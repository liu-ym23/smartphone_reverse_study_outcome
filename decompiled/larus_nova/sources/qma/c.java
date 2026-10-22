package qma;

import com.alibaba.gaiax.template.GXTemplateKey;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f533942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f533943b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f533944c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<b> f533945d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f533942a, r101.f533942a) == true) goto L12;
        return false;
    L12:
        if (this.f533943b == r101.f533943b) goto L15;
        return false;
    L15:
        if (this.f533944c == r101.f533944c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f533945d, r101.f533945d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f533942a.hashCode() * 31;
        long r101 = this.f533943b;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.f533944c;
        return ((r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31) + this.f533945d.hashCode();
    }

    public final String toString() {
        return "EffectStage(id=" + this.f533942a + ", startMs=" + this.f533943b + ", durationMs=" + this.f533944c + ", layers=" + this.f533945d + ')';
    }

    public c(String r100, long r101, List r102) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r102, GXTemplateKey.GAIAX_LAYERS);
        this.f533942a = r100;
        this.f533943b = 0;
        this.f533944c = r101;
        this.f533945d = r102;
    }
}
