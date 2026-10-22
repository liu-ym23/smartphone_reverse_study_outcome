package com.bytedance.ee.bear.mindnote.toolbar;

import com.bytedance.ee.bear.document.toolbar.ItemId;
import com.bytedance.ee.bear.document.toolbar.Toolbar;
import java.util.Arrays;

/* JADX INFO: loaded from: classes18.dex */
public class MindNoteToolbar extends Toolbar {
    @Override // com.bytedance.ee.bear.document.toolbar.Item
    public String toString() {
        return "MindNoteToolbar{items=" + Arrays.toString(getChildren()) + '}';
    }

    public MindNoteToolbar() {
    }

    @Override // com.bytedance.ee.bear.document.toolbar.Toolbar
    public boolean supportSubToolbar(ItemId r100) {
        MindNoteItemId r101 = MindNoteItemId.insertImage;
        if (r100 != r101) goto L7;
        if (adminLimit(r101) == true) goto L7;
    L8:
        return true;
    L7:
        if (super.supportSubToolbar(r100) == true) goto L8;
        return false;
    }
}
