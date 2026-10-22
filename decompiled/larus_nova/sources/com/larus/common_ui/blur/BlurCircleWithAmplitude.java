package com.larus.common_ui.blur;

import android.animation.Animator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import com.larus.common_ui.widget.input.audiowave.amplitude.AudioAmplitudeProcessor;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u0000 )2\u00020\u00012\u00020\u0002:\u0001)B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ(\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0014H\u0014J\u0016\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001aH\u0096@¢\u0006\u0002\u0010\u001bJ\b\u0010\u001c\u001a\u00020\u0012H\u0016J\b\u0010\u001d\u001a\u00020\u0012H\u0016J\b\u0010\u001e\u001a\u00020\u0012H\u0014J\b\u0010\u001f\u001a\u00020\u000eH\u0016J\u0010\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\"H\u0016J\u0012\u0010#\u001a\u00020\u00122\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u000e\u0010&\u001a\u00020\u00122\u0006\u0010'\u001a\u00020(R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/larus/common_ui/blur/BlurCircleWithAmplitude;", "Lcom/larus/common_ui/blur/BlurView;", "Lcom/larus/common_ui/widget/input/audiowave/IAudioWaveView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "amplitudeProcessor", "Lcom/larus/common_ui/widget/input/audiowave/amplitude/AudioAmplitudeProcessor;", "animHelper", "Lcom/larus/common_ui/blur/BlurCircleAnimHelper;", "autoStartAnim", "", "hasAutoStarted", "pendingStartAnim", "onSizeChanged", "", "w", "", "h", "oldw", "oldh", "updateAudioData", "audioData", "", "([BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startWaveAnim", "stopWaveAnim", "onDetachedFromWindow", "isAnimating", "setWaveTintList", "tint", "Landroid/content/res/ColorStateList;", "setWaveTintMode", "mode", "Landroid/graphics/PorterDuff$Mode;", "updateVolumeData", ITTVideoEngineEventSource.KEY_VOLUME, "", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BlurCircleWithAmplitude extends BlurView {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final AudioAmplitudeProcessor f326862l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final com.larus.common_ui.blur.a f326863m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f326864n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f326865o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f326866p;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.larus.common_ui.blur.BlurCircleWithAmplitude$onSizeChanged$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes27.dex */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass1 extends AdaptedFunctionReference implements Function0<Float> {
        public AnonymousClass1(Object r100) {
            super(0, r100, AudioAmplitudeProcessor.class, "getMaxAmplitude", "getMaxAmplitude(Z)F", 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Float invoke() {
            return Float.valueOf(AudioAmplitudeProcessor.a((AudioAmplitudeProcessor) this.receiver));
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Float invoke() {
            return invoke();
        }
    }

    static {
    }

    public final void f() {
        this.f326866p = false;
        com.larus.common_ui.blur.a r100 = this.f326863m;
        r100.f326879b = 1;
        Animator r101 = r100.f326880c;
        if (r101 == null) goto L5;
        r101.removeAllListeners();
        r101.cancel();
    L5:
        r100.f326880c = null;
    }

    public void setWaveTintList(ColorStateList r100) {
        Intrinsics.checkNotNullParameter(r100, "tint");
    }

    public void setWaveTintMode(PorterDuff.Mode r100) {
    }

    public final boolean d() {
        if (this.f326863m.f326879b != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        return true;
    L8:
        if (this.f326866p == true) goto L13;
        return false;
    L13:
        return true;
    L5:
        r100 = false;
        goto L6
    }

    public final void e() {
        if (d() == true) goto L17;
        if (this.f326866p == true) goto L17;
        if (getWidth() != 0) goto L10;
    L14:
        this.f326866p = true;
        return;
    L10:
        if (getHeight() == 0) goto L14;
        this.f326863m.a(new BlurCircleWithAmplitude$startWaveAnim$1(this.f326862l));
        return;
    L17:
        if (isInEditMode() == true) goto L20;
        FLogger.f375446a.v("BlurCircleWithAmplitude", "[startWaveAnim][ALREADY_START]");
        return;
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        f();
    }

    public BlurCircleWithAmplitude(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public BlurCircleWithAmplitude(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, 4, 0);
        this.f326862l = new AudioAmplitudeProcessor(30, 2);
        this.f326863m = new com.larus.common_ui.blur.a(this);
        this.f326864n = true;
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.larus_circle_autoStartAnim});
        this.f326864n = r102.getBoolean(0, true);
        r102.recycle();
    }

    @Override // com.larus.common_ui.blur.BlurView, android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        boolean r104 = d();
        if (r104 == false) goto L5;
        f();
    L5:
        super.onSizeChanged(r100, r101, r102, r103);
        if (r104 == false) goto L8;
    L13:
        this.f326865o = true;
        this.f326866p = false;
        this.f326863m.a(new AnonymousClass1(this.f326862l));
        return;
    L8:
        if (this.f326864n == false) goto L12;
        if (this.f326865o == false) goto L13;
    L12:
        if (this.f326866p == true) goto L13;
    }
}
