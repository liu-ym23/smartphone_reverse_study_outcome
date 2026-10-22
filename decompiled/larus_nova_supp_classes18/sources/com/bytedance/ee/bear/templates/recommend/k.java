package com.bytedance.ee.bear.templates.recommend;

import android.view.View;
import com.bytedance.ee.bear.widgets.t;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k extends t {
    public final /* synthetic */ i c;

    public k(i r1) {
        this.c = r1;
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
        tt5.a.h("NewRecommendTemplateView", "onMoreClick()...");
        b.a r3 = this.c.e;
        if (r3 == null) goto L6;
        r3.o();
        return;
    }
}
