package vy5;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, a> f557621a = null;

    static {
        f557621a = new LinkedHashMap();
    }

    public static a a(String r100) {
        Map<String, a> r101 = f557621a;
        monitor-enter(r101);
        a r102 = (a) ((LinkedHashMap) r101).get(r100);     // Catch: Throwable -> L9
        if (r102 != null) goto L7;
        r102 = new a();     // Catch: Throwable -> L9
        r101.put(r100, r102);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r101);
        return r102;
    L9:
        th = move-exception;
        throw th;
    }

    public static boolean b(String r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L11
        a r102 = a(r100);     // Catch: Throwable -> L11
        boolean r103 = false;
        int r104 = 0;
    L4:
        if (r104 >= 50) goto L9;
        r102.f557620c.lock();     // Catch: Throwable -> L11
        if (r102.f557619b == false) goto L8;
        r102.f557620c.unlock();     // Catch: Throwable -> L11
        r104 = r104 + 10;     // Catch: Throwable -> L11
        Thread.sleep(10);     // Catch: Throwable -> L11
        goto L4
    L8:
        r102.f557618a++;     // Catch: Throwable -> L11
        r102.f557620c.unlock();     // Catch: Throwable -> L11
        r103 = true;
    L9:
        Object r105 = Result.m9449constructorimpl(Boolean.valueOf(r103));     // Catch: Throwable -> L11
    L13:
        Boolean r106 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r105) == false) goto L17;
        r105 = r106;
    L17:
        return ((Boolean) r105).booleanValue();
    L11:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    public static boolean c(String r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L13
        a r102 = a(r100);     // Catch: Throwable -> L13
        r102.f557620c.lock();     // Catch: Throwable -> L10
        if (r102.f557619b == false) goto L7;
        r102.f557620c.unlock();     // Catch: Throwable -> L13
        boolean r103 = false;
    L9:
        Object r104 = Result.m9449constructorimpl(Boolean.valueOf(r103));     // Catch: Throwable -> L13
    L15:
        Boolean r105 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r104) == false) goto L19;
        r104 = r105;
    L19:
        return ((Boolean) r104).booleanValue();
    L7:
        r102.f557618a++;     // Catch: Throwable -> L10
        r102.f557620c.unlock();     // Catch: Throwable -> L13
        r103 = true;
        goto L9
    L10:
        th = move-exception;
        r102.f557620c.unlock();     // Catch: Throwable -> L13
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    }

    public static void d(String r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L13
        a r102 = a(r100);     // Catch: Throwable -> L13
        r102.f557620c.lock();     // Catch: Throwable -> L10
        if (r102.f557618a == 0) goto L9;
        r102.f557618a--;     // Catch: Throwable -> L10
    L9:
        r102.f557620c.unlock();     // Catch: Throwable -> L13
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L13
        return;
    L10:
        th = move-exception;
        r102.f557620c.unlock();     // Catch: Throwable -> L13
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public static boolean e(String r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L15
        a r102 = a(r100);     // Catch: Throwable -> L15
        r102.f557620c.lock();     // Catch: Throwable -> L12
        if (r102.f557618a <= 0) goto L6;
    L10:
        r102.f557620c.unlock();     // Catch: Throwable -> L15
        boolean r103 = false;
    L11:
        Object r104 = Result.m9449constructorimpl(Boolean.valueOf(r103));     // Catch: Throwable -> L15
    L17:
        Boolean r105 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r104) == false) goto L21;
        r104 = r105;
    L21:
        return ((Boolean) r104).booleanValue();
    L6:
        if (r102.f557619b == true) goto L10;
        r103 = true;
        r102.f557619b = true;     // Catch: Throwable -> L12
        r102.f557620c.unlock();     // Catch: Throwable -> L15
        goto L11
    L12:
        th = move-exception;
        r102.f557620c.unlock();     // Catch: Throwable -> L15
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L17
    }

    public static void f(String r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L8
        a r102 = a(r100);     // Catch: Throwable -> L8
        r102.f557620c.lock();     // Catch: Throwable -> L5
        r102.f557619b = false;     // Catch: Throwable -> L5
        r102.f557620c.unlock();     // Catch: Throwable -> L8
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
        return;
    L5:
        th = move-exception;
        r102.f557620c.unlock();     // Catch: Throwable -> L8
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }
}
