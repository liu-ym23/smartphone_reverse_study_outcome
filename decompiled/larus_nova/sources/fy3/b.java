package fy3;

import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DampScrollableLayout;
import com.bytedance.awemeopen.bizmodels.profile.User;
import com.bytedance.awemeopen.infra.base.image.AoImageView;
import com.bytedance.crash.dumper.Scraps;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class b extends f04.a<Unit> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.awemeopen.apps.framework.collect.i f479237d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AoImageView f479238e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final FrameLayout f479239f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final DampScrollableLayout f479240g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final View f479241h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.bytedance.awemeopen.apps.framework.base.view.a f479242i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public User f479243j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final fy3.a f479244k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final float f479245l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final a f479246m;

    public static final class a implements DampScrollableLayout.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f479247a;

        @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DampScrollableLayout.d
        public final boolean c() {
            return false;
        }

        @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DampScrollableLayout.d
        public final void d() {
        }

        public a(b r100) {
            this.f479247a = r100;
        }

        @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DampScrollableLayout.d
        public final void e(int r100) {
            b r101 = this.f479247a;
            if (r100 > 0) goto L5;
            float r102 = r101.f479245l;
            float r103 = ((-r100) + r102) / r102;
            r101.f479239f.setScaleX(r103);
            r101.f479239f.setScaleY(r103);
            r101.f479239f.setTranslationY((-r100) / 2);
            return;
        L5:
            r101.getClass();
        }
    }

    @Override // f04.a
    public final void k() {
        this.f479240g.e(this.f479246m);
        this.f479237d.f193987b.getServerUserInfo().removeObserver(this.f479244k);
    }

    /* JADX WARN: Type inference failed for: r3v13, types: [fy3.a] */
    public b(com.bytedance.awemeopen.apps.framework.collect.i r100) {
        Intrinsics.checkNotNullParameter(r100, "pgParameters");
        super(r100.f193986a);
        this.f479237d = r100;
        this.f479238e = (AoImageView) i(R.id.collect_user_bg);
        this.f479239f = (FrameLayout) i(R.id.header_background_frameLayout);
        this.f479240g = (DampScrollableLayout) i(R.id.scroll_layout);
        this.f479241h = i(R.id.collect_cover_mask);
        this.f479242i = new com.bytedance.awemeopen.apps.framework.base.view.a(getContext().getResources().getColor(R.color.aos_profile_background_mark_color_default), 1.0f);
        this.f479244k = new fy3.a(this);
        Resources r101 = Resources.getSystem();
        this.f479245l = TypedValue.applyDimension(1, 162, WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()));
        this.f479246m = new a(this);
    }

    @Override // f04.a
    public final void j(Unit r100) {
        Intrinsics.checkNotNullParameter(r100, Scraps.INNER_UNIT);
        this.f479240g.d(this.f479246m);
        this.f479241h.setBackground(this.f479242i);
        this.f479237d.f193987b.getServerUserInfo().observe(this.f479237d.f193988c, this.f479244k);
    }
}
