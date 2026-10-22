package com.bytedance.applog.priority;

import android.content.Context;
import android.net.Uri;
import com.bytedance.applog.log.NativeLogWrapper;
import com.bytedance.applog.priority.original.Config;
import com.bytedance.applog.priority.original.Engine;
import com.bytedance.applog.priority.original.Model$EventType;
import com.bytedance.applog.priority.original.z;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.utils.logger.FLogger;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class PriorityWrapper {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final List<String> f192573f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile boolean f192574g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f192575h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f192576i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f192577j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f192578a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f192579b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f192580c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Engine f192581d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f192582e;

    /* JADX INFO: loaded from: classes14.dex */
    public static final enum NativeThreadType extends Enum<NativeThreadType> {
        public static final NativeThreadType Android = null;
        public static final NativeThreadType Native = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ NativeThreadType[] f192583a = null;
        private final int value;

        static {
            NativeThreadType r100 = new NativeThreadType("Native", 0, 0);
            Native = r100;
            NativeThreadType r101 = new NativeThreadType("Android", 1, 1);
            Android = r101;
            f192583a = new NativeThreadType[]{r100, r101};
        }

        public static NativeThreadType[] values() {
            return (NativeThreadType[]) f192583a.clone();
        }

        public static /* synthetic */ int access$000(NativeThreadType r100) {
            return r100.value;
        }

        public static NativeThreadType valueOf(String r100) {
            return (NativeThreadType) r27.a.a(NativeThreadType.class, r100);
        }

        public NativeThreadType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    /* JADX INFO: loaded from: classes14.dex */
    public static class a extends com.bytedance.applog.log.b<Boolean> {
        public a() {
        }

        @Override // com.bytedance.applog.log.b
        public final Boolean a(Object[] r100) {
            Intrinsics.checkNotNullParameter("applog_rust", "libName");
            FLogger r101 = FLogger.f375446a;
            r101.i("Librarian_loadLib", "loadLibrary start libName -> applog_rust");
            com.bytedance.librarian.a.c("applog_rust");
            r101.i("Librarian_loadLib", "loadLibrary success by librarian -> applog_rust");
            return Boolean.TRUE;
        }
    }

    private static native int initHooks();

    private static native int nativeAddSessionDuration(String r100, String r101, String r102, long r103, String r104);

    private static native int nativeInitPriority(String r100, String r101, String r102, String r103, PriorityCallback r104, PriorityEventMetaFactory r105, boolean r106, boolean r107);

    private static native boolean nativeIsPriorityEmpty(String r100);

    private static native boolean nativeIsPriorityMatchEventType(String r100, int r101);

    private static native int nativeNewSession(String r100, String r101, boolean r102, long r103, String r104);

    private static native int nativePriorityFlush(String r100);

    private static native String nativePriorityGetVersionConfig(String r100);

    private static native int nativePriorityOnEvent(String r100, int r101, String r102, NativeLazyString r103);

    private static native int nativePrioritySetConfig(String r100, String r101);

    private static native int nativeStartPriority(String r100);

    private static native void onHttpPostResponse(long r100, PriorityHttpResponse r101);

    private static native void setDefaultThreadNum(int r100);

    private static native void setThreadType(int r100);

    public final synchronized void e() {
        monitor-enter(this);
        this.f192579b.f192622c.a("initPriority", new v());     // Catch: Throwable -> L25
        if (this.f192578a.get() == false) goto L28;
        monitor-exit(this);
        return;
    L28:
    L21:
        th = move-exception;
        this.f192579b.f192622c.b("initPriority", th, new w());     // Catch: Throwable -> L25
    L23:
        monitor-exit(this);
        return;
    L8:
        if (f192574g == true) goto L18;
        Engine r100 = this.f192581d;     // Catch: Throwable -> L21
        if (r100 == null) goto L19;
        JSONObject r101 = r100.f192654d.a();     // Catch: Throwable -> L21
        if (r101 == null) goto L19;
        if (r101.length() == 0) goto L19;
        r100.g(r101);     // Catch: Throwable -> L21
        r100.f192656f.b();     // Catch: Throwable -> L21
    L19:
        this.f192578a.set(true);     // Catch: Throwable -> L21
    L18:
        nativeStartPriority(this.f192580c);     // Catch: Throwable -> L21
        this.f192582e = nativeIsPriorityEmpty(this.f192580c);     // Catch: Throwable -> L21
        this.f192579b.f192622c.a("PriorityWrapper:initPriority", new s());     // Catch: Throwable -> L21
    L25:
        th = move-exception;
        throw th;
    }

    static {
        f192573f = Collections.singletonList("Priority3");
        f192574g = true;
        f192575h = 3;
        f192576i = 4;
        f192577j = new a();
    }

    public final void d() {
        this.f192579b.f192622c.a("flush", new u());
        if (f192574g == true) goto L7;
        Engine r100 = this.f192581d;
        if (r100 == null) goto L9;
        r100.d();
        return;
    L9:
        return;
    L7:
        nativePriorityFlush(this.f192580c);
    }

    public static /* synthetic */ void a(Pair r100) {
        onHttpPostResponse(((Long) r100.getFirst()).longValue(), (PriorityHttpResponse) r100.getSecond());
    }

    public final void b(JSONObject r100) {
        if (this.f192578a.get() == false) goto L43;
    L30:
        th = move-exception;
        this.f192579b.f192622c.b("addDefaultPriorityOptions", th, new k());
        if (this.f192579b.f192621b.f192616f.isMonitorEnabled() == false) goto L42;
        this.f192579b.f192621b.f192616f.monitorError("priority addDefaultPriorityOptions error", th.toString());
        return;
    L42:
        return;
    L6:
        if (f192574g == false) goto L12;
        String r101 = nativePriorityGetVersionConfig(this.f192580c);     // Catch: Throwable -> L30
        if (r101 != null) goto L10;
    L15:
        JSONObject r102 = null;
    L16:
        if (r102 != null) goto L18;
    L25:
        JSONObject r103 = new JSONObject();     // Catch: Throwable -> L30
        r103.put("version", 0);     // Catch: Throwable -> L30
        Iterator<String> r104 = g.f192618a.iterator();     // Catch: Throwable -> L30
    L27:
        if (r104.hasNext() == false) goto L45;
        r100.put(r104.next(), r103);     // Catch: Throwable -> L30
        goto L27
    L45:
        return;
    L18:
        if (r102.length() <= 0) goto L25;
        Iterator<String> r105 = g.f192618a.iterator();     // Catch: Throwable -> L30
    L21:
        if (r105.hasNext() == false) goto L44;
        String r106 = r105.next();     // Catch: Throwable -> L30
        Object r107 = r102.optJSONObject(r106);     // Catch: Throwable -> L30
        if (r107 == null) goto L21;
        r100.put(r106, r107);     // Catch: Throwable -> L30
        goto L21
    L44:
        return;
    L10:
        if (r101.isEmpty() == true) goto L15;
        r102 = new JSONObject(r101);     // Catch: Throwable -> L30
        goto L16
    L12:
        Engine r108 = this.f192581d;     // Catch: Throwable -> L30
        if (r108 == null) goto L15;
        r102 = r108.e();     // Catch: Throwable -> L30
        goto L16
    }

    public final boolean f(int r100) {
        if (f192574g == true) goto L5;
        Engine r101 = this.f192581d;
        r101.getClass();
        Model$EventType.Companion.getClass();
        Model$EventType r102 = Model$EventType.a.a(r100);
        com.bytedance.applog.priority.original.k r103 = r101.f192653c;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r102, "eventType");
        Set<Model$EventType> r104 = r103.f192752d;
        if (r104 == null) goto L9;
        boolean r105 = r104.contains(r102);
    L10:
        if (r105 == true) goto L13;
        Config r106 = r101.f192654d;
        r106.getClass();
        Intrinsics.checkNotNullParameter(r102, "eventType");
        if (((Set) r106.f192649e.getValue()).contains(r102) == true) goto L13;
        return false;
    L13:
        return true;
    L9:
        r105 = false;
        goto L10
    L5:
        return nativeIsPriorityMatchEventType(this.f192580c, r100);
    }

    public final void i(final JSONObject r100) {
        if (this.f192578a.get() == false) goto L29;
        Iterator<String> r101 = g.f192619b.iterator();
    L7:
        if (r101.hasNext() == false) goto L11;
        if (r100.has(r101.next()) == false) goto L7;
        boolean r102 = true;
    L12:
        if (r102 == false) goto L25;
        this.f192579b.f192622c.a("parsePriorityConfigFromServerResponse", new p(r100));
        if (f192574g == true) goto L19;
        Engine r103 = this.f192581d;
        if (r103 == null) goto L26;
        r103.i(r100);
        return;
    L26:
        return;
    L19:
        if (nativePrioritySetConfig(this.f192580c, r100.toString()) != 0) goto L28;
        this.f192582e = nativeIsPriorityEmpty(this.f192580c);
        return;
    L28:
        return;
    L25:
        return;
    L11:
        r102 = false;
        goto L12
    }

    public PriorityWrapper(Context r210, f r211) {
        this.f192578a = new AtomicBoolean(false);
        this.f192581d = null;
        this.f192582e = false;
        com.bytedance.applog.log.n.w().e(f192573f, "create priority wrapper with native: {} with config: {}", new Object[]{Boolean.valueOf(f192574g), r211});
        this.f192580c = r211.f192611a;
        if (r211.f192613c == false) goto L5;
        com.bytedance.applog.log.a r100 = new e(r211.f192616f);
    L6:
        com.bytedance.applog.log.a r101 = r100;
        String r102 = r211.f192612b;
        if (r102 != null) goto L9;
    L15:
        String[] r103 = null;
    L16:
        if (r103 == null) goto L18;
        String r104 = r103[0];
        String r105 = r103[1];
    L19:
        PolarisFileWrapper r106 = new PolarisFileWrapper(r210.getFilesDir().getAbsolutePath() + "/applog_priority_db");
        if (r106.exists() == true) goto L22;
        r106.mkdirs();
    L22:
        h r107 = new h(r210, r211, r101, r106.getAbsolutePath(), r104, r105);
        this.f192579b = r107;
        if (f192574g == true) goto L25;
        int r108 = Engine.f192650j;
        this.f192581d = Engine.Companion.a(r107);
        return;
    L25:
        f192577j.b(new Object[0]);
        r107.f192622c.a("nativeInit", new q());
        if (r107.f192621b.f192613c == false) goto L28;
        NativeLogWrapper.a();
    L28:
        setDefaultThreadNum(0);
        setThreadType(0);
        String r110 = this.f192580c;
        String r111 = r107.f192623d;
        String r112 = r107.f192624e;
        String r113 = r107.f192625f;
        NativePriorityCallbackImpl r109 = new NativePriorityCallbackImpl(r107.f192621b.f192616f, r107.f192622c, new r());
        NativePriorityEventMetaFactoryImpl r114 = new NativePriorityEventMetaFactoryImpl(r107.f192621b.f192617g);
        f r115 = r107.f192621b;
        final int r116 = nativeInitPriority(r110, r111, r112, r113, r109, r114, r115.f192614d, r115.f192615e);
        if (r116 != 0) goto L31;
        this.f192582e = nativeIsPriorityEmpty(this.f192580c);
        r107.f192622c.a("PriorityWrapper:nativeInit", new s());
    L33:
        if (r211.f192613c == false) goto L39;
        NativeLogWrapper.a();
        return;
    L39:
        return;
    L31:
        r107.f192622c.b("PriorityWrapper:onPriorityEvent", null, new t(r116));
        goto L33
    L18:
        r104 = "";
        r105 = r104;
        goto L19
    L9:
        if (r102.isEmpty() == true) goto L15;
        Uri r117 = UriProtector.parse(r102);     // Catch: Throwable -> L13
        r103 = new String[]{r117.getScheme() + "://" + r117.getHost(), r117.getPath()};     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        r101.b("nativeInit", th, new x());
        goto L15
    L5:
        r100 = new com.bytedance.applog.log.f();
        goto L6
    }

    public final boolean h(final int r100, final String r101, z<JSONObject> r102) {
        final boolean r103 = false;
        boolean r104 = true;
        if (f192574g == true) goto L16;
        Engine r105 = this.f192581d;
        if (r105 != null) goto L7;
    L29:
        this.f192579b.f192622c.a("PriorityWrapper:onPriorityEvent", new o(r103, r100, r101));
    L30:
        return r103;
    L7:
        if (r105.f192653c.f192749a.isEmpty() == true) goto L9;
    L11:
        r104 = false;
    L12:
        if (r104 == true) goto L30;
        com.bytedance.applog.priority.original.i r106 = new com.bytedance.applog.priority.original.i(r102);
        r103 = this.f192581d.a(r101, r100, r106);
        goto L29
    L9:
        if (((Set) r105.f192654d.f192649e.getValue()).isEmpty() == false) goto L11;
    L16:
        if (this.f192582e == false) goto L19;
        this.f192579b.f192622c.a("onPriorityEvent", new m());
        goto L30
    L19:
        if (nativeIsPriorityMatchEventType(this.f192580c, r100) == false) goto L30;
        final int r107 = nativePriorityOnEvent(this.f192580c, r100, r101, new NativeLazyString(r102));
        int r108 = f192575h;
        if (r107 != r108) goto L24;
        r103 = true;
    L24:
        if (r107 == 0) goto L29;
        if (r107 == r108) goto L29;
        if (r107 == f192576i) goto L29;
        this.f192579b.f192622c.b("PriorityWrapper:onPriorityEvent", null, new n(r107));
        goto L29
    }

    public final void c(String r100, String r101, long r110, String r111) {
        if (f192574g == false) goto L7;
        final int r102 = nativeAddSessionDuration(this.f192580c, r100, r101, r110, r111);
        if (r102 == 0) goto L9;
        this.f192579b.f192622c.b("PriorityWrapper:addSessionDuration", null, new l(r102));
        return;
    L9:
        return;
    L7:
        this.f192581d.c(r100, r101, r110, r111);
    }

    public final void g(String r100, boolean r101, long r110, String r111) {
        if (f192574g == false) goto L7;
        final int r102 = nativeNewSession(this.f192580c, r100, r101, r110, r111);
        if (r102 == 0) goto L9;
        this.f192579b.f192622c.b("PriorityWrapper:newSession", null, new y(r102));
        return;
    L9:
        return;
    L7:
        this.f192581d.h(r100, r101, r110, r111);
    }
}
