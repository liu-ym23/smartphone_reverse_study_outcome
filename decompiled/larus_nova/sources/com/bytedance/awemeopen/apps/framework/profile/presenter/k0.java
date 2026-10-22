package com.bytedance.awemeopen.apps.framework.profile.presenter;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import com.bytedance.awemeopen.bizmodels.profile.User;
import com.bytedance.crash.dumper.Scraps;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes14.dex */
public final class k0 extends f04.a<Unit> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.awemeopen.apps.framework.profile.m f197459d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HorizontalScrollView f197460e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LinearLayout f197461f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f197462g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f197463h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public User f197464i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final j0 f197465j;

    @Override // f04.a
    public final void k() {
        this.f197459d.f197362b.getServerUserInfo().removeObserver(this.f197465j);
    }

    /* JADX WARN: Type inference failed for: r3v15, types: [com.bytedance.awemeopen.apps.framework.profile.presenter.j0] */
    public k0(com.bytedance.awemeopen.apps.framework.profile.m r100) {
        Intrinsics.checkNotNullParameter(r100, "pgParameters");
        super(r100.f197361a);
        this.f197459d = r100;
        this.f197460e = (HorizontalScrollView) i(R.id.user_tags_sl);
        this.f197461f = (LinearLayout) i(R.id.user_tags_ll);
        this.f197462g = MathKt.roundToInt(TypedValue.applyDimension(1, 5, m(Resources.getSystem())));
        this.f197463h = MathKt.roundToInt(TypedValue.applyDimension(1, 3, m(Resources.getSystem())));
        this.f197465j = new j0(this);
    }

    public static DisplayMetrics m(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    @Override // f04.a
    public final void j(Unit r100) {
        Intrinsics.checkNotNullParameter(r100, Scraps.INNER_UNIT);
        this.f197459d.f197362b.getServerUserInfo().observe(this.f197459d.f197363c, this.f197465j);
    }
}
