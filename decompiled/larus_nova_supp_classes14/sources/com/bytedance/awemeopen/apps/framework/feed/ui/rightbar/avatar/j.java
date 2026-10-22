package com.bytedance.awemeopen.apps.framework.feed.ui.rightbar.avatar;

import android.app.Activity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.bytedance.awemeopen.apps.framework.AosExtConfig;
import com.bytedance.awemeopen.apps.framework.feed.AosEventReporter;
import com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement;
import com.bytedance.awemeopen.apps.framework.utils.p0;
import com.bytedance.awemeopen.apps.photo.pinch.PinchEnterMethod;
import com.bytedance.awemeopen.bizmodels.profile.User;
import com.bytedance.awemeopen.domain.base.repo.GsonHolder;
import com.bytedance.awemeopen.infra.base.live.AoLive;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.google.gson.Gson;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import r14.a0;
import r14.g0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class j extends BaseElement<p, AvatarModel, tz3.a, jz3.a> {
    public static final /* synthetic */ int w = 0;
    public final Activity g;
    public final com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b h;
    public final com.bytedance.awemeopen.apps.framework.framework.viewpager.o i;
    public final l14.c j;
    public jz3.a k;
    public boolean l;
    public boolean m;
    public boolean n;
    public final y24.d o;
    public final a34.a p;
    public g0 q;
    public final c r;
    public final f s;
    public final g t;
    public final h u;
    public final i v;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Lifecycle.Event.values().length];
            r0[Lifecycle.Event.ON_RESUME.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            a = r0;
        }
    }

    public static final class c implements y24.c {
        public final /* synthetic */ j a;

        public c(j r1) {
            this.a = r1;
        }

        public final void a(String r2, int r3) {
            jz3.a r4 = this.a.k;
            String r0 = null;
            if (r4 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("data");
            r4 = null;
        L5:
            User r5 = r4.a.f();
            if (r5 == null) goto L9;
            r0 = r5.u();
        L9:
            if (Intrinsics.areEqual(r2, r0) == false) goto L14;
            j r6 = this.a;
            if (r6.n == true) goto L15;
            r6.t();
            return;
        L15:
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void k() {
        this.m = true;
        LifecycleOwner r0 = this.h.d;
        if (r0 == null) goto L6;
        this.i.getFeedHomeContainerSelectedIndex().observe(r0, this.t);
        this.i.getFeedHomeContainerDeliverHiddenState().observe(r0, this.u);
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void m() {
        this.m = false;
        this.i.getFeedHomeContainerSelectedIndex().removeObserver(this.t);
        this.i.getFeedHomeContainerDeliverHiddenState().removeObserver(this.u);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.a b() {
        return new p();
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.b c() {
        return new AvatarModel();
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c d() {
        return new AvatarElementView(getContext(), g(), h());
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void o() {
        this.p.s1(this.v);
        this.o.r2(this.r);
        LifecycleOwner r0 = this.h.d;
        if (r0 == null) goto L8;
        Lifecycle r1 = r0.getLifecycle();
        if (r1 == null) goto L9;
        r1.removeObserver(this.s);
        return;
    L9:
        return;
    }

    public final String q() {
        jz3.a r0 = this.k;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("data");
        r0 = null;
    L5:
        User r1 = r0.a.f();
        if (r1 == null) goto L9;
        String r2 = r1.u();
        if (r2 == null) goto L9;
        return r2;
    L9:
        return "";
    }

    public final void s() {
        long r1 = r();
        if (r1 == 0) goto L47;
        AosEventReporter r3 = AosEventReporter.a;
        String r5 = this.i.getPageConfig().getHostEnterFrom();
        String r7 = this.i.sceneId();
        jz3.a r4 = this.k;
        jz3.a r6 = null;
        if (r4 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("data");
        r4 = null;
    L7:
        String r8 = r4.a.r().b;
        if (r8 != null) goto L10;
        String r10 = "";
    L11:
        String r11 = String.valueOf(r1);
        jz3.a r2 = this.k;
        if (r2 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("data");
        r2 = null;
    L14:
        a0 r9 = r2.a.d;
        if (r9 == null) goto L20;
        String r12 = r9.a();
        if (r12 == null) goto L20;
        String r13 = r12;
    L21:
        g0 r14 = this.q;
        if (r14 == null) goto L27;
        String r15 = Long.valueOf(r14.appId).toString();
        if (r15 == null) goto L27;
        String r16 = r15;
    L28:
        g0 r17 = this.q;
        if (r17 == null) goto L36;
        g0.a r18 = r17.extra;
        if (r18 == null) goto L36;
        String r19 = Long.valueOf(r18.xgUid).toString();
        if (r19 == null) goto L36;
        String r110 = r19;
    L37:
        jz3.a r20 = this.k;
        if (r20 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("data");
    L41:
        String r111 = r6.a.c();
        String r21 = this.i.getPageConfig().getEnterRequestId();
        if (r21 != null) goto L44;
        String r112 = "";
    L45:
        JSONObject r113 = this.i.getPageConfig().getHostExtraParams();
        r3.getClass();
        AosEventReporter.G(r5, "video_head", r7, "video_head", PinchEnterMethod.CLICK, r10, r11, r13, r16, r110, r113, r111, r112);
        return;
    L44:
        r112 = r21;
        goto L45
    L40:
        r6 = r20;
    L36:
        r110 = "";
    L27:
        r16 = "";
    L20:
        r13 = "";
        goto L21
    L10:
        r10 = r8;
        goto L11
    }

    public final void t() {
        if (Intrinsics.areEqual(this.f.c, Boolean.FALSE) == false) goto L6;
        return;
    L6:
        if (this.l == false) goto L15;
        l14.c r0 = this.j;
        if (r0 != null) goto L10;
    L12:
        boolean r1 = false;
    L13:
        if (r1 == false) goto L15;
    L16:
        AvatarModel r2 = h();
        AvatarModel.FollowStatus r3 = AvatarModel.FollowStatus.UNSHOWFOLLOW;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "followStatus");
        r2.a.b(r3);
        return;
    L10:
        if (r0.f() == true) goto L12;
        r1 = true;
    L15:
        if (this.i.getPageConfig().isTeenagerModel() == true) goto L16;
        AvatarModel r4 = h();
        if (AosExtConfig.b.A().a == true) goto L20;
        AvatarModel.FollowStatus r5 = AvatarModel.FollowStatus.UNSHOWFOLLOW;
    L34:
        r4.getClass();
        Intrinsics.checkNotNullParameter(r5, "followStatus");
        r4.a.b(r5);
        return;
    L20:
        jz3.a r6 = this.k;
        jz3.a r7 = null;
        if (r6 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("data");
        r6 = null;
    L24:
        if (p0.e(r6.a.r().b) == false) goto L26;
        r5 = AvatarModel.FollowStatus.MYSELF;
        goto L34
    L26:
        y24.d r8 = this.o;
        jz3.a r9 = this.k;
        if (r9 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("data");
    L31:
        if (r8.E1(r7.a) == true) goto L33;
        r5 = AvatarModel.FollowStatus.UNFOLLOWED;
        goto L34
    L33:
        r5 = AvatarModel.FollowStatus.FOLLOWED;
        goto L34
    L29:
        r7 = r9;
        goto L31
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void onCreate() {
        p r0 = g();
        Observer<Unit> r1 = new com.bytedance.awemeopen.apps.framework.feed.ui.rightbar.avatar.a(this);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "observer");
        r0.e.a(r1);
        p r2 = g();
        Observer<Unit> r3 = new com.bytedance.awemeopen.apps.framework.feed.ui.rightbar.avatar.b(this);
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "observer");
        r2.a.a(r3);
        p r4 = g();
        Observer<Unit> r5 = new com.bytedance.awemeopen.apps.framework.feed.ui.rightbar.avatar.c(this);
        r4.getClass();
        Intrinsics.checkNotNullParameter(r5, "observer");
        r4.b.a(r5);
        p r6 = g();
        Observer<Unit> r7 = new d(this);
        r6.getClass();
        Intrinsics.checkNotNullParameter(r7, "observer");
        r6.c.a(r7);
        p r8 = g();
        Observer<Unit> r9 = new e(this);
        r8.getClass();
        Intrinsics.checkNotNullParameter(r9, "observer");
        r8.d.a(r9);
    }

    public final long r() {
        if (AoLive.b() == false) goto L32;
        jz3.a r0 = this.k;
        jz3.a r1 = null;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("data");
        r0 = null;
    L7:
        User r2 = r0.a.f();
        boolean r3 = false;
        if (r2 != null) goto L10;
    L12:
        boolean r4 = false;
    L13:
        if (r4 == true) goto L32;
        jz3.a r5 = this.k;
        if (r5 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("data");
        r5 = null;
    L18:
        String r6 = r5.a.r().b;
        if (r6 != null) goto L21;
    L22:
        r3 = true;
    L23:
        if (r3 == true) goto L25;
        this.p.r0(r6);
    L25:
        jz3.a r7 = this.k;
        if (r7 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("data");
    L29:
        User r8 = r1.a.f();
        if (r8 == null) goto L32;
        return r8.z();
    L28:
        r1 = r7;
        goto L29
    L21:
        if (r6.length() != 0) goto L23;
    L10:
        if (r2.M() != true) goto L12;
        r4 = true;
    L32:
        return 0;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.d e() {
        return com.bytedance.awemeopen.apps.framework.feed.ui.rightbar.a.a;
    }

    public final Activity getActivity() {
        return this.g;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void n() {
        s();
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void l(jz3.a r9) {
        jz3.a r10 = r9;
        Intrinsics.checkNotNullParameter(r10, "data");
        p();
        this.k = r10;
        this.m = false;
        this.n = false;
        User r2 = r10.a.f();
        AvatarModel r3 = h();
        String r4 = null;
        if (r2 == null) goto L7;
        t14.a r5 = r2.a();
        if (r5 == null) goto L7;
        List<String> r6 = r5.g();
    L8:
        r3.b.b(r6);
        d14.a r7 = b14.a.a;
        this.l = b14.a.a(l24.c.class).a(r10.a);
        t();
        this.o.R2(this.r);
        this.p.O2(this.v);
        if (r() != 0) goto L11;
    L21:
        AvatarModel r11 = h();
        yz3.b r8 = new yz3.b(false);
        r11.getClass();
        Intrinsics.checkNotNullParameter(r8, "data");
        r11.d.b(r8);
    L22:
        LifecycleOwner r12 = this.h.d;
        if (r12 == null) goto L30;
        Lifecycle r13 = r12.getLifecycle();
        if (r13 == null) goto L31;
        r13.addObserver(this.s);
        return;
    L31:
        return;
    L30:
        return;
    L11:
        if (this.i.getPageConfig().isTeenagerModel() == true) goto L21;
        Gson r14 = GsonHolder.a();     // Catch: Exception -> L18
        User r15 = r10.a.f();     // Catch: Exception -> L18
        if (r15 == null) goto L16;
        r4 = r15.y();     // Catch: Exception -> L18
    L16:
        this.q = (g0) r14.fromJson(r4, g0.class);     // Catch: Exception -> L18
    L20:
        AvatarModel r16 = h();
        yz3.b r1 = new yz3.b(true);
        r16.getClass();
        Intrinsics.checkNotNullParameter(r1, "data");
        r16.d.b(r1);
    L18:
        e = move-exception;
        AoLogger.c("AvatarElement", new Object[]{e});
    L7:
        r6 = null;
        goto L8
    }

    /* JADX WARN: Type inference failed for: r2v10, types: [com.bytedance.awemeopen.apps.framework.feed.ui.rightbar.avatar.g] */
    /* JADX WARN: Type inference failed for: r2v11, types: [com.bytedance.awemeopen.apps.framework.feed.ui.rightbar.avatar.h] */
    /* JADX WARN: Type inference failed for: r2v12, types: [com.bytedance.awemeopen.apps.framework.feed.ui.rightbar.avatar.i] */
    /* JADX WARN: Type inference failed for: r2v9, types: [com.bytedance.awemeopen.apps.framework.feed.ui.rightbar.avatar.f] */
    public j(Activity r2, com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b r3, com.bytedance.awemeopen.apps.framework.framework.viewpager.o r4, l14.c r5) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "pageOwner");
        Intrinsics.checkNotNullParameter(r4, "vm");
        super(r2);
        this.g = r2;
        this.h = r3;
        this.i = r4;
        this.j = r5;
        d14.a r6 = b14.a.a;
        this.o = b14.a.a(y24.d.class);
        this.p = b14.a.a(a34.a.class);
        this.r = new c(this);
        this.s = new f(this);
        this.t = new g(this);
        this.u = new h(this);
        this.v = new i(this);
    }
}
