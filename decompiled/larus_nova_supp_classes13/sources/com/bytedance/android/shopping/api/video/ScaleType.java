package com.bytedance.android.shopping.api.video;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/api/video/ScaleType;", "", "CENTER_CROP", "FIT_CENTER", "ec-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ScaleType extends Enum<ScaleType> {
    public static final ScaleType CENTER_CROP = null;
    public static final ScaleType FIT_CENTER = null;
    public static final /* synthetic */ ScaleType[] a = null;

    static {
        ScaleType r1 = new ScaleType("CENTER_CROP", 0);
        CENTER_CROP = r1;
        ScaleType r2 = new ScaleType("FIT_CENTER", 1);
        FIT_CENTER = r2;
        a = new ScaleType[]{r1, r2};
    }

    public static ScaleType valueOf(String r1) {
        return (ScaleType) r27.a.a(ScaleType.class, r1);
    }

    public static ScaleType[] values() {
        return (ScaleType[]) a.clone();
    }

    public ScaleType(String r1, int r2) {
        super(r1, r2);
    }
}
