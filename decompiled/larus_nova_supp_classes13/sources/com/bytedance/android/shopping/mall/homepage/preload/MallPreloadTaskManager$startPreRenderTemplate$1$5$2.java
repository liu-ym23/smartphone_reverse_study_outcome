package com.bytedance.android.shopping.mall.homepage.preload;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/m$b;", "it", "", "invoke", "(Lcom/bytedance/android/shopping/api/mall/m$b;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class MallPreloadTaskManager$startPreRenderTemplate$1$5$2 extends Lambda implements Function1<com.bytedance.android.shopping.api.mall.m.b, Boolean> {
    public static final MallPreloadTaskManager$startPreRenderTemplate$1$5$2 INSTANCE = null;

    static {
        INSTANCE = new MallPreloadTaskManager$startPreRenderTemplate$1$5$2();
    }

    public MallPreloadTaskManager$startPreRenderTemplate$1$5$2() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return Boolean.valueOf(invoke((com.bytedance.android.shopping.api.mall.m.b) r1));
    }

    public final boolean invoke(com.bytedance.android.shopping.api.mall.m.b r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return r2 instanceof com.bytedance.android.shopping.api.mall.m.a;
    }
}
