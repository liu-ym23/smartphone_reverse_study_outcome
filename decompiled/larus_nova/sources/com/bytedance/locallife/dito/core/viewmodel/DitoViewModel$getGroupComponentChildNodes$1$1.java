package com.bytedance.locallife.dito.core.viewmodel;

import com.bytedance.locallife.dito.view.VisibleState;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/locallife/dito/data/m;", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/locallife/dito/data/m;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class DitoViewModel$getGroupComponentChildNodes$1$1 extends Lambda implements Function1<com.bytedance.locallife.dito.data.m, Boolean> {
    final /* synthetic */ VisibleState $visibility;

    public DitoViewModel$getGroupComponentChildNodes$1$1(VisibleState r100) {
        this.$visibility = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(com.bytedance.locallife.dito.data.m r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        if (r100.r() == false) goto L9;
        VisibleState r101 = this.$visibility;
        if (r101 != null) goto L7;
    L8:
        boolean r102 = true;
    L11:
        return Boolean.valueOf(r102);
    L7:
        if (r100.f258225e == r101) goto L8;
    L9:
        r102 = false;
        goto L11
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(com.bytedance.locallife.dito.data.m r100) {
        return invoke2(r100);
    }
}
