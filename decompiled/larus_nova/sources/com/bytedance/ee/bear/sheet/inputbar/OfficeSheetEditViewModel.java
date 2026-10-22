package com.bytedance.ee.bear.sheet.inputbar;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.doc.follow.event.VcKeyboardChangeEventProducer;
import com.bytedance.ee.bear.document.toolbar.editpanels.KeyboardShowingStatusMode;
import com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.BaseSegment;
import com.bytedance.ee.bear.sheet.inputbar.editor.SheetInputData;
import com.bytedance.ee.bear.sheet.inputbar.formula.FormulaCatalogData;
import com.bytedance.ee.bear.sheet.inputbar.formula.FormulaFunctionPickData;
import com.bytedance.ee.bear.sheet.inputbar.formula.FormulaHideAssistData;
import com.bytedance.ee.bear.sheet.inputbar.formula.FormulaInputStyleData;
import com.bytedance.ee.bear.sheet.inputbar.formula.FormulaSignatureHelpData;
import com.bytedance.ee.bear.sheet.inputbar.formula.FormulaSuggestionPickData;
import com.bytedance.ee.bear.sheet.inputbar.formula.FormulaSuggestionsData;
import com.bytedance.ee.bear.sheet_core.inputbar.toolbar.ToolbarItemEnum;
import com.larus.nova.R;
import g45.d;
import java.util.ArrayList;
import java.util.List;
import wm5.a;

/* JADX INFO: loaded from: classes18.dex */
public class OfficeSheetEditViewModel extends BaseEditPanelViewModel implements VcKeyboardChangeEventProducer {
    private static final String PANEL_NAME = "sheet_editor";
    private static final String TAG = "SheetEditViewModel";
    private boolean isAtVc;
    private MutableLiveData<ToolbarItemEnum> mClickedToolbarItem;
    private MutableLiveData<Integer> mCustomKeyboardHeight;
    private String mDateKeyboardCurType;
    private MutableLiveData<String> mDateType;
    private a mEditDelegate;
    private MutableLiveData<Editable> mEditable;
    private MutableLiveData<String> mFormat;
    private FormulaCatalogData mFormulaCatalog;
    private final MutableLiveData<FormulaFunctionPickData> mFormulaFunctionPick;
    private final MutableLiveData<FormulaHideAssistData> mFormulaHideAssist;
    private final MutableLiveData<FormulaInputStyleData> mFormulaInputStyle;
    private final MutableLiveData<FormulaSignatureHelpData> mFormulaSignatureHelp;
    private final MutableLiveData<FormulaSuggestionPickData> mFormulaSuggestionPick;
    private final MutableLiveData<FormulaSuggestionsData> mFormulaSuggestions;
    private MutableLiveData<SheetInputData.InputData> mInput;
    private int mInputHeight;
    private MutableLiveData<Boolean> mIsExpand;
    private MutableLiveData<Boolean> mIsHideFab;
    private List<BaseSegment> mSegment;
    private final MutableLiveData<Boolean> mShowFormulaPicker;
    private int mSystemKeyboardHeight;
    private MutableLiveData<SheetInputData.SheetToolbarItem[]> mToolbarItems;

    @Override // com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel, g45.a
    public String getPanelName() {
        return PANEL_NAME;
    }

    public String[] getBadges() {
        ArrayList r100 = new ArrayList();
        SheetInputData.SheetToolbarItem[] r101 = this.mToolbarItems.getValue();
        if (r101 == null) goto L11;
        int r102 = r101.length;
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L11;
        SheetInputData.SheetToolbarItem r104 = r101[r103];
        if (r104.isBadged() == false) goto L9;
        r100.add(r104.getId());
    L9:
        r103 = r103 + 1;
    L11:
        return (String[]) r100.toArray(new String[0]);
    }

    public String getCellInfo() {
        SheetInputData.InputData r100 = this.mInput.getValue();
        if (r100 != null) goto L5;
        tt5.a.b(TAG, "InputData is not be initialized");
        return "";
    L5:
        return r100.getCellInfo();
    }

