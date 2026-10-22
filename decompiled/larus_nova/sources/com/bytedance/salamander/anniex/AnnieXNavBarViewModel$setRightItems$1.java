package com.bytedance.salamander.anniex;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/bytedance/salamander/anniex/i0;", BaseSwitches.V, AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/salamander/anniex/i0;)Lcom/bytedance/salamander/anniex/i0;", "<no name provided>"}, k = 3, mv = {1, 4, 3})
final class AnnieXNavBarViewModel$setRightItems$1 extends Lambda implements Function1<i0, i0> {
    final /* synthetic */ ArrayList<j0> $rightItems;

    public AnnieXNavBarViewModel$setRightItems$1(ArrayList<j0> r100) {
        this.$rightItems = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final i0 invoke2(i0 r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        i0 r101 = r100.a();
        ArrayList<j0> r102 = this.$rightItems;
        Intrinsics.checkNotNullParameter(r102, "items");
        r101.f268109e = r102;
        return r101;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ i0 invoke(i0 r100) {
        return invoke2(r100);
    }
}
