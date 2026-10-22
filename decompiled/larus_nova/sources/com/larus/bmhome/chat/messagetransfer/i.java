package com.larus.bmhome.chat.messagetransfer;

/* JADX INFO: loaded from: classes25.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f307343a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f307344b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (this.f307343a == r101.f307343a) goto L12;
        return false;
    L12:
        if (this.f307344b == r101.f307344b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f307343a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f307344b;
        return r101 + ((int) (r102 ^ (r102 >>> 32)));
    }

    public final String toString() {
        return "ForwardMessageContent(messageId=" + this.f307343a + ", contentSizeBytes=" + this.f307344b + ')';
    }

    public i(long r100, long r101) {
        this.f307343a = r100;
        this.f307344b = r101;
    }
}
