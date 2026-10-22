package com.ss.android.ainote;

import com.ss.android.ainote.model.AINoteContentState;

/* JADX INFO: loaded from: classes34.dex */
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f406738a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f406739b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AINoteContentState f406740c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e0) == true) goto L8;
        return false;
    L8:
        e0 r101 = (e0) r100;
        if (this.f406738a == r101.f406738a) goto L12;
        return false;
    L12:
        if (this.f406739b == r101.f406739b) goto L15;
        return false;
    L15:
        if (this.f406740c == r101.f406740c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f406738a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f406739b;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        AINoteContentState r104 = this.f406740c;
        if (r104 != null) goto L5;
        int r105 = 0;
    L7:
        return r103 + r105;
    L5:
        r105 = r104.hashCode();
        goto L7
    }

    public final String toString() {
        return "AINotePushMeta(sid=" + this.f406738a + ", version=" + this.f406739b + ", contentState=" + this.f406740c + ')';
    }

    public e0(long r100, long r101, AINoteContentState r102) {
        this.f406738a = r100;
        this.f406739b = r101;
        this.f406740c = r102;
    }
}
