package com.ss.videoarch.liveplayer;

/* JADX INFO: loaded from: classes38.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f458812a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f458813b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public VeLivePlayerDef$VeLivePlayerVideoEffectSharpenLevel f458814c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f458815d;

    public boolean isValid() {
        if (this.f458812a == (-1)) goto L5;
    L8:
        return true;
    L5:
        if (this.f458814c != VeLivePlayerDef$VeLivePlayerVideoEffectSharpenLevel.VeLivePlayerSharpenLevelUnknown) goto L8;
        return false;
    }

    public c0() {
        this.f458812a = -1;
        this.f458813b = -1;
        this.f458814c = VeLivePlayerDef$VeLivePlayerVideoEffectSharpenLevel.VeLivePlayerSharpenLevelUnknown;
        this.f458815d = null;
    }
}
