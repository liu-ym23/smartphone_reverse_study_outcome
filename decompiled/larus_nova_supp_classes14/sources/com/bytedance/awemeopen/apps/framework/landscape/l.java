package com.bytedance.awemeopen.apps.framework.landscape;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.awemeopen.apps.framework.card.video.VideoCardPlayerViewModel;
import com.bytedance.awemeopen.apps.framework.card.video.VideoCardPreRender;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.p;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.FeedGesturePresenterConfig;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.LongPressSpeedPresenterConfig;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter.FeedLongPressFastSpeedPresenter;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter.LandscapeStatusBarPresenter;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter.VideoFeedGesturePresenter;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter.VideoFeedPlayerPresenter;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.o;
import com.bytedance.awemeopen.apps.framework.landscape.ui.AvatarElement;
import com.bytedance.awemeopen.apps.framework.utils.h0;
import com.bytedance.awemeopen.bizmodels.profile.User;
import com.bytedance.awemeopen.infra.base.anim.lottie.AoAnimationLottieView;
import com.bytedance.awemeopen.infra.base.image.AoImageView;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class l extends com.bytedance.awemeopen.apps.framework.framework.viewpager.g<jz3.a> {
    public static final /* synthetic */ int k = 0;
    public final com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a e;
    public String f;
    public final g04.b<jz3.a> g;
    public final VideoFeedPlayerPresenter h;
    public final FeedLongPressFastSpeedPresenter i;
    public final b j;

    public static final class a {
    }

    public static final class b {
        public final ViewGroup a;
        public final View b;
        public final TextView c;
        public final ViewGroup d;
        public final TextView e;
        public final AoImageView f;
        public final AoAnimationLottieView g;
        public final View h;
        public final ViewGroup i;
        public final TextView j;
        public final AppCompatImageView k;
        public final TextView l;
        public final AppCompatImageView m;
        public final TextView n;
        public final TextView o;
        public final ViewGroup p;
        public final ViewGroup q;
        public final ViewGroup r;
        public final List<View> s;
        public final List<View> t;
        public final m u;
        public int v;

        public final void a() {
            if (this.v != 0) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == true) goto L8;
            return;
        L8:
            this.v = 8;
            float r1 = com.bytedance.awemeopen.apps.framework.landscape.a.a;
            com.bytedance.awemeopen.apps.framework.landscape.a.a(this.s, this.t, this.r, true);
            return;
        L5:
            r0 = false;
            goto L6
        }

        public final void b() {
            if (this.v != 0) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L8;
            return;
        L8:
            this.v = 0;
            float r1 = com.bytedance.awemeopen.apps.framework.landscape.a.a;
            com.bytedance.awemeopen.apps.framework.landscape.a.a(this.s, this.t, this.r, false);
            c04.i.a(this.u);
            m r2 = this.u;
            c04.i.b();
            Handler r3 = c04.i.b;
            if (r3 == null) goto L12;
            r3.postDelayed(r2, 5000);
            return;
        L12:
            return;
        L5:
            r0 = false;
            goto L6
        }

        /* JADX WARN: Type inference failed for: r11v3, types: [com.bytedance.awemeopen.apps.framework.landscape.m] */
        public b(ViewGroup r11) {
            Intrinsics.checkNotNullParameter(r11, "rootView");
            this.a = r11;
            View r0 = r11.findViewById(2131377134);
            this.b = r0;
            TextView r1 = (TextView) r11.findViewById(2131391606);
            this.c = r1;
            ViewGroup r2 = (ViewGroup) r11.findViewById(2131378809);
            this.d = r2;
            this.e = (TextView) r11.findViewById(2131390995);
            this.f = r11.findViewById(2131376019);
            this.g = r11.findViewById(2131379217);
            View r3 = r11.findViewById(2131363770);
            this.h = r3;
            ViewGroup r4 = (ViewGroup) r11.findViewById(2131375550);
            this.i = r4;
            this.j = (TextView) r11.findViewById(2131390413);
            this.k = r11.findViewById(2131376304);
            this.l = (TextView) r11.findViewById(2131390412);
            this.m = r11.findViewById(2131376301);
            this.n = (TextView) r11.findViewById(2131390409);
            this.o = (TextView) r11.findViewById(2131391301);
            ViewGroup r5 = (ViewGroup) r11.findViewById(2131389132);
            this.p = r5;
            ViewGroup r6 = (ViewGroup) r11.findViewById(2131377133);
            this.q = r6;
            this.r = (ViewGroup) r11.findViewById(2131377526);
            this.s = CollectionsKt.listOf(new View[]{r0, r1, r3, r2, r11.findViewById(2131389153)});
            this.t = CollectionsKt.listOf(new View[]{r4, r5, r6, r11.findViewById(2131364465)});
            this.u = new m(this);
            this.v = 8;
        }
    }

    static {
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.g
    public final void f() {
        AoLogger.b("VideoFeedVideoViewHolder", new Object[]{"onSelected " + this.f});
        this.g.j();
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.g
    public final void g() {
        AoLogger.b("VideoFeedVideoViewHolder", new Object[]{"onUnBind " + this.f});
        this.g.k();
        c04.i.a(this.j.u);
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.g
    public final void h() {
        AoLogger.b("VideoFeedVideoViewHolder", new Object[]{"onUnSelected " + this.f});
        this.g.l();
    }

    public final void n() {
        String[] r0 = {"0.5x", "倍速", "1.5x", "2.0x"};
        String r1 = (String) ArraysKt.getOrNull(r0, (int) ((this.h.p() * 2) - 1));
        if (r1 != null) goto L5;
        r1 = r0[1];
    L5:
        this.j.o.setText(r1);
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.g
    public final void e(jz3.a r11, int r12) {
        jz3.a r13 = r11;
        Intrinsics.checkNotNullParameter(r13, "data");
        StringBuilder r14 = new StringBuilder("index:");
        r14.append(r13.d);
        r14.append("\nawemeId:");
        r14.append(r13.a.c());
        r14.append("\nuserOpenId:");
        User r0 = r13.a.f();
        Long r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.u();
    L6:
        r14.append(r2);
        r14.append("\nnickName:");
        User r3 = r13.a.f();
        if (r3 == null) goto L9;
        String r4 = r3.t();
    L10:
        r14.append(r4);
        r14.append('\n');
        this.f = r14.toString();
        boolean r15 = true;
        AoLogger.b("VideoFeedVideoViewHolder", new Object[]{"onBind " + this.f});
        this.g.b(r13);
        o r5 = this.e.c;
        if ((r5 instanceof com.bytedance.awemeopen.apps.framework.card.video.j) == false) goto L13;
        com.bytedance.awemeopen.apps.framework.card.video.j r6 = (com.bytedance.awemeopen.apps.framework.card.video.j) r5;
    L14:
        if (r6 == null) goto L20;
        VideoCardPlayerViewModel r7 = r6.b;
        if (r7 == null) goto L20;
        if (r7.isReusedPlayer() != true) goto L20;
    L21:
        if (r15 == false) goto L23;
        this.i.q();
    L23:
        this.j.a();
        TextView r16 = this.j.c;
        r14.c r8 = r13.a;
        String r9 = r8.F();
        if (r9 != null) goto L26;
    L28:
        String r10 = r8.p();
        if (h0.a(r10) == false) goto L31;
        r9 = StringsKt.replace$default(r10, '\n', ' ', false, 4, null);
    L37:
        r16.setText(r9);
        r14.c r17 = r13.a;
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r18 = this.e;
        b r19 = this.j;
        new AvatarElement(r17, r18, r19.f, r19.e, r19.g).b();
        r14.c r20 = r13.a;
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r21 = this.e;
        b r22 = this.j;
        final com.bytedance.awemeopen.apps.framework.landscape.ui.h r110 = new com.bytedance.awemeopen.apps.framework.landscape.ui.h(r20, r21, r22.k, r22.j);
        if (r110.b.c.getPageConfig().isTeenagerModel() == false) goto L40;
        Class<m34.a> r23 = m34.a.class;
    L41:
        final q24.c r24 = b14.a.a(r23);
        final Context r25 = r110.c.getContext();
        boolean r26 = r24.m3(r25, r110.a);
        r110.e = r26;
        r110.a(r26);
        final Activity r27 = r110.b.getActivity();
        if (r27 == null) goto L45;
        Object r28 = r110.d.getParent();
        Intrinsics.checkNotNull(r28, "null cannot be cast to non-null type android.view.View");
        ((View) r28).setOnClickListener(new com.bytedance.awemeopen.apps.framework.landscape.ui.g(r110, r24, r25, r27));
    L45:
        r14.c r29 = r13.a;
        Activity r30 = this.e.getActivity();
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r31 = this.e;
        final com.bytedance.awemeopen.apps.framework.landscape.ui.f r111 = new com.bytedance.awemeopen.apps.framework.landscape.ui.f(r29, r30, r31.c, r31.e);
        TextView r32 = this.j.n;
        Intrinsics.checkNotNullParameter(r32, "commentView");
        r14.j r33 = r111.a.L();
        if (r33 == null) goto L48;
        r1 = Long.valueOf(r33.c());
    L48:
        r32.setText(com.bytedance.awemeopen.apps.framework.landscape.ui.k.a(r1, "评论"));
        Object r34 = r32.getParent();
        Intrinsics.checkNotNull(r34, "null cannot be cast to non-null type android.view.View");
        ((View) r34).setOnClickListener(new com.bytedance.awemeopen.apps.framework.landscape.ui.e(r111));
        r14.c r112 = r13.a;
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r35 = this.e;
        b r36 = this.j;
        final com.bytedance.awemeopen.apps.framework.landscape.ui.j r113 = new com.bytedance.awemeopen.apps.framework.landscape.ui.j(r112, r35, r36.m, r36.l);
        Object r114 = r113.b.getParent();
        Intrinsics.checkNotNull(r114, "null cannot be cast to non-null type android.view.View");
        ((View) r114).setOnClickListener(new com.bytedance.awemeopen.apps.framework.landscape.ui.i(r113));
        boolean r115 = r113.f.v1(r113.b.getContext(), r113.a);
        r113.i = r115;
        r113.a(r115);
        this.j.h.setOnClickListener(new j(this));
        n();
        final e r116 = new e(this.j.a, this.h);
        this.j.o.setOnClickListener(new k(this, r116));
        return;
    L40:
        r23 = q24.c.class;
        goto L41
    L31:
        User r37 = r8.f();
        if (r37 == null) goto L35;
        String r38 = r37.t();
        if (r38 == null) goto L35;
    L36:
        r9 = r38.concat("的视频");
    L35:
        r38 = "";
        goto L36
    L26:
        if (h0.a(r9) == false) goto L28;
    L20:
        r15 = false;
        goto L21
    L13:
        r6 = null;
        goto L14
    L9:
        r4 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    public l(com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.c r7, p r8, VideoCardPreRender r9) {
        Intrinsics.checkNotNullParameter(r7, "params");
        Intrinsics.checkNotNullParameter(r8, "eventRecorder");
        Intrinsics.checkNotNullParameter(r9, "videoPrePreRenderHelper");
        super(r7.a);
        this.e = r7;
        g04.b<jz3.a> r0 = new g04.b(this.a);
        this.g = r0;
        VideoFeedPlayerPresenter r1 = new VideoFeedPlayerPresenter(r7, r8, r9, null);
        this.h = r1;
        LongPressSpeedPresenterConfig r10 = new LongPressSpeedPresenterConfig();
        Function0<Boolean> r11 = new LandscapeVideoViewHolder$longPressFastSpeedPresenter$1$1(this);
        Intrinsics.checkNotNullParameter(r11, "<set-?>");
        r10.a = r11;
        r10.b = new LandscapeVideoViewHolder$longPressFastSpeedPresenter$1$2(this);
        Unit r12 = Unit.INSTANCE;
        FeedLongPressFastSpeedPresenter r13 = new FeedLongPressFastSpeedPresenter(r7, r10);
        this.i = r13;
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r2 = this.e;
        View r3 = r2.a.findViewById(2131375768);
        FeedGesturePresenterConfig r4 = new FeedGesturePresenterConfig();
        r4.b = new LandscapeVideoViewHolder$createFeedGesturePresenterConfig$1$1(this);
        r4.c = new LandscapeVideoViewHolder$createFeedGesturePresenterConfig$1$2(this);
        r4.g = new LandscapeVideoViewHolder$createFeedGesturePresenterConfig$1$3(this);
        r4.h = new LandscapeVideoViewHolder$createFeedGesturePresenterConfig$1$4(this);
        r4.j = true;
        VideoFeedGesturePresenter r14 = new VideoFeedGesturePresenter(r2, r3, r4);
        View r5 = r7.a;
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type android.view.ViewGroup");
        b r6 = new b((ViewGroup) r5);
        this.j = r6;
        r0.m(r1);
        r0.m(r14);
        r0.m(r13);
        r0.m(new LandscapeStatusBarPresenter(r6.a.getContext(), r6.b));
        View r15 = this.a;
        View r16 = r15.findViewById(2131373357);
        pz3.f r17 = new pz3.f();
        r17.a = new LandscapeVideoViewHolder$1$1(this);
        r17.b = new LandscapeVideoViewHolder$1$2(this);
        r0.m(new pz3.h(r15, r16, r7, r17));
    }
}
