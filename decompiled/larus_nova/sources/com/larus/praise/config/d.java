package com.larus.praise.config;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.larus.common.apphost.AppHost;

/* JADX INFO: loaded from: classes31.dex */
public final class d implements y57.e {
    public d() {
    }

    @Override // y57.e
    public void startActivity(Context r100, Intent r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (r100 != null) goto L9;
        AppHost.Companion r102 = AppHost.f326268a;
        Activity r103 = r102.a().getCurrentActivity();
        if (r103 == null) goto L8;
        r100 = r103;
        goto L9
    L8:
        r100 = r102.getApplication();
    L9:
        r100.startActivity(r101);
    }

    @Override // y57.e
    public void startActivityForResult(Activity r100, Intent r101, int r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r101 != null) goto L6;
        return;
    L6:
        r100.startActivityForResult(r101, r102);
    }
}
