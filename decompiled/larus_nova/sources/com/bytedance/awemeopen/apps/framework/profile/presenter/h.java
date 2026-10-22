package com.bytedance.awemeopen.apps.framework.profile.presenter;

import android.util.SparseArray;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import com.bytedance.awemeopen.apps.framework.framework.eventbus.LiveDataBus;
import com.larus.nova.R;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class h extends f04.a<Unit> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.awemeopen.apps.framework.profile.m f197434d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HorizontalScrollView f197435e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LinearLayout f197436f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final n04.a f197437g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final SparseArray<n04.c> f197438h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f197439i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final e f197440j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final f f197441k;

    @Override // f04.a
    public final void k() {
        LiveDataBus r100 = LiveDataBus.f196946c;
        LiveDataBus.a.a(gz3.e.class).removeObserver(this.f197440j);
        this.f197434d.f197362b.getCardEntryStructs().removeObserver(this.f197441k);
    }

    public final void m() {
        int r100 = this.f197438h.size();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L8;
        n04.c r102 = this.f197438h.valueAt(r101);
        if (r102 == null) goto L7;
        r102.c(this.f197434d);
    L7:
        r101 = r101 + 1;
        goto L3
    }

    /* JADX WARN: Type inference failed for: r2v10, types: [com.bytedance.awemeopen.apps.framework.profile.presenter.f] */
    /* JADX WARN: Type inference failed for: r2v9, types: [com.bytedance.awemeopen.apps.framework.profile.presenter.e] */
    public h(com.bytedance.awemeopen.apps.framework.profile.m r100) {
        Intrinsics.checkNotNullParameter(r100, "pgParameters");
        super(r100.f197361a);
        this.f197434d = r100;
        this.f197435e = (HorizontalScrollView) i(R.id.user_card_entries_sl);
        this.f197436f = (LinearLayout) i(R.id.user_card_entries_ll);
        this.f197437g = new n04.a(getContext());
        this.f197438h = new SparseArray();
        this.f197440j = new e(this);
        this.f197441k = new f(this);
    }

    @Override // f04.a
    public final void j(Unit r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        LiveDataBus r101 = LiveDataBus.f196946c;
        LiveDataBus.a.a(gz3.e.class).observeForever(this.f197440j);
        this.f197434d.f197362b.getCardEntryStructs().observe(this.f197434d.f197363c, this.f197441k);
    }
}
