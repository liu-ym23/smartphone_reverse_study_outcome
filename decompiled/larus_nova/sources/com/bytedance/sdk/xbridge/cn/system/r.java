package com.bytedance.sdk.xbridge.cn.system;

import android.os.Process;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import kotlin.Unit;
import kotlin.concurrent.ThreadsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "x.getDeviceStats")
public final class r extends d {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f270229i = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f270230d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f270231e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f270232f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f270233g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f270234h;

    public r() {
        this.f270230d = 360;
        this.f270233g = "/sys/devices/system/cpu/cpu";
        this.f270234h = "/cpufreq/stats/time_in_state";
    }

    public static final long a(r r100) {
        r100.getClass();
        BufferedReader r101 = new BufferedReader(new InputStreamReader(new PolarisFileInputStreamWrapper("/proc/" + Process.myPid() + "/stat")), 1000);     // Catch: Throwable -> L11
        Object[] r102 = new Regex(" ").split(r101.readLine(), 0).toArray(new String[0]);     // Catch: Throwable -> L10
        if (r102 == null) goto L9;
        String[] r103 = (String[]) r102;     // Catch: Throwable -> L10
        long r104 = (Long.parseLong(r103[13]) + Long.parseLong(r103[14])) * ((long) 10);
        r101.close();
        return r104;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");     // Catch: Throwable -> L10
    L12:
        if (r101 == null) goto L14;
        r101.close();
    L14:
        return -1;
    L11:
        r101 = null;
        goto L12
    }

    public static final long b(r r110) {
        r110.getClass();
        int r100 = Runtime.getRuntime().availableProcessors();
        long r101 = -1;
        int r102 = 0;
    L3:
        if (r102 >= r100) goto L30;
        BufferedReader r103 = new BufferedReader(new PolarisFileReaderWrapper(r110.f270233g + r102 + r110.f270234h), 50);     // Catch: Throwable -> L24
    L33:
        String r104 = r103.readLine();     // Catch: Throwable -> L22
        if (r104 != null) goto L8;
    L32:
        r103.close();     // Catch: Throwable -> L31
        r102 = r102 + 1;     // Catch: Throwable -> L31
        goto L3
    L45:
        return r101;
    L8:
        if (r104.length() != 0) goto L10;
        boolean r105 = true;
    L11:
        if (r105 == true) goto L32;
        Object[] r106 = new Regex("\\s+").split(r104, 0).toArray(new String[0]);     // Catch: Throwable -> L22
        if (r106 == null) goto L20;
        String[] r107 = (String[]) r106;     // Catch: Throwable -> L22
        if (r107.length != 2) goto L33;
        r101 = r101 + Long.parseLong(r107[1]);     // Catch: Throwable -> L22
        goto L33
    L20:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");     // Catch: Throwable -> L22
    L10:
        r105 = false;
    L22:
        th = th;
    L26:
        if (r103 == null) goto L28;
        r103.close();     // Catch: Throwable -> L31
    L28:
        throw th;     // Catch: Throwable -> L31
    L24:
        th = th;
        r103 = null;
        goto L26
    L30:
        return r101 / ((long) r100);
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(final IBDXBridgeContext r110, XBaseParamModel r111, final CompletionBlock r112) {
        final d.b r113 = (d.b) r111;
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r113, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        final Function1<Float, Unit> r100 = new XGetDeviceStatsMethod$handle$onResult$1(r110, r112, this, r113);
        if (Intrinsics.areEqual(r113.getCpu_usage(), Boolean.TRUE) == false) goto L8;
        long r114 = System.currentTimeMillis();
        if ((r114 - this.f270231e) >= this.f270230d) goto L7;
        r100.invoke(Float.valueOf(this.f270232f));
        return;
    L7:
        this.f270231e = r114;
        ThreadsKt.thread$default(false, false, null, null, 0, new XGetDeviceStatsMethod$getCpuUsage$1(this, r100), 31, null);
        return;
    L8:
        r100.invoke(Float.valueOf(-2.0f));
    }
}
