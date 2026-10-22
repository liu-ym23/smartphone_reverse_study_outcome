package um8;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f550696a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f550697b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f550698c;

    public c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f550696a = r100;
        this.f550697b = LazyKt.lazy(new a());
        this.f550698c = LazyKt.lazy(new b(this));
    }
}
