package com.larus.audio.call.common;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.audio.call.f;

/* JADX INFO: loaded from: classes24.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f289094a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f289095b = null;

    static {
        f289094a = f.c().k();
        int r100 = com.larus.audio.call.aec.f.f288968l;
        if (f.d().f289127c.f289098a == false) goto L15;
        String r101 = f.d().f289127c.f289103f;
        int r102 = com.larus.audio.call.util.d.f289644a;
        if (r101 != null) goto L7;
    L9:
        boolean r103 = false;
    L10:
        if (r103 == false) goto L14;
        PolarisFileWrapper r104 = new PolarisFileWrapper(f.d().f289127c.f289103f);
        if (r104.exists() == true) goto L14;
        r104.mkdirs();
    L14:
        String r105 = f.d().f289127c.f289103f;
    L16:
        f289095b = r105;
        return;
    L7:
        if (r101.length() <= 0) goto L9;
        r103 = true;
        goto L10
    L15:
        r105 = "";
        goto L16
    }
}
