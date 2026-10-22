package com.bytedance.ee.bear.templates.dto;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class CustomCreateDocumentByTemplateResult implements Parcelable {
    public static final Parcelable.Creator<CustomCreateDocumentByTemplateResult> CREATOR = null;
    public final boolean a;
    public final boolean b;
    public final String c;
    public final String d;

    public class a implements Parcelable.Creator<CustomCreateDocumentByTemplateResult> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final CustomCreateDocumentByTemplateResult createFromParcel(Parcel r2) {
            return new CustomCreateDocumentByTemplateResult(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final CustomCreateDocumentByTemplateResult[] newArray(int r1) {
            return new CustomCreateDocumentByTemplateResult[r1];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public final String toString() {
        return "CustomCreateDocumentByTemplateResult{close=" + this.a + ", success=" + this.b + ", url='" + du5.b.k(this.c) + "', toastTip='" + this.d + "'}";
    }

    public CustomCreateDocumentByTemplateResult(Parcel r4) {
        boolean r1 = true;
        if (r4.readByte() == 0) goto L5;
        boolean r0 = true;
    L6:
        this.a = r0;
        if (r4.readByte() != 0) goto L10;
        r1 = false;
    L10:
        this.b = r1;
        this.c = r4.readString();
        this.d = r4.readString();
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        r1.writeByte(this.a ? 1 : 0);
        r1.writeByte(this.b ? 1 : 0);
        r1.writeString(this.c);
        r1.writeString(this.d);
    }
}
