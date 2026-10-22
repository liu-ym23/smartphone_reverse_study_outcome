package com.larus.dora.impl.wlan.wifi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 (2\u00020\u0001:\u0001(BG\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003JI\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0006\u0010\u001d\u001a\u00020\u0006J\u0013\u0010\u001e\u001a\u00020\n2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u0006HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\u0016\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0006R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0016\u0010\b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006)"}, d2 = {"Lcom/larus/dora/impl/wlan/wifi/DoraWifiEntity;", "Landroid/os/Parcelable;", "ssid", "", "bssid", "securityType", "", "level", "frequency", "inOperation", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;IIIZ)V", "getSsid", "()Ljava/lang/String;", "getBssid", "getSecurityType", "()I", "getLevel", "getFrequency", "getInOperation", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraWifiEntity implements Parcelable {
    public static final Parcelable.Creator<DoraWifiEntity> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f338249a;

    @SerializedName("bssid")
    private final String bssid;

    @SerializedName("frequency")
    private final int frequency;

    @SerializedName("level")
    private final int level;

    @SerializedName("security_type")
    private final int securityType;

    @SerializedName("ssid")
    private final String ssid;

    public static final class a {
    }

    public static final class b implements Parcelable.Creator<DoraWifiEntity> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final DoraWifiEntity createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            String r101 = r100.readString();
            String r102 = r100.readString();
            int r103 = r100.readInt();
            int r104 = r100.readInt();
            int r105 = r100.readInt();
            if (r100.readInt() == 0) goto L5;
            boolean r106 = true;
        L7:
            return new DoraWifiEntity(r101, r102, r103, r104, r105, r106);
        L5:
            r106 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final DoraWifiEntity[] newArray(int r100) {
            return new DoraWifiEntity[r100];
        }
    }

    static {
        CREATOR = new b();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DoraWifiEntity) == true) goto L8;
        return false;
    L8:
        DoraWifiEntity r101 = (DoraWifiEntity) r100;
        if (Intrinsics.areEqual(this.ssid, r101.ssid) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.bssid, r101.bssid) == true) goto L15;
        return false;
    L15:
        if (this.securityType == r101.securityType) goto L18;
        return false;
    L18:
        if (this.level == r101.level) goto L21;
        return false;
    L21:
        if (this.frequency == r101.frequency) goto L24;
        return false;
    L24:
        if (this.f338249a == r101.f338249a) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        String r100 = this.ssid;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.bssid;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        int r105 = (((((((r103 + r101) * 31) + this.securityType) * 31) + this.level) * 31) + this.frequency) * 31;
        if (this.f338249a == false) goto L13;
        int r106 = 1231;
    L15:
        return r105 + r106;
    L13:
        r106 = 1237;
        goto L15
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "DoraWifiEntity(ssid=" + this.ssid + ", bssid=" + this.bssid + ", securityType=" + this.securityType + ", level=" + this.level + ", frequency=" + this.frequency + ", inOperation=" + this.f338249a + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.ssid);
        r100.writeString(this.bssid);
        r100.writeInt(this.securityType);
        r100.writeInt(this.level);
        r100.writeInt(this.frequency);
        r100.writeInt(this.f338249a ? 1 : 0);
    }

    public DoraWifiEntity() {
        this("", "", -1, -1, -1, false);
    }

    public final int a() {
        return this.frequency;
    }

    public final int b() {
        return this.securityType;
    }

    public final String c() {
        return this.ssid;
    }

    public DoraWifiEntity(String r100, String r101, int r102, int r103, int r104, boolean r105) {
        this.ssid = r100;
        this.bssid = r101;
        this.securityType = r102;
        this.level = r103;
        this.frequency = r104;
        this.f338249a = r105;
    }
}
