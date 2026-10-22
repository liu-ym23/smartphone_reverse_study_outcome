package zka;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.common.apphost.AppHost;
import com.obric.miniapp.calendar.proxy.function.SystemAppletMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicLong f572728a;

    public static final class a {
    }

    static {
    }

    public n() {
        this.f572728a = new AtomicLong(-1);
        Application r100 = AppHost.f326268a.getApplication();
        o r101 = new o(this, new Handler(Looper.getMainLooper()));
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        r100.getContentResolver().registerContentObserver(UriProtector.parse("content://com.obric.appletapp.SystemAppletProvider/server_alive"), false, r101);     // Catch: Throwable -> L5
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public static long a(Context r100) {
        Object r101 = null;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L9
        Bundle r103 = r100.getApplicationContext().getContentResolver().call(UriProtector.parse("content://com.obric.appletapp.SystemAppletProvider"), SystemAppletMethod.METHOD_GET_FEATURES, null, null);     // Catch: Throwable -> L9
        if (r103 == null) goto L6;
        Long r104 = Long.valueOf(r103.getLong("result"));     // Catch: Throwable -> L9
    L7:
        Object r105 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L9
    L12:
        if (Result.m9455isFailureimpl(r105) == true) goto L15;
        r101 = r105;
    L15:
        Long r106 = (Long) r101;
        if (r106 != null) goto L22;
        return 0;
    L22:
        return r106.longValue();
    L6:
        r104 = null;
    L9:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    public final boolean b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (this.f572728a.get() != (-1)) goto L6;
        this.f572728a.set(a(r100));
    L6:
        if ((this.f572728a.get() & 1) <= 0) goto L8;
        return true;
    L8:
        return false;
    }

    public final boolean c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if ((a(r100) & 2) <= 0) goto L5;
        return true;
    L5:
        return false;
    }
}
