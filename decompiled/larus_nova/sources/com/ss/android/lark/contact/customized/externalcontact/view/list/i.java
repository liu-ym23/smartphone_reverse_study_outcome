package com.ss.android.lark.contact.customized.externalcontact.view.list;

import android.view.View;
import com.ss.android.lark.contact.customized.externalcontact.view.OfficeContactListAdapter;
import com.ss.android.lark.contact.customized.externalcontact.view.OfficeExternalContactFragment$initExternalContactView$actionHandler$1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class i implements OfficeContactListAdapter.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a.InterfaceC4935a f419230a;

    public i(OfficeExternalContactFragment$initExternalContactView$actionHandler$1 r100) {
        this.f419230a = r100;
    }

    @Override // com.ss.android.lark.contact.customized.externalcontact.view.OfficeContactListAdapter.a
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "chatterId");
        this.f419230a.a(r100);
    }

    @Override // com.ss.android.lark.contact.customized.externalcontact.view.OfficeContactListAdapter.a
    public final void b(View r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "anchorView");
        this.f419230a.b(r100, r101);
    }
}
