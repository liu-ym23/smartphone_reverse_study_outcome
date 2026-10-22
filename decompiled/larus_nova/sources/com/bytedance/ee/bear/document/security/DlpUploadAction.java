package com.bytedance.ee.bear.document.security;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.bear.contract.drive.sdk.preview.PreviewAction;

/* JADX INFO: loaded from: classes16.dex */
public class DlpUploadAction implements PreviewAction {
    public static final Parcelable.Creator<DlpUploadAction> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f221563a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f221564b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f221565c;

    public class a implements Parcelable.Creator<DlpUploadAction> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final DlpUploadAction createFromParcel(Parcel r100) {
            return new DlpUploadAction(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final DlpUploadAction[] newArray(int r100) {
            return new DlpUploadAction[r100];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public DlpUploadAction(Parcel r100) {
        this.f221563a = r100.readString();
        if (r100.readByte() == 0) goto L5;
        boolean r101 = true;
    L6:
        this.f221564b = r101;
        this.f221565c = r100.readString();
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f221563a);
        r100.writeByte(this.f221564b ? 1 : 0);
        r100.writeString(this.f221565c);
    }

    public DlpUploadAction(String r100, boolean r101, String r102) {
        this.f221563a = r100;
        this.f221564b = r101;
        this.f221565c = r102;
    }
}
