package com.bytedance.ee.bear.doc.toolbar;

import com.bytedance.ee.bear.document.toolbar.BaseToolbarPanelViewModel;
import com.bytedance.ee.bear.document.toolbar.Item;
import com.bytedance.ee.bear.document.toolbar.ItemId;
import com.bytedance.ee.bear.document.toolbar.Toolbar;
import com.bytedance.ee.bear.document.toolbar.editpanels.KeyboardShowingStatusMode;
import g45.a;
import g45.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DocToolbarPanelViewModel extends BaseToolbarPanelViewModel<DocToolbar> {
    private static final String TAG = "DocToolbarPanelViewModel";

    @Override // com.bytedance.ee.bear.document.toolbar.BaseToolbarPanelViewModel, com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel, g45.a
    public String getPanelName() {
        return "editor";
    }

    @Override // com.bytedance.ee.bear.document.toolbar.BaseToolbarPanelViewModel, com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel, g45.a
    public /* bridge */ /* synthetic */ void onBecomeActive(d r1, a r2) {
    }

    @Override // com.bytedance.ee.bear.document.toolbar.BaseToolbarPanelViewModel, com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel, g45.a
    public /* bridge */ /* synthetic */ void onBecomeInactive(d r1, a r2) {
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

    private void selectSpecifiedItem(DocToolbar r5) {
        Item[] r6 = r5.getChildren();
        int r0 = r6.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L11;
        Item r2 = r6[r1];
        if (r2.isSelected() == true) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        tt5.a.h(TAG, "selectSpecifiedItem(): " + r2);
        updateExpandedSubToolbars(r2.id());
        return;
    }

    public void onUpdateToolbar(DocToolbar r1, DocToolbar r2) {
        super.onUpdateToolbar(r1, r2);
        if (r2 == null) goto L6;
        selectSpecifiedItem(r2);
        return;
    }

    @Override // com.bytedance.ee.bear.document.toolbar.BaseToolbarPanelViewModel
    public void processToolbarItemClick(ItemId r1, String r2) {
        super.processToolbarItemClick(r1, r2);
        if (r1 != DocTxtAttrId.h1) goto L5;
    L26:
        clearSubToolbars();
        return;
    L5:
        if (r1 == DocTxtAttrId.h2) goto L26;
        if (r1 == DocTxtAttrId.h3) goto L26;
        if (r1 == DocTxtAttrId.h4) goto L26;
        if (r1 == DocTxtAttrId.h5) goto L26;
        if (r1 == DocTxtAttrId.h6) goto L26;
        if (r1 == DocTxtAttrId.h7) goto L26;
        if (r1 == DocTxtAttrId.h8) goto L26;
        if (r1 == DocTxtAttrId.h9) goto L26;
        if (r1 == DocTxtAttrId.checkbox) goto L26;
        if (r1 == DocTxtAttrId.unorderedList) goto L26;
        if (r1 == DocTxtAttrId.orderedList) goto L26;
    }

    @Override // com.bytedance.ee.bear.document.toolbar.BaseToolbarPanelViewModel
    public /* bridge */ /* synthetic */ void onUpdateToolbar(Toolbar r1, Toolbar r2) {
        onUpdateToolbar((DocToolbar) r1, (DocToolbar) r2);
    }
}
