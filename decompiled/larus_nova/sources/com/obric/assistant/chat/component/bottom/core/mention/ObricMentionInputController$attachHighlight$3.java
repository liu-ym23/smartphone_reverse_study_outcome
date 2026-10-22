package com.obric.assistant.chat.component.bottom.core.mention;

import com.obric.assistant.ability.chat.input.SkillSelectSource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class ObricMentionInputController$attachHighlight$3 extends FunctionReferenceImpl implements Function1<String, Unit> {
    public ObricMentionInputController$attachHighlight$3(Object r100) {
        super(1, r100, ObricMentionInputController.class, "onSelectMention", "onSelectMention(Ljava/lang/String;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        ObricMentionInputController r101 = (ObricMentionInputController) this.receiver;
        paa.c r102 = r101.f386760c;
        if (r102 == null) goto L5;
        r102.YW(r100, SkillSelectSource.MENTION);
    L5:
        r101.g();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
