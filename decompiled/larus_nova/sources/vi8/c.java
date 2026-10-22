package vi8;

import com.larus.im.FlowRuntime;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f555352a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f555353b = null;

    public c() {
    }

    static {
        f555352a = new c();
        f555353b = LazyKt.lazy(new b());
    }

    public static boolean a() {
        a r100 = (a) f555353b.getValue();
        FlowRuntime.b().a().isOversea();
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.f555348b;
    }
}
