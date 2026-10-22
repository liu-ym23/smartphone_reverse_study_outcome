package com.bytedance.ee.bear.drivesdk.plugin.model.menu;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction;

/* JADX INFO: loaded from: classes16.dex */
public class CustomDefineMenu extends BaseMoreMenuAction {
    public static final Parcelable.Creator<CustomDefineMenu> CREATOR = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f225996n;

    public class a implements Parcelable.Creator<CustomDefineMenu> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final CustomDefineMenu createFromParcel(Parcel r100) {
            return new CustomDefineMenu(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final CustomDefineMenu[] newArray(int r100) {
            return new CustomDefineMenu[r100];
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
        ((com.bytedance.ee.bear.drivesdk.plugin.model.menu.a) org.koin.java.a.a(com.bytedance.ee.bear.drivesdk.plugin.model.menu.a.class)).a(this.f217010g, this.f225996n, "none");
    }

    public CustomDefineMenu(Parcel r100) {
        super(r100);
        this.f225996n = r100.readString();
    }

    @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction, android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
        r100.writeString(this.f225996n);
    }
}
