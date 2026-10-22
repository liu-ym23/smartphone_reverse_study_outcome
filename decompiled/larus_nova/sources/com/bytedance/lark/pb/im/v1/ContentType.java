package com.bytedance.lark.pb.im.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum ContentType extends Enum<ContentType> implements WireEnum {
    private static final /* synthetic */ ContentType[] $VALUES = null;
    public static final ProtoAdapter<ContentType> ADAPTER = null;
    public static final ContentType TEXT_CONTENT_TYPE = null;
    public static final ContentType UNKNOWN_CONTENT_TYPE = null;
    public static final ContentType WEB_XML_CONTENT_TYPE = null;
    private final int value;

    static {
        ContentType r100 = new ContentType("UNKNOWN_CONTENT_TYPE", 0, 0);
        UNKNOWN_CONTENT_TYPE = r100;
        ContentType r101 = new ContentType("WEB_XML_CONTENT_TYPE", 1, 1);
        WEB_XML_CONTENT_TYPE = r101;
        ContentType r102 = new ContentType("TEXT_CONTENT_TYPE", 2, 2);
        TEXT_CONTENT_TYPE = r102;
        $VALUES = new ContentType[]{r100, r101, r102};
        ADAPTER = ProtoAdapter.newEnumAdapter(ContentType.class);
    }

    public static ContentType[] values() {
        return (ContentType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static ContentType fromValue(int r100) {
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L12;
        if (r100 == 2) goto L10;
        return null;
    L10:
        return TEXT_CONTENT_TYPE;
    L12:
        return WEB_XML_CONTENT_TYPE;
    L14:
        return UNKNOWN_CONTENT_TYPE;
    }

    public static ContentType valueOf(String r100) {
        return (ContentType) a.a(ContentType.class, r100);
    }

    private ContentType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
