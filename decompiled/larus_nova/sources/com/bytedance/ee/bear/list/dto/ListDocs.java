package com.bytedance.ee.bear.list.dto;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public class ListDocs implements Parcelable {
    public static final Parcelable.Creator<ListDocs> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<String> f227914a;

    public class a implements Parcelable.Creator<ListDocs> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ListDocs createFromParcel(Parcel r100) {
            return new ListDocs(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final ListDocs[] newArray(int r100) {
            return new ListDocs[r100];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public ListDocs() {
    }

    public ListDocs(Parcel r100) {
        this.f227914a = r100.createStringArrayList();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeStringList(this.f227914a);
    }
}
