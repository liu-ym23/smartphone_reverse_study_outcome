package com.larus.flow.capture.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/flow/capture/model/PixelFormat;", "", "<init>", "(Ljava/lang/String;I)V", "TEXTURE_OES", "TEXTURE_2D", "RGBA", "NV12", "OApp.flowSDK.baseSDK.common.flow-capture"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PixelFormat extends Enum<PixelFormat> {
    public static final PixelFormat NV12 = null;
    public static final PixelFormat RGBA = null;
    public static final PixelFormat TEXTURE_2D = null;
    public static final PixelFormat TEXTURE_OES = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PixelFormat[] f343424a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f343425b = null;

    public static EnumEntries<PixelFormat> getEntries() {
        return f343425b;
    }

    static {
        PixelFormat r100 = new PixelFormat("TEXTURE_OES", 0);
        TEXTURE_OES = r100;
        PixelFormat r101 = new PixelFormat("TEXTURE_2D", 1);
        TEXTURE_2D = r101;
        PixelFormat r102 = new PixelFormat("RGBA", 2);
        RGBA = r102;
        PixelFormat r103 = new PixelFormat("NV12", 3);
        NV12 = r103;
        PixelFormat[] r104 = {r100, r101, r102, r103};
        f343424a = r104;
        f343425b = EnumEntriesKt.enumEntries(r104);
    }

    public static PixelFormat[] values() {
        return (PixelFormat[]) f343424a.clone();
    }

    public static PixelFormat valueOf(String r100) {
        return (PixelFormat) a.a(PixelFormat.class, r100);
    }

    public PixelFormat(String r100, int r101) {
        super(r100, r101);
    }
}
