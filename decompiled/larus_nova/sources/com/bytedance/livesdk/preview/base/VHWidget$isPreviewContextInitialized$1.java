package com.bytedance.livesdk.preview.base;

import com.bytedance.livesdk.preview.viewmodel.VHPreviewContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class VHWidget$isPreviewContextInitialized$1 extends MutablePropertyReference0Impl {
    public VHWidget$isPreviewContextInitialized$1(VHWidget r100) {
        super(r100, VHWidget.class, "previewContext", "getPreviewContext()Lcom/bytedance/livesdk/preview/viewmodel/VHPreviewContext;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        return ((VHWidget) this.receiver).xq();
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        VHWidget r101 = (VHWidget) this.receiver;
        VHPreviewContext r102 = (VHPreviewContext) r100;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r101.f256409c = r102;
    }
}
