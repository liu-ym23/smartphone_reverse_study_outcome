package com.larus.office.card.urlpreview;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.ArtifactBlock;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.FileBlock;
import com.larus.platform.service.LarkConnectorArtifactService;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.url.card.UrlCardProperty;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.WeakHashMap;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes29.dex */
public final class OfficeUrlPreviewCoordinator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f361720a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CoroutineScope f361721b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Handler f361722c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final LinkedHashMap<String, e> f361723d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map<String, String> f361724e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final LinkedHashMap<String, b1> f361725f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Map<r, s> f361726g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Map<r, s> f361727h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Map<String, b1> f361728i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final OfficeUrlPreviewCoordinator$previewStates$1 f361729j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final OfficeUrlPreviewCoordinator$renderFailures$1 f361730k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Set<String> f361731l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Set<String> f361732m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final OfficeUrlPreviewCoordinator$automaticallyRetriedPreviewKeys$1 f361733n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final OfficeUrlPreviewCoordinator$stalePreviewRefreshAttempts$1 f361734o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Set<c2> f361735p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final OfficeUrlPreviewCoordinator$stalePreviewOrigins$1 f361736q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final WeakHashMap<Object, a> f361737r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static long f361738s;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f361739a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f361740b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final c2 f361741c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Function1<String, Unit> f361742d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f361739a, r101.f361739a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f361740b, r101.f361740b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f361741c, r101.f361741c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f361742d, r101.f361742d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f361739a.hashCode() * 31;
            String r101 = this.f361740b;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            c2 r105 = this.f361741c;
            if (r105 != null) goto L9;
            int r106 = 0;
        L10:
            int r107 = (r104 + r106) * 31;
            Function1<String, Unit> r108 = this.f361742d;
            if (r108 == null) goto L15;
            r102 = r108.hashCode();
        L15:
            return r107 + r102;
        L9:
            r106 = r105.hashCode();
            goto L10
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "HolderBinding(messageIdentity=" + this.f361739a + ", serverMessageId=" + this.f361740b + ", requestKey=" + this.f361741c + ", invalidator=" + this.f361742d + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(String r100, String r101, c2 r102, Function1<? super String, Unit> r103) {
            Intrinsics.checkNotNullParameter(r100, "messageIdentity");
            this.f361739a = r100;
            this.f361740b = r101;
            this.f361741c = r102;
            this.f361742d = r103;
        }
    }

    public interface b {

        public static final class a implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final long f361743a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof a) == true) goto L9;
                return false;
            L9:
                if (this.f361743a == ((a) r100).f361743a) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                long r100 = this.f361743a;
                return (int) (r100 ^ (r100 >>> 32));
            }

            public final String toString() {
                return "Failed(failedAtMs=" + this.f361743a + ')';
            }

            public a(long r100) {
                this.f361743a = r100;
            }
        }

        /* JADX INFO: renamed from: com.larus.office.card.urlpreview.OfficeUrlPreviewCoordinator$b$b, reason: collision with other inner class name */
        public static final class C4442b implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C4442b f361744a = null;

            static {
                f361744a = new C4442b();
            }

            public C4442b() {
            }

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof C4442b) == true) goto L9;
                return false;
            L9:
                C4442b r101 = (C4442b) r100;
                return true;
            }

            public final int hashCode() {
                return 434589363;
            }

            public final String toString() {
                return "Loading";
            }
        }

        public static final class c implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final z0 f361745a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof c) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.f361745a, ((c) r100).f361745a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.f361745a.hashCode();
            }

            public final String toString() {
                return "Ready(previewInfo=" + this.f361745a + ')';
            }

            public c(z0 r100) {
                Intrinsics.checkNotNullParameter(r100, "previewInfo");
                this.f361745a = r100;
            }
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final r f361746a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f361747b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f361746a, r101.f361746a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f361747b, r101.f361747b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f361746a.hashCode() * 31) + this.f361747b.hashCode();
        }

        public final String toString() {
            return "RenderFailureKey(blockKey=" + this.f361746a + ", previewId=" + this.f361747b + ')';
        }

        public c(r r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "blockKey");
            Intrinsics.checkNotNullParameter(r101, "previewId");
            this.f361746a = r100;
            this.f361747b = r101;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c2 f361748a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f361749b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (Intrinsics.areEqual(this.f361748a, r101.f361748a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f361749b, r101.f361749b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f361748a.hashCode() * 31) + this.f361749b.hashCode();
        }

        public final String toString() {
            return "StalePreviewKey(requestKey=" + this.f361748a + ", previewId=" + this.f361749b + ')';
        }

        public d(c2 r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "requestKey");
            Intrinsics.checkNotNullParameter(r101, "previewId");
            this.f361748a = r100;
            this.f361749b = r101;
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f361750a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final l2 f361751b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L8;
            return false;
        L8:
            e r101 = (e) r100;
            if (this.f361750a == r101.f361750a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f361751b, r101.f361751b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f361750a;
            return (((int) (r100 ^ (r100 >>> 32))) * 31) + this.f361751b.hashCode();
        }

        public final String toString() {
            return "VersionedSourceSnapshot(generation=" + this.f361750a + ", snapshot=" + this.f361751b + ')';
        }

        public e(long r100, l2 r101) {
            Intrinsics.checkNotNullParameter(r101, "snapshot");
            this.f361750a = r100;
            this.f361751b = r101;
        }
    }

    public OfficeUrlPreviewCoordinator() {
    }

    static {
        f361720a = new Object();
        f361721b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        f361722c = new Handler(Looper.getMainLooper());
        f361723d = new LinkedHashMap();
        f361724e = new LinkedHashMap();
        f361725f = new LinkedHashMap();
        f361726g = new LinkedHashMap();
        f361727h = new LinkedHashMap();
        f361728i = new LinkedHashMap();
        f361729j = new OfficeUrlPreviewCoordinator$previewStates$1();
        f361730k = new OfficeUrlPreviewCoordinator$renderFailures$1();
        f361731l = new LinkedHashSet();
        f361732m = new LinkedHashSet();
        f361733n = new OfficeUrlPreviewCoordinator$automaticallyRetriedPreviewKeys$1();
        f361734o = new OfficeUrlPreviewCoordinator$stalePreviewRefreshAttempts$1();
        f361735p = new LinkedHashSet();
        f361736q = new OfficeUrlPreviewCoordinator$stalePreviewOrigins$1();
        f361737r = new WeakHashMap();
    }

    public static final void a(final String r100) {
        Object r101 = f361720a;
        monitor-enter(r101);
        Set r102 = SequencesKt.toSet(SequencesKt.map(SequencesKt.filter(CollectionsKt.asSequence(f361723d.values()), new k0(r100)), new l0()));     // Catch: Throwable -> L11
        monitor-exit(r101);
        Iterator r103 = r102.iterator();
    L8:
        if (r103.hasNext() == false) goto L10;
        n((String) r103.next());
        goto L8
    L10:
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public static s d(r r100) {
        e r101 = i(r100.f362013a);
        if (r101 == null) goto L11;
        l2 r102 = r101.f361751b;
        if (r102 == null) goto L11;
        Map<r, s> r103 = r102.f361973d;
        if (r103 == null) goto L11;
        s r104 = r103.get(r100);
        if (r104 == null) goto L11;
        return r104;
    L11:
        return (s) ((LinkedHashMap) f361726g).get(r100);
    }

    public static b1 e(String r100) {
        e r101 = i(r100);
        if (r101 == null) goto L9;
        l2 r102 = r101.f361751b;
        if (r102 == null) goto L9;
        Map<String, b1> r103 = r102.f361972c;
        if (r103 == null) goto L9;
        b1 r104 = r103.get(r100);
    L10:
        b1 r105 = f361725f.get(r100);
        if (r104 != null) goto L13;
        return r105;
    L13:
        if (r105 != null) goto L15;
        return r104;
    L15:
        List<s> r106 = r104.f361863c;
        LinkedHashSet r107 = new LinkedHashSet();
        Iterator<T> r108 = r106.iterator();
    L17:
        if (r108.hasNext() == false) goto L19;
        r107.add(((s) r108.next()).f362018a);
        goto L17
    L19:
        List<s> r109 = r104.f361863c;
        List<s> r110 = r105.f361863c;
        ArrayList r111 = new ArrayList();
        Iterator<T> r112 = r110.iterator();
    L21:
        if (r112.hasNext() == false) goto L25;
        Object r113 = r112.next();
        if ((!r107.contains(((s) r113).f362018a)) == false) goto L21;
        r111.add(r113);
        goto L21
    L25:
        List r114 = CollectionsKt.plus(r109, r111);
        String r115 = r104.f361861a;
        Message r116 = r104.f361862b;
        Intrinsics.checkNotNullParameter(r115, "messageIdentity");
        Intrinsics.checkNotNullParameter(r116, "message");
        Intrinsics.checkNotNullParameter(r114, "blocks");
        return new b1(r115, r116, r114);
    L9:
        r104 = null;
        goto L10
    }

    public static void f(b1 r110) {
        if (x0.a() == true) goto L5;
        return;
    L5:
        String r100 = r110.f361862b.getMessageId();
        if (r100 != null) goto L8;
    L10:
        r100 = null;
    L11:
        final String r101 = r100;
        if (r101 != null) goto L14;
        return;
    L14:
        LinkedHashMap r102 = new LinkedHashMap();
        Object r103 = f361720a;
        monitor-enter(r103);
        Set<String> r104 = f361731l;     // Catch: Throwable -> L35
        if (r104.contains(r101) == false) goto L20;
        monitor-exit(r103);
        return;
    L20:
        final long r105 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L35
        List r106 = SequencesKt.toList(SequencesKt.filter(SequencesKt.distinct(SequencesKt.mapNotNull(SequencesKt.filter(CollectionsKt.asSequence(r110.f361863c), new o0()), OfficeUrlPreviewCoordinator$ensurePreviewIds$requestUrls$1$urls$2.INSTANCE)), new p0(r101, r105)));     // Catch: Throwable -> L35
        if (r106.isEmpty() == false) goto L24;
        monitor-exit(r103);
        return;
    L24:
        r104.add(r101);     // Catch: Throwable -> L35
        Iterator r107 = r106.iterator();     // Catch: Throwable -> L35
    L25:
        if (r107.hasNext() == false) goto L32;
        c2 r108 = new c2(r101, (String) r107.next());     // Catch: Throwable -> L35
        z0 r109 = (z0) f361736q.get(r108);     // Catch: Throwable -> L35
        if (r109 == null) goto L29;
        r102.put(r108, r109);     // Catch: Throwable -> L35
        goto L25
    L29:
        f361729j.put(r108, b.C4442b.f361744a);     // Catch: Throwable -> L35
        goto L25
    L32:
        monitor-exit(r103);
        BuildersKt.launch$default(f361721b, null, null, new OfficeUrlPreviewCoordinator$ensurePreviewIds$1(r101, r106, r110, r102, null), 3, null);
        return;
    L35:
        th = move-exception;
        throw th;
    L8:
        if ((!StringsKt.isBlank(r100)) == false) goto L10;
        goto L10
    }

    public static boolean g(b1 r110) {
        String r100 = r110.f361862b.getMessageId();
        if (r100 != null) goto L5;
    L118:
        return false;
    L5:
        if ((!StringsKt.isBlank(r100)) == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L118;
        p r101 = p.f362001a;
        Message r102 = r110.f361862b;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "message");
        Map<String, String> r103 = r102.getBusinessExt();
        if (r103 == null) goto L70;
        String r104 = r103.get(UrlCardProperty.URL_PREVIEW_BUSINESS_TYPE);
        if (r104 == null) goto L70;
        if ((!StringsKt.isBlank(r104)) == true) goto L18;
        r104 = null;
    L18:
        if (r104 == null) goto L70;
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L22
        Object r106 = Result.m9449constructorimpl((p.a) p.f362002b.fromJson(r104, p.a.class));     // Catch: Throwable -> L22
    L25:
        if (Result.m9455isFailureimpl(r106) == false) goto L27;
        r106 = null;
    L27:
        p.a r107 = (p.a) r106;
        if (r107 != null) goto L31;
        Map r108 = MapsKt.emptyMap();
    L72:
        if (r108.isEmpty() == false) goto L74;
        return false;
    L74:
        Iterator<T> r111 = r110.f361863c.iterator();
        boolean r109 = false;
    L76:
        if (r111.hasNext() == false) goto L117;
        s r112 = (s) r111.next();
        String r113 = r112.f362023f;
        if (r113 == null) goto L76;
        String r114 = r112.f362022e.getResourceId();
        if (r114 != null) goto L83;
        r114 = "";
    L83:
        p.c r115 = (p.c) r108.get(r112.f362019b);
        if (r115 == null) goto L76;
        if (Intrinsics.areEqual(r115.f362004b, r113) == true) goto L88;
    L90:
        boolean r116 = false;
    L91:
        if (r116 == true) goto L94;
        r115 = null;
    L94:
        if (r115 == null) goto L76;
        c2 r117 = new c2(r100, r113);
        Object r118 = f361720a;
        monitor-enter(r118);
        z0 r119 = (z0) f361736q.get(r117);     // Catch: Throwable -> L114
        if (r119 == null) goto L101;
        String r120 = r119.f362052a;     // Catch: Throwable -> L114
    L102:
        monitor-exit(r118);
        if (Intrinsics.areEqual(r115.f362003a.f362052a, r120) == true) goto L76;
        monitor-enter(r118);
        b r121 = f361729j.put(r117, new b.c(r115.f362003a));     // Catch: Throwable -> L111
        monitor-exit(r118);
        OfficeUrlPreviewPlatformBridge.f361768a.b(r100, r113, r115.f362003a);
        if (Intrinsics.areEqual(r121, new b.c(r115.f362003a)) == true) goto L76;
        r109 = true;
    L111:
        th = move-exception;
        throw th;
    L101:
        r120 = null;
    L114:
        th = move-exception;
        throw th;
    L88:
        if (Intrinsics.areEqual(r115.f362005c, r114) == false) goto L90;
        r116 = true;
        goto L91
    L117:
        return r109;
    L31:
        if (r107.b() == 1) goto L33;
        r108 = MapsKt.emptyMap();
        goto L72
    L33:
        Map<String, p.b> r122 = r107.a();
        if (r122 != null) goto L36;
        r122 = MapsKt.emptyMap();
    L36:
        ArrayList r123 = new ArrayList();
        Iterator<Map.Entry<String, p.b>> r124 = r122.entrySet().iterator();
    L38:
        if (r124.hasNext() == false) goto L69;
        Map.Entry<String, p.b> r125 = r124.next();
        String r126 = r125.getKey();
        p.b r127 = r125.getValue();
        if (r127 == null) goto L66;
        String r128 = r127.b();
        if (r128 == null) goto L66;
        if ((!StringsKt.isBlank(r128)) == true) goto L48;
        r128 = null;
    L48:
        if (r128 == null) goto L66;
        String r129 = r127.d();
        if (r129 == null) goto L66;
        if ((!StringsKt.isBlank(r129)) == true) goto L56;
        r129 = null;
    L56:
        if (r129 == null) goto L66;
        Boolean r130 = r127.a();
        if (r130 == null) goto L61;
        boolean r131 = r130.booleanValue();
    L62:
        z0 r132 = new z0(r128, r131);
        String r133 = r127.c();
        if (r133 != null) goto L65;
        r133 = "";
    L65:
        Pair r134 = TuplesKt.to(r126, new p.c(r132, r129, r133));
    L67:
        if (r134 == null) goto L38;
        r123.add(r134);
        goto L38
    L61:
        r131 = false;
    L66:
        r134 = null;
        goto L67
    L69:
        r108 = MapsKt.toMap(r123);
    L22:
        th = move-exception;
        Result.Companion r135 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L70:
        r108 = MapsKt.emptyMap();
        goto L72
    }

    public static void h(final Set r100) {
        if (r100.isEmpty() == false) goto L5;
        return;
    L5:
        f361722c.post(new m0(r100));
    }

    public static e i(final String r100) {
        Iterator r101 = SequencesKt.filter(CollectionsKt.asSequence(f361723d.values()), new c0(r100)).iterator();
        if (r101.hasNext() == true) goto L5;
        Object r102 = null;
    L16:
        return (e) r102;
    L5:
        Object r103 = r101.next();
        if (r101.hasNext() == true) goto L8;
    L7:
        r102 = r103;
        goto L16
    L8:
        long r104 = ((e) r103).f361750a;
    L9:
        Object r105 = r101.next();
        long r106 = ((e) r105).f361750a;
        if (r104 >= r106) goto L13;
        r103 = r105;
        r104 = r106;
    L13:
        if (r101.hasNext() == true) goto L9;
        goto L7
    }

    public static Set l(l2 r100) {
        LinkedHashMap<String, e> r101 = f361723d;
        e r102 = r101.remove(r100.f361970a);
        long r103 = f361738s + 1;
        f361738s = r103;
        r101.put(r100.f361970a, new e(r103, r100));
        List r104 = CollectionsKt.createListBuilder();
    L3:
        LinkedHashMap<String, e> r105 = f361723d;
        if (r105.size() <= 32) goto L13;
        String r106 = (String) CollectionsKt.firstOrNull(r105.keySet());
        if (r106 == null) goto L13;
        e r107 = r105.remove(r106);
        if (r107 == null) goto L3;
        l2 r108 = r107.f361751b;
        if (r108 == null) goto L3;
        f361724e.remove(r106);
        r104.add(r108);
    L13:
        List r109 = CollectionsKt.build(r104);
        Set r110 = SetsKt.createSetBuilder();
        Set<String> r111 = null;
        if (r102 == null) goto L18;
        l2 r112 = r102.f361751b;
        if (r112 == null) goto L18;
        Map<r, s> r113 = r112.f361973d;
    L19:
        if (r113 != null) goto L21;
        r113 = MapsKt.emptyMap();
    L21:
        r110.addAll(r113.keySet());
        r110.addAll(r100.f361973d.keySet());
        List r114 = r109;
        Iterator r115 = r114.iterator();
    L23:
        if (r115.hasNext() == false) goto L25;
        r110.addAll(((l2) r115.next()).f361973d.keySet());
        goto L23
    L25:
        Set r116 = SetsKt.build(r110);
        LinkedHashSet r117 = new LinkedHashSet();
        Iterator r118 = r116.iterator();
    L27:
        if (r118.hasNext() == false) goto L52;
        r r119 = (r) r118.next();
        Map<r, s> r120 = f361727h;
        s r121 = (s) ((LinkedHashMap) r120).get(r119);
        s r122 = d(r119);
        if (r122 != null) goto L31;
        r120.remove(r119);
    L32:
        if (r121 == null) goto L34;
        Boolean r123 = Boolean.valueOf(r121.f362024g);
    L35:
        if (r122 == null) goto L37;
        Boolean r124 = Boolean.valueOf(r122.f362024g);
    L39:
        if (Intrinsics.areEqual(r123, r124) == true) goto L27;
        if (r121 == null) goto L46;
        r r125 = r121.f362018a;
        if (r125 == null) goto L46;
        String r126 = r125.f362013a;
        if (r126 == null) goto L46;
        r117.add(r126);
    L46:
        if (r122 == null) goto L27;
        r r127 = r122.f362018a;
        if (r127 == null) goto L27;
        String r128 = r127.f362013a;
        if (r128 == null) goto L27;
        r117.add(r128);
        goto L27
    L37:
        r124 = null;
        goto L39
    L34:
        r123 = null;
        goto L35
    L31:
        r120.put(r119, r122);
        goto L32
    L52:
        Set r129 = SetsKt.createSetBuilder();
        if (r102 == null) goto L57;
        l2 r130 = r102.f361751b;
        if (r130 == null) goto L57;
        r111 = r130.f361971b;
    L57:
        if (r111 != null) goto L59;
        r111 = SetsKt.emptySet();
    L59:
        r129.addAll(r111);
        r129.addAll(r100.f361971b);
        Iterator r131 = r114.iterator();
    L61:
        if (r131.hasNext() == false) goto L63;
        r129.addAll(((l2) r131.next()).f361971b);
        goto L61
    L63:
        Iterator r132 = SetsKt.build(r129).iterator();
    L65:
        if (r132.hasNext() == false) goto L70;
        String r133 = (String) r132.next();
        b1 r134 = e(r133);
        if (r134 == null) goto L68;
        f361728i.put(r133, r134);
        goto L65
    L68:
        f361728i.remove(r133);
        goto L65
    L70:
        return r117;
    L18:
        r113 = null;
        goto L19
    }

    public static void n(final String r110) {
        if (OfficeUrlPreviewPlatformBridge.f361768a.e(r110) == true) goto L5;
        return;
    L5:
        Object r100 = f361720a;
        monitor-enter(r100);
        e r101 = f361723d.get(r110);     // Catch: Throwable -> L26
        if (r101 == null) goto L24;
        l2 r102 = r101.f361751b;     // Catch: Throwable -> L26
        if (r102 == null) goto L24;
        final List r103 = SequencesKt.toList(SequencesKt.take(SequencesKt.distinctBy(SequencesKt.flatMap(CollectionsKt.asSequence(r102.f361972c.values()), new q0()), OfficeUrlPreviewCoordinator$prefetchSource$previewInfos$1$candidates$2.INSTANCE), 4));     // Catch: Throwable -> L26
        if (r103.isEmpty() == false) goto L16;
        monitor-exit(r100);
        return;
    L16:
        String r104 = CollectionsKt.joinToString$default(r103, HiAnalyticsConstant.REPORT_VAL_SEPARATOR, null, null, 0, null, new r0(), 30, null);     // Catch: Throwable -> L26
        Map<String, String> r105 = f361724e;     // Catch: Throwable -> L26
        if (Intrinsics.areEqual(((LinkedHashMap) r105).get(r110), r104) == false) goto L20;
        monitor-exit(r100);
        return;
    L20:
        r105.put(r110, r104);     // Catch: Throwable -> L26
        monitor-exit(r100);
        f361722c.post(new s0(r110, r103));
        return;
    L24:
        monitor-exit(r100);
        return;
    L26:
        th = move-exception;
        throw th;
    }

    public static void o(final c2 r100) {
        if (r100 == null) goto L20;
        Collection<a> r101 = f361737r.values();
        if (r101.isEmpty() == true) goto L12;
        Iterator<T> r102 = r101.iterator();
    L8:
        if (r102.hasNext() == false) goto L12;
        if (Intrinsics.areEqual(((a) r102.next()).f361741c, r100) == false) goto L8;
        boolean r103 = true;
    L13:
        if (r103 == true) goto L21;
        CollectionsKt.removeAll(f361734o.keySet(), new g0(r100));
        f361733n.remove(r100);
        return;
    L21:
        return;
    L12:
        r103 = false;
        goto L13
    }

    public static boolean q(s r100) {
        h2 r101 = h2.f361915a;
        ArtifactBlock r102 = r100.f362022e;
        r101.getClass();
        if (h2.d(r102) == true) goto L5;
        return false;
    L5:
        if (r100.f362023f == null) goto L24;
        String r103 = r100.f362022e.getResourceId();
        if (r103 != null) goto L9;
    L12:
        boolean r104 = true;
    L13:
        if (r104 == true) goto L25;
        Integer r105 = r100.f362022e.getResourceType();
        if (r105 == null) goto L20;
        if (r105.intValue() != 0) goto L20;
    L21:
        return true;
    L20:
        if (vn9.a.a(r100.f362022e) == false) goto L21;
        return false;
    L25:
        return false;
    L9:
        if (StringsKt.isBlank(r103) == true) goto L12;
        r104 = false;
        goto L13
    L24:
        return false;
    }

    public static a2 r(r r100) {
        Object r101 = f361720a;
        monitor-enter(r101);
        s r102 = (s) ((LinkedHashMap) f361727h).get(r100);     // Catch: Throwable -> L11
        monitor-exit(r101);
        if (r102 != null) goto L10;
        return null;
    L10:
        return s(r102);
    L11:
        th = move-exception;
        throw th;
    }

    public static a2 s(s r110) {
        String r100 = r110.f362020c.getMessageId();
        boolean r101 = true;
        if (r100 != null) goto L5;
    L7:
        r100 = null;
    L8:
        String r102 = r110.f362023f;
        h2 r103 = h2.f361915a;
        ArtifactBlock r104 = r110.f362022e;
        r103.getClass();
        if (h2.d(r104) == false) goto L62;
        if (r100 == null) goto L62;
        if (r102 == null) goto L62;
        String r105 = r110.f362022e.getResourceId();
        if (r105 != null) goto L15;
    L18:
        boolean r106 = true;
    L19:
        if (r106 == true) goto L62;
        Integer r107 = r110.f362022e.getResourceType();
        if (r107 == null) goto L26;
        if (r107.intValue() != 0) goto L26;
    L28:
        Object r108 = f361720a;
        monitor-enter(r108);
        b r109 = (b) f361729j.get(new c2(r100, r102));     // Catch: Throwable -> L58
        monitor-exit(r108);
        if ((r109 instanceof b.c) == false) goto L35;
        b.c r111 = (b.c) r109;
    L36:
        if (r111 == null) goto L38;
        z0 r112 = r111.f361745a;
    L39:
        if (r112 == null) goto L48;
        monitor-enter(r108);
        boolean r113 = f361730k.containsKey(new c(r110.f362018a, r112.f362052a));     // Catch: Throwable -> L45
        monitor-exit(r108);
        if (r113 != true) goto L48;
    L49:
        if (r101 == true) goto L67;
        if (r112 == null) goto L54;
        return new a2(r110, OfficeUrlPreviewResolution.READY, r112);
    L54:
        if ((r109 instanceof b.a) == false) goto L57;
        return new a2(r110, OfficeUrlPreviewResolution.FAILED, null);
    L57:
        return new a2(r110, OfficeUrlPreviewResolution.LOADING, null);
    L67:
        return new a2(r110, OfficeUrlPreviewResolution.FAILED, r112);
    L45:
        th = move-exception;
        throw th;
    L48:
        r101 = false;
        goto L49
    L38:
        r112 = null;
        goto L39
    L35:
        r111 = null;
    L58:
        th = move-exception;
        throw th;
    L26:
        if (vn9.a.a(r110.f362022e) == false) goto L28;
    L15:
        if (StringsKt.isBlank(r105) == true) goto L18;
        r106 = false;
    L62:
        return new a2(r110, OfficeUrlPreviewResolution.FAILED, null);
    L5:
        if ((!StringsKt.isBlank(r100)) == false) goto L7;
        goto L7
    }

    public static void t(String r110) {
        if (x0.a() == true) goto L5;
        return;
    L5:
        Object r100 = f361720a;
        monitor-enter(r100);
    L58:
        th = move-exception;
        throw th;
    L8:
        if (f361732m.contains(r110) == false) goto L11;
        monitor-exit(r100);
        return;
    L11:
        Collection<a> r101 = f361737r.values();     // Catch: Throwable -> L58
        if ((r101 instanceof Collection) == true) goto L14;
    L16:
        Iterator<T> r102 = r101.iterator();     // Catch: Throwable -> L58
    L18:
        if (r102.hasNext() == false) goto L22;
        if (Intrinsics.areEqual(((a) r102.next()).f361739a, r110) == false) goto L18;
        boolean r103 = false;
    L23:
        if (r103 == false) goto L26;
        monitor-exit(r100);
        return;
    L26:
        b1 r104 = (b1) ((LinkedHashMap) f361728i).get(r110);     // Catch: Throwable -> L58
        if (r104 != null) goto L30;
        monitor-exit(r100);
        return;
    L30:
        final String r105 = r104.f361862b.getMessageId();     // Catch: Throwable -> L58
        if (r105 != null) goto L33;
    L56:
        monitor-exit(r100);
        return;
    L33:
        if ((true ^ StringsKt.isBlank(r105)) == true) goto L36;
        r105 = null;
    L36:
        if (r105 == null) goto L56;
        long r106 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L58
        List r107 = SequencesKt.toList(SequencesKt.mapNotNull(SequencesKt.filter(CollectionsKt.asSequence(r104.f361863c), new d0()), new e0(r105)));     // Catch: Throwable -> L58
        if (r107.isEmpty() == false) goto L42;
        monitor-exit(r100);
        return;
    L42:
        f361732m.add(r110);     // Catch: Throwable -> L58
        Iterator r108 = r107.iterator();     // Catch: Throwable -> L58
        if (r108.hasNext() == false) goto L55;
        long r109 = RangesKt.coerceAtLeast((((b.a) ((Pair) r108.next()).component2()).f361743a + 3000) - r106, 0);     // Catch: Throwable -> L58
    L46:
        if (r108.hasNext() == false) goto L51;
        long r111 = RangesKt.coerceAtLeast((((b.a) ((Pair) r108.next()).component2()).f361743a + 3000) - r106, 0);     // Catch: Throwable -> L58
        if (r109 <= r111) goto L46;
        r109 = r111;
        goto L46
    L51:
        monitor-exit(r100);
        FLogger.f375446a.i("OfficeUrlPreviewSDK", "[PIPELINE][preview_id_retry_scheduled] messageIdentity=" + r110 + ", delayMs=" + r109);
        BuildersKt.launch$default(f361721b, null, null, new OfficeUrlPreviewCoordinator$scheduleFailedPreviewIdRetry$1(r109, r110, null), 3, null);
        return;
    L55:
        throw new NoSuchElementException();     // Catch: Throwable -> L58
    L22:
        r103 = true;
        goto L23
    L14:
        if (r101.isEmpty() == false) goto L16;
        goto L16
    }

    public static void u(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        Object r101 = f361720a;
        monitor-enter(r101);
        a r102 = f361737r.remove(r100);     // Catch: Throwable -> L11
        if (r102 != null) goto L8;
        monitor-exit(r101);
        return;
    L8:
        o(r102.f361741c);     // Catch: Throwable -> L11
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r101);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public static void c(r r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "blockKey");
        Intrinsics.checkNotNullParameter(r101, "previewId");
        if (StringsKt.isBlank(r101) == false) goto L5;
        return;
    L5:
        Object r102 = f361720a;
        monitor-enter(r102);
        if (f361730k.remove(new c(r100, r101)) == null) goto L10;
        boolean r103 = true;
    L11:
        monitor-exit(r102);
        if (r103 == false) goto L20;
        h(SetsKt.setOf(r100.f362013a));
        return;
    L20:
        return;
    L10:
        r103 = false;
    L15:
        th = move-exception;
        throw th;
    }

    public static void j(r r100, z0 r101) {
        Intrinsics.checkNotNullParameter(r100, "blockKey");
        Intrinsics.checkNotNullParameter(r101, "previewInfo");
        Object r102 = f361720a;
        monitor-enter(r102);
        s r103 = (s) ((LinkedHashMap) f361727h).get(r100);     // Catch: Throwable -> L36
        if (r103 != null) goto L8;
        monitor-exit(r102);
        return;
    L8:
        String r104 = r103.f362020c.getMessageId();     // Catch: Throwable -> L36
        if (r104 == null) goto L34;
        boolean r105 = true;
        String r106 = null;
        if ((!StringsKt.isBlank(r104)) == true) goto L14;
        r104 = null;
    L14:
        if (r104 == null) goto L34;
        String r107 = r103.f362023f;     // Catch: Throwable -> L36
        if (r107 != null) goto L20;
        monitor-exit(r102);
        return;
    L20:
        c2 r108 = new c2(r104, r107);     // Catch: Throwable -> L36
        Set<c2> r109 = f361735p;     // Catch: Throwable -> L36
        if (r109.contains(r108) == false) goto L23;
        f361729j.put(r108, new b.c(r101));     // Catch: Throwable -> L36
    L28:
        r105 = false;
    L30:
        monitor-exit(r102);
        if (r105 == false) goto L40;
        h(SetsKt.setOf(r100.f362013a));
        return;
    L40:
        return;
    L23:
        f361734o.remove(new d(r108, r101.f362052a));     // Catch: Throwable -> L36
        OfficeUrlPreviewCoordinator$stalePreviewOrigins$1 r110 = f361736q;     // Catch: Throwable -> L36
        z0 r111 = (z0) r110.get(r108);     // Catch: Throwable -> L36
        if (r111 == null) goto L27;
        r106 = r111.f362052a;     // Catch: Throwable -> L36
    L27:
        if (Intrinsics.areEqual(r106, r101.f362052a) == false) goto L28;
        r110.remove(r108);     // Catch: Throwable -> L36
        r109.remove(r108);     // Catch: Throwable -> L36
        f361733n.remove(r108);     // Catch: Throwable -> L36
        f361729j.put(r108, new b.c(r101));     // Catch: Throwable -> L36
    L34:
        monitor-exit(r102);
        return;
    L36:
        th = move-exception;
        throw th;
    }

    public static Set k(String r100, l2 r101) {
        b1 r102 = f361725f.remove(r100);
        if (r102 == null) goto L10;
        List<s> r103 = r102.f361863c;
        if (r103 == null) goto L10;
        Iterator<T> r104 = r103.iterator();
    L8:
        if (r104.hasNext() == false) goto L10;
        f361726g.remove(((s) r104.next()).f362018a);
    L10:
        b1 r105 = r101.f361972c.get(r100);
        if (r105 == null) goto L16;
        f361725f.put(r100, r105);
        Iterator<T> r106 = r105.f361863c.iterator();
    L14:
        if (r106.hasNext() == false) goto L16;
        s r107 = (s) r106.next();
        f361726g.put(r107.f362018a, r107);
    L16:
        List r108 = CollectionsKt.createListBuilder();
    L17:
        LinkedHashMap<String, b1> r109 = f361725f;
        if (r109.size() <= 200) goto L25;
        String r110 = (String) CollectionsKt.firstOrNull(r109.keySet());
        if (r110 == null) goto L25;
        b1 r111 = r109.remove(r110);
        if (r111 == null) goto L17;
        r108.add(r111);
    L25:
        List r112 = CollectionsKt.build(r108);
        Iterator r113 = r112.iterator();
    L27:
        if (r113.hasNext() == false) goto L32;
        Iterator<T> r114 = ((b1) r113.next()).f361863c.iterator();
    L30:
        if (r114.hasNext() == false) goto L27;
        f361726g.remove(((s) r114.next()).f362018a);
        goto L30
    L32:
        Set r115 = SetsKt.createSetBuilder();
        if (r102 == null) goto L35;
        List<s> r116 = r102.f361863c;
    L36:
        if (r116 != null) goto L38;
        r116 = CollectionsKt.emptyList();
    L38:
        List<s> r117 = r116;
        ArrayList r118 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r117, 10));
        Iterator<T> r119 = r117.iterator();
    L40:
        if (r119.hasNext() == false) goto L42;
        r118.add(((s) r119.next()).f362018a);
        goto L40
    L42:
        r115.addAll(r118);
        r115.addAll(r101.f361973d.keySet());
        Iterator r120 = r112.iterator();
    L44:
        if (r120.hasNext() == false) goto L50;
        List<s> r121 = ((b1) r120.next()).f361863c;
        ArrayList r122 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r121, 10));
        Iterator<T> r123 = r121.iterator();
    L47:
        if (r123.hasNext() == false) goto L49;
        r122.add(((s) r123.next()).f362018a);
        goto L47
    L49:
        r115.addAll(r122);
        goto L44
    L50:
        Set r124 = SetsKt.build(r115);
        LinkedHashSet r125 = new LinkedHashSet();
        Iterator r126 = r124.iterator();
    L52:
        if (r126.hasNext() == false) goto L77;
        r r127 = (r) r126.next();
        Map<r, s> r128 = f361727h;
        s r129 = (s) ((LinkedHashMap) r128).get(r127);
        s r130 = d(r127);
        if (r130 != null) goto L56;
        r128.remove(r127);
    L57:
        if (r129 == null) goto L59;
        Boolean r131 = Boolean.valueOf(r129.f362024g);
    L60:
        if (r130 == null) goto L62;
        Boolean r132 = Boolean.valueOf(r130.f362024g);
    L64:
        if (Intrinsics.areEqual(r131, r132) == true) goto L52;
        if (r129 == null) goto L71;
        r r133 = r129.f362018a;
        if (r133 == null) goto L71;
        String r134 = r133.f362013a;
        if (r134 == null) goto L71;
        r125.add(r134);
    L71:
        if (r130 == null) goto L52;
        r r135 = r130.f362018a;
        if (r135 == null) goto L52;
        String r136 = r135.f362013a;
        if (r136 == null) goto L52;
        r125.add(r136);
        goto L52
    L62:
        r132 = null;
        goto L64
    L59:
        r131 = null;
        goto L60
    L56:
        r128.put(r127, r130);
        goto L57
    L77:
        Set r137 = SetsKt.createSetBuilder();
        r137.add(r100);
        Iterator r138 = r112.iterator();
    L79:
        if (r138.hasNext() == false) goto L81;
        r137.add(((b1) r138.next()).f361861a);
        goto L79
    L81:
        Iterator r139 = SetsKt.build(r137).iterator();
    L83:
        if (r139.hasNext() == false) goto L88;
        String r140 = (String) r139.next();
        b1 r141 = e(r140);
        if (r141 == null) goto L86;
        f361728i.put(r140, r141);
        goto L83
    L86:
        f361728i.remove(r140);
        goto L83
    L88:
        return r125;
    L35:
        r116 = null;
        goto L36
    }

    public static void m(String r100, List r101) {
        Intrinsics.checkNotNullParameter(r100, "sourceKey");
        Intrinsics.checkNotNullParameter(r101, "messages");
        boolean r102 = x0.a();
        if (r102 == true) goto L5;
        return;
    L5:
        l2 r103 = b(r100, r101, r102);
        Object r104 = f361720a;
        monitor-enter(r104);
        Set r105 = l(r103);     // Catch: Throwable -> L24
        monitor-exit(r104);
        Collection<b1> r106 = r103.f361972c.values();
        ArrayList r107 = new ArrayList();
        Iterator<T> r108 = r106.iterator();
    L11:
        if (r108.hasNext() == false) goto L15;
        Object r109 = r108.next();
        if (g((b1) r109) == false) goto L11;
        r107.add(r109);
        goto L11
    L15:
        LinkedHashSet r110 = new LinkedHashSet();
        Iterator r111 = r107.iterator();
    L17:
        if (r111.hasNext() == false) goto L19;
        r110.add(((b1) r111.next()).f361861a);
        goto L17
    L19:
        n(r100);
        h(SetsKt.plus(r105, r110));
        Iterator<T> r112 = r103.f361972c.values().iterator();
    L21:
        if (r112.hasNext() == false) goto L23;
        f((b1) r112.next());
        goto L21
    L23:
        return;
    L24:
        th = move-exception;
        throw th;
    }

    public static l2 b(String r210, List r211, boolean r212) {
        int r100 = a1.f361823a;
        Function1 r101 = new n0();
        boolean r102 = com.larus.office.experiment.c.b();
        int r103 = ua9.a.f549294a;
        boolean r104 = ga9.a.b("url_preivew_layout_optimization", true);
        h2 r105 = h2.f361915a;
        OfficeUrlPreviewListAnalyzer$analyze$1 r106 = new OfficeUrlPreviewListAnalyzer$analyze$1(r105);
        Intrinsics.checkNotNullParameter(r210, "sourceKey");
        Intrinsics.checkNotNullParameter(r211, "messages");
        Intrinsics.checkNotNullParameter(r101, "htmlPreviewEligibility");
        Intrinsics.checkNotNullParameter(r106, "urlResolver");
        HashSet r107 = new HashSet();
        ArrayList r110 = new ArrayList();
        Iterator r108 = r211.iterator();
    L4:
        if (r108.hasNext() == false) goto L8;
        Object r111 = r108.next();
        r105.getClass();
        if (r107.add(h2.e((Message) r111)) == false) goto L4;
        r110.add(r111);
        goto L4
    L8:
        ArrayList r109 = new ArrayList();
        Iterator r112 = r110.iterator();
    L10:
        if (r112.hasNext() == false) goto L62;
        Message r113 = (Message) r112.next();
        boolean r114 = ((Boolean) r101.invoke(r113)).booleanValue();
        if (LarkConnectorArtifactService.f365709a.c(r113) == false) goto L14;
        List r115 = CollectionsKt.emptyList();
        Function1 r213 = r101;
        Iterator r214 = r112;
    L53:
        if ((!r115.isEmpty()) == true) goto L56;
        r115 = null;
    L56:
        if (r115 == null) goto L58;
        Pair r116 = TuplesKt.to(r113, r115);
    L59:
        if (r116 == null) goto L61;
        r109.add(r116);
    L61:
        r101 = r213;
        r112 = r214;
        goto L10
    L58:
        r116 = null;
        goto L59
    L14:
        List<Block> r117 = com.larus.im.bean.message.a.d(r113);
        ArrayList r118 = new ArrayList();
        Iterator r119 = r117.iterator();
    L16:
        if (r119.hasNext() == false) goto L51;
        Block r120 = (Block) r119.next();
        h2.f361915a.getClass();
        ArtifactBlock r121 = h2.h(r120);
        if (r121 != null) goto L20;
        Function1 r215 = r101;
        Iterator r216 = r112;
        Iterator r217 = r119;
    L43:
        a1.a r122 = null;
    L48:
        if (r122 == null) goto L50;
        r118.add(r122);
    L50:
        r101 = r215;
        r112 = r216;
        r119 = r217;
        goto L16
    L20:
        Intrinsics.checkNotNullParameter(r120, "block");
        r215 = r101;
        Intrinsics.checkNotNullParameter(r121, "artifact");
        BlockContent r123 = r120.getContent();
        r216 = r112;
        if (r123 == null) goto L27;
        FileBlock r124 = r123.getFileBlock();
        r217 = r119;
        if (r124 != null) goto L25;
    L28:
        FileBlock r125 = null;
    L29:
        if (r125 == null) goto L41;
        if (r212 == false) goto L40;
        if (r114 == false) goto L40;
        String r126 = r125.url;
        if (r126 != null) goto L35;
    L37:
        boolean r127 = false;
    L38:
        if (r127 == false) goto L40;
        boolean r128 = true;
    L42:
        if (r128 == false) goto L43;
        r r129 = h2.b(r113, r120, r121);
        Intrinsics.checkNotNullParameter(r113, "message");
        Intrinsics.checkNotNullParameter(r120, "block");
        Intrinsics.checkNotNullParameter(r121, "artifact");
        StringBuilder r130 = new StringBuilder();
        r130.append(h2.a(r120, r121));
        r130.append('|');
        String r131 = r121.getResourceId();
        if (r131 != null) goto L47;
        r131 = "";
    L47:
        r130.append(r131);
        r122 = new a1.a(r129, r130.toString(), r120, r121, r106.invoke(r121));
        goto L48
    L35:
        if (h2.c(r126) != true) goto L37;
        r127 = true;
    L40:
        r128 = false;
        goto L42
    L41:
        r128 = h2.k(r121, r212, r102);
        goto L42
    L25:
        if (StringsKt.equals(r124.type, "html", true) == false) goto L28;
        r125 = r124;
        goto L29
    L27:
        r217 = r119;
        goto L28
    L51:
        r213 = r101;
        r214 = r112;
        r115 = r118;
        goto L53
    L62:
        LinkedHashSet r132 = new LinkedHashSet();
        if (r104 == true) goto L77;
        Iterator r133 = r109.iterator();
    L66:
        if (r133.hasNext() == false) goto L77;
        List r134 = (List) ((Pair) r133.next()).component2();
        if (SequencesKt.count(SequencesKt.take(SequencesKt.distinct(SequencesKt.mapNotNull(CollectionsKt.asSequence(r134), OfficeUrlPreviewListAnalyzer$analyze$2$containsDifferentUrls$1.INSTANCE)), 2)) <= 1) goto L70;
        boolean r135 = true;
    L71:
        if (r135 == false) goto L66;
        ArrayList r136 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r134, 10));
        Iterator r137 = r134.iterator();
    L74:
        if (r137.hasNext() == false) goto L76;
        r136.add(((a1.a) r137.next()).f361824a);
        goto L74
    L76:
        CollectionsKt.addAll(r132, r136);
        goto L66
    L70:
        r135 = false;
    L77:
        LinkedHashSet r138 = new LinkedHashSet();
        Iterator r139 = r109.iterator();
    L79:
        if (r139.hasNext() == false) goto L107;
        Pair r140 = (Pair) r139.next();
        Message r141 = (Message) r140.component1();
        List r142 = (List) r140.component2();
        String r143 = r141.getConversationId();
        if (r143 != null) goto L83;
    L88:
        r143 = r210;
    L89:
        Iterator r144 = CollectionsKt.asReversed(r142).iterator();
    L91:
        if (r144.hasNext() == false) goto L79;
        a1.a r145 = (a1.a) r144.next();
        h2 r146 = h2.f361915a;
        ArtifactBlock r147 = r145.f361827d;
        r146.getClass();
        if (h2.d(r147) == false) goto L91;
        if (r104 == false) goto L97;
        String r148 = r145.f361827d.getResourceId();
    L98:
        if (r148 == null) goto L91;
        if ((!StringsKt.isBlank(r148)) == true) goto L103;
        r148 = null;
    L103:
        if (r148 == null) goto L91;
        if (r138.add(TuplesKt.to(r143, r148)) == true) goto L91;
        r132.add(r145.f361824a);
        goto L91
    L97:
        r148 = r145.f361828e;
        goto L98
    L83:
        if ((!StringsKt.isBlank(r143)) == true) goto L86;
        r143 = null;
    L86:
        if (r143 == null) goto L88;
    L107:
        LinkedHashMap r149 = new LinkedHashMap();
        LinkedHashMap r150 = new LinkedHashMap();
        Iterator r151 = r109.iterator();
    L109:
        if (r151.hasNext() == false) goto L115;
        Pair r152 = (Pair) r151.next();
        Message r153 = (Message) r152.component1();
        List r154 = (List) r152.component2();
        ArrayList r155 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r154, 10));
        Iterator r156 = r154.iterator();
    L112:
        if (r156.hasNext() == false) goto L114;
        a1.a r157 = (a1.a) r156.next();
        r r158 = r157.f361824a;
        s r159 = new s(r158, r157.f361825b, r153, r157.f361826c, r157.f361827d, r157.f361828e, r132.contains(r158));
        r150.put(r159.f362018a, r159);
        r155.add(r159);
        goto L112
    L114:
        h2.f361915a.getClass();
        String r160 = h2.e(r153);
        r149.put(r160, new b1(r160, r153, r155));
        goto L109
    L115:
        LinkedHashSet r161 = new LinkedHashSet();
        h2 r162 = h2.f361915a;
        Iterator r163 = r110.iterator();
    L117:
        if (r163.hasNext() == false) goto L120;
        Message r164 = (Message) r163.next();
        r162.getClass();
        r161.add(h2.e(r164));
        goto L117
    L120:
        return new l2(r210, r161, r149, r150);
    }

    public static z1 p(Message r100, Block r101, ArtifactBlock r102) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r101, "block");
        Intrinsics.checkNotNullParameter(r102, "artifact");
        h2.f361915a.getClass();
        a2 r103 = r(h2.b(r100, r101, r102));
        Boolean r104 = null;
        if (r103 != null) goto L5;
        return null;
    L5:
        boolean r105 = r103.f361829a.f362024g;
        OfficeUrlPreviewResolution r106 = r103.f361830b;
        z0 r107 = r103.f361831c;
        if (r107 == null) goto L8;
        String r108 = r107.f362052a;
    L9:
        if (r107 == null) goto L12;
        r104 = Boolean.valueOf(r107.f362053b);
    L12:
        return new z1(r105, r106, r108, r104);
    L8:
        r108 = null;
        goto L9
    }
}
