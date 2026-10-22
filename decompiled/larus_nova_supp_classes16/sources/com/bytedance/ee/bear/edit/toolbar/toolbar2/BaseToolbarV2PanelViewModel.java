package com.bytedance.ee.bear.edit.toolbar.toolbar2;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.document.model.toolbar.ItemIdV2;
import com.bytedance.ee.bear.document.model.toolbar.ItemV2;
import com.bytedance.ee.bear.document.model.toolbar.ToolbarV2;
import com.bytedance.ee.bear.document.toolbar.editpanels.KeyboardShowingStatusMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class BaseToolbarV2PanelViewModel<T extends ToolbarV2> extends ViewModel implements g45.a, ocb.a {
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

        void c(LifecycleOwner r1, Observer r2);

        <V> void onToolbarItemClick(ItemIdV2 r1, V r2, int r3);
    }

    public abstract /* synthetic */ String getPanelName();

    public /* bridge */ /* synthetic */ void onBecomeActive(g45.d r1, g45.a r2) {
    }

    public /* bridge */ /* synthetic */ void onBecomeInactive(g45.d r1, g45.a r2) {
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
        MutableLiveData<Rect> r0 = new MutableLiveData();
        this.subToolbarV2Rect = r0;
        r0.setValue(new Rect());
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
        MutableLiveData<ItemV2> r0 = this.expandedSubToolbar;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.getValue() == null) goto L7;
        return true;
    }

    public boolean hasFunctionPanel() {
        MutableLiveData<ItemV2> r0 = this.expandedSubToolbar;
        if (r0 != null) goto L6;
        return false;
    L6:
        if (r0.getValue() != null) goto L8;
        return false;
    L8:
        if (((ItemV2) this.expandedSubToolbar.getValue()).id().displayMode() != ItemIdV2.DisplayMode.FunctionPanel) goto L12;
        return true;
    L12:
        return false;
    }

    public boolean hasSubToolBarV2() {
        MutableLiveData<ItemV2> r0 = this.expandedSubToolbar;
        if (r0 != null) goto L5;
    L9:
        return false;
    L5:
        if (r0.getValue() == null) goto L9;
        if (((ItemV2) this.expandedSubToolbar.getValue()).id().displayMode() != ItemIdV2.DisplayMode.SubToolBarV2) goto L9;
        return true;
    }

    public void hideToolbar() {
        tt5.a.h(TAG, "dismissToolBar:" + this.toolbar);
        clearSubToolbar();
        updateToolbar(null);
    }

    public boolean isAtVc() {
        a r0 = this.delegate;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.a();
    }

    public LiveData<Integer> keyboardHeightLiveData() {
        if (this.keyboardHeightLiveData != null) goto L6;
        this.keyboardHeightLiveData = new MutableLiveData();
    L6:
        return this.keyboardHeightLiveData;
    }

    public void requestUpdateContentHeight() {
        a r0 = this.delegate;
        if (r0 == null) goto L5;
        r0.b();
        return;
    L5:
        tt5.a.d(TAG, "requestUpdateContentHeight delegate == null");
    }

    public BaseToolbarV2PanelViewModel() {
        this.hasWindowFocus = new MutableLiveData();
    }

    public boolean clearSubToolbar() {
        if (hasExpandedSubToolbar() == false) goto L8;
        ItemIdV2 r0 = ((ItemV2) this.expandedSubToolbar.getValue()).id();
        updateExpandedSubToolbar(null);
        if (r0.displayMode() != ItemIdV2.DisplayMode.FunctionPanel) goto L9;
        return true;
    L9:
        return false;
    L8:
        return false;
    }

    public int getKeyboardHeight() {
        Integer r0 = (Integer) keyboardHeightLiveData().getValue();
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.intValue();
    }

    public String getShowingItemId() {
        if (mutableToolbar().getValue() != null) goto L7;
        return null;
    L7:
        return ((ToolbarV2) mutableToolbar().getValue()).getShowingItemId();
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
        return getToolbar();
    }

    public void updateExpandedSubToolbar() {
        ToolbarV2 r0 = (ToolbarV2) getToolbar().getValue();
        if (r0 != null) goto L6;
        clearSubToolbar();
        return;
    L6:
        ItemV2[] r1 = r0.getItems();
        tt5.a.h(TAG, "current showing item id: " + ((ItemV2) getExpandedSubToolbar().getValue()));
        if (r1 != null) goto L9;
    L18:
        clearSubToolbar();
        return;
    L9:
        if (TextUtils.isEmpty(r0.getShowingItemId()) == true) goto L18;
        int r2 = r1.length;
        int r4 = 0;
    L12:
        if (r4 >= r2) goto L22;
        ItemV2 r5 = r1[r4];
        if (r5.id().name().equals(r0.getShowingItemId()) == true) goto L15;
        r4 = r4 + 1;
        goto L12
    L15:
        tt5.a.h(TAG, "update show subToolbarV2 " + r5);
        updateExpandedSubToolbar(r5);
        return;
    }

    public KeyboardShowingStatusMode getKeyboardShowingStatusMode() {
        return KeyboardShowingStatusMode.ALWAYS_SHOW;
    }

    public MutableLiveData<Boolean> hasWindowFocus() {
        return this.hasWindowFocus;
    }

    public void onDetachFromUI() {
        hideToolbar();
    }

    private void updateExpandedSubToolbar(ItemV2 r4) {
        getExpandedSubToolbar();
        ItemV2 r0 = (ItemV2) this.expandedSubToolbar.getValue();
        tt5.a.d(TAG, "updateExpandedSubToolbar from " + r0 + " to " + r4);
        if (r0 == null) goto L8;
        if (r4 == null) goto L8;
        if (TextUtils.equals(r0.getId(), r4.getId()) == false) goto L8;
        tt5.a.h(TAG, "item no changed , ignore updateExpandedSubToolbar");
    L8:
        this.expandedSubToolbar.setValue(r4);
    }

    public int getPanelHeight(Context r2) {
        return r2.getResources().getDimensionPixelSize(2131165742);
    }

    boolean isExpanded(ItemV2 r2) {
        ItemV2 r0 = (ItemV2) getExpandedSubToolbar().getValue();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.id() != r2.id()) goto L7;
        return true;
    }

    public boolean isLastShowingId(String r2) {
        if (r2 != null) goto L4;
    L6:
        return false;
    L4:
        if (r2.equals(this.lastShowingItemIdV2) == false) goto L6;
        return true;
    }

    public void onKeyboardStateChanged(int r2) {
        keyboardHeightLiveData().setValue(Integer.valueOf(r2));
    }

    @Override // g45.a
    public void requestNotFocus(Context r2) {
        rcb.c.c(r2);
        tt5.a.h(TAG, "requestNotFocus");
        if (hasFunctionPanel() == false) goto L6;
        hideToolbar();
        return;
    }

    public void setActive(boolean r3) {
        MutableLiveData r0 = getActive();
        if (r0.getValue() != null) goto L5;
    L6:
        r0.setValue(Boolean.valueOf(r3));
        return;
    L5:
        if (((Boolean) r0.getValue()).booleanValue() != r3) goto L6;
    }

    public void setDelegate(a r1) {
        this.delegate = r1;
    }

    public void updateSubToolbarV2Rect(Rect r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        tt5.a.b(TAG, "updateSubToolbarV2Rect=" + r3.toString());
        if (r3.equals((Rect) getSubToolbarV2Rect().getValue()) == true) goto L8;
        this.subToolbarV2Rect.setValue(r3);
        return;
    }

    public void updateToolbar(T r6) {
        tt5.a.h(TAG, getClass().getSimpleName() + " updateToolbar:" + r6);
        ToolbarV2 r0 = (ToolbarV2) getToolbar().getValue();
        updateLastShowingItemId(r0, r6);
        if (ToolbarV2.equals(r6, r0) == true) goto L13;
        onUpdateToolbar(r0, r6);
        StringBuilder r1 = new StringBuilder("setActive ");
        boolean r2 = true;
        if (r6 == null) goto L7;
        boolean r4 = true;
    L8:
        r1.append(r4);
        r1.append(" getActive ");
        r1.append(getActive().getValue());
        tt5.a.h(TAG, r1.toString());
        if (r6 != null) goto L12;
        r2 = false;
    L12:
        setActive(r2);
        return;
    L7:
        r4 = false;
        goto L8
    L13:
        if (r0 != null) goto L17;
        tt5.a.h(TAG, "all toolbar is null");
        return;
    }

    private void updateLastShowingItemId(T r4, T r5) {
        tt5.a.h(TAG, "before updateLastShowingItemId: " + this.lastShowingItemIdV2);
        if (r4 != null) goto L5;
        this.lastShowingItemIdV2 = null;
    L9:
        tt5.a.h(TAG, "after updateLastShowingItemId =" + this.lastShowingItemIdV2);
        return;
    L5:
        if (r5 == null) goto L7;
        tt5.a.h(TAG, "### new showing item =" + r5.getShowingItemId());
    L8:
        this.lastShowingItemIdV2 = r4.getShowingItemId();
        goto L9
    L7:
        tt5.a.h(TAG, "### new showing item is null");
        goto L8
    }

    public void observeActivePanel(LifecycleOwner r2, Observer r3) {
        a r0 = this.delegate;
        if (r0 == null) goto L5;
        r0.c(r2, r3);
        return;
    L5:
        tt5.a.d(TAG, "observeActivePanel delegate == null");
    }

    public void onAttachToUI(FragmentActivity r1, tb5.n r2) {
        this.bridge = r2;
    }

    public void onUpdateToolbar(T r2, T r3) {
        tt5.a.b(TAG, " onUpdateToolbar:" + r3);
        mutableToolbar().setValue(r3);
        updateExpandedSubToolbar();
    }

    public void processToolbarItemClick(ItemIdV2 r3, String r4) {
        tt5.a.h(TAG, "processToolbarItemClick:" + r3 + "," + r4);
        if (((ToolbarV2) getToolbar().getValue()) != null) goto L6;
        tt5.a.h(TAG, "Toolbar is null");
        return;
    L6:
        a r0 = this.delegate;
        if (r0 == null) goto L12;
        if (r4 != null) goto L10;
        r4 = "";
    L10:
        r0.onToolbarItemClick(r3, r4, 1);
        return;
    }

    public void dispatchBridgeMsg(String r2, Object r3, tb5.m r4) {
        this.bridge.a(r2, r3, r4);
    }

    public void onKeyboardHeightChanged(pcb.a r1, int r2, int r3) {
        onKeyboardStateChanged(r2);
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
    public <V> void processSubToolbarItemClick(ItemIdV2 r3, V r4, int r5) {
        tt5.a.h(TAG, "processSubToolbarItemClick:" + r3 + "," + r4);
        if (((ToolbarV2) getToolbar().getValue()) != null) goto L5;
        return;
    L5:
        a r0 = this.delegate;
        if (r0 == null) goto L11;
        if (r4 != null) goto L9;
        r4 = (V) "";
    L9:
        r0.onToolbarItemClick(r3, r4, r5);
        return;
    }
}
