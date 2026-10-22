package com.bytedance.awemeopen.apps.framework.base.view.digg;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import com.facebook.keyframes.KeyframesDrawable;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes14.dex */
public class DiggAnimationView extends AppCompatImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public KeyframesDrawable f193240a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f193241b;

    public class a implements KeyframesDrawable.OnAnimationEnd {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DiggAnimationView f193242a;

        @Override // com.facebook.keyframes.KeyframesDrawable.OnAnimationEnd
        public final void onAnimationEnd() {
            DiggAnimationView r100 = this.f193242a;
            r100.setScaleX(1.0f);
            r100.setScaleY(1.0f);
            r100.setImageAlpha(254);
            r100.setImageDrawable(this.f193242a.getSelector());
        }

        public a(DiggAnimationView r100) {
            this.f193242a = r100;
        }
    }

    public Pair<Float, Float> getAnimateScale() {
        Float r100 = Float.valueOf(1.25f);
        return new Pair(r100, r100);
    }

    public Drawable getLogoDrawable() {
        return ContextCompat.getDrawable(getContext(), R.drawable.aos_feed_item_icon_digg_after);
    }

    public Drawable getSelector() {
        return ContextCompat.getDrawable(getContext(), R.drawable.aos_feed_item_icon_digg);
    }

    public DiggAnimationView(Context r100) {
        super(r100);
        this.f193241b = new a(this);
    }

    public DiggAnimationView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f193241b = new a(this);
    }

    public DiggAnimationView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f193241b = new a(this);
    }
}
