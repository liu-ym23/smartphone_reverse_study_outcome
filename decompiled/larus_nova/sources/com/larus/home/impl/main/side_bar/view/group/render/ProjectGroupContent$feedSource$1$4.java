package com.larus.home.impl.main.side_bar.view.group.render;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class ProjectGroupContent$feedSource$1$4 extends FunctionReferenceImpl implements Function2<Integer, com.larus.home.impl.main.side_bar.data.j0, Unit> {
    public ProjectGroupContent$feedSource$1$4(Object r100) {
        super(2, r100, j0.class, "reportShow", "reportShow(ILcom/larus/home/impl/main/side_bar/data/SideBarItemConfig;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Integer r100, com.larus.home.impl.main.side_bar.data.j0 r101) {
        invoke(r100.intValue(), r101);
        return Unit.INSTANCE;
    }

    public final void invoke(int r100, com.larus.home.impl.main.side_bar.data.j0 r101) {
        Intrinsics.checkNotNullParameter(r101, "p1");
        ((j0) this.receiver).f(r100, r101);
    }
}
