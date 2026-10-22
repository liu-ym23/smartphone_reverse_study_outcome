package com.larus.dora.obric.device_management.explore;

import java.util.List;

/* JADX INFO: loaded from: classes27.dex */
public final class w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f339604a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f339605b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<u0> f339606c;

    public w0() {
        this(false, 15);
    }

    public /* synthetic */ w0(boolean r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        r100 = true;
    L5:
        this(r100, null, null);
    }

    public w0(boolean r100, String r101, List r102) {
        this.f339604a = r100;
        this.f339605b = r101;
        this.f339606c = r102;
    }
}
