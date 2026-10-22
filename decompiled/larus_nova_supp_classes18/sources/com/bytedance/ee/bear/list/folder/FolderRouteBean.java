package com.bytedance.ee.bear.list.folder;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.bear.route.RouteBean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class FolderRouteBean extends RouteBean {
    public static final Parcelable.Creator<FolderRouteBean> CREATOR = null;
    public int A;
    public boolean B;
    public boolean C;
    public String D;
    public int v;
    public String w;
    public String x;
    public int y;
    public int z;

    public class a implements Parcelable.Creator<FolderRouteBean> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final FolderRouteBean createFromParcel(Parcel r2) {
            return new FolderRouteBean(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final FolderRouteBean[] newArray(int r1) {
            return new FolderRouteBean[r1];
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

    public FolderRouteBean(Parcel r4) {
        super(r4);
        this.v = r4.readInt();
        this.w = r4.readString();
        this.x = r4.readString();
        this.y = r4.readInt();
        this.z = r4.readInt();
        boolean r1 = true;
        if (r4.readByte() == 0) goto L5;
        boolean r0 = true;
    L6:
        this.B = r0;
        if (r4.readByte() != 0) goto L10;
        r1 = false;
    L10:
        this.C = r1;
        this.A = r4.readInt();
        this.D = r4.readString();
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.route.RouteBean, android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        super.writeToParcel(r1, r2);
        r1.writeInt(this.v);
        r1.writeString(this.w);
        r1.writeString(this.x);
        r1.writeInt(this.y);
        r1.writeInt(this.z);
        r1.writeByte(this.B ? 1 : 0);
        r1.writeByte(this.C ? 1 : 0);
        r1.writeInt(this.A);
        r1.writeString(this.D);
    }
}
