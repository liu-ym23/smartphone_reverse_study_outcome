package com.larus.asr.session;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class LiveTutorAsrOnlySessionV2$createComponents$3 extends FunctionReferenceImpl implements Function1<com.larus.asr.session.component.f0, Boolean> {
    public LiveTutorAsrOnlySessionV2$createComponents$3(Object r100) {
        super(1, r100, LiveTutorAsrOnlySessionV2.class, "needVibrateAfterPermission", "needVibrateAfterPermission(Lcom/larus/asr/session/component/AsrSessionContext;)Z", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(com.larus.asr.session.component.f0 r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        return Boolean.valueOf(((LiveTutorAsrOnlySessionV2) this.receiver).m(r100));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(com.larus.asr.session.component.f0 r100) {
        return invoke2(r100);
    }
}
