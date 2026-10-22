package ke6;

import com.bytedance.lark.policy.event.Event;
import com.bytedance.lark.policy.event.EventManager;
import com.bytedance.lark.policy.model.p;
import com.bytedance.lark.policy.utils.Logger;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import ne6.e;

/* JADX INFO: loaded from: classes20.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f503032a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f503033b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static p f503034c;

    static {
        f503032a = new d();
    }

    public d() {
    }

    public static ne6.a a() {
        p r100 = f503034c;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        r100 = null;
    L6:
        return r100.f253856a;
    }

    public static ne6.b b() {
        p r100 = f503034c;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        r100 = null;
    L6:
        return r100.f253861f;
    }

    public static ne6.c c() {
        p r100 = f503034c;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        r100 = null;
    L6:
        return r100.f253857b;
    }

    public static e d() {
        p r100 = f503034c;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        r100 = null;
    L6:
        return r100.f253858c;
    }

    public static boolean e() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L7
        p r101 = f503034c;     // Catch: Throwable -> L7
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("config");     // Catch: Throwable -> L7
        r101 = null;
    L5:
        Object r102 = Result.m9449constructorimpl(Boolean.valueOf(r101.f253863h.invoke().booleanValue()));     // Catch: Throwable -> L7
    L9:
        Boolean r103 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r102) == false) goto L13;
        r102 = r103;
    L13:
        return ((Boolean) r102).booleanValue();
    L7:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L9
    }

    public static boolean f() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L7
        p r101 = f503034c;     // Catch: Throwable -> L7
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("config");     // Catch: Throwable -> L7
        r101 = null;
    L5:
        Object r102 = Result.m9449constructorimpl(Boolean.valueOf(r101.f253862g.invoke().booleanValue()));     // Catch: Throwable -> L7
    L9:
        Boolean r103 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r102) == false) goto L13;
        r102 = r103;
    L13:
        return ((Boolean) r102).booleanValue();
    L7:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L9
    }

    public static void g(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "userID");
        Intrinsics.checkNotNullParameter(r101, "tenantID");
        ne6.c r102 = c();
        if (r102 == null) goto L5;
        r102.b();
    L5:
        boolean r103 = com.bytedance.lark.policy.manager.d.f253827a;
        Intrinsics.checkNotNullParameter(r100, "userID");
        Intrinsics.checkNotNullParameter(r101, "tenantID");
        Logger.c("UserManager", "login()");
        com.bytedance.lark.policy.manager.d.f253828b = r100;
        com.bytedance.lark.policy.manager.d.f253829c = r101;
        com.bytedance.lark.policy.manager.d.f253827a = true;
        CopyOnWriteArraySet<com.bytedance.lark.policy.event.a> r104 = EventManager.f253801a;
        EventManager.a(Event.EVENT_LOGIN);
    }

    @JvmStatic
    public static final void h(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        ConcurrentHashMap<String, Object> r102 = re6.b.f537431a;
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        ConcurrentHashMap<String, Object> r103 = re6.b.f537431a;
        monitor-enter(r103);
        r103.put(r100, r101);     // Catch: Throwable -> L7
        monitor-exit(r103);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
