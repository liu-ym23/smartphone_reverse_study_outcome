package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.view.TintableBackgroundView;
import androidx.core.view.ViewCompat;
import com.bytedance.crash.d;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class AppCompatSpinner extends Spinner implements TintableBackgroundView {
    private static final int[] ATTRS_ANDROID_SPINNERMODE = null;
    private static final int MAX_ITEMS_MEASURED = 15;
    private static final int MODE_DIALOG = 0;
    private static final int MODE_DROPDOWN = 1;
    private static final int MODE_THEME = -1;
    private static final String TAG = "AppCompatSpinner";
    private final AppCompatBackgroundHelper mBackgroundTintHelper;
    int mDropDownWidth;
    private ForwardingListener mForwardingListener;
    private SpinnerPopup mPopup;
    private final Context mPopupContext;
    private final boolean mPopupSet;
    private SpinnerAdapter mTempAdapter;
    final Rect mTempRect;

    public class DialogPopup implements SpinnerPopup, DialogInterface.OnClickListener {
        private ListAdapter mListAdapter;
        AlertDialog mPopup;
        private CharSequence mPrompt;
        final /* synthetic */ AppCompatSpinner this$0;

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public Drawable getBackground() {
            return null;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public int getHorizontalOffset() {
            return 0;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public int getHorizontalOriginalOffset() {
            return 0;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public int getVerticalOffset() {
            return 0;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void setBackgroundDrawable(Drawable r1) {
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void setHorizontalOffset(int r1) {
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void setHorizontalOriginalOffset(int r1) {
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void setVerticalOffset(int r1) {
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void dismiss() {
            AlertDialog r0 = this.mPopup;
            if (r0 == null) goto L6;
            INVOKEVIRTUAL_androidx_appcompat_widget_AppCompatSpinner$DialogPopup_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(r0);
            this.mPopup = null;
            return;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public boolean isShowing() {
            AlertDialog r0 = this.mPopup;
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.isShowing();
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public CharSequence getHintText() {
            return this.mPrompt;
        }

        public DialogPopup(AppCompatSpinner r1) {
            this.this$0 = r1;
        }

        public static void INVOKEVIRTUAL_androidx_appcompat_widget_AppCompatSpinner$DialogPopup_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(AlertDialog r3) {
            Handler r0 = DialogLancet.resolveDialogHandler(r3);
            if (r0 != null) goto L5;
        L8:
            DialogLancet.beforeDialogDismiss(r3);
            r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
        L10:
            DialogLancet.afterDialogDismiss(r3);
            return;
        L11:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r3);
            throw th;
        L13:
            e = move-exception;
            d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
            if (r1 == null) goto L10;
            d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
            goto L10
        L5:
            if (Looper.myLooper() == r0.getLooper()) goto L8;
            r0.post(DialogLancet.createDismissRunnable(r3));
        }

        public static void INVOKEVIRTUAL_androidx_appcompat_widget_AppCompatSpinner$DialogPopup_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(AlertDialog r1) {
            if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L10;
            DialogLancet.handleBlockedDialogShow(r1);
            return;
        L10:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
        L7:
            DialogLancet.beforeDialogShow(r1);
            r1.show();
            DialogLancet.afterDialogShow(r1);
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void setAdapter(ListAdapter r1) {
            this.mListAdapter = r1;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void setPromptText(CharSequence r1) {
            this.mPrompt = r1;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface r4, int r5) {
            this.this$0.setSelection(r5);
            if (this.this$0.getOnItemClickListener() == null) goto L5;
            this.this$0.performItemClick(null, r5, this.mListAdapter.getItemId(r5));
        L5:
            dismiss();
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void show(int r4, int r5) {
            if (this.mListAdapter != null) goto L5;
            return;
        L5:
            AlertDialog.Builder r0 = new AlertDialog.Builder(this.this$0.getPopupContext());
            CharSequence r1 = this.mPrompt;
            if (r1 == null) goto L8;
            r0.setTitle(r1);
        L8:
            AlertDialog r2 = r0.setSingleChoiceItems(this.mListAdapter, this.this$0.getSelectedItemPosition(), this).create();
            this.mPopup = r2;
            ListView r3 = r2.getListView();
            r3.setTextDirection(r4);
            r3.setTextAlignment(r5);
            INVOKEVIRTUAL_androidx_appcompat_widget_AppCompatSpinner$DialogPopup_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(this.mPopup);
        }
    }

    public static class DropDownAdapter implements ListAdapter, SpinnerAdapter {
        private SpinnerAdapter mAdapter;
        private ListAdapter mListAdapter;

        @Override // android.widget.Adapter
        public int getItemViewType(int r1) {
            return 0;
        }

        @Override // android.widget.Adapter
        public int getViewTypeCount() {
            return 1;
        }

        @Override // android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            ListAdapter r0 = this.mListAdapter;
            if (r0 != null) goto L5;
            return true;
        L5:
            return r0.areAllItemsEnabled();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            SpinnerAdapter r0 = this.mAdapter;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.getCount();
        }

        @Override // android.widget.Adapter
        public boolean hasStableIds() {
            SpinnerAdapter r0 = this.mAdapter;
            if (r0 != null) goto L5;
        L7:
            return false;
        L5:
            if (r0.hasStableIds() == false) goto L7;
            return true;
        }

        @Override // android.widget.Adapter
        public boolean isEmpty() {
            if (getCount() != 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // android.widget.Adapter
        public Object getItem(int r2) {
            SpinnerAdapter r0 = this.mAdapter;
            if (r0 != null) goto L6;
            return null;
        L6:
            return r0.getItem(r2);
        }

        @Override // android.widget.Adapter
        public long getItemId(int r3) {
            SpinnerAdapter r0 = this.mAdapter;
            if (r0 != null) goto L6;
            return -1;
        L6:
            return r0.getItemId(r3);
        }

        @Override // android.widget.ListAdapter
        public boolean isEnabled(int r2) {
            ListAdapter r0 = this.mListAdapter;
            if (r0 != null) goto L5;
            return true;
        L5:
            return r0.isEnabled(r2);
        }

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver r2) {
            SpinnerAdapter r0 = this.mAdapter;
            if (r0 == null) goto L6;
            r0.registerDataSetObserver(r2);
            return;
        }

        @Override // android.widget.Adapter
        public void unregisterDataSetObserver(DataSetObserver r2) {
            SpinnerAdapter r0 = this.mAdapter;
            if (r0 == null) goto L6;
            r0.unregisterDataSetObserver(r2);
            return;
        }

        public DropDownAdapter(SpinnerAdapter r3, Resources.Theme r4) {
            this.mAdapter = r3;
            if ((r3 instanceof ListAdapter) == false) goto L5;
            this.mListAdapter = (ListAdapter) r3;
        L5:
            if (r4 != null) goto L7;
            return;
        L7:
            if (Build.VERSION.SDK_INT < 23) goto L14;
            if ((r3 instanceof android.widget.ThemedSpinnerAdapter) == false) goto L14;
            android.widget.ThemedSpinnerAdapter r5 = (android.widget.ThemedSpinnerAdapter) r3;
            if (r5.getDropDownViewTheme() == r4) goto L20;
            r5.setDropDownViewTheme(r4);
            return;
        L20:
            return;
        L14:
            if ((r3 instanceof ThemedSpinnerAdapter) == false) goto L22;
            ThemedSpinnerAdapter r6 = (ThemedSpinnerAdapter) r3;
            if (r6.getDropDownViewTheme() != null) goto L23;
            r6.setDropDownViewTheme(r4);
            return;
        L23:
            return;
        }

        @Override // android.widget.SpinnerAdapter
        public View getDropDownView(int r2, View r3, ViewGroup r4) {
            SpinnerAdapter r0 = this.mAdapter;
            if (r0 != null) goto L6;
            return null;
        L6:
            return r0.getDropDownView(r2, r3, r4);
        }

        @Override // android.widget.Adapter
        public View getView(int r1, View r2, ViewGroup r3) {
            return getDropDownView(r1, r2, r3);
        }
    }

    public class DropdownPopup extends ListPopupWindow implements SpinnerPopup {
        ListAdapter mAdapter;
        private CharSequence mHintText;
        private int mOriginalHorizontalOffset;
        private final Rect mVisibleRect;
        final /* synthetic */ AppCompatSpinner this$0;

        public void computeContentWidth() {
            Drawable r0 = getBackground();
            if (r0 == null) goto L8;
            r0.getPadding(this.this$0.mTempRect);
            if (ViewUtils.isLayoutRtl(this.this$0) == false) goto L7;
            int r1 = this.this$0.mTempRect.right;
        L9:
            int r2 = this.this$0.getPaddingLeft();
            int r3 = this.this$0.getPaddingRight();
            int r4 = this.this$0.getWidth();
            AppCompatSpinner r5 = this.this$0;
            int r6 = r5.mDropDownWidth;
            if (r6 != (-2)) goto L16;
            int r7 = r5.compatMeasureContentWidth((SpinnerAdapter) this.mAdapter, getBackground());
            int r8 = INVOKEVIRTUAL_androidx_appcompat_widget_AppCompatSpinner$DropdownPopup_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(this.this$0.getContext().getResources()).widthPixels;
            Rect r9 = this.this$0.mTempRect;
            int r10 = (r8 - r9.left) - r9.right;
            if (r7 <= r10) goto L14;
            r7 = r10;
        L14:
            setContentWidth(Math.max(r7, (r4 - r2) - r3));
        L20:
            if (ViewUtils.isLayoutRtl(this.this$0) == false) goto L22;
            int r11 = r1 + (((r4 - r3) - getWidth()) - getHorizontalOriginalOffset());
        L23:
            setHorizontalOffset(r11);
            return;
        L22:
            r11 = r1 + (r2 + getHorizontalOriginalOffset());
            goto L23
        L16:
            if (r6 != (-1)) goto L18;
            setContentWidth((r4 - r2) - r3);
            goto L20
        L18:
            setContentWidth(r6);
            goto L20
        L7:
            r1 = -this.this$0.mTempRect.left;
            goto L9
        L8:
            Rect r12 = this.this$0.mTempRect;
            r12.right = 0;
            r12.left = 0;
            r1 = 0;
            goto L9
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public CharSequence getHintText() {
            return this.mHintText;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public int getHorizontalOriginalOffset() {
            return this.mOriginalHorizontalOffset;
        }

        public static DisplayMetrics INVOKEVIRTUAL_androidx_appcompat_widget_AppCompatSpinner$DropdownPopup_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r1) {
            return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
        }

        public static /* synthetic */ void access$001(DropdownPopup r0) {
            super.show();
        }

        public boolean isVisibleToUser(View r2) {
            if (ViewCompat.isAttachedToWindow(r2) == true) goto L5;
        L7:
            return false;
        L5:
            if (r2.getGlobalVisibleRect(this.mVisibleRect) == false) goto L7;
            return true;
        }

        @Override // androidx.appcompat.widget.ListPopupWindow, androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void setAdapter(ListAdapter r1) {
            super.setAdapter(r1);
            this.mAdapter = r1;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void setHorizontalOriginalOffset(int r1) {
            this.mOriginalHorizontalOffset = r1;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void setPromptText(CharSequence r1) {
            this.mHintText = r1;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void show(int r4, int r5) {
            boolean r0 = isShowing();
            computeContentWidth();
            setInputMethodMode(2);
            super.show();
            ListView r1 = getListView();
            r1.setChoiceMode(1);
            r1.setTextDirection(r4);
            r1.setTextAlignment(r5);
            setSelection(this.this$0.getSelectedItemPosition());
            if (r0 == false) goto L5;
            return;
        L5:
            ViewTreeObserver r6 = this.this$0.getViewTreeObserver();
            if (r6 == null) goto L9;
            final ViewTreeObserver.OnGlobalLayoutListener r7 = new AnonymousClass2(this);
            r6.addOnGlobalLayoutListener(r7);
            setOnDismissListener(new AnonymousClass3(this, r7));
            return;
        }

        public DropdownPopup(final AppCompatSpinner r1, Context r2, AttributeSet r3, int r4) {
            this.this$0 = r1;
            super(r2, r3, r4);
            this.mVisibleRect = new Rect();
            setAnchorView(r1);
            setModal(true);
            setPromptPosition(0);
            setOnItemClickListener(new AnonymousClass1(this, r1));
        }
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        boolean mShowDropdown;

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState(Parcel r1) {
            super(r1);
            if (r1.readByte() == 0) goto L5;
            boolean r2 = true;
        L6:
            this.mShowDropdown = r2;
            return;
        L5:
            r2 = false;
            goto L6
        }

        public SavedState(Parcelable r1) {
            super(r1);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            super.writeToParcel(r1, r2);
            r1.writeByte(this.mShowDropdown ? 1 : 0);
        }
    }

    public interface SpinnerPopup {
        void dismiss();

        Drawable getBackground();

        CharSequence getHintText();

        int getHorizontalOffset();

        int getHorizontalOriginalOffset();

        int getVerticalOffset();

        boolean isShowing();

        void setAdapter(ListAdapter r1);

        void setBackgroundDrawable(Drawable r1);

        void setHorizontalOffset(int r1);

        void setHorizontalOriginalOffset(int r1);

        void setPromptText(CharSequence r1);

        void setVerticalOffset(int r1);

        void show(int r1, int r2);
    }

    static {
        ATTRS_ANDROID_SPINNERMODE = new int[]{R.attr.spinnerMode};
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        SpinnerPopup r0 = this.mPopup;
        if (r0 == null) goto L7;
        return r0.getHorizontalOffset();
    L7:
        return super.getDropDownHorizontalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        SpinnerPopup r0 = this.mPopup;
        if (r0 == null) goto L7;
        return r0.getVerticalOffset();
    L7:
        return super.getDropDownVerticalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        if (this.mPopup == null) goto L7;
        return this.mDropDownWidth;
    L7:
        return super.getDropDownWidth();
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        SpinnerPopup r0 = this.mPopup;
        if (r0 == null) goto L7;
        return r0.getBackground();
    L7:
        return super.getPopupBackground();
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        SpinnerPopup r0 = this.mPopup;
        if (r0 == null) goto L6;
        return r0.getHintText();
    L6:
        return super.getPrompt();
    }

    public ColorStateList getSupportBackgroundTintList() {
        AppCompatBackgroundHelper r0 = this.mBackgroundTintHelper;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getSupportBackgroundTintList();
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        AppCompatBackgroundHelper r0 = this.mBackgroundTintHelper;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getSupportBackgroundTintMode();
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r0 = new SavedState(super.onSaveInstanceState());
        SpinnerPopup r1 = this.mPopup;
        if (r1 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        r0.mShowDropdown = r2;
        return r0;
    L5:
        if (r1.isShowing() == false) goto L7;
        r2 = true;
        goto L8
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean performClick() {
        SpinnerPopup r0 = this.mPopup;
        if (r0 == null) goto L10;
        if (r0.isShowing() == true) goto L11;
        showPopup();
        return true;
    L11:
        return true;
    L10:
        return super.performClick();
    }

    public void showPopup() {
        this.mPopup.show(getTextDirection(), getTextAlignment());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatBackgroundHelper r0 = this.mBackgroundTintHelper;
        if (r0 == null) goto L6;
        r0.applySupportBackgroundTint();
        return;
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SpinnerPopup r0 = this.mPopup;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isShowing() == false) goto L9;
        this.mPopup.dismiss();
        return;
    }

    public final SpinnerPopup getInternalPopup() {
        return this.mPopup;
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        return this.mPopupContext;
    }

    public AppCompatSpinner(Context r2) {
        this(r2, null);
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public void onRestoreInstanceState(Parcelable r2) {
        SavedState r3 = (SavedState) r2;
        super.onRestoreInstanceState(r3.getSuperState());
        if (r3.mShowDropdown == false) goto L8;
        ViewTreeObserver r4 = getViewTreeObserver();
        if (r4 == null) goto L9;
        r4.addOnGlobalLayoutListener(new AnonymousClass2(this));
        return;
    L9:
        return;
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean onTouchEvent(MotionEvent r2) {
        ForwardingListener r0 = this.mForwardingListener;
        if (r0 == null) goto L9;
        if (r0.onTouch(this, r2) == false) goto L9;
        return true;
    L9:
        return super.onTouchEvent(r2);
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner
    public void setAdapter(SpinnerAdapter r4) {
        if (this.mPopupSet == true) goto L6;
        this.mTempAdapter = r4;
        return;
    L6:
        super.setAdapter(r4);
        if (this.mPopup == null) goto L13;
        Context r0 = this.mPopupContext;
        if (r0 != null) goto L11;
        r0 = getContext();
    L11:
        this.mPopup.setAdapter(new DropDownAdapter(r4, r0.getTheme()));
        return;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable r2) {
        super.setBackgroundDrawable(r2);
        AppCompatBackgroundHelper r0 = this.mBackgroundTintHelper;
        if (r0 == null) goto L6;
        r0.onSetBackgroundDrawable(r2);
        return;
    }

    @Override // android.view.View
    public void setBackgroundResource(int r2) {
        super.setBackgroundResource(r2);
        AppCompatBackgroundHelper r0 = this.mBackgroundTintHelper;
        if (r0 == null) goto L6;
        r0.onSetBackgroundResource(r2);
        return;
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int r2) {
        SpinnerPopup r0 = this.mPopup;
        if (r0 == null) goto L5;
        r0.setHorizontalOriginalOffset(r2);
        this.mPopup.setHorizontalOffset(r2);
        return;
    L5:
        super.setDropDownHorizontalOffset(r2);
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int r2) {
        SpinnerPopup r0 = this.mPopup;
        if (r0 == null) goto L5;
        r0.setVerticalOffset(r2);
        return;
    L5:
        super.setDropDownVerticalOffset(r2);
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int r2) {
        if (this.mPopup == null) goto L5;
        this.mDropDownWidth = r2;
        return;
    L5:
        super.setDropDownWidth(r2);
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable r2) {
        SpinnerPopup r0 = this.mPopup;
        if (r0 == null) goto L5;
        r0.setBackgroundDrawable(r2);
        return;
    L5:
        super.setPopupBackgroundDrawable(r2);
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(int r2) {
        setPopupBackgroundDrawable(AppCompatResources.getDrawable(getPopupContext(), r2));
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence r2) {
        SpinnerPopup r0 = this.mPopup;
        if (r0 == null) goto L5;
        r0.setPromptText(r2);
        return;
    L5:
        super.setPrompt(r2);
    }

    public void setSupportBackgroundTintList(ColorStateList r2) {
        AppCompatBackgroundHelper r0 = this.mBackgroundTintHelper;
        if (r0 == null) goto L6;
        r0.setSupportBackgroundTintList(r2);
        return;
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode r2) {
        AppCompatBackgroundHelper r0 = this.mBackgroundTintHelper;
        if (r0 == null) goto L6;
        r0.setSupportBackgroundTintMode(r2);
        return;
    }

    @Override // android.widget.AdapterView
    public /* bridge */ /* synthetic */ void setAdapter(Adapter r1) {
        setAdapter((SpinnerAdapter) r1);
    }

    public AppCompatSpinner(Context r3, int r4) {
        this(r3, null, 2130974126, r4);
    }

    public int compatMeasureContentWidth(SpinnerAdapter r11, Drawable r12) {
        int r0 = 0;
        if (r11 != null) goto L5;
        return 0;
    L5:
        int r1 = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int r2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int r3 = Math.max(0, getSelectedItemPosition());
        int r4 = Math.min(r11.getCount(), r3 + 15);
        int r6 = Math.max(0, r3 - (15 - (r4 - r3)));
        View r7 = null;
        int r5 = 0;
    L6:
        if (r6 >= r4) goto L14;
        int r8 = r11.getItemViewType(r6);
        if (r8 == r0) goto L10;
        r7 = null;
        r0 = r8;
    L10:
        r7 = r11.getView(r6, r7, this);
        if (r7.getLayoutParams() != null) goto L13;
        r7.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    L13:
        r7.measure(r1, r2);
        r5 = Math.max(r5, r7.getMeasuredWidth());
        r6 = r6 + 1;
        goto L6
    L14:
        if (r12 == null) goto L20;
        r12.getPadding(this.mTempRect);
        Rect r13 = this.mTempRect;
        return r5 + (r13.left + r13.right);
    L20:
        return r5;
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public void onMeasure(int r3, int r4) {
        super.onMeasure(r3, r4);
        if (this.mPopup != null) goto L5;
        return;
    L5:
        if (View.MeasureSpec.getMode(r3) != Integer.MIN_VALUE) goto L9;
        setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), compatMeasureContentWidth(getAdapter(), getBackground())), View.MeasureSpec.getSize(r3)), getMeasuredHeight());
        return;
    }

    public AppCompatSpinner(Context r2, AttributeSet r3) {
        this(r2, r3, 2130974126);
    }

    public AppCompatSpinner(Context r2, AttributeSet r3, int r4) {
        this(r2, r3, r4, -1);
    }

    public AppCompatSpinner(Context r7, AttributeSet r8, int r9, int r10) {
        this(r7, r8, r9, r10, null);
    }

    public AppCompatSpinner(Context r8, AttributeSet r9, int r10, int r11, Resources.Theme r12) {
        super(r8, r9, r10);
        this.mTempRect = new Rect();
        ThemeUtils.checkAppCompatTheme(this, getContext());
        TintTypedArray r1 = TintTypedArray.obtainStyledAttributes(r8, r9, new int[]{R.attr.entries, R.attr.popupBackground, R.attr.prompt, R.attr.dropDownWidth, 2130973585}, r10, 0);
        this.mBackgroundTintHelper = new AppCompatBackgroundHelper(this);
        if (r12 == null) goto L5;
        this.mPopupContext = new ContextThemeWrapper(r8, r12);
    L9:
        TypedArray r3 = null;
        if (r11 != (-1)) goto L26;
        TypedArray r13 = r8.obtainStyledAttributes(r9, ATTRS_ANDROID_SPINNERMODE, r10, 0);     // Catch: Throwable -> L18 Exception -> L22
    L42:
    L16:
        th = th;
        r3 = r13;
    L19:
        if (r3 == null) goto L21;
        r3.recycle();
    L21:
        throw th;
    L13:
        if (r13.hasValue(0) == false) goto L15;
        r11 = r13.getInt(0, 0);     // Catch: Throwable -> L16 Exception -> L39
    L15:
        r13.recycle();
    L23:
        if (r13 == null) goto L26;
    L22:
        r13 = null;
    L18:
        th = th;
    L26:
        if (r11 == 0) goto L30;
        if (r11 != 1) goto L31;
        final DropdownPopup r14 = new DropdownPopup(this, this.mPopupContext, r9, r10);
        TintTypedArray r0 = TintTypedArray.obtainStyledAttributes(this.mPopupContext, r9, new int[]{R.attr.entries, R.attr.popupBackground, R.attr.prompt, R.attr.dropDownWidth, 2130973585}, r10, 0);
        this.mDropDownWidth = r0.getLayoutDimension(3, -2);
        r14.setBackgroundDrawable(r0.getDrawable(1));
        r14.setPromptText(r1.getString(2));
        r0.recycle();
        this.mPopup = r14;
        this.mForwardingListener = new AnonymousClass1(this, this, r14);
    L31:
        CharSequence[] r15 = r1.getTextArray(0);
        if (r15 == null) goto L34;
        ArrayAdapter r16 = new ArrayAdapter(r8, R.layout.simple_spinner_item, r15);
        r16.setDropDownViewResource(2131564910);
        setAdapter(r16);
    L34:
        r1.recycle();
        this.mPopupSet = true;
        SpinnerAdapter r17 = this.mTempAdapter;
        if (r17 == null) goto L37;
        setAdapter(r17);
        this.mTempAdapter = null;
    L37:
        this.mBackgroundTintHelper.loadFromAttributes(r9, r10);
        return;
    L30:
        DialogPopup r18 = new DialogPopup(this);
        this.mPopup = r18;
        r18.setPromptText(r1.getString(2));
        goto L31
    L5:
        int r19 = r1.getResourceId(4, 0);
        if (r19 == 0) goto L8;
        this.mPopupContext = new ContextThemeWrapper(r8, r19);
        goto L9
    L8:
        this.mPopupContext = r8;
        goto L9
    }
}
