package androidx.camera.core;

import androidx.compose.material3.MenuKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class LayoutSettings {
    public static final LayoutSettings DEFAULT = null;
    private final float mAlpha;
    private final float mHeight;
    private final float mOffsetX;
    private final float mOffsetY;
    private final float mWidth;

    /* JADX INFO: renamed from: androidx.camera.core.LayoutSettings$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder {
        private float mAlpha;
        private float mHeight;
        private float mOffsetX;
        private float mOffsetY;
        private float mWidth;

        public LayoutSettings build() {
            return new LayoutSettings(this.mAlpha, this.mOffsetX, this.mOffsetY, this.mWidth, this.mHeight, null);
        }

        public Builder() {
            this.mAlpha = 1.0f;
            this.mOffsetX = MenuKt.ClosedAlphaTarget;
            this.mOffsetY = MenuKt.ClosedAlphaTarget;
            this.mWidth = MenuKt.ClosedAlphaTarget;
            this.mHeight = MenuKt.ClosedAlphaTarget;
        }

        public Builder setAlpha(float r1) {
            this.mAlpha = r1;
            return this;
        }

        public Builder setHeight(float r1) {
            this.mHeight = r1;
            return this;
        }

        public Builder setOffsetX(float r1) {
            this.mOffsetX = r1;
            return this;
        }

        public Builder setOffsetY(float r1) {
            this.mOffsetY = r1;
            return this;
        }

        public Builder setWidth(float r1) {
            this.mWidth = r1;
            return this;
        }
    }

    static {
        DEFAULT = new Builder().setAlpha(1.0f).setOffsetX(MenuKt.ClosedAlphaTarget).setOffsetY(MenuKt.ClosedAlphaTarget).setWidth(1.0f).setHeight(1.0f).build();
    }

    public float getAlpha() {
        return this.mAlpha;
    }

    public float getHeight() {
        return this.mHeight;
    }

    public float getOffsetX() {
        return this.mOffsetX;
    }

    public float getOffsetY() {
        return this.mOffsetY;
    }

    public float getWidth() {
        return this.mWidth;
    }

    private LayoutSettings(float r1, float r2, float r3, float r4, float r5) {
        this.mAlpha = r1;
        this.mOffsetX = r2;
        this.mOffsetY = r3;
        this.mWidth = r4;
        this.mHeight = r5;
    }

    public /* synthetic */ LayoutSettings(float r1, float r2, float r3, float r4, float r5, AnonymousClass1 r6) {
        this(r1, r2, r3, r4, r5);
    }
}
