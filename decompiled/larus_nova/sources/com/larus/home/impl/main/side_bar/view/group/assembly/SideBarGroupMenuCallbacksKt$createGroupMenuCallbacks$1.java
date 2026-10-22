package com.larus.home.impl.main.side_bar.view.group.assembly;

import com.larus.home.impl.main.side_bar.view.group.policy.ConversationGroupPolicy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class SideBarGroupMenuCallbacksKt$createGroupMenuCallbacks$1 extends FunctionReferenceImpl implements Function1<ConversationGroupPolicy, Unit> {
    public SideBarGroupMenuCallbacksKt$createGroupMenuCallbacks$1(Object r100) {
        super(1, r100, n.class, "onGroupPolicySelected", "onGroupPolicySelected(Lcom/larus/home/impl/main/side_bar/view/group/policy/ConversationGroupPolicy;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ConversationGroupPolicy r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        ((n) this.receiver).b(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ConversationGroupPolicy r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
