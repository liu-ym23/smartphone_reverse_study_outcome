package yy9;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f569501a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f569502b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f569503c;

    public static final class a {
    }

    static {
    }

    public final Context getContext() {
        return this.f569501a;
    }

    public c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f569501a = r100;
        this.f569502b = LazyKt.lazy(new yy9.a(this));
        this.f569503c = LazyKt.lazy(new b());
    }
}
