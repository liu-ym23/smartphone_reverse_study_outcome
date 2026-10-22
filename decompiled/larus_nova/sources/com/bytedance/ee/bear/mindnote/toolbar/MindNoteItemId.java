package com.bytedance.ee.bear.mindnote.toolbar;

import com.bytedance.ee.bear.document.toolbar.ItemId;
import com.ss.ttvideoengine.log.VideoEventOneOutSync;
import r27.a;

/* JADX INFO: loaded from: classes18.dex */
public final enum MindNoteItemId extends Enum<MindNoteItemId> implements ItemId.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MindNoteItemId[] f234470a = null;
    public static final MindNoteItemId comment = null;
    public static final MindNoteItemId delete = null;
    public static final MindNoteItemId finish = null;
    public static final MindNoteItemId indent = null;
    public static final MindNoteItemId insertImage = null;
    public static final MindNoteItemId mention = null;
    public static final MindNoteItemId mnAttribute = null;
    public static final MindNoteItemId note = null;
    public static final MindNoteItemId outdent = null;
    public static final MindNoteItemId redo = null;
    public static final MindNoteItemId undo = null;

    static {
        MindNoteItemId r100 = new MindNoteItemId("outdent", 0);
        outdent = r100;
        MindNoteItemId r101 = new MindNoteItemId("indent", 1);
        indent = r101;
        MindNoteItemId r102 = new MindNoteItemId(VideoEventOneOutSync.END_TYPE_FINISH, 2);
        finish = r102;
        MindNoteItemId r103 = new MindNoteItemId("mention", 3);
        mention = r103;
        MindNoteItemId r104 = new MindNoteItemId("note", 4);
        note = r104;
        MindNoteItemId r105 = new MindNoteItemId("comment", 5);
        comment = r105;
        MindNoteItemId r110 = new MindNoteItemId("insertImage", 6);
        insertImage = r110;
        MindNoteItemId r111 = new MindNoteItemId("mnAttribute", 7);
        mnAttribute = r111;
        MindNoteItemId r112 = new MindNoteItemId("undo", 8);
        undo = r112;
        MindNoteItemId r113 = new MindNoteItemId("redo", 9);
        redo = r113;
        MindNoteItemId r114 = new MindNoteItemId("delete", 10);
        delete = r114;
        f234470a = new MindNoteItemId[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114};
    }

    public static MindNoteItemId[] values() {
        return (MindNoteItemId[]) f234470a.clone();
    }

    @Override // com.bytedance.ee.bear.document.toolbar.ItemId
    public ItemId[] children() {
        if (this == mnAttribute) goto L5;
        return null;
    L5:
        return MindNoteTxtAttrId.values();
    }

    public static MindNoteItemId valueOf(String r100) {
        return (MindNoteItemId) a.a(MindNoteItemId.class, r100);
    }

    public MindNoteItemId(String r100, int r101) {
        super(r100, r101);
    }
}
