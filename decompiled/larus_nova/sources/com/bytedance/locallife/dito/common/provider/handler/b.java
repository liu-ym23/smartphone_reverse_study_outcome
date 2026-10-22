package com.bytedance.locallife.dito.common.provider.handler;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes21.dex */
public final class b implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f257631a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f257632b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f257633c;

    public b(RecyclerView r100, d r101, long r102) {
        this.f257631a = r100;
        this.f257632b = r101;
        this.f257633c = r102;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        this.f257631a.removeCallbacks(this.f257632b);
        this.f257631a.postDelayed(this.f257632b, this.f257633c);
    }
}
