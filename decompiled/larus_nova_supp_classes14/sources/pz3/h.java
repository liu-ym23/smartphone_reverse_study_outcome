package pz3;

import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h extends g04.a<jz3.a> {
    public final View e;
    public final View f;
    public final com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a g;
    public final f h;
    public e i;
    public e j;
    public r14.c k;
    public int l;
    public int m;
    public int n;
    public int o;
    public View p;
    public g q;

    @Override // g04.a
    public final void h() {
        g r0 = this.q;
        if (r0 == null) goto L5;
        this.g.c.getVideoScaling().removeObserver(r0);
    L5:
        this.q = null;
        this.l = 0;
        this.m = 0;
        this.n = 0;
        this.o = 0;
        e r1 = this.i;
        if (r1 == null) goto L8;
        r1.f();
    L8:
        e r2 = this.j;
        if (r2 == null) goto L11;
        r2.f();
    L11:
        this.i = null;
        this.j = null;
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [pz3.g] */
    @Override // g04.a
    public final void f(jz3.a r3) {
        jz3.a r4 = r3;
        Intrinsics.checkNotNullParameter(r4, "data");
        this.l = 0;
        this.m = 0;
        this.n = 0;
        this.o = 0;
        this.k = r4.a;
        this.q = new g(this);
        MutableLiveData<d> r5 = this.g.c.getVideoScaling();
        LifecycleOwner r0 = this.g.e.d;
        g r1 = this.q;
        Intrinsics.checkNotNull(r1);
        r5.observe(r0, r1);
    }

    public h(View r2, View r3, com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r4, f r5) {
        Intrinsics.checkNotNullParameter(r2, "mRootView");
        Intrinsics.checkNotNullParameter(r3, "videoWrapper");
        Intrinsics.checkNotNullParameter(r4, "feedGroupParameters");
        Intrinsics.checkNotNullParameter(r5, "config");
        super(r4.a);
        this.e = r2;
        this.f = r3;
        this.g = r4;
        this.h = r5;
    }
}
