package com.bytedance.ee.bear.templates.search.recommend;

import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RecommendAdapter f239398a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f239399b;

    public a(RecommendAdapter r100, int r101) {
        this.f239398a = r100;
        this.f239399b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        RecommendAdapter r101 = this.f239398a;
        Function1<? super String, Unit> r102 = r101.f239391b;
        if (r102 == null) goto L6;
        r102.invoke(ListProtector.get(r101.f239390a, this.f239399b));
        return;
    }
}
