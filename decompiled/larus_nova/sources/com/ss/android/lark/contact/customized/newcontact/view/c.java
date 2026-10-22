package com.ss.android.lark.contact.customized.newcontact.view;

import android.view.View;
import com.ss.android.lark.contact.base.contact_new.mvp.NewContactView;
import com.ss.android.lark.widget.listener.OnSingleClickListener;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class c extends OnSingleClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficeNewContactAdapter f419370a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ NewContactView.a f419371b;

    @Override // com.ss.android.lark.widget.listener.OnSingleClickListener
    public final void onSingleClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        OfficeNewContactAdapter.a r101 = this.f419370a.f419356b;
        if (r101 == null) goto L6;
        NewContactView.a r102 = this.f419371b;
        r101.b(r102.f418722b, r102.f418721a);
        return;
    }

    public c(OfficeNewContactAdapter r100, NewContactView.a r101) {
        this.f419370a = r100;
        this.f419371b = r101;
    }
}
