package ik8;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import lk8.e;

/* JADX INFO: loaded from: classes26.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f490275a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f490276b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f490277c;

    public b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f490275a = r100;
        this.f490276b = LazyKt.lazy(new a(this));
        this.f490277c = new e();
    }
}
