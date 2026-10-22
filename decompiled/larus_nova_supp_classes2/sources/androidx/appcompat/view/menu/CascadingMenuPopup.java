package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.widget.MenuItemHoverListener;
import androidx.appcompat.widget.MenuPopupWindow;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class CascadingMenuPopup extends MenuPopup implements View.OnKeyListener, PopupWindow.OnDismissListener {
    static final int HORIZ_POSITION_LEFT = 0;
    static final int HORIZ_POSITION_RIGHT = 1;
    private static final int ITEM_LAYOUT = 2131558417;
    static final int SUBMENU_TIMEOUT_MS = 200;
    private View mAnchorView;
    private final View.OnAttachStateChangeListener mAttachStateChangeListener;
    private final Context mContext;
    private int mDropDownGravity;
    private boolean mForceShowIcon;
    final ViewTreeObserver.OnGlobalLayoutListener mGlobalLayoutListener;
    private boolean mHasXOffset;
    private boolean mHasYOffset;
    private int mLastPosition;
    private final MenuItemHoverListener mMenuItemHoverListener;
    private final int mMenuMaxWidth;
    private PopupWindow.OnDismissListener mOnDismissListener;
    private final boolean mOverflowOnly;
    private final List<MenuBuilder> mPendingMenus;
    private final int mPopupStyleAttr;
    private final int mPopupStyleRes;
    private MenuPresenter.Callback mPresenterCallback;
    private int mRawDropDownGravity;
    boolean mShouldCloseImmediately;
    private boolean mShowTitle;
    final List<CascadingMenuInfo> mShowingMenus;
    View mShownAnchorView;
    final Handler mSubMenuHoverHandler;
    ViewTreeObserver mTreeObserver;
    private int mXOffset;
    private int mYOffset;

    public static class CascadingMenuInfo {
        public final MenuBuilder menu;
        public final int position;
        public final MenuPopupWindow window;

        public ListView getListView() {
            return this.window.getListView();
        }

        public CascadingMenuInfo(MenuPopupWindow r1, MenuBuilder r2, int r3) {
            this.window = r1;
            this.menu = r2;
            this.position = r3;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface HorizPosition {
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public boolean closeMenuOnSubMenuOpened() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean flagActionItems() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onRestoreInstanceState(Parcelable r1) {
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public Parcelable onSaveInstanceState() {
        return null;
    }

    private MenuPopupWindow createPopupWindow() {
        MenuPopupWindow r0 = new MenuPopupWindow(this.mContext, null, this.mPopupStyleAttr, this.mPopupStyleRes);
        r0.setHoverListener(this.mMenuItemHoverListener);
        r0.setOnItemClickListener(this);
        r0.setOnDismissListener(this);
        r0.setAnchorView(this.mAnchorView);
        r0.setDropDownGravity(this.mDropDownGravity);
        r0.setModal(true);
        r0.setInputMethodMode(2);
        return r0;
    }

    private int getInitialMenuPosition() {
        if (ViewCompat.getLayoutDirection(this.mAnchorView) != 1) goto L6;
        return 0;
    L6:
        return 1;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void dismiss() {
        int r0 = this.mShowingMenus.size();
        if (r0 <= 0) goto L10;
        CascadingMenuInfo[] r1 = (CascadingMenuInfo[]) this.mShowingMenus.toArray(new CascadingMenuInfo[r0]);
        int r2 = r0 - 1;
    L5:
        if (r2 < 0) goto L14;
        CascadingMenuInfo r3 = r1[r2];
        if (r3.window.isShowing() == false) goto L9;
        r3.window.dismiss();
    L9:
        r2 = r2 - 1;
        goto L5
    L14:
        return;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public ListView getListView() {
        if (this.mShowingMenus.isEmpty() == false) goto L5;
        return null;
    L5:
        List<CascadingMenuInfo> r0 = this.mShowingMenus;
        return ((CascadingMenuInfo) ListProtector.get(r0, r0.size() - 1)).getListView();
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public boolean isShowing() {
        if (this.mShowingMenus.size() > 0) goto L5;
        return false;
    L5:
        if (((CascadingMenuInfo) ListProtector.get(this.mShowingMenus, 0)).window.isShowing() == false) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        int r0 = this.mShowingMenus.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        CascadingMenuInfo r3 = (CascadingMenuInfo) ListProtector.get(this.mShowingMenus, r2);
        if (r3.window.isShowing() == false) goto L9;
        r2 = r2 + 1;
    L9:
        if (r3 == null) goto L14;
        r3.menu.close(false);
        return;
    L14:
        return;
    L8:
        r3 = null;
        goto L9
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void show() {
        if (isShowing() == false) goto L5;
        return;
    L5:
        Iterator<MenuBuilder> r0 = this.mPendingMenus.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        showMenu(r0.next());
        goto L7
    L9:
        this.mPendingMenus.clear();
        View r1 = this.mAnchorView;
        this.mShownAnchorView = r1;
        if (r1 != null) goto L12;
        return;
    L12:
        if (this.mTreeObserver != null) goto L14;
        boolean r2 = true;
    L15:
        ViewTreeObserver r3 = r1.getViewTreeObserver();
        this.mTreeObserver = r3;
        if (r2 == false) goto L18;
        r3.addOnGlobalLayoutListener(this.mGlobalLayoutListener);
    L18:
        this.mShownAnchorView.addOnAttachStateChangeListener(this.mAttachStateChangeListener);
        return;
    L14:
        r2 = false;
        goto L15
    }

    public static DisplayMetrics INVOKEVIRTUAL_androidx_appcompat_view_menu_CascadingMenuPopup_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    private int findIndexOfAddedMenu(MenuBuilder r4) {
        int r0 = this.mShowingMenus.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        if (r4 == ((CascadingMenuInfo) ListProtector.get(this.mShowingMenus, r1)).menu) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return r1;
    L8:
        return -1;
    }

    private int getNextMenuPosition(int r7) {
        List<CascadingMenuInfo> r0 = this.mShowingMenus;
        ListView r1 = ((CascadingMenuInfo) ListProtector.get(r0, r0.size() - 1)).getListView();
        int[] r2 = new int[2];
        r1.getLocationOnScreen(r2);
        Rect r3 = new Rect();
        this.mShownAnchorView.getWindowVisibleDisplayFrame(r3);
        if (this.mLastPosition != 1) goto L9;
        if (((r2[0] + r1.getWidth()) + r7) <= r3.right) goto L7;
        return 0;
    L7:
        return 1;
    L9:
        if ((r2[0] - r7) >= 0) goto L11;
        return 1;
    L11:
        return 0;
    }

    private void showMenu(MenuBuilder r15) {
        LayoutInflater r0 = LayoutInflater.from(this.mContext);
        MenuAdapter r1 = new MenuAdapter(r15, r0, this.mOverflowOnly, ITEM_LAYOUT);
        if (isShowing() == true) goto L8;
        if (this.mForceShowIcon == false) goto L8;
        r1.setForceShowIcon(true);
    L10:
        int r2 = MenuPopup.measureIndividualMenuWidth(r1, null, this.mContext, this.mMenuMaxWidth);
        MenuPopupWindow r4 = createPopupWindow();
        r4.setAdapter(r1);
        r4.setContentWidth(r2);
        r4.setDropDownGravity(this.mDropDownGravity);
        if (this.mShowingMenus.size() <= 0) goto L13;
        List<CascadingMenuInfo> r3 = this.mShowingMenus;
        CascadingMenuInfo r5 = (CascadingMenuInfo) ListProtector.get(r3, r3.size() - 1);
        View r6 = findParentViewForSubmenu(r5, r15);
    L15:
        if (r6 == null) goto L38;
        r4.setTouchModal(false);
        r4.setEnterTransition(null);
        int r8 = getNextMenuPosition(r2);
        if (r8 != 1) goto L19;
        boolean r9 = true;
    L20:
        this.mLastPosition = r8;
        if (Build.VERSION.SDK_INT < 26) goto L23;
        r4.setAnchorView(r6);
        int r10 = 0;
        int r12 = 0;
    L28:
        if ((this.mDropDownGravity & 5) != 5) goto L32;
        if (r9 == true) goto L34;
        r2 = r6.getWidth();
    L35:
        int r13 = r12 - r2;
    L36:
        r4.setHorizontalOffset(r13);
        r4.setOverlapAnchor(true);
        r4.setVerticalOffset(r10);
    L44:
        this.mShowingMenus.add(new CascadingMenuInfo(r4, r15, this.mLastPosition));
        r4.show();
        ListView r7 = r4.getListView();
        r7.setOnKeyListener(this);
        if (r5 == null) goto L47;
        return;
    L47:
        if (this.mShowTitle == true) goto L49;
        return;
    L49:
        if (r15.getHeaderTitle() == null) goto L54;
        FrameLayout r11 = (FrameLayout) r0.inflate(2131558424, r7, false);
        TextView r14 = (TextView) r11.findViewById(R.id.title);
        r11.setEnabled(false);
        r14.setText(r15.getHeaderTitle());
        r7.addHeaderView(r11, null, false);
        r4.show();
        return;
    L54:
        return;
    L34:
        r13 = r12 + r2;
        goto L36
    L32:
        if (r9 == false) goto L35;
        r2 = r6.getWidth();
        goto L34
    L23:
        int[] r16 = new int[2];
        this.mAnchorView.getLocationOnScreen(r16);
        int[] r17 = new int[2];
        r6.getLocationOnScreen(r17);
        if ((this.mDropDownGravity & 7) != 5) goto L26;
        r16[0] = r16[0] + this.mAnchorView.getWidth();
        r17[0] = r17[0] + r6.getWidth();
    L26:
        r12 = r17[0] - r16[0];
        r10 = r17[1] - r16[1];
        goto L28
    L19:
        r9 = false;
        goto L20
    L38:
        if (this.mHasXOffset == false) goto L41;
        r4.setHorizontalOffset(this.mXOffset);
    L41:
        if (this.mHasYOffset == false) goto L43;
        r4.setVerticalOffset(this.mYOffset);
    L43:
        r4.setEpicenterBounds(getEpicenterBounds());
        goto L44
    L13:
        r5 = null;
        r6 = null;
    L8:
        if (isShowing() == false) goto L10;
        r1.setForceShowIcon(MenuPopup.shouldPreserveIconSpacing(r15));
        goto L10
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void addMenu(MenuBuilder r2) {
        r2.addMenuPresenter(this, this.mContext);
        if (isShowing() == false) goto L5;
        showMenu(r2);
        return;
    L5:
        this.mPendingMenus.add(r2);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean onSubMenuSelected(SubMenuBuilder r5) {
        Iterator<CascadingMenuInfo> r0 = this.mShowingMenus.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        CascadingMenuInfo r1 = r0.next();
        if (r5 != r1.menu) goto L4;
        r1.getListView().requestFocus();
        return true;
    L10:
        if (r5.hasVisibleItems() == false) goto L15;
        addMenu(r5);
        MenuPresenter.Callback r2 = this.mPresenterCallback;
        if (r2 == null) goto L14;
        r2.onOpenSubMenu(r5);
    L14:
        return true;
    L15:
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setAnchorView(View r2) {
        if (this.mAnchorView == r2) goto L6;
        this.mAnchorView = r2;
        this.mDropDownGravity = GravityCompat.getAbsoluteGravity(this.mRawDropDownGravity, ViewCompat.getLayoutDirection(r2));
        return;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void setCallback(MenuPresenter.Callback r1) {
        this.mPresenterCallback = r1;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setForceShowIcon(boolean r1) {
        this.mForceShowIcon = r1;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setGravity(int r2) {
        if (this.mRawDropDownGravity == r2) goto L6;
        this.mRawDropDownGravity = r2;
        this.mDropDownGravity = GravityCompat.getAbsoluteGravity(r2, ViewCompat.getLayoutDirection(this.mAnchorView));
        return;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setHorizontalOffset(int r2) {
        this.mHasXOffset = true;
        this.mXOffset = r2;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setOnDismissListener(PopupWindow.OnDismissListener r1) {
        this.mOnDismissListener = r1;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setShowTitle(boolean r1) {
        this.mShowTitle = r1;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setVerticalOffset(int r2) {
        this.mHasYOffset = true;
        this.mYOffset = r2;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean r2) {
        Iterator<CascadingMenuInfo> r3 = this.mShowingMenus.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        MenuPopup.toMenuAdapter(r3.next().getListView().getAdapter()).notifyDataSetChanged();
        goto L4
    }

    private MenuItem findMenuItemForSubmenu(MenuBuilder r5, MenuBuilder r6) {
        int r0 = r5.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L10;
        MenuItem r2 = r5.getItem(r1);
        if (r2.hasSubMenu() == false) goto L9;
        if (r6 != r2.getSubMenu()) goto L9;
        return r2;
    L9:
        r1 = r1 + 1;
        goto L3
    L10:
        return null;
    }

    private View findParentViewForSubmenu(CascadingMenuInfo r8, MenuBuilder r9) {
        MenuItem r10 = findMenuItemForSubmenu(r8.menu, r9);
        if (r10 != null) goto L5;
        return null;
    L5:
        ListView r11 = r8.getListView();
        ListAdapter r1 = r11.getAdapter();
        int r3 = 0;
        if ((r1 instanceof HeaderViewListAdapter) == false) goto L8;
        HeaderViewListAdapter r2 = (HeaderViewListAdapter) r1;
        int r4 = r2.getHeadersCount();
        MenuAdapter r5 = (MenuAdapter) r2.getWrappedAdapter();
    L9:
        int r6 = r5.getCount();
    L11:
        if (r3 >= r6) goto L16;
        if (r10 == r5.getItem(r3)) goto L17;
        r3 = r3 + 1;
    L17:
        if (r3 != (-1)) goto L19;
        return null;
    L19:
        int r7 = (r3 + r4) - r11.getFirstVisiblePosition();
        if (r7 >= 0) goto L22;
    L26:
        return null;
    L22:
        if (r7 >= r11.getChildCount()) goto L26;
        return r11.getChildAt(r7);
    L16:
        r3 = -1;
        goto L17
    L8:
        r5 = (MenuAdapter) r1;
        r4 = 0;
        goto L9
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder r6, boolean r7) {
        int r0 = findIndexOfAddedMenu(r6);
        if (r0 >= 0) goto L5;
        return;
    L5:
        int r1 = r0 + 1;
        if (r1 >= this.mShowingMenus.size()) goto L8;
        ((CascadingMenuInfo) ListProtector.get(this.mShowingMenus, r1)).menu.close(false);
    L8:
        CascadingMenuInfo r2 = (CascadingMenuInfo) ListProtector.remove(this.mShowingMenus, r0);
        r2.menu.removeMenuPresenter(this);
        if (this.mShouldCloseImmediately == false) goto L11;
        r2.window.setExitTransition(null);
        r2.window.setAnimationStyle(0);
    L11:
        r2.window.dismiss();
        int r3 = this.mShowingMenus.size();
        if (r3 <= 0) goto L14;
        this.mLastPosition = ((CascadingMenuInfo) ListProtector.get(this.mShowingMenus, r3 - 1)).position;
    L15:
        if (r3 != 0) goto L26;
        dismiss();
        MenuPresenter.Callback r8 = this.mPresenterCallback;
        if (r8 == null) goto L19;
        r8.onCloseMenu(r6, true);
    L19:
        ViewTreeObserver r9 = this.mTreeObserver;
        if (r9 != null) goto L22;
    L25:
        this.mShownAnchorView.removeOnAttachStateChangeListener(this.mAttachStateChangeListener);
        this.mOnDismissListener.onDismiss();
        return;
    L22:
        if (r9.isAlive() == false) goto L24;
        this.mTreeObserver.removeGlobalOnLayoutListener(this.mGlobalLayoutListener);
    L24:
        this.mTreeObserver = null;
        goto L25
    L26:
        if (r7 == false) goto L30;
        ((CascadingMenuInfo) ListProtector.get(this.mShowingMenus, 0)).menu.close(false);
        return;
    L30:
        return;
    L14:
        this.mLastPosition = getInitialMenuPosition();
        goto L15
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View r1, int r2, KeyEvent r3) {
        if (r3.getAction() == 1) goto L5;
        return false;
    L5:
        if (r2 != 82) goto L10;
        dismiss();
        return true;
    L10:
        return false;
    }

    public CascadingMenuPopup(Context r2, View r3, int r4, int r5, boolean r6) {
        this.mPendingMenus = new ArrayList();
        this.mShowingMenus = new ArrayList();
        this.mGlobalLayoutListener = new AnonymousClass1(this);
        this.mAttachStateChangeListener = new AnonymousClass2(this);
        this.mMenuItemHoverListener = new AnonymousClass3(this);
        this.mRawDropDownGravity = 0;
        this.mDropDownGravity = 0;
        this.mContext = r2;
        this.mAnchorView = r3;
        this.mPopupStyleAttr = r4;
        this.mPopupStyleRes = r5;
        this.mOverflowOnly = r6;
        this.mForceShowIcon = false;
        this.mLastPosition = getInitialMenuPosition();
        Resources r7 = r2.getResources();
        this.mMenuMaxWidth = Math.max(INVOKEVIRTUAL_androidx_appcompat_view_menu_CascadingMenuPopup_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r7).widthPixels / 2, r7.getDimensionPixelSize(2131165211));
        this.mSubMenuHoverHandler = new Handler();
    }
}
