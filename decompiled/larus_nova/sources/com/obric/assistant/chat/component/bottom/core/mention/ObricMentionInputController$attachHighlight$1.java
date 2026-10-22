package com.obric.assistant.chat.component.bottom.core.mention;

import com.obric.assistant.special_input.j;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class ObricMentionInputController$attachHighlight$1 extends FunctionReferenceImpl implements Function0<Boolean> {
    public ObricMentionInputController$attachHighlight$1(Object r100) {
        super(0, r100, ObricMentionInputController.class, "isMentionEnabled", "isMentionEnabled()Z", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Boolean invoke() {
        ObricMentionInputController r100 = (ObricMentionInputController) this.receiver;
        int r101 = ObricMentionInputController.f386757o;
        r100.getClass();
        if (com.obric.assistant.task.skill.f.d() == true) goto L5;
    L7:
        boolean r102 = false;
    L9:
        return Boolean.valueOf(r102);
    L5:
        if (j.b() == false) goto L7;
        r102 = true;
        goto L9
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return invoke();
    }
}
