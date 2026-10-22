package com.bytedance.ee.bear.bitable.card.view.stage;

import android.view.View;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class g extends pr4.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ StageDataViewHolder f208722b;

    public g(StageDataViewHolder r100) {
        this.f208722b = r100;
    }

    @Override // pr4.a
    public final void a(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        b r101 = this.f208722b.f208670a.getView();
        if (r101 == null) goto L5;
        r101.GY(r100);
    L5:
        this.f208722b.f208670a.l();
    }
}
