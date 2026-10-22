package com.bytedance.android.shopping.mall.homepage.tools;

import android.content.Context;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListDTO;
import com.bytedance.android.shopping.api.mall.model.BffBizInfo;
import com.bytedance.android.shopping.api.mall.model.HomePageBffDTO;
import com.bytedance.android.shopping.api.mall.model.HomePageDTO;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class x {
    public static final com.bytedance.android.ec.hybrid.list.entity.k a(Context r4, String r5) {
        String r0 = null;
        if (r4 != null) goto L5;
        return null;
    L5:
        Intrinsics.checkNotNullParameter(r4, "context");
        if (r5 != null) goto L8;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == false) goto L14;
        r5 = "homepage_cache";
    L14:
        String r6 = q.d(r4, "{" + r5 + "}_lasted");
        if (r6 != null) goto L18;
        r6 = "";
    L18:
        if (com.bytedance.forest.utils.h.a(r6) == false) goto L33;
        HomePageDTO r7 = (HomePageDTO) GsonProtectorUtils.fromJson(new Gson(), r6, HomePageDTO.class);
        if (r7 == null) goto L33;
        HomePageBffDTO r8 = r7.getBff();
        if (r8 == null) goto L33;
        ECHybridListDTO r9 = r8.getFeed();
        if (r9 == null) goto L33;
        ECHybridListDTO.a r3 = ECHybridListDTO.Companion;
        HomePageBffDTO r10 = r7.getBff();
        if (r10 == null) goto L31;
        BffBizInfo r11 = r10.getBizInfo();
        if (r11 == null) goto L31;
        r0 = r11.getEcSceneId();
    L31:
        com.bytedance.android.ec.hybrid.list.entity.dto.a r12 = new com.bytedance.android.ec.hybrid.list.entity.dto.a(1, r0, 190);
        r3.getClass();
        return ECHybridListDTO.a.d(r9, true, r12);
    L33:
        return null;
    L8:
        if (r5.length() == 0) goto L11;
        r2 = false;
        goto L12
    }
}
