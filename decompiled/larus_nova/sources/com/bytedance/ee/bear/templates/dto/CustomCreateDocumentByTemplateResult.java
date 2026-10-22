package com.bytedance.ee.bear.templates.dto;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes18.dex */
public class CustomCreateDocumentByTemplateResult implements Parcelable {
    public static final Parcelable.Creator<CustomCreateDocumentByTemplateResult> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f239062a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f239063b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f239064c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f239065d;

    public class a implements Parcelable.Creator<CustomCreateDocumentByTemplateResult> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final CustomCreateDocumentByTemplateResult createFromParcel(Parcel r100) {
            return new CustomCreateDocumentByTemplateResult(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final CustomCreateDocumentByTemplateResult[] newArray(int r100) {
            return new CustomCreateDocumentByTemplateResult[r100];
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
        return "CustomCreateDocumentByTemplateResult{close=" + this.f239062a + ", success=" + this.f239063b + ", url='" + du5.b.k(this.f239064c) + "', toastTip='" + this.f239065d + "'}";
    }

    public CustomCreateDocumentByTemplateResult(Parcel r100) {
        boolean r101 = true;
        if (r100.readByte() == 0) goto L5;
        boolean r102 = true;
    L6:
        this.f239062a = r102;
        if (r100.readByte() != 0) goto L10;
        r101 = false;
    L10:
        this.f239063b = r101;
        this.f239064c = r100.readString();
        this.f239065d = r100.readString();
        return;
    L5:
        r102 = false;
        goto L6
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeByte(this.f239062a ? 1 : 0);
        r100.writeByte(this.f239063b ? 1 : 0);
        r100.writeString(this.f239064c);
        r100.writeString(this.f239065d);
    }
}
