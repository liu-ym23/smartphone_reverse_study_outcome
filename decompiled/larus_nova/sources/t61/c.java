package t61;

import android.animation.ValueAnimator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f544655f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function0<Unit> f544656a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function0<Unit> f544657b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function0<Unit> f544658c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function0<Unit> f544659d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function1<? super ValueAnimator, Unit> f544660e;

    public static final class a {
        public static c a(Function1 r100) {
            Intrinsics.checkNotNullParameter(r100, "listener");
            c r101 = new c();
            r100.invoke(r101);
            return r101;
        }
    }

    static {
    }

    public c() {
    }
}
