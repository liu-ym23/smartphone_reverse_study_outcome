package hl8;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f485697a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f485698b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f485699c;

    public final Context getContext() {
        return this.f485697a;
    }

    public c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f485697a = r100;
        this.f485698b = LazyKt.lazy(new a(this));
        this.f485699c = LazyKt.lazy(new b());
    }
}
