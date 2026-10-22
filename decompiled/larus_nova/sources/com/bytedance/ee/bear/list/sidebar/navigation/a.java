package com.bytedance.ee.bear.list.sidebar.navigation;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SidebarNavigationAdapter f229616a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f229617b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ b f229618c;

    public a(SidebarNavigationAdapter r100, int r101, b r102) {
        this.f229616a = r100;
        this.f229617b = r101;
        this.f229618c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        SidebarNavigationAdapter r101 = this.f229616a;
        if (r101.f229597c == false) goto L7;
        int r102 = this.f229617b;
        if (r102 == (-1)) goto L7;
        int r103 = r101.f229598d;
        r101.f229598d = r102;
        r101.notifyItemChanged(r102);
        this.f229616a.notifyItemChanged(r103);
    L7:
        Function1<? super b, Unit> r104 = this.f229616a.f229595a;
        if (r104 == null) goto L11;
        r104.invoke(this.f229618c);
        return;
    }
}
