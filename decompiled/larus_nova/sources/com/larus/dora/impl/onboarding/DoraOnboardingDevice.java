package com.larus.dora.impl.onboarding;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.ec.model.response.ECPromotion;
import com.bytedance.crash.dumper.Scraps;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0096\u0002J\b\u0010 \u001a\u00020\u0007H\u0016J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0007HÆ\u0003J\t\u0010%\u001a\u00020\u0007HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010(\u001a\u00020\u0007HÆ\u0003J\t\u0010)\u001a\u00020\u0007HÆ\u0003Jg\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u0007HÆ\u0001J\u0006\u0010+\u001a\u00020\u0007J\t\u0010,\u001a\u00020\u0003HÖ\u0001J\u0016\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0011\u0010\r\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015¨\u00062"}, d2 = {"Lcom/larus/dora/impl/onboarding/DoraOnboardingDevice;", "Landroid/os/Parcelable;", "name", "", "mac", "sn", "type", "", ECPromotion.SKU, Scraps.BATTERY, "", "charge", "productId", "vendorID", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II[I[III)V", "getName", "()Ljava/lang/String;", "getMac", "getSn", "getType", "()I", "getSku", "getBattery", "()[I", "getCharge", "getProductId", "getVendorID", "equals", "", "other", "", "hashCode", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraOnboardingDevice implements Parcelable {
    public static final Parcelable.Creator<DoraOnboardingDevice> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f336551a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f336552b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f336553c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f336554d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f336555e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int[] f336556f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int[] f336557g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f336558h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f336559i;

    public static final class a implements Parcelable.Creator<DoraOnboardingDevice> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final DoraOnboardingDevice createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            return new DoraOnboardingDevice(r110.readString(), r110.readString(), r110.readString(), r110.readInt(), r110.readInt(), r110.createIntArray(), r110.createIntArray(), r110.readInt(), r110.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final DoraOnboardingDevice[] newArray(int r100) {
            return new DoraOnboardingDevice[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "DoraOnboardingDevice(name=" + this.f336551a + ", mac=" + this.f336552b + ", sn=" + this.f336553c + ", type=" + this.f336554d + ", sku=" + this.f336555e + ", battery=" + Arrays.toString(this.f336556f) + ", charge=" + Arrays.toString(this.f336557g) + ", productId=" + this.f336558h + ", vendorID=" + this.f336559i + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f336551a);
        r100.writeString(this.f336552b);
        r100.writeString(this.f336553c);
        r100.writeInt(this.f336554d);
        r100.writeInt(this.f336555e);
        r100.writeIntArray(this.f336556f);
        r100.writeIntArray(this.f336557g);
        r100.writeInt(this.f336558h);
        r100.writeInt(this.f336559i);
    }

    public final int hashCode() {
        int r100 = ((((((((this.f336551a.hashCode() * 31) + this.f336552b.hashCode()) * 31) + this.f336553c.hashCode()) * 31) + this.f336554d) * 31) + this.f336555e) * 31;
        int[] r101 = this.f336556f;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = Arrays.hashCode(r101);
    L6:
        int r104 = (r100 + r103) * 31;
        int[] r105 = this.f336557g;
        if (r105 == null) goto L10;
        r102 = Arrays.hashCode(r105);
    L10:
        return ((((r104 + r102) * 31) + this.f336558h) * 31) + this.f336559i;
    L5:
        r103 = 0;
        goto L6
    }

    public final int getType() {
        return this.f336554d;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(DoraOnboardingDevice.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.larus.dora.impl.onboarding.DoraOnboardingDevice");
        DoraOnboardingDevice r102 = (DoraOnboardingDevice) r100;
        if (Intrinsics.areEqual(this.f336551a, r102.f336551a) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f336552b, r102.f336552b) == true) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(this.f336553c, r102.f336553c) == true) goto L22;
        return false;
    L22:
        if (this.f336554d == r102.f336554d) goto L25;
        return false;
    L25:
        if (this.f336555e == r102.f336555e) goto L27;
        return false;
    L27:
        int[] r103 = this.f336556f;
        if (r103 == null) goto L36;
        int[] r104 = r102.f336556f;
        if (r104 != null) goto L33;
        return false;
    L33:
        if (Arrays.equals(r103, r104) == true) goto L38;
        return false;
    L38:
        int[] r105 = this.f336557g;
        if (r105 == null) goto L47;
        int[] r106 = r102.f336557g;
        if (r106 != null) goto L44;
        return false;
    L44:
        if (Arrays.equals(r105, r106) == true) goto L50;
        return false;
    L50:
        if (this.f336558h == r102.f336558h) goto L53;
        return false;
    L53:
        if (this.f336559i == r102.f336559i) goto L55;
        return false;
    L55:
        return true;
    L47:
        if (r102.f336557g == null) goto L50;
        return false;
    L36:
        if (r102.f336556f == null) goto L38;
        return false;
    L8:
        r101 = null;
        goto L10
    }

    public DoraOnboardingDevice(String r100, String r101, String r102, int r103, int r104, int[] r105, int[] r106, int r107, int r110) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "mac");
        Intrinsics.checkNotNullParameter(r102, "sn");
        this.f336551a = r100;
        this.f336552b = r101;
        this.f336553c = r102;
        this.f336554d = r103;
        this.f336555e = r104;
        this.f336556f = r105;
        this.f336557g = r106;
        this.f336558h = r107;
        this.f336559i = r110;
    }
}
