package com.ss.android.lark.contact.base.contact_new.mvp;

import android.view.View;
import com.ss.android.lark.contact.base.statistics.ContactHitPoint;

/* JADX INFO: loaded from: classes35.dex */
public final class e extends rcc.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NewContactView.a f418737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ NewContactAdapter f418738b;

    @Override // rcc.c
    public final void a(View r100) {
        ContactHitPoint.d("member_avatar");
        NewContactAdapter.a r101 = this.f418738b.f418709b;
        if (r101 == null) goto L6;
        NewContactView.a r102 = this.f418737a;
        String r103 = r102.f418722b;
        String r104 = r102.f418721a;
        ((m) r101).f418754a.f418717b.t0(r103, r104);
        return;
    }

    public e(NewContactAdapter r100, NewContactView.a r101) {
        this.f418738b = r100;
        this.f418737a = r101;
    }
}
