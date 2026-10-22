package com.bytedance.ee.bear.bitable.card.view.cell.chatter;

import android.view.View;
import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.IChatterEntity;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class c extends com.bytedance.ee.bear.widgets.t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ChatterItemView<IChatterEntity> f207563c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ IChatterEntity f207564d;

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        e<T> r101 = this.f207563c.getMDelegate();
        if (r101 == 0) goto L6;
        r101.X0(this.f207564d);
        return;
    }

    public c(ChatterItemView<IChatterEntity> r100, IChatterEntity r101) {
        this.f207563c = r100;
        this.f207564d = r101;
    }
}
