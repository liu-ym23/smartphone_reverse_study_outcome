package com.bytedance.badger.x;

import java.security.spec.AlgorithmParameterSpec;

/* JADX INFO: loaded from: classes47.dex */
public abstract class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f199391a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f199392b;

    public k(String r100, int r101) {
        this.f199391a = r100;
        this.f199392b = r101;
    }

    public abstract k a(String... r100);

    public abstract AlgorithmParameterSpec b();

    public abstract k c(String... r100);
}
