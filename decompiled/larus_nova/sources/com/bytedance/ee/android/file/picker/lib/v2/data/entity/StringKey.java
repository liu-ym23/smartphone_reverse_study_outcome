package com.bytedance.ee.android.file.picker.lib.v2.data.entity;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ee/android/file/picker/lib/v2/data/entity/StringKey;", "Lcom/bytedance/ee/android/file/picker/lib/v2/data/entity/Key;", "str", "", "<init>", "(Ljava/lang/String;)V", "getStr", "()Ljava/lang/String;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "file-picker-lib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StringKey implements Key {
    public static final Parcelable.Creator<StringKey> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f206024a;

    public static final class a implements Parcelable.Creator<StringKey> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final StringKey createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new StringKey(r100.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final StringKey[] newArray(int r100) {
            return new StringKey[r100];
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
        if ((r100 instanceof StringKey) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f206024a, ((StringKey) r100).f206024a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f206024a.hashCode();
    }

    public final String toString() {
        return "StringKey(str=" + this.f206024a + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f206024a);
    }

    public StringKey(String r100) {
        Intrinsics.checkNotNullParameter(r100, "str");
        this.f206024a = r100;
    }
}
