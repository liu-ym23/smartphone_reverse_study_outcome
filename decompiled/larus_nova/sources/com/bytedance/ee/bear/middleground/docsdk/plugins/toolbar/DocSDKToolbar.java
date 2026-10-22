package com.bytedance.ee.bear.middleground.docsdk.plugins.toolbar;

import com.bytedance.ee.bear.document.toolbar.ItemId;
import com.bytedance.ee.bear.document.toolbar.Toolbar;
import java.util.Arrays;

/* JADX INFO: loaded from: classes18.dex */
public class DocSDKToolbar extends Toolbar {
    @Override // com.bytedance.ee.bear.document.toolbar.Item
    public String toString() {
        return "DocSDKToolbar{items=" + Arrays.toString(getChildren()) + '}';
    }

    public DocSDKToolbar() {
    }

    @Override // com.bytedance.ee.bear.document.toolbar.Toolbar
    public boolean supportSubToolbar(ItemId r100) {
        DocSDKItemId r101 = DocSDKItemId.insertImage;
        if (r100 != r101) goto L7;
        if (adminLimit(r101) == true) goto L7;
    L8:
        return true;
    L7:
        if (super.supportSubToolbar(r100) == true) goto L8;
        return false;
    }
}
