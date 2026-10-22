package com.bytedance.locallife.adapter.live.impl.host.live.float_window;

import com.bytedance.locallife.poi.poidetail.container.plugin.business.PoiBusinessHomedLiveFloatPlugin$manager$2;
import it6.m;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f256525a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static m f256526b;

    static {
    }

    public static a a(PoiBusinessHomedLiveFloatPlugin$manager$2.a r100) {
        if (r100 == null) goto L9;
        if (Intrinsics.areEqual(f256526b, r100) == true) goto L6;
    L7:
        f256526b = r100;
        f256525a = new a();
        goto L9
    L6:
        if (f256525a == null) goto L7;
    L9:
        return f256525a;
    }
}
