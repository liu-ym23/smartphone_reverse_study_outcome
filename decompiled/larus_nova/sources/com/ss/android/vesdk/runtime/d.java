package com.ss.android.vesdk.runtime;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.vesdk.VELogUtil;

/* JADX INFO: loaded from: classes40.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f455898a;

    public final String a() {
        PolarisFileWrapper r100 = new PolarisFileWrapper(this.f455898a, "audio");
        if (r100.exists() == true) goto L9;
        if (r100.mkdirs() == true) goto L9;
        VELogUtil.e("VEResManager", "mkdirs failed, workspace path: " + this.f455898a);
        return "";
    L9:
        return r100.getAbsolutePath();
    }

    public d(String r100) {
        this.f455898a = r100;
    }

    public static String b(String r100, String r101) {
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100, r101);
        if (r102.exists() == true) goto L9;
        if (r102.mkdirs() == true) goto L9;
        VELogUtil.e("VEResManager", "mkdirs failed, workspace path: " + r100);
        return "";
    L9:
        return r102.getAbsolutePath();
    }
}
