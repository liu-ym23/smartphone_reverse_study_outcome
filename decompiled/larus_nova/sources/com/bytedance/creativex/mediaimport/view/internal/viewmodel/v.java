package com.bytedance.creativex.mediaimport.view.internal.viewmodel;

import androidx.lifecycle.MutableLiveData;
import kotlin.Pair;
import kotlin.TuplesKt;

/* JADX INFO: loaded from: classes15.dex */
public class v<DATA> implements ti4.t<DATA> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MutableLiveData<Pair<DATA, Integer>> f204152a;

    public v() {
        this.f204152a = new MutableLiveData();
    }

    @Override // ti4.t
    public final MutableLiveData a() {
        return this.f204152a;
    }

    @Override // ti4.t
    public final void b(DATA r100, int r101) {
        if (r100 == null) goto L5;
        this.f204152a.setValue(TuplesKt.to(r100, Integer.valueOf(r101)));
        return;
    }
}
