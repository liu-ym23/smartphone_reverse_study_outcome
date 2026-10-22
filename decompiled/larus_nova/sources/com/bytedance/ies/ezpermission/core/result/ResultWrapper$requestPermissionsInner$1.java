package com.bytedance.ies.ezpermission.core.result;

import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\t\u001a\u0004\u0018\u00010\b2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00000\u0006H\u0086@"}, d2 = {"", "", ComplianceResult.JsonKey.PERMISSIONS, "Lkotlin/Function0;", "", "block", "Lkotlin/coroutines/Continuation;", "continuation", "", "requestPermissionsInner"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.bytedance.ies.ezpermission.core.result.ResultWrapper", f = "ResultWrapper.kt", i = {0, 0, 0, 1, 1, 1}, l = {51, 52, 53}, m = "requestPermissionsInner", n = {"this", ComplianceResult.JsonKey.PERMISSIONS, "block", "this", ComplianceResult.JsonKey.PERMISSIONS, "block"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
public final class ResultWrapper$requestPermissionsInner$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ResultWrapper this$0;

    public ResultWrapper$requestPermissionsInner$1(ResultWrapper r100, Continuation r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, this);
    }
}
