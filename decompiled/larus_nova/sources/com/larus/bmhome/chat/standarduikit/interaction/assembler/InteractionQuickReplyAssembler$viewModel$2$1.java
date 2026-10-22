package com.larus.bmhome.chat.standarduikit.interaction.assembler;

import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class InteractionQuickReplyAssembler$viewModel$2$1 extends FunctionReferenceImpl implements Function0<Unit> {
    public InteractionQuickReplyAssembler$viewModel$2$1(Object r100) {
        super(0, r100, InteractionQuickReplyAssembler.class, ChameleonOpenTracker.Stage.RENDER, "render()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((InteractionQuickReplyAssembler) this.receiver).a();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
