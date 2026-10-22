package hm2;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.network.api.IMiddlewareNetworkService;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livehostapi.foundation.IMiddlewareHostNetwork;
import com.bytedance.android.livehostapi.platform.IHostWebView;
import com.bytedance.android.livesdk.config.k80;
import com.bytedance.android.livesdk.config.o80;
import com.bytedance.android.livesdk.config.r80;
import com.bytedance.android.livesdk.config.yj1;
import com.bytedance.android.livesdk.crash.SourceType;
import com.bytedance.android.livesdk.utils.d4;
import com.bytedance.android.livesdk.y0;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import zg1.k1;

/* JADX INFO: loaded from: classes11.dex */
public final class l implements amc.e {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final AtomicInteger f485840w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final ArrayList<Integer> f485841x = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f485842a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<String, String> f485843b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final im2.d f485844c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Disposable f485845d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final im2.n f485846e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final bc2.a f485847f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final bc2.e f485848g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.ss.ugc.live.sdk.msg.network.l f485849h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final hm2.g f485850i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final e f485851j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List<com.ss.ugc.live.sdk.msg.dispatch.a> f485852k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Set<String> f485853l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final b f485854m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final c f485855n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final f f485856o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final d f485857p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final long f485858q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String f485859r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Map<String, String> f485860s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final List<vlc.b> f485861t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final List<vlc.j> f485862u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f485863v;

    public static final class a {
    }

    public static final class b implements amc.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f485864a;

        public static final class a<T> implements h80.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f485865a;

            public a(b r100) {
                this.f485865a = r100;
            }

