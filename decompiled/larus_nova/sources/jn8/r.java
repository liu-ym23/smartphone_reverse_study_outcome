package jn8;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import v19.d6;

/* JADX INFO: loaded from: classes26.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f499779a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f499780b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public t f499781c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public d6 f499782d;

    public r(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f499779a = r100;
        this.f499780b = LazyKt.lazy(new q(this));
    }
}
