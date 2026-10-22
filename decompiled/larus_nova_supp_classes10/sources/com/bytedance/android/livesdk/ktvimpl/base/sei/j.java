package com.bytedance.android.livesdk.ktvimpl.base.sei;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class j implements md0.a.c {
    public j() {
    }

    public final boolean isVersionSupported(int r1, int r2) {
        return true;
    }

    public final void onAudioMvControllerUpdate(String r1) {
    }

    public final void onAudioSubtitleUpdate(String r1) {
    }

    public final /* synthetic */ void onBusinessAppSeiUpdate(JSONObject r1) {
    }

    public final void onRadioSeiUpdate(JSONObject r1) {
    }

    public final void onRadioTextSeiUpdate(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "seiObj");
    }

    public final void onSpeechRecognitionSeiUpdate(String r1) {
    }

    public final /* synthetic */ void onSpeechRhythm(String r1) {
    }

    public final void onVideoStateSeiUpdate(ld0.a r1) {
    }
}
