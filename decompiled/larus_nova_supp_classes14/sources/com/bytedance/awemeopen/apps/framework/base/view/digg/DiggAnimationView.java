package com.bytedance.awemeopen.apps.framework.base.view.digg;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import com.facebook.keyframes.KeyframesDrawable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class DiggAnimationView extends AppCompatImageView {
    public KeyframesDrawable a;
    public final a b;

    public class a implements KeyframesDrawable.OnAnimationEnd {
        public final /* synthetic */ DiggAnimationView a;

        public final void onAnimationEnd() {
            AppCompatImageView r0 = this.a;
            r0.setScaleX(1.0f);
            r0.setScaleY(1.0f);
            r0.setImageAlpha(254);
            r0.setImageDrawable(this.a.getSelector());
        }

        public a(DiggAnimationView r1) {
            this.a = r1;
        }
    }

    public Pair<Float, Float> getAnimateScale() {
        Float r1 = Float.valueOf(1.25f);
        return new Pair(r1, r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Drawable getLogoDrawable() {
        return ContextCompat.getDrawable(getContext(), 2131231459);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Drawable getSelector() {
        return ContextCompat.getDrawable(getContext(), 2131231458);
    }

    public DiggAnimationView(Context r1) {
        super(r1);
        this.b = new a(this);
    }

    public DiggAnimationView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.b = new a(this);
    }

    public DiggAnimationView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.b = new a(this);
    }
}
