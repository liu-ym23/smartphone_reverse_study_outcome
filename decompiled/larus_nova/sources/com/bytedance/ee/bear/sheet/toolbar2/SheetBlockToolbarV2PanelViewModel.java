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
import com.larus.nova.R;
import java.util.Iterator;
import java.util.List;
import nn5.l;

/* JADX INFO: loaded from: classes18.dex */
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

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.BaseToolbarV2PanelViewModel, g45.a
    public String getPanelName() {
        return DocumentType.SHEET_NAME;
    }

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.BaseToolbarV2PanelViewModel, g45.a
    public /* bridge */ /* synthetic */ void onBecomeActive(g45.d r100, g45.a r101) {
    }

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.BaseToolbarV2PanelViewModel, g45.a
    public /* bridge */ /* synthetic */ void onBecomeInactive(g45.d r100, g45.a r101) {
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

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.BaseToolbarV2PanelViewModel, g45.a
    public KeyboardShowingStatusMode getKeyboardShowingStatusMode() {
        return KeyboardShowingStatusMode.ALWAYS_SHOW;
    }

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.BaseToolbarV2PanelViewModel, com.bytedance.ee.bear.doc.follow.event.VcKeyboardChangeEventProducer
    public VcKeyboardChangeEventProducer.OrientationSwitchMode getOrientationSwitchMode() {
        return VcKeyboardChangeEventProducer.OrientationSwitchMode.ADJUST_BY_KEYBOARD_EVENT;
    }

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.BaseToolbarV2PanelViewModel, com.bytedance.ee.bear.doc.follow.event.VcKeyboardChangeEventProducer
    public VcKeyboardChangeEventProducer.VcBottomBarPolicy getVcBottomBarPolicy() {
        return VcKeyboardChangeEventProducer.VcBottomBarPolicy.ADJUST_BY_KEYBOARD;
    }

    public a getViewDelegate() {
        return this.viewDelegate;
    }

    private boolean shouldHandleEmbedImageSegment(List<BaseSegment> r100) {
        if (this.mSegment != null) goto L5;
        return false;
    L5:
        if (r100.isEmpty() == false) goto L18;
        Iterator<BaseSegment> r101 = this.mSegment.iterator();
    L8:
        if (r101.hasNext() == false) goto L19;
        if ((r101.next() instanceof EmbedImageSegment) == false) goto L8;
        return true;
    L19:
        return false;
    L18:
        return false;
    }

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.BaseToolbarV2PanelViewModel, g45.a
    public int getPanelHeight(Context r100) {
        if (this.isShowingInput == true) goto L8;
        int r101 = super.getPanelHeight(r100) * 2;
        a r102 = this.viewDelegate;
        if (r102 != null) goto L7;
        return r101;
    L7:
        return r101 + SheetBlockToolbarV2Plugin.c(((l) r102).f519661a);
    L8:
        int r103 = super.getPanelHeight(r100);
        int r104 = this.mInputHeight;
        if (r104 != 0) goto L12;
        r104 = r100.getResources().getDimensionPixelSize(R.dimen.sheet_edit_inputbar_height);
    L12:
        return r103 + r104;
    }

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.BaseToolbarV2PanelViewModel
    public void onKeyboardStateChanged(int r100) {
        if (r100 <= 0) goto L4;
        boolean r101 = true;
    L5:
        if (r101 == true) goto L16;
        MutableLiveData<Boolean> r102 = this.active;
        if (r102 != null) goto L9;
    L11:
        MutableLiveData<SheetBlockToolbarV2> r103 = mutableToolbar();
        SheetBlockToolbarV2 r104 = r103.getValue();
        if (r104 == null) goto L16;
        if (r104.getInput() == null) goto L16;
        r104.setInput(null);
        r103.setValue(r104);
        goto L16
    L9:
        if (r102.getValue() != Boolean.TRUE) goto L11;
        this.analytic.d("close_keyboard");
    L16:
        ((MutableLiveData) keyboardHeightLiveData()).setValue(Integer.valueOf(r100));
        return;
    L4:
        r101 = false;
        goto L5
    }

    public void setInputHeight(int r100) {
        this.mInputHeight = r100;
    }

    public void setSegment(List<BaseSegment> r100) {
        this.mSegment = r100;
    }

    public void setShowingInput(boolean r100) {
        this.isShowingInput = r100;
    }

    public void setViewDelegate(a r100) {
        this.viewDelegate = r100;
    }

    public void onUpdateToolbar(SheetBlockToolbarV2 r100, SheetBlockToolbarV2 r101) {
        super.onUpdateToolbar(r100, r101);
        if (r101 == null) goto L5;
        qm5.a r102 = this.analytic;
        r102.f533874a = r101.getUrl();
    L5:
        if (r100 != null) goto L8;
        if (r101 == null) goto L8;
        this.analytic.b("open_toolbar");
        return;
    L8:
        if (r100 == null) goto L13;
        if (r101 != null) goto L14;
        this.analytic.b("close_toolbar");
        return;
    L14:
        return;
    }

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.BaseToolbarV2PanelViewModel
    public /* bridge */ /* synthetic */ void onUpdateToolbar(ToolbarV2 r100, ToolbarV2 r101) {
        onUpdateToolbar((SheetBlockToolbarV2) r100, (SheetBlockToolbarV2) r101);
    }

    @Override // wm5.a
    public void updateSheetEdit(int r100, List<BaseSegment> r101, String r102, String r103, String r104) {
        if (shouldHandleEmbedImageSegment(r101) == false) goto L5;
        r101 = this.mSegment;
    L6:
        dispatchBridgeMsg("lark.biz.sheet.onUpdateEdit", new SheetUpdateData(r100, r101, r104), null);
        SheetBlockToolbarV2 r105 = getToolbar().getValue();
        if (r105 != null) goto L9;
        return;
    L9:
        if (r105.getInput() == null) goto L13;
        r105.getInput().setSegments(r101);
        return;
    L13:
        return;
    L5:
        this.mSegment = null;
        goto L6
    }

    @Override // wm5.a
    public void updateSheetEditWithFormulaMeta(int r100, List r101, String r102, String r103, String r104, Integer r105, Integer r106, String r107, Boolean r108) {
        updateSheetEdit(r100, r101, r102, r103, r104);
    }
}
