package fr2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f478555a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f478556b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f478557c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f478558d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof y) == false) goto L14;
        y r101 = (y) r100;
        if (this.f478555a == r101.f478555a) goto L8;
        return false;
    L8:
        if (this.f478556b == r101.f478556b) goto L10;
        return false;
    L10:
        if (this.f478557c == r101.f478557c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f478558d, r101.f478558d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f478555a * 31;
        long r101 = this.f478556b;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.f478557c;
        int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        String r105 = this.f478558d;
        if (r105 == null) goto L5;
        int r106 = r105.hashCode();
    L7:
        return r104 + r106;
    L5:
        r106 = 0;
        goto L7
    }

    public final String toString() {
        return "IMixStreamVideoEffectMsg(msgId=" + this.f478555a + ", arg1=" + this.f478556b + ", arg2=" + this.f478557c + ", arg3=" + this.f478558d + ")";
    }

    public y(int r100, long r101, long r102, String r103) {
        Intrinsics.checkNotNullParameter(r103, "arg3");
        this.f478555a = r100;
        this.f478556b = r101;
        this.f478557c = r102;
        this.f478558d = r103;
    }
}
