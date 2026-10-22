package mh9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f513980a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Long f513981b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f513982c;

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
        if (Intrinsics.areEqual(this.f513980a, r101.f513980a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f513981b, r101.f513981b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f513982c, r101.f513982c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f513980a.hashCode() * 31;
        Long r101 = this.f513981b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Long r105 = this.f513982c;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "VoiceMixTraceSession(mixId=" + this.f513980a + ", enteredAtMs=" + this.f513981b + ", firstOperationAtMs=" + this.f513982c + ')';
    }

    public /* synthetic */ a(int r100) {
        this("", null, null);
    }

    public static a a(a r100, Long r101) {
        String r102 = r100.f513980a;
        Long r103 = r100.f513981b;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r102, "mixId");
        return new a(r102, r103, r101);
    }

    public a(String r100, Long r101, Long r102) {
        Intrinsics.checkNotNullParameter(r100, "mixId");
        this.f513980a = r100;
        this.f513981b = r101;
        this.f513982c = r102;
    }
}
