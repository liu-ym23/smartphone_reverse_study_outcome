package lq9;

import com.google.gson.annotations.SerializedName;
import com.larus.common.apphost.AppHost;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J1\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\tR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/larus/platform/model/audio/RealtimeVLMOfficialConfig;", "", "isVideoEnable", "", "isScreenShareEnable", "isMenuEnable", "isNewCallIconEnable", "<init>", "(ZZZZ)V", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a0 {

    @SerializedName("is_menu_enable")
    private final boolean isMenuEnable;

    @SerializedName("is_new_call_icon_enable")
    private final boolean isNewCallIconEnable;

    @SerializedName("is_screen_share_enable")
    private final boolean isScreenShareEnable;

    @SerializedName("is_video_enable")
    private final boolean isVideoEnable;

    public a0() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a0) == true) goto L8;
        return false;
    L8:
        a0 r101 = (a0) r100;
        if (this.isVideoEnable == r101.isVideoEnable) goto L12;
        return false;
    L12:
        if (this.isScreenShareEnable == r101.isScreenShareEnable) goto L15;
        return false;
    L15:
        if (this.isMenuEnable == r101.isMenuEnable) goto L18;
        return false;
    L18:
        if (this.isNewCallIconEnable == r101.isNewCallIconEnable) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.isVideoEnable == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.isScreenShareEnable == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.isMenuEnable == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.isNewCallIconEnable == true) goto L19;
        r100 = 1237;
    L19:
        return r106 + r100;
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "RealtimeVLMOfficialConfig(isVideoEnable=" + this.isVideoEnable + ", isScreenShareEnable=" + this.isScreenShareEnable + ", isMenuEnable=" + this.isMenuEnable + ", isNewCallIconEnable=" + this.isNewCallIconEnable + ')';
    }

    public final boolean a() {
        return this.isMenuEnable;
    }

    public final boolean b() {
        return this.isNewCallIconEnable;
    }

    public final boolean c() {
        return this.isScreenShareEnable;
    }

    public final boolean d() {
        return this.isVideoEnable;
    }

    public a0(int r100) {
        AppHost.Companion r101 = AppHost.f326268a;
        boolean r102 = !r101.isOversea();
        boolean r103 = !r101.isOversea();
        boolean r104 = !r101.isOversea();
        this.isVideoEnable = r102;
        this.isScreenShareEnable = r103;
        this.isMenuEnable = r104;
        this.isNewCallIconEnable = false;
    }
}
