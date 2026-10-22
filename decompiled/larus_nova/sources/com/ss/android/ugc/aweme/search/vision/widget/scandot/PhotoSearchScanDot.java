package com.ss.android.ugc.aweme.search.vision.widget.scandot;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.search.common.anim.CubicBezierInterpolator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/ugc/aweme/search/vision/widget/scandot/PhotoSearchScanDot;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PhotoSearchScanDot extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AnimatorSet f454106a;

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        AnimatorSet r100 = this.f454106a;
        if (r100 == null) goto L6;
        r100.cancel();
        return;
    }

    public PhotoSearchScanDot(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        FrameLayout.inflate(getContext(), R.layout.photo_search_scan_dot, this);
        ImageView r101 = (ImageView) findViewById(R.id.scan_dot_back);
        ImageView r102 = (ImageView) findViewById(R.id.scan_dot_fe);
        if (r101 == null) goto L6;
        if (r102 == null) goto L6;
        this.f454106a = a(r102, r101);
    L6:
        post(new AnonymousClass2(this));
    }

    public PhotoSearchScanDot(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        FrameLayout.inflate(getContext(), R.layout.photo_search_scan_dot, this);
        ImageView r102 = (ImageView) findViewById(R.id.scan_dot_back);
        ImageView r103 = (ImageView) findViewById(R.id.scan_dot_fe);
        if (r102 == null) goto L6;
        if (r103 == null) goto L6;
        this.f454106a = a(r103, r102);
    L6:
        post(new AnonymousClass2(this));
    }

    public final AnimatorSet a(View r110, View r111) {
        CubicBezierInterpolator r100 = new CubicBezierInterpolator(0.65f, 0.0f, 0.35f);
        CubicBezierInterpolator r101 = new CubicBezierInterpolator(0.4f, 0.0f, 0.2f);
        AnimatorSet r102 = new AnimatorSet();
        r102.play(ObjectAnimator.ofFloat(r110, LiveDegradeFpsAnimator.SCALE_X, new float[]{1.0f, 1.125f})).with(ObjectAnimator.ofFloat(r110, LiveDegradeFpsAnimator.SCALE_Y, new float[]{1.0f, 1.125f})).before(ObjectAnimator.ofFloat(r110, LiveDegradeFpsAnimator.SCALE_X, new float[]{1.125f, 1.0f})).before(ObjectAnimator.ofFloat(r110, LiveDegradeFpsAnimator.SCALE_Y, new float[]{1.125f, 1.0f}));
        r102.setDuration(1000);
        r102.setInterpolator(r100);
        AnimatorSet r112 = new AnimatorSet();
        AnimatorSet.Builder r103 = r112.play(ObjectAnimator.ofFloat(r111, "alpha", new float[]{0.65f, 0.0f}));
        ObjectAnimator r104 = ObjectAnimator.ofFloat(r111, LiveDegradeFpsAnimator.SCALE_X, new float[]{1.0f, 2.0f});
        r104.setInterpolator(r101);
        Unit r105 = Unit.INSTANCE;
        AnimatorSet.Builder r106 = r103.with(r104);
        ObjectAnimator r113 = ObjectAnimator.ofFloat(r111, LiveDegradeFpsAnimator.SCALE_Y, new float[]{1.0f, 2.0f});
        r113.setInterpolator(r101);
        r106.with(r113);
        r112.setDuration(2000);
        AnimatorSet r114 = new AnimatorSet();
        r114.play(r102).with(r112);
        r114.addListener(new PhotoSearchScanDot$generateDotAnimator$1(this, r114));
        return r114;
    }

    public PhotoSearchScanDot(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        FrameLayout.inflate(getContext(), R.layout.photo_search_scan_dot, this);
        ImageView r103 = (ImageView) findViewById(R.id.scan_dot_back);
        ImageView r104 = (ImageView) findViewById(R.id.scan_dot_fe);
        if (r103 == null) goto L6;
        if (r104 == null) goto L6;
        this.f454106a = a(r104, r103);
    L6:
        post(new AnonymousClass2(this));
    }
}
