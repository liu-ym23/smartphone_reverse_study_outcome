package com.ss.android.lark.setting.api.entity;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes38.dex */
public class ParcelableLanguageInfo implements Parcelable {
    public static final Parcelable.Creator<ParcelableLanguageInfo> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f440493a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f440494b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f440495c;

    public class a implements Parcelable.Creator<ParcelableLanguageInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ParcelableLanguageInfo createFromParcel(Parcel r100) {
            return new ParcelableLanguageInfo(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final ParcelableLanguageInfo[] newArray(int r100) {
            return new ParcelableLanguageInfo[r100];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public ParcelableLanguageInfo() {
    }

    public ParcelableLanguageInfo(Parcel r100) {
        this.f440493a = r100.readString();
        this.f440494b = r100.readString();
        this.f440495c = r100.readString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f440493a);
        r100.writeString(this.f440494b);
        r100.writeString(this.f440495c);
    }
}
