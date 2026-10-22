package com.bytedance.ee.bear.doc.toolbar;

import com.bytedance.ee.bear.document.offline.file.upload.FileUploadModel;
import com.bytedance.ee.bear.document.toolbar.ItemId;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final enum DocItemId extends Enum<DocItemId> implements ItemId.a {
    public static final /* synthetic */ DocItemId[] a = null;
    public static final DocItemId attribution = null;
    public static final DocItemId comment = null;
    public static final DocItemId indentLeft = null;
    public static final DocItemId indentRight = null;
    public static final DocItemId insertImage = null;
    public static final DocItemId mention = null;
    public static final DocItemId redo = null;
    public static final DocItemId reminder = null;
    public static final DocItemId undo = null;

    static {
        DocItemId r0 = new DocItemId("reminder", 0);
        reminder = r0;
        DocItemId r1 = new DocItemId("attribution", 1);
        attribution = r1;
        DocItemId r3 = new DocItemId("insertImage", 2);
        insertImage = r3;
        DocItemId r5 = new DocItemId("mention", 3);
        mention = r5;
        DocItemId r7 = new DocItemId(FileUploadModel.FROM_COMMENT, 4);
        comment = r7;
        DocItemId r9 = new DocItemId("indentLeft", 5);
        indentLeft = r9;
        DocItemId r11 = new DocItemId("indentRight", 6);
        indentRight = r11;
        DocItemId r13 = new DocItemId("undo", 7);
        undo = r13;
        DocItemId r16 = new DocItemId("redo", 8);
        redo = r16;
        a = new DocItemId[]{r0, r1, r3, r5, r7, r9, r11, r13, r16};
    }

    public static DocItemId[] values() {
        return (DocItemId[]) a.clone();
    }

    @Override // com.bytedance.ee.bear.document.toolbar.ItemId
    public ItemId[] children() {
        if (this == attribution) goto L5;
        return null;
    L5:
        return DocTxtAttrId.values();
    }

    public static DocItemId valueOf(String r1) {
        return (DocItemId) a.a(DocItemId.class, r1);
    }

    public DocItemId(String r1, int r2) {
        super(r1, r2);
    }
}
