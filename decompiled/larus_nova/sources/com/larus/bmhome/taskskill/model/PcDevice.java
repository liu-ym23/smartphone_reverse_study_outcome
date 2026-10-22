package com.larus.bmhome.taskskill.model;

import android.os.Parcel;
import android.os.Parcelable;
import be8.d;
import com.dtf.face.config.IConstValues;
import com.google.gson.annotations.SerializedName;
import com.ss.texturerender.effect.ICEffect.ICEffectKeys;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B©\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0006\u0010)\u001a\u00020*J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010.\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010/\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00104\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0011\u00105\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fHÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J°\u0001\u00108\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00109J\u0006\u0010:\u001a\u00020\u0010J\u0013\u0010;\u001a\u00020\u00072\b\u0010<\u001a\u0004\u0018\u00010=HÖ\u0003J\t\u0010>\u001a\u00020\u0010HÖ\u0001J\t\u0010?\u001a\u00020\u0003HÖ\u0001J\u0016\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\u0010R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\b\u0010\u001aR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016R\u001a\u0010\r\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b \u0010\u001aR\u001e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0016R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0016R\u001a\u0010%\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006E"}, d2 = {"Lcom/larus/bmhome/taskskill/model/PcDevice;", "Landroid/os/Parcelable;", "deviceId", "", "deviceName", IConstValues.DEVICE_TYPE, "authorized", "", "isOnline", "appId", "osName", "osVersion", "pcVersion", "enableControl", "supportedReqCmds", "", "", "iconUrl", "iconUrlDark", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getDeviceId", "()Ljava/lang/String;", "getDeviceName", "getDeviceType", "getAuthorized", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getAppId", "getOsName", "getOsVersion", "getPcVersion", "getEnableControl", "getSupportedReqCmds", "()Ljava/util/List;", "getIconUrl", "getIconUrlDark", "isAuthorizing", "()Z", "setAuthorizing", "(Z)V", "toTaskDeviceInfo", "Lcom/larus/bmhome/chat/component/skill/TaskDeviceInfo;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)Lcom/larus/bmhome/taskskill/model/PcDevice;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PcDevice implements Parcelable {
    public static final Parcelable.Creator<PcDevice> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient boolean f314343a;

    @SerializedName("app_id")
    private final String appId;

    @SerializedName("authorized")
    private final Boolean authorized;

    @SerializedName("device_id")
    private final String deviceId;

    @SerializedName(ICEffectKeys.KEY_IS_IC_EFFECT_DEVICE_NAME)
    private final String deviceName;

    @SerializedName("device_type")
    private final String deviceType;

    @SerializedName("enable_control")
    private final Boolean enableControl;

    @SerializedName("icon_url")
    private final String iconUrl;

    @SerializedName("icon_url_dark")
    private final String iconUrlDark;

    @SerializedName("is_online")
    private final Boolean isOnline;

    @SerializedName("os_name")
    private final String osName;

    @SerializedName("os_version")
    private final String osVersion;

    @SerializedName("pc_version")
    private final String pcVersion;

    @SerializedName("supported_req_cmds")
    private final List<Integer> supportedReqCmds;

    public static final class a implements Parcelable.Creator<PcDevice> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final PcDevice createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            String r100 = r110.readString();
            String r101 = r110.readString();
            String r102 = r110.readString();
            int r103 = 0;
            boolean r104 = true;
            ArrayList r105 = null;
            if (r110.readInt() != 0) goto L6;
            Boolean r106 = null;
        L11:
            if (r110.readInt() != 0) goto L14;
            Boolean r107 = null;
        L18:
            String r108 = r110.readString();
            String r111 = r110.readString();
            String r112 = r110.readString();
            String r113 = r110.readString();
            if (r110.readInt() != 0) goto L22;
            Boolean r114 = null;
        L27:
            if (r110.readInt() == 0) goto L33;
            int r109 = r110.readInt();
            r105 = new ArrayList(r109);
        L30:
            if (r103 == r109) goto L33;
            r105.add(Integer.valueOf(r110.readInt()));
            r103 = r103 + 1;
        L33:
            return new PcDevice(r100, r101, r102, r106, r107, r108, r111, r112, r113, r114, r105, r110.readString(), r110.readString());
        L22:
            if (r110.readInt() != 0) goto L25;
            r104 = false;
        L25:
            r114 = Boolean.valueOf(r104);
            goto L27
        L14:
            if (r110.readInt() == 0) goto L16;
            boolean r115 = true;
        L17:
            r107 = Boolean.valueOf(r115);
            goto L18
        L16:
            r115 = false;
            goto L17
        L6:
            if (r110.readInt() == 0) goto L8;
            boolean r116 = true;
        L9:
            r106 = Boolean.valueOf(r116);
            goto L11
        L8:
            r116 = false;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public final PcDevice[] newArray(int r100) {
            return new PcDevice[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public PcDevice() {
        Boolean r110 = Boolean.FALSE;
        this(null, null, null, r110, r110, null, null, null, null, r110, null, null, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PcDevice) == true) goto L8;
        return false;
    L8:
        PcDevice r101 = (PcDevice) r100;
        if (Intrinsics.areEqual(this.deviceId, r101.deviceId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.deviceName, r101.deviceName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.deviceType, r101.deviceType) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.authorized, r101.authorized) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.isOnline, r101.isOnline) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.appId, r101.appId) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.osName, r101.osName) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.osVersion, r101.osVersion) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.pcVersion, r101.pcVersion) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.enableControl, r101.enableControl) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.supportedReqCmds, r101.supportedReqCmds) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.iconUrl, r101.iconUrl) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.iconUrlDark, r101.iconUrlDark) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        String r100 = this.deviceId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.deviceName;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.deviceType;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.authorized;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Boolean r113 = this.isOnline;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.appId;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.osName;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.osVersion;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.pcVersion;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        Boolean r128 = this.enableControl;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        List<Integer> r131 = this.supportedReqCmds;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.iconUrl;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        String r137 = this.iconUrlDark;
        if (r137 == null) goto L55;
        r101 = r137.hashCode();
    L55:
        return r136 + r101;
    L49:
        r135 = r134.hashCode();
        goto L50
    L45:
        r132 = r131.hashCode();
        goto L46
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
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

    public final String toString() {
        return "PcDevice(deviceId=" + this.deviceId + ", deviceName=" + this.deviceName + ", deviceType=" + this.deviceType + ", authorized=" + this.authorized + ", isOnline=" + this.isOnline + ", appId=" + this.appId + ", osName=" + this.osName + ", osVersion=" + this.osVersion + ", pcVersion=" + this.pcVersion + ", enableControl=" + this.enableControl + ", supportedReqCmds=" + this.supportedReqCmds + ", iconUrl=" + this.iconUrl + ", iconUrlDark=" + this.iconUrlDark + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.deviceId);
        r100.writeString(this.deviceName);
        r100.writeString(this.deviceType);
        Boolean r102 = this.authorized;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        Boolean r103 = this.isOnline;
        if (r103 != null) goto L9;
        r100.writeInt(0);
    L10:
        r100.writeString(this.appId);
        r100.writeString(this.osName);
        r100.writeString(this.osVersion);
        r100.writeString(this.pcVersion);
        Boolean r104 = this.enableControl;
        if (r104 != null) goto L13;
        r100.writeInt(0);
    L14:
        List<Integer> r105 = this.supportedReqCmds;
        if (r105 != null) goto L17;
        r100.writeInt(0);
    L21:
        r100.writeString(this.iconUrl);
        r100.writeString(this.iconUrlDark);
        return;
    L17:
        r100.writeInt(1);
        r100.writeInt(r105.size());
        Iterator<Integer> r106 = r105.iterator();
    L19:
        if (r106.hasNext() == false) goto L21;
        r100.writeInt(r106.next().intValue());
        goto L19
    L13:
        r100.writeInt(1);
        r100.writeInt(r104.booleanValue() ? 1 : 0);
        goto L14
    L9:
        r100.writeInt(1);
        r100.writeInt(r103.booleanValue() ? 1 : 0);
        goto L10
    L5:
        r100.writeInt(1);
        r100.writeInt(r102.booleanValue() ? 1 : 0);
        goto L6
    }

    public final d s() {
        return new d(this.deviceId, this.deviceName, this.deviceType, this.appId);
    }

    public final String b() {
        return this.appId;
    }

    public final Boolean c() {
        return this.authorized;
    }

    public final String d() {
        return this.deviceName;
    }

    public final String e() {
        return this.deviceType;
    }

    public final Boolean g() {
        return this.enableControl;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final String h() {
        return this.iconUrl;
    }

    public final String i() {
        return this.iconUrlDark;
    }

    public final String j() {
        return this.osName;
    }

    public final String k() {
        return this.osVersion;
    }

    public final String o() {
        return this.pcVersion;
    }

    public final List<Integer> q() {
        return this.supportedReqCmds;
    }

    public final Boolean r() {
        return this.isOnline;
    }

    public static PcDevice a(PcDevice r110, Boolean r111, Boolean r210, Boolean r211, int r212) {
        String r100 = null;
        if ((r212 & 1) == 0) goto L5;
        String r101 = r110.deviceId;
    L7:
        if ((r212 & 2) == 0) goto L9;
        String r102 = r110.deviceName;
    L11:
        if ((r212 & 4) == 0) goto L13;
        String r103 = r110.deviceType;
    L15:
        if ((r212 & 8) == 0) goto L17;
        Boolean r104 = r110.authorized;
    L19:
        if ((r212 & 16) == 0) goto L21;
        Boolean r105 = r110.isOnline;
    L23:
        if ((r212 & 32) == 0) goto L25;
        String r112 = r110.appId;
    L27:
        if ((r212 & 64) == 0) goto L29;
        String r113 = r110.osName;
    L31:
        if ((r212 & 128) == 0) goto L33;
        String r114 = r110.osVersion;
    L35:
        if ((r212 & 256) == 0) goto L37;
        String r115 = r110.pcVersion;
    L39:
        if ((r212 & 512) == 0) goto L41;
        Boolean r116 = r110.enableControl;
    L43:
        if ((r212 & 1024) == 0) goto L45;
        List<Integer> r117 = r110.supportedReqCmds;
    L47:
        if ((r212 & 2048) == 0) goto L49;
        String r118 = r110.iconUrl;
    L51:
        if ((r212 & 4096) == 0) goto L53;
        r100 = r110.iconUrlDark;
    L53:
        r110.getClass();
        return new PcDevice(r101, r102, r103, r104, r105, r112, r113, r114, r115, r116, r117, r118, r100);
    L49:
        r118 = null;
        goto L51
    L45:
        r117 = null;
        goto L47
    L41:
        r116 = r211;
        goto L43
    L37:
        r115 = null;
        goto L39
    L33:
        r114 = null;
        goto L35
    L29:
        r113 = null;
        goto L31
    L25:
        r112 = null;
        goto L27
    L21:
        r105 = r210;
        goto L23
    L17:
        r104 = r111;
        goto L19
    L13:
        r103 = null;
        goto L15
    L9:
        r102 = null;
        goto L11
    L5:
        r101 = null;
        goto L7
    }

    public PcDevice(String r100, String r101, String r102, Boolean r103, Boolean r104, String r105, String r106, String r107, String r108, Boolean r110, List<Integer> r111, String r112, String r113) {
        this.deviceId = r100;
        this.deviceName = r101;
        this.deviceType = r102;
        this.authorized = r103;
        this.isOnline = r104;
        this.appId = r105;
        this.osName = r106;
        this.osVersion = r107;
        this.pcVersion = r108;
        this.enableControl = r110;
        this.supportedReqCmds = r111;
        this.iconUrl = r112;
        this.iconUrlDark = r113;
    }
}
