package com.bytedance.iesgurd;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/iesgurd/e;", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/iesgurd/e;)V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class IESGurdKit$checkResExistOnlyOffline$1 extends Lambda implements Function1<e, Unit> {
    final /* synthetic */ Ref.ObjectRef $geckoData;

    public IESGurdKit$checkResExistOnlyOffline$1(Ref.ObjectRef r100) {
        this.$geckoData = r100;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(e r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(e r100) {
        this.$geckoData.element = r100;
    }
}
