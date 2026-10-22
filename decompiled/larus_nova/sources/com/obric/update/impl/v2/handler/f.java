package com.obric.update.impl.v2.handler;

import android.app.Application;
import android.net.Uri;
import androidx.core.content.ContextCompat;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.applog.api.IApplog;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.product.platform.api.rom.RomInfo;
import com.obric.update.impl.v2.j;
import com.obric.update.impl.v2.o;
import java.io.File;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import yhc.i0;
import yhc.v;

/* JADX INFO: loaded from: classes5.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f404114a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<Integer, Unit> f404115b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function3<Integer, Integer, Boolean, Unit> f404116c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function2<Boolean, Boolean, Unit> f404117d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f404118e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f404119f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final h f404120g;

    public static final class a {
    }

    static {
    }

    public final v a() {
        v.a r100 = new v.a();
        r100.f567757b = new ObricInitHandler$createAppCommonContext$1();
        r100.f567760e = new b();
        r100.f567761f = new c();
        this.f404114a.f404132b.getClass();
        StringBuilder r101 = new StringBuilder();
        AppHost.Companion r102 = AppHost.f326268a;
        r101.append(r102.getApplication().getPackageName());
        r101.append(".obric.update");
        r100.f567758c = r101.toString();
        i0 r103 = new i0();
        r103.f567700b = true;
        r100.f567759d = r103;
        r100.f567766k = IApplog.f287053a.getDeviceId();
        r100.f567756a = R.drawable.status_icon;
        r100.f567771p = true;
        r100.f567762g = true;
        r100.f567772q = false;
        r100.f567764i = true;
        r100.f567763h = false;
        Application r104 = r102.getApplication();
        String r105 = null;
        File r106 = (File) ArraysKt.firstOrNull(ContextCompat.getExternalFilesDirs(r104, null));
        if (r106 == null) goto L8;
        String r107 = new PolarisFileWrapper(r106, "update").getAbsolutePath();
        if (r107 == null) goto L8;
        r105 = r107;
    L15:
        r100.f567770o = r105;
        r100.f567769n = new d(this);
        String r108 = "";
        RomInfo r109 = t9a.b.b().b();     // Catch: Exception -> L21
        String r110 = r109.b();     // Catch: Exception -> L21
        String r111 = r109.getDeviceBrand();     // Catch: Exception -> L21
        String r112 = r109.a();     // Catch: Exception -> L21
        if (r112 != null) goto L19;
        r112 = "";
    L19:
        FLogger.f375446a.i("ObricInitHandler", "buildObricUpdateQuery,romVersion=" + r110 + ",brand=" + r111 + ",outerSdkVersion=0,externalDid=" + r112);     // Catch: Exception -> L21
        r108 = "&rom_version=" + Uri.encode(r110) + "&outer_sdk_version=" + Uri.encode("0") + "&device_brand=" + Uri.encode(r111) + "&external_did=" + Uri.encode(r112);     // Catch: Exception -> L21
    L23:
        r100.f567768m = r108;
        return new v(r100);
    L21:
        e = move-exception;
        FLogger.f375446a.i("ObricInitHandler", "buildObricUpdateQuery fail, " + e);
    L8:
        File r113 = r104.getExternalCacheDir();
        if (r113 != null) goto L13;
        r113 = r104.getFilesDir();
        if (r113 != null) goto L13;
        r113 = r104.getCacheDir();
    L13:
        if (r113 == null) goto L15;
        r105 = new PolarisFileWrapper(r113, "update").getAbsolutePath();
        goto L15
    }

    /* JADX WARN: Type inference failed for: r7v0, types: [com.obric.update.impl.v2.handler.a] */
    public final void b() {
        if (this.f404118e == false) goto L5;
        return;
    L5:
        Object r100 = this.f404119f;
        monitor-enter(r100);
        FLogger r101 = FLogger.f375446a;     // Catch: Throwable -> L9 Exception -> L11
        r101.i("ObricInitHandler", "initSDK start");     // Catch: Throwable -> L9 Exception -> L11
        v r102 = a();     // Catch: Throwable -> L9 Exception -> L11
        com.obric.update.impl.v2.gateway.f r103 = this.f404114a.f404131a;     // Catch: Throwable -> L9 Exception -> L11
        ObricInitHandler$createAppCommonContext$1 r104 = new ObricInitHandler$createAppCommonContext$1();     // Catch: Throwable -> L9 Exception -> L11
        g r105 = new g();     // Catch: Throwable -> L9 Exception -> L11
        ?? r106 = new com.obric.update.impl.v2.handler.a();     // Catch: Throwable -> L9 Exception -> L11
        h r107 = this.f404120g;     // Catch: Throwable -> L9 Exception -> L11
        r103.getClass();     // Catch: Throwable -> L9 Exception -> L11
        com.obric.update.impl.v2.gateway.f.a(r104, r102, r105, r106, r107);     // Catch: Throwable -> L9 Exception -> L11
        this.f404118e = true;     // Catch: Throwable -> L9 Exception -> L11
        r101.i("ObricInitHandler", "initSDK success");     // Catch: Throwable -> L9 Exception -> L11
    L13:
        Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L9
        monitor-exit(r100);
        return;
    L11:
        e = move-exception;
        FLogger.f375446a.e("ObricInitHandler", "initSDK error: " + e);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public f(o r100, com.obric.update.impl.v2.h r101, com.obric.update.impl.v2.i r102, j r103) {
        Intrinsics.checkNotNullParameter(r100, "gateways");
        Intrinsics.checkNotNullParameter(r101, "onStatus");
        Intrinsics.checkNotNullParameter(r102, "onProgress");
        Intrinsics.checkNotNullParameter(r103, "onDownloadResult");
        this.f404114a = r100;
        this.f404115b = r101;
        this.f404116c = r102;
        this.f404117d = r103;
        this.f404119f = new Object();
        this.f404120g = new h(this);
    }
}
