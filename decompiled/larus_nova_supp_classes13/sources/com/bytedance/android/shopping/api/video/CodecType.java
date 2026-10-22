package com.bytedance.android.shopping.api.video;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/api/video/CodecType;", "", "CODEC_TYPE_264", "CODEC_TYPE_265", "CODEC_TYPE_266", "CODEC_TYPE_AV1", "ec-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CodecType extends Enum<CodecType> {
    public static final CodecType CODEC_TYPE_264 = null;
    public static final CodecType CODEC_TYPE_265 = null;
    public static final CodecType CODEC_TYPE_266 = null;
    public static final CodecType CODEC_TYPE_AV1 = null;
    public static final /* synthetic */ CodecType[] a = null;

    static {
        CodecType r1 = new CodecType("CODEC_TYPE_264", 0);
        CODEC_TYPE_264 = r1;
        CodecType r2 = new CodecType("CODEC_TYPE_265", 1);
        CODEC_TYPE_265 = r2;
        CodecType r3 = new CodecType("CODEC_TYPE_266", 2);
        CODEC_TYPE_266 = r3;
        CodecType r4 = new CodecType("CODEC_TYPE_AV1", 3);
        CODEC_TYPE_AV1 = r4;
        a = new CodecType[]{r1, r2, r3, r4};
    }

    public static CodecType valueOf(String r1) {
        return (CodecType) r27.a.a(CodecType.class, r1);
    }

    public static CodecType[] values() {
        return (CodecType[]) a.clone();
    }

    public CodecType(String r1, int r2) {
        super(r1, r2);
    }
}
