package com.larus.kmp.voice_setting.voice.screen.doubletab;

import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import com.larus.im.FlowRuntime;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float f354254a = 0.0f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final float f354255b = 0.0f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final float f354256c = 0.0f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long f354257d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final float f354258e = 0.0f;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final float f354259f = 0.0f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final float f354260g = 0.0f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final float f354261h = 0.0f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final float f354262i = 0.0f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final float f354263j = 0.0f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final com.larus.kmp.voice_setting.voice.mix.x0 f354264k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final com.larus.kmp.voice_setting.voice.mix.x0 f354265l = null;

    static {
        f354254a = Dp.m7544constructorimpl(44);
        float r100 = 16;
        f354255b = Dp.m7544constructorimpl(r100);
        float r101 = 10;
        f354256c = Dp.m7544constructorimpl(r101);
        f354257d = TextUnitKt.getSp(24);
        float r102 = Dp.m7544constructorimpl(52);
        float r103 = 8;
        float r104 = Dp.m7544constructorimpl(r103);
        f354258e = r104;
        f354259f = Dp.m7544constructorimpl(r102 + r104);
        float r105 = 56;
        f354260g = Dp.m7544constructorimpl(Dp.m7544constructorimpl(r105) + r104);
        f354261h = Dp.m7544constructorimpl(r105);
        f354262i = Dp.m7544constructorimpl(r103);
        f354263j = Dp.m7544constructorimpl(r100);
        float r106 = Dp.m7544constructorimpl(6);
        float r110 = 0;
        float r107 = Dp.m7544constructorimpl(r110);
        float r108 = Dp.m7544constructorimpl(r103);
        float r111 = 36;
        float r109 = Dp.m7544constructorimpl(r111);
        float r112 = Dp.m7544constructorimpl(r100);
        float r113 = Dp.m7544constructorimpl(r101);
        float r114 = 24;
        f354264k = new com.larus.kmp.voice_setting.voice.mix.x0(r107, r108, r109, r106, r112, r113, Dp.m7544constructorimpl(r114), Dp.m7544constructorimpl(r114), 64);
        float r115 = 20;
        f354265l = new com.larus.kmp.voice_setting.voice.mix.x0(Dp.m7544constructorimpl(r110), Dp.m7544constructorimpl(r103), Dp.m7544constructorimpl(r111), r106, Dp.m7544constructorimpl(r100), Dp.m7544constructorimpl(12), Dp.m7544constructorimpl(r115), Dp.m7544constructorimpl(r115), 64);
    }

    public static final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        FlowRuntime.b().e().d("VoiceDoubleTabUi", r100);     // Catch: Throwable -> L5
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r102 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public static final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        FlowRuntime.b().e().i("VoiceDoubleTabUi", r100);     // Catch: Throwable -> L5
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r102 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }
}
