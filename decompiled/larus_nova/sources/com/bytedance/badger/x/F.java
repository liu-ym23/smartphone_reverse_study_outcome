package com.bytedance.badger.x;

import android.security.keystore.KeyGenParameterSpec;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes47.dex */
final class F extends Lambda implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f199364a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f199365b;

    public F(String r100, int r101) {
        this.f199364a = r100;
        this.f199365b = r101;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        return new KeyGenParameterSpec.Builder(this.f199364a, this.f199365b);
    }
}
