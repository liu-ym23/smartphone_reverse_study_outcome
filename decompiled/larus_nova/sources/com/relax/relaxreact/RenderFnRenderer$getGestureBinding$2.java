package com.relax.relaxreact;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/relax/relaxreact/Element;", "element", "Lcom/relax/relaxreact/ElementNode;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 9, 0}, xi = 48)
final class RenderFnRenderer$getGestureBinding$2 extends Lambda implements Function1<p, o> {
    final /* synthetic */ RenderFnRenderer this$0;

    public RenderFnRenderer$getGestureBinding$2(RenderFnRenderer r100) {
        this.this$0 = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final o invoke2(p r100) {
        Intrinsics.checkNotNullParameter(r100, "element");
        RenderFnRenderer r101 = this.this$0;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "ele");
        long r102 = r100.f405555a;
        o r103 = (o) com.bytedance.rts.kmp.foundation.j.c(r101.f405423g, Long.valueOf(r102));
        if (r103 != null) goto L7;
        o r104 = new o(r101);
        com.bytedance.rts.kmp.foundation.j.e(r101.f405423g, Long.valueOf(r102), r104);
        return r104;
    L7:
        return r103;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ o invoke(p r100) {
        return invoke2(r100);
    }
}
