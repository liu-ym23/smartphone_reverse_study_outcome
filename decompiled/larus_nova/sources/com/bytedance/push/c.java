package com.bytedance.push;

import android.app.Application;
import com.bytedance.common.model.ClientDisplayFeature;
import com.bytedance.common.model.PushCommonConfiguration;
import com.bytedance.common.push.interfaze.IAccountService;
import com.bytedance.common.push.interfaze.IPushCommonConfiguration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class c {
    public static c O;
    public final boolean A;
    public final boolean B;
    public final com.bytedance.push.notification.c C;
    public final int[] D;
    public boolean E;
    public final boolean F;
    public final String G;
    public final v67.p H;
    public final boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final boolean f266760J;
    public final boolean K;
    public final IPushCommonConfiguration L;
    public final ClientDisplayFeature M;
    public volatile PushCommonConfiguration N;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Application f266761a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f266762b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f266763c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f266764d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f266765e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f266766f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f266767g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f266768h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f266769i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f266770j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final b f266771k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List<gfc.a> f266772l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final v67.e f266773m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.bytedance.push.notification.r f266774n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f266775o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final yfc.c f266776p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final v67.b f266777q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final v67.z f266778r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final z67.c f266779s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final String f266780t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final String f266781u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f266782v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final IAccountService f266783w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final b77.a f266784x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final boolean f266785y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final long f266786z;

    public static class a {
        public int[] A;
        public v67.p B;
        public boolean C;
        public boolean D;
        public String E;
        public boolean F;
        public boolean G;
        public boolean H;
        public boolean I;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        public IPushCommonConfiguration f266787J;
        public ClientDisplayFeature K;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Application f266788a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f266789b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f266790c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f266791d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public b f266792e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public List<gfc.a> f266793f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public v67.e f266794g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final String f266795h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f266796i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public yfc.c f266797j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public v67.b f266798k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public t67.a f266799l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public v67.z f266800m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public z67.c f266801n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public v67.b0 f266802o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final com.bytedance.push.a f266803p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public String f266804q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public String f266805r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public boolean f266806s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public IAccountService f266807t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public b77.a f266808u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public boolean f266809v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public long f266810w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public v67.l f266811x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public v67.d f266812y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public e87.a f266813z;

        public final void a(String r100) {
            if (this.f266789b == true) goto L7;
            com.bytedance.push.utils.f.e("init", r100);
            return;
        L7:
            throw new IllegalArgumentException(r100);
        }

        public a(Application r100, com.bytedance.push.a r101, String r102) {
            this.f266790c = 3;
            this.f266793f = new ArrayList();
            this.f266810w = TimeUnit.MINUTES.toMillis(2);
            this.D = true;
            this.G = false;
            this.H = false;
            this.I = true;
            this.f266788a = r100;
            this.f266803p = r101;
            this.f266795h = r102;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f266814a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f266815b;

        public b(String r100) {
            this.f266814a = r100;
            this.f266815b = "push";
        }
    }

    public final PushCommonConfiguration a() {
        if (this.N != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.N != null) goto L8;
        this.N = new PushCommonConfiguration();     // Catch: Throwable -> L10
        PushCommonConfiguration r100 = this.N;     // Catch: Throwable -> L10
        r100.mApplication = this.f266761a;     // Catch: Throwable -> L10
        PushCommonConfiguration r101 = this.N;     // Catch: Throwable -> L10
        r101.mAid = this.f266762b;     // Catch: Throwable -> L10
        PushCommonConfiguration r102 = this.N;     // Catch: Throwable -> L10
        r102.mHost = this.f266775o;     // Catch: Throwable -> L10
        PushCommonConfiguration r103 = this.N;     // Catch: Throwable -> L10
        r103.mVersionCode = this.f266763c;     // Catch: Throwable -> L10
        PushCommonConfiguration r104 = this.N;     // Catch: Throwable -> L10
        r104.mUpdateVersionCode = this.f266764d;     // Catch: Throwable -> L10
        PushCommonConfiguration r105 = this.N;     // Catch: Throwable -> L10
        r105.mVersionName = this.f266765e;     // Catch: Throwable -> L10
        PushCommonConfiguration r106 = this.N;     // Catch: Throwable -> L10
        r106.mAppName = this.f266770j;     // Catch: Throwable -> L10
        PushCommonConfiguration r107 = this.N;     // Catch: Throwable -> L10
        r107.mChannel = this.f266768h;     // Catch: Throwable -> L10
        this.N.getClass();     // Catch: Throwable -> L10
        PushCommonConfiguration r108 = this.N;     // Catch: Throwable -> L10
        r108.mI18nCommonParams = this.f266777q;     // Catch: Throwable -> L10
        PushCommonConfiguration r109 = this.N;     // Catch: Throwable -> L10
        r109.mEnableRealTimeReportEvent = this.A;     // Catch: Throwable -> L10
        PushCommonConfiguration r110 = this.N;     // Catch: Throwable -> L10
        r110.mIsDebugMode = this.f266766f;     // Catch: Throwable -> L10
        PushCommonConfiguration r111 = this.N;     // Catch: Throwable -> L10
        r111.mIPushCommonEventSender = this.f266773m;     // Catch: Throwable -> L10
        PushCommonConfiguration r112 = this.N;     // Catch: Throwable -> L10
        r112.mIsThroughMsgEncrypt = this.f266760J;     // Catch: Throwable -> L10
        PushCommonConfiguration r113 = this.N;     // Catch: Throwable -> L10
        r113.mEnableAlog = this.F;     // Catch: Throwable -> L10
        this.N.getClass();     // Catch: Throwable -> L10
        PushCommonConfiguration r114 = this.N;     // Catch: Throwable -> L10
        r114.mIPushCommonConfiguration = this.L;     // Catch: Throwable -> L10
        PushCommonConfiguration r115 = this.N;     // Catch: Throwable -> L10
        r115.mIsBoe = this.B;     // Catch: Throwable -> L10
        PushCommonConfiguration r116 = this.N;     // Catch: Throwable -> L10
        r116.mClientDisplayFeature = this.M;     // Catch: Throwable -> L10
        PushCommonConfiguration r117 = this.N;     // Catch: Throwable -> L10
        r117.mSelfAid = String.valueOf(this.f266762b);     // Catch: Throwable -> L10
        PushCommonConfiguration r118 = this.N;     // Catch: Throwable -> L10
        r118.mProcess = this.f266769i;     // Catch: Throwable -> L10
        this.N.mEnableLazy = false;     // Catch: Throwable -> L10
        this.N.mIsLaunchFromIcon = false;     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.N;
    }

    public c(Application r100, com.bytedance.push.a r101, boolean r102, int r103, String r110, b r111, List r112, v67.e r113, com.bytedance.push.notification.r r114, String r115, yfc.c r116, v67.b r117, v67.z r118, z67.c r119, String r210, boolean r211, IAccountService r212, b77.a r213, com.bytedance.push.notification.c r214, int[] r215, v67.p r216, String r217, a r218) {
        this.E = true;
        this.f266761a = r100;
        this.f266762b = r101.f266740a;
        this.f266763c = r101.f266741b;
        this.f266764d = r101.f266743d;
        this.f266765e = r101.f266742c;
        this.f266768h = r101.f266744e;
        this.f266770j = r101.f266745f;
        this.f266766f = r102;
        this.f266767g = r103;
        this.f266769i = r110;
        this.f266771k = r111;
        this.f266772l = new CopyOnWriteArrayList(r112);
        this.f266773m = r113;
        this.f266774n = r114;
        this.f266775o = r115;
        this.f266776p = r116;
        this.f266777q = r117;
        this.f266778r = r118;
        this.f266779s = r119;
        this.f266780t = r210;
        this.f266782v = r211;
        this.f266783w = r212;
        this.f266784x = r213;
        this.f266785y = r218.f266809v;
        this.f266786z = r218.f266810w;
        this.C = r214;
        this.D = r215;
        this.H = r216;
        this.f266781u = r217;
        this.F = r218.D;
        this.G = r218.E;
        this.A = r218.F;
        this.I = r218.G;
        this.f266760J = r218.H;
        this.L = r218.f266787J;
        this.K = r218.I;
        this.B = r218.C;
        this.M = r218.K;
    }
}
