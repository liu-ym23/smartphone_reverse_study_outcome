package com.bytedance.lark.pb.im.v1;

import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum TranslateScopeMask extends Enum<TranslateScopeMask> implements WireEnum {
    private static final /* synthetic */ TranslateScopeMask[] $VALUES = null;
    public static final ProtoAdapter<TranslateScopeMask> ADAPTER = null;
    public static final TranslateScopeMask CHAT_NAME = null;
    public static final TranslateScopeMask DOC_BODY_MASK = null;
    public static final TranslateScopeMask DOC_COMMENT_MASK = null;
    public static final TranslateScopeMask DOC_MASK = null;
    public static final TranslateScopeMask EMAIL = null;
    public static final TranslateScopeMask LARK_MESSAGE_MASK = null;
    public static final TranslateScopeMask MOMENTS = null;
    public static final TranslateScopeMask UNKNOWN_TRANSLATE_SCOPE_MASK = null;
    public static final TranslateScopeMask VIDEO_CONFERENCE = null;
    public static final TranslateScopeMask WEB_XML = null;
    private final int value;

    static {
        TranslateScopeMask r100 = new TranslateScopeMask("UNKNOWN_TRANSLATE_SCOPE_MASK", 0, 0);
        UNKNOWN_TRANSLATE_SCOPE_MASK = r100;
        TranslateScopeMask r101 = new TranslateScopeMask("LARK_MESSAGE_MASK", 1, 1);
        LARK_MESSAGE_MASK = r101;
        TranslateScopeMask r102 = new TranslateScopeMask("DOC_BODY_MASK", 2, 2);
        DOC_BODY_MASK = r102;
        TranslateScopeMask r103 = new TranslateScopeMask("DOC_COMMENT_MASK", 3, 4);
        DOC_COMMENT_MASK = r103;
        TranslateScopeMask r104 = new TranslateScopeMask("WEB_XML", 4, 8);
        WEB_XML = r104;
        TranslateScopeMask r110 = new TranslateScopeMask("DOC_MASK", 5, 16);
        DOC_MASK = r110;
        TranslateScopeMask r111 = new TranslateScopeMask(CommonConstant.RETKEY.EMAIL, 6, 32);
        EMAIL = r111;
        TranslateScopeMask r112 = new TranslateScopeMask("VIDEO_CONFERENCE", 7, 64);
        VIDEO_CONFERENCE = r112;
        TranslateScopeMask r113 = new TranslateScopeMask("MOMENTS", 8, 128);
        MOMENTS = r113;
        TranslateScopeMask r105 = new TranslateScopeMask("CHAT_NAME", 9, 256);
        CHAT_NAME = r105;
        $VALUES = new TranslateScopeMask[]{r100, r101, r102, r103, r104, r110, r111, r112, r113, r105};
        ADAPTER = ProtoAdapter.newEnumAdapter(TranslateScopeMask.class);
    }

    public static TranslateScopeMask[] values() {
        return (TranslateScopeMask[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static TranslateScopeMask fromValue(int r100) {
        if (r100 == 0) goto L42;
        if (r100 == 1) goto L40;
        if (r100 == 2) goto L38;
        if (r100 == 4) goto L36;
        if (r100 == 8) goto L34;
        if (r100 == 16) goto L32;
        if (r100 == 32) goto L30;
        if (r100 == 64) goto L28;
        if (r100 == 128) goto L26;
        if (r100 == 256) goto L24;
        return null;
    L24:
        return CHAT_NAME;
    L26:
        return MOMENTS;
    L28:
        return VIDEO_CONFERENCE;
    L30:
        return EMAIL;
    L32:
        return DOC_MASK;
    L34:
        return WEB_XML;
    L36:
        return DOC_COMMENT_MASK;
    L38:
        return DOC_BODY_MASK;
    L40:
        return LARK_MESSAGE_MASK;
    L42:
        return UNKNOWN_TRANSLATE_SCOPE_MASK;
    }

    public static TranslateScopeMask valueOf(String r100) {
        return (TranslateScopeMask) a.a(TranslateScopeMask.class, r100);
    }

    private TranslateScopeMask(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
