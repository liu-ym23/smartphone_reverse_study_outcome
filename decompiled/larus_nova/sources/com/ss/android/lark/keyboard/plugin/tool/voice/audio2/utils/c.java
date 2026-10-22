package com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.bytedance.supervisor.token.Token;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.biz.im.api.param.IMConstants$NetworkLevel;
import com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceModule;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.widget.AudioLottieTrashButton;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.h;
import com.ss.android.lark.utils.l;
import com.ss.android.lark.utils.n;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.suite.lark.platform.component.widget_biz_permissionpurposewindow.PermissionPurposeWindowPermissionResult;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;

/* JADX INFO: loaded from: classes36.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f430003a = 0;

    public static final class a extends PermissionPurposeWindowPermissionResult {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1<Boolean, Unit> f430004b;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function1<? super Boolean, Unit> r100) {
            this.f430004b = r100;
        }

        @Override // com.suite.lark.platform.component.widget_biz_permissionpurposewindow.PermissionPurposeWindowPermissionResult, com.ss.android.lark.utils.h.e
        public final void a(boolean r100) {
            Log.i("AudioPluginUtils", "requestAudioPermission / Audio permission status = " + r100);
            this.f430004b.invoke(Boolean.valueOf(r100));
        }
    }

    static {
    }

    public c() {
    }

    public static int e() {
        return com.ss.android.lark.im.base.a.a().getInt("user_audio_send_tab", AudioPluginConstants.f429985a);
    }

    public static boolean h() {
        if (KeyboardVoiceModule.a().getCurNetWorkLevel() != IMConstants$NetworkLevel.NET_UNAVAILABLE) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean g(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (ContextCompat.checkSelfPermission(r100, "android.permission.RECORD_AUDIO") != 0) goto L5;
        boolean r101 = true;
    L6:
        Log.i("AudioPluginUtils", "hasAudioPermission / " + r101);
        return r101;
    L5:
        r101 = false;
        goto L6
    }

    public static void a(View r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 == false) goto L5;
        int r102 = 0;
    L6:
        r100.setVisibility(r102);
        return;
    L5:
        r102 = 4;
        goto L6
    }

    public static void b(boolean r100, View... r101) {
        Intrinsics.checkNotNullParameter(r101, "views");
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        a(r101[r103], r100);
        r103 = r103 + 1;
        goto L3
    }

    public static int c(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return UIUtils.getColor(r100.getContext(), r101);
    }

    public static Drawable d(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return UIUtils.getDrawable(r100.getContext(), r101);
    }

    public static String f(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return UIUtils.getString(r100.getContext(), r101);
    }

    public static void j(Activity r110, Function1 r111) {
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter(r111, "callback");
        Token r100 = new Token("LARK-PSDA-android_audio_input_request_permission");
        a r101 = new a(r111);
        int r112 = n.f444741a;
        h.c(r110, r100, r101, "android.permission.RECORD_AUDIO", new l(R.string.Lark_Core_MicrophoneAccess_Title, R.string.Lark_Core_EnableMicrophoneAccess_RecordAudioDuringVideoRecording, R.string.Lark_Core_MicrophoneAccess_Title, R.string.Lark_Core_EnableMicrophoneAccess_RecordAudioDuringVideoRecording, null, null, 240), false, 0, 0);
    }

    public static Pair l(CharSequence r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "charSequence");
        SpannableStringBuilder r102 = (SpannableStringBuilder) r100;
        int r103 = r102.length();
        if (r101 <= 0) goto L9;
        if (r101 < r103) goto L8;
        return new Pair(r100, "");
    L8:
        return new Pair(r102.subSequence(0, r101), r102.subSequence(r101, r103));
    L9:
        return new Pair("", r102.subSequence(r101, r103));
    }

    public static int m(View r100, Number r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "dp");
        return UIUtils.dp2px(r100.getContext(), r101.floatValue());
    }

    public static float n(View r100, Number r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "dp");
        return UIUtils.dp2px(r100.getContext(), r101.floatValue());
    }

    public static void p(View r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "doUpdate");
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r103 = (ConstraintLayout.LayoutParams) r102;
        r101.invoke(r103);
        r100.setLayoutParams(r103);
    }

    public static void k(EditText r100, CharSequence r101, Integer r102) {
        Intrinsics.checkNotNullParameter(r100, "editText");
        if (r101 != null) goto L5;
        int r103 = 0;
    L25:
        r100.setText(r101);     // Catch: Exception -> L22
        r100.setSelection(r103);     // Catch: Exception -> L22
        return;
    L22:
        e = move-exception;
        Log.e("AudioPluginUtils", e.toString());
        return;
    L5:
        if (r102 != null) goto L7;
    L15:
        r103 = r100.getSelectionEnd();
        if (r103 >= 0) goto L18;
    L19:
        r103 = r101.length();
        goto L25
    L18:
        if (r103 <= r101.length()) goto L25;
    L7:
        if (r102.intValue() > r101.length()) goto L15;
        if (r102.intValue() < (-1)) goto L15;
        if (r102.intValue() != (-1)) goto L14;
        r103 = r101.length();
        goto L25
    L14:
        r103 = r102.intValue();
        goto L25
    }

    public static float o(Number r100, Number r101, Number r102) {
        Intrinsics.checkNotNullParameter(r100, "x");
        Intrinsics.checkNotNullParameter(r101, "maxValue");
        Intrinsics.checkNotNullParameter(r102, "minValue");
        float r103 = (float) (r101.doubleValue() / (Math.exp(-((r100.doubleValue() - ((double) 150)) / ((double) 60))) + 1.0d));
        float r104 = r102.floatValue();
        float r105 = r101.floatValue();
        float r106 = r105 / 5;
        if ((r103 / r105) < 0.9f) goto L6;
        r103 = r103 - (r106 * Random.Default.nextFloat());
    L6:
        return Math.max(r104, r103);
    }

    public static void i(AudioLottieTrashButton r100, int r101, int r102, float r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.setSpeed(r103);
        r100.setMinAndMaxFrame(r101, r102);
        r100.playAnimation();
    }
}
