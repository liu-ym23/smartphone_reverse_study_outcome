package com.bytedance.sdk.account.impl;

import android.view.View;
import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public final class f implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.ss.android.token.e.a f268989a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Map f268990b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f268991c;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        com.ss.android.token.e.a r101 = this.f268989a;
        e r102 = (e) r101;
        r102.a(this.f268990b, this.f268991c);
    }

    public f(e r100, Object r101) {
        this.f268989a = r100;
        this.f268990b = null;
        this.f268991c = r101;
    }
}
