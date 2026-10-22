package com.bytedance.ee.bear.more.view3.ui;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f235064a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View.OnClickListener f235065b;

    public b(a r100, View.OnClickListener r101) {
        this.f235064a = r100;
        this.f235065b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        a r101 = this.f235064a;
        Intrinsics.checkNotNull(r100);
        a r102 = this.f235064a;
        boolean r103 = r102.f235059h;
        String r104 = r102.f235060i;
        View.OnClickListener r105 = r102.f235061j;
        View.OnClickListener r106 = this.f235065b;
        r101.getClass();
        a.h(r100, r103, r104, r105, r106);
    }
}
