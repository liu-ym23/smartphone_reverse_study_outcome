package com.ss.android.lark.contact.customized.newcontact.view;

import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class i<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficeNewContactFragment f419379a;

    public i(OfficeNewContactFragment r100) {
        this.f419379a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        if (Intrinsics.areEqual((Boolean) r100, Boolean.TRUE) == false) goto L9;
        l r101 = this.f419379a.f419364e;
        if (r101 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("newContactView");
        r101 = null;
    L7:
        r101.f419382a.f419025c.refreshComplete();
        return;
    }
}
