package com.larus.caijing_pay.impl.init;

import com.android.ttcjpaysdk.ttcjpayapi.IH5PayCallback;
import com.bytedance.applet.impl.e0;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes26.dex */
public final class j implements IH5PayCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function2<Integer, String, Unit> f321310a;

    public j(e0 r100) {
        this.f321310a = r100;
    }

    @Override // com.android.ttcjpaysdk.ttcjpayapi.IH5PayCallback
    public final void onResult(int r100, String r101) {
        Function2<Integer, String, Unit> r102 = this.f321310a;
        if (r102 == null) goto L6;
        r102.invoke(Integer.valueOf(r100), r101);
        return;
    }
}
