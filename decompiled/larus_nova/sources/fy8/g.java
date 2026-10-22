package fy8;

import com.larus.canvas.feature.ability.CanvasInputEventType;
import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CanvasInputEventType f479307a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f479308b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (this.f479307a == r101.f479307a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f479308b, r101.f479308b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f479307a.hashCode() * 31) + this.f479308b.hashCode();
    }

    public final String toString() {
        return "CanvasInputEvent(eventType=" + this.f479307a + ", prompt=" + this.f479308b + ')';
    }

    public g() {
        this(CanvasInputEventType.NONE, "");
    }

    public g(CanvasInputEventType r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "eventType");
        Intrinsics.checkNotNullParameter(r101, EventConstant.Key.RETAIN_PROMPT);
        this.f479307a = r100;
        this.f479308b = r101;
    }
}
