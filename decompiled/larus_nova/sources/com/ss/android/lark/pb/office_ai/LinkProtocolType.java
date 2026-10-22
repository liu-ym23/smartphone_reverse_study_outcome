package com.ss.android.lark.pb.office_ai;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum LinkProtocolType extends Enum<LinkProtocolType> implements WireEnum {
    private static final /* synthetic */ LinkProtocolType[] $VALUES = null;
    public static final ProtoAdapter<LinkProtocolType> ADAPTER = null;
    public static final LinkProtocolType LinkProtocolType_APPLINK = null;
    public static final LinkProtocolType LinkProtocolType_DOUBAO = null;
    public static final LinkProtocolType LinkProtocolType_HTTP = null;
    public static final LinkProtocolType LinkProtocolType_HTTPS = null;
    private final int value;

    static {
        LinkProtocolType r100 = new LinkProtocolType("LinkProtocolType_APPLINK", 0, 1);
        LinkProtocolType_APPLINK = r100;
        LinkProtocolType r101 = new LinkProtocolType("LinkProtocolType_DOUBAO", 1, 2);
        LinkProtocolType_DOUBAO = r101;
        LinkProtocolType r102 = new LinkProtocolType("LinkProtocolType_HTTPS", 2, 3);
        LinkProtocolType_HTTPS = r102;
        LinkProtocolType r103 = new LinkProtocolType("LinkProtocolType_HTTP", 3, 4);
        LinkProtocolType_HTTP = r103;
        $VALUES = new LinkProtocolType[]{r100, r101, r102, r103};
        ADAPTER = ProtoAdapter.newEnumAdapter(LinkProtocolType.class);
    }

    public static LinkProtocolType[] values() {
        return (LinkProtocolType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static LinkProtocolType fromValue(int r100) {
        if (r100 == 1) goto L19;
        if (r100 == 2) goto L17;
        if (r100 == 3) goto L15;
        if (r100 == 4) goto L13;
        return null;
    L13:
        return LinkProtocolType_HTTP;
    L15:
        return LinkProtocolType_HTTPS;
    L17:
        return LinkProtocolType_DOUBAO;
    L19:
        return LinkProtocolType_APPLINK;
    }

    public static LinkProtocolType valueOf(String r100) {
        return (LinkProtocolType) a.a(LinkProtocolType.class, r100);
    }

    private LinkProtocolType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
