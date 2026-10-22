package kj8;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f503721a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f503722b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final nj8.b f503723c;

    public final Context getContext() {
        return this.f503721a;
    }

    public b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f503721a = r100;
        this.f503722b = LazyKt.lazy(new a(this));
        this.f503723c = new nj8.b();
    }
}
