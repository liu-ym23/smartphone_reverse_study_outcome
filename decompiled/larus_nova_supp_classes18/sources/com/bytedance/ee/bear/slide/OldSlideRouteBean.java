package com.bytedance.ee.bear.slide;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.bear.route.RouteBean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class OldSlideRouteBean extends RouteBean {
    public static final Parcelable.Creator<OldSlideRouteBean> CREATOR = null;
    public final boolean v;

    public class a implements Parcelable.Creator<OldSlideRouteBean> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final OldSlideRouteBean createFromParcel(Parcel r2) {
            return new OldSlideRouteBean(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final OldSlideRouteBean[] newArray(int r1) {
            return new OldSlideRouteBean[r1];
        }
    }

    @Override // com.bytedance.ee.bear.route.RouteBean, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public OldSlideRouteBean() {
    }

    public OldSlideRouteBean(Parcel r1) {
        super(r1);
        if (r1.readByte() == 0) goto L5;
        boolean r2 = true;
    L6:
        this.v = r2;
        return;
    L5:
        r2 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.route.RouteBean, android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        super.writeToParcel(r1, r2);
        r1.writeByte(this.v ? 1 : 0);
    }
}
