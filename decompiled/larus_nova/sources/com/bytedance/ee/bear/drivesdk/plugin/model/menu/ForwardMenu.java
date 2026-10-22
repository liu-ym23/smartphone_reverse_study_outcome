package com.bytedance.ee.bear.drivesdk.plugin.model.menu;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction;
import com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BinderMenuAction;

/* JADX INFO: loaded from: classes16.dex */
public class ForwardMenu extends BaseMoreMenuAction {
    public static final Parcelable.Creator<ForwardMenu> CREATOR = null;

    public class a implements Parcelable.Creator<ForwardMenu> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ForwardMenu createFromParcel(Parcel r100) {
            return new ForwardMenu(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final ForwardMenu[] newArray(int r100) {
            return new ForwardMenu[r100];
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
        ((com.bytedance.ee.bear.drivesdk.plugin.model.menu.a) org.koin.java.a.a(com.bytedance.ee.bear.drivesdk.plugin.model.menu.a.class)).a(this.f217010g, "send_to_chat", "public_multi_select_share_view");
    }

    public ForwardMenu(Parcel r100) {
        super(r100);
    }

    public ForwardMenu(int r100, BinderMenuAction r101) {
        super(r100);
        this.f217004a = r101;
    }

    @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction, android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
    }
}
