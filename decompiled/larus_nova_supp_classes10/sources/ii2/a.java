package ii2;

import com.bytedance.android.livesdk.livecommerce.largemode.model.ComponentLargeModeConfig;
import com.bytedance.android.livesdk.livecommerce.largemode.model.LargeModeConfig;
import com.bytedance.android.livesdk.livecommerce.largemode.model.LayoutLargeModeConfig;
import com.bytedance.android.livesdk.livecommerce.largemode.model.LayoutSizeLargeModeConfig;
import com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.monitor.MonitorLevel;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a {
    public static final LargeModeConfig a = null;

    static {
        a = new LargeModeConfig("LargeFont", "ExplainCard", "Large", "1.15", CollectionsKt.listOf(new ComponentLargeModeConfig[]{new ComponentLargeModeConfig("ExplainCard.TopArea", new LayoutLargeModeConfig(null, new LayoutSizeLargeModeConfig(LayoutSizeLargeModeConfig.TYPE_SIZE_DP, 22.0f), null, null, null, null, null, null, null, null, null, null, 4093, null), null, 4, null), new ComponentLargeModeConfig("ExplainCard.TopArea.Tag", new LayoutLargeModeConfig(null, new LayoutSizeLargeModeConfig(LayoutSizeLargeModeConfig.TYPE_SIZE_DP, 18.0f), null, null, null, null, null, null, null, null, null, null, 4093, null), null, 4, null), new ComponentLargeModeConfig("ExplainCard.TopArea.Close", new LayoutLargeModeConfig(new LayoutSizeLargeModeConfig(LayoutSizeLargeModeConfig.TYPE_SIZE_DP, 18.0f), new LayoutSizeLargeModeConfig(LayoutSizeLargeModeConfig.TYPE_SIZE_DP, 18.0f), null, null, null, null, null, null, null, null, null, null, 4092, null), null, 4, null), new ComponentLargeModeConfig("ExplainCard.TopArea.Tag.Text", null, new hi2.a(11, null, 6), 2, null), new ComponentLargeModeConfig("ExplainCard.Title", null, new hi2.a(11, Integer.valueOf(MonitorLevel.FATAL), 4), 2, null), new ComponentLargeModeConfig("ExplainCard.SellPoint", null, new hi2.a(11, null, 6), 2, null), new ComponentLargeModeConfig("ExplainCard.Price.Yuan", null, new hi2.a(11, null, 6), 2, null), new ComponentLargeModeConfig("ExplainCard.Price.Integer", null, new hi2.a(16, null, 6), 2, null), new ComponentLargeModeConfig("ExplainCard.Price.Decimal", null, new hi2.a(16, null, 6), 2, null)}));
    }
}