    public OfficeSheetEditViewModel() {
        this.mInput = new MutableLiveData();
        this.mFormat = new MutableLiveData();
        this.mDateType = new MutableLiveData();
        this.mIsHideFab = new MutableLiveData();
        this.mToolbarItems = new MutableLiveData();
        this.mEditable = new MutableLiveData();
        this.mIsExpand = new MutableLiveData();
        this.mClickedToolbarItem = new MutableLiveData();
        this.mDateKeyboardCurType = "date";
        this.mFormulaInputStyle = new MutableLiveData();
        this.mFormulaSuggestions = new MutableLiveData();
        this.mFormulaSignatureHelp = new MutableLiveData();
        this.mFormulaHideAssist = new MutableLiveData();
        this.mFormulaSuggestionPick = new MutableLiveData();
        this.mShowFormulaPicker = new MutableLiveData();
        this.mFormulaFunctionPick = new MutableLiveData();
        this.mCustomKeyboardHeight = new MutableLiveData();
        this.isAtVc = false;
    }

    public MutableLiveData<Integer> getCustomKeyboardHeight() {
        return this.mCustomKeyboardHeight;
    }

    public String getDateKeyboardCurType() {
        return this.mDateKeyboardCurType;
    }

    public MutableLiveData<String> getDateType() {
        return this.mDateType;
    }

    public a getEditDelegate() {
        return this.mEditDelegate;
    }

    public MutableLiveData<Editable> getEditable() {
        return this.mEditable;
    }

    public MutableLiveData<String> getFormat() {
        return this.mFormat;
    }

    public FormulaCatalogData getFormulaCatalog() {
        return this.mFormulaCatalog;
    }

    public MutableLiveData<FormulaFunctionPickData> getFormulaFunctionPick() {
        return this.mFormulaFunctionPick;
    }

    public MutableLiveData<FormulaHideAssistData> getFormulaHideAssist() {
        return this.mFormulaHideAssist;
    }

    public MutableLiveData<FormulaInputStyleData> getFormulaInputStyle() {
        return this.mFormulaInputStyle;
    }

    public MutableLiveData<FormulaSignatureHelpData> getFormulaSignatureHelp() {
        return this.mFormulaSignatureHelp;
    }

    public MutableLiveData<FormulaSuggestionPickData> getFormulaSuggestionPick() {
        return this.mFormulaSuggestionPick;
    }

    public MutableLiveData<FormulaSuggestionsData> getFormulaSuggestions() {
        return this.mFormulaSuggestions;
    }

    public MutableLiveData<SheetInputData.InputData> getInputData() {
        return this.mInput;
    }

    public int getInputHeight() {
        return this.mInputHeight;
    }

    @Override // com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel, g45.a
    public KeyboardShowingStatusMode getKeyboardShowingStatusMode() {
        return KeyboardShowingStatusMode.ALWAYS_SHOW;
    }

    @Override // com.bytedance.ee.bear.doc.follow.event.VcKeyboardChangeEventProducer
    public VcKeyboardChangeEventProducer.OrientationSwitchMode getOrientationSwitchMode() {
        return VcKeyboardChangeEventProducer.OrientationSwitchMode.ADJUST_BY_KEYBOARD_EVENT;
    }

    public List<BaseSegment> getSegment() {
        return this.mSegment;
    }

    public MutableLiveData<Boolean> getShowFormulaPicker() {
        return this.mShowFormulaPicker;
    }

    public MutableLiveData<SheetInputData.SheetToolbarItem[]> getToolbarItems() {
        return this.mToolbarItems;
    }

    @Override // com.bytedance.ee.bear.doc.follow.event.VcKeyboardChangeEventProducer
    public VcKeyboardChangeEventProducer.VcBottomBarPolicy getVcBottomBarPolicy() {
        return VcKeyboardChangeEventProducer.VcBottomBarPolicy.ALWAYS_HIDE;
    }

    public boolean isAtVc() {
        return this.isAtVc;
    }

    public MutableLiveData<Boolean> isExpand() {
        return this.mIsExpand;
    }

    public MutableLiveData<Boolean> isHideFab() {
        return this.mIsHideFab;
    }

    public MutableLiveData<ToolbarItemEnum> onToolbarItemClicked() {
        return this.mClickedToolbarItem;
    }

