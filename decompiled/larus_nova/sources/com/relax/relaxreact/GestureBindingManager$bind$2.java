package com.relax.relaxreact;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<no name provided>", "", "_execId", "", "gestureId", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 9, 0}, xi = 48)
final class GestureBindingManager$bind$2 extends Lambda implements Function2<Integer, Integer, Unit> {
    final /* synthetic */ p $ele;
    final /* synthetic */ ArrayList<Integer> $nextGestureIds;
    final /* synthetic */ mpa.l $renderer;

    public GestureBindingManager$bind$2(ArrayList<Integer> r100, mpa.l r101, p r102) {
        this.$nextGestureIds = r100;
        this.$renderer = r101;
        this.$ele = r102;
        super(2);
    }

    public final void invoke(int r100, int r101) {
        ArrayList<Integer> r102 = this.$nextGestureIds;
        Intrinsics.checkNotNullParameter(r102, "gestureIds");
        boolean r103 = false;
        int r104 = 0;
    L3:
        IntCompanionObject r105 = IntCompanionObject.INSTANCE;
        Intrinsics.checkNotNullParameter(r102, "<this>");
        int r106 = r102.size();
        Intrinsics.checkNotNullParameter(r105, "<this>");
        if (r104 >= r106) goto L12;
        Integer r107 = (Integer) ListProtector.get(r102, r104);
        if (r107 == null) goto L11;
        if (r107.intValue() != r101) goto L11;
        r103 = true;
    L11:
        r104 = r104 + 1;
    L12:
        if (r103 == true) goto L19;
        mpa.l r108 = this.$renderer;
        Intrinsics.checkNotNull(r108);
        long r109 = this.$ele.f405555a;
        int r110 = com.bytedance.rts.kmp.foundation.c.f267609a;
        r108.a(r109, r101);
        return;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Integer r100, Integer r101) {
        invoke(r100.intValue(), r101.intValue());
        return Unit.INSTANCE;
    }
}
