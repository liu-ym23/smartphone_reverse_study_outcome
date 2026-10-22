package com.bytedance.ee.bear.drive.business.preview.attachment.menuaction;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class AttachmentBaseMenuAction implements Parcelable {
    public static final Parcelable.Creator<AttachmentBaseMenuAction> CREATOR = null;
    public final Bundle a;
    public final BinderAttachmentMenuAction b;
    public final int c;

    public class a implements Parcelable.Creator<AttachmentBaseMenuAction> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final AttachmentBaseMenuAction createFromParcel(Parcel r2) {
            return new AttachmentBaseMenuAction(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final AttachmentBaseMenuAction[] newArray(int r1) {
            return new AttachmentBaseMenuAction[r1];
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

    public AttachmentBaseMenuAction(Parcel r4) {
        this.b = BinderAttachmentMenuAction.Stub.asInterface(r4.readStrongBinder());     // Catch: Throwable -> L5
        this.a = r4.readBundle(AttachmentBaseMenuAction.class.getClassLoader());     // Catch: Throwable -> L5
        this.c = r4.readInt();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        tt5.a.e("AttachmentBaseMenuAction", "AttachmentBaseMenuAction#writeToAbsMoreMenuAction(Parcel) error=", th, false);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        BinderAttachmentMenuAction r5 = this.b;     // Catch: Throwable -> L8
        if (r5 != null) goto L5;
        IBinder r6 = null;
    L6:
        r3.writeStrongBinder(r6);     // Catch: Throwable -> L8
        r3.writeBundle(this.a);     // Catch: Throwable -> L8
        r3.writeInt(this.c);     // Catch: Throwable -> L8
        return;
    L5:
        r6 = r5.asBinder();     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        tt5.a.e("AttachmentBaseMenuAction", "AttachmentBaseMenuAction#writeToParcel() error=", th, false);
    }
}
