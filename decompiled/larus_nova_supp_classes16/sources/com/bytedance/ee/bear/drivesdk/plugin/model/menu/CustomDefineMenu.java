package com.bytedance.ee.bear.drivesdk.plugin.model.menu;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class CustomDefineMenu extends BaseMoreMenuAction {
    public static final Parcelable.Creator<CustomDefineMenu> CREATOR = null;
    public final String n;

    public class a implements Parcelable.Creator<CustomDefineMenu> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final CustomDefineMenu createFromParcel(Parcel r2) {
            return new CustomDefineMenu(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final CustomDefineMenu[] newArray(int r1) {
            return new CustomDefineMenu[r1];
        }
    }

    @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction
    public final void a() {
        super.a();
        d();
        ((com.bytedance.ee.bear.drivesdk.plugin.model.menu.a) org.koin.java.a.a(com.bytedance.ee.bear.drivesdk.plugin.model.menu.a.class)).a(this.g, this.n, "none");
    }

    public CustomDefineMenu(Parcel r1) {
        super(r1);
        this.n = r1.readString();
    }

    @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction, android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        super.writeToParcel(r1, r2);
        r1.writeString(this.n);
    }
}
