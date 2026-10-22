package com.bytedance.awemeopen.infra.base.player;

import com.bytedance.awemeopen.infra.base.debug.AoDebug;
import com.bytedance.awemeopen.infra.base.env.AoEnv;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f198739a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f198740b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f198741c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f198742d;

    public d() {
        AoDebug.b();
        String r100 = AoEnv.b();
        String r101 = AoEnv.a().getHostAppName();
        String r102 = AoEnv.f();
        Intrinsics.checkNotNullParameter(r100, "appChannel");
        Intrinsics.checkNotNullParameter(r101, "appName");
        Intrinsics.checkNotNullParameter(r102, "appVersion");
        Intrinsics.checkNotNullParameter("", "ttSDKLicensePath");
        this.f198739a = r100;
        this.f198740b = r101;
        this.f198741c = r102;
        this.f198742d = "";
    }
}
