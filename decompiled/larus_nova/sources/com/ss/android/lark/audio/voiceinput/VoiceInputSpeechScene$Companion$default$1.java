package com.ss.android.lark.audio.voiceinput;

import com.bytedance.lark.pb.im.v1.SpeechScene;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/bytedance/lark/pb/im/v1/SpeechScene$Builder;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class VoiceInputSpeechScene$Companion$default$1 extends Lambda implements Function1<SpeechScene.Builder, SpeechScene.Builder> {
    public static final VoiceInputSpeechScene$Companion$default$1 INSTANCE = null;

    static {
        INSTANCE = new VoiceInputSpeechScene$Companion$default$1();
    }

    public VoiceInputSpeechScene$Companion$default$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final SpeechScene.Builder invoke2(SpeechScene.Builder r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$build");
        return r100.speech_default(new SpeechScene.SpeechDefault.Builder().build());
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ SpeechScene.Builder invoke(SpeechScene.Builder r100) {
        return invoke2(r100);
    }
}
