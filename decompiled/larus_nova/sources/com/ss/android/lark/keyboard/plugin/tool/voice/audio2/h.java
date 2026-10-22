package com.ss.android.lark.keyboard.plugin.tool.voice.audio2;

import android.app.Activity;
import android.view.MotionEvent;
import android.widget.EditText;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.larus.nova.R;
import com.ss.android.lark.audio.voiceinput.AudioPluginFeature;
import com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceModule;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.AbsAudioPopupView;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.AbsAudioPopupViewWithEditText;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.AudioPluginEnums$DisplayMode;
import com.ss.android.lark.log.Log;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f429940a = 0;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f429941a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f429942b = null;

        static {
            int[] r100 = new int[AudioPluginEnums$DisplayMode.values().length];
            r100[AudioPluginEnums$DisplayMode.COMPLETE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[AudioPluginEnums$DisplayMode.SIMPLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L6:
            f429941a = r100;
            int[] r101 = new int[AudioPluginFeature.values().length];
            r101[AudioPluginFeature.WITH_TEXT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L25:
            r101[AudioPluginFeature.RECOGNIZE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L21:
            r101[AudioPluginFeature.RECORD.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L10:
            f429942b = r101;
        }
    }

    static {
    }

    public h() {
        throw null;
    }

    public final boolean g() {
        Object r100 = null;
        if ((r100 instanceof AbsAudioPopupViewWithEditText) == false) goto L7;
        AbsAudioPopupViewWithEditText r101 = (AbsAudioPopupViewWithEditText) null;
        return false;
    L7:
        return false;
    }

    public final void j(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
    }

    public final String f() {
        Intrinsics.throwUninitializedPropertyAccessException("mAudioMessageDelegate");
        throw null;
    }

    public final boolean h() {
        Intrinsics.throwUninitializedPropertyAccessException("mAudioRecorderDelegate");
        throw null;
    }

    public final void i() {
        Log.i("AudioPluginController", LiveCommonConstants.REASON_ON_DEDTROY);
        if (h() == false) goto L5;
        throw null;
    L5:
        e(null);
        throw null;
    }

    public final boolean n() {
        if (h() == false) goto L6;
        Log.e("AudioPluginController", "startRecord / Is recording now");
    L6:
        throw null;
    }

    public final EditText b() {
        throw null;
    }

    public final Activity c() {
        throw null;
    }

    public final com.ss.android.lark.keyboard.ime.a d() {
        throw null;
    }

    public static void k(final h r100) {
        r100.getClass();
        final boolean r101 = false;
        final long r102 = 0;
        new AudioPluginController$showCursor$runnable$1(r100, r101, r102).invoke();
    }

    public final int a(AudioPluginFeature r100) {
        r100.getClass();
        int r101 = b.f429942b[r100.ordinal()];
        if (r101 != 1) goto L5;
        int r102 = com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.f430003a;
        if (KeyboardVoiceModule.a().isZh() == false) goto L15;
        return R.drawable.ud_icon_voice2text_cn_outlined;
    L15:
        return R.drawable.ud_icon_voice2text_en_outlined;
    L5:
        if (r101 != 2) goto L7;
        return R.drawable.ud_icon_voice2text_outlined;
    L7:
        if (r101 != 3) goto L10;
        return R.drawable.ud_icon_mic_outlined;
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public final com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.b e(AbsAudioPopupView r100) {
        throw null;
    }

    public final void l(int r100) {
        throw null;
    }

    public final void m(String r100) {
        throw null;
    }

    public final void p(boolean r100, boolean r101) {
        throw null;
    }

    public static void o(h r100, AudioPluginEnums$DisplayMode r101, MotionEvent r102, int r103, int r104, int r105) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "mode");
        Intrinsics.checkNotNullParameter(r102, "event");
        Log.i("AudioPluginController", "startRecordByLongPressed / displayMode: " + r101);
        r100.getClass();
        int r106 = b.f429941a[r101.ordinal()];
        if (r106 != 1) goto L5;
        throw null;
    L5:
        if (r106 != 2) goto L8;
        throw null;
    L8:
        throw new NoWhenBranchMatchedException();
    }
}
