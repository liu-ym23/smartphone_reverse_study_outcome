package com.bytedance.ee.bear.mindnote.toolbar;

import com.bytedance.ee.bear.document.toolbar.ItemId;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final enum MindNoteItemId extends Enum<MindNoteItemId> implements ItemId.a {
    public static final /* synthetic */ MindNoteItemId[] a = null;
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
        MindNoteItemId r0 = new MindNoteItemId("outdent", 0);
        outdent = r0;
        MindNoteItemId r1 = new MindNoteItemId("indent", 1);
        indent = r1;
        MindNoteItemId r3 = new MindNoteItemId("finish", 2);
        finish = r3;
        MindNoteItemId r5 = new MindNoteItemId("mention", 3);
        mention = r5;
        MindNoteItemId r7 = new MindNoteItemId("note", 4);
        note = r7;
        MindNoteItemId r9 = new MindNoteItemId("comment", 5);
        comment = r9;
        MindNoteItemId r11 = new MindNoteItemId("insertImage", 6);
        insertImage = r11;
        MindNoteItemId r13 = new MindNoteItemId("mnAttribute", 7);
        mnAttribute = r13;
        MindNoteItemId r15 = new MindNoteItemId("undo", 8);
        undo = r15;
        MindNoteItemId r14 = new MindNoteItemId("redo", 9);
        redo = r14;
        MindNoteItemId r12 = new MindNoteItemId("delete", 10);
        delete = r12;
        a = new MindNoteItemId[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12};
    }

    public static MindNoteItemId[] values() {
        return (MindNoteItemId[]) a.clone();
    }

    public ItemId[] children() {
        if (this == mnAttribute) goto L5;
        return null;
    L5:
        return MindNoteTxtAttrId.values();
    }

    public static MindNoteItemId valueOf(String r1) {
        return (MindNoteItemId) a.a(MindNoteItemId.class, r1);
    }

    public MindNoteItemId(String r1, int r2) {
        super(r1, r2);
    }
}
