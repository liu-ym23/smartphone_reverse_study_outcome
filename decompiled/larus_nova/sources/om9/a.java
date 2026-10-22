package om9;

import android.content.Context;
import com.larus.settings.coldboot.c;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f524313a = null;

    static {
        f524313a = new a();
    }

    public a() {
    }

    public static int a(Context r100) {
        c.f368540a.getClass();
        int r101 = Runtime.getRuntime().availableProcessors() * 2;
        if (r101 <= 6) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L12
        Object r104 = Result.m9449constructorimpl(c.a(r100, r101));     // Catch: Throwable -> L12
    L14:
        Result.m9452exceptionOrNullimpl(r104);
        if (Result.m9455isFailureimpl(r104) == false) goto L17;
        r104 = null;
    L17:
        Integer r105 = (Integer) r104;
        if (r105 == null) goto L22;
        r101 = r105.intValue();
    L22:
        return r101;
    L12:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    L8:
        return r101;
    L5:
        r102 = false;
        goto L6
    }
}
