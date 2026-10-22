package j70;

import com.bytedance.android.live.core.tetris.layer.view.ElementConstraint;
import h70.b;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public abstract class h<T extends h70.b> extends d<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f497560a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f70.b f497561b;

    public double F(T r100) {
        Intrinsics.checkNotNullParameter(r100, "layerContext");
        return 3.9d;
    }

    public double G(T r100) {
        Intrinsics.checkNotNullParameter(r100, "layerContext");
        return 3.9d;
    }

    public double H(T r100) {
        Intrinsics.checkNotNullParameter(r100, "layerContext");
        return 3.9d;
    }

    public abstract ElementConstraint J(T r100);

    public com.bytedance.android.live.core.tetris.layer.view.b K(T r100) {
        Intrinsics.checkNotNullParameter(r100, "layerContext");
        return null;
    }

    public h() {
        this.f497561b = f70.b.f475744c;
    }

    public f70.b L() {
        return this.f497561b;
    }

    public final ElementConstraint I(Function1<? super ElementConstraint, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "init");
        float r101 = 0.0f;
        ElementConstraint r102 = new ElementConstraint(r101, 3);
        r100.invoke(r102);
        return r102;
    }

    public final void M(f70.b r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f497561b = r100;
    }
}
