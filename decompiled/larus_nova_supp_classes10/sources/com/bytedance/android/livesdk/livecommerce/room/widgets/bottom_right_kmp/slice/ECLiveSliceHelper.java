package com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right_kmp.slice;

import android.content.Context;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ecom.arch.slice.render.SliceRender;
import com.bytedance.android.ecom.arch.slice.render.elements.ElementTypes;
import com.bytedance.android.ecom.slice.ext.template.gecko.SlcGeckoTemplateMgr;
import com.bytedance.android.ecom.slice.ext.template.gecko.g;
import com.bytedance.android.ecom.slice.ext.template.gecko.j;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.slice.api.ISliceInitService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import wh.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class ECLiveSliceHelper {
    public static boolean a;
    public static final g b = null;

    static {
        List<String> r1 = ECLiveABUtils.INSTANCE.getEC_LIVE_POP_CARD_SLICE_TEMPLATE();
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator<T> r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        String r4 = (String) r3.next();
        r2.add(new j(r4, r4, 1));
        goto L4
    L6:
        b = new g((ArrayList) CollectionsKt.toCollection(r2, new ArrayList()), 6);
    }

    public static void a() {
        Context r0 = ECAppInfoService.e.getApplicationContext();
        if (r0 != null) goto L5;
        return;
    L5:
        int r1 = ECSdk.a;
        ISliceInitService r2 = (ISliceInitService) ECSdk.a(ISliceInitService.class);
        if (r2 == null) goto L8;
        r2.initSlice();
    L8:
        SlcGeckoTemplateMgr.f(SlcGeckoTemplateMgr.l, "ec_live", "ecom_live_slice", a.b(r0), ECLiveSliceHelper$preloadSlice$1.INSTANCE);
    }

    public static void b() {
        if (a == false) goto L5;
        return;
    L5:
        SliceRender r0 = SliceRender.o;
        ECLiveSliceHelper$registerSliceElement$1 r1 = ECLiveSliceHelper$registerSliceElement$1.INSTANCE;
        r0.getClass();
        ElementTypes.b("IESECLiveAtmosphere", r1);
        ElementTypes.b("IESECLiveAuctionBidAtmosphere", ECLiveSliceHelper$registerSliceElement$2.INSTANCE);
        ElementTypes.b("IESECLiveAuctionBidAtmosphereV2", ECLiveSliceHelper$registerSliceElement$3.INSTANCE);
        ElementTypes.b("IESECLivePriceLabel", ECLiveSliceHelper$registerSliceElement$4.INSTANCE);
        a = true;
    }
}
