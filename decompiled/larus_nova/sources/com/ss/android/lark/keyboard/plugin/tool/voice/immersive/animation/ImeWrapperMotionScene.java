package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.transition.Transition;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.audio.voiceinput.VoiceInputScene;
import com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceFGUtils;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class ImeWrapperMotionScene {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f430184a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f430185b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f430186c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f430187d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f430188e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f430189f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f430190g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f430191h;

    public ImeWrapperMotionScene(ConstraintLayout r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        this.f430184a = r100;
        this.f430185b = UIUtils.dp2px(r100.getContext(), 160.0f);
        this.f430186c = UIUtils.dp2px(r100.getContext(), 16.0f);
        this.f430187d = UIUtils.dp2px(r100.getContext(), 27.0f);
        this.f430188e = UIUtils.dp2px(r100.getContext(), 35.0f);
        this.f430189f = UIUtils.dp2px(r100.getContext(), 40.0f);
        this.f430190g = UIUtils.dp2px(r100.getContext(), 75.0f);
        this.f430191h = 120;
    }

    public final void b(final boolean r100, Function1<? super Transition, Unit> r101) {
        c r102 = new c(this.f430184a);
        c.a(r102, this.f430184a, new ImeWrapperMotionScene$whenImeWrapperChange$1$1(r100, this));
        r102.b(ImeWrapperMotionScene$whenImeWrapperChange$1$2.INSTANCE);
        c.c(r102, r101, null, 0, null, 14);
    }

    public static final b a(ImeWrapperMotionScene r100, int r101, String r102, boolean r103, boolean r104) {
        r100.getClass();
        b r105 = new b(r101, r102);
        r105.e();
        if (r101 != R.id.hold_to_speak_btn) goto L6;
        r105.v(R.id.send_asr_audio);
        r105.n(R.id.send_asr_audio);
        r105.y(R.id.send_asr_audio);
        r105.b(R.id.send_asr_audio);
    L9:
        r105.r(!r103);
        return r105;
    L6:
        if (r104 == false) goto L8;
        r105.u(R.id.send_asr_all_result);
        r105.n(0);
        r105.c(R.id.ime_wrapper_container);
        r105.a(r100.f430186c);
        r105.t(r100.f430187d);
        r105.f430252c.put(12, 0);
        goto L9
    L8:
        r105.u(R.id.cancel_asr_result);
        r105.n(0);
        r105.y(R.id.cancel_asr_result);
        r105.b(R.id.cancel_asr_result);
        r105.t(r100.f430190g);
        r105.a(0);
        goto L9
    }

    public static void d(ImeWrapperMotionScene r100, boolean r101, Long r102, VoiceInputScene r110, int r111) {
        if ((r111 & 2) == 0) goto L5;
        boolean r103 = false;
    L7:
        if ((r111 & 4) == 0) goto L9;
        r102 = null;
    L9:
        Long r104 = r102;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r110, "scene");
        KeyboardVoiceFGUtils r105 = KeyboardVoiceFGUtils.f429815a;
        if (KeyboardVoiceFGUtils.b() == false) goto L12;
        r100.c(false, null, r103, r104, r110, false);
        return;
    L12:
        r100.b(false, null);
        return;
    L5:
        r103 = r101;
        goto L7
    }

    public final void c(final boolean r110, Function1<? super Transition, Unit> r111, final boolean r112, final Long r113, final VoiceInputScene r114, final boolean r210) {
        c r100 = new c(this.f430184a);
        c.a(r100, this.f430184a, new ImeWrapperMotionScene$whenImeWrapperChangeNew$1$1(this, r114, r110, r210, r112));
        r100.b(new ImeWrapperMotionScene$whenImeWrapperChangeNew$1$2(r113, this));
        c.c(r100, r111, null, 0, null, 14);
    }
}
