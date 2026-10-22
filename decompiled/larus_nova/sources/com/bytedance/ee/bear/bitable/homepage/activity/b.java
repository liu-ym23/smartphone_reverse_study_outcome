package com.bytedance.ee.bear.bitable.homepage.activity;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableMessageAdapter f212306a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ HomePageData f212307b;

    public b(BitableMessageAdapter r100, HomePageData r101) {
        this.f212306a = r100;
        this.f212307b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        j r101 = this.f212306a.f212270c;
        Intrinsics.checkNotNull(r100);
        r101.a(r100, this.f212307b);
    }
}
