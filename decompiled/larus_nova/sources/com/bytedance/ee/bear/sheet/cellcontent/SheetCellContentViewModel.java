package com.bytedance.ee.bear.sheet.cellcontent;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.doc.follow.event.VcKeyboardChangeEventProducer;
import com.bytedance.ee.bear.document.toolbar.editpanels.KeyboardShowingStatusMode;
import com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel;
import com.bytedance.ee.bear.sheet.inputbar.editor.SheetInputData;

/* JADX INFO: loaded from: classes18.dex */
public class SheetCellContentViewModel extends BaseEditPanelViewModel implements VcKeyboardChangeEventProducer {
    private String bgColor;
    private MutableLiveData<SheetInputData.InputData> cellData;
    private MutableLiveData<Boolean> copyable;
    private boolean docAIEnabled;
    private MutableLiveData<SheetCellContentData.FormulaData> formulaData;
    private boolean isVCFollow;
    private float midHeight;
    private a onSegmentsClickListener;
    MutableLiveData<Float> panelHeight;

    @Override // com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel, g45.a
    public String getPanelName() {
        return "sheetCellContent";
    }

    @Override // com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel, g45.a
    public /* bridge */ /* synthetic */ void onBecomeActive(g45.d r100, g45.a r101) {
    }

    @Override // com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel, g45.a
    public /* bridge */ /* synthetic */ void onBecomeInactive(g45.d r100, g45.a r101) {
    }

    public SheetCellContentViewModel() {
        this.panelHeight = new MutableLiveData(Float.valueOf(0.0f));
        this.cellData = new MutableLiveData();
        this.formulaData = new MutableLiveData();
        this.copyable = new MutableLiveData(Boolean.FALSE);
        this.isVCFollow = false;
        this.docAIEnabled = false;
    }

    public String getBgColor() {
        return this.bgColor;
    }

    public MutableLiveData<SheetInputData.InputData> getCellData() {
        return this.cellData;
    }

    public MutableLiveData<Boolean> getCopyAble() {
        return this.copyable;
    }

    public MutableLiveData<SheetCellContentData.FormulaData> getFormulaData() {
        return this.formulaData;
    }

    @Override // com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel, g45.a
    public KeyboardShowingStatusMode getKeyboardShowingStatusMode() {
        return KeyboardShowingStatusMode.ALWAYS_SHOW;
    }

    public float getMidHeight() {
        return this.midHeight;
    }

    public a getOnSegmentsClickListener() {
        return this.onSegmentsClickListener;
    }

    @Override // com.bytedance.ee.bear.doc.follow.event.VcKeyboardChangeEventProducer
    public VcKeyboardChangeEventProducer.OrientationSwitchMode getOrientationSwitchMode() {
        return VcKeyboardChangeEventProducer.OrientationSwitchMode.ADJUST_BY_KEYBOARD_EVENT;
    }

    public MutableLiveData<Float> getPanelHeightData() {
        return this.panelHeight;
    }

    @Override // com.bytedance.ee.bear.doc.follow.event.VcKeyboardChangeEventProducer
    public VcKeyboardChangeEventProducer.VcBottomBarPolicy getVcBottomBarPolicy() {
        return VcKeyboardChangeEventProducer.VcBottomBarPolicy.ALWAYS_HIDE;
    }

    public boolean isDocAIEnabled() {
        return this.docAIEnabled;
    }

    public boolean isVCFollow() {
        return this.isVCFollow;
    }

    @Override // com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel, g45.a
    public int getPanelHeight(Context r100) {
        return this.panelHeight.getValue().intValue();
    }

    public void setBgColor(String r100) {
        this.bgColor = r100;
    }

    public void setCopyable(boolean r100) {
        this.copyable.setValue(Boolean.valueOf(r100));
    }

    public void setDocAIEnabled(boolean r100) {
        this.docAIEnabled = r100;
    }

    public void setMidHeight(float r100) {
        this.midHeight = r100;
    }

    public void setOnSegmentsClickListener(a r100) {
        this.onSegmentsClickListener = r100;
    }

    public void setPanelHeight(int r100) {
        this.panelHeight.setValue(Float.valueOf(r100));
    }

    public void setVCFollow(boolean r100) {
        this.isVCFollow = r100;
    }

    public void updateCellData(SheetInputData.InputData r100) {
        this.cellData.setValue(r100);
    }

    public void updateFormulaData(SheetCellContentData.FormulaData r100) {
        this.formulaData.setValue(r100);
    }
}
