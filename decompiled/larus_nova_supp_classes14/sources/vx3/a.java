package vx3;

import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.util.Pair;
import com.bytedance.awemeopen.apps.framework.base.view.digg.DiggAnimationView;
import com.facebook.keyframes.KeyframesDrawableBuilder;
import com.facebook.keyframes.model.KFImage;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final /* synthetic */ class a implements f {
    public final /* synthetic */ b a;

    public /* synthetic */ a(b r1) {
        this.a = r1;
    }

    /* JADX WARN: Type inference failed for: r8v1, types: [android.widget.ImageView, androidx.appcompat.widget.AppCompatImageView, com.bytedance.awemeopen.apps.framework.base.view.digg.DiggAnimationView] */
    public final void a(KFImage r8) {
        b r0 = this.a;
        Drawable r1 = r0.a.getLogoDrawable();
        if (r1 == null) goto L5;
        r1.setBounds(0, 0, 120, 120);
        r0.a.a = new KeyframesDrawableBuilder().withImage(r8).withExperimentalFeatures().withParticleFeatureConfigs(new Pair[]{Pair.create("keyframes", Pair.create(r1, new Matrix()))}).build();
    L5:
        ?? r9 = r0.a;
        Pair<Float, Float> r2 = r9.getAnimateScale();
        r9.animate().scaleX(((Float) r2.first).floatValue()).scaleY(((Float) r2.second).floatValue()).setDuration(1).start();
        r9.setVisibility(0);
        r9.setLayerType(1, null);
        r9.setImageDrawable(r0.a.a);
        r9.setImageAlpha(0);
        r0.a.a.startAnimation();
        r0.a.a.stopAnimationAtLoopEnd();
        DiggAnimationView r10 = r0.a;
        r10.a.setAnimationListener(r10.b);
    }
}
