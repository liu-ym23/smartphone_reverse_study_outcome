package com.bytedance.ee.bear.widgets;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class ButtonsBean implements Parcelable {
    public static final Parcelable.Creator<ButtonsBean> CREATOR = null;
    public final String a;
    public final String b;
    public final int c;
    public final boolean d;

    public class a implements Parcelable.Creator<ButtonsBean> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ButtonsBean createFromParcel(Parcel r2) {
            return new ButtonsBean(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final ButtonsBean[] newArray(int r1) {
            return new ButtonsBean[r1];
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

    public ButtonsBean(Parcel r2) {
        this.a = r2.readString();
        this.b = r2.readString();
        this.c = r2.readInt();
        if (r2.readByte() == 0) goto L5;
        boolean r3 = true;
    L6:
        this.d = r3;
        return;
    L5:
        r3 = false;
        goto L6
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        r1.writeString(this.a);
        r1.writeString(this.b);
        r1.writeInt(this.c);
        r1.writeByte(this.d ? 1 : 0);
    }
}
