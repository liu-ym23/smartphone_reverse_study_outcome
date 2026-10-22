package com.bytedance.salamander.anniex;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/bytedance/salamander/anniex/n0;", "originModel", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/salamander/anniex/n0;)Lcom/bytedance/salamander/anniex/n0;", "<no name provided>"}, k = 3, mv = {1, 4, 3})
final class AnnieXPageViewModel$setPageWidthSizeByPadAdapter$1 extends Lambda implements Function1<n0, n0> {
    final /* synthetic */ z7 $info;

    public AnnieXPageViewModel$setPageWidthSizeByPadAdapter$1(z7 r100) {
        this.$info = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final n0 invoke2(n0 r100) {
        Intrinsics.checkNotNullParameter(r100, "originModel");
        r100.getClass();
        n0 r101 = new n0();
        DistanceUnitType r102 = r100.f268251b;
        Intrinsics.checkNotNullParameter(r102, "pageWidthType");
        r101.f268251b = r102;
        r101.f268250a = r100.f268250a;
        this.$info.getClass();
        Intrinsics.checkNotNullParameter(null, "pageWidthType");
        r101.f268251b = null;
        this.$info.getClass();
        r101.f268250a = 0;
        return r101;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ n0 invoke(n0 r100) {
        return invoke2(r100);
    }
}
