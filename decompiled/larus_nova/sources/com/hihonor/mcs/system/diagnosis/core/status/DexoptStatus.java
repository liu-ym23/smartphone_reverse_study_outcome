package com.hihonor.mcs.system.diagnosis.core.status;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes23.dex */
public class DexoptStatus implements Parcelable {
    public static final Parcelable.Creator<DexoptStatus> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f276672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f276673b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f276674c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f276675d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f276676e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f276677f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f276678g;

    public static class a implements Parcelable.Creator<DexoptStatus> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final DexoptStatus createFromParcel(Parcel r100) {
            return new DexoptStatus(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final DexoptStatus[] newArray(int r100) {
            return new DexoptStatus[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public DexoptStatus(Parcel r100) {
        this.f276672a = r100.readString();
        this.f276673b = r100.readString();
        this.f276674c = r100.readString();
        this.f276675d = r100.readString();
        this.f276676e = r100.readInt();
        this.f276677f = r100.readInt();
        this.f276678g = r100.readInt();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f276672a);
        r100.writeString(this.f276673b);
        r100.writeString(this.f276674c);
        r100.writeString(this.f276675d);
        r100.writeInt(this.f276676e);
        r100.writeInt(this.f276677f);
        r100.writeInt(this.f276678g);
    }
}
