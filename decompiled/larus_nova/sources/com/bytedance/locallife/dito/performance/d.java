package com.bytedance.locallife.dito.performance;

import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class d<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbsComponentLifecyclePlugin f258550a;

    public d(AbsComponentLifecyclePlugin r100) {
        this.f258550a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        ((DitoComponentPerformancePlugin) this.f258550a).getClass();
        Intrinsics.checkNotNullParameter((com.bytedance.locallife.dito.data.b) r100, "componentLifeData");
    }
}
