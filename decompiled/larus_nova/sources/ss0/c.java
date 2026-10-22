package ss0;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b!\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b!\u0010\"R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\"\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\"\u0010\u001e\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\b¨\u0006#"}, d2 = {"Lss0/c;", "", "", "enableFansClubVip", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "setEnableFansClubVip", "(Z)V", "enableFansClubVipShowMap", "c", "setEnableFansClubVipShowMap", "enableFansClubVipClickMap", "b", "setEnableFansClubVipClickMap", "enableGiftUpdateVersionChange", "d", "setEnableGiftUpdateVersionChange", "enableHonourUpdateVersionChange", "e", "setEnableHonourUpdateVersionChange", "enableHonourWallShowMap", ce.f26391f, "setEnableHonourWallShowMap", "enableHonourWallClickMap", "f", "setEnableHonourWallClickMap", "enableTagShowMap", RXScreenCaptureService.KEY_INDEX, "setEnableTagShowMap", "enableTagClickMap", "h", "setEnableTagClickMap", "<init>", "()V", "live-profile-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("enable_fans_club_vip")
    private boolean enableFansClubVip;

    @SerializedName("enable_fans_club_vip_click_map")
    private boolean enableFansClubVipClickMap;

    @SerializedName("enable_fans_club_vip_show_map")
    private boolean enableFansClubVipShowMap;

    @SerializedName("enable_gift_update_version_change")
    private boolean enableGiftUpdateVersionChange;

    @SerializedName("enable_honour_update_version_change")
    private boolean enableHonourUpdateVersionChange;

    @SerializedName("enable_honour_wall_click_map")
    private boolean enableHonourWallClickMap;

    @SerializedName("enable_honour_wall_show_map")
    private boolean enableHonourWallShowMap;

    @SerializedName("enable_tag_click_map")
    private boolean enableTagClickMap;

    @SerializedName("enable_tag_show_map")
    private boolean enableTagShowMap;

    public c() {
        this.enableFansClubVip = true;
        this.enableFansClubVipShowMap = true;
        this.enableFansClubVipClickMap = true;
        this.enableGiftUpdateVersionChange = true;
        this.enableHonourUpdateVersionChange = true;
        this.enableHonourWallShowMap = true;
        this.enableHonourWallClickMap = true;
        this.enableTagShowMap = true;
        this.enableTagClickMap = true;
    }

    public final boolean a() {
        return this.enableFansClubVip;
    }

    public final boolean b() {
        return this.enableFansClubVipClickMap;
    }

    public final boolean c() {
        return this.enableFansClubVipShowMap;
    }

    public final boolean d() {
        return this.enableGiftUpdateVersionChange;
    }

    public final boolean e() {
        return this.enableHonourUpdateVersionChange;
    }

    public final boolean f() {
        return this.enableHonourWallClickMap;
    }

    public final boolean g() {
        return this.enableHonourWallShowMap;
    }

    public final boolean h() {
        return this.enableTagClickMap;
    }

    public final boolean i() {
        return this.enableTagShowMap;
    }
}
