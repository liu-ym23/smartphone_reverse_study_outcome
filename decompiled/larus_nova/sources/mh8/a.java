package mh8;

import fh8.i;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class a implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f513969a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<jc8.a> f513970b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final kc8.b f513971c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f513969a, r101.f513969a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f513970b, r101.f513970b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f513971c, r101.f513971c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f513969a.hashCode() * 31) + this.f513970b.hashCode()) * 31;
        kc8.b r101 = this.f513971c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "MarkdownEmbeddedBlockContext(valueId=" + this.f513969a + ", models=" + this.f513970b + ", blockDependConfig=" + this.f513971c + ')';
    }

    @Override // fh8.i
    public final String a() {
        return this.f513969a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(String r100, List<? extends jc8.a> r101, kc8.b r102) {
        Intrinsics.checkNotNullParameter(r100, "valueId");
        Intrinsics.checkNotNullParameter(r101, "models");
        this.f513969a = r100;
        this.f513970b = r101;
        this.f513971c = r102;
    }
}
