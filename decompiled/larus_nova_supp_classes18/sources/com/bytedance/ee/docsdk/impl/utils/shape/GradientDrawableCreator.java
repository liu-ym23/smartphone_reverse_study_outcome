package com.bytedance.ee.docsdk.impl.utils.shape;

import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class GradientDrawableCreator {

    public static class Builder {
        private ColorStateList colorStateList;
        private int fillColor;
        private float[] radii;
        private float radius;
        private int shape;

        public GradientDrawable build() {
            GradientDrawable r0 = new GradientDrawable();
            int r1 = this.fillColor;
            if (r1 == 0) goto L5;
            r0.setColor(r1);
        L5:
            float r2 = this.radius;
            if (r2 == 0.0f) goto L8;
            r0.setCornerRadius(r2);
        L8:
            float[] r3 = this.radii;
            if (r3 == null) goto L11;
            r0.setCornerRadii(r3);
        L11:
            ColorStateList r4 = this.colorStateList;
            if (r4 == null) goto L14;
            r0.setColor(r4);
        L14:
            r0.setShape(this.shape);
            return r0;
        }

        public Builder() {
            this.fillColor = 0;
            this.radius = 0.0f;
            this.shape = 0;
        }

        public Builder colorStateList(ColorStateList r1) {
            this.colorStateList = r1;
            return this;
        }

        public Builder cornerRadii(float[] r1) {
            this.radii = r1;
            return this;
        }

        public Builder cornerRadius(float r1) {
            this.radius = r1;
            return this;
        }

        public Builder fillColor(int r1) {
            this.fillColor = r1;
            return this;
        }

        public Builder shape(int r1) {
            this.shape = r1;
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Shape {
    }

    public GradientDrawableCreator() {
    }
}
