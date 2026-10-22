package com.obric.matrixpro.sdk.deviceinfoclient;

import android.os.HandlerThread;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class DeviceInfoGetter$initThreadIfNeeded$1 extends MutablePropertyReference0Impl {
    public DeviceInfoGetter$initThreadIfNeeded$1(a r100) {
        super(r100, a.class, "handlerThread", "getHandlerThread()Landroid/os/HandlerThread;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        a r100 = (a) this.receiver;
        HandlerThread r101 = a.f397034a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("handlerThread");
    L5:
        return r101;
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        a r101 = (a) this.receiver;
        a.f397034a = (HandlerThread) r100;
    }
}
