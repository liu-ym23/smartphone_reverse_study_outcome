package com.ss.android.lark.contact.customized.externalcontact.view;

import android.view.View;
import com.ss.android.lark.widget.listener.OnSingleClickListener;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class c extends OnSingleClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficeContactListAdapter f419202a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f419203b;

    @Override // com.ss.android.lark.widget.listener.OnSingleClickListener
    public final void onSingleClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        OfficeContactListAdapter.a r101 = this.f419202a.f419159e;
        if (r101 == null) goto L6;
        r101.a(this.f419203b);
        return;
    }

    public c(OfficeContactListAdapter r100, String r101) {
        this.f419202a = r100;
        this.f419203b = r101;
    }
}
