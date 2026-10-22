package com.bytedance.ee.bear.drivesdk.plugin.model.menu;

import android.os.Parcel;
import android.os.Parcelable;
import cj5.b;
import com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction;
import com.larus.nova.R;
import jg5.e;

/* JADX INFO: loaded from: classes16.dex */
public class SaveToLocalMenuV2 extends BaseMoreMenuAction {
    public static final Parcelable.Creator<SaveToLocalMenuV2> CREATOR = null;

    public class a implements Parcelable.Creator<SaveToLocalMenuV2> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SaveToLocalMenuV2 createFromParcel(Parcel r100) {
            return new SaveToLocalMenuV2(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final SaveToLocalMenuV2[] newArray(int r100) {
            return new SaveToLocalMenuV2[r100];
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
    public final boolean e() {
        if (this.f217010g == null) goto L10;
        ((b) org.koin.java.a.a(b.class)).getConfig();
        if (e.a.f499003a.g() == false) goto L9;
        return BaseMoreMenuAction.c(this.f217010g);
    L9:
        return ((gj5.b) org.koin.java.a.a(gj5.b.class)).g(pw4.b.c(this.f217010g.getMountPoint()), pw4.b.d(this.f217010g.getMountPoint()), pw4.b.f(this.f217010g.getMountPoint()), this.f217010g.getFileId()).f481503a;
    L10:
        return true;
    }

    public SaveToLocalMenuV2() {
        super(R.string.CreationMobile_ECM_SaveToLocal_option);
    }

    public SaveToLocalMenuV2(Parcel r100) {
        super(r100);
    }

    @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction, android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
    }
}
