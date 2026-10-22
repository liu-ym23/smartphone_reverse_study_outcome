package com.obric.assistant.os.libs;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0010JV\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0006HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u0010R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0013\u0010\u0010R\u001a\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0014\u0010\u0010¨\u0006\""}, d2 = {"Lcom/obric/assistant/os/libs/NetworkCapability;", "", "ssid", "", "bssid", "freq", "", "rssi", "linkSpeed", "rxLinkSpeed", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getSsid", "()Ljava/lang/String;", "getBssid", "getFreq", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getRssi", "getLinkSpeed", "getRxLinkSpeed", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/obric/assistant/os/libs/NetworkCapability;", "equals", "", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NetworkCapability {

    @SerializedName("bssid")
    private final String bssid;

    @SerializedName("freq")
    private final Integer freq;

    @SerializedName("linkspeed")
    private final Integer linkSpeed;

    @SerializedName("rssi")
    private final Integer rssi;

    @SerializedName("rxLinkspeed")
    private final Integer rxLinkSpeed;

    @SerializedName("ssid")
    private final String ssid;

    public NetworkCapability() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ NetworkCapability copy$default(NetworkCapability r100, String r101, String r102, Integer r103, Integer r104, Integer r105, Integer r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.ssid;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.bssid;
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.freq;
    L11:
        Integer r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.rssi;
    L14:
        Integer r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.linkSpeed;
    L17:
        Integer r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.rxLinkSpeed;
    L20:
        String r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final String component1() {
        return this.ssid;
    }

    public final String component2() {
        return this.bssid;
    }

    public final Integer component3() {
        return this.freq;
    }

    public final Integer component4() {
        return this.rssi;
    }

    public final Integer component5() {
        return this.linkSpeed;
    }

    public final Integer component6() {
        return this.rxLinkSpeed;
    }

    public final NetworkCapability copy(String r100, String r110, Integer r111, Integer r112, Integer r113, Integer r114) {
        return new NetworkCapability(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof NetworkCapability) == true) goto L8;
        return false;
    L8:
        NetworkCapability r101 = (NetworkCapability) r100;
        if (Intrinsics.areEqual(this.ssid, r101.ssid) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.bssid, r101.bssid) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.freq, r101.freq) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.rssi, r101.rssi) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.linkSpeed, r101.linkSpeed) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.rxLinkSpeed, r101.rxLinkSpeed) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        String r100 = this.ssid;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.bssid;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.freq;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.rssi;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.linkSpeed;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.rxLinkSpeed;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "NetworkCapability(ssid=" + this.ssid + ", bssid=" + this.bssid + ", freq=" + this.freq + ", rssi=" + this.rssi + ", linkSpeed=" + this.linkSpeed + ", rxLinkSpeed=" + this.rxLinkSpeed + ')';
    }

    public final String getBssid() {
        return this.bssid;
    }

    public final Integer getFreq() {
        return this.freq;
    }

    public final Integer getLinkSpeed() {
        return this.linkSpeed;
    }

    public final Integer getRssi() {
        return this.rssi;
    }

    public final Integer getRxLinkSpeed() {
        return this.rxLinkSpeed;
    }

    public final String getSsid() {
        return this.ssid;
    }

    public NetworkCapability(String r100, String r101, Integer r102, Integer r103, Integer r104, Integer r105) {
        this.ssid = r100;
        this.bssid = r101;
        this.freq = r102;
        this.rssi = r103;
        this.linkSpeed = r104;
        this.rxLinkSpeed = r105;
    }

    public /* synthetic */ NetworkCapability(String r100, String r101, Integer r102, Integer r103, Integer r110, Integer r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        String r114 = null;
    L7:
        if ((r112 & 2) == 0) goto L9;
        String r104 = null;
    L11:
        if ((r112 & 4) == 0) goto L13;
        Integer r105 = null;
    L15:
        if ((r112 & 8) == 0) goto L17;
        Integer r106 = null;
    L19:
        if ((r112 & 16) == 0) goto L21;
        Integer r107 = null;
    L23:
        if ((r112 & 32) == 0) goto L25;
        Integer r115 = null;
    L26:
        this(r114, r104, r105, r106, r107, r115);
        return;
    L25:
        r115 = r111;
        goto L26
    L21:
        r107 = r110;
        goto L23
    L17:
        r106 = r103;
        goto L19
    L13:
        r105 = r102;
        goto L15
    L9:
        r104 = r101;
        goto L11
    L5:
        r114 = r100;
        goto L7
    }
}
