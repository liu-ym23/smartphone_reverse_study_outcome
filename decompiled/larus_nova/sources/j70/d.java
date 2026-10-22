package j70;

import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import h70.b;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public abstract class d<T extends h70.b> {
    public d() {
    }

    public abstract boolean B(T r100);

    public abstract f C(T r100);

    public abstract LayerIndex E(T r100);

    public final boolean D(T r100) {
        Intrinsics.checkNotNullParameter(r100, "layerContext");
        z70.b r101 = r100.f483964a;
        if (r101 == null) goto L22;
        if (r101.k() != true) goto L22;
        if ((C(r100) instanceof c) == true) goto L13;
        z70.b r102 = r100.f483964a;
        if (r102 != null) goto L12;
    L14:
        boolean r103 = false;
    L15:
        if (r103 == true) goto L17;
    L19:
        return false;
    L17:
        if (B(r100) == false) goto L19;
        return true;
    L12:
        if (r102.d(C(r100)) == true) goto L14;
    L13:
        r103 = true;
    L22:
        return B(r100);
    }
}
