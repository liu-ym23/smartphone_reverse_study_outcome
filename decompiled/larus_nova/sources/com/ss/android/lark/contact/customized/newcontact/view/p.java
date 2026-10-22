package com.ss.android.lark.contact.customized.newcontact.view;

import android.view.View;
import com.ss.android.lark.contact.base.statistics.ContactHitPoint;

/* JADX INFO: loaded from: classes35.dex */
public final class p implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f419392a;

    public p(l r100) {
        this.f419392a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        ContactHitPoint.d("add_external");
        this.f419392a.f419383b.z();
    }
}
