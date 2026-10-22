package com.bytedance.ee.bear.doc.toolbar;

import com.bytedance.ee.bear.document.toolbar.BaseToolbarPanelViewModel;
import com.bytedance.ee.bear.document.toolbar.Item;
import com.bytedance.ee.bear.document.toolbar.ItemId;
import com.bytedance.ee.bear.document.toolbar.Toolbar;
import com.bytedance.ee.bear.document.toolbar.editpanels.KeyboardShowingStatusMode;
import g45.a;
import g45.d;

/* JADX INFO: loaded from: classes16.dex */
public class DocToolbarPanelViewModel extends BaseToolbarPanelViewModel<DocToolbar> {
    private static final String TAG = "DocToolbarPanelViewModel";

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

    public String toString() {
        return "DocToolbar";
    }

    public DocToolbarPanelViewModel() {
    }

    @Override // com.bytedance.ee.bear.document.toolbar.BaseToolbarPanelViewModel, com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel, g45.a
    public KeyboardShowingStatusMode getKeyboardShowingStatusMode() {
        return KeyboardShowingStatusMode.ALWAYS_SHOW;
    }

    private void selectSpecifiedItem(DocToolbar r100) {
        Item[] r101 = r100.getChildren();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L11;
        Item r104 = r101[r103];
        if (r104.isSelected() == true) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        tt5.a.h(TAG, "selectSpecifiedItem(): " + r104);
        updateExpandedSubToolbars(r104.id());
        return;
    }

    public void onUpdateToolbar(DocToolbar r100, DocToolbar r101) {
        super.onUpdateToolbar(r100, r101);
        if (r101 == null) goto L6;
        selectSpecifiedItem(r101);
        return;
    }

    @Override // com.bytedance.ee.bear.document.toolbar.BaseToolbarPanelViewModel
    public void processToolbarItemClick(ItemId r100, String r101) {
        super.processToolbarItemClick(r100, r101);
        if (r100 != DocTxtAttrId.f218298h1) goto L5;
    L26:
        clearSubToolbars();
        return;
    L5:
        if (r100 == DocTxtAttrId.f218299h2) goto L26;
        if (r100 == DocTxtAttrId.f218300h3) goto L26;
        if (r100 == DocTxtAttrId.f218301h4) goto L26;
        if (r100 == DocTxtAttrId.f218302h5) goto L26;
        if (r100 == DocTxtAttrId.f218303h6) goto L26;
        if (r100 == DocTxtAttrId.f218304h7) goto L26;
        if (r100 == DocTxtAttrId.f218305h8) goto L26;
        if (r100 == DocTxtAttrId.f218306h9) goto L26;
        if (r100 == DocTxtAttrId.checkbox) goto L26;
        if (r100 == DocTxtAttrId.unorderedList) goto L26;
        if (r100 == DocTxtAttrId.orderedList) goto L26;
    }

    @Override // com.bytedance.ee.bear.document.toolbar.BaseToolbarPanelViewModel
    public /* bridge */ /* synthetic */ void onUpdateToolbar(Toolbar r100, Toolbar r101) {
        onUpdateToolbar((DocToolbar) r100, (DocToolbar) r101);
    }
}
