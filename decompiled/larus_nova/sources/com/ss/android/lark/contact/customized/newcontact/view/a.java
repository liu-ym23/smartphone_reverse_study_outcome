package com.ss.android.lark.contact.customized.newcontact.view;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NewContactDeleteDialogBuilder f419368a;

    public a(NewContactDeleteDialogBuilder r100) {
        this.f419368a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Function0<Unit> r101 = this.f419368a.f419351e;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dismiss");
        r101 = null;
    L5:
        r101.invoke();
    }
}
