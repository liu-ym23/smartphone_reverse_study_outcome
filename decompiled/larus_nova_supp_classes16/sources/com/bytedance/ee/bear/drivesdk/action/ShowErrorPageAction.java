package com.bytedance.ee.bear.drivesdk.action;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.bear.contract.drive.sdk.preview.PreviewAction;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class ShowErrorPageAction implements PreviewAction {
    public static final Parcelable.Creator<ShowErrorPageAction> CREATOR = null;
    public final String a;
    public final int b;
    public final boolean c;
    public final boolean d;

    public class a implements Parcelable.Creator<ShowErrorPageAction> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ShowErrorPageAction createFromParcel(Parcel r2) {
            return new ShowErrorPageAction(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final ShowErrorPageAction[] newArray(int r1) {
            return new ShowErrorPageAction[r1];
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
        this.a = "";
        this.b = 0;
    }

    public ShowErrorPageAction(Parcel r4) {
        this.a = r4.readString();
        this.b = r4.readInt();
        boolean r1 = true;
        if (r4.readByte() == 0) goto L5;
        boolean r0 = true;
    L6:
        this.c = r0;
        if (r4.readByte() != 0) goto L10;
        r1 = false;
    L10:
        this.d = r1;
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        r1.writeString(this.a);
        r1.writeInt(this.b);
        r1.writeByte(this.c ? 1 : 0);
        r1.writeByte(this.d ? 1 : 0);
    }
}
