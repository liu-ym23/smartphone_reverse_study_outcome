package com.bytedance.sdk.account.utils;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes22.dex */
public class LazyUnserializedData<T> implements j<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f269531d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f269532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f269533b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<T, String> f269534c;

    static {
        f269531d = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LazyUnserializedData.class), "serialized", "getSerialized()Ljava/lang/String;"))};
    }

    @Override // com.bytedance.sdk.account.utils.j
    public final String a() {
        Lazy r100 = this.f269532a;
        KProperty r101 = f269531d[0];
        return (String) r100.getValue();
    }

    @Override // com.bytedance.sdk.account.utils.j
    public final boolean isValid() {
        if (this.f269533b == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final String toString() {
        T r100 = this.f269533b;
        if (r100 == null) goto L7;
        String r101 = r100.toString();
        if (r101 == null) goto L7;
        return r101;
    L7:
        return "null";
    }

    @Override // com.bytedance.sdk.account.utils.j
    public final T getData() {
        return this.f269533b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LazyUnserializedData(T r100, Function1<? super T, String> r101) {
        this.f269533b = r100;
        this.f269534c = r101;
        this.f269532a = LazyKt.lazy(new LazyUnserializedData$serialized$2(this));
    }
}
