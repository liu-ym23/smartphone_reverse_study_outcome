package com.bytedance.iesgurd.request;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE, "com/bytedance/iesgurd/request/UpdateRequest$onFailed$1$1"}, k = 3, mv = {1, 1, 16})
public final class UpdateRequest$onFailed$$inlined$let$lambda$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function2 $it;
    final /* synthetic */ UpdateRequest this$0;

    public UpdateRequest$onFailed$$inlined$let$lambda$1(Function2 r100, UpdateRequest r101) {
        this.$it = r100;
        this.this$0 = r101;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.$it.invoke(this.this$0.f250800h, null);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
