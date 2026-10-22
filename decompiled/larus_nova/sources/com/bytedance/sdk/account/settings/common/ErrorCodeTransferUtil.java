package com.bytedance.sdk.account.settings.common;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes3.dex */
public final class ErrorCodeTransferUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f269336a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f269337b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ErrorCodeTransferUtil f269338c = null;

    static {
        f269336a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ErrorCodeTransferUtil.class), "defaultErrorCodeTransfer", "getDefaultErrorCodeTransfer()Lorg/json/JSONObject;"))};
        f269338c = new ErrorCodeTransferUtil();
        f269337b = LazyKt.lazy(ErrorCodeTransferUtil$defaultErrorCodeTransfer$2.INSTANCE);
    }

    public ErrorCodeTransferUtil() {
    }
}
