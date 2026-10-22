package com.larus.caijing_pay.impl.init;

import com.android.ttcjpaysdk.ttcjpayapi.IH5PayCallback;
import com.android.ttcjpaysdk.ttcjpayapi.TTCJPayUtils;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes26.dex */
public final class i implements IH5PayCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function2<Integer, String, Unit> f321309a;

    /* JADX WARN: Multi-variable type inference failed */
    public i(Function2<? super Integer, ? super String, Unit> r100) {
        this.f321309a = r100;
    }

    @Override // com.android.ttcjpaysdk.ttcjpayapi.IH5PayCallback
    public final void onResult(int r100, String r101) {
        FLogger.f375446a.i("CJPayServiceImpl", "pay result code: " + r100 + ", msg: " + r101);
        Function2<Integer, String, Unit> r102 = this.f321309a;
        if (r102 == null) goto L5;
        r102.invoke(Integer.valueOf(r100), r101);
    L5:
        TTCJPayUtils.Companion.getInstance().releaseAll();
    }
}