            @Override // h80.d
            public final Object get() {
                return Long.valueOf(this.f485865a.f485864a.f485858q);
            }
        }

        @Override // amc.b
        public final boolean c() {
            return true;
        }

        @Override // amc.b
        public final void e() {
        }

        @Override // amc.b
        public final int j() {
            return 512;
        }

        @Override // amc.b
        public final List<com.ss.ugc.live.sdk.msg.dispatch.a> b() {
            return this.f485864a.f485852k;
        }

        @Override // amc.b
        public final vlc.k f() {
            return new gm2.l(new a(this));
        }

        @Override // amc.b
        public final com.ss.ugc.live.sdk.msg.dispatch.g g() {
            Integer r100 = k80.f120581a.getValue();
            if (r100.intValue() > 0) goto L5;
            return null;
        L5:
            c r101 = this.f485864a.f485855n;
            r101.f485866a = r100.intValue();
            return r101;
        }

        @Override // amc.b
        public final List<vlc.b> getInterceptors() {
            return this.f485864a.f485861t;
        }

        @Override // amc.b
        public final Set<String> h() {
            return this.f485864a.f485853l;
        }

        @Override // amc.b
        public final List<vlc.j> i() {
            return this.f485864a.f485862u;
        }

        @Override // amc.b
        public final long a() {
            return d4.l();
        }

        @Override // amc.b
        public final long d() {
            return d4.k();
        }

        public b(l r100) {
            this.f485864a = r100;
        }
    }

    public static final class c implements com.ss.ugc.live.sdk.msg.dispatch.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f485866a;

        public c() {
        }

        @Override // com.ss.ugc.live.sdk.msg.dispatch.g
        public final int a(List<? extends tlc.d> r110, com.ss.ugc.live.sdk.msg.dispatch.h r111) {
            Intrinsics.checkNotNullParameter(r110, "messages");
            Intrinsics.checkNotNullParameter(r111, "dispatcher");
            long r100 = SystemClock.uptimeMillis();
            if ((!r110.isEmpty()) == true) goto L6;
            r110 = null;
        L6:
            int r101 = 0;
            if (r110 == null) goto L21;
            Iterator<? extends tlc.d> r112 = r110.iterator();
        L10:
            if (r112.hasNext() == false) goto L21;
            tlc.d r102 = r112.next();
            long r103 = SystemClock.uptimeMillis();
            r111.onMessage(r102);
            r101 = r101 + 1;
            if ((SystemClock.uptimeMillis() - r103) <= this.f485866a) goto L17;
            String r104 = "a message has timeout!!! " + (SystemClock.uptimeMillis() - r100) + "ms ," + r102.getClass();
            if (v.a() == false) goto L17;
            ALogger.d("MessageDispatchDelegate", r104);
        L17:
            if ((SystemClock.uptimeMillis() - r100) <= this.f485866a) goto L10;
            String r113 = "messageList dispatch has timeout!!! " + (SystemClock.uptimeMillis() - r100) + "ms";
            if (v.a() == false) goto L21;
            ALogger.d("MessageDispatchDelegate", r113);
        L21:
            return r101;
        }
    }

    public static final class d implements com.ss.ugc.live.sdk.msg.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f485867a;

        @Override // com.ss.ugc.live.sdk.msg.b
        public final void onInit() {
            List<vlc.b> r100 = this.f485867a.f485861t;
            if (r100 == null) goto L14;
            ArrayList r101 = new ArrayList();
            Iterator<T> r102 = r100.iterator();
        L6:
            if (r102.hasNext() == false) goto L10;
            Object r103 = r102.next();
            if ((r103 instanceof com.bytedance.android.livesdk.message.interceptor.h) == false) goto L6;
            r101.add(r103);
            goto L6
        L10:
            Iterator r104 = r101.iterator();
        L12:
            if (r104.hasNext() == false) goto L21;
            ((com.bytedance.android.livesdk.message.interceptor.h) r104.next()).getClass();
            goto L12
        L21:
            return;
        }

        @Override // com.ss.ugc.live.sdk.msg.b
        public final void onRelease() {
            l r100 = this.f485867a;
            Disposable r101 = r100.f485845d;
            if (r101 == null) goto L5;
            r101.dispose();
        L5:
            im2.n r102 = null;
            r100.f485845d = null;
            im2.n r103 = this.f485867a.f485846e;
            if ((r103 instanceof im2.n) == false) goto L9;
            r102 = r103;
        L9:
            if (r102 == null) goto L11;
            r102.a();
        L11:
            List<vlc.b> r104 = this.f485867a.f485861t;
            if (r104 == null) goto L23;
            ArrayList r105 = new ArrayList();
            Iterator<T> r106 = r104.iterator();
        L15:
            if (r106.hasNext() == false) goto L19;
            Object r107 = r106.next();
            if ((r107 instanceof com.bytedance.android.livesdk.message.interceptor.h) == false) goto L15;
            r105.add(r107);
            goto L15
        L19:
            Iterator r108 = r105.iterator();
        L21:
            if (r108.hasNext() == false) goto L23;
            ((com.bytedance.android.livesdk.message.interceptor.h) r108.next()).onRelease();
        L23:
            this.f485867a.f485844c.d("live_message");
        }

        @Override // com.ss.ugc.live.sdk.msg.b
        public final void onResume() {
            l r100 = this.f485867a;
            r100.getClass();
            r100.f485845d = xs2.b.a().b(k1.class).subscribe(new m(r100));
            List<vlc.b> r101 = this.f485867a.f485861t;
            if (r101 == null) goto L14;
            ArrayList r102 = new ArrayList();
            Iterator<T> r103 = r101.iterator();
        L6:
            if (r103.hasNext() == false) goto L10;
            Object r104 = r103.next();
            if ((r104 instanceof com.bytedance.android.livesdk.message.interceptor.h) == false) goto L6;
            r102.add(r104);
            goto L6
        L10:
            Iterator r105 = r102.iterator();
        L12:
            if (r105.hasNext() == false) goto L21;
            ((com.bytedance.android.livesdk.message.interceptor.h) r105.next()).getClass();
            goto L12
        L21:
            return;
        }

        @Override // com.ss.ugc.live.sdk.msg.b
        public final void onStart() {
            l r100 = this.f485867a;
            r100.getClass();
            r100.f485845d = xs2.b.a().b(k1.class).subscribe(new m(r100));
            List<vlc.b> r101 = this.f485867a.f485861t;
            if (r101 == null) goto L14;
            ArrayList r102 = new ArrayList();
            Iterator<T> r103 = r101.iterator();
        L6:
            if (r103.hasNext() == false) goto L10;
            Object r104 = r103.next();
            if ((r104 instanceof com.bytedance.android.livesdk.message.interceptor.h) == false) goto L6;
            r102.add(r104);
            goto L6
        L10:
            Iterator r105 = r102.iterator();
        L12:
            if (r105.hasNext() == false) goto L21;
            ((com.bytedance.android.livesdk.message.interceptor.h) r105.next()).getClass();
            goto L12
        L21:
            return;
        }

        public d(l r100) {
            this.f485867a = r100;
        }

        @Override // com.ss.ugc.live.sdk.msg.b
        public final void a(boolean r100) {
            l r101 = this.f485867a;
            Disposable r102 = r101.f485845d;
            if (r102 == null) goto L5;
            r102.dispose();
        L5:
            r101.f485845d = null;
            List<vlc.b> r103 = this.f485867a.f485861t;
            if (r103 == null) goto L17;
            ArrayList r104 = new ArrayList();
            Iterator<T> r105 = r103.iterator();
        L9:
            if (r105.hasNext() == false) goto L13;
            Object r106 = r105.next();
            if ((r106 instanceof com.bytedance.android.livesdk.message.interceptor.h) == false) goto L9;
            r104.add(r106);
            goto L9
        L13:
            Iterator r107 = r104.iterator();
        L15:
            if (r107.hasNext() == false) goto L24;
            ((com.bytedance.android.livesdk.message.interceptor.h) r107.next()).getClass();
            goto L15
        L24:
            return;
        }
    }

    public static final class e extends amc.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f485868a;

        public static final class a<T> implements h80.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ e f485869a;

            public a(e r100) {
                this.f485869a = r100;
            }

            @Override // h80.d
            public final Object get() {
                return Long.valueOf(this.f485869a.f485868a.f485858q);
            }
        }

        public static final class b<T> implements h80.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f485870a = null;

            static {
                f485870a = new b();
            }

            public b() {
            }

            @Override // h80.d
            public final /* bridge */ /* synthetic */ Object get() {
                return "";
            }
        }

        public static final class c<T> implements h80.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ e f485871a;

            public c(e r100) {
                this.f485871a = r100;
            }

            @Override // h80.d
            public final Object get() {
                HashMap r100 = new HashMap();
                Pair<String, String> r101 = this.f485871a.f485868a.f485850i.c();
                if (r101 == null) goto L5;
                String r102 = (String) r100.put(r101.getFirst(), r101.getSecond());
            L5:
                return r100;
            }
        }

        @Override // amc.g
        public final void j() {
        }

        @Override // amc.h, amc.g
        public final boolean k() {
            return false;
        }

        @Override // amc.g
        public final Map<String, String> a() {
            return this.f485868a.f();
        }

        @Override // amc.g
        public final com.ss.ugc.live.sdk.msg.network.i d() {
            return new im2.h(new a(this), b.f485870a, new c(this));
        }

        @Override // amc.g
        public final String e() {
            StringBuilder r100 = new StringBuilder("https://");
            r100.append(((IMiddlewareHostNetwork) jc1.k.n(IMiddlewareHostNetwork.class)).getHostDomain());
            String r101 = hm2.c.f485751a;
            if (this.f485868a.f485863v == true) goto L5;
        L7:
            boolean r102 = false;
        L8:
            if (r102 == false) goto L10;
            String r103 = "/webcast/openapi/im/fetch/inner_card/";
        L11:
            r100.append(r103);
            return r100.toString();
        L10:
            r103 = hm2.c.f485754d;
            goto L11
        L5:
            if (y0.f162544a.getValue().booleanValue() == false) goto L7;
            r102 = true;
            goto L8
        }

        @Override // amc.g
        public final com.ss.ugc.live.sdk.msg.network.l f() {
            return this.f485868a.f485849h;
        }

        @Override // amc.g
        public final im2.d h() {
            return this.f485868a.f485844c;
        }

        @Override // amc.g
        public final amc.d l() {
            return new im2.l(this.f485868a.f485849h);
        }

        @Override // amc.h
        public final long n() {
            int r100 = d4.f158930a;
            return r80.f121111a.getValue().longValue();
        }

        @Override // amc.g
        public final boolean b() {
            return d4.o();
        }

        @Override // amc.h, amc.g
        public final int c() {
            return d4.i();
        }

        @Override // amc.h, amc.g
        public final String g() {
            if (TextUtils.isEmpty(d4.g().f()) == false) goto L16;
            StringBuilder r100 = new StringBuilder("wss://");
            r100.append(((IMiddlewareHostNetwork) jc1.k.n(IMiddlewareHostNetwork.class)).getHostDomain());
            String r101 = hm2.c.f485751a;
            if (this.f485868a.f485863v == true) goto L8;
        L10:
            boolean r102 = false;
        L11:
            if (r102 == false) goto L13;
            String r103 = "/webcast/im/push/inner_card/";
        L14:
            r100.append(r103);
            return r100.toString();
        L13:
            r103 = hm2.c.f485755e;
            goto L14
        L8:
            if (y0.f162544a.getValue().booleanValue() == false) goto L10;
            r102 = true;
            goto L11
        L16:
            return d4.g().f();
        }

        @Override // amc.h, amc.g
        public final boolean i() {
            return d4.g().e();
        }

        public e(l r100) {
            this.f485868a = r100;
        }
    }

    public static final class f implements amc.i {
        public f() {
        }

        @Override // amc.i
        public final boolean b() {
            return false;
        }

        @Override // amc.i
        public final lmc.h c() {
            return null;
        }

        @Override // amc.i
        public final boolean d() {
            return false;
        }

        @Override // amc.i
        public final boolean enable() {
            return false;
        }

        @Override // amc.i
        public final String e() {
            return "https://" + ((IMiddlewareHostNetwork) jc1.k.n(IMiddlewareHostNetwork.class)).getHostDomain() + "/webcast/im/gw/uplink/message/";
        }

        @Override // amc.i
        public final long a() {
            return ac2.k.a();
        }
    }

    public static final class g<T> implements h80.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f485872a;

        public g(l r100) {
            this.f485872a = r100;
        }

        @Override // h80.d
        public final Object get() {
            return Long.valueOf(this.f485872a.f485858q);
        }
    }

    public static final class h<T> implements h80.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h f485873a = null;

        static {
            f485873a = new h();
        }

        public h() {
        }

        @Override // h80.d
        public final /* bridge */ /* synthetic */ Object get() {
            return "";
        }
    }

    public static final class i<T> implements h80.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f485874a;

        public i(l r100) {
            this.f485874a = r100;
        }

        @Override // h80.d
        public final Object get() {
            this.f485874a.getClass();
            return Boolean.FALSE;
        }
    }

    public static final class j<T> implements h80.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final j f485875a = null;

        static {
            f485875a = new j();
        }

        public j() {
        }

        @Override // h80.d
        public final Object get() {
            IHostWebView r100 = (IHostWebView) jc1.k.f(IHostWebView.class);
            if (r100 == null) goto L30;
            Map<String, String> r101 = r100.getHeaderMap("https://" + ((IMiddlewareHostNetwork) jc1.k.n(IMiddlewareHostNetwork.class)).getHostDomain());
            if (r101 == null) goto L30;
            LinkedHashMap r102 = new LinkedHashMap();
            Iterator<Map.Entry<String, String>> r103 = r101.entrySet().iterator();
        L8:
            if (r103.hasNext() == false) goto L36;
            Map.Entry<String, String> r104 = r103.next();
            String r105 = r104.getKey();
            boolean r106 = true;
            if (r105 != null) goto L12;
        L15:
            boolean r107 = true;
        L16:
            if (r107 == true) goto L26;
            String r108 = r104.getValue();
            if (r108 != null) goto L20;
        L23:
            boolean r109 = true;
        L24:
            if (r109 == true) goto L26;
        L27:
            if (r106 == false) goto L8;
            r102.put(r104.getKey(), r104.getValue());
            goto L8
        L20:
            if (r108.length() == 0) goto L23;
            r109 = false;
        L26:
            r106 = false;
            goto L27
        L12:
            if (r105.length() == 0) goto L15;
            r107 = false;
            goto L16
        L36:
            return r102;
        L30:
            return new HashMap();
        }
    }

    static {
        f485840w = new AtomicInteger(0);
        f485841x = CollectionsKt.arrayListOf(new Integer[]{10011, 10012, 10013, 10014, 10015});
    }

    @Override // amc.e
    public final List<cmc.b<?>> e() {
        return CollectionsKt.listOf(this.f485850i);
    }

    public final Map<String, String> f() {
        IMiddleWareHostContext r100 = (IMiddleWareHostContext) jc1.k.n(IMiddleWareHostContext.class);
        HashMap r101 = new HashMap(((IMiddlewareNetworkService) jc1.k.n(IMiddlewareNetworkService.class)).getCommonParams());
        r101.put("room_id", String.valueOf(this.f485858q));
        r101.put("rid", String.valueOf(this.f485858q));
        r101.put("aid", String.valueOf(r100.hostAppId()));
        r101.put("user_id", this.f485859r);
        r101.put(DownloadHelper.IDENTITY, this.f485842a);
        r101.put("live_id", String.valueOf(((IMiddleWareHostContext) jc1.k.n(IMiddleWareHostContext.class)).liveId()));
        r101.putAll(this.f485843b);
        return r101;
    }

    @Override // amc.e
    public final amc.b b() {
        return this.f485854m;
    }

    @Override // amc.e
    public final com.ss.ugc.live.sdk.msg.b c() {
        return this.f485857p;
    }

    @Override // amc.e
    public final amc.i d() {
        return this.f485856o;
    }

    @Override // amc.e
    public final im2.n g() {
        return this.f485846e;
    }

    @Override // amc.e
    public final vlc.c getLogger() {
        return this.f485847f;
    }

    @Override // amc.e
    public final bc2.e getMonitor() {
        return this.f485848g;
    }

    @Override // amc.e
    public final amc.g getNetworkConfig() {
        return this.f485851j;
    }

    @Override // amc.e
    public final long getRoomId() {
        return this.f485858q;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public l(Context r100, long r101, String r110, Map<String, String> r111, List<? extends vlc.b> r112, List<? extends vlc.j> r113, boolean r114) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "userId");
        Intrinsics.checkNotNullParameter(r111, "extraParams");
        this.f485858q = r101;
        this.f485859r = r110;
        this.f485860s = r111;
        this.f485861t = r112;
        this.f485862u = r113;
        this.f485863v = r114;
        this.f485842a = SourceType.DEFAULT;
        HashMap<String, String> r102 = new HashMap();
        this.f485843b = r102;
        im2.d r115 = new im2.d(false);
        this.f485844c = r115;
        Context r103 = r100.getApplicationContext();
        this.f485846e = new im2.n();
        this.f485847f = new bc2.a("preview");
        this.f485848g = new bc2.e();
        if (yj1.f121695a.getValue().booleanValue() == true) goto L5;
    L7:
        com.ss.ugc.live.sdk.msg.network.l r104 = new im2.k(((Number) ListProtector.get(f485841x, f485840w.incrementAndGet() % 5)).intValue(), r103, j.f485875a, new g(this), h.f485873a, new i(this));
    L8:
        this.f485849h = r104;
        im2.k.d r116 = null;
        if ((r104 instanceof im2.k) == true) goto L11;
        r104 = null;
    L11:
        im2.k r105 = (im2.k) r104;
        if (r105 == null) goto L14;
        r116 = r105.f490487d;
    L14:
        this.f485850i = new hm2.g(r115, r116);
        this.f485851j = new e(this);
        if (o80.f120884a.getValue().booleanValue() == false) goto L17;
        List<com.ss.ugc.live.sdk.msg.dispatch.a> r106 = CollectionsKt.listOf(new com.ss.ugc.live.sdk.msg.dispatch.a(MessageType.CHAT.getWsMethod()));
    L18:
        this.f485852k = r106;
        this.f485853l = CollectionsKt.toSet(d4.m());
        this.f485854m = new b(this);
        this.f485855n = new c();
        this.f485856o = new f();
        this.f485857p = new d(this);
        Intrinsics.checkNotNullParameter(r111, "customParams");
        r102.putAll(r111);
        return;
    L17:
        r106 = CollectionsKt.emptyList();
        goto L18
    L5:
        if (v.a() == false) goto L7;
        r104 = new com.ss.ugc.live.sdk.msg.network.a();
        goto L8
    }
}
