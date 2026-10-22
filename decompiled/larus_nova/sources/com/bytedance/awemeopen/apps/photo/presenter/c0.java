package com.bytedance.awemeopen.apps.photo.presenter;

import android.app.Activity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.awemeopen.apps.framework.feed.follow.util.DuxTextView;
import com.bytedance.crash.dumper.Scraps;
import com.larus.nova.R;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class c0 extends f04.a<Unit> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a14.a f197945d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final o24.b f197946e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LinearLayout f197947f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ImageView f197948g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final DuxTextView f197949h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f197950i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f197951j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public b0 f197952k;

    @Override // f04.a
    public final void k() {
        b0 r100 = this.f197952k;
        if (r100 == null) goto L6;
        this.f197946e.T(r100);
        return;
    }

    public final void m() {
        DuxTextView r100 = this.f197949h;
        o24.b r101 = this.f197946e;
        Activity r102 = this.f197945d.getActivity();
        Intrinsics.checkNotNull(r102);
        x04.a.b(r100, r101.q(r102, this.f197945d.f1366a), this.f197949h.getContext().getResources().getString(R.string.aos_feed_collect));
        o24.b r103 = this.f197946e;
        Activity r104 = this.f197945d.getActivity();
        Intrinsics.checkNotNull(r104);
        boolean r105 = r103.v1(r104, this.f197945d.f1366a);
        this.f197948g.setSelected(r105);
    }

    public c0(a14.a r100) {
        Intrinsics.checkNotNullParameter(r100, "pgParameters");
        super(r100.f1367b);
        this.f197945d = r100;
        d14.a r101 = b14.a.f16924a;
        this.f197946e = (o24.b) b14.a.a(o24.b.class);
        this.f197947f = (LinearLayout) i(R.id.ll_collect);
        this.f197948g = (ImageView) i(R.id.iv_collect);
        this.f197949h = (DuxTextView) i(R.id.tv_collect_count);
    }

    @Override // f04.a
    public final void j(Unit r100) {
        Intrinsics.checkNotNullParameter(r100, Scraps.INNER_UNIT);
        m();
        this.f197950i = false;
        this.f197951j = false;
        this.f197947f.setOnClickListener(new a0(this));
        b0 r101 = new b0(this);
        this.f197952k = r101;
        o24.b r102 = this.f197946e;
        Intrinsics.checkNotNull(r101);
        r102.l2(r101);
    }
}
