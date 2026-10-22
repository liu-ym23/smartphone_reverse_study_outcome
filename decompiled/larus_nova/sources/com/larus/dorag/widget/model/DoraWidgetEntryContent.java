package com.larus.dorag.widget.model;

import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import java.io.Serializable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b(\n\u0002\u0010\u0000\n\u0002\b\u001a\b\u0086\b\u0018\u00002\u00020\u0001Bã\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\t\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0006\u00105\u001a\u00020\u0005J\u0013\u00106\u001a\u00020\u00052\b\u00107\u001a\u0004\u0018\u000108H\u0096\u0002J\b\u00109\u001a\u00020\tH\u0016J\b\u0010:\u001a\u00020\u0003H\u0016J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0005HÆ\u0003J\t\u0010=\u001a\u00020\u0005HÆ\u0003J\t\u0010>\u001a\u00020\u0005HÆ\u0003J\t\u0010?\u001a\u00020\tHÆ\u0003J\t\u0010@\u001a\u00020\tHÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\tHÆ\u0003J\t\u0010D\u001a\u00020\u000fHÆ\u0003J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\t\u0010G\u001a\u00020\u000fHÆ\u0003J\t\u0010H\u001a\u00020\u0003HÆ\u0003J\t\u0010I\u001a\u00020\u0003HÆ\u0003J\t\u0010J\u001a\u00020\u0003HÆ\u0003J\t\u0010K\u001a\u00020\u0003HÆ\u0003J\t\u0010L\u001a\u00020\u000fHÆ\u0003J\t\u0010M\u001a\u00020\u0003HÆ\u0003J\t\u0010N\u001a\u00020\u0003HÆ\u0003J\t\u0010O\u001a\u00020\u0003HÆ\u0003J\t\u0010P\u001a\u00020\u0003HÆ\u0003Jå\u0001\u0010Q\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u000f2\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u0003HÆ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010 R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010 R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010 R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001fR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001fR\u0011\u0010\r\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\"R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001fR\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001fR\u0011\u0010\u0012\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b+\u0010(R\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001fR\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001fR\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001fR\u0011\u0010\u0016\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001fR\u0011\u0010\u0017\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b0\u0010(R\u0011\u0010\u0018\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001fR\u0011\u0010\u0019\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001fR\u0011\u0010\u001a\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u001fR\u0011\u0010\u001b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u001f¨\u0006R"}, d2 = {"Lcom/larus/dorag/widget/model/DoraWidgetEntryContent;", "Ljava/io/Serializable;", "deviceName", "", "isConnected", "", "isGlassCharging", "isBoxCharging", "glassBattery", "", "boxBattery", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "serialNumber", "productId", "date", "", "latestDiaryId", "latestDiaryDate", "latestDiaryCreateTime", "latestDiaryTitle", "latestDiaryContent", "latestDiaryEmotion", "latestDiaryEmotionUrl", "lastDiaryFetchTime", "betaDate", "betaTitle", "betaText", "betaImageUrl", "<init>", "(Ljava/lang/String;ZZZIILjava/lang/String;Ljava/lang/String;IJLjava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDeviceName", "()Ljava/lang/String;", "()Z", "getGlassBattery", "()I", "getBoxBattery", "getModel", "getSerialNumber", "getProductId", "getDate", "()J", "getLatestDiaryId", "getLatestDiaryDate", "getLatestDiaryCreateTime", "getLatestDiaryTitle", "getLatestDiaryContent", "getLatestDiaryEmotion", "getLatestDiaryEmotionUrl", "getLastDiaryFetchTime", "getBetaDate", "getBetaTitle", "getBetaText", "getBetaImageUrl", "hasBetaWidgetCard", "equals", "other", "", "hashCode", "toString", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "copy", "dorag_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraWidgetEntryContent implements Serializable {
    private final String betaDate;
    private final String betaImageUrl;
    private final String betaText;
    private final String betaTitle;
    private final int boxBattery;
    private final long date;
    private final String deviceName;
    private final int glassBattery;
    private final boolean isBoxCharging;
    private final boolean isConnected;
    private final boolean isGlassCharging;
    private final long lastDiaryFetchTime;
    private final String latestDiaryContent;
    private final long latestDiaryCreateTime;
    private final String latestDiaryDate;
    private final String latestDiaryEmotion;
    private final String latestDiaryEmotionUrl;
    private final String latestDiaryId;
    private final String latestDiaryTitle;
    private final String model;
    private final int productId;
    private final String serialNumber;

    public DoraWidgetEntryContent() {
        this(null, false, false, false, 0, 0, null, null, 0, 0, null, null, 0, null, null, null, null, 0, null, null, null, null, 4194303, null);
    }

    public static /* synthetic */ DoraWidgetEntryContent copy$default(DoraWidgetEntryContent r110, String r111, boolean r112, boolean r210, boolean r211, int r212, int r213, String r214, String r215, int r216, long r217, String r218, String r310, long r311, String r312, String r313, String r314, String r315, long r316, String r317, String r410, String r411, String r412, int r413, Object r414) {
        if ((r413 & 1) == 0) goto L5;
        String r100 = r110.deviceName;
    L7:
        if ((r413 & 2) == 0) goto L9;
        boolean r101 = r110.isConnected;
    L11:
        if ((r413 & 4) == 0) goto L13;
        boolean r102 = r110.isGlassCharging;
    L15:
        if ((r413 & 8) == 0) goto L17;
        boolean r103 = r110.isBoxCharging;
    L19:
        if ((r413 & 16) == 0) goto L21;
        int r104 = r110.glassBattery;
    L23:
        if ((r413 & 32) == 0) goto L25;
        int r105 = r110.boxBattery;
    L27:
        if ((r413 & 64) == 0) goto L29;
        String r106 = r110.model;
    L31:
        if ((r413 & 128) == 0) goto L33;
        String r107 = r110.serialNumber;
    L35:
        if ((r413 & 256) == 0) goto L37;
        int r113 = r110.productId;
    L39:
        if ((r413 & 512) == 0) goto L41;
        long r114 = r110.date;
    L43:
        if ((r413 & 1024) == 0) goto L45;
        String r115 = r110.latestDiaryId;
    L47:
        if ((r413 & 2048) == 0) goto L49;
        String r116 = r110.latestDiaryDate;
    L50:
        String r318 = r116;
        if ((r413 & 4096) == 0) goto L53;
        long r117 = r110.latestDiaryCreateTime;
    L54:
        long r319 = r117;
        if ((r413 & 8192) == 0) goto L57;
        String r118 = r110.latestDiaryTitle;
    L59:
        if ((r413 & 16384) == 0) goto L61;
        String r119 = r110.latestDiaryContent;
    L62:
        String r320 = r119;
        if ((r413 & 32768) == 0) goto L65;
        String r120 = r110.latestDiaryEmotion;
    L66:
        String r321 = r120;
        if ((r413 & 65536) == 0) goto L69;
        String r121 = r110.latestDiaryEmotionUrl;
    L70:
        String r322 = r118;
        String r323 = r121;
        if ((r413 & 131072) == 0) goto L73;
        long r122 = r110.lastDiaryFetchTime;
    L74:
        long r324 = r122;
        if ((r413 & 262144) == 0) goto L77;
        String r123 = r110.betaDate;
    L79:
        if ((524288 & r413) == 0) goto L81;
        String r124 = r110.betaTitle;
    L82:
        String r415 = r124;
        if ((r413 & 1048576) == 0) goto L85;
        String r125 = r110.betaText;
    L87:
        if ((r413 & 2097152) == 0) goto L89;
        String r108 = r110.betaImageUrl;
    L91:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r318, r319, r322, r320, r321, r323, r324, r123, r415, r125, r108);
    L89:
        r108 = r412;
        goto L91
    L85:
        r125 = r411;
        goto L87
    L81:
        r124 = r410;
        goto L82
    L77:
        r123 = r317;
        goto L79
    L73:
        r122 = r316;
        goto L74
    L69:
        r121 = r315;
        goto L70
    L65:
        r120 = r314;
        goto L66
    L61:
        r119 = r313;
        goto L62
    L57:
        r118 = r312;
        goto L59
    L53:
        r117 = r311;
        goto L54
    L49:
        r116 = r310;
        goto L50
    L45:
        r115 = r218;
        goto L47
    L41:
        r114 = r217;
        goto L43
    L37:
        r113 = r216;
        goto L39
    L33:
        r107 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.deviceName;
    }

    public final long component10() {
        return this.date;
    }

    public final String component11() {
        return this.latestDiaryId;
    }

    public final String component12() {
        return this.latestDiaryDate;
    }

    public final long component13() {
        return this.latestDiaryCreateTime;
    }

    public final String component14() {
        return this.latestDiaryTitle;
    }

    public final String component15() {
        return this.latestDiaryContent;
    }

    public final String component16() {
        return this.latestDiaryEmotion;
    }

    public final String component17() {
        return this.latestDiaryEmotionUrl;
    }

    public final long component18() {
        return this.lastDiaryFetchTime;
    }

    public final String component19() {
        return this.betaDate;
    }

    public final boolean component2() {
        return this.isConnected;
    }

    public final String component20() {
        return this.betaTitle;
    }

    public final String component21() {
        return this.betaText;
    }

    public final String component22() {
        return this.betaImageUrl;
    }

    public final boolean component3() {
        return this.isGlassCharging;
    }

    public final boolean component4() {
        return this.isBoxCharging;
    }

    public final int component5() {
        return this.glassBattery;
    }

    public final int component6() {
        return this.boxBattery;
    }

    public final String component7() {
        return this.model;
    }

    public final String component8() {
        return this.serialNumber;
    }

    public final int component9() {
        return this.productId;
    }

    public final DoraWidgetEntryContent copy(String r210, boolean r310, boolean r311, boolean r312, int r313, int r314, String r315, String r316, int r317, long r318, String r410, String r411, long r412, String r413, String r414, String r415, String r416, long r417, String r510, String r511, String r512, String r513) {
        Intrinsics.checkNotNullParameter(r210, "deviceName");
        Intrinsics.checkNotNullParameter(r315, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r316, "serialNumber");
        Intrinsics.checkNotNullParameter(r410, "latestDiaryId");
        Intrinsics.checkNotNullParameter(r411, "latestDiaryDate");
        Intrinsics.checkNotNullParameter(r413, "latestDiaryTitle");
        Intrinsics.checkNotNullParameter(r414, "latestDiaryContent");
        Intrinsics.checkNotNullParameter(r415, "latestDiaryEmotion");
        Intrinsics.checkNotNullParameter(r416, "latestDiaryEmotionUrl");
        Intrinsics.checkNotNullParameter(r510, "betaDate");
        Intrinsics.checkNotNullParameter(r511, "betaTitle");
        Intrinsics.checkNotNullParameter(r512, "betaText");
        Intrinsics.checkNotNullParameter(r513, "betaImageUrl");
        return new DoraWidgetEntryContent(r210, r310, r311, r312, r313, r314, r315, r316, r317, r318, r410, r411, r412, r413, r414, r415, r416, r417, r510, r511, r512, r513);
    }

    public final boolean hasBetaWidgetCard() {
        if (this.betaTitle.length() <= 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        return true;
    L8:
        if (this.betaText.length() <= 0) goto L10;
        boolean r101 = true;
    L11:
        if (r101 == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        r101 = false;
        goto L11
    L5:
        r100 = false;
        goto L6
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.deviceName, Boolean.valueOf(this.isConnected), Boolean.valueOf(this.isGlassCharging), Boolean.valueOf(this.isBoxCharging), Integer.valueOf(this.glassBattery), Integer.valueOf(this.boxBattery), this.model, this.serialNumber, Integer.valueOf(this.productId), this.latestDiaryId, this.latestDiaryDate, Long.valueOf(this.latestDiaryCreateTime), this.latestDiaryTitle, this.latestDiaryContent, this.latestDiaryEmotion, this.latestDiaryEmotionUrl, Long.valueOf(this.lastDiaryFetchTime), this.betaDate, this.betaTitle, this.betaText, this.betaImageUrl});
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("deviceName: ");
        r100.append(this.deviceName);
        r100.append(", isConnected: ");
        r100.append(this.isConnected);
        r100.append(", isGlassCharging: ");
        r100.append(this.isGlassCharging);
        r100.append(", isBoxCharging: ");
        r100.append(this.isBoxCharging);
        r100.append(", glassBattery: ");
        r100.append(this.glassBattery);
        r100.append(", boxBattery: ");
        r100.append(this.boxBattery);
        r100.append(", model: ");
        r100.append(this.model);
        r100.append(", productId: ");
        r100.append(this.productId);
        r100.append(", date: ");
        r100.append(this.date);
        r100.append(", betaDate: ");
        r100.append(this.betaDate);
        r100.append(", betaTitle: ");
        r100.append(this.betaTitle);
        r100.append(", hasBetaImage: ");
        if (this.betaImageUrl.length() <= 0) goto L5;
        boolean r101 = true;
    L6:
        r100.append(r101);
        return r100.toString();
    L5:
        r101 = false;
        goto L6
    }

    public final String getBetaDate() {
        return this.betaDate;
    }

    public final String getBetaImageUrl() {
        return this.betaImageUrl;
    }

    public final String getBetaText() {
        return this.betaText;
    }

    public final String getBetaTitle() {
        return this.betaTitle;
    }

    public final int getBoxBattery() {
        return this.boxBattery;
    }

    public final long getDate() {
        return this.date;
    }

    public final String getDeviceName() {
        return this.deviceName;
    }

    public final int getGlassBattery() {
        return this.glassBattery;
    }

    public final long getLastDiaryFetchTime() {
        return this.lastDiaryFetchTime;
    }

    public final String getLatestDiaryContent() {
        return this.latestDiaryContent;
    }

    public final long getLatestDiaryCreateTime() {
        return this.latestDiaryCreateTime;
    }

    public final String getLatestDiaryDate() {
        return this.latestDiaryDate;
    }

    public final String getLatestDiaryEmotion() {
        return this.latestDiaryEmotion;
    }

    public final String getLatestDiaryEmotionUrl() {
        return this.latestDiaryEmotionUrl;
    }

    public final String getLatestDiaryId() {
        return this.latestDiaryId;
    }

    public final String getLatestDiaryTitle() {
        return this.latestDiaryTitle;
    }

    public final String getModel() {
        return this.model;
    }

    public final int getProductId() {
        return this.productId;
    }

    public final String getSerialNumber() {
        return this.serialNumber;
    }

    public final boolean isBoxCharging() {
        return this.isBoxCharging;
    }

    public final boolean isConnected() {
        return this.isConnected;
    }

    public final boolean isGlassCharging() {
        return this.isGlassCharging;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DoraWidgetEntryContent) == false) goto L8;
        DoraWidgetEntryContent r101 = (DoraWidgetEntryContent) r100;
    L10:
        if (r101 != null) goto L12;
        return false;
    L12:
        DoraWidgetEntryContent r102 = (DoraWidgetEntryContent) r100;
        if (Intrinsics.areEqual(this.deviceName, r102.deviceName) == true) goto L15;
    L55:
        return false;
    L15:
        if (this.isConnected != r102.isConnected) goto L55;
        if (this.isGlassCharging != r102.isGlassCharging) goto L55;
        if (this.isBoxCharging != r102.isBoxCharging) goto L55;
        if (this.glassBattery != r102.glassBattery) goto L55;
        if (this.boxBattery != r102.boxBattery) goto L55;
        if (Intrinsics.areEqual(this.model, r102.model) == false) goto L55;
        if (Intrinsics.areEqual(this.serialNumber, r102.serialNumber) == false) goto L55;
        if (this.productId != r102.productId) goto L55;
        if (Intrinsics.areEqual(this.latestDiaryId, r102.latestDiaryId) == false) goto L55;
        if (Intrinsics.areEqual(this.latestDiaryDate, r102.latestDiaryDate) == false) goto L55;
        if (this.latestDiaryCreateTime != r102.latestDiaryCreateTime) goto L55;
        if (Intrinsics.areEqual(this.latestDiaryTitle, r102.latestDiaryTitle) == false) goto L55;
        if (Intrinsics.areEqual(this.latestDiaryContent, r102.latestDiaryContent) == false) goto L55;
        if (Intrinsics.areEqual(this.latestDiaryEmotion, r102.latestDiaryEmotion) == false) goto L55;
        if (Intrinsics.areEqual(this.latestDiaryEmotionUrl, r102.latestDiaryEmotionUrl) == false) goto L55;
        if (this.lastDiaryFetchTime != r102.lastDiaryFetchTime) goto L55;
        if (Intrinsics.areEqual(this.betaDate, r102.betaDate) == false) goto L55;
        if (Intrinsics.areEqual(this.betaTitle, r102.betaTitle) == false) goto L55;
        if (Intrinsics.areEqual(this.betaText, r102.betaText) == false) goto L55;
        if (Intrinsics.areEqual(this.betaImageUrl, r102.betaImageUrl) == false) goto L55;
        return true;
    L8:
        r101 = null;
        goto L10
    }

    public DoraWidgetEntryContent(String r110, boolean r111, boolean r112, boolean r113, int r210, int r211, String r212, String r213, int r214, long r215, String r216, String r217, long r218, String r310, String r311, String r312, String r313, long r314, String r315, String r316, String r317, String r410) {
        Intrinsics.checkNotNullParameter(r110, "deviceName");
        Intrinsics.checkNotNullParameter(r212, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r213, "serialNumber");
        Intrinsics.checkNotNullParameter(r216, "latestDiaryId");
        Intrinsics.checkNotNullParameter(r217, "latestDiaryDate");
        Intrinsics.checkNotNullParameter(r310, "latestDiaryTitle");
        Intrinsics.checkNotNullParameter(r311, "latestDiaryContent");
        Intrinsics.checkNotNullParameter(r312, "latestDiaryEmotion");
        Intrinsics.checkNotNullParameter(r313, "latestDiaryEmotionUrl");
        Intrinsics.checkNotNullParameter(r315, "betaDate");
        Intrinsics.checkNotNullParameter(r316, "betaTitle");
        Intrinsics.checkNotNullParameter(r317, "betaText");
        Intrinsics.checkNotNullParameter(r410, "betaImageUrl");
        this.deviceName = r110;
        this.isConnected = r111;
        this.isGlassCharging = r112;
        this.isBoxCharging = r113;
        this.glassBattery = r210;
        this.boxBattery = r211;
        this.model = r212;
        this.serialNumber = r213;
        this.productId = r214;
        this.date = r215;
        this.latestDiaryId = r216;
        this.latestDiaryDate = r217;
        this.latestDiaryCreateTime = r218;
        this.latestDiaryTitle = r310;
        this.latestDiaryContent = r311;
        this.latestDiaryEmotion = r312;
        this.latestDiaryEmotionUrl = r313;
        this.lastDiaryFetchTime = r314;
        this.betaDate = r315;
        this.betaTitle = r316;
        this.betaText = r317;
        this.betaImageUrl = r410;
    }

    public /* synthetic */ DoraWidgetEntryContent(String r210, boolean r211, boolean r212, boolean r310, int r311, int r312, String r313, String r314, int r315, long r316, String r317, String r318, long r410, String r411, String r412, String r413, String r414, long r415, String r416, String r417, String r510, String r511, int r512, DefaultConstructorMarker r513) {
        if ((r512 & 1) == 0) goto L5;
        String r100 = "";
    L6:
        boolean r101 = false;
        if ((r512 & 2) == 0) goto L9;
        boolean r102 = false;
    L11:
        if ((r512 & 4) == 0) goto L13;
        boolean r103 = false;
    L15:
        if ((r512 & 8) != 0) goto L18;
        r101 = r310;
    L18:
        int r104 = -1;
        if ((r512 & 16) == 0) goto L21;
        int r105 = -1;
    L23:
        if ((r512 & 32) != 0) goto L27;
        r104 = r312;
    L27:
        if ((r512 & 64) == 0) goto L29;
        String r106 = "";
    L31:
        if ((r512 & 128) == 0) goto L33;
        String r107 = "";
    L35:
        if ((r512 & 256) == 0) goto L37;
        int r110 = 16;
    L39:
        if ((r512 & 512) == 0) goto L41;
        long r111 = -1;
    L43:
        if ((r512 & 1024) == 0) goto L45;
        String r112 = "";
    L47:
        if ((r512 & 2048) == 0) goto L49;
        String r113 = "";
    L50:
        long r114 = 0;
        if ((r512 & 4096) == 0) goto L53;
        long r115 = 0;
    L55:
        if ((r512 & 8192) == 0) goto L57;
        String r116 = "";
    L59:
        if ((r512 & 16384) == 0) goto L61;
        String r108 = "";
    L63:
        if ((r512 & 32768) == 0) goto L65;
        String r213 = "";
    L67:
        if ((r512 & 65536) == 0) goto L69;
        String r214 = "";
    L71:
        if ((r512 & 131072) != 0) goto L75;
        r114 = r415;
    L75:
        if ((r512 & 262144) == 0) goto L77;
        String r215 = "";
    L79:
        if ((r512 & 524288) == 0) goto L81;
        String r216 = "";
    L83:
        if ((r512 & 1048576) == 0) goto L85;
        String r217 = "";
    L87:
        if ((r512 & 2097152) == 0) goto L89;
        String r109 = "";
    L90:
        this(r100, r102, r103, r101, r105, r104, r106, r107, r110, r111, r112, r113, r115, r116, r108, r213, r214, r114, r215, r216, r217, r109);
        return;
    L89:
        r109 = r511;
        goto L90
    L85:
        r217 = r510;
        goto L87
    L81:
        r216 = r417;
        goto L83
    L77:
        r215 = r416;
        goto L79
    L69:
        r214 = r414;
        goto L71
    L65:
        r213 = r413;
        goto L67
    L61:
        r108 = r412;
        goto L63
    L57:
        r116 = r411;
        goto L59
    L53:
        r115 = r410;
        goto L55
    L49:
        r113 = r318;
        goto L50
    L45:
        r112 = r317;
        goto L47
    L41:
        r111 = r316;
        goto L43
    L37:
        r110 = r315;
        goto L39
    L33:
        r107 = r314;
        goto L35
    L29:
        r106 = r313;
        goto L31
    L21:
        r105 = r311;
        goto L23
    L13:
        r103 = r212;
        goto L15
    L9:
        r102 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L6
    }
}
