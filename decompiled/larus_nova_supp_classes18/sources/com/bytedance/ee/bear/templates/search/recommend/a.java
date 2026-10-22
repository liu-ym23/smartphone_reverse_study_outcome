package com.bytedance.ee.bear.templates.search.recommend;

import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ RecommendAdapter a;
    public final /* synthetic */ int b;

    public a(RecommendAdapter r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        RecommendAdapter r4 = this.a;
        Function1<? super String, Unit> r0 = r4.b;
        if (r0 == null) goto L6;
        r0.invoke(ListProtector.get(r4.a, this.b));
        return;
    }
}
