package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.ActionBarPolicy;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.BaseMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ActionProvider;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
class ActionMenuPresenter extends BaseMenuPresenter implements ActionProvider.SubUiVisibilityListener {
    private static final String TAG = "ActionMenuPresenter";
    private final SparseBooleanArray mActionButtonGroups;
    ActionButtonSubmenu mActionButtonPopup;
    private int mActionItemWidthLimit;
    private boolean mExpandedActionViewsExclusive;
    private int mMaxItems;
    private boolean mMaxItemsSet;
    private int mMinCellSize;
    int mOpenSubMenuId;
    OverflowMenuButton mOverflowButton;
    OverflowPopup mOverflowPopup;
    private Drawable mPendingOverflowIcon;
    private boolean mPendingOverflowIconSet;
    private ActionMenuPopupCallback mPopupCallback;
    final PopupPresenterCallback mPopupPresenterCallback;
    OpenOverflowRunnable mPostedOpenRunnable;
    private boolean mReserveOverflow;
    private boolean mReserveOverflowSet;
    private boolean mStrictWidthLimit;
    private int mWidthLimit;
    private boolean mWidthLimitSet;

    public class ActionButtonSubmenu extends MenuPopupHelper {
        final /* synthetic */ ActionMenuPresenter this$0;

        @Override // androidx.appcompat.view.menu.MenuPopupHelper
        public void onDismiss() {
            ActionMenuPresenter r0 = this.this$0;
            r0.mActionButtonPopup = null;
            r0.mOpenSubMenuId = 0;
            super.onDismiss();
        }

        public ActionButtonSubmenu(ActionMenuPresenter r7, Context r8, SubMenuBuilder r9, View r10) {
            this.this$0 = r7;
            super(r8, r9, r10, false, 2130968742);
            if (((MenuItemImpl) r9.getItem()).isActionButton() == true) goto L8;
            AppCompatImageView r11 = r7.mOverflowButton;
            if (r11 != null) goto L7;
            r11 = (View) ActionMenuPresenter.access$200(r7);
        L7:
            setAnchorView(r11);
        L8:
            setPresenterCallback(r7.mPopupPresenterCallback);
        }
    }

    public class ActionMenuPopupCallback extends ActionMenuItemView.PopupCallback {
        final /* synthetic */ ActionMenuPresenter this$0;

        @Override // androidx.appcompat.view.menu.ActionMenuItemView.PopupCallback
        public ShowableListMenu getPopup() {
            ActionButtonSubmenu r0 = this.this$0.mActionButtonPopup;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.getPopup();
        }

        public ActionMenuPopupCallback(ActionMenuPresenter r1) {
            this.this$0 = r1;
        }
    }

    public class OpenOverflowRunnable implements Runnable {
        private OverflowPopup mPopup;
        final /* synthetic */ ActionMenuPresenter this$0;

