package com.larus.kmp.voice_setting.voice.ui;

import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;

/* JADX INFO: loaded from: classes30.dex */
public final class z {
    public static final boolean a(Composer r100) {
        r100.startReplaceGroup(-473115954);
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-473115954, 0, -1, "com.larus.kmp.voice_setting.voice.ui.isVoiceSettingDarkTheme (VoiceSettingTheme.android.kt:6)");
    L5:
        boolean r101 = DarkThemeKt.isSystemInDarkTheme(r100, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        r100.endReplaceGroup();
        return r101;
    }
}
