package com.lynx.animax.loader;

import u4a.k;

/* JADX INFO: loaded from: classes32.dex */
public class AnimaXLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f380301a;

    public AnimaXLoader(k r100) {
        this.f380301a = r100;
    }

    public static AnimaXLoader create(k r100) {
        return new AnimaXLoader(r100);
    }

    public void load(AnimaXLoaderRequest r100, AnimaXLoaderCompletionHandler r101) {
        this.f380301a.a(r100, r101);
    }
}
