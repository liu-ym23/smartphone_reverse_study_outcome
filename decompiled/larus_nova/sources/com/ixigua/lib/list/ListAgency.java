package com.ixigua.lib.list;

import android.content.Context;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes23.dex */
public final class ListAgency {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f278494a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f278495b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Context f278496c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ListAgency f278497d = null;

    static {
        f278494a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ListAgency.class), "mainHandler", "getMainHandler$liblist_release()Landroid/os/Handler;"))};
        f278497d = new ListAgency();
        new AtomicInteger(0);
        new AtomicInteger(2000000);
        f278495b = LazyKt.lazy(ListAgency$mainHandler$2.INSTANCE);
    }

    public ListAgency() {
    }
}
