package com.ss.android.lark.contact.customized.externalcontact.view;

import androidx.lifecycle.Observer;
import com.ss.android.lark.contact.base.dependency.ContactBaseModuleDependency;

/* JADX INFO: loaded from: classes35.dex */
public final class i<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficeExternalContactFragment f419211a;

    public i(OfficeExternalContactFragment r100) {
        this.f419211a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        String r101 = (String) r100;
        if (r101 == null) goto L6;
        ContactBaseModuleDependency.f418857b.jumpProfilePage(OfficeExternalContactFragment.U90(this.f419211a), r101, 17);
        return;
    }
}
