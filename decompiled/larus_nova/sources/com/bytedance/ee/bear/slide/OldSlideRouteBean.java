package com.bytedance.ee.bear.slide;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.bear.route.RouteBean;

/* JADX INFO: loaded from: classes18.dex */
public class OldSlideRouteBean extends RouteBean {
    public static final Parcelable.Creator<OldSlideRouteBean> CREATOR = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f238570v;

    public class a implements Parcelable.Creator<OldSlideRouteBean> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final OldSlideRouteBean createFromParcel(Parcel r100) {
            return new OldSlideRouteBean(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final OldSlideRouteBean[] newArray(int r100) {
            return new OldSlideRouteBean[r100];
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

    public OldSlideRouteBean(Parcel r100) {
        super(r100);
        if (r100.readByte() == 0) goto L5;
        boolean r101 = true;
    L6:
        this.f238570v = r101;
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.route.RouteBean, android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
        r100.writeByte(this.f238570v ? 1 : 0);
    }
}
