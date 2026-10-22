package com.ss.android.lark.keyboard.keyboard2;

import android.graphics.Rect;
import android.view.View;
import androidx.transition.ChangeBounds;
import androidx.transition.TransitionValues;
import com.larus.nova.R;
import com.ss.android.lark.KeyboardBaseModule;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0014\u0010\u0016\u001a\u00020\u0011*\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0005H\u0002J\u0014\u0010\u0018\u001a\u00020\u0011*\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0005H\u0002JS\u0010\u0019\u001a\u00020\u00112K\u0010\u001a\u001aG\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000RU\u0010\t\u001aI\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/keyboard/keyboard2/KeyboardChangeBounds;", "Landroidx/transition/ChangeBounds;", "<init>", "()V", "reusableStartBounds", "Landroid/graphics/Rect;", "reusableEndBounds", "shouldClearStartValuesTag", "", "prepareAnimationHandler", "Lkotlin/Function3;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "startBounds", "endBounds", "", "captureStartValues", "transitionValues", "Landroidx/transition/TransitionValues;", "captureEndValues", "copyBounds", "bounds", "resetBounds", "onPrepareAnimation", "handleAction", "Companion", "keyboard-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KeyboardChangeBounds extends ChangeBounds {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Rect f429458a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Rect f429459b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f429460c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function3<? super View, ? super Rect, ? super Rect, Unit> f429461d;

    public static final class a {
    }

    static {
    }

    public KeyboardChangeBounds() {
        this.f429458a = new Rect();
        this.f429459b = new Rect();
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L9
        if (KeyboardBaseModule.a().isFeatureGatingEnable("messenger.im.disable_keyboard_change_bounds_leak_fix") == true) goto L6;
        boolean r101 = true;
    L7:
        Object r102 = Result.m9449constructorimpl(Boolean.valueOf(r101));     // Catch: Throwable -> L9
    L11:
        Boolean r103 = Boolean.TRUE;
        if (Result.m9455isFailureimpl(r102) == false) goto L14;
        r102 = r103;
    L14:
        this.f429460c = ((Boolean) r102).booleanValue();
        return;
    L6:
        r101 = false;
    L9:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
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
    L7:
        if (this.f429460c == false) goto L9;
        r101.setTag(R.id.kb_change_bounds_start_value, null);
    L9:
        Function3<? super View, ? super Rect, ? super Rect, Unit> r105 = this.f429461d;
        if (r104 == null) goto L36;
        if (r105 == null) goto L37;
        Rect r106 = this.f429458a;
        Object r107 = r104.values.get("android:changeBounds:bounds");
        if ((r107 instanceof Rect) == false) goto L15;
        Rect r108 = (Rect) r107;
    L16:
        if (r108 == null) goto L18;
        r106.set(r108);
    L18:
        Rect r109 = this.f429459b;
        Object r110 = r100.values.get("android:changeBounds:bounds");
        if ((r110 instanceof Rect) == false) goto L21;
        Rect r111 = (Rect) r110;
    L22:
        if (r111 == null) goto L24;
        r109.set(r111);
    L24:
        Intrinsics.checkNotNull(r101);
        r105.invoke(r101, this.f429458a, this.f429459b);
        Rect r112 = this.f429458a;
        Object r113 = r104.values.get("android:changeBounds:bounds");
        if ((r113 instanceof Rect) == false) goto L27;
        Rect r114 = (Rect) r113;
    L28:
        if (r114 == null) goto L30;
        r114.set(r112);
    L30:
        Rect r115 = this.f429459b;
        Object r116 = r100.values.get("android:changeBounds:bounds");
        if ((r116 instanceof Rect) == false) goto L33;
        r103 = (Rect) r116;
    L33:
        if (r103 == null) goto L38;
        r103.set(r115);
        return;
    L38:
        return;
    L27:
        r114 = null;
        goto L28
    L21:
        r111 = null;
        goto L22
    L15:
        r108 = null;
        goto L16
    L37:
        return;
    L36:
        return;
    L5:
        r104 = null;
        goto L7
    }

    @Override // androidx.transition.ChangeBounds, androidx.transition.Transition
    public final void captureStartValues(TransitionValues r100) {
        Intrinsics.checkNotNullParameter(r100, "transitionValues");
        super.captureStartValues(r100);
        r100.view.setTag(R.id.kb_change_bounds_start_value, r100);
    }
}
