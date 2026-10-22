package com.ss.android.lark.contact.customized.externalcontact.view;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ContactItemDeleteDialogBuilder f419200a;

    public a(ContactItemDeleteDialogBuilder r100) {
        this.f419200a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Function0<Unit> r101 = this.f419200a.f419153f;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dismiss");
        r101 = null;
    L5:
        r101.invoke();
    }
}
