package com.bytedance.ee.bear.drivesdk.plugin.model.menu;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction;
import com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BinderSaveToSpaceCallback;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import gj5.b;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class SaveToSpaceMenu extends BaseMoreMenuAction {
    public static final Parcelable.Creator<SaveToSpaceMenu> CREATOR = null;
    public boolean n;
    public final BinderSaveToSpaceCallback o;

    public class a implements Parcelable.Creator<SaveToSpaceMenu> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SaveToSpaceMenu createFromParcel(Parcel r2) {
            return new SaveToSpaceMenu(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final SaveToSpaceMenu[] newArray(int r1) {
            return new SaveToSpaceMenu[r1];
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
        if (this.g != null) goto L5;
        return true;
    L5:
        return ((b) org.koin.java.a.a(b.class)).g("CCM_FILE_UPLOAD", FileBizDomain.FileBizDomainCCM, e.l.b, this.g.getFileId()).a;
    }

    public SaveToSpaceMenu() {
        super(2131888449);
    }

    @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction
    public final void a() {
        if (d() == false) goto L8;
        ((com.bytedance.ee.bear.drivesdk.plugin.model.menu.a) org.koin.java.a.a(com.bytedance.ee.bear.drivesdk.plugin.model.menu.a.class)).a(this.g, "save_to_drive", "none");
        BinderSaveToSpaceCallback r0 = this.o;
        if (r0 == null) goto L9;
        r0.onClick(this.n);
        return;
    L9:
        return;
    }

    public SaveToSpaceMenu(Parcel r4) {
        super(r4);
        if (r4.readByte() == 0) goto L5;
        boolean r0 = true;
    L6:
        this.n = r0;
        this.o = BinderSaveToSpaceCallback.Stub.asInterface(r4.readStrongBinder());     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        tt5.a.e("DriveSdk#AbsMoreMenuAction", "SaveToSpaceMenu#writeToParcel() error=", th, false);
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction, android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        super.writeToParcel(r3, r4);
        r3.writeByte(this.n ? 1 : 0);
        BinderSaveToSpaceCallback r5 = this.o;     // Catch: Throwable -> L9
        if (r5 != null) goto L6;
        IBinder r6 = null;
    L7:
        r3.writeStrongBinder(r6);     // Catch: Throwable -> L9
        return;
    L6:
        r6 = r5.asBinder();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        tt5.a.e("DriveSdk#AbsMoreMenuAction", "SaveToSpaceMenu#writeToParcel() error=", th, false);
    }
}
