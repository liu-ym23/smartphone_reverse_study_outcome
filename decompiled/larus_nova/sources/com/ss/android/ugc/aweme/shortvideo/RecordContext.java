package com.ss.android.ugc.aweme.shortvideo;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.ugc.aweme.filter.StrArray;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/shortvideo/RecordContext;", "Landroid/os/Parcelable;", "lib-runtime_release"}, k = 1, mv = {1, 4, 1})
public final class RecordContext implements Parcelable {
    public static final Parcelable.Creator<RecordContext> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final StrArray f454169a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final StrArray f454170b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final StrArray f454171c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final StrArray f454172d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final StrArray f454173e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final StrArray f454174f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final StrArray f454175g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final StrArray f454176h;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    public static class Creator implements Parcelable.Creator<RecordContext> {
        public Creator() {
        }

        @Override // android.os.Parcelable.Creator
        public final RecordContext createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "in");
            return new RecordContext((StrArray) r110.readParcelable(RecordContext.class.getClassLoader()), (StrArray) r110.readParcelable(RecordContext.class.getClassLoader()), (StrArray) r110.readParcelable(RecordContext.class.getClassLoader()), (StrArray) r110.readParcelable(RecordContext.class.getClassLoader()), (StrArray) r110.readParcelable(RecordContext.class.getClassLoader()), (StrArray) r110.readParcelable(RecordContext.class.getClassLoader()), (StrArray) r110.readParcelable(RecordContext.class.getClassLoader()), (StrArray) r110.readParcelable(RecordContext.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        public final RecordContext[] newArray(int r100) {
            return new RecordContext[r100];
        }
    }

    static {
        CREATOR = new Creator();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof RecordContext) == false) goto L22;
        RecordContext r101 = (RecordContext) r100;
        if (Intrinsics.areEqual(this.f454169a, r101.f454169a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f454170b, r101.f454170b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f454171c, r101.f454171c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f454172d, r101.f454172d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f454173e, r101.f454173e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f454174f, r101.f454174f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f454175g, r101.f454175g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f454176h, r101.f454176h) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public final int hashCode() {
        StrArray r100 = this.f454169a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        StrArray r104 = this.f454170b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        StrArray r107 = this.f454171c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        StrArray r110 = this.f454172d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        StrArray r113 = this.f454173e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        StrArray r116 = this.f454174f;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        StrArray r119 = this.f454175g;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        StrArray r122 = this.f454176h;
        if (r122 == null) goto L34;
        r101 = r122.hashCode();
    L34:
        return r121 + r101;
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "RecordContext(filterLabels=" + this.f454169a + ", filterIds=" + this.f454170b + ", filterValues=" + this.f454171c + ", filterEnterMethod=" + this.f454172d + ", smoothSkinLabels=" + this.f454173e + ", reshapeLabels=" + this.f454174f + ", eyesLables=" + this.f454175g + ", tanningLabels=" + this.f454176h + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeParcelable(this.f454169a, r101);
        r100.writeParcelable(this.f454170b, r101);
        r100.writeParcelable(this.f454171c, r101);
        r100.writeParcelable(this.f454172d, r101);
        r100.writeParcelable(this.f454173e, r101);
        r100.writeParcelable(this.f454174f, r101);
        r100.writeParcelable(this.f454175g, r101);
        r100.writeParcelable(this.f454176h, r101);
    }

    public RecordContext() {
        this(new StrArray(), new StrArray(), new StrArray(), new StrArray(), new StrArray(), new StrArray(), new StrArray(), new StrArray());
    }

    public RecordContext(StrArray r100, StrArray r101, StrArray r102, StrArray r103, StrArray r104, StrArray r105, StrArray r106, StrArray r107) {
        Intrinsics.checkNotNullParameter(r100, "filterLabels");
        Intrinsics.checkNotNullParameter(r101, "filterIds");
        Intrinsics.checkNotNullParameter(r102, "filterValues");
        Intrinsics.checkNotNullParameter(r103, "filterEnterMethod");
        Intrinsics.checkNotNullParameter(r104, "smoothSkinLabels");
        Intrinsics.checkNotNullParameter(r105, "reshapeLabels");
        Intrinsics.checkNotNullParameter(r106, "eyesLables");
        Intrinsics.checkNotNullParameter(r107, "tanningLabels");
        this.f454169a = r100;
        this.f454170b = r101;
        this.f454171c = r102;
        this.f454172d = r103;
        this.f454173e = r104;
        this.f454174f = r105;
        this.f454175g = r106;
        this.f454176h = r107;
    }
}
