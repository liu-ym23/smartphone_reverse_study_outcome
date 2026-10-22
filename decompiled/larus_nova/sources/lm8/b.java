package lm8;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f509894a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f509895b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final om8.b f509896c;

    public final Context getContext() {
        return this.f509894a;
    }

    public b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f509894a = r100;
        this.f509895b = LazyKt.lazy(new a(this));
        this.f509896c = new om8.b();
    }
}
