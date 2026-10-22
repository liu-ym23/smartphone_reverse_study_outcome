package com.unionpay.tsmservice.mini;

import android.os.Bundle;

/* JADX INFO: loaded from: classes41.dex */
final class UPTsmAddonMini$b extends ITsmCallback.Stub {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f462190a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ITsmCallback f462191b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f462192c;

    private UPTsmAddonMini$b(a r100, ITsmCallback r101, int r102) {
        this.f462190a = r100;
        this.f462191b = r101;
        this.f462192c = r102;
    }

    public /* synthetic */ UPTsmAddonMini$b(a r100, ITsmCallback r101, int r102, byte r103) {
        this(r100, r101, r102);
    }

    @Override // com.unionpay.tsmservice.mini.ITsmCallback
    public final void onError(String r100, String r101) {
        ITsmCallback r102 = this.f462191b;
        if (r102 == null) goto L6;
        r102.onError(r100, r101);
        return;
    }

    @Override // com.unionpay.tsmservice.mini.ITsmCallback
    public final void onResult(Bundle r100) {
        if (this.f462191b == null) goto L6;
        r100.putInt("interfaceId", this.f462192c);
        this.f462191b.onResult(r100);
        return;
    }
}
