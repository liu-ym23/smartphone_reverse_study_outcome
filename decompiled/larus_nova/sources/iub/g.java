package iub;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f495830a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f495831b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f495832c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f495833d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f495834e;

    public g() {
        this(null, 31);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f495830a, r101.f495830a) == true) goto L12;
        return false;
    L12:
        if (this.f495831b == r101.f495831b) goto L15;
        return false;
    L15:
        if (this.f495832c == r101.f495832c) goto L18;
        return false;
    L18:
        if (this.f495833d == r101.f495833d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f495834e, r101.f495834e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f495830a.hashCode() * 31;
        int r101 = 1231;
        if (this.f495831b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f495832c == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.f495833d == true) goto L15;
        r101 = 1237;
    L15:
        return ((r105 + r101) * 31) + this.f495834e.hashCode();
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "MmRecordingAIInterpretationData(recordingId=" + this.f495830a + ", entryVisible=" + this.f495831b + ", enabled=" + this.f495832c + ", loading=" + this.f495833d + ", languageState=" + this.f495834e + ')';
    }

    public /* synthetic */ g(String r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        r100 = "";
    L5:
        String r102 = r100;
        if ((r101 & 16) == 0) goto L8;
        c r103 = new c(0);
    L9:
        this(r102, false, false, false, r103);
        return;
    L8:
        r103 = null;
        goto L9
    }

    public g(String r100, boolean r101, boolean r102, boolean r103, c r104) {
        Intrinsics.checkNotNullParameter(r100, "recordingId");
        Intrinsics.checkNotNullParameter(r104, "languageState");
        this.f495830a = r100;
        this.f495831b = r101;
        this.f495832c = r102;
        this.f495833d = r103;
        this.f495834e = r104;
    }
}
