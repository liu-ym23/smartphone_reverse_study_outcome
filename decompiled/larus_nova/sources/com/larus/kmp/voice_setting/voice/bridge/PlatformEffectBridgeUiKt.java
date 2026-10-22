package com.larus.kmp.voice_setting.voice.bridge;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import com.larus.kmp.voice_setting.voice.component.VoicePlatformEffectKind;
import com.larus.kmp.voice_setting.voice.component.l5;
import com.ss.ttm.player.MediaPlayer;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class PlatformEffectBridgeUiKt {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f351847a = null;

        static {
            int[] r100 = new int[VoicePlatformEffectKind.values().length];
            r100[VoicePlatformEffectKind.PLAY_PREVIEW.ordinal()] = 1;     // Catch: NoSuchFieldError -> L25
        L71:
            r100[VoicePlatformEffectKind.LOAD_MIX_PREVIEW.ordinal()] = 2;     // Catch: NoSuchFieldError -> L26
        L83:
            r100[VoicePlatformEffectKind.STOP_PREVIEW.ordinal()] = 3;     // Catch: NoSuchFieldError -> L27
        L53:
            r100[VoicePlatformEffectKind.RELEASE_MEDIA.ordinal()] = 4;     // Catch: NoSuchFieldError -> L28
        L57:
            r100[VoicePlatformEffectKind.VIBRATE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L29
        L65:
            r100[VoicePlatformEffectKind.REPORT_EDIT_RESULT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L30
        L77:
            r100[VoicePlatformEffectKind.PICK_IMAGE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L31
        L61:
            r100[VoicePlatformEffectKind.CROP_IMAGE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L32
        L73:
            r100[VoicePlatformEffectKind.UPLOAD_IMAGE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L33
        L75:
            r100[VoicePlatformEffectKind.REQUEST_RECORD_PERMISSION.ordinal()] = 10;     // Catch: NoSuchFieldError -> L34
        L47:
            r100[VoicePlatformEffectKind.REQUEST_RECORD_MEDIA.ordinal()] = 11;     // Catch: NoSuchFieldError -> L35
        L69:
            r100[VoicePlatformEffectKind.START_RECORD_QUALITY_CHECK.ordinal()] = 12;     // Catch: NoSuchFieldError -> L36
        L81:
            r100[VoicePlatformEffectKind.STOP_RECORD_QUALITY_CHECK.ordinal()] = 13;     // Catch: NoSuchFieldError -> L37
        L45:
            r100[VoicePlatformEffectKind.CANCEL_RECORD_QUALITY_CHECK.ordinal()] = 14;     // Catch: NoSuchFieldError -> L38
        L59:
            r100[VoicePlatformEffectKind.SHOW_SHELL_FEEDBACK.ordinal()] = 15;     // Catch: NoSuchFieldError -> L39
        L79:
            r100[VoicePlatformEffectKind.NONE.ordinal()] = 16;     // Catch: NoSuchFieldError -> L40
        L51:
            r100[VoicePlatformEffectKind.CREATE_VOICE_PREFLIGHT.ordinal()] = 17;     // Catch: NoSuchFieldError -> L41
        L55:
            r100[VoicePlatformEffectKind.OPEN_PAGE.ordinal()] = 18;     // Catch: NoSuchFieldError -> L42
        L67:
            r100[VoicePlatformEffectKind.FINISH_WITH_RESULT.ordinal()] = 19;     // Catch: NoSuchFieldError -> L43
        L49:
            r100[VoicePlatformEffectKind.DISMISS_DIALOG.ordinal()] = 20;     // Catch: NoSuchFieldError -> L44
        L23:
            f351847a = r100;
        }
    }

    public static final void a(final l5 r110, final t r111, final Function1<? super l5, Boolean> r112, Composer r113, final int r114) {
        Composer r115 = r113.startRestartGroup(775860563);
        if ((r114 & 6) == 0) goto L5;
        int r100 = r114;
    L11:
        if ((r114 & 48) != 0) goto L18;
        if (r115.changed(r111) == false) goto L15;
        int r101 = 32;
    L16:
        r100 = r100 | r101;
        goto L18
    L15:
        r101 = 16;
    L18:
        if ((r114 & 384) == 0) goto L20;
    L24:
        boolean r102 = true;
        if ((r100 & 147) == 146) goto L27;
        boolean r103 = true;
    L29:
        if (r115.shouldExecute(r103, r100 & 1) == true) goto L31;
        r115.skipToGroupEnd();
    L46:
        ScopeUpdateScope r116 = r115.endRestartGroup();
        if (r116 == null) goto L50;
        r116.updateScope(new l(r110, r111, r112, r114));
        return;
    L50:
        return;
    L31:
        if (ComposerKt.isTraceInProgress() == false) goto L33;
        ComposerKt.traceEventStart(775860563, r100, -1, "com.larus.kmp.voice_setting.voice.bridge.VoicePlatformEffectBridge (PlatformEffectBridgeUi.kt:42)");
    L33:
        State r104 = SnapshotStateKt.rememberUpdatedState(r112, r115, (r100 >> 6) & 14);
        VoicePlatformEffectKind r105 = r110.f352355a;
        Long r106 = Long.valueOf(r110.f352356b);
        Boolean r107 = Boolean.valueOf(r111.f351906a);
        r115.startReplaceGroup(-1746271574);
        if ((r100 & 112) == 32) goto L37;
        r102 = false;
    L37:
        boolean r108 = (r115.changedInstance(r110) | r102) | r115.changed(r104);
        Object r109 = r115.rememberedValue();
        if (r108 == false) goto L40;
    L41:
        r109 = new PlatformEffectBridgeUiKt$VoicePlatformEffectBridge$1$1(r111, r110, r104, null);
        r115.updateRememberedValue(r109);
    L42:
        r115.endReplaceGroup();
        EffectsKt.LaunchedEffect(r105, r106, r107, (Function2) r109, r115, 0);
        SpacerKt.Spacer(SizeKt.m778size3ABfNKs(Modifier.Companion, Dp.m7544constructorimpl(0)), r115, 6);
        if (ComposerKt.isTraceInProgress() == false) goto L46;
        ComposerKt.traceEventEnd();
        goto L46
    L40:
        if (r109 != Composer.Companion.getEmpty()) goto L42;
    L27:
        r103 = false;
        goto L29
    L20:
        if (r115.changedInstance(r112) == false) goto L22;
        int r117 = 256;
    L23:
        r100 = r100 | r117;
        goto L24
    L22:
        r117 = 128;
        goto L23
    L5:
        if (r115.changedInstance(r110) == false) goto L7;
        int r118 = 4;
    L8:
        r100 = r118 | r114;
        goto L11
    L7:
        r118 = 2;
        goto L8
    }

    public static final void b(final l5 r100, final t r101, Function1<? super l5, Boolean> r102, Composer r110, final int r111, final int r112) {
        Intrinsics.checkNotNullParameter(r100, "effectData");
        Intrinsics.checkNotNullParameter(r101, "bridgeState");
        Composer r113 = r110.startRestartGroup(-2116630885);
        if ((r112 & 1) == 0) goto L6;
        int r103 = r111 | 6;
    L14:
        if ((r112 & 2) == 0) goto L17;
        r103 = r103 | 48;
    L23:
        int r104 = r112 & 4;
        if (r104 == 0) goto L27;
        r103 = r103 | 384;
    L34:
        if ((r103 & 147) == 146) goto L36;
        boolean r105 = true;
    L38:
        if (r113.shouldExecute(r105, r103 & 1) == false) goto L50;
        if (r104 == 0) goto L45;
        r113.startReplaceGroup(1849434622);
        Object r106 = r113.rememberedValue();
        if (r106 != Composer.Companion.getEmpty()) goto L43;
        r106 = new j();
        r113.updateRememberedValue(r106);
    L43:
        r102 = (Function1) r106;
        r113.endReplaceGroup();
    L45:
        if (ComposerKt.isTraceInProgress() == false) goto L47;
        ComposerKt.traceEventStart(-2116630885, r103, -1, "com.larus.kmp.voice_setting.voice.bridge.VoicePlatformEffectBridgeHost (PlatformEffectBridgeUi.kt:29)");
    L47:
        a(r100, r101, r102, r113, ((r103 & 14) | (r103 & 112)) | (r103 & MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_FRAME_COUNT));
        if (ComposerKt.isTraceInProgress() == false) goto L51;
        ComposerKt.traceEventEnd();
    L51:
        final Function1<? super l5, Boolean> r107 = r102;
        ScopeUpdateScope r108 = r113.endRestartGroup();
        if (r108 == null) goto L55;
        r108.updateScope(new k(r100, r101, r107, r111, r112));
        return;
    L55:
        return;
    L50:
        r113.skipToGroupEnd();
        goto L51
    L36:
        r105 = false;
        goto L38
    L27:
        if ((r111 & 384) != 0) goto L34;
        if (r113.changedInstance(r102) == false) goto L31;
        int r109 = 256;
    L32:
        r103 = r103 | r109;
        goto L34
    L31:
        r109 = 128;
        goto L32
    L17:
        if ((r111 & 48) != 0) goto L23;
        if (r113.changed(r101) == false) goto L21;
        int r114 = 32;
    L22:
        r103 = r103 | r114;
        goto L23
    L21:
        r114 = 16;
        goto L22
    L6:
        if ((r111 & 6) == 0) goto L8;
        r103 = r111;
        goto L14
    L8:
        if (r113.changedInstance(r100) == false) goto L10;
        int r115 = 4;
    L11:
        r103 = r115 | r111;
        goto L14
    L10:
        r115 = 2;
        goto L11
    }
}
