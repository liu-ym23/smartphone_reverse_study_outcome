package com.bytedance.ee.bear.document.toolbar;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.bizwidget.helper.FGDowngradeHelper;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.toolbar.Toolbar;
import com.bytedance.ee.bear.document.toolbar.editpanels.KeyboardShowingStatusMode;
import com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel;
import com.larus.nova.R;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;
import kotlin.Lazy;

/* JADX INFO: loaded from: classes16.dex */
public abstract class BaseToolbarPanelViewModel<T extends Toolbar> extends BaseEditPanelViewModel {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    protected static final String TAG = "BaseToolbarPanelViewModel";
    protected Context context;
    private ItemId currItemId;
    private a delegate;
    private MutableLiveData<Stack<ItemId>> expandedSubToolbars;
    private final MutableLiveData<Boolean> hasWindowFocus;
    private ItemId lastItemId;
    private Map<ItemId, MutableLiveData<Item[]>> subToolbars;
    private MutableLiveData<T> toolbar;

    public interface a {
        boolean a();

        void b(ItemId r100, String r101);
    }

    public static /* synthetic */ void Mo(BaseToolbarPanelViewModel r100, g45.a r101) {
        r100.lambda$onAttachToUI$1(r101);
    }

    public static /* synthetic */ void yo(BaseToolbarPanelViewModel r100, g45.a r101) {
        r100.lambda$onAttachToUI$0(r101);
    }

    @Override // com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel, g45.a
    public abstract /* synthetic */ String getPanelName();

    @Override // com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel, g45.a
    public /* bridge */ /* synthetic */ void onBecomeActive(g45.d r100, g45.a r101) {
    }

    @Override // com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel, g45.a
    public /* bridge */ /* synthetic */ void onBecomeInactive(g45.d r100, g45.a r101) {
    }

    public LiveData<Stack<ItemId>> getExpandedSubToolbars() {
        if (this.expandedSubToolbars != null) goto L6;
        MutableLiveData<Stack<ItemId>> r100 = new MutableLiveData();
        r100.setValue(new Stack());
        this.expandedSubToolbars = r100;
    L6:
        return this.expandedSubToolbars;
    }

    public LiveData<T> getToolbar() {
        if (this.toolbar != null) goto L6;
        this.toolbar = new MutableLiveData();
    L6:
        return this.toolbar;
    }

    public boolean hasExpandedSubToolbar() {
        MutableLiveData<Stack<ItemId>> r100 = this.expandedSubToolbars;
        if (r100 != null) goto L5;
        return false;
    L5:
        Stack<ItemId> r101 = r100.getValue();
        if (r101 != null) goto L8;
        return false;
    L8:
        if (r101.isEmpty() == true) goto L12;
        return true;
    L12:
        return false;
    }

    public boolean isAtVc() {
        a r100 = this.delegate;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.a();
    }

