package com.bytedance.awemeopen.apps.framework.profile.presenter;

import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DampScrollableLayout;
import com.bytedance.awemeopen.bizmodels.profile.User;
import com.bytedance.awemeopen.infra.base.image.AoImageView;
import com.bytedance.awemeopen.infra.base.settings.AoSettings;
import com.bytedance.crash.dumper.Scraps;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class b extends f04.a<Unit> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.awemeopen.apps.framework.profile.m f197401d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AoImageView f197402e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final FrameLayout f197403f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final DampScrollableLayout f197404g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final View f197405h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.bytedance.awemeopen.apps.framework.base.view.a f197406i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public User f197407j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final com.bytedance.awemeopen.apps.framework.profile.presenter.a f197408k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final float f197409l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final a f197410m;

    public static final class a implements DampScrollableLayout.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f197411a;

        @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DampScrollableLayout.d
        public final boolean c() {
            return false;
        }

        @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DampScrollableLayout.d
        public final void d() {
        }

        public a(b r100) {
            this.f197411a = r100;
        }

        @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DampScrollableLayout.d
        public final void e(int r100) {
            b r101 = this.f197411a;
            if (r100 > 0) goto L5;
            float r102 = r101.f197409l;
            float r103 = ((-r100) + r102) / r102;
            r101.f197403f.setScaleX(r103);
            r101.f197403f.setScaleY(r103);
            r101.f197403f.setTranslationY((-r100) / 2);
            return;
        L5:
            r101.getClass();
        }
    }

    @Override // f04.a
    public final void k() {
        this.f197404g.e(this.f197410m);
        this.f197401d.f197362b.getServerUserInfo().removeObserver(this.f197408k);
    }

    public final String m() {
        JSONObject r100 = AoSettings.a("ao_resource_config");
        if (r100 != null) goto L5;
        return null;
    L5:
        if (com.bytedance.awemeopen.apps.framework.utils.n0.d(getContext()) == false) goto L7;
        String r101 = "user_profile_banner_cover_dark";
    L11:
        return r100.optString(r101);
    L7:
        r101 = "user_profile_banner_cover_light";
        goto L11
    }

    /* JADX WARN: Type inference failed for: r3v13, types: [com.bytedance.awemeopen.apps.framework.profile.presenter.a] */
    public b(com.bytedance.awemeopen.apps.framework.profile.m r100) {
        Intrinsics.checkNotNullParameter(r100, "pgParameters");
        super(r100.f197361a);
        this.f197401d = r100;
        this.f197402e = (AoImageView) i(R.id.profile_user_bg);
        this.f197403f = (FrameLayout) i(R.id.header_background_frameLayout);
        this.f197404g = (DampScrollableLayout) i(R.id.scroll_layout);
        this.f197405h = i(R.id.profile_cover_mask);
        this.f197406i = new com.bytedance.awemeopen.apps.framework.base.view.a(getContext().getResources().getColor(R.color.aos_profile_background_mark_color_default), 0.6f);
        this.f197408k = new com.bytedance.awemeopen.apps.framework.profile.presenter.a(this);
        Resources r101 = Resources.getSystem();
        this.f197409l = TypedValue.applyDimension(1, 162, WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()));
        this.f197410m = new a(this);
    }

    @Override // f04.a
    public final void j(Unit r100) {
        Intrinsics.checkNotNullParameter(r100, Scraps.INNER_UNIT);
        this.f197404g.d(this.f197410m);
        this.f197405h.setBackground(this.f197406i);
        this.f197401d.f197362b.getServerUserInfo().observe(this.f197401d.f197363c, this.f197408k);
    }
}
