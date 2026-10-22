package com.bytedance.ee.bear.widgets;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes18.dex */
public class ButtonsBean implements Parcelable {
    public static final Parcelable.Creator<ButtonsBean> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f240064a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f240065b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f240066c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f240067d;

    public class a implements Parcelable.Creator<ButtonsBean> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ButtonsBean createFromParcel(Parcel r100) {
            return new ButtonsBean(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final ButtonsBean[] newArray(int r100) {
            return new ButtonsBean[r100];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public ButtonsBean() {
    }

    public ButtonsBean(Parcel r100) {
        this.f240064a = r100.readString();
        this.f240065b = r100.readString();
        this.f240066c = r100.readInt();
        if (r100.readByte() == 0) goto L5;
        boolean r101 = true;
    L6:
        this.f240067d = r101;
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f240064a);
        r100.writeString(this.f240065b);
        r100.writeInt(this.f240066c);
        r100.writeByte(this.f240067d ? 1 : 0);
    }
}
