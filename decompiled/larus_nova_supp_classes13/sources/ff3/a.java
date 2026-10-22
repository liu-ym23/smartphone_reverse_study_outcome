package ff3;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements b {
    public View a;
    public final View b;

    @Override // ff3.b
    public final View Q1() {
        View r0 = this.a;
        if (r0 == null) goto L9;
        ViewParent r1 = r0.getParent();
        if (r1 == null) goto L9;
        if ((r1 instanceof ViewGroup) == false) goto L9;
        ((ViewGroup) r1).removeView(this.a);
    L9:
        View r2 = this.a;
        this.a = null;
        return r2;
    }

    public a(View r2) {
        Intrinsics.checkNotNullParameter(r2, "vhView");
        this.b = r2;
    }

    @Override // ff3.b
    public final void s3(LottieAnimationView r8, FrameLayout.LayoutParams r9) {
        Intrinsics.checkNotNullParameter(r8, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r9, "lp");
        Q1();
        this.a = r8;
        ConstraintLayout r0 = this.b;
        if ((r0 instanceof ViewGroup) == true) goto L5;
        r0 = null;
    L5:
        ConstraintLayout r1 = (ViewGroup) r0;
        if ((r1 instanceof ConstraintLayout) == false) goto L29;
        ConstraintLayout r2 = r1;
        ConstraintLayout.LayoutParams r3 = new ConstraintLayout.LayoutParams(r9.width, r9.height);
        r3.setMargins(r9.leftMargin, r9.topMargin, r9.rightMargin, r9.bottomMargin);
        int r4 = r9.gravity;
        int r5 = r4 & 7;
        if (r5 != 1) goto L10;
        r3.leftToLeft = 0;
        r3.rightToRight = 0;
    L17:
        int r6 = r4 & 112;
        if (r6 != 16) goto L20;
        r3.topToTop = 0;
        r3.bottomToBottom = 0;
    L27:
        r2.addView(r8, r3);
        goto L29
    L20:
        if (r6 != 48) goto L22;
        r3.topToTop = 0;
        goto L27
    L22:
        if (r6 != 80) goto L27;
        r3.bottomToBottom = 0;
        goto L27
    L10:
        if (r5 != 3) goto L12;
        r3.leftToLeft = 0;
        goto L17
    L12:
        if (r5 != 5) goto L17;
        r3.rightToRight = 0;
    L29:
        if ((r1 instanceof FrameLayout) == false) goto L32;
        ((FrameLayout) r1).addView(r8, r9);
        return;
    }
}
