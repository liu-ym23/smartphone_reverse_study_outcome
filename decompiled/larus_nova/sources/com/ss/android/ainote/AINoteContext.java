package com.ss.android.ainote;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.ss.android.ainote.model.AINoteScene;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import com.ss.android.lark.appsetting.api.AppSettingApiModule;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.utils.LarkContext;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes34.dex */
public final class AINoteContext {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final /* synthetic */ int f406481u = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f406482a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.lark.rustclient.api.l f406483b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.ss.android.lark.passportc.api.m f406484c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinkedHashMap<String, AINotesSession> f406485d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LinkedHashMap<String, Job> f406486e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LinkedHashSet<String> f406487f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LinkedHashMap<AINoteScene, s0> f406488g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f406489h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final CoroutineScope f406490i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AINoteImageUploadCoordinator f406491j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final AINoteImageDownloadCoordinator f406492k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final AINoteCacheStore f406493l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public volatile g0 f406494m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final d f406495n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final c f406496o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public volatile boolean f406497p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public volatile boolean f406498q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public volatile boolean f406499r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public volatile boolean f406500s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public volatile int f406501t;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.ss.android.ainote.d f406502a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AINoteScene f406503b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f406502a, r101.f406502a) == true) goto L12;
            return false;
        L12:
            if (this.f406503b == r101.f406503b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f406502a.hashCode() * 31) + this.f406503b.hashCode();
        }

        public final String toString() {
            return "SessionTarget(bizIds=" + this.f406502a + ", scene=" + this.f406503b + ')';
        }

        public b(com.ss.android.ainote.d r100, AINoteScene r101) {
            Intrinsics.checkNotNullParameter(r100, "bizIds");
            Intrinsics.checkNotNullParameter(r101, "scene");
            this.f406502a = r100;
            this.f406503b = r101;
        }
    }

    public static final class c implements ComponentCallbacks2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AINoteContext f406504a;

        @Override // android.content.ComponentCallbacks
        public final void onConfigurationChanged(Configuration r100) {
            Intrinsics.checkNotNullParameter(r100, "newConfig");
        }

        @Override // android.content.ComponentCallbacks
        public final void onLowMemory() {
            t.d("AINoteContext", "app lowMemory");
            this.f406504a.e("low_memory");
        }

        public c(AINoteContext r100) {
            this.f406504a = r100;
        }

        @Override // android.content.ComponentCallbacks2
        public final void onTrimMemory(int r100) {
            if (r100 < 10) goto L6;
            int r101 = t.f407207a;
            t.d("AINoteContext", "app trimMemory, level=" + r100);
            this.f406504a.e("trim_memory_" + r100);
            return;
        }
    }

    public static final class d implements com.ss.android.lark.appcontext.applifecycle.y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AINoteContext f406505a;

        public d(AINoteContext r100) {
            this.f406505a = r100;
        }

        @Override // com.ss.android.lark.appcontext.applifecycle.y
        public final void f(com.ss.android.lark.appcontext.applifecycle.y.a r100, com.ss.android.lark.appcontext.applifecycle.y.a r101) {
            Intrinsics.checkNotNullParameter(r100, "oldState");
            Intrinsics.checkNotNullParameter(r101, "newState");
            AINoteContext r102 = this.f406505a;
            boolean r103 = r100.f408860c;
            boolean r104 = r101.f408860c;
            monitor-enter(r102);
            if (r103 == true) goto L11;
            if (r104 == false) goto L11;
            t.d("AINoteContext", "app entered foreground");     // Catch: Throwable -> L9
            monitor-exit(r102);
            return;
        L11:
            if (r103 == false) goto L17;
            if (r104 == true) goto L17;
            t.d("AINoteContext", "app entered background");     // Catch: Throwable -> L9
            r102.e("background");     // Catch: Throwable -> L9
        L17:
            monitor-exit(r102);
            return;
        L9:
            th = move-exception;
            throw th;
        }
    }

    public static final class e implements AINotesSession.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AINoteContext f406506a;

        public e(AINoteContext r100) {
            this.f406506a = r100;
        }

        @Override // com.ss.android.ainote.AINotesSession.f
        public final void a(AINotesSession r100) {
            Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
            AINoteContext r101 = this.f406506a;
            monitor-enter(r101);
            String r102 = AINoteContext.n(r100.f406577a, r100.f406579b);     // Catch: Throwable -> L26
            if (r101.f406485d.get(r102) == r100) goto L8;
            monitor-exit(r101);
            return;
        L8:
            String r103 = r101.f406489h;     // Catch: Throwable -> L26
            if (Intrinsics.areEqual(r103, r102) == false) goto L13;
            r101.a(r102);     // Catch: Throwable -> L26
            r101.g(r100);     // Catch: Throwable -> L26
            int r104 = t.f407207a;     // Catch: Throwable -> L26
            t.d("AINoteContext", "pin current ui session unchanged, userId=" + r101.f406482a + ", key=" + r102);     // Catch: Throwable -> L26
            monitor-exit(r101);
            return;
        L13:
            r101.f406489h = r102;     // Catch: Throwable -> L26
            r101.a(r102);     // Catch: Throwable -> L26
            int r105 = t.f407207a;     // Catch: Throwable -> L26
            t.d("AINoteContext", "pin current ui session, userId=" + r101.f406482a + ", key=" + r102 + ", previous=" + r103);     // Catch: Throwable -> L26
            if (r103 != null) goto L16;
        L23:
            r101.g(r100);     // Catch: Throwable -> L26
            monitor-exit(r101);
            return;
        L16:
            if ((!Intrinsics.areEqual(r103, r102)) == true) goto L19;
            r103 = null;
        L19:
            if (r103 == null) goto L23;
            AINotesSession r106 = r101.f406485d.get(r103);     // Catch: Throwable -> L26
            if (r106 == null) goto L23;
            r101.g(r106);     // Catch: Throwable -> L26
        L26:
            th = move-exception;
            throw th;
        }

        @Override // com.ss.android.ainote.AINotesSession.f
        public final void b(AINotesSession r100) {
            Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
            this.f406506a.g(r100);
        }
    }

    static {
    }

    public final synchronized void c() {
        monitor-enter(this);
        this.f406489h = null;     // Catch: Throwable -> L21
        Iterator<T> r100 = this.f406486e.values().iterator();     // Catch: Throwable -> L21
    L6:
        if (r100.hasNext() == false) goto L8;
        Job.DefaultImpls.cancel$default((Job) r100.next(), null, 1, null);     // Catch: Throwable -> L21
        goto L6
    L8:
        this.f406486e.clear();     // Catch: Throwable -> L21
        b(MapMonitorConst.EVENT_DESTROY);     // Catch: Throwable -> L21
        this.f406491j.a();     // Catch: Throwable -> L21
        this.f406492k.f406510b.clear();     // Catch: Throwable -> L21
        List r101 = CollectionsKt.toList(this.f406485d.values());     // Catch: Throwable -> L21
        this.f406485d.clear();     // Catch: Throwable -> L21
        Iterator r102 = r101.iterator();     // Catch: Throwable -> L21
    L10:
        if (r102.hasNext() == false) goto L13;
        ((AINotesSession) r102.next()).B();     // Catch: Throwable -> L21
        goto L10
    L13:
        if (this.f406499r == false) goto L16;
        AppLifecycle r103 = AppLifecycle.a.f408803a;     // Catch: Throwable -> L21
        r103.f408785h.remove(this.f406495n);     // Catch: Throwable -> L21
        this.f406499r = false;     // Catch: Throwable -> L21
    L16:
        if (this.f406500s == false) goto L18;
        LarkContext.getApplication().unregisterComponentCallbacks(this.f406496o);     // Catch: Throwable -> L21
        this.f406500s = false;     // Catch: Throwable -> L21
    L18:
        this.f406497p = false;     // Catch: Throwable -> L21
        this.f406498q = false;     // Catch: Throwable -> L21
        int r104 = t.f407207a;     // Catch: Throwable -> L21
        t.d("AINoteContext", "destroy, userId=" + this.f406482a + ", sessionCount=" + r101.size());     // Catch: Throwable -> L21
        monitor-exit(this);
        return;
    L21:
        th = move-exception;
        throw th;
    }

    public final synchronized void d() {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.f406497p == false) goto L19;
        monitor-exit(this);
        return;
    L19:
        AINoteImageDownloadCoordinator r100 = this.f406492k;     // Catch: Exception -> L10 Throwable -> L15
        new z(LarkContext.getApplication());     // Catch: Exception -> L10 Throwable -> L15
        r100.getClass();     // Catch: Exception -> L10 Throwable -> L15
        this.f406491j.f406514d = new b0();     // Catch: Exception -> L10 Throwable -> L15
        i();     // Catch: Exception -> L10 Throwable -> L15
        this.f406497p = true;     // Catch: Exception -> L10 Throwable -> L15
        int r101 = t.f407207a;     // Catch: Exception -> L10 Throwable -> L15
        t.d("AINoteContext", "ensureInitialized, userId=" + this.f406482a + ", passport=" + this.f406484c.getClass().getSimpleName() + ", rustClient=" + this.f406483b.getClass().getSimpleName());     // Catch: Exception -> L10 Throwable -> L15
    L13:
        monitor-exit(this);
        return;
    L10:
        e = move-exception;
        this.f406497p = false;     // Catch: Throwable -> L15
        int r102 = t.f407207a;     // Catch: Throwable -> L15
        t.c("AINoteContext", "ensureInitialized failed, userId=" + this.f406482a, e);     // Catch: Throwable -> L15
        goto L13
    }

    public final void i() {
        h0.f406759a.getClass();
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L33
        String r101 = com.ss.android.lark.appsetting.api.e.a.f408951a.c(AppSettingApiModule.a().getUid(), "vc_personal_note_config", true);     // Catch: Throwable -> L33
        if (r101 != null) goto L6;
        r101 = "";
    L6:
        boolean r110 = h0.b("vc.recording.personal_notes_live_rewriting");     // Catch: Throwable -> L33
        boolean r111 = h0.b("vc.ai_view.personal_notes_live_rewriting");     // Catch: Throwable -> L33
        if (StringsKt.isBlank(r101) == false) goto L9;
    L31:
        g0 r102 = new g0(r110, r111, 15);     // Catch: Throwable -> L33
    L42:
        this.f406494m = r102;
        int r103 = t.f407207a;
        t.d("AINoteContext", "loadRuntimeConfig, config=" + this.f406494m);
        return;
    L9:
        if (Intrinsics.areEqual(r101, "null") == true) goto L31;
        JSONObject r104 = JSON.parseObject(r101);     // Catch: Throwable -> L33
        Long r105 = h0.a(r104, "auto_save_interval_ms");     // Catch: Throwable -> L33
        if (r105 == null) goto L14;
        long r106 = r105.longValue();     // Catch: Throwable -> L33
    L15:
        Long r107 = h0.a(r104, "idle_save_timeout_s");     // Catch: Throwable -> L33
        if (r107 == null) goto L18;
        long r108 = r107.longValue();     // Catch: Throwable -> L33
    L19:
        Long r109 = h0.a(r104, "mark_throttle_interval_ms");     // Catch: Throwable -> L33
        if (r109 == null) goto L22;
        long r112 = r109.longValue();     // Catch: Throwable -> L33
    L24:
        if (r104.containsKey("max_image_count") == false) goto L26;
        Integer r113 = Integer.valueOf(r104.getIntValue("max_image_count"));     // Catch: Throwable -> L33
    L27:
        if (r113 == null) goto L29;
        int r114 = r113.intValue();     // Catch: Throwable -> L33
    L30:
        Object r115 = Result.m9449constructorimpl(new g0(r106, r108 * 1000, r112, r114, r110, r111));     // Catch: Throwable -> L33
    L35:
        Throwable r116 = Result.m9452exceptionOrNullimpl(r115);
        if (r116 == null) goto L38;
        t.c("AINoteRuntimeConfigLoader", "load failed", r116);
    L38:
        g0 r117 = new g0(false, false, 63);
        if (Result.m9455isFailureimpl(r115) == false) goto L41;
        r115 = r117;
    L41:
        r102 = (g0) r115;
        goto L42
    L29:
        r114 = 15;
        goto L30
    L26:
        r113 = null;
        goto L27
    L22:
        r112 = 2000;
        goto L24
    L18:
        r108 = 60;
        goto L19
    L14:
        r106 = 1000;
    L33:
        th = move-exception;
        Result.Companion r118 = Result.Companion;
        r115 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L35
    }

    public final synchronized void k() {
        monitor-enter(this);
        List<String> r100 = this.f406493l.e(this.f406482a);     // Catch: Throwable -> L30
        if (r100.isEmpty() == false) goto L9;
        int r101 = t.f407207a;     // Catch: Throwable -> L30
        t.d("AINoteContext", "recoverPendingNotes skip, no cached sessions, userId=" + this.f406482a);     // Catch: Throwable -> L30
        monitor-exit(this);
        return;
    L9:
        int r102 = t.f407207a;     // Catch: Throwable -> L30
        t.d("AINoteContext", "recoverPendingNotes, userId=" + this.f406482a + ", cachedSessionCount=" + r100.size());     // Catch: Throwable -> L30
        Iterator<T> r103 = r100.iterator();     // Catch: Throwable -> L30
    L11:
        if (r103.hasNext() == false) goto L28;
        String r104 = (String) r103.next();     // Catch: Throwable -> L30
        b r105 = j(r104);     // Catch: Throwable -> L30
        if (r105 == null) goto L11;
        String r106 = n(r105.f406502a, r105.f406503b);     // Catch: Throwable -> L30
        this.f406487f.add(r106);     // Catch: Throwable -> L30
        AINotesSession r107 = f(r105.f406502a, r105.f406503b);     // Catch: Throwable -> L23
        if (r107.o0() == false) goto L19;
        int r108 = t.f407207a;     // Catch: Throwable -> L23
        t.d("AINoteContext", "recoverPendingNotes flush, userId=" + this.f406482a + ", key=" + r104);     // Catch: Throwable -> L23
        r107.I();     // Catch: Throwable -> L23
    L20:
        this.f406487f.remove(r106);     // Catch: Throwable -> L30
        AINotesSession r109 = this.f406485d.get(r106);     // Catch: Throwable -> L30
        if (r109 == null) goto L11;
        g(r109);     // Catch: Throwable -> L30
        goto L11
    L19:
        int r110 = t.f407207a;     // Catch: Throwable -> L23
        t.d("AINoteContext", "recoverPendingNotes skip flush, userId=" + this.f406482a + ", key=" + r104);     // Catch: Throwable -> L23
        goto L20
    L23:
        th = move-exception;
        this.f406487f.remove(r106);     // Catch: Throwable -> L30
        AINotesSession r111 = this.f406485d.get(r106);     // Catch: Throwable -> L30
        if (r111 == null) goto L27;
        g(r111);     // Catch: Throwable -> L30
    L27:
        throw th;     // Catch: Throwable -> L30
    L28:
        monitor-exit(this);
        return;
    L30:
        th = move-exception;
        throw th;
    }

    public static boolean h(xra.a r100) {
        if (r100.f564910o == false) goto L6;
        return false;
    L6:
        if (r100.f564897b <= 0) goto L9;
        return true;
    L9:
        if ((!StringsKt.isBlank(r100.d())) == false) goto L12;
        return true;
    L12:
        if ((!StringsKt.isBlank(r100.a())) == false) goto L15;
        return true;
    L15:
        if ((!r100.f564903h.isEmpty()) == false) goto L17;
        return true;
    L17:
        return false;
    }

    public static b j(String r100) {
        String r101 = null;
        int r102 = 6;
        if (StringsKt.startsWith$default(r100, "meeting:", false, 2, null) == false) goto L7;
        b r103 = new b(new com.ss.android.ainote.d(StringsKt.removePrefix(r100, "meeting:"), r101, r102), AINoteScene.Meeting);
    L12:
        return r103;
    L7:
        if (StringsKt.startsWith$default(r100, "record:", false, 2, null) == false) goto L10;
        r103 = new b(new com.ss.android.ainote.d(StringsKt.removePrefix(r100, "record:"), r101, r102), AINoteScene.Record);
        goto L12
    L10:
        if (StringsKt.startsWith$default(r100, "hardware:", false, 2, null) == false) goto L13;
        r103 = new b(new com.ss.android.ainote.d(StringsKt.removePrefix(r100, "hardware:"), r101, r102), AINoteScene.Hardware);
        goto L12
    L13:
        return null;
    }

    public final synchronized void a(String r100) {
        monitor-enter(this);
        Job r101 = this.f406486e.remove(r100);     // Catch: Throwable -> L8
        if (r101 == null) goto L6;
        Job.DefaultImpls.cancel$default(r101, null, 1, null);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final synchronized void b(String r110) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.f406488g.isEmpty() == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        String r100 = CollectionsKt.joinToString$default(this.f406488g.keySet(), null, "[", "]", 0, null, null, 57, null);     // Catch: Throwable -> L11
        this.f406488g.clear();     // Catch: Throwable -> L11
        int r101 = t.f407207a;     // Catch: Throwable -> L11
        t.d("AINoteContext", "clear headless scene event callbacks, userId=" + this.f406482a + ", reason=" + r110 + ", scenes=" + r100);     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    public final synchronized void e(String r100) {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.f406497p == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        Iterator<T> r101 = this.f406485d.values().iterator();     // Catch: Throwable -> L14
    L9:
        if (r101.hasNext() == false) goto L12;
        AINotesSession r102 = (AINotesSession) r101.next();     // Catch: Throwable -> L14
        String r103 = n(r102.f406577a, r102.f406579b);     // Catch: Throwable -> L14
        int r104 = t.f407207a;     // Catch: Throwable -> L14
        t.d("AINoteContext", "flush session on app lifecycle, trigger=" + r100 + ", key=" + r103);     // Catch: Throwable -> L14
        r102.I();     // Catch: Throwable -> L14
        goto L9
    L12:
        monitor-exit(this);
    }

    public final synchronized void g(AINotesSession r100) {
        monitor-enter(this);
        String r101 = n(r100.f406577a, r100.f406579b);     // Catch: Throwable -> L31
        if (this.f406485d.get(r101) == r100) goto L9;
        monitor-exit(this);
        return;
    L9:
        if (this.f406487f.contains(r101) == false) goto L13;
        a(r101);     // Catch: Throwable -> L31
        int r102 = t.f407207a;     // Catch: Throwable -> L31
        t.d("AINoteContext", "skip retention while recovering, userId=" + this.f406482a + ", key=" + r101);     // Catch: Throwable -> L31
        monitor-exit(this);
        return;
    L13:
        int r103 = t.f407207a;     // Catch: Throwable -> L31
        t.d("AINoteContext", "handleSessionRetentionChanged, userId=" + this.f406482a + ", key=" + r101 + ", shouldRetain=" + r100.E0());     // Catch: Throwable -> L31
        boolean r104 = false;
        if (r100.E0() == false) goto L17;
        a(r101);     // Catch: Throwable -> L31
        t.d("AINoteContext", "keep session alive, userId=" + this.f406482a + ", key=" + r101);     // Catch: Throwable -> L31
    L27:
        if (r104 == false) goto L29;
        t.d("AINoteContext", "release session immediately after biz end, userId=" + this.f406482a + ", key=" + r101);     // Catch: Throwable -> L31
        r100.B();     // Catch: Throwable -> L31
    L29:
        monitor-exit(this);
        return;
    L17:
        if (r100.T == 0) goto L19;
    L21:
        boolean r105 = false;
    L22:
        if (r105 == false) goto L26;
        a(r101);     // Catch: Throwable -> L31
        if (this.f406485d.remove(r101) != r100) goto L27;
        r104 = true;
        goto L27
    L26:
        m(r100);     // Catch: Throwable -> L31
        goto L27
    L19:
        if (r100.f406591h.invoke().booleanValue() == true) goto L21;
        r105 = true;
    L31:
        th = move-exception;
        throw th;
    }

    public final synchronized void l(String r100) {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.f406498q == false) goto L9;
        int r101 = t.f407207a;     // Catch: Throwable -> L12
        t.d("AINoteContext", r100.concat(" skip recoverPendingNotes, already recovered"));     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L9:
        k();     // Catch: Throwable -> L12
        this.f406498q = true;     // Catch: Throwable -> L12
        monitor-exit(this);
    }

    public final synchronized void m(AINotesSession r110) {
        monitor-enter(this);
        String r100 = n(r110.f406577a, r110.f406579b);     // Catch: Throwable -> L17
        Job r101 = this.f406486e.get(r100);     // Catch: Throwable -> L17
        if (r101 != null) goto L7;
    L10:
        boolean r102 = false;
    L11:
        if (r102 == false) goto L14;
        monitor-exit(this);
        return;
    L14:
        this.f406486e.put(r100, BuildersKt.launch$default(this.f406490i, null, null, new AINoteContext$scheduleRelease$1(this, r100, r110, null), 3, null));     // Catch: Throwable -> L17
        int r111 = t.f407207a;     // Catch: Throwable -> L17
        t.d("AINoteContext", "schedule session release, userId=" + this.f406482a + ", key=" + r100 + ", delayMs=30000");     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L7:
        r102 = true;
        if (r101.isActive() != true) goto L10;
    L17:
        th = move-exception;
        throw th;
    }

    public static String n(com.ss.android.ainote.d r100, AINoteScene r101) {
        if (r101 == AINoteScene.UNKNOWN) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L10;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "scene");
        return r101.name() + ':' + r100.f406694a;
    L10:
        throw new IllegalArgumentException("scene=UNKNOWN cannot create session key".toString());
    L5:
        r102 = false;
        goto L6
    }

    public final synchronized AINotesSession f(com.ss.android.ainote.d r110, AINoteScene r111) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r110, "bizIds");     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r111, "scene");     // Catch: Throwable -> L12
        d();     // Catch: Throwable -> L12
        i();     // Catch: Throwable -> L12
        final String r100 = n(r110, r111);     // Catch: Throwable -> L12
        AINotesSession r101 = this.f406485d.get(r100);     // Catch: Throwable -> L12
        if (r101 == null) goto L9;
        a(r100);     // Catch: Throwable -> L12
        int r102 = t.f407207a;     // Catch: Throwable -> L12
        t.d("AINoteContext", "reuse notes session, userId=" + this.f406482a + ", key=" + r100);     // Catch: Throwable -> L12
        monitor-exit(this);
        return r101;
    L9:
        AINotesSession r103 = new AINotesSession(r110, r111, this.f406482a, this.f406483b, this.f406494m, this.f406491j, this.f406492k, new AINoteContext$getOrCreateSession$created$1(this), new AINoteContext$getOrCreateSession$created$2(this, r100), new AINoteContext$getOrCreateSession$created$3(this), new e(this));     // Catch: Throwable -> L12
        this.f406485d.put(r100, r103);     // Catch: Throwable -> L12
        a(r100);     // Catch: Throwable -> L12
        int r104 = t.f407207a;     // Catch: Throwable -> L12
        t.d("AINoteContext", "create notes session, userId=" + this.f406482a + ", key=" + r100);     // Catch: Throwable -> L12
        g(r103);     // Catch: Throwable -> L12
        monitor-exit(this);
        return r103;
    L12:
        th = move-exception;
        throw th;
    }

    public AINoteContext(String r100, com.bytedance.lark.rustclient.api.l r101, com.ss.android.lark.passportc.api.m r102) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r101, "rustClient");
        Intrinsics.checkNotNullParameter(r102, "passportUserService");
        this.f406482a = r100;
        this.f406483b = r101;
        this.f406484c = r102;
        this.f406485d = new LinkedHashMap();
        this.f406486e = new LinkedHashMap();
        this.f406487f = new LinkedHashSet();
        this.f406488g = new LinkedHashMap();
        this.f406490i = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        this.f406491j = new AINoteImageUploadCoordinator();
        this.f406492k = new AINoteImageDownloadCoordinator();
        this.f406493l = new AINoteCacheStore(LarkContext.getApplication());
        this.f406494m = new g0(false, false, 63);
        this.f406495n = new d(this);
        this.f406496o = new c(this);
    }
}
