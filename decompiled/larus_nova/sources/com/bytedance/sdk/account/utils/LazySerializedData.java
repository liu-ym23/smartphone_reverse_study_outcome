package com.bytedance.sdk.account.utils;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes3.dex */
public class LazySerializedData<T> implements j<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f269527d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f269528a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f269529b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<String, T> f269530c;

    static {
        f269527d = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LazySerializedData.class), "data", "getData()Ljava/lang/Object;"))};
    }

    @Override // com.bytedance.sdk.account.utils.j
    public final T getData() {
        Lazy r100 = this.f269528a;
        KProperty r101 = f269527d[0];
        return (T) r100.getValue();
    }

    @Override // com.bytedance.sdk.account.utils.j
    public final boolean isValid() {
        if (this.f269529b.length() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.sdk.account.utils.j
    public final String a() {
        return this.f269529b;
    }

    public final String toString() {
        return this.f269529b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LazySerializedData(String r100, Function1<? super String, ? extends T> r101) {
        this.f269529b = r100;
        this.f269530c = r101;
        this.f269528a = LazyKt.lazy(new LazySerializedData$data$2(this));
    }
}
