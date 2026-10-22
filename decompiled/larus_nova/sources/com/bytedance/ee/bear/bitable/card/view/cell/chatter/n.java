package com.bytedance.ee.bear.bitable.card.view.cell.chatter;

import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.IChatterEntity;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class n implements Function4<List<IChatterEntity>, IChatterEntity, IChatterEntity, Boolean, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f<IChatterEntity> f207611a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f<IChatterEntity>.e f207612b;

    public n(f<IChatterEntity> r100, f<IChatterEntity>.e r101) {
        this.f207611a = r100;
        this.f207612b = r101;
    }

    @Override // kotlin.jvm.functions.Function4
    public final Unit invoke(List<IChatterEntity> r100, IChatterEntity r101, IChatterEntity r102, Boolean r103) {
        List<IChatterEntity> r104 = r100;
        IChatterEntity r105 = r101;
        Intrinsics.checkNotNullParameter(r104, "list");
        Intrinsics.checkNotNullParameter(r102, "clickedChatter");
        f<IChatterEntity> r106 = this.f207611a;
        int r107 = f.f207567x;
        r106.v("select");
        if (Intrinsics.areEqual(r103, Boolean.TRUE) == false) goto L5;
        this.f207611a.D();
    L7:
        return Unit.INSTANCE;
    L5:
        f.e.a(this.f207612b, r104, r105, BitableAnalytic.MemberItemSource.BOTTOM_LIST_SOURCE);
        goto L7
    }
}
