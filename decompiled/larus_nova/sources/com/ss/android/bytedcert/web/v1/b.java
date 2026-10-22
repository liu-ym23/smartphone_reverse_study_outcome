package com.ss.android.bytedcert.web.v1;

import android.content.DialogInterface;
import com.bytedance.sdk.bridge.model.IBridgeContext;

/* JADX INFO: loaded from: classes34.dex */
public final class b implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IBridgeContext f407894a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ JSModule f407895b;

    public b(JSModule r100, IBridgeContext r101) {
        this.f407895b = r100;
        this.f407894a = r101;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        JSModule.a(this.f407895b, this.f407894a, 1);
    }
}
