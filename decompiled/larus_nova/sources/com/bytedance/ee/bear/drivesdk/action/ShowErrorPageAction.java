package com.bytedance.ee.bear.drivesdk.action;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.bear.contract.drive.sdk.preview.PreviewAction;

/* JADX INFO: loaded from: classes16.dex */
public class ShowErrorPageAction implements PreviewAction {
    public static final Parcelable.Creator<ShowErrorPageAction> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f225988a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f225989b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f225990c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f225991d;

    public class a implements Parcelable.Creator<ShowErrorPageAction> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ShowErrorPageAction createFromParcel(Parcel r100) {
            return new ShowErrorPageAction(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final ShowErrorPageAction[] newArray(int r100) {
            return new ShowErrorPageAction[r100];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public ShowErrorPageAction() {
        this.f225988a = "";
        this.f225989b = 0;
    }

    public ShowErrorPageAction(Parcel r100) {
        this.f225988a = r100.readString();
        this.f225989b = r100.readInt();
        boolean r101 = true;
        if (r100.readByte() == 0) goto L5;
        boolean r102 = true;
    L6:
        this.f225990c = r102;
        if (r100.readByte() != 0) goto L10;
        r101 = false;
    L10:
        this.f225991d = r101;
        return;
    L5:
        r102 = false;
        goto L6
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f225988a);
        r100.writeInt(this.f225989b);
        r100.writeByte(this.f225990c ? 1 : 0);
        r100.writeByte(this.f225991d ? 1 : 0);
    }
}
