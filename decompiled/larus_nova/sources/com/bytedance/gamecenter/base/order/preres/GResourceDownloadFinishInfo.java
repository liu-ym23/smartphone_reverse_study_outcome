package com.bytedance.gamecenter.base.order.preres;

import com.google.gson.annotations.SerializedName;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b#\b\u0087\b\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0005¢\u0006\u0002\u0010\u0010J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\t\u0010)\u001a\u00020\rHÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003Js\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0005HÆ\u0001J\u0013\u0010,\u001a\u00020\r2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020\u0003HÖ\u0001J\t\u0010/\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u000b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0016\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u0016\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0012R\u0016\u0010\u000f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0019¨\u00060"}, d2 = {"Lcom/bytedance/gamecenter/base/order/preres/GResourceDownloadFinishInfo;", "", "downloadFromType", "", "path", "", "gameId", "downloadStatus", "downloadInfo", "Lcom/bytedance/gamecenter/base/order/preres/GResourceDownloadInfo;", "gamePackageName", "gameName", DBDefinition.ONLY_WIFI, "", "token", "userId", "(ILjava/lang/String;Ljava/lang/String;ILcom/bytedance/gamecenter/base/order/preres/GResourceDownloadInfo;Ljava/lang/String;Ljava/lang/String;ZILjava/lang/String;)V", "getDownloadFromType", "()I", "getDownloadInfo", "()Lcom/bytedance/gamecenter/base/order/preres/GResourceDownloadInfo;", "getDownloadStatus", "setDownloadStatus", "(I)V", "getGameId", "()Ljava/lang/String;", "getGameName", "getGamePackageName", "getOnlyWifi", "()Z", "getPath", "getToken", "getUserId", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "gamecenterbase_release"}, k = 1, mv = {1, 4, 3})
public final class GResourceDownloadFinishInfo {

    @SerializedName("type")
    private final int downloadFromType;

    @SerializedName("resource_download_info")
    private final GResourceDownloadInfo downloadInfo;

    @SerializedName("download_status")
    private int downloadStatus;

    @SerializedName("game_id")
    private final String gameId;

    @SerializedName(EventConstants.ExtraJson.GAME_NAME)
    private final String gameName;

    @SerializedName("package_name")
    private final String gamePackageName;

    @SerializedName("only_wifi")
    private final boolean onlyWifi;

    @SerializedName("path")
    private final String path;

    @SerializedName("token")
    private final int token;

    @SerializedName("user_id")
    private final String userId;

    public static /* synthetic */ GResourceDownloadFinishInfo copy$default(GResourceDownloadFinishInfo r110, int r111, String r112, String r113, int r114, GResourceDownloadInfo r115, String r116, String r117, boolean r118, int r210, String r211, int r212, Object r213) {
        if ((r212 & 1) == 0) goto L5;
        int r100 = r110.downloadFromType;
    L7:
        if ((r212 & 2) == 0) goto L9;
        String r101 = r110.path;
    L11:
        if ((r212 & 4) == 0) goto L13;
        String r102 = r110.gameId;
    L15:
        if ((r212 & 8) == 0) goto L17;
        int r103 = r110.downloadStatus;
    L19:
        if ((r212 & 16) == 0) goto L21;
        GResourceDownloadInfo r104 = r110.downloadInfo;
    L23:
        if ((r212 & 32) == 0) goto L25;
        String r105 = r110.gamePackageName;
    L27:
        if ((r212 & 64) == 0) goto L29;
        String r106 = r110.gameName;
    L31:
        if ((r212 & 128) == 0) goto L33;
        boolean r107 = r110.onlyWifi;
    L35:
        if ((r212 & 256) == 0) goto L37;
        int r119 = r110.token;
    L39:
        if ((r212 & 512) == 0) goto L41;
        String r108 = r110.userId;
    L43:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r119, r108);
    L41:
        r108 = r211;
        goto L43
    L37:
        r119 = r210;
        goto L39
    L33:
        r107 = r118;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final int component1() {
        return this.downloadFromType;
    }

    public final String component10() {
        return this.userId;
    }

    public final String component2() {
        return this.path;
    }

    public final String component3() {
        return this.gameId;
    }

    public final int component4() {
        return this.downloadStatus;
    }

    public final GResourceDownloadInfo component5() {
        return this.downloadInfo;
    }

    public final String component6() {
        return this.gamePackageName;
    }

