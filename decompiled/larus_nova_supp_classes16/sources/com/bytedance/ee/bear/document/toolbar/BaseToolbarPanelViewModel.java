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
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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

        void b(ItemId r1, String r2);
    }

    public static /* synthetic */ void Mo(BaseToolbarPanelViewModel r0, g45.a r1) {
        r0.lambda$onAttachToUI$1(r1);
    }

    public static /* synthetic */ void yo(BaseToolbarPanelViewModel r0, g45.a r1) {
        r0.lambda$onAttachToUI$0(r1);
    }

    @Override // com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel, g45.a
    public abstract /* synthetic */ String getPanelName();

    @Override // com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel, g45.a
    public /* bridge */ /* synthetic */ void onBecomeActive(g45.d r1, g45.a r2) {
    }

    @Override // com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel, g45.a
    public /* bridge */ /* synthetic */ void onBecomeInactive(g45.d r1, g45.a r2) {
    }

    public LiveData<Stack<ItemId>> getExpandedSubToolbars() {
        if (this.expandedSubToolbars != null) goto L6;
        MutableLiveData<Stack<ItemId>> r0 = new MutableLiveData();
        r0.setValue(new Stack());
        this.expandedSubToolbars = r0;
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
        MutableLiveData<Stack<ItemId>> r0 = this.expandedSubToolbars;
        if (r0 != null) goto L5;
        return false;
    L5:
        Stack r1 = (Stack) r0.getValue();
        if (r1 != null) goto L8;
        return false;
    L8:
        if (r1.isEmpty() == true) goto L12;
        return true;
    L12:
        return false;
    }

    public boolean isAtVc() {
        a r0 = this.delegate;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.a();
    }

    public BaseToolbarPanelViewModel() {
        this.hasWindowFocus = new MutableLiveData();
    }

    public boolean clearSubToolbars() {
        MutableLiveData r0 = getExpandedSubToolbars();
        Stack r1 = (Stack) r0.getValue();
        if (r1.isEmpty() == true) goto L6;
        r1.clear();
        r0.setValue(r1);
        return true;
    L6:
        return false;
    }

    public MutableLiveData<T> mutableToolbar() {
        return getToolbar();
    }

    @Override // com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel
    public void onDetachFromUI() {
        super.onDetachFromUI();
        this.delegate = null;
        this.toolbar = null;
        this.expandedSubToolbars = null;
        this.subToolbars = null;
    }

    public void updateExpandedSubToolbars() {
        Toolbar r0 = (Toolbar) getToolbar().getValue();
        if (r0 != null) goto L8;
        MutableLiveData<Stack<ItemId>> r1 = this.expandedSubToolbars;
        if (r1 == null) goto L43;
        r1.setValue(new Stack());
        return;
    L43:
        return;
    L8:
        MutableLiveData r2 = getExpandedSubToolbars();
        Stack r3 = (Stack) r2.getValue();
        Item[] r4 = r0.getChildren();
        int r5 = r4.length;
        int r6 = 0;
        boolean r7 = false;
    L10:
        if (r6 >= r5) goto L17;
        Item r8 = r4[r6];
        ItemId r9 = r8.id();
        if (r8.isEnable() == true) goto L16;
        if (r3.contains(r9) == false) goto L16;
        r3.remove(r9);
        r7 = true;
    L16:
        r6 = r6 + 1;
        goto L10
    L17:
        Iterator r10 = r3.iterator();
    L19:
        if (r10.hasNext() == false) goto L29;
        ItemId r11 = (ItemId) r10.next();
        int r12 = r4.length;
        int r13 = 0;
    L21:
        if (r13 >= r12) goto L26;
        if (r4[r13].id() == r11) goto L24;
        r13 = r13 + 1;
        goto L21
    L24:
        boolean r14 = true;
    L27:
        if (r14 == true) goto L19;
        r10.remove();
        r7 = true;
        goto L19
    L26:
        r14 = false;
        goto L27
    L29:
        if (r7 == false) goto L44;
        r2.setValue(r3);
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

    private /* synthetic */ void lambda$onAttachToUI$0(g45.a r1) {
        if (this == r1) goto L5;
        clearSubToolbars();
        return;
    }

    private /* synthetic */ void lambda$onAttachToUI$1(g45.a r1) {
        if (this == r1) goto L5;
        clearSubToolbars();
        return;
    }

    private void updateSubToolbars(T r7) {
        if (r7 != null) goto L11;
        Map<ItemId, MutableLiveData<Item[]>> r8 = this.subToolbars;
        if (r8 == null) goto L10;
        Iterator<MutableLiveData<Item[]>> r9 = r8.values().iterator();
    L8:
        if (r9.hasNext() == false) goto L30;
        r9.next().setValue(new Item[0]);
        goto L8
    L30:
        return;
    L10:
        return;
    L11:
        Item[] r1 = r7.getChildren();
        int r2 = r1.length;
        int r3 = 0;
    L12:
        if (r3 >= r2) goto L14;
        Item r4 = r1[r3];
        updateSubToolbarValues(r4.id(), r4.getChildren());
        r3 = r3 + 1;
        goto L12
    L14:
        Map<ItemId, MutableLiveData<Item[]>> r5 = this.subToolbars;
        if (r5 == null) goto L22;
        Iterator<Map.Entry<ItemId, MutableLiveData<Item[]>>> r6 = r5.entrySet().iterator();
    L18:
        if (r6.hasNext() == false) goto L31;
        ItemId r10 = r6.next().getKey();
        if (r7.contains(r10) == true) goto L18;
        updateSubToolbarValues(r10, new Item[0]);
        goto L18
    L31:
        return;
    }

    public void configToolbar(T r1) {
        updateToolbar(r1);
    }

    @Override // com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel, g45.a
    public int getPanelHeight(Context r2) {
        return r2.getResources().getDimensionPixelSize(2131168470);
    }

    public LiveData<Item[]> getSubToolbar(ItemId r3) {
        if (this.subToolbars != null) goto L5;
        this.subToolbars = new HashMap();
    L5:
        LiveData<Item[]> r0 = this.subToolbars.get(r3);
        if (r0 != null) goto L9;
        MutableLiveData<Item[]> r1 = new MutableLiveData();
        this.subToolbars.put(r3, r1);
        return r1;
    L9:
        return r0;
    }

    public boolean isExpanded(Item r3) {
        Stack r0 = (Stack) getExpandedSubToolbars().getValue();
        if (r0.isEmpty() == false) goto L5;
    L7:
        return false;
    L5:
        if (r0.peek() != r3.id()) goto L7;
        return true;
    }

    @Override // com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel
    public void onKeyboardStateChanged(int r2) {
        super.onKeyboardStateChanged(r2);
        if (r2 != 0) goto L12;
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

    @Override // com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel, g45.a
    public void requestNotFocus(Context r3) {
        super.requestNotFocus(r3);
        MutableLiveData r4 = getExpandedSubToolbars();
        Stack r0 = (Stack) r4.getValue();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isEmpty() == true) goto L9;
        r0.clear();
        r4.setValue(r0);
        return;
    }

    public void setCurrItemId(ItemId r1) {
        this.currItemId = r1;
    }

    public void setDelegate(a r1) {
        this.delegate = r1;
    }

    public void setLastItemId(ItemId r1) {
        this.lastItemId = r1;
    }

    public void updateExpandedSubToolbars(ItemId r5) {
        MutableLiveData r0 = getExpandedSubToolbars();
        Stack r1 = (Stack) r0.getValue();
        if (r1.isEmpty() == false) goto L5;
    L7:
        boolean r2 = false;
    L9:
        if (r1.isEmpty() == true) goto L16;
        if (r1.contains(r5) == false) goto L16;
        if (r1.peek() == r5) goto L16;
        r1.pop();
    L16:
        if (r1.isEmpty() == false) goto L18;
    L22:
        r1.push(r5);
    L23:
        r0.setValue(r1);
        return;
    L18:
        if (r1.peek() != r5) goto L22;
        if (r2 == false) goto L23;
        r1.clear();
        goto L23
    L5:
        if (r1.peek() != r5) goto L7;
        r2 = true;
        goto L9
    }

    public void updateToolbar(T r3) {
        tt5.a.h(TAG, "updateToolbar:" + r3);
        Toolbar r0 = (Toolbar) getToolbar().getValue();
        if (Toolbar.equals(r3, r0) == true) goto L10;
        onUpdateToolbar(r0, r3);
        if (r3 == null) goto L7;
        boolean r4 = true;
    L8:
        setActive(r4);
        return;
    L7:
        r4 = false;
        goto L8
    }

    private void updateSubToolbarValues(ItemId r2, Item[] r3) {
        MutableLiveData r4 = getSubToolbar(r2);
        if (Arrays.equals((Item[]) r4.getValue(), r3) == true) goto L6;
        r4.setValue(r3);
        return;
    }

    @Override // com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel
    public void onAttachToUI(PluginHost r2, vv4.k r3) {
        super.onAttachToUI(r2, r3);
        Lazy r4 = FGDowngradeHelper.a;
        if (FGDowngradeHelper.b() == false) goto L5;
        return;
    L5:
        this.context = r2.getContext().getApplicationContext();
        panelsViewModel().getActiveEditPanel().observe(r2.getLifecycleOwner(), new i(this));
    }

    public void onUpdateToolbar(T r2, T r3) {
        tt5.a.b(TAG, "onUpdateToolbar:" + r3);
        updateSubToolbars(r3);
        mutableToolbar().setValue(r3);
        updateExpandedSubToolbars();
    }

    public void processToolbarItemClick(ItemId r3, String r4) {
        tt5.a.b(TAG, "processToolbarItemClick:" + r3 + "," + r4);
        Toolbar r0 = (Toolbar) getToolbar().getValue();
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.supportSubToolbar(r3) == false) goto L9;
        updateExpandedSubToolbars(r3);
    L9:
        if (ItemId.BusinessId.mention.name().equals(r3.name()) == false) goto L11;
        clearSubToolbars();
    L11:
        a r1 = this.delegate;
        if (r1 == null) goto L17;
        if (r4 != null) goto L15;
        r4 = "";
    L15:
        r1.b(r3, r4);
        return;
    }

    @Override // com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel
    public void onAttachToUI(FragmentActivity r2, vv4.k r3) {
        super.onAttachToUI(r2, r3);
        this.context = r2.getApplicationContext();
        panelsViewModel().getActiveEditPanel().observe(r2, new j(this));
    }
}
