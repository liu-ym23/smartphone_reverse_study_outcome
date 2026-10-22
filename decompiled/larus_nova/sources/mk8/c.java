package mk8;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f514345a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f514346b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f514347c;

    public c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f514345a = r100;
        this.f514346b = LazyKt.lazy(new a(this));
        this.f514347c = LazyKt.lazy(new b());
    }
}
