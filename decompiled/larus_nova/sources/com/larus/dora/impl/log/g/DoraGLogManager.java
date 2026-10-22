package com.larus.dora.impl.log.g;

import android.app.Application;
import androidx.camera.video.AudioStats;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.keva.Keva;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.log.GLogType;
import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.impl.util.s0;
import com.obric.sva.sdk.controller.Global;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import t19.s;
import t39.v;

/* JADX INFO: loaded from: classes27.dex */
public final class DoraGLogManager extends s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DoraGLogManager f336103a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f336104b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static GLogType f336105c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static long f336106d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AtomicLong f336107e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static byte f336108f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static long f336109g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static String f336110h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static PolarisFileWrapper f336111i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final AtomicBoolean f336112j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static v f336113k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final ScheduledExecutorService f336114l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static ScheduledFuture<?> f336115m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Lazy f336116n = null;

    public static final class a implements v {
        public a() {
        }

        @Override // t39.v
        public final void a(boolean r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "msg");
            g49.d.d("DoraGLogManager", "upload log result success:" + r100 + " msg:" + r101);
            if (r100 == false) goto L5;
            s r102 = s.f544207a;
            Application r103 = AppHost.f326268a.getApplication();
            r102.getClass();
            s.p(r103, "upload log success");
            return;
        L5:
            s r104 = s.f544207a;
            Application r105 = AppHost.f326268a.getApplication();
            r104.getClass();
            s.c(r105, "upload log failed");
        }
    }

    static {
        f336103a = new DoraGLogManager();
        f336105c = GLogType.SYSLOG;
        f336107e = new AtomicLong(0);
        f336110h = "";
        f336112j = new AtomicBoolean(false);
        f336114l = PThreadExecutorsUtils.newScheduledThreadPool(1, new DefaultThreadFactory("DoraGLogManager"));
        f336116n = LazyKt.lazy(new b());
    }

    public static long l() {
        return f336107e.get();
    }

    public final String o() {
        return AppHost.f326268a.getApplication().getApplicationContext().getFilesDir() + "/DoraSDK/DoraGLog/";
    }

    public final void s() {
        f336110h = "";
        f336106d = 0;
        f336107e.set(0);
        f336109g = 0;
        f336111i = null;
        t(f336105c, l());
        u(f336105c, f336106d);
    }

    public static String m() {
        DoraDevice r100 = kj4.a.g().c();
        if (r100 == null) goto L6;
        String r101 = r100.f204390sn;
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    public DoraGLogManager() {
    }

    public final void v(boolean r100) {
        f336112j.set(r100);
    }

    public final void k(GLogType r100, byte r101) {
        String r102 = new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(new Date());
        String r103 = r100.getType();
        if (r101 != 0) goto L6;
    L11:
        String r104 = Global.SUFFIX_TXT_FILE;
    L12:
        StringBuilder r105 = new StringBuilder();
        r105.append(o());
        r105.append("DoraGLog_");
        r105.append(r102);
        r105.append('_');
        r105.append(m());
        r105.append('_');
        DoraDevice r106 = kj4.a.g().c();
        if (r106 == null) goto L16;
        String r107 = r106.hwVersion;
        if (r107 == null) goto L16;
    L17:
        r105.append(r107);
        r105.append('_');
        r105.append(r103);
        r105.append(r104);
        f336110h = r105.toString();
        PolarisFileWrapper r108 = new PolarisFileWrapper(f336110h);
        f336111i = r108;
        if (r108.exists() == false) goto L20;
        return;
    L20:
        if (r108.createNewFile() == true) goto L24;
        g49.d.b("DoraGLogManager", "create log file " + f336110h + " failed");
        return;
    L24:
        return;
    L16:
        r107 = "";
        goto L17
    L6:
        if (r101 != 1) goto L9;
        r104 = ".lzf";
        goto L12
    L9:
        if (r101 != 2) goto L11;
        r104 = ".log";
        goto L12
    }

    public final void r(boolean r100, String r101) {
        g49.d.d("DoraGLogManager", "notifyUploadGLogResult result:" + r100 + " msg:" + r101);
        v r102 = f336113k;
        if (r102 == null) goto L6;
        r102.a(r100, r101);
        return;
    }

    public final void t(GLogType r100, long r101) {
        ((Keva) f336116n.getValue()).storeLong(m() + "_log_offset_" + r100, r101);
    }

    public final void u(GLogType r100, long r101) {
        ((Keva) f336116n.getValue()).storeLong(m() + "_log_size_" + r100.getType(), r101);
    }

    public final void q(boolean r100, GLogType r101, String r102) {
        g49.d.d("DoraGLogManager", "notifyGetGLogsResult result:" + r100 + " msg:" + r102 + " curLogType:" + r101);
        v(false);
    }

    public static void n(GLogType r110, long r111, long r112, long r113) {
        g49.d.d("DoraGLogManager", "getLogData type " + r110 + ", offset " + r111 + ", size " + r112 + ", count " + r113);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new DoraGLogManager$getLogData$1(r110, r111, r112, r113, null), 3, null);
    }

    public static void p(byte r100, long r101, long r102, long r103) {
        g49.d.d("DoraGLogManager", "notifyGetGLogProgress type:" + r100 + " curOffset:" + r101 + " totalSize:" + r102 + ", duration:" + r103);
    }

    @Override // com.larus.dora.impl.util.s0, mj4.i
    public final void g(int r110, byte r111, int r112, byte r113) {
        g49.d.d("DoraGLogManager", "onGetGLogInfo nid:" + r110 + " logType:" + r111 + " size:" + r112 + " logFormat:" + r113);
        if (r112 < 0) goto L5;
        f336104b = 0;
        ScheduledFuture<?> r100 = f336115m;
        if (r100 == null) goto L19;
        r100.cancel(true);
    L19:
        GLogType.Companion.getClass();
        GLogType[] r101 = GLogType.values();
        int r102 = r101.length;
        int r103 = 0;
    L21:
        if (r103 >= r102) goto L29;
        GLogType r114 = r101[r103];
        if (r114.getId() != r111) goto L25;
        boolean r115 = true;
    L26:
        if (r115 == true) goto L30;
        r103 = r103 + 1;
    L30:
        if (r114 != null) goto L32;
        return;
    L32:
        f336105c = r114;
        long r104 = r112;
        f336106d = r104;
        f336108f = r113;
        u(r114, r104);
        k(f336105c, r113);
        n(f336105c, l(), 768, 16);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new DoraGLogManager$onGetGLogInfo$1(null), 3, null);
        return;
    L25:
        r115 = false;
        goto L26
    L29:
        r114 = null;
        goto L30
    L5:
        if (r112 != (-3)) goto L7;
        String r105 = "the offset position exceeds the log range(offset >= total_size)";
    L14:
        g49.d.b("DoraGLogManager", "onGetGLogInfo size:" + r112 + ", msg:" + r105);
        q(false, f336105c, r105);
        return;
    L7:
        if (r112 != (-2)) goto L9;
        r105 = "request packet size exceeds the range(maximum value 960)";
        goto L14
    L9:
        if (r112 == (-1)) goto L11;
        r105 = "NEMOS internal error";
        goto L14
    L11:
        r105 = "unknown log type";
        goto L14
    }

    @Override // com.larus.dora.impl.util.s0, mj4.i
    public final void b(int r210, byte r211, long r212, int r213, byte[] r214) {
        g49.d.a("DoraGLogManager", "onGetGLogData nid:" + r210 + " logType:" + r211 + " index:" + r212 + " size:" + r213);
        StringBuilder r100 = new StringBuilder("buf:");
        if (r214 == null) goto L5;
        String r101 = Arrays.toString(r214);
    L6:
        r100.append(r101);
        g49.d.a("DoraGLogManager", r100.toString());
        if (r213 >= 0) goto L21;
        if (r213 != (-3)) goto L11;
        String r102 = "the offset position exceeds the log range(offset >= total_size)";
    L18:
        g49.d.b("DoraGLogManager", "onGetGLogData size:" + r213 + ", msg:" + r102);
        q(false, f336105c, r102);
        return;
    L11:
        if (r213 != (-2)) goto L13;
        r102 = "request packet size exceeds the range(maximum value 960)";
        goto L18
    L13:
        if (r213 == (-1)) goto L15;
        r102 = "NEMOS internal error";
        goto L18
    L15:
        r102 = "unknown log type";
        goto L18
    L21:
        if (f336109g != 0) goto L23;
        f336109g = System.nanoTime();
    L24:
        f336104b = 0;
        ScheduledFuture<?> r103 = f336115m;
        if (r103 == null) goto L27;
        r103.cancel(true);
    L27:
        PolarisFileWrapper r104 = f336111i;
        if (r104 != null) goto L30;
    L55:
        g49.d.b("DoraGLogManager", "logFile is null or not exist");
        q(false, f336105c, "the log file is not exist");
        return;
    L30:
        if (r104.exists() != true) goto L32;
        boolean r105 = true;
    L33:
        if (r105 == false) goto L55;
        if (r214 == null) goto L39;
        PolarisFileWrapper r106 = f336111i;
        if (r106 == null) goto L39;
        FilesKt.appendBytes(r106, r214);
    L39:
        f336107e.set(l() + ((long) r213));
        t(f336105c, l());
        int r107 = com.larus.dora.impl.log.g.a.f336120a;
        com.larus.dora.impl.log.g.a.f336124e = l();
        if (l() < f336106d) goto L51;
        g49.d.d("DoraGLogManager", "log data transmission completed!");
        byte r110 = f336105c.getId();
        long r111 = f336106d;
        p(r110, r111, r111, System.nanoTime() - f336109g);
        int r108 = kj4.a.g().f503708c.f514229d.i(4, 7, new byte[]{12, 1, r211});
        if (r108 == 0) goto L44;
        g49.d.b("DoraGLogManager", "getLogEnd failed, ret:" + r108);
        com.larus.dora.impl.log.g.a.a(1);
    L45:
        t(f336105c, l());
        u(f336105c, f336106d);
        g49.d.d("DoraGLogManager", "get log end success, type:" + r211);
        g49.d.d("DoraGLogManager", "!!!all log upload done!!! type " + f336105c);
        q(true, f336105c, "get log success");
        LogResultType r109 = LogResultType.SUCCESS;
        Intrinsics.checkNotNullParameter(r109, "result");
        long r112 = System.currentTimeMillis() - com.larus.dora.impl.log.g.a.f336125f;
        if (r112 <= 0) goto L48;
        double r113 = ((Math.abs(com.larus.dora.impl.log.g.a.f336124e - com.larus.dora.impl.log.g.a.f336123d) / r112) * ((double) 1000)) / ((double) 1024);
    L49:
        DoraBuryPointManager.J(DoraBuryPointManager.f331862a, "log_get_result", MapsKt.mapOf(new Pair[]{TuplesKt.to("result", Integer.valueOf(r109.getId())), TuplesKt.to("type", Integer.valueOf(com.larus.dora.impl.log.g.a.f336120a)), TuplesKt.to("trigger_type", "manual"), TuplesKt.to("duration", Long.valueOf(r112)), TuplesKt.to("total_size", Long.valueOf(com.larus.dora.impl.log.g.a.f336121b)), TuplesKt.to("get_size", Long.valueOf(com.larus.dora.impl.log.g.a.f336124e)), TuplesKt.to("offset_size", Long.valueOf(com.larus.dora.impl.log.g.a.f336123d)), TuplesKt.to("append_size", Long.valueOf(com.larus.dora.impl.log.g.a.f336124e - com.larus.dora.impl.log.g.a.f336123d)), TuplesKt.to("batch_fetch_count", Long.valueOf(com.larus.dora.impl.log.g.a.f336122c)), TuplesKt.to("pull_rate", String.format("%.1f KB/s", Arrays.copyOf(new Object[]{Double.valueOf(r113)}, 1)))}), false, 12);
        String r114 = f336110h;
        byte r115 = f336105c.getId();
        f336113k = new a();
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new DoraGLogManager$startUploadLog$1(r114 + "", r115, null), 3, null);
        v(false);
        s();
        return;
    L48:
        r113 = AudioStats.AUDIO_AMPLITUDE_NONE;
        goto L49
    L44:
        g49.d.d("DoraGLogManager", "getLogEnd success");
        com.larus.dora.impl.log.g.a.a(0);
        goto L45
    L51:
        if (r212 != 15) goto L53;
        g49.d.a("DoraGLogManager", "getLogData index:" + r212 + ", curLogOffset:" + l());
        n(f336105c, l(), 768, 16);
        return;
    L53:
        g49.d.a("DoraGLogManager", "getLogData index:" + r212 + ", curLogOffset:" + l());
        return;
    L32:
        r105 = false;
        goto L33
    L23:
        long r116 = System.nanoTime();
        p(f336105c.getId(), l(), f336106d, r116 - f336109g);
        f336109g = r116;
        goto L24
    L5:
        r101 = null;
        goto L6
    }
}
