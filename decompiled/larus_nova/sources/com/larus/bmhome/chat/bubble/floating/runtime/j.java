package com.larus.bmhome.chat.bubble.floating.runtime;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.bytedance.router.SmartRouter;
import com.larus.bmhome.chat.bubble.floating.BubbleBannerDismissReason;
import com.larus.bmhome.chat.bubble.floating.BubbleBannerRenderPart;
import com.larus.bmhome.chat.bubble.floating.BubbleBannerState;
import com.larus.bmhome.chat.bubble.floating.BubbleBannerTransitionType;
import com.larus.utils.logger.FLogger;
import com.ss.android.cert.manager.constants.EventConstant;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes25.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f297547a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final l f297548b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CoroutineScope f297549c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Handler f297550d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map<String, List<a>> f297551e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Set<String> f297552f = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<k.a> f297553a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f297553a, ((a) r100).f297553a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f297553a.hashCode();
        }

        public final String toString() {
            return "RefreshRegistration(listenerRef=" + this.f297553a + ')';
        }

        public a(WeakReference<k.a> r100) {
            Intrinsics.checkNotNullParameter(r100, "listenerRef");
            this.f297553a = r100;
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f297554a = null;

        static {
            int[] r100 = new int[BubbleBannerState.values().length];
            r100[BubbleBannerState.ENTERING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[BubbleBannerState.VISIBLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[BubbleBannerState.EXITING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f297554a = r100;
        }
    }

    public j() {
    }

    public static Map l() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("banner_action_result", "fail"), TuplesKt.to("banner_action_fail_reason", "system_error")});
    }

    static {
        f297547a = new j();
        f297548b = new l();
        f297549c = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate()));
        f297550d = new Handler(Looper.getMainLooper());
        f297551e = new LinkedHashMap();
        f297552f = new LinkedHashSet();
    }

    public static void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "promptId");
        pc8.e r101 = f297548b.a(r100);
        if (r101 != null) goto L5;
        return;
    L5:
        j(r101, true);
    }

    public static void f(String r100) {
        List r101 = (List) ((LinkedHashMap) f297551e).get(r100);
        if (r101 != null) goto L5;
        r101 = CollectionsKt.emptyList();
    L5:
        ArrayList r102 = new ArrayList();
        Iterator r103 = r101.iterator();
    L7:
        if (r103.hasNext() == false) goto L12;
        k.a r104 = ((a) r103.next()).f297553a.get();
        if (r104 == null) goto L7;
        r102.add(r104);
        goto L7
    L12:
        if (r102.size() == r101.size()) goto L25;
        Map<String, List<a>> r105 = f297551e;
        LinkedHashMap r106 = (LinkedHashMap) r105;
        List r107 = (List) r106.get(r100);
        if (r107 == null) goto L16;
        CollectionsKt.removeAll(r107, new i());
    L16:
        Collection r108 = (Collection) r106.get(r100);
        if (r108 != null) goto L19;
    L22:
        boolean r109 = true;
    L23:
        if (r109 == false) goto L25;
        r105.remove(r100);
        goto L25
    L19:
        if (r108.isEmpty() == true) goto L22;
        r109 = false;
    L25:
        Iterator r110 = r102.iterator();
    L27:
        if (r110.hasNext() == false) goto L29;
        ((k.a) r110.next()).E(r100);
        goto L27
    }

    public static void g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "promptId");
        l r101 = f297548b;
        pc8.e r102 = r101.a(r100);
        if (r102 != null) goto L6;
        return;
    L6:
        if (r102.f528578c == BubbleBannerState.VISIBLE) goto L8;
        return;
    L8:
        if (r102.f528583h == true) goto L11;
        return;
    L11:
        if (r102.f528581f == false) goto L14;
        return;
    L14:
        if (r102.f528580e > 0) goto L16;
        r101.c(r100, k(r102, System.currentTimeMillis()));
    L16:
        Handler r103 = com.larus.bmhome.chat.bubble.floating.runtime.b.f297539a;
        Intrinsics.checkNotNullParameter(r100, "promptId");
        if (com.larus.bmhome.chat.bubble.floating.runtime.b.f297540b.containsKey(r100) == true) goto L23;
        pc8.e r104 = r101.a(r100);
        if (r104 == null) goto L24;
        com.larus.bmhome.chat.bubble.floating.runtime.b.b(r104);
        return;
    L24:
        return;
    }

    public static void a(String r100, BubbleBannerDismissReason r101) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        Intrinsics.checkNotNullParameter(r101, "reason");
        l r102 = f297548b;
        monitor-enter(r102);
        Intrinsics.checkNotNullParameter(r100, "conversationId");     // Catch: Throwable -> L11
        List r103 = CollectionsKt.listOfNotNull(r102.b(r100));     // Catch: Throwable -> L11
        monitor-exit(r102);
        Iterator r104 = r103.iterator();
    L8:
        if (r104.hasNext() == false) goto L10;
        pc8.e r105 = (pc8.e) r104.next();
        j r106 = f297547a;
        String r107 = r105.f528576a;
        r106.getClass();
        c(r107, r101);
        goto L8
    L10:
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public static boolean c(final String r110, BubbleBannerDismissReason r210) {
        Intrinsics.checkNotNullParameter(r110, "promptId");
        Intrinsics.checkNotNullParameter(r210, "reason");
        l r111 = f297548b;
        pc8.e r112 = r111.a(r110);
        if (r112 != null) goto L5;
        return false;
    L5:
        com.larus.bmhome.chat.bubble.floating.runtime.b.a(r110);
        if (r210 != BubbleBannerDismissReason.HOST_UNAVAILABLE) goto L17;
        BubbleBannerState r100 = r112.f528578c;
        if (r100 != BubbleBannerState.EXITING) goto L11;
        return false;
    L11:
        if (r100 != BubbleBannerState.ENTERING) goto L13;
    L14:
        e(r112, r210);
    L15:
        j(r112, true);
        return true;
    L13:
        if (r100 != BubbleBannerState.VISIBLE) goto L15;
    L17:
        BubbleBannerState r101 = r112.f528578c;
        int r102 = b.f297554a[r101.ordinal()];
        if (r102 != 1) goto L20;
    L24:
        e(r112, r210);
        pc8.i r113 = h(r110, BubbleBannerTransitionType.EXIT);
        pc8.f r103 = r112.f528579d;
        if (r103 == null) goto L28;
        Set<BubbleBannerRenderPart> r104 = r103.f528591c;
        if (r104 == null) goto L28;
    L29:
        pc8.b r114 = new pc8.b(r104, SetsKt.emptySet());
        monitor-enter(r111);
        Intrinsics.checkNotNullParameter(r110, "promptId");     // Catch: Throwable -> L40
        Intrinsics.checkNotNullParameter(r210, "reason");     // Catch: Throwable -> L40
        Intrinsics.checkNotNullParameter(r113, "transition");     // Catch: Throwable -> L40
        Intrinsics.checkNotNullParameter(r114, "exitCompletion");     // Catch: Throwable -> L40
        pc8.e r105 = r111.f297556a.get(r110);     // Catch: Throwable -> L40
        if (r105 != null) goto L35;
        monitor-exit(r111);
    L37:
        String r106 = r112.f528577b.f528569b;
        Handler r107 = f297550d;
        r107.post(new e(r106));
        r107.postDelayed(new f(r110), 600);
    L38:
        return true;
    L35:
        r111.f297556a.put(r110, pc8.e.a(r105, BubbleBannerState.EXITING, null, 0, false, false, false, r210, r113, r114, null, 2299));     // Catch: Throwable -> L40
        monitor-exit(r111);
    L40:
        th = move-exception;
        throw th;
    L28:
        r104 = SetsKt.setOf(BubbleBannerRenderPart.CONTENT);
        goto L29
    L20:
        if (r102 == 2) goto L24;
        if (r102 == 3) goto L45;
        j(r112, false);
        goto L38
    L45:
        return false;
    }

    public static void d(pc8.e r100, Map r101) {
        sc8.i r102 = sc8.i.f541403a;
        sc8.a r103 = new sc8.a(r101);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, EventConstant.Key.RETAIN_PROMPT);
        Intrinsics.checkNotNullParameter(r103, "result");
        sc8.b r104 = pc8.g.b(r100);
        Intrinsics.checkNotNullParameter(r104, "event");
        Intrinsics.checkNotNullParameter(r103, "result");
        sc8.i.c(new sc8.e(sc8.i.b(r104.f541378a), r104, r103));
    }

    public static void e(pc8.e r100, final BubbleBannerDismissReason r101) {
        sc8.i.f541403a.getClass();
        Intrinsics.checkNotNullParameter(r100, EventConstant.Key.RETAIN_PROMPT);
        Intrinsics.checkNotNullParameter(r101, "reason");
        final sc8.b r102 = pc8.g.b(r100);
        Intrinsics.checkNotNullParameter(r102, "event");
        Intrinsics.checkNotNullParameter(r101, "reason");
        final List r103 = sc8.i.b(r102.f541378a);
        sc8.i.c(new sc8.f(r103, r102, r101));
    }

    public static pc8.i h(String r100, BubbleBannerTransitionType r101) {
        long r102 = SystemClock.uptimeMillis();
        return new pc8.i(r101.name() + '_' + r100 + '_' + r102, r101, r102);
    }

    public static void j(pc8.e r100, boolean r101) {
        l r102 = f297548b;
        String r103 = r100.f528576a;
        monitor-enter(r102);
        Intrinsics.checkNotNullParameter(r103, "promptId");     // Catch: Throwable -> L15
        pc8.e r104 = r102.f297556a.remove(r103);     // Catch: Throwable -> L15
        if (r104 != null) goto L8;
        monitor-exit(r102);
    L12:
        if (r101 == false) goto L20;
        String r105 = r100.f528577b.f528569b;
        f297550d.post(new e(r105));
        return;
    L20:
        return;
    L8:
        Map<String, String> r106 = r102.f297557b;     // Catch: Throwable -> L15
        LinkedHashMap r107 = (LinkedHashMap) r106;     // Catch: Throwable -> L15
        if (Intrinsics.areEqual(r107.get(r104.f528577b.f528569b), r103) == false) goto L11;
        r102.f297557b.remove(r104.f528577b.f528569b);     // Catch: Throwable -> L15
    L11:
        monitor-exit(r102);
    L15:
        th = move-exception;
        throw th;
    }

    public static long k(pc8.e r100, long r101) {
        if (r100.f528581f == false) goto L5;
        return 0;
    L5:
        long r102 = r100.f528580e;
        if (r102 <= 0) goto L8;
        return r102;
    L8:
        long r103 = r100.f528577b.f528573f.f528594c;
        if (r103 > 0) goto L12;
        return 0;
    L12:
        return r101 + (r103 * 1000);
    }

    public static void i(Context r100, pc8.e r101, String r102, String r103) {
        if (r102 != null) goto L4;
        return;
    L4:
        if ((!StringsKt.isBlank(r102)) == true) goto L7;
        r102 = null;
    L7:
        if (r102 == null) goto L21;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L11
        SmartRouter.buildRoute(r100, r102).d();     // Catch: Throwable -> L11
        Object r105 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L20;
        FLogger.f375446a.w("BubbleBannerManager", r103 + " failed, promptId=" + r101.f528576a, r106);
        return;
    L20:
        return;
    L11:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    }
}
