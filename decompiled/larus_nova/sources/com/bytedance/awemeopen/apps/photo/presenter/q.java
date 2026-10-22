package com.bytedance.awemeopen.apps.photo.presenter;

import android.app.Activity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.awemeopen.apps.framework.feed.follow.util.DuxTextView;
import com.bytedance.awemeopen.apps.framework.feed.ui.rightbar.digg.DiggType;
import com.bytedance.awemeopen.infra.base.env.AoEnv;
import com.bytedance.crash.dumper.Scraps;
import com.larus.nova.R;
import com.ss.ttvideoengine.strategrycenter.IStrategyStateSupplier;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class q extends f04.a<Unit> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a14.a f198005d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LinearLayout f198006e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ImageView f198007f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final DuxTextView f198008g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final q24.c f198009h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f198010i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f198011j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public s f198012k;

    public static final class a implements q24.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q f198013a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DiggType f198014b;

        @Override // q24.a
        public final void b() {
        }

        @Override // q24.a
        public final void a() {
            zx3.a.b(this.f198013a.f198005d.getActivity(), R.string.aos_network_unavailable).d();
            this.f198013a.f198010i = false;
        }

        @Override // q24.a
        public final void onFail() {
            if (AoEnv.j() == true) goto L5;
            zx3.a.b(this.f198013a.f198005d.getActivity(), R.string.aos_digg_failed).d();
        L5:
            this.f198013a.f198010i = false;
        }

        @Override // q24.a
        public final void onSuccess(String r100) {
            Intrinsics.checkNotNullParameter(r100, "aid");
            Intrinsics.checkNotNullParameter(r100, "aid");
            if (Intrinsics.areEqual(r100, this.f198013a.f198005d.f1366a.c()) == false) goto L6;
            this.f198013a.n();
            com.bytedance.awemeopen.apps.photo.utils.a r101 = com.bytedance.awemeopen.apps.photo.utils.a.f198038a;
            a14.a r102 = this.f198013a.f198005d;
            DiggType r103 = this.f198014b;
            r101.getClass();
            com.bytedance.awemeopen.apps.photo.utils.a.d(r102, r103, false);
            com.bytedance.awemeopen.apps.photo.utils.a.d(this.f198013a.f198005d, this.f198014b, true);
            this.f198013a.f198010i = false;
            return;
        }

        public a(q r100, DiggType r101) {
            this.f198013a = r100;
            this.f198014b = r101;
        }
    }

    @Override // f04.a
    public final void k() {
        s r100 = this.f198012k;
        if (r100 == null) goto L6;
        this.f198009h.s3(r100);
        return;
    }

    public final void n() {
        x04.a.b(this.f198008g, this.f198009h.f0(this.f198005d.getActivity(), this.f198005d.f1366a), this.f198008g.getContext().getResources().getString(R.string.slides_flow_digg));
        boolean r100 = this.f198009h.m3(this.f198005d.getActivity(), this.f198005d.f1366a);
        this.f198007f.setSelected(r100);
        this.f198005d.f1368c.changeDiggStatus(r100);
    }

    public q(a14.a r100) {
        Intrinsics.checkNotNullParameter(r100, "pgParameters");
        super(r100.f1367b);
        this.f198005d = r100;
        this.f198006e = (LinearLayout) i(R.id.ll_like);
        this.f198007f = (ImageView) i(R.id.iv_like);
        this.f198008g = (DuxTextView) i(R.id.tv_like_count);
        d14.a r101 = b14.a.f16924a;
        this.f198009h = (q24.c) b14.a.a(q24.c.class);
    }

    @Override // f04.a
    public final void j(Unit r100) {
        Intrinsics.checkNotNullParameter(r100, Scraps.INNER_UNIT);
        this.f198010i = false;
        this.f198011j = false;
        n();
        this.f198006e.setOnClickListener(new o(this));
        s r101 = new s(this);
        this.f198012k = r101;
        q24.c r102 = this.f198009h;
        Intrinsics.checkNotNull(r101);
        r102.Y(r101);
        this.f198005d.f1368c.observeDiggStatusChange(new p(this));
    }

    public final void m(DiggType r100) {
        Intrinsics.checkNotNullParameter(r100, "diggType");
        if (this.f198009h.m3(this.f198005d.getActivity(), this.f198005d.f1366a) == false) goto L6;
        return;
    L6:
        if (this.f198010i == false) goto L8;
        return;
    L8:
        com.bytedance.awemeopen.apps.photo.utils.a r101 = com.bytedance.awemeopen.apps.photo.utils.a.f198038a;
        a14.a r102 = this.f198005d;
        r101.getClass();
        com.bytedance.awemeopen.apps.photo.utils.a.c(r102, r100, "click_like");
        this.f198010i = true;
        q24.c r103 = this.f198009h;
        Activity r104 = this.f198005d.getActivity();
        r14.c r105 = this.f198005d.f1366a;
        Activity r106 = this.f198005d.getActivity();
        int r107 = com.bytedance.awemeopen.bizmodels.user.a.f198216a;
        r103.j3(r104, r105, new com.bytedance.awemeopen.bizmodels.user.f(r106, IStrategyStateSupplier.KEY_INFO_LIKE, null), new a(this, r100));
    }
}
