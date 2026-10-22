package qma;

import com.facebook.keyframes.model.KFAnimation;
import com.obric.oui.texteffects.core.EffectProperty;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EffectProperty f533962a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<f> f533963b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f533964c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final j f533965d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (this.f533962a == r101.f533962a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f533963b, r101.f533963b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f533964c, r101.f533964c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f533965d, r101.f533965d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f533962a.hashCode() * 31) + this.f533963b.hashCode()) * 31) + this.f533964c.hashCode()) * 31) + this.f533965d.hashCode();
    }

    public final String toString() {
        return "PropertyTrack(property=" + this.f533962a + ", keyframes=" + this.f533963b + ", easing=" + this.f533964c + ", selector=" + this.f533965d + ')';
    }

    public /* synthetic */ i(EffectProperty r100, List r101, a r102) {
        this(r100, r101, r102, j.a.f533966a);
    }

    public i(EffectProperty r100, List<f> r101, a r102, j r103) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r101, "keyframes");
        Intrinsics.checkNotNullParameter(r102, "easing");
        Intrinsics.checkNotNullParameter(r103, "selector");
        this.f533962a = r100;
        this.f533963b = r101;
        this.f533964c = r102;
        this.f533965d = r103;
    }
}
