package com.bytedance.ee.bear.mindnote.toolbar;

import com.bytedance.ee.bear.document.toolbar.ItemId;
import com.bytedance.ee.bear.document.toolbar.Toolbar;
import java.util.Arrays;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class MindNoteToolbar extends Toolbar {
    public String toString() {
        return "MindNoteToolbar{items=" + Arrays.toString(getChildren()) + '}';
    }

    public MindNoteToolbar() {
    }

    public boolean supportSubToolbar(ItemId r2) {
        MindNoteItemId r0 = MindNoteItemId.insertImage;
        if (r2 != r0) goto L7;
        if (adminLimit(r0) == true) goto L7;
    L8:
        return true;
    L7:
        if (super.supportSubToolbar(r2) == true) goto L8;
        return false;
    }
}
