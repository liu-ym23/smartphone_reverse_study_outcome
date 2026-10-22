package com.larus.kmp.voice_setting.voice.screen.doubletab;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class VoiceDoubleTabPageController$schedulePageOwnerAttach$3 extends FunctionReferenceImpl implements Function2<Integer, String, Unit> {
    public VoiceDoubleTabPageController$schedulePageOwnerAttach$3(Object r100) {
        super(2, r100, VoiceDoubleTabPageController.class, "attachPageOwner", "attachPageOwner(ILjava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Integer r100, String r101) {
        invoke(r100.intValue(), r101);
        return Unit.INSTANCE;
    }

    public final void invoke(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "p1");
        ((VoiceDoubleTabPageController) this.receiver).b(r100, r101);
    }
}
