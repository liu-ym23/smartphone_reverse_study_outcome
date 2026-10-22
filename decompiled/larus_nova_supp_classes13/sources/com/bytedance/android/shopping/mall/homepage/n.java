package com.bytedance.android.shopping.mall.homepage;

import android.view.ViewGroup;
import com.bytedance.android.ec.hybrid.card.api.ECLynxCardErrorType;
import com.bytedance.android.ec.hybrid.card.impl.ECLynxCard;
import com.bytedance.android.shopping.mall.homepage.card.LynxCardType;
import com.bytedance.android.shopping.verse.api.IVerseService;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class n extends rj.a {
    public final /* synthetic */ ECMallFragment d;
    public final /* synthetic */ ViewGroup e;

    public final void onLoadSuccess() {
        super.onLoadSuccess();
        ECMallFragment r0 = this.d;
        int r1 = ECMallFragment.h4;
        r0.Ra0();
        com.bytedance.android.shopping.mall.homepage.card.e r2 = this.d.U;
        r2.getClass();
        Intrinsics.checkNotNullParameter(LynxCardType.MALL_POPUP, "type");
        r2.a.put(LynxCardType.MALL_POPUP, Boolean.TRUE);
        Set r3 = (Set) ((LinkedHashMap) r2.b).get(LynxCardType.MALL_POPUP);
        if (r3 == null) goto L8;
        Iterator r4 = r3.iterator();
    L6:
        if (r4.hasNext() == false) goto L8;
        ((com.bytedance.android.shopping.mall.homepage.card.b) r4.next()).run();
    L8:
        this.e.setVisibility(0);
        ECMallFragment.V90(this.d, true, null);
    }

    public final void onTimingSetup(Map<String, ? extends Object> r27) {
        super.onTimingSetup(r27);
        ECMallFragment r1 = this.d;
        ECLynxCard r11 = r1.k1;
        if (r11 == null) goto L5;
        IVerseService r2 = ECLynxCard.f;
        ECLynxCard.m(r11, true, "page", ECLynxCard.a.a(r1.x3, r1.y3), true, false, false, this.d.M1, 176);
    L5:
        Object r3 = null;
        if (r27 == null) goto L8;
        Object r4 = r27.get("setup_timing");
    L10:
        if ((r4 instanceof Map) == true) goto L12;
        r4 = null;
    L12:
        Map r5 = (Map) r4;
        if (r5 != null) goto L15;
        return;
    L15:
        ECMallFragment r8 = this.d;
        y93.d r6 = r8.y1;
        Object r7 = r5.get("draw_end");
        if ((r7 instanceof Long) == true) goto L18;
        r7 = null;
    L18:
        Long r24 = (Long) r7;
        Object r9 = r5.get("load_template_start");
        if ((r9 instanceof Long) == false) goto L22;
        r3 = r9;
    L22:
        r8.y1 = y93.d.a(r6, null, null, 1, null, null, (Long) r3, r24, null, r27, null, null, null, null, null, null, null, null, 0, false, 8387995);
        ECMallFragment r10 = this.d;
        r10.d.n(r10.y1);
        ECMallFragment r12 = this.d;
        r12.y1 = y93.d.a(r12.y1, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, true, 4194303);
        return;
    L8:
        r4 = null;
        goto L10
    }

    public n(ECMallFragment r1, ViewGroup r2, ECLynxCard r3) {
        this.d = r1;
        this.e = r2;
        super(r3, "popupLayer");
    }

    public final void onLoadFailed(ECLynxCardErrorType r44, Integer r45, String r46) {
        Intrinsics.checkNotNullParameter(r44, "type");
        super.onLoadFailed(r44, r45, r46);
        ECMallFragment r15 = this.d;
        r15.y1 = y93.d.a(r15.y1, null, null, 0, r45, r46, null, null, null, null, null, null, null, null, null, null, null, null, 0, false, 8388579);
        ECMallFragment r1 = this.d;
        r1.d.n(r1.y1);
        ECMallFragment r2 = this.d;
        r2.y1 = y93.d.a(r2.y1, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, true, 4194303);
        ECMallFragment.V90(this.d, false, r46);
    }
}
