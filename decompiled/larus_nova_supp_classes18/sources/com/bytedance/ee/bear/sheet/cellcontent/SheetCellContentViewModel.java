package com.bytedance.ee.bear.sheet.cellcontent;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.doc.follow.event.VcKeyboardChangeEventProducer;
import com.bytedance.ee.bear.document.toolbar.editpanels.KeyboardShowingStatusMode;
import com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel;
import com.bytedance.ee.bear.sheet.inputbar.editor.SheetInputData;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
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

    public String getPanelName() {
        return "sheetCellContent";
    }

    public /* bridge */ /* synthetic */ void onBecomeActive(g45.d r1, g45.a r2) {
    }

    public /* bridge */ /* synthetic */ void onBecomeInactive(g45.d r1, g45.a r2) {
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

    public KeyboardShowingStatusMode getKeyboardShowingStatusMode() {
        return KeyboardShowingStatusMode.ALWAYS_SHOW;
    }

    public float getMidHeight() {
        return this.midHeight;
    }

    public a getOnSegmentsClickListener() {
        return this.onSegmentsClickListener;
    }

    public VcKeyboardChangeEventProducer.OrientationSwitchMode getOrientationSwitchMode() {
        return VcKeyboardChangeEventProducer.OrientationSwitchMode.ADJUST_BY_KEYBOARD_EVENT;
    }

    public MutableLiveData<Float> getPanelHeightData() {
        return this.panelHeight;
    }

    public VcKeyboardChangeEventProducer.VcBottomBarPolicy getVcBottomBarPolicy() {
        return VcKeyboardChangeEventProducer.VcBottomBarPolicy.ALWAYS_HIDE;
    }

    public boolean isDocAIEnabled() {
        return this.docAIEnabled;
    }

    public boolean isVCFollow() {
        return this.isVCFollow;
    }

    public int getPanelHeight(Context r1) {
        return ((Float) this.panelHeight.getValue()).intValue();
    }

    public void setBgColor(String r1) {
        this.bgColor = r1;
    }

    public void setCopyable(boolean r2) {
        this.copyable.setValue(Boolean.valueOf(r2));
    }

    public void setDocAIEnabled(boolean r1) {
        this.docAIEnabled = r1;
    }

    public void setMidHeight(float r1) {
        this.midHeight = r1;
    }

    public void setOnSegmentsClickListener(a r1) {
        this.onSegmentsClickListener = r1;
    }

    public void setPanelHeight(int r2) {
        this.panelHeight.setValue(Float.valueOf(r2));
    }

    public void setVCFollow(boolean r1) {
        this.isVCFollow = r1;
    }

    public void updateCellData(SheetInputData.InputData r2) {
        this.cellData.setValue(r2);
    }

    public void updateFormulaData(SheetCellContentData.FormulaData r2) {
        this.formulaData.setValue(r2);
    }
}
