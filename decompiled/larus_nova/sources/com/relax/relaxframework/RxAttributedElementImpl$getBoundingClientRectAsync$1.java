package com.relax.relaxframework;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.relax.runtime.gen.BoundingClientRect;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003j\u0002`\u0005H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<no name provided>", "Lcom/relax/runtime/gen/BoundingClientRect;", "res", "", "", "Lcom/relax/relaxframework/GetBoundingClientRectRes;", AbsMethodDelegate.TAG_INVOKE, "([Ljava/lang/Object;)Lcom/relax/runtime/gen/BoundingClientRect;"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class RxAttributedElementImpl$getBoundingClientRectAsync$1 extends Lambda implements Function1<Object[], BoundingClientRect> {
    public static final RxAttributedElementImpl$getBoundingClientRectAsync$1 INSTANCE = null;

    static {
        INSTANCE = new RxAttributedElementImpl$getBoundingClientRectAsync$1();
    }

    public RxAttributedElementImpl$getBoundingClientRectAsync$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final BoundingClientRect invoke2(Object[] r100) {
        Intrinsics.checkNotNullParameter(r100, "res");
        Object r101 = r100[1];
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.relax.runtime.gen.BoundingClientRect");
        return (BoundingClientRect) r101;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ BoundingClientRect invoke(Object[] r100) {
        return invoke2(r100);
    }
}
