package com.bytedance.ee.bear.contract.route.parcelable;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.bear.route.RouteBean;

/* JADX INFO: loaded from: classes16.dex */
public class WikiRouteBean extends RouteBean {
    public static final Parcelable.Creator<WikiRouteBean> CREATOR = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f217154v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f217155w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final String f217156x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final String f217157y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final String f217158z;

    public class a implements Parcelable.Creator<WikiRouteBean> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final WikiRouteBean createFromParcel(Parcel r100) {
            return new WikiRouteBean(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final WikiRouteBean[] newArray(int r100) {
            return new WikiRouteBean[r100];
        }
    }

    @Override // com.bytedance.ee.bear.route.RouteBean, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public WikiRouteBean(Parcel r100) {
        super(r100);
        this.f217154v = r100.readString();
        this.f217155w = r100.readInt();
        this.f217156x = r100.readString();
        this.f217157y = r100.readString();
        this.f217158z = r100.readString();
    }

    @Override // com.bytedance.ee.bear.route.RouteBean, android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
        r100.writeString(this.f217154v);
        r100.writeInt(this.f217155w);
        r100.writeString(this.f217156x);
        r100.writeString(this.f217157y);
        r100.writeString(this.f217158z);
    }

    public WikiRouteBean(String r100, int r101, String r102, String r103, String r104) {
        this.f217154v = r100;
        this.f217155w = r101;
        this.f217156x = r102;
        this.f217157y = r103;
        this.f217158z = r104;
    }
}
