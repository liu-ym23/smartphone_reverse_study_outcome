package com.ss.android.lark.discretescrollview.transform;

import android.view.View;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes35.dex */
public class ScaleTransformer implements DiscreteScrollItemTransformer {
    private static final String LOG_TAG = "ScaleTransformer";
    private float maxMinOpacityDiff;
    private float maxMinScaleDiff;
    private float minOpacity;
    private float minScale;
    private Pivot pivotX;
    private Pivot pivotY;

    public static class Builder {
        private float maxScale;
        protected ScaleTransformer transformer;

        public ScaleTransformer build() {
            ScaleTransformer r100 = this.transformer;
            ScaleTransformer.access$402(r100, this.maxScale - ScaleTransformer.access$000(r100));
            ScaleTransformer r101 = this.transformer;
            ScaleTransformer.access$502(r101, 1.0f - ScaleTransformer.access$300(r101));
            return this.transformer;
        }

        public Builder() {
            this.transformer = new ScaleTransformer();
            this.maxScale = 1.0f;
        }

        public Builder setMaxScale(float r100) {
            this.maxScale = r100;
            return this;
        }

        public Builder setMinOpacity(float r100) {
            ScaleTransformer.access$302(this.transformer, r100);
            return this;
        }

        public Builder setMinScale(float r100) {
            ScaleTransformer.access$002(this.transformer, r100);
            return this;
        }

        public Builder setPivotX(Pivot r100) {
            assertAxis(r100, 0);
            ScaleTransformer.access$102(this.transformer, r100);
            return this;
        }

        public Builder setPivotY(Pivot r100) {
            assertAxis(r100, 1);
            ScaleTransformer.access$202(this.transformer, r100);
            return this;
        }

        public Builder setPivotX(Pivot.X r100) {
            return setPivotX(r100.create());
        }

        public Builder setPivotY(Pivot.Y r100) {
            return setPivotY(r100.create());
        }

        private void assertAxis(Pivot r100, int r101) {
            if (r100.f420445a == r101) goto L6;
            Log.e(ScaleTransformer.LOG_TAG, "You passed a Pivot for wrong axis.");
            return;
        }
    }

    public ScaleTransformer() {
        this.pivotX = Pivot.X.CENTER.create();
        this.pivotY = Pivot.Y.CENTER.create();
        this.minScale = 0.8f;
        this.maxMinScaleDiff = 0.2f;
        this.minOpacity = 1.0f;
    }

    public static /* synthetic */ float access$000(ScaleTransformer r100) {
        return r100.minScale;
    }

    public static /* synthetic */ float access$300(ScaleTransformer r100) {
        return r100.minOpacity;
    }

    public static /* synthetic */ float access$002(ScaleTransformer r100, float r101) {
        r100.minScale = r101;
        return r101;
    }

    public static /* synthetic */ Pivot access$102(ScaleTransformer r100, Pivot r101) {
        r100.pivotX = r101;
        return r101;
    }

    public static /* synthetic */ Pivot access$202(ScaleTransformer r100, Pivot r101) {
        r100.pivotY = r101;
        return r101;
    }

    public static /* synthetic */ float access$302(ScaleTransformer r100, float r101) {
        r100.minOpacity = r101;
        return r101;
    }

    public static /* synthetic */ float access$402(ScaleTransformer r100, float r101) {
        r100.maxMinScaleDiff = r101;
        return r101;
    }

    public static /* synthetic */ float access$502(ScaleTransformer r100, float r101) {
        r100.maxMinOpacityDiff = r101;
        return r101;
    }

    @Override // com.ss.android.lark.discretescrollview.transform.DiscreteScrollItemTransformer
    public void transformItem(View r100, float r101) {
        this.pivotX.a(r100);
        this.pivotY.a(r100);
        float r102 = 1.0f - Math.abs(r101);
        float r103 = this.minScale + (this.maxMinScaleDiff * r102);
        r100.setScaleX(r103);
        r100.setScaleY(r103);
        r100.setAlpha(this.minOpacity + (this.maxMinOpacityDiff * r102));
    }
}
