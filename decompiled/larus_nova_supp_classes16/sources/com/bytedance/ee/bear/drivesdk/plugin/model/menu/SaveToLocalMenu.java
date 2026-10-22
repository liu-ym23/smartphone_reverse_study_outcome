package com.bytedance.ee.bear.drivesdk.plugin.model.menu;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import cj5.b;
import com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction;
import com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BinderSaveCallback;
import jg5.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class SaveToLocalMenu extends BaseMoreMenuAction {
    public static final Parcelable.Creator<SaveToLocalMenu> CREATOR = null;
    public final String n;
    public boolean o;
    public BinderSaveCallback p;

    public class a implements Parcelable.Creator<SaveToLocalMenu> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SaveToLocalMenu createFromParcel(Parcel r2) {
            return new SaveToLocalMenu(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final SaveToLocalMenu[] newArray(int r1) {
            return new SaveToLocalMenu[r1];
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

    @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction
    public final void a() {
        super.a();
        if (d() == false) goto L6;
        tt5.a.d("SaveToLocalMenu", "SaveToLocalMenu#execute() execute proxy action done");
        return;
    }

    public SaveToLocalMenu(Parcel r2) {
        super(r2);
        this.n = r2.readString();
        if (r2.readByte() == 0) goto L5;
        boolean r0 = true;
    L6:
        this.o = r0;
        this.p = BinderSaveCallback.Stub.asInterface(r2.readStrongBinder());
        return;
    L5:
        r0 = false;
        goto L6
    }

    public SaveToLocalMenu(int r1) {
        super(r1);
    }

    @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction, android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        super.writeToParcel(r1, r2);
        r1.writeString(this.n);
        r1.writeByte(this.o ? 1 : 0);
        BinderSaveCallback r3 = this.p;
        if (r3 != null) goto L5;
        IBinder r4 = null;
    L6:
        r1.writeStrongBinder(r4);
        return;
    L5:
        r4 = r3.asBinder();
        goto L6
    }
}
