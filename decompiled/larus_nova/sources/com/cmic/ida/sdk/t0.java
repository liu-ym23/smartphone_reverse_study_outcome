package com.cmic.ida.sdk;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.byted.cast.common.TeaEventTrack;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.Closeable;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public class t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f273223a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g f273224b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f273225c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f273226d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f273227e;

    public class a extends ConnectivityManager.NetworkCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AtomicBoolean f273228a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ g f273229b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ JSONObject f273230c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ JSONObject f273231d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ j0 f273232e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ b f273233f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ t0 f273234g;

        public static /* synthetic */ void a(a r100, Thread r101, Throwable r102) {
            r100.a(r101, r102);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onUnavailable() {
            u.b("TransmitBusiness", "wifi切换onUnavailable");
            this.f273232e.a(this.f273229b, 102508, "数据网络切换失败");
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network r100) {
            if (this.f273228a.getAndSet(true) == true) goto L7;
            if (r100 == null) goto L8;
            ThreadMethodProxy.currentThread().setUncaughtExceptionHandler(new h1(this));
            u.b("TransmitBusiness", "wifi切换onAvailable");
            t0.a(this.f273234g, this.f273229b, r100, this.f273230c, this.f273231d, this.f273232e);
            ThreadMethodProxy.currentThread().setUncaughtExceptionHandler(null);
            this.f273233f.a(1000);
            return;
        L8:
            return;
        }

        private /* synthetic */ void a(Thread r100, Throwable r101) {
            u.b("TransmitBusiness", "切换后线程发生crash");
            t0.a(this.f273234g).a().A.add(r101);
            r101.printStackTrace();
        }

        public a(t0 r100, g r101, JSONObject r102, JSONObject r103, j0 r104, b r105) {
            this.f273234g = r100;
            this.f273229b = r101;
            this.f273230c = r102;
            this.f273231d = r103;
            this.f273232e = r104;
            this.f273233f = r105;
            this.f273228a = new AtomicBoolean(false);
        }
    }

    public static class b {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static volatile b f273235g;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ConnectivityManager f273236a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Network f273237b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private ConnectivityManager.NetworkCallback f273238c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f273239d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Handler f273240e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Runnable f273241f;

        public class a extends ConnectivityManager.NetworkCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ ConnectivityManager.NetworkCallback f273242a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ b f273243b;

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onUnavailable() {
                u.b("TransmitBusiness", "onUnavailable");
                super.onUnavailable();
                if (Build.VERSION.SDK_INT < 26) goto L6;
                this.f273242a.onUnavailable();
                return;
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network r100) {
                u.b("TransmitBusiness", "onAvailable");
            L8:
                e = move-exception;
                e.printStackTrace();
                this.f273242a.onAvailable(null);
                return;
            L4:
                if (b.a(this.f273243b).getNetworkCapabilities(r100).hasTransport(0) == false) goto L6;
                b.a(this.f273243b, r100);     // Catch: Exception -> L8
                this.f273242a.onAvailable(r100);     // Catch: Exception -> L8
                b.a(this.f273243b, false);     // Catch: Exception -> L8
            L11:
                return;
            L6:
                u.b("TransmitBusiness", "切换失败，未开启数据网络");     // Catch: Exception -> L8
                b.a(this.f273243b, null);     // Catch: Exception -> L8
                this.f273242a.onAvailable(null);     // Catch: Exception -> L8
                b.a(this.f273243b, true);     // Catch: Exception -> L8
                goto L11
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLost(Network r100) {
                b.a(this.f273243b, true);
            }

            public a(b r100, ConnectivityManager.NetworkCallback r101) {
                this.f273243b = r100;
                this.f273242a = r101;
            }
        }

        public void a() {
            if (this.f273236a != null) goto L13;
            return;
        L13:
        L10:
            e = move-exception;
            e.printStackTrace();
            return;
        L6:
            if (this.f273238c != null) goto L8;
            return;
        L8:
            u.a("TransmitBusiness", "unregisterNetwork");     // Catch: Exception -> L10
            this.f273236a.unregisterNetworkCallback(this.f273238c);     // Catch: Exception -> L10
            this.f273238c = null;     // Catch: Exception -> L10
            this.f273237b = null;     // Catch: Exception -> L10
        }

        private b(Context r100) {
            this.f273241f = new i1(this);
            this.f273236a = (ConnectivityManager) r100.getSystemService("connectivity");     // Catch: Exception -> L5
            this.f273240e = new Handler(Looper.getMainLooper());     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            e.printStackTrace();
        }

        public static b a(Context r100) {
            if (f273235g != null) goto L15;
            monitor-enter(b.class);
        L11:
            th = move-exception;
            throw th;
        L7:
            if (f273235g != null) goto L9;
            f273235g = new b(r100);     // Catch: Throwable -> L11
        L9:
            monitor-exit(b.class);     // Catch: Throwable -> L11
        L15:
            return f273235g;
        }

        public void a(long r100) {
            this.f273240e.postDelayed(this.f273241f, r100);
        }

        public static /* synthetic */ ConnectivityManager a(b r100) {
            return r100.f273236a;
        }

        public static /* synthetic */ Network a(b r100, Network r101) {
            r100.f273237b = r101;
            return r101;
        }

        public static /* synthetic */ boolean a(b r100, boolean r101) {
            r100.f273239d = r101;
            return r101;
        }

        public void a(g r100, j0 r101, ConnectivityManager.NetworkCallback r102) {
            u.b("HttpUtils", "forceNet: ");
            this.f273240e.removeCallbacks(this.f273241f);
            ConnectivityManager r103 = this.f273236a;
            if (r103 != null) goto L6;
            u.b("TransmitBusiness", "mConnectivityManager 为空");
            return;
        L6:
            Network r104 = this.f273237b;
            if (r104 != null) goto L9;
        L16:
            ConnectivityManager.NetworkCallback r105 = this.f273238c;
            if (r105 != null) goto L34;
        L23:
            NetworkRequest r106 = new NetworkRequest.Builder().addCapability(12).addTransportType(0).build();
            a r107 = new a(this, r102);
            this.f273238c = r107;
        L29:
            u.b("TransmitBusiness", "catch requestNetwork exception");
            r101.a(r100, CastIntegerProtector.parseInt("200025"), "数据网络切换失败");
            return;
        L25:
            if (Build.VERSION.SDK_INT < 26) goto L27;
            this.f273236a.requestNetwork(r106, r107, 5000);     // Catch: Exception -> L29
        L31:
            return;
        L27:
            this.f273236a.requestNetwork(r106, r107);     // Catch: Exception -> L29
            goto L31
        L34:
            this.f273236a.unregisterNetworkCallback(r105);     // Catch: Exception -> L20
        L22:
            u.b("HttpUtils", "clear: ");
        L20:
            e = move-exception;
            e.printStackTrace();
            this.f273238c = null;
            goto L22
        L9:
            if (this.f273239d == true) goto L16;
            NetworkInfo r108 = r103.getNetworkInfo(r104);
            if (r108 == null) goto L16;
            if (r108.isAvailable() == false) goto L16;
            u.b("HttpUtils", "reuse network: ");
            r102.onAvailable(this.f273237b);
        }
    }

    @Skip({"com.obric.assistant.network.okhttp"})
    public static URLConnection INVOKEVIRTUAL_com_cmic_ida_sdk_t0_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(URL r100) throws IOException {
        String r101 = r100.getHost();     // Catch: Throwable -> L8 IOException -> L12
        String r102 = r100.getPath();     // Catch: Throwable -> L8 IOException -> L12
        if (com.obric.assistant.network.okhttp.a.c(r101, r102) == false) goto L11;
        FLogger.f375446a.i("UrlConnLancet", "openConnection drop host=" + r101 + " path=" + r102);     // Catch: Throwable -> L8 IOException -> L12
        com.obric.assistant.network.okhttp.a.b(com.obric.assistant.network.okhttp.a.a(r101, r102), r101, r102);     // Catch: Throwable -> L8 IOException -> L12
        throw new IOException("[NetGuard] dropped " + r100);     // Catch: Throwable -> L8 IOException -> L12
    L11:
        return r100.openConnection();
    L12:
        e = move-exception;
        throw e;
    L8:
        th = move-exception;
        FLogger.f375446a.e("UrlConnLancet", "openConnection intercept failed, fallback to origin: " + th.getMessage());
        goto L11
    }

    private void a(Closeable r100) {
        if (r100 == null) goto L10;
        r100.close();     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static /* synthetic */ g a(t0 r100) {
        return r100.f273224b;
    }

    public t0(Context r100, g r101) {
        this.f273225c = false;
        this.f273223a = r100;
        this.f273224b = r101;
    }

    private boolean a(g r100, int r101, j0 r102) {
        u.a("TransmitBusiness", "preCheck");
        r100.b("systemStartTime", SystemClock.elapsedRealtime());
        r100.b("starttime", r0.a());
        r100.b("loginMethod", "transmitRequest");
        r100.b("timeOut", String.valueOf(r101));
        r100.b("logintype", 5);
        boolean r103 = p0.a(this.f273223a);
        String r104 = k0.b().a(r103);
        String r105 = k0.b().a(r104, r103);
        int r106 = p0.a(this.f273223a, r103, r100);
        r100.b(OnekeyLoginConstants.OPERATOR_TYPE, r105);
        r100.b(OnekeyLoginConstants.CU_KEY_OPERATOR, r104);
        r100.b("networktype", r106);
        String r107 = this.f273223a.getPackageName();
        if (r100.a("enable_apk_contents_signers", false) == false) goto L5;
        byte[] r108 = o0.a(this.f273223a);
    L6:
        String r109 = v.a(r108);
        r100.b("apppackage", r107);
        r100.b("appsign", r109);
        if (r106 != 3) goto L10;
        this.f273225c = true;
    L10:
        if (r103 == true) goto L13;
        r102.a(r100, 200010, null);
        return false;
    L13:
        if (r106 != 0) goto L17;
        r102.a(r100, 102101, null);
        return false;
    L17:
        if (r106 != 2) goto L20;
        r102.a(r100, 102103, null);
        return false;
    L20:
        return true;
    L5:
        r108 = o0.a(this.f273223a, r107);
        goto L6
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 11 */
    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 31611. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    private void a(com.cmic.ida.sdk.g r52, android.net.Network r53, com.cmic.ida.sdk.v0 r54, com.cmic.ida.sdk.j0 r55) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0060: CONST (r28v0 ?? I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (0 ??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) A[DECLARE_VAR] (LINE:67108960) in method: com.cmic.ida.sdk.t0.a(com.cmic.ida.sdk.g, android.net.Network, com.cmic.ida.sdk.v0, com.cmic.ida.sdk.j0):void, file: classes22.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:348)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.ArgType.getPrimitiveType()" because "type" is null
            	at jadx.core.codegen.ClassGen.useType(ClassGen.java:564)
            	at jadx.core.codegen.InsnGen.useType(InsnGen.java:269)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:166)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:159)
            	at jadx.core.codegen.InsnGen.assignVar(InsnGen.java:152)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:299)
            	... 31 more
            */
        /*
            Method dump skipped, instruction units count: 3161
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cmic.ida.sdk.t0.a(com.cmic.ida.sdk.g, android.net.Network, com.cmic.ida.sdk.v0, com.cmic.ida.sdk.j0):void");
    }

    public void a(g r110, int r111, String r112, j0 r210) {
        JSONObject r100 = new JSONObject(r112);     // Catch: JSONException -> L14
        String r113 = r100.optString("operType");     // Catch: JSONException -> L14
        JSONObject r114 = r100.optJSONObject("headers");     // Catch: JSONException -> L14
        JSONObject r115 = r100.optJSONObject("params");     // Catch: JSONException -> L14
        String r116 = r100.optString(com.alipay.sdk.m.p.e.f25671s).toUpperCase();     // Catch: JSONException -> L14
        String r117 = r100.optString("url");     // Catch: JSONException -> L14
        r115.put("clientType", "1");     // Catch: JSONException -> L12
        String r101 = r100.optString("callbackFn");     // Catch: JSONException -> L12
        this.f273224b.b(com.alipay.sdk.m.p.e.f25671s, r116);     // Catch: JSONException -> L12
        this.f273224b.b("operType", r113);     // Catch: JSONException -> L12
        this.f273224b.b("url", r117);     // Catch: JSONException -> L12
        this.f273224b.b("callbackFn", r101);     // Catch: JSONException -> L12
        this.f273224b.b("traceId", r115.optString("traceId"));     // Catch: JSONException -> L12
        this.f273224b.b("appId", r115.optString("appId"));     // Catch: JSONException -> L12
        if (a(this.f273224b, r111, r210) == true) goto L8;
        return;
    L8:
        if (this.f273225c == false) goto L10;
        a(r110, r114, r115, r210);
        return;
    L10:
        a(r110, null, r114, r115, r210);
        return;
    L12:
        e = e;
    L15:
        e.printStackTrace();
        r210.a(r110, CastIntegerProtector.parseInt("102203"), null);
        return;
    L14:
        e = e;
        goto L15
    }

    private void a(g r110, JSONObject r111, JSONObject r112, j0 r113) {
        b r100 = b.a(this.f273223a);
        b.a(this.f273223a).a(r110, r113, new a(this, r110, r111, r112, r113, r100));
    }

    private void a(g r110, Network r111, JSONObject r112, JSONObject r210, j0 r211) {
        u.a("TransmitBusiness", "startRequest");
        y0.c(this.f273224b, "gw");
        String r100 = this.f273224b.b("url");
        String r113 = this.f273224b.b(com.alipay.sdk.m.p.e.f25671s);
        String[] r114 = x0.a(true);
        JSONObject r115 = new JSONObject();
        r115.put("ipv4List", r114[0]);     // Catch: JSONException -> L14
        r115.put("ipv6List", r114[1]);     // Catch: JSONException -> L14
        r115.put("networkType", String.valueOf(this.f273224b.a("networktype")));     // Catch: JSONException -> L14
        r115.put("packageName", this.f273224b.b("apppackage"));     // Catch: JSONException -> L14
        if (r210.optString("version", "").equals("4.0") == true) goto L7;
    L10:
        byte[] r101 = y0.b();     // Catch: JSONException -> L14
        String r102 = g0.d().a(r101);     // Catch: JSONException -> L14
        u.a("lyy", r115.toString());     // Catch: JSONException -> L14
        String r103 = com.cmic.ida.sdk.a.a(r101, r115.toString());     // Catch: JSONException -> L14
        new ArrayList(1).add(r103);     // Catch: JSONException -> L14
        r210.put("sdkData", r103);     // Catch: JSONException -> L14
        new ArrayList(1).add(r102);     // Catch: JSONException -> L14
        r210.put("sdkSecret", r102);     // Catch: JSONException -> L14
        if ("GET".equalsIgnoreCase(r113) == false) goto L16;
        r112.put("Content-Type", "application/x-www-form-urlencoded");     // Catch: JSONException -> L14
    L16:
        v0 r104 = new v0(r100, r113, r112, r210);
        r104.c(this.f273224b.b("apppackage"));
        r104.a(this.f273224b.b("appsign"));
        a(r110, r111, r104, r211);
        return;
    L7:
        if (r110.a("oaid", false) == false) goto L9;
        r115.put("funcType", "authz");     // Catch: JSONException -> L14
        r210.put("funcType", "authz");     // Catch: JSONException -> L14
        r115.put("oaid", n0.a("oaid", ""));     // Catch: JSONException -> L14
        goto L10
    L9:
        u.a("funcType", "lyy123");     // Catch: JSONException -> L14
        r115.put("funcType", TeaEventTrack.ACTION_DRAMA_PRE);     // Catch: JSONException -> L14
        r210.put("funcType", TeaEventTrack.ACTION_DRAMA_PRE);     // Catch: JSONException -> L14
    L14:
        e = move-exception;
        e.printStackTrace();
        goto L16
    }

    public static /* synthetic */ void a(t0 r100, g r101, Network r102, JSONObject r103, JSONObject r104, j0 r105) {
        r100.a(r101, r102, r103, r104, r105);
    }
}
