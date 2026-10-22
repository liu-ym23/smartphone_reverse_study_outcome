package com.bytedance.ee.bear.wikiv2.selector;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.bear.contract.route.parcelable.WikNodePerm;

/* JADX INFO: loaded from: classes18.dex */
public class WikiSelectorBean implements Parcelable {
    public static final Parcelable.Creator<WikiSelectorBean> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f241128a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f241129b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f241130c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f241131d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f241132e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f241133f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f241134g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f241135h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f241136i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f241137j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f241138k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f241139l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f241140m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f241141n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f241142o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public WikNodePerm f241143p;

    public class a implements Parcelable.Creator<WikiSelectorBean> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final WikiSelectorBean createFromParcel(Parcel r100) {
            return new WikiSelectorBean(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final WikiSelectorBean[] newArray(int r100) {
            return new WikiSelectorBean[r100];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public WikiSelectorBean() {
    }

    public WikiSelectorBean(Parcel r100) {
        this.f241128a = r100.readString();
        this.f241129b = r100.readString();
        this.f241131d = r100.readString();
        this.f241133f = r100.readString();
        this.f241134g = r100.readString();
        boolean r101 = true;
        if (r100.readByte() == 0) goto L5;
        boolean r102 = true;
    L6:
        this.f241135h = r102;
        this.f241143p = (WikNodePerm) r100.readSerializable();
        this.f241136i = r100.readString();
        this.f241137j = r100.readInt();
        this.f241130c = r100.readString();
        this.f241132e = r100.readString();
        this.f241138k = r100.readLong();
        if (r100.readByte() == 0) goto L9;
        boolean r103 = true;
    L10:
        this.f241139l = r103;
        this.f241140m = r100.readInt();
        if (r100.readByte() == 0) goto L13;
        boolean r104 = true;
    L14:
        this.f241141n = r104;
        if (r100.readByte() != 0) goto L18;
        r101 = false;
    L18:
        this.f241142o = r101;
        return;
    L13:
        r104 = false;
        goto L14
    L9:
        r103 = false;
        goto L10
    L5:
        r102 = false;
        goto L6
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f241128a);
        r100.writeString(this.f241129b);
        r100.writeString(this.f241131d);
        r100.writeString(this.f241133f);
        r100.writeString(this.f241134g);
        r100.writeByte(this.f241135h ? 1 : 0);
        r100.writeSerializable(this.f241143p);
        r100.writeString(this.f241136i);
        r100.writeInt(this.f241137j);
        r100.writeString(this.f241130c);
        r100.writeString(this.f241132e);
        r100.writeLong(this.f241138k);
        r100.writeByte(this.f241139l ? 1 : 0);
        r100.writeInt(this.f241140m);
        r100.writeByte(this.f241141n ? 1 : 0);
        r100.writeByte(this.f241142o ? 1 : 0);
    }
}
