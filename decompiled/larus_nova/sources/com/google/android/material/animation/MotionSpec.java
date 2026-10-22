package com.google.android.material.animation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import androidx.collection.SimpleArrayMap;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public class MotionSpec {
    private static final String TAG = "MotionSpec";
    private final SimpleArrayMap<String, MotionTiming> timings;

    public long getTotalDuration() {
        int r100 = this.timings.size();
        long r101 = 0;
        int r102 = 0;
    L3:
        if (r102 >= r100) goto L5;
        MotionTiming r103 = this.timings.valueAt(r102);
        r101 = Math.max(r101, r103.getDelay() + r103.getDuration());
        r102 = r102 + 1;
        goto L3
    L5:
        return r101;
    }

    public int hashCode() {
        return this.timings.hashCode();
    }

    public String toString() {
        return "\n" + getClass().getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " timings: " + this.timings + "}\n";
    }

    public MotionSpec() {
        this.timings = new SimpleArrayMap();
    }

    private static MotionSpec createSpecFromAnimators(List<Animator> r100) {
        MotionSpec r101 = new MotionSpec();
        int r102 = r100.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        addTimingFromAnimator(r101, (Animator) ListProtector.get(r100, r103));
        r103 = r103 + 1;
        goto L3
    L5:
        return r101;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L5;
        return true;
    L5:
        if (r100 != null) goto L7;
        return false;
    L7:
        if (getClass() == r100.getClass()) goto L10;
        return false;
    L10:
        return this.timings.equals(((MotionSpec) r100).timings);
    }

    public MotionTiming getTiming(String r100) {
        if (hasTiming(r100) == false) goto L7;
        return this.timings.get(r100);
    L7:
        throw new IllegalArgumentException();
    }

    public boolean hasTiming(String r100) {
        if (this.timings.get(r100) == null) goto L5;
        return true;
    L5:
        return false;
    }

    private static void addTimingFromAnimator(MotionSpec r100, Animator r101) {
        if ((r101 instanceof ObjectAnimator) == false) goto L7;
        ObjectAnimator r102 = (ObjectAnimator) r101;
        r100.setTiming(r102.getPropertyName(), MotionTiming.createFromAnimator(r102));
        return;
    L7:
        throw new IllegalArgumentException("Animator must be an ObjectAnimator: " + r101);
    }

    public static MotionSpec createFromResource(Context r100, int r101) {
        Animator r102 = AnimatorInflater.loadAnimator(r100, r101);     // Catch: Exception -> L11
        if ((r102 instanceof AnimatorSet) == true) goto L6;
        if (r102 == null) goto L10;
        ArrayList r103 = new ArrayList();     // Catch: Exception -> L11
        r103.add(r102);     // Catch: Exception -> L11
        return createSpecFromAnimators(r103);
    L10:
        return null;
    L6:
        return createSpecFromAnimators(((AnimatorSet) r102).getChildAnimations());
    L11:
        Integer.toHexString(r101);
        return null;
    }

    public void setTiming(String r100, MotionTiming r101) {
        this.timings.put(r100, r101);
    }

    public static MotionSpec createFromAttribute(Context r100, TypedArray r101, int r102) {
        if (r101.hasValue(r102) == false) goto L8;
        int r103 = r101.getResourceId(r102, 0);
        if (r103 != 0) goto L7;
        return null;
    L7:
        return createFromResource(r100, r103);
    L8:
        return null;
    }
}
