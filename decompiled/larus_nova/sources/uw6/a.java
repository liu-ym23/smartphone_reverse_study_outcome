package uw6;

import androidx.core.app.NotificationCompat;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.ss.android.ugc.aweme.trade.goods.entity.PoiTripTradeSettingEntity;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f551948a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final PoiTripTradeSettingEntity f551949b = null;

    static {
        f551948a = CollectionsKt.listOf(NotificationCompat.CATEGORY_RECOMMENDATION);
        f551949b = (PoiTripTradeSettingEntity) HostServiceUtilsKt.g0().a("poi_trip_trade_settings", PoiTripTradeSettingEntity.class, null);
    }
}
