package zm8;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f572878a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f572879b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f572880c;

    public c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f572878a = r100;
        this.f572879b = LazyKt.lazy(new a(this));
        this.f572880c = LazyKt.lazy(new b());
    }
}
