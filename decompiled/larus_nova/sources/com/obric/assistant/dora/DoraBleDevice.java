package com.obric.assistant.dora;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.ec.model.response.ECPromotion;
import com.bytedance.crash.dumper.Scraps;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b:\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0095\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u0012\b\b\u0002\u0010\r\u001a\u00020\t\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u000f\u001a\u00020\t\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u00108\u001a\u00020\tHÆ\u0003J\t\u00109\u001a\u00020\tHÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010;\u001a\u00020\tHÆ\u0003J\t\u0010<\u001a\u00020\tHÆ\u0003J\t\u0010=\u001a\u00020\tHÆ\u0003J\t\u0010>\u001a\u00020\tHÆ\u0003J\t\u0010?\u001a\u00020\tHÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0097\u0001\u0010A\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0006\u0010B\u001a\u00020\tJ\u0013\u0010C\u001a\u00020D2\b\u0010E\u001a\u0004\u0018\u00010FHÖ\u0003J\t\u0010G\u001a\u00020\tHÖ\u0001J\t\u0010H\u001a\u00020\u0003HÖ\u0001J\u0016\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020\tR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001b\"\u0004\b\u001f\u0010\u001dR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010\n\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010!\"\u0004\b%\u0010#R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0015\"\u0004\b'\u0010\u0017R\u001a\u0010\f\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010!\"\u0004\b)\u0010#R\u001a\u0010\r\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010!\"\u0004\b+\u0010#R\u001a\u0010\u000e\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010!\"\u0004\b-\u0010#R\u001a\u0010\u000f\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010!\"\u0004\b/\u0010#R\u001a\u0010\u0010\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010!\"\u0004\b1\u0010#R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0015\"\u0004\b3\u0010\u0017¨\u0006N"}, d2 = {"Lcom/obric/assistant/dora/DoraBleDevice;", "Landroid/os/Parcelable;", "mac", "", "name", "charge", "", Scraps.BATTERY, "version", "", "type", "sn", ECPromotion.SKU, "mode", "vendorId", "vendorCapabilities", "productId", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "<init>", "(Ljava/lang/String;Ljava/lang/String;[I[IIILjava/lang/String;IIIIILjava/lang/String;)V", "getMac", "()Ljava/lang/String;", "setMac", "(Ljava/lang/String;)V", "getName", "setName", "getCharge", "()[I", "setCharge", "([I)V", "getBattery", "setBattery", "getVersion", "()I", "setVersion", "(I)V", "getType", "setType", "getSn", "setSn", "getSku", "setSku", "getMode", "setMode", "getVendorId", "setVendorId", "getVendorCapabilities", "setVendorCapabilities", "getProductId", "setProductId", "getModel", "setModel", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraBleDevice implements Parcelable {
    public static final Parcelable.Creator<DoraBleDevice> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f389031a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f389032b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int[] f389033c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int[] f389034d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f389035e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f389036f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f389037g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f389038h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f389039i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f389040j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f389041k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f389042l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f389043m;

    public static final class a implements Parcelable.Creator<DoraBleDevice> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final DoraBleDevice createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            return new DoraBleDevice(r110.readString(), r110.readString(), r110.createIntArray(), r110.createIntArray(), r110.readInt(), r110.readInt(), r110.readString(), r110.readInt(), r110.readInt(), r110.readInt(), r110.readInt(), r110.readInt(), r110.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final DoraBleDevice[] newArray(int r100) {
            return new DoraBleDevice[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public DoraBleDevice() {
        this(null, null, null, null, 0, 0, null, 0, 0, 0, 0, 0, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DoraBleDevice) == true) goto L8;
        return false;
    L8:
        DoraBleDevice r101 = (DoraBleDevice) r100;
        if (Intrinsics.areEqual(this.f389031a, r101.f389031a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f389032b, r101.f389032b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f389033c, r101.f389033c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f389034d, r101.f389034d) == true) goto L21;
        return false;
    L21:
        if (this.f389035e == r101.f389035e) goto L24;
        return false;
    L24:
        if (this.f389036f == r101.f389036f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f389037g, r101.f389037g) == true) goto L30;
        return false;
    L30:
        if (this.f389038h == r101.f389038h) goto L33;
        return false;
    L33:
        if (this.f389039i == r101.f389039i) goto L36;
        return false;
    L36:
        if (this.f389040j == r101.f389040j) goto L39;
        return false;
    L39:
        if (this.f389041k == r101.f389041k) goto L42;
        return false;
    L42:
        if (this.f389042l == r101.f389042l) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f389043m, r101.f389043m) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f389031a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f389032b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        int[] r107 = this.f389033c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        int[] r110 = this.f389034d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (((((r109 + r111) * 31) + this.f389035e) * 31) + this.f389036f) * 31;
        String r113 = this.f389037g;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (((((((((((r112 + r114) * 31) + this.f389038h) * 31) + this.f389039i) * 31) + this.f389040j) * 31) + this.f389041k) * 31) + this.f389042l) * 31;
        String r116 = this.f389043m;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
    L21:
        r114 = r113.hashCode();
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
        return "DoraBleDevice(mac=" + this.f389031a + ", name=" + this.f389032b + ", charge=" + Arrays.toString(this.f389033c) + ", battery=" + Arrays.toString(this.f389034d) + ", version=" + this.f389035e + ", type=" + this.f389036f + ", sn=" + this.f389037g + ", sku=" + this.f389038h + ", mode=" + this.f389039i + ", vendorId=" + this.f389040j + ", vendorCapabilities=" + this.f389041k + ", productId=" + this.f389042l + ", model=" + this.f389043m + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f389031a);
        r100.writeString(this.f389032b);
        r100.writeIntArray(this.f389033c);
        r100.writeIntArray(this.f389034d);
        r100.writeInt(this.f389035e);
        r100.writeInt(this.f389036f);
        r100.writeString(this.f389037g);
        r100.writeInt(this.f389038h);
        r100.writeInt(this.f389039i);
        r100.writeInt(this.f389040j);
        r100.writeInt(this.f389041k);
        r100.writeInt(this.f389042l);
        r100.writeString(this.f389043m);
    }

    public final int getType() {
        return this.f389036f;
    }

    public DoraBleDevice(String r100, String r101, int[] r102, int[] r103, int r104, int r105, String r106, int r107, int r108, int r110, int r111, int r112, String r113) {
        this.f389031a = r100;
        this.f389032b = r101;
        this.f389033c = r102;
        this.f389034d = r103;
        this.f389035e = r104;
        this.f389036f = r105;
        this.f389037g = r106;
        this.f389038h = r107;
        this.f389039i = r108;
        this.f389040j = r110;
        this.f389041k = r111;
        this.f389042l = r112;
        this.f389043m = r113;
    }
}
