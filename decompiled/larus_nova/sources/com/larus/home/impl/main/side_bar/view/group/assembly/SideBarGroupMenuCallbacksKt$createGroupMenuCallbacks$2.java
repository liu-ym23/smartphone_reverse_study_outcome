package com.larus.home.impl.main.side_bar.view.group.assembly;

import com.larus.home.impl.main.side_bar.view.group.datasource.GroupSortPolicy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class SideBarGroupMenuCallbacksKt$createGroupMenuCallbacks$2 extends FunctionReferenceImpl implements Function1<GroupSortPolicy, Unit> {
    public SideBarGroupMenuCallbacksKt$createGroupMenuCallbacks$2(Object r100) {
        super(1, r100, n.class, "onSortPolicySelected", "onSortPolicySelected(Lcom/larus/home/impl/main/side_bar/view/group/datasource/GroupSortPolicy;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GroupSortPolicy r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        ((n) this.receiver).k(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GroupSortPolicy r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
