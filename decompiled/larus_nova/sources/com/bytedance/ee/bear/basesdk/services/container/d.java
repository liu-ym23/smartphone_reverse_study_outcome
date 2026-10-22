package com.bytedance.ee.bear.basesdk.services.container;

import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.ee.bear.contract.Result;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class d<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f206633a;

    public d(c r100) {
        this.f206633a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Result r101 = (Result) r100;
        Intrinsics.checkNotNullParameter(r101, "stringResult");
        tt5.a.h("UserDomainCharacteristicServiceImpl", "fetchConfigFlowable()...result, code = " + r101.code + ", data = " + ((String) r101.data) + ", msg = " + r101.msg);
        if (r101.code != 0) goto L5;
        c.a(this.f206633a, r101);
        return (String) r101.data;
    L5:
        return SliceInitService.DEFAULT_SWITCH;
    }
}
