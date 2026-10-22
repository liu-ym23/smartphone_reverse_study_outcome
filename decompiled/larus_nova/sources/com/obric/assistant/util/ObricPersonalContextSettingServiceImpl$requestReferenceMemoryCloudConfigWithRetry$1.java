package com.obric.assistant.util;

import android.net.Uri;
import com.bytedance.map.api.monitor.MapMonitorConst;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.util.ObricPersonalContextSettingServiceImpl", f = "ObricPersonalContextSettingServiceImpl.kt", i = {0, 0}, l = {329, 342}, m = "requestReferenceMemoryCloudConfigWithRetry", n = {"index", MapMonitorConst.ATTEMPT}, s = {"I$2", "I$3"})
public final class ObricPersonalContextSettingServiceImpl$requestReferenceMemoryCloudConfigWithRetry$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ObricPersonalContextSettingServiceImpl this$0;

    public ObricPersonalContextSettingServiceImpl$requestReferenceMemoryCloudConfigWithRetry$1(ObricPersonalContextSettingServiceImpl r100, Continuation<? super ObricPersonalContextSettingServiceImpl$requestReferenceMemoryCloudConfigWithRetry$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        ObricPersonalContextSettingServiceImpl r101 = this.this$0;
        Uri r102 = ObricPersonalContextSettingServiceImpl.f393628f;
        return r101.B(this);
    }
}
