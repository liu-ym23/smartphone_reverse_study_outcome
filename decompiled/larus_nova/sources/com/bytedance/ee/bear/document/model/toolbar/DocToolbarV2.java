package com.bytedance.ee.bear.document.model.toolbar;

/* JADX INFO: loaded from: classes16.dex */
public class DocToolbarV2 extends ToolbarV2 {
    public DocToolbarV2() {
    }

    public DocToolbarV2(ToolbarV2 r100) {
        setItems(r100.getItems());
        setShowingItemId(r100.getShowingItemId());
        setType(r100.getType());
    }

    @Override // com.bytedance.ee.bear.document.model.toolbar.ToolbarV2
    public boolean supportSubToolbar(ItemIdV2 r100) {
        if (r100 != ToolbarPrimaryItemId.insertImage) goto L5;
    L8:
        return true;
    L5:
        if (super.supportSubToolbar(r100) == true) goto L8;
        return false;
    }
}
