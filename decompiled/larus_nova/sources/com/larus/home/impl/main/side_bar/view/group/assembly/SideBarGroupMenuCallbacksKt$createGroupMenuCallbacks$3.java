package com.larus.home.impl.main.side_bar.view.group.assembly;

import com.larus.home.impl.main.side_bar.view.group.policy.ConversationArchiveFilter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class SideBarGroupMenuCallbacksKt$createGroupMenuCallbacks$3 extends FunctionReferenceImpl implements Function1<ConversationArchiveFilter, Unit> {
    public SideBarGroupMenuCallbacksKt$createGroupMenuCallbacks$3(Object r100) {
        super(1, r100, n.class, "onArchiveFilterSelected", "onArchiveFilterSelected(Lcom/larus/home/impl/main/side_bar/view/group/policy/ConversationArchiveFilter;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ConversationArchiveFilter r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        ((n) this.receiver).l(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ConversationArchiveFilter r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
