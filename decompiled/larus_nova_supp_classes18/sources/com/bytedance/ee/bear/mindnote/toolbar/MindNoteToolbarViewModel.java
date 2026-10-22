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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class MindNoteToolbarViewModel extends BaseToolbarPanelViewModel<MindNoteToolbar> implements VcKeyboardChangeEventProducer {
    private boolean isShowingFunctionPanel;
    private boolean isShowingSubToolBar;

    public static /* synthetic */ void No(MindNoteToolbarViewModel r0, Integer r1) {
        r0.lambda$new$1(r1);
    }

    public static /* synthetic */ void Oo(MindNoteToolbarViewModel r0, MindNoteToolbar r1) {
        r0.lambda$new$0(r1);
    }

    public String getPanelName() {
        return "editor";
    }

    public /* bridge */ /* synthetic */ void onBecomeActive(d r1, a r2) {
    }

    public /* bridge */ /* synthetic */ void onBecomeInactive(d r1, a r2) {
    }

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
        boolean r1 = true;
        if (getToolbar().getValue() == null) goto L5;
        boolean r0 = true;
    L7:
        if (getKeyboardHeight() <= 0) goto L9;
        boolean r3 = true;
    L10:
        tt5.a.h("BaseToolbarPanelViewModel", "updateToolbarPanelActive:" + r0 + "," + r3);
        if (n.D(n.g(((BaseToolbarPanelViewModel) this).context)) == false) goto L20;
        if (r0 == true) goto L18;
        if (r3 == true) goto L18;
        if (b.a(((BaseToolbarPanelViewModel) this).context) == true) goto L18;
        r1 = false;
    L18:
        setActive(r1);
        return;
    L20:
        if (this.isShowingFunctionPanel == true) goto L30;
        if (r0 == false) goto L26;
        if (r3 == false) goto L24;
    L27:
        setActive(r1);
        return;
    L24:
        if (b.a(((BaseToolbarPanelViewModel) this).context) == true) goto L27;
    L26:
        r1 = false;
        goto L27
    L30:
        return;
    L9:
        r3 = false;
        goto L10
    L5:
        r0 = false;
        goto L7
    }

    public KeyboardShowingStatusMode getKeyboardShowingStatusMode() {
        return KeyboardShowingStatusMode.ALWAYS_SHOW;
    }

    public VcKeyboardChangeEventProducer.OrientationSwitchMode getOrientationSwitchMode() {
        return VcKeyboardChangeEventProducer.OrientationSwitchMode.ADJUST_BY_KEYBOARD_EVENT;
    }

    private /* synthetic */ void lambda$new$0(MindNoteToolbar r1) {
        updateToolbarPanelActive();
    }

    private /* synthetic */ void lambda$new$1(Integer r1) {
        updateToolbarPanelActive();
    }

    public void onKeyboardStateChanged(int r2) {
        if (n.D(n.g(((BaseToolbarPanelViewModel) this).context)) == false) goto L9;
        if (r2 != 0) goto L9;
        if (this.isShowingSubToolBar == false) goto L9;
        return;
    L9:
        if (this.isShowingFunctionPanel == false) goto L13;
        if (r2 != 0) goto L12;
        return;
    L12:
        clearSubToolbars();
        this.isShowingFunctionPanel = false;
    L13:
        super.onKeyboardStateChanged(r2);
    }

    public void setIsShowingSubToolBar(boolean r1) {
        this.isShowingSubToolBar = r1;
    }

    public void setShowingFunctionPanel(boolean r1) {
        this.isShowingFunctionPanel = r1;
    }

    public void updateToolbar(MindNoteToolbar r3) {
        tt5.a.h("BaseToolbarPanelViewModel", "updateToolbar:" + r3);
        MindNoteToolbar r0 = (MindNoteToolbar) getToolbar().getValue();
        if (Toolbar.equals(r3, r0) == true) goto L6;
        onUpdateToolbar(r0, r3);
        return;
    }

    public /* bridge */ /* synthetic */ void updateToolbar(Toolbar r1) {
        updateToolbar((MindNoteToolbar) r1);
    }
}
