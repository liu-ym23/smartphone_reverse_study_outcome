package com.ss.android.vesdk.settings;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes40.dex */
public class VideoInvisibleWatermarkSettings implements Parcelable {
    public static final Parcelable.Creator<VideoInvisibleWatermarkSettings> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f455923a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f455924b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f455925c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f455926d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f455927e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f455928f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f455929g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f455930h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f455931i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f455932j;

    public class a implements Parcelable.Creator<VideoInvisibleWatermarkSettings> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final VideoInvisibleWatermarkSettings createFromParcel(Parcel r100) {
            return new VideoInvisibleWatermarkSettings(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final VideoInvisibleWatermarkSettings[] newArray(int r100) {
            return new VideoInvisibleWatermarkSettings[r100];
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
        return "VideoInvisibleWatermarkSettings watermarkStr:" + this.f455923a + ", algorithmName:" + this.f455924b + ", watermarkInterval:" + this.f455925c + ", modelPath:" + this.f455926d + ", modelPathSec:" + this.f455927e + ", algoVersion:" + this.f455928f + ", endWaterDuration:" + this.f455929g + ", enableDelayInit:" + this.f455930h + ", pFlag:" + this.f455931i + ", memLazyload:" + this.f455932j + super.toString();
    }

    public VideoInvisibleWatermarkSettings() {
        this.f455924b = "anti_cut_resize_0";
        this.f455925c = 40;
        this.f455928f = 0;
        this.f455929g = 0;
        this.f455930h = false;
        this.f455931i = 0;
        this.f455932j = 0;
    }

    public VideoInvisibleWatermarkSettings(Parcel r100) {
        this.f455924b = "anti_cut_resize_0";
        this.f455925c = 40;
        boolean r101 = false;
        this.f455928f = 0;
        this.f455929g = 0;
        this.f455930h = false;
        this.f455931i = 0;
        this.f455932j = 0;
        this.f455923a = r100.readString();
        this.f455924b = r100.readString();
        this.f455925c = r100.readInt();
        this.f455926d = r100.readString();
        this.f455927e = r100.readString();
        this.f455928f = r100.readInt();
        this.f455929g = r100.readLong();
        if (r100.readByte() == 0) goto L5;
        r101 = true;
    L5:
        this.f455930h = r101;
        this.f455931i = r100.readInt();
        this.f455932j = r100.readInt();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f455923a);
        r100.writeString(this.f455924b);
        r100.writeInt(this.f455925c);
        r100.writeString(this.f455926d);
        r100.writeString(this.f455927e);
        r100.writeInt(this.f455928f);
        r100.writeLong(this.f455929g);
        r100.writeByte(this.f455930h ? 1 : 0);
        r100.writeInt(this.f455931i);
        r100.writeInt(this.f455932j);
    }
}
