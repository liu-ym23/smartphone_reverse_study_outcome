package androidx.appcompat.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug;
import android.widget.LinearLayout;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.view.ActionProvider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class MenuItemImpl implements SupportMenuItem {
    private static final int CHECKABLE = 1;
    private static final int CHECKED = 2;
    private static final int ENABLED = 16;
    private static final int EXCLUSIVE = 4;
    private static final int HIDDEN = 8;
    private static final int IS_ACTION = 32;
    static final int NO_ICON = 0;
    private static final int SHOW_AS_ACTION_MASK = 3;
    private static final String TAG = "MenuItemImpl";
    private ActionProvider mActionProvider;
    private View mActionView;
    private final int mCategoryOrder;
    private MenuItem.OnMenuItemClickListener mClickListener;
    private CharSequence mContentDescription;
    private int mFlags;
    private final int mGroup;
    private boolean mHasIconTint;
    private boolean mHasIconTintMode;
    private Drawable mIconDrawable;
    private int mIconResId;
    private ColorStateList mIconTintList;
    private PorterDuff.Mode mIconTintMode;
    private final int mId;
    private Intent mIntent;
    private boolean mIsActionViewExpanded;
    private Runnable mItemCallback;
    MenuBuilder mMenu;
    private ContextMenu.ContextMenuInfo mMenuInfo;
    private boolean mNeedToApplyIconTint;
    private MenuItem.OnActionExpandListener mOnActionExpandListener;
    private final int mOrdering;
    private char mShortcutAlphabeticChar;
    private int mShortcutAlphabeticModifiers;
    private char mShortcutNumericChar;
    private int mShortcutNumericModifiers;
    private int mShowAsAction;
    private SubMenuBuilder mSubMenu;
    private CharSequence mTitle;
    private CharSequence mTitleCondensed;
    private CharSequence mTooltipText;

    public void actionFormatChanged() {
        this.mMenu.onItemActionRequestChanged(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean collapseActionView() {
        if ((this.mShowAsAction & 8) != 0) goto L6;
        return false;
    L6:
        if (this.mActionView != null) goto L9;
        return true;
    L9:
        MenuItem.OnActionExpandListener r0 = this.mOnActionExpandListener;
        if (r0 == null) goto L16;
        if (r0.onMenuItemActionCollapse(this) == true) goto L16;
        return false;
    L16:
        return this.mMenu.collapseItemActionView(this);
    }

    public android.view.ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View getActionView() {
        View r0 = this.mActionView;
        if (r0 == null) goto L5;
        return r0;
    L5:
        ActionProvider r1 = this.mActionProvider;
        if (r1 == null) goto L9;
        View r2 = r1.onCreateActionView(this);
        this.mActionView = r2;
        return r2;
    L9:
        return null;
    }

    public Drawable getIcon() {
        Drawable r0 = this.mIconDrawable;
        if (r0 == null) goto L7;
        return applyIconTintIfNecessary(r0);
    L7:
        if (this.mIconResId == 0) goto L10;
        Drawable r1 = AppCompatResources.getDrawable(this.mMenu.getContext(), this.mIconResId);
        this.mIconResId = 0;
        this.mIconDrawable = r1;
        return applyIconTintIfNecessary(r1);
    L10:
        return null;
    }

    public char getShortcut() {
        if (this.mMenu.isQwertyMode() == false) goto L6;
        return this.mShortcutAlphabeticChar;
    L6:
        return this.mShortcutNumericChar;
    }

    public CharSequence getTitleCondensed() {
        CharSequence r0 = this.mTitleCondensed;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return this.mTitle;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean hasCollapsibleActionView() {
        if ((this.mShowAsAction & 8) != 0) goto L5;
        return false;
    L5:
        if (this.mActionView != null) goto L10;
        ActionProvider r0 = this.mActionProvider;
        if (r0 == null) goto L10;
        this.mActionView = r0.onCreateActionView(this);
    L10:
        if (this.mActionView == null) goto L14;
        return true;
    L14:
        return false;
    }

    public boolean hasSubMenu() {
        if (this.mSubMenu == null) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean invoke() {
        MenuItem.OnMenuItemClickListener r0 = this.mClickListener;
        if (r0 != null) goto L5;
    L7:
        MenuBuilder r1 = this.mMenu;
        if (r1.dispatchMenuItemSelected(r1, this) == false) goto L10;
        return true;
    L10:
        Runnable r2 = this.mItemCallback;
        if (r2 == null) goto L15;
        r2.run();
        return true;
    L15:
        if (this.mIntent != null) goto L26;
    L19:
        ActionProvider r3 = this.mActionProvider;
        if (r3 != null) goto L22;
        return false;
    L22:
        if (r3.onPerformDefaultAction() == false) goto L28;
        return true;
    L28:
        return false;
    L26:
        this.mMenu.getContext().startActivity(this.mIntent);     // Catch: ActivityNotFoundException -> L18
        return true;
    L5:
        if (r0.onMenuItemClick(this) == false) goto L7;
        return true;
    }

    public boolean isActionButton() {
        if ((this.mFlags & IS_ACTION) != IS_ACTION) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isCheckable() {
        if ((this.mFlags & 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isChecked() {
        if ((this.mFlags & 2) != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isEnabled() {
        if ((this.mFlags & 16) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isExclusiveCheckable() {
        if ((this.mFlags & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isVisible() {
        ActionProvider r0 = this.mActionProvider;
        if (r0 == null) goto L14;
        if (r0.overridesItemVisibility() == false) goto L14;
        if ((this.mFlags & 8) == 0) goto L9;
    L11:
        return false;
    L9:
        if (this.mActionProvider.isVisible() == false) goto L11;
        return true;
    L14:
        if ((this.mFlags & 8) == 0) goto L19;
        return false;
    L19:
        return true;
    }

    public boolean requestsActionButton() {
        if ((this.mShowAsAction & 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean requiresActionButton() {
        if ((this.mShowAsAction & 2) != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean shouldShowIcon() {
        return this.mMenu.getOptionalIconsVisible();
    }

    public boolean shouldShowShortcut() {
        if (this.mMenu.isShortcutsVisible() == true) goto L5;
    L7:
        return false;
    L5:
        if (getShortcut() == 0) goto L7;
        return true;
    }

    public boolean showsTextAsAction() {
        if ((this.mShowAsAction & 4) != 4) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        CharSequence r0 = this.mTitle;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean expandActionView() {
        if (hasCollapsibleActionView() == true) goto L5;
        return false;
    L5:
        MenuItem.OnActionExpandListener r0 = this.mOnActionExpandListener;
        if (r0 == null) goto L12;
        if (r0.onMenuItemActionExpand(this) == true) goto L12;
        return false;
    L12:
        return this.mMenu.expandItemActionView(this);
    }

    public String getShortcutLabel() {
        char r0 = getShortcut();
        if (r0 != 0) goto L6;
        return "";
    L6:
        Resources r1 = this.mMenu.getContext().getResources();
        StringBuilder r2 = new StringBuilder();
        if (ViewConfiguration.get(this.mMenu.getContext()).hasPermanentMenuKey() == false) goto L10;
        r2.append(r1.getString(2131894056));
    L10:
        if (this.mMenu.isQwertyMode() == false) goto L12;
        int r3 = this.mShortcutAlphabeticModifiers;
    L13:
        appendModifier(r2, r3, 65536, r1.getString(2131894052));
        appendModifier(r2, r3, 4096, r1.getString(2131894048));
        appendModifier(r2, r3, 2, r1.getString(2131894047));
        appendModifier(r2, r3, 1, r1.getString(2131894053));
        appendModifier(r2, r3, 4, r1.getString(2131894055));
        appendModifier(r2, r3, 8, r1.getString(2131894051));
        if (r0 != '\b') goto L16;
        r2.append(r1.getString(2131894049));
    L24:
        return r2.toString();
    L16:
        if (r0 != '\n') goto L18;
        r2.append(r1.getString(2131894050));
        goto L24
    L18:
        if (r0 == IS_ACTION) goto L20;
        r2.append(r0);
        goto L24
    L20:
        r2.append(r1.getString(2131894054));
        goto L24
    L12:
        r3 = this.mShortcutNumericModifiers;
        goto L13
    }

    public boolean requiresOverflow() {
        if (requiresActionButton() == false) goto L5;
    L7:
        return false;
    L5:
        if (requestsActionButton() == true) goto L7;
        return true;
    }

    public int getAlphabeticModifiers() {
        return this.mShortcutAlphabeticModifiers;
    }

    public char getAlphabeticShortcut() {
        return this.mShortcutAlphabeticChar;
    }

    public Runnable getCallback() {
        return this.mItemCallback;
    }

    public CharSequence getContentDescription() {
        return this.mContentDescription;
    }

    public int getGroupId() {
        return this.mGroup;
    }

    public ColorStateList getIconTintList() {
        return this.mIconTintList;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.mIconTintMode;
    }

    public Intent getIntent() {
        return this.mIntent;
    }

    @ViewDebug.CapturedViewProperty
    public int getItemId() {
        return this.mId;
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.mMenuInfo;
    }

    public int getNumericModifiers() {
        return this.mShortcutNumericModifiers;
    }

    public char getNumericShortcut() {
        return this.mShortcutNumericChar;
    }

    public int getOrder() {
        return this.mCategoryOrder;
    }

    public int getOrdering() {
        return this.mOrdering;
    }

    public SubMenu getSubMenu() {
        return this.mSubMenu;
    }

    public ActionProvider getSupportActionProvider() {
        return this.mActionProvider;
    }

    @ViewDebug.CapturedViewProperty
    public CharSequence getTitle() {
        return this.mTitle;
    }

    public CharSequence getTooltipText() {
        return this.mTooltipText;
    }

    public boolean isActionViewExpanded() {
        return this.mIsActionViewExpanded;
    }

    private Drawable applyIconTintIfNecessary(Drawable r2) {
        if (r2 != null) goto L4;
    L16:
        return r2;
    L4:
        if (this.mNeedToApplyIconTint == false) goto L16;
        if (this.mHasIconTint == false) goto L8;
    L9:
        r2 = DrawableCompat.wrap(r2).mutate();
        if (this.mHasIconTint == false) goto L13;
        DrawableCompat.setTintList(r2, this.mIconTintList);
    L13:
        if (this.mHasIconTintMode == false) goto L15;
        DrawableCompat.setTintMode(r2, this.mIconTintMode);
    L15:
        this.mNeedToApplyIconTint = false;
        goto L16
    L8:
        if (this.mHasIconTintMode == false) goto L16;
        goto L9
    }

    public CharSequence getTitleForItemView(MenuView.ItemView r1) {
        if (r1 == null) goto L7;
        if (r1.prefersCondensedTitle() == false) goto L7;
        return getTitleCondensed();
    L7:
        return getTitle();
    }

    public MenuItem setActionProvider(android.view.ActionProvider r2) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    /* JADX INFO: renamed from: setActionView, reason: collision with other method in class */
    public SupportMenuItem m67setActionView(View r3) {
        this.mActionView = r3;
        this.mActionProvider = null;
        if (r3 != null) goto L5;
    L9:
        this.mMenu.onItemActionRequestChanged(this);
        return this;
    L5:
        if (r3.getId() != (-1)) goto L9;
        int r0 = this.mId;
        if (r0 <= 0) goto L9;
        r3.setId(r0);
        goto L9
    }

    public void setActionViewExpanded(boolean r2) {
        this.mIsActionViewExpanded = r2;
        this.mMenu.onItemsChanged(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MenuItem setAlphabeticShortcut(char r2) {
        if (this.mShortcutAlphabeticChar != r2) goto L5;
        return this;
    L5:
        this.mShortcutAlphabeticChar = Character.toLowerCase(r2);
        this.mMenu.onItemsChanged(false);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MenuItem setCallback(Runnable r1) {
        this.mItemCallback = r1;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MenuItem setCheckable(boolean r3) {
        int r0 = this.mFlags;
        int r4 = r3 ? 1 : 0;
        int r5 = r4 | (r0 & (-2));
        this.mFlags = r5;
        if (r0 == r5) goto L5;
        this.mMenu.onItemsChanged(false);
    L5:
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MenuItem setChecked(boolean r2) {
        if ((this.mFlags & 4) == 0) goto L5;
        this.mMenu.setExclusiveItemChecked(this);
    L6:
        return this;
    L5:
        setCheckedInt(r2);
        goto L6
    }

    public void setCheckedInt(boolean r4) {
        int r0 = this.mFlags;
        int r1 = r0 & (-3);
        if (r4 == false) goto L5;
        int r5 = 2;
    L6:
        int r6 = r5 | r1;
        this.mFlags = r6;
        if (r0 == r6) goto L10;
        this.mMenu.onItemsChanged(false);
        return;
    L10:
        return;
    L5:
        r5 = 0;
        goto L6
    }

    /* JADX INFO: renamed from: setContentDescription, reason: collision with other method in class */
    public SupportMenuItem m68setContentDescription(CharSequence r2) {
        this.mContentDescription = r2;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MenuItem setEnabled(boolean r2) {
        if (r2 == false) goto L4;
        this.mFlags |= 16;
    L5:
        this.mMenu.onItemsChanged(false);
        return this;
    L4:
        this.mFlags &= -17;
        goto L5
    }

    public void setExclusiveCheckable(boolean r2) {
        int r0 = this.mFlags & (-5);
        if (r2 == false) goto L5;
        int r3 = 4;
    L6:
        this.mFlags = r3 | r0;
        return;
    L5:
        r3 = 0;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MenuItem setIcon(int r2) {
        this.mIconDrawable = null;
        this.mIconResId = r2;
        this.mNeedToApplyIconTint = true;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MenuItem setIconTintList(ColorStateList r2) {
        this.mIconTintList = r2;
        this.mHasIconTint = true;
        this.mNeedToApplyIconTint = true;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MenuItem setIconTintMode(PorterDuff.Mode r2) {
        this.mIconTintMode = r2;
        this.mHasIconTintMode = true;
        this.mNeedToApplyIconTint = true;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MenuItem setIntent(Intent r1) {
        this.mIntent = r1;
        return this;
    }

    public void setIsActionButton(boolean r1) {
        if (r1 == false) goto L4;
        this.mFlags |= IS_ACTION;
        return;
    L4:
        this.mFlags &= -33;
    }

    public void setMenuInfo(ContextMenu.ContextMenuInfo r1) {
        this.mMenuInfo = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MenuItem setNumericShortcut(char r2) {
        if (this.mShortcutNumericChar != r2) goto L5;
        return this;
    L5:
        this.mShortcutNumericChar = r2;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener r1) {
        this.mOnActionExpandListener = r1;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener r1) {
        this.mClickListener = r1;
        return this;
    }

    public void setShowAsAction(int r3) {
        int r0 = r3 & 3;
        if (r0 != 0) goto L5;
    L11:
        this.mShowAsAction = r3;
        this.mMenu.onItemActionRequestChanged(this);
        return;
    L5:
        if (r0 == 1) goto L11;
        if (r0 == 2) goto L11;
        throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
    }

    public /* bridge */ /* synthetic */ MenuItem setShowAsActionFlags(int r1) {
        return m69setShowAsActionFlags(r1);
    }

    public void setSubMenu(SubMenuBuilder r2) {
        this.mSubMenu = r2;
        r2.setHeaderTitle(getTitle());
    }

    public SupportMenuItem setSupportActionProvider(ActionProvider r2) {
        ActionProvider r0 = this.mActionProvider;
        if (r0 == null) goto L5;
        r0.reset();
    L5:
        this.mActionView = null;
        this.mActionProvider = r2;
        this.mMenu.onItemsChanged(true);
        ActionProvider r3 = this.mActionProvider;
        if (r3 == null) goto L8;
        r3.setVisibilityListener(new AnonymousClass1(this));
    L8:
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MenuItem setTitle(CharSequence r3) {
        this.mTitle = r3;
        this.mMenu.onItemsChanged(false);
        SubMenuBuilder r0 = this.mSubMenu;
        if (r0 == null) goto L5;
        r0.setHeaderTitle(r3);
    L5:
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MenuItem setTitleCondensed(CharSequence r2) {
        this.mTitleCondensed = r2;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    /* JADX INFO: renamed from: setTooltipText, reason: collision with other method in class */
    public SupportMenuItem m70setTooltipText(CharSequence r2) {
        this.mTooltipText = r2;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MenuItem setVisible(boolean r1) {
        if (setVisibleInt(r1) == false) goto L5;
        this.mMenu.onItemVisibleChanged(this);
    L5:
        return this;
    }

    public boolean setVisibleInt(boolean r4) {
        int r0 = this.mFlags;
        int r1 = r0 & (-9);
        if (r4 == false) goto L5;
        int r5 = 0;
    L6:
        int r6 = r5 | r1;
        this.mFlags = r6;
        if (r0 == r6) goto L10;
        return true;
    L10:
        return false;
    L5:
        r5 = 8;
        goto L6
    }

    /* JADX INFO: renamed from: setActionView, reason: collision with other method in class */
    public SupportMenuItem m66setActionView(int r4) {
        Context r0 = this.mMenu.getContext();
        m67setActionView(LayoutInflater.from(r0).inflate(r4, new LinearLayout(r0), false));
        return this;
    }

    public /* bridge */ /* synthetic */ MenuItem setContentDescription(CharSequence r1) {
        return m68setContentDescription(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MenuItem setIcon(Drawable r2) {
        this.mIconResId = 0;
        this.mIconDrawable = r2;
        this.mNeedToApplyIconTint = true;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    /* JADX INFO: renamed from: setShowAsActionFlags, reason: collision with other method in class */
    public SupportMenuItem m69setShowAsActionFlags(int r1) {
        setShowAsAction(r1);
        return this;
    }

    public MenuItem setTitle(int r2) {
        return setTitle(this.mMenu.getContext().getString(r2));
    }

    public /* bridge */ /* synthetic */ MenuItem setTooltipText(CharSequence r1) {
        return m70setTooltipText(r1);
    }

    public /* bridge */ /* synthetic */ MenuItem setActionView(int r1) {
        return m66setActionView(r1);
    }

    public /* bridge */ /* synthetic */ MenuItem setActionView(View r1) {
        return m67setActionView(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MenuItem setAlphabeticShortcut(char r2, int r3) {
        if (this.mShortcutAlphabeticChar == r2) goto L5;
    L7:
        this.mShortcutAlphabeticChar = Character.toLowerCase(r2);
        this.mShortcutAlphabeticModifiers = KeyEvent.normalizeMetaState(r3);
        this.mMenu.onItemsChanged(false);
        return this;
    L5:
        if (this.mShortcutAlphabeticModifiers != r3) goto L7;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MenuItem setNumericShortcut(char r2, int r3) {
        if (this.mShortcutNumericChar == r2) goto L5;
    L7:
        this.mShortcutNumericChar = r2;
        this.mShortcutNumericModifiers = KeyEvent.normalizeMetaState(r3);
        this.mMenu.onItemsChanged(false);
        return this;
    L5:
        if (this.mShortcutNumericModifiers != r3) goto L7;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MenuItem setShortcut(char r1, char r2) {
        this.mShortcutNumericChar = r1;
        this.mShortcutAlphabeticChar = Character.toLowerCase(r2);
        this.mMenu.onItemsChanged(false);
        return this;
    }

    private static void appendModifier(StringBuilder r0, int r1, int r2, String r3) {
        if ((r1 & r2) != r2) goto L6;
        r0.append(r3);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MenuItem setShortcut(char r1, char r2, int r3, int r4) {
        this.mShortcutNumericChar = r1;
        this.mShortcutNumericModifiers = KeyEvent.normalizeMetaState(r3);
        this.mShortcutAlphabeticChar = Character.toLowerCase(r2);
        this.mShortcutAlphabeticModifiers = KeyEvent.normalizeMetaState(r4);
        this.mMenu.onItemsChanged(false);
        return this;
    }

    public MenuItemImpl(MenuBuilder r3, int r4, int r5, int r6, int r7, CharSequence r8, int r9) {
        this.mShortcutNumericModifiers = 4096;
        this.mShortcutAlphabeticModifiers = 4096;
        this.mIconResId = 0;
        this.mIconTintList = null;
        this.mIconTintMode = null;
        this.mHasIconTint = false;
        this.mHasIconTintMode = false;
        this.mNeedToApplyIconTint = false;
        this.mFlags = 16;
        this.mIsActionViewExpanded = false;
        this.mMenu = r3;
        this.mId = r5;
        this.mGroup = r4;
        this.mCategoryOrder = r6;
        this.mOrdering = r7;
        this.mTitle = r8;
        this.mShowAsAction = r9;
    }
}
