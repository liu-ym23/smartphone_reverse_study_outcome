package com.bytedance.ee.bear.document.icon;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class IconSelectFragment$initRecyclerView$1 extends FunctionReferenceImpl implements Function1<DocIconNetResult.Icon, Unit> {
    public IconSelectFragment$initRecyclerView$1(Object r8) {
        super(1, r8, IconSelectFragment.class, "clickIcon", "clickIcon(Lcom/bytedance/ee/bear/document/icon/DocIconNetResult$Icon;)V", 0);
    }

    public final void invoke(DocIconNetResult.Icon r3) {
        IconSelectFragment r0 = (IconSelectFragment) ((CallableReference) this).receiver;
        int r1 = IconSelectFragment.s;
        r0.U90(r3, false);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((DocIconNetResult.Icon) r1);
        return Unit.INSTANCE;
    }
}
