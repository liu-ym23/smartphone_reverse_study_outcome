package com.fackbook.drawee;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes3.dex */
public final class DefaultDraweeConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f274110a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f274111b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final DefaultDraweeConfig f274112c = null;

    static {
        f274110a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DefaultDraweeConfig.class), "initializer", "getInitializer()Lcom/facebook/common/internal/Supplier;"))};
        f274112c = new DefaultDraweeConfig();
        f274111b = LazyKt.lazy(DefaultDraweeConfig$initializer$2.INSTANCE);
    }

    public DefaultDraweeConfig() {
    }
}
