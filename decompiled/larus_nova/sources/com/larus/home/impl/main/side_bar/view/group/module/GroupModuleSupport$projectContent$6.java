package com.larus.home.impl.main.side_bar.view.group.module;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class GroupModuleSupport$projectContent$6 extends FunctionReferenceImpl implements Function1<String, Unit> {
    public GroupModuleSupport$projectContent$6(Object r100) {
        super(1, r100, com.larus.home.impl.main.side_bar.view.group.assembly.o.class, "startCreateConversationInProject", "startCreateConversationInProject(Ljava/lang/String;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        ((com.larus.home.impl.main.side_bar.view.group.assembly.o) this.receiver).a(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
