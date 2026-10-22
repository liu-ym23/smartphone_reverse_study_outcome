package com.ss.android.lark.passportc.impl.v2.state;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u0002H\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "State", "", "it", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class StateModel$setState$1 extends Lambda implements Function1<Object, Object> {
    final /* synthetic */ Object $state;

    public StateModel$setState$1(Object r100) {
        this.$state = r100;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        return this.$state;
    }
}
