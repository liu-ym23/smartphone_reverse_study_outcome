package com.bytedance.ee.bear.contract.route.parcelable;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.route.RouteBean;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DriveRouteBean extends RouteBean {
    public static final Parcelable.Creator<DriveRouteBean> CREATOR = null;
    public List<Document> v;
    public final String w;

    public class a implements Parcelable.Creator<DriveRouteBean> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final DriveRouteBean createFromParcel(Parcel r2) {
            return new DriveRouteBean(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final DriveRouteBean[] newArray(int r1) {
            return new DriveRouteBean[r1];
        }
    }

    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public DriveRouteBean() {
    }

    public DriveRouteBean(Parcel r2) {
        super(r2);
        this.v = r2.createTypedArrayList(Document.CREATOR);
        this.w = r2.readString();
    }

    public final void writeToParcel(Parcel r1, int r2) {
        super.writeToParcel(r1, r2);
        r1.writeTypedList(this.v);
        r1.writeString(this.w);
    }
}
