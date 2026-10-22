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
import com.ss.android.download.api.config.HttpMethod;

/* JADX INFO: loaded from: classes16.dex */
public class BaseMoreMenuAction implements Parcelable {
    public static final Parcelable.Creator<BaseMoreMenuAction> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BinderMenuAction f217004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BinderDriveMenuAction f217005b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f217006c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f217007d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Bundle f217008e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Bundle f217009f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public BaseOpenEntity f217010g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f217011h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f217012i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f217013j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f217014k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f217015l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f217016m;

    public class a implements Parcelable.Creator<BaseMoreMenuAction> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final BaseMoreMenuAction createFromParcel(Parcel r100) {
            return new BaseMoreMenuAction(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final BaseMoreMenuAction[] newArray(int r100) {
            return new BaseMoreMenuAction[r100];
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
        if (this.f217004a != null) goto L18;
        return false;
    L18:
        AttachmentInfo r100 = new AttachmentInfo();     // Catch: Throwable -> L8
        BaseOpenEntity r101 = this.f217010g;     // Catch: Throwable -> L8
        if (r101 == null) goto L11;
        r100.f225992a = r101.getFileId();     // Catch: Throwable -> L8
        r100.f225993b = this.f217010g.getFileName();     // Catch: Throwable -> L8
        r100.f225994c = com.bytedance.ee.util.io.a.c(this.f217010g.getFileName());     // Catch: Throwable -> L8
        r100.f225995d = this.f217010g.getLocalPath();     // Catch: Throwable -> L8
    L11:
        if (this.f217008e != null) goto L13;
        this.f217008e = new Bundle();     // Catch: Throwable -> L8
    L13:
        this.f217008e.putParcelable("attachmentInfo", r100);     // Catch: Throwable -> L8
        this.f217004a.action(this.f217008e);     // Catch: Throwable -> L8
        tt5.a.h("DriveSdk#AbsMoreMenuAction", "handleProxyAction() exec proxy action done.");     // Catch: Throwable -> L8
        return true;
    L8:
        th = move-exception;
        tt5.a.e("DriveSdk#AbsMoreMenuAction", "executeProxy() error=", th, false);
        return true;
    }

    public int b() {
        return this.f217013j;
    }

    public boolean e() {
        return this.f217012i;
    }

    public BaseMoreMenuAction(Parcel r100) {
        this.f217011h = "";
        boolean r101 = true;
        this.f217012i = true;
        this.f217013j = -1;
        this.f217014k = true;
        this.f217015l = true;
        this.f217016m = "";
        this.f217004a = BinderMenuAction.Stub.asInterface(r100.readStrongBinder());     // Catch: Throwable -> L17
        this.f217005b = BinderDriveMenuAction.Stub.asInterface(r100.readStrongBinder());     // Catch: Throwable -> L17
        this.f217006c = r100.readInt();     // Catch: Throwable -> L17
        this.f217008e = r100.readBundle();     // Catch: Throwable -> L17
        this.f217009f = r100.readBundle();     // Catch: Throwable -> L17
        this.f217011h = r100.readString();     // Catch: Throwable -> L17
        if (r100.readInt() != 1) goto L6;
        boolean r102 = true;
    L7:
        this.f217012i = r102;     // Catch: Throwable -> L17
        this.f217013j = r100.readInt();     // Catch: Throwable -> L17
        if (r100.readByte() == 0) goto L10;
        boolean r103 = true;
    L11:
        this.f217014k = r103;     // Catch: Throwable -> L17
        if (r100.readByte() != 0) goto L15;
        r101 = false;
    L15:
        this.f217015l = r101;     // Catch: Throwable -> L17
        this.f217016m = r100.readString();     // Catch: Throwable -> L17
        this.f217007d = r100.readInt();     // Catch: Throwable -> L17
        return;
    L10:
        r103 = false;
        goto L11
    L6:
        r102 = false;
    L17:
        th = move-exception;
        tt5.a.e("DriveSdk#AbsMoreMenuAction", "AbsMoreMenuAction#writeToAbsMoreMenuAction(Parcel) error=", th, false);
    }

    public static boolean c(BaseOpenEntity r100) {
        BaseEntity r101 = new BaseEntity(r100.getFileId(), pw4.b.e(r100.getMountPoint()), pw4.b.a(r100.getMountPoint()), "");
        PermissionResponse r102 = ((ph5.b) org.koin.java.a.a(ph5.b.class)).f(new PermissionRequest(r101, HttpMethod.DOWNLOAD), null);
        return ((ph5.c) org.koin.java.a.a(ph5.c.class)).e(r102);
    }

    public BaseMoreMenuAction(int r100) {
        this.f217011h = "";
        this.f217012i = true;
        this.f217013j = -1;
        this.f217014k = true;
        this.f217015l = true;
        this.f217016m = "";
        this.f217006c = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        BinderMenuAction r102 = this.f217004a;     // Catch: Throwable -> L25
        IBinder r103 = null;
        if (r102 != null) goto L6;
        IBinder r104 = null;
    L7:
        r100.writeStrongBinder(r104);     // Catch: Throwable -> L25
        BinderDriveMenuAction r105 = this.f217005b;     // Catch: Throwable -> L25
        if (r105 == null) goto L11;
        r103 = r105.asBinder();     // Catch: Throwable -> L25
    L11:
        r100.writeStrongBinder(r103);     // Catch: Throwable -> L25
        r100.writeInt(this.f217006c);     // Catch: Throwable -> L25
        r100.writeBundle(this.f217008e);     // Catch: Throwable -> L25
        r100.writeBundle(this.f217009f);     // Catch: Throwable -> L25
        r100.writeString(this.f217011h);     // Catch: Throwable -> L25
        byte r106 = 1;
        if (this.f217012i == false) goto L14;
        int r107 = 1;
    L15:
        r100.writeInt(r107);     // Catch: Throwable -> L25
        r100.writeInt(this.f217013j);     // Catch: Throwable -> L25
        if (this.f217014k == false) goto L18;
        byte r108 = 1;
    L19:
        r100.writeByte(r108);     // Catch: Throwable -> L25
        if (this.f217015l == true) goto L23;
        r106 = 0;
    L23:
        r100.writeByte(r106);     // Catch: Throwable -> L25
        r100.writeString(this.f217016m);     // Catch: Throwable -> L25
        r100.writeInt(this.f217007d);     // Catch: Throwable -> L25
        return;
    L18:
        r108 = 0;
        goto L19
    L14:
        r107 = 0;
        goto L15
    L6:
        r104 = r102.asBinder();     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        tt5.a.e("DriveSdk#AbsMoreMenuAction", "AbsMoreMenuAction#writeToParcel() error=", th, false);
    }
}
