package com.ss.android.lark.audio;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f408966a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f408967b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f408968c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f408969d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f408970e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f408966a, r101.f408966a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f408967b, r101.f408967b) == true) goto L15;
        return false;
    L15:
        if (this.f408968c == r101.f408968c) goto L18;
        return false;
    L18:
        if (this.f408969d == r101.f408969d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f408970e, r101.f408970e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((this.f408966a.hashCode() * 31) + this.f408967b.hashCode()) * 31) + this.f408968c) * 31) + this.f408969d) * 31) + this.f408970e.hashCode();
    }

    public final String toString() {
        return "AudioItem(key=" + this.f408966a + ", messageId=" + this.f408967b + ", duration=" + this.f408968c + ", progress=" + this.f408969d + ", localFilePath=" + this.f408970e + ')';
    }

    public a(String r100, String r101, int r102, int r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "messageId");
        Intrinsics.checkNotNullParameter(r104, "localFilePath");
        this.f408966a = r100;
        this.f408967b = r101;
        this.f408968c = r102;
        this.f408969d = r103;
        this.f408970e = r104;
    }
}
