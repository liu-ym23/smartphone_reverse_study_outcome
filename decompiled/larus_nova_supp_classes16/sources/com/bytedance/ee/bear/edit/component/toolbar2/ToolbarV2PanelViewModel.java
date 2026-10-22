package com.bytedance.ee.bear.edit.component.toolbar2;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.doc.follow.event.VcKeyboardChangeEventProducer;
import com.bytedance.ee.bear.document.model.toolbar.DocToolbarV2;
import com.bytedance.ee.bear.document.toolbar.editpanels.KeyboardShowingStatusMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class ToolbarV2PanelViewModel extends BaseToolbarV2PanelViewModel<DocToolbarV2> {
    private static final String TAG = "ToolbarV2PanelViewModel";
    private a0 docToolbarV2Compat;
    private DocToolbarV2 mCurrToolbarV2;

    public static /* synthetic */ void yo(ToolbarV2PanelViewModel r0, pcb.a r1) {
        r0.lambda$onKeyboardHeightChanged$0(r1);
    }

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.BaseToolbarV2PanelViewModel, g45.a
    public String getPanelName() {
        return "editor";
    }

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.BaseToolbarV2PanelViewModel, g45.a
    public /* bridge */ /* synthetic */ void onBecomeActive(g45.d r1, g45.a r2) {
    }

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.BaseToolbarV2PanelViewModel, g45.a
    public /* bridge */ /* synthetic */ void onBecomeInactive(g45.d r1, g45.a r2) {
    }

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.BaseToolbarV2PanelViewModel, com.bytedance.ee.bear.doc.follow.event.VcKeyboardChangeEventProducer
    public VcKeyboardChangeEventProducer.VcBottomBarPolicy getVcBottomBarPolicy() {
        if (this.docToolbarV2Compat == null) goto L6;
        return VcKeyboardChangeEventProducer.VcBottomBarPolicy.ALWAYS_HIDE;
    L6:
        return VcKeyboardChangeEventProducer.VcBottomBarPolicy.ADJUST_BY_KEYBOARD;
    }

    public void resetToolbar() {
        updateToolbar(this.mCurrToolbarV2);
    }

    public ToolbarV2PanelViewModel() {
    }

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.BaseToolbarV2PanelViewModel, g45.a
    public KeyboardShowingStatusMode getKeyboardShowingStatusMode() {
        return KeyboardShowingStatusMode.ALWAYS_SHOW;
    }

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.BaseToolbarV2PanelViewModel, com.bytedance.ee.bear.doc.follow.event.VcKeyboardChangeEventProducer
    public VcKeyboardChangeEventProducer.OrientationSwitchMode getOrientationSwitchMode() {
        return VcKeyboardChangeEventProducer.OrientationSwitchMode.ADJUST_BY_KEYBOARD_EVENT;
    }

    private /* synthetic */ void lambda$onKeyboardHeightChanged$0(pcb.a r3) {
        tt5.a.h(TAG, "resetToolbar isKeyboardShowing :" + r3.isKeyboardShowing() + "; " + hasToolbarV2());
        if (r3.isKeyboardShowing() == true) goto L5;
        return;
    L5:
        if (hasToolbarV2() == true) goto L9;
        resetToolbar();
        return;
    }

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.BaseToolbarV2PanelViewModel, g45.a
    public int getPanelHeight(Context r2) {
        if (hasSubToolBarV2() == false) goto L7;
        return super.getPanelHeight(r2) * 2;
    L7:
        return super.getPanelHeight(r2);
    }

    public void setCurrToolbarV2(DocToolbarV2 r1) {
        this.mCurrToolbarV2 = r1;
    }

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.BaseToolbarV2PanelViewModel
    public void onAttachToUI(FragmentActivity r1, tb5.n r2) {
        super.onAttachToUI(r1, r2);
        this.docToolbarV2Compat = DocToolbarV2Compat.of(r1);
    }

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.BaseToolbarV2PanelViewModel
    public void onKeyboardHeightChanged(final pcb.a r3, int r4, int r5) {
        super.onKeyboardHeightChanged(r3, r4, r5);
        if (r4 != 0) goto L6;
        com.bytedance.ee.util.ui.j.d(new d0(this, r3), 100);
        return;
    }
}
