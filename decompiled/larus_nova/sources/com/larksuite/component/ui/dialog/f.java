package com.larksuite.component.ui.dialog;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class f implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d<?> f284134a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f284135b;

    @Override // com.larksuite.component.ui.dialog.c
    public Context getContext() {
        return this.f284135b;
    }

    public f(d<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "lkuiDialogBuilder");
        this.f284134a = r100;
    }
}
