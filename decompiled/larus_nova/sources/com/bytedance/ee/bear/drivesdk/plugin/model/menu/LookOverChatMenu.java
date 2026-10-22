package com.bytedance.ee.bear.drivesdk.plugin.model.menu;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction;

/* JADX INFO: loaded from: classes16.dex */
public class LookOverChatMenu extends BaseMoreMenuAction {
    public static final Parcelable.Creator<LookOverChatMenu> CREATOR = null;

    public class a implements Parcelable.Creator<LookOverChatMenu> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final LookOverChatMenu createFromParcel(Parcel r100) {
            return new LookOverChatMenu(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final LookOverChatMenu[] newArray(int r100) {
            return new LookOverChatMenu[r100];
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
    }

    public LookOverChatMenu(Parcel r100) {
        super(r100);
    }

    @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction, android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
    }
}
