package com.bytedance.ee.bear.drivesdk.plugin.model.menu;

import android.os.Parcel;
import android.os.Parcelable;
import cj5.b;
import com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction;
import jg5.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class SaveToLocalMenuV2 extends BaseMoreMenuAction {
    public static final Parcelable.Creator<SaveToLocalMenuV2> CREATOR = null;

    public class a implements Parcelable.Creator<SaveToLocalMenuV2> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SaveToLocalMenuV2 createFromParcel(Parcel r2) {
            return new SaveToLocalMenuV2(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final SaveToLocalMenuV2[] newArray(int r1) {
            return new SaveToLocalMenuV2[r1];
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
        if (this.g == null) goto L10;
        ((b) org.koin.java.a.a(b.class)).getConfig();
        if (e.a.a.g() == false) goto L9;
        return BaseMoreMenuAction.c(this.g);
    L9:
        return ((gj5.b) org.koin.java.a.a(gj5.b.class)).g(pw4.b.c(this.g.getMountPoint()), pw4.b.d(this.g.getMountPoint()), pw4.b.f(this.g.getMountPoint()), this.g.getFileId()).a;
    L10:
        return true;
    }

    public SaveToLocalMenuV2() {
        super(2131887287);
    }

    public SaveToLocalMenuV2(Parcel r1) {
        super(r1);
    }

    @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction, android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        super.writeToParcel(r1, r2);
    }
}
