package com.relax.relaxframework;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/relax/relaxframework/o0;", "e", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/relax/relaxframework/o0;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
final class RxCustomElementImpl$setEventListener$1 extends Lambda implements Function1<o0, Object> {
    final /* synthetic */ h5 this$0;

    public RxCustomElementImpl$setEventListener$1(h5 r100) {
        this.this$0 = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(o0 r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        h5 r101 = this.this$0;
        int r102 = h5.f405117x;
        r101.getClass();
        LinkedHashMap r103 = new LinkedHashMap();
        com.bytedance.rts.foundation.m.e(r103, "detail", r100.e());
        return r103;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(o0 r100) {
        return invoke2(r100);
    }
}
