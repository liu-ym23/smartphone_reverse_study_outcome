package com.bytedance.ee.bear.operation.api.event;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes18.dex */
public class OperationEvent implements Parcelable {
    public static final Parcelable.Creator<OperationEvent> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f236198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f236199b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f236200c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f236201d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f236202e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Long f236203f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f236204g;

    public class a implements Parcelable.Creator<OperationEvent> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final OperationEvent createFromParcel(Parcel r100) {
            return new OperationEvent(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final OperationEvent[] newArray(int r100) {
            return new OperationEvent[r100];
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
        this.f236203f = Long.valueOf(System.currentTimeMillis());
    }

    public OperationEvent(Parcel r100) {
        this.f236198a = r100.readString();
        this.f236199b = r100.readInt();
        this.f236200c = r100.readString();
        this.f236201d = r100.readInt();
        this.f236202e = r100.readString();
        this.f236203f = (Long) r100.readValue(Long.class.getClassLoader());
        this.f236204g = r100.readString();
    }

    public OperationEvent(bl5.a r100) {
        this.f236198a = r100.f19433a;
        this.f236199b = r100.f19434b;
        this.f236200c = r100.f19435c;
        this.f236201d = r100.f19436d;
        this.f236202e = r100.f19437e;
        this.f236203f = r100.f19438f;
        this.f236204g = r100.f19439g;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f236198a);
        r100.writeInt(this.f236199b);
        r100.writeString(this.f236200c);
        r100.writeInt(this.f236201d);
        r100.writeString(this.f236202e);
        r100.writeValue(this.f236203f);
        r100.writeString(this.f236204g);
    }
}
