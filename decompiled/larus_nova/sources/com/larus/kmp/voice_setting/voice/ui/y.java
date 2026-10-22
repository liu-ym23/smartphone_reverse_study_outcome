package com.larus.kmp.voice_setting.voice.ui;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import com.larus.dora.impl.ota.g2.j0;
import com.ss.ttm.player.MediaPlayer;

/* JADX INFO: loaded from: classes30.dex */
public final class y {
    public static final x a(Composer r117) {
        r117.startReplaceGroup(978466695);
        if (ComposerKt.isTraceInProgress() == false) goto L6;
        ComposerKt.traceEventStart(978466695, 0, -1, "com.larus.kmp.voice_setting.voice.ui.voiceSettingColors (VoiceSettingColors.kt:39)");
    L6:
        if (z.a(r117) == false) goto L8;
        long r100 = ColorKt.Color(4278190080L);
        long r101 = ColorKt.Color(4280624421L);
        long r102 = ColorKt.Color(536870911);
        Color.Companion r310 = Color.Companion;
        x r103 = new x(r100, r101, r102, r310.m4864getWhite0d7_KjU(), ColorKt.Color(4286019447L), ColorKt.Color(4291611852L), ColorKt.Color(4278879487L), ColorKt.Color(536870911), ColorKt.Color(352321535), ColorKt.Color(536870911), r310.m4864getWhite0d7_KjU(), r310.m4864getWhite0d7_KjU(), ColorKt.Color(1291845632), ColorKt.Color(4281874488L), ColorKt.Color(4280624421L), ColorKt.Color(4280624421L), ColorKt.Color(4282729797L), r310.m4864getWhite0d7_KjU(), ColorKt.Color(4294919482L), ColorKt.Color(4294919482L), ColorKt.Color(872367418), ColorKt.Color(644261119), ColorKt.Color(352321535), ColorKt.Color(4281874488L), ColorKt.Color(4281874488L), ColorKt.Color(4286019447L), ColorKt.Color(536870911), ColorKt.Color(3439329279L));
    L10:
        if (ComposerKt.isTraceInProgress() == false) goto L12;
        ComposerKt.traceEventEnd();
    L12:
        r117.endReplaceGroup();
        return r103;
    L8:
        long r610 = ColorKt.Color(4294440951L);
        Color.Companion r104 = Color.Companion;
        r103 = new x(r610, r104.m4864getWhite0d7_KjU(), ColorKt.Color(MediaPlayer.MEDIA_INFO_SOCKET_CONNECTRED), r104.m4853getBlack0d7_KjU(), ColorKt.Color(4288256409L), ColorKt.Color(4284900966L), ColorKt.Color(4278216447L), ColorKt.Color(335544320), ColorKt.Color(MediaPlayer.MEDIA_INFO_SOCKET_CONNECTRED), ColorKt.Color(436207616), r104.m4853getBlack0d7_KjU(), r104.m4864getWhite0d7_KjU(), ColorKt.Color(1291845632), ColorKt.Color(4294440951L), r104.m4864getWhite0d7_KjU(), r104.m4864getWhite0d7_KjU(), ColorKt.Color(4293322470L), r104.m4853getBlack0d7_KjU(), ColorKt.Color(4294916912L), ColorKt.Color(4292422944L), ColorKt.Color(4294960360L), ColorKt.Color(436233983), ColorKt.Color(4294112503L), ColorKt.Color(4293060848L), ColorKt.Color(4292668415L), ColorKt.Color(4288256409L), ColorKt.Color(MediaPlayer.MEDIA_INFO_SOCKET_CONNECTRED), ColorKt.Color(j0.G2_OTA_SPACE_RESERVE_BYTES));
        goto L10
    }
}
