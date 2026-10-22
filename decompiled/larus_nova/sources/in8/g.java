package in8;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f490620a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f490621b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f490622c;

    public static final class a {
    }

    static {
    }

    public final Context getContext() {
        return this.f490620a;
    }

    public g(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f490620a = r100;
        this.f490621b = LazyKt.lazy(new e(this));
        this.f490622c = LazyKt.lazy(new f());
    }
}
