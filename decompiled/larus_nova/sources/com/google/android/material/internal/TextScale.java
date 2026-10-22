package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.transition.Transition;
import androidx.transition.TransitionValues;
import java.util.Map;

/* JADX INFO: loaded from: classes23.dex */
public class TextScale extends Transition {
    private static final String PROPNAME_SCALE = "android:textscale:scale";

    public TextScale() {
    }

    private void captureValues(TransitionValues r100) {
        View r101 = r100.view;
        if ((r101 instanceof TextView) == false) goto L6;
        r100.values.put(PROPNAME_SCALE, Float.valueOf(((TextView) r101).getScaleX()));
        return;
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(TransitionValues r100) {
        captureValues(r100);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(TransitionValues r100) {
        captureValues(r100);
    }

    @Override // androidx.transition.Transition
    public Animator createAnimator(ViewGroup r100, TransitionValues r101, TransitionValues r102) {
        if (r101 == null) goto L22;
        if (r102 != null) goto L6;
        return null;
    L6:
        if ((r101.view instanceof TextView) == false) goto L24;
        View r103 = r102.view;
        if ((r103 instanceof TextView) == false) goto L25;
        final TextView r104 = (TextView) r103;
        Map<String, Object> r105 = r101.values;
        Map<String, Object> r106 = r102.values;
        float r107 = 1.0f;
        if (r105.get(PROPNAME_SCALE) == null) goto L13;
        float r108 = ((Float) r105.get(PROPNAME_SCALE)).floatValue();
    L15:
        if (r106.get(PROPNAME_SCALE) == null) goto L18;
        r107 = ((Float) r106.get(PROPNAME_SCALE)).floatValue();
    L18:
        if (r108 != r107) goto L20;
        return null;
    L20:
        ValueAnimator r109 = ValueAnimator.ofFloat(new float[]{r108, r107});
        r109.addUpdateListener(new AnonymousClass1(this, r104));
        return r109;
    L13:
        r108 = 1.0f;
        goto L15
    L25:
        return null;
    L24:
        return null;
    L22:
        return null;
    }
}
