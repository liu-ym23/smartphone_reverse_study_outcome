package com.larus.kmp.voice_setting.voice.utils;

import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f355112a;

    public l() {
        Intrinsics.checkNotNullParameter("Voice-Setting", EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter("Voice-Clone", "subModule");
        this.f355112a = "Voice-Setting-Voice-Clone";
    }

    public final k a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "what");
        return new k(this.f355112a, VoiceSettingLogLevel.ERROR, r100);
    }

    public final k b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "what");
        return new k(this.f355112a, VoiceSettingLogLevel.INFO, r100);
    }
}
