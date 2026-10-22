package com.bytedance.android.shopping.anchorv4.voavhs.detailhead;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv3.repository.dto.DetailCombinePropertiesComponent;
import com.bytedance.android.shopping.anchorv3.repository.dto.DetailCombinePropertiesSkusStruct;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    public b() {
    }

    static {
    }

    public static String b(DetailCombinePropertiesComponent r1) {
        if (r1 == null) goto L14;
        List r2 = r1.getSkus();
        if (r2 == null) goto L8;
        DetailCombinePropertiesSkusStruct r3 = (DetailCombinePropertiesSkusStruct) ListProtector.get(r2, 0);
        if (r3 == null) goto L8;
        ECUrlModel r4 = r3.getPic();
    L9:
        if (r4 != null) goto L12;
        return "word";
    L12:
        return "picture";
    L8:
        r4 = null;
        goto L9
    L14:
        return "";
    }

    public static void a(t r9, int r10, boolean r11, String r12) {
        if (r9 == null) goto L9;
        Pair[] r0 = new Pair[3];
        r0[0] = TuplesKt.to("params_cnt", Integer.valueOf(r10));
        if (r11 == false) goto L6;
        String r13 = "1";
    L7:
        r0[1] = TuplesKt.to("is_fold", r13);
        r0[2] = TuplesKt.to("params_list", String.valueOf(r12));
        com.bytedance.android.shopping.anchorv4.voavhs.car.f.a.a(r9, "click_product_feature_unfold", MapsKt.mapOf(r0), false, null, null, null, null, 252);
        return;
    L6:
        r13 = "0";
        goto L7
    }
}
