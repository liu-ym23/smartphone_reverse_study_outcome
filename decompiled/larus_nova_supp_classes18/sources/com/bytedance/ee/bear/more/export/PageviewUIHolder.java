package com.bytedance.ee.bear.more.export;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class PageviewUIHolder implements Parcelable {
    public static final Parcelable.Creator<PageviewUIHolder> CREATOR = null;
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public boolean f;

    public class a implements Parcelable.Creator<PageviewUIHolder> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final PageviewUIHolder createFromParcel(Parcel r2) {
            return new PageviewUIHolder(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final PageviewUIHolder[] newArray(int r1) {
            return new PageviewUIHolder[r1];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public PageviewUIHolder() {
    }

    public PageviewUIHolder(Parcel r2) {
        this.a = r2.readString();
        this.b = r2.readString();
        this.c = r2.readString();
        this.d = r2.readString();
        this.e = r2.readString();
        if (r2.readByte() == 0) goto L5;
        boolean r3 = true;
    L6:
        this.f = r3;
        return;
    L5:
        r3 = false;
        goto L6
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        r1.writeString(this.a);
        r1.writeString(this.b);
        r1.writeString(this.c);
        r1.writeString(this.d);
        r1.writeString(this.e);
        r1.writeByte(this.f ? 1 : 0);
    }
}
