package com.google.android.material.circularreveal;

import android.animation.TypeEvaluator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.Property;
import com.google.android.material.math.MathUtils;

/* JADX INFO: loaded from: classes23.dex */
public interface CircularRevealWidget extends CircularRevealHelper.Delegate {

    /* JADX INFO: renamed from: com.google.android.material.circularreveal.CircularRevealWidget$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class CircularRevealEvaluator implements TypeEvaluator<RevealInfo> {
        public static final TypeEvaluator<RevealInfo> CIRCULAR_REVEAL = null;
        private final RevealInfo revealInfo;

        static {
            CIRCULAR_REVEAL = new CircularRevealEvaluator();
        }

        public CircularRevealEvaluator() {
            this.revealInfo = new RevealInfo(null);
        }

        /* JADX INFO: renamed from: evaluate, reason: avoid collision after fix types in other method */
        public RevealInfo evaluate2(float r100, RevealInfo r101, RevealInfo r102) {
            this.revealInfo.set(MathUtils.lerp(r101.centerX, r102.centerX, r100), MathUtils.lerp(r101.centerY, r102.centerY, r100), MathUtils.lerp(r101.radius, r102.radius, r100));
            return this.revealInfo;
        }

        @Override // android.animation.TypeEvaluator
        public /* bridge */ /* synthetic */ RevealInfo evaluate(float r100, RevealInfo r101, RevealInfo r102) {
            return evaluate2(r100, r101, r102);
        }
    }

    public static class CircularRevealProperty extends Property<CircularRevealWidget, RevealInfo> {
        public static final Property<CircularRevealWidget, RevealInfo> CIRCULAR_REVEAL = null;

        static {
            CIRCULAR_REVEAL = new CircularRevealProperty("circularReveal");
        }

        private CircularRevealProperty(String r100) {
            super(RevealInfo.class, r100);
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ RevealInfo get(CircularRevealWidget r100) {
            return get2(r100);
        }

        /* JADX INFO: renamed from: get, reason: avoid collision after fix types in other method */
        public RevealInfo get2(CircularRevealWidget r100) {
            return r100.getRevealInfo();
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ void set(CircularRevealWidget r100, RevealInfo r101) {
            set2(r100, r101);
        }

        /* JADX INFO: renamed from: set, reason: avoid collision after fix types in other method */
        public void set2(CircularRevealWidget r100, RevealInfo r101) {
            r100.setRevealInfo(r101);
        }
    }

    public static class CircularRevealScrimColorProperty extends Property<CircularRevealWidget, Integer> {
        public static final Property<CircularRevealWidget, Integer> CIRCULAR_REVEAL_SCRIM_COLOR = null;

        static {
            CIRCULAR_REVEAL_SCRIM_COLOR = new CircularRevealScrimColorProperty("circularRevealScrimColor");
        }

        private CircularRevealScrimColorProperty(String r100) {
            super(Integer.class, r100);
        }

        /* JADX INFO: renamed from: get, reason: avoid collision after fix types in other method */
        public Integer get2(CircularRevealWidget r100) {
            return Integer.valueOf(r100.getCircularRevealScrimColor());
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ Integer get(CircularRevealWidget r100) {
            return get2(r100);
        }

        /* JADX INFO: renamed from: set, reason: avoid collision after fix types in other method */
        public void set2(CircularRevealWidget r100, Integer r101) {
            r100.setCircularRevealScrimColor(r101.intValue());
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ void set(CircularRevealWidget r100, Integer r101) {
            set2(r100, r101);
        }
    }

    public static class RevealInfo {
        public static final float INVALID_RADIUS = Float.MAX_VALUE;
        public float centerX;
        public float centerY;
        public float radius;

        private RevealInfo() {
        }

        public boolean isInvalid() {
            if (this.radius != Float.MAX_VALUE) goto L5;
            return true;
        L5:
            return false;
        }

        public RevealInfo(RevealInfo r100) {
            this(r100.centerX, r100.centerY, r100.radius);
        }

        public void set(RevealInfo r100) {
            set(r100.centerX, r100.centerY, r100.radius);
        }

        public /* synthetic */ RevealInfo(AnonymousClass1 r100) {
            this();
        }

        public RevealInfo(float r100, float r101, float r102) {
            this.centerX = r100;
            this.centerY = r101;
            this.radius = r102;
        }

        public void set(float r100, float r101, float r102) {
            this.centerX = r100;
            this.centerY = r101;
            this.radius = r102;
        }
    }

    void buildCircularRevealCache();

    void destroyCircularRevealCache();

    void draw(Canvas r100);

    Drawable getCircularRevealOverlayDrawable();

    int getCircularRevealScrimColor();

    RevealInfo getRevealInfo();

    boolean isOpaque();

    void setCircularRevealOverlayDrawable(Drawable r100);

    void setCircularRevealScrimColor(int r100);

    void setRevealInfo(RevealInfo r100);
}
