package cw3;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f465572a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f465573b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f465574c;

    public final Context getContext() {
        return this.f465572a;
    }

    public c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f465572a = r100;
        this.f465573b = LazyKt.lazy(new a());
        this.f465574c = LazyKt.lazy(new b(this));
    }
}
