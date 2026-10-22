package eia;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public abstract class r extends v {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f472814d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f472815e;

    public static final class a {
    }

    static {
    }

    public r(Context r100, final t1a.b r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "vContext");
        super(r100, r101);
        this.f472814d = LazyKt.lazy(new p(r101));
        this.f472815e = LazyKt.lazy(new q(this));
    }
}
