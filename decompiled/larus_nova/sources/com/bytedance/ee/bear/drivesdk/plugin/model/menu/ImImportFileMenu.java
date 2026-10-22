package com.bytedance.ee.bear.drivesdk.plugin.model.menu;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction;

/* JADX INFO: loaded from: classes16.dex */
public class ImImportFileMenu extends BaseMoreMenuAction {
    public static final Parcelable.Creator<ImImportFileMenu> CREATOR = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f226001n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f226002o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final long f226003p;

    public class a implements Parcelable.Creator<ImImportFileMenu> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ImImportFileMenu createFromParcel(Parcel r100) {
            return new ImImportFileMenu(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final ImImportFileMenu[] newArray(int r100) {
            return new ImImportFileMenu[r100];
        }
    }

    @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public ImImportFileMenu(Parcel r100) {
        super(r100);
        this.f226001n = r100.readString();
        this.f226003p = r100.readLong();
        this.f226002o = r100.readString();
    }

    @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction, android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
        r100.writeString(this.f226001n);
        r100.writeLong(this.f226003p);
        r100.writeString(this.f226002o);
    }
}
