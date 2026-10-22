package ff3;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.LottieAnimationView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f476659a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f476660b;

    @Override // ff3.b
    public final View Q1() {
        View r100 = this.f476659a;
        if (r100 == null) goto L9;
        ViewParent r101 = r100.getParent();
        if (r101 == null) goto L9;
        if ((r101 instanceof ViewGroup) == false) goto L9;
        ((ViewGroup) r101).removeView(this.f476659a);
    L9:
        View r102 = this.f476659a;
        this.f476659a = null;
        return r102;
    }

    public a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "vhView");
        this.f476660b = r100;
    }

    @Override // ff3.b
    public final void s3(LottieAnimationView r100, FrameLayout.LayoutParams r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "lp");
        Q1();
        this.f476659a = r100;
        View r102 = this.f476660b;
        if ((r102 instanceof ViewGroup) == true) goto L5;
        r102 = null;
    L5:
        ViewGroup r103 = (ViewGroup) r102;
        if ((r103 instanceof ConstraintLayout) == false) goto L29;
        ConstraintLayout r104 = (ConstraintLayout) r103;
        ConstraintLayout.LayoutParams r105 = new ConstraintLayout.LayoutParams(r101.width, r101.height);
        r105.setMargins(r101.leftMargin, r101.topMargin, r101.rightMargin, r101.bottomMargin);
        int r106 = r101.gravity;
        int r107 = r106 & 7;
        if (r107 != 1) goto L10;
        r105.leftToLeft = 0;
        r105.rightToRight = 0;
    L17:
        int r108 = r106 & 112;
        if (r108 != 16) goto L20;
        r105.topToTop = 0;
        r105.bottomToBottom = 0;
    L27:
        r104.addView(r100, r105);
        goto L29
    L20:
        if (r108 != 48) goto L22;
        r105.topToTop = 0;
        goto L27
    L22:
        if (r108 != 80) goto L27;
        r105.bottomToBottom = 0;
        goto L27
    L10:
        if (r107 != 3) goto L12;
        r105.leftToLeft = 0;
        goto L17
    L12:
        if (r107 != 5) goto L17;
        r105.rightToRight = 0;
    L29:
        if ((r103 instanceof FrameLayout) == false) goto L32;
        ((FrameLayout) r103).addView(r100, r101);
        return;
    }
}
