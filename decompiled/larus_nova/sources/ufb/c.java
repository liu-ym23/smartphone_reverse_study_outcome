package ufb;

import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.view.View;
import android.view.WindowManager;
import com.ss.android.lark.floating.widget.appfloat.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class c implements wfb.b {
    public c() {
    }

    public static int c(View r100, h r101) {
        int r102 = xfb.d.f563555a;
        Rect r103 = xfb.d.c(r100.getContext());
        int r104 = ((WindowManager.LayoutParams) r101.f421955a).x;
        if (r104 >= (r103.right - (r100.getRight() + r104))) goto L6;
        return -r100.getRight();
    L6:
        return r103.right;
    }

    @Override // wfb.b
    public final ValueAnimator b(View r100, h r101, WindowManager r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "windowManager");
        ValueAnimator r103 = ValueAnimator.ofInt(new int[]{((WindowManager.LayoutParams) r101.f421955a).x, c(r100, r101)});
        r103.addUpdateListener(new b(r101, r102, r100));
        return r103;
    }

    @Override // wfb.b
    public final ValueAnimator a(View r100, h r101, WindowManager r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "windowManager");
        int r104 = c(r100, r101);
        int r105 = ((WindowManager.LayoutParams) r101.f421955a).x;
        if (r105 <= 0) goto L5;
        int r106 = r105 + r103;
    L6:
        ValueAnimator r107 = ValueAnimator.ofInt(new int[]{r104, r106});
        r107.setDuration(500);
        r107.addUpdateListener(new a(r101, r102, r100));
        return r107;
    L5:
        r106 = r105 - r103;
        goto L6
    }
}
