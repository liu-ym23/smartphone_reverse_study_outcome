package com.bytedance.locallife.dito.core;

import android.view.View;
import com.bytedance.locallife.dito.core.viewmodel.DitoDataCenter;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes21.dex */
public final class a<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseDitoView<T> f257871a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f257872b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f257873c;

    public a(BaseDitoView<T> r100, View r101, String r102) {
        this.f257871a = r100;
        this.f257872b = r101;
        this.f257873c = r102;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        com.bytedance.locallife.dito.data.u r101 = (com.bytedance.locallife.dito.data.u) r100;
        this.f257871a.getDataCenter().y0().setValue(new DitoDataCenter.f(this.f257872b, this.f257871a, this.f257873c));
    }
}
