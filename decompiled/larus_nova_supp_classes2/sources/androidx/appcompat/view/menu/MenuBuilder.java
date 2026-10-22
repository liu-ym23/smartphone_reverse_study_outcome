package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.content.ContextCompat;
import androidx.core.internal.view.SupportMenu;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.view.ActionProvider;
import androidx.core.view.ViewConfigurationCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class MenuBuilder implements SupportMenu {
    private static final String ACTION_VIEW_STATES_KEY = "android:menu:actionviewstates";
    private static final String EXPANDED_ACTION_VIEW_ID = "android:menu:expandedactionview";
    private static final String PRESENTER_KEY = "android:menu:presenters";
    private static final String TAG = "MenuBuilder";
    private static final int[] sCategoryToOrder = null;
    private ArrayList<MenuItemImpl> mActionItems;
    private Callback mCallback;
    private final Context mContext;
    private ContextMenu.ContextMenuInfo mCurrentMenuInfo;
    private int mDefaultShowAsAction;
    private MenuItemImpl mExpandedItem;
    private boolean mGroupDividerEnabled;
    Drawable mHeaderIcon;
    CharSequence mHeaderTitle;
    View mHeaderView;
    private boolean mIsActionItemsStale;
    private boolean mIsClosing;
    private boolean mIsVisibleItemsStale;
    private ArrayList<MenuItemImpl> mItems;
    private boolean mItemsChangedWhileDispatchPrevented;
    private ArrayList<MenuItemImpl> mNonActionItems;
    private boolean mOptionalIconsVisible;
    private boolean mOverrideVisibleItems;
    private CopyOnWriteArrayList<WeakReference<MenuPresenter>> mPresenters;
    private boolean mPreventDispatchingItemsChanged;
    private boolean mQwertyMode;
    private final Resources mResources;
    private boolean mShortcutsVisible;
    private boolean mStructureChangedWhileDispatchPrevented;
    private ArrayList<MenuItemImpl> mTempShortcutItemList;
    private ArrayList<MenuItemImpl> mVisibleItems;

    public interface Callback {
        boolean onMenuItemSelected(MenuBuilder r1, MenuItem r2);

        void onMenuModeChange(MenuBuilder r1);
    }

    public interface ItemInvoker {
        boolean invokeItem(MenuItemImpl r1);
    }

    static {
        sCategoryToOrder = new int[]{1, 4, 5, 3, 2, 0};
    }

    public void clearAll() {
        this.mPreventDispatchingItemsChanged = true;
        clear();
        clearHeader();
        this.mPresenters.clear();
        this.mPreventDispatchingItemsChanged = false;
        this.mItemsChangedWhileDispatchPrevented = false;
        this.mStructureChangedWhileDispatchPrevented = false;
        onItemsChanged(true);
    }

    public void clearHeader() {
        this.mHeaderIcon = null;
        this.mHeaderTitle = null;
        this.mHeaderView = null;
        onItemsChanged(false);
    }

    public void close() {
        close(true);
    }

    public String getActionViewStatesKey() {
        return ACTION_VIEW_STATES_KEY;
    }

    public MenuBuilder getRootMenu() {
        return this;
    }

    public void startDispatchingItemsChanged() {
        this.mPreventDispatchingItemsChanged = false;
        if (this.mItemsChangedWhileDispatchPrevented == false) goto L6;
        this.mItemsChangedWhileDispatchPrevented = false;
        onItemsChanged(this.mStructureChangedWhileDispatchPrevented);
        return;
    }

    public void changeMenuMode() {
        Callback r0 = this.mCallback;
        if (r0 == null) goto L6;
        r0.onMenuModeChange(this);
        return;
    }

    public void clear() {
        MenuItemImpl r0 = this.mExpandedItem;
        if (r0 == null) goto L5;
        collapseItemActionView(r0);
    L5:
        this.mItems.clear();
        onItemsChanged(true);
    }

    public ArrayList<MenuItemImpl> getVisibleItems() {
        if (this.mIsVisibleItemsStale == false) goto L5;
        this.mVisibleItems.clear();
        int r0 = this.mItems.size();
        int r2 = 0;
    L7:
        if (r2 >= r0) goto L12;
        MenuItemImpl r3 = (MenuItemImpl) ListProtector.get(this.mItems, r2);
        if (r3.isVisible() == false) goto L11;
        this.mVisibleItems.add(r3);
    L11:
        r2 = r2 + 1;
        goto L7
    L12:
        this.mIsVisibleItemsStale = false;
        this.mIsActionItemsStale = true;
        return this.mVisibleItems;
    L5:
        return this.mVisibleItems;
    }

    public boolean hasVisibleItems() {
        if (this.mOverrideVisibleItems == false) goto L5;
        return true;
    L5:
        int r0 = size();
        int r3 = 0;
    L6:
        if (r3 >= r0) goto L11;
        if (((MenuItemImpl) ListProtector.get(this.mItems, r3)).isVisible() == true) goto L9;
        r3 = r3 + 1;
        goto L6
    L9:
        return true;
    L11:
        return false;
    }

    public int size() {
        return this.mItems.size();
    }

    public void stopDispatchingItemsChanged() {
        if (this.mPreventDispatchingItemsChanged == true) goto L6;
        this.mPreventDispatchingItemsChanged = true;
        this.mItemsChangedWhileDispatchPrevented = false;
        this.mStructureChangedWhileDispatchPrevented = false;
        return;
    }

    public void flagActionItems() {
        ArrayList<MenuItemImpl> r0 = getVisibleItems();
        if (this.mIsActionItemsStale == true) goto L5;
        return;
    L5:
        Iterator<WeakReference<MenuPresenter>> r1 = this.mPresenters.iterator();
        boolean r3 = false;
    L7:
        if (r1.hasNext() == false) goto L12;
        WeakReference<MenuPresenter> r4 = r1.next();
        MenuPresenter r5 = r4.get();
        if (r5 == null) goto L10;
        r3 = r3 | r5.flagActionItems();
        goto L7
    L10:
        this.mPresenters.remove(r4);
        goto L7
    L12:
        if (r3 == false) goto L20;
        this.mActionItems.clear();
        this.mNonActionItems.clear();
        int r2 = r0.size();
        int r6 = 0;
    L14:
        if (r6 >= r2) goto L21;
        MenuItemImpl r7 = (MenuItemImpl) ListProtector.get(r0, r6);
        if (r7.isActionButton() == false) goto L18;
        this.mActionItems.add(r7);
    L19:
        r6 = r6 + 1;
        goto L14
    L18:
        this.mNonActionItems.add(r7);
    L21:
        this.mIsActionItemsStale = false;
        return;
    L20:
        this.mActionItems.clear();
        this.mNonActionItems.clear();
        this.mNonActionItems.addAll(getVisibleItems());
        goto L21
    }

    public ArrayList<MenuItemImpl> getActionItems() {
        flagActionItems();
        return this.mActionItems;
    }

    public ArrayList<MenuItemImpl> getNonActionItems() {
        flagActionItems();
        return this.mNonActionItems;
    }

    public Context getContext() {
        return this.mContext;
    }

    public MenuItemImpl getExpandedItem() {
        return this.mExpandedItem;
    }

    public Drawable getHeaderIcon() {
        return this.mHeaderIcon;
    }

    public CharSequence getHeaderTitle() {
        return this.mHeaderTitle;
    }

    public View getHeaderView() {
        return this.mHeaderView;
    }

    public boolean getOptionalIconsVisible() {
        return this.mOptionalIconsVisible;
    }

    public Resources getResources() {
        return this.mResources;
    }

    public boolean isGroupDividerEnabled() {
        return this.mGroupDividerEnabled;
    }

    public boolean isQwertyMode() {
        return this.mQwertyMode;
    }

    public boolean isShortcutsVisible() {
        return this.mShortcutsVisible;
    }

    public MenuBuilder(Context r3) {
        this.mDefaultShowAsAction = 0;
        this.mPreventDispatchingItemsChanged = false;
        this.mItemsChangedWhileDispatchPrevented = false;
        this.mStructureChangedWhileDispatchPrevented = false;
        this.mOptionalIconsVisible = false;
        this.mIsClosing = false;
        this.mTempShortcutItemList = new ArrayList();
        this.mPresenters = new CopyOnWriteArrayList();
        this.mGroupDividerEnabled = false;
        this.mContext = r3;
        this.mResources = r3.getResources();
        this.mItems = new ArrayList();
        this.mVisibleItems = new ArrayList();
        this.mIsVisibleItemsStale = true;
        this.mActionItems = new ArrayList();
        this.mNonActionItems = new ArrayList();
        this.mIsActionItemsStale = true;
        setShortcutsVisibleInner(true);
    }

    private void dispatchPresenterUpdate(boolean r4) {
        if (this.mPresenters.isEmpty() == false) goto L5;
        return;
    L5:
        stopDispatchingItemsChanged();
        Iterator<WeakReference<MenuPresenter>> r0 = this.mPresenters.iterator();
    L7:
        if (r0.hasNext() == false) goto L12;
        WeakReference<MenuPresenter> r1 = r0.next();
        MenuPresenter r2 = r1.get();
        if (r2 == null) goto L10;
        r2.updateMenuView(r4);
        goto L7
    L10:
        this.mPresenters.remove(r1);
        goto L7
    L12:
        startDispatchingItemsChanged();
    }

    private void dispatchRestoreInstanceState(Bundle r4) {
        SparseArray r5 = r4.getSparseParcelableArray(PRESENTER_KEY);
        if (r5 != null) goto L5;
        return;
    L5:
        if (this.mPresenters.isEmpty() == true) goto L29;
        Iterator<WeakReference<MenuPresenter>> r0 = this.mPresenters.iterator();
    L9:
        if (r0.hasNext() == false) goto L30;
        WeakReference<MenuPresenter> r1 = r0.next();
        MenuPresenter r2 = r1.get();
        if (r2 == null) goto L12;
        int r3 = r2.getId();
        if (r3 <= 0) goto L9;
        Parcelable r6 = (Parcelable) r5.get(r3);
        if (r6 == null) goto L9;
        r2.onRestoreInstanceState(r6);
        goto L9
    L12:
        this.mPresenters.remove(r1);
        goto L9
    L30:
        return;
    }

    private void dispatchSaveInstanceState(Bundle r5) {
        if (this.mPresenters.isEmpty() == false) goto L5;
        return;
    L5:
        SparseArray<? extends Parcelable> r0 = new SparseArray();
        Iterator<WeakReference<MenuPresenter>> r1 = this.mPresenters.iterator();
    L7:
        if (r1.hasNext() == false) goto L16;
        WeakReference<MenuPresenter> r2 = r1.next();
        MenuPresenter r3 = r2.get();
        if (r3 == null) goto L10;
        int r4 = r3.getId();
        if (r4 <= 0) goto L7;
        Parcelable r6 = r3.onSaveInstanceState();
        if (r6 == null) goto L7;
        r0.put(r4, r6);
        goto L7
    L10:
        this.mPresenters.remove(r2);
        goto L7
    L16:
        r5.putSparseParcelableArray(PRESENTER_KEY, r0);
    }

    private static int getOrdering(int r3) {
        int r0 = ((-65536) & r3) >> 16;
        if (r0 < 0) goto L9;
        int[] r1 = sCategoryToOrder;
        if (r0 >= r1.length) goto L9;
        int r4 = r3 & 65535;
        return r4 | (r1[r0] << 16);
    L9:
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    private void setShortcutsVisibleInner(boolean r3) {
        if (r3 == false) goto L8;
        boolean r0 = true;
        if (this.mResources.getConfiguration().keyboard == 1) goto L8;
        if (ViewConfigurationCompat.shouldShowMenuShortcutsWhenKeyboardPresent(ViewConfiguration.get(this.mContext), this.mContext) == false) goto L8;
    L9:
        this.mShortcutsVisible = r0;
        return;
    L8:
        r0 = false;
        goto L9
    }

    public MenuItem add(int r2) {
        return addInternal(0, 0, 0, this.mResources.getString(r2));
    }

    public void addMenuPresenter(MenuPresenter r2) {
        addMenuPresenter(r2, this.mContext);
    }

    public SubMenu addSubMenu(int r2) {
        return addSubMenu(0, 0, 0, this.mResources.getString(r2));
    }

    public final void close(boolean r4) {
        if (this.mIsClosing == false) goto L5;
        return;
    L5:
        this.mIsClosing = true;
        Iterator<WeakReference<MenuPresenter>> r0 = this.mPresenters.iterator();
    L7:
        if (r0.hasNext() == false) goto L12;
        WeakReference<MenuPresenter> r1 = r0.next();
        MenuPresenter r2 = r1.get();
        if (r2 == null) goto L10;
        r2.onCloseMenu(this, r4);
        goto L7
    L10:
        this.mPresenters.remove(r1);
        goto L7
    L12:
        this.mIsClosing = false;
    }

    public boolean collapseItemActionView(MenuItemImpl r5) {
        boolean r1 = false;
        if (this.mPresenters.isEmpty() == false) goto L5;
    L18:
        return r1;
    L5:
        if (this.mExpandedItem != r5) goto L18;
        stopDispatchingItemsChanged();
        Iterator<WeakReference<MenuPresenter>> r0 = this.mPresenters.iterator();
    L9:
        if (r0.hasNext() == false) goto L15;
        WeakReference<MenuPresenter> r2 = r0.next();
        MenuPresenter r3 = r2.get();
        if (r3 == null) goto L12;
        r1 = r3.collapseItemActionView(this, r5);
        if (r1 == false) goto L9;
    L12:
        this.mPresenters.remove(r2);
    L15:
        startDispatchingItemsChanged();
        if (r1 == false) goto L18;
        this.mExpandedItem = null;
        goto L18
    }

    public boolean expandItemActionView(MenuItemImpl r5) {
        boolean r1 = false;
        if (this.mPresenters.isEmpty() == false) goto L5;
        return false;
    L5:
        stopDispatchingItemsChanged();
        Iterator<WeakReference<MenuPresenter>> r0 = this.mPresenters.iterator();
    L7:
        if (r0.hasNext() == false) goto L13;
        WeakReference<MenuPresenter> r2 = r0.next();
        MenuPresenter r3 = r2.get();
        if (r3 == null) goto L10;
        r1 = r3.expandItemActionView(this, r5);
        if (r1 == false) goto L7;
    L10:
        this.mPresenters.remove(r2);
    L13:
        startDispatchingItemsChanged();
        if (r1 == false) goto L16;
        this.mExpandedItem = r5;
    L16:
        return r1;
    }

    public int findGroupIndex(int r2) {
        return findGroupIndex(r2, 0);
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [android.view.MenuItem, androidx.appcompat.view.menu.MenuItemImpl] */
    public MenuItem findItem(int r5) {
        int r0 = size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L13;
        ?? r2 = (MenuItemImpl) ListProtector.get(this.mItems, r1);
        if (r2.getItemId() == r5) goto L6;
        if (r2.hasSubMenu() == false) goto L12;
        MenuItem r3 = r2.getSubMenu().findItem(r5);
        if (r3 == null) goto L12;
        return r3;
    L12:
        r1 = r1 + 1;
        goto L3
    L6:
        return r2;
    L13:
        return null;
    }

    public int findItemIndex(int r4) {
        int r0 = size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        if (((MenuItemImpl) ListProtector.get(this.mItems, r1)).getItemId() == r4) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return r1;
    L8:
        return -1;
    }

    public MenuItem getItem(int r2) {
        return (MenuItem) ListProtector.get(this.mItems, r2);
    }

    public void onItemActionRequestChanged(MenuItemImpl r1) {
        this.mIsActionItemsStale = true;
        onItemsChanged(true);
    }

    public void onItemVisibleChanged(MenuItemImpl r1) {
        this.mIsVisibleItemsStale = true;
        onItemsChanged(true);
    }

    public void onItemsChanged(boolean r3) {
        if (this.mPreventDispatchingItemsChanged == true) goto L7;
        if (r3 == false) goto L6;
        this.mIsVisibleItemsStale = true;
        this.mIsActionItemsStale = true;
    L6:
        dispatchPresenterUpdate(r3);
        return;
    L7:
        this.mItemsChangedWhileDispatchPrevented = true;
        if (r3 == false) goto L12;
        this.mStructureChangedWhileDispatchPrevented = true;
        return;
    }

    public void removeGroup(int r6) {
        int r0 = findGroupIndex(r6);
        if (r0 < 0) goto L14;
        int r1 = this.mItems.size() - r0;
        int r3 = 0;
    L5:
        int r4 = r3 + 1;
        if (r3 >= r1) goto L10;
        if (((MenuItemImpl) ListProtector.get(this.mItems, r0)).getGroupId() != r6) goto L10;
        removeItemAtInt(r0, false);
        r3 = r4;
    L10:
        onItemsChanged(true);
        return;
    }

    public void removeItem(int r2) {
        removeItemAtInt(findItemIndex(r2), true);
    }

    public void removeItemAt(int r2) {
        removeItemAtInt(r2, true);
    }

    public void removeMenuPresenter(MenuPresenter r4) {
        Iterator<WeakReference<MenuPresenter>> r0 = this.mPresenters.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        WeakReference<MenuPresenter> r1 = r0.next();
        MenuPresenter r2 = r1.get();
        if (r2 == null) goto L8;
        if (r2 != r4) goto L4;
    L8:
        this.mPresenters.remove(r1);
        goto L4
    }

    public void restoreActionViewStates(Bundle r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        SparseArray<Parcelable> r0 = r8.getSparseParcelableArray(getActionViewStatesKey());
        int r1 = size();
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L15;
        MenuItem r3 = getItem(r2);
        View r4 = r3.getActionView();
        if (r4 == null) goto L12;
        if (r4.getId() == (-1)) goto L12;
        r4.restoreHierarchyState(r0);
    L12:
        if (r3.hasSubMenu() == false) goto L14;
        ((SubMenuBuilder) r3.getSubMenu()).restoreActionViewStates(r8);
    L14:
        r2 = r2 + 1;
        goto L5
    L15:
        int r9 = r8.getInt(EXPANDED_ACTION_VIEW_ID);
        if (r9 <= 0) goto L24;
        MenuItem r10 = findItem(r9);
        if (r10 == null) goto L25;
        r10.expandActionView();
        return;
    L25:
        return;
    }

    public void restorePresenterStates(Bundle r1) {
        dispatchRestoreInstanceState(r1);
    }

    public void saveActionViewStates(Bundle r8) {
        int r0 = size();
        SparseArray<? extends Parcelable> r1 = null;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L17;
        MenuItem r3 = getItem(r2);
        View r4 = r3.getActionView();
        if (r4 == null) goto L14;
        if (r4.getId() == (-1)) goto L14;
        if (r1 != null) goto L10;
        r1 = new SparseArray();
    L10:
        r4.saveHierarchyState(r1);
        if (r3.isActionViewExpanded() == false) goto L14;
        r8.putInt(EXPANDED_ACTION_VIEW_ID, r3.getItemId());
    L14:
        if (r3.hasSubMenu() == false) goto L16;
        ((SubMenuBuilder) r3.getSubMenu()).saveActionViewStates(r8);
    L16:
        r2 = r2 + 1;
        goto L3
    L17:
        if (r1 == null) goto L23;
        r8.putSparseParcelableArray(getActionViewStatesKey(), r1);
        return;
    }

    public void savePresenterStates(Bundle r1) {
        dispatchSaveInstanceState(r1);
    }

    public void setCallback(Callback r1) {
        this.mCallback = r1;
    }

    public void setCurrentMenuInfo(ContextMenu.ContextMenuInfo r1) {
        this.mCurrentMenuInfo = r1;
    }

    public MenuBuilder setDefaultShowAsAction(int r1) {
        this.mDefaultShowAsAction = r1;
        return this;
    }

    public void setExclusiveItemChecked(MenuItem r7) {
        int r0 = r7.getGroupId();
        int r1 = this.mItems.size();
        stopDispatchingItemsChanged();
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L17;
        MenuItemImpl r4 = (MenuItemImpl) ListProtector.get(this.mItems, r3);
        if (r4.getGroupId() != r0) goto L16;
        if (r4.isExclusiveCheckable() == false) goto L16;
        if (r4.isCheckable() == false) goto L16;
        if (r4 != r7) goto L14;
        boolean r5 = true;
    L15:
        r4.setCheckedInt(r5);
        goto L16
    L14:
        r5 = false;
    L16:
        r3 = r3 + 1;
        goto L3
    L17:
        startDispatchingItemsChanged();
    }

    public void setGroupDividerEnabled(boolean r1) {
        this.mGroupDividerEnabled = r1;
    }

    public MenuBuilder setHeaderIconInt(int r7) {
        setHeaderInternal(0, null, r7, null, null);
        return this;
    }

    public MenuBuilder setHeaderTitleInt(int r7) {
        setHeaderInternal(r7, null, 0, null, null);
        return this;
    }

    public MenuBuilder setHeaderViewInt(View r7) {
        setHeaderInternal(0, null, 0, null, r7);
        return this;
    }

    public void setOptionalIconsVisible(boolean r1) {
        this.mOptionalIconsVisible = r1;
    }

    public void setOverrideVisibleItems(boolean r1) {
        this.mOverrideVisibleItems = r1;
    }

    public void setQwertyMode(boolean r1) {
        this.mQwertyMode = r1;
        onItemsChanged(false);
    }

    public void setShortcutsVisible(boolean r2) {
        if (this.mShortcutsVisible != r2) goto L5;
        return;
    L5:
        setShortcutsVisibleInner(r2);
        onItemsChanged(false);
    }

    public MenuItem add(CharSequence r2) {
        return addInternal(0, 0, 0, r2);
    }

    public SubMenu addSubMenu(CharSequence r2) {
        return addSubMenu(0, 0, 0, r2);
    }

    public MenuBuilder setHeaderIconInt(Drawable r7) {
        setHeaderInternal(0, null, 0, r7, null);
        return this;
    }

    public MenuBuilder setHeaderTitleInt(CharSequence r7) {
        setHeaderInternal(0, r7, 0, null, null);
        return this;
    }

    private boolean dispatchSubMenuSelected(SubMenuBuilder r4, MenuPresenter r5) {
        boolean r1 = false;
        if (this.mPresenters.isEmpty() == false) goto L5;
        return false;
    L5:
        if (r5 == null) goto L7;
        r1 = r5.onSubMenuSelected(r4);
    L7:
        Iterator<WeakReference<MenuPresenter>> r6 = this.mPresenters.iterator();
    L9:
        if (r6.hasNext() == false) goto L15;
        WeakReference<MenuPresenter> r0 = r6.next();
        MenuPresenter r2 = r0.get();
        if (r2 == null) goto L12;
        if (r1 == true) goto L9;
        r1 = r2.onSubMenuSelected(r4);
        goto L9
    L12:
        this.mPresenters.remove(r0);
        goto L9
    L15:
        return r1;
    }

    private static int findInsertIndex(ArrayList<MenuItemImpl> r2, int r3) {
        int r0 = r2.size() - 1;
    L3:
        if (r0 < 0) goto L9;
        if (((MenuItemImpl) ListProtector.get(r2, r0)).getOrdering() <= r3) goto L7;
        r0 = r0 - 1;
        goto L3
    L7:
        return r0 + 1;
    L9:
        return 0;
    }

    private void removeItemAtInt(int r2, boolean r3) {
        if (r2 >= 0) goto L4;
        return;
    L4:
        if (r2 >= this.mItems.size()) goto L12;
        ListProtector.remove(this.mItems, r2);
        if (r3 == false) goto L11;
        onItemsChanged(true);
        return;
    L11:
        return;
    }

    public void addMenuPresenter(MenuPresenter r3, Context r4) {
        this.mPresenters.add(new WeakReference(r3));
        r3.initForMenu(r4, this);
        this.mIsActionItemsStale = true;
    }

    public boolean dispatchMenuItemSelected(MenuBuilder r2, MenuItem r3) {
        Callback r0 = this.mCallback;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.onMenuItemSelected(r2, r3) == false) goto L7;
        return true;
    }

    public int findGroupIndex(int r3, int r4) {
        int r0 = size();
        if (r4 >= 0) goto L5;
        r4 = 0;
    L5:
        if (r4 >= r0) goto L10;
        if (((MenuItemImpl) ListProtector.get(this.mItems, r4)).getGroupId() == r3) goto L8;
        r4 = r4 + 1;
        goto L5
    L8:
        return r4;
    L10:
        return -1;
    }

    public MenuItemImpl findItemWithShortcutForKey(int r12, KeyEvent r13) {
        ArrayList<MenuItemImpl> r0 = this.mTempShortcutItemList;
        r0.clear();
        findItemsWithShortcutForKey(r0, r12, r13);
        if (r0.isEmpty() == false) goto L5;
        return null;
    L5:
        int r1 = r13.getMetaState();
        KeyCharacterMap.KeyData r3 = new KeyCharacterMap.KeyData();
        r13.getKeyData(r3);
        int r14 = r0.size();
        if (r14 == 1) goto L8;
        boolean r4 = isQwertyMode();
        int r6 = 0;
    L10:
        if (r6 >= r14) goto L30;
        MenuItemImpl r7 = (MenuItemImpl) ListProtector.get(r0, r6);
        if (r4 == false) goto L14;
        char r8 = r7.getAlphabeticShortcut();
    L15:
        char[] r9 = r3.meta;
        if (r8 != r9[0]) goto L20;
        if ((r1 & 2) != 0) goto L20;
    L28:
        return r7;
    L20:
        if (r8 == r9[2]) goto L22;
    L23:
        if (r4 == false) goto L29;
        if (r8 != '\b') goto L29;
        if (r12 == 67) goto L28;
    L29:
        r6 = r6 + 1;
        goto L10
    L22:
        if ((r1 & 2) != 0) goto L28;
    L14:
        r8 = r7.getNumericShortcut();
        goto L15
    L30:
        return null;
    L8:
        return (MenuItemImpl) ListProtector.get(r0, 0);
    }

    public boolean isShortcutKey(int r1, KeyEvent r2) {
        if (findItemWithShortcutForKey(r1, r2) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean performIdentifierAction(int r1, int r2) {
        return performItemAction(findItem(r1), r2);
    }

    public boolean performItemAction(MenuItem r2, int r3) {
        return performItemAction(r2, null, r3);
    }

    public void setGroupEnabled(int r5, boolean r6) {
        int r0 = this.mItems.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        MenuItemImpl r2 = (MenuItemImpl) ListProtector.get(this.mItems, r1);
        if (r2.getGroupId() != r5) goto L7;
        r2.setEnabled(r6);
    L7:
        r1 = r1 + 1;
        goto L3
    }

    public void setGroupVisible(int r7, boolean r8) {
        int r0 = this.mItems.size();
        int r1 = 0;
        boolean r2 = false;
    L4:
        if (r1 >= r0) goto L11;
        MenuItemImpl r4 = (MenuItemImpl) ListProtector.get(this.mItems, r1);
        if (r4.getGroupId() != r7) goto L10;
        if (r4.setVisibleInt(r8) == false) goto L10;
        r2 = true;
    L10:
        r1 = r1 + 1;
        goto L4
    L11:
        if (r2 == false) goto L18;
        onItemsChanged(true);
        return;
    }

    public void findItemsWithShortcutForKey(List<MenuItemImpl> r13, int r14, KeyEvent r15) {
        boolean r0 = isQwertyMode();
        int r1 = r15.getModifiers();
        KeyCharacterMap.KeyData r2 = new KeyCharacterMap.KeyData();
        if (r15.getKeyData(r2) == true) goto L6;
        if (r14 == 67) goto L6;
        return;
    L6:
        int r3 = this.mItems.size();
        int r6 = 0;
    L7:
        if (r6 >= r3) goto L35;
        MenuItemImpl r7 = (MenuItemImpl) ListProtector.get(this.mItems, r6);
        if (r7.hasSubMenu() == false) goto L11;
        ((MenuBuilder) r7.getSubMenu()).findItemsWithShortcutForKey(r13, r14, r15);
    L11:
        if (r0 == false) goto L13;
        char r8 = r7.getAlphabeticShortcut();
    L14:
        if (r0 == false) goto L16;
        int r9 = r7.getAlphabeticModifiers();
    L18:
        if ((r1 & 69647) != (r9 & 69647)) goto L20;
        boolean r10 = true;
    L21:
        if (r10 == false) goto L34;
        if (r8 == 0) goto L34;
        char[] r11 = r2.meta;
        if (r8 == r11[0]) goto L32;
        if (r8 == r11[2]) goto L32;
        if (r0 == false) goto L34;
        if (r8 != '\b') goto L34;
        if (r14 != 67) goto L34;
    L32:
        if (r7.isEnabled() == false) goto L34;
        r13.add(r7);
    L34:
        r6 = r6 + 1;
        goto L7
    L20:
        r10 = false;
        goto L21
    L16:
        r9 = r7.getNumericModifiers();
        goto L18
    L13:
        r8 = r7.getNumericShortcut();
        goto L14
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean performItemAction(MenuItem r7, MenuPresenter r8, int r9) {
        MenuItemImpl r10 = (MenuItemImpl) r7;
        if (r10 != null) goto L5;
    L38:
        return false;
    L5:
        if (r10.isEnabled() == false) goto L38;
        boolean r1 = r10.invoke();
        ActionProvider r2 = r10.getSupportActionProvider();
        if (r2 != null) goto L10;
    L12:
        boolean r4 = false;
    L14:
        if (r10.hasCollapsibleActionView() == false) goto L19;
        r1 = r1 | r10.expandActionView();
        if (r1 == false) goto L37;
        close(true);
    L37:
        return r1;
    L19:
        if (r10.hasSubMenu() == true) goto L26;
        if (r4 == true) goto L26;
        if ((r9 & 1) != 0) goto L37;
        close(true);
    L26:
        if ((r9 & 4) != 0) goto L29;
        close(false);
    L29:
        if (r10.hasSubMenu() == true) goto L31;
        r10.setSubMenu(new SubMenuBuilder(getContext(), this, r10));
    L31:
        SubMenuBuilder r11 = (SubMenuBuilder) r10.getSubMenu();
        if (r4 == false) goto L34;
        r2.onPrepareSubMenu(r11);
    L34:
        r1 = r1 | dispatchSubMenuSelected(r11, r8);
        if (r1 == true) goto L37;
        close(true);
        goto L37
    L10:
        if (r2.hasSubMenu() == false) goto L12;
        r4 = true;
        goto L14
    }

    public boolean performShortcut(int r1, KeyEvent r2, int r3) {
        SupportMenuItem r4 = findItemWithShortcutForKey(r1, r2);
        if (r4 == null) goto L5;
        boolean r5 = performItemAction(r4, r3);
    L7:
        if ((r3 & 2) == 0) goto L9;
        close(true);
    L9:
        return r5;
    L5:
        r5 = false;
        goto L7
    }

    public void setGroupCheckable(int r5, boolean r6, boolean r7) {
        int r0 = this.mItems.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        MenuItemImpl r2 = (MenuItemImpl) ListProtector.get(this.mItems, r1);
        if (r2.getGroupId() != r5) goto L7;
        r2.setExclusiveCheckable(r7);
        r2.setCheckable(r6);
    L7:
        r1 = r1 + 1;
        goto L3
    }

    public MenuItem add(int r2, int r3, int r4, int r5) {
        return addInternal(r2, r3, r4, this.mResources.getString(r5));
    }

    /* JADX WARN: Type inference failed for: r9v1, types: [android.view.MenuItem, androidx.appcompat.view.menu.MenuItemImpl, java.lang.Object] */
    public MenuItem addInternal(int r9, int r10, int r11, CharSequence r12) {
        int r7 = getOrdering(r11);
        ?? r13 = createNewMenuItem(r9, r10, r11, r7, r12, this.mDefaultShowAsAction);
        ContextMenu.ContextMenuInfo r14 = this.mCurrentMenuInfo;
        if (r14 == null) goto L5;
        r13.setMenuInfo(r14);
    L5:
        ArrayList<MenuItemImpl> r15 = this.mItems;
        ListProtector.add(r15, findInsertIndex(r15, r7), r13);
        onItemsChanged(true);
        return r13;
    }

    public SubMenu addSubMenu(int r1, int r2, int r3, CharSequence r4) {
        MenuItemImpl r5 = (MenuItemImpl) addInternal(r1, r2, r3, r4);
        SubMenuBuilder r6 = new SubMenuBuilder(this.mContext, this, r5);
        r5.setSubMenu(r6);
        return r6;
    }

    public MenuItem add(int r1, int r2, int r3, CharSequence r4) {
        return addInternal(r1, r2, r3, r4);
    }

    public SubMenu addSubMenu(int r2, int r3, int r4, int r5) {
        return addSubMenu(r2, r3, r4, this.mResources.getString(r5));
    }

    private void setHeaderInternal(int r3, CharSequence r4, int r5, Drawable r6, View r7) {
        Resources r0 = getResources();
        if (r7 == null) goto L5;
        this.mHeaderView = r7;
        this.mHeaderTitle = null;
        this.mHeaderIcon = null;
    L14:
        onItemsChanged(false);
        return;
    L5:
        if (r3 <= 0) goto L7;
        this.mHeaderTitle = r0.getText(r3);
    L9:
        if (r5 <= 0) goto L11;
        this.mHeaderIcon = ContextCompat.getDrawable(getContext(), r5);
    L13:
        this.mHeaderView = null;
        goto L14
    L11:
        if (r6 == null) goto L13;
        this.mHeaderIcon = r6;
        goto L13
    L7:
        if (r4 == null) goto L9;
        this.mHeaderTitle = r4;
        goto L9
    }

    private MenuItemImpl createNewMenuItem(int r10, int r11, int r12, int r13, CharSequence r14, int r15) {
        return new MenuItemImpl(this, r10, r11, r12, r13, r14, r15);
    }

    public int addIntentOptions(int r8, int r9, int r10, ComponentName r11, Intent[] r12, Intent r13, int r14, MenuItem[] r15) {
        PackageManager r0 = this.mContext.getPackageManager();
        int r1 = 0;
        List<ResolveInfo> r16 = r0.queryIntentActivityOptions(r11, r12, r13, 0);
        if (r16 == null) goto L5;
        int r2 = r16.size();
    L7:
        if ((r14 & 1) != 0) goto L9;
        removeGroup(r8);
    L9:
        if (r1 >= r2) goto L20;
        ResolveInfo r17 = (ResolveInfo) ListProtector.get(r16, r1);
        int r4 = r17.specificIndex;
        if (r4 >= 0) goto L13;
        Intent r5 = r13;
    L14:
        Intent r3 = new Intent(r5);
        ActivityInfo r6 = r17.activityInfo;
        r3.setComponent(new ComponentName(r6.applicationInfo.packageName, r6.name));
        MenuItem r7 = add(r8, r9, r10, r17.loadLabel(r0)).setIcon(r17.loadIcon(r0)).setIntent(r3);
        if (r15 == null) goto L19;
        int r18 = r17.specificIndex;
        if (r18 < 0) goto L19;
        r15[r18] = r7;
    L19:
        r1 = r1 + 1;
        goto L9
    L13:
        r5 = r12[r4];
        goto L14
    L20:
        return r2;
    L5:
        r2 = 0;
        goto L7
    }
}
