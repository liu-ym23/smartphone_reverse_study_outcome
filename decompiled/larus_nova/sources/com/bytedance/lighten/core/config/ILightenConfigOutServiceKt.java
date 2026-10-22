package com.bytedance.lighten.core.config;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes3.dex */
public final class ILightenConfigOutServiceKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f254668a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f254669b = null;

    static {
        f254668a = new KProperty[]{Reflection.property0(new PropertyReference0Impl(Reflection.getOrCreateKotlinPackage(ILightenConfigOutServiceKt.class, "lighten-core_release"), "LightenConfigOutService", "getLightenConfigOutService()Lcom/bytedance/lighten/core/config/ILightenConfigOutService;"))};
        f254669b = LazyKt.lazy(ILightenConfigOutServiceKt$LightenConfigOutService$2.INSTANCE);
    }

    public static final ILightenConfigOutService a() {
        Lazy r100 = f254669b;
        KProperty r101 = f254668a[0];
        return (ILightenConfigOutService) r100.getValue();
    }
}
