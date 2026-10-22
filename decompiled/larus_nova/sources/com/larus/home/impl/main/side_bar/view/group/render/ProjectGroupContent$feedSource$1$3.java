package com.larus.home.impl.main.side_bar.view.group.render;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class ProjectGroupContent$feedSource$1$3 extends FunctionReferenceImpl implements Function3<Integer, com.larus.home.impl.main.side_bar.data.j0, String, Unit> {
    public ProjectGroupContent$feedSource$1$3(Object r100) {
        super(3, r100, j0.class, "reportClick", "reportClick(ILcom/larus/home/impl/main/side_bar/data/SideBarItemConfig;Ljava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(Integer r100, com.larus.home.impl.main.side_bar.data.j0 r101, String r102) {
        invoke(r100.intValue(), r101, r102);
        return Unit.INSTANCE;
    }

    public final void invoke(int r100, com.larus.home.impl.main.side_bar.data.j0 r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "p1");
        ((j0) this.receiver).d(r100, r101, r102);
    }
}
