package com.bytedance.ee.bear.contract.config;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes16.dex */
public class DocDynamicConfig implements Parcelable {
    public static final Parcelable.Creator<DocDynamicConfig> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f216917a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TenantInfo f216918b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f216919c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f216920d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f216921e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LoginInfo f216922f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f216923g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f216924h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f216925i;

    public class a implements Parcelable.Creator<DocDynamicConfig> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final DocDynamicConfig createFromParcel(Parcel r100) {
            return new DocDynamicConfig(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final DocDynamicConfig[] newArray(int r100) {
            return new DocDynamicConfig[r100];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public final String toString() {
        return "DocDynamicConfig{', deviceId='" + this.f216917a + "', tenantInfo=" + this.f216918b + ", showDocWatermark=" + this.f216919c + ", isKABuildPackage=" + this.f216920d + ", buildPackageChannel='" + this.f216921e + ", userUnit='" + this.f216923g + ", brand='" + this.f216924h + "'}";
    }

    public DocDynamicConfig(Parcel r100) {
        boolean r101 = false;
        this.f216920d = false;
        this.f216921e = "normal";
        this.f216925i = false;
        this.f216917a = r100.readString();
        this.f216918b = (TenantInfo) r100.readParcelable(TenantInfo.class.getClassLoader());
        if (r100.readByte() == 0) goto L5;
        boolean r102 = true;
    L6:
        this.f216919c = r102;
        if (r100.readByte() == 0) goto L9;
        boolean r103 = true;
    L10:
        this.f216920d = r103;
        this.f216921e = r100.readString();
        this.f216923g = r100.readString();
        this.f216924h = r100.readString();
        this.f216922f = (LoginInfo) r100.readParcelable(LoginInfo.class.getClassLoader());
        if (r100.readByte() == 0) goto L13;
        r101 = true;
    L13:
        this.f216925i = r101;
        return;
    L9:
        r103 = false;
        goto L10
    L5:
        r102 = false;
        goto L6
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f216917a);
        r100.writeParcelable(this.f216918b, r101);
        r100.writeByte(this.f216919c ? 1 : 0);
        r100.writeByte(this.f216920d ? 1 : 0);
        r100.writeString(this.f216921e);
        r100.writeString(this.f216923g);
        r100.writeString(this.f216924h);
        r100.writeParcelable(this.f216922f, r101);
        r100.writeByte(this.f216925i ? 1 : 0);
    }

    public DocDynamicConfig(LoginInfo r100, String r101, TenantInfo r102, boolean r103, boolean r104, String r105, String r106, String r110, boolean r111) {
        this.f216920d = false;
        this.f216921e = "normal";
        this.f216925i = false;
        this.f216922f = r100;
        this.f216917a = r101;
        this.f216918b = r102;
        this.f216919c = r103;
        this.f216920d = r104;
        this.f216921e = r105;
        this.f216923g = r106;
        this.f216924h = r110;
        this.f216925i = r111;
    }
}
