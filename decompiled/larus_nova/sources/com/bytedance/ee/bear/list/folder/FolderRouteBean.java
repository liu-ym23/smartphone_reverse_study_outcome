package com.bytedance.ee.bear.list.folder;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.bear.route.RouteBean;

/* JADX INFO: loaded from: classes18.dex */
public class FolderRouteBean extends RouteBean {
    public static final Parcelable.Creator<FolderRouteBean> CREATOR = null;
    public int A;
    public boolean B;
    public boolean C;
    public String D;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f228002v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f228003w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f228004x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f228005y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f228006z;

    public class a implements Parcelable.Creator<FolderRouteBean> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final FolderRouteBean createFromParcel(Parcel r100) {
            return new FolderRouteBean(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final FolderRouteBean[] newArray(int r100) {
            return new FolderRouteBean[r100];
        }
    }

    @Override // com.bytedance.ee.bear.route.RouteBean, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public FolderRouteBean() {
    }

    public FolderRouteBean(Parcel r100) {
        super(r100);
        this.f228002v = r100.readInt();
        this.f228003w = r100.readString();
        this.f228004x = r100.readString();
        this.f228005y = r100.readInt();
        this.f228006z = r100.readInt();
        boolean r101 = true;
        if (r100.readByte() == 0) goto L5;
        boolean r102 = true;
    L6:
        this.B = r102;
        if (r100.readByte() != 0) goto L10;
        r101 = false;
    L10:
        this.C = r101;
        this.A = r100.readInt();
        this.D = r100.readString();
        return;
    L5:
        r102 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.route.RouteBean, android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
        r100.writeInt(this.f228002v);
        r100.writeString(this.f228003w);
        r100.writeString(this.f228004x);
        r100.writeInt(this.f228005y);
        r100.writeInt(this.f228006z);
        r100.writeByte(this.B ? 1 : 0);
        r100.writeByte(this.C ? 1 : 0);
        r100.writeInt(this.A);
        r100.writeString(this.D);
    }
}
