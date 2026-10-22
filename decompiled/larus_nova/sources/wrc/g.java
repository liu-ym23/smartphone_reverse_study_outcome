package wrc;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f560926a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f560927b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e f560928c = null;

    static {
        f560926a = new c();
        f560927b = new d();
        f560928c = new e();
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [wrc.f] */
    public static final f a(final io.github.alexzhirkevich.compottie.internal.animation.expressions.f r100, final io.github.alexzhirkevich.compottie.internal.animation.expressions.f r101, final Function2 r102) {
        Intrinsics.checkNotNullParameter(r100, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY);
        Intrinsics.checkNotNullParameter(r101, "b");
        Intrinsics.checkNotNullParameter(r102, "comparator");
        return new f(r102, r100, r101);
    }
}
