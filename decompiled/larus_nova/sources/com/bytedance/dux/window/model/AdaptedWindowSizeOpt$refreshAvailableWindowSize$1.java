package com.bytedance.dux.window.model;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class AdaptedWindowSizeOpt$refreshAvailableWindowSize$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ float $heightDp;
    final /* synthetic */ float $widthDp;

    public AdaptedWindowSizeOpt$refreshAvailableWindowSize$1(float r100, float r101) {
        this.$widthDp = r100;
        this.$heightDp = r101;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Set<Integer> r100 = a.f205955b;
        new hm4.a(this.$widthDp, this.$heightDp);
        Set<Integer> r101 = a.f205955b;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
