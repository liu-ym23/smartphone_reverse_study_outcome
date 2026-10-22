package com.bytedance.lego.init.util;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes.dex */
public final class InitContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f254566a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f254567b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f254568c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ConcurrentHashMap<Object, Object> f254569d = null;

    static {
        f254566a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(InitContext.class), "isMainProcess", "isMainProcess()Z")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(InitContext.class), "processName", "getProcessName()Ljava/lang/String;"))};
        new InitContext();
        f254567b = LazyKt.lazy(InitContext$isMainProcess$2.INSTANCE);
        f254568c = LazyKt.lazy(InitContext$processName$2.INSTANCE);
        f254569d = new ConcurrentHashMap();
    }

    public InitContext() {
    }
}
