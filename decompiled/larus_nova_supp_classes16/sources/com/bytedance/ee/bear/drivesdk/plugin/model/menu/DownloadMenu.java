package com.bytedance.ee.bear.drivesdk.plugin.model.menu;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import cj5.b;
import com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction;
import com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BinderProxyDownloadCallBack;
import com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BinderProxyDownloadUpdaterContainer;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.LocalOpenEntity;
import com.bytedance.ee.bear.f;
import com.bytedance.ee.bear.middleground_permission_export.model.c;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DownloadMenu extends BaseMoreMenuAction {
    public static final Parcelable.Creator<DownloadMenu> CREATOR = null;
    public final BinderProxyDownloadCallBack n;
    public final BinderProxyDownloadUpdaterContainer o;

    public class a implements Parcelable.Creator<DownloadMenu> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final DownloadMenu createFromParcel(Parcel r2) {
            return new DownloadMenu(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final DownloadMenu[] newArray(int r1) {
            return new DownloadMenu[r1];
        }
    }

    @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction
    public int b() {
        return 2131887246;
    }

    @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction
    public void a() {
        BaseOpenEntity r0 = this.g;
        if (r0 == null) goto L12;
        if ((r0 instanceof LocalOpenEntity) == true) goto L8;
        ((c) org.koin.java.a.a(c.class)).j(this.g.getAppId(), this.g.getFileId(), Boolean.FALSE);
    L10:
        ((f) org.koin.java.a.a(f.class)).a(this.g);
        ((zk5.a) org.koin.java.a.a(zk5.a.class)).a(e.l.b, this.g.getFileId(), "download");
        ((com.bytedance.ee.bear.drivesdk.plugin.model.menu.a) org.koin.java.a.a(com.bytedance.ee.bear.drivesdk.plugin.model.menu.a.class)).a(this.g, "download", "none");
        goto L12
    L8:
        if (TextUtils.isEmpty(r0.getFileId()) == true) goto L10;
        ((c) org.koin.java.a.a(c.class)).a(this.g.getAppId(), this.g.getFileId(), Boolean.TRUE, ((LocalOpenEntity) this.g).getThirdPartyAppID());
    L12:
        if (d() == false) goto L14;
        return;
    L14:
        tt5.a.d("DriveSdk#AbsMoreMenuAction", "DownloadMenu#execute() no default action now, ignore it");
    }

    @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction
    public boolean e() {
        if (this.g == null) goto L23;
        ((b) org.koin.java.a.a(b.class)).getConfig();
        if (jg5.e.a.a.g() == true) goto L7;
        BaseOpenEntity r0 = this.g;
        if (r0 == null) goto L16;
        Integer r1 = Integer.valueOf(r0.getBizType());
        int r2 = com.bytedance.ee.bear.contract.drive.sdk.entity.open.a.a;
        if (r1 == null) goto L16;
        if (r1.intValue() != 3) goto L16;
        boolean r3 = true;
    L17:
        if (r3 == false) goto L21;
        return ((com.bytedance.ee.bear.middleground_permission_export.model.b) org.koin.java.a.a(com.bytedance.ee.bear.middleground_permission_export.model.b.class)).b(e.l.b, this.g.getFileId());
    L21:
        return g();
    L16:
        r3 = false;
        goto L17
    L7:
        return BaseMoreMenuAction.c(this.g);
    L23:
        return this.i;
    }

    public final boolean g() {
        return ((gj5.b) org.koin.java.a.a(gj5.b.class)).g(pw4.b.c(this.g.getMountPoint()), pw4.b.d(this.g.getMountPoint()), pw4.b.f(this.g.getMountPoint()), this.g.getFileId()).a;
    }

    public DownloadMenu() {
        this(2131888471);
    }

    public DownloadMenu(Parcel r4) {
        super(r4);
        this.n = BinderProxyDownloadCallBack.Stub.asInterface(r4.readStrongBinder());     // Catch: Throwable -> L5
        this.o = BinderProxyDownloadUpdaterContainer.Stub.asInterface(r4.readStrongBinder());     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        tt5.a.e("DriveSdk#AbsMoreMenuAction", "DownloadMenu#DownloadMenu(Parcel) error=", th, false);
    }

    public DownloadMenu(int r1) {
        super(r1);
        this.o = new AnonymousClass1(this);
    }

    @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction, android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        super.writeToParcel(r3, r4);
        BinderProxyDownloadCallBack r5 = this.n;     // Catch: Throwable -> L13
        IBinder r0 = null;
        if (r5 != null) goto L6;
        IBinder r6 = null;
    L7:
        r3.writeStrongBinder(r6);     // Catch: Throwable -> L13
        BinderProxyDownloadUpdaterContainer r7 = this.o;     // Catch: Throwable -> L13
        if (r7 == null) goto L11;
        r0 = r7.asBinder();     // Catch: Throwable -> L13
    L11:
        r3.writeStrongBinder(r0);     // Catch: Throwable -> L13
        return;
    L6:
        r6 = r5.asBinder();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        tt5.a.e("DriveSdk#AbsMoreMenuAction", "DownloadMenu#writeToParcel() error=", th, false);
    }
}
