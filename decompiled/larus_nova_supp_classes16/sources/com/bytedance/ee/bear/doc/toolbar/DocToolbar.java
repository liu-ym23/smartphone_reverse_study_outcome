package com.bytedance.ee.bear.doc.toolbar;

import com.bytedance.ee.bear.document.toolbar.ItemId;
import com.bytedance.ee.bear.document.toolbar.Toolbar;
import java.util.Arrays;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DocToolbar extends Toolbar {
    @Override // com.bytedance.ee.bear.document.toolbar.Item
    public String toString() {
        return "DocToolbar{items=" + Arrays.toString(getChildren()) + '}';
    }

    public DocToolbar() {
    }

    @Override // com.bytedance.ee.bear.document.toolbar.Toolbar
    public boolean supportSubToolbar(ItemId r2) {
        DocItemId r0 = DocItemId.insertImage;
        if (r2 != r0) goto L7;
        if (adminLimit(r0) == true) goto L7;
    L8:
        return true;
    L7:
        if (super.supportSubToolbar(r2) == true) goto L8;
        return false;
    }
}
