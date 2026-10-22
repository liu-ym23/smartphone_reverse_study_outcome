package com.loc;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.live.soloktv.SoloKtvContext;

/* JADX INFO: loaded from: classes32.dex */
public final class em implements Parcelable {
    public static final Parcelable.Creator<em> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f380040a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f380041b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f380042c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f380043d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f380044e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f380045f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f380046g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f380047h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f380048i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f380049j;

    public static class a implements Parcelable.Creator<em> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final em createFromParcel(Parcel r100) {
            em r101 = new em();
            r101.f380044e = r100.readString();
            r101.f380045f = r100.readString();
            r101.f380046g = r100.readString();
            r101.f380047h = r100.readString();
            r101.f380049j = r100.readString();
            r101.f380040a = r100.readLong();
            r101.f380041b = r100.readLong();
            r101.f380042c = r100.readLong();
            r101.f380043d = r100.readLong();
            r101.f380048i = r100.readString();
            return r101;
        }

        @Override // android.os.Parcelable.Creator
        public final em[] newArray(int r100) {
            return new em[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public em() {
        this.f380040a = 0;
        this.f380041b = 0;
        this.f380042c = 0;
        this.f380043d = 0;
        this.f380046g = SoloKtvContext.SOLO_PAGE_FIRST;
        this.f380047h = "";
        this.f380048i = "";
        this.f380049j = null;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f380044e);     // Catch: Throwable -> L4
        r100.writeString(this.f380045f);     // Catch: Throwable -> L4
        r100.writeString(this.f380046g);     // Catch: Throwable -> L4
        r100.writeString(this.f380047h);     // Catch: Throwable -> L4
        r100.writeString(this.f380049j);     // Catch: Throwable -> L4
        r100.writeLong(this.f380040a);     // Catch: Throwable -> L4
        r100.writeLong(this.f380041b);     // Catch: Throwable -> L4
        r100.writeLong(this.f380042c);     // Catch: Throwable -> L4
        r100.writeLong(this.f380043d);     // Catch: Throwable -> L4
        r100.writeString(this.f380048i);     // Catch: Throwable -> L4
        return;
    }
}
