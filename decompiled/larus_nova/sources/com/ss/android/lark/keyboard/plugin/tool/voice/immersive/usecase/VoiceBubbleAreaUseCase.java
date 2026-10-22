package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase;

import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioAsrLanguageSwitcher;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.SpannableStringUtils;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation.VoiceBubbleMotionScene;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.ImmersiveVoiceViewModel;
import com.ss.android.lark.log.Log;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class VoiceBubbleAreaUseCase {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final /* synthetic */ int f430443y = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f430444a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Fragment f430445b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final VoiceImeWrapperUseCase f430446c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation.a f430447d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f430448e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f430449f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ConstraintSet f430450g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ConstraintSet f430451h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f430452i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f430453j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f430454k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f430455l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f430456m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f430457n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f430458o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f430459p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f430460q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f430461r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f430462s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f430463t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public SpannableStringUtils.a f430464u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final AudioAsrLanguageSwitcher f430465v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final VoiceBubbleMotionScene f430466w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Lazy f430467x;

    public static final class a {
    }

    static {
    }

    public final ImmersiveVoiceViewModel f() {
        return (ImmersiveVoiceViewModel) this.f430467x.getValue();
    }

    public final int h() {
        return ((Number) this.f430462s.getValue()).intValue();
    }

    public static final int a(VoiceBubbleAreaUseCase r100) {
        return ((Number) r100.f430461r.getValue()).intValue();
    }

    public static final int b(VoiceBubbleAreaUseCase r100) {
        return ((Number) r100.f430460q.getValue()).intValue();
    }

    public static final int c(VoiceBubbleAreaUseCase r100) {
        return ((Number) r100.f430457n.getValue()).intValue();
    }

    public static final int d(VoiceBubbleAreaUseCase r100) {
        return ((Number) r100.f430452i.getValue()).intValue();
    }

    public final Pair<Integer, Integer> g(int r100) {
        Pair<Integer, Integer> r101 = f().getBeforeInsetSelection().getValue();
        if (r101 != null) goto L6;
        r101 = new Pair(0, 0);
    L6:
        if (r101.getFirst().intValue() >= 0) goto L8;
    L13:
        Log.w(this.f430448e, "invalid beforeInsetSelection:" + r101 + ", editableLength:" + r100);
        return null;
    L8:
        if (r101.getSecond().intValue() < r101.getFirst().intValue()) goto L13;
        if (r101.getSecond().intValue() > r100) goto L13;
        return r101;
    }

    public final void i(long r100) {
        if (Build.VERSION.SDK_INT < 26) goto L5;
        VibrationEffect r101 = VibrationEffect.createOneShot(r100, -1);
        Object r102 = this.f430444a.getContext().getSystemService("vibrator");
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.os.Vibrator");
        ((Vibrator) r102).vibrate(r101);
        return;
    L5:
        Object r103 = this.f430444a.getContext().getSystemService("vibrator");
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.os.Vibrator");
        ((Vibrator) r103).vibrate(r100);
    }

    public static final void e(VoiceBubbleAreaUseCase r100, List r101, List r102) {
        r100.getClass();
        Iterator r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        int r104 = ((Number) r103.next()).intValue();
        r100.f430444a.findViewById(r104).setVisibility(0);
        goto L4
    L6:
        Iterator r105 = r102.iterator();
    L8:
        if (r105.hasNext() == false) goto L10;
        int r106 = ((Number) r105.next()).intValue();
        r100.f430444a.findViewById(r106).setVisibility(8);
        goto L8
    }

    public VoiceBubbleAreaUseCase(ConstraintLayout r100, Fragment r101, VoiceImeWrapperUseCase r102, com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation.a r103) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r102, "imeWrapperUseCase");
        Intrinsics.checkNotNullParameter(r103, "viewFinder");
        this.f430444a = r100;
        this.f430445b = r101;
        this.f430446c = r102;
        this.f430447d = r103;
        this.f430448e = "VoiceBubbleAreaUseCase";
        this.f430449f = LazyKt.lazy(new VoiceBubbleAreaUseCase$loadingAnimation$2(this));
        ConstraintSet r104 = new ConstraintSet();
        r104.clone(r100);
        this.f430450g = r104;
        ConstraintSet r105 = new ConstraintSet();
        r105.clone(r103.o());
        this.f430451h = r105;
        this.f430452i = LazyKt.lazy(new VoiceBubbleAreaUseCase$waveBarWidthInRecording$2(this));
        this.f430453j = UIUtils.dp2px(r100.getContext(), 8.0f);
        this.f430454k = UIUtils.dp2px(r100.getContext(), 10.0f);
        this.f430455l = UIUtils.dp2px(r100.getContext(), 12.0f);
        this.f430456m = UIUtils.dp2px(r100.getContext(), 20.0f);
        this.f430457n = LazyKt.lazy(new VoiceBubbleAreaUseCase$waveBarWidthInRecognizing$2(this));
        this.f430458o = LazyKt.lazy(new VoiceBubbleAreaUseCase$waveBarWidthInCanceling$2(this));
        this.f430459p = LazyKt.lazy(new VoiceBubbleAreaUseCase$bubbleWidthInPreparing$2(this));
        this.f430460q = LazyKt.lazy(new VoiceBubbleAreaUseCase$bubbleWidthInRecording$2(this));
        this.f430461r = LazyKt.lazy(new VoiceBubbleAreaUseCase$bubbleWidthInCanceling$2(this));
        this.f430462s = LazyKt.lazy(VoiceBubbleAreaUseCase$waveBarColor$2.INSTANCE);
        this.f430463t = LazyKt.lazy(VoiceBubbleAreaUseCase$waveBarColorInCancel$2.INSTANCE);
        this.f430465v = new AudioAsrLanguageSwitcher(r100.getContext());
        this.f430466w = new VoiceBubbleMotionScene(r100, r103.o(), r103);
        this.f430467x = LazyKt.lazy(new VoiceBubbleAreaUseCase$immersiveVoiceViewModel$2(this));
    }
}
