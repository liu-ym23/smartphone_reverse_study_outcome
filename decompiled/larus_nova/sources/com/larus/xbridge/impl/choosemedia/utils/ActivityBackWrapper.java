package com.larus.xbridge.impl.choosemedia.utils;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 !2\u00020\u0001:\u0001!B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0007\u0010\u000bJ\b\u0010\u0011\u001a\u00020\u0005H\u0016J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0005H\u0016J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J)\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\""}, d2 = {"Lcom/larus/xbridge/impl/choosemedia/utils/ActivityBackWrapper;", "Landroid/os/Parcelable;", "intent", "Landroid/content/Intent;", "requestCode", "", "resultCode", "<init>", "(Landroid/content/Intent;II)V", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getIntent", "()Landroid/content/Intent;", "getRequestCode", "()I", "getResultCode", "describeContents", "writeToParcel", "", "dest", "flags", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "", "CREATOR", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ActivityBackWrapper implements Parcelable {
    public static final a CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Intent f379894a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f379895b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f379896c;

    public static final class a implements Parcelable.Creator<ActivityBackWrapper> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ActivityBackWrapper createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            Intrinsics.checkNotNullParameter(r100, "source");
            return new ActivityBackWrapper((Intent) r100.readParcelable(Intent.class.getClassLoader()), r100.readInt(), r100.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final ActivityBackWrapper[] newArray(int r100) {
            return new ActivityBackWrapper[r100];
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
        if ((r100 instanceof ActivityBackWrapper) == true) goto L8;
        return false;
    L8:
        ActivityBackWrapper r101 = (ActivityBackWrapper) r100;
        if (Intrinsics.areEqual(this.f379894a, r101.f379894a) == true) goto L12;
        return false;
    L12:
        if (this.f379895b == r101.f379895b) goto L15;
        return false;
    L15:
        if (this.f379896c == r101.f379896c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        Intent r100 = this.f379894a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (((r101 * 31) + this.f379895b) * 31) + this.f379896c;
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public final String toString() {
        return "ActivityBackWrapper(intent=" + this.f379894a + ", requestCode=" + this.f379895b + ", resultCode=" + this.f379896c + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeParcelable(this.f379894a, 0);
        r100.writeInt(this.f379895b);
        r100.writeInt(this.f379896c);
    }

    public ActivityBackWrapper(Intent r100, int r101, int r102) {
        this.f379894a = r100;
        this.f379895b = r101;
        this.f379896c = r102;
    }
}
