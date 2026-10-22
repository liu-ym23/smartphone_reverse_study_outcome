package com.bytedance.ee.bear.debug;

import android.text.Editable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class b extends AppendParamsActivity.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AppendParamsActivity.b f217365a;

    public b(AppendParamsActivity.b r100) {
        this.f217365a = r100;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
        AppendParamsActivity.b r101 = this.f217365a;
        if (r100 == null) goto L6;
        String r102 = r100.toString();
        if (r102 == null) goto L6;
    L7:
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r101.f217350a = r102;
        return;
    L6:
        r102 = "";
        goto L7
    }
}
