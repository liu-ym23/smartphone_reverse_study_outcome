package com.bytedance.ee.bear.contract.create;

import android.os.Parcel;
import android.os.Parcelable;
import du5.b;

/* JADX INFO: loaded from: classes16.dex */
public class DocumentCreateInfo implements Parcelable {
    public static final Parcelable.Creator<DocumentCreateInfo> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f216947a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f216948b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f216949c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f216950d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f216951e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f216952f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f216953g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f216954h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f216955i;

    public class a implements Parcelable.Creator<DocumentCreateInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final DocumentCreateInfo createFromParcel(Parcel r100) {
            return new DocumentCreateInfo(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final DocumentCreateInfo[] newArray(int r100) {
            return new DocumentCreateInfo[r100];
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
        return "DocumentCreateInfo{token='" + b.g(this.f216947a) + "', objToken='" + b.g(this.f216948b) + "', templateToken='" + b.g(this.f216949c) + "', isWiki='" + this.f216955i + "'}";
    }

    public DocumentCreateInfo() {
    }

    public int getType() {
        return this.f216952f;
    }

    public DocumentCreateInfo(Parcel r100) {
        this.f216947a = r100.readString();
        this.f216948b = r100.readString();
        this.f216949c = r100.readString();
        this.f216950d = r100.readString();
        this.f216951e = r100.readString();
        this.f216952f = r100.readInt();
        this.f216954h = r100.readString();
        if (r100.readInt() == 0) goto L5;
        boolean r101 = true;
    L6:
        this.f216955i = r101;
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f216947a);
        r100.writeString(this.f216948b);
        r100.writeString(this.f216949c);
        r100.writeString(this.f216950d);
        r100.writeString(this.f216951e);
        r100.writeInt(this.f216952f);
        r100.writeString(this.f216954h);
        r100.writeInt(this.f216955i ? 1 : 0);
    }

    public DocumentCreateInfo(String r100, String r101, String r102, String r103, String r104, int r105, int r106) {
        this.f216947a = r100;
        this.f216948b = r101;
        this.f216949c = r102;
        this.f216950d = r103;
        this.f216951e = r104;
        this.f216953g = r105;
        this.f216952f = r106;
    }
}
