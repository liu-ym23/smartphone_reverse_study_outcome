package com.bytedance.awemeopen.apps.framework.profile.presenter;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import com.bytedance.awemeopen.bizmodels.profile.User;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class k0 extends f04.a<Unit> {
    public final com.bytedance.awemeopen.apps.framework.profile.m d;
    public final HorizontalScrollView e;
    public final LinearLayout f;
    public final int g;
    public final int h;
    public User i;
    public final j0 j;

    @Override // f04.a
    public final void k() {
        this.d.b.getServerUserInfo().removeObserver(this.j);
    }

    /* JADX WARN: Type inference failed for: r3v15, types: [com.bytedance.awemeopen.apps.framework.profile.presenter.j0] */
    public k0(com.bytedance.awemeopen.apps.framework.profile.m r3) {
        Intrinsics.checkNotNullParameter(r3, "pgParameters");
        super(r3.a);
        this.d = r3;
        this.e = (HorizontalScrollView) i(2131392070);
        this.f = (LinearLayout) i(2131392069);
        this.g = MathKt.roundToInt(TypedValue.applyDimension(1, 5, m(Resources.getSystem())));
        this.h = MathKt.roundToInt(TypedValue.applyDimension(1, 3, m(Resources.getSystem())));
        this.j = new j0(this);
    }

    public static DisplayMetrics m(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    @Override // f04.a
    public final void j(Unit r3) {
        Intrinsics.checkNotNullParameter(r3, "unit");
        this.d.b.getServerUserInfo().observe(this.d.c, this.j);
    }
}
