package com.larus.kmp.voice_setting.voice.base;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class PublicVoiceListFragment$perfTracer$2$1 extends FunctionReferenceImpl implements Function1<String, x2a.a> {
    public static final PublicVoiceListFragment$perfTracer$2$1 INSTANCE = null;

    static {
        INSTANCE = new PublicVoiceListFragment$perfTracer$2$1();
    }

    public PublicVoiceListFragment$perfTracer$2$1() {
        super(1, ih9.b.class, "voiceSettingFpsTraceDelegate", "voiceSettingFpsTraceDelegate(Ljava/lang/String;)Lcom/larus/voice_setting/voice/perf/FpsTraceDelegate;", 1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final x2a.a invoke2(String r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        Intrinsics.checkNotNullParameter(r100, "sceneName");
        return new ih9.a(new et3.c(r100, false, null));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ x2a.a invoke(String r100) {
        return invoke2(r100);
    }
}
