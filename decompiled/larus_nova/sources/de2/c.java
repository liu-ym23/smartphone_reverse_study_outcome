package de2;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0010\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u0012"}, d2 = {"Lde2/c;", "", "", "roomId", "J", "b", "()J", "", "headphoneMonitorChecked", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "showOppoHeadphoneGuide", "c", "isSupportEarMonitor", "e", "isCdnSinger", "d", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class c {

    @SerializedName("headphone_monitor_checked")
    private final boolean headphoneMonitorChecked;

    @SerializedName("is_cdn_singer")
    private final boolean isCdnSinger;

    @SerializedName("is_support_ear_monitor")
    private final boolean isSupportEarMonitor;

    @SerializedName("room_id")
    private final long roomId;

    @SerializedName("show_oppo_headphone_guide")
    private final boolean showOppoHeadphoneGuide;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L16;
        c r101 = (c) r100;
        if (this.roomId == r101.roomId) goto L8;
        return false;
    L8:
        if (this.headphoneMonitorChecked == r101.headphoneMonitorChecked) goto L10;
        return false;
    L10:
        if (this.showOppoHeadphoneGuide == r101.showOppoHeadphoneGuide) goto L12;
        return false;
    L12:
        if (this.isSupportEarMonitor == r101.isSupportEarMonitor) goto L14;
        return false;
    L14:
        if (this.isCdnSinger == r101.isCdnSinger) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4 */
    public final int hashCode() {
        long r100 = this.roomId;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        boolean r102 = this.headphoneMonitorChecked;
        ?? r103 = 1;
        ?? r104 = r102;
        if (r102 == false) goto L5;
        r104 = 1;
    L5:
        int r105 = (r101 + r104) * 31;
        boolean r106 = this.showOppoHeadphoneGuide;
        ?? r107 = r106;
        if (r106 == false) goto L8;
        r107 = 1;
    L8:
        int r108 = (r105 + r107) * 31;
        boolean r109 = this.isSupportEarMonitor;
        ?? r110 = r109;
        if (r109 == false) goto L11;
        r110 = 1;
    L11:
        int r111 = (r108 + r110) * 31;
        boolean r112 = this.isCdnSinger;
        if (r112 == true) goto L16;
        r103 = r112;
    L16:
        return r111 + r103;
    }

    public final String toString() {
        return "TuningPanelParams(roomId=" + this.roomId + ", headphoneMonitorChecked=" + this.headphoneMonitorChecked + ", showOppoHeadphoneGuide=" + this.showOppoHeadphoneGuide + ", isSupportEarMonitor=" + this.isSupportEarMonitor + ", isCdnSinger=" + this.isCdnSinger + ")";
    }

    public final boolean a() {
        return this.headphoneMonitorChecked;
    }

    public final long b() {
        return this.roomId;
    }

    public final boolean c() {
        return this.showOppoHeadphoneGuide;
    }

    public final boolean d() {
        return this.isCdnSinger;
    }

    public final boolean e() {
        return this.isSupportEarMonitor;
    }

    public c(long r100, boolean r101, boolean r102, boolean r103, boolean r104) {
        this.roomId = r100;
        this.headphoneMonitorChecked = r101;
        this.showOppoHeadphoneGuide = r102;
        this.isSupportEarMonitor = r103;
        this.isCdnSinger = r104;
    }
}
