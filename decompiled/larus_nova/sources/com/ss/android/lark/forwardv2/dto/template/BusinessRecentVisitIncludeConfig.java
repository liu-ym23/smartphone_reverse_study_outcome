package com.ss.android.lark.forwardv2.dto.template;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.forwardv2.dto.template.config.EntityItem;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes36.dex */
public class BusinessRecentVisitIncludeConfig implements Parcelable {
    public static final Parcelable.Creator<BusinessRecentVisitIncludeConfig> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList<EntityItem> f424822a;

    public class a implements Parcelable.Creator<BusinessRecentVisitIncludeConfig> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final BusinessRecentVisitIncludeConfig createFromParcel(Parcel r100) {
            return new BusinessRecentVisitIncludeConfig(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final BusinessRecentVisitIncludeConfig[] newArray(int r100) {
            return new BusinessRecentVisitIncludeConfig[r100];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public BusinessRecentVisitIncludeConfig() {
        this.f424822a = new ArrayList();
    }

    public BusinessRecentVisitIncludeConfig(Parcel r100) {
        ArrayList<EntityItem> r101 = new ArrayList();
        this.f424822a = r101;
        r100.readTypedList(r101, EntityItem.CREATOR);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeTypedList(this.f424822a);
    }
}
