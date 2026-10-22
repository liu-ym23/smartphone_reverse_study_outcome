package com.ss.videoarch.liveplayer;

/* JADX INFO: loaded from: classes38.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f458816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f458817b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f458818c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f458819d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f458820e;

    public boolean isValid() {
        if (this.f458816a == (-1)) goto L5;
    L10:
        return true;
    L5:
        if (this.f458817b != (-1)) goto L10;
        if (this.f458818c != (-1)) goto L10;
        return false;
    }

    public d0() {
        this.f458816a = -1;
        this.f458817b = -1;
        this.f458818c = -1;
        this.f458819d = -1;
        this.f458820e = null;
    }
}
