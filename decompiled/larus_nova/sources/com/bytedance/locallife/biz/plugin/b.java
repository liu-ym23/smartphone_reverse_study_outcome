package com.bytedance.locallife.biz.plugin;

import android.os.SystemClock;
import androidx.lifecycle.Observer;
import com.bytedance.locallife.dito.data.m;
import com.bytedance.locallife.dito.model.BaseDitoModel;

/* JADX INFO: loaded from: classes21.dex */
public final class b<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbsDitoFmpPlugin f256920a;

    public b(AbsDitoFmpPlugin r100) {
        this.f256920a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        BaseDitoModel<?> r101 = ((com.bytedance.locallife.dito.data.b) r100).f258196b;
        if (r101 == null) goto L11;
        m r102 = r101.f258493b;
        if (r102 == null) goto L12;
        String r103 = r102.f258222b;
        if (r103 == null) goto L13;
        this.f256920a.f256874n.put(r103, Long.valueOf(SystemClock.elapsedRealtime()));
        return;
    L13:
        return;
    L12:
        return;
    }
}
