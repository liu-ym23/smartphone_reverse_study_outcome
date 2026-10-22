package tn8;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f546877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f546878b;

    public c(final Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f546877a = LazyKt.lazy(new a(r100));
        this.f546878b = LazyKt.lazy(new b());
    }
}
