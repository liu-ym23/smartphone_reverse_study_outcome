package com.bytedance.ee.bear.drivesdk.plugin.model.menu;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import cj5.b;
import com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.LocalOpenEntity;
import com.bytedance.ee.bear.f;
import com.bytedance.ee.bear.middleground_permission_export.model.c;
import com.ss.lark.android.encryption.CipherManager;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class OpenExternalMenu extends DownloadMenu {
    public static final Parcelable.Creator<OpenExternalMenu> CREATOR = null;

    public class a implements Parcelable.Creator<OpenExternalMenu> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final OpenExternalMenu createFromParcel(Parcel r2) {
            return new OpenExternalMenu(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final OpenExternalMenu[] newArray(int r1) {
            return new OpenExternalMenu[r1];
        }
    }

    @Override // com.bytedance.ee.bear.drivesdk.plugin.model.menu.DownloadMenu, com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction
    public final int b() {
        return 2131887246;
    }

    @Override // com.bytedance.ee.bear.drivesdk.plugin.model.menu.DownloadMenu, com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    @Override // com.bytedance.ee.bear.drivesdk.plugin.model.menu.DownloadMenu, com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction
    public final void a() {
        BaseOpenEntity r0 = this.g;
        if (r0 == null) goto L16;
        if ((r0 instanceof LocalOpenEntity) == true) goto L12;
        c r1 = (c) org.koin.java.a.a(c.class);
        String r2 = this.g.getAppId();
        String r3 = this.g.getFileId();
        Boolean r4 = Boolean.FALSE;
        boolean r6 = true;
        if (CipherManager.d() != 1) goto L10;
        r6 = false;
    L10:
        r1.g(r2, r3, r4, Boolean.valueOf(r6));
        ((zk5.a) org.koin.java.a.a(zk5.a.class)).a(e.l.b, this.g.getFileId(), "open_with_other_app");
    L14:
        ((f) org.koin.java.a.a(f.class)).a(this.g);
        ((com.bytedance.ee.bear.drivesdk.plugin.model.menu.a) org.koin.java.a.a(com.bytedance.ee.bear.drivesdk.plugin.model.menu.a.class)).a(this.g, "open_in_other_apps", "none");
        goto L16
    L12:
        if (TextUtils.isEmpty(r0.getFileId()) == true) goto L14;
        ((c) org.koin.java.a.a(c.class)).k(this.g.getAppId(), this.g.getFileId(), Boolean.TRUE, ((LocalOpenEntity) this.g).getThirdPartyAppID());
        ((zk5.a) org.koin.java.a.a(zk5.a.class)).a(e.l.b, this.g.getFileId(), "open_with_other_app");
    L16:
        if (d() == false) goto L18;
        return;
    L18:
        tt5.a.d("DriveSdk#AbsMoreMenuAction", "OpenExternalMenu#execute() no default action now, ignore it");
    }

    @Override // com.bytedance.ee.bear.drivesdk.plugin.model.menu.DownloadMenu, com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction
    public final boolean e() {
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
        return super.e();
    }

    public OpenExternalMenu(String r2) {
        super(2131888429);
        this.a = null;
        this.m = r2;
    }

    public OpenExternalMenu(Parcel r1) {
        super(r1);
    }

    @Override // com.bytedance.ee.bear.drivesdk.plugin.model.menu.DownloadMenu, com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction, android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        super.writeToParcel(r1, r2);
    }
}
