package com.ss.android.ugc.aweme.search.vision.loading.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.search.common.anim.CubicBezierInterpolator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/ugc/aweme/search/vision/loading/view/LoadingBgAnimationView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LoadingBgAnimationView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Animator f453589a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Animator f453590b;

    public final void a() {
        if (this.f453589a != null) goto L10;
        ImageView r100 = (ImageView) findViewById(R.id.animation_bg_1);
        if (r100 == null) goto L10;
        ObjectAnimator r110 = ObjectAnimator.ofPropertyValuesHolder(r100, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(LiveDegradeFpsAnimator.SCALE_X, new float[]{0.0f, 1.0f}), PropertyValuesHolder.ofFloat(LiveDegradeFpsAnimator.SCALE_Y, new float[]{0.0f, 1.0f})});
        r110.setDuration(900);
        r110.setInterpolator(new CubicBezierInterpolator(0.0f, 0.0f, 1.0f));
        AnimatorSet r111 = new AnimatorSet();
        ObjectAnimator r112 = ObjectAnimator.ofFloat(r100, "alpha", new float[]{0.0f, 1.0f});
        r112.setDuration(400);
        r112.setInterpolator(new CubicBezierInterpolator(0.0f, 0.0f, 1.0f));
        ObjectAnimator r101 = ObjectAnimator.ofFloat(r100, "alpha", new float[]{1.0f, 0.0f});
        r101.setDuration(500);
        r101.setInterpolator(new CubicBezierInterpolator(0.0f, 0.0f, 1.0f));
        r111.playSequentially(new Animator[]{r112, r101});
        AnimatorSet r102 = new AnimatorSet();
        r102.playTogether(new Animator[]{r110, r111});
        this.f453589a = r102;
    L10:
        if (this.f453590b != null) goto L16;
        ImageView r103 = (ImageView) findViewById(R.id.animation_bg_2);
        if (r103 == null) goto L16;
        ObjectAnimator r104 = ObjectAnimator.ofPropertyValuesHolder(r103, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(LiveDegradeFpsAnimator.SCALE_X, new float[]{0.0f, 1.0f}), PropertyValuesHolder.ofFloat(LiveDegradeFpsAnimator.SCALE_Y, new float[]{0.0f, 1.0f})});
        r104.setDuration(1100);
        r104.setInterpolator(new CubicBezierInterpolator(0.0f, 0.0f, 1.0f));
        r104.setStartDelay(200);
        AnimatorSet r113 = new AnimatorSet();
        ObjectAnimator r114 = ObjectAnimator.ofFloat(r103, "alpha", new float[]{0.0f, 1.0f});
        r114.setDuration(600);
        r114.setInterpolator(new CubicBezierInterpolator(0.0f, 0.0f, 1.0f));
        r114.setStartDelay(200);
        ObjectAnimator r105 = ObjectAnimator.ofFloat(r103, "alpha", new float[]{1.0f, 0.0f});
        r105.setDuration(500);
        r105.setInterpolator(new CubicBezierInterpolator(0.0f, 0.0f, 1.0f));
        r105.setStartDelay(200);
        r113.playSequentially(new Animator[]{r114, r105});
        AnimatorSet r106 = new AnimatorSet();
        r106.playTogether(new Animator[]{r104, r113});
        this.f453590b = r106;
    L16:
        Animator r107 = this.f453589a;
        if (r107 == null) goto L19;
        r107.start();
    L19:
        Animator r108 = this.f453590b;
        if (r108 == null) goto L23;
        r108.start();
        return;
    }

    public LoadingBgAnimationView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        FrameLayout.inflate(getContext(), R.layout.search_photo_search_loading_bg_anmiation, this);
    }

    public LoadingBgAnimationView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        FrameLayout.inflate(getContext(), R.layout.search_photo_search_loading_bg_anmiation, this);
    }

    public LoadingBgAnimationView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        FrameLayout.inflate(getContext(), R.layout.search_photo_search_loading_bg_anmiation, this);
    }
}
