package com.ss.android.lark.contact.customized.newcontact.view;

import androidx.lifecycle.Observer;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class k<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficeNewContactFragment f419381a;

    public k(OfficeNewContactFragment r100) {
        this.f419381a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Pair r101 = (Pair) r100;
        if (r101 == null) goto L9;
        l r102 = this.f419381a.f419364e;
        if (r102 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("newContactView");
        r102 = null;
    L7:
        String r103 = (String) r101.getFirst();
        String r104 = (String) r101.getSecond();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "userId");
        Intrinsics.checkNotNullParameter(r104, "friendRequestId");
        r102.f419383b.J(r103, r104);
        return;
    }
}
