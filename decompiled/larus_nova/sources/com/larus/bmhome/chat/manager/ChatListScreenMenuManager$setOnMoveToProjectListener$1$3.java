package com.larus.bmhome.chat.manager;

import com.larus.bmhome.view.screenmenu.x0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AdaptedFunctionReference;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class ChatListScreenMenuManager$setOnMoveToProjectListener$1$3 extends AdaptedFunctionReference implements Function0<Unit> {
    public ChatListScreenMenuManager$setOnMoveToProjectListener$1$3(Object r100) {
        super(0, r100, x0.class, "close", "close()Lkotlin/Unit;", 8);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((x0) this.receiver).c();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
