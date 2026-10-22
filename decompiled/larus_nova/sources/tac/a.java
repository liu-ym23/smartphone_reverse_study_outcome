package tac;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final wac.a f545223a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final uac.a f545224b;

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f545223a, r101.f545223a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f545224b, r101.f545224b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f545223a.hashCode() * 31) + this.f545224b.hashCode();
    }

    public final String toString() {
        return "VoiceConfig(recordConfig=" + this.f545223a + ", asrConfig=" + this.f545224b + ')';
    }

    public /* synthetic */ a(int r100) {
        this(new wac.a(null, 1023), new uac.a(null, 63));
    }

    public a(wac.a r100, uac.a r101) {
        Intrinsics.checkNotNullParameter(r100, "recordConfig");
        Intrinsics.checkNotNullParameter(r101, "asrConfig");
        this.f545223a = r100;
        this.f545224b = r101;
    }
}
