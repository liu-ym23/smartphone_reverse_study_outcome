package com.bytedance.ee.bear.drive.business.preview.attachment.menuaction;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes16.dex */
public class AttachmentBaseMenuAction implements Parcelable {
    public static final Parcelable.Creator<AttachmentBaseMenuAction> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bundle f224039a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BinderAttachmentMenuAction f224040b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f224041c;

    public class a implements Parcelable.Creator<AttachmentBaseMenuAction> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final AttachmentBaseMenuAction createFromParcel(Parcel r100) {
            return new AttachmentBaseMenuAction(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final AttachmentBaseMenuAction[] newArray(int r100) {
            return new AttachmentBaseMenuAction[r100];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public AttachmentBaseMenuAction() {
    }

    public AttachmentBaseMenuAction(Parcel r100) {
        this.f224040b = BinderAttachmentMenuAction.Stub.asInterface(r100.readStrongBinder());     // Catch: Throwable -> L5
        this.f224039a = r100.readBundle(AttachmentBaseMenuAction.class.getClassLoader());     // Catch: Throwable -> L5
        this.f224041c = r100.readInt();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        tt5.a.e("AttachmentBaseMenuAction", "AttachmentBaseMenuAction#writeToAbsMoreMenuAction(Parcel) error=", th, false);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        BinderAttachmentMenuAction r102 = this.f224040b;     // Catch: Throwable -> L8
        if (r102 != null) goto L5;
        IBinder r103 = null;
    L6:
        r100.writeStrongBinder(r103);     // Catch: Throwable -> L8
        r100.writeBundle(this.f224039a);     // Catch: Throwable -> L8
        r100.writeInt(this.f224041c);     // Catch: Throwable -> L8
        return;
    L5:
        r103 = r102.asBinder();     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        tt5.a.e("AttachmentBaseMenuAction", "AttachmentBaseMenuAction#writeToParcel() error=", th, false);
    }
}
