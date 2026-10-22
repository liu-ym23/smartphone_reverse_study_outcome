package rz1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.view.View;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.revenue.common.RevBitmapTranslateUtils;
import com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.GiftIconMaskView;
import com.bytedance.common.utility.UIUtils;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AnimatorSet f539954a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AnimatorSet f539955b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final GiftIconMaskView f539956c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f539957d;

    public static final class a {
    }

    /* JADX INFO: renamed from: rz1.b$b, reason: collision with other inner class name */
    public static final class C7549b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f539958a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0 f539959b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            b r101 = this.f539958a;
            r101.f539956c.setRepeatCount(1);
            r101.f539956c.setShaderMode(1);
            r101.f539956c.b();
            r101.f539956c.setOnShaderAinmatorListener(new d(r101));
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f539958a.f539956c.setVisibility(0);
            this.f539958a.f539957d.setVisibility(4);
            Function0 r101 = this.f539959b;
            if (r101 == null) goto L6;
            r101.invoke();
            return;
        }

        public C7549b(b r100, Function0 r101) {
            this.f539958a = r100;
            this.f539959b = r101;
        }
    }

    static {
    }

    public final void b() {
        AnimatorSet r100 = this.f539954a;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        AnimatorSet r101 = this.f539954a;
        if (r101 == null) goto L8;
        r101.removeAllListeners();
    L8:
        this.f539956c.c();
        AnimatorSet r102 = this.f539955b;
        if (r102 == null) goto L11;
        r102.cancel();
    L11:
        AnimatorSet r103 = this.f539955b;
        if (r103 == null) goto L15;
        r103.removeAllListeners();
        return;
    }

    public final void a(Bitmap r100) {
        Intrinsics.checkNotNullParameter(r100, SimplayerImageStrategy.RESULT_BITMAP);
        float r101 = UIUtils.dip2Px(this.f539956c.getContext(), 52.0f);
        Bitmap r102 = RevBitmapTranslateUtils.a(r100);
        int r103 = (int) r101;
        if (r102 != null) goto L11;
    L7:
        Bitmap r104 = null;
    L8:
        this.f539956c.a(r104);
        return;
    L11:
        int r105 = r102.getWidth();     // Catch: OutOfMemoryError -> L10
        int r106 = r102.getHeight();     // Catch: OutOfMemoryError -> L10
        float r107 = r103;
        Matrix r108 = new Matrix();     // Catch: OutOfMemoryError -> L10
        r108.postScale(r107 / r105, r107 / r106);     // Catch: OutOfMemoryError -> L10
        r104 = Bitmap.createBitmap(r102, 0, 0, r105, r106, r108, true);     // Catch: OutOfMemoryError -> L10
        goto L8
    }

    public final void c(Function0<Unit> r100) {
        if (this.f539954a != null) goto L5;
        this.f539954a = new AnimatorSet();
    L5:
        AnimatorSet r101 = this.f539954a;
        if (r101 == null) goto L9;
        r101.cancel();
        r101.removeAllListeners();
        ObjectAnimator r102 = ObjectAnimator.ofFloat(this.f539956c, LiveDegradeFpsAnimator.SCALE_X, new float[]{1.0f, 1.12f});
        ObjectAnimator r103 = ObjectAnimator.ofFloat(this.f539956c, LiveDegradeFpsAnimator.SCALE_Y, new float[]{1.0f, 1.12f});
        r101.play(r102).with(r103);
        r101.setDuration(200);
        r101.addListener(new C7549b(this, r100));
        r101.start();
        return;
    }

    public b(GiftIconMaskView r100, HSImageView r101) {
        Intrinsics.checkNotNullParameter(r100, "giftIconMaskView");
        Intrinsics.checkNotNullParameter(r101, "giftImageIcon");
        this.f539956c = r100;
        this.f539957d = r101;
    }
}
