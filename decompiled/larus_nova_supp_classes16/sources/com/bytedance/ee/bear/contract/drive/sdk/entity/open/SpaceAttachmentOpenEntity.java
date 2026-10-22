package com.bytedance.ee.bear.contract.drive.sdk.entity.open;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class SpaceAttachmentOpenEntity extends BaseSpaceOpenEntity {
    public static final Parcelable.Creator<SpaceAttachmentOpenEntity> CREATOR = null;

    public class a implements Parcelable.Creator<SpaceAttachmentOpenEntity> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SpaceAttachmentOpenEntity createFromParcel(Parcel r2) {
            return new SpaceAttachmentOpenEntity(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final SpaceAttachmentOpenEntity[] newArray(int r1) {
            return new SpaceAttachmentOpenEntity[r1];
        }
    }

    @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseSpaceOpenEntity, com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public SpaceAttachmentOpenEntity(Parcel r1) {
        super(r1);
    }

    @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseSpaceOpenEntity
    public void readFromParcel(Parcel r1) {
        super.readFromParcel(r1);
    }

    @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseSpaceOpenEntity, com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity, android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        super.writeToParcel(r1, r2);
    }

    public SpaceAttachmentOpenEntity(String r1, String r2, String r3) {
        super(r1, r2, r3);
        setBizType(4);
    }
}
