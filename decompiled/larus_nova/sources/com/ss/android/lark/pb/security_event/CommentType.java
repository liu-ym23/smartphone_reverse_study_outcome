package com.ss.android.lark.pb.security_event;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum CommentType extends Enum<CommentType> implements WireEnum {
    private static final /* synthetic */ CommentType[] $VALUES = null;
    public static final ProtoAdapter<CommentType> ADAPTER = null;
    public static final CommentType AddComment = null;
    public static final CommentType AddReply = null;
    public static final CommentType CommentTypeUnknown = null;
    public static final CommentType DeleteReply = null;
    public static final CommentType EditReply = null;
    public static final CommentType UpdateComment = null;
    private final int value;

    static {
        CommentType r100 = new CommentType("CommentTypeUnknown", 0, 0);
        CommentTypeUnknown = r100;
        CommentType r101 = new CommentType("AddComment", 1, 1);
        AddComment = r101;
        CommentType r102 = new CommentType("AddReply", 2, 2);
        AddReply = r102;
        CommentType r103 = new CommentType("EditReply", 3, 3);
        EditReply = r103;
        CommentType r104 = new CommentType("DeleteReply", 4, 4);
        DeleteReply = r104;
        CommentType r105 = new CommentType("UpdateComment", 5, 5);
        UpdateComment = r105;
        $VALUES = new CommentType[]{r100, r101, r102, r103, r104, r105};
        ADAPTER = ProtoAdapter.newEnumAdapter(CommentType.class);
    }

    public static CommentType[] values() {
        return (CommentType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static CommentType fromValue(int r100) {
        if (r100 == 0) goto L26;
        if (r100 == 1) goto L24;
        if (r100 == 2) goto L22;
        if (r100 == 3) goto L20;
        if (r100 == 4) goto L18;
        if (r100 == 5) goto L16;
        return null;
    L16:
        return UpdateComment;
    L18:
        return DeleteReply;
    L20:
        return EditReply;
    L22:
        return AddReply;
    L24:
        return AddComment;
    L26:
        return CommentTypeUnknown;
    }

    public static CommentType valueOf(String r100) {
        return (CommentType) a.a(CommentType.class, r100);
    }

    private CommentType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
