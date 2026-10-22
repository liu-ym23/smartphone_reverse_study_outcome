package com.bytedance.ee.bear.middleground.comment.cell;

import android.view.View;
import java.util.HashMap;

/* JADX INFO: loaded from: classes18.dex */
public final class k implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.middleground.comment.uitls.p f231066a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f231067b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ j f231068c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.middleground.comment.control.t f231069d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f231070e;

    public k(com.bytedance.ee.bear.middleground.comment.uitls.p r100, String r101, j r102, com.bytedance.ee.bear.middleground.comment.control.t r103, int r104) {
        this.f231066a = r100;
        this.f231067b = r101;
        this.f231068c = r102;
        this.f231069d = r103;
        this.f231070e = r104;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        HashMap r101 = new HashMap();
        this.f231066a.f232225d0.o("solve_and_hide", this.f231067b, r101);
        j r102 = this.f231068c;
        com.bytedance.ee.bear.middleground.comment.control.t r103 = this.f231069d;
        String r104 = this.f231067b;
        int r105 = this.f231070e;
        r102.getClass();
        j.a(r103, r104, r105, false);
    }
}
