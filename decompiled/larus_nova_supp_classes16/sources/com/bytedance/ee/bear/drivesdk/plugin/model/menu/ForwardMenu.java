package com.bytedance.ee.bear.drivesdk.plugin.model.menu;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction;
import com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BinderMenuAction;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class ForwardMenu extends BaseMoreMenuAction {
    public static final Parcelable.Creator<ForwardMenu> CREATOR = null;

    public class a implements Parcelable.Creator<ForwardMenu> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ForwardMenu createFromParcel(Parcel r2) {
            return new ForwardMenu(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final ForwardMenu[] newArray(int r1) {
            return new ForwardMenu[r1];
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
        ((com.bytedance.ee.bear.drivesdk.plugin.model.menu.a) org.koin.java.a.a(com.bytedance.ee.bear.drivesdk.plugin.model.menu.a.class)).a(this.g, "send_to_chat", "public_multi_select_share_view");
    }

    public ForwardMenu(Parcel r1) {
        super(r1);
    }

    public ForwardMenu(int r1, BinderMenuAction r2) {
        super(r1);
        this.a = r2;
    }

    @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction, android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        super.writeToParcel(r1, r2);
    }
}
