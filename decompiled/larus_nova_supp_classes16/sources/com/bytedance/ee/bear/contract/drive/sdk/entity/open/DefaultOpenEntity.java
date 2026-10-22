package com.bytedance.ee.bear.contract.drive.sdk.entity.open;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.bear.document.comment.bean.ShowCardsJsData;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DefaultOpenEntity extends BaseOpenEntity {
    public static final Parcelable.Creator<DefaultOpenEntity> CREATOR = null;

    public class a implements Parcelable.Creator<DefaultOpenEntity> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final DefaultOpenEntity createFromParcel(Parcel r2) {
            return new DefaultOpenEntity(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final DefaultOpenEntity[] newArray(int r1) {
            return new DefaultOpenEntity[r1];
        }
    }

    @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void readFromParcel(Parcel r1) {
    }

    static {
        CREATOR = new a();
    }

    public DefaultOpenEntity() {
        super(ShowCardsJsData.ID_GLOBAL, "", "", "", null);
    }

    public DefaultOpenEntity(Parcel r1) {
        super(r1);
    }

    @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity, android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        super.writeToParcel(r1, r2);
    }
}
