package mv9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u0000H\u0016R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0016\u0010\n\u001a\u00020\u00058\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0016\u0010\f\u001a\u00020\u00058\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/larus/settings/provider/notice/NoticeSyncConfig;", "Lcom/bytedance/news/common/settings/api/annotation/IDefaultValueProvider;", "<init>", "()V", "noticeListRefreshInterval", "", "getNoticeListRefreshInterval", "()I", "noticeUnreadCountPollingInterval", "getNoticeUnreadCountPollingInterval", "noticeListAppearRefreshMaxInterval", "getNoticeListAppearRefreshMaxInterval", "noticeBannerRefreshInterval", "getNoticeBannerRefreshInterval", "create", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    @SerializedName("notice_banner_refresh_interval")
    private final int noticeBannerRefreshInterval;

    @SerializedName("notice_list_appear_refresh_max_interval")
    private final int noticeListAppearRefreshMaxInterval;

    @SerializedName("notice_list_refresh_interval")
    private final int noticeListRefreshInterval;

    @SerializedName("notice_unread_count_polling_interval")
    private final int noticeUnreadCountPollingInterval;

    public a() {
        this.noticeListRefreshInterval = 60;
        this.noticeUnreadCountPollingInterval = 60;
        this.noticeListAppearRefreshMaxInterval = 600;
        this.noticeBannerRefreshInterval = 3500;
    }

    public final int a() {
        return this.noticeBannerRefreshInterval;
    }

    public final int b() {
        return this.noticeListAppearRefreshMaxInterval;
    }

    public final int c() {
        return this.noticeListRefreshInterval;
    }

    public final int d() {
        return this.noticeUnreadCountPollingInterval;
    }
}
