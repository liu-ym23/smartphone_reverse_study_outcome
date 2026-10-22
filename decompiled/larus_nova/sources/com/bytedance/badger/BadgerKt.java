package com.bytedance.badger;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes3.dex */
public final class BadgerKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f199016a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f199017b = null;

    static {
        f199016a = new KProperty[]{Reflection.property0(new PropertyReference0Impl(Reflection.getOrCreateKotlinPackage(BadgerKt.class, "badger-api_release"), "core", "getCore()Lcom/bytedance/badger/IBadger;"))};
        f199017b = LazyKt.lazy(BadgerKt$core$2.INSTANCE);
    }
}
