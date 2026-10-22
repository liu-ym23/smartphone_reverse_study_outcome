package s47;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.pia.core.api.bridge.PiaMethod;
import com.bytedance.pia.core.metrics.ErrorType;
import com.bytedance.pia.core.metrics.TraceEvent;
import com.bytedance.pia.core.setting.Config;
import com.bytedance.pia.core.setting.Settings;
import com.bytedance.pia.core.utils.DefaultResourceLoader;
import com.bytedance.pia.core.utils.ThreadUtil;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class n extends b47.b {
    public volatile WeakReference<View> A;
    public final m47.o B;
    public final boolean C;
    public final long D;
    public final AtomicBoolean E;
    public final AtomicBoolean F;
    public final AtomicBoolean G;
    public final AtomicBoolean H;
    public final AtomicBoolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public volatile e47.b f540649J;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final ConcurrentLinkedQueue<l> f540650z;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f540651a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f540652b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f540653c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f540654d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Config f540655e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f540656f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public e f540657g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public j f540658h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Uri f540659i;

        public final n a() {
            Object r100 = this.f540653c;
            int r101 = f47.b.f475570a;
            String r102 = null;
            if ((r100 instanceof e47.a) == false) goto L5;
            f47.c r103 = (f47.c) ((e47.a) r100).get(f47.c.class);
        L6:
            if (r103 != null) goto L8;
            r103 = f47.c.f475571a;
        L8:
            f47.c r110 = r103;
            r110.a(TraceEvent.INITIALIZE_START, System.currentTimeMillis());
            Lazy<Settings> r104 = Settings.f266286f;
            if (Settings.a.a().r() == true) goto L11;
            return null;
        L11:
            b();
            String r105 = this.f540656f;
            if (r105 != null) goto L14;
        L102:
            return null;
        L14:
            if (r105.isEmpty() == true) goto L102;
            t47.f r106 = t47.f.f544586a;
            if (t47.f.d(this.f540659i) == true) goto L20;
            com.bytedance.pia.core.utils.d.n("[Runtime]: url is not support. Url: " + this.f540652b);
            return null;
        L20:
            boolean r107 = false;
            boolean r108 = this.f540659i.getBooleanQueryParameter("_pia_", false);
            if (r108 == true) goto L26;
            if (this.f540659i.getBooleanQueryParameter("__pia_manifest__", false) == false) goto L26;
            r107 = true;
        L26:
            if (Settings.a.a().s() == false) goto L32;
            Config r109 = Config.c(this.f540659i);
            this.f540655e = r109;
            if (r109 != null) goto L32;
            if (r108 == false) goto L32;
            this.f540655e = new Config(SetsKt.setOf(ErrorType.PREFETCH), r102, 14);
        L32:
            if (this.f540655e != null) goto L36;
            if (r108 == false) goto L36;
            this.f540655e = Config.c(this.f540659i);
        L36:
            if (this.f540655e != null) goto L40;
            if (r107 == false) goto L40;
            this.f540655e = Config.f266282c;
        L40:
            if (this.f540655e != null) goto L42;
            return null;
        L42:
            c47.c r111 = t47.e.b.f544585a.b(this.f540651a);
            l47.b<i47.c> r112 = r111.f22398c;
            if (r112 != null) goto L45;
            r112 = c47.c.a.f22408d;
        L45:
            if (r112 != null) goto L103;
        L50:
            i47.c r113 = null;
        L51:
            DefaultResourceLoader r114 = new DefaultResourceLoader(r113);
            l47.b<g47.a> r115 = r111.f22400e;
            if (r115 != null) goto L54;
            r115 = c47.c.a.f22409e;
        L54:
            if (r115 != null) goto L111;
        L59:
            g47.a r116 = null;
        L60:
            if (r116 != null) goto L62;
            r116 = new m();
        L62:
            g47.a r117 = r116;
            l47.b<String> r118 = r111.f22397b;
            if (r118 != null) goto L65;
            Context r119 = c47.c.a.f22405a;
            r118 = null;
        L65:
            if (r118 != null) goto L113;
        L70:
            String r120 = null;
        L71:
            if (r120 != null) goto L73;
            r120 = "";
        L73:
            String r121 = r120;
            l47.b<Map<String, ?>> r122 = r111.f22402g;
            if (r122 != null) goto L76;
            Context r123 = c47.c.a.f22405a;
            r122 = null;
        L76:
            if (r122 != null) goto L109;
        L81:
            Map<String, ?> r124 = null;
        L82:
            l47.b<Map<String, String>> r125 = r111.f22403h;
            if (r125 != null) goto L85;
            Context r126 = c47.c.a.f22405a;
            r125 = null;
        L85:
            if (r125 != null) goto L107;
        L90:
            Map<String, String> r127 = null;
        L91:
            l47.b<j47.a> r128 = r111.f22404i;
            if (r128 != null) goto L94;
            Context r129 = c47.c.a.f22405a;
            r128 = null;
        L94:
            if (r128 != null) goto L105;
        L99:
            j47.a r130 = null;
        L101:
            return new n(this.f540659i, this.f540656f, this.f540651a, this.f540653c, this.f540654d, r114, r117, r121, this.f540655e, r124, r110, this.f540657g, this.f540658h, r127, r130);
        L105:
            r130 = r128.create(this.f540653c);     // Catch: Throwable -> L97
        L97:
            th = move-exception;
            com.bytedance.pia.core.utils.d.d("[Runtime] create securityDelegate error:", th);
            goto L99
        L107:
            r127 = r125.create(this.f540653c);     // Catch: Throwable -> L88
        L88:
            th = move-exception;
            com.bytedance.pia.core.utils.d.d("[Runtime] create headers error:", th);
            goto L90
        L109:
            r124 = r122.create(this.f540653c);     // Catch: Throwable -> L79
        L79:
            th = move-exception;
            com.bytedance.pia.core.utils.d.d("[Runtime] create globalProps error:", th);
            goto L81
        L113:
            r120 = r118.create(this.f540653c);     // Catch: Throwable -> L68
        L68:
            th = move-exception;
            com.bytedance.pia.core.utils.d.d("[Runtime] create custom UserAgent error:", th);
            goto L70
        L111:
            r116 = r115.create(this.f540653c);     // Catch: Throwable -> L57
        L57:
            th = move-exception;
            com.bytedance.pia.core.utils.d.d("[Runtime] create Retrofit error:", th);
            goto L59
        L103:
            r113 = r112.create(this.f540653c);     // Catch: Throwable -> L48
        L48:
            th = move-exception;
            com.bytedance.pia.core.utils.d.d("[Runtime] create ResourceLoader error:", th);
            goto L50
        L5:
            r103 = null;
            goto L6
        }

        public final String b() {
            if (TextUtils.isEmpty(this.f540652b) == false) goto L6;
            return null;
        L6:
            if (Settings.e().s() == false) goto L8;
        L12:
            String r100 = this.f540656f;
            if (r100 == null) goto L15;
            return r100;
        L15:
            Uri r101 = UriProtector.parse(this.f540652b);
            this.f540659i = r101;
            String r102 = com.bytedance.pia.core.utils.j.g(r101, null);
            this.f540656f = r102;
            return r102;
        L8:
            if (this.f540652b.contains("__pia_manifest__") == true) goto L12;
            if (this.f540652b.contains("_pia_") == true) goto L12;
            return null;
        }

        public a() {
            this.f540651a = null;
            this.f540652b = null;
            this.f540653c = null;
            this.f540654d = false;
            this.f540655e = null;
            this.f540656f = null;
            this.f540657g = null;
            this.f540658h = null;
        }
    }

    public final View g() {
        if (this.A != null) goto L5;
        return null;
    L5:
        return this.A.get();
    }

    public final void h() {
        if (this.I.get() == false) goto L7;
        com.bytedance.pia.core.utils.d.c("[Runtime] call initialize after release.");
        return;
    L7:
        if (this.E.compareAndSet(false, true) == true) goto L10;
        com.bytedance.pia.core.utils.d.c("[Runtime] initialize more than once!");
        return;
    L10:
        Iterator<l> r100 = this.f540650z.iterator();
    L12:
        if (r100.hasNext() == false) goto L18;
        l r101 = r100.next();
        r101.b();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        com.bytedance.pia.core.utils.d.d("[Runtime] " + r101.a() + "initialize error:", th);
        this.f540650z.remove(r101);
        goto L12
    }

    public final boolean j() {
        Config r100 = this.f17555d;
        r100.getClass();
        return !Intrinsics.areEqual(r100, Config.f266282c);
    }

    @Override // s47.a, l47.c
    public final void release() {
        if (this.I.compareAndSet(false, true) == true) goto L6;
        com.bytedance.pia.core.utils.d.c("[Runtime] release more than once!");
        return;
    L6:
        this.f540649J.remove("ctx-pia-runtime");
        this.f540649J = null;
        super.release();
        Iterator<l> r100 = this.f540650z.iterator();
    L8:
        if (r100.hasNext() == false) goto L10;
        r100.next().release();
        goto L8
    L10:
        this.f540650z.clear();
        m47.o r101 = this.B;
        r101.getClass();
        ThreadUtil.c(new m47.f(r101));
        com.bytedance.pia.core.utils.d.i("[Runtime] release runtime. url=" + this.f17559h);
    }

    public final l f(String r100) {
        if (this.I.get() == false) goto L7;
        com.bytedance.pia.core.utils.d.c("[Runtime] call getPlugin after release.");
        return null;
    L7:
        if (r100.isEmpty() == true) goto L13;
        Object r101 = get(r100);
        if ((r101 instanceof l) == false) goto L13;
        return (l) r101;
    L13:
        return null;
    }

    public final void k(View r100) {
        if (this.I.get() == false) goto L7;
        com.bytedance.pia.core.utils.d.c("[Runtime] call onBindView after release.");
        return;
    L7:
        if (this.F.compareAndSet(false, true) == true) goto L11;
        com.bytedance.pia.core.utils.d.c("[Runtime] onBindView more than once!");
        return;
    L11:
        if ((r100 instanceof WebView) == false) goto L13;
        final p47.h r101 = this.f17562k;
        final WebView r102 = (WebView) r100;
        r101.getClass();
        ThreadUtil.d(new p47.c(r101, r102));
    L13:
        this.A = new WeakReference(r100);
        Iterator<l> r103 = this.f540650z.iterator();
    L15:
        if (r103.hasNext() == false) goto L21;
        l r104 = r103.next();
        r104.e(r100);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        com.bytedance.pia.core.utils.d.d("[Runtime] " + r104.a() + " onBindView error:", th);
        goto L15
    }

    public final void i(Class<? extends l> r100, Object r101) {
        if (this.E.get() == false) goto L7;
        com.bytedance.pia.core.utils.d.c("[Runtime] can not install plugin after initialized!");
        return;
    L7:
        if (this.I.get() == false) goto L23;
        com.bytedance.pia.core.utils.d.c("[Runtime] call installPlugin after release.");
        return;
    L23:
        if (r101 != null) goto L13;
        l r102 = r100.getConstructor(new Class[]{n.class}).newInstance(new Object[]{this});     // Catch: Throwable -> L20
    L15:
        if (get(r102.a()) == null) goto L18;
        com.bytedance.pia.core.utils.d.i("[Runtime] duplicate plugin registered, name=" + r102.a());     // Catch: Throwable -> L20
        return;
    L18:
        a(r102, r102.a());     // Catch: Throwable -> L20
        this.f540650z.add(r102);     // Catch: Throwable -> L20
        com.bytedance.pia.core.utils.d.i("[Runtime] install plugin success, name=" + r102.a());     // Catch: Throwable -> L20
        return;
    L13:
        r102 = r100.getConstructor(new Class[]{n.class, r101.getClass()}).newInstance(new Object[]{this, r101});     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        com.bytedance.pia.core.utils.d.d("[Runtime] install plugin error:", th);
    }

    public final void l(String r100, Object... r101) {
        if (this.E.get() == true) goto L7;
        com.bytedance.pia.core.utils.d.c("[Runtime] can not send event before initialize!");
        return;
    L7:
        if (this.I.get() == false) goto L10;
        com.bytedance.pia.core.utils.d.c("[Runtime] can not send event after released!");
        return;
    L10:
        Iterator<l> r102 = this.f540650z.iterator();
    L12:
        if (r102.hasNext() == false) goto L18;
        l r103 = r102.next();
        r103.f(r100, r101);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        com.bytedance.pia.core.utils.d.d("[Runtime] " + r103.a() + " onEvent error:", th);
        goto L12
    }

    public n(Uri r110, String r111, String r112, Object r210, boolean r211, DefaultResourceLoader r212, g47.a r213, String r214, Config r215, Map r216, f47.c r217, e r218, j r219, Map r310, j47.a r311) {
        super(r110, r111, r112, r210, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311);
        this.f540650z = new ConcurrentLinkedQueue();
        this.A = null;
        this.B = new m47.o(PiaMethod.Scope.Render, this, this.f17561j);
        this.E = new AtomicBoolean(false);
        this.F = new AtomicBoolean(false);
        this.G = new AtomicBoolean(false);
        this.H = new AtomicBoolean(false);
        this.I = new AtomicBoolean(false);
        this.f540649J = null;
        this.C = r211;
        com.bytedance.pia.core.utils.d.i("[Runtime] created runtime. url=" + r110);
        long r100 = System.currentTimeMillis();
        this.D = r100;
        this.f17571t.a(TraceEvent.INITIALIZE_END, r100);
    }
}
