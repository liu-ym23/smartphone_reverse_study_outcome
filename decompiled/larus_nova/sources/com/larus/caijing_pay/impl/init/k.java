package com.larus.caijing_pay.impl.init;

import com.larus.camera.impl.utils.n;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
public final class k implements wc4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function2<Integer, String, Unit> f321311a;

    public k(n r100) {
        this.f321311a = r100;
    }

    @Override // wc4.a
    public final void onResult(int r100, String r101, JSONObject r102) {
        Intrinsics.checkNotNullParameter(r101, "msg");
        FLogger.f375446a.i("CJPayServiceImpl", "routeSign result code: " + r100 + ", msg: " + r101);
        Function2<Integer, String, Unit> r103 = this.f321311a;
        if (r103 == null) goto L6;
        r103.invoke(Integer.valueOf(r100), r101);
        return;
    }
}
