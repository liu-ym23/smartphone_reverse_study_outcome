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

/* JADX INFO: loaded from: classes16.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f569224a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LinkedList<String> f569225b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, String> f569226c = null;

    public d() {
    }

    static {
        f569224a = org.koin.java.a.d(m.class);
        f569225b = new LinkedList();
        f569226c = MapsKt.mapOf(new Pair[]{TuplesKt.to("update_record_apply_succeed", "BASE_ITEM_VIEW_EDIT_JSSDK_SET_RECORD"), TuplesKt.to("update_record_get_cards_succeed", "BASE_ITEM_VIEW_EDIT_JSSDK_GEN_CARDS_DATA")});
    }

    public static m a() {
        return (m) f569224a.getValue();
    }

    @JvmStatic
    public static final void c(String r100) {
        if (r100 == null) goto L4;
        f569225b.push(r100);
    L4:
        b(r100, "BASE_ITEM_VIEW_EDIT_REQUEST_RECORD_DATA_FINISH");
    }

    public static void b(String r100, String r101) {
        long r102 = System.currentTimeMillis();
        if (r100 == null) goto L6;
        a().addNormalPoint(r100, BitableStatisticEventModel$NormalPointModel.a.c(BitableStatisticEventModel$NormalPointModel.Companion, r101, r102, false, 12));
        return;
    }
}
