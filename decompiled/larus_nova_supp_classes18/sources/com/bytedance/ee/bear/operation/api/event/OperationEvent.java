package com.bytedance.ee.bear.operation.api.event;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class OperationEvent implements Parcelable {
    public static final Parcelable.Creator<OperationEvent> CREATOR = null;
    public String a;
    public int b;
    public String c;
    public int d;
    public String e;
    public Long f;
    public String g;

    public class a implements Parcelable.Creator<OperationEvent> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final OperationEvent createFromParcel(Parcel r2) {
            return new OperationEvent(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final OperationEvent[] newArray(int r1) {
            return new OperationEvent[r1];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public OperationEvent() {
        this.f = Long.valueOf(System.currentTimeMillis());
    }

    public OperationEvent(Parcel r2) {
        this.a = r2.readString();
        this.b = r2.readInt();
        this.c = r2.readString();
        this.d = r2.readInt();
        this.e = r2.readString();
        this.f = (Long) r2.readValue(Long.class.getClassLoader());
        this.g = r2.readString();
    }

    public OperationEvent(bl5.a r2) {
        this.a = r2.a;
        this.b = r2.b;
        this.c = r2.c;
        this.d = r2.d;
        this.e = r2.e;
        this.f = r2.f;
        this.g = r2.g;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        r1.writeString(this.a);
        r1.writeInt(this.b);
        r1.writeString(this.c);
        r1.writeInt(this.d);
        r1.writeString(this.e);
        r1.writeValue(this.f);
        r1.writeString(this.g);
    }
}
