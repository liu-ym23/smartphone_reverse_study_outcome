package com.unionpay;

import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes41.dex */
public final class y implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UPPayWapActivity f462204a;

    public y(UPPayWapActivity r100) {
        this.f462204a = r100;
    }

    @Override // com.unionpay.f
    public final void a(String r100, c r101) {
        UPPayWapActivity r102 = this.f462204a;
        if (r102 == null) goto L5;
        SharedPreferences.Editor r103 = r102.getSharedPreferences("UnionPayPluginEx.pref", 0).edit();
        r103.remove(r100);
        r103.commit();
    L5:
        if (r101 == null) goto L8;
        r101.a(UPPayWapActivity.b("0", "success", null));
        return;
    }
}
