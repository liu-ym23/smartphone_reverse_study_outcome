package ks;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.gamecp.api.GameDataChannelMonitorInfo")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lks/b;", "", "", "gameId", "Ljava/lang/String;", "androidMonitorUrl", "iosMonitorUrl", "Lks/a;", "trackInfo", "Lks/a;", "", "allowPersonalDeviceInfo", "Ljava/lang/Boolean;", "<init>", "()V", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b implements h {

    @SerializedName("allow_personal_device_info")
    public Boolean allowPersonalDeviceInfo;

    @SerializedName("android_monitor_url")
    public String androidMonitorUrl;

    @SerializedName("game_id")
    public String gameId;

    @SerializedName("ios_monitor_url")
    public String iosMonitorUrl;

    @SerializedName("track_info")
    public a trackInfo;

    public b() {
        this.allowPersonalDeviceInfo = Boolean.FALSE;
    }

    public b(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        if (r102 != 1) goto L8;
        this.gameId = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.androidMonitorUrl = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.iosMonitorUrl = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.trackInfo = new a(r100);
        goto L3
    L14:
        if (r102 != 5) goto L15;
        this.allowPersonalDeviceInfo = Boolean.valueOf(am3.h.a(r100));
        goto L3
    L15:
        am3.h.e(r100);
        goto L3
    L21:
        r100.d(r101);
        if (this.allowPersonalDeviceInfo != null) goto L43;
        this.allowPersonalDeviceInfo = Boolean.FALSE;
        return;
    }
}
