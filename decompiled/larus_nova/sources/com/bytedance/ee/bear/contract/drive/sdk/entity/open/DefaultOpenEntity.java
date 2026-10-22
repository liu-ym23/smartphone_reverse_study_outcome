package com.bytedance.ee.bear.contract.drive.sdk.entity.open;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes16.dex */
public class DefaultOpenEntity extends BaseOpenEntity {
    public static final Parcelable.Creator<DefaultOpenEntity> CREATOR = null;

    public class a implements Parcelable.Creator<DefaultOpenEntity> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final DefaultOpenEntity createFromParcel(Parcel r100) {
            return new DefaultOpenEntity(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final DefaultOpenEntity[] newArray(int r100) {
            return new DefaultOpenEntity[r100];
        }
    }

    @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void readFromParcel(Parcel r100) {
    }

    static {
        CREATOR = new a();
    }

    public DefaultOpenEntity() {
        super("-1", "", "", "", null);
    }

    public DefaultOpenEntity(Parcel r100) {
        super(r100);
    }

    @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
    }
}
