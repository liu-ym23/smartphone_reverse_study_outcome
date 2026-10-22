package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.view.ActionProvider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class ActionMenuItem implements SupportMenuItem {
    private static final int CHECKABLE = 1;
    private static final int CHECKED = 2;
    private static final int ENABLED = 16;
    private static final int EXCLUSIVE = 4;
    private static final int HIDDEN = 8;
    private MenuItem.OnMenuItemClickListener mClickListener;
    private CharSequence mContentDescription;
    private Context mContext;
    private int mFlags;
    private final int mGroup;
    private boolean mHasIconTint;
    private boolean mHasIconTintMode;
    private Drawable mIconDrawable;
    private ColorStateList mIconTintList;
    private PorterDuff.Mode mIconTintMode;
    private final int mId;
    private Intent mIntent;
    private final int mOrdering;
    private char mShortcutAlphabeticChar;
    private int mShortcutAlphabeticModifiers;
    private char mShortcutNumericChar;
    private int mShortcutNumericModifiers;
    private CharSequence mTitle;
    private CharSequence mTitleCondensed;
    private CharSequence mTooltipText;

    public boolean collapseActionView() {
        return false;
    }

    public boolean expandActionView() {
        return false;
    }

    public View getActionView() {
        return null;
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    public SubMenu getSubMenu() {
        return null;
    }

    public ActionProvider getSupportActionProvider() {
        return null;
    }

    public boolean hasSubMenu() {
        return false;
    }

    public boolean isActionViewExpanded() {
        return false;
    }

    public boolean requiresActionButton() {
        return true;
    }

    public boolean requiresOverflow() {
        return false;
    }

    public void setShowAsAction(int r1) {
    }

    private void applyIconTint() {
        Drawable r0 = this.mIconDrawable;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.mHasIconTint == false) goto L7;
    L8:
        Drawable r1 = DrawableCompat.wrap(r0);
        this.mIconDrawable = r1;
        Drawable r2 = r1.mutate();
        this.mIconDrawable = r2;
        if (this.mHasIconTint == false) goto L12;
        DrawableCompat.setTintList(r2, this.mIconTintList);
    L12:
        if (this.mHasIconTintMode == false) goto L17;
        DrawableCompat.setTintMode(this.mIconDrawable, this.mIconTintMode);
        return;
    L17:
        return;
    L7:
        if (this.mHasIconTintMode == true) goto L8;
    }

    public android.view.ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    public CharSequence getTitleCondensed() {
        CharSequence r0 = this.mTitleCondensed;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return this.mTitle;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean invoke() {
        MenuItem.OnMenuItemClickListener r0 = this.mClickListener;
        if (r0 != null) goto L5;
    L7:
        Intent r1 = this.mIntent;
        if (r1 == null) goto L11;
        this.mContext.startActivity(r1);
        return true;
    L11:
        return false;
    L5:
        if (r0.onMenuItemClick(this) == false) goto L7;
        return true;
    }

    public boolean isCheckable() {
        if ((this.mFlags & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isChecked() {
        if ((this.mFlags & 2) == 0) goto L5;
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

    public boolean isVisible() {
        if ((this.mFlags & 8) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public int getAlphabeticModifiers() {
        return this.mShortcutAlphabeticModifiers;
    }

    public char getAlphabeticShortcut() {
        return this.mShortcutAlphabeticChar;
    }

    public CharSequence getContentDescription() {
        return this.mContentDescription;
    }

    public int getGroupId() {
        return this.mGroup;
    }

    public Drawable getIcon() {
        return this.mIconDrawable;
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

    public int getItemId() {
        return this.mId;
    }

    public int getNumericModifiers() {
        return this.mShortcutNumericModifiers;
    }

    public char getNumericShortcut() {
        return this.mShortcutNumericChar;
    }

    public int getOrder() {
        return this.mOrdering;
    }

    public CharSequence getTitle() {
        return this.mTitle;
    }

    public CharSequence getTooltipText() {
        return this.mTooltipText;
    }

    public MenuItem setActionProvider(android.view.ActionProvider r1) {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: renamed from: setActionView, reason: collision with other method in class */
    public SupportMenuItem m61setActionView(int r1) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MenuItem setAlphabeticShortcut(char r1) {
        this.mShortcutAlphabeticChar = Character.toLowerCase(r1);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MenuItem setCheckable(boolean r2) {
        int r0 = this.mFlags & (-2);
        this.mFlags = (r2 ? 1 : 0) | r0;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MenuItem setChecked(boolean r2) {
        int r0 = this.mFlags & (-3);
        if (r2 == false) goto L5;
        int r3 = 2;
    L6:
        this.mFlags = r3 | r0;
        return this;
    L5:
        r3 = 0;
        goto L6
    }

    public /* bridge */ /* synthetic */ MenuItem setContentDescription(CharSequence r1) {
        return m63setContentDescription(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MenuItem setEnabled(boolean r2) {
        int r0 = this.mFlags & (-17);
        if (r2 == false) goto L5;
        int r3 = 16;
    L6:
        this.mFlags = r3 | r0;
        return this;
    L5:
        r3 = 0;
        goto L6
    }

    public ActionMenuItem setExclusiveCheckable(boolean r2) {
        int r0 = this.mFlags & (-5);
        if (r2 == false) goto L5;
        int r3 = 4;
    L6:
        this.mFlags = r3 | r0;
        return this;
    L5:
        r3 = 0;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MenuItem setIcon(int r2) {
        this.mIconDrawable = ContextCompat.getDrawable(this.mContext, r2);
        applyIconTint();
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MenuItem setIconTintList(ColorStateList r1) {
        this.mIconTintList = r1;
        this.mHasIconTint = true;
        applyIconTint();
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MenuItem setIconTintMode(PorterDuff.Mode r1) {
        this.mIconTintMode = r1;
        this.mHasIconTintMode = true;
        applyIconTint();
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MenuItem setIntent(Intent r1) {
        this.mIntent = r1;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MenuItem setNumericShortcut(char r1) {
        this.mShortcutNumericChar = r1;
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener r1) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener r1) {
        this.mClickListener = r1;
        return this;
    }

    public /* bridge */ /* synthetic */ MenuItem setShowAsActionFlags(int r1) {
        return m64setShowAsActionFlags(r1);
    }

    public SupportMenuItem setSupportActionProvider(ActionProvider r1) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MenuItem setTitle(int r2) {
        this.mTitle = this.mContext.getResources().getString(r2);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MenuItem setTitleCondensed(CharSequence r1) {
        this.mTitleCondensed = r1;
        return this;
    }

    public /* bridge */ /* synthetic */ MenuItem setTooltipText(CharSequence r1) {
        return m65setTooltipText(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MenuItem setVisible(boolean r3) {
        int r1 = 8;
        int r0 = this.mFlags & 8;
        if (r3 == false) goto L5;
        r1 = 0;
    L5:
        this.mFlags = r0 | r1;
        return this;
    }

    /* JADX INFO: renamed from: setActionView, reason: collision with other method in class */
    public SupportMenuItem m62setActionView(View r1) {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: renamed from: setContentDescription, reason: collision with other method in class */
    public SupportMenuItem m63setContentDescription(CharSequence r1) {
        this.mContentDescription = r1;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MenuItem setIcon(Drawable r1) {
        this.mIconDrawable = r1;
        applyIconTint();
        return this;
    }

    /* JADX INFO: renamed from: setShowAsActionFlags, reason: collision with other method in class */
    public SupportMenuItem m64setShowAsActionFlags(int r1) {
        setShowAsAction(r1);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MenuItem setTitle(CharSequence r1) {
        this.mTitle = r1;
        return this;
    }

    /* JADX INFO: renamed from: setTooltipText, reason: collision with other method in class */
    public SupportMenuItem m65setTooltipText(CharSequence r1) {
        this.mTooltipText = r1;
        return this;
    }

    public /* bridge */ /* synthetic */ MenuItem setActionView(int r1) {
        return m61setActionView(r1);
    }

    public /* bridge */ /* synthetic */ MenuItem setActionView(View r1) {
        return m62setActionView(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MenuItem setAlphabeticShortcut(char r1, int r2) {
        this.mShortcutAlphabeticChar = Character.toLowerCase(r1);
        this.mShortcutAlphabeticModifiers = KeyEvent.normalizeMetaState(r2);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MenuItem setNumericShortcut(char r1, int r2) {
        this.mShortcutNumericChar = r1;
        this.mShortcutNumericModifiers = KeyEvent.normalizeMetaState(r2);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MenuItem setShortcut(char r1, char r2) {
        this.mShortcutNumericChar = r1;
        this.mShortcutAlphabeticChar = Character.toLowerCase(r2);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MenuItem setShortcut(char r1, char r2, int r3, int r4) {
        this.mShortcutNumericChar = r1;
        this.mShortcutNumericModifiers = KeyEvent.normalizeMetaState(r3);
        this.mShortcutAlphabeticChar = Character.toLowerCase(r2);
        this.mShortcutAlphabeticModifiers = KeyEvent.normalizeMetaState(r4);
        return this;
    }

    public ActionMenuItem(Context r1, int r2, int r3, int r4, int r5, CharSequence r6) {
        this.mShortcutNumericModifiers = 4096;
        this.mShortcutAlphabeticModifiers = 4096;
        this.mIconTintList = null;
        this.mIconTintMode = null;
        this.mHasIconTint = false;
        this.mHasIconTintMode = false;
        this.mFlags = 16;
        this.mContext = r1;
        this.mId = r3;
        this.mGroup = r2;
        this.mOrdering = r5;
        this.mTitle = r6;
    }
}
