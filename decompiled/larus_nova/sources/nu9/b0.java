package nu9;

import androidx.core.app.NotificationCompat;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR \u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u0014\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R \u0010\u0017\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013¨\u0006\u001a"}, d2 = {"Lcom/larus/settings/provider/dora/VideoStreamingConfig;", "", "<init>", "()V", "enable", "", "getEnable", "()Ljava/lang/Boolean;", "setEnable", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "showEntrance", "getShowEntrance", "setShowEntrance", NotificationCompat.CATEGORY_TRANSPORT, "", "getTransport", "()Ljava/lang/String;", "setTransport", "(Ljava/lang/String;)V", "controlMode", "getControlMode", "setControlMode", "activeLink", "getActiveLink", "setActiveLink", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class b0 {

    @SerializedName("active_link")
    private String activeLink;

    @SerializedName("control_mode")
    private String controlMode;

    @SerializedName("enable")
    private Boolean enable;

    @SerializedName("show_entrance")
    private Boolean showEntrance;

    @SerializedName(NotificationCompat.CATEGORY_TRANSPORT)
    private String transport;

    public b0() {
    }

    public final void f() {
        this.activeLink = "spp";
    }

    public final void g() {
        this.controlMode = "preset";
    }

    public final void j() {
        this.transport = "rtc";
    }

    public final String a() {
        return this.activeLink;
    }

    public final String b() {
        return this.controlMode;
    }

    public final Boolean c() {
        return this.enable;
    }

    public final Boolean d() {
        return this.showEntrance;
    }

    public final String e() {
        return this.transport;
    }

    public final void h(Boolean r100) {
        this.enable = r100;
    }

    public final void i(Boolean r100) {
        this.showEntrance = r100;
    }
}