        @Override // java.lang.Runnable
        public void run() {
            androidx_appcompat_widget_ActionMenuPresenter$OpenOverflowRunnable_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void androidx_appcompat_widget_ActionMenuPresenter$OpenOverflowRunnable__run$___twin___() {
            if (ActionMenuPresenter.access$400(this.this$0) == null) goto L5;
            ActionMenuPresenter.access$500(this.this$0).changeMenuMode();
        L5:
            View r0 = (View) ActionMenuPresenter.access$600(this.this$0);
            if (r0 != null) goto L8;
        L12:
            this.this$0.mPostedOpenRunnable = null;
            return;
        L8:
            if (r0.getWindowToken() == null) goto L12;
            if (this.mPopup.tryShow() == false) goto L12;
            ActionMenuPresenter r1 = this.this$0;
            r1.mOverflowPopup = this.mPopup;
            goto L12
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void androidx_appcompat_widget_ActionMenuPresenter$OpenOverflowRunnable_com_larus_apm_impl_protector_RunnableLancet_run(OpenOverflowRunnable r1) {
            r1.androidx_appcompat_widget_ActionMenuPresenter$OpenOverflowRunnable__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public OpenOverflowRunnable(ActionMenuPresenter r1, OverflowPopup r2) {
            this.this$0 = r1;
            this.mPopup = r2;
        }
    }

    public class OverflowMenuButton extends AppCompatImageView implements ActionMenuView.ActionMenuChildView {
        final /* synthetic */ ActionMenuPresenter this$0;

        @Override // androidx.appcompat.widget.ActionMenuView.ActionMenuChildView
        public boolean needsDividerAfter() {
            return false;
        }

        @Override // androidx.appcompat.widget.ActionMenuView.ActionMenuChildView
        public boolean needsDividerBefore() {
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public boolean performClick() {
            if (super/*android.widget.ImageView*/.performClick() == false) goto L5;
            return true;
        L5:
            playSoundEffect(0);
            this.this$0.showOverflowMenu();
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public OverflowMenuButton(final ActionMenuPresenter r3, Context r4) {
            this.this$0 = r3;
            super(r4, null, 2130968741);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            TooltipCompat.setTooltipText(this, getContentDescription());
            setOnTouchListener(new AnonymousClass1(this, this, r3));
        }

        /* JADX WARN: Multi-variable type inference failed */
        public boolean setFrame(int r5, int r6, int r7, int r8) {
            boolean r9 = super/*android.widget.ImageView*/.setFrame(r5, r6, r7, r8);
            Drawable r10 = getDrawable();
            Drawable r11 = getBackground();
            if (r10 == null) goto L6;
            if (r11 == null) goto L6;
            int r12 = getWidth();
            int r13 = getHeight();
            int r0 = Math.max(r12, r13) / 2;
            int r1 = getPaddingLeft() - getPaddingRight();
            int r14 = (r12 + r1) / 2;
            int r15 = (r13 + (getPaddingTop() - getPaddingBottom())) / 2;
            DrawableCompat.setHotspotBounds(r11, r14 - r0, r15 - r0, r14 + r0, r15 + r0);
        L6:
            return r9;
        }
    }

    public class OverflowPopup extends MenuPopupHelper {
        final /* synthetic */ ActionMenuPresenter this$0;

        @Override // androidx.appcompat.view.menu.MenuPopupHelper
        public void onDismiss() {
            if (ActionMenuPresenter.access$000(this.this$0) == null) goto L5;
            ActionMenuPresenter.access$100(this.this$0).close();
        L5:
            this.this$0.mOverflowPopup = null;
            super.onDismiss();
        }

        public OverflowPopup(ActionMenuPresenter r7, Context r8, MenuBuilder r9, View r10, boolean r11) {
            this.this$0 = r7;
            super(r8, r9, r10, r11, 2130968742);
            setGravity(8388613);
            setPresenterCallback(r7.mPopupPresenterCallback);
        }
    }

    public class PopupPresenterCallback implements MenuPresenter.Callback {
        final /* synthetic */ ActionMenuPresenter this$0;

        public PopupPresenterCallback(ActionMenuPresenter r1) {
            this.this$0 = r1;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(MenuBuilder r4) {
            if (r4 != ActionMenuPresenter.access$300(this.this$0)) goto L5;
            return false;
        L5:
            ActionMenuPresenter r0 = this.this$0;
            r0.mOpenSubMenuId = ((SubMenuBuilder) r4).getItem().getItemId();
            MenuPresenter.Callback r1 = this.this$0.getCallback();
            if (r1 != null) goto L8;
            return false;
        L8:
            return r1.onOpenSubMenu(r4);
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public void onCloseMenu(MenuBuilder r3, boolean r4) {
            if ((r3 instanceof SubMenuBuilder) == false) goto L5;
            r3.getRootMenu().close(false);
        L5:
            MenuPresenter.Callback r0 = this.this$0.getCallback();
            if (r0 == null) goto L9;
            r0.onCloseMenu(r3, r4);
            return;
        }
    }

    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        public int openSubMenuId;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState() {
        }

        public SavedState(Parcel r1) {
            this.openSubMenuId = r1.readInt();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            r1.writeInt(this.openSubMenuId);
        }
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public boolean flagActionItems() {
        ActionMenuPresenter r0 = this;
        MenuBuilder r1 = r0.mMenu;
        View r2 = null;
        int r3 = 0;
        if (r1 == null) goto L5;
        ArrayList<MenuItemImpl> r4 = r1.getVisibleItems();
        int r5 = r4.size();
    L6:
        int r6 = r0.mMaxItems;
        int r7 = r0.mActionItemWidthLimit;
        int r8 = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup r9 = (ViewGroup) r0.mMenuView;
        int r10 = 0;
        boolean r11 = false;
        int r12 = 0;
        int r13 = 0;
    L7:
        if (r10 >= r5) goto L22;
        MenuItemImpl r14 = (MenuItemImpl) ListProtector.get(r4, r10);
        if (r14.requiresActionButton() == false) goto L12;
        r12 = r12 + 1;
    L16:
        if (r0.mExpandedActionViewsExclusive == false) goto L20;
        if (r14.isActionViewExpanded() == false) goto L20;
        r6 = 0;
    L20:
        r10 = r10 + 1;
        goto L7
    L12:
        if (r14.requestsActionButton() == false) goto L14;
        r13 = r13 + 1;
        goto L16
    L14:
        r11 = true;
        goto L16
    L22:
        if (r0.mReserveOverflow == false) goto L27;
        if (r11 == false) goto L25;
    L26:
        r6 = r6 - 1;
        goto L27
    L25:
        if ((r13 + r12) > r6) goto L26;
    L27:
        int r15 = r6 - r12;
        SparseBooleanArray r16 = r0.mActionButtonGroups;
        r16.clear();
        if (r0.mStrictWidthLimit == false) goto L30;
        int r17 = r0.mMinCellSize;
        int r18 = r7 / r17;
        int r19 = r17 + ((r7 % r17) / r18);
    L31:
        int r110 = 0;
        int r111 = 0;
    L32:
        if (r110 >= r5) goto L96;
        MenuItemImpl r112 = (MenuItemImpl) ListProtector.get(r4, r110);
        if (r112.requiresActionButton() == false) goto L48;
        View r113 = r0.getItemView(r112, r2, r9);
        if (r0.mStrictWidthLimit == false) goto L38;
        r18 = r18 - ActionMenuView.measureChildForCells(r113, r19, r18, r8, r3);
    L39:
        int r20 = r113.getMeasuredWidth();
        r7 = r7 - r20;
        if (r111 != 0) goto L42;
        r111 = r20;
    L42:
        int r21 = r112.getGroupId();
        if (r21 == 0) goto L45;
        r16.put(r21, true);
    L45:
        r112.setIsActionButton(true);
    L95:
        r110 = r110 + 1;
        r2 = null;
        r0 = this;
        r5 = r5;
        r3 = 0;
        goto L32
    L38:
        r113.measure(r8, r8);
        goto L39
    L48:
        if (r112.requestsActionButton() == false) goto L94;
        int r22 = r112.getGroupId();
        boolean r114 = r16.get(r22);
        if (r15 > 0) goto L52;
        if (r114 == true) goto L52;
    L57:
        boolean r23 = false;
    L58:
        boolean r115 = r23;
        if (r23 == false) goto L78;
        View r24 = r0.getItemView(r112, null, r9);
        if (r0.mStrictWidthLimit == false) goto L65;
        int r116 = ActionMenuView.measureChildForCells(r24, r19, r18, r8, 0);
        r18 = r18 - r116;
        if (r116 != 0) goto L66;
        r115 = false;
    L66:
        boolean r25 = r115;
        int r26 = r24.getMeasuredWidth();
        r7 = r7 - r26;
        if (r111 != 0) goto L70;
        r111 = r26;
    L70:
        if (r0.mStrictWidthLimit == false) goto L74;
        if (r7 >= 0) goto L75;
    L76:
        boolean r27 = false;
    L77:
        r23 = r25 & r27;
    L75:
        r27 = true;
        goto L77
    L74:
        if ((r7 + r111) <= 0) goto L76;
    L65:
        r24.measure(r8, r8);
    L78:
        if (r23 == false) goto L81;
        if (r22 == 0) goto L81;
        r16.put(r22, true);
    L91:
        if (r23 == false) goto L93;
        r15 = r15 - 1;
    L93:
        r112.setIsActionButton(r23);
    L81:
        if (r114 == false) goto L91;
        r16.put(r22, false);
        int r28 = 0;
    L83:
        if (r28 >= r110) goto L91;
        MenuItemImpl r117 = (MenuItemImpl) ListProtector.get(r4, r28);
        if (r117.getGroupId() != r22) goto L90;
        if (r117.isActionButton() == false) goto L89;
        r15 = r15 + 1;
    L89:
        r117.setIsActionButton(false);
    L90:
        r28 = r28 + 1;
    L52:
        if (r7 <= 0) goto L57;
        if (r0.mStrictWidthLimit == false) goto L56;
        if (r18 <= 0) goto L57;
    L56:
        r23 = true;
        goto L58
    L94:
        r5 = r5;
        r112.setIsActionButton(false);
        goto L95
    L96:
        return true;
    L30:
        r19 = 0;
        r18 = 0;
        goto L31
    L5:
        r4 = null;
        r5 = 0;
        goto L6
    }

    public Drawable getOverflowIcon() {
        AppCompatImageView r0 = this.mOverflowButton;
        if (r0 == null) goto L7;
        return r0.getDrawable();
    L7:
        if (this.mPendingOverflowIconSet == true) goto L9;
        return null;
    L9:
        return this.mPendingOverflowIcon;
    }

    public boolean hideOverflowMenu() {
        OpenOverflowRunnable r0 = this.mPostedOpenRunnable;
        if (r0 == null) goto L8;
        Object r2 = this.mMenuView;
        if (r2 == null) goto L8;
        ((View) r2).removeCallbacks(r0);
        this.mPostedOpenRunnable = null;
        return true;
    L8:
        OverflowPopup r1 = this.mOverflowPopup;
        if (r1 == null) goto L12;
        r1.dismiss();
        return true;
    L12:
        return false;
    }

    public boolean hideSubMenus() {
        ActionButtonSubmenu r0 = this.mActionButtonPopup;
        if (r0 == null) goto L6;
        r0.dismiss();
        return true;
    L6:
        return false;
    }

    public boolean isOverflowMenuShowPending() {
        if (this.mPostedOpenRunnable == null) goto L5;
    L8:
        return true;
    L5:
        if (isOverflowMenuShowing() == true) goto L8;
        return false;
    }

    public boolean isOverflowMenuShowing() {
        OverflowPopup r0 = this.mOverflowPopup;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isShowing() == false) goto L7;
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public Parcelable onSaveInstanceState() {
        SavedState r0 = new SavedState();
        r0.openSubMenuId = this.mOpenSubMenuId;
        return r0;
    }

    public boolean showOverflowMenu() {
        if (this.mReserveOverflow == true) goto L5;
        return false;
    L5:
        if (isOverflowMenuShowing() == true) goto L18;
        MenuBuilder r0 = this.mMenu;
        if (r0 != null) goto L9;
        return false;
    L9:
        if (this.mMenuView != null) goto L11;
        return false;
    L11:
        if (this.mPostedOpenRunnable == null) goto L13;
        return false;
    L13:
        if (r0.getNonActionItems().isEmpty() == true) goto L22;
        OpenOverflowRunnable r1 = new OpenOverflowRunnable(this, new OverflowPopup(this, this.mContext, this.mMenu, this.mOverflowButton, true));
        this.mPostedOpenRunnable = r1;
        ((View) this.mMenuView).post(r1);
        return true;
    L22:
        return false;
    L18:
        return false;
    }

    public boolean dismissPopupMenus() {
        return hideOverflowMenu() | hideSubMenus();
    }

    public boolean isOverflowReserved() {
        return this.mReserveOverflow;
    }

    public ActionMenuPresenter(Context r3) {
        super(r3, 2131558409, 2131558408);
        this.mActionButtonGroups = new SparseBooleanArray();
        this.mPopupPresenterCallback = new PopupPresenterCallback(this);
    }

    public static DisplayMetrics INVOKEVIRTUAL_androidx_appcompat_widget_ActionMenuPresenter_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    public static /* synthetic */ MenuBuilder access$000(ActionMenuPresenter r0) {
        return r0.mMenu;
    }

    public static /* synthetic */ MenuBuilder access$100(ActionMenuPresenter r0) {
        return r0.mMenu;
    }

    public static /* synthetic */ MenuView access$200(ActionMenuPresenter r0) {
        return r0.mMenuView;
    }

    public static /* synthetic */ MenuBuilder access$300(ActionMenuPresenter r0) {
        return r0.mMenu;
    }

    public static /* synthetic */ MenuBuilder access$400(ActionMenuPresenter r0) {
        return r0.mMenu;
    }

    public static /* synthetic */ MenuBuilder access$500(ActionMenuPresenter r0) {
        return r0.mMenu;
    }

    public static /* synthetic */ MenuView access$600(ActionMenuPresenter r0) {
        return r0.mMenuView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private View findViewForItem(MenuItem r7) {
        ViewGroup r0 = (ViewGroup) this.mMenuView;
        if (r0 != null) goto L5;
        return null;
    L5:
        int r2 = r0.getChildCount();
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L13;
        View r4 = r0.getChildAt(r3);
        if ((r4 instanceof MenuView.ItemView) == false) goto L12;
        if (((MenuView.ItemView) r4).getItemData() != r7) goto L12;
        return r4;
    L12:
        r3 = r3 + 1;
        goto L6
    L13:
        return null;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public MenuView getMenuView(ViewGroup r2) {
        MenuView r0 = this.mMenuView;
        MenuView r3 = super.getMenuView(r2);
        if (r0 == r3) goto L5;
        ((ActionMenuView) r3).setPresenter(this);
    L5:
        return r3;
    }

    public void onConfigurationChanged(Configuration r2) {
        if (this.mMaxItemsSet == true) goto L5;
        this.mMaxItems = ActionBarPolicy.get(this.mContext).getMaxActionButtons();
    L5:
        MenuBuilder r3 = this.mMenu;
        if (r3 == null) goto L9;
        r3.onItemsChanged(true);
        return;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onRestoreInstanceState(Parcelable r2) {
        if ((r2 instanceof SavedState) == true) goto L5;
        return;
    L5:
        int r3 = ((SavedState) r2).openSubMenuId;
        if (r3 <= 0) goto L11;
        MenuItem r4 = this.mMenu.findItem(r3);
        if (r4 == null) goto L12;
        onSubMenuSelected((SubMenuBuilder) r4.getSubMenu());
        return;
    L12:
        return;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public boolean onSubMenuSelected(SubMenuBuilder r8) {
        boolean r1 = false;
        if (r8.hasVisibleItems() == true) goto L5;
        return false;
    L5:
        SubMenuBuilder r0 = r8;
    L7:
        if (r0.getParentMenu() == this.mMenu) goto L9;
        r0 = (SubMenuBuilder) r0.getParentMenu();
        goto L7
    L9:
        View r2 = findViewForItem(r0.getItem());
        if (r2 != null) goto L12;
        return false;
    L12:
        this.mOpenSubMenuId = r8.getItem().getItemId();
        int r3 = r8.size();
        int r4 = 0;
    L14:
        if (r4 >= r3) goto L21;
        MenuItem r5 = r8.getItem(r4);
        if (r5.isVisible() == false) goto L20;
        if (r5.getIcon() == null) goto L20;
        r1 = true;
    L20:
        r4 = r4 + 1;
    L21:
        ActionButtonSubmenu r6 = new ActionButtonSubmenu(this, this.mContext, r8, r2);
        this.mActionButtonPopup = r6;
        r6.setForceShowIcon(r1);
        this.mActionButtonPopup.show();
        super.onSubMenuSelected(r8);
        return true;
    }

    public void onSubUiVisibilityChanged(boolean r2) {
        if (r2 == false) goto L4;
        super.onSubMenuSelected(null);
        return;
    L4:
        MenuBuilder r3 = this.mMenu;
        if (r3 == null) goto L9;
        r3.close(false);
        return;
    }

    public void setExpandedActionViewsExclusive(boolean r1) {
        this.mExpandedActionViewsExclusive = r1;
    }

    public void setItemLimit(int r1) {
        this.mMaxItems = r1;
        this.mMaxItemsSet = true;
    }

    public void setMenuView(ActionMenuView r2) {
        this.mMenuView = r2;
        r2.initialize(this.mMenu);
    }

    public void setOverflowIcon(Drawable r2) {
        OverflowMenuButton r0 = this.mOverflowButton;
        if (r0 == null) goto L5;
        r0.setImageDrawable(r2);
        return;
    L5:
        this.mPendingOverflowIconSet = true;
        this.mPendingOverflowIcon = r2;
    }

    public void setReserveOverflow(boolean r1) {
        this.mReserveOverflow = r1;
        this.mReserveOverflowSet = true;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean r5) {
        super.updateMenuView(r5);
        ((View) this.mMenuView).requestLayout();
        MenuBuilder r6 = this.mMenu;
        boolean r0 = false;
        if (r6 == null) goto L10;
        ArrayList<MenuItemImpl> r7 = r6.getActionItems();
        int r1 = r7.size();
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L10;
        ActionProvider r3 = ((MenuItemImpl) ListProtector.get(r7, r2)).getSupportActionProvider();
        if (r3 == null) goto L9;
        r3.setSubUiVisibilityListener(this);
    L9:
        r2 = r2 + 1;
    L10:
        MenuBuilder r8 = this.mMenu;
        if (r8 == null) goto L13;
        ArrayList<MenuItemImpl> r9 = r8.getNonActionItems();
    L15:
        if (this.mReserveOverflow == false) goto L22;
        if (r9 == null) goto L22;
        int r4 = r9.size();
        if (r4 != 1) goto L20;
        r0 = !((MenuItemImpl) ListProtector.get(r9, 0)).isActionViewExpanded();
        goto L22
    L20:
        if (r4 <= 0) goto L22;
        r0 = true;
    L22:
        if (r0 == true) goto L24;
        AppCompatImageView r10 = this.mOverflowButton;
        if (r10 == null) goto L36;
        Object r11 = r10.getParent();
        Object r12 = this.mMenuView;
        if (r11 != r12) goto L36;
        ((ViewGroup) r12).removeView(this.mOverflowButton);
    L36:
        ((ActionMenuView) this.mMenuView).setOverflowReserved(this.mReserveOverflow);
        return;
    L24:
        if (this.mOverflowButton != null) goto L26;
        this.mOverflowButton = new OverflowMenuButton(this, this.mSystemContext);
    L26:
        ViewGroup r13 = (ViewGroup) this.mOverflowButton.getParent();
        if (r13 == this.mMenuView) goto L36;
        if (r13 == null) goto L30;
        r13.removeView(this.mOverflowButton);
    L30:
        ActionMenuView r14 = (ActionMenuView) this.mMenuView;
        r14.addView(this.mOverflowButton, r14.generateOverflowButtonLayoutParams());
        goto L36
    L13:
        r9 = null;
        goto L15
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter
    public void bindItemView(MenuItemImpl r2, MenuView.ItemView r3) {
        r3.initialize(r2, 0);
        ActionMenuItemView r4 = (ActionMenuItemView) r3;
        r4.setItemInvoker((ActionMenuView) this.mMenuView);
        if (this.mPopupCallback != null) goto L5;
        this.mPopupCallback = new ActionMenuPopupCallback(this);
    L5:
        r4.setPopupCallback(this.mPopupCallback);
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter
    public boolean filterLeftoverView(ViewGroup r3, int r4) {
        if (r3.getChildAt(r4) != this.mOverflowButton) goto L7;
        return false;
    L7:
        return super.filterLeftoverView(r3, r4);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public void initForMenu(Context r5, MenuBuilder r6) {
        super.initForMenu(r5, r6);
        Resources r7 = r5.getResources();
        ActionBarPolicy r8 = ActionBarPolicy.get(r5);
        if (this.mReserveOverflowSet == true) goto L6;
        this.mReserveOverflow = r8.showsOverflowMenuButton();
    L6:
        if (this.mWidthLimitSet == true) goto L9;
        this.mWidthLimit = r8.getEmbeddedMenuWidthLimit();
    L9:
        if (this.mMaxItemsSet == true) goto L11;
        this.mMaxItems = r8.getMaxActionButtons();
    L11:
        int r9 = this.mWidthLimit;
        if (this.mReserveOverflow == true) goto L14;
        this.mOverflowButton = null;
    L21:
        this.mActionItemWidthLimit = r9;
        this.mMinCellSize = (int) (INVOKEVIRTUAL_androidx_appcompat_widget_ActionMenuPresenter_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r7).density * 56.0f);
        return;
    L14:
        if (this.mOverflowButton != null) goto L19;
        OverflowMenuButton r0 = new OverflowMenuButton(this, this.mSystemContext);
        this.mOverflowButton = r0;
        if (this.mPendingOverflowIconSet == false) goto L18;
        r0.setImageDrawable(this.mPendingOverflowIcon);
        this.mPendingOverflowIcon = null;
        this.mPendingOverflowIconSet = false;
    L18:
        int r1 = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.mOverflowButton.measure(r1, r1);
    L19:
        r9 = r9 - this.mOverflowButton.getMeasuredWidth();
        goto L21
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder r1, boolean r2) {
        dismissPopupMenus();
        super.onCloseMenu(r1, r2);
    }

    public void setWidthLimit(int r1, boolean r2) {
        this.mWidthLimit = r1;
        this.mStrictWidthLimit = r2;
        this.mWidthLimitSet = true;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter
    public boolean shouldIncludeItem(int r1, MenuItemImpl r2) {
        return r2.isActionButton();
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter
    public View getItemView(MenuItemImpl r3, View r4, ViewGroup r5) {
        View r0 = r3.getActionView();
        if (r0 != null) goto L5;
    L6:
        r0 = super.getItemView(r3, r4, r5);
    L8:
        if (r3.isActionViewExpanded() == false) goto L10;
        int r6 = 8;
    L11:
        r0.setVisibility(r6);
        ActionMenuView r7 = (ActionMenuView) r5;
        ViewGroup.LayoutParams r8 = r0.getLayoutParams();
        if (r7.checkLayoutParams(r8) == true) goto L14;
        r0.setLayoutParams(r7.generateLayoutParams(r8));
    L14:
        return r0;
    L10:
        r6 = 0;
        goto L11
    L5:
        if (r3.hasCollapsibleActionView() == false) goto L8;
        goto L6
    }
}
