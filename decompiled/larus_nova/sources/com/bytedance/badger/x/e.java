package com.bytedance.badger.x;

import android.security.keystore.KeyGenParameterSpec;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class e extends k {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f199377d = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f199378c;

    static {
        f199377d = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(e.class), "builder", "getBuilder()Landroid/security/keystore/KeyGenParameterSpec$Builder;"))};
    }

    public e(String r100, int r101) {
        super(r100, r101);
        this.f199378c = LazyKt.lazy(new F(r100, r101));
    }

    @Override // com.bytedance.badger.x.k
    public final AlgorithmParameterSpec b() {
        Lazy r100 = this.f199378c;
        KProperty r101 = f199377d[0];
        return ((KeyGenParameterSpec.Builder) r100.getValue()).build();
    }

    @Override // com.bytedance.badger.x.k
    public final k a(String... r100) {
        Lazy r101 = this.f199378c;
        KProperty r102 = f199377d[0];
        ((KeyGenParameterSpec.Builder) r101.getValue()).setDigests((String[]) Arrays.copyOf(r100, r100.length));
        return this;
    }

    @Override // com.bytedance.badger.x.k
    public final k c(String... r100) {
        Lazy r101 = this.f199378c;
        KProperty r102 = f199377d[0];
        ((KeyGenParameterSpec.Builder) r101.getValue()).setSignaturePaddings((String[]) Arrays.copyOf(r100, r100.length));
        return this;
    }
}
