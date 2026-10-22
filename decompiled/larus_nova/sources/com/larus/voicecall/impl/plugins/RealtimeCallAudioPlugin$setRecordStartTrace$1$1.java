package com.larus.voicecall.impl.plugins;

import com.obric.assistant.spi.audio.ObricBackTraceLogDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class RealtimeCallAudioPlugin$setRecordStartTrace$1$1 extends FunctionReferenceImpl implements Function2<String, Long, Unit> {
    public RealtimeCallAudioPlugin$setRecordStartTrace$1$1(Object r100) {
        super(2, r100, ObricBackTraceLogDelegate.class, "reportBackTraceRecorderConfig", "reportBackTraceRecorderConfig(Ljava/lang/String;J)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(String r100, Long r101) {
        invoke(r100, r101.longValue());
        return Unit.INSTANCE;
    }

    public final void invoke(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        ((ObricBackTraceLogDelegate) this.receiver).a(r100, r101);
    }
}
