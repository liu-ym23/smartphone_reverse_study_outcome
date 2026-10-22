package com.bytedance.ee.bear.atfinder;

import android.text.TextUtils;
import com.bytedance.ee.bear.at.AtObject;
import io.reactivex.functions.Consumer;
import kn4.k;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements Consumer<AtFinderResultList> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtObject f206345a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f206346b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ c f206347c;

    @Override // io.reactivex.functions.Consumer
    public final void accept(AtFinderResultList r100) throws Exception {
        tt5.a.b("AtFinderController", "accept: ");
        d r101 = this.f206347c.f206351d;
        boolean r102 = false;
        r101.a(r100, false);
        AtObject r103 = this.f206345a;
        if (r103 == null) goto L13;
        c r104 = this.f206347c;
        r104.f206358k.e(r103, r104.f206359l);
        c r105 = this.f206347c;
        k r106 = r105.f206358k;
        AtObject r107 = this.f206345a;
        AtCheckBoxViewModel r108 = r105.f206361n;
        if (r108 != null) goto L7;
    L9:
        r106.c(r107, r102, this.f206346b, true ^ TextUtils.equals(this.f206347c.f206353f, ""));
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.mention.user_recommendation_optimize") == false) goto L14;
        this.f206347c.f206360m.a(this.f206345a);
        return;
    L14:
        return;
    L7:
        if (r108.isCheckboxSelected() == false) goto L9;
        r102 = true;
        goto L9
    }

    public a(c r100, AtObject r101, int r102) {
        this.f206347c = r100;
        this.f206345a = r101;
        this.f206346b = r102;
    }
}
