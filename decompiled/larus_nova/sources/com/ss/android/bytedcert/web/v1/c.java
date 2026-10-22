package com.ss.android.bytedcert.web.v1;

import android.content.DialogInterface;
import com.bytedance.sdk.bridge.model.IBridgeContext;

/* JADX INFO: loaded from: classes34.dex */
public final class c implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IBridgeContext f407896a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ JSModule f407897b;

    public c(JSModule r100, IBridgeContext r101) {
        this.f407897b = r100;
        this.f407896a = r101;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        JSModule.a(this.f407897b, this.f407896a, 2);
    }
}
