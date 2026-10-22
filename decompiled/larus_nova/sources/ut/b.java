package ut;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.gamecp.api.GamesMonitorInfo")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0004¨\u0006\u0013"}, d2 = {"Lut/b;", "", "", "gameId", "Ljava/lang/String;", "showMonitorUrl", "clickDownMonitorURL", "clickIconMonitorURL", "Lut/a;", "trackInfo", "Lut/a;", "", "deviceInfoPermission", "Ljava/lang/Boolean;", "groupLeaderId", "groupTaskId", "reserveMonitorUrl", "<init>", "()V", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b implements h {

    @SerializedName("click_down_monitor_url")
    public String clickDownMonitorURL;

    @SerializedName("click_icon_monitor_url")
    public String clickIconMonitorURL;

    @SerializedName("allow_personal_device_info")
    public Boolean deviceInfoPermission;

    @SerializedName("game_id")
    public String gameId;

    @SerializedName("group_leader_id")
    public String groupLeaderId;

    @SerializedName("group_task_id")
    public String groupTaskId;

    @SerializedName("reserve_monitor_url")
    public String reserveMonitorUrl;

    @SerializedName("show_monitor_url")
    public String showMonitorUrl;

    @SerializedName("track_info")
    public a trackInfo;

    public b() {
        this.deviceInfoPermission = Boolean.FALSE;
    }

    public b(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L16;
        switch(r102) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            case 9: goto L7;
            default: goto L6;
        };
    L7:
        this.reserveMonitorUrl = am3.h.c(r100);
        goto L3
    L8:
        this.groupTaskId = am3.h.c(r100);
        goto L3
    L9:
        this.groupLeaderId = am3.h.c(r100);
        goto L3
    L10:
        this.deviceInfoPermission = Boolean.valueOf(am3.h.a(r100));
        goto L3
    L11:
        this.trackInfo = new a(r100);
        goto L3
    L12:
        this.clickIconMonitorURL = am3.h.c(r100);
        goto L3
    L13:
        this.clickDownMonitorURL = am3.h.c(r100);
        goto L3
    L14:
        this.showMonitorUrl = am3.h.c(r100);
        goto L3
    L15:
        this.gameId = am3.h.c(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L16:
        r100.d(r101);
        if (this.deviceInfoPermission != null) goto L42;
        this.deviceInfoPermission = Boolean.FALSE;
        return;
    }
}
