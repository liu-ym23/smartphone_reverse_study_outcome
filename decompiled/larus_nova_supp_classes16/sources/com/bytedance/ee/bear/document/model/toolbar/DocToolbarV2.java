package com.bytedance.ee.bear.document.model.toolbar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DocToolbarV2 extends ToolbarV2 {
    public DocToolbarV2() {
    }

    public DocToolbarV2(ToolbarV2 r2) {
        setItems(r2.getItems());
        setShowingItemId(r2.getShowingItemId());
        setType(r2.getType());
    }

    @Override // com.bytedance.ee.bear.document.model.toolbar.ToolbarV2
    public boolean supportSubToolbar(ItemIdV2 r2) {
        if (r2 != ToolbarPrimaryItemId.insertImage) goto L5;
    L8:
        return true;
    L5:
        if (super.supportSubToolbar(r2) == true) goto L8;
        return false;
    }
}
