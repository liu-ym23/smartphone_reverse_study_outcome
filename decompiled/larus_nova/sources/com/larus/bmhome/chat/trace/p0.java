package com.larus.bmhome.chat.trace;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f310258a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f310259b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f310260c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f310261d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p0) == true) goto L8;
        return false;
    L8:
        p0 r101 = (p0) r100;
        if (this.f310258a == r101.f310258a) goto L12;
        return false;
    L12:
        if (this.f310259b == r101.f310259b) goto L15;
        return false;
    L15:
        if (this.f310260c == r101.f310260c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f310261d, r101.f310261d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        if (this.f310258a == false) goto L5;
        int r100 = 1231;
    L6:
        long r101 = this.f310259b;
        int r102 = ((r100 * 31) + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.f310260c;
        int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        String r105 = this.f310261d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L11:
        return r104 + r106;
    L9:
        r106 = r105.hashCode();
        goto L11
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "SpeakInfo(isSpeakHandsFree=" + this.f310258a + ", speakDuration=" + this.f310259b + ", handsfreeSpeakDuration=" + this.f310260c + ", handsfreeEnterMethod=" + this.f310261d + ')';
    }

    public final String a() {
        return this.f310261d;
    }

    public final long b() {
        return this.f310260c;
    }

    public final long c() {
        return this.f310259b;
    }

    public final boolean d() {
        return this.f310258a;
    }

    public p0(boolean r100, long r101, long r102, String r103) {
        this.f310258a = r100;
        this.f310259b = r101;
        this.f310260c = r102;
        this.f310261d = r103;
    }
}
