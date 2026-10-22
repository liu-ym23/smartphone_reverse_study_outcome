package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter;

import android.content.res.Resources;
import android.util.TypedValue;
import com.bytedance.awemeopen.apps.framework.player.FullVideoView;
import com.bytedance.awemeopen.bizmodels.feed.Video;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class i extends g04.a<jz3.a> {
    public final com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a e;
    public final FullVideoView f;
    public final b g;
    public final int h;
    public jz3.a i;

    public static final class a {
    }

    public static final class b implements com.bytedance.awemeopen.infra.base.player.k {
        public final /* synthetic */ i a;

        public final void c(String r1) {
        }

        public final void d(String r1, long r2, int r4) {
        }

        public final void e(String r1, int r2, String r3) {
        }

        public final void f(String r1, boolean r2, int r3, int r4) {
        }

        public final void h(String r1) {
        }

        public final void onPlayPrepare(String r1) {
        }

        public final void onPlaying(String r1) {
        }

        public b(i r1) {
            this.a = r1;
        }

        public final void l(String r1, com.bytedance.awemeopen.infra.base.player.l r2) {
            Intrinsics.checkNotNullParameter(r2, "playerStatusInfo");
        }

        public final void g(String r1, boolean r2, String r3) {
            x54.b.b(this.a.f.getForegroundImageView());
        }
    }

    static {
    }

    @Override // g04.a
    public final void g() {
        this.e.c.addPlayStateListener(this.g);
    }

    @Override // g04.a
    public final void i() {
        this.e.c.removePlayStateListener(this.g);
        m();
    }

    public final void m() {
        x54.b.d(this.f.getForegroundImageView());
        jz3.a r0 = this.i;
        List<String> r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("data");
        r0 = null;
    L5:
        Video r1 = r0.a.P();
        if (r1 == null) goto L50;
        r14.j0 r4 = r1.getPlayAddr();
        boolean r5 = true;
        if (r4 == null) goto L12;
        List r6 = r4.g();
        if (r6 == null) goto L12;
        boolean r7 = !r6.isEmpty();
    L13:
        if (r7 == false) goto L50;
        if (com.bytedance.awemeopen.apps.framework.utils.f.a(r1.getOriginCover()) == false) goto L50;
        if (r1.getHeight() >= this.h) goto L19;
        this.f.getForegroundImageView().setBackgroundResource(2131231413);
    L20:
        int r3 = com.bytedance.awemeopen.bizmodels.user.d.a;
        jz3.a r8 = this.i;
        if (r8 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("data");
        r8 = null;
    L23:
        r14.c r9 = r8.a;
        d14.a r10 = b14.a.a;
        com.bytedance.awemeopen.bizmodels.user.c r11 = b14.a.a(k34.b.class).getAccessToken();
        if (r11 == null) goto L27;
        String r12 = r11.b;
        if (r12 == null) goto L27;
    L28:
        Intrinsics.checkNotNullParameter(r12, "openId");
        if (r9 != null) goto L31;
    L35:
        r5 = false;
    L36:
        if (r5 == false) goto L39;
        this.f.getForegroundImageView().setImageResource(2131231542);
        return;
    L39:
        jz3.a r13 = this.i;
        if (r13 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("data");
        r13 = null;
    L42:
        Video r14 = r13.a.P();
        if (r14 == null) goto L48;
        t14.a r15 = r14.getOriginCover();
        if (r15 == null) goto L47;
        r2 = r15.g();
    L47:
        if (r2 == null) goto L48;
    L49:
        this.f.setForegroundUrl(r2);
        return;
    L48:
        r2 = new ArrayList();
        goto L49
    L31:
        if (com.bytedance.awemeopen.bizmodels.user.d.c(r9, r12) == false) goto L35;
        if (r9.Z() == false) goto L35;
    L27:
        r12 = "";
        goto L28
    L19:
        this.f.getForegroundImageView().setBackgroundResource(2131231414);
    L12:
        r7 = false;
    L50:
        this.f.getForegroundImageView().setImageResource(2131231542);
    }

    public i(com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r3) {
        Intrinsics.checkNotNullParameter(r3, "feedGroupParameters");
        super(r3.a);
        this.e = r3;
        this.f = (FullVideoView) e(2131375746);
        this.g = new b(this);
        Resources r0 = Resources.getSystem();
        this.h = MathKt.roundToInt(TypedValue.applyDimension(1, 300, WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics())));
    }

    @Override // g04.a
    public final void f(jz3.a r2) {
        jz3.a r3 = r2;
        Intrinsics.checkNotNullParameter(r3, "data");
        this.i = r3;
        m();
    }
}
