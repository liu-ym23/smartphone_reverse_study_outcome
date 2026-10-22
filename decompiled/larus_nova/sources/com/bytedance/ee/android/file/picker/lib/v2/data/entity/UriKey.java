package com.bytedance.ee.android.file.picker.lib.v2.data.entity;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ee/android/file/picker/lib/v2/data/entity/UriKey;", "Lcom/bytedance/ee/android/file/picker/lib/v2/data/entity/Key;", "uri", "Landroid/net/Uri;", "<init>", "(Landroid/net/Uri;)V", "getUri", "()Landroid/net/Uri;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "file-picker-lib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UriKey implements Key {
    public static final Parcelable.Creator<UriKey> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f206025a;

    public static final class a implements Parcelable.Creator<UriKey> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final UriKey createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new UriKey((Uri) r100.readParcelable(UriKey.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        public final UriKey[] newArray(int r100) {
            return new UriKey[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof UriKey) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f206025a, ((UriKey) r100).f206025a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f206025a.hashCode();
    }

    public final String toString() {
        return "UriKey(uri=" + this.f206025a + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeParcelable(this.f206025a, r101);
    }

    public UriKey(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        this.f206025a = r100;
    }
}
