package gj8;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f481511a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f481512b;

    public f(final Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f481511a = LazyKt.lazy(new d(r100));
        this.f481512b = LazyKt.lazy(new e());
    }
}
