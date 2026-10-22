package com.bytedance.awemeopen.apps.framework.landscape;

import android.app.Activity;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.awemeopen.apps.framework.AosExtConfig;
import com.bytedance.awemeopen.apps.framework.card.video.VideoCardPlayerViewModel;
import com.bytedance.awemeopen.apps.framework.card.video.VideoCardPreRender;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.p;
import com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.SingleVideoSeekBarHelper;
import com.bytedance.awemeopen.apps.framework.utils.reporter.HostCommonParamProvider;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class LandscapeVideoItemView implements p44.b {
    public final Activity a;
    public final ViewGroup b;
    public final l54.a c;
    public final com.bytedance.awemeopen.apps.framework.card.video.a d;
    public final com.bytedance.awemeopen.apps.framework.card.video.a e;
    public String f;
    public final VideoCardPlayerViewModel g;
    public final com.bytedance.awemeopen.apps.framework.card.video.j h;
    public final SingleVideoSeekBarHelper i;
    public final View j;
    public final com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.c k;
    public final VideoCardPreRender l;
    public final l m;
    public final d n;
    public final HostCommonParamProvider o;
    public final h p;
    public r14.c q;

    public static final class a {
    }

    public static final class b implements com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.d.a {
        public final /* synthetic */ LandscapeVideoItemView a;

        @Override // com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.d.a
        public final void onProgressChanged(int r1) {
        }

        @Override // com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.d.a
        public final void a() {
            c04.i.a(this.a.m.j.u);
        }

        public b(LandscapeVideoItemView r1) {
            this.a = r1;
        }

        @Override // com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.d.a
        public final void b(SeekBar r3, boolean r4) {
            m r5 = this.a.m.j.u;
            c04.i.b();
            Handler r6 = c04.i.b;
            if (r6 == null) goto L6;
            r6.postDelayed(r5, 5000);
            return;
        }
    }

    public static final class c implements View.OnLayoutChangeListener {
        public final /* synthetic */ LandscapeVideoItemView a;
        public final /* synthetic */ r14.c b;
        public final /* synthetic */ int c;

        public c(LandscapeVideoItemView r1, r14.c r2, int r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            AoLogger.b("LandscapeVideoItemView", new Object[]{this.a.f + " parentView onLayoutChange " + this.a.d()});
            if (this.a.d() == false) goto L6;
            this.a.b.removeOnLayoutChangeListener(this);
            LandscapeVideoItemView.a(this.a, this.b, this.c);
            return;
        }
    }

    public static final class d implements com.bytedance.awemeopen.infra.base.player.k {
        public final /* synthetic */ LandscapeVideoItemView a;

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

        public d(LandscapeVideoItemView r1) {
            this.a = r1;
        }

        public final void l(String r1, com.bytedance.awemeopen.infra.base.player.l r2) {
            Intrinsics.checkNotNullParameter(r2, "playerStatusInfo");
        }

        public final void g(String r3, boolean r4, String r5) {
            AoLogger.b("LandscapeVideoItemView", new Object[]{this.a.f + " onRenderFirstFrame " + this.a.f + " sourceId = " + r3 + ", event = " + r5});
        }
    }

    static {
    }

    public final boolean d() {
        if (this.b.getMeasuredWidth() > 0) goto L5;
    L7:
        return false;
    L5:
        if (this.b.getMeasuredHeight() <= 0) goto L7;
        return true;
    }

    public final void e() {
        d14.a r0 = b14.a.a;
        b14.a.a(t24.a.class).H1(this.o);
        b14.a.a(t24.a.class).H1(this.p);
        if (this.d.a() == false) goto L6;
        this.d.b();
        this.m.i();
    L8:
        boolean r1 = true;
        this.l.c = true;
        if (this.g.getFeedPlayerHelper().a != null) goto L12;
        r1 = false;
    L12:
        if (r1 == true) goto L14;
        return;
    L14:
        if (Intrinsics.areEqual(g.d, Boolean.FALSE) == true) goto L18;
        this.g.getFeedPlayerHelper().playPlayer();
        return;
    L18:
        return;
    L6:
        if (this.e.a() == false) goto L8;
        this.e.b();
        goto L8
    }

    public final void b(r14.c r4, int r5) {
        AoLogger.b("LandscapeVideoItemView", new Object[]{this.f + " doBind"});
        this.q = r4;
        this.d.b();
        if (this.j.getParent() != null) goto L5;
        this.b.addView(this.j, 0);
    L5:
        this.i.i(r4);
        this.i.e();
        this.h.c = this.i;
        this.m.c(new jz3.a(r4, null, 12), r5);
        this.i.addSeekBarChangeListener(new b(this));
    }

    public final void c(r14.c r4, int r5) {
        AoLogger.b("LandscapeVideoItemView", new Object[]{this.f + " ensureParentSize"});
        this.b.addOnLayoutChangeListener(new c(this, r4, r5));
    }

    public static final void a(LandscapeVideoItemView r5, r14.c r6, int r7) {
        r5.getClass();
        boolean r0 = true;
        AoLogger.b("LandscapeVideoItemView", new Object[]{r5.f + " resumePendingState " + r5.e});
        com.bytedance.awemeopen.apps.framework.card.video.a r1 = r5.e;
        if (r1.a == 2) goto L6;
        r0 = false;
    L6:
        if (r0 == false) goto L9;
        r5.b(r6, r7);
        r5.e();
    L11:
        r5.e.a = 0;
        return;
    L9:
        if (r1.a() == false) goto L11;
        r5.b(r6, r7);
        goto L11
    }

    /* JADX WARN: Type inference failed for: r2v18, types: [com.bytedance.awemeopen.apps.framework.landscape.h] */
    public LandscapeVideoItemView(String r19, Activity r20, ViewGroup r21, l54.a r22) {
        Intrinsics.checkNotNullParameter(r19, "aid");
        Intrinsics.checkNotNullParameter(r20, "activity");
        Intrinsics.checkNotNullParameter(r21, "rootView");
        Intrinsics.checkNotNullParameter(r22, "videoCardConfig");
        this.a = r20;
        this.b = r21;
        this.c = r22;
        this.d = new com.bytedance.awemeopen.apps.framework.card.video.a();
        this.e = new com.bytedance.awemeopen.apps.framework.card.video.a();
        this.f = "";
        VideoCardPlayerViewModel r12 = new VideoCardPlayerViewModel(g.a(r19));
        this.g = r12;
        com.bytedance.awemeopen.apps.framework.card.video.j r13 = new com.bytedance.awemeopen.apps.framework.card.video.j(r22, r12);
        this.h = r13;
        Intrinsics.checkNotNullParameter(r13.getPlayer(), "player");
        SingleVideoSeekBarHelper r14 = new SingleVideoSeekBarHelper(new WeakReference(this.a), r13.a(), true, 8);
        this.i = r14;
        LayoutInflater r1 = LayoutInflater.from(r20);
        int r2 = l.k;
        View r15 = r1.inflate(2131558709, null);
        this.j = r15;
        Intrinsics.checkNotNull(r20, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        Intrinsics.checkNotNull(r20, "null cannot be cast to non-null type androidx.lifecycle.ViewModelStoreOwner");
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.c r9 = new com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.c(r15, r21, r13, r20, new com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b(r20, r21, r21, (LifecycleOwner) r20, (ViewModelStoreOwner) r20, null, 0, 224), AosExtConfig.b.p2(), LandscapeVideoItemView$parameters$1.INSTANCE);
        this.k = r9;
        VideoCardPreRender r3 = new VideoCardPreRender(r12.getFeedPlayerHelper().e());
        this.l = r3;
        l r4 = new l(r9, new p(), r3);
        this.m = r4;
        this.n = new d(this);
        this.o = new HostCommonParamProvider(r13.a.g.getHostCommonParams());
        this.p = new h(this);
        r14.h(r4.j.q, r9.e.h);
    }
}
