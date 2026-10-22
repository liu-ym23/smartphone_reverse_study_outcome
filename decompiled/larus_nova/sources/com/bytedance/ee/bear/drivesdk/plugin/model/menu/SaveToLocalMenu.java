package com.bytedance.ee.bear.drivesdk.plugin.model.menu;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import cj5.b;
import com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction;
import com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BinderSaveCallback;
import jg5.e;

/* JADX INFO: loaded from: classes16.dex */
public class SaveToLocalMenu extends BaseMoreMenuAction {
    public static final Parcelable.Creator<SaveToLocalMenu> CREATOR = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f226004n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f226005o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public BinderSaveCallback f226006p;

    public class a implements Parcelable.Creator<SaveToLocalMenu> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SaveToLocalMenu createFromParcel(Parcel r100) {
            return new SaveToLocalMenu(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final SaveToLocalMenu[] newArray(int r100) {
            return new SaveToLocalMenu[r100];
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

    @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction
    public final void a() {
        super.a();
        if (d() == false) goto L6;
        tt5.a.d("SaveToLocalMenu", "SaveToLocalMenu#execute() execute proxy action done");
        return;
    }

    public SaveToLocalMenu(Parcel r100) {
        super(r100);
        this.f226004n = r100.readString();
        if (r100.readByte() == 0) goto L5;
        boolean r101 = true;
    L6:
        this.f226005o = r101;
        this.f226006p = BinderSaveCallback.Stub.asInterface(r100.readStrongBinder());
        return;
    L5:
        r101 = false;
        goto L6
    }

    public SaveToLocalMenu(int r100) {
        super(r100);
    }

    @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction, android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
        r100.writeString(this.f226004n);
        r100.writeByte(this.f226005o ? 1 : 0);
        BinderSaveCallback r102 = this.f226006p;
        if (r102 != null) goto L5;
        IBinder r103 = null;
    L6:
        r100.writeStrongBinder(r103);
        return;
    L5:
        r103 = r102.asBinder();
        goto L6
    }
}
