package com.bytedance.ee.bear.drivesdk.action;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction;
import com.bytedance.ee.bear.contract.drive.sdk.preview.PreviewAction;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class MenuConfigAction implements PreviewAction {
    public static final Parcelable.Creator<MenuConfigAction> CREATOR = null;
    public final ArrayList<BaseMoreMenuAction> a;

    public class a implements Parcelable.Creator<MenuConfigAction> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final MenuConfigAction createFromParcel(Parcel r2) {
            return new MenuConfigAction(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final MenuConfigAction[] newArray(int r1) {
            return new MenuConfigAction[r1];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public MenuConfigAction(Parcel r2) {
        this.a = r2.createTypedArrayList(BaseMoreMenuAction.CREATOR);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        r1.writeTypedList(this.a);
    }
}
