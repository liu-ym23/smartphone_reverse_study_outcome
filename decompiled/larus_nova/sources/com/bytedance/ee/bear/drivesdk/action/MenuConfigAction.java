package com.bytedance.ee.bear.drivesdk.action;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction;
import com.bytedance.ee.bear.contract.drive.sdk.preview.PreviewAction;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes16.dex */
public class MenuConfigAction implements PreviewAction {
    public static final Parcelable.Creator<MenuConfigAction> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<BaseMoreMenuAction> f225986a;

    public class a implements Parcelable.Creator<MenuConfigAction> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final MenuConfigAction createFromParcel(Parcel r100) {
            return new MenuConfigAction(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final MenuConfigAction[] newArray(int r100) {
            return new MenuConfigAction[r100];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public MenuConfigAction(Parcel r100) {
        this.f225986a = r100.createTypedArrayList(BaseMoreMenuAction.CREATOR);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeTypedList(this.f225986a);
    }
}
