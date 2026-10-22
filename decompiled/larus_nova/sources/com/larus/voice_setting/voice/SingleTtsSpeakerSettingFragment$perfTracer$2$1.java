package com.larus.voice_setting.voice;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class SingleTtsSpeakerSettingFragment$perfTracer$2$1 extends FunctionReferenceImpl implements Function1<String, x2a.a> {
    public static final SingleTtsSpeakerSettingFragment$perfTracer$2$1 INSTANCE = null;

    static {
        INSTANCE = new SingleTtsSpeakerSettingFragment$perfTracer$2$1();
    }

    public SingleTtsSpeakerSettingFragment$perfTracer$2$1() {
        super(1, x2a.c.class, "voiceSettingFpsTraceDelegate", "voiceSettingFpsTraceDelegate(Ljava/lang/String;)Lcom/larus/voice_setting/voice/perf/FpsTraceDelegate;", 1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final x2a.a invoke2(String r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        Intrinsics.checkNotNullParameter(r100, "sceneName");
        return new x2a.b(new et3.c(r100, false, null));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ x2a.a invoke(String r100) {
        return invoke2(r100);
    }
}
