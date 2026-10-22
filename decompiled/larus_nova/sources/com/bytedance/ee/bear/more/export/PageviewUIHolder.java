package com.bytedance.ee.bear.more.export;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes18.dex */
public class PageviewUIHolder implements Parcelable {
    public static final Parcelable.Creator<PageviewUIHolder> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f234504a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f234505b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f234506c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f234507d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f234508e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f234509f;

    public class a implements Parcelable.Creator<PageviewUIHolder> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final PageviewUIHolder createFromParcel(Parcel r100) {
            return new PageviewUIHolder(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final PageviewUIHolder[] newArray(int r100) {
            return new PageviewUIHolder[r100];
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

    public PageviewUIHolder(Parcel r100) {
        this.f234504a = r100.readString();
        this.f234505b = r100.readString();
        this.f234506c = r100.readString();
        this.f234507d = r100.readString();
        this.f234508e = r100.readString();
        if (r100.readByte() == 0) goto L5;
        boolean r101 = true;
    L6:
        this.f234509f = r101;
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f234504a);
        r100.writeString(this.f234505b);
        r100.writeString(this.f234506c);
        r100.writeString(this.f234507d);
        r100.writeString(this.f234508e);
        r100.writeByte(this.f234509f ? 1 : 0);
    }
}
