package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.core.view.ViewCompat;
import androidx.core.widget.PopupWindowCompat;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildPopupWindowBoundsAdapter;
import java.lang.reflect.Method;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class ListPopupWindow implements ShowableListMenu {
    private static final boolean DEBUG = false;
    static final int EXPAND_LIST_TIMEOUT = 250;
    public static final int INPUT_METHOD_FROM_FOCUSABLE = 0;
    public static final int INPUT_METHOD_NEEDED = 1;
    public static final int INPUT_METHOD_NOT_NEEDED = 2;
    public static final int MATCH_PARENT = -1;
    public static final int POSITION_PROMPT_ABOVE = 0;
    public static final int POSITION_PROMPT_BELOW = 1;
    private static final String TAG = "ListPopupWindow";
    public static final int WRAP_CONTENT = -2;
    private static Method sGetMaxAvailableHeightMethod;
    private static Method sSetClipToWindowEnabledMethod;
    private static Method sSetEpicenterBoundsMethod;
    private ListAdapter mAdapter;
    private Context mContext;
    private boolean mDropDownAlwaysVisible;
    private View mDropDownAnchorView;
    private int mDropDownGravity;
    private int mDropDownHeight;
    private int mDropDownHorizontalOffset;
    DropDownListView mDropDownList;
    private Drawable mDropDownListHighlight;
    private int mDropDownVerticalOffset;
    private boolean mDropDownVerticalOffsetSet;
    private int mDropDownWidth;
    private int mDropDownWindowLayoutType;
    private Rect mEpicenterBounds;
    private boolean mForceIgnoreOutsideTouch;
    final Handler mHandler;
    private final ListSelectorHider mHideSelector;
    private AdapterView.OnItemClickListener mItemClickListener;
    private AdapterView.OnItemSelectedListener mItemSelectedListener;
    int mListItemExpandMaximum;
    private boolean mModal;
    private DataSetObserver mObserver;
    private boolean mOverlapAnchor;
    private boolean mOverlapAnchorSet;
    PopupWindow mPopup;
    private int mPromptPosition;
    private View mPromptView;
    final ResizePopupRunnable mResizePopupRunnable;
    private final PopupScrollListener mScrollListener;
    private Runnable mShowDropDownRunnable;
    private final Rect mTempRect;
    private final PopupTouchInterceptor mTouchInterceptor;

    public class ListSelectorHider implements Runnable {
        final /* synthetic */ ListPopupWindow this$0;

        @Override // java.lang.Runnable
        public void run() {
            androidx_appcompat_widget_ListPopupWindow$ListSelectorHider_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void androidx_appcompat_widget_ListPopupWindow$ListSelectorHider__run$___twin___() {
            this.this$0.clearListSelection();
        }

        public ListSelectorHider(ListPopupWindow r1) {
            this.this$0 = r1;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void androidx_appcompat_widget_ListPopupWindow$ListSelectorHider_com_larus_apm_impl_protector_RunnableLancet_run(ListSelectorHider r1) {
            r1.androidx_appcompat_widget_ListPopupWindow$ListSelectorHider__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public class PopupDataSetObserver extends DataSetObserver {
        final /* synthetic */ ListPopupWindow this$0;

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (this.this$0.isShowing() == false) goto L6;
            this.this$0.show();
            return;
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            this.this$0.dismiss();
        }

        public PopupDataSetObserver(ListPopupWindow r1) {
            this.this$0 = r1;
        }
    }

    public class PopupScrollListener implements AbsListView.OnScrollListener {
        final /* synthetic */ ListPopupWindow this$0;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView r1, int r2, int r3, int r4) {
        }

        public PopupScrollListener(ListPopupWindow r1) {
            this.this$0 = r1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView r1, int r2) {
            if (r2 == 1) goto L5;
            return;
        L5:
            if (this.this$0.isInputMethodNotNeeded() == false) goto L7;
            return;
        L7:
            if (this.this$0.mPopup.getContentView() == null) goto L12;
            ListPopupWindow r3 = this.this$0;
            r3.mHandler.removeCallbacks(r3.mResizePopupRunnable);
            this.this$0.mResizePopupRunnable.run();
            return;
        }
    }

    public class PopupTouchInterceptor implements View.OnTouchListener {
        final /* synthetic */ ListPopupWindow this$0;

        public PopupTouchInterceptor(ListPopupWindow r1) {
            this.this$0 = r1;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View r3, MotionEvent r4) {
            int r5 = r4.getAction();
            int r0 = (int) r4.getX();
            int r6 = (int) r4.getY();
            if (r5 != 0) goto L16;
            PopupWindow r1 = this.this$0.mPopup;
            if (r1 == null) goto L16;
            if (r1.isShowing() == false) goto L16;
            if (r0 < 0) goto L16;
            if (r0 >= this.this$0.mPopup.getWidth()) goto L16;
            if (r6 < 0) goto L16;
            if (r6 >= this.this$0.mPopup.getHeight()) goto L16;
            ListPopupWindow r7 = this.this$0;
            r7.mHandler.postDelayed(r7.mResizePopupRunnable, 250);
            return false;
        L16:
            if (r5 != 1) goto L21;
            ListPopupWindow r8 = this.this$0;
            r8.mHandler.removeCallbacks(r8.mResizePopupRunnable);
            return false;
        L21:
            return false;
        }
    }

    public class ResizePopupRunnable implements Runnable {
        final /* synthetic */ ListPopupWindow this$0;

        @Override // java.lang.Runnable
        public void run() {
            androidx_appcompat_widget_ListPopupWindow$ResizePopupRunnable_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void androidx_appcompat_widget_ListPopupWindow$ResizePopupRunnable__run$___twin___() {
            DropDownListView r0 = this.this$0.mDropDownList;
            if (r0 != null) goto L5;
            return;
        L5:
            if (ViewCompat.isAttachedToWindow(r0) == true) goto L7;
            return;
        L7:
            if (this.this$0.mDropDownList.getCount() <= this.this$0.mDropDownList.getChildCount()) goto L14;
            int r1 = this.this$0.mDropDownList.getChildCount();
            ListPopupWindow r2 = this.this$0;
            if (r1 > r2.mListItemExpandMaximum) goto L15;
            r2.mPopup.setInputMethodMode(2);
            this.this$0.show();
            return;
        L15:
            return;
        }

        public ResizePopupRunnable(ListPopupWindow r1) {
            this.this$0 = r1;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void androidx_appcompat_widget_ListPopupWindow$ResizePopupRunnable_com_larus_apm_impl_protector_RunnableLancet_run(ResizePopupRunnable r1) {
            r1.androidx_appcompat_widget_ListPopupWindow$ResizePopupRunnable__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    private static boolean isConfirmKey(int r1) {
        if (r1 != 66) goto L5;
    L8:
        return true;
    L5:
        if (r1 == 23) goto L8;
        return false;
    }

    static {
        if (Build.VERSION.SDK_INT > 28) goto L9;
        sSetClipToWindowEnabledMethod = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", new Class[]{Boolean.TYPE});     // Catch: NoSuchMethodException -> L13
    L14:
        sSetEpicenterBoundsMethod = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", new Class[]{Rect.class});     // Catch: NoSuchMethodException -> L7
    L9:
        if (Build.VERSION.SDK_INT > 23) goto L20;
        sGetMaxAvailableHeightMethod = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", new Class[]{View.class, Integer.TYPE, Boolean.TYPE});     // Catch: NoSuchMethodException -> L12
        return;
    L21:
        return;
    }

    private int buildDropDown() {
        boolean r3 = true;
        if (this.mDropDownList != null) goto L25;
        Context r0 = this.mContext;
        this.mShowDropDownRunnable = new AnonymousClass2(this);
        DropDownListView r5 = createDropDownListView(r0, !this.mModal);
        this.mDropDownList = r5;
        Drawable r6 = this.mDropDownListHighlight;
        if (r6 == null) goto L7;
        r5.setSelector(r6);
    L7:
        this.mDropDownList.setAdapter(this.mAdapter);
        this.mDropDownList.setOnItemClickListener(this.mItemClickListener);
        this.mDropDownList.setFocusable(true);
        this.mDropDownList.setFocusableInTouchMode(true);
        this.mDropDownList.setOnItemSelectedListener(new AnonymousClass3(this));
        this.mDropDownList.setOnScrollListener(this.mScrollListener);
        AdapterView.OnItemSelectedListener r7 = this.mItemSelectedListener;
        if (r7 == null) goto L10;
        this.mDropDownList.setOnItemSelectedListener(r7);
    L10:
        DropDownListView r8 = this.mDropDownList;
        View r9 = this.mPromptView;
        if (r9 == null) goto L23;
        LinearLayout r10 = new LinearLayout(r0);
        r10.setOrientation(1);
        LinearLayout.LayoutParams r1 = new LinearLayout.LayoutParams(-1, 0, 1.0f);
        int r11 = this.mPromptPosition;
        if (r11 == 0) goto L17;
        if (r11 != 1) goto L18;
        r10.addView(r8, r1);
        r10.addView(r9);
    L18:
        int r2 = this.mDropDownWidth;
        if (r2 < 0) goto L21;
        int r12 = RtlSpacingHelper.UNDEFINED;
    L22:
        r9.measure(View.MeasureSpec.makeMeasureSpec(r2, r12), 0);
        LinearLayout.LayoutParams r4 = (LinearLayout.LayoutParams) r9.getLayoutParams();
        int r13 = (r9.getMeasuredHeight() + r4.topMargin) + r4.bottomMargin;
        View r14 = r10;
    L24:
        this.mPopup.setContentView(r14);
    L29:
        Drawable r15 = this.mPopup.getBackground();
        if (r15 == null) goto L34;
        r15.getPadding(this.mTempRect);
        Rect r16 = this.mTempRect;
        int r17 = r16.top;
        int r18 = r16.bottom + r17;
        if (this.mDropDownVerticalOffsetSet == true) goto L36;
        this.mDropDownVerticalOffset = -r17;
    L36:
        if (this.mPopup.getInputMethodMode() == 2) goto L39;
        r3 = false;
    L39:
        int r19 = getMaxAvailableHeight(getAnchorView(), this.mDropDownVerticalOffset, r3);
        if (this.mDropDownAlwaysVisible == true) goto L57;
        if (this.mDropDownHeight == (-1)) goto L57;
        int r20 = this.mDropDownWidth;
        if (r20 != (-2)) goto L47;
        int r21 = INVOKEVIRTUAL_androidx_appcompat_widget_ListPopupWindow_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(this.mContext.getResources()).widthPixels;
        Rect r22 = this.mTempRect;
        int r23 = View.MeasureSpec.makeMeasureSpec(r21 - (r22.left + r22.right), RtlSpacingHelper.UNDEFINED);
    L51:
        int r24 = this.mDropDownList.measureHeightOfChildrenCompat(r23, 0, -1, r19 - r13, -1);
        if (r24 <= 0) goto L55;
        r13 = r13 + (r18 + (this.mDropDownList.getPaddingTop() + this.mDropDownList.getPaddingBottom()));
    L55:
        return r24 + r13;
    L47:
        if (r20 == (-1)) goto L49;
        r23 = View.MeasureSpec.makeMeasureSpec(r20, 1073741824);
        goto L51
    L49:
        int r25 = INVOKEVIRTUAL_androidx_appcompat_widget_ListPopupWindow_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(this.mContext.getResources()).widthPixels;
        Rect r26 = this.mTempRect;
        r23 = View.MeasureSpec.makeMeasureSpec(r25 - (r26.left + r26.right), 1073741824);
    L57:
        return r19 + r18;
    L34:
        this.mTempRect.setEmpty();
        r18 = 0;
        goto L36
    L21:
        r2 = 0;
        r12 = 0;
        goto L22
    L17:
        r10.addView(r9);
        r10.addView(r8, r1);
        goto L18
    L23:
        r13 = 0;
        r14 = r8;
        goto L24
    L25:
        ViewGroup r27 = (ViewGroup) this.mPopup.getContentView();
        View r28 = this.mPromptView;
        if (r28 == null) goto L28;
        LinearLayout.LayoutParams r29 = (LinearLayout.LayoutParams) r28.getLayoutParams();
        r13 = (r28.getMeasuredHeight() + r29.topMargin) + r29.bottomMargin;
        goto L29
    L28:
        r13 = 0;
        goto L29
    }

    private void removePromptView() {
        View r0 = this.mPromptView;
        if (r0 == null) goto L8;
        ViewParent r1 = r0.getParent();
        if ((r1 instanceof ViewGroup) == false) goto L9;
        ((ViewGroup) r1).removeView(this.mPromptView);
        return;
    L9:
        return;
    }

    public void clearListSelection() {
        DropDownListView r0 = this.mDropDownList;
        if (r0 == null) goto L6;
        r0.setListSelectionHidden(true);
        r0.requestLayout();
        return;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void dismiss() {
        INVOKEVIRTUAL_androidx_appcompat_widget_ListPopupWindow_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_dismiss(this.mPopup);
        removePromptView();
        this.mPopup.setContentView(null);
        this.mDropDownList = null;
        this.mHandler.removeCallbacks(this.mResizePopupRunnable);
    }

    public int getAnimationStyle() {
        return this.mPopup.getAnimationStyle();
    }

    public Drawable getBackground() {
        return this.mPopup.getBackground();
    }

    public Rect getEpicenterBounds() {
        if (this.mEpicenterBounds != null) goto L7;
        return null;
    L7:
        return new Rect(this.mEpicenterBounds);
    }

    public int getInputMethodMode() {
        return this.mPopup.getInputMethodMode();
    }

    public int getSoftInputMode() {
        return this.mPopup.getSoftInputMode();
    }

    public int getVerticalOffset() {
        if (this.mDropDownVerticalOffsetSet == true) goto L7;
        return 0;
    L7:
        return this.mDropDownVerticalOffset;
    }

    public boolean isInputMethodNotNeeded() {
        if (this.mPopup.getInputMethodMode() != 2) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public boolean isShowing() {
        return this.mPopup.isShowing();
    }

    public void postShow() {
        this.mHandler.post(this.mShowDropDownRunnable);
    }

    public Object getSelectedItem() {
        if (isShowing() == true) goto L7;
        return null;
    L7:
        return this.mDropDownList.getSelectedItem();
    }

    public long getSelectedItemId() {
        if (isShowing() == true) goto L7;
        return Long.MIN_VALUE;
    L7:
        return this.mDropDownList.getSelectedItemId();
    }

    public int getSelectedItemPosition() {
        if (isShowing() == true) goto L7;
        return -1;
    L7:
        return this.mDropDownList.getSelectedItemPosition();
    }

    public View getSelectedView() {
        if (isShowing() == true) goto L7;
        return null;
    L7:
        return this.mDropDownList.getSelectedView();
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void show() {
        int r0 = buildDropDown();
        boolean r1 = isInputMethodNotNeeded();
        PopupWindowCompat.setWindowLayoutType(this.mPopup, this.mDropDownWindowLayoutType);
        boolean r3 = true;
        if (this.mPopup.isShowing() == true) goto L5;
        int r2 = this.mDropDownWidth;
        if (r2 != (-1)) goto L48;
        r2 = -1;
    L50:
        int r4 = this.mDropDownHeight;
        if (r4 != (-1)) goto L53;
        r0 = -1;
    L56:
        this.mPopup.setWidth(r2);
        this.mPopup.setHeight(r0);
        setPopupClipToScreenEnabled(true);
        PopupWindow r5 = this.mPopup;
        if (this.mForceIgnoreOutsideTouch == false) goto L59;
    L61:
        boolean r6 = false;
    L62:
        r5.setOutsideTouchable(r6);
        this.mPopup.setTouchInterceptor(this.mTouchInterceptor);
        if (this.mOverlapAnchorSet == false) goto L66;
        PopupWindowCompat.setOverlapAnchor(this.mPopup, this.mOverlapAnchor);
    L66:
        if (Build.VERSION.SDK_INT > 28) goto L72;
        Method r7 = sSetEpicenterBoundsMethod;
        if (r7 != null) goto L82;
    L73:
        PopupWindowCompat.showAsDropDown(this.mPopup, getAnchorView(), this.mDropDownHorizontalOffset, this.mDropDownVerticalOffset, this.mDropDownGravity);
        this.mDropDownList.setSelection(-1);
        if (this.mModal == true) goto L76;
    L77:
        clearListSelection();
    L79:
        if (this.mModal == true) goto L85;
        this.mHandler.post(this.mHideSelector);
        return;
    L85:
        return;
    L76:
        if (this.mDropDownList.isInTouchMode() == false) goto L79;
    L82:
        r7.invoke(this.mPopup, new Object[]{this.mEpicenterBounds});     // Catch: Exception -> L71
        goto L73
    L72:
        this.mPopup.setEpicenterBounds(this.mEpicenterBounds);
        goto L73
    L59:
        if (this.mDropDownAlwaysVisible == true) goto L61;
        r6 = true;
        goto L62
    L53:
        if (r4 == (-2)) goto L56;
        r0 = r4;
        goto L56
    L48:
        if (r2 != (-2)) goto L50;
        r2 = getAnchorView().getWidth();
        goto L50
    L5:
        if (ViewCompat.isAttachedToWindow(getAnchorView()) == true) goto L7;
        return;
    L7:
        int r8 = this.mDropDownWidth;
        if (r8 != (-1)) goto L10;
        r8 = -1;
    L12:
        int r9 = this.mDropDownHeight;
        if (r9 != (-1)) goto L28;
        if (r1 == true) goto L17;
        r0 = -1;
    L17:
        if (r1 == false) goto L23;
        PopupWindow r10 = this.mPopup;
        if (this.mDropDownWidth != (-1)) goto L21;
        int r11 = -1;
    L22:
        r10.setWidth(r11);
        this.mPopup.setHeight(0);
    L31:
        PopupWindow r12 = this.mPopup;
        if (this.mForceIgnoreOutsideTouch == false) goto L34;
    L36:
        r3 = false;
    L37:
        r12.setOutsideTouchable(r3);
        PopupWindow r13 = this.mPopup;
        View r14 = getAnchorView();
        int r15 = this.mDropDownHorizontalOffset;
        int r16 = this.mDropDownVerticalOffset;
        if (r8 >= 0) goto L40;
        int r17 = -1;
    L41:
        if (r0 >= 0) goto L43;
        int r18 = -1;
    L44:
        INVOKEVIRTUAL_androidx_appcompat_widget_ListPopupWindow_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_update(r13, r14, r15, r16, r17, r18);
        return;
    L43:
        r18 = r0;
        goto L44
    L40:
        r17 = r8;
        goto L41
    L34:
        if (this.mDropDownAlwaysVisible == true) goto L36;
    L21:
        r11 = 0;
        goto L22
    L23:
        PopupWindow r19 = this.mPopup;
        if (this.mDropDownWidth != (-1)) goto L26;
        int r20 = -1;
    L27:
        r19.setWidth(r20);
        this.mPopup.setHeight(-1);
        goto L31
    L26:
        r20 = 0;
        goto L27
    L28:
        if (r9 == (-2)) goto L31;
        r0 = r9;
        goto L31
    L10:
        if (r8 != (-2)) goto L12;
        r8 = getAnchorView().getWidth();
        goto L12
    }

    public View getAnchorView() {
        return this.mDropDownAnchorView;
    }

    public int getHeight() {
        return this.mDropDownHeight;
    }

    public int getHorizontalOffset() {
        return this.mDropDownHorizontalOffset;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public ListView getListView() {
        return this.mDropDownList;
    }

    public int getPromptPosition() {
        return this.mPromptPosition;
    }

    public int getWidth() {
        return this.mDropDownWidth;
    }

    public boolean isDropDownAlwaysVisible() {
        return this.mDropDownAlwaysVisible;
    }

    public boolean isModal() {
        return this.mModal;
    }

    public ListPopupWindow(Context r3) {
        this(r3, null, 2130972563);
    }

    public static void INVOKEVIRTUAL_androidx_appcompat_widget_ListPopupWindow_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_dismiss(PopupWindow r0) {
        PopupWindowLancet.handleDismissBeforeOrigin(r0);
        r0.dismiss();
    }

    public static DisplayMetrics INVOKEVIRTUAL_androidx_appcompat_widget_ListPopupWindow_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    private void setPopupClipToScreenEnabled(boolean r5) {
        if (Build.VERSION.SDK_INT > 28) goto L8;
        Method r0 = sSetClipToWindowEnabledMethod;
        if (r0 == null) goto L13;
        r0.invoke(this.mPopup, new Object[]{Boolean.valueOf(r5)});     // Catch: Exception -> L10
        return;
    L15:
        return;
    L13:
        return;
    L8:
        this.mPopup.setIsClippedToScreen(r5);
    }

    public View.OnTouchListener createDragToOpenListener(final View r2) {
        return new AnonymousClass1(this, r2);
    }

    public boolean performItemClick(int r8) {
        if (isShowing() == true) goto L5;
        return false;
    L5:
        if (this.mItemClickListener == null) goto L11;
        DropDownListView r2 = this.mDropDownList;
        View r3 = r2.getChildAt(r8 - r2.getFirstVisiblePosition());
        ListAdapter r0 = r2.getAdapter();
        this.mItemClickListener.onItemClick(r2, r3, r8, r0.getItemId(r8));
        return true;
    L11:
        return true;
    }

    public void setAdapter(ListAdapter r3) {
        DataSetObserver r0 = this.mObserver;
        if (r0 != null) goto L5;
        this.mObserver = new PopupDataSetObserver(this);
    L8:
        this.mAdapter = r3;
        if (r3 == null) goto L11;
        r3.registerDataSetObserver(this.mObserver);
    L11:
        DropDownListView r4 = this.mDropDownList;
        if (r4 == null) goto L15;
        r4.setAdapter(this.mAdapter);
        return;
    L15:
        return;
    L5:
        ListAdapter r1 = this.mAdapter;
        if (r1 == null) goto L8;
        r1.unregisterDataSetObserver(r0);
        goto L8
    }

    public void setAnchorView(View r1) {
        this.mDropDownAnchorView = r1;
    }

    public void setAnimationStyle(int r2) {
        this.mPopup.setAnimationStyle(r2);
    }

    public void setBackgroundDrawable(Drawable r2) {
        this.mPopup.setBackgroundDrawable(r2);
    }

    public void setContentWidth(int r3) {
        Drawable r0 = this.mPopup.getBackground();
        if (r0 == null) goto L5;
        r0.getPadding(this.mTempRect);
        Rect r1 = this.mTempRect;
        this.mDropDownWidth = (r1.left + r1.right) + r3;
        return;
    L5:
        setWidth(r3);
    }

    public void setDropDownAlwaysVisible(boolean r1) {
        this.mDropDownAlwaysVisible = r1;
    }

    public void setDropDownGravity(int r1) {
        this.mDropDownGravity = r1;
    }

    public void setEpicenterBounds(Rect r2) {
        if (r2 == null) goto L4;
        Rect r0 = new Rect(r2);
    L5:
        this.mEpicenterBounds = r0;
        return;
    L4:
        r0 = null;
        goto L5
    }

    public void setForceIgnoreOutsideTouch(boolean r1) {
        this.mForceIgnoreOutsideTouch = r1;
    }

    public void setHeight(int r2) {
        if (r2 < 0) goto L4;
    L10:
        this.mDropDownHeight = r2;
        return;
    L4:
        if ((-2) == r2) goto L10;
        if ((-1) == r2) goto L10;
        throw new IllegalArgumentException("Invalid height. Must be a positive value, MATCH_PARENT, or WRAP_CONTENT.");
    }

    public void setHorizontalOffset(int r1) {
        this.mDropDownHorizontalOffset = r1;
    }

    public void setInputMethodMode(int r2) {
        this.mPopup.setInputMethodMode(r2);
    }

    public void setListItemExpandMax(int r1) {
        this.mListItemExpandMaximum = r1;
    }

    public void setListSelector(Drawable r1) {
        this.mDropDownListHighlight = r1;
    }

    public void setModal(boolean r2) {
        this.mModal = r2;
        this.mPopup.setFocusable(r2);
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener r2) {
        this.mPopup.setOnDismissListener(r2);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener r1) {
        this.mItemClickListener = r1;
    }

    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener r1) {
        this.mItemSelectedListener = r1;
    }

    public void setOverlapAnchor(boolean r2) {
        this.mOverlapAnchorSet = true;
        this.mOverlapAnchor = r2;
    }

    public void setPromptPosition(int r1) {
        this.mPromptPosition = r1;
    }

    public void setPromptView(View r2) {
        boolean r0 = isShowing();
        if (r0 == false) goto L5;
        removePromptView();
    L5:
        this.mPromptView = r2;
        if (r0 == false) goto L9;
        show();
        return;
    }

    public void setSelection(int r3) {
        DropDownListView r0 = this.mDropDownList;
        if (isShowing() == false) goto L9;
        if (r0 == null) goto L10;
        r0.setListSelectionHidden(false);
        r0.setSelection(r3);
        if (r0.getChoiceMode() == 0) goto L11;
        r0.setItemChecked(r3, true);
        return;
    L11:
        return;
    L10:
        return;
    }

    public void setSoftInputMode(int r2) {
        this.mPopup.setSoftInputMode(r2);
    }

    public void setVerticalOffset(int r1) {
        this.mDropDownVerticalOffset = r1;
        this.mDropDownVerticalOffsetSet = true;
    }

    public void setWidth(int r1) {
        this.mDropDownWidth = r1;
    }

    public void setWindowLayoutType(int r1) {
        this.mDropDownWindowLayoutType = r1;
    }

    public ListPopupWindow(Context r2, AttributeSet r3) {
        this(r2, r3, 2130972563);
    }

    public DropDownListView createDropDownListView(Context r2, boolean r3) {
        return new DropDownListView(r2, r3);
    }

    public boolean onKeyDown(int r10, KeyEvent r11) {
        if (isShowing() == true) goto L5;
    L49:
        return false;
    L5:
        if (r10 == 62) goto L49;
        if (this.mDropDownList.getSelectedItemPosition() < 0) goto L9;
    L10:
        int r0 = this.mDropDownList.getSelectedItemPosition();
        boolean r2 = !this.mPopup.isAboveAnchor();
        ListAdapter r4 = this.mAdapter;
        if (r4 == null) goto L19;
        boolean r5 = r4.areAllItemsEnabled();
        if (r5 == false) goto L15;
        int r6 = 0;
    L16:
        if (r5 == false) goto L18;
        int r7 = r4.getCount() - 1;
    L21:
        if (r2 == false) goto L25;
        if (r10 != 19) goto L25;
        if (r0 > r6) goto L25;
    L28:
        clearListSelection();
        this.mPopup.setInputMethodMode(1);
        show();
        return true;
    L25:
        if (r2 == true) goto L30;
        if (r10 != 20) goto L30;
        if (r0 >= r7) goto L28;
    L30:
        this.mDropDownList.setListSelectionHidden(false);
        if (this.mDropDownList.onKeyDown(r10, r11) == false) goto L41;
        this.mPopup.setInputMethodMode(2);
        this.mDropDownList.requestFocusFromTouch();
        show();
        if (r10 == 19) goto L40;
        if (r10 == 20) goto L40;
        if (r10 == 23) goto L40;
        if (r10 != 66) goto L49;
    L40:
        return true;
    L41:
        if (r2 == false) goto L45;
        if (r10 != 20) goto L45;
        if (r0 != r7) goto L49;
        return true;
    L45:
        if (r2 == true) goto L49;
        if (r10 != 19) goto L49;
        if (r0 != r6) goto L49;
        return true;
    L18:
        r7 = this.mDropDownList.lookForSelectablePosition(r4.getCount() - 1, false);
        goto L21
    L15:
        r6 = this.mDropDownList.lookForSelectablePosition(0, true);
        goto L16
    L19:
        r6 = Integer.MAX_VALUE;
        r7 = RtlSpacingHelper.UNDEFINED;
        goto L21
    L9:
        if (isConfirmKey(r10) == true) goto L49;
        goto L10
    }

    public boolean onKeyPreIme(int r3, KeyEvent r4) {
        if (r3 == 4) goto L5;
        return false;
    L5:
        if (isShowing() == false) goto L27;
        View r5 = this.mDropDownAnchorView;
        if (r4.getAction() != 0) goto L15;
        if (r4.getRepeatCount() != 0) goto L15;
        KeyEvent.DispatcherState r6 = r5.getKeyDispatcherState();
        if (r6 == null) goto L13;
        r6.startTracking(r4, this);
    L13:
        return true;
    L15:
        if (r4.getAction() != 1) goto L28;
        KeyEvent.DispatcherState r7 = r5.getKeyDispatcherState();
        if (r7 == null) goto L20;
        r7.handleUpEvent(r4);
    L20:
        if (r4.isTracking() == true) goto L22;
        return false;
    L22:
        if (r4.isCanceled() == true) goto L30;
        dismiss();
        return true;
    L30:
        return false;
    L28:
        return false;
    L27:
        return false;
    }

    public boolean onKeyUp(int r2, KeyEvent r3) {
        if (isShowing() == true) goto L5;
        return false;
    L5:
        if (this.mDropDownList.getSelectedItemPosition() < 0) goto L14;
        boolean r4 = this.mDropDownList.onKeyUp(r2, r3);
        if (r4 == true) goto L9;
    L11:
        return r4;
    L9:
        if (isConfirmKey(r2) == false) goto L11;
        dismiss();
        goto L11
    L14:
        return false;
    }

    public ListPopupWindow(Context r2, AttributeSet r3, int r4) {
        this(r2, r3, r4, 0);
    }

    private int getMaxAvailableHeight(View r6, int r7, boolean r8) {
        if (Build.VERSION.SDK_INT > 23) goto L11;
        Method r0 = sGetMaxAvailableHeightMethod;
        if (r0 == null) goto L9;
        return ((Integer) r0.invoke(this.mPopup, new Object[]{r6, Integer.valueOf(r7), Boolean.valueOf(r8)})).intValue();
    L9:
        return this.mPopup.getMaxAvailableHeight(r6, r7);
    L11:
        return this.mPopup.getMaxAvailableHeight(r6, r7, r8);
    }

    public ListPopupWindow(Context r4, AttributeSet r5, int r6, int r7) {
        this.mDropDownHeight = -2;
        this.mDropDownWidth = -2;
        this.mDropDownWindowLayoutType = 1002;
        this.mDropDownGravity = 0;
        this.mDropDownAlwaysVisible = false;
        this.mForceIgnoreOutsideTouch = false;
        this.mListItemExpandMaximum = Integer.MAX_VALUE;
        this.mPromptPosition = 0;
        this.mResizePopupRunnable = new ResizePopupRunnable(this);
        this.mTouchInterceptor = new PopupTouchInterceptor(this);
        this.mScrollListener = new PopupScrollListener(this);
        this.mHideSelector = new ListSelectorHider(this);
        this.mTempRect = new Rect();
        this.mContext = r4;
        this.mHandler = new Handler(r4.getMainLooper());
        TypedArray r1 = r4.obtainStyledAttributes(r5, new int[]{R.attr.dropDownHorizontalOffset, R.attr.dropDownVerticalOffset}, r6, r7);
        this.mDropDownHorizontalOffset = r1.getDimensionPixelOffset(0, 0);
        int r0 = r1.getDimensionPixelOffset(1, 0);
        this.mDropDownVerticalOffset = r0;
        if (r0 == 0) goto L5;
        this.mDropDownVerticalOffsetSet = true;
    L5:
        r1.recycle();
        AppCompatPopupWindow r2 = new AppCompatPopupWindow(r4, r5, r6, r7);
        this.mPopup = r2;
        r2.setInputMethodMode(1);
    }

    public static void INVOKEVIRTUAL_androidx_appcompat_widget_ListPopupWindow_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_update(PopupWindow r1, View r2, int r3, int r4, int r5, int r6) {
        if ((r1 instanceof PopupWindow) == false) goto L9;
        if (LandscapeChildPopupWindowBoundsAdapter.isDirectUpdateBypassTarget(r1) == false) goto L9;
        r1.update(r2, r3, r4, r5, r6);
        return;
    L9:
        if (PopupWindowLancet.rewriteDirectUpdateIfNeeded(r1, r2, r3, r4, r5, r6) == false) goto L11;
        return;
    L11:
        r1.update(r2, r3, r4, r5, r6);
    }
}
