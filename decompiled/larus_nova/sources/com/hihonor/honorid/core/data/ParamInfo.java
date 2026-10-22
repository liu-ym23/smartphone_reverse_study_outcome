package com.hihonor.honorid.core.data;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes23.dex */
public class ParamInfo implements Parcelable {
    public static final Parcelable.Creator<ParamInfo> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f276565a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f276566b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f276567c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f276568d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f276569e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f276570f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f276571g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f276572h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f276573i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f276574j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f276575k;

    public class a implements Parcelable.Creator<ParamInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ParamInfo createFromParcel(Parcel r100) {
            return new ParamInfo(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final ParamInfo[] newArray(int r100) {
            return new ParamInfo[r100];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public ParamInfo(Parcel r100) {
        this.f276565a = r100.readString();
        this.f276566b = r100.readString();
        this.f276567c = r100.readString();
        this.f276568d = r100.readInt();
        this.f276569e = r100.readString();
        boolean r101 = true;
        if (r100.readByte() == 0) goto L5;
        boolean r102 = true;
    L6:
        this.f276570f = r102;
        if (r100.readByte() != 0) goto L10;
        r101 = false;
    L10:
        this.f276571g = r101;
        this.f276572h = r100.readString();
        this.f276573i = r100.readString();
        this.f276574j = r100.readString();
        this.f276575k = r100.readString();
        return;
    L5:
        r102 = false;
        goto L6
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f276565a);
        r100.writeString(this.f276566b);
        r100.writeString(this.f276567c);
        r100.writeInt(this.f276568d);
        r100.writeString(this.f276569e);
        r100.writeByte(this.f276570f ? 1 : 0);
        r100.writeByte(this.f276571g ? 1 : 0);
        r100.writeString(this.f276572h);
        r100.writeString(this.f276573i);
        r100.writeString(this.f276574j);
        r100.writeString(this.f276575k);
    }
}
