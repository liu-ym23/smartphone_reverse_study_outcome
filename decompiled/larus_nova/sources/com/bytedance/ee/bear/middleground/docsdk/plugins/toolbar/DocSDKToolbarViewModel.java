package com.bytedance.ee.bear.middleground.docsdk.plugins.toolbar;

import com.bytedance.ee.bear.document.toolbar.BaseToolbarPanelViewModel;
import com.bytedance.ee.bear.document.toolbar.Item;
import com.bytedance.ee.bear.document.toolbar.ItemId;
import com.bytedance.ee.bear.document.toolbar.Toolbar;
import com.bytedance.ee.bear.document.toolbar.editpanels.KeyboardShowingStatusMode;
import com.bytedance.ee.bear.middleground.docsdk.plugins.subpanel.DocSDKTxtAttrId;
import g45.d;

/* JADX INFO: loaded from: classes18.dex */
public class DocSDKToolbarViewModel extends BaseToolbarPanelViewModel<DocSDKToolbar> {
    private static final String TAG = "DocSDKToolbarViewModel";

    @Override // com.bytedance.ee.bear.document.toolbar.BaseToolbarPanelViewModel, com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel, g45.a
    public String getPanelName() {
        return "editor";
    }

    @Override // com.bytedance.ee.bear.document.toolbar.BaseToolbarPanelViewModel, com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel, g45.a
    public /* bridge */ /* synthetic */ void onBecomeActive(d r100, g45.a r101) {
    }

    @Override // com.bytedance.ee.bear.document.toolbar.BaseToolbarPanelViewModel, com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel, g45.a
    public /* bridge */ /* synthetic */ void onBecomeInactive(d r100, g45.a r101) {
    }

    public String toString() {
        return "DocSDKToolbar";
    }

    public DocSDKToolbarViewModel() {
    }

    @Override // com.bytedance.ee.bear.document.toolbar.BaseToolbarPanelViewModel, com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel, g45.a
    public KeyboardShowingStatusMode getKeyboardShowingStatusMode() {
        return KeyboardShowingStatusMode.ALWAYS_SHOW;
    }

    private void selectSpecifiedItem(DocSDKToolbar r100) {
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

    public void onUpdateToolbar(DocSDKToolbar r100, DocSDKToolbar r101) {
        super.onUpdateToolbar(r100, r101);
        if (r101 == null) goto L6;
        selectSpecifiedItem(r101);
        return;
    }

    @Override // com.bytedance.ee.bear.document.toolbar.BaseToolbarPanelViewModel
    public void processToolbarItemClick(ItemId r100, String r101) {
        super.processToolbarItemClick(r100, r101);
        if (r100 != DocSDKTxtAttrId.f232377h1) goto L5;
    L14:
        clearSubToolbars();
        return;
    L5:
        if (r100 == DocSDKTxtAttrId.f232378h2) goto L14;
        if (r100 == DocSDKTxtAttrId.f232379h3) goto L14;
        if (r100 == DocSDKTxtAttrId.checkbox) goto L14;
        if (r100 == DocSDKTxtAttrId.unorderedList) goto L14;
        if (r100 == DocSDKTxtAttrId.orderedList) goto L14;
    }

    @Override // com.bytedance.ee.bear.document.toolbar.BaseToolbarPanelViewModel
    public /* bridge */ /* synthetic */ void onUpdateToolbar(Toolbar r100, Toolbar r101) {
        onUpdateToolbar((DocSDKToolbar) r100, (DocSDKToolbar) r101);
    }
}
