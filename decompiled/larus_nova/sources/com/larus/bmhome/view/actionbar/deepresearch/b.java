package com.larus.bmhome.view.actionbar.deepresearch;

import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.instruction.g;
import com.larus.utils.logger.FLogger;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import tx9.p0;

/* JADX INFO: loaded from: classes26.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f316025a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f316026b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static z0 f316027c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static g f316028d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static y f316029e;

    public b() {
    }

    static {
        f316025a = new b();
        f316026b = LazyKt.lazy(new a());
    }

    public static Map c() {
        return (Map) f316026b.getValue();
    }

    public static boolean d() {
        if (f316027c != null) goto L5;
        return false;
    L5:
        y r100 = f316029e;
        if (r100 == null) goto L8;
        String r101 = r100.Y1();
    L9:
        if (r101 != null) goto L11;
        return false;
    L11:
        c r102 = (c) c().get(r101);
        if (r102 != null) goto L14;
        return false;
    L14:
        if (r102.f316031b != true) goto L18;
        return true;
    L18:
        return false;
    L8:
        r101 = null;
        goto L9
    }

    public static void a(String r100) {
        b r101 = f316025a;
        monitor-enter(r101);
        if (r100 != null) goto L23;
    L8:
        y r102 = f316029e;     // Catch: Throwable -> L20
        if (r102 == null) goto L11;
        String r103 = r102.Y1();     // Catch: Throwable -> L20
    L13:
        if (Intrinsics.areEqual(r100, r103) == true) goto L17;
        FLogger.f375446a.i("DeepResearchBarManager", "clearItemAndVContext, cvsId not the same");     // Catch: Throwable -> L20
        monitor-exit(r101);
        return;
    L17:
        f316027c = null;     // Catch: Throwable -> L20
        f316028d = null;     // Catch: Throwable -> L20
        f316029e = null;     // Catch: Throwable -> L20
        monitor-exit(r101);
        return;
    L11:
        r103 = null;
        goto L13
    L23:
        c r104 = (c) c().get(r100);     // Catch: Throwable -> L20
        if (r104 == null) goto L8;
        p0.a(r104.f316030a, "user_end");     // Catch: Throwable -> L20
        c r105 = (c) c().remove(r100);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }

    public static void b(Map r110) {
        if (r110 != null) goto L4;
        r110 = new LinkedHashMap();
    L4:
        y r100 = f316029e;
        if (r100 == null) goto L7;
        String r101 = r100.Y1();
    L8:
        if (r101 != null) goto L11;
        return;
    L11:
        if (d() == false) goto L18;
        r110.put("deep_research_phase", "more_context");
        c r102 = (c) c().get(r101);
        if (r102 == null) goto L15;
        String r103 = r102.f316030a;
    L16:
        if (r103 == null) goto L19;
        r110.put("deep_research_id", r103);
    L19:
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new DeepResearchBarManager$getDeepResearchParamsToSend$2(null), 3, null);
        return;
    L15:
        r103 = null;
        goto L16
    L18:
        r110.put("deep_research_phase", "topic");
        goto L19
    L7:
        r101 = null;
        goto L8
    }

    public static void e(String r100, String r101) {
        if (f316027c != null) goto L5;
        return;
    L5:
        c r102 = (c) c().get(r100);
        if (r102 == null) goto L10;
        if (r101 == null) goto L10;
        FLogger.f375446a.i("DeepResearchBarManager", "quitDeepSearch, deepResearchId[" + r102.f316030a + "], cvsId[" + r100 + "], reason[" + r101 + ']');
        p0.a(r102.f316030a, r101);
    L10:
        c().remove(r100);
        y r103 = f316029e;
        if (r103 == null) goto L13;
        String r104 = r103.Y1();
    L15:
        if (Intrinsics.areEqual(r104, r100) == false) goto L20;
        FLogger.f375446a.i("DeepResearchBarManager", "quitDeepSearch, closeInstructionEditor, cvsId[" + r100 + "], reason[" + r101 + ']');
        g r105 = f316028d;
        if (r105 == null) goto L21;
        r105.A1();
        return;
    L21:
        return;
    L20:
        return;
    L13:
        r104 = null;
        goto L15
    }

    public static void f(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "cvsId");
        Intrinsics.checkNotNullParameter(r101, "sourceMsgId");
        if (c().containsKey(r100) == true) goto L7;
        FLogger.f375446a.i("DeepResearchBarManager", "registerDeepResearchInfoIfAbsent, cvsId[" + r100 + "], sourceMsgId[" + r101 + "], isInExplain[false]");
        c().put(r100, new c(r101, r100, false));
        return;
    }
}
