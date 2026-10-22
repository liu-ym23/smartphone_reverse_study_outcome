package com.larus.home.impl.main.side_bar.view.group.module;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class GroupModuleSupport$projectContent$9 extends FunctionReferenceImpl implements Function3<String, String, Boolean, Unit> {
    public GroupModuleSupport$projectContent$9(Object r100) {
        super(3, r100, com.larus.home.impl.main.side_bar.view.group.assembly.o.class, "removeProject", "removeProject(Ljava/lang/String;Ljava/lang/String;Z)V", 0);
    }

    public final void invoke(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        Intrinsics.checkNotNullParameter(r101, "p1");
        ((com.larus.home.impl.main.side_bar.view.group.assembly.o) this.receiver).b(r100, r101, r102);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(String r100, String r101, Boolean r102) {
        invoke(r100, r101, r102.booleanValue());
        return Unit.INSTANCE;
    }
}
