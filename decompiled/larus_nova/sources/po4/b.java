package po4;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.ee.bear.document.loading.LazyLoadingWrapper;
import com.bytedance.ee.bear.document.loading.LoadingLayout;
import com.bytedance.ee.bear.facade.common.widget.BearLottieView;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class b extends LazyLoadingWrapper {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f530046m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public BearLottieView f530047n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View f530048o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public AnimatorSet f530049p;

    @Override // com.bytedance.ee.bear.document.loading.LazyLoadingWrapper, com.bytedance.ee.bear.document.loading.c
    public final void hide() {
        AnimatorSet r100 = this.f530049p;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        this.f530049p = null;
        super.hide();
    }

    @Override // com.bytedance.ee.bear.document.loading.LazyLoadingWrapper, com.bytedance.ee.bear.document.loading.c
    public final void show() {
        super.show();
        LoadingLayout r100 = d();
        if (r100 != null) goto L5;
        return;
    L5:
        LinearLayout r101 = (LinearLayout) r100.findViewById(R.id.ll_loading);
        if (r101 != null) goto L9;
        return;
    L9:
        if (this.f530046m == true) goto L28;
        View r102 = r101.findViewById(R.id.lark_loading_view);
        if (r102 == null) goto L13;
        ViewParent r103 = r102.getParent();
    L15:
        if ((r103 instanceof ViewGroup) == false) goto L17;
        ViewGroup r104 = (ViewGroup) r103;
    L18:
        if (r102 == null) goto L21;
        if (r104 == null) goto L21;
        r104.removeView(r102);
    L21:
        r101.removeAllViews();
        r101.setGravity(17);
        r101.setOrientation(1);
        Context r105 = r101.getContext();
        if ((r102 instanceof BearLottieView) == false) goto L24;
        BearLottieView r106 = (BearLottieView) r102;
    L25:
        if (r106 == null) goto L27;
        r106.setAnimation(R.raw.bitable_app_loading_anim);
        r106.setRepeatCount(-1);
        r106.playAnimation();
        int r107 = UIHelper.dp2px(50.0f);
        LinearLayout.LayoutParams r108 = new LinearLayout.LayoutParams(r107, r107);
        r108.gravity = 1;
        r101.addView(r106, r108);
        this.f530047n = r106;
    L27:
        FrameLayout r109 = new FrameLayout(r105);
        int r110 = UIHelper.dp2px(180.0f);
        int r111 = UIHelper.dp2px(5.0f);
        float r112 = UIHelper.dp2px(2.5f);
        int r113 = ContextCompat.getColor(r105, R.color.ud_N900_15);
        int r114 = ContextCompat.getColor(r105, R.color.icon_n1);
        View r115 = new View(r105);
        GradientDrawable r116 = new GradientDrawable();
        r116.setShape(0);
        r116.setCornerRadius(r112);
        r116.setColor(r113);
        r115.setBackground(r116);
        View r117 = new View(r105);
        GradientDrawable r118 = new GradientDrawable();
        r118.setShape(0);
        r118.setCornerRadius(r112);
        r118.setColor(r114);
        r117.setBackground(r118);
        r117.setScaleX(0.0f);
        r117.setPivotX(0.0f);
        FrameLayout.LayoutParams r119 = new FrameLayout.LayoutParams(r110, r111);
        r109.addView(r115, r119);
        r109.addView(r117, r119);
        LinearLayout.LayoutParams r120 = new LinearLayout.LayoutParams(r110, r111);
        r120.gravity = 1;
        r120.topMargin = UIHelper.dp2px(14.0f);
        r101.addView(r109, r120);
        r101.addView(new View(r105), new LinearLayout.LayoutParams(-1, UIHelper.dp2px(80.0f)));
        this.f530048o = r117;
        this.f530046m = true;
    L31:
        View r121 = this.f530048o;
        if (r121 == null) goto L39;
        AnimatorSet r122 = this.f530049p;
        if (r122 == null) goto L37;
        r122.cancel();
    L37:
        this.f530049p = null;
        r121.setScaleX(0.0f);
        r121.setPivotX(0.0f);
        r121.post(new a(r121));
        PathInterpolator r123 = new PathInterpolator(0.0f, 0.0f, 0.58f, 1.0f);
        ObjectAnimator r124 = ObjectAnimator.ofFloat(r121, View.SCALE_X, new float[]{0.0f, 0.86f});
        r124.setDuration(600);
        r124.setInterpolator(r123);
        ObjectAnimator r125 = ObjectAnimator.ofFloat(r121, View.SCALE_X, new float[]{0.86f, 0.99f});
        r125.setDuration(2000);
        r125.setInterpolator(r123);
        AnimatorSet r126 = new AnimatorSet();
        r126.playSequentially(new Animator[]{r124, r125});
        r126.start();
        this.f530049p = r126;
        return;
    L39:
        return;
    L24:
        r106 = null;
        goto L25
    L17:
        r104 = null;
        goto L18
    L13:
        r103 = null;
        goto L15
    L28:
        BearLottieView r127 = this.f530047n;
        if (r127 == null) goto L31;
        r127.setAnimation(R.raw.bitable_app_loading_anim);
        r127.setRepeatCount(-1);
        r127.playAnimation();
        goto L31
    }

    public b(View r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
        Intrinsics.checkNotNullParameter(r101, "fileType");
        super(r100, false, r101);
    }
}
