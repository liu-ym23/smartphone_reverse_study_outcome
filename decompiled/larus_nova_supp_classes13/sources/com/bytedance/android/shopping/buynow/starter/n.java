package com.bytedance.android.shopping.buynow.starter;

import android.content.Context;
import com.bytedance.android.shopping.buynow.controller.s;
import com.bytedance.kmp.ec.yata.common.biz.YataPageInfo;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public interface n {
    nl.c a();

    s b();

    void c(Context r1, com.bytedance.android.shopping.sku.common.data.e r2);

    void d(Object r1);

    void e(Function1<? super d, Unit> r1);

    boolean f();

    boolean g();

    YataPageInfo getPageInfo();

    String getSourceBtmToken();

    d h();

    void i(Context r1, boolean r2);

    Map<String, Object> j();

    void k(Function0<Unit> r1);

    void release();
}
