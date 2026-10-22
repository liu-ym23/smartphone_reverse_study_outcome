package com.bytedance.ee.bear.edit.component.toolbar2;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.doc.follow.event.VcKeyboardChangeEventProducer;
import com.bytedance.ee.bear.document.model.toolbar.ItemIdV2;
import com.bytedance.ee.bear.document.model.toolbar.ItemV2;
import com.bytedance.ee.bear.document.model.toolbar.ToolbarV2;
import com.bytedance.ee.bear.document.toolbar.editpanels.KeyboardShowingStatusMode;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public abstract class BaseToolbarV2PanelViewModel<T extends ToolbarV2> extends ViewModel implements g45.a, ocb.a, VcKeyboardChangeEventProducer {
    private static final String TAG = "BaseToolbarV2PanelViewM";
    protected MutableLiveData<Boolean> active;
    protected tb5.n bridge;
    private a delegate;
    private MutableLiveData<ItemV2> expandedSubToolbar;
    private MutableLiveData<Boolean> hasWindowFocus;
    private MutableLiveData<Integer> keyboardHeightLiveData;
    private String lastShowingItemIdV2;
    private MutableLiveData<Rect> subToolbarV2Rect;
    private MutableLiveData<T> toolbar;

    public interface a {
        boolean a();

        void b();

        void c(LifecycleOwner r100, Observer r101);

        <V> void onToolbarItemClick(ItemIdV2 r100, V r101, int r102);
    }

    @Override // g45.a
    public abstract /* synthetic */ String getPanelName();

    @Override // g45.a
    public /* bridge */ /* synthetic */ void onBecomeActive(g45.d r100, g45.a r101) {
    }

    @Override // g45.a
    public /* bridge */ /* synthetic */ void onBecomeInactive(g45.d r100, g45.a r101) {
    }

    public void onDetachFromHost() {
        this.delegate = null;
    }

    @Override // g45.a
    public LiveData<Boolean> getActive() {
        if (this.active != null) goto L6;
        this.active = new MutableLiveData();
    L6:
        return this.active;
    }

    public LiveData<ItemV2> getExpandedSubToolbar() {
        if (this.expandedSubToolbar != null) goto L6;
        this.expandedSubToolbar = new MutableLiveData();
    L6:
        return this.expandedSubToolbar;
    }

    public LiveData<Rect> getSubToolbarV2Rect() {
        if (this.subToolbarV2Rect != null) goto L6;
        MutableLiveData<Rect> r100 = new MutableLiveData();
        this.subToolbarV2Rect = r100;
        r100.setValue(new Rect());
    L6:
        return this.subToolbarV2Rect;
    }

    public LiveData<T> getToolbar() {
        if (this.toolbar != null) goto L6;
        this.toolbar = new MutableLiveData();
    L6:
        return this.toolbar;
    }

    public boolean hasExpandedSubToolbar() {
        MutableLiveData<ItemV2> r100 = this.expandedSubToolbar;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.getValue() == null) goto L7;
        return true;
    }

    public boolean hasFunctionPanel() {
        MutableLiveData<ItemV2> r100 = this.expandedSubToolbar;
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.getValue() != null) goto L8;
        return false;
    L8:
        if (this.expandedSubToolbar.getValue().id().displayMode() != ItemIdV2.DisplayMode.FunctionPanel) goto L12;
        return true;
    L12:
        return false;
    }

    public boolean hasSubToolBarV2() {
        MutableLiveData<ItemV2> r100 = this.expandedSubToolbar;
        if (r100 != null) goto L5;
    L9:
        return false;
    L5:
        if (r100.getValue() == null) goto L9;
        if (this.expandedSubToolbar.getValue().id().displayMode() != ItemIdV2.DisplayMode.SubToolBarV2) goto L9;
        return true;
    }

    public void hideToolbar() {
        tt5.a.h(TAG, "dismissToolBar:" + this.toolbar);
        clearSubToolbar();
        updateToolbar(null);
    }

    public boolean isAtVc() {
        a r100 = this.delegate;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.a();
    }

    public LiveData<Integer> keyboardHeightLiveData() {
        if (this.keyboardHeightLiveData != null) goto L6;
        this.keyboardHeightLiveData = new MutableLiveData();
    L6:
        return this.keyboardHeightLiveData;
    }

    public void requestUpdateContentHeight() {
        a r100 = this.delegate;
        if (r100 == null) goto L5;
        r100.b();
        return;
    L5:
        tt5.a.d(TAG, "requestUpdateContentHeight delegate == null");
    }

    public BaseToolbarV2PanelViewModel() {
        this.hasWindowFocus = new MutableLiveData();
    }

    public boolean clearSubToolbar() {
        if (hasExpandedSubToolbar() == false) goto L8;
        ItemIdV2 r100 = this.expandedSubToolbar.getValue().id();
        updateExpandedSubToolbar(null);
        if (r100.displayMode() != ItemIdV2.DisplayMode.FunctionPanel) goto L9;
        return true;
    L9:
        return false;
    L8:
        return false;
    }

    public int getKeyboardHeight() {
        Integer r100 = keyboardHeightLiveData().getValue();
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.intValue();
    }

    public String getShowingItemId() {
        if (mutableToolbar().getValue() != null) goto L7;
        return null;
    L7:
        return mutableToolbar().getValue().getShowingItemId();
    }

    public boolean hasToolbarV2() {
        if (getToolbar() != null) goto L5;
    L7:
        return false;
    L5:
        if (getToolbar().getValue() == null) goto L7;
        return true;
    }

    public MutableLiveData<T> mutableToolbar() {
        return (MutableLiveData) getToolbar();
    }

    public void updateExpandedSubToolbar() {
        T r100 = getToolbar().getValue();
        if (r100 != null) goto L6;
        clearSubToolbar();
        return;
    L6:
        ItemV2[] r101 = r100.getItems();
        tt5.a.h(TAG, "current showing item id: " + getExpandedSubToolbar().getValue());
        if (TextUtils.isEmpty(r100.getShowingItemId()) == false) goto L9;
        clearSubToolbar();
        return;
    L9:
        int r102 = r101.length;
        int r103 = 0;
    L10:
        if (r103 >= r102) goto L19;
        ItemV2 r104 = r101[r103];
        if (r104.id().name().equals(r100.getShowingItemId()) == true) goto L13;
        r103 = r103 + 1;
        goto L10
    L13:
        tt5.a.h(TAG, "update show subToolbarV2 " + r104);
        updateExpandedSubToolbar(r104);
        return;
    }

    @Override // g45.a
    public KeyboardShowingStatusMode getKeyboardShowingStatusMode() {
        return KeyboardShowingStatusMode.ALWAYS_SHOW;
    }

    @Override // com.bytedance.ee.bear.doc.follow.event.VcKeyboardChangeEventProducer
    public VcKeyboardChangeEventProducer.OrientationSwitchMode getOrientationSwitchMode() {
        return VcKeyboardChangeEventProducer.OrientationSwitchMode.ADJUST_BY_KEYBOARD_EVENT;
    }

    @Override // com.bytedance.ee.bear.doc.follow.event.VcKeyboardChangeEventProducer
    public VcKeyboardChangeEventProducer.VcBottomBarPolicy getVcBottomBarPolicy() {
        return VcKeyboardChangeEventProducer.VcBottomBarPolicy.ADJUST_BY_KEYBOARD;
    }

    public MutableLiveData<Boolean> hasWindowFocus() {
        return this.hasWindowFocus;
    }

    public void onDetachFromUI() {
        hideToolbar();
    }

    private void updateExpandedSubToolbar(ItemV2 r100) {
        getExpandedSubToolbar();
        ItemV2 r101 = this.expandedSubToolbar.getValue();
        tt5.a.d(TAG, "updateExpandedSubToolbar from " + r101 + " to " + r100);
        if (r101 == null) goto L8;
        if (r100 == null) goto L8;
        if (TextUtils.equals(r101.getId(), r100.getId()) == false) goto L8;
        tt5.a.h(TAG, "item no changed , ignore updateExpandedSubToolbar");
    L8:
        this.expandedSubToolbar.setValue(r100);
    }

    @Override // g45.a
    public int getPanelHeight(Context r100) {
        return r100.getResources().getDimensionPixelSize(R.dimen.toolbar_menu_height);
    }

    public boolean isExpanded(ItemV2 r100) {
        ItemV2 r101 = getExpandedSubToolbar().getValue();
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.id() != r100.id()) goto L7;
        return true;
    }

    public boolean isLastShowingId(String r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (r100.equals(this.lastShowingItemIdV2) == false) goto L6;
        return true;
    }

    public void onKeyboardStateChanged(int r100) {
        ((MutableLiveData) keyboardHeightLiveData()).setValue(Integer.valueOf(r100));
    }

    @Override // g45.a
    public void requestNotFocus(Context r100) {
        rcb.c.c(r100);
        tt5.a.h(TAG, "requestNotFocus");
        if (hasFunctionPanel() == false) goto L6;
        hideToolbar();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setActive(boolean r100) {
        MutableLiveData r101 = (MutableLiveData) getActive();
        if (r101.getValue() != 0) goto L5;
    L6:
        r101.setValue(Boolean.valueOf(r100));
        return;
    L5:
        if (((Boolean) r101.getValue()).booleanValue() != r100) goto L6;
    }

    public void setDelegate(a r100) {
        this.delegate = r100;
    }

    public void updateSubToolbarV2Rect(Rect r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        tt5.a.b(TAG, "updateSubToolbarV2Rect=" + r100.toString());
        if (r100.equals(getSubToolbarV2Rect().getValue()) == true) goto L8;
        this.subToolbarV2Rect.setValue(r100);
        return;
    }

    public void updateToolbar(T r100) {
        tt5.a.h(TAG, getClass().getSimpleName() + " updateToolbar:" + r100);
        T r101 = getToolbar().getValue();
        updateLastShowingItemId(r101, r100);
        if (ToolbarV2.equals(r100, r101) == true) goto L13;
        onUpdateToolbar(r101, r100);
        StringBuilder r102 = new StringBuilder("setActive ");
        boolean r103 = true;
        if (r100 == null) goto L7;
        boolean r104 = true;
    L8:
        r102.append(r104);
        r102.append(" getActive ");
        r102.append(getActive().getValue());
        tt5.a.h(TAG, r102.toString());
        if (r100 != null) goto L12;
        r103 = false;
    L12:
        setActive(r103);
        return;
    L7:
        r104 = false;
        goto L8
    L13:
        if (r101 != null) goto L17;
        tt5.a.h(TAG, "all toolbar is null");
        return;
    }

    private void updateLastShowingItemId(T r100, T r101) {
        tt5.a.h(TAG, "before updateLastShowingItemId: " + this.lastShowingItemIdV2);
        if (r100 != null) goto L5;
        this.lastShowingItemIdV2 = null;
    L9:
        tt5.a.h(TAG, "after updateLastShowingItemId =" + this.lastShowingItemIdV2);
        return;
    L5:
        if (r101 == null) goto L7;
        tt5.a.h(TAG, "### new showing item =" + r101.getShowingItemId());
    L8:
        this.lastShowingItemIdV2 = r100.getShowingItemId();
        goto L9
    L7:
        tt5.a.h(TAG, "### new showing item is null");
        goto L8
    }

    public void observeActivePanel(LifecycleOwner r100, Observer r101) {
        a r102 = this.delegate;
        if (r102 == null) goto L5;
        r102.c(r100, r101);
        return;
    L5:
        tt5.a.d(TAG, "observeActivePanel delegate == null");
    }

    public void onAttachToUI(FragmentActivity r100, tb5.n r101) {
        this.bridge = r101;
    }

    public void onUpdateToolbar(T r100, T r101) {
        tt5.a.b(TAG, " onUpdateToolbar:" + r101);
        mutableToolbar().setValue(r101);
        updateExpandedSubToolbar();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public <V> void processSubToolbarItemClick(ItemIdV2 r100, V r101) {
        tt5.a.b(TAG, "processSubToolbarItemClick:" + r100 + "," + r101);
        if (getToolbar().getValue() != null) goto L5;
        return;
    L5:
        a r102 = this.delegate;
        if (r102 == null) goto L11;
        if (r101 != null) goto L9;
        r101 = (V) "";
    L9:
        r102.onToolbarItemClick(r100, r101, 2);
        return;
    }

    public void processToolbarItemClick(ItemIdV2 r100, String r101) {
        tt5.a.b(TAG, "processToolbarItemClick:" + r100 + "," + r101);
        if (getToolbar().getValue() != null) goto L6;
        tt5.a.h(TAG, "Toolbar is null");
        return;
    L6:
        a r102 = this.delegate;
        if (r102 == null) goto L12;
        if (r101 != null) goto L10;
        r101 = "";
    L10:
        r102.onToolbarItemClick(r100, r101, 1);
        return;
    }

    public void dispatchBridgeMsg(String r100, Object r101, tb5.m r102) {
        this.bridge.a(r100, r101, r102);
    }

    @Override // ocb.a
    public void onKeyboardHeightChanged(pcb.a r100, int r101, int r102) {
        onKeyboardStateChanged(r101);
    }
}
