package kb8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f502253a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f502254b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f502255c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f502256d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f502257e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f502258f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o) == true) goto L8;
        return false;
    L8:
        o r101 = (o) r100;
        if (Intrinsics.areEqual(this.f502253a, r101.f502253a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f502254b, r101.f502254b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f502255c, r101.f502255c) == true) goto L18;
        return false;
    L18:
        if (this.f502256d == r101.f502256d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f502257e, r101.f502257e) == true) goto L24;
        return false;
    L24:
        if (this.f502258f == r101.f502258f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f502253a.hashCode() * 31) + this.f502254b.hashCode()) * 31) + this.f502255c.hashCode()) * 31;
        int r101 = 1231;
        if (this.f502256d == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (((r100 + r102) * 31) + this.f502257e.hashCode()) * 31;
        if (this.f502258f == true) goto L11;
        r101 = 1237;
    L11:
        return r103 + r101;
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "ReferenceData(messageId=" + this.f502253a + ", conversationId=" + this.f502254b + ", botId=" + this.f502255c + ", isDeepThinkingShow=" + this.f502256d + ", chatType=" + this.f502257e + ", isHalfFold=" + this.f502258f + ')';
    }

    public o(String r100, String r101, String r102, boolean r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "messageId");
        Intrinsics.checkNotNullParameter(r101, "conversationId");
        Intrinsics.checkNotNullParameter(r102, "botId");
        Intrinsics.checkNotNullParameter(r104, "chatType");
        this.f502253a = r100;
        this.f502254b = r101;
        this.f502255c = r102;
        this.f502256d = r103;
        this.f502257e = r104;
        this.f502258f = false;
    }
}
