package com.bytedance.ee.bear.contract.drive.sdk.entity.menu;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.drivesdk.plugin.model.menu.AttachmentInfo;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BaseEntity;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionRequest;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class BaseMoreMenuAction implements Parcelable {
    public static final Parcelable.Creator<BaseMoreMenuAction> CREATOR = null;
    public BinderMenuAction a;
    public final BinderDriveMenuAction b;
    public int c;
    public final int d;
    public Bundle e;
    public Bundle f;
    public BaseOpenEntity g;
    public final String h;
    public boolean i;
    public int j;
    public boolean k;
    public boolean l;
    public String m;

    public class a implements Parcelable.Creator<BaseMoreMenuAction> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final BaseMoreMenuAction createFromParcel(Parcel r2) {
            return new BaseMoreMenuAction(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final BaseMoreMenuAction[] newArray(int r1) {
            return new BaseMoreMenuAction[r1];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public void a() {
        tt5.a.h("DriveSdk#AbsMoreMenuAction", "execute() ");
    }

    public final boolean d() {
        if (this.a != null) goto L18;
        return false;
    L18:
        AttachmentInfo r1 = new AttachmentInfo();     // Catch: Throwable -> L8
        BaseOpenEntity r3 = this.g;     // Catch: Throwable -> L8
        if (r3 == null) goto L11;
        r1.a = r3.getFileId();     // Catch: Throwable -> L8
        r1.b = this.g.getFileName();     // Catch: Throwable -> L8
        r1.c = com.bytedance.ee.util.io.a.c(this.g.getFileName());     // Catch: Throwable -> L8
        r1.d = this.g.getLocalPath();     // Catch: Throwable -> L8
    L11:
        if (this.e != null) goto L13;
        this.e = new Bundle();     // Catch: Throwable -> L8
    L13:
        this.e.putParcelable("attachmentInfo", r1);     // Catch: Throwable -> L8
        this.a.action(this.e);     // Catch: Throwable -> L8
        tt5.a.h("DriveSdk#AbsMoreMenuAction", "handleProxyAction() exec proxy action done.");     // Catch: Throwable -> L8
        return true;
    L8:
        th = move-exception;
        tt5.a.e("DriveSdk#AbsMoreMenuAction", "executeProxy() error=", th, false);
        return true;
    }

    public int b() {
        return this.j;
    }

    public boolean e() {
        return this.i;
    }

    public BaseMoreMenuAction(Parcel r4) {
        this.h = "";
        boolean r1 = true;
        this.i = true;
        this.j = -1;
        this.k = true;
        this.l = true;
        this.m = "";
        this.a = BinderMenuAction.Stub.asInterface(r4.readStrongBinder());     // Catch: Throwable -> L17
        this.b = BinderDriveMenuAction.Stub.asInterface(r4.readStrongBinder());     // Catch: Throwable -> L17
        this.c = r4.readInt();     // Catch: Throwable -> L17
        this.e = r4.readBundle();     // Catch: Throwable -> L17
        this.f = r4.readBundle();     // Catch: Throwable -> L17
        this.h = r4.readString();     // Catch: Throwable -> L17
        if (r4.readInt() != 1) goto L6;
        boolean r2 = true;
    L7:
        this.i = r2;     // Catch: Throwable -> L17
        this.j = r4.readInt();     // Catch: Throwable -> L17
        if (r4.readByte() == 0) goto L10;
        boolean r3 = true;
    L11:
        this.k = r3;     // Catch: Throwable -> L17
        if (r4.readByte() != 0) goto L15;
        r1 = false;
    L15:
        this.l = r1;     // Catch: Throwable -> L17
        this.m = r4.readString();     // Catch: Throwable -> L17
        this.d = r4.readInt();     // Catch: Throwable -> L17
        return;
    L10:
        r3 = false;
        goto L11
    L6:
        r2 = false;
    L17:
        th = move-exception;
        tt5.a.e("DriveSdk#AbsMoreMenuAction", "AbsMoreMenuAction#writeToAbsMoreMenuAction(Parcel) error=", th, false);
    }

    public static boolean c(BaseOpenEntity r4) {
        BaseEntity r0 = new BaseEntity(r4.getFileId(), pw4.b.e(r4.getMountPoint()), pw4.b.a(r4.getMountPoint()), "");
        PermissionResponse r5 = ((ph5.b) org.koin.java.a.a(ph5.b.class)).f(new PermissionRequest(r0, "DOWNLOAD"), null);
        return ((ph5.c) org.koin.java.a.a(ph5.c.class)).e(r5);
    }

    public BaseMoreMenuAction(int r4) {
        this.h = "";
        this.i = true;
        this.j = -1;
        this.k = true;
        this.l = true;
        this.m = "";
        this.c = r4;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        BinderMenuAction r0 = this.a;     // Catch: Throwable -> L25
        IBinder r1 = null;
        if (r0 != null) goto L6;
        IBinder r2 = null;
    L7:
        r3.writeStrongBinder(r2);     // Catch: Throwable -> L25
        BinderDriveMenuAction r5 = this.b;     // Catch: Throwable -> L25
        if (r5 == null) goto L11;
        r1 = r5.asBinder();     // Catch: Throwable -> L25
    L11:
        r3.writeStrongBinder(r1);     // Catch: Throwable -> L25
        r3.writeInt(this.c);     // Catch: Throwable -> L25
        r3.writeBundle(this.e);     // Catch: Throwable -> L25
        r3.writeBundle(this.f);     // Catch: Throwable -> L25
        r3.writeString(this.h);     // Catch: Throwable -> L25
        byte r6 = 1;
        if (this.i == false) goto L14;
        int r7 = 1;
    L15:
        r3.writeInt(r7);     // Catch: Throwable -> L25
        r3.writeInt(this.j);     // Catch: Throwable -> L25
        if (this.k == false) goto L18;
        byte r8 = 1;
    L19:
        r3.writeByte(r8);     // Catch: Throwable -> L25
        if (this.l == true) goto L23;
        r6 = 0;
    L23:
        r3.writeByte(r6);     // Catch: Throwable -> L25
        r3.writeString(this.m);     // Catch: Throwable -> L25
        r3.writeInt(this.d);     // Catch: Throwable -> L25
        return;
    L18:
        r8 = 0;
        goto L19
    L14:
        r7 = 0;
        goto L15
    L6:
        r2 = r0.asBinder();     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        tt5.a.e("DriveSdk#AbsMoreMenuAction", "AbsMoreMenuAction#writeToParcel() error=", th, false);
    }
}