    @Override // com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel, g45.a
    public int getPanelHeight(Context r100) {
        boolean r101 = "text".equals(this.mFormat.getValue());
        if (r101 == false) goto L5;
    L9:
        int r102 = 0;
    L10:
        int r103 = this.mInputHeight;
        if (r103 != 0) goto L13;
        r103 = r100.getResources().getDimensionPixelSize(R.dimen.sheet_edit_inputbar_height);
    L13:
        int r104 = r100.getResources().getDimensionPixelSize(R.dimen.sheet_edit_toolbar_height);
        StringBuilder r105 = new StringBuilder("isKeyboardShowing: ");
        if (r101 == false) goto L16;
        String r106 = "true";
    L17:
        r105.append(r106);
        r105.append(" marginBottom: ");
        r105.append(r102);
        tt5.a.b(TAG, r105.toString());
        return (r104 + r103) + r102;
    L16:
        r106 = "false";
        goto L17
    L5:
        if (this.mCustomKeyboardHeight.getValue() == null) goto L9;
        if (this.mSystemKeyboardHeight != 0) goto L9;
        r102 = this.mCustomKeyboardHeight.getValue().intValue();
        goto L10
    }

    public int getSheetKeyboardFixedHeight(Activity r100) {
        float r101 = pcb.a.AbstractC7181a.b(r100).keyBoardRawHeight();
        float r102 = r100.getResources().getDimensionPixelSize(R.dimen.sheet_keyboard_height);
        if (r102 <= r101) goto L5;
    L7:
        r101 = r102;
    L9:
        return (int) r101;
    L5:
        if (r101 > (1.1f * r102)) goto L7;
        goto L7
    }

    public void hideFormulaAssist(FormulaHideAssistData r100) {
        this.mFormulaHideAssist.setValue(r100);
    }

    public void notifyFormulaFunctionPicked(String r100) {
        tt5.a.h(TAG, "notifyFormulaFunctionPicked funcName=" + r100);
        this.mFormulaFunctionPick.setValue(new FormulaFunctionPickData(r100));
    }

    public void notifyToolbarItemClicked(ToolbarItemEnum r100) {
        this.mClickedToolbarItem.setValue(r100);
    }

    public void setAtVc(boolean r100) {
        this.isAtVc = r100;
    }

    public void setDateKeyboardCurType(String r100) {
        this.mDateKeyboardCurType = r100;
    }

    public void setEditDelegate(a r100) {
        this.mEditDelegate = r100;
    }

    public void setEditable(Editable r100) {
        this.mEditable.setValue(r100);
    }

    public void setExpand(Boolean r100) {
        this.mIsExpand.setValue(r100);
    }

    public void setFormulaCatalog(FormulaCatalogData r100) {
        StringBuilder r101 = new StringBuilder("setFormulaCatalog data=");
        if (r100 != null) goto L5;
        Object r102 = "null";
    L6:
        r101.append(r102);
        tt5.a.h(TAG, r101.toString());
        this.mFormulaCatalog = r100;
        return;
    L5:
        r102 = r100.getCatalog();
        goto L6
    }

    public void setHideFab(Boolean r100) {
        this.mIsHideFab.setValue(r100);
    }

    public void setInputHeight(int r100) {
        this.mInputHeight = r100;
    }

    public void setSegment(List<BaseSegment> r100) {
        this.mSegment = r100;
    }

    public void setShowFormulaPicker(boolean r100) {
        tt5.a.h(TAG, "setShowFormulaPicker show=" + r100);
        this.mShowFormulaPicker.setValue(Boolean.valueOf(r100));
    }

    public void setSystemKeyboardHeight(int r100) {
        this.mSystemKeyboardHeight = r100;
    }

    public void setToolbarItems(SheetInputData.SheetToolbarItem[] r100) {
        this.mToolbarItems.setValue(r100);
    }

    public void showFormulaSignatureHelp(FormulaSignatureHelpData r100) {
        this.mFormulaSignatureHelp.setValue(r100);
    }

    public void showFormulaSuggestions(FormulaSuggestionsData r100) {
        this.mFormulaSuggestions.setValue(r100);
    }

    public void updateFormulaInputStyle(FormulaInputStyleData r100) {
        this.mFormulaInputStyle.setValue(r100);
    }

    public void updateInput(SheetInputData.InputData r100) {
        this.mInput.setValue(r100);
        this.mFormat.setValue(r100.getFormat());
    }

    public void notifyFormulaSuggestionPicked(String r100, int r101) {
        this.mFormulaSuggestionPick.setValue(new FormulaSuggestionPickData(r100, r101));
    }

    @Override // com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel, g45.a
    public void onBecomeActive(d r100, g45.a r101) {
        tt5.a.b(TAG, "requestUpdateWebContentHeight");
        r100.requestUpdateWebContentHeight(200);
    }

    @Override // com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel, g45.a
    public void onBecomeInactive(d r100, g45.a r101) {
        setActive(false);
        this.mInputHeight = 0;
        this.mSystemKeyboardHeight = 0;
    }
}
