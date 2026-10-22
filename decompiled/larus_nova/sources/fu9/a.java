package fu9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/larus/settings/provider/commercecredit/CommerceCreditConfig;", "", "<init>", "()V", "creditVersion", "", "getCreditVersion", "()Ljava/lang/String;", "enable", "getEnable", "disableTouristCreation", "getDisableTouristCreation", "sendUserActivityOnPageChanged", "", "getSendUserActivityOnPageChanged", "()Z", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    @SerializedName("credit_version")
    private final String creditVersion;

    @SerializedName("disable_tourist_creation")
    private final String disableTouristCreation;

    @SerializedName("enable")
    private final String enable;

    @SerializedName("send_user_activity_on_page_changed")
    private final boolean sendUserActivityOnPageChanged;

    public a() {
        this.sendUserActivityOnPageChanged = true;
    }

    public final String a() {
        return this.creditVersion;
    }

    public final String b() {
        return this.disableTouristCreation;
    }

    public final String c() {
        return this.enable;
    }

    public final boolean d() {
        return this.sendUserActivityOnPageChanged;
    }
}
