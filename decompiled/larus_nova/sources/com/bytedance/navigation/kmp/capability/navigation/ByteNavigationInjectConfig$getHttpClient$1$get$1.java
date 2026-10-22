package com.bytedance.navigation.kmp.capability.navigation;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.navigation.kmp.capability.navigation.ByteNavigationInjectConfig$getHttpClient$1", f = "ByteNavigationInjectConfig.kt", i = {}, l = {22}, m = MonitorConstants.CONNECT_TYPE_GET, n = {}, s = {})
final class ByteNavigationInjectConfig$getHttpClient$1$get$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ h this$0;

    public ByteNavigationInjectConfig$getHttpClient$1$get$1(h r100, Continuation<? super ByteNavigationInjectConfig$getHttpClient$1$get$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, null, null, null, this);
    }
}
