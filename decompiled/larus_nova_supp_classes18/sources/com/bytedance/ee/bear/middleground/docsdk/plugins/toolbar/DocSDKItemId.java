package com.bytedance.ee.bear.middleground.docsdk.plugins.toolbar;

import com.bytedance.ee.bear.document.toolbar.ItemId;
import com.bytedance.ee.bear.middleground.docsdk.plugins.subpanel.DocSDKTxtAttrId;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final enum DocSDKItemId extends Enum<DocSDKItemId> implements ItemId.a {
    public static final /* synthetic */ DocSDKItemId[] a = null;
    public static final DocSDKItemId attribution = null;
    public static final DocSDKItemId comment = null;
    public static final DocSDKItemId indentLeft = null;
    public static final DocSDKItemId indentRight = null;
    public static final DocSDKItemId insertImage = null;
    public static final DocSDKItemId mention = null;
    public static final DocSDKItemId redo = null;
    public static final DocSDKItemId reminder = null;
    public static final DocSDKItemId undo = null;

    static {
        DocSDKItemId r0 = new DocSDKItemId("reminder", 0);
        reminder = r0;
        DocSDKItemId r1 = new DocSDKItemId("attribution", 1);
        attribution = r1;
        DocSDKItemId r3 = new DocSDKItemId("insertImage", 2);
        insertImage = r3;
        DocSDKItemId r5 = new DocSDKItemId("mention", 3);
        mention = r5;
        DocSDKItemId r7 = new DocSDKItemId("comment", 4);
        comment = r7;
        DocSDKItemId r9 = new DocSDKItemId("indentLeft", 5);
        indentLeft = r9;
        DocSDKItemId r11 = new DocSDKItemId("indentRight", 6);
        indentRight = r11;
        DocSDKItemId r13 = new DocSDKItemId("undo", 7);
        undo = r13;
        DocSDKItemId r15 = new DocSDKItemId("redo", 8);
        redo = r15;
        a = new DocSDKItemId[]{r0, r1, r3, r5, r7, r9, r11, r13, r15};
    }

    public static DocSDKItemId[] values() {
        return (DocSDKItemId[]) a.clone();
    }

    public ItemId[] children() {
        if (this == attribution) goto L5;
        return null;
    L5:
        return DocSDKTxtAttrId.values();
    }

    public static DocSDKItemId valueOf(String r1) {
        return (DocSDKItemId) r27.a.a(DocSDKItemId.class, r1);
    }

    public DocSDKItemId(String r1, int r2) {
        super(r1, r2);
    }
}