    public BaseToolbarPanelViewModel() {
        this.hasWindowFocus = new MutableLiveData();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean clearSubToolbars() {
        MutableLiveData r100 = (MutableLiveData) getExpandedSubToolbars();
        Stack r101 = (Stack) r100.getValue();
        if (r101.isEmpty() == true) goto L6;
        r101.clear();
        r100.setValue(r101);
        return true;
    L6:
        return false;
    }

    public MutableLiveData<T> mutableToolbar() {
        return (MutableLiveData) getToolbar();
    }

    @Override // com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel
    public void onDetachFromUI() {
        super.onDetachFromUI();
        this.delegate = null;
        this.toolbar = null;
        this.expandedSubToolbars = null;
        this.subToolbars = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void updateExpandedSubToolbars() {
        T r100 = getToolbar().getValue();
        if (r100 != null) goto L8;
        MutableLiveData<Stack<ItemId>> r101 = this.expandedSubToolbars;
        if (r101 == null) goto L43;
        r101.setValue(new Stack());
        return;
    L43:
        return;
    L8:
        MutableLiveData r102 = (MutableLiveData) getExpandedSubToolbars();
        Stack r103 = (Stack) r102.getValue();
        Item[] r104 = r100.getChildren();
        int r105 = r104.length;
        int r106 = 0;
        boolean r107 = false;
    L10:
        if (r106 >= r105) goto L17;
        Item r108 = r104[r106];
        ItemId r109 = r108.id();
        if (r108.isEnable() == true) goto L16;
        if (r103.contains(r109) == false) goto L16;
        r103.remove(r109);
        r107 = true;
    L16:
        r106 = r106 + 1;
        goto L10
    L17:
        Iterator r110 = r103.iterator();
    L19:
        if (r110.hasNext() == false) goto L29;
        ItemId r111 = (ItemId) r110.next();
        int r112 = r104.length;
        int r113 = 0;
    L21:
        if (r113 >= r112) goto L26;
        if (r104[r113].id() == r111) goto L24;
        r113 = r113 + 1;
        goto L21
    L24:
        boolean r114 = true;
    L27:
        if (r114 == true) goto L19;
        r110.remove();
        r107 = true;
        goto L19
    L26:
        r114 = false;
        goto L27
    L29:
        if (r107 == false) goto L44;
        r102.setValue(r103);
        return;
    }

    static {
    }

    public ItemId getCurrItemId() {
        return this.currItemId;
    }

    @Override // com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel, g45.a
    public KeyboardShowingStatusMode getKeyboardShowingStatusMode() {
        return KeyboardShowingStatusMode.ALWAYS_SHOW;
    }

    public ItemId getLastItemId() {
        return this.lastItemId;
    }

    public MutableLiveData<Boolean> hasWindowFocus() {
        return this.hasWindowFocus;
    }

    private /* synthetic */ void lambda$onAttachToUI$0(g45.a r100) {
        if (this == r100) goto L5;
        clearSubToolbars();
        return;
    }

    private /* synthetic */ void lambda$onAttachToUI$1(g45.a r100) {
        if (this == r100) goto L5;
        clearSubToolbars();
        return;
    }

    private void updateSubToolbars(T r100) {
        if (r100 != null) goto L11;
        Map<ItemId, MutableLiveData<Item[]>> r101 = this.subToolbars;
        if (r101 == null) goto L10;
        Iterator<MutableLiveData<Item[]>> r102 = r101.values().iterator();
    L8:
        if (r102.hasNext() == false) goto L30;
        r102.next().setValue(new Item[0]);
        goto L8
    L30:
        return;
    L10:
        return;
    L11:
        Item[] r103 = r100.getChildren();
        int r104 = r103.length;
        int r105 = 0;
    L12:
        if (r105 >= r104) goto L14;
        Item r106 = r103[r105];
        updateSubToolbarValues(r106.id(), r106.getChildren());
        r105 = r105 + 1;
        goto L12
    L14:
        Map<ItemId, MutableLiveData<Item[]>> r107 = this.subToolbars;
        if (r107 == null) goto L22;
        Iterator<Map.Entry<ItemId, MutableLiveData<Item[]>>> r108 = r107.entrySet().iterator();
    L18:
        if (r108.hasNext() == false) goto L31;
        ItemId r109 = r108.next().getKey();
        if (r100.contains(r109) == true) goto L18;
        updateSubToolbarValues(r109, new Item[0]);
        goto L18
    L31:
        return;
    }

    public void configToolbar(T r100) {
        updateToolbar(r100);
    }

    @Override // com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel, g45.a
    public int getPanelHeight(Context r100) {
        return r100.getResources().getDimensionPixelSize(R.dimen.toolbar_menu_height);
    }

    public LiveData<Item[]> getSubToolbar(ItemId r100) {
        if (this.subToolbars != null) goto L5;
        this.subToolbars = new HashMap();
    L5:
        MutableLiveData<Item[]> r101 = this.subToolbars.get(r100);
        if (r101 != null) goto L9;
        MutableLiveData<Item[]> r102 = new MutableLiveData();
        this.subToolbars.put(r100, r102);
        return r102;
    L9:
        return r101;
    }

    public boolean isExpanded(Item r100) {
        Stack<ItemId> r101 = getExpandedSubToolbars().getValue();
        if (r101.isEmpty() == false) goto L5;
    L7:
        return false;
    L5:
        if (r101.peek() != r100.id()) goto L7;
        return true;
    }

    @Override // com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel
    public void onKeyboardStateChanged(int r100) {
        super.onKeyboardStateChanged(r100);
        if (r100 != 0) goto L12;
        tt5.a.h(TAG, "onKeyboardStateChanged(): keyboardHeight = 0");
        if (hasExpandedSubToolbar() == false) goto L9;
        if (this.hasWindowFocus.getValue() != Boolean.FALSE) goto L9;
        return;
    L9:
        if (rcb.b.a(this.context) == true) goto L14;
        clearSubToolbars();
        return;
    L14:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel, g45.a
    public void requestNotFocus(Context r100) {
        super.requestNotFocus(r100);
        MutableLiveData r101 = (MutableLiveData) getExpandedSubToolbars();
        Stack r102 = (Stack) r101.getValue();
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.isEmpty() == true) goto L9;
        r102.clear();
        r101.setValue(r102);
        return;
    }

    public void setCurrItemId(ItemId r100) {
        this.currItemId = r100;
    }

    public void setDelegate(a r100) {
        this.delegate = r100;
    }

    public void setLastItemId(ItemId r100) {
        this.lastItemId = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void updateExpandedSubToolbars(ItemId r100) {
        MutableLiveData r101 = (MutableLiveData) getExpandedSubToolbars();
        Stack r102 = (Stack) r101.getValue();
        if (r102.isEmpty() == false) goto L5;
    L7:
        boolean r103 = false;
    L9:
        if (r102.isEmpty() == true) goto L16;
        if (r102.contains(r100) == false) goto L16;
        if (r102.peek() == r100) goto L16;
        r102.pop();
    L16:
        if (r102.isEmpty() == false) goto L18;
    L22:
        r102.push(r100);
    L23:
        r101.setValue(r102);
        return;
    L18:
        if (r102.peek() != r100) goto L22;
        if (r103 == false) goto L23;
        r102.clear();
        goto L23
    L5:
        if (r102.peek() != r100) goto L7;
        r103 = true;
        goto L9
    }

    public void updateToolbar(T r100) {
        tt5.a.h(TAG, "updateToolbar:" + r100);
        T r101 = getToolbar().getValue();
        if (Toolbar.equals(r100, r101) == true) goto L10;
        onUpdateToolbar(r101, r100);
        if (r100 == null) goto L7;
        boolean r102 = true;
    L8:
        setActive(r102);
        return;
    L7:
        r102 = false;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void updateSubToolbarValues(ItemId r100, Item[] r101) {
        MutableLiveData r102 = (MutableLiveData) getSubToolbar(r100);
        if (Arrays.equals((Item[]) r102.getValue(), r101) == true) goto L6;
        r102.setValue(r101);
        return;
    }

    @Override // com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel
    public void onAttachToUI(PluginHost r100, vv4.k r101) {
        super.onAttachToUI(r100, r101);
        Lazy r102 = FGDowngradeHelper.f216485a;
        if (FGDowngradeHelper.b() == false) goto L5;
        return;
    L5:
        this.context = r100.getContext().getApplicationContext();
        panelsViewModel().getActiveEditPanel().observe(r100.getLifecycleOwner(), new i(this));
    }

    public void onUpdateToolbar(T r100, T r101) {
        tt5.a.b(TAG, "onUpdateToolbar:" + r101);
        updateSubToolbars(r101);
        mutableToolbar().setValue(r101);
        updateExpandedSubToolbars();
    }

    public void processToolbarItemClick(ItemId r100, String r101) {
        tt5.a.b(TAG, "processToolbarItemClick:" + r100 + "," + r101);
        T r102 = getToolbar().getValue();
        if (r102 != null) goto L6;
        return;
    L6:
        if (r102.supportSubToolbar(r100) == false) goto L9;
        updateExpandedSubToolbars(r100);
    L9:
        if (ItemId.BusinessId.mention.name().equals(r100.name()) == false) goto L11;
        clearSubToolbars();
    L11:
        a r103 = this.delegate;
        if (r103 == null) goto L17;
        if (r101 != null) goto L15;
        r101 = "";
    L15:
        r103.b(r100, r101);
        return;
    }

    @Override // com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel
    public void onAttachToUI(FragmentActivity r100, vv4.k r101) {
        super.onAttachToUI(r100, r101);
        this.context = r100.getApplicationContext();
        panelsViewModel().getActiveEditPanel().observe(r100, new j(this));
    }
}
