package com.obric.memorydata.sdk.proactive;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 !2\u00020\u0001:\u0001!B+\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0007\u0010\u000bJ\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0004HÆ\u0003J3\u0010\u001a\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u0015HÖ\u0001J\t\u0010 \u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\""}, d2 = {"Lcom/obric/memorydata/sdk/proactive/ProactiveLabelingFeedbackConfigDto;", "Landroid/os/Parcelable;", "positiveReasons", "", "", "negativeReasons", "feedbackPlaceholder", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getPositiveReasons", "()Ljava/util/List;", "getNegativeReasons", "getFeedbackPlaceholder", "()Ljava/lang/String;", "writeToParcel", "", "dest", "flags", "", "describeContents", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "CREATOR", "cocreationreview_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ProactiveLabelingFeedbackConfigDto implements Parcelable {
    public static final a CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f397167a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f397168b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f397169c;

    public static final class a implements Parcelable.Creator<ProactiveLabelingFeedbackConfigDto> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ProactiveLabelingFeedbackConfigDto createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            Intrinsics.checkNotNullParameter(r100, "parcel");
            List r101 = r100.createStringArrayList();
            if (r101 != null) goto L5;
            r101 = CollectionsKt.emptyList();
        L5:
            List r102 = r100.createStringArrayList();
            if (r102 != null) goto L8;
            r102 = CollectionsKt.emptyList();
        L8:
            String r103 = r100.readString();
            if (r103 != null) goto L12;
            r103 = "";
        L12:
            return new ProactiveLabelingFeedbackConfigDto(r101, r102, r103);
        }

        @Override // android.os.Parcelable.Creator
        public final ProactiveLabelingFeedbackConfigDto[] newArray(int r100) {
            return new ProactiveLabelingFeedbackConfigDto[r100];
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
        if ((r100 instanceof ProactiveLabelingFeedbackConfigDto) == true) goto L8;
        return false;
    L8:
        ProactiveLabelingFeedbackConfigDto r101 = (ProactiveLabelingFeedbackConfigDto) r100;
        if (Intrinsics.areEqual(this.f397167a, r101.f397167a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f397168b, r101.f397168b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f397169c, r101.f397169c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f397167a.hashCode() * 31) + this.f397168b.hashCode()) * 31) + this.f397169c.hashCode();
    }

    public final String toString() {
        return "ProactiveLabelingFeedbackConfigDto(positiveReasons=" + this.f397167a + ", negativeReasons=" + this.f397168b + ", feedbackPlaceholder=" + this.f397169c + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeStringList(this.f397167a);
        r100.writeStringList(this.f397168b);
        r100.writeString(this.f397169c);
    }

    public ProactiveLabelingFeedbackConfigDto(List<String> r100, List<String> r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "positiveReasons");
        Intrinsics.checkNotNullParameter(r101, "negativeReasons");
        Intrinsics.checkNotNullParameter(r102, "feedbackPlaceholder");
        this.f397167a = r100;
        this.f397168b = r101;
        this.f397169c = r102;
    }
}
