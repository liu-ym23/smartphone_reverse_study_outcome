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
import com.bytedance.ee.bear.sheet.inputbar.toolbar.ToolbarItemEnum;
import g45.d;
import java.util.ArrayList;
import java.util.List;
import wm5.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SheetEditViewModel extends BaseEditPanelViewModel implements VcKeyboardChangeEventProducer {
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

    public String getPanelName() {
        return "sheet_editor";
    }

    public String[] getBadges() {
        ArrayList r0 = new ArrayList();
        SheetInputData.SheetToolbarItem[] r1 = (SheetInputData.SheetToolbarItem[]) this.mToolbarItems.getValue();
        if (r1 == null) goto L11;
        int r3 = r1.length;
        int r4 = 0;
    L5:
        if (r4 >= r3) goto L11;
        SheetInputData.SheetToolbarItem r5 = r1[r4];
        if (r5.isBadged() == false) goto L9;
        r0.add(r5.getId());
    L9:
        r4 = r4 + 1;
    L11:
        return (String[]) r0.toArray(new String[0]);
    }

    public String getCellInfo() {
        SheetInputData.InputData r0 = (SheetInputData.InputData) this.mInput.getValue();
        if (r0 != null) goto L5;
        tt5.a.b(TAG, "InputData is not be initialized");
        return "";
    L5:
        return r0.getCellInfo();
    }

    public SheetEditViewModel() {
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

    public KeyboardShowingStatusMode getKeyboardShowingStatusMode() {
        return KeyboardShowingStatusMode.ALWAYS_SHOW;
    }

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

    public int getPanelHeight(Context r6) {
        boolean r0 = "text".equals(this.mFormat.getValue());
        if (r0 == false) goto L5;
    L9:
        int r1 = 0;
    L10:
        int r2 = this.mInputHeight;
        if (r2 != 0) goto L13;
        r2 = r6.getResources().getDimensionPixelSize(2131168150);
    L13:
        int r7 = r6.getResources().getDimensionPixelSize(2131168151);
        StringBuilder r3 = new StringBuilder("isKeyboardShowing: ");
        if (r0 == false) goto L16;
        String r4 = "true";
    L17:
        r3.append(r4);
        r3.append(" marginBottom: ");
        r3.append(r1);
        tt5.a.b(TAG, r3.toString());
        return (r7 + r2) + r1;
    L16:
        r4 = "false";
        goto L17
    L5:
        if (this.mCustomKeyboardHeight.getValue() == null) goto L9;
        if (this.mSystemKeyboardHeight != 0) goto L9;
        r1 = ((Integer) this.mCustomKeyboardHeight.getValue()).intValue();
        goto L10
    }

    public int getSheetKeyboardFixedHeight(Activity r3) {
        float r0 = pcb.a.a.b(r3).keyBoardRawHeight();
        float r4 = r3.getResources().getDimensionPixelSize(2131168153);
        if (r4 <= r0) goto L5;
    L7:
        r0 = r4;
    L9:
        return (int) r0;
    L5:
        if (r0 > (1.1f * r4)) goto L7;
        goto L7
    }

    public void hideFormulaAssist(FormulaHideAssistData r2) {
        this.mFormulaHideAssist.setValue(r2);
    }

    public void notifyFormulaFunctionPicked(String r3) {
        tt5.a.h(TAG, "notifyFormulaFunctionPicked funcName=" + r3);
        this.mFormulaFunctionPick.setValue(new FormulaFunctionPickData(r3));
    }

    public void notifyToolbarItemClicked(ToolbarItemEnum r2) {
        this.mClickedToolbarItem.setValue(r2);
    }

    public void setAtVc(boolean r1) {
        this.isAtVc = r1;
    }

    public void setDateKeyboardCurType(String r1) {
        this.mDateKeyboardCurType = r1;
    }

    public void setEditDelegate(a r1) {
        this.mEditDelegate = r1;
    }

    public void setEditable(Editable r2) {
        this.mEditable.setValue(r2);
    }

    public void setExpand(Boolean r2) {
        this.mIsExpand.setValue(r2);
    }

    public void setFormulaCatalog(FormulaCatalogData r3) {
        StringBuilder r0 = new StringBuilder("setFormulaCatalog data=");
        if (r3 != null) goto L5;
        Object r1 = "null";
    L6:
        r0.append(r1);
        tt5.a.h(TAG, r0.toString());
        this.mFormulaCatalog = r3;
        return;
    L5:
        r1 = r3.getCatalog();
        goto L6
    }

    public void setHideFab(Boolean r2) {
        this.mIsHideFab.setValue(r2);
    }

    public void setInputHeight(int r1) {
        this.mInputHeight = r1;
    }

    public void setSegment(List<BaseSegment> r1) {
        this.mSegment = r1;
    }

    public void setShowFormulaPicker(boolean r3) {
        tt5.a.h(TAG, "setShowFormulaPicker show=" + r3);
        this.mShowFormulaPicker.setValue(Boolean.valueOf(r3));
    }

    public void setSystemKeyboardHeight(int r1) {
        this.mSystemKeyboardHeight = r1;
    }

    public void setToolbarItems(SheetInputData.SheetToolbarItem[] r2) {
        this.mToolbarItems.setValue(r2);
    }

    public void showFormulaSignatureHelp(FormulaSignatureHelpData r2) {
        this.mFormulaSignatureHelp.setValue(r2);
    }

    public void showFormulaSuggestions(FormulaSuggestionsData r2) {
        this.mFormulaSuggestions.setValue(r2);
    }

    public void updateFormulaInputStyle(FormulaInputStyleData r2) {
        this.mFormulaInputStyle.setValue(r2);
    }

    public void updateInput(SheetInputData.InputData r2) {
        this.mInput.setValue(r2);
        this.mFormat.setValue(r2.getFormat());
    }

    public void notifyFormulaSuggestionPicked(String r3, int r4) {
        this.mFormulaSuggestionPick.setValue(new FormulaSuggestionPickData(r3, r4));
    }

    public void onBecomeActive(d r3, g45.a r4) {
        tt5.a.b(TAG, "requestUpdateWebContentHeight");
        r3.requestUpdateWebContentHeight(200);
    }

    public void onBecomeInactive(d r1, g45.a r2) {
        setActive(false);
        this.mInputHeight = 0;
        this.mSystemKeyboardHeight = 0;
    }
}
