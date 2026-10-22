package com.larus.common_ui;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.LinearLayout;
import androidx.camera.video.AudioStats;
import androidx.cardview.widget.CardView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import v19.i5;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0005\u0018\u0000 (2\u00020\u0001:\u0001(B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\b\u0010\u0017\u001a\u00020\u0018H\u0014J\u0006\u0010\u0019\u001a\u00020\u0018J\u0006\u0010\u001a\u001a\u00020\u0018J\b\u0010\u001b\u001a\u00020\u0018H\u0014J\u0010\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u000fH\u0002J\u0016\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020 H\u0086@¢\u0006\u0002\u0010!J\u000e\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020$J\u0010\u0010%\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u000fH\u0002R\u000e\u0010\f\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/larus/common_ui/SoundWaveView;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "density", "amplitude", "", "", "prevScaleY", "barScaleY", "barViewRef", "", "Landroidx/cardview/widget/CardView;", "animators", "Landroid/animation/Animator;", "onAttachedToWindow", "", "pauseAnim", "resumeAnim", "onDetachedFromWindow", "startScaleAnimation", "nextScaleY", "setAudioData", "data", "", "([BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setVolume", "before", "", "optAmplitude", "setAmplitude", "value", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SoundWaveView extends LinearLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f326847f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f326848a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f326849b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Float> f326850c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<CardView> f326851d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<? extends Animator> f326852e;

    public static final class a {
    }

    static {
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Iterator<T> r100 = this.f326852e.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((Animator) r100.next()).start();
        goto L4
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<T> r100 = this.f326852e.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((Animator) r100.next()).end();
        goto L4
    }

    public SoundWaveView(Context r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110);
        this.f326848a = 45;
        new ArrayList(0);
        this.f326849b = 1.0f;
        ArrayList r100 = new ArrayList(4);
        int r101 = 0;
    L3:
        if (r101 >= 4) goto L5;
        r100.add(Float.valueOf(1.0f));
        r101 = r101 + 1;
        goto L3
    L5:
        this.f326850c = r100;
        ArrayList r102 = new ArrayList(7);
        int r103 = 0;
    L6:
        if (r103 >= 7) goto L8;
        CardView r104 = new CardView(getContext());
        LinearLayout.LayoutParams r105 = new LinearLayout.LayoutParams(i5.z(), i5.Y());
        r105.setMargins(i5.b(), 0, i5.b(), 0);
        r104.setLayoutParams(r105);
        r104.setRadius(i5.z());
        r104.setCardElevation(0.0f);
        r104.setCardBackgroundColor(FakePickerAvatarCreator.GRAY);
        r102.add(r104);
        r103 = r103 + 1;
        goto L6
    L8:
        this.f326851d = r102;
        this.f326852e = CollectionsKt.emptyList();
        setOrientation(0);
        setGravity(17);
        ArrayList r106 = r102;
        ArrayList r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));
        Iterator r108 = r106.iterator();
        final int r109 = 0;
    L10:
        if (r108.hasNext() == false) goto L15;
        Object r111 = r108.next();
        int r112 = r109 + 1;
        if (r109 >= 0) goto L14;
        CollectionsKt.throwIndexOverflow();
    L14:
        final CardView r113 = (CardView) r111;
        addView(r113);
        ValueAnimator r114 = ValueAnimator.ofInt(new int[]{i5.Y(), i5.r0(), i5.Y()});
        r114.setInterpolator(new PathInterpolator(0.4f, 0.8f, 0.74f, 1.0f));
        r114.setDuration(1000);
        r114.setStartDelay(Math.abs(((long) (r109 - 3)) * 400));
        r114.setRepeatCount(-1);
        r114.addUpdateListener(new c(r113, this, r109));
        r107.add(r114);
        r109 = r112;
        goto L10
    L15:
        this.f326852e = r107;
    }

    public static float b(double r100) {
        if (r100 <= 0.5d) goto L5;
        double r101 = 1.0d;
    L7:
        return RangesKt.coerceAtMost(((float) r101) * 2.5f, 1.0f);
    L5:
        r101 = Math.sin(r100 * 3.141592653589793d);
        goto L7
    }

    private final void setAmplitude(float r110) {
        FLogger.f375446a.i("SoundWaveView", "next amplitude " + r110);
        float r111 = r110 + 1.0f;
        if (r111 != this.f326849b) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L15;
        final int r101 = 0;
    L10:
        if (r101 >= 4) goto L12;
        ValueAnimator r102 = ValueAnimator.ofFloat(new float[]{this.f326849b, r111});
        r102.setDuration(200);
        r102.setInterpolator(new PathInterpolator(0.4f, 0.8f, 0.74f, 1.0f));
        r102.setStartDelay(((long) r101) * 200);
        r102.addUpdateListener(new b(this, r101));
        r102.start();
        r101 = r101 + 1;
        goto L10
    L12:
        this.f326849b = r111;
        return;
    L15:
        return;
    L5:
        r100 = false;
        goto L6
    }

    public final void setVolume(double r100) {
        setAmplitude(b(r100));
    }

    public SoundWaveView(Context r110, AttributeSet r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111);
        this.f326848a = 45;
        new ArrayList(0);
        this.f326849b = 1.0f;
        ArrayList r100 = new ArrayList(4);
        int r101 = 0;
    L3:
        if (r101 >= 4) goto L5;
        r100.add(Float.valueOf(1.0f));
        r101 = r101 + 1;
        goto L3
    L5:
        this.f326850c = r100;
        ArrayList r102 = new ArrayList(7);
        int r103 = 0;
    L6:
        if (r103 >= 7) goto L8;
        CardView r104 = new CardView(getContext());
        LinearLayout.LayoutParams r105 = new LinearLayout.LayoutParams(i5.z(), i5.Y());
        r105.setMargins(i5.b(), 0, i5.b(), 0);
        r104.setLayoutParams(r105);
        r104.setRadius(i5.z());
        r104.setCardElevation(0.0f);
        r104.setCardBackgroundColor(FakePickerAvatarCreator.GRAY);
        r102.add(r104);
        r103 = r103 + 1;
        goto L6
    L8:
        this.f326851d = r102;
        this.f326852e = CollectionsKt.emptyList();
        setOrientation(0);
        setGravity(17);
        ArrayList r106 = r102;
        ArrayList r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));
        Iterator r108 = r106.iterator();
        final int r109 = 0;
    L10:
        if (r108.hasNext() == false) goto L15;
        Object r112 = r108.next();
        int r113 = r109 + 1;
        if (r109 >= 0) goto L14;
        CollectionsKt.throwIndexOverflow();
    L14:
        final CardView r114 = (CardView) r112;
        addView(r114);
        ValueAnimator r115 = ValueAnimator.ofInt(new int[]{i5.Y(), i5.r0(), i5.Y()});
        r115.setInterpolator(new PathInterpolator(0.4f, 0.8f, 0.74f, 1.0f));
        r115.setDuration(1000);
        r115.setStartDelay(Math.abs(((long) (r109 - 3)) * 400));
        r115.setRepeatCount(-1);
        r115.addUpdateListener(new c(r114, this, r109));
        r107.add(r115);
        r109 = r113;
        goto L10
    L15:
        this.f326852e = r107;
    }

    public final Object c(byte[] r100, Continuation<? super Unit> r101) {
        if ((r101 instanceof SoundWaveView$setAudioData$1) == false) goto L7;
        SoundWaveView$setAudioData$1 r102 = (SoundWaveView$setAudioData$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
    L17:
        Iterator r107 = ((ArrayList) r104).iterator();
        if (r107.hasNext() == true) goto L20;
        Double r108 = null;
    L25:
        if (r108 == null) goto L27;
        double r109 = r108.doubleValue();
    L28:
        setAmplitude(b(r109));
        return Unit.INSTANCE;
    L27:
        r109 = AudioStats.AUDIO_AMPLITUDE_NONE;
        goto L28
    L20:
        double r110 = Math.abs(((Number) r107.next()).doubleValue());
    L22:
        if (r107.hasNext() == false) goto L24;
        r110 = Math.max(r110, Math.abs(((Number) r107.next()).doubleValue()));
        goto L22
    L24:
        r108 = Boxing.boxDouble(r110);
        goto L25
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        int r111 = com.larus.common_ui.widget.input.a.f328681a;
        int r112 = this.f326848a;
        r102.label = 1;
        r104 = com.larus.common_ui.widget.input.a.a(r100, r112, r102);
        if (r104 != r105) goto L17;
        return r105;
    L7:
        r102 = new SoundWaveView$setAudioData$1(this, r101);
        goto L8
    }

    public SoundWaveView(Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112);
        this.f326848a = 45;
        new ArrayList(0);
        this.f326849b = 1.0f;
        ArrayList r113 = new ArrayList(4);
        int r100 = 0;
    L3:
        if (r100 >= 4) goto L5;
        r113.add(Float.valueOf(1.0f));
        r100 = r100 + 1;
        goto L3
    L5:
        this.f326850c = r113;
        ArrayList r114 = new ArrayList(7);
        int r101 = 0;
    L6:
        if (r101 >= 7) goto L8;
        CardView r102 = new CardView(getContext());
        LinearLayout.LayoutParams r103 = new LinearLayout.LayoutParams(i5.z(), i5.Y());
        r103.setMargins(i5.b(), 0, i5.b(), 0);
        r102.setLayoutParams(r103);
        r102.setRadius(i5.z());
        r102.setCardElevation(0.0f);
        r102.setCardBackgroundColor(FakePickerAvatarCreator.GRAY);
        r114.add(r102);
        r101 = r101 + 1;
        goto L6
    L8:
        this.f326851d = r114;
        this.f326852e = CollectionsKt.emptyList();
        setOrientation(0);
        setGravity(17);
        ArrayList r115 = r114;
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r115, 10));
        Iterator r116 = r115.iterator();
        final int r105 = 0;
    L10:
        if (r116.hasNext() == false) goto L15;
        Object r106 = r116.next();
        int r107 = r105 + 1;
        if (r105 >= 0) goto L14;
        CollectionsKt.throwIndexOverflow();
    L14:
        final CardView r108 = (CardView) r106;
        addView(r108);
        ValueAnimator r109 = ValueAnimator.ofInt(new int[]{i5.Y(), i5.r0(), i5.Y()});
        r109.setInterpolator(new PathInterpolator(0.4f, 0.8f, 0.74f, 1.0f));
        r109.setDuration(1000);
        r109.setStartDelay(Math.abs(((long) (r105 - 3)) * 400));
        r109.setRepeatCount(-1);
        r109.addUpdateListener(new c(r108, this, r105));
        r104.add(r109);
        r105 = r107;
        goto L10
    L15:
        this.f326852e = r104;
    }

    public static void a(CardView r100, SoundWaveView r101, int r102, ValueAnimator r103) {
        Intrinsics.checkNotNullParameter(r103, "it");
        if (r100 == null) goto L5;
        ViewGroup.LayoutParams r104 = r100.getLayoutParams();
    L6:
        if (r104 == null) goto L8;
        Object r105 = r103.getAnimatedValue();
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type kotlin.Int");
        r104.height = (int) (((Integer) r105).intValue() * ((Number) ListProtector.get(r101.f326850c, Math.abs(r102 - 3))).floatValue());
    L8:
        if (r100 == null) goto L11;
        r100.setLayoutParams(r104);
        return;
    L11:
        return;
    L5:
        r104 = null;
        goto L6
    }
}
