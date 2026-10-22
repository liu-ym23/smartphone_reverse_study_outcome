package com.bytedance.iesgurd.request;

import com.bytedance.iesgurd.l;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/iesgurd/l;", "result", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/iesgurd/l;)V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class RequestHelper$updateResourceWithMeta$updateParams$1 extends Lambda implements Function1<l, Unit> {
    final /* synthetic */ String $accessKey;
    final /* synthetic */ com.bytedance.iesgurd.b $params;
    final /* synthetic */ LinkedHashMap $paramsCheckFailedResult;

    public RequestHelper$updateResourceWithMeta$updateParams$1(com.bytedance.iesgurd.b r100, LinkedHashMap r101, String r102) {
        this.$paramsCheckFailedResult = r101;
        this.$accessKey = r102;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(l r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(l r100) {
        throw null;
    }
}
