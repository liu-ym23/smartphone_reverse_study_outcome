package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.skin;

import com.bytedance.android.ec.core.utils.s;
import com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.monitor.MonitorLevel;
import com.bytedance.android.livesdk.livecommerce.skin.model.AbsECLiveSkinBaseUIConfig;
import com.bytedance.android.livesdk.livecommerce.skin.model.ECLiveSkinBackgroundElement;
import com.bytedance.android.livesdk.livecommerce.skin.model.ECLiveSkinBaseViewUIConfig;
import com.bytedance.android.livesdk.livecommerce.skin.model.ECLiveSkinBtnUIConfig;
import com.bytedance.android.livesdk.livecommerce.skin.model.ECLiveSkinTextElement;
import com.bytedance.bdlocation.exception.BDLocationException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class PromotionCardStyleHelper {
    public static final Map<String, Map<String, AbsECLiveSkinBaseUIConfig>> a = null;
    public static final Lazy b = null;
    public static final Map<String, Map<String, AbsECLiveSkinBaseUIConfig>> c = null;

    public static final class ButtonHelper {
        public static final ECLiveSkinBtnUIConfig a = null;
        public static final Lazy b = null;
        public static final Lazy c = null;
        public static final Lazy d = null;
        public static final Lazy e = null;

        static {
            List r1 = CollectionsKt.listOf(15);
            a = new ECLiveSkinBtnUIConfig(new ECLiveSkinBaseViewUIConfig(new ECLiveSkinTextElement(13, CollectionsKt.listOf("#FFFFFFFF"), MonitorLevel.FATAL), null, new ECLiveSkinBackgroundElement(null, CollectionsKt.listOf(new String[]{"#FFFF005C", "#FFFF005C", "#FFFF3443", "#FFFF9624"}), 1, null), null, null, 26, null), new ECLiveSkinBaseViewUIConfig(new ECLiveSkinTextElement(13, CollectionsKt.listOf("#FFFFFFFF"), MonitorLevel.FATAL), null, new ECLiveSkinBackgroundElement(null, CollectionsKt.listOf(new String[]{"#80FF005C", "#80FF005C", "#80FF3443", "#80FF9624"}), 1, null), null, null, 26, null), r1);
            b = LazyKt.lazy(PromotionCardStyleHelper$ButtonHelper$buttonOptStyleV1Enabled$2.INSTANCE);
            c = LazyKt.lazy(PromotionCardStyleHelper$ButtonHelper$buttonOptStyleV1Disabled$2.INSTANCE);
            d = LazyKt.lazy(PromotionCardStyleHelper$ButtonHelper$buttonOptStyleV2Enabled$2.INSTANCE);
            e = LazyKt.lazy(PromotionCardStyleHelper$ButtonHelper$buttonOptStyleV2Disabled$2.INSTANCE);
        }

        public static List a(List r2) {
            Intrinsics.checkNotNullParameter(r2, "$this$convertToColorIntList");
            ArrayList r0 = new ArrayList();
            Iterator r3 = r2.iterator();
        L4:
            if (r3.hasNext() == false) goto L8;
            Integer r1 = s.b((String) r3.next());
            if (r1 == null) goto L4;
            r0.add(r1);
            goto L4
        L8:
            return r0;
        }
    }

    static {
        a = new LinkedHashMap();
        b = LazyKt.lazy(PromotionCardStyleHelper$liveCardStyleConfigSettings$2.INSTANCE);
        c = MapsKt.mapOf(TuplesKt.to("button", MapsKt.mapOf(TuplesKt.to(BDLocationException.ERROR_TIMEOUT, ButtonHelper.a))));
    }
}
