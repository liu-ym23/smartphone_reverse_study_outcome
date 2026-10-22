package wc9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f559224a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f559225b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f559226c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f559227d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f559228e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f559224a, r101.f559224a) == true) goto L12;
        return false;
    L12:
        if (this.f559225b == r101.f559225b) goto L15;
        return false;
    L15:
        if (this.f559226c == r101.f559226c) goto L18;
        return false;
    L18:
        if (this.f559227d == r101.f559227d) goto L21;
        return false;
    L21:
        if (this.f559228e == r101.f559228e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f559224a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = ((r101 * 31) + this.f559225b) * 31;
        if (this.f559226c == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        long r105 = this.f559227d;
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        long r107 = this.f559228e;
        return r106 + ((int) (r107 ^ (r107 >>> 32)));
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ConversationListAnchor(conversationId=" + this.f559224a + ", conversationType=" + this.f559225b + ", pinned=" + this.f559226c + ", pinTime=" + this.f559227d + ", version=" + this.f559228e + ')';
    }

    public f(String r100, int r101, boolean r102, long r103, long r104) {
        this.f559224a = r100;
        this.f559225b = r101;
        this.f559226c = r102;
        this.f559227d = r103;
        this.f559228e = r104;
    }
}
