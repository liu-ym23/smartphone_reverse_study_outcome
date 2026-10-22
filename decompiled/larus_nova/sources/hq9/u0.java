package hq9;

import com.google.gson.annotations.SerializedName;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0006\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0014\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/larus/platform/model/CreationNotificationConfig;", "", "showNotification", "", Keys.API_PARAM_KEY_SDK_EXPIRETIME, "", "refreshQueuingIntervalSec", "refreshGeneratingIntervalSec", "progressSpeed", "", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Double;)V", "Ljava/lang/Boolean;", "Ljava/lang/Long;", "Ljava/lang/Double;", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class u0 {

    @SerializedName("expire_time")
    public final Long expireTime;

    @SerializedName("progress_speed")
    public final Double progressSpeed;

    @SerializedName("refresh_generating_interval_sec")
    public final Long refreshGeneratingIntervalSec;

    @SerializedName("refresh_queuing_interval_sec")
    public final Long refreshQueuingIntervalSec;

    @SerializedName("show_notification")
    public final Boolean showNotification;

    public u0() {
        this(0);
    }

    public /* synthetic */ u0(int r100) {
        this(Boolean.TRUE, 21600L, 5L, 1L, Double.valueOf(0.05d));
    }

    public u0(Boolean r100, Long r101, Long r102, Long r103, Double r104) {
        this.showNotification = r100;
        this.expireTime = r101;
        this.refreshQueuingIntervalSec = r102;
        this.refreshGeneratingIntervalSec = r103;
        this.progressSpeed = r104;
    }
}
