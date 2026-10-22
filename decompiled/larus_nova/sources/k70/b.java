package k70;

import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import j70.e;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public abstract class b<T extends j70.e> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h70.b f501980a;

    public b() {
    }

    public abstract Element<?> a(T r100);

    public final h70.b b() {
        h70.b r100 = this.f501980a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("layerContext");
    L5:
        return r100;
    }
}
