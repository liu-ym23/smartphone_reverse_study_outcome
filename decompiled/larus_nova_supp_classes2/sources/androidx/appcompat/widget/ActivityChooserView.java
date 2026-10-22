package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.view.ActionProvider;
import androidx.core.view.ViewCompat;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class ActivityChooserView extends ViewGroup implements ActivityChooserModel.ActivityChooserModelClient {
    private final View mActivityChooserContent;
    private final Drawable mActivityChooserContentBackground;
    final ActivityChooserViewAdapter mAdapter;
    private final Callbacks mCallbacks;
    private int mDefaultActionButtonContentDescription;
    final FrameLayout mDefaultActivityButton;
    private final ImageView mDefaultActivityButtonImage;
    final FrameLayout mExpandActivityOverflowButton;
    private final ImageView mExpandActivityOverflowButtonImage;
    int mInitialActivityCount;
    private boolean mIsAttachedToWindow;
    boolean mIsSelectingDefaultActivity;
    private final int mListPopupMaxWidth;
    private ListPopupWindow mListPopupWindow;
    final DataSetObserver mModelDataSetObserver;
    PopupWindow.OnDismissListener mOnDismissListener;
    private final ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener;
    ActionProvider mProvider;

    public class ActivityChooserViewAdapter extends BaseAdapter {
        private static final int ITEM_VIEW_TYPE_ACTIVITY = 0;
        private static final int ITEM_VIEW_TYPE_COUNT = 3;
        private static final int ITEM_VIEW_TYPE_FOOTER = 1;
        public static final int MAX_ACTIVITY_COUNT_DEFAULT = 4;
        public static final int MAX_ACTIVITY_COUNT_UNLIMITED = Integer.MAX_VALUE;
        private ActivityChooserModel mDataModel;
        private boolean mHighlightDefaultActivity;
        private int mMaxActivityCount;
        private boolean mShowDefaultActivity;
        private boolean mShowFooterView;
        final /* synthetic */ ActivityChooserView this$0;

        @Override // android.widget.Adapter
        public long getItemId(int r3) {
            return r3;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return 3;
        }

        public int getActivityCount() {
            return this.mDataModel.getActivityCount();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int r0 = this.mDataModel.getActivityCount();
            if (this.mShowDefaultActivity == false) goto L5;
        L7:
            int r1 = Math.min(r0, this.mMaxActivityCount);
            if (this.mShowFooterView == true) goto L10;
            return r1;
        L10:
            return r1 + 1;
        L5:
            if (this.mDataModel.getDefaultActivity() == null) goto L7;
            r0 = r0 - 1;
            goto L7
        }

        public ResolveInfo getDefaultActivity() {
            return this.mDataModel.getDefaultActivity();
        }

        public int getHistorySize() {
            return this.mDataModel.getHistorySize();
        }

        public int measureContentWidth() {
            int r0 = this.mMaxActivityCount;
            this.mMaxActivityCount = Integer.MAX_VALUE;
            int r1 = 0;
            int r2 = View.MeasureSpec.makeMeasureSpec(0, 0);
            int r3 = View.MeasureSpec.makeMeasureSpec(0, 0);
            int r4 = getCount();
            View r7 = null;
            int r6 = 0;
        L3:
            if (r1 >= r4) goto L5;
            r7 = getView(r1, r7, null);
            r7.measure(r2, r3);
            r6 = Math.max(r6, r7.getMeasuredWidth());
            r1 = r1 + 1;
            goto L3
        L5:
            this.mMaxActivityCount = r0;
            return r6;
        }

        public ActivityChooserModel getDataModel() {
            return this.mDataModel;
        }

        public boolean getShowDefaultActivity() {
            return this.mShowDefaultActivity;
        }

        public ActivityChooserViewAdapter(ActivityChooserView r1) {
            this.this$0 = r1;
            this.mMaxActivityCount = 4;
        }

        @Override // android.widget.Adapter
        public Object getItem(int r2) {
            int r0 = getItemViewType(r2);
            if (r0 == 0) goto L11;
            if (r0 != 1) goto L9;
            return null;
        L9:
            throw new IllegalArgumentException();
        L11:
            if (this.mShowDefaultActivity == true) goto L16;
            if (this.mDataModel.getDefaultActivity() == null) goto L16;
            r2 = r2 + 1;
        L16:
            return this.mDataModel.getActivity(r2);
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int r3) {
            if (this.mShowFooterView == true) goto L5;
            return 0;
        L5:
            if (r3 != (getCount() - 1)) goto L9;
            return 1;
        L9:
            return 0;
        }

        public void setDataModel(ActivityChooserModel r3) {
            ActivityChooserModel r0 = this.this$0.mAdapter.getDataModel();
            if (r0 != null) goto L5;
        L7:
            this.mDataModel = r3;
            if (r3 != null) goto L10;
        L12:
            notifyDataSetChanged();
            return;
        L10:
            if (this.this$0.isShown() == false) goto L12;
            r3.registerObserver(this.this$0.mModelDataSetObserver);
            goto L12
        L5:
            if (this.this$0.isShown() == false) goto L7;
            r0.unregisterObserver(this.this$0.mModelDataSetObserver);
            goto L7
        }

        public void setMaxActivityCount(int r2) {
            if (this.mMaxActivityCount == r2) goto L6;
            this.mMaxActivityCount = r2;
            notifyDataSetChanged();
            return;
        }

        public void setShowFooterView(boolean r2) {
            if (this.mShowFooterView == r2) goto L6;
            this.mShowFooterView = r2;
            notifyDataSetChanged();
            return;
        }

        public void setShowDefaultActivity(boolean r2, boolean r3) {
            if (this.mShowDefaultActivity == r2) goto L5;
        L6:
            this.mShowDefaultActivity = r2;
            this.mHighlightDefaultActivity = r3;
            notifyDataSetChanged();
            return;
        L5:
            if (this.mHighlightDefaultActivity != r3) goto L6;
        }

        @Override // android.widget.Adapter
        public View getView(int r7, View r8, ViewGroup r9) {
            int r0 = getItemViewType(r7);
            if (r0 == 0) goto L12;
            if (r0 != 1) goto L11;
            if (r8 != null) goto L7;
        L8:
            View r10 = LayoutInflater.from(this.this$0.getContext()).inflate(2131558413, r9, false);
            r10.setId(1);
            ((TextView) r10.findViewById(2131388772)).setText(this.this$0.getContext().getString(2131894043));
            return r10;
        L7:
            if (r8.getId() != 1) goto L8;
            return r8;
        L11:
            throw new IllegalArgumentException();
        L12:
            if (r8 != null) goto L14;
        L15:
            r8 = LayoutInflater.from(this.this$0.getContext()).inflate(2131558413, r9, false);
        L16:
            PackageManager r11 = this.this$0.getContext().getPackageManager();
            ImageView r1 = (ImageView) r8.findViewById(2131374718);
            ResolveInfo r2 = (ResolveInfo) getItem(r7);
            r1.setImageDrawable(r2.loadIcon(r11));
            ((TextView) r8.findViewById(2131388772)).setText(r2.loadLabel(r11));
            if (this.mShowDefaultActivity == false) goto L22;
            if (r7 != 0) goto L22;
            if (this.mHighlightDefaultActivity == false) goto L22;
            r8.setActivated(true);
        L23:
            return r8;
        L22:
            r8.setActivated(false);
            goto L23
        L14:
            if (r8.getId() == 2131378129) goto L16;
            goto L15
        }
    }

    public class Callbacks implements AdapterView.OnItemClickListener, View.OnClickListener, View.OnLongClickListener, PopupWindow.OnDismissListener {
        final /* synthetic */ ActivityChooserView this$0;

        private void notifyOnDismissListener() {
            PopupWindow.OnDismissListener r0 = this.this$0.mOnDismissListener;
            if (r0 == null) goto L6;
            r0.onDismiss();
            return;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            notifyOnDismissListener();
            ActionProvider r0 = this.this$0.mProvider;
            if (r0 == null) goto L6;
            r0.subUiVisibilityChanged(false);
            return;
        }

        public Callbacks(ActivityChooserView r1) {
            this.this$0 = r1;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r3) {
            ActivityChooserView r0 = this.this$0;
            if (r3 != r0.mDefaultActivityButton) goto L8;
            r0.dismissPopup();
            ResolveInfo r4 = this.this$0.mAdapter.getDefaultActivity();
            int r5 = this.this$0.mAdapter.getDataModel().getActivityIndex(r4);
            Intent r6 = this.this$0.mAdapter.getDataModel().chooseActivity(r5);
            if (r6 == null) goto L13;
            r6.addFlags(524288);
            this.this$0.getContext().startActivity(r6);
            return;
        L13:
            return;
        L8:
            if (r3 != r0.mExpandActivityOverflowButton) goto L12;
            r0.mIsSelectingDefaultActivity = false;
            r0.showPopupUnchecked(r0.mInitialActivityCount);
            return;
        L12:
            throw new IllegalArgumentException();
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View r3) {
            ActivityChooserView r0 = this.this$0;
            if (r3 != r0.mDefaultActivityButton) goto L9;
            if (r0.mAdapter.getCount() <= 0) goto L7;
            ActivityChooserView r4 = this.this$0;
            r4.mIsSelectingDefaultActivity = true;
            r4.showPopupUnchecked(r4.mInitialActivityCount);
        L7:
            return true;
        L9:
            throw new IllegalArgumentException();
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> r1, View r2, int r3, long r4) {
            int r5 = ((ActivityChooserViewAdapter) r1.getAdapter()).getItemViewType(r3);
            if (r5 != 0) goto L5;
            this.this$0.dismissPopup();
            ActivityChooserView r6 = this.this$0;
            if (r6.mIsSelectingDefaultActivity == false) goto L14;
            if (r3 <= 0) goto L22;
            r6.mAdapter.getDataModel().setDefaultActivity(r3);
            return;
        L22:
            return;
        L14:
            if (r6.mAdapter.getShowDefaultActivity() == true) goto L17;
            r3 = r3 + 1;
        L17:
            Intent r7 = this.this$0.mAdapter.getDataModel().chooseActivity(r3);
            if (r7 == null) goto L24;
            r7.addFlags(524288);
            this.this$0.getContext().startActivity(r7);
            return;
        L24:
            return;
        L5:
            if (r5 != 1) goto L8;
            this.this$0.showPopupUnchecked(Integer.MAX_VALUE);
            return;
        L8:
            throw new IllegalArgumentException();
        }
    }

    public static class InnerLayout extends LinearLayout {
        private static final int[] TINT_ATTRS = null;

        static {
            TINT_ATTRS = new int[]{R.attr.background};
        }

        public InnerLayout(Context r2, AttributeSet r3) {
            super(r2, r3);
            TintTypedArray r4 = TintTypedArray.obtainStyledAttributes(r2, r3, TINT_ATTRS);
            setBackgroundDrawable(r4.getDrawable(0));
            r4.recycle();
        }
    }

    public ActivityChooserModel getDataModel() {
        return this.mAdapter.getDataModel();
    }

    public ListPopupWindow getListPopupWindow() {
        if (this.mListPopupWindow != null) goto L6;
        ListPopupWindow r0 = new ListPopupWindow(getContext());
        this.mListPopupWindow = r0;
        r0.setAdapter(this.mAdapter);
        this.mListPopupWindow.setAnchorView(this);
        this.mListPopupWindow.setModal(true);
        this.mListPopupWindow.setOnItemClickListener(this.mCallbacks);
        this.mListPopupWindow.setOnDismissListener(this.mCallbacks);
    L6:
        return this.mListPopupWindow;
    }

    public void updateAppearance() {
        if (this.mAdapter.getCount() <= 0) goto L5;
        this.mExpandActivityOverflowButton.setEnabled(true);
    L6:
        int r0 = this.mAdapter.getActivityCount();
        int r3 = this.mAdapter.getHistorySize();
        if (r0 == 1) goto L12;
        if (r0 <= 1) goto L11;
        if (r3 > 0) goto L12;
    L11:
        this.mDefaultActivityButton.setVisibility(8);
    L16:
        if (this.mDefaultActivityButton.getVisibility() != 0) goto L18;
        this.mActivityChooserContent.setBackgroundDrawable(this.mActivityChooserContentBackground);
        return;
    L18:
        this.mActivityChooserContent.setBackgroundDrawable(null);
        return;
    L12:
        this.mDefaultActivityButton.setVisibility(0);
        ResolveInfo r1 = this.mAdapter.getDefaultActivity();
        PackageManager r4 = getContext().getPackageManager();
        this.mDefaultActivityButtonImage.setImageDrawable(r1.loadIcon(r4));
        if (this.mDefaultActionButtonContentDescription == 0) goto L16;
        CharSequence r2 = r1.loadLabel(r4);
        this.mDefaultActivityButton.setContentDescription(getContext().getString(this.mDefaultActionButtonContentDescription, new Object[]{r2}));
        goto L16
    L5:
        this.mExpandActivityOverflowButton.setEnabled(false);
        goto L6
    }

    public boolean dismissPopup() {
        if (isShowingPopup() == false) goto L9;
        getListPopupWindow().dismiss();
        ViewTreeObserver r0 = getViewTreeObserver();
        if (r0.isAlive() == false) goto L10;
        r0.removeGlobalOnLayoutListener(this.mOnGlobalLayoutListener);
        return true;
    L10:
        return true;
    L9:
        return true;
    }

    public boolean isShowingPopup() {
        return getListPopupWindow().isShowing();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ActivityChooserModel r0 = this.mAdapter.getDataModel();
        if (r0 == null) goto L5;
        r0.registerObserver(this.mModelDataSetObserver);
    L5:
        this.mIsAttachedToWindow = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActivityChooserModel r0 = this.mAdapter.getDataModel();
        if (r0 == null) goto L5;
        r0.unregisterObserver(this.mModelDataSetObserver);
    L5:
        ViewTreeObserver r1 = getViewTreeObserver();
        if (r1.isAlive() == false) goto L9;
        r1.removeGlobalOnLayoutListener(this.mOnGlobalLayoutListener);
    L9:
        if (isShowingPopup() == false) goto L11;
        dismissPopup();
    L11:
        this.mIsAttachedToWindow = false;
    }

    public boolean showPopup() {
        if (isShowingPopup() == false) goto L5;
    L9:
        return false;
    L5:
        if (this.mIsAttachedToWindow == false) goto L9;
        this.mIsSelectingDefaultActivity = false;
        showPopupUnchecked(this.mInitialActivityCount);
        return true;
    }

    public ActivityChooserView(Context r2) {
        this(r2, null);
    }

    public static DisplayMetrics INVOKEVIRTUAL_androidx_appcompat_widget_ActivityChooserView_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    @Override // androidx.appcompat.widget.ActivityChooserModel.ActivityChooserModelClient
    public void setActivityChooserModel(ActivityChooserModel r2) {
        this.mAdapter.setDataModel(r2);
        if (isShowingPopup() == false) goto L6;
        dismissPopup();
        showPopup();
        return;
    }

    public void setDefaultActionButtonContentDescription(int r1) {
        this.mDefaultActionButtonContentDescription = r1;
    }

    public void setExpandActivityOverflowButtonContentDescription(int r2) {
        String r3 = getContext().getString(r2);
        this.mExpandActivityOverflowButtonImage.setContentDescription(r3);
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable r2) {
        this.mExpandActivityOverflowButtonImage.setImageDrawable(r2);
    }

    public void setInitialActivityCount(int r1) {
        this.mInitialActivityCount = r1;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener r1) {
        this.mOnDismissListener = r1;
    }

    public void setProvider(ActionProvider r1) {
        this.mProvider = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7, types: [boolean, int] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void showPopupUnchecked(int r6) {
        if (this.mAdapter.getDataModel() == null) goto L28;
        getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        if (this.mDefaultActivityButton.getVisibility() != 0) goto L7;
        ?? r0 = 1;
    L8:
        int r3 = this.mAdapter.getActivityCount();
        if (r6 != Integer.MAX_VALUE) goto L11;
    L13:
        this.mAdapter.setShowFooterView(false);
        this.mAdapter.setMaxActivityCount(r6);
    L14:
        ListPopupWindow r7 = getListPopupWindow();
        if (r7.isShowing() == false) goto L17;
        return;
    L17:
        if (this.mIsSelectingDefaultActivity == true) goto L21;
        if (r0 == 0) goto L21;
        this.mAdapter.setShowDefaultActivity(false, false);
    L22:
        r7.setContentWidth(Math.min(this.mAdapter.measureContentWidth(), this.mListPopupMaxWidth));
        r7.show();
        ActionProvider r1 = this.mProvider;
        if (r1 == null) goto L25;
        r1.subUiVisibilityChanged(true);
    L25:
        r7.getListView().setContentDescription(getContext().getString(2131894044));
        r7.getListView().setSelector(new ColorDrawable(0));
        return;
    L21:
        this.mAdapter.setShowDefaultActivity(true, r0);
        goto L22
    L11:
        if (r3 <= (r6 + r0)) goto L13;
        this.mAdapter.setShowFooterView(true);
        this.mAdapter.setMaxActivityCount(r6 - 1);
        goto L14
    L7:
        r0 = 0;
        goto L8
    L28:
        throw new IllegalStateException("No data model. Did you call #setDataModel?");
    }

    public ActivityChooserView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    @Override // android.view.View
    public void onMeasure(int r3, int r4) {
        View r0 = this.mActivityChooserContent;
        if (this.mDefaultActivityButton.getVisibility() == 0) goto L5;
        r4 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(r4), 1073741824);
    L5:
        measureChild(r0, r3, r4);
        setMeasuredDimension(r0.getMeasuredWidth(), r0.getMeasuredHeight());
    }

    public ActivityChooserView(Context r12, AttributeSet r13, int r14) {
        super(r12, r13, r14);
        this.mModelDataSetObserver = new AnonymousClass1(this);
        this.mOnGlobalLayoutListener = new AnonymousClass2(this);
        this.mInitialActivityCount = 4;
        TypedArray r2 = r12.obtainStyledAttributes(r13, new int[]{2130969990, 2130970352}, r14, 0);
        ViewCompat.saveAttributeDataForStyleable(this, r12, new int[]{2130969990, 2130970352}, r13, r2, r14, 0);
        this.mInitialActivityCount = r2.getInt(1, 4);
        Drawable r15 = r2.getDrawable(0);
        r2.recycle();
        LayoutInflater.from(getContext()).inflate(2131558412, this, true);
        Callbacks r16 = new Callbacks(this);
        this.mCallbacks = r16;
        View r0 = findViewById(2131362162);
        this.mActivityChooserContent = r0;
        this.mActivityChooserContentBackground = r0.getBackground();
        FrameLayout r1 = (FrameLayout) findViewById(2131368742);
        this.mDefaultActivityButton = r1;
        r1.setOnClickListener(r16);
        r1.setOnLongClickListener(r16);
        this.mDefaultActivityButtonImage = (ImageView) r1.findViewById(2131374931);
        final FrameLayout r3 = (FrameLayout) findViewById(2131371872);
        r3.setOnClickListener(r16);
        r3.setAccessibilityDelegate(new AnonymousClass3(this));
        r3.setOnTouchListener(new AnonymousClass4(this, r3));
        this.mExpandActivityOverflowButton = r3;
        ImageView r17 = (ImageView) r3.findViewById(2131374931);
        this.mExpandActivityOverflowButtonImage = r17;
        r17.setImageDrawable(r15);
        ActivityChooserViewAdapter r18 = new ActivityChooserViewAdapter(this);
        this.mAdapter = r18;
        r18.registerDataSetObserver(new AnonymousClass5(this));
        Resources r19 = r12.getResources();
        this.mListPopupMaxWidth = Math.max(INVOKEVIRTUAL_androidx_appcompat_widget_ActivityChooserView_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r19).widthPixels / 2, r19.getDimensionPixelSize(2131165211));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        this.mActivityChooserContent.layout(0, 0, r4 - r2, r5 - r3);
        if (isShowingPopup() == true) goto L6;
        dismissPopup();
        return;
    }
}
