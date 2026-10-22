package vx3;

import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.util.Pair;
import com.bytedance.awemeopen.apps.framework.base.view.digg.DiggAnimationView;
import com.facebook.keyframes.KeyframesDrawableBuilder;
import com.facebook.keyframes.model.KFImage;

/* JADX INFO: loaded from: classes14.dex */
public final /* synthetic */ class a implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f557463a;

    public /* synthetic */ a(b r100) {
        this.f557463a = r100;
    }

    public final void a(KFImage r100) {
        b r101 = this.f557463a;
        Drawable r102 = r101.f557464a.getLogoDrawable();
        if (r102 == null) goto L5;
        r102.setBounds(0, 0, 120, 120);
        r101.f557464a.f193240a = new KeyframesDrawableBuilder().withImage(r100).withExperimentalFeatures().withParticleFeatureConfigs(new Pair[]{Pair.create("keyframes", Pair.create(r102, new Matrix()))}).build();
    L5:
        DiggAnimationView r103 = r101.f557464a;
        Pair<Float, Float> r104 = r103.getAnimateScale();
        r103.animate().scaleX(((Float) r104.first).floatValue()).scaleY(((Float) r104.second).floatValue()).setDuration(1).start();
        r103.setVisibility(0);
        r103.setLayerType(1, null);
        r103.setImageDrawable(r101.f557464a.f193240a);
        r103.setImageAlpha(0);
        r101.f557464a.f193240a.startAnimation();
        r101.f557464a.f193240a.stopAnimationAtLoopEnd();
        DiggAnimationView r105 = r101.f557464a;
        r105.f193240a.setAnimationListener(r105.f193241b);
    }
}
