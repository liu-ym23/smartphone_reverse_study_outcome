package com.ss.videoarch.live;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.LinkAddress;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.android.livesdkapi.performance.IPerformanceStrategyManager;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.TTDispatchResult;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.httpdns.TTDnsResult;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ss.ttvideoengine.DataLoaderHelper;
import com.ss.videoarch.strategy.IFunctionCalledByStrategyEngine;
import com.ss.videoarch.strategy.LiveStrategyManager;
import com.ss.videoarch.strategy.featureCenter.featureType.TypeDeviceFeaturesCollector;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.net.Inet6Address;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class b {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static rmc.a f458553w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static Context f458554x;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f458555a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.ss.videoarch.live.a f458556b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f458557c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f458558d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f458559e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f458560f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final rmc.c f458561g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f458562h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public rmc.b f458563i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public h f458564j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public PthreadHandlerThreadV2 f458565k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f458566l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f458567m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f458568n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f458569o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f458570p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public i f458571q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final a f458572r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final C5510b f458573s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final c f458574t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final d f458575u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final e f458576v;

    public class a extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f458577a;

        public a(b r100) {
            this.f458577a = r100;
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context r100, Intent r101) {
            if (isInitialStickyBroadcast() == false) goto L6;
            return;
        L6:
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(r101.getAction()) == true) goto L15;
            return;
        L15:
        L12:
            e = move-exception;
            e.printStackTrace();
            return;
        L9:
            if (this.f458577a.f458564j == null) goto L17;
            Message r102 = new Message();     // Catch: Exception -> L12
            r102.what = 1026;     // Catch: Exception -> L12
            r102.obj = r100;     // Catch: Exception -> L12
            this.f458577a.f458564j.sendMessage(r102);     // Catch: Exception -> L12
            return;
        }
    }

    /* JADX INFO: renamed from: com.ss.videoarch.live.b$b, reason: collision with other inner class name */
    public class C5510b implements com.ss.videoarch.live.a.InterfaceC5509a {
        public C5510b() {
        }

        @Override // com.ss.videoarch.live.a.InterfaceC5509a
        public final void f(String r100) {
            rmc.a r101 = b.f458553w;
            if (r101 != null) goto L5;
            if (r100 != null) goto L5;
            return;
        L5:
            r101.a(r100);
        }
    }

    public class c implements com.ss.videoarch.live.a.c {
        @Override // com.ss.videoarch.live.a.c
        public final void a() {
        }

        public c() {
        }
    }

    public class d implements com.ss.videoarch.live.a.e {
        @Override // com.ss.videoarch.live.a.e
        public final int getEffectiveConnectionType() {
            return TTNetInit.getEffectiveConnectionType();
        }

        public d() {
        }

        @Override // com.ss.videoarch.live.a.e
        public final String b(String r100) {
            TTDispatchResult r101 = TTNetInit.ttUrlDispatch(r100);     // Catch: Exception -> L7
            if (TextUtils.isEmpty(r101.getFinalUrl()) == true) goto L12;
            JSONObject r102 = new JSONObject();     // Catch: Exception -> L7
            r102.put(r100, r101.getFinalUrl());     // Catch: Exception -> L7
            return r102.toString();
        L12:
            return null;
        L7:
            e = move-exception;
            e.printStackTrace();
            return null;
        }

        @Override // com.ss.videoarch.live.a.e
        public final List<String> d(String r100) {
            ArrayList r101 = new ArrayList();
            LinkedHashMap r102 = new LinkedHashMap();     // Catch: Exception -> L11
            r102.put("x-ttnet-httpdns-auth-id", "2102328933");     // Catch: Exception -> L11
            r102.put("x-ttnet-httpdns-auth-key", "NkVWU0FxeTBvN05xUHZONQ==");     // Catch: Exception -> L11
            TTDnsResult r103 = TTNetInit.TTDnsResolve(r100, 0, r102);     // Catch: Exception -> L11
            if (r103.ret != 0) goto L16;
            List<String> r104 = r103.iplist;     // Catch: Exception -> L11
            if (r104 != null) goto L8;
            return r101;
        L8:
            if (r104.isEmpty() == true) goto L18;
            return r103.iplist;
        L18:
            return r101;
        L16:
            return r101;
        L11:
            e = move-exception;
            e.printStackTrace();
            return r101;
        }
    }

    public class e implements com.ss.videoarch.live.a.d {
        @Override // com.ss.videoarch.live.a.d
        public final String g() {
            return (String) LiveStrategyManager.inst().getConfigAndStrategyByKeyInt(0, 52, new String(), null);
        }

        public e() {
        }

        @Override // com.ss.videoarch.live.a.d
        public final void e(String r100) {
            LiveStrategyManager.inst().notifyInfo(2, 0, r100);
        }

        @Override // com.ss.videoarch.live.a.d
        public final JSONObject c(int r100, JSONObject r101) {
            return LiveStrategyManager.inst().executeCommand(2, r100, 0, r101);
        }
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f458578a = null;

        static {
            f458578a = new b();
        }
    }

    public static class g implements IFunctionCalledByStrategyEngine {
        public g() {
        }

        @Override // com.ss.videoarch.strategy.IFunctionCalledByStrategyEngine
        public final <T> T callFunctionByKey(int r100, T r101) {
            if (r101 != null) goto L5;
            return null;
        L5:
            b r102 = f.f458578a;
            if (r102.f() == true) goto L9;
            return null;
        L9:
            if (r100 == 1) goto L21;
        L20:
            return null;
        L21:
            JSONObject r103 = new JSONObject(String.valueOf(r101));     // Catch: JSONException -> L18
            String r104 = r103.optString("url_info");     // Catch: JSONException -> L18
            String r105 = r103.optString("preconn_params");     // Catch: JSONException -> L18
            if (r104 == null) goto L20;
            if (r102.f() == false) goto L20;
            r102.f458556b.h(r104, r105);     // Catch: JSONException -> L18
        L18:
            e = move-exception;
            e.printStackTrace();
            goto L20
        }
    }

    public class h extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f458579a;

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class a() throws ClassNotFoundException {
            ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
            FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (el9.a.a() == true) goto L34;
            Class<?> r102 = Class.forName("com.ss.videoarch.live.LiveIOManager");     // Catch: Throwable -> L8
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
            FastClassNotFoundHandler.a("com.ss.videoarch.live.LiveIOManager");     // Catch: Throwable -> L8
        L7:
            return r102;
        L8:
            th = move-exception;
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b("com.ss.videoarch.live.LiveIOManager");
        L12:
            throw th;
        L34:
            Class<?> r103 = Class.forName("com.ss.videoarch.live.LiveIOManager");     // Catch: Throwable -> L17
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
            FastClassNotFoundHandler.a("com.ss.videoarch.live.LiveIOManager");     // Catch: Throwable -> L17
        L16:
            return r103;
        L17:
            th = move-exception;
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
            FastClassNotFoundHandler.b("com.ss.videoarch.live.LiveIOManager");
        L22:
            if ((th instanceof PluginClassNotFoundException) == false) goto L24;
            throw th;
        L24:
            if ((th instanceof ClassNotFoundException) == true) goto L30;
            if ((th instanceof NoClassDefFoundError) == true) goto L30;
            throw th;
        L30:
            return MiraPluginFix.forName("com.ss.videoarch.live.LiveIOManager");
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r110) {
            super.handleMessage(r110);
            if (r110 != null) goto L6;
            return;
        L6:
            switch(r110.what) {
                case 1025: goto L32;
                case 1026: goto L29;
                case 1027: goto L13;
                case 1028: goto L12;
                case 1029: goto L11;
                case 1030: goto L8;
                default: goto L223;
            };
        L8:
            e r111 = this.f458579a.f458576v;
            if (r111 == null) goto L179;
            r111.c(405, null);
            return;
        L179:
            return;
        L11:
            this.f458579a.f458556b.n(1157, CastLongProtector.valueOf(String.valueOf(r110.obj)).longValue());
            return;
        L12:
            this.f458579a.f458556b.n(1156, CastLongProtector.valueOf(String.valueOf(r110.obj)).longValue());
            return;
        L13:
            this.f458579a.getClass();
            String r112 = "::";
            ConnectivityManager r100 = (ConnectivityManager) b.f458554x.getSystemService("connectivity");     // Catch: Throwable -> L25
            Iterator<LinkAddress> r101 = r100.getLinkProperties(r100.getActiveNetwork()).getLinkAddresses().iterator();     // Catch: Throwable -> L25
        L16:
            if (r101.hasNext() == false) goto L27;
            LinkAddress r102 = r101.next();     // Catch: Throwable -> L25
            if ((r102.getAddress() instanceof Inet6Address) == false) goto L16;
            if (r102.getAddress().isLoopbackAddress() == true) goto L16;
            if (r102.getAddress().isLinkLocalAddress() == true) goto L16;
            r102.getAddress().toString();     // Catch: Throwable -> L25
            r112 = r102.getAddress().toString();     // Catch: Throwable -> L25
        L27:
            this.f458579a.f458556b.o(DataLoaderHelper.DATALOADER_KEY_INT_FILE_EXTEND_SIZE, r112);
            return;
        L25:
            th = move-exception;
            th.printStackTrace();
            goto L27
        L32:
            Object r113 = this.f458579a.f458555a;
            monitor-enter(r113);
        L176:
            th = move-exception;
            throw th;
        L35:
            boolean r103 = false;
            if (this.f458579a.f458556b == null) goto L189;
        L47:
            monitor-exit(r113);     // Catch: Throwable -> L176
            b r114 = this.f458579a;
            int r104 = -1;
            if (r114.f458556b != null) goto L187;
        L70:
            if (r104 != 0) goto L173;
            String r115 = b.f458554x.getFilesDir().getAbsolutePath();
            this.f458579a.f458566l = r115 + "/lspullstream.scfg";
            b r116 = f.f458578a;
            if (r116.f458556b.e() == false) goto L183;
        L130:
            r103 = true;
        L132:
            if (r103 == false) goto L219;
            Context r117 = b.f458554x;
            if (r117 != null) goto L136;
        L169:
            this.f458579a.f458564j.sendMessageDelayed(this.f458579a.f458564j.obtainMessage(1027), 0);
            b r118 = this.f458579a;
            if (r118.f458567m <= 0) goto L172;
            r118.f458564j.postDelayed(new j(this.f458579a, f.f458578a), 10000);
        L172:
            h r119 = this.f458579a.f458564j;
            r119.sendMessage(r119.obtainMessage(1030));
            return;
        L136:
            if (ContextCompat.checkSelfPermission(r117, "android.permission.ACCESS_NETWORK_STATE") == 0) goto L138;
            return;
        L138:
            Context r120 = b.f458554x;
            a r105 = this.f458579a.f458572r;
            IntentFilter r106 = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
            if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L204;
            ReceiverRegisterCrashOptimizer.doHWReceiverFix();
        L204:
        L164:
            e = move-exception;
            e.toString();
            e.printStackTrace();
            if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L168;
            ReceiverRegisterCrashOptimizer.registerReceiver(r105, r106);
            goto L169
        L168:
            throw e;
        L142:
            if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L155;
            if (ReceiverRegisterAnrOptimizer.hasScreenActions(r106) == false) goto L155;
            int r107 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r105, r106, 0, null, null, 2, r120).result;     // Catch: Exception -> L164
            if (r107 != 1) goto L148;
            r120.registerReceiver(r105, r106);     // Catch: Exception -> L164
        L203:
            goto L169
        L148:
            if (r107 != 2) goto L150;
            new Intent();     // Catch: Exception -> L164
            goto L203
        L150:
            if (r107 == 3) goto L203;
            r120.registerReceiver(r105, r106);     // Catch: Exception -> L164
        L155:
            if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L158;
            ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L164
            r120.registerReceiver(r105, r106, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L164
            goto L203
        L158:
            if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L160;
        L162:
            r120.registerReceiver(r105, r106);     // Catch: Exception -> L164
            goto L203
        L160:
            if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r106) == false) goto L162;
            ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L164
            ContextCompat.registerReceiver(r120, r105, r106, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L164
            goto L203
        L219:
            return;
        L183:
            JSONObject r108 = new JSONObject(r116.f458562h);     // Catch: JSONException -> L131
            JSONObject r121 = new JSONObject(r108.optString("ttquic_engine_config", SliceInitService.DEFAULT_SWITCH));     // Catch: JSONException -> L131
            if (r121.optInt("ttquic_use_lsengine", 0) != 1) goto L77;
            JSONObject r109 = new JSONObject(r121.optString("ttquic_lsengine_params", SliceInitService.DEFAULT_SWITCH));     // Catch: JSONException -> L131
            r109.put("SCFGPath", r116.f458566l);     // Catch: JSONException -> L131
            r121.put("ttquic_lsengine_params", r109.toString());     // Catch: JSONException -> L131
            r108.put("ttquic_engine_config", r121.toString());     // Catch: JSONException -> L131
            r116.f458562h = r108.toString();     // Catch: JSONException -> L131
        L77:
            r116.f458556b.j(r116.f458562h);
            r116.f458556b.m(2000, r116.f458573s);
            r116.f458556b.m(2001, r116.f458574t);
            r116.f458556b.m(2002, r116.f458576v);
            r116.f458556b.m(2003, r116.f458575u);
            if (r116.f458568n != 1) goto L82;
            PthreadHandlerThreadV2 r122 = r116.f458565k;
            if (r122 == null) goto L82;
            Looper r123 = r122.getLooper();
        L84:
            if (r116.f458556b.q(r123) != 0) goto L132;
            int r124 = b.a();
            if (r116.f458570p != 1) goto L129;
            i r125 = new i(r116);
            r116.f458571q = r125;
        L107:
            th = move-exception;
            th.printStackTrace();
        L109:
            i r126 = r116.f458571q;
            r126.getClass();
        L127:
            th = move-exception;
            th.printStackTrace();
        L117:
            th = move-exception;
            th.printStackTrace();     // Catch: Throwable -> L127
        L119:
            if (r103 == false) goto L129;
            r126.f458580a.requestNetwork(new NetworkRequest.Builder().addTransportType(1).addCapability(12).build(), new com.ss.videoarch.live.d(r126));     // Catch: Throwable -> L124
        L124:
            th = move-exception;
            th.printStackTrace();     // Catch: Throwable -> L127
            goto L129
        L111:
            if (Build.VERSION.SDK_INT >= 24) goto L114;
        L193:
        L114:
            if (r126.f458580a == null) goto L193;
            r103 = true;
        L96:
            th = move-exception;
            th.printStackTrace();     // Catch: Throwable -> L107
        L98:
            boolean r127 = false;
        L99:
            if (r127 == false) goto L109;
            r125.f458580a.requestNetwork(new NetworkRequest.Builder().addTransportType(0).addCapability(12).build(), new com.ss.videoarch.live.c(r125));     // Catch: Throwable -> L104
        L104:
            th = move-exception;
            th.printStackTrace();     // Catch: Throwable -> L107
            goto L109
        L90:
            if (Build.VERSION.SDK_INT >= 24) goto L93;
        L195:
        L93:
            if (r125.f458580a == null) goto L195;
            r127 = true;
        L129:
            r116.f458556b.l(1005, r124);
            LiveStrategyManager.inst().setIFunctionCalledByStrategyEngine(new g());
        L82:
            r123 = null;
            goto L84
        L173:
            b r128 = this.f458579a;
            int r129 = r128.f458560f + 1;
            r128.f458560f = r129;
            if (r129 > r128.f458559e) goto L221;
            r128.f458564j.sendEmptyMessageDelayed(1025, r128.f458557c);
            return;
        L221:
            return;
        L187:
            rmc.b r130 = r114.f458563i;     // Catch: Exception -> L67
            if (r130 != null) goto L53;
        L55:
            boolean r131 = false;
        L56:
            rmc.c.f538621b = r131;     // Catch: Exception -> L67
            String r132 = (String) this.f458579a.f458563i.getSettingsValueForKey("io_lib_name", "avio");     // Catch: Exception -> L67
            rmc.c r133 = this.f458579a.f458561g;     // Catch: Exception -> L67
            int r134 = rmc.c.b(r132);     // Catch: Exception -> L67
            b r135 = this.f458579a;     // Catch: Exception -> L65
            int r136 = r135.f458569o;     // Catch: Exception -> L65
            if (r136 == 0) goto L62;
            if (r136 == 1) goto L61;
        L63:
            rmc.c r137 = this.f458579a.f458561g;     // Catch: Exception -> L65
            r104 = rmc.c.b("liveio");     // Catch: Exception -> L65
            goto L70
        L61:
            if (r135.f458563i.getSettingsValueForKey("ttquic_engine_config", SliceInitService.DEFAULT_SWITCH) == SliceInitService.DEFAULT_SWITCH) goto L63;
        L62:
            rmc.c r138 = this.f458579a.f458561g;     // Catch: Exception -> L65
            rmc.c.b("vcbasekit");     // Catch: Exception -> L65
            rmc.c r139 = this.f458579a.f458561g;     // Catch: Exception -> L65
            r134 = rmc.c.b("ttquic");     // Catch: Exception -> L65
        L65:
            Exception e100 = e;
            r104 = r134;
        L69:
            e100.printStackTrace();
            goto L70
        L53:
            if (((Integer) r130.getSettingsValueForKey("liveio_use_system_loadlibrary", 0)).intValue() != 1) goto L55;
            r131 = true;
        L67:
            e = move-exception;
            e100 = e;
            goto L69
        L189:
            Constructor r140 = a().getConstructor(new Class[0]);     // Catch: Throwable -> L40
            this.f458579a.f458556b = (com.ss.videoarch.live.a) r140.newInstance(new Object[0]);     // Catch: Throwable -> L40
        L43:
            com.ss.videoarch.live.a r141 = this.f458579a.f458556b;     // Catch: Throwable -> L176
        L40:
            th = move-exception;
            th.printStackTrace();     // Catch: Throwable -> L44
        L44:
            th = move-exception;
            com.ss.videoarch.live.a r142 = this.f458579a.f458556b;     // Catch: Throwable -> L176
            throw th;     // Catch: Throwable -> L176
        L223:
            return;
        L29:
            if (r110.obj != null) goto L31;
            return;
        L31:
            this.f458579a.getClass();
            this.f458579a.f458556b.l(1005, b.a());
            this.f458579a.f458564j.removeMessages(1027);
            Message r143 = this.f458579a.f458564j.obtainMessage(1027);
            b r144 = this.f458579a;
            r144.f458564j.sendMessageDelayed(r143, r144.f458558d);
        }

        public h(b r100, Looper r101) {
            this.f458579a = r100;
            super(r101);
        }
    }

    public class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ConnectivityManager f458580a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f458581b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f458582c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f458583d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ b f458584e;

        public i(b r100) {
            this.f458584e = r100;
            this.f458581b = 0;
            this.f458582c = 0;
            this.f458583d = 0;
            this.f458580a = (ConnectivityManager) b.f458554x.getSystemService("connectivity");
        }

        public static void a(i r100, long r101) {
            if (r100.f458584e.f458564j == null) goto L6;
            Message r102 = new Message();
            r102.what = 1028;
            r102.obj = Long.valueOf(r101);
            r100.f458584e.f458564j.sendMessage(r102);
            return;
        }

        public static void b(i r100, long r101) {
            if (r100.f458584e.f458564j == null) goto L6;
            Message r102 = new Message();
            r102.what = 1029;
            r102.obj = Long.valueOf(r101);
            r100.f458584e.f458564j.sendMessage(r102);
            return;
        }
    }

    public class j implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<b> f458585a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f458586b;

        public final void b() {
            b r100 = this.f458585a.get();
            if (r100 != null) goto L5;
            return;
        L5:
            if (r100.f() == false) goto L31;
            JSONObject r101 = new JSONObject();
            Runtime r102 = Runtime.getRuntime();     // Catch: Exception -> L21
            ActivityManager.MemoryInfo r103 = new ActivityManager.MemoryInfo();     // Catch: Exception -> L21
            ActivityManager r104 = (ActivityManager) b.f458554x.getSystemService("activity");     // Catch: Exception -> L21
            if (r104 == null) goto L11;
            r104.getMemoryInfo(r103);     // Catch: Exception -> L21
        L11:
            Intent r105 = a(b.f458554x, new IntentFilter("android.intent.action.BATTERY_CHANGED"));     // Catch: Exception -> L21
            int r106 = 0;
            if (r105 == null) goto L14;
            int r107 = r105.getIntExtra(IPerformanceStrategyManager.KEY_FLOAT_TEMPERATURE, 0) / 10;     // Catch: Exception -> L21
        L15:
            BatteryManager r108 = (BatteryManager) b.f458554x.getSystemService("batterymanager");     // Catch: Exception -> L21
            if (r108 == null) goto L18;
            r106 = r108.getIntProperty(4);     // Catch: Exception -> L21
            int r109 = r108.getIntProperty(6);     // Catch: Exception -> L21
        L19:
            JSONObject r110 = new JSONObject();     // Catch: Exception -> L21
            r110.put(TypeDeviceFeaturesCollector.BATTERY_PERCENTAGE, r106);     // Catch: Exception -> L21
            r110.put(TypeDeviceFeaturesCollector.BATTERY_TEMPERATURE, r107);     // Catch: Exception -> L21
            r110.put(TypeDeviceFeaturesCollector.BATTERY_STATUS, r109);     // Catch: Exception -> L21
            r101.put("DEVICE-Battery", r110);     // Catch: Exception -> L21
            JSONObject r111 = new JSONObject();     // Catch: Exception -> L21
            r111.put("sys_total_mem", r103.totalMem);     // Catch: Exception -> L21
            r111.put("sys_avail_mem", r103.availMem);     // Catch: Exception -> L21
            r111.put("sys_low_mem_flag", r103.lowMemory ? 1 : 0);     // Catch: Exception -> L21
            r111.put("app_max_mem", r102.maxMemory());     // Catch: Exception -> L21
            r111.put("app_total_mem", r102.totalMemory());     // Catch: Exception -> L21
            r111.put("app_free_mem", r102.freeMemory());     // Catch: Exception -> L21
            r101.put("DEVICE-Memory", r111);     // Catch: Exception -> L21
        L24:
            if (r101.length() == 0) goto L26;
            r100.f458556b.o(1136, r101.toString());
        L26:
            r100.f458564j.postDelayed(new j(this.f458586b, r100), r100.f458567m);
            return;
        L18:
            r109 = 0;
            goto L19
        L14:
            r107 = 0;
        L21:
            e = move-exception;
            e.toString();
            goto L24
        }

        @Override // java.lang.Runnable
        public final void run() {
            b();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public j(b r100, b r101) {
            this.f458586b = r100;
            this.f458585a = new WeakReference(r101);
        }

        @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
        public static Intent a(Context r100, IntentFilter r110) {
            if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L42;
            ReceiverRegisterCrashOptimizer.doHWReceiverFix();
        L42:
        L36:
            e = move-exception;
            e.toString();
            e.printStackTrace();
            if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L40;
            throw e;
        L40:
            return ReceiverRegisterCrashOptimizer.registerReceiver(null, r110);
        L7:
            if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
            if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L25;
            ReceiverRegisterAnrOptimizer.ResultWrapper r101 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(null, r110, 0, null, null, 2, r100);     // Catch: Exception -> L36
            int r102 = r101.result;     // Catch: Exception -> L36
            if (r102 == 1) goto L23;
            if (r102 == 2) goto L21;
            if (r102 == 3) goto L19;
            return r100.registerReceiver(null, r110);
        L19:
            return r101.intent;
        L21:
            return new Intent();
        L23:
            return r100.registerReceiver(null, r110);
        L25:
            if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L29;
            ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L36
            return r100.registerReceiver(null, r110, null, ReceiverRegisterLancet.sReceiverHandler);
        L29:
            if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() == null) goto L35;
            if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r110) == false) goto L35;
            ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L36
            return ContextCompat.registerReceiver(r100, null, r110, null, ReceiverRegisterLancet.sProxyHandler, 2);
        L35:
            return r100.registerReceiver(null, r110);
        }
    }

    public static int a() {
        NetworkInfo r100 = ((ConnectivityManager) f458554x.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Throwable -> L25
        if (r100 != null) goto L6;
        return -1;
    L6:
        if (r100.isConnected() == false) goto L31;
        int r101 = r100.getType();     // Catch: Throwable -> L25
        if (r101 == 0) goto L13;
        if (r101 != 1) goto L32;
        return 0;
    L32:
        return -1;
    L13:
        int r102 = r100.getSubtype();     // Catch: Throwable -> L25
        if (r102 == 20) goto L23;
        switch(r102) {
            case 1: goto L21;
            case 2: goto L21;
            case 3: goto L19;
            case 4: goto L21;
            case 5: goto L19;
            case 6: goto L19;
            case 7: goto L21;
            case 8: goto L19;
            case 9: goto L19;
            case 10: goto L19;
            case 11: goto L21;
            case 12: goto L19;
            case 13: goto L18;
            case 14: goto L19;
            case 15: goto L19;
            default: goto L33;
        };
    L18:
        return 1;
    L19:
        return 3;
    L21:
        return 2;
    L33:
        return -1;
    L23:
        return 4;
    L31:
        return -1;
    L25:
        th = move-exception;
        th.printStackTrace();
        return -1;
    }

    public final boolean f() {
        Object r100 = this.f458555a;
        monitor-enter(r100);
        com.ss.videoarch.live.a r101 = this.f458556b;     // Catch: Throwable -> L12
        if (r101 != null) goto L9;
        monitor-exit(r100);     // Catch: Throwable -> L12
        return false;
    L9:
        monitor-exit(r100);     // Catch: Throwable -> L12
        return r101.e();
    L12:
        th = move-exception;
        throw th;
    }

    public b() {
        this.f458555a = new Object();
        this.f458556b = null;
        this.f458557c = 5000;
        this.f458558d = 1500;
        this.f458559e = 10;
        this.f458560f = 0;
        this.f458561g = new rmc.c();
        this.f458562h = null;
        this.f458563i = null;
        this.f458564j = null;
        this.f458565k = null;
        this.f458567m = 0;
        this.f458568n = 0;
        this.f458569o = 0;
        this.f458570p = 1;
        this.f458572r = new a(this);
        this.f458573s = new C5510b();
        this.f458574t = new c();
        this.f458575u = new d();
        this.f458576v = new e();
    }

    public static b b() {
        return f.f458578a;
    }

    public final long c(int r100) {
        if (f() == true) goto L5;
        return -1;
    L5:
        return this.f458556b.a(r100);
    }

    public final long d(String r100, int r101) {
        if (f() == true) goto L5;
        return -1;
    L5:
        return this.f458556b.b(r100, r101);
    }

    public final String e(String r100, int r101) {
        if (f() == true) goto L5;
        return null;
    L5:
        return this.f458556b.d(r100, r101);
    }

    public final void g(int r100, String r101, long r102) {
        if (f() == false) goto L6;
        this.f458556b.k(r100, r101, r102);
        return;
    }
}
