package com.bytedance.ee.bear.templates.recommend;

import android.view.View;
import com.bytedance.ee.bear.widgets.t;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class k extends t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ i f239294c;

    public k(i r100) {
        this.f239294c = r100;
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        tt5.a.h("NewRecommendTemplateView", "onMoreClick()...");
        b.a r101 = this.f239294c.f239289e;
        if (r101 == null) goto L6;
        r101.o();
        return;
    }
}
