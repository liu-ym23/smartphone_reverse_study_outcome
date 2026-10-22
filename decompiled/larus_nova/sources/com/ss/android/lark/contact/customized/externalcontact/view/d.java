package com.ss.android.lark.contact.customized.externalcontact.view;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class d implements View.OnLongClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficeContactListAdapter f419204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f419205b;

    public d(OfficeContactListAdapter r100, long r101) {
        this.f419204a = r100;
        this.f419205b = r101;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r100) {
        OfficeContactListAdapter.a r101 = this.f419204a.f419159e;
        if (r101 == null) goto L7;
        Intrinsics.checkNotNull(r100);
        r101.b(r100, this.f419205b);
        return true;
    L7:
        return true;
    }
}
