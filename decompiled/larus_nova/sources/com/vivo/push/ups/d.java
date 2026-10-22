package com.vivo.push.ups;

import com.vivo.push.IPushActionListener;

/* JADX INFO: loaded from: classes41.dex */
final class d implements IPushActionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ UPSTurnCallback f462527a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ VUpsManager f462528b;

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int r100) {
        this.f462527a.onResult(new CodeResult(r100));
    }

    public d(VUpsManager r100, UPSTurnCallback r101) {
        this.f462528b = r100;
        this.f462527a = r101;
    }
}
