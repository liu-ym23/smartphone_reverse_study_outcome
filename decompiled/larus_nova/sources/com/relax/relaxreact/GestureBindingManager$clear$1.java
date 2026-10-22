package com.relax.relaxreact;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<no name provided>", "", "_execId", "", "gestureId", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 9, 0}, xi = 48)
final class GestureBindingManager$clear$1 extends Lambda implements Function2<Integer, Integer, Unit> {
    final /* synthetic */ p $ele;
    final /* synthetic */ mpa.l $renderer;

    public GestureBindingManager$clear$1(mpa.l r100, p r101) {
        this.$renderer = r100;
        this.$ele = r101;
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Integer r100, Integer r101) {
        invoke(r100.intValue(), r101.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int r100, int r101) {
        mpa.l r102 = this.$renderer;
        Intrinsics.checkNotNull(r102);
        long r103 = this.$ele.f405555a;
        int r104 = com.bytedance.rts.kmp.foundation.c.f267609a;
        r102.a(r103, r101);
    }
}
