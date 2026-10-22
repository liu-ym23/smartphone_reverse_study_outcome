package com.ss.android.ainote.list;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes34.dex */
public final class w implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AINoteListView f407117a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AINoteItemView f407118b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f407119c;

    public w(AINoteListView r100, AINoteItemView r101, long r102) {
        this.f407117a = r100;
        this.f407118b = r101;
        this.f407119c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        AINoteListView r101 = this.f407117a;
        int r102 = AINoteListView.f406958k1;
        r101.getClass();
        this.f407118b.setHighlighted(false);
        int r103 = com.ss.android.ainote.t.f407207a;
        com.ss.android.ainote.t.a("AINoteListView", "restore clicked, noteId=" + this.f407119c);
        Function1<? super Long, Unit> r104 = this.f407117a.E;
        if (r104 == null) goto L5;
        r104.invoke(Long.valueOf(this.f407119c));
    L5:
        AINoteItemView r105 = this.f407118b;
        r105.K = true;
        r105.m();
        r105.removeCallbacks(r105.L);
        r105.postDelayed(r105.L, 1500);
        this.f407117a.m();
    }
}
