package com.bytedance.ee.bear.contract.route.parcelable;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.route.RouteBean;
import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
public class DriveRouteBean extends RouteBean {
    public static final Parcelable.Creator<DriveRouteBean> CREATOR = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public List<Document> f217147v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final String f217148w;

    public class a implements Parcelable.Creator<DriveRouteBean> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final DriveRouteBean createFromParcel(Parcel r100) {
            return new DriveRouteBean(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final DriveRouteBean[] newArray(int r100) {
            return new DriveRouteBean[r100];
        }
    }

    @Override // com.bytedance.ee.bear.route.RouteBean, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public DriveRouteBean() {
    }

    public DriveRouteBean(Parcel r100) {
        super(r100);
        this.f217147v = r100.createTypedArrayList(Document.CREATOR);
        this.f217148w = r100.readString();
    }

    @Override // com.bytedance.ee.bear.route.RouteBean, android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
        r100.writeTypedList(this.f217147v);
        r100.writeString(this.f217148w);
    }
}
