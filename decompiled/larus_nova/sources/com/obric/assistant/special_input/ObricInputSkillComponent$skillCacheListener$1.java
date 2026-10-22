package com.obric.assistant.special_input;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class ObricInputSkillComponent$skillCacheListener$1 extends FunctionReferenceImpl implements Function1<s0, Unit> {
    public ObricInputSkillComponent$skillCacheListener$1(Object r100) {
        super(1, r100, ObricInputSkillComponent.class, "refreshSkillListFromCache", "refreshSkillListFromCache(Lcom/obric/assistant/special_input/SkillCacheSnapshot;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(s0 r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        ObricInputSkillComponent r101 = (ObricInputSkillComponent) this.receiver;
        int r102 = ObricInputSkillComponent.f392555w;
        r101.Y2(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(s0 r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
