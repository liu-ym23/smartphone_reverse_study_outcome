package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class MenuPopupHelper implements MenuHelper {
    private static final int TOUCH_EPICENTER_SIZE_DP = 48;
    private View mAnchorView;
    private final Context mContext;
    private int mDropDownGravity;
    private boolean mForceShowIcon;
    private final PopupWindow.OnDismissListener mInternalOnDismissListener;
    private final MenuBuilder mMenu;
    private PopupWindow.OnDismissListener mOnDismissListener;
    private final boolean mOverflowOnly;
    private MenuPopup mPopup;
    private final int mPopupStyleAttr;
    private final int mPopupStyleRes;
    private MenuPresenter.Callback mPresenterCallback;

    public void onDismiss() {
        this.mPopup = null;
        PopupWindow.OnDismissListener r0 = this.mOnDismissListener;
        if (r0 == null) goto L6;
        r0.onDismiss();
        return;
    }

    private MenuPopup createPopup() {
        Display r0 = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay();
        Point r1 = new Point();
        r0.getRealSize(r1);
        if (Math.min(r1.x, r1.y) < this.mContext.getResources().getDimensionPixelSize(2131165210)) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L8;
        MenuPopup r3 = new CascadingMenuPopup(this.mContext, this.mAnchorView, this.mPopupStyleAttr, this.mPopupStyleRes, this.mOverflowOnly);
    L9:
        r3.addMenu(this.mMenu);
        r3.setOnDismissListener(this.mInternalOnDismissListener);
        r3.setAnchorView(this.mAnchorView);
        r3.setCallback(this.mPresenterCallback);
        r3.setForceShowIcon(this.mForceShowIcon);
        r3.setGravity(this.mDropDownGravity);
        return r3;
    L8:
        r3 = new StandardMenuPopup(this.mContext, this.mMenu, this.mAnchorView, this.mPopupStyleAttr, this.mPopupStyleRes, this.mOverflowOnly);
        goto L9
    L5:
        r2 = false;
        goto L6
    }

    public MenuPopup getPopup() {
        if (this.mPopup != null) goto L6;
        this.mPopup = createPopup();
    L6:
        return this.mPopup;
    }

    public boolean isShowing() {
        MenuPopup r0 = this.mPopup;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isShowing() == false) goto L7;
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuHelper
    public void dismiss() {
        if (isShowing() == false) goto L6;
        this.mPopup.dismiss();
        return;
    }

    public ListView getListView() {
        return getPopup().getListView();
    }

    public void show() {
        if (tryShow() == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
    }

    public boolean tryShow() {
        if (isShowing() == false) goto L6;
        return true;
    L6:
        if (this.mAnchorView != null) goto L8;
        return false;
    L8:
        showPopup(0, 0, false, false);
        return true;
    }

    public int getGravity() {
        return this.mDropDownGravity;
    }

    public static DisplayMetrics INVOKEVIRTUAL_androidx_appcompat_view_menu_MenuPopupHelper_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    public void setAnchorView(View r1) {
        this.mAnchorView = r1;
    }

    public void setForceShowIcon(boolean r2) {
        this.mForceShowIcon = r2;
        MenuPopup r0 = this.mPopup;
        if (r0 == null) goto L6;
        r0.setForceShowIcon(r2);
        return;
    }

    public void setGravity(int r1) {
        this.mDropDownGravity = r1;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener r1) {
        this.mOnDismissListener = r1;
    }

    @Override // androidx.appcompat.view.menu.MenuHelper
    public void setPresenterCallback(MenuPresenter.Callback r2) {
        this.mPresenterCallback = r2;
        MenuPopup r0 = this.mPopup;
        if (r0 == null) goto L6;
        r0.setCallback(r2);
        return;
    }

    public MenuPopupHelper(Context r8, MenuBuilder r9) {
        this(r8, r9, null, false, 2130973584, 0);
    }

    public void show(int r1, int r2) {
        if (tryShow(r1, r2) == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
    }

    public boolean tryShow(int r3, int r4) {
        if (isShowing() == false) goto L6;
        return true;
    L6:
        if (this.mAnchorView != null) goto L9;
        return false;
    L9:
        showPopup(r3, r4, true, true);
        return true;
    }

    public MenuPopupHelper(Context r8, MenuBuilder r9, View r10) {
        this(r8, r9, r10, false, 2130973584, 0);
    }

    private void showPopup(int r4, int r5, boolean r6, boolean r7) {
        MenuPopup r0 = getPopup();
        r0.setShowTitle(r7);
        if (r6 == true) goto L5;
    L8:
        r0.show();
        return;
    L5:
        if ((GravityCompat.getAbsoluteGravity(this.mDropDownGravity, ViewCompat.getLayoutDirection(this.mAnchorView)) & 7) != 5) goto L7;
        r4 = r4 - this.mAnchorView.getWidth();
    L7:
        r0.setHorizontalOffset(r4);
        r0.setVerticalOffset(r5);
        int r8 = (int) ((INVOKEVIRTUAL_androidx_appcompat_view_menu_MenuPopupHelper_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(this.mContext.getResources()).density * 48.0f) / 2.0f);
        r0.setEpicenterBounds(new Rect(r4 - r8, r5 - r8, r4 + r8, r5 + r8));
        goto L8
    }

    public MenuPopupHelper(Context r8, MenuBuilder r9, View r10, boolean r11, int r12) {
        this(r8, r9, r10, r11, r12, 0);
    }

    public MenuPopupHelper(Context r2, MenuBuilder r3, View r4, boolean r5, int r6, int r7) {
        this.mDropDownGravity = 8388611;
        this.mInternalOnDismissListener = new AnonymousClass1(this);
        this.mContext = r2;
        this.mMenu = r3;
        this.mAnchorView = r4;
        this.mOverflowOnly = r5;
        this.mPopupStyleAttr = r6;
        this.mPopupStyleRes = r7;
    }
}
