package com.ss.android.socialbase.downloader.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes5.dex */
public class HttpHeader implements Parcelable, Comparable {
    public static final Parcelable.Creator<HttpHeader> CREATOR = null;
    private final String name;
    private final String value;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public int hashCode() {
        String r100 = this.name;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.value;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "HttpHeader{name='" + this.name + "', value='" + this.value + "'}";
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public HttpHeader(Parcel r100) {
        this.name = r100.readString();
        this.value = r100.readString();
    }

    @Override // java.lang.Comparable
    public int compareTo(Object r100) {
        if ((r100 instanceof HttpHeader) == false) goto L16;
        HttpHeader r101 = (HttpHeader) r100;
        if (TextUtils.equals(this.name, r101.getName()) == false) goto L7;
        return 0;
    L7:
        String r102 = this.name;
        if (r102 != null) goto L10;
        return -1;
    L10:
        int r103 = r102.compareTo(r101.getName());
        if (r103 <= 0) goto L13;
        return 1;
    L13:
        if (r103 >= 0) goto L15;
        return -1;
    L15:
        return 0;
    L16:
        return 1;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L17:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L17;
        HttpHeader r101 = (HttpHeader) r100;
        if (TextUtils.equals(this.name, r101.name) == true) goto L13;
    L15:
        return false;
    L13:
        if (TextUtils.equals(this.value, r101.value) == false) goto L15;
        return true;
    }

    public HttpHeader(String r100, String r101) {
        this.name = r100;
        this.value = r101;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.name);
        r100.writeString(this.value);
    }
}
