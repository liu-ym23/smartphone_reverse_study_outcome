package com.ss.android.lark.contact.customized.newcontact.view;

import android.view.View;
import com.ss.android.lark.contact.base.contact_new.mvp.NewContactView;
import com.ss.android.lark.contact.base.statistics.ContactHitPoint;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class d extends rcc.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficeNewContactAdapter f419372a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ NewContactView.a f419373b;

    @Override // rcc.c
    public final void a(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        ContactHitPoint.d("member_avatar");
        OfficeNewContactAdapter.a r101 = this.f419372a.f419356b;
        if (r101 == null) goto L6;
        NewContactView.a r102 = this.f419373b;
        r101.b(r102.f418722b, r102.f418721a);
        return;
    }

    public d(OfficeNewContactAdapter r100, NewContactView.a r101) {
        this.f419372a = r100;
        this.f419373b = r101;
    }
}
