package com.bytedance.ee.bear.document.icon;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class IconSelectFragment$initRecyclerView$1 extends FunctionReferenceImpl implements Function1<DocIconNetResult.Icon, Unit> {
    public IconSelectFragment$initRecyclerView$1(Object r100) {
        super(1, r100, IconSelectFragment.class, "clickIcon", "clickIcon(Lcom/bytedance/ee/bear/document/icon/DocIconNetResult$Icon;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(DocIconNetResult.Icon r100) {
        IconSelectFragment r101 = (IconSelectFragment) this.receiver;
        int r102 = IconSelectFragment.f219967s;
        r101.U90(r100, false);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(DocIconNetResult.Icon r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
