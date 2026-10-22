package com.bytedance.android.shopping.store.product;

import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListDTO;
import com.bytedance.android.ec.hybrid.list.entity.k;
import com.bytedance.android.ec.store.repository.vo.StoreV2ProductListResponseVO;
import com.bytedance.android.ec.store.repository.vo.n;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f {
    public static StoreV2ProductListResponseVO a(List r17, List r18, List r19, boolean r20, Integer r21, Long r22, Integer r23, String r24, Integer r25, n r26, Integer r27, List r28, Map r29, ECHybridListDTO r30, k r31, String r32, String r33, int r34) {
        String r2 = null;
        if ((r34 & 1) == 0) goto L5;
        List r1 = null;
    L7:
        if ((r34 & 2) == 0) goto L9;
        List r3 = null;
    L11:
        if ((r34 & 4) == 0) goto L13;
        List r4 = null;
    L14:
        int r6 = 0;
        if ((r34 & 8) == 0) goto L17;
        boolean r5 = false;
    L19:
        if ((r34 & 16) == 0) goto L21;
        Integer r7 = null;
    L23:
        if ((r34 & 256) == 0) goto L25;
        Integer r8 = null;
    L27:
        if ((r34 & 512) == 0) goto L29;
        n r9 = null;
    L31:
        if ((r34 & 1024) == 0) goto L33;
        Integer r10 = null;
    L35:
        if ((r34 & 2048) == 0) goto L37;
        List r11 = null;
    L39:
        if ((r34 & 4096) == 0) goto L41;
        Map r12 = null;
    L43:
        if ((r34 & 8192) == 0) goto L45;
        ECHybridListDTO r13 = null;
    L47:
        if ((r34 & 16384) == 0) goto L49;
        k r14 = null;
    L51:
        if ((32768 & r34) == 0) goto L53;
        String r15 = null;
    L55:
        if ((r34 & 65536) != 0) goto L58;
        r2 = r33;
    L58:
        StoreV2ProductListResponseVO r0 = new StoreV2ProductListResponseVO();
        r0.setGoodTypes(r1);
        r0.setSortTypes(r3);
        if (r4 == null) goto L61;
        r0.setProducts(r4);
    L61:
        r0.setHasMore(r5);
        if (r22 == null) goto L64;
        long r16 = r22.longValue();
    L65:
        r0.setCursor(r16);
        if (r23 == null) goto L68;
        r6 = r23.intValue();
    L68:
        r0.setRecommendModuleType(r6);
        r0.setBottomModuleParams(r24);
        r0.setLayoutType(r8);
        r0.setDiscountFilterButtons(r9);
        r0.setForceProductLayout(r10);
        r0.setStyleType(r7);
        r0.setPickTypes(r11);
        r0.setBizExtra(r12);
        r0.setHybridList(r13);
        r0.setHybridListVO(r14);
        r0.setPaginationParams(r15);
        r0.setHybridParams(r2);
        return r0;
    L64:
        r16 = 0;
        goto L65
    L53:
        r15 = r32;
        goto L55
    L49:
        r14 = r31;
        goto L51
    L45:
        r13 = r30;
        goto L47
    L41:
        r12 = r29;
        goto L43
    L37:
        r11 = r28;
        goto L39
    L33:
        r10 = r27;
        goto L35
    L29:
        r9 = r26;
        goto L31
    L25:
        r8 = r25;
        goto L27
    L21:
        r7 = r21;
        goto L23
    L17:
        r5 = r20;
        goto L19
    L13:
        r4 = r19;
        goto L14
    L9:
        r3 = r18;
        goto L11
    L5:
        r1 = r17;
        goto L7
    }
}
