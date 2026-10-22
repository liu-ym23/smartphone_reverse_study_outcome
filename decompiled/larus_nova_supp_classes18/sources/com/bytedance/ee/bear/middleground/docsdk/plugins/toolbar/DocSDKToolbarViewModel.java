package com.bytedance.ee.bear.middleground.docsdk.plugins.toolbar;

import com.bytedance.ee.bear.document.toolbar.BaseToolbarPanelViewModel;
import com.bytedance.ee.bear.document.toolbar.Item;
import com.bytedance.ee.bear.document.toolbar.ItemId;
import com.bytedance.ee.bear.document.toolbar.Toolbar;
import com.bytedance.ee.bear.document.toolbar.editpanels.KeyboardShowingStatusMode;
import com.bytedance.ee.bear.middleground.docsdk.plugins.subpanel.DocSDKTxtAttrId;
import g45.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class DocSDKToolbarViewModel extends BaseToolbarPanelViewModel<DocSDKToolbar> {
    private static final String TAG = "DocSDKToolbarViewModel";

    public String getPanelName() {
        return "editor";
    }

    public /* bridge */ /* synthetic */ void onBecomeActive(d r1, g45.a r2) {
    }

    public /* bridge */ /* synthetic */ void onBecomeInactive(d r1, g45.a r2) {
    }

    public String toString() {
        return "DocSDKToolbar";
    }

    public DocSDKToolbarViewModel() {
    }

    public KeyboardShowingStatusMode getKeyboardShowingStatusMode() {
        return KeyboardShowingStatusMode.ALWAYS_SHOW;
    }

    private void selectSpecifiedItem(DocSDKToolbar r5) {
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

    public void onUpdateToolbar(DocSDKToolbar r1, DocSDKToolbar r2) {
        super.onUpdateToolbar(r1, r2);
        if (r2 == null) goto L6;
        selectSpecifiedItem(r2);
        return;
    }

    public void processToolbarItemClick(ItemId r1, String r2) {
        super.processToolbarItemClick(r1, r2);
        if (r1 != DocSDKTxtAttrId.h1) goto L5;
    L14:
        clearSubToolbars();
        return;
    L5:
        if (r1 == DocSDKTxtAttrId.h2) goto L14;
        if (r1 == DocSDKTxtAttrId.h3) goto L14;
        if (r1 == DocSDKTxtAttrId.checkbox) goto L14;
        if (r1 == DocSDKTxtAttrId.unorderedList) goto L14;
        if (r1 == DocSDKTxtAttrId.orderedList) goto L14;
    }

    public /* bridge */ /* synthetic */ void onUpdateToolbar(Toolbar r1, Toolbar r2) {
        onUpdateToolbar((DocSDKToolbar) r1, (DocSDKToolbar) r2);
    }
}
