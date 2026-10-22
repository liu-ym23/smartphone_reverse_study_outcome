package com.vivo.push.ups;

import com.vivo.push.IPushActionListener;

/* JADX INFO: loaded from: classes41.dex */
final class b implements IPushActionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ UPSRegisterCallback f462523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ VUpsManager f462524b;

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int r100) {
        this.f462523a.onResult(new TokenResult(r100, ""));
    }

    public b(VUpsManager r100, UPSRegisterCallback r101) {
        this.f462524b = r100;
        this.f462523a = r101;
    }
}
