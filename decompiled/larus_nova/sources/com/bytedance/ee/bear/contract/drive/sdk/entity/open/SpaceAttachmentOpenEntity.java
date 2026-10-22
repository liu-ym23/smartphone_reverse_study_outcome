package com.bytedance.ee.bear.contract.drive.sdk.entity.open;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes16.dex */
public class SpaceAttachmentOpenEntity extends BaseSpaceOpenEntity {
    public static final Parcelable.Creator<SpaceAttachmentOpenEntity> CREATOR = null;

    public class a implements Parcelable.Creator<SpaceAttachmentOpenEntity> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SpaceAttachmentOpenEntity createFromParcel(Parcel r100) {
            return new SpaceAttachmentOpenEntity(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final SpaceAttachmentOpenEntity[] newArray(int r100) {
            return new SpaceAttachmentOpenEntity[r100];
        }
    }

    @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseSpaceOpenEntity, com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public SpaceAttachmentOpenEntity(Parcel r100) {
        super(r100);
    }

    @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseSpaceOpenEntity
    public void readFromParcel(Parcel r100) {
        super.readFromParcel(r100);
    }

    @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseSpaceOpenEntity, com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
    }

    public SpaceAttachmentOpenEntity(String r100, String r101, String r102) {
        super(r100, r101, r102);
        setBizType(4);
    }
}
