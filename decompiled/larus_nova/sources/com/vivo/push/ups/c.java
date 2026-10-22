package com.vivo.push.ups;

import com.vivo.push.IPushActionListener;

/* JADX INFO: loaded from: classes41.dex */
final class c implements IPushActionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ UPSTurnCallback f462525a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ VUpsManager f462526b;

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int r100) {
        this.f462525a.onResult(new CodeResult(r100));
    }

    public c(VUpsManager r100, UPSTurnCallback r101) {
        this.f462526b = r100;
        this.f462525a = r101;
    }
}
