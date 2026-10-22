package com.bytedance.ee.bear.contract.route.parcelable;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.bear.route.RouteBean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class WikiRouteBean extends RouteBean {
    public static final Parcelable.Creator<WikiRouteBean> CREATOR = null;
    public final String v;
    public final int w;
    public final String x;
    public final String y;
    public final String z;

    public class a implements Parcelable.Creator<WikiRouteBean> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final WikiRouteBean createFromParcel(Parcel r2) {
            return new WikiRouteBean(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final WikiRouteBean[] newArray(int r1) {
            return new WikiRouteBean[r1];
        }
    }

    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public WikiRouteBean(Parcel r2) {
        super(r2);
        this.v = r2.readString();
        this.w = r2.readInt();
        this.x = r2.readString();
        this.y = r2.readString();
        this.z = r2.readString();
    }

    public final void writeToParcel(Parcel r1, int r2) {
        super.writeToParcel(r1, r2);
        r1.writeString(this.v);
        r1.writeInt(this.w);
        r1.writeString(this.x);
        r1.writeString(this.y);
        r1.writeString(this.z);
    }

    public WikiRouteBean(String r1, int r2, String r3, String r4, String r5) {
        this.v = r1;
        this.w = r2;
        this.x = r3;
        this.y = r4;
        this.z = r5;
    }
}
