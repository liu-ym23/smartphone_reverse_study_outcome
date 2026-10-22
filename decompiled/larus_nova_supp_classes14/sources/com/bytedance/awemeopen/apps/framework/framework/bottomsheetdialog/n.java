package com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog;

import android.animation.ObjectAnimator;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment;
import com.google.android.material.internal.AosBottomSheetBehavior;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class n {
    public static final /* synthetic */ int i = 0;
    public AosBaseFragment<?> a;
    public AosBottomSheetBehavior<FrameLayout> b;
    public FrameLayout c;
    public FrameLayout d;
    public boolean e;
    public a0 f;
    public int g;
    public boolean h;

    public static final class a {
    }

    static {
    }

    public n() {
        this.e = true;
        this.g = -1;
    }

    public final void c(View r4) {
        ObjectAnimator r5 = ObjectAnimator.ofFloat(r4, "translationY", new float[]{r4.getMeasuredHeight(), 0.0f});
        r5.setDuration(300);
        r5.start();
        a0 r6 = this.f;
        if (r6 == null) goto L6;
        r6.onOpen();
        return;
    }

    public final void b(final FragmentActivity r3, final AosBaseFragment<?> r4) {
        Intrinsics.checkNotNullParameter(r4, "aosBaseFragment");
        FrameLayout r0 = this.d;
        if (r0 == null) goto L6;
        r0.post(new l(this, r3, r4));
        return;
    }

    public static final void a(n r1, FragmentActivity r2, AosBaseFragment r3) {
        if (r2 != null) goto L4;
        r1.getClass();
        return;
    L4:
        if (r1.e == false) goto L6;
        r1.g = 2;
        r2.getSupportFragmentManager().beginTransaction().remove(r3).commitAllowingStateLoss();
    L7:
        a0 r4 = r1.f;
        if (r4 == null) goto L12;
        r4.onClose();
        return;
    L12:
        return;
    L6:
        r1.g = 3;
        r2.getSupportFragmentManager().beginTransaction().hide(r3).commitAllowingStateLoss();
        goto L7
    }
}
