package com.bytedance.ee.bear.creationmenu;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes16.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f217288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CreationMenuItemAdapter f217289b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CreationMenuItemAdapter.ViewHolder f217290c;

    public b(a r100, CreationMenuItemAdapter r101, CreationMenuItemAdapter.ViewHolder r102) {
        this.f217288a = r100;
        this.f217289b = r101;
        this.f217290c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        a r101 = this.f217288a;
        if (r101 == null) goto L8;
        Function2<? super a, ? super View, Unit> r102 = this.f217289b.f217268c;
        if (r102 == null) goto L9;
        r102.invoke(r101, this.f217290c.itemView);
        return;
    L9:
        return;
    }
}
