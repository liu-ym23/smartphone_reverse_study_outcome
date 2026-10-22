package com.larus.home.impl.main.side_bar.view.group.module;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class GroupModuleSupport$projectContent$8 extends FunctionReferenceImpl implements Function2<String, String, Unit> {
    public GroupModuleSupport$projectContent$8(Object r100) {
        super(2, r100, com.larus.home.impl.main.side_bar.view.group.assembly.o.class, "showHideProjectConversationsDialog", "showHideProjectConversationsDialog(Ljava/lang/String;Ljava/lang/String;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        Intrinsics.checkNotNullParameter(r101, "p1");
        ((com.larus.home.impl.main.side_bar.view.group.assembly.o) this.receiver).c(r100, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(String r100, String r101) {
        invoke2(r100, r101);
        return Unit.INSTANCE;
    }
}
