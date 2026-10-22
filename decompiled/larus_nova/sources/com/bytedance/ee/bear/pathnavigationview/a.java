package com.bytedance.ee.bear.pathnavigationview;

import android.view.View;
import kl5.b;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f236233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PathNavigationAdapter<kl5.a> f236234b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f236235c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ kl5.a f236236d;

    public a(boolean r100, PathNavigationAdapter<kl5.a> r101, int r102, kl5.a r103) {
        this.f236233a = r100;
        this.f236234b = r101;
        this.f236235c = r102;
        this.f236236d = r103;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (this.f236233a == true) goto L8;
        PathNavigationAdapter<kl5.a> r101 = this.f236234b;
        r101.setNewData(r101.getData().subList(0, this.f236235c + 1));
        b<M> r102 = this.f236234b.f236232a;
        if (r102 == 0) goto L9;
        r102.T(this.f236236d);
        return;
    L9:
        return;
    }
}
