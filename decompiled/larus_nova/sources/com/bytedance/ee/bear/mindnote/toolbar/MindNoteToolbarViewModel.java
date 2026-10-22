package com.bytedance.ee.bear.mindnote.toolbar;

import com.bytedance.ee.bear.doc.follow.event.VcKeyboardChangeEventProducer;
import com.bytedance.ee.bear.document.toolbar.BaseToolbarPanelViewModel;
import com.bytedance.ee.bear.document.toolbar.Toolbar;
import com.bytedance.ee.bear.document.toolbar.editpanels.KeyboardShowingStatusMode;
import com.bytedance.ee.util.ui.n;
import g45.a;
import g45.d;
import jj5.e;
import rcb.b;

/* JADX INFO: loaded from: classes18.dex */
public class MindNoteToolbarViewModel extends BaseToolbarPanelViewModel<MindNoteToolbar> implements VcKeyboardChangeEventProducer {
    private boolean isShowingFunctionPanel;
    private boolean isShowingSubToolBar;

    public static /* synthetic */ void No(MindNoteToolbarViewModel r100, Integer r101) {
        r100.lambda$new$1(r101);
    }

    public static /* synthetic */ void Oo(MindNoteToolbarViewModel r100, MindNoteToolbar r101) {
        r100.lambda$new$0(r101);
    }

    @Override // com.bytedance.ee.bear.document.toolbar.BaseToolbarPanelViewModel, com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel, g45.a
    public String getPanelName() {
        return "editor";
    }

    @Override // com.bytedance.ee.bear.document.toolbar.BaseToolbarPanelViewModel, com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel, g45.a
    public /* bridge */ /* synthetic */ void onBecomeActive(d r100, a r101) {
    }

    @Override // com.bytedance.ee.bear.document.toolbar.BaseToolbarPanelViewModel, com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel, g45.a
    public /* bridge */ /* synthetic */ void onBecomeInactive(d r100, a r101) {
    }

    @Override // com.bytedance.ee.bear.doc.follow.event.VcKeyboardChangeEventProducer
    public VcKeyboardChangeEventProducer.VcBottomBarPolicy getVcBottomBarPolicy() {
        if (this.isShowingFunctionPanel == false) goto L6;
        return VcKeyboardChangeEventProducer.VcBottomBarPolicy.ALWAYS_HIDE;
    L6:
        return VcKeyboardChangeEventProducer.VcBottomBarPolicy.ADJUST_BY_KEYBOARD;
    }

    public MindNoteToolbarViewModel() {
        this.isShowingSubToolBar = false;
        this.isShowingFunctionPanel = false;
        getToolbar().observeForever(new jj5.d(this));
        keyboardHeightLiveData().observeForever(new e(this));
    }

    private void updateToolbarPanelActive() {
        boolean r100 = true;
        if (getToolbar().getValue() == null) goto L5;
        boolean r101 = true;
    L7:
        if (getKeyboardHeight() <= 0) goto L9;
        boolean r102 = true;
    L10:
        tt5.a.h("BaseToolbarPanelViewModel", "updateToolbarPanelActive:" + r101 + "," + r102);
        if (n.D(n.g(this.context)) == false) goto L20;
        if (r101 == true) goto L18;
        if (r102 == true) goto L18;
        if (b.a(this.context) == true) goto L18;
        r100 = false;
    L18:
        setActive(r100);
        return;
    L20:
        if (this.isShowingFunctionPanel == true) goto L30;
        if (r101 == false) goto L26;
        if (r102 == false) goto L24;
    L27:
        setActive(r100);
        return;
    L24:
        if (b.a(this.context) == true) goto L27;
    L26:
        r100 = false;
        goto L27
    L30:
        return;
    L9:
        r102 = false;
        goto L10
    L5:
        r101 = false;
        goto L7
    }

    @Override // com.bytedance.ee.bear.document.toolbar.BaseToolbarPanelViewModel, com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel, g45.a
    public KeyboardShowingStatusMode getKeyboardShowingStatusMode() {
        return KeyboardShowingStatusMode.ALWAYS_SHOW;
    }

    @Override // com.bytedance.ee.bear.doc.follow.event.VcKeyboardChangeEventProducer
    public VcKeyboardChangeEventProducer.OrientationSwitchMode getOrientationSwitchMode() {
        return VcKeyboardChangeEventProducer.OrientationSwitchMode.ADJUST_BY_KEYBOARD_EVENT;
    }

    private /* synthetic */ void lambda$new$0(MindNoteToolbar r100) {
        updateToolbarPanelActive();
    }

    private /* synthetic */ void lambda$new$1(Integer r100) {
        updateToolbarPanelActive();
    }

    @Override // com.bytedance.ee.bear.document.toolbar.BaseToolbarPanelViewModel, com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel
    public void onKeyboardStateChanged(int r100) {
        if (n.D(n.g(this.context)) == false) goto L9;
        if (r100 != 0) goto L9;
        if (this.isShowingSubToolBar == false) goto L9;
        return;
    L9:
        if (this.isShowingFunctionPanel == false) goto L13;
        if (r100 != 0) goto L12;
        return;
    L12:
        clearSubToolbars();
        this.isShowingFunctionPanel = false;
    L13:
        super.onKeyboardStateChanged(r100);
    }

    public void setIsShowingSubToolBar(boolean r100) {
        this.isShowingSubToolBar = r100;
    }

    public void setShowingFunctionPanel(boolean r100) {
        this.isShowingFunctionPanel = r100;
    }

    public void updateToolbar(MindNoteToolbar r100) {
        tt5.a.h("BaseToolbarPanelViewModel", "updateToolbar:" + r100);
        MindNoteToolbar r101 = getToolbar().getValue();
        if (Toolbar.equals(r100, r101) == true) goto L6;
        onUpdateToolbar(r101, r100);
        return;
    }

    @Override // com.bytedance.ee.bear.document.toolbar.BaseToolbarPanelViewModel
    public /* bridge */ /* synthetic */ void updateToolbar(Toolbar r100) {
        updateToolbar((MindNoteToolbar) r100);
    }
}
