package com.bytedance.awemeopen.apps.framework.profile.presenter;

import android.util.SparseArray;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import com.bytedance.awemeopen.apps.framework.framework.eventbus.LiveDataBus;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h extends f04.a<Unit> {
    public final com.bytedance.awemeopen.apps.framework.profile.m d;
    public final HorizontalScrollView e;
    public final LinearLayout f;
    public final n04.a g;
    public final SparseArray<n04.c> h;
    public boolean i;
    public final e j;
    public final f k;

    @Override // f04.a
    public final void k() {
        LiveDataBus r0 = LiveDataBus.c;
        LiveDataBus.a.a(gz3.e.class).removeObserver(this.j);
        this.d.b.getCardEntryStructs().removeObserver(this.k);
    }

    public final void m() {
        int r0 = this.h.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        n04.c r2 = this.h.valueAt(r1);
        if (r2 == null) goto L7;
        r2.c(this.d);
    L7:
        r1 = r1 + 1;
        goto L3
    }

    /* JADX WARN: Type inference failed for: r2v10, types: [com.bytedance.awemeopen.apps.framework.profile.presenter.f] */
    /* JADX WARN: Type inference failed for: r2v9, types: [com.bytedance.awemeopen.apps.framework.profile.presenter.e] */
    public h(com.bytedance.awemeopen.apps.framework.profile.m r2) {
        Intrinsics.checkNotNullParameter(r2, "pgParameters");
        super(r2.a);
        this.d = r2;
        this.e = (HorizontalScrollView) i(2131392011);
        this.f = (LinearLayout) i(2131392010);
        this.g = new n04.a(getContext());
        this.h = new SparseArray();
        this.j = new e(this);
        this.k = new f(this);
    }

    @Override // f04.a
    public final void j(Unit r3) {
        Intrinsics.checkNotNullParameter(r3, "data");
        LiveDataBus r4 = LiveDataBus.c;
        LiveDataBus.a.a(gz3.e.class).observeForever(this.j);
        this.d.b.getCardEntryStructs().observe(this.d.c, this.k);
    }
}
