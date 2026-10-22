package com.ss.android.lark.forseti.chain;

import com.ss.android.lark.api.bean.ForsetiWidth;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class ForsetiChainHelper$saveForsetiNodeWidthIfNeed$4 extends FunctionReferenceImpl implements Function1<ForsetiWidth, Unit> {
    public ForsetiChainHelper$saveForsetiNodeWidthIfNeed$4(Object r100) {
        super(1, r100, com.ss.android.lark.forseti.util.dragging.d.class, "setLeftForsetiNodeWidth", "setLeftForsetiNodeWidth(Lcom/ss/android/lark/api/bean/ForsetiWidth;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ForsetiWidth r100) {
        ((com.ss.android.lark.forseti.util.dragging.d) this.receiver).getClass();
        com.ss.android.lark.forseti.util.dragging.d.f424620b = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ForsetiWidth r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
