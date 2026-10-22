package fy3;

import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DampScrollableLayout;
import com.bytedance.awemeopen.bizmodels.profile.User;
import com.bytedance.awemeopen.infra.base.image.AoImageView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b extends f04.a<Unit> {
    public final com.bytedance.awemeopen.apps.framework.collect.i d;
    public final AoImageView e;
    public final FrameLayout f;
    public final DampScrollableLayout g;
    public final View h;
    public final com.bytedance.awemeopen.apps.framework.base.view.a i;
    public User j;
    public final fy3.a k;
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

    /* JADX WARN: Type inference failed for: r3v13, types: [fy3.a] */
    public b(com.bytedance.awemeopen.apps.framework.collect.i r3) {
        Intrinsics.checkNotNullParameter(r3, "pgParameters");
        super(r3.a);
        this.d = r3;
        this.e = i(2131367158);
        this.f = (FrameLayout) i(2131374279);
        this.g = (DampScrollableLayout) i(2131385230);
        this.h = i(2131367136);
        this.i = new com.bytedance.awemeopen.apps.framework.base.view.a(getContext().getResources().getColor(2131100311), 1.0f);
        this.k = new fy3.a(this);
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
