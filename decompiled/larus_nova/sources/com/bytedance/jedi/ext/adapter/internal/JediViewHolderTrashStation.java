package com.bytedance.jedi.ext.adapter.internal;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes19.dex */
public final class JediViewHolderTrashStation {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f251025b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f251026a;

    static {
        f251025b = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(JediViewHolderTrashStation.class), "trashStation", "getTrashStation()Landroid/util/SparseArray;"))};
    }

    public JediViewHolderTrashStation() {
        this.f251026a = LazyKt.lazy(JediViewHolderTrashStation$trashStation$2.INSTANCE);
    }
}
