package com.bytedance.pia.core.bridge.methods;

import com.bytedance.pia.core.api.bridge.PiaMethod;

/* JADX INFO: loaded from: classes21.dex */
public final class p<T> implements l47.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l47.a<PiaMethod.Error> f266212a;

    public p(m47.i r100) {
        this.f266212a = r100;
    }

    @Override // l47.a
    public final void accept(Object r100) {
        this.f266212a.accept(new PiaMethod.Error(((Throwable) r100).toString()));
    }
}
