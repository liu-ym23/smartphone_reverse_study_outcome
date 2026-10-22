package com.suite.lark.platform.service.resourcerepository.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.lark.pb.basic.v1.Trace;
import com.larksuite.framework.callback.Entity.ErrorResult;

/* JADX INFO: loaded from: classes36.dex */
public class Resource implements Parcelable {
    public static final Parcelable.Creator<Resource> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f461376a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f461377b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Boolean f461378c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Trace f461379d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ErrorResult f461380e;

    public class a implements Parcelable.Creator<Resource> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final Resource createFromParcel(Parcel r100) {
            return new Resource(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final Resource[] newArray(int r100) {
            return new Resource[r100];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public Resource() {
    }

    public Resource(Parcel r100) {
        this.f461376a = r100.readString();
        this.f461377b = r100.readString();
        boolean r101 = true;
        if (r100.readInt() == 1) goto L6;
        r101 = false;
    L6:
        this.f461378c = Boolean.valueOf(r101);
        this.f461379d = (Trace) r100.readSerializable();
        this.f461380e = (ErrorResult) r100.readSerializable();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f461376a);
        r100.writeString(this.f461377b);
        r100.writeInt(this.f461378c.booleanValue() ? 1 : 0);
        r100.writeSerializable(this.f461379d);
        r100.writeSerializable(this.f461380e);
    }

    public Resource(String r100, String r101, Boolean r102) {
        this.f461376a = r100;
        this.f461377b = r101;
        this.f461378c = r102;
    }
}
