package com.bytedance.android.shopping.mall.homepage.tools;

import com.bytedance.android.ec.hybrid.ECHybridExtensionsKt;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.shopping.api.mall.common.tools.NativeMallGeckoHelper;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class DataEngineMap$ECMallGeckoChangedListener$onClean$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $channel;
    final /* synthetic */ Long $version;

    public DataEngineMap$ECMallGeckoChangedListener$onClean$1(String r1, Long r2) {
        this.$channel = r1;
        this.$version = r2;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1434invoke() {
        if (Intrinsics.areEqual(this.$channel, NativeMallGeckoHelper.b()) == false) goto L6;
        Lazy r0 = ECMallLogUtil.a;
        ECMallLogUtil.a(com.bytedance.android.ec.hybrid.log.mall.m.b.b, "ECMallGeckoChangedListener#onClean(), channel = " + this.$channel + ", version = " + this.$version);
        ECHybridExtensionsKt.f(new AnonymousClass1(this));
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1434invoke();
        return Unit.INSTANCE;
    }
}
