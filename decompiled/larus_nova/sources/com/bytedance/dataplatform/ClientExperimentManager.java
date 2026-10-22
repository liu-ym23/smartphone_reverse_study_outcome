package com.bytedance.dataplatform;

import android.app.Application;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Triple;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes3.dex */
public final class ClientExperimentManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f204275a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Application f204276b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static q f204277c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List<Triple<String, ij4.a<?>, String>> f204278d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f204279e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ClientExperimentManager f204280f = null;

    static {
        f204275a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ClientExperimentManager.class), "clientExperimentLayer", "getClientExperimentLayer()Ljava/util/Map;"))};
        f204280f = new ClientExperimentManager();
        f204278d = new CopyOnWriteArrayList();
        new HashMap();
        f204279e = LazyKt.lazy(ClientExperimentManager$clientExperimentLayer$2.INSTANCE);
    }

    public ClientExperimentManager() {
    }

    public final Application getContext() {
        return f204276b;
    }
}
