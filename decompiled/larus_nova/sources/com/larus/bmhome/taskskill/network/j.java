package com.larus.bmhome.taskskill.network;

/* JADX INFO: loaded from: classes26.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f314381a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f314382b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f314383c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (this.f314381a == r101.f314381a) goto L12;
        return false;
    L12:
        if (this.f314382b == r101.f314382b) goto L15;
        return false;
    L15:
        if (this.f314383c == r101.f314383c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f314381a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        if (this.f314382b == false) goto L5;
        int r102 = 1231;
    L7:
        return ((r101 + r102) * 31) + this.f314383c;
    L5:
        r102 = 1237;
        goto L7
    }

    public final String toString() {
        return "SuggestionSkillMetadata(lastUsedAtMs=" + this.f314381a + ", isRecommend=" + this.f314382b + ", position=" + this.f314383c + ')';
    }

    public j(long r100, boolean r101, int r102) {
        this.f314381a = r100;
        this.f314382b = r101;
        this.f314383c = r102;
    }
}
