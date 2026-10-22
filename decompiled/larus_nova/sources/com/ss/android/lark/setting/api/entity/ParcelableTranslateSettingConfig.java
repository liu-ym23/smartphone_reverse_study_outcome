package com.ss.android.lark.setting.api.entity;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes38.dex */
public class ParcelableTranslateSettingConfig implements Parcelable {
    public static final Parcelable.Creator<ParcelableTranslateSettingConfig> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ParcelableLanguageInfo f440496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ParcelableLanguageInfo f440497b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f440498c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f440499d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f440500e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f440501f;

    public class a implements Parcelable.Creator<ParcelableTranslateSettingConfig> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ParcelableTranslateSettingConfig createFromParcel(Parcel r100) {
            return new ParcelableTranslateSettingConfig(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final ParcelableTranslateSettingConfig[] newArray(int r100) {
            return new ParcelableTranslateSettingConfig[r100];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public ParcelableTranslateSettingConfig() {
    }

    public ParcelableTranslateSettingConfig(Parcel r100) {
        this.f440496a = (ParcelableLanguageInfo) r100.readParcelable(ParcelableLanguageInfo.class.getClassLoader());
        this.f440497b = (ParcelableLanguageInfo) r100.readParcelable(ParcelableLanguageInfo.class.getClassLoader());
        this.f440498c = r100.readString();
        boolean r101 = true;
        if (r100.readByte() == 0) goto L5;
        boolean r102 = true;
    L6:
        this.f440499d = r102;
        if (r100.readByte() == 0) goto L9;
        boolean r103 = true;
    L10:
        this.f440500e = r103;
        if (r100.readByte() != 0) goto L14;
        r101 = false;
    L14:
        this.f440501f = r101;
        return;
    L9:
        r103 = false;
        goto L10
    L5:
        r102 = false;
        goto L6
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeParcelable(this.f440496a, r101);
        r100.writeParcelable(this.f440497b, r101);
        r100.writeString(this.f440498c);
        r100.writeByte(this.f440499d ? 1 : 0);
        r100.writeByte(this.f440500e ? 1 : 0);
        r100.writeByte(this.f440501f ? 1 : 0);
    }
}
