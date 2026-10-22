package com.bytedance.android.livesdk.livecommerce.room.utils;

import android.content.Context;
import com.bytedance.android.ec.model.sku.SkuShowAndDismissState;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface e {
    Function1<Long, Unit> a();

    Function2<String[], Long, Unit> b();

    Function1<SkuShowAndDismissState, Unit> c();

    Context context();

    String d();

    Function1<Boolean, Unit> e();
}
