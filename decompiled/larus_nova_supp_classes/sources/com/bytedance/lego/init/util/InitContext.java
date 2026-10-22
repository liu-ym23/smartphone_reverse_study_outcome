package com.bytedance.lego.init.util;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class InitContext {
    public static final /* synthetic */ KProperty[] a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static final ConcurrentHashMap<Object, Object> d = null;

    static {
        a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(InitContext.class), "isMainProcess", "isMainProcess()Z")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(InitContext.class), "processName", "getProcessName()Ljava/lang/String;"))};
        new InitContext();
        b = LazyKt.lazy(InitContext$isMainProcess$2.INSTANCE);
        c = LazyKt.lazy(InitContext$processName$2.INSTANCE);
        d = new ConcurrentHashMap();
    }

    public InitContext() {
    }
}
