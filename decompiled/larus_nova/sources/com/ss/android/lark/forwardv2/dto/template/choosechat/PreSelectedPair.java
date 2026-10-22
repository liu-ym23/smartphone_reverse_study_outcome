package com.ss.android.lark.forwardv2.dto.template.choosechat;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes36.dex */
public class PreSelectedPair implements Parcelable {
    public static final Parcelable.Creator<PreSelectedPair> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f424872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f424873b;

    public class a implements Parcelable.Creator<PreSelectedPair> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final PreSelectedPair createFromParcel(Parcel r100) {
            return new PreSelectedPair(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final PreSelectedPair[] newArray(int r100) {
            return new PreSelectedPair[r100];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public PreSelectedPair() {
    }

    public PreSelectedPair(Parcel r100) {
        this.f424872a = r100.readString();
        this.f424873b = r100.readString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f424872a);
        r100.writeString(this.f424873b);
    }
}
