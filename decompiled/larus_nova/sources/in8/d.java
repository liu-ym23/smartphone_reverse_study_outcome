package in8;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f490616a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f490617b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f490618c;

    public static final class a {
    }

    static {
    }

    public final kn8.c a() {
        return (kn8.c) this.f490618c.getValue();
    }

    public final Context getContext() {
        return this.f490616a;
    }

    public d(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f490616a = r100;
        this.f490617b = LazyKt.lazy(new in8.a(this));
        this.f490618c = LazyKt.lazy(new b());
    }
}
