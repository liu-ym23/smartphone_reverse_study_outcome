package com.bytedance.android.shopping.mall.feed.opt;

import android.content.Context;
import com.bytedance.android.ec.hybrid.list.entity.dto.ChipViewConfig;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListDTO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListItemDTO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListSectionDTO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECNAMallCardExtra;
import com.bytedance.android.shopping.api.mall.model.HomePageBffDTO;
import com.bytedance.android.shopping.api.mall.model.HomePageDTO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c implements a {
    public c() {
    }

    public static void c(HomePageDTO r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        ArrayList r0 = new ArrayList();
        HomePageBffDTO r4 = r3.getBff();
        if (r4 == null) goto L24;
        ECHybridListDTO r5 = r4.getFeed();
        if (r5 == null) goto L24;
        List r6 = r5.getSections();
        if (r6 == null) goto L24;
        Iterator r7 = r6.iterator();
    L12:
        if (r7.hasNext() == false) goto L24;
        ArrayList r1 = ((ECHybridListSectionDTO) r7.next()).getItems();
        if (r1 == null) goto L12;
        Iterator r2 = r1.iterator();
    L17:
        if (r2.hasNext() == false) goto L12;
        ECNAMallCardExtra r8 = ((ECHybridListItemDTO) r2.next()).getExtra();
        if (r8 == null) goto L17;
        ChipViewConfig r9 = r8.getChipViewConfig();
        if (r9 == null) goto L17;
        r0.add(r9);
    L24:
        if (r0.isEmpty() == true) goto L39;
        com.bytedance.android.ec.hybrid.a.d().submit(new b(r0));
        return;
    }

    @Override // com.bytedance.android.shopping.mall.feed.opt.a
    public final void a(Context r2, HomePageDTO r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        c(r3);
    }

    @Override // com.bytedance.android.shopping.mall.feed.opt.a
    public final void b(Context r2, HomePageDTO r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        c(r3);
    }
}
