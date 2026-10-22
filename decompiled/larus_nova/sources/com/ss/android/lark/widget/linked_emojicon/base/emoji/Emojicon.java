package com.ss.android.lark.widget.linked_emojicon.base.emoji;

import android.os.Parcel;
import android.os.Parcelable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes38.dex */
public class Emojicon implements Parcelable {
    public static final Parcelable.Creator<Emojicon> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f446385a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final char f446386b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f446387c;

    public @interface Alignment {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Type {
    }

    public class a implements Parcelable.Creator<Emojicon> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final Emojicon createFromParcel(Parcel r100) {
            return new Emojicon(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final Emojicon[] newArray(int r100) {
            return new Emojicon[r100];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public final int hashCode() {
        return this.f446387c.hashCode();
    }

    public Emojicon() {
    }

    public Emojicon(Parcel r100) {
        this.f446385a = r100.readInt();
        this.f446386b = (char) r100.readInt();
        this.f446387c = r100.readString();
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof Emojicon) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f446387c.equals(((Emojicon) r100).f446387c) == false) goto L7;
        return true;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(this.f446385a);
        r100.writeInt(this.f446386b);
        r100.writeString(this.f446387c);
    }
}
