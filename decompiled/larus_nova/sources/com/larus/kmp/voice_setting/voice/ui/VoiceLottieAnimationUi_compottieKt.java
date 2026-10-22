package com.larus.kmp.voice_setting.voice.ui;

import androidx.compose.foundation.ImageKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.Modifier;
import com.larus.im.FlowRuntime;
import com.ss.ttm.player.MediaPlayer;
import io.github.alexzhirkevich.compottie.LottieAnimatableImpl;
import io.github.alexzhirkevich.compottie.LottieComposition;
import io.github.alexzhirkevich.compottie.LottieCompositionResultImpl;
import io.github.alexzhirkevich.compottie.b0;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class VoiceLottieAnimationUi_compottieKt {
    public static final void b(String r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L4
        FlowRuntime.b().e().i("VoiceDoubleTabUi", r100);     // Catch: Throwable -> L4
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Result.Companion r102 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void a(final String r110, Modifier r210, Object r211, Function2<? super Composer, ? super Integer, Unit> r212, Composer r213, final int r214, final int r215) {
        Intrinsics.checkNotNullParameter(r110, "assetPath");
        Composer r111 = r213.startRestartGroup(781986263);
        if ((r215 & 1) == 0) goto L6;
        int r100 = r214 | 6;
    L13:
        int r101 = r215 & 2;
        if (r101 == 0) goto L17;
        r100 = r100 | 48;
    L23:
        Modifier r102 = r210;
    L24:
        int r103 = r215 & 4;
        if (r103 == 0) goto L28;
        r100 = r100 | 384;
    L34:
        Object r104 = r211;
    L35:
        int r112 = r215 & 8;
        if (r112 == 0) goto L39;
        r100 = r100 | 3072;
    L45:
        Function2<? super Composer, ? super Integer, Unit> r113 = r212;
    L46:
        int r114 = r100;
        boolean r115 = true;
        if ((r114 & 1171) == 1170) goto L49;
        boolean r105 = true;
    L51:
        if (r111.shouldExecute(r105, r114 & 1) == false) goto L121;
        if (r101 == 0) goto L54;
        Modifier r116 = Modifier.Companion;
    L55:
        if (r103 == 0) goto L57;
        Object r117 = Unit.INSTANCE;
    L58:
        if (r112 == 0) goto L61;
        r113 = a.f354965a;
    L61:
        if (ComposerKt.isTraceInProgress() == false) goto L63;
        ComposerKt.traceEventStart(781986263, r114, -1, "com.larus.kmp.voice_setting.voice.ui.VoiceLoopingLottieImage (VoiceLottieAnimationUi.compottie.kt:27)");
    L63:
        r111.startReplaceGroup(5004770);
        int r106 = r114 & 14;
        if (r106 != 4) goto L66;
        boolean r107 = true;
    L67:
        Object r108 = r111.rememberedValue();
        if (r107 == false) goto L70;
    L71:
        r108 = SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        r111.updateRememberedValue(r108);
    L72:
        MutableState r109 = (MutableState) r108;
        r111.endReplaceGroup();
        r111.startReplaceGroup(-130468505);
        if (((Boolean) r109.getValue()).booleanValue() == false) goto L90;
        r111.startReplaceGroup(5004770);
        if (r106 == 4) goto L78;
        r115 = false;
    L78:
        Object r118 = r111.rememberedValue();
        if (r115 == false) goto L81;
    L82:
        r118 = new VoiceLottieAnimationUi_compottieKt$VoiceLoopingLottieImage$1$1(r110, null);
        r111.updateRememberedValue(r118);
    L83:
        r111.endReplaceGroup();
        EffectsKt.LaunchedEffect(r110, (Function2) r118, r111, r106);
        r113.invoke(r111, Integer.valueOf((r114 >> 9) & 14));
        r111.endReplaceGroup();
        if (ComposerKt.isTraceInProgress() == false) goto L86;
        ComposerKt.traceEventEnd();
    L86:
        ScopeUpdateScope r119 = r111.endRestartGroup();
        if (r119 == null) goto L126;
        final Modifier r120 = r116;
        final Object r121 = r117;
        final Function2<? super Composer, ? super Integer, Unit> r122 = r113;
        r119.updateScope(new q(r110, r120, r121, r122, r214, r215));
        return;
    L126:
        return;
    L81:
        if (r118 != Composer.Companion.getEmpty()) goto L83;
    L90:
        r111.endReplaceGroup();
        Object[] r123 = {r110};
        r111.startReplaceGroup(5004770);
        if (r106 != 4) goto L93;
        boolean r124 = true;
    L94:
        Object r125 = r111.rememberedValue();
        if (r124 == false) goto L97;
    L98:
        r125 = new VoiceLottieAnimationUi_compottieKt$VoiceLoopingLottieImage$result$1$1(r110, null);
        r111.updateRememberedValue(r125);
    L99:
        r111.endReplaceGroup();
        LottieCompositionResultImpl r126 = io.github.alexzhirkevich.compottie.s.a(r123, (Function1) r125, r111);
        Boolean r127 = Boolean.valueOf(((Boolean) r126.f490713g.getValue()).booleanValue());
        Boolean r128 = Boolean.valueOf(r126.isFailure());
        r111.startReplaceGroup(-1746271574);
        boolean r129 = r111.changed(r126);
        if (r106 == 4) goto L103;
        r115 = false;
    L103:
        boolean r130 = (r129 | r115) | r111.changed(r109);
        Object r131 = r111.rememberedValue();
        if (r130 == false) goto L106;
    L107:
        r131 = new VoiceLottieAnimationUi_compottieKt$VoiceLoopingLottieImage$3$1(r126, r110, r109, null);
        r111.updateRememberedValue(r131);
    L108:
        r111.endReplaceGroup();
        EffectsKt.LaunchedEffect(r110, r127, r128, (Function2) r131, r111, r106);
        LottieComposition r132 = (LottieComposition) r126.f490708b.getValue();
        r111.startReplaceGroup(-130441409);
        if (r132 != null) goto L117;
        r113.invoke(r111, Integer.valueOf((r114 >> 9) & 14));
        r111.endReplaceGroup();
        if (ComposerKt.isTraceInProgress() == false) goto L113;
        ComposerKt.traceEventEnd();
    L113:
        ScopeUpdateScope r133 = r111.endRestartGroup();
        if (r133 == null) goto L127;
        final Modifier r134 = r116;
        final Object r135 = r117;
        final Function2<? super Composer, ? super Integer, Unit> r136 = r113;
        r133.updateScope(new r(r110, r134, r135, r136, r214, r215));
        return;
    L127:
        return;
    L117:
        r111.endReplaceGroup();
        r111.startMovableGroup(-130438571, r111.joinKey(r110, r117));
        final LottieAnimatableImpl r137 = io.github.alexzhirkevich.compottie.a.a(r132, r111);
        Function2<? super Composer, ? super Integer, Unit> r138 = r113;
        Object r139 = r117;
        Composer r140 = r111;
        ImageKt.Image(b0.a(r132, new VoiceLottieAnimationUi_compottieKt$VoiceLoopingLottieImage$5(r137), r111), null, r116, null, null, 0.0f, null, r111, ((r114 << 3) & MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_FRAME_COUNT) | 48, 120);
        r140.endMovableGroup();
        if (ComposerKt.isTraceInProgress() == false) goto L120;
        ComposerKt.traceEventEnd();
    L120:
        final Object r141 = r139;
        final Function2<? super Composer, ? super Integer, Unit> r142 = r138;
        final Modifier r143 = r116;
    L122:
        ScopeUpdateScope r144 = r140.endRestartGroup();
        if (r144 == null) goto L128;
        r144.updateScope(new s(r110, r143, r141, r142, r214, r215));
        return;
    L128:
        return;
    L106:
        if (r131 != Composer.Companion.getEmpty()) goto L108;
    L97:
        if (r125 != Composer.Companion.getEmpty()) goto L99;
    L93:
        r124 = false;
        goto L94
    L70:
        if (r108 != Composer.Companion.getEmpty()) goto L72;
    L66:
        r107 = false;
        goto L67
    L57:
        r117 = r104;
        goto L58
    L54:
        r116 = r102;
        goto L55
    L121:
        r140 = r111;
        r140.skipToGroupEnd();
        r143 = r102;
        r141 = r104;
        r142 = r113;
        goto L122
    L49:
        r105 = false;
        goto L51
    L39:
        if ((r214 & 3072) != 0) goto L45;
        r113 = r212;
        if (r111.changedInstance(r113) == false) goto L43;
        int r145 = 2048;
    L44:
        r100 = r100 | r145;
        goto L46
    L43:
        r145 = 1024;
        goto L44
    L28:
        if ((r214 & 384) != 0) goto L34;
        r104 = r211;
        if (r111.changedInstance(r104) == false) goto L32;
        int r146 = 256;
    L33:
        r100 = r100 | r146;
        goto L35
    L32:
        r146 = 128;
        goto L33
    L17:
        if ((r214 & 48) != 0) goto L23;
        r102 = r210;
        if (r111.changed(r102) == false) goto L21;
        int r147 = 32;
    L22:
        r100 = r100 | r147;
        goto L24
    L21:
        r147 = 16;
        goto L22
    L6:
        if ((r214 & 6) == 0) goto L8;
        r100 = r214;
        goto L13
    L8:
        if (r111.changed(r110) == false) goto L10;
        int r148 = 4;
    L11:
        r100 = r148 | r214;
        goto L13
    L10:
        r148 = 2;
        goto L11
    }
}
