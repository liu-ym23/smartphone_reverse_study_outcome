package com.huawei.hms.support.account.result;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes23.dex */
public class AccountIcon implements Parcelable {
    public static final Parcelable.Creator<AccountIcon> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f277698a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Bitmap f277699b;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public AccountIcon() {
    }

    public String getDescription() {
        return this.f277698a;
    }

    public Bitmap getIcon() {
        return this.f277699b;
    }

    private AccountIcon(Parcel r100) {
        this.f277698a = r100.readString();
        this.f277699b = (Bitmap) r100.readParcelable(Bitmap.class.getClassLoader());
    }

    public void setDescription(String r100) {
        this.f277698a = r100;
    }

    public void setIcon(Bitmap r100) {
        this.f277699b = r100;
    }

    public AccountIcon(String r100, Bitmap r101) {
        this.f277698a = r100;
        this.f277699b = r101;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f277698a);
        r100.writeParcelable(this.f277699b, r101);
    }

    public /* synthetic */ AccountIcon(Parcel r100, AnonymousClass1 r101) {
        this(r100);
    }
}
