package com.bytedance.ee.docsdk.impl.utils.shape;

import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes18.dex */
public class GradientDrawableCreator {

    public static class Builder {
        private ColorStateList colorStateList;
        private int fillColor;
        private float[] radii;
        private float radius;
        private int shape;

        public GradientDrawable build() {
            GradientDrawable r100 = new GradientDrawable();
            int r101 = this.fillColor;
            if (r101 == 0) goto L5;
            r100.setColor(r101);
        L5:
            float r102 = this.radius;
            if (r102 == 0.0f) goto L8;
            r100.setCornerRadius(r102);
        L8:
            float[] r103 = this.radii;
            if (r103 == null) goto L11;
            r100.setCornerRadii(r103);
        L11:
            ColorStateList r104 = this.colorStateList;
            if (r104 == null) goto L14;
            r100.setColor(r104);
        L14:
            r100.setShape(this.shape);
            return r100;
        }

        public Builder() {
            this.fillColor = 0;
            this.radius = 0.0f;
            this.shape = 0;
        }

        public Builder colorStateList(ColorStateList r100) {
            this.colorStateList = r100;
            return this;
        }

        public Builder cornerRadii(float[] r100) {
            this.radii = r100;
            return this;
        }

        public Builder cornerRadius(float r100) {
            this.radius = r100;
            return this;
        }

        public Builder fillColor(int r100) {
            this.fillColor = r100;
            return this;
        }

        public Builder shape(int r100) {
            this.shape = r100;
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Shape {
    }

    public GradientDrawableCreator() {
    }
}
