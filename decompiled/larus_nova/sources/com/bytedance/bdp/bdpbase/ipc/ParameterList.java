package com.bytedance.bdp.bdpbase.ipc;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes11.dex */
public class ParameterList implements Parcelable {
    public static final Parcelable.Creator<ParameterList> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f201111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object[] f201112b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f201113c;

    public class a implements Parcelable.Creator<ParameterList> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ParameterList createFromParcel(Parcel r100) {
            return new ParameterList(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final ParameterList[] newArray(int r100) {
            return new ParameterList[r100];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public ParameterList(Parcel r100) {
        int r101 = r100.readInt();
        this.f201113c = r101;
        this.f201111a = new byte[r101];
        this.f201112b = new Object[r101];
        int r102 = 0;
    L4:
        if (r102 >= this.f201113c) goto L6;
        byte r103 = r100.readByte();
        this.f201111a[r102] = r103;
        ba4.b r104 = ba4.c.getType(r103);
        this.f201112b[r102] = r104.createFromParcel(r100);
        r102 = r102 + 1;
        goto L4
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(this.f201113c);
        int r102 = 0;
    L4:
        if (r102 >= this.f201113c) goto L6;
        byte r103 = this.f201111a[r102];
        r100.writeByte(r103);
        ba4.c.getType(r103).a(r100, r101, this.f201112b[r102]);
        r102 = r102 + 1;
        goto L4
    }

    public ParameterList(int r100, byte[] r101, Object[] r102) {
        this.f201113c = r100;
        this.f201111a = r101;
        this.f201112b = r102;
    }
}
