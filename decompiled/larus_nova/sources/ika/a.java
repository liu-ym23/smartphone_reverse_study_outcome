package ika;

import android.content.Context;
import com.obric.matrix.push.common.cross_process.CrossProcessService;
import com.ss.android.lark.utils.statistics.PerfLog;
import jka.c;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f490286a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static CrossProcessService f490287b;

    static {
        f490286a = new a();
    }

    public a() {
    }

    public final c a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (f490287b != null) goto L14;
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L6:
        if (f490287b != null) goto L8;
        f490287b = new CrossProcessService(r100);     // Catch: Throwable -> L11
    L8:
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(this);
    L14:
        CrossProcessService r102 = f490287b;
        Intrinsics.checkNotNull(r102);
        return r102;
    }
}
