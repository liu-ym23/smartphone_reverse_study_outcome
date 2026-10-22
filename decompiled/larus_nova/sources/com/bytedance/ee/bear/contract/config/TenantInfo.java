package com.bytedance.ee.bear.contract.config;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
public class TenantInfo implements Parcelable {
    public static final Parcelable.Creator<TenantInfo> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f216936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f216937b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f216938c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f216939d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final InterfaceDomain f216940e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f216941f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<String> f216942g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f216943h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f216944i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f216945j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f216946k;

    public class a implements Parcelable.Creator<TenantInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final TenantInfo createFromParcel(Parcel r100) {
            return new TenantInfo(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final TenantInfo[] newArray(int r100) {
            return new TenantInfo[r100];
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
        return "TenantInfo{hostDomain='" + this.f216936a + "', country='" + this.f216937b + "', isOversea=" + this.f216939d + ", interfaceDomain=" + this.f216940e + ", mainPersistentConnectionDomain='" + this.f216941f + "', persistentConnectionKey='" + this.f216943h + "', configPlatformURL='" + this.f216944i + "', frontendHotFixDomain='" + this.f216945j + '}';
    }

    public TenantInfo(Parcel r100) {
        this.f216936a = r100.readString();
        this.f216937b = r100.readString();
        if (r100.readByte() == 0) goto L5;
        boolean r101 = true;
    L6:
        this.f216939d = r101;
        this.f216940e = (InterfaceDomain) r100.readParcelable(InterfaceDomain.class.getClassLoader());
        this.f216941f = r100.readString();
        this.f216943h = r100.readString();
        this.f216944i = r100.readString();
        this.f216945j = r100.readString();
        this.f216946k = r100.readInt();
        this.f216942g = r100.createStringArrayList();
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f216936a);
        r100.writeString(this.f216937b);
        r100.writeByte(this.f216939d ? 1 : 0);
        r100.writeParcelable(this.f216940e, r101);
        r100.writeString(this.f216941f);
        r100.writeString(this.f216943h);
        r100.writeString(this.f216944i);
        r100.writeString(this.f216945j);
        r100.writeInt(this.f216946k);
        r100.writeStringList(this.f216942g);
    }

    public TenantInfo(String r100, String r101, boolean r102, InterfaceDomain r103, String r104, List r105, String r106, String r107, int r108, String r110) {
        this.f216936a = r100;
        this.f216938c = r101;
        this.f216937b = "";
        this.f216939d = r102;
        this.f216940e = r103;
        this.f216941f = r104;
        this.f216942g = r105;
        this.f216944i = r106;
        this.f216945j = r107;
        this.f216946k = r108;
        this.f216943h = r110;
    }
}
