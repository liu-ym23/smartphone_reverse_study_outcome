package com.bytedance.ee.bear.document.edit_toolbar;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.doc.follow.event.VcKeyboardChangeEventProducer;
import com.bytedance.ee.bear.document.model.toolbar.DocToolbarV2;
import com.bytedance.ee.bear.document.toolbar.editpanels.KeyboardShowingStatusMode;
import com.bytedance.ee.bear.edit.component.toolbar2.a0;
import com.bytedance.ee.bear.edit.toolbar.toolbar2.BaseToolbarV2PanelViewModel;
import com.bytedance.ee.util.ui.j;
import tb5.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class ToolbarV2PanelViewModel extends BaseToolbarV2PanelViewModel<DocToolbarV2> implements VcKeyboardChangeEventProducer {
    private static final String TAG = "ToolbarV2PanelViewModel";
    private a0 docToolbarV2Compat;
    private int lastPanelHeight;
    private DocToolbarV2 mCurrToolbarV2;
    private int rememberKeyboardHeight;

    public class a implements Observer<Boolean> {
        public final /* synthetic */ ToolbarV2PanelViewModel a;

        public a(ToolbarV2PanelViewModel r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            if (((Boolean) r2) == Boolean.TRUE) goto L6;
            ToolbarV2PanelViewModel.access$002(this.a, 0);
            return;
        }
    }

    public static /* synthetic */ void yo(ToolbarV2PanelViewModel r0, pcb.a r1) {
        r0.lambda$onKeyboardHeightChanged$0(r1);
    }

    @Override // com.bytedance.ee.bear.edit.toolbar.toolbar2.BaseToolbarV2PanelViewModel, g45.a
    public String getPanelName() {
        return "editor";
    }

    @Override // com.bytedance.ee.bear.edit.toolbar.toolbar2.BaseToolbarV2PanelViewModel, g45.a
    public /* bridge */ /* synthetic */ void onBecomeActive(g45.d r1, g45.a r2) {
    }

    @Override // com.bytedance.ee.bear.edit.toolbar.toolbar2.BaseToolbarV2PanelViewModel, g45.a
    public /* bridge */ /* synthetic */ void onBecomeInactive(g45.d r1, g45.a r2) {
    }

    @Override // com.bytedance.ee.bear.doc.follow.event.VcKeyboardChangeEventProducer
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
        this.rememberKeyboardHeight = 0;
        this.lastPanelHeight = 0;
        getActive().observeForever(new a(this));
    }

    private boolean isKeyBoardShowing() {
        Integer r0 = (Integer) keyboardHeightLiveData().getValue();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.intValue() <= 0) goto L7;
        return true;
    }

    @Override // com.bytedance.ee.bear.edit.toolbar.toolbar2.BaseToolbarV2PanelViewModel, g45.a
    public KeyboardShowingStatusMode getKeyboardShowingStatusMode() {
        return KeyboardShowingStatusMode.ALWAYS_SHOW;
    }

    @Override // com.bytedance.ee.bear.doc.follow.event.VcKeyboardChangeEventProducer
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

    @Override // com.bytedance.ee.bear.edit.toolbar.toolbar2.BaseToolbarV2PanelViewModel, g45.a
    public int getPanelHeight(Context r4) {
        if (hasSubToolBarV2() == false) goto L5;
        int r5 = super.getPanelHeight(r4) * 2;
    L6:
        int r0 = this.lastPanelHeight;
        if (r0 <= r5) goto L9;
        r5 = r0;
    L11:
        if (isKeyBoardShowing() == true) goto L13;
        tt5.a.h(TAG, "getPanelHeight, isKeyboardShowing = false, hasSubToolBarV2() = " + hasSubToolBarV2());
        return r5 + this.rememberKeyboardHeight;
    L13:
        tt5.a.h(TAG, "getPanelHeight, isKeyboardShowing = true, hasSubToolBarV2() = " + hasSubToolBarV2());
        return r5;
    L9:
        this.lastPanelHeight = r5;
        goto L11
    L5:
        r5 = super.getPanelHeight(r4);
        goto L6
    }

    public void setCurrToolbarV2(DocToolbarV2 r1) {
        this.mCurrToolbarV2 = r1;
    }

    public static /* synthetic */ int access$002(ToolbarV2PanelViewModel r0, int r1) {
        r0.lastPanelHeight = r1;
        return r1;
    }

    @Override // com.bytedance.ee.bear.edit.toolbar.toolbar2.BaseToolbarV2PanelViewModel
    public void onAttachToUI(FragmentActivity r1, n r2) {
        super.onAttachToUI(r1, r2);
        this.docToolbarV2Compat = DocToolbarV2Compat.of(r1);
    }

    @Override // com.bytedance.ee.bear.edit.toolbar.toolbar2.BaseToolbarV2PanelViewModel
    public void onKeyboardHeightChanged(final pcb.a r3, int r4, int r5) {
        if (r4 <= 0) goto L4;
        this.rememberKeyboardHeight = r4;
    L4:
        tt5.a.h(TAG, "rememberKeyboardHeight = " + this.rememberKeyboardHeight);
        super.onKeyboardHeightChanged(r3, r4, r5);
        if (r4 != 0) goto L8;
        j.d(new h(this, r3), 100);
        return;
    }
}
