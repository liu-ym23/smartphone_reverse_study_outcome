package com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog;

import android.animation.ObjectAnimator;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment;
import com.google.android.material.internal.AosBottomSheetBehavior;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class n {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f196901i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AosBaseFragment<?> f196902a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AosBottomSheetBehavior<FrameLayout> f196903b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public FrameLayout f196904c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FrameLayout f196905d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f196906e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a0 f196907f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f196908g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f196909h;

    public static final class a {
    }

    static {
    }

    public n() {
        this.f196906e = true;
        this.f196908g = -1;
    }

    public final void c(View r100) {
        ObjectAnimator r101 = ObjectAnimator.ofFloat(r100, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{r100.getMeasuredHeight(), 0.0f});
        r101.setDuration(300);
        r101.start();
        a0 r102 = this.f196907f;
        if (r102 == null) goto L6;
        r102.onOpen();
        return;
    }

    public final void b(final FragmentActivity r100, final AosBaseFragment<?> r101) {
        Intrinsics.checkNotNullParameter(r101, "aosBaseFragment");
        FrameLayout r102 = this.f196905d;
        if (r102 == null) goto L6;
        r102.post(new l(this, r100, r101));
        return;
    }

    public static final void a(n r100, FragmentActivity r101, AosBaseFragment r102) {
        if (r101 != null) goto L4;
        r100.getClass();
        return;
    L4:
        if (r100.f196906e == false) goto L6;
        r100.f196908g = 2;
        r101.getSupportFragmentManager().beginTransaction().remove(r102).commitAllowingStateLoss();
    L7:
        a0 r103 = r100.f196907f;
        if (r103 == null) goto L12;
        r103.onClose();
        return;
    L12:
        return;
    L6:
        r100.f196908g = 3;
        r101.getSupportFragmentManager().beginTransaction().hide(r102).commitAllowingStateLoss();
        goto L7
    }
}
