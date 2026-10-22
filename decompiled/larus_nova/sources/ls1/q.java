package ls1;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b#\u0010$R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR*\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\bR\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\bR\"\u0010\u001d\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\bR\"\u0010 \u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\b¨\u0006%"}, d2 = {"Lls1/q;", "", "", "enable", "Z", "getEnable", "()Z", "setEnable", "(Z)V", "enablePk", "getEnablePk", "setEnablePk", "enablePkReset", "getEnablePkReset", "setEnablePkReset", "", "", "pkTimeToEnd", "Ljava/util/List;", "getPkTimeToEnd", "()Ljava/util/List;", "setPkTimeToEnd", "(Ljava/util/List;)V", "showToastEnable", "getShowToastEnable", "setShowToastEnable", "enableClientTrigger", "getEnableClientTrigger", "setEnableClientTrigger", "giftListPreloadEnable", "getGiftListPreloadEnable", "setGiftListPreloadEnable", "giftAssetDownloadEnable", "getGiftAssetDownloadEnable", "setGiftAssetDownloadEnable", "<init>", "()V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class q {

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("enable_client_trigger")
    private boolean enableClientTrigger;

    @SerializedName("enable_pk")
    private boolean enablePk;

    @SerializedName("enable_pk_reset")
    private boolean enablePkReset;

    @SerializedName("gift_asset_download")
    private boolean giftAssetDownloadEnable;

    @SerializedName("gift_list_enable")
    private boolean giftListPreloadEnable;

    @SerializedName("pk_time_to_end")
    private List<Long> pkTimeToEnd;

    @SerializedName("show_toast_enable")
    private boolean showToastEnable;

    public q() {
        this.pkTimeToEnd = CollectionsKt.listOf(30000L);
        this.enableClientTrigger = true;
        this.giftListPreloadEnable = true;
        this.giftAssetDownloadEnable = true;
    }
}
