package com.obric.assistant.dora;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.ec.model.response.ECPromotion;
import com.bytedance.crash.dumper.Scraps;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b;\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B£\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\f¢\u0006\u0004\b\u0013\u0010\u0014J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010>\u001a\u00020\fHÆ\u0003J\t\u0010?\u001a\u00020\fHÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010A\u001a\u00020\fHÆ\u0003J\t\u0010B\u001a\u00020\fHÆ\u0003J\t\u0010C\u001a\u00020\fHÆ\u0003J\t\u0010D\u001a\u00020\fHÆ\u0003J¥\u0001\u0010E\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\f2\b\b\u0002\u0010\u0011\u001a\u00020\f2\b\b\u0002\u0010\u0012\u001a\u00020\fHÆ\u0001J\u0006\u0010F\u001a\u00020\fJ\u0013\u0010G\u001a\u00020H2\b\u0010I\u001a\u0004\u0018\u00010JHÖ\u0003J\t\u0010K\u001a\u00020\fHÖ\u0001J\t\u0010L\u001a\u00020\u0003HÖ\u0001J\u0016\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020\fR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001c\"\u0004\b \u0010\u001eR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001c\"\u0004\b\"\u0010\u001eR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001c\"\u0004\b$\u0010\u001eR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001c\"\u0004\b&\u0010\u001eR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010\r\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010(\"\u0004\b,\u0010*R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0016\"\u0004\b.\u0010\u0018R\u001a\u0010\u000f\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010(\"\u0004\b0\u0010*R\u001a\u0010\u0010\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010(\"\u0004\b2\u0010*R\u001a\u0010\u0011\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010(\"\u0004\b4\u0010*R\u001a\u0010\u0012\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010(\"\u0004\b6\u0010*¨\u0006R"}, d2 = {"Lcom/obric/assistant/dora/DoraDeviceInfo;", "Landroid/os/Parcelable;", "mac", "", "name", "state", "", "charge", Scraps.BATTERY, "wearState", "idleState", "version", "", "type", "sn", ECPromotion.SKU, "mode", "vendorId", "productId", "<init>", "(Ljava/lang/String;Ljava/lang/String;[I[I[I[I[IIILjava/lang/String;IIII)V", "getMac", "()Ljava/lang/String;", "setMac", "(Ljava/lang/String;)V", "getName", "setName", "getState", "()[I", "setState", "([I)V", "getCharge", "setCharge", "getBattery", "setBattery", "getWearState", "setWearState", "getIdleState", "setIdleState", "getVersion", "()I", "setVersion", "(I)V", "getType", "setType", "getSn", "setSn", "getSku", "setSku", "getMode", "setMode", "getVendorId", "setVendorId", "getProductId", "setProductId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraDeviceInfo implements Parcelable {
    public static final Parcelable.Creator<DoraDeviceInfo> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f389056a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f389057b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int[] f389058c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int[] f389059d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int[] f389060e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int[] f389061f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int[] f389062g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f389063h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f389064i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f389065j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f389066k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f389067l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f389068m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f389069n;

    public static final class a implements Parcelable.Creator<DoraDeviceInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final DoraDeviceInfo createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            return new DoraDeviceInfo(r110.readString(), r110.readString(), r110.createIntArray(), r110.createIntArray(), r110.createIntArray(), r110.createIntArray(), r110.createIntArray(), r110.readInt(), r110.readInt(), r110.readString(), r110.readInt(), r110.readInt(), r110.readInt(), r110.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final DoraDeviceInfo[] newArray(int r100) {
            return new DoraDeviceInfo[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public DoraDeviceInfo() {
        this(null, null, null, null, 0, 0, null, 0, 0, 0, 0, 16383);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DoraDeviceInfo) == true) goto L8;
        return false;
    L8:
        DoraDeviceInfo r101 = (DoraDeviceInfo) r100;
        if (Intrinsics.areEqual(this.f389056a, r101.f389056a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f389057b, r101.f389057b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f389058c, r101.f389058c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f389059d, r101.f389059d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f389060e, r101.f389060e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f389061f, r101.f389061f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f389062g, r101.f389062g) == true) goto L30;
        return false;
    L30:
        if (this.f389063h == r101.f389063h) goto L33;
        return false;
    L33:
        if (this.f389064i == r101.f389064i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f389065j, r101.f389065j) == true) goto L39;
        return false;
    L39:
        if (this.f389066k == r101.f389066k) goto L42;
        return false;
    L42:
        if (this.f389067l == r101.f389067l) goto L45;
        return false;
    L45:
        if (this.f389068m == r101.f389068m) goto L48;
        return false;
    L48:
        if (this.f389069n == r101.f389069n) goto L50;
        return false;
    L50:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f389056a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f389057b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        int[] r107 = this.f389058c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        int[] r110 = this.f389059d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        int[] r113 = this.f389060e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        int[] r116 = this.f389061f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        int[] r119 = this.f389062g;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (((((r118 + r120) * 31) + this.f389063h) * 31) + this.f389064i) * 31;
        String r122 = this.f389065j;
        if (r122 == null) goto L35;
        r101 = r122.hashCode();
    L35:
        return ((((((((r121 + r101) * 31) + this.f389066k) * 31) + this.f389067l) * 31) + this.f389068m) * 31) + this.f389069n;
    L29:
        r120 = Arrays.hashCode(r119);
        goto L30
    L25:
        r117 = Arrays.hashCode(r116);
        goto L26
    L21:
        r114 = Arrays.hashCode(r113);
        goto L22
    L17:
        r111 = Arrays.hashCode(r110);
        goto L18
    L13:
        r108 = Arrays.hashCode(r107);
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "DoraDeviceInfo(mac=" + this.f389056a + ", name=" + this.f389057b + ", state=" + Arrays.toString(this.f389058c) + ", charge=" + Arrays.toString(this.f389059d) + ", battery=" + Arrays.toString(this.f389060e) + ", wearState=" + Arrays.toString(this.f389061f) + ", idleState=" + Arrays.toString(this.f389062g) + ", version=" + this.f389063h + ", type=" + this.f389064i + ", sn=" + this.f389065j + ", sku=" + this.f389066k + ", mode=" + this.f389067l + ", vendorId=" + this.f389068m + ", productId=" + this.f389069n + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f389056a);
        r100.writeString(this.f389057b);
        r100.writeIntArray(this.f389058c);
        r100.writeIntArray(this.f389059d);
        r100.writeIntArray(this.f389060e);
        r100.writeIntArray(this.f389061f);
        r100.writeIntArray(this.f389062g);
        r100.writeInt(this.f389063h);
        r100.writeInt(this.f389064i);
        r100.writeString(this.f389065j);
        r100.writeInt(this.f389066k);
        r100.writeInt(this.f389067l);
        r100.writeInt(this.f389068m);
        r100.writeInt(this.f389069n);
    }

    public final int getType() {
        return this.f389064i;
    }

    public static DoraDeviceInfo a(DoraDeviceInfo r110, int[] r210, int[] r211, int r212) {
        String r100 = null;
        if ((r212 & 1) == 0) goto L5;
        String r101 = r110.f389056a;
    L7:
        if ((r212 & 2) == 0) goto L9;
        String r102 = r110.f389057b;
    L11:
        if ((r212 & 4) == 0) goto L13;
        int[] r103 = r110.f389058c;
    L15:
        if ((r212 & 8) == 0) goto L17;
        int[] r104 = r110.f389059d;
    L19:
        if ((r212 & 16) == 0) goto L21;
        int[] r105 = r110.f389060e;
    L23:
        if ((r212 & 32) == 0) goto L25;
        int[] r111 = r110.f389061f;
    L27:
        if ((r212 & 64) == 0) goto L29;
        int[] r112 = r110.f389062g;
    L31:
        if ((r212 & 128) == 0) goto L33;
        int r113 = r110.f389063h;
    L35:
        if ((r212 & 256) == 0) goto L37;
        int r114 = r110.f389064i;
    L39:
        if ((r212 & 512) == 0) goto L41;
        r100 = r110.f389065j;
    L41:
        String r115 = r100;
        if ((r212 & 1024) == 0) goto L44;
        int r116 = r110.f389066k;
    L46:
        if ((r212 & 2048) == 0) goto L48;
        int r117 = r110.f389067l;
    L50:
        if ((r212 & 4096) == 0) goto L52;
        int r118 = r110.f389068m;
    L54:
        if ((r212 & 8192) == 0) goto L56;
        int r119 = r110.f389069n;
    L58:
        return new DoraDeviceInfo(r101, r102, r103, r104, r105, r111, r112, r113, r114, r115, r116, r117, r118, r119);
    L56:
        r119 = 0;
        goto L58
    L52:
        r118 = 0;
        goto L54
    L48:
        r117 = 0;
        goto L50
    L44:
        r116 = 0;
        goto L46
    L37:
        r114 = 0;
        goto L39
    L33:
        r113 = 0;
        goto L35
    L29:
        r112 = null;
        goto L31
    L25:
        r111 = null;
        goto L27
    L21:
        r105 = r211;
        goto L23
    L17:
        r104 = r210;
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

    public /* synthetic */ DoraDeviceInfo(String r110, String r210, int[] r211, int[] r212, int r213, int r214, String r215, int r216, int r217, int r218, int r219, int r310) {
        if ((r310 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r310 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r310 & 8) == 0) goto L13;
        int[] r102 = null;
    L15:
        if ((r310 & 16) == 0) goto L17;
        int[] r103 = null;
    L19:
        if ((r310 & 128) == 0) goto L21;
        int r111 = 0;
    L23:
        if ((r310 & 256) == 0) goto L25;
        int r112 = 0;
    L27:
        if ((r310 & 512) == 0) goto L29;
        String r113 = null;
    L31:
        if ((r310 & 1024) == 0) goto L33;
        int r114 = 0;
    L35:
        if ((r310 & 2048) == 0) goto L37;
        int r115 = 0;
    L39:
        if ((r310 & 4096) == 0) goto L41;
        int r116 = 0;
    L43:
        if ((r310 & 8192) == 0) goto L45;
        int r117 = 0;
    L46:
        this(r100, r101, null, r102, r103, null, null, r111, r112, r113, r114, r115, r116, r117);
        return;
    L45:
        r117 = r219;
        goto L46
    L41:
        r116 = r218;
        goto L43
    L37:
        r115 = r217;
        goto L39
    L33:
        r114 = r216;
        goto L35
    L29:
        r113 = r215;
        goto L31
    L25:
        r112 = r214;
        goto L27
    L21:
        r111 = r213;
        goto L23
    L17:
        r103 = r212;
        goto L19
    L13:
        r102 = r211;
        goto L15
    L9:
        r101 = r210;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public DoraDeviceInfo(String r100, String r101, int[] r102, int[] r103, int[] r104, int[] r105, int[] r106, int r107, int r108, String r110, int r111, int r112, int r113, int r114) {
        this.f389056a = r100;
        this.f389057b = r101;
        this.f389058c = r102;
        this.f389059d = r103;
        this.f389060e = r104;
        this.f389061f = r105;
        this.f389062g = r106;
        this.f389063h = r107;
        this.f389064i = r108;
        this.f389065j = r110;
        this.f389066k = r111;
        this.f389067l = r112;
        this.f389068m = r113;
        this.f389069n = r114;
    }
}
