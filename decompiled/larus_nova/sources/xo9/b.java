package xo9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f564686a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f564687b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f564688c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f564689d;

    public b() {
        this(false, null, null, 15);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f564686a == r101.f564686a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f564687b, r101.f564687b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f564688c, r101.f564688c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f564689d, r101.f564689d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        if (this.f564686a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = ((r100 * 31) + this.f564687b.hashCode()) * 31;
        String r102 = this.f564688c;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r101 + r104) * 31;
        String r106 = this.f564689d;
        if (r106 == null) goto L15;
        r103 = r106.hashCode();
    L15:
        return r105 + r103;
    L9:
        r104 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "OfficeDrivePreviewAiConfig(forceDarkModeForMedia=" + this.f564686a + ", flowReadyProvider=" + this.f564687b + ", sourceConversationId=" + this.f564688c + ", sourceBotId=" + this.f564689d + ')';
    }

    public b(boolean r100, String r101, String r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r103 & 2) == 0) goto L8;
        c r104 = new a();
    L10:
        if ((r103 & 4) == 0) goto L13;
        r101 = null;
    L13:
        if ((r103 & 8) == 0) goto L15;
        r102 = null;
    L15:
        Intrinsics.checkNotNullParameter(r104, "flowReadyProvider");
        this.f564686a = r100;
        this.f564687b = r104;
        this.f564688c = r101;
        this.f564689d = r102;
        return;
    L8:
        r104 = null;
        goto L10
    }
}
