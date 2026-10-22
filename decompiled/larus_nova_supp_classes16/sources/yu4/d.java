package yu4;

import com.bytedance.ee.bear.bitable.statistic.BitableStatisticEventModel$NormalPointModel;
import com.bytedance.ee.bear.bitable.statistic.m;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d {
    public static final Lazy a = null;
    public static final LinkedList<String> b = null;
    public static final Map<String, String> c = null;

    public d() {
    }

    static {
        a = org.koin.java.a.d(m.class);
        b = new LinkedList();
        c = MapsKt.mapOf(new Pair[]{TuplesKt.to("update_record_apply_succeed", "BASE_ITEM_VIEW_EDIT_JSSDK_SET_RECORD"), TuplesKt.to("update_record_get_cards_succeed", "BASE_ITEM_VIEW_EDIT_JSSDK_GEN_CARDS_DATA")});
    }

    public static m a() {
        return (m) a.getValue();
    }

    @JvmStatic
    public static final void c(String r1) {
        if (r1 == null) goto L4;
        b.push(r1);
    L4:
        b(r1, "BASE_ITEM_VIEW_EDIT_REQUEST_RECORD_DATA_FINISH");
    }

    public static void b(String r7, String r8) {
        long r2 = System.currentTimeMillis();
        if (r7 == null) goto L6;
        a().addNormalPoint(r7, BitableStatisticEventModel$NormalPointModel.a.c(BitableStatisticEventModel$NormalPointModel.Companion, r8, r2, false, 12));
        return;
    }
}
