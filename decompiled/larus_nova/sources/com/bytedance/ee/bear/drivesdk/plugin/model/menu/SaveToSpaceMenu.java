package com.bytedance.ee.bear.drivesdk.plugin.model.menu;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction;
import com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BinderSaveToSpaceCallback;
import com.larus.nova.R;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import gj5.b;
import sbb.e;

/* JADX INFO: loaded from: classes16.dex */
public class SaveToSpaceMenu extends BaseMoreMenuAction {
    public static final Parcelable.Creator<SaveToSpaceMenu> CREATOR = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f226007n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final BinderSaveToSpaceCallback f226008o;

    public class a implements Parcelable.Creator<SaveToSpaceMenu> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SaveToSpaceMenu createFromParcel(Parcel r100) {
            return new SaveToSpaceMenu(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final SaveToSpaceMenu[] newArray(int r100) {
            return new SaveToSpaceMenu[r100];
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
        if (this.f217010g != null) goto L5;
        return true;
    L5:
        return ((b) org.koin.java.a.a(b.class)).g("CCM_FILE_UPLOAD", FileBizDomain.FileBizDomainCCM, e.f541301l.f541317b, this.f217010g.getFileId()).f481503a;
    }

    public SaveToSpaceMenu() {
        super(R.string.Drive_Drive_SaveToSpace);
    }

    @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction
    public final void a() {
        if (d() == false) goto L8;
        ((com.bytedance.ee.bear.drivesdk.plugin.model.menu.a) org.koin.java.a.a(com.bytedance.ee.bear.drivesdk.plugin.model.menu.a.class)).a(this.f217010g, "save_to_drive", "none");
        BinderSaveToSpaceCallback r100 = this.f226008o;
        if (r100 == null) goto L9;
        r100.onClick(this.f226007n);
        return;
    L9:
        return;
    }

    public SaveToSpaceMenu(Parcel r100) {
        super(r100);
        if (r100.readByte() == 0) goto L5;
        boolean r101 = true;
    L6:
        this.f226007n = r101;
        this.f226008o = BinderSaveToSpaceCallback.Stub.asInterface(r100.readStrongBinder());     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        tt5.a.e("DriveSdk#AbsMoreMenuAction", "SaveToSpaceMenu#writeToParcel() error=", th, false);
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction, android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
        r100.writeByte(this.f226007n ? 1 : 0);
        BinderSaveToSpaceCallback r102 = this.f226008o;     // Catch: Throwable -> L9
        if (r102 != null) goto L6;
        IBinder r103 = null;
    L7:
        r100.writeStrongBinder(r103);     // Catch: Throwable -> L9
        return;
    L6:
        r103 = r102.asBinder();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        tt5.a.e("DriveSdk#AbsMoreMenuAction", "SaveToSpaceMenu#writeToParcel() error=", th, false);
    }
}
