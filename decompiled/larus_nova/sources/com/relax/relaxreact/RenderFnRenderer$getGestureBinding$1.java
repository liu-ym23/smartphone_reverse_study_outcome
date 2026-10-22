package com.relax.relaxreact;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u000121\u0010\u0002\u001a-\u0012#\u0012!\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004j\u0002`\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0003H\n¢\u0006\u0002\b\u000b"}, d2 = {"<no name provided>", "", "callback", "Lkotlin/Function1;", "", "", "Lcom/relax/relaxreact/UnspecifiedJsonPayload;", "Lkotlin/ParameterName;", "name", WsConstants.KEY_PAYLOAD, "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 9, 0}, xi = 48)
final class RenderFnRenderer$getGestureBinding$1 extends Lambda implements Function1<Function1<? super Map<String, Object>, ? extends Unit>, Object> {
    final /* synthetic */ com.bytedance.rts.kmp.foundation.p<RenderFnRenderer> $weakThis;

    public RenderFnRenderer$getGestureBinding$1(com.bytedance.rts.kmp.foundation.p<RenderFnRenderer> r100) {
        this.$weakThis = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(final Function1<? super Map<String, Object>, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        final com.bytedance.rts.kmp.foundation.p<RenderFnRenderer> r101 = this.$weakThis;
        Function1<Object, Unit> r102 = new RenderFnRenderer$getGestureBinding$1$wrappedCallback$1(r101, r100);
        int r103 = com.relax.relaxreact.utils.a.f405592a;
        Intrinsics.checkNotNullParameter(r102, "callback");
        Intrinsics.checkNotNullParameter(r102, "callback");
        AtomicLong r104 = mpa.j.f514756a;
        Intrinsics.checkNotNullParameter(r102, "callback");
        return new mpa.c(r102);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Function1<? super Map<String, Object>, ? extends Unit> r100) {
        return invoke2(r100);
    }
}
