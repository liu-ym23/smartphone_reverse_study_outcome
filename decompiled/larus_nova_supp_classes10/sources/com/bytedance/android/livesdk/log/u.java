package com.bytedance.android.livesdk.log;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.initialize.LiveWTO;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livehostapi.platform.IHostLog;
import com.bytedance.android.livesdk.config.ju0;
import com.bytedance.android.livesdk.config.oi1;
import com.bytedance.android.livesdk.config.pe;
import com.bytedance.android.livesdk.config.rk0;
import com.bytedance.android.livesdk.log.filter.p0;
import com.bytedance.android.livesdk.log.filter.q0;
import com.bytedance.android.livesdk.log.filter.r0;
import com.bytedance.android.livesdk.log.filter.s0;
import com.bytedance.android.livesdk.log.filter.u0;
import com.bytedance.android.livesdk.log.filter.v0;
import com.bytedance.android.livesdk.log.filter.w0;
import com.bytedance.android.livesdk.log.filter.x0;
import com.bytedance.android.livesdk.log.model.FollowLog;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.PadLoggerData;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.logsdk.format.Spm;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.bpea.entry.api.device.info.TelephonyManagerEntry;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.StringUtils;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class u implements g {
    public static final TokenCert g = null;
    public static String h;
    public static volatile g i;
    public static boolean j;
    public static boolean k;
    public static ExecutorService l;
    public static final boolean m = false;
    public final Map<Class, com.bytedance.android.livesdk.log.filter.o> a;
    public final Set<String> b;
    public final Map<Object, com.bytedance.android.livesdk.log.filter.v> c;
    public Disposable d;
    public ObservableEmitter<b> e;
    public boolean f;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[NetworkUtils.NetworkType.values().length];
            a = r0;
            r0[NetworkUtils.NetworkType.MOBILE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            a[NetworkUtils.NetworkType.MOBILE_2G.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            a[NetworkUtils.NetworkType.MOBILE_3G.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            a[NetworkUtils.NetworkType.MOBILE_4G.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            a[NetworkUtils.NetworkType.WIFI.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public static class b {
        public final String a;
        public final Map<String, String> b;

        public b(String r1, Map<String, String> r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
        g = TokenCert.with("bpea-livelogger_get_network_type");
        h = BDLocationException.ERROR_TIMEOUT;
        j = false;
        k = false;
        m = true;
    }

    public static void i() {
        if (j == true) goto L8;
        if (k == true) goto L8;
        return;
    L8:
        if (l != null) goto L11;
        l = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("og/LiveLogger"));
        return;
    }

    public static boolean j() {
        if (j == false) goto L5;
    L8:
        return true;
    L5:
        if (k == true) goto L8;
        return false;
    }

    public static String k() {
        TokenCert r0 = g;
        int[] r1 = a.a;
        Context r2 = s1.getContext();
        NetworkInfo r4 = ((ConnectivityManager) r2.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Throwable -> L23
        if (r4 != null) goto L6;
    L21:
        NetworkUtils.NetworkType r3 = NetworkUtils.NetworkType.NONE;     // Catch: Throwable -> L23
    L41:
    L24:
        int r5 = r1[r3.ordinal()];
        if (r5 == 1) goto L37;
        if (r5 == 2) goto L37;
        if (r5 == 3) goto L37;
        if (r5 == 4) goto L37;
        if (r5 == 5) goto L35;
        return "none";
    L35:
        return LocationAnnotation.LightLocationType.LIGHT_LOCATION_WIFI;
    L37:
        if (TTLiveSDK.hostService().config().appConfig().isFreeFlow() == false) goto L39;
        return "free_card";
    L39:
        return "limited_data";
    L6:
        if (r4.isAvailable() == false) goto L21;
        int r6 = r4.getType();     // Catch: Throwable -> L23
        if (1 != r6) goto L11;
        r3 = NetworkUtils.NetworkType.WIFI;     // Catch: Throwable -> L23
        goto L41
    L11:
        if (r6 != 0) goto L20;
        Integer r7 = TelephonyManagerEntry.getNetworkType((TelephonyManager) r2.getSystemService("phone"), r0);     // Catch: Throwable -> L23
        if (r7 != null) goto L16;
        r3 = NetworkUtils.NetworkType.MOBILE;     // Catch: Throwable -> L23
        goto L41
    L16:
        switch(r7.intValue()) {
            case 3: goto L19;
            case 4: goto L17;
            case 5: goto L19;
            case 6: goto L19;
            case 7: goto L17;
            case 8: goto L19;
            case 9: goto L19;
            case 10: goto L19;
            case 11: goto L17;
            case 12: goto L19;
            case 13: goto L18;
            case 14: goto L19;
            case 15: goto L19;
            default: goto L17;
        };     // Catch: Throwable -> L23
    L17:
        r3 = NetworkUtils.NetworkType.MOBILE;     // Catch: Throwable -> L23
        goto L41
    L18:
        r3 = NetworkUtils.NetworkType.MOBILE_4G;     // Catch: Throwable -> L23
        goto L41
    L19:
        r3 = NetworkUtils.NetworkType.MOBILE_3G;     // Catch: Throwable -> L23
        goto L41
    L20:
        r3 = NetworkUtils.NetworkType.MOBILE;     // Catch: Throwable -> L23
    L23:
        r3 = NetworkUtils.NetworkType.MOBILE;
        goto L24
    }

    public static g l() {
        if (i != null) goto L19;
        monitor-enter(g.class);
    L15:
        th = move-exception;
        throw th;
    L7:
        if (i == null) goto L9;
    L12:
        g r1 = i;     // Catch: Throwable -> L15
        monitor-exit(g.class);     // Catch: Throwable -> L15
        return r1;
    L9:
        if (((Boolean) oi1.a.getValue()).booleanValue() == false) goto L11;
        i = j0.l();     // Catch: Throwable -> L15
        goto L12
    L11:
        i = new u();     // Catch: Throwable -> L15
        goto L12
    L19:
        return i;
    }

    public u() {
        this.a = new HashMap();
        HashSet r0 = new HashSet();
        this.b = r0;
        this.c = new HashMap();
        this.f = false;
        register(Room.class, new s0());
        register(IRoom.class, new s0());
        register(am2.d.class, new com.bytedance.android.livesdk.log.filter.e());
        register(am2.f0.class, new w0());
        register(am2.e0.class, new v0());
        register(am2.d0.class, new r0());
        register(FollowLog.class, new com.bytedance.android.livesdk.log.filter.h());
        register(am2.p.class, new com.bytedance.android.livesdk.log.filter.c0());
        register(am2.l.class, new com.bytedance.android.livesdk.log.filter.w());
        register(am2.b.class, new com.bytedance.android.livesdk.log.filter.c());
        register(com.bytedance.android.livesdk.log.filter.n.class, new com.bytedance.android.livesdk.log.filter.a0());
        com.bytedance.android.livesdk.log.filter.n0 r1 = new com.bytedance.android.livesdk.log.filter.n0();
        r1.c("event_page", "live_take_detail");
        register(am2.x.class, r1);
        register(am2.c.class, new com.bytedance.android.livesdk.log.filter.d());
        register(User.class, new x0());
        register(IBaseUser.class, new s0());
        register(am2.m.class, new com.bytedance.android.livesdk.log.filter.x());
        register(am2.a.class, new com.bytedance.android.livesdk.log.filter.b());
        register(am2.g.class, new com.bytedance.android.livesdk.log.filter.j());
        register(am2.h.class, new com.bytedance.android.livesdk.log.filter.k());
        register(am2.z.class, new p0());
        register(am2.y.class, new com.bytedance.android.livesdk.log.filter.o0());
        register(am2.u.class, new com.bytedance.android.livesdk.log.filter.i0());
        register(am2.q.class, new com.bytedance.android.livesdk.log.filter.d0());
        register(am2.t.class, new com.bytedance.android.livesdk.log.filter.h0());
        register(am2.r.class, new com.bytedance.android.livesdk.log.filter.e0());
        register(am2.n.class, new com.bytedance.android.livesdk.log.filter.z());
        register(am2.o.class, new com.bytedance.android.livesdk.log.filter.b0());
        register(PadLoggerData.class, new com.bytedance.android.livesdk.log.filter.m0());
        register(com.bytedance.android.livesdk.log.filter.y.class, new com.bytedance.android.livesdk.log.filter.g0());
        register(am2.s.class, new com.bytedance.android.livesdk.log.filter.f0());
        register(am2.w.class, new com.bytedance.android.livesdk.log.filter.l0());
        register(am2.c0.class, new q0());
        register(am2.i.class, new com.bytedance.android.livesdk.log.filter.l());
        register(am2.f.class, new com.bytedance.android.livesdk.log.filter.i());
        addSendLogFilter(u0.class, new u0());
        r0.add("livesdk_draw_room_bottom");
        r0.add("livesdk_show_next_room");
        this.d = Observable.create(new p(this)).observeOn(Schedulers.io()).subscribe(new q(this), new r());
        i();
        this.f = ((Boolean) pe.a.getValue()).booleanValue();
    }

    @Override // com.bytedance.android.livesdk.log.g
    public final Map<Object, com.bytedance.android.livesdk.log.filter.v> getSendLogFilter() {
        return this.c;
    }

    @Override // com.bytedance.android.livesdk.log.g
    public final void a(int r4) {
        HashMap r0 = new HashMap();
        if (r4 != 1) goto L5;
        r0.put("action_type", "click");
    L6:
        l().sendLog("livesdk_more_anchor_live_take_button", r0, new Object[0]);
        return;
    L5:
        r0.put("action_type", "show");
        goto L6
    }

    @Override // com.bytedance.android.livesdk.log.g
    public final void b(String r3) {
        sendLog(r3, null, new Object[0]);
    }

    @Override // com.bytedance.android.livesdk.log.g
    public final com.bytedance.android.livesdk.log.filter.o c(Class r2) {
        if (((HashMap) this.a).containsKey(r2) == true) goto L5;
        return null;
    L5:
        return (com.bytedance.android.livesdk.log.filter.o) ((HashMap) this.a).get(r2);
    }

    @Override // com.bytedance.android.livesdk.log.g
    public final com.bytedance.android.livesdk.log.filter.v removeSendLogFilter(Object r2) {
        com.bytedance.android.livesdk.log.filter.v r3 = (com.bytedance.android.livesdk.log.filter.v) ((HashMap) this.c).remove(r2);
        if (r3 == null) goto L5;
        r3.onRemove();
    L5:
        return r3;
    }

    public static void m(String r4, Map r5) {
        if (StringUtils.isEmpty(r4) == false) goto L5;
        return;
    L5:
        Map r6 = x.a(r4, r5);
        IHostLog r0 = jc1.k.f(IHostLog.class);
        if (m == false) goto L10;
        qm0.a r1 = om0.c.d();
        if (r1 == null) goto L12;
        r1.logV3(r4, r6);
    L12:
        ce1.d r2 = ce1.e.a;
        if (r2 == null) goto L16;
        r2.b();
    L16:
        if (jc1.k.f(IHostContext.class).isLocalTest() == false) goto L24;
        Spm r3 = Spm.obtain("a100.c100.d400");
        HashMap r7 = new HashMap();
        Iterator r8 = r6.entrySet().iterator();
    L19:
        if (r8.hasNext() == false) goto L21;
        Map.Entry r9 = (Map.Entry) r8.next();
        r7.put((String) r9.getKey(), r9.getValue());
        goto L19
    L21:
        r3.args(r7).businessId(r4).apply("tea_event");
        return;
    L24:
        return;
    L10:
        if (r0 == null) goto L12;
        r0.logV3(r4, r6);
        goto L12
    }

    @Override // com.bytedance.android.livesdk.log.g
    public final boolean addSendLogFilter(Object r2, com.bytedance.android.livesdk.log.filter.v r3) {
        if (((HashMap) this.c).containsKey(r2) == false) goto L6;
        return false;
    L6:
        ((HashMap) this.c).put(r2, r3);
        r3.Rd();
        return true;
    }

    @Override // com.bytedance.android.livesdk.log.g
    public final void d(String r2, Object... r3) {
        sendLog(r2, null, r3);
    }

    @Override // com.bytedance.android.livesdk.log.g
    public final <T> void register(Class<? extends T> r2, com.bytedance.android.livesdk.log.filter.o<? extends T> r3) {
        ((HashMap) this.a).put(r2, r3);
    }

    @Override // com.bytedance.android.livesdk.log.g
    public final void e(String r7, Map r8, Object... r9) {
        g(r7, false, false, r8, r9);
    }

    @Override // com.bytedance.android.livesdk.log.g
    public final void f(String r9, Map<String, String> r10, Object... r11) {
        if (this.f == false) goto L5;
        LiveWTO.INSTANCE.commitRepeatableTask(new y(r9, r10, r11));
        return;
    L5:
        g(r9, true, true, r10, r11);
    }

    @Override // com.bytedance.android.livesdk.log.g
    public final void h(String r7, Map<String, String> r8, Object... r9) {
        g(r7, false, false, r8, r9);
    }

    @Override // com.bytedance.android.livesdk.log.g
    public final void sendLog(String r10, Map<String, String> r11, Object... r12) {
        if (this.f == false) goto L6;
        LiveWTO.INSTANCE.commitRepeatableTask(new y(r10, r11, r12));
        return;
    L6:
        if (r11 != null) goto L8;
    L10:
        boolean r2 = false;
    L11:
        if (r2 == false) goto L13;
        r11.remove("escape_prefix_check");
    L13:
        g(r10, !r2, false, r11, r12);
        return;
    L8:
        if (r11.containsKey("escape_prefix_check") == false) goto L10;
        r2 = true;
        goto L11
    }

    @Override // com.bytedance.android.livesdk.log.g
    public final void g(String r10, boolean r11, boolean r12, Map<String, String> r13, Object... r14) {
        boolean r0 = this.f;
        if (r0 == false) goto L5;
    L8:
        if (r0 == false) goto L11;
        n(r10, r11, r12, r13, r14);
        return;
    L11:
        if (l != null) goto L13;
        i();
    L13:
        ExecutorService r1 = l;
        if (r1 == null) goto L16;
        r1.submit(new s(this, r10, r11, r12, r13, r14));
        return;
    L16:
        n(r10, r11, r12, r13, r14);
        return;
    L5:
        if (j == true) goto L8;
        n(r10, r11, r12, r13, r14);
    }

    public final void n(String r9, boolean r10, boolean r11, Map<String, String> r12, Object... r13) {
        HashMap r0 = new HashMap();
        boolean r4 = false;
        if (r9.startsWith("noLivePrefix") == false) goto L6;
        r9 = r9.split("noLivePrefix")[1];
        r10 = false;
    L6:
        if (((HashMap) this.a).containsKey(am2.d.class) == false) goto L9;
        ((com.bytedance.android.livesdk.log.filter.o) ((HashMap) this.a).get(am2.d.class)).a(r0);
    L9:
        if (((HashMap) this.a).containsKey(am2.i.class) == false) goto L11;
        ((com.bytedance.android.livesdk.log.filter.o) ((HashMap) this.a).get(am2.i.class)).a(r0);
    L11:
        if (r13 == null) goto L28;
        int r1 = r13.length;
        int r2 = 0;
    L13:
        if (r2 >= r1) goto L28;
        Object r5 = r13[r2];
        if (r5 == null) goto L27;
        if ((r5 instanceof Class) == false) goto L24;
        if (((HashMap) this.a).containsKey(r5) == false) goto L27;
        ((com.bytedance.android.livesdk.log.filter.o) ((HashMap) this.a).get(r5)).a(r0);
        goto L27
    L24:
        if (((HashMap) this.a).containsKey(r5.getClass()) == false) goto L27;
        ((com.bytedance.android.livesdk.log.filter.o) ((HashMap) this.a).get(r5.getClass())).u(r0, r5);
    L27:
        r2 = r2 + 1;
    L28:
        if (r12 != null) goto L30;
    L32:
        Map<String, String> r14 = n.a;
        Intrinsics.checkNotNullParameter(r0, "map");
        Map r15 = n.b();
        if (r15 == null) goto L35;
        r0.putAll(r15);
    L35:
        if (r10 == false) goto L40;
        if (r9.startsWith("livesdk_") == true) goto L40;
        r9 = "livesdk_".concat(r9);
    L40:
        if (r0.containsKey("_param_live_platform") == true) goto L42;
        r0.put("_param_live_platform", "live");
    L42:
        r0.put("sdk_version", String.valueOf(com.bytedance.android.livesdk.paas.c.b()));
        r0.put("room_orientation", h);
        Iterator r16 = ((HashMap) this.c).values().iterator();
    L44:
        if (r16.hasNext() == false) goto L46;
        ((com.bytedance.android.livesdk.log.filter.v) r16.next()).L9(r9, r0);
        goto L44
    L46:
        LocalTestManager.a(new Class[]{wy.a.class});
        if (r9.equals("livesdk_live_show") == false) goto L55;
        if (r0.containsKey("event_page") == false) goto L52;
        String r17 = (String) r0.get("event_page");
    L52:
        if (r0.containsKey("event_module") == false) goto L61;
        String r18 = (String) r0.get("event_module");
    L61:
        if (r0.containsKey("bypass_mapping") == false) goto L64;
        r4 = TextUtils.equals("true", (CharSequence) r0.get("bypass_mapping"));
    L64:
        if (((HashSet) this.b).contains(r9) == true) goto L68;
        if (r4 == true) goto L68;
        Map<String, String> r19 = e0.a;
    L68:
        if (((Boolean) ju0.a.getValue()).booleanValue() == false) goto L70;
    L71:
        String r110 = ee1.a.a;
        ee1.a.a(r9, r0, (com.bytedance.android.livesdk.log.filter.o) ((HashMap) this.a).get(Room.class));
    L72:
        boolean r111 = k;
        if (r111 == false) goto L88;
        if (r111 == true) goto L77;
        return;
    L77:
        if (l != null) goto L79;
        i();
    L79:
        ExecutorService r112 = l;
        if (r112 == null) goto L82;
        r112.submit(new t(this, r9, r0));
        return;
    L82:
        if (r11 == false) goto L87;
        ObservableEmitter<b> r113 = this.e;
        if (r113 == null) goto L86;
        r113.onNext(new b(r9, r0));
        return;
    L86:
        m(r9, r0);
        return;
    L87:
        m(r9, r0);
        return;
    L88:
        if (r11 == false) goto L93;
        ObservableEmitter<b> r114 = this.e;
        if (r114 == null) goto L92;
        r114.onNext(new b(r9, r0));
        return;
    L92:
        m(r9, r0);
        return;
    L93:
        m(r9, r0);
        return;
    L70:
        if (((Boolean) rk0.a.getValue()).booleanValue() == false) goto L72;
    L55:
        if (r0.containsKey("enter_from") == false) goto L58;
        String r115 = (String) r0.get("enter_from");
    L58:
        if (r0.containsKey("source") == false) goto L61;
        String r116 = (String) r0.get("source");
        goto L61
    L30:
        if (r12.size() <= 0) goto L32;
        r0.putAll(r12);
        goto L32
    }
}
