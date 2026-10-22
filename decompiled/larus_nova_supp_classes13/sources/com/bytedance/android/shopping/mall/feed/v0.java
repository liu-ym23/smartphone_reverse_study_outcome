package com.bytedance.android.shopping.mall.feed;

import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListDTO;
import com.bytedance.android.shopping.api.mall.model.BffBizInfo;
import com.bytedance.android.shopping.api.mall.model.HomePageBffDTO;
import com.bytedance.android.shopping.api.mall.model.HomePageDTO;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import java.util.concurrent.Callable;
import kotlin.Lazy;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class v0<V> implements Callable {
    public final /* synthetic */ ECMallFeedComponent a;
    public final /* synthetic */ String b;

    public v0(ECMallFeedComponent r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.util.concurrent.Callable
    public final Pair<ECHybridListDTO, com.bytedance.android.shopping.api.mall.idl.b> call() {
        ECMallFeedComponent r0 = this.a;
        Lazy r1 = ECMallFeedComponent.p0;
        ECMallFeedLocalStorage r2 = (ECMallFeedLocalStorage) r0.I.getValue();
        String r3 = null;
        if (r2 == null) goto L7;
        String r4 = r2.c(this.b);
        if (r4 == null) goto L7;
        String r5 = com.bytedance.android.shopping.api.mall.common.tools.b0.k(r4);
    L8:
        if (r5 == null) goto L22;
        HomePageDTO r6 = (HomePageDTO) GsonProtectorUtils.fromJson(new Gson(), r5, HomePageDTO.class);
        if (r6 == null) goto L23;
        HomePageBffDTO r7 = r6.getBff();
        if (r7 == null) goto L24;
        ECHybridListDTO r8 = r7.getFeed();
        if (r8 == null) goto L25;
        ECHybridListDTO.a r9 = ECHybridListDTO.Companion;
        HomePageBffDTO r10 = r6.getBff();
        if (r10 == null) goto L20;
        BffBizInfo r11 = r10.getBizInfo();
        if (r11 == null) goto L20;
        r3 = r11.getEcSceneId();
    L20:
        com.bytedance.android.ec.hybrid.list.entity.dto.a r12 = new com.bytedance.android.ec.hybrid.list.entity.dto.a(1, r3, 190);
        r9.getClass();
        return new Pair(r8, new com.bytedance.android.shopping.api.mall.idl.b(ECHybridListDTO.a.d(r8, true, r12), r8.getCursor(), r8.getHasMore(), System.currentTimeMillis()));
    L25:
        return null;
    L24:
        return null;
    L23:
        return null;
    L22:
        return null;
    L7:
        r5 = null;
        goto L8
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }
}
