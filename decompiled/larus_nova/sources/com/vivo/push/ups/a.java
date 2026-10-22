package com.vivo.push.ups;

import com.vivo.push.IPushActionListener;

/* JADX INFO: loaded from: classes41.dex */
final class a implements IPushActionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ UPSRegisterCallback f462521a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ VUpsManager f462522b;

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int r100) {
        this.f462521a.onResult(new TokenResult(r100, com.vivo.push.restructure.a.a().h().b()));
    }

    public a(VUpsManager r100, UPSRegisterCallback r101) {
        this.f462522b = r100;
        this.f462521a = r101;
    }
}
