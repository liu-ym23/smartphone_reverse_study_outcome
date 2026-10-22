package com.obric.memorydata.sdk.assistant;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H\u0016J\b\u0010\u000f\u001a\u00020\u0003H\u0016J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/obric/memorydata/sdk/assistant/QueryContext;", "Landroid/os/Parcelable;", "windowState", "", "queryType", "<init>", "(II)V", "getWindowState", "()I", "getQueryType", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "describeContents", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "CREATOR", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class QueryContext implements Parcelable {
    public static final a CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f397077a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f397078b;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<QueryContext> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final QueryContext createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            int r101 = r100.readInt();
            if (r100.dataAvail() <= 0) goto L5;
            int r102 = r100.readInt();
        L7:
            return new QueryContext(r101, r102);
        L5:
            r102 = 0;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final QueryContext[] newArray(int r100) {
            return new QueryContext[r100];
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
        if ((r100 instanceof QueryContext) == true) goto L8;
        return false;
    L8:
        QueryContext r101 = (QueryContext) r100;
        if (this.f397077a == r101.f397077a) goto L12;
        return false;
    L12:
        if (this.f397078b == r101.f397078b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f397077a * 31) + this.f397078b;
    }

    public final String toString() {
        return "QueryContext(windowState=" + this.f397077a + ", queryType=" + this.f397078b + ')';
    }

    public QueryContext(int r100, int r101) {
        this.f397077a = r100;
        this.f397078b = r101;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeInt(this.f397077a);
        r100.writeInt(this.f397078b);
    }
}
