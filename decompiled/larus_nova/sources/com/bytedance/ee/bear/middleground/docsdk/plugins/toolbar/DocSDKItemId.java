package com.bytedance.ee.bear.middleground.docsdk.plugins.toolbar;

import androidx.core.app.NotificationCompat;
import com.bytedance.ee.bear.document.toolbar.ItemId;
import com.bytedance.ee.bear.middleground.docsdk.plugins.subpanel.DocSDKTxtAttrId;

/* JADX INFO: loaded from: classes18.dex */
public final enum DocSDKItemId extends Enum<DocSDKItemId> implements ItemId.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DocSDKItemId[] f232385a = null;
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
        DocSDKItemId r100 = new DocSDKItemId(NotificationCompat.CATEGORY_REMINDER, 0);
        reminder = r100;
        DocSDKItemId r101 = new DocSDKItemId("attribution", 1);
        attribution = r101;
        DocSDKItemId r102 = new DocSDKItemId("insertImage", 2);
        insertImage = r102;
        DocSDKItemId r103 = new DocSDKItemId("mention", 3);
        mention = r103;
        DocSDKItemId r104 = new DocSDKItemId("comment", 4);
        comment = r104;
        DocSDKItemId r105 = new DocSDKItemId("indentLeft", 5);
        indentLeft = r105;
        DocSDKItemId r110 = new DocSDKItemId("indentRight", 6);
        indentRight = r110;
        DocSDKItemId r111 = new DocSDKItemId("undo", 7);
        undo = r111;
        DocSDKItemId r112 = new DocSDKItemId("redo", 8);
        redo = r112;
        f232385a = new DocSDKItemId[]{r100, r101, r102, r103, r104, r105, r110, r111, r112};
    }

    public static DocSDKItemId[] values() {
        return (DocSDKItemId[]) f232385a.clone();
    }

    @Override // com.bytedance.ee.bear.document.toolbar.ItemId
    public ItemId[] children() {
        if (this == attribution) goto L5;
        return null;
    L5:
        return DocSDKTxtAttrId.values();
    }

    public static DocSDKItemId valueOf(String r100) {
        return (DocSDKItemId) r27.a.a(DocSDKItemId.class, r100);
    }

    public DocSDKItemId(String r100, int r101) {
        super(r100, r101);
    }
}
