package com.obric.update.impl.v2;

import com.monitor.cloudmessage.consts.CloudControlInf;
import com.obric.update.impl.v2.gateway.PluginInstallGateway;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.obric.update.impl.v2.gateway.f f404131a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.obric.update.impl.v2.gateway.b f404132b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.obric.update.impl.v2.gateway.a f404133c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.obric.update.impl.v2.gateway.c f404134d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final PluginInstallGateway f404135e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.obric.update.impl.v2.gateway.d f404136f;

    public o() {
        com.obric.update.impl.v2.gateway.f r100 = new com.obric.update.impl.v2.gateway.f();
        com.obric.update.impl.v2.gateway.b r101 = new com.obric.update.impl.v2.gateway.b();
        com.obric.update.impl.v2.gateway.a r102 = new com.obric.update.impl.v2.gateway.a();
        com.obric.update.impl.v2.gateway.c r103 = new com.obric.update.impl.v2.gateway.c();
        PluginInstallGateway r104 = new PluginInstallGateway();
        com.obric.update.impl.v2.gateway.d r105 = new com.obric.update.impl.v2.gateway.d();
        Intrinsics.checkNotNullParameter(r100, "sdk");
        Intrinsics.checkNotNullParameter(r101, "apkInstall");
        Intrinsics.checkNotNullParameter(r102, "account");
        Intrinsics.checkNotNullParameter(r103, "network");
        Intrinsics.checkNotNullParameter(r104, CloudControlInf.PLUGIN);
        Intrinsics.checkNotNullParameter(r105, "setting");
        this.f404131a = r100;
        this.f404132b = r101;
        this.f404133c = r102;
        this.f404134d = r103;
        this.f404135e = r104;
        this.f404136f = r105;
    }
}
