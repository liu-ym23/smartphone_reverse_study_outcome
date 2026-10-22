package com.ss.android.ainote.list;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes34.dex */
public final class y implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AINoteListView f407123a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AINoteItemView f407124b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f407125c;

    public y(AINoteListView r100, AINoteItemView r101, long r102) {
        this.f407123a = r100;
        this.f407124b = r101;
        this.f407125c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        AINoteListView r101 = this.f407123a;
        int r102 = AINoteListView.f406958k1;
        r101.getClass();
        this.f407124b.setHighlighted(false);
        Function2<? super Long, ? super String, Unit> r103 = this.f407123a.C;
        if (r103 == null) goto L5;
        r103.invoke(Long.valueOf(this.f407125c), this.f407124b.d());
    L5:
        this.f407123a.m();
    }
}
