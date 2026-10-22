package com.larus.network;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common.apphost.AppHost;

/* JADX INFO: loaded from: classes4.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f360110a = false;

    static {
        StringBuilder r100 = new StringBuilder();
        AppHost.Companion r101 = AppHost.f326268a;
        r100.append(r101.getApplication().getFilesDir().getAbsolutePath());
        r100.append("/enable_opaque_data.flag");
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100.toString());
        new PolarisFileWrapper(r101.getApplication().getFilesDir().getAbsolutePath() + "/schedule_vdc.flag");
        new PolarisFileWrapper(r101.getApplication().getFilesDir().getAbsolutePath() + "/request_env.flag");
        new PolarisFileWrapper(r101.getApplication().getFilesDir().getAbsolutePath() + "/lark_env.flag");
        f360110a = r102.exists();
    }
}
