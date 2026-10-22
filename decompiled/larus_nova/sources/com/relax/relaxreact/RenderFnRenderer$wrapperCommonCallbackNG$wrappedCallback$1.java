package com.relax.relaxreact;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<no name provided>", "", WsConstants.KEY_PAYLOAD, "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 9, 0}, xi = 48)
final class RenderFnRenderer$wrapperCommonCallbackNG$wrappedCallback$1 extends Lambda implements Function1<Object, Unit> {
    final /* synthetic */ Function1<Map<String, Object>, Unit> $callback;
    final /* synthetic */ com.bytedance.rts.kmp.foundation.p<RenderFnRenderer> $weakThis;

    /* JADX WARN: Multi-variable type inference failed */
    public RenderFnRenderer$wrapperCommonCallbackNG$wrappedCallback$1(com.bytedance.rts.kmp.foundation.p<RenderFnRenderer> r100, Function1<? super Map<String, Object>, Unit> r101) {
        this.$weakThis = r100;
        this.$callback = r101;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(final Object r100) {
        Intrinsics.checkNotNullParameter(r100, WsConstants.KEY_PAYLOAD);
        RenderFnRenderer r101 = (RenderFnRenderer) com.bytedance.rts.kmp.foundation.q.a(this.$weakThis);
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.f405426j == true) goto L10;
        final Function1<Map<String, Object>, Unit> r102 = this.$callback;
        r101.q(new AnonymousClass1(r102, r100));
        return;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Object r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
