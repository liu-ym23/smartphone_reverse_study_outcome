package com.bytedance.lark.open_app_android;

import kotlin.UInt;
import kotlin.ULong;
import open_app.proto.FileStat;

/* JADX INFO: loaded from: classes19.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f253420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f253421b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f253422c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f253423d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f253420a == r101.f253420a) goto L12;
        return false;
    L12:
        if (this.f253421b == r101.f253421b) goto L15;
        return false;
    L15:
        if (this.f253422c == r101.f253422c) goto L18;
        return false;
    L18:
        if (this.f253423d == r101.f253423d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((UInt.m9556hashCodeimpl(this.f253420a) * 31) + ULong.m9635hashCodeimpl(this.f253421b)) * 31) + ULong.m9635hashCodeimpl(this.f253422c)) * 31) + ULong.m9635hashCodeimpl(this.f253423d);
    }

    public final String toString() {
        return "FileStat(mode=" + UInt.m9590toStringimpl(this.f253420a) + ", size=" + ULong.m9669toStringimpl(this.f253421b) + ", lastAccessedTime=" + ULong.m9669toStringimpl(this.f253422c) + ", lastModifiedTime=" + ULong.m9669toStringimpl(this.f253423d) + ')';
    }

    public final FileStat a() {
        return new FileStat(Integer.valueOf(this.f253420a), Long.valueOf(this.f253421b), Long.valueOf(this.f253422c), Long.valueOf(this.f253423d));
    }

    public c(int r100, long r101, long r102, long r103) {
        this.f253420a = r100;
        this.f253421b = r101;
        this.f253422c = r102;
        this.f253423d = r103;
    }
}