    public final String component7() {
        return this.gameName;
    }

    public final boolean component8() {
        return this.onlyWifi;
    }

    public final int component9() {
        return this.token;
    }

    public final GResourceDownloadFinishInfo copy(int r110, String r111, String r112, int r113, GResourceDownloadInfo r114, String r115, String r116, boolean r210, int r211, String r212) {
        Intrinsics.checkNotNullParameter(r115, "gamePackageName");
        Intrinsics.checkNotNullParameter(r116, "gameName");
        Intrinsics.checkNotNullParameter(r212, "userId");
        return new GResourceDownloadFinishInfo(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof GResourceDownloadFinishInfo) == false) goto L26;
        GResourceDownloadFinishInfo r101 = (GResourceDownloadFinishInfo) r100;
        if (this.downloadFromType == r101.downloadFromType) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.path, r101.path) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.gameId, r101.gameId) == true) goto L12;
        return false;
    L12:
        if (this.downloadStatus == r101.downloadStatus) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.downloadInfo, r101.downloadInfo) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.gamePackageName, r101.gamePackageName) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.gameName, r101.gameName) == true) goto L20;
        return false;
    L20:
        if (this.onlyWifi == r101.onlyWifi) goto L22;
        return false;
    L22:
        if (this.token == r101.token) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.userId, r101.userId) == true) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r1v17, types: [int] */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v26 */
    public int hashCode() {
        int r100 = this.downloadFromType * 31;
        String r101 = this.path;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.gameId;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (((r104 + r106) * 31) + this.downloadStatus) * 31;
        GResourceDownloadInfo r108 = this.downloadInfo;
        if (r108 == null) goto L13;
        int r109 = r108.hashCode();
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.gamePackageName;
        if (r111 == null) goto L17;
        int r112 = r111.hashCode();
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.gameName;
        if (r114 == null) goto L21;
        int r115 = r114.hashCode();
    L22:
        int r116 = (r113 + r115) * 31;
        boolean r117 = this.onlyWifi;
        ?? r118 = r117;
        if (r117 == false) goto L25;
        r118 = 1;
    L25:
        int r119 = (((r116 + r118) * 31) + this.token) * 31;
        String r120 = this.userId;
        if (r120 == null) goto L29;
        r102 = r120.hashCode();
    L29:
        return r119 + r102;
    L21:
        r115 = 0;
        goto L22
    L17:
        r112 = 0;
        goto L18
    L13:
        r109 = 0;
        goto L14
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public String toString() {
        return "GResourceDownloadFinishInfo(downloadFromType=" + this.downloadFromType + ", path=" + this.path + ", gameId=" + this.gameId + ", downloadStatus=" + this.downloadStatus + ", downloadInfo=" + this.downloadInfo + ", gamePackageName=" + this.gamePackageName + ", gameName=" + this.gameName + ", onlyWifi=" + this.onlyWifi + ", token=" + this.token + ", userId=" + this.userId + ")";
    }

    public final int getDownloadFromType() {
        return this.downloadFromType;
    }

    public final GResourceDownloadInfo getDownloadInfo() {
        return this.downloadInfo;
    }

    public final int getDownloadStatus() {
        return this.downloadStatus;
    }

    public final String getGameId() {
        return this.gameId;
    }

    public final String getGameName() {
        return this.gameName;
    }

    public final String getGamePackageName() {
        return this.gamePackageName;
    }

    public final boolean getOnlyWifi() {
        return this.onlyWifi;
    }

    public final String getPath() {
        return this.path;
    }

    public final int getToken() {
        return this.token;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final void setDownloadStatus(int r100) {
        this.downloadStatus = r100;
    }

    public GResourceDownloadFinishInfo(int r100, String r101, String r102, int r103, GResourceDownloadInfo r104, String r105, String r106, boolean r107, int r110, String r111) {
        Intrinsics.checkNotNullParameter(r105, "gamePackageName");
        Intrinsics.checkNotNullParameter(r106, "gameName");
        Intrinsics.checkNotNullParameter(r111, "userId");
        this.downloadFromType = r100;
        this.path = r101;
        this.gameId = r102;
        this.downloadStatus = r103;
        this.downloadInfo = r104;
        this.gamePackageName = r105;
        this.gameName = r106;
        this.onlyWifi = r107;
        this.token = r110;
        this.userId = r111;
    }
}
