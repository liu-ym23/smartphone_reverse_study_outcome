package ji2;

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
        Integer r10 = Integer.valueOf(MonitorLevel.ERROR);
        a = new LargeModeConfig("LargeFont", "List", "Large", "1.15", CollectionsKt.listOf(new ComponentLargeModeConfig[]{new ComponentLargeModeConfig("List.Tab.Text.Selected", null, new hi2.a(18, 600, 4), 2, null), new ComponentLargeModeConfig("List.Tab.Text.Unselected", null, new hi2.a(15, r10, 4), 2, null), new ComponentLargeModeConfig("List.Tab.Text.Disabled", null, new hi2.a(15, r10, 4), 2, null), new ComponentLargeModeConfig("List.Header", new LayoutLargeModeConfig(null, new LayoutSizeLargeModeConfig(LayoutSizeLargeModeConfig.TYPE_SIZE_DP, 56.0f), null, null, null, null, null, null, null, null, null, null, 4093, null), null, 4, null), new ComponentLargeModeConfig("List.Header.Avatar", new LayoutLargeModeConfig(new LayoutSizeLargeModeConfig(LayoutSizeLargeModeConfig.TYPE_SIZE_DP, 46.0f), new LayoutSizeLargeModeConfig(LayoutSizeLargeModeConfig.TYPE_SIZE_DP, 46.0f), null, null, null, null, null, null, null, null, null, null, 4092, null), null, 4, null), new ComponentLargeModeConfig("List.Header.Avatar.Title", new LayoutLargeModeConfig(null, new LayoutSizeLargeModeConfig(LayoutSizeLargeModeConfig.TYPE_SIZE_DP, 17.0f), null, null, null, 30, null, null, null, null, null, null, 4061, null), new hi2.a(10, null, 6)), new ComponentLargeModeConfig("List.Header.SearchBar", new LayoutLargeModeConfig(null, null, null, 67, null, null, null, null, null, null, null, null, 4087, null), null, 4, null), new ComponentLargeModeConfig("List.Header.SearchBar.Icon", new LayoutLargeModeConfig(new LayoutSizeLargeModeConfig(LayoutSizeLargeModeConfig.TYPE_SIZE_DP, 18.0f), new LayoutSizeLargeModeConfig(LayoutSizeLargeModeConfig.TYPE_SIZE_DP, 18.0f), null, null, null, null, null, null, null, null, null, null, 4092, null), null, 4, null), new ComponentLargeModeConfig("List.Header.SearchBar.Hint", null, new hi2.a(16, null, 6), 2, null), new ComponentLargeModeConfig("List.Header.Entry.Icon", new LayoutLargeModeConfig(new LayoutSizeLargeModeConfig(LayoutSizeLargeModeConfig.TYPE_SIZE_DP, 18.0f), new LayoutSizeLargeModeConfig(LayoutSizeLargeModeConfig.TYPE_SIZE_DP, 18.0f), null, null, null, null, null, null, null, null, null, null, 4092, null), null, 4, null), new ComponentLargeModeConfig("List.Header.Entry.CartIcon", new LayoutLargeModeConfig(new LayoutSizeLargeModeConfig(LayoutSizeLargeModeConfig.TYPE_SIZE_DP, 24.75f), new LayoutSizeLargeModeConfig(LayoutSizeLargeModeConfig.TYPE_SIZE_DP, 24.75f), null, null, null, -2, null, null, null, null, null, null, 4060, null), null, 4, null), new ComponentLargeModeConfig("List.Header.Entry.Title", new LayoutLargeModeConfig(null, null, null, null, null, 20, null, null, null, null, null, null, 4063, null), new hi2.a(11, null, 6))}));
    }
}
