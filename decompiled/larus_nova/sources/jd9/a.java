package jd9;

import com.larus.im.internal.utils.a0;
import com.larus.im.service.audio.x0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x0 f498750a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a0<c> f498751b;

    public a() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f498750a, r101.f498750a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f498751b, r101.f498751b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f498750a.hashCode() * 31) + this.f498751b.hashCode();
    }

    public final String toString() {
        return "AudioSessionContext(config=" + this.f498750a + ", sessionState=" + this.f498751b + ')';
    }

    public a(x0 r100) {
        d r101 = new d();
        Intrinsics.checkNotNullParameter(r100, "config");
        Intrinsics.checkNotNullParameter(r101, "sessionState");
        this.f498750a = r100;
        this.f498751b = r101;
    }
}
