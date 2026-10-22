package com.ss.android.lark.vote.publish;

import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;

/* JADX INFO: loaded from: classes38.dex */
public final class k implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VoteRecycleAdapter f445302a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f445303b;

    public k(VoteRecycleAdapter r100, int r101) {
        this.f445302a = r100;
        this.f445303b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        VoteRecycleAdapter r101 = this.f445302a;
        int r102 = this.f445303b;
        ListProtector.remove(r101.f445284a, r102);
        r101.notifyDataSetChanged();
        VoteRecycleAdapter.y2(this.f445302a);
        this.f445302a.f445285b.b();
    }
}
