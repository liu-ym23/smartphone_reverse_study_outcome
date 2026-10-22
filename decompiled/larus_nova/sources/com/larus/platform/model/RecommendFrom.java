package com.larus.platform.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0006\u0010\u0014\u001a\u00020\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0015HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0015R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000b¨\u0006!"}, d2 = {"Lcom/larus/platform/model/RecommendFrom;", "Landroid/os/Parcelable;", "scene", "", "requestId", "recommendFrom", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getScene", "()Ljava/lang/String;", "setScene", "(Ljava/lang/String;)V", "getRequestId", "setRequestId", "getRecommendFrom", "setRecommendFrom", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RecommendFrom implements Parcelable {
    public static final Parcelable.Creator<RecommendFrom> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f365482a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f365483b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f365484c;

    public static final class a implements Parcelable.Creator<RecommendFrom> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final RecommendFrom createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new RecommendFrom(r100.readString(), r100.readString(), r100.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final RecommendFrom[] newArray(int r100) {
            return new RecommendFrom[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public RecommendFrom() {
        String r100 = null;
        this(r100, r100, r100, 7);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof RecommendFrom) == true) goto L8;
        return false;
    L8:
        RecommendFrom r101 = (RecommendFrom) r100;
        if (Intrinsics.areEqual(this.f365482a, r101.f365482a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f365483b, r101.f365483b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f365484c, r101.f365484c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f365482a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f365483b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f365484c;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "RecommendFrom(scene=" + this.f365482a + ", requestId=" + this.f365483b + ", recommendFrom=" + this.f365484c + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f365482a);
        r100.writeString(this.f365483b);
        r100.writeString(this.f365484c);
    }

    public final String a() {
        return this.f365483b;
    }

    public final String b() {
        return this.f365482a;
    }

    public RecommendFrom(String r100, String r101, String r102) {
        this.f365482a = r100;
        this.f365483b = r101;
        this.f365484c = r102;
    }

    public /* synthetic */ RecommendFrom(String r100, String r101, String r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
