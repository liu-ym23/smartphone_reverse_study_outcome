package com.bytedance.ee.bear.document.security;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.bear.contract.drive.sdk.preview.PreviewAction;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DlpUploadAction implements PreviewAction {
    public static final Parcelable.Creator<DlpUploadAction> CREATOR = null;
    public final String a;
    public final boolean b;
    public final String c;

    public class a implements Parcelable.Creator<DlpUploadAction> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final DlpUploadAction createFromParcel(Parcel r2) {
            return new DlpUploadAction(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final DlpUploadAction[] newArray(int r1) {
            return new DlpUploadAction[r1];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public DlpUploadAction(Parcel r2) {
        this.a = r2.readString();
        if (r2.readByte() == 0) goto L5;
        boolean r0 = true;
    L6:
        this.b = r0;
        this.c = r2.readString();
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        r1.writeString(this.a);
        r1.writeByte(this.b ? 1 : 0);
        r1.writeString(this.c);
    }

    public DlpUploadAction(String r1, boolean r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
