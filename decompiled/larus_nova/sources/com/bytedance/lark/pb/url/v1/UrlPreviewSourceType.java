package com.bytedance.lark.pb.url.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum UrlPreviewSourceType extends Enum<UrlPreviewSourceType> implements WireEnum {
    private static final /* synthetic */ UrlPreviewSourceType[] $VALUES = null;
    public static final ProtoAdapter<UrlPreviewSourceType> ADAPTER = null;
    public static final UrlPreviewSourceType CHAT_ANNOUNCEMENT = null;
    public static final UrlPreviewSourceType PERSONAL_SIG = null;
    public static final UrlPreviewSourceType PRIVATE_DESCRIPTION = null;
    private final int value;

    static {
        UrlPreviewSourceType r100 = new UrlPreviewSourceType("CHAT_ANNOUNCEMENT", 0, 1);
        CHAT_ANNOUNCEMENT = r100;
        UrlPreviewSourceType r101 = new UrlPreviewSourceType("PERSONAL_SIG", 1, 10);
        PERSONAL_SIG = r101;
        UrlPreviewSourceType r102 = new UrlPreviewSourceType("PRIVATE_DESCRIPTION", 2, 11);
        PRIVATE_DESCRIPTION = r102;
        $VALUES = new UrlPreviewSourceType[]{r100, r101, r102};
        ADAPTER = ProtoAdapter.newEnumAdapter(UrlPreviewSourceType.class);
    }

    public static UrlPreviewSourceType[] values() {
        return (UrlPreviewSourceType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static UrlPreviewSourceType fromValue(int r100) {
        if (r100 == 1) goto L15;
        if (r100 == 10) goto L13;
        if (r100 == 11) goto L11;
        return null;
    L11:
        return PRIVATE_DESCRIPTION;
    L13:
        return PERSONAL_SIG;
    L15:
        return CHAT_ANNOUNCEMENT;
    }

    public static UrlPreviewSourceType valueOf(String r100) {
        return (UrlPreviewSourceType) a.a(UrlPreviewSourceType.class, r100);
    }

    private UrlPreviewSourceType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
