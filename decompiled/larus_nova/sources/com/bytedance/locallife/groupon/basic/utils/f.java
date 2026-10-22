package com.bytedance.locallife.groupon.basic.utils;

import com.bytedance.locallife.model.response.BaseResponse;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.SsResponse;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class f {
    public static final <T extends BaseResponse> e<T> a(Call<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        SsResponse<T> r101 = r100.execute();
        T r102 = r101.body();
        if (r101.isSuccessful() == true) goto L5;
    L7:
        e.b r103 = new e.b(new Exception(r101.body().message));
        r103.f258793b = r101.headers();
        return r103;
    L5:
        if (r102.status_code != 0) goto L7;
        e.d r104 = new e.d(r102);
        r104.f258796b = r101.headers();
        return r104;
    }
}
