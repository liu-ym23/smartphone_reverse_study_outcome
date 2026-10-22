package com.bytedance.ee.bear.sheet.toolbar2;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.doc.follow.event.VcKeyboardChangeEventProducer;
import com.bytedance.ee.bear.document.model.toolbar.ToolbarV2;
import com.bytedance.ee.bear.document.toolbar.editpanels.KeyboardShowingStatusMode;
import com.bytedance.ee.bear.edit.component.toolbar2.BaseToolbarV2PanelViewModel;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.BaseSegment;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.EmbedImageSegment;
import com.bytedance.ee.bear.sheet.inputbar.editor.SheetUpdateData;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import java.util.Iterator;
import java.util.List;
import nn5.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SheetBlockToolbarV2PanelViewModel extends BaseToolbarV2PanelViewModel<SheetBlockToolbarV2> implements wm5.a {
    private static final int PANEL_HEIGHT_COUNT = 2;
    private static final String TAG = "SheetBlockToolbarV2PanelViewModel";
    private qm5.a analytic;
    private boolean isShowingInput;
    private int mInputHeight;
    private List<BaseSegment> mSegment;
    private a viewDelegate;

    public interface a {
    }

    public String getPanelName() {
        return DocumentType.SHEET_NAME;
    }

    public /* bridge */ /* synthetic */ void onBecomeActive(g45.d r1, g45.a r2) {
    }

    public /* bridge */ /* synthetic */ void onBecomeInactive(g45.d r1, g45.a r2) {
    }

    public SheetBlockToolbarV2PanelViewModel() {
        this.isShowingInput = true;
        this.analytic = new qm5.a();
    }

    public qm5.a getAnalytic() {
        return this.analytic;
    }

    public int getInputHeight() {
        return this.mInputHeight;
    }

    public KeyboardShowingStatusMode getKeyboardShowingStatusMode() {
        return KeyboardShowingStatusMode.ALWAYS_SHOW;
    }

    public VcKeyboardChangeEventProducer.OrientationSwitchMode getOrientationSwitchMode() {
        return VcKeyboardChangeEventProducer.OrientationSwitchMode.ADJUST_BY_KEYBOARD_EVENT;
    }

    public VcKeyboardChangeEventProducer.VcBottomBarPolicy getVcBottomBarPolicy() {
        return VcKeyboardChangeEventProducer.VcBottomBarPolicy.ADJUST_BY_KEYBOARD;
    }

    public a getViewDelegate() {
        return this.viewDelegate;
    }

    private boolean shouldHandleEmbedImageSegment(List<BaseSegment> r2) {
        if (this.mSegment != null) goto L5;
        return false;
    L5:
        if (r2.isEmpty() == false) goto L18;
        Iterator<BaseSegment> r3 = this.mSegment.iterator();
    L8:
        if (r3.hasNext() == false) goto L19;
        if ((r3.next() instanceof EmbedImageSegment) == false) goto L8;
        return true;
    L19:
        return false;
    L18:
        return false;
    }

    public int getPanelHeight(Context r3) {
        if (this.isShowingInput == true) goto L8;
        int r4 = super.getPanelHeight(r3) * 2;
        a r0 = this.viewDelegate;
        if (r0 != null) goto L7;
        return r4;
    L7:
        return r4 + SheetBlockToolbarV2Plugin.c(((l) r0).a);
    L8:
        int r1 = super.getPanelHeight(r3);
        int r2 = this.mInputHeight;
        if (r2 != 0) goto L12;
        r2 = r3.getResources().getDimensionPixelSize(2131168150);
    L12:
        return r1 + r2;
    }

    public void onKeyboardStateChanged(int r4) {
        if (r4 <= 0) goto L4;
        boolean r0 = true;
    L5:
        if (r0 == true) goto L16;
        MutableLiveData r1 = ((BaseToolbarV2PanelViewModel) this).active;
        if (r1 != null) goto L9;
    L11:
        MutableLiveData r2 = mutableToolbar();
        SheetBlockToolbarV2 r3 = (SheetBlockToolbarV2) r2.getValue();
        if (r3 == null) goto L16;
        if (r3.getInput() == null) goto L16;
        r3.setInput(null);
        r2.setValue(r3);
        goto L16
    L9:
        if (r1.getValue() != Boolean.TRUE) goto L11;
        this.analytic.d("close_keyboard");
    L16:
        keyboardHeightLiveData().setValue(Integer.valueOf(r4));
        return;
    L4:
        r0 = false;
        goto L5
    }

    public void setInputHeight(int r1) {
        this.mInputHeight = r1;
    }

    public void setSegment(List<BaseSegment> r1) {
        this.mSegment = r1;
    }

    public void setShowingInput(boolean r1) {
        this.isShowingInput = r1;
    }

    public void setViewDelegate(a r1) {
        this.viewDelegate = r1;
    }

    public void onUpdateToolbar(SheetBlockToolbarV2 r3, SheetBlockToolbarV2 r4) {
        super.onUpdateToolbar(r3, r4);
        if (r4 == null) goto L5;
        qm5.a r0 = this.analytic;
        r0.a = r4.getUrl();
    L5:
        if (r3 != null) goto L8;
        if (r4 == null) goto L8;
        this.analytic.b("open_toolbar");
        return;
    L8:
        if (r3 == null) goto L13;
        if (r4 != null) goto L14;
        this.analytic.b("close_toolbar");
        return;
    L14:
        return;
    }

    public /* bridge */ /* synthetic */ void onUpdateToolbar(ToolbarV2 r1, ToolbarV2 r2) {
        onUpdateToolbar((SheetBlockToolbarV2) r1, (SheetBlockToolbarV2) r2);
    }

    @Override // wm5.a
    public void updateSheetEdit(int r1, List<BaseSegment> r2, String r3, String r4, String r5) {
        if (shouldHandleEmbedImageSegment(r2) == false) goto L5;
        r2 = this.mSegment;
    L6:
        dispatchBridgeMsg("lark.biz.sheet.onUpdateEdit", new SheetUpdateData(r1, r2, r5), null);
        SheetBlockToolbarV2 r6 = (SheetBlockToolbarV2) getToolbar().getValue();
        if (r6 != null) goto L9;
        return;
    L9:
        if (r6.getInput() == null) goto L13;
        r6.getInput().setSegments(r2);
        return;
    L13:
        return;
    L5:
        this.mSegment = null;
        goto L6
    }

    @Override // wm5.a
    public void updateSheetEditWithFormulaMeta(int r1, List r2, String r3, String r4, String r5, Integer r6, Integer r7, String r8, Boolean r9) {
        updateSheetEdit(r1, r2, r3, r4, r5);
    }
}
