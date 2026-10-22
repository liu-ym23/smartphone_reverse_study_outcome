package com.bytedance.ee.bear.bitable.card.view.cell.chatter;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.IChatterEntity;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class m implements Function2<List<IChatterEntity>, IChatterEntity, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f<IChatterEntity>.e f207609a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f<IChatterEntity> f207610b;

    public m(f<IChatterEntity>.e r100, f<IChatterEntity> r101) {
        this.f207609a = r100;
        this.f207610b = r101;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Unit invoke(List<IChatterEntity> r100, IChatterEntity r101) {
        List<IChatterEntity> r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "list");
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        f.e.a(this.f207609a, r102, null, BitableAnalytic.MemberItemSource.TOP_BAR_SOURCE);
        this.f207610b.v("delete");
        return Unit.INSTANCE;
    }
}
