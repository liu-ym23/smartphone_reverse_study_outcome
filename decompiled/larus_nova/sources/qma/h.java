package qma;

import com.obric.oui.texteffects.core.Direction;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Direction f533961a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L9;
        return false;
    L9:
        if (this.f533961a == ((h) r100).f533961a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f533961a.hashCode();
    }

    public final String toString() {
        return "MaterialLayerSpec(blurDirection=" + this.f533961a + ')';
    }

    public h(Direction r100) {
        Intrinsics.checkNotNullParameter(r100, "blurDirection");
        this.f533961a = r100;
    }
}
