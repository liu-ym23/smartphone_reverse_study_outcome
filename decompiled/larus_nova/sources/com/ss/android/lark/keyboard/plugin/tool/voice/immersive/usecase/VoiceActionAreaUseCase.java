package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.nova.R;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.audio.voiceinput.VoiceInputScene;
import com.ss.android.lark.compose.foundation.toast.FlowToast;
import com.ss.android.lark.keyboard.edittext2.span.ClickLinkMovementMethod;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.ImmersiveVoiceInputComponent;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.VoiceTextSetting;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.ImmersiveVoiceViewModel;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.widget.CircleIconWithTitle;
import com.ss.android.lark.utils.ContextsKt;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class VoiceActionAreaUseCase {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f430427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation.a f430428b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f430429c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f430430d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f430431e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f430432f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f430433g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f430434h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ImmersiveVoiceInputComponent.b f430435i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f430436j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f430437k;

    public static final class a {
    }

    static {
    }

    public final ImmersiveVoiceViewModel e() {
        return (ImmersiveVoiceViewModel) this.f430430d.getValue();
    }

    public final void f() {
        com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation.a r100 = this.f430428b;
        r100.j().setVisibility(4);
        r100.k().setVisibility(4);
        r100.g().setVisibility(4);
        r100.c().setVisibility(4);
    }

    public final boolean g() {
        VoiceInputScene r100 = e().getImmersiveVoiceMode().f409283b;
        if (r100 != VoiceInputScene.EnterpriseAnswer) goto L5;
    L10:
        boolean r101 = true;
    L12:
        return !r101;
    L5:
        if (r100 == VoiceInputScene.UniverseSearch) goto L10;
        if (r100 == VoiceInputScene.CcmComment) goto L10;
        r101 = false;
        goto L12
    }

    public static final void a(VoiceActionAreaUseCase r100) {
        com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation.a r101 = r100.f430428b;
        CircleIconWithTitle r102 = r101.g();
        if (r100.g() == false) goto L5;
        int r103 = 0;
    L6:
        r102.setVisibility(r103);
        r101.a().setEnabled(true);
        r101.n().setVisibility(4);
        r101.k().setVisibility(4);
        r101.p().setVisibility(4);
        r101.c().setVisibility(0);
        r101.j().setVisibility(0);
        r101.e().setVisibility(4);
        CircleIconWithTitle.S5(r101.j());
        r101.j().animate().scaleX(1.0f).scaleY(1.0f).setDuration(r100.f430437k).start();
        r100.e().stopVoiceRecord();
        r100.e().whenReleaseOrCancelTouch();
        r100.f430434h = false;
        return;
    L5:
        r103 = 8;
        goto L6
    }

    public static final void c(VoiceActionAreaUseCase r100) {
        com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation.a r101 = r100.f430428b;
        ((View) r101.A.getValue()).animate().scaleX(0.9f).setDuration(150).withEndAction(new j(r101, r100)).start();
    }

    public final void h(boolean r100) {
        if (r100 == false) goto L5;
        int r101 = 0;
    L6:
        com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation.a r102 = this.f430428b;
        r102.c().setVisibility(r101);
        CircleIconWithTitle r103 = r102.g();
        if (g() == false) goto L9;
        int r104 = r101;
    L10:
        r103.setVisibility(r104);
        r102.j().setVisibility(r101);
        if (e().isVoiceSecondInputV2() == false) goto L18;
        Boolean r105 = e().isPanelShowing().getValue();
        Boolean r106 = Boolean.TRUE;
        if (Intrinsics.areEqual(r105, r106) == true) goto L18;
        if (Intrinsics.areEqual(e().isKeyboardShowing().getValue(), r106) == true) goto L18;
        r102.k().setVisibility(r101);
        return;
    L18:
        r102.k().setVisibility(4);
        return;
    L9:
        r104 = 8;
        goto L10
    L5:
        r101 = 4;
        goto L6
    }

    public static final void b(VoiceActionAreaUseCase r100, int r101) {
        Context r102 = r100.f430427a.getContext();
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        FlowToast.a r103 = FlowToast.a(r102);
        r103.e(r101);
        r103.d(UDToast.access$createTintedIcon(UDToast.INSTANCE, r102, R.drawable.ud_icon_warning_outlined));
        r103.c(17, 0, 0);
        r103.a().show();
    }

    public static final void d(VoiceActionAreaUseCase r100, boolean r101) {
        r100.f430428b.j().T5(r101);
        if (r100.e().isVoiceSecondInputV2() == false) goto L10;
        if (r101 == true) goto L6;
    L8:
        r100.f430428b.k().setVisibility(4);
        return;
    L6:
        if (Intrinsics.areEqual(r100.e().isKeyboardShowing().getValue(), Boolean.TRUE) == true) goto L8;
        r100.f430428b.k().setVisibility(0);
        return;
    }

    public VoiceActionAreaUseCase(ConstraintLayout r100, Fragment r101, com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation.a r110) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r110, "viewFinder");
        this.f430427a = r100;
        this.f430428b = r110;
        Context r102 = r100.getContext();
        this.f430429c = r102;
        this.f430430d = LazyKt.lazy(new VoiceActionAreaUseCase$immersiveVoiceViewModel$2(this));
        ConstraintSet r103 = new ConstraintSet();
        r103.clone(r100);
        if (e().getImmersiveVoiceMode().c() == false) goto L5;
    L8:
        r103.clear(R.id.tips_record_preparing, 6);
        r103.clear(R.id.tips_record_preparing, 7);
        r103.connect(R.id.tips_record_preparing, 6, 0, 6);
        r103.connect(R.id.tips_record_preparing, 7, 0, 7);
        r103.setMargin(R.id.tips_record_preparing, 6, y9c.d.b(r102, 16.0f));
        r103.setMargin(R.id.tips_record_preparing, 7, y9c.d.b(r102, 16.0f));
    L9:
        r103.applyTo(r100);
        r110.d().setOnClickListener(new com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase.a(this));
        r110.c().setOnClickListener(new b(this, r110));
        r110.g().setOnClickListener(new c(this, r110));
        VoiceTextSetting r104 = (VoiceTextSetting) SettingManager.getInstance().get(VoiceTextSetting.class);
        r110.e().setText(r104.voicePageSecondVoiceButtonText);
        r110.k().setText(r104.voicePageSecondVoiceSendAllBtnText);
        if (e().isVoiceSecondInputV2() == false) goto L12;
        r110.j().setOnTouchListener(new VoiceActionAreaUseCase$buildSendAllResultLongPressTouchListener$1(this));
    L12:
        r110.e().setOnTouchListener(new d(this));
        r110.j().setOnClickListener(new e(r110, this));
        r110.a().addTextChangedListener(new i(this, r110));
        r110.a().setMovementMethod(new ClickLinkMovementMethod(r110.a()));
        LifecycleOwner r105 = r101;
        if (r101 != null) goto L16;
        ComponentCallbacks2 r106 = ContextsKt.findActivity(r102);
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        r105 = (LifecycleOwner) r106;
    L16:
        ImmersiveVoiceViewModel r107 = e();
        r107.getVoiceRecordTooShort().observe(r105, new f(this));
        r107.getImmersiveVoiceState().observe(r105, new g(r107, this));
        r107.getAsrSessionState().observe(r105, new h(this, r107, r105));
        this.f430436j = 300;
        this.f430437k = 180;
        return;
    L5:
        if (e().getImmersiveVoiceMode().b() == true) goto L8;
        r103.clear(R.id.tips_record_preparing, 6);
        r103.clear(R.id.tips_record_preparing, 7);
        r103.connect(R.id.tips_record_preparing, 6, R.id.cancel_recording, 7);
        r103.connect(R.id.tips_record_preparing, 7, R.id.recognizing, 6);
        r103.setMargin(R.id.tips_record_preparing, 6, 0);
        r103.setMargin(R.id.tips_record_preparing, 7, 0);
        goto L9
    }
}
