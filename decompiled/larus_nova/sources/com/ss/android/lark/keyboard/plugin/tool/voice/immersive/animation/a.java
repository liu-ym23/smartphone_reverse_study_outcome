package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import com.ss.android.lark.keyboard.edittext2.KeyboardFunctionEditText;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.ImmersiveVoiceView;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.widget.CircleIconWithTitle;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.widget.VoiceCircleButton;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.widget.VoiceOvalBackground;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.widget.VoiceWaveBar;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a {
    public final Lazy A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f430224a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewGroup f430225b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Fragment f430226c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f430227d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f430228e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f430229f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f430230g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f430231h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f430232i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f430233j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f430234k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f430235l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f430236m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f430237n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f430238o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f430239p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f430240q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f430241r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f430242s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f430243t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f430244u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f430245v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Lazy f430246w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Lazy f430247x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Lazy f430248y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Lazy f430249z;

    public final KeyboardFunctionEditText a() {
        return (KeyboardFunctionEditText) this.f430229f.getValue();
    }

    public final AppCompatImageView b() {
        return (AppCompatImageView) this.f430231h.getValue();
    }

    public final CircleIconWithTitle c() {
        return (CircleIconWithTitle) this.f430245v.getValue();
    }

    public final VoiceCircleButton d() {
        return (VoiceCircleButton) this.f430239p.getValue();
    }

    public final CircleIconWithTitle e() {
        return (CircleIconWithTitle) this.f430244u.getValue();
    }

    public final FrameLayout f() {
        return (FrameLayout) this.f430248y.getValue();
    }

    public final CircleIconWithTitle g() {
        return (CircleIconWithTitle) this.f430243t.getValue();
    }

    public final AppCompatImageView h() {
        return (AppCompatImageView) this.f430236m.getValue();
    }

    public final AppCompatTextView i() {
        return (AppCompatTextView) this.f430233j.getValue();
    }

    public final CircleIconWithTitle j() {
        return (CircleIconWithTitle) this.f430241r.getValue();
    }

    public final AppCompatTextView k() {
        return (AppCompatTextView) this.f430242s.getValue();
    }

    public final AppCompatTextView l() {
        return (AppCompatTextView) this.f430234k.getValue();
    }

    public final AppCompatImageView m() {
        return (AppCompatImageView) this.f430232i.getValue();
    }

    public final AppCompatTextView n() {
        return (AppCompatTextView) this.f430247x.getValue();
    }

    public final ConstraintLayout o() {
        return (ConstraintLayout) this.f430230g.getValue();
    }

    public final VoiceOvalBackground p() {
        return (VoiceOvalBackground) this.f430238o.getValue();
    }

    public final VoiceCircleButton q() {
        return (VoiceCircleButton) this.f430240q.getValue();
    }

    public final AppCompatTextView r() {
        return (AppCompatTextView) this.f430228e.getValue();
    }

    public final VoiceWaveBar s() {
        return (VoiceWaveBar) this.f430227d.getValue();
    }

    public a(ImmersiveVoiceView r100, ViewGroup r101, Fragment r102) {
        Intrinsics.checkNotNullParameter(r100, "rootContainer");
        Intrinsics.checkNotNullParameter(r101, "decorViewGroup");
        this.f430224a = r100;
        this.f430225b = r101;
        this.f430226c = r102;
        this.f430227d = LazyKt.lazy(new ImmersiveViewFinder$voiceWaveBar$2(this));
        this.f430228e = LazyKt.lazy(new ImmersiveViewFinder$voiceRecordElapseHint$2(this));
        this.f430229f = LazyKt.lazy(new ImmersiveViewFinder$asrResultEditText$2(this));
        this.f430230g = LazyKt.lazy(new ImmersiveViewFinder$voiceBubbleContainer$2(this));
        this.f430231h = LazyKt.lazy(new ImmersiveViewFinder$bubbleTriangle$2(this));
        this.f430232i = LazyKt.lazy(new ImmersiveViewFinder$switchLanguage$2(this));
        this.f430233j = LazyKt.lazy(new ImmersiveViewFinder$retryRecognitionText$2(this));
        this.f430234k = LazyKt.lazy(new ImmersiveViewFinder$showOriginalText$2(this));
        this.f430235l = LazyKt.lazy(new ImmersiveViewFinder$tipsAsrResultEditable$2(this));
        this.f430236m = LazyKt.lazy(new ImmersiveViewFinder$recordPreparing$2(this));
        this.f430237n = LazyKt.lazy(new ImmersiveViewFinder$tipsWeakNet$2(this));
        this.f430238o = LazyKt.lazy(new ImmersiveViewFinder$voiceOvalBackground$2(this));
        this.f430239p = LazyKt.lazy(new ImmersiveViewFinder$cancelRecording$2(this));
        this.f430240q = LazyKt.lazy(new ImmersiveViewFinder$voiceRecognizing$2(this));
        this.f430241r = LazyKt.lazy(new ImmersiveViewFinder$sendAllResult$2(this));
        this.f430242s = LazyKt.lazy(new ImmersiveViewFinder$sendAllResultContinueTip$2(this));
        this.f430243t = LazyKt.lazy(new ImmersiveViewFinder$onlySendAudio$2(this));
        this.f430244u = LazyKt.lazy(new ImmersiveViewFinder$holdToSpeakBtn$2(this));
        this.f430245v = LazyKt.lazy(new ImmersiveViewFinder$cancelAsrResult$2(this));
        this.f430246w = LazyKt.lazy(new ImmersiveViewFinder$bubbleTriangleAnchor$2(this));
        this.f430247x = LazyKt.lazy(new ImmersiveViewFinder$tipsRecordPreparing$2(this));
        this.f430248y = LazyKt.lazy(new ImmersiveViewFinder$imeWrapperContainer$2(this));
        this.f430249z = LazyKt.lazy(new ImmersiveViewFinder$holdToSpeakBarLayout$2(this));
        this.A = LazyKt.lazy(new ImmersiveViewFinder$holdToSpeakBarBkg$2(this));
    }
}
