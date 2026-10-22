package com.bytedance.platform.aio.channel.js.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/platform/aio/channel/js/model/BytesContentType;", "", "", "type", "I", "getType", "()I", "JS_OBJECT", "JSON", "PROTOBUF", "live-kmp-platform-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum BytesContentType extends Enum<BytesContentType> {
    public static final BytesContentType JSON = null;
    public static final BytesContentType JS_OBJECT = null;
    public static final BytesContentType PROTOBUF = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BytesContentType[] f266599a = null;
    private final int type;

    static {
        BytesContentType r100 = new BytesContentType("JS_OBJECT", 0, -1);
        JS_OBJECT = r100;
        BytesContentType r101 = new BytesContentType("JSON", 1, 0);
        JSON = r101;
        BytesContentType r102 = new BytesContentType("PROTOBUF", 2, 1);
        PROTOBUF = r102;
        f266599a = new BytesContentType[]{r100, r101, r102};
    }

    public static BytesContentType valueOf(String r100) {
        return (BytesContentType) r27.a.a(BytesContentType.class, r100);
    }

    public static BytesContentType[] values() {
        return (BytesContentType[]) f266599a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public BytesContentType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
