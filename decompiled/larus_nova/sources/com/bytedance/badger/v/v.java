package com.bytedance.badger.v;

import java.util.Collection;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public abstract class v {
    public v() {
    }

    public final f a(String r100, boolean r101) {
        return new f(this, r100, new n(r101));
    }

    public final g b(String r100, long r101, TimeUnit r102) {
        return new g(this, r100, new o(r101, r102), r102);
    }

    public final h c(String r100, int r101) {
        return new h(this, r100, new p(r101));
    }

    public final k d(String r100, long r101) {
        return new k(this, r100, new s(r101));
    }

    public final m e(String r100, Collection r101) {
        return new m(this, r100, new u(r101));
    }
}
