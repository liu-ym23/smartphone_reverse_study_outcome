package com.bytedance.android.livesdk.log;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livehostapi.TTMiddlewareLiveSDK;
import com.bytedance.android.livesdk.ability.LiveLoggerScheduleAtomicAbility;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveAppLoggerConfig;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.performance.task.AtlasAsyncDegradeCallback;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.performance.task.AtlasAsyncExecutor;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.performance.task.AtlasAsyncExtKt;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.bpea.entry.api.device.info.TelephonyManagerEntry;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.StringUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class j0 implements g {
    public static final TokenCert c = null;
    public static String d;
    public static ExecutorService e;
    public static volatile j0 f;
    public ILoggerLifeManagerService a;
    public ObservableEmitter<d> b;

    public class a implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ Map b;
        public final /* synthetic */ Object[] c;
        public final /* synthetic */ j0 d;

        @Override // java.lang.Runnable
        public final void run() {
            j0.j(this.d, this.a, this.b, this.c);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(j0 r1, String r2, Map r3, Object[] r4) {
            this.d = r1;
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public class b implements AtlasAsyncDegradeCallback {
        public final /* synthetic */ String a;
        public final /* synthetic */ Map b;
        public final /* synthetic */ Object[] c;
        public final /* synthetic */ j0 d;

        public class a implements Runnable {
            public final /* synthetic */ b a;

            @Override // java.lang.Runnable
            public final void run() {
                b r0 = this.a;     // Catch: Throwable -> L4
                j0.j(r0.d, r0.a, r0.b, r0.c);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public a(b r1) {
                this.a = r1;
            }
        }

        public void call() {
            ExecutorService r0 = j0.e;
            if (r0 != null) goto L6;
            if (r0 != null) goto L6;
            j0.e = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("MiddlewareLiveLogger"));
        L6:
            ExecutorService r1 = j0.e;
            if (r1 == null) goto L9;
            r1.submit(new a(this));
            return;
        L9:
            j0.j(this.d, this.a, this.b, this.c);
        }

        public b(j0 r1, String r2, Map r3, Object[] r4) {
            this.d = r1;
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static /* synthetic */ class c {
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

    public static class d {
        public final String a;
        public final Map<String, String> b;

        public d(String r1, Map<String, String> r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
        c = TokenCert.with("bpea-livelogger_get_network_type");
        d = BDLocationException.ERROR_TIMEOUT;
    }

    public static String k() {
        TokenCert r0 = c;
        int[] r1 = c.a;
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
        if (TTMiddlewareLiveSDK.hostMiddlewareService().config().appConfig().isFreeFlow() == false) goto L39;
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

    public static j0 l() {
        if (f != null) goto L16;
        monitor-enter(g.class);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (f != null) goto L9;
        f = new j0();     // Catch: Throwable -> L12
    L9:
        j0 r1 = f;     // Catch: Throwable -> L12
        monitor-exit(g.class);     // Catch: Throwable -> L12
        return r1;
    L16:
        return f;
    }

    @Override // com.bytedance.android.livesdk.log.g
    public final Map<Object, com.bytedance.android.livesdk.log.filter.v> getSendLogFilter() {
        ILoggerLifeManagerService r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getSendLogFilter();
    }

    public j0() {
        this.a = null;
        this.a = (ILoggerLifeManagerService) jc1.k.f(ILoggerLifeManagerService.class);
        Observable.create(new g0(this)).observeOn(Schedulers.io()).subscribe(new h0(this), new i0());
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
        ILoggerLifeManagerService r0 = this.a;
        if (r0 != null) goto L5;
    L10:
        ILoggerLifeManagerService r1 = this.a;
        if (r1 != null) goto L13;
        return null;
    L13:
        if (r1.getFakeTempMap() != null) goto L15;
        return null;
    L15:
        if (this.a.getFakeTempMap().containsKey(r2) == true) goto L17;
        return null;
    L17:
        return this.a.getFakeTempMap().get(r2);
    L5:
        if (r0.getMap() == null) goto L10;
        if (this.a.getMap().containsKey(r2) == false) goto L10;
        return this.a.getMap().get(r2);
    }

    @Override // com.bytedance.android.livesdk.log.g
    public final com.bytedance.android.livesdk.log.filter.v removeSendLogFilter(Object r2) {
        ILoggerLifeManagerService r0 = this.a;
        if (r0 != null) goto L6;
        return null;
    L6:
        com.bytedance.android.livesdk.log.filter.v r3 = r0.removeSendLogFilter(r2);
        if (r3 == null) goto L9;
        r3.onRemove();
    L9:
        return r3;
    }

    public static /* synthetic */ void i(j0 r1, d r2) {
        r1.getClass();
        if (r2 == null) goto L6;
        r1.m(r2.a, r2.b);
        return;
    }

    private void m(String r2, Map<String, String> r3) {
        if (StringUtils.isEmpty(r2) == false) goto L5;
        return;
    L5:
        if (this.a == null) goto L14;
        r3 = x.a(r2, r3);     // Catch: Exception -> L10
    L8:
        this.a.onSendAppLog(r2, r3);
        this.a.afterSendAppLog(r2, r3);
        return;
    }

    @Override // com.bytedance.android.livesdk.log.g
    public final boolean addSendLogFilter(Object r2, com.bytedance.android.livesdk.log.filter.v r3) {
        ILoggerLifeManagerService r0 = this.a;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.addSendLogFilter(r2, r3);
    }

    @Override // com.bytedance.android.livesdk.log.g
    public final void d(String r2, Object... r3) {
        sendLog(r2, null, r3);
    }

    @Override // com.bytedance.android.livesdk.log.g
    public final <T> void register(Class<? extends T> r2, com.bytedance.android.livesdk.log.filter.o<? extends T> r3) {
        ILoggerLifeManagerService r0 = this.a;
        if (r0 == null) goto L6;
        r0.register(r2, r3);
        return;
    }

    @Override // com.bytedance.android.livesdk.log.g
    public final void e(String r7, Map r8, Object... r9) {
        n(r7, false, false, r8, r9);
    }

    @Override // com.bytedance.android.livesdk.log.g
    public final void f(String r7, Map<String, String> r8, Object... r9) {
        n(r7, true, true, r8, r9);
    }

    @Override // com.bytedance.android.livesdk.log.g
    public final void h(String r7, Map<String, String> r8, Object... r9) {
        n(r7, false, false, r8, r9);
    }

    public final void o(String r4, Map<String, String> r5, Object... r6) {
        AtlasAsyncExtKt.executeTask(AtlasAsyncExecutor.INSTANCE, "MiddlewareLiveLogger", new a(this, r4, r5, r6), new b(this, r4, r5, r6));
    }

    @Override // com.bytedance.android.livesdk.log.g
    public final void sendLog(String r10, Map<String, String> r11, Object... r12) {
        if (r11 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L10;
        r11.remove("escape_prefix_check");
    L10:
        n(r10, !r2, false, r11, r12);
        return;
    L5:
        if (r11.containsKey("escape_prefix_check") == false) goto L7;
        r2 = true;
        goto L8
    }

    public static /* synthetic */ void j(j0 r6, String r7, Map r8, Object[] r9) {
        r6.n(r7, true, false, r8, r9);
    }

    private void n(String r3, boolean r4, boolean r5, Map<String, String> r6, Object... r7) {
        ILoggerLifeManagerService r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        String r8 = r0.onChangeEventName(r4, r3);
        LiveAppLoggerConfig.Companion r9 = LiveAppLoggerConfig.Companion;     // Catch: Exception -> L30
        if (r9.getConfig().getEnablePreDrop() == false) goto L14;
        Set r10 = r9.getConfig().getPreDropEventsWhiteSet();     // Catch: Exception -> L30
        boolean r1 = true;
        if (r10 != null) goto L11;
    L15:
        if (r1 == false) goto L20;
        if (this.a.needDropEventBySampling(r8) == false) goto L20;
        return;
    L20:
        if (LiveLoggerScheduleAtomicAbility.INSTANCE.filterLiveLoggerSchedule(r8) == false) goto L22;
        return;
    L22:
        HashMap r11 = new HashMap();
        this.a.beforeExecuteLogFilter(r11);
        this.a.onExecuteLogFilter(r6, r11, r7);
        this.a.afterExecuteLogFilter();
        this.a.beforeSendAppLog(r8, r11);
        if (r5 == false) goto L28;
        ObservableEmitter<d> r12 = this.b;
        if (r12 == null) goto L27;
        r12.onNext(new d(r8, r11));
        return;
    L27:
        m(r8, r11);
        return;
    L28:
        m(r8, r11);
        return;
    L11:
        if (r10.size() <= 0) goto L15;
        r1 = true ^ r10.contains(r8);
    L14:
        r1 = false;
        goto L15
    }

    @Override // com.bytedance.android.livesdk.log.g
    public final void g(String r1, boolean r2, boolean r3, Map<String, String> r4, Object... r5) {
        n(r1, r2, r3, r4, r5);
    }
}
