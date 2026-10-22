package com.bytedance.awemeopen.apps.photo.presenter;

import android.app.Activity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.awemeopen.apps.framework.feed.follow.util.DuxTextView;
import com.bytedance.awemeopen.apps.framework.feed.ui.rightbar.digg.DiggType;
import com.bytedance.awemeopen.infra.base.env.AoEnv;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class q extends f04.a<Unit> {
    public final a14.a d;
    public final LinearLayout e;
    public final ImageView f;
    public final DuxTextView g;
    public final q24.c h;
    public boolean i;
    public boolean j;
    public s k;

    public static final class a implements q24.a {
        public final /* synthetic */ q a;
        public final /* synthetic */ DiggType b;

        public final void b() {
        }

        public final void a() {
            zx3.a.b(this.a.d.getActivity(), 2131894241).d();
            this.a.i = false;
        }

        public final void onFail() {
            if (AoEnv.j() == true) goto L5;
            zx3.a.b(this.a.d.getActivity(), 2131894185).d();
        L5:
            this.a.i = false;
        }

        public final void onSuccess(String r4) {
            Intrinsics.checkNotNullParameter(r4, "aid");
            Intrinsics.checkNotNullParameter(r4, "aid");
            if (Intrinsics.areEqual(r4, this.a.d.a.c()) == false) goto L6;
            this.a.n();
            com.bytedance.awemeopen.apps.photo.utils.a r5 = com.bytedance.awemeopen.apps.photo.utils.a.a;
            a14.a r0 = this.a.d;
            DiggType r1 = this.b;
            r5.getClass();
            com.bytedance.awemeopen.apps.photo.utils.a.d(r0, r1, false);
            com.bytedance.awemeopen.apps.photo.utils.a.d(this.a.d, this.b, true);
            this.a.i = false;
            return;
        }

        public a(q r1, DiggType r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    @Override // f04.a
    public final void k() {
        s r0 = this.k;
        if (r0 == null) goto L6;
        this.h.s3(r0);
        return;
    }

    public final void n() {
        x04.a.b(this.g, this.h.f0(this.d.getActivity(), this.d.a), this.g.getContext().getResources().getString(2131914110));
        boolean r0 = this.h.m3(this.d.getActivity(), this.d.a);
        this.f.setSelected(r0);
        this.d.c.changeDiggStatus(r0);
    }

    public q(a14.a r2) {
        Intrinsics.checkNotNullParameter(r2, "pgParameters");
        super(r2.b);
        this.d = r2;
        this.e = (LinearLayout) i(2131378733);
        this.f = (ImageView) i(2131376356);
        this.g = (DuxTextView) i(2131390863);
        d14.a r3 = b14.a.a;
        this.h = b14.a.a(q24.c.class);
    }

    @Override // f04.a
    public final void j(Unit r2) {
        Intrinsics.checkNotNullParameter(r2, "unit");
        this.i = false;
        this.j = false;
        n();
        this.e.setOnClickListener(new o(this));
        s r3 = new s(this);
        this.k = r3;
        q24.c r0 = this.h;
        Intrinsics.checkNotNull(r3);
        r0.Y(r3);
        this.d.c.observeDiggStatusChange(new p(this));
    }

    public final void m(DiggType r8) {
        Intrinsics.checkNotNullParameter(r8, "diggType");
        if (this.h.m3(this.d.getActivity(), this.d.a) == false) goto L6;
        return;
    L6:
        if (this.i == false) goto L8;
        return;
    L8:
        com.bytedance.awemeopen.apps.photo.utils.a r0 = com.bytedance.awemeopen.apps.photo.utils.a.a;
        a14.a r1 = this.d;
        r0.getClass();
        com.bytedance.awemeopen.apps.photo.utils.a.c(r1, r8, "click_like");
        this.i = true;
        q24.c r2 = this.h;
        Activity r3 = this.d.getActivity();
        r14.c r4 = this.d.a;
        Activity r5 = this.d.getActivity();
        int r6 = com.bytedance.awemeopen.bizmodels.user.a.a;
        r2.j3(r3, r4, new com.bytedance.awemeopen.bizmodels.user.f(r5, "like", null), new a(this, r8));
    }
}
