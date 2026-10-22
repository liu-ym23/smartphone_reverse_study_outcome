package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.compose.material3.MenuKt;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class ActionMenuView extends LinearLayoutCompat implements MenuBuilder.ItemInvoker, MenuView {
    static final int GENERATED_ITEM_PADDING = 4;
    static final int MIN_CELL_SIZE = 56;
    private static final String TAG = "ActionMenuView";
    private MenuPresenter.Callback mActionMenuPresenterCallback;
    private boolean mFormatItems;
    private int mFormatItemsWidth;
    private int mGeneratedItemPadding;
    private MenuBuilder mMenu;
    MenuBuilder.Callback mMenuBuilderCallback;
    private int mMinCellSize;
    OnMenuItemClickListener mOnMenuItemClickListener;
    private Context mPopupContext;
    private int mPopupTheme;
    private ActionMenuPresenter mPresenter;
    private boolean mReserveOverflow;

    public interface ActionMenuChildView {
        boolean needsDividerAfter();

        boolean needsDividerBefore();
    }

    public static class ActionMenuPresenterCallback implements MenuPresenter.Callback {
        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public void onCloseMenu(MenuBuilder r1, boolean r2) {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(MenuBuilder r1) {
            return false;
        }

        public ActionMenuPresenterCallback() {
        }
    }

    public static class LayoutParams extends LinearLayoutCompat.LayoutParams {

        @ViewDebug.ExportedProperty
        public int cellsUsed;

        @ViewDebug.ExportedProperty
        public boolean expandable;
        boolean expanded;

        @ViewDebug.ExportedProperty
        public int extraPixels;

        @ViewDebug.ExportedProperty
        public boolean isOverflowButton;

        @ViewDebug.ExportedProperty
        public boolean preventEdgeOffset;

        public LayoutParams(LayoutParams r1) {
            super(r1);
            this.isOverflowButton = r1.isOverflowButton;
        }

        public LayoutParams(ViewGroup.LayoutParams r1) {
            super(r1);
        }

        public LayoutParams(int r1, int r2) {
            super(r1, r2);
            this.isOverflowButton = false;
        }

        public LayoutParams(Context r1, AttributeSet r2) {
            super(r1, r2);
        }

        public LayoutParams(int r1, int r2, boolean r3) {
            super(r1, r2);
            this.isOverflowButton = r3;
        }
    }

    public class MenuBuilderCallback implements MenuBuilder.Callback {
        final /* synthetic */ ActionMenuView this$0;

        public MenuBuilderCallback(ActionMenuView r1) {
            this.this$0 = r1;
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public void onMenuModeChange(MenuBuilder r2) {
            MenuBuilder.Callback r0 = this.this$0.mMenuBuilderCallback;
            if (r0 == null) goto L6;
            r0.onMenuModeChange(r2);
            return;
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public boolean onMenuItemSelected(MenuBuilder r1, MenuItem r2) {
            OnMenuItemClickListener r3 = this.this$0.mOnMenuItemClickListener;
            if (r3 != null) goto L5;
        L7:
            return false;
        L5:
            if (r3.onMenuItemClick(r2) == false) goto L7;
            return true;
        }
    }

    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem r1);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent r1) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public int getWindowAnimations() {
        return 0;
    }

    public void dismissPopupMenus() {
        ActionMenuPresenter r0 = this.mPresenter;
        if (r0 == null) goto L6;
        r0.dismissPopupMenus();
        return;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        LayoutParams r0 = new LayoutParams(-2, -2);
        ((LinearLayout.LayoutParams) r0).gravity = 16;
        return r0;
    }

    public Menu getMenu() {
        if (this.mMenu != null) goto L10;
        Context r0 = getContext();
        MenuBuilder r1 = new MenuBuilder(r0);
        this.mMenu = r1;
        r1.setCallback(new MenuBuilderCallback(this));
        ActionMenuPresenter r2 = new ActionMenuPresenter(r0);
        this.mPresenter = r2;
        r2.setReserveOverflow(true);
        ActionMenuPresenter r3 = this.mPresenter;
        MenuPresenter.Callback r4 = this.mActionMenuPresenterCallback;
        if (r4 != null) goto L8;
        r4 = new ActionMenuPresenterCallback();
    L8:
        r3.setCallback(r4);
        this.mMenu.addMenuPresenter(this.mPresenter, this.mPopupContext);
        this.mPresenter.setMenuView(this);
    L10:
        return this.mMenu;
    }

    public boolean hideOverflowMenu() {
        ActionMenuPresenter r0 = this.mPresenter;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.hideOverflowMenu() == false) goto L7;
        return true;
    }

    public boolean isOverflowMenuShowPending() {
        ActionMenuPresenter r0 = this.mPresenter;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isOverflowMenuShowPending() == false) goto L7;
        return true;
    }

    public boolean isOverflowMenuShowing() {
        ActionMenuPresenter r0 = this.mPresenter;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isOverflowMenuShowing() == false) goto L7;
        return true;
    }

    public boolean showOverflowMenu() {
        ActionMenuPresenter r0 = this.mPresenter;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.showOverflowMenu() == false) goto L7;
        return true;
    }

    public LayoutParams generateOverflowButtonLayoutParams() {
        LayoutParams r0 = generateDefaultLayoutParams();
        r0.isOverflowButton = true;
        return r0;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        return this.mPresenter.getOverflowIcon();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dismissPopupMenus();
    }

    public int getPopupTheme() {
        return this.mPopupTheme;
    }

    public boolean isOverflowReserved() {
        return this.mReserveOverflow;
    }

    public MenuBuilder peekMenu() {
        return this.mMenu;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public /* bridge */ /* synthetic */ LinearLayoutCompat.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    public ActionMenuView(Context r2) {
        this(r2, null);
    }

    public static DisplayMetrics INVOKEVIRTUAL_androidx_appcompat_widget_ActionMenuView_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams r1) {
        return r1 instanceof LayoutParams;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams r2) {
        if (r2 == null) goto L12;
        if ((r2 instanceof LayoutParams) == false) goto L6;
        LayoutParams r0 = new LayoutParams((LayoutParams) r2);
    L8:
        if (((LinearLayout.LayoutParams) r0).gravity > 0) goto L10;
        ((LinearLayout.LayoutParams) r0).gravity = 16;
    L10:
        return r0;
    L6:
        r0 = new LayoutParams(r2);
        goto L8
    L12:
        return generateDefaultLayoutParams();
    }

    public boolean hasSupportDividerBeforeChildAt(int r5) {
        boolean r0 = false;
        if (r5 != 0) goto L5;
        return false;
    L5:
        KeyEvent.Callback r1 = getChildAt(r5 - 1);
        KeyEvent.Callback r2 = getChildAt(r5);
        if (r5 < getChildCount()) goto L8;
    L10:
        if (r5 > 0) goto L12;
        return r0;
    L12:
        if ((r2 instanceof ActionMenuChildView) == true) goto L14;
        return r0;
    L14:
        return r0 | ((ActionMenuChildView) r2).needsDividerBefore();
    L8:
        if ((r1 instanceof ActionMenuChildView) == false) goto L10;
        r0 = false | ((ActionMenuChildView) r1).needsDividerAfter();
        goto L10
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public void initialize(MenuBuilder r1) {
        this.mMenu = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.view.menu.MenuBuilder.ItemInvoker
    public boolean invokeItem(MenuItemImpl r3) {
        return this.mMenu.performItemAction(r3, 0);
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r2) {
        super.onConfigurationChanged(r2);
        ActionMenuPresenter r3 = this.mPresenter;
        if (r3 == null) goto L8;
        r3.updateMenuView(false);
        if (this.mPresenter.isOverflowMenuShowing() == false) goto L9;
        this.mPresenter.hideOverflowMenu();
        this.mPresenter.showOverflowMenu();
        return;
    L9:
        return;
    }

    public void setExpandedActionViewsExclusive(boolean r2) {
        this.mPresenter.setExpandedActionViewsExclusive(r2);
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener r1) {
        this.mOnMenuItemClickListener = r1;
    }

    public void setOverflowIcon(Drawable r2) {
        getMenu();
        this.mPresenter.setOverflowIcon(r2);
    }

    public void setOverflowReserved(boolean r1) {
        this.mReserveOverflow = r1;
    }

    public void setPopupTheme(int r3) {
        if (this.mPopupTheme == r3) goto L9;
        this.mPopupTheme = r3;
        if (r3 != 0) goto L7;
        this.mPopupContext = getContext();
        return;
    L7:
        this.mPopupContext = new ContextThemeWrapper(getContext(), r3);
        return;
    }

    public void setPresenter(ActionMenuPresenter r1) {
        this.mPresenter = r1;
        r1.setMenuView(this);
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet r3) {
        return new LayoutParams(getContext(), r3);
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r1) {
        return generateLayoutParams(r1);
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        return generateLayoutParams(r1);
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public /* bridge */ /* synthetic */ LinearLayoutCompat.LayoutParams generateLayoutParams(AttributeSet r1) {
        return generateLayoutParams(r1);
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public /* bridge */ /* synthetic */ LinearLayoutCompat.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        return generateLayoutParams(r1);
    }

    public ActionMenuView(Context r3, AttributeSet r4) {
        super(r3, r4);
        setBaselineAligned(false);
        float r0 = INVOKEVIRTUAL_androidx_appcompat_widget_ActionMenuView_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r3.getResources()).density;
        this.mMinCellSize = (int) (56.0f * r0);
        this.mGeneratedItemPadding = (int) (r0 * 4.0f);
        this.mPopupContext = r3;
        this.mPopupTheme = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v8 */
    /* JADX WARN: Type inference failed for: r14v9, types: [boolean, int] */
    private void onMeasureExactFormat(int r30, int r31) {
        int r1 = View.MeasureSpec.getMode(r31);
        int r2 = View.MeasureSpec.getSize(r30);
        int r3 = View.MeasureSpec.getSize(r31);
        int r4 = getPaddingLeft() + getPaddingRight();
        int r5 = getPaddingTop() + getPaddingBottom();
        int r6 = ViewGroup.getChildMeasureSpec(r31, r5, -2);
        int r7 = r2 - r4;
        int r8 = this.mMinCellSize;
        int r9 = r7 / r8;
        int r10 = r7 % r8;
        if (r9 != 0) goto L6;
        setMeasuredDimension(r7, 0);
        return;
    L6:
        int r11 = r8 + (r10 / r9);
        int r12 = getChildCount();
        int r13 = 0;
        int r14 = 0;
        boolean r15 = false;
        int r16 = 0;
        int r17 = 0;
        int r18 = 0;
        long r19 = 0;
    L7:
        if (r14 >= r12) goto L37;
        View r110 = getChildAt(r14);
        int r111 = r3;
        if (r110.getVisibility() == 8) goto L36;
        boolean r20 = r110 instanceof ActionMenuItemView;
        int r112 = r16 + 1;
        if (r20 == false) goto L14;
        int r21 = this.mGeneratedItemPadding;
        ?? r113 = 0;
        r110.setPadding(r21, 0, r21, 0);
    L15:
        LayoutParams r22 = (LayoutParams) r110.getLayoutParams();
        r22.expanded = r113;
        r22.extraPixels = r113;
        r22.cellsUsed = r113;
        r22.expandable = r113;
        ((LinearLayout.LayoutParams) r22).leftMargin = r113;
        ((LinearLayout.LayoutParams) r22).rightMargin = r113;
        if (r20 == true) goto L18;
    L20:
        boolean r23 = false;
    L21:
        r22.preventEdgeOffset = r23;
        if (r22.isOverflowButton == false) goto L24;
        int r24 = 1;
    L25:
        int r25 = measureChildForCells(r110, r11, r24, r6, r5);
        r17 = Math.max(r17, r25);
        if (r22.expandable == false) goto L29;
        r18 = r18 + 1;
    L29:
        if (r22.isOverflowButton == false) goto L31;
        r15 = true;
    L31:
        r9 = r9 - r25;
        r13 = Math.max(r13, r110.getMeasuredHeight());
        if (r25 != 1) goto L35;
        r19 = r19 | ((long) (1 << r14));
        r13 = r13;
    L35:
        r16 = r112;
        goto L36
    L24:
        r24 = r9;
        goto L25
    L18:
        if (((ActionMenuItemView) r110).hasText() == false) goto L20;
        r23 = true;
        goto L21
    L14:
        r113 = 0;
    L36:
        r14 = r14 + 1;
        r3 = r111;
        goto L7
    L37:
        int r114 = r3;
        if (r15 == false) goto L41;
        if (r16 != 2) goto L41;
        boolean r26 = true;
    L42:
        boolean r27 = false;
    L43:
        if (r18 <= 0) goto L78;
        if (r9 <= 0) goto L78;
        int r28 = 0;
        int r115 = 0;
        int r116 = Integer.MAX_VALUE;
        long r29 = 0;
    L46:
        if (r115 >= r12) goto L57;
        boolean r210 = r27;
        LayoutParams r32 = (LayoutParams) getChildAt(r115).getLayoutParams();
        int r211 = r13;
        if (r32.expandable == false) goto L56;
        int r33 = r32.cellsUsed;
        if (r33 >= r116) goto L54;
        r29 = 1 << r115;
        r116 = r33;
        r28 = 1;
        goto L56
    L54:
        if (r33 != r116) goto L56;
        r28 = r28 + 1;
        r29 = r29 | (1 << r115);
    L56:
        r115 = r115 + 1;
        r13 = r211;
        r27 = r210;
        goto L46
    L57:
        boolean r212 = r27;
        int r213 = r13;
        r19 = r19 | r29;
        if (r28 > r9) goto L80;
        int r117 = r116 + 1;
        int r34 = 0;
    L61:
        if (r34 >= r12) goto L77;
        View r35 = getChildAt(r34);
        LayoutParams r118 = (LayoutParams) r35.getLayoutParams();
        int r214 = r7;
        int r119 = r1;
        long r36 = 1 << r34;
        if ((r29 & r36) == 0) goto L65;
        if (r26 == false) goto L75;
        if (r118.preventEdgeOffset == false) goto L75;
        if (r9 != 1) goto L75;
        int r37 = this.mGeneratedItemPadding;
        r35.setPadding(r37 + r11, 0, r37, 0);
    L75:
        r118.cellsUsed++;
        r118.expanded = true;
        r9 = r9 - 1;
    L76:
        r34 = r34 + 1;
        r1 = r119;
        r7 = r214;
        r26 = r26;
        goto L61
    L65:
        if (r118.cellsUsed != r117) goto L67;
        r19 = r19 | r36;
    L67:
        r26 = r26;
        goto L76
    L77:
        r13 = r213;
        r27 = true;
    L80:
        if (r15 == true) goto L83;
        if (r16 != 1) goto L83;
        boolean r38 = true;
    L84:
        if (r9 > 0) goto L86;
    L133:
        boolean r39 = r212;
    L135:
        if (r39 == false) goto L143;
        int r40 = 0;
    L137:
        if (r40 >= r12) goto L143;
        View r41 = getChildAt(r40);
        LayoutParams r42 = (LayoutParams) r41.getLayoutParams();
        if (r42.expanded == false) goto L142;
        r41.measure(View.MeasureSpec.makeMeasureSpec((r42.cellsUsed * r11) + r42.extraPixels, 1073741824), r6);
    L142:
        r40 = r40 + 1;
    L143:
        if (r1 == 1073741824) goto L145;
        int r43 = r213;
    L146:
        setMeasuredDimension(r7, r43);
        return;
    L145:
        r43 = r114;
        goto L146
    L86:
        if (r19 == 0) goto L133;
        if (r9 < (r16 - 1)) goto L91;
        if (r38 == true) goto L91;
        if (r17 <= 1) goto L133;
    L91:
        float r44 = Long.bitCount(r19);
        if (r38 == true) goto L105;
        if ((r19 & 1) != 0) goto L96;
    L98:
        int r45 = r12 - 1;
        if ((r19 & ((long) (1 << r45))) == 0) goto L105;
        if (((LayoutParams) getChildAt(r45).getLayoutParams()).preventEdgeOffset == true) goto L105;
        r44 = r44 - 0.5f;
        goto L105
    L96:
        if (((LayoutParams) getChildAt(0).getLayoutParams()).preventEdgeOffset == true) goto L98;
        r44 = r44 - 0.5f;
    L105:
        if (r44 <= MenuKt.ClosedAlphaTarget) goto L107;
        int r46 = (int) ((r9 * r11) / r44);
    L108:
        r39 = r212;
        int r47 = 0;
    L109:
        if (r47 >= r12) goto L135;
        if ((r19 & ((long) (1 << r47))) == 0) goto L132;
        View r48 = getChildAt(r47);
        LayoutParams r49 = (LayoutParams) r48.getLayoutParams();
        if ((r48 instanceof ActionMenuItemView) == false) goto L123;
        r49.extraPixels = r46;
        r49.expanded = true;
        if (r47 != 0) goto L125;
        if (r49.preventEdgeOffset == true) goto L125;
        ((LinearLayout.LayoutParams) r49).leftMargin = (-r46) / 2;
    L125:
        r39 = true;
        goto L132
    L123:
        if (r49.isOverflowButton == false) goto L127;
        r49.extraPixels = r46;
        r49.expanded = true;
        ((LinearLayout.LayoutParams) r49).rightMargin = (-r46) / 2;
        goto L125
    L127:
        if (r47 == 0) goto L130;
        ((LinearLayout.LayoutParams) r49).leftMargin = r46 / 2;
    L130:
        if (r47 == (r12 - 1)) goto L132;
        ((LinearLayout.LayoutParams) r49).rightMargin = r46 / 2;
    L132:
        r47 = r47 + 1;
        goto L109
    L107:
        r46 = 0;
    L83:
        r38 = false;
    L78:
        r212 = r27;
        r213 = r13;
    L41:
        r26 = false;
        goto L42
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public void onMeasure(int r6, int r7) {
        boolean r0 = this.mFormatItems;
        if (View.MeasureSpec.getMode(r6) != 1073741824) goto L5;
        boolean r1 = true;
    L6:
        this.mFormatItems = r1;
        if (r0 == r1) goto L9;
        this.mFormatItemsWidth = 0;
    L9:
        int r2 = View.MeasureSpec.getSize(r6);
        if (this.mFormatItems == false) goto L16;
        MenuBuilder r3 = this.mMenu;
        if (r3 == null) goto L16;
        if (r2 == this.mFormatItemsWidth) goto L16;
        this.mFormatItemsWidth = r2;
        r3.onItemsChanged(true);
    L16:
        int r4 = getChildCount();
        if (this.mFormatItems == false) goto L20;
        if (r4 <= 0) goto L20;
        onMeasureExactFormat(r6, r7);
        return;
    L20:
        int r5 = 0;
    L21:
        if (r5 >= r4) goto L23;
        LayoutParams r8 = (LayoutParams) getChildAt(r5).getLayoutParams();
        ((LinearLayout.LayoutParams) r8).rightMargin = 0;
        ((LinearLayout.LayoutParams) r8).leftMargin = 0;
        r5 = r5 + 1;
        goto L21
    L23:
        super.onMeasure(r6, r7);
        return;
    L5:
        r1 = false;
        goto L6
    }

    public void setMenuCallbacks(MenuPresenter.Callback r1, MenuBuilder.Callback r2) {
        this.mActionMenuPresenterCallback = r1;
        this.mMenuBuilderCallback = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int measureChildForCells(View r5, int r6, int r7, int r8, int r9) {
        LayoutParams r0 = (LayoutParams) r5.getLayoutParams();
        int r10 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(r8) - r9, View.MeasureSpec.getMode(r8));
        if ((r5 instanceof ActionMenuItemView) == false) goto L5;
        ActionMenuItemView r11 = (ActionMenuItemView) r5;
    L6:
        boolean r1 = true;
        if (r11 != null) goto L9;
    L11:
        boolean r12 = false;
    L12:
        if (r7 <= 0) goto L23;
        int r3 = 2;
        if (r12 == false) goto L16;
        if (r7 < 2) goto L23;
    L16:
        r5.measure(View.MeasureSpec.makeMeasureSpec(r7 * r6, RtlSpacingHelper.UNDEFINED), r10);
        int r13 = r5.getMeasuredWidth();
        int r4 = r13 / r6;
        if ((r13 % r6) == 0) goto L19;
        r4 = r4 + 1;
    L19:
        if (r12 == false) goto L22;
        if (r4 >= 2) goto L22;
    L25:
        if (r0.isOverflowButton == true) goto L28;
        if (r12 == false) goto L28;
    L29:
        r0.expandable = r1;
        r0.cellsUsed = r3;
        r5.measure(View.MeasureSpec.makeMeasureSpec(r6 * r3, 1073741824), r10);
        return r3;
    L28:
        r1 = false;
    L22:
        r3 = r4;
    L23:
        r3 = 0;
        goto L25
    L9:
        if (r11.hasText() == false) goto L11;
        r12 = true;
        goto L12
    L5:
        r11 = null;
        goto L6
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r18, int r19, int r20, int r21, int r22) {
        if (this.mFormatItems == true) goto L6;
        super.onLayout(r18, r19, r20, r21, r22);
        return;
    L6:
        int r1 = getChildCount();
        int r2 = (r22 - r20) / 2;
        int r3 = getDividerWidth();
        int r4 = r21 - r19;
        int r5 = (r4 - getPaddingRight()) - getPaddingLeft();
        boolean r6 = ViewUtils.isLayoutRtl(this);
        int r8 = 0;
        int r9 = 0;
        int r10 = 0;
    L8:
        if (r8 >= r1) goto L24;
        View r13 = getChildAt(r8);
        if (r13.getVisibility() == 8) goto L23;
        LayoutParams r11 = (LayoutParams) r13.getLayoutParams();
        if (r11.isOverflowButton == false) goto L22;
        int r12 = r13.getMeasuredWidth();
        if (hasSupportDividerBeforeChildAt(r8) == false) goto L17;
        r12 = r12 + r3;
    L17:
        int r14 = r13.getMeasuredHeight();
        if (r6 == false) goto L20;
        int r15 = getPaddingLeft() + ((LinearLayout.LayoutParams) r11).leftMargin;
        int r16 = r15 + r12;
    L21:
        int r7 = r2 - (r14 / 2);
        r13.layout(r15, r7, r16, r14 + r7);
        r5 = r5 - r12;
        r9 = 1;
        goto L23
    L20:
        r16 = (getWidth() - getPaddingRight()) - ((LinearLayout.LayoutParams) r11).rightMargin;
        r15 = r16 - r12;
        goto L21
    L22:
        r5 = r5 - ((r13.getMeasuredWidth() + ((LinearLayout.LayoutParams) r11).leftMargin) + ((LinearLayout.LayoutParams) r11).rightMargin);
        hasSupportDividerBeforeChildAt(r8);
        r10 = r10 + 1;
    L23:
        r8 = r8 + 1;
        goto L8
    L24:
        if (r1 != 1) goto L28;
        if (r9 != 0) goto L28;
        View r17 = getChildAt(0);
        int r23 = r17.getMeasuredWidth();
        int r24 = r17.getMeasuredHeight();
        int r25 = (r4 / 2) - (r23 / 2);
        int r26 = r2 - (r24 / 2);
        r17.layout(r25, r26, r23 + r25, r24 + r26);
        return;
    L28:
        int r110 = r10 - (r9 ^ 1);
        if (r110 <= 0) goto L31;
        int r27 = r5 / r110;
    L32:
        int r28 = Math.max(0, r27);
        if (r6 == false) goto L43;
        int r29 = getWidth() - getPaddingRight();
        int r30 = 0;
    L35:
        if (r30 >= r1) goto L52;
        View r31 = getChildAt(r30);
        LayoutParams r32 = (LayoutParams) r31.getLayoutParams();
        if (r31.getVisibility() == 8) goto L42;
        if (r32.isOverflowButton == true) goto L42;
        int r33 = r29 - ((LinearLayout.LayoutParams) r32).rightMargin;
        int r34 = r31.getMeasuredWidth();
        int r35 = r31.getMeasuredHeight();
        int r111 = r2 - (r35 / 2);
        r31.layout(r33 - r34, r111, r33, r35 + r111);
        r29 = r33 - ((r34 + ((LinearLayout.LayoutParams) r32).leftMargin) + r28);
    L42:
        r30 = r30 + 1;
        goto L35
    L52:
        return;
    L43:
        int r36 = getPaddingLeft();
        int r37 = 0;
    L44:
        if (r37 >= r1) goto L65;
        View r38 = getChildAt(r37);
        LayoutParams r39 = (LayoutParams) r38.getLayoutParams();
        if (r38.getVisibility() == 8) goto L51;
        if (r39.isOverflowButton == true) goto L51;
        int r40 = r36 + ((LinearLayout.LayoutParams) r39).leftMargin;
        int r41 = r38.getMeasuredWidth();
        int r42 = r38.getMeasuredHeight();
        int r112 = r2 - (r42 / 2);
        r38.layout(r40, r112, r40 + r41, r42 + r112);
        r36 = r40 + ((r41 + ((LinearLayout.LayoutParams) r39).rightMargin) + r28);
    L51:
        r37 = r37 + 1;
        goto L44
    L65:
        return;
    L31:
        r27 = 0;
        goto L32
    }
}
