package com.bytedance.ee.bear.middleground.docsdk.plugins.toolbar;

import com.bytedance.ee.bear.document.toolbar.ItemId;
import com.bytedance.ee.bear.document.toolbar.Toolbar;
import java.util.Arrays;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class DocSDKToolbar extends Toolbar {
    public String toString() {
        return "DocSDKToolbar{items=" + Arrays.toString(getChildren()) + '}';
    }

    public DocSDKToolbar() {
    }

    public boolean supportSubToolbar(ItemId r2) {
        DocSDKItemId r0 = DocSDKItemId.insertImage;
        if (r2 != r0) goto L7;
        if (adminLimit(r0) == true) goto L7;
    L8:
        return true;
    L7:
        if (super.supportSubToolbar(r2) == true) goto L8;
        return false;
    }
}
