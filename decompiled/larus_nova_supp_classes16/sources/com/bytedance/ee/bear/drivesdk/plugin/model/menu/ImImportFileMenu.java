package com.bytedance.ee.bear.drivesdk.plugin.model.menu;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class ImImportFileMenu extends BaseMoreMenuAction {
    public static final Parcelable.Creator<ImImportFileMenu> CREATOR = null;
    public final String n;
    public final String o;
    public final long p;

    public class a implements Parcelable.Creator<ImImportFileMenu> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ImImportFileMenu createFromParcel(Parcel r2) {
            return new ImImportFileMenu(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final ImImportFileMenu[] newArray(int r1) {
            return new ImImportFileMenu[r1];
        }
    }

    @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public ImImportFileMenu(Parcel r3) {
        super(r3);
        this.n = r3.readString();
        this.p = r3.readLong();
        this.o = r3.readString();
    }

    @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction, android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        super.writeToParcel(r3, r4);
        r3.writeString(this.n);
        r3.writeLong(this.p);
        r3.writeString(this.o);
    }
}
