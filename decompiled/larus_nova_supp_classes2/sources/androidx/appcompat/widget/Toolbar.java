package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.CollapsibleActionView;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.GravityCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class Toolbar extends ViewGroup {
    private static final String TAG = "Toolbar";
    private MenuPresenter.Callback mActionMenuPresenterCallback;
    int mButtonGravity;
    ImageButton mCollapseButtonView;
    private CharSequence mCollapseDescription;
    private Drawable mCollapseIcon;
    private boolean mCollapsible;
    private int mContentInsetEndWithActions;
    private int mContentInsetStartWithNavigation;
    private RtlSpacingHelper mContentInsets;
    private boolean mEatingHover;
    private boolean mEatingTouch;
    View mExpandedActionView;
    private ExpandedActionViewMenuPresenter mExpandedMenuPresenter;
    private int mGravity;
    private final ArrayList<View> mHiddenViews;
    private ImageView mLogoView;
    private int mMaxButtonHeight;
    private MenuBuilder.Callback mMenuBuilderCallback;
    private ActionMenuView mMenuView;
    private final ActionMenuView.OnMenuItemClickListener mMenuViewItemClickListener;
    private ImageButton mNavButtonView;
    OnMenuItemClickListener mOnMenuItemClickListener;
    private ActionMenuPresenter mOuterActionMenuPresenter;
    private Context mPopupContext;
    private int mPopupTheme;
    private final Runnable mShowOverflowMenuRunnable;
    private CharSequence mSubtitleText;
    private int mSubtitleTextAppearance;
    private ColorStateList mSubtitleTextColor;
    private TextView mSubtitleTextView;
    private final int[] mTempMargins;
    private final ArrayList<View> mTempViews;
    private int mTitleMarginBottom;
    private int mTitleMarginEnd;
    private int mTitleMarginStart;
    private int mTitleMarginTop;
    private CharSequence mTitleText;
    private int mTitleTextAppearance;
    private ColorStateList mTitleTextColor;
    private TextView mTitleTextView;
    private ToolbarWidgetWrapper mWrapper;

    public class ExpandedActionViewMenuPresenter implements MenuPresenter {
        MenuItemImpl mCurrentExpandedItem;
        MenuBuilder mMenu;
        final /* synthetic */ Toolbar this$0;

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public boolean flagActionItems() {
            return false;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public int getId() {
            return 0;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public MenuView getMenuView(ViewGroup r1) {
            return null;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public void onCloseMenu(MenuBuilder r1, boolean r2) {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public void onRestoreInstanceState(Parcelable r1) {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public Parcelable onSaveInstanceState() {
            return null;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public boolean onSubMenuSelected(SubMenuBuilder r1) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public void setCallback(MenuPresenter.Callback r1) {
        }

        public ExpandedActionViewMenuPresenter(Toolbar r1) {
            this.this$0 = r1;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public void updateMenuView(boolean r5) {
            if (this.mCurrentExpandedItem == null) goto L17;
            MenuBuilder r6 = this.mMenu;
            boolean r0 = false;
            if (r6 == null) goto L12;
            int r7 = r6.size();
            int r1 = 0;
        L7:
            if (r1 >= r7) goto L12;
            if (this.mMenu.getItem(r1) == this.mCurrentExpandedItem) goto L10;
            r1 = r1 + 1;
            goto L7
        L10:
            r0 = true;
        L12:
            if (r0 == true) goto L18;
            collapseItemActionView(this.mMenu, this.mCurrentExpandedItem);
            return;
        L18:
            return;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public boolean collapseItemActionView(MenuBuilder r2, MenuItemImpl r3) {
            KeyEvent.Callback r4 = this.this$0.mExpandedActionView;
            if ((r4 instanceof CollapsibleActionView) == false) goto L5;
            ((CollapsibleActionView) r4).onActionViewCollapsed();
        L5:
            Toolbar r5 = this.this$0;
            r5.removeView(r5.mExpandedActionView);
            Toolbar r6 = this.this$0;
            r6.removeView(r6.mCollapseButtonView);
            Toolbar r7 = this.this$0;
            r7.mExpandedActionView = null;
            r7.addChildrenForExpandedActionView();
            this.mCurrentExpandedItem = null;
            this.this$0.requestLayout();
            r3.setActionViewExpanded(false);
            return true;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public boolean expandItemActionView(MenuBuilder r4, MenuItemImpl r5) {
            this.this$0.ensureCollapseButtonView();
            ViewParent r6 = this.this$0.mCollapseButtonView.getParent();
            Toolbar r0 = this.this$0;
            if (r6 != r0) goto L5;
        L8:
            Toolbar r7 = this.this$0;
            r7.mExpandedActionView = r5.getActionView();
            this.mCurrentExpandedItem = r5;
            ViewParent r8 = this.this$0.mExpandedActionView.getParent();
            Toolbar r1 = this.this$0;
            if (r8 != r1) goto L11;
        L14:
            this.this$0.removeChildrenForExpandedActionView();
            this.this$0.requestLayout();
            r5.setActionViewExpanded(true);
            KeyEvent.Callback r9 = this.this$0.mExpandedActionView;
            if ((r9 instanceof CollapsibleActionView) == false) goto L17;
            ((CollapsibleActionView) r9).onActionViewExpanded();
        L17:
            return true;
        L11:
            if ((r8 instanceof ViewGroup) == false) goto L13;
            ((ViewGroup) r8).removeView(r1.mExpandedActionView);
        L13:
            LayoutParams r10 = this.this$0.generateDefaultLayoutParams();
            Toolbar r2 = this.this$0;
            r10.gravity = (r2.mButtonGravity & 112) | 8388611;
            r10.mViewType = 2;
            r2.mExpandedActionView.setLayoutParams(r10);
            Toolbar r11 = this.this$0;
            r11.addView(r11.mExpandedActionView);
            goto L14
        L5:
            if ((r6 instanceof ViewGroup) == false) goto L7;
            ((ViewGroup) r6).removeView(r0.mCollapseButtonView);
        L7:
            Toolbar r12 = this.this$0;
            r12.addView(r12.mCollapseButtonView);
            goto L8
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public void initForMenu(Context r2, MenuBuilder r3) {
            MenuBuilder r4 = this.mMenu;
            if (r4 == null) goto L7;
            MenuItemImpl r0 = this.mCurrentExpandedItem;
            if (r0 == null) goto L7;
            r4.collapseItemActionView(r0);
        L7:
            this.mMenu = r3;
        }
    }

    public static class LayoutParams extends ActionBar.LayoutParams {
        static final int CUSTOM = 0;
        static final int EXPANDED = 2;
        static final int SYSTEM = 1;
        int mViewType;

        public LayoutParams(LayoutParams r2) {
            super(r2);
            this.mViewType = 0;
            this.mViewType = r2.mViewType;
        }

        public void copyMarginsFromCompat(ViewGroup.MarginLayoutParams r2) {
            ((ViewGroup.MarginLayoutParams) this).leftMargin = r2.leftMargin;
            ((ViewGroup.MarginLayoutParams) this).topMargin = r2.topMargin;
            ((ViewGroup.MarginLayoutParams) this).rightMargin = r2.rightMargin;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = r2.bottomMargin;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r2) {
            super(r2);
            this.mViewType = 0;
            copyMarginsFromCompat(r2);
        }

        public LayoutParams(ViewGroup.LayoutParams r1) {
            super(r1);
            this.mViewType = 0;
        }

        public LayoutParams(ActionBar.LayoutParams r1) {
            super(r1);
            this.mViewType = 0;
        }

        public LayoutParams(int r3) {
            this(-2, -1, r3);
        }

        public LayoutParams(int r1, int r2) {
            super(r1, r2);
            this.mViewType = 0;
            this.gravity = 8388627;
        }

        public LayoutParams(Context r1, AttributeSet r2) {
            super(r1, r2);
            this.mViewType = 0;
        }

        public LayoutParams(int r1, int r2, int r3) {
            super(r1, r2);
            this.mViewType = 0;
            this.gravity = r3;
        }
    }

    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem r1);
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        int expandedMenuItemId;
        boolean isOverflowOpen;

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState(Parcel r2) {
            this(r2, null);
        }

        public SavedState(Parcelable r1) {
            super(r1);
        }

        public SavedState(Parcel r1, ClassLoader r2) {
            super(r1, r2);
            this.expandedMenuItemId = r1.readInt();
            if (r1.readInt() == 0) goto L5;
            boolean r3 = true;
        L6:
            this.isOverflowOpen = r3;
            return;
        L5:
            r3 = false;
            goto L6
        }

        public void writeToParcel(Parcel r1, int r2) {
            super.writeToParcel(r1, r2);
            r1.writeInt(this.expandedMenuItemId);
            r1.writeInt(this.isOverflowOpen ? 1 : 0);
        }
    }

    private void ensureContentInsets() {
        if (this.mContentInsets != null) goto L6;
        this.mContentInsets = new RtlSpacingHelper();
        return;
    }

    private void ensureLogoView() {
        if (this.mLogoView != null) goto L6;
        this.mLogoView = new AppCompatImageView(getContext());
        return;
    }

    private void ensureMenuView() {
        if (this.mMenuView != null) goto L6;
        ActionMenuView r0 = new ActionMenuView(getContext());
        this.mMenuView = r0;
        r0.setPopupTheme(this.mPopupTheme);
        this.mMenuView.setOnMenuItemClickListener(this.mMenuViewItemClickListener);
        this.mMenuView.setMenuCallbacks(this.mActionMenuPresenterCallback, this.mMenuBuilderCallback);
        LayoutParams r1 = generateDefaultLayoutParams();
        r1.gravity = (this.mButtonGravity & 112) | 8388613;
        this.mMenuView.setLayoutParams(r1);
        addSystemView(this.mMenuView, false);
        return;
    }

    private void ensureNavButtonView() {
        if (this.mNavButtonView != null) goto L6;
        this.mNavButtonView = new AppCompatImageButton(getContext(), null, 2130974605);
        LayoutParams r0 = generateDefaultLayoutParams();
        r0.gravity = (this.mButtonGravity & 112) | 8388611;
        this.mNavButtonView.setLayoutParams(r0);
        return;
    }

    private MenuInflater getMenuInflater() {
        return new SupportMenuInflater(getContext());
    }

    private void postShowOverflowMenu() {
        removeCallbacks(this.mShowOverflowMenuRunnable);
        post(this.mShowOverflowMenuRunnable);
    }

    private boolean shouldCollapse() {
        if (this.mCollapsible == true) goto L5;
        return false;
    L5:
        int r0 = getChildCount();
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L15;
        View r3 = getChildAt(r2);
        if (shouldLayout(r3) == false) goto L14;
        if (r3.getMeasuredWidth() <= 0) goto L14;
        if (r3.getMeasuredHeight() <= 0) goto L14;
        return false;
    L14:
        r2 = r2 + 1;
        goto L6
    L15:
        return true;
    }

    public void addChildrenForExpandedActionView() {
        int r0 = this.mHiddenViews.size() - 1;
    L3:
        if (r0 < 0) goto L5;
        addView((View) ListProtector.get(this.mHiddenViews, r0));
        r0 = r0 - 1;
        goto L3
    L5:
        this.mHiddenViews.clear();
    }

    public void collapseActionView() {
        ExpandedActionViewMenuPresenter r0 = this.mExpandedMenuPresenter;
        if (r0 != null) goto L5;
        MenuItemImpl r1 = null;
    L6:
        if (r1 == null) goto L9;
        r1.collapseActionView();
        return;
    L9:
        return;
    L5:
        r1 = r0.mCurrentExpandedItem;
        goto L6
    }

    public void dismissPopupMenus() {
        ActionMenuView r0 = this.mMenuView;
        if (r0 == null) goto L6;
        r0.dismissPopupMenus();
        return;
    }

    public void ensureCollapseButtonView() {
        if (this.mCollapseButtonView != null) goto L6;
        AppCompatImageButton r0 = new AppCompatImageButton(getContext(), null, 2130974605);
        this.mCollapseButtonView = r0;
        r0.setImageDrawable(this.mCollapseIcon);
        this.mCollapseButtonView.setContentDescription(this.mCollapseDescription);
        LayoutParams r1 = generateDefaultLayoutParams();
        r1.gravity = (this.mButtonGravity & 112) | 8388611;
        r1.mViewType = 2;
        this.mCollapseButtonView.setLayoutParams(r1);
        this.mCollapseButtonView.setOnClickListener(new AnonymousClass3(this));
        return;
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    public CharSequence getCollapseContentDescription() {
        ImageButton r0 = this.mCollapseButtonView;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getContentDescription();
    }

    public Drawable getCollapseIcon() {
        ImageButton r0 = this.mCollapseButtonView;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getDrawable();
    }

    public int getContentInsetEnd() {
        RtlSpacingHelper r0 = this.mContentInsets;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getEnd();
    }

    public int getContentInsetEndWithActions() {
        int r0 = this.mContentInsetEndWithActions;
        if (r0 == Integer.MIN_VALUE) goto L6;
        return r0;
    L6:
        return getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        RtlSpacingHelper r0 = this.mContentInsets;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getLeft();
    }

    public int getContentInsetRight() {
        RtlSpacingHelper r0 = this.mContentInsets;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getRight();
    }

    public int getContentInsetStart() {
        RtlSpacingHelper r0 = this.mContentInsets;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getStart();
    }

    public int getContentInsetStartWithNavigation() {
        int r0 = this.mContentInsetStartWithNavigation;
        if (r0 == Integer.MIN_VALUE) goto L6;
        return r0;
    L6:
        return getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        ActionMenuView r0 = this.mMenuView;
        if (r0 == null) goto L9;
        MenuBuilder r1 = r0.peekMenu();
        if (r1 == null) goto L9;
        if (r1.hasVisibleItems() == false) goto L9;
        boolean r2 = true;
    L10:
        if (r2 == false) goto L13;
        return Math.max(getContentInsetEnd(), Math.max(this.mContentInsetEndWithActions, 0));
    L13:
        return getContentInsetEnd();
    L9:
        r2 = false;
        goto L10
    }

    public Drawable getLogo() {
        ImageView r0 = this.mLogoView;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getDrawable();
    }

    public CharSequence getLogoDescription() {
        ImageView r0 = this.mLogoView;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getContentDescription();
    }

    public CharSequence getNavigationContentDescription() {
        ImageButton r0 = this.mNavButtonView;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getContentDescription();
    }

    public Drawable getNavigationIcon() {
        ImageButton r0 = this.mNavButtonView;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getDrawable();
    }

    public DecorToolbar getWrapper() {
        if (this.mWrapper != null) goto L6;
        this.mWrapper = new ToolbarWidgetWrapper(this, true);
    L6:
        return this.mWrapper;
    }

    public boolean hasExpandedActionView() {
        ExpandedActionViewMenuPresenter r0 = this.mExpandedMenuPresenter;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.mCurrentExpandedItem == null) goto L7;
        return true;
    }

    public boolean hideOverflowMenu() {
        ActionMenuView r0 = this.mMenuView;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.hideOverflowMenu() == false) goto L7;
        return true;
    }

    public boolean isOverflowMenuShowPending() {
        ActionMenuView r0 = this.mMenuView;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isOverflowMenuShowPending() == false) goto L7;
        return true;
    }

    public boolean isOverflowMenuShowing() {
        ActionMenuView r0 = this.mMenuView;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isOverflowMenuShowing() == false) goto L7;
        return true;
    }

    public boolean isTitleTruncated() {
        TextView r0 = this.mTitleTextView;
        if (r0 != null) goto L5;
        return false;
    L5:
        Layout r1 = r0.getLayout();
        if (r1 != null) goto L8;
        return false;
    L8:
        int r2 = r1.getLineCount();
        int r3 = 0;
    L9:
        if (r3 >= r2) goto L15;
        if (r1.getEllipsisCount(r3) > 0) goto L12;
        r3 = r3 + 1;
        goto L9
    L12:
        return true;
    L15:
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.os.Parcelable, androidx.appcompat.widget.Toolbar$SavedState] */
    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        ?? r0 = new SavedState(super.onSaveInstanceState());
        ExpandedActionViewMenuPresenter r1 = this.mExpandedMenuPresenter;
        if (r1 == null) goto L7;
        MenuItemImpl r2 = r1.mCurrentExpandedItem;
        if (r2 == null) goto L7;
        r0.expandedMenuItemId = r2.getItemId();
    L7:
        r0.isOverflowOpen = isOverflowMenuShowing();
        return r0;
    }

    public boolean showOverflowMenu() {
        ActionMenuView r0 = this.mMenuView;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.showOverflowMenu() == false) goto L7;
        return true;
    }

    private void ensureMenu() {
        ensureMenuView();
        if (this.mMenuView.peekMenu() != null) goto L9;
        MenuBuilder r0 = (MenuBuilder) this.mMenuView.getMenu();
        if (this.mExpandedMenuPresenter != null) goto L7;
        this.mExpandedMenuPresenter = new ExpandedActionViewMenuPresenter(this);
    L7:
        this.mMenuView.setExpandedActionViewsExclusive(true);
        r0.addMenuPresenter(this.mExpandedMenuPresenter, this.mPopupContext);
        return;
    }

    public boolean canShowOverflowMenu() {
        if (getVisibility() != 0) goto L9;
        ActionMenuView r0 = this.mMenuView;
        if (r0 == null) goto L9;
        if (r0.isOverflowReserved() == false) goto L9;
        return true;
    L9:
        return false;
    }

    public int getCurrentContentInsetLeft() {
        if (ViewCompat.getLayoutDirection(this) != 1) goto L6;
        return getCurrentContentInsetEnd();
    L6:
        return getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        if (ViewCompat.getLayoutDirection(this) != 1) goto L6;
        return getCurrentContentInsetStart();
    L6:
        return getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        if (getNavigationIcon() == null) goto L6;
        return Math.max(getContentInsetStart(), Math.max(this.mContentInsetStartWithNavigation, 0));
    L6:
        return getContentInsetStart();
    }

    public Menu getMenu() {
        ensureMenu();
        return this.mMenuView.getMenu();
    }

    public Drawable getOverflowIcon() {
        ensureMenu();
        return this.mMenuView.getOverflowIcon();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.mShowOverflowMenuRunnable);
    }

    public void removeChildrenForExpandedActionView() {
        int r0 = getChildCount() - 1;
    L3:
        if (r0 < 0) goto L10;
        View r1 = getChildAt(r0);
        if (((LayoutParams) r1.getLayoutParams()).mViewType == 2) goto L9;
        if (r1 == this.mMenuView) goto L9;
        removeViewAt(r0);
        this.mHiddenViews.add(r1);
    L9:
        r0 = r0 - 1;
        goto L3
    }

    public ActionMenuPresenter getOuterActionMenuPresenter() {
        return this.mOuterActionMenuPresenter;
    }

    public Context getPopupContext() {
        return this.mPopupContext;
    }

    public int getPopupTheme() {
        return this.mPopupTheme;
    }

    public CharSequence getSubtitle() {
        return this.mSubtitleText;
    }

    public final TextView getSubtitleTextView() {
        return this.mSubtitleTextView;
    }

    public CharSequence getTitle() {
        return this.mTitleText;
    }

    public int getTitleMarginBottom() {
        return this.mTitleMarginBottom;
    }

    public int getTitleMarginEnd() {
        return this.mTitleMarginEnd;
    }

    public int getTitleMarginStart() {
        return this.mTitleMarginStart;
    }

    public int getTitleMarginTop() {
        return this.mTitleMarginTop;
    }

    public final TextView getTitleTextView() {
        return this.mTitleTextView;
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    public Toolbar(Context r2) {
        this(r2, null);
    }

    private int getChildHorizontalGravity(int r5) {
        int r0 = ViewCompat.getLayoutDirection(this);
        int r6 = GravityCompat.getAbsoluteGravity(r5, r0) & 7;
        if (r6 != 1) goto L5;
    L11:
        return r6;
    L5:
        if (r6 == 3) goto L11;
        if (r6 == 5) goto L11;
        if (r0 != 1) goto L12;
        return 5;
    L12:
        return 3;
    }

    private int getChildVerticalGravity(int r2) {
        int r3 = r2 & 112;
        if (r3 != 16) goto L5;
        return r3;
    L5:
        if (r3 != 48) goto L7;
        return r3;
    L7:
        if (r3 != 80) goto L9;
        return r3;
    L9:
        return this.mGravity & 112;
    }

    private int getHorizontalMargins(View r2) {
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) r2.getLayoutParams();
        return MarginLayoutParamsCompat.getMarginStart(r3) + MarginLayoutParamsCompat.getMarginEnd(r3);
    }

    private int getVerticalMargins(View r2) {
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) r2.getLayoutParams();
        return r3.topMargin + r3.bottomMargin;
    }

    private boolean isChildOrHidden(View r2) {
        if (r2.getParent() != this) goto L5;
    L8:
        return true;
    L5:
        if (this.mHiddenViews.contains(r2) == true) goto L8;
        return false;
    }

    private boolean shouldLayout(View r2) {
        if (r2 != null) goto L4;
    L8:
        return false;
    L4:
        if (r2.getParent() != this) goto L8;
        if (r2.getVisibility() == 8) goto L8;
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams r2) {
        if (super.checkLayoutParams(r2) == true) goto L5;
    L7:
        return false;
    L5:
        if ((r2 instanceof LayoutParams) == false) goto L7;
        return true;
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams r2) {
        if ((r2 instanceof LayoutParams) == false) goto L7;
        return new LayoutParams((LayoutParams) r2);
    L7:
        if ((r2 instanceof ActionBar.LayoutParams) == false) goto L11;
        return new LayoutParams((ActionBar.LayoutParams) r2);
    L11:
        if ((r2 instanceof ViewGroup.MarginLayoutParams) == false) goto L15;
        return new LayoutParams((ViewGroup.MarginLayoutParams) r2);
    L15:
        return new LayoutParams(r2);
    }

    public void inflateMenu(int r3) {
        getMenuInflater().inflate(r3, getMenu());
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent r6) {
        int r0 = r6.getActionMasked();
        if (r0 != 9) goto L6;
        this.mEatingHover = false;
    L6:
        if (this.mEatingHover == true) goto L12;
        boolean r7 = super.onHoverEvent(r6);
        if (r0 != 9) goto L12;
        if (r7 == true) goto L12;
        this.mEatingHover = true;
    L12:
        if (r0 != 10) goto L14;
    L15:
        this.mEatingHover = false;
    L16:
        return true;
    L14:
        if (r0 != 3) goto L16;
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r4) {
        if ((r4 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r4);
        return;
    L6:
        SavedState r5 = (SavedState) r4;
        super.onRestoreInstanceState(r5.getSuperState());
        ActionMenuView r0 = this.mMenuView;
        if (r0 == null) goto L9;
        SupportMenu r1 = r0.peekMenu();
    L10:
        int r2 = r5.expandedMenuItemId;
        if (r2 == 0) goto L19;
        if (this.mExpandedMenuPresenter == null) goto L19;
        if (r1 == null) goto L19;
        MenuItem r3 = r1.findItem(r2);
        if (r3 == null) goto L19;
        r3.expandActionView();
    L19:
        if (r5.isOverflowOpen == false) goto L22;
        postShowOverflowMenu();
        return;
    L22:
        return;
    L9:
        r1 = null;
        goto L10
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int r3) {
        super.onRtlPropertiesChanged(r3);
        ensureContentInsets();
        RtlSpacingHelper r0 = this.mContentInsets;
        boolean r1 = true;
        if (r3 == 1) goto L6;
        r1 = false;
    L6:
        r0.setDirection(r1);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r5) {
        int r0 = r5.getActionMasked();
        if (r0 != 0) goto L6;
        this.mEatingTouch = false;
    L6:
        if (this.mEatingTouch == true) goto L11;
        boolean r6 = super.onTouchEvent(r5);
        if (r0 != 0) goto L11;
        if (r6 == true) goto L11;
        this.mEatingTouch = true;
    L11:
        if (r0 != 1) goto L13;
    L14:
        this.mEatingTouch = false;
    L15:
        return true;
    L13:
        if (r0 != 3) goto L15;
        goto L14
    }

    public void setCollapseContentDescription(CharSequence r2) {
        if (TextUtils.isEmpty(r2) == true) goto L5;
        ensureCollapseButtonView();
    L5:
        ImageButton r0 = this.mCollapseButtonView;
        if (r0 == null) goto L9;
        r0.setContentDescription(r2);
        return;
    }

    public void setCollapseIcon(Drawable r2) {
        if (r2 == null) goto L4;
        ensureCollapseButtonView();
        this.mCollapseButtonView.setImageDrawable(r2);
        return;
    L4:
        ImageButton r3 = this.mCollapseButtonView;
        if (r3 == null) goto L9;
        r3.setImageDrawable(this.mCollapseIcon);
        return;
    }

    public void setCollapsible(boolean r1) {
        this.mCollapsible = r1;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int r2) {
        if (r2 >= 0) goto L5;
        r2 = RtlSpacingHelper.UNDEFINED;
    L5:
        if (r2 == this.mContentInsetEndWithActions) goto L10;
        this.mContentInsetEndWithActions = r2;
        if (getNavigationIcon() == null) goto L11;
        requestLayout();
        return;
    L11:
        return;
    }

    public void setContentInsetStartWithNavigation(int r2) {
        if (r2 >= 0) goto L5;
        r2 = RtlSpacingHelper.UNDEFINED;
    L5:
        if (r2 == this.mContentInsetStartWithNavigation) goto L10;
        this.mContentInsetStartWithNavigation = r2;
        if (getNavigationIcon() == null) goto L11;
        requestLayout();
        return;
    L11:
        return;
    }

    public void setLogo(Drawable r3) {
        if (r3 == null) goto L6;
        ensureLogoView();
        if (isChildOrHidden(this.mLogoView) == true) goto L11;
        addSystemView(this.mLogoView, true);
    L11:
        ImageView r0 = this.mLogoView;
        if (r0 == null) goto L15;
        r0.setImageDrawable(r3);
        return;
    L15:
        return;
    L6:
        ImageView r1 = this.mLogoView;
        if (r1 == null) goto L11;
        if (isChildOrHidden(r1) == false) goto L11;
        removeView(this.mLogoView);
        this.mHiddenViews.remove(this.mLogoView);
        goto L11
    }

    public void setLogoDescription(CharSequence r2) {
        if (TextUtils.isEmpty(r2) == true) goto L5;
        ensureLogoView();
    L5:
        ImageView r0 = this.mLogoView;
        if (r0 == null) goto L9;
        r0.setContentDescription(r2);
        return;
    }

    public void setNavigationContentDescription(CharSequence r2) {
        if (TextUtils.isEmpty(r2) == true) goto L5;
        ensureNavButtonView();
    L5:
        ImageButton r0 = this.mNavButtonView;
        if (r0 == null) goto L9;
        r0.setContentDescription(r2);
        return;
    }

    public void setNavigationIcon(Drawable r3) {
        if (r3 == null) goto L6;
        ensureNavButtonView();
        if (isChildOrHidden(this.mNavButtonView) == true) goto L11;
        addSystemView(this.mNavButtonView, true);
    L11:
        ImageButton r0 = this.mNavButtonView;
        if (r0 == null) goto L15;
        r0.setImageDrawable(r3);
        return;
    L15:
        return;
    L6:
        ImageButton r1 = this.mNavButtonView;
        if (r1 == null) goto L11;
        if (isChildOrHidden(r1) == false) goto L11;
        removeView(this.mNavButtonView);
        this.mHiddenViews.remove(this.mNavButtonView);
        goto L11
    }

    public void setNavigationOnClickListener(View.OnClickListener r2) {
        ensureNavButtonView();
        this.mNavButtonView.setOnClickListener(r2);
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener r1) {
        this.mOnMenuItemClickListener = r1;
    }

    public void setOverflowIcon(Drawable r2) {
        ensureMenu();
        this.mMenuView.setOverflowIcon(r2);
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

    public void setSubtitle(CharSequence r4) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
        TextView r0 = this.mSubtitleTextView;
        if (r0 != null) goto L18;
    L20:
        TextView r1 = this.mSubtitleTextView;
        if (r1 == null) goto L23;
        r1.setText(r4);
    L23:
        this.mSubtitleText = r4;
        return;
    L18:
        if (isChildOrHidden(r0) == false) goto L20;
        removeView(this.mSubtitleTextView);
        this.mHiddenViews.remove(this.mSubtitleTextView);
        goto L20
    L5:
        if (this.mSubtitleTextView != null) goto L13;
        Context r2 = getContext();
        AppCompatTextView r3 = new AppCompatTextView(r2);
        this.mSubtitleTextView = r3;
        r3.setSingleLine();
        this.mSubtitleTextView.setEllipsize(TextUtils.TruncateAt.END);
        int r5 = this.mSubtitleTextAppearance;
        if (r5 == 0) goto L9;
        this.mSubtitleTextView.setTextAppearance(r2, r5);
    L9:
        ColorStateList r6 = this.mSubtitleTextColor;
        if (r6 == null) goto L13;
        this.mSubtitleTextView.setTextColor(r6);
    L13:
        if (isChildOrHidden(this.mSubtitleTextView) == true) goto L20;
        addSystemView(this.mSubtitleTextView, true);
        goto L20
    }

    public void setSubtitleTextColor(ColorStateList r2) {
        this.mSubtitleTextColor = r2;
        TextView r0 = this.mSubtitleTextView;
        if (r0 == null) goto L6;
        r0.setTextColor(r2);
        return;
    }

    public void setTitle(CharSequence r4) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
        TextView r0 = this.mTitleTextView;
        if (r0 != null) goto L18;
    L20:
        TextView r1 = this.mTitleTextView;
        if (r1 == null) goto L23;
        r1.setText(r4);
    L23:
        this.mTitleText = r4;
        return;
    L18:
        if (isChildOrHidden(r0) == false) goto L20;
        removeView(this.mTitleTextView);
        this.mHiddenViews.remove(this.mTitleTextView);
        goto L20
    L5:
        if (this.mTitleTextView != null) goto L13;
        Context r2 = getContext();
        AppCompatTextView r3 = new AppCompatTextView(r2);
        this.mTitleTextView = r3;
        r3.setSingleLine();
        this.mTitleTextView.setEllipsize(TextUtils.TruncateAt.END);
        int r5 = this.mTitleTextAppearance;
        if (r5 == 0) goto L9;
        this.mTitleTextView.setTextAppearance(r2, r5);
    L9:
        ColorStateList r6 = this.mTitleTextColor;
        if (r6 == null) goto L13;
        this.mTitleTextView.setTextColor(r6);
    L13:
        if (isChildOrHidden(this.mTitleTextView) == true) goto L20;
        addSystemView(this.mTitleTextView, true);
        goto L20
    }

    public void setTitleMarginBottom(int r1) {
        this.mTitleMarginBottom = r1;
        requestLayout();
    }

    public void setTitleMarginEnd(int r1) {
        this.mTitleMarginEnd = r1;
        requestLayout();
    }

    public void setTitleMarginStart(int r1) {
        this.mTitleMarginStart = r1;
        requestLayout();
    }

    public void setTitleMarginTop(int r1) {
        this.mTitleMarginTop = r1;
        requestLayout();
    }

    public void setTitleTextColor(ColorStateList r2) {
        this.mTitleTextColor = r2;
        TextView r0 = this.mTitleTextView;
        if (r0 == null) goto L6;
        r0.setTextColor(r2);
        return;
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet r3) {
        return new LayoutParams(getContext(), r3);
    }

    public void setCollapseContentDescription(int r2) {
        if (r2 == 0) goto L4;
        CharSequence r3 = getContext().getText(r2);
    L5:
        setCollapseContentDescription(r3);
        return;
    L4:
        r3 = null;
        goto L5
    }

    public void setCollapseIcon(int r2) {
        setCollapseIcon(AppCompatResources.getDrawable(getContext(), r2));
    }

    public void setLogo(int r2) {
        setLogo(AppCompatResources.getDrawable(getContext(), r2));
    }

    public void setLogoDescription(int r2) {
        setLogoDescription(getContext().getText(r2));
    }

    public void setNavigationContentDescription(int r2) {
        if (r2 == 0) goto L4;
        CharSequence r3 = getContext().getText(r2);
    L5:
        setNavigationContentDescription(r3);
        return;
    L4:
        r3 = null;
        goto L5
    }

    public void setNavigationIcon(int r2) {
        setNavigationIcon(AppCompatResources.getDrawable(getContext(), r2));
    }

    public void setSubtitle(int r2) {
        setSubtitle(getContext().getText(r2));
    }

    public void setSubtitleTextColor(int r1) {
        setSubtitleTextColor(ColorStateList.valueOf(r1));
    }

    public void setTitle(int r2) {
        setTitle(getContext().getText(r2));
    }

    public void setTitleTextColor(int r1) {
        setTitleTextColor(ColorStateList.valueOf(r1));
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r1) {
        return generateLayoutParams(r1);
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        return generateLayoutParams(r1);
    }

    public Toolbar(Context r2, AttributeSet r3) {
        this(r2, r3, 2130974606);
    }

    private void addCustomViewsWithGravity(List<View> r6, int r7) {
        int r1 = 0;
        if (ViewCompat.getLayoutDirection(this) != 1) goto L5;
        boolean r0 = true;
    L6:
        int r3 = getChildCount();
        int r8 = GravityCompat.getAbsoluteGravity(r7, ViewCompat.getLayoutDirection(this));
        r6.clear();
        if (r0 == false) goto L18;
        int r4 = r3 - 1;
    L9:
        if (r4 < 0) goto L27;
        View r2 = getChildAt(r4);
        LayoutParams r5 = (LayoutParams) r2.getLayoutParams();
        if (r5.mViewType != 0) goto L17;
        if (shouldLayout(r2) == false) goto L17;
        if (getChildHorizontalGravity(r5.gravity) != r8) goto L17;
        r6.add(r2);
    L17:
        r4 = r4 - 1;
        goto L9
    L27:
        return;
    L18:
        if (r1 >= r3) goto L38;
        View r9 = getChildAt(r1);
        LayoutParams r10 = (LayoutParams) r9.getLayoutParams();
        if (r10.mViewType != 0) goto L26;
        if (shouldLayout(r9) == false) goto L26;
        if (getChildHorizontalGravity(r10.gravity) != r8) goto L26;
        r6.add(r9);
    L26:
        r1 = r1 + 1;
        goto L18
    L38:
        return;
    L5:
        r0 = false;
        goto L6
    }

    private void addSystemView(View r3, boolean r4) {
        ViewGroup.LayoutParams r0 = r3.getLayoutParams();
        if (r0 != null) goto L6;
        LayoutParams r1 = generateDefaultLayoutParams();
    L9:
        r1.mViewType = 1;
        if (r4 == true) goto L12;
    L14:
        addView(r3, r1);
        return;
    L12:
        if (this.mExpandedActionView == null) goto L14;
        r3.setLayoutParams(r1);
        this.mHiddenViews.add(r3);
        return;
    L6:
        if (checkLayoutParams(r0) == true) goto L8;
        r1 = generateLayoutParams(r0);
        goto L9
    L8:
        r1 = (LayoutParams) r0;
        goto L9
    }

    private int getChildTop(View r7, int r8) {
        LayoutParams r0 = (LayoutParams) r7.getLayoutParams();
        int r9 = r7.getMeasuredHeight();
        if (r8 <= 0) goto L5;
        int r10 = (r9 - r8) / 2;
    L6:
        int r2 = getChildVerticalGravity(r0.gravity);
        if (r2 == 48) goto L21;
        if (r2 == 80) goto L19;
        int r11 = getPaddingTop();
        int r3 = getPaddingBottom();
        int r4 = getHeight();
        int r5 = (((r4 - r11) - r3) - r9) / 2;
        int r6 = ((ViewGroup.MarginLayoutParams) r0).topMargin;
        if (r5 >= r6) goto L13;
        r5 = r6;
    L17:
        return r11 + r5;
    L13:
        int r12 = (((r4 - r3) - r9) - r5) - r11;
        int r13 = ((ViewGroup.MarginLayoutParams) r0).bottomMargin;
        if (r12 >= r13) goto L17;
        r5 = Math.max(0, r5 - (r13 - r12));
        goto L17
    L19:
        return (((getHeight() - getPaddingBottom()) - r9) - ((ViewGroup.MarginLayoutParams) r0).bottomMargin) - r10;
    L21:
        return getPaddingTop() - r10;
    L5:
        r10 = 0;
        goto L6
    }

    private int getViewListMeasuredWidth(List<View> r9, int[] r10) {
        int r1 = r10[0];
        int r11 = r10[1];
        int r2 = r9.size();
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r3 >= r2) goto L5;
        View r5 = (View) ListProtector.get(r9, r3);
        LayoutParams r6 = (LayoutParams) r5.getLayoutParams();
        int r7 = ((ViewGroup.MarginLayoutParams) r6).leftMargin - r1;
        int r8 = ((ViewGroup.MarginLayoutParams) r6).rightMargin - r11;
        int r12 = Math.max(0, r7);
        int r13 = Math.max(0, r8);
        int r14 = Math.max(0, -r7);
        int r15 = Math.max(0, -r8);
        r4 = r4 + ((r12 + r5.getMeasuredWidth()) + r13);
        r3 = r3 + 1;
        r11 = r15;
        r1 = r14;
        goto L3
    L5:
        return r4;
    }

    @Override // android.view.View
    public void onMeasure(int r17, int r18) {
        int[] r8 = this.mTempMargins;
        boolean r9 = ViewUtils.isLayoutRtl(this);
        int r10 = 0;
        int r11 = !r9 ? 1 : 0;
        if (shouldLayout(this.mNavButtonView) == false) goto L5;
        measureChildConstrained(this.mNavButtonView, r17, 0, r18, 0, this.mMaxButtonHeight);
        int r0 = this.mNavButtonView.getMeasuredWidth() + getHorizontalMargins(this.mNavButtonView);
        int r1 = Math.max(0, this.mNavButtonView.getMeasuredHeight() + getVerticalMargins(this.mNavButtonView));
        int r12 = r1;
        int r13 = View.combineMeasuredStates(0, this.mNavButtonView.getMeasuredState());
    L7:
        if (shouldLayout(this.mCollapseButtonView) == false) goto L9;
        measureChildConstrained(this.mCollapseButtonView, r17, 0, r18, 0, this.mMaxButtonHeight);
        r0 = this.mCollapseButtonView.getMeasuredWidth() + getHorizontalMargins(this.mCollapseButtonView);
        r12 = Math.max(r12, this.mCollapseButtonView.getMeasuredHeight() + getVerticalMargins(this.mCollapseButtonView));
        r13 = View.combineMeasuredStates(r13, this.mCollapseButtonView.getMeasuredState());
    L9:
        int r2 = getCurrentContentInsetStart();
        int r14 = 0 + Math.max(r2, r0);
        int r3 = Math.max(0, r2 - r0);
        r8[r9 ? 1 : 0] = r3;
        if (shouldLayout(this.mMenuView) == false) goto L12;
        measureChildConstrained(this.mMenuView, r17, r14, r18, 0, this.mMaxButtonHeight);
        int r4 = this.mMenuView.getMeasuredWidth() + getHorizontalMargins(this.mMenuView);
        r12 = Math.max(r12, this.mMenuView.getMeasuredHeight() + getVerticalMargins(this.mMenuView));
        r13 = View.combineMeasuredStates(r13, this.mMenuView.getMeasuredState());
    L13:
        int r5 = getCurrentContentInsetEnd();
        int r15 = r14 + Math.max(r5, r4);
        r8[r11] = Math.max(0, r5 - r4);
        if (shouldLayout(this.mExpandedActionView) == false) goto L17;
        r15 = r15 + measureChildCollapseMargins(this.mExpandedActionView, r17, r15, r18, 0, r8);
        r12 = Math.max(r12, this.mExpandedActionView.getMeasuredHeight() + getVerticalMargins(this.mExpandedActionView));
        r13 = View.combineMeasuredStates(r13, this.mExpandedActionView.getMeasuredState());
    L17:
        if (shouldLayout(this.mLogoView) == false) goto L19;
        r15 = r15 + measureChildCollapseMargins(this.mLogoView, r17, r15, r18, 0, r8);
        r12 = Math.max(r12, this.mLogoView.getMeasuredHeight() + getVerticalMargins(this.mLogoView));
        r13 = View.combineMeasuredStates(r13, this.mLogoView.getMeasuredState());
    L19:
        int r16 = getChildCount();
        int r19 = 0;
    L20:
        if (r19 >= r16) goto L28;
        View r110 = getChildAt(r19);
        if (((LayoutParams) r110.getLayoutParams()).mViewType != 0) goto L27;
        if (shouldLayout(r110) == false) goto L27;
        r15 = r15 + measureChildCollapseMargins(r110, r17, r15, r18, 0, r8);
        int r6 = Math.max(r12, r110.getMeasuredHeight() + getVerticalMargins(r110));
        r12 = r6;
        r13 = View.combineMeasuredStates(r13, r110.getMeasuredState());
    L27:
        r19 = r19 + 1;
        goto L20
    L28:
        int r20 = this.mTitleMarginTop + this.mTitleMarginBottom;
        int r111 = this.mTitleMarginStart + this.mTitleMarginEnd;
        if (shouldLayout(this.mTitleTextView) == false) goto L31;
        measureChildCollapseMargins(this.mTitleTextView, r17, r15 + r111, r18, r20, r8);
        int r7 = this.mTitleTextView.getMeasuredWidth() + getHorizontalMargins(this.mTitleTextView);
        int r21 = this.mTitleTextView.getMeasuredHeight() + getVerticalMargins(this.mTitleTextView);
        int r112 = r21;
        int r22 = View.combineMeasuredStates(r13, this.mTitleTextView.getMeasuredState());
        int r113 = r7;
    L33:
        if (shouldLayout(this.mSubtitleTextView) == false) goto L36;
        int r23 = r112 + r20;
        r113 = Math.max(r113, measureChildCollapseMargins(this.mSubtitleTextView, r17, r15 + r111, r18, r23, r8));
        r112 = r112 + (this.mSubtitleTextView.getMeasuredHeight() + getVerticalMargins(this.mSubtitleTextView));
        r22 = View.combineMeasuredStates(r22, this.mSubtitleTextView.getMeasuredState());
    L36:
        int r24 = Math.max(r12, r112);
        int r114 = (r15 + r113) + (getPaddingLeft() + getPaddingRight());
        int r25 = r24 + (getPaddingTop() + getPaddingBottom());
        int r26 = View.resolveSizeAndState(Math.max(r114, getSuggestedMinimumWidth()), r17, (-16777216) & r22);
        int r27 = View.resolveSizeAndState(Math.max(r25, getSuggestedMinimumHeight()), r18, r22 << 16);
        if (shouldCollapse() == true) goto L40;
        r10 = r27;
    L40:
        setMeasuredDimension(r26, r10);
        return;
    L31:
        r22 = r13;
        r113 = 0;
        r112 = 0;
        goto L33
    L12:
        r4 = 0;
        goto L13
    L5:
        r0 = 0;
        r12 = 0;
        r13 = 0;
        goto L7
    }

    public void setContentInsetsAbsolute(int r2, int r3) {
        ensureContentInsets();
        this.mContentInsets.setAbsolute(r2, r3);
    }

    public void setContentInsetsRelative(int r2, int r3) {
        ensureContentInsets();
        this.mContentInsets.setRelative(r2, r3);
    }

    public void setMenu(MenuBuilder r4, ActionMenuPresenter r5) {
        if (r4 == null) goto L4;
    L6:
        ensureMenuView();
        MenuBuilder r0 = this.mMenuView.peekMenu();
        if (r0 != r4) goto L9;
        return;
    L9:
        if (r0 == null) goto L12;
        r0.removeMenuPresenter(this.mOuterActionMenuPresenter);
        r0.removeMenuPresenter(this.mExpandedMenuPresenter);
    L12:
        if (this.mExpandedMenuPresenter != null) goto L14;
        this.mExpandedMenuPresenter = new ExpandedActionViewMenuPresenter(this);
    L14:
        r5.setExpandedActionViewsExclusive(true);
        if (r4 == null) goto L17;
        r4.addMenuPresenter(r5, this.mPopupContext);
        r4.addMenuPresenter(this.mExpandedMenuPresenter, this.mPopupContext);
    L18:
        this.mMenuView.setPopupTheme(this.mPopupTheme);
        this.mMenuView.setPresenter(r5);
        this.mOuterActionMenuPresenter = r5;
        return;
    L17:
        r5.initForMenu(this.mPopupContext, null);
        this.mExpandedMenuPresenter.initForMenu(this.mPopupContext, null);
        r5.updateMenuView(true);
        this.mExpandedMenuPresenter.updateMenuView(true);
        goto L18
    L4:
        if (this.mMenuView != null) goto L6;
    }

    public void setMenuCallbacks(MenuPresenter.Callback r2, MenuBuilder.Callback r3) {
        this.mActionMenuPresenterCallback = r2;
        this.mMenuBuilderCallback = r3;
        ActionMenuView r0 = this.mMenuView;
        if (r0 == null) goto L6;
        r0.setMenuCallbacks(r2, r3);
        return;
    }

    public void setSubtitleTextAppearance(Context r2, int r3) {
        this.mSubtitleTextAppearance = r3;
        TextView r0 = this.mSubtitleTextView;
        if (r0 == null) goto L6;
        r0.setTextAppearance(r2, r3);
        return;
    }

    public void setTitleTextAppearance(Context r2, int r3) {
        this.mTitleTextAppearance = r3;
        TextView r0 = this.mTitleTextView;
        if (r0 == null) goto L6;
        r0.setTextAppearance(r2, r3);
        return;
    }

    public Toolbar(Context r13, AttributeSet r14, int r15) {
        super(r13, r14, r15);
        this.mGravity = 8388627;
        this.mTempViews = new ArrayList();
        this.mHiddenViews = new ArrayList();
        this.mTempMargins = new int[2];
        this.mMenuViewItemClickListener = new AnonymousClass1(this);
        this.mShowOverflowMenuRunnable = new AnonymousClass2(this);
        TintTypedArray r1 = TintTypedArray.obtainStyledAttributes(getContext(), r14, new int[]{R.attr.gravity, R.attr.minHeight, 2130969104, 2130969550, 2130969552, 2130969620, 2130969621, 2130969622, 2130969623, 2130969624, 2130969625, 2130972601, 2130972602, 2130972692, 2130972749, 2130972813, 2130972814, 2130973585, 2130974326, 2130974328, 2130974329, 2130974574, 2130974577, 2130974578, 2130974579, 2130974580, 2130974581, 2130974582, 2130974589, 2130974590}, r15, 0);
        ViewCompat.saveAttributeDataForStyleable(this, r13, new int[]{R.attr.gravity, R.attr.minHeight, 2130969104, 2130969550, 2130969552, 2130969620, 2130969621, 2130969622, 2130969623, 2130969624, 2130969625, 2130972601, 2130972602, 2130972692, 2130972749, 2130972813, 2130972814, 2130973585, 2130974326, 2130974328, 2130974329, 2130974574, 2130974577, 2130974578, 2130974579, 2130974580, 2130974581, 2130974582, 2130974589, 2130974590}, r14, r1.getWrappedTypeArray(), r15, 0);
        this.mTitleTextAppearance = r1.getResourceId(28, 0);
        this.mSubtitleTextAppearance = r1.getResourceId(19, 0);
        this.mGravity = r1.getInteger(0, this.mGravity);
        this.mButtonGravity = r1.getInteger(2, 48);
        int r16 = r1.getDimensionPixelOffset(22, 0);
        if (r1.hasValue(27) == false) goto L5;
        r16 = r1.getDimensionPixelOffset(27, r16);
    L5:
        this.mTitleMarginBottom = r16;
        this.mTitleMarginTop = r16;
        this.mTitleMarginEnd = r16;
        this.mTitleMarginStart = r16;
        int r17 = r1.getDimensionPixelOffset(25, -1);
        if (r17 < 0) goto L8;
        this.mTitleMarginStart = r17;
    L8:
        int r18 = r1.getDimensionPixelOffset(24, -1);
        if (r18 < 0) goto L11;
        this.mTitleMarginEnd = r18;
    L11:
        int r19 = r1.getDimensionPixelOffset(26, -1);
        if (r19 < 0) goto L14;
        this.mTitleMarginTop = r19;
    L14:
        int r110 = r1.getDimensionPixelOffset(23, -1);
        if (r110 < 0) goto L17;
        this.mTitleMarginBottom = r110;
    L17:
        this.mMaxButtonHeight = r1.getDimensionPixelSize(13, -1);
        int r111 = r1.getDimensionPixelOffset(9, RtlSpacingHelper.UNDEFINED);
        int r112 = r1.getDimensionPixelOffset(5, RtlSpacingHelper.UNDEFINED);
        int r0 = r1.getDimensionPixelSize(7, 0);
        int r2 = r1.getDimensionPixelSize(8, 0);
        ensureContentInsets();
        this.mContentInsets.setAbsolute(r0, r2);
        if (r111 != Integer.MIN_VALUE) goto L20;
        if (r112 != Integer.MIN_VALUE) goto L20;
    L21:
        this.mContentInsetStartWithNavigation = r1.getDimensionPixelOffset(10, RtlSpacingHelper.UNDEFINED);
        this.mContentInsetEndWithActions = r1.getDimensionPixelOffset(6, RtlSpacingHelper.UNDEFINED);
        this.mCollapseIcon = r1.getDrawable(4);
        this.mCollapseDescription = r1.getText(3);
        CharSequence r113 = r1.getText(21);
        if (TextUtils.isEmpty(r113) == true) goto L24;
        setTitle(r113);
    L24:
        CharSequence r114 = r1.getText(18);
        if (TextUtils.isEmpty(r114) == true) goto L27;
        setSubtitle(r114);
    L27:
        this.mPopupContext = getContext();
        setPopupTheme(r1.getResourceId(17, 0));
        Drawable r115 = r1.getDrawable(16);
        if (r115 == null) goto L30;
        setNavigationIcon(r115);
    L30:
        CharSequence r116 = r1.getText(15);
        if (TextUtils.isEmpty(r116) == true) goto L33;
        setNavigationContentDescription(r116);
    L33:
        Drawable r117 = r1.getDrawable(11);
        if (r117 == null) goto L36;
        setLogo(r117);
    L36:
        CharSequence r118 = r1.getText(12);
        if (TextUtils.isEmpty(r118) == true) goto L40;
        setLogoDescription(r118);
    L40:
        if (r1.hasValue(29) == false) goto L43;
        setTitleTextColor(r1.getColorStateList(29));
    L43:
        if (r1.hasValue(20) == false) goto L46;
        setSubtitleTextColor(r1.getColorStateList(20));
    L46:
        if (r1.hasValue(14) == false) goto L48;
        inflateMenu(r1.getResourceId(14, 0));
    L48:
        r1.recycle();
        return;
    L20:
        this.mContentInsets.setRelative(r111, r112);
        goto L21
    }

    private int layoutChildLeft(View r5, int r6, int[] r7, int r8) {
        LayoutParams r0 = (LayoutParams) r5.getLayoutParams();
        int r1 = ((ViewGroup.MarginLayoutParams) r0).leftMargin - r7[0];
        int r9 = r6 + Math.max(0, r1);
        r7[0] = Math.max(0, -r1);
        int r10 = getChildTop(r5, r8);
        int r11 = r5.getMeasuredWidth();
        r5.layout(r9, r10, r9 + r11, r5.getMeasuredHeight() + r10);
        return r9 + (r11 + ((ViewGroup.MarginLayoutParams) r0).rightMargin);
    }

    private int layoutChildRight(View r6, int r7, int[] r8, int r9) {
        LayoutParams r0 = (LayoutParams) r6.getLayoutParams();
        int r1 = ((ViewGroup.MarginLayoutParams) r0).rightMargin - r8[1];
        int r10 = r7 - Math.max(0, r1);
        r8[1] = Math.max(0, -r1);
        int r11 = getChildTop(r6, r9);
        int r12 = r6.getMeasuredWidth();
        r6.layout(r10 - r12, r11, r10, r6.getMeasuredHeight() + r11);
        return r10 - (r12 + ((ViewGroup.MarginLayoutParams) r0).leftMargin);
    }

    public void setTitleMargin(int r1, int r2, int r3, int r4) {
        this.mTitleMarginStart = r1;
        this.mTitleMarginTop = r2;
        this.mTitleMarginEnd = r3;
        this.mTitleMarginBottom = r4;
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r20, int r21, int r22, int r23, int r24) {
        if (ViewCompat.getLayoutDirection(this) != 1) goto L5;
        boolean r1 = true;
    L6:
        int r4 = getWidth();
        int r5 = getHeight();
        int r6 = getPaddingLeft();
        int r7 = getPaddingRight();
        int r8 = getPaddingTop();
        int r9 = getPaddingBottom();
        int r10 = r4 - r7;
        int[] r11 = this.mTempMargins;
        r11[1] = 0;
        r11[0] = 0;
        int r12 = ViewCompat.getMinimumHeight(this);
        if (r12 < 0) goto L9;
        int r13 = Math.min(r12, r24 - r22);
    L11:
        if (shouldLayout(this.mNavButtonView) == false) goto L15;
        if (r1 == false) goto L14;
        int r14 = layoutChildRight(this.mNavButtonView, r10, r11, r13);
        int r15 = r6;
    L18:
        if (shouldLayout(this.mCollapseButtonView) == false) goto L23;
        if (r1 == false) goto L21;
        r14 = layoutChildRight(this.mCollapseButtonView, r14, r11, r13);
        goto L23
    L21:
        r15 = layoutChildLeft(this.mCollapseButtonView, r15, r11, r13);
    L23:
        if (shouldLayout(this.mMenuView) == false) goto L27;
        if (r1 == false) goto L26;
        r15 = layoutChildLeft(this.mMenuView, r15, r11, r13);
        goto L27
    L26:
        r14 = layoutChildRight(this.mMenuView, r14, r11, r13);
    L27:
        int r16 = getCurrentContentInsetLeft();
        int r17 = getCurrentContentInsetRight();
        r11[0] = Math.max(0, r16 - r15);
        r11[1] = Math.max(0, r17 - (r10 - r14));
        int r3 = Math.max(r15, r16);
        int r18 = Math.min(r14, r10 - r17);
        if (shouldLayout(this.mExpandedActionView) == false) goto L33;
        if (r1 == false) goto L31;
        r18 = layoutChildRight(this.mExpandedActionView, r18, r11, r13);
        goto L33
    L31:
        r3 = layoutChildLeft(this.mExpandedActionView, r3, r11, r13);
    L33:
        if (shouldLayout(this.mLogoView) == false) goto L37;
        if (r1 == false) goto L36;
        r18 = layoutChildRight(this.mLogoView, r18, r11, r13);
        goto L37
    L36:
        r3 = layoutChildLeft(this.mLogoView, r3, r11, r13);
    L37:
        boolean r19 = shouldLayout(this.mTitleTextView);
        boolean r110 = shouldLayout(this.mSubtitleTextView);
        if (r19 == false) goto L40;
        LayoutParams r111 = (LayoutParams) this.mTitleTextView.getLayoutParams();
        int r2 = ((((ViewGroup.MarginLayoutParams) r111).topMargin + this.mTitleTextView.getMeasuredHeight()) + ((ViewGroup.MarginLayoutParams) r111).bottomMargin) + 0;
    L41:
        if (r110 == false) goto L44;
        LayoutParams r25 = (LayoutParams) this.mSubtitleTextView.getLayoutParams();
        r2 = r2 + ((((ViewGroup.MarginLayoutParams) r25).topMargin + this.mSubtitleTextView.getMeasuredHeight()) + ((ViewGroup.MarginLayoutParams) r25).bottomMargin);
    L44:
        if (r19 == true) goto L49;
        if (r110 == true) goto L49;
        int r112 = r6;
        r13 = r13;
    L48:
        int r26 = 0;
    L103:
        addCustomViewsWithGravity(this.mTempViews, 3);
        int r27 = this.mTempViews.size();
        int r28 = 0;
    L104:
        if (r28 >= r27) goto L106;
        r3 = layoutChildLeft((View) ListProtector.get(this.mTempViews, r28), r3, r11, r13);
        r28 = r28 + 1;
        goto L104
    L106:
        int r113 = r13;
        addCustomViewsWithGravity(this.mTempViews, 5);
        int r29 = this.mTempViews.size();
        int r30 = 0;
    L107:
        if (r30 >= r29) goto L109;
        r18 = layoutChildRight((View) ListProtector.get(this.mTempViews, r30), r18, r11, r113);
        r30 = r30 + 1;
        goto L107
    L109:
        addCustomViewsWithGravity(this.mTempViews, 1);
        int r31 = getViewListMeasuredWidth(this.mTempViews, r11);
        int r32 = (r112 + (((r4 - r112) - r7) / 2)) - (r31 / 2);
        int r33 = r31 + r32;
        if (r32 < r3) goto L115;
        if (r33 <= r18) goto L114;
        r3 = r32 - (r33 - r18);
        goto L115
    L114:
        r3 = r32;
    L115:
        int r34 = this.mTempViews.size();
    L116:
        if (r26 >= r34) goto L118;
        r3 = layoutChildLeft((View) ListProtector.get(this.mTempViews, r26), r3, r11, r113);
        r26 = r26 + 1;
        goto L116
    L118:
        this.mTempViews.clear();
        return;
    L49:
        if (r19 == false) goto L51;
        TextView r35 = this.mTitleTextView;
    L52:
        if (r110 == false) goto L54;
        TextView r36 = this.mSubtitleTextView;
    L55:
        LayoutParams r37 = (LayoutParams) r35.getLayoutParams();
        LayoutParams r38 = (LayoutParams) r36.getLayoutParams();
        if (r19 == true) goto L58;
    L59:
        if (r110 == true) goto L61;
    L63:
        boolean r114 = false;
    L64:
        int r115 = this.mGravity & 112;
        r112 = r6;
        if (r115 != 48) goto L67;
        int r39 = (getPaddingTop() + ((ViewGroup.MarginLayoutParams) r37).topMargin) + this.mTitleMarginTop;
    L77:
        if (r1 == false) goto L91;
        if (r114 == false) goto L80;
        int r40 = this.mTitleMarginStart;
    L81:
        int r41 = r40 - r11[1];
        r18 = r18 - Math.max(0, r41);
        r11[1] = Math.max(0, -r41);
        if (r19 == false) goto L84;
        LayoutParams r42 = (LayoutParams) this.mTitleTextView.getLayoutParams();
        int r43 = r18 - this.mTitleTextView.getMeasuredWidth();
        int r44 = this.mTitleTextView.getMeasuredHeight() + r39;
        this.mTitleTextView.layout(r43, r39, r18, r44);
        int r45 = r43 - this.mTitleMarginEnd;
        r39 = r44 + ((ViewGroup.MarginLayoutParams) r42).bottomMargin;
    L85:
        if (r110 == false) goto L87;
        int r46 = r39 + ((ViewGroup.MarginLayoutParams) ((LayoutParams) this.mSubtitleTextView.getLayoutParams())).topMargin;
        int r47 = r18 - this.mSubtitleTextView.getMeasuredWidth();
        int r48 = this.mSubtitleTextView.getMeasuredHeight() + r46;
        this.mSubtitleTextView.layout(r47, r46, r18, r48);
        int r49 = r18 - this.mTitleMarginEnd;
    L88:
        if (r114 == false) goto L90;
        r18 = Math.min(r45, r49);
    L90:
        r3 = r3;
        goto L48
    L87:
        r49 = r18;
        goto L88
    L84:
        r45 = r18;
        goto L85
    L80:
        r40 = 0;
        goto L81
    L91:
        if (r114 == false) goto L93;
        int r50 = this.mTitleMarginStart;
        r26 = 0;
    L94:
        int r51 = r50 - r11[r26];
        r3 = r3 + Math.max(r26, r51);
        r11[r26] = Math.max(r26, -r51);
        if (r19 == false) goto L97;
        LayoutParams r52 = (LayoutParams) this.mTitleTextView.getLayoutParams();
        int r53 = this.mTitleTextView.getMeasuredWidth() + r3;
        int r54 = this.mTitleTextView.getMeasuredHeight() + r39;
        this.mTitleTextView.layout(r3, r39, r53, r54);
        int r55 = r53 + this.mTitleMarginEnd;
        r39 = r54 + ((ViewGroup.MarginLayoutParams) r52).bottomMargin;
    L98:
        if (r110 == false) goto L100;
        int r56 = r39 + ((ViewGroup.MarginLayoutParams) ((LayoutParams) this.mSubtitleTextView.getLayoutParams())).topMargin;
        int r57 = this.mSubtitleTextView.getMeasuredWidth() + r3;
        int r58 = this.mSubtitleTextView.getMeasuredHeight() + r56;
        this.mSubtitleTextView.layout(r3, r56, r57, r58);
        int r59 = r57 + this.mTitleMarginEnd;
    L101:
        if (r114 == false) goto L103;
        r3 = Math.max(r55, r59);
        goto L103
    L100:
        r59 = r3;
        goto L101
    L97:
        r55 = r3;
        goto L98
    L93:
        r26 = 0;
        r50 = 0;
        goto L94
    L67:
        if (r115 == 80) goto L75;
        int r60 = (((r5 - r8) - r9) - r2) / 2;
        int r116 = ((ViewGroup.MarginLayoutParams) r37).topMargin;
        int r117 = this.mTitleMarginTop;
        if (r60 >= (r116 + r117)) goto L71;
        r60 = r116 + r117;
    L74:
        r39 = r8 + r60;
        goto L77
    L71:
        int r61 = (((r5 - r9) - r2) - r60) - r8;
        int r62 = ((ViewGroup.MarginLayoutParams) r37).bottomMargin;
        int r63 = this.mTitleMarginBottom;
        if (r61 >= (r62 + r63)) goto L74;
        r60 = Math.max(0, r60 - ((((ViewGroup.MarginLayoutParams) r38).bottomMargin + r63) - r61));
        goto L74
    L75:
        r39 = (((r5 - r9) - ((ViewGroup.MarginLayoutParams) r38).bottomMargin) - this.mTitleMarginBottom) - r2;
        goto L77
    L61:
        if (this.mSubtitleTextView.getMeasuredWidth() <= 0) goto L63;
    L62:
        r114 = true;
        goto L64
    L58:
        if (this.mTitleTextView.getMeasuredWidth() > 0) goto L62;
    L54:
        r36 = this.mTitleTextView;
        goto L55
    L51:
        r35 = this.mSubtitleTextView;
        goto L52
    L40:
        r2 = 0;
        goto L41
    L14:
        r15 = layoutChildLeft(this.mNavButtonView, r6, r11, r13);
    L16:
        r14 = r10;
        goto L18
    L15:
        r15 = r6;
        goto L16
    L9:
        r13 = 0;
        goto L11
    L5:
        r1 = false;
        goto L6
    }

    private int measureChildCollapseMargins(View r8, int r9, int r10, int r11, int r12, int[] r13) {
        ViewGroup.MarginLayoutParams r0 = (ViewGroup.MarginLayoutParams) r8.getLayoutParams();
        int r1 = r0.leftMargin - r13[0];
        int r3 = r0.rightMargin - r13[1];
        int r5 = Math.max(0, r1) + Math.max(0, r3);
        r13[0] = Math.max(0, -r1);
        r13[1] = Math.max(0, -r3);
        r8.measure(ViewGroup.getChildMeasureSpec(r9, ((getPaddingLeft() + getPaddingRight()) + r5) + r10, r0.width), ViewGroup.getChildMeasureSpec(r11, (((getPaddingTop() + getPaddingBottom()) + r0.topMargin) + r0.bottomMargin) + r12, r0.height));
        return r8.getMeasuredWidth() + r5;
    }

    private void measureChildConstrained(View r4, int r5, int r6, int r7, int r8, int r9) {
        ViewGroup.MarginLayoutParams r0 = (ViewGroup.MarginLayoutParams) r4.getLayoutParams();
        int r10 = ViewGroup.getChildMeasureSpec(r5, (((getPaddingLeft() + getPaddingRight()) + r0.leftMargin) + r0.rightMargin) + r6, r0.width);
        int r11 = ViewGroup.getChildMeasureSpec(r7, (((getPaddingTop() + getPaddingBottom()) + r0.topMargin) + r0.bottomMargin) + r8, r0.height);
        int r12 = View.MeasureSpec.getMode(r11);
        if (r12 == 1073741824) goto L8;
        if (r9 < 0) goto L8;
        if (r12 == 0) goto L7;
        r9 = Math.min(View.MeasureSpec.getSize(r11), r9);
    L7:
        r11 = View.MeasureSpec.makeMeasureSpec(r9, 1073741824);
    L8:
        r4.measure(r10, r11);
    }
}
