package com.ss.android.lark.contact.customized.search.view;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.contact.customized.databinding.ContactDbInviteSearchViewLayoutBinding;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficeInviteExternalSearchFragment f419425a;

    public f(OfficeInviteExternalSearchFragment r100) {
        this.f419425a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ContactDbInviteSearchViewLayoutBinding r100 = this.f419425a.f419412d;     // Catch: Throwable -> L7
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");     // Catch: Throwable -> L7
        r100 = null;
    L5:
        com.ss.android.lark.inv.export.util.e.b(r100.f419078j);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
