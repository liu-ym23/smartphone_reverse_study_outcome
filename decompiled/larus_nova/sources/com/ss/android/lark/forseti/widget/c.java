package com.ss.android.lark.forseti.widget;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class c implements OnApplyWindowInsetsListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ForsetiNormalChainDraggingView f424740a;

    public c(ForsetiNormalChainDraggingView r100) {
        this.f424740a = r100;
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public final WindowInsetsCompat onApplyWindowInsets(View r100, WindowInsetsCompat r101) {
        Intrinsics.checkNotNullParameter(r100, "<unused var>");
        Intrinsics.checkNotNullParameter(r101, "insets");
        boolean r102 = r101.isVisible(WindowInsetsCompat.Type.ime());
        if (this.f424740a.f424652e == r102) goto L9;
        Log.i("ForsetiNormalChainDraggingView", "setKeyboardStateListener: isKeyboardVisible = " + r102);
        ForsetiNormalChainDraggingView r103 = this.f424740a;
        r103.f424652e = r102;
        r103.getDraggingHelper().f424584d = r102;
        this.f424740a.invalidate();
        if (r102 == false) goto L7;
        float r104 = ((this.f424740a.getMeasuredHeight() - this.f424740a.getDraggingHelper().f424592l) / 2.0f) - (this.f424740a.getMeasuredHeight() - this.f424740a.getDraggingHelper().f424602v);
    L8:
        ForsetiNormalChainDraggingView r105 = this.f424740a;
        float r106 = r105.f424653f;
        r105.getClass();
        ValueAnimator r107 = ValueAnimator.ofFloat(new float[]{r106, r104});
        r107.setDuration(300);
        r107.setInterpolator(new AccelerateDecelerateInterpolator());
        r107.addUpdateListener(new b(r105));
        r107.start();
        goto L9
    L7:
        r104 = 0.0f;
    L9:
        return r101;
    }
}
