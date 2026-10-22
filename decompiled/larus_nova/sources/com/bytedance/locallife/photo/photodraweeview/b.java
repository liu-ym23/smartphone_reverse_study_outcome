package com.bytedance.locallife.photo.photodraweeview;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f262100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f262101b;

    public b() {
        this(0, null, 1023);
    }

    public final int getType() {
        return this.f262100a;
    }

    public b(int r100, String r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = "";
    L8:
        Intrinsics.checkNotNullParameter(r101, "url");
        this.f262100a = r100;
        this.f262101b = r101;
    }
}
