package com.bytedance.awemeopen.apps.framework.profile.presenter;

import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DampScrollableLayout;
import com.bytedance.awemeopen.bizmodels.profile.User;
import com.bytedance.awemeopen.infra.base.image.AoImageView;
import com.bytedance.awemeopen.infra.base.settings.AoSettings;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b extends f04.a<Unit> {
    public final com.bytedance.awemeopen.apps.framework.profile.m d;
    public final AoImageView e;
    public final FrameLayout f;
    public final DampScrollableLayout g;
    public final View h;
    public final com.bytedance.awemeopen.apps.framework.base.view.a i;
    public User j;
    public final com.bytedance.awemeopen.apps.framework.profile.presenter.a k;
    public final float l;
    public final a m;

    public static final class a implements DampScrollableLayout.d {
        public final /* synthetic */ b a;

        @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DampScrollableLayout.d
        public final boolean c() {
            return false;
        }

        @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DampScrollableLayout.d
        public final void d() {
        }

        public a(b r1) {
            this.a = r1;
        }

        @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DampScrollableLayout.d
        public final void e(int r4) {
            b r0 = this.a;
            if (r4 > 0) goto L5;
            float r2 = r0.l;
            float r1 = ((-r4) + r2) / r2;
            r0.f.setScaleX(r1);
            r0.f.setScaleY(r1);
            r0.f.setTranslationY((-r4) / 2);
            return;
        L5:
            r0.getClass();
        }
    }

    @Override // f04.a
    public final void k() {
        this.g.e(this.m);
        this.d.b.getServerUserInfo().removeObserver(this.k);
    }

    public final String m() {
        JSONObject r0 = AoSettings.a("ao_resource_config");
        if (r0 != null) goto L5;
        return null;
    L5:
        if (com.bytedance.awemeopen.apps.framework.utils.n0.d(getContext()) == false) goto L7;
        String r1 = "user_profile_banner_cover_dark";
    L11:
        return r0.optString(r1);
    L7:
        r1 = "user_profile_banner_cover_light";
        goto L11
    }

    /* JADX WARN: Type inference failed for: r3v13, types: [com.bytedance.awemeopen.apps.framework.profile.presenter.a] */
    public b(com.bytedance.awemeopen.apps.framework.profile.m r3) {
        Intrinsics.checkNotNullParameter(r3, "pgParameters");
        super(r3.a);
        this.d = r3;
        this.e = i(2131383274);
        this.f = (FrameLayout) i(2131374279);
        this.g = (DampScrollableLayout) i(2131385230);
        this.h = i(2131383204);
        this.i = new com.bytedance.awemeopen.apps.framework.base.view.a(getContext().getResources().getColor(2131100311), 0.6f);
        this.k = new com.bytedance.awemeopen.apps.framework.profile.presenter.a(this);
        Resources r0 = Resources.getSystem();
        this.l = TypedValue.applyDimension(1, 162, WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()));
        this.m = new a(this);
    }

    @Override // f04.a
    public final void j(Unit r3) {
        Intrinsics.checkNotNullParameter(r3, "unit");
        this.g.d(this.m);
        this.h.setBackground(this.i);
        this.d.b.getServerUserInfo().observe(this.d.c, this.k);
    }
}
