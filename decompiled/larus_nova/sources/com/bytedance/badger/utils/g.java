package com.bytedance.badger.utils;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f199256b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f199257a;

    static {
        f199256b = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(g.class), "list", "getList()[Ljava/lang/String;"))};
    }

    public g() {
        this.f199257a = LazyKt.lazy(a.f199213a);
    }
}
