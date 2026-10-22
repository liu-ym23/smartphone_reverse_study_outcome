package com.bytedance.ee.bear.doc.toolbar;

import androidx.core.app.NotificationCompat;
import com.bytedance.ee.bear.document.toolbar.ItemId;
import r27.a;

/* JADX INFO: loaded from: classes16.dex */
public final enum DocItemId extends Enum<DocItemId> implements ItemId.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DocItemId[] f218295a = null;
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
        DocItemId r100 = new DocItemId(NotificationCompat.CATEGORY_REMINDER, 0);
        reminder = r100;
        DocItemId r101 = new DocItemId("attribution", 1);
        attribution = r101;
        DocItemId r102 = new DocItemId("insertImage", 2);
        insertImage = r102;
        DocItemId r103 = new DocItemId("mention", 3);
        mention = r103;
        DocItemId r104 = new DocItemId("comment", 4);
        comment = r104;
        DocItemId r105 = new DocItemId("indentLeft", 5);
        indentLeft = r105;
        DocItemId r110 = new DocItemId("indentRight", 6);
        indentRight = r110;
        DocItemId r111 = new DocItemId("undo", 7);
        undo = r111;
        DocItemId r112 = new DocItemId("redo", 8);
        redo = r112;
        f218295a = new DocItemId[]{r100, r101, r102, r103, r104, r105, r110, r111, r112};
    }

    public static DocItemId[] values() {
        return (DocItemId[]) f218295a.clone();
    }

    @Override // com.bytedance.ee.bear.document.toolbar.ItemId
    public ItemId[] children() {
        if (this == attribution) goto L5;
        return null;
    L5:
        return DocTxtAttrId.values();
    }

    public static DocItemId valueOf(String r100) {
        return (DocItemId) a.a(DocItemId.class, r100);
    }

    public DocItemId(String r100, int r101) {
        super(r100, r101);
    }
}
