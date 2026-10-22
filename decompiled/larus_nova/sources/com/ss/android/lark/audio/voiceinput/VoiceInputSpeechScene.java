package com.ss.android.lark.audio.voiceinput;

import com.bytedance.lark.pb.im.v1.SpeechScene;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes34.dex */
public final class VoiceInputSpeechScene {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f409196b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SpeechScene f409197a;

    public static final class Companion {
        @JvmStatic
        public static VoiceInputSpeechScene a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "dataId");
            VoiceInputSpeechScene$Companion$doc$1 r101 = VoiceInputSpeechScene$Companion$doc$1.INSTANCE;
            if ((!StringsKt.isBlank(r100)) == true) goto L6;
            r100 = null;
        L6:
            if (r100 != null) goto L9;
            return null;
        L9:
            return new VoiceInputSpeechScene(r101.invoke(new SpeechScene.Builder().data_id(r100)).build());
        }
    }

    static {
    }

    public VoiceInputSpeechScene(SpeechScene r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.f409197a = r100;
    }
}
