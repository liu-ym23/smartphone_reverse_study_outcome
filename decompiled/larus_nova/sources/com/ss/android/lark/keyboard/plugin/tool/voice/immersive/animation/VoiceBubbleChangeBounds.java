package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation;

import android.graphics.Rect;
import android.view.View;
import androidx.transition.ChangeBounds;
import androidx.transition.TransitionValues;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0014\u0010\u0014\u001a\u00020\u000f*\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0005H\u0002J\u0014\u0010\u0016\u001a\u00020\u000f*\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0005H\u0002JS\u0010\u0017\u001a\u00020\u000f2K\u0010\u0018\u001aG\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000RU\u0010\u0007\u001aI\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/animation/VoiceBubbleChangeBounds;", "Landroidx/transition/ChangeBounds;", "<init>", "()V", "reusableStartBounds", "Landroid/graphics/Rect;", "reusableEndBounds", "prepareAnimationHandler", "Lkotlin/Function3;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "startBounds", "endBounds", "", "captureStartValues", "transitionValues", "Landroidx/transition/TransitionValues;", "captureEndValues", "copyBounds", "bounds", "resetBounds", "onPrepareAnimation", "handleAction", "Companion", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VoiceBubbleChangeBounds extends ChangeBounds {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Rect f430200a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Rect f430201b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function3<? super View, ? super Rect, ? super Rect, Unit> f430202c;

    public static final class a {
    }

    static {
    }

    public VoiceBubbleChangeBounds() {
        this.f430200a = new Rect();
        this.f430201b = new Rect();
    }

    @Override // androidx.transition.ChangeBounds, androidx.transition.Transition
    public final void captureEndValues(TransitionValues r100) {
        Intrinsics.checkNotNullParameter(r100, "transitionValues");
        super.captureEndValues(r100);
        View r101 = r100.view;
        Object r102 = r101.getTag(R.id.kb_change_bounds_start_value);
        Rect r103 = null;
        if ((r102 instanceof TransitionValues) == false) goto L5;
        TransitionValues r104 = (TransitionValues) r102;
    L6:
        Function3<? super View, ? super Rect, ? super Rect, Unit> r105 = this.f430202c;
        if (r104 == null) goto L32;
        if (r105 == null) goto L32;
        Rect r106 = this.f430200a;
        Object r107 = r104.values.get("android:changeBounds:bounds");
        if ((r107 instanceof Rect) == false) goto L12;
        Rect r108 = (Rect) r107;
    L13:
        if (r108 == null) goto L15;
        r106.set(r108);
    L15:
        Rect r109 = this.f430201b;
        Object r110 = r100.values.get("android:changeBounds:bounds");
        if ((r110 instanceof Rect) == false) goto L18;
        Rect r111 = (Rect) r110;
    L19:
        if (r111 == null) goto L21;
        r109.set(r111);
    L21:
        Intrinsics.checkNotNull(r101);
        r105.invoke(r101, this.f430200a, this.f430201b);
        Rect r112 = this.f430200a;
        Object r113 = r104.values.get("android:changeBounds:bounds");
        if ((r113 instanceof Rect) == false) goto L24;
        Rect r114 = (Rect) r113;
    L25:
        if (r114 == null) goto L27;
        r114.set(r112);
    L27:
        Rect r115 = this.f430201b;
        Object r116 = r100.values.get("android:changeBounds:bounds");
        if ((r116 instanceof Rect) == false) goto L30;
        r103 = (Rect) r116;
    L30:
        if (r103 == null) goto L32;
        r103.set(r115);
        goto L32
    L24:
        r114 = null;
        goto L25
    L18:
        r111 = null;
        goto L19
    L12:
        r108 = null;
    L32:
        Log.d("VoiceBubbleChangeBounds", "captureEndValues: " + r100);
        return;
    L5:
        r104 = null;
        goto L6
    }

    @Override // androidx.transition.ChangeBounds, androidx.transition.Transition
    public final void captureStartValues(TransitionValues r100) {
        Intrinsics.checkNotNullParameter(r100, "transitionValues");
        super.captureStartValues(r100);
        r100.view.setTag(R.id.kb_change_bounds_start_value, r100);
        Log.d("VoiceBubbleChangeBounds", "captureStartValues: " + r100);
    }
}
