package com.ss.android.ugc.aweme.mediachoose.helper;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes40.dex */
public class MediaAudio implements Parcelable {
    public static final Parcelable.Creator<MediaAudio> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f451267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f451268b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f451269c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f451270d;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public MediaAudio() {
    }

    public MediaAudio(Parcel r100) {
        this.f451267a = r100.readString();
        this.f451268b = r100.readString();
        this.f451269c = r100.readString();
        this.f451270d = r100.readLong();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f451267a);
        r100.writeString(this.f451268b);
        r100.writeString(this.f451269c);
        r100.writeLong(this.f451270d);
    }
}
