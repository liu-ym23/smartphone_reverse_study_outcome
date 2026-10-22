package com.bytedance.ee.bear.list.dto;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class ListDocs implements Parcelable {
    public static final Parcelable.Creator<ListDocs> CREATOR = null;
    public List<String> a;

    public class a implements Parcelable.Creator<ListDocs> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ListDocs createFromParcel(Parcel r2) {
            return new ListDocs(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final ListDocs[] newArray(int r1) {
            return new ListDocs[r1];
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

    public ListDocs(Parcel r1) {
        this.a = r1.createStringArrayList();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        r1.writeStringList(this.a);
    }
}
