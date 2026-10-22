package com.obric.memorydata.sdk.proactive;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 (2\u00020\u0001:\u0001(B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fB\u0011\b\u0016\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000b\u0010\u000fJ\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J7\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001J\u0013\u0010#\u001a\u00020\u00072\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020\u001cHÖ\u0001J\t\u0010'\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006)"}, d2 = {"Lcom/obric/memorydata/sdk/proactive/ProactiveDayPageResult;", "Landroid/os/Parcelable;", "batchId", "", "dayKey", "", "hasNext", "", "list", "", "Lcom/obric/memorydata/sdk/proactive/ProactiveRecommendationDto;", "<init>", "(JLjava/lang/String;ZLjava/util/List;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getBatchId", "()J", "getDayKey", "()Ljava/lang/String;", "getHasNext", "()Z", "getList", "()Ljava/util/List;", "writeToParcel", "", "dest", "flags", "", "describeContents", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "toString", "CREATOR", "cocreationreview_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ProactiveDayPageResult implements Parcelable {
    public static final a CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f397155a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f397156b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f397157c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<ProactiveRecommendationDto> f397158d;

    public static final class a implements Parcelable.Creator<ProactiveDayPageResult> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ProactiveDayPageResult createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            Intrinsics.checkNotNullParameter(r110, "parcel");
            long r100 = r110.readLong();
            String r101 = r110.readString();
            if (r101 != null) goto L5;
            r101 = "";
        L5:
            String r102 = r101;
            int r103 = 0;
            if (r110.readInt() == 0) goto L8;
            boolean r104 = true;
        L9:
            List r105 = CollectionsKt.createListBuilder();
            int r106 = r110.readInt();
        L10:
            if (r103 >= r106) goto L12;
            ProactiveRecommendationDto.CREATOR.getClass();
            r105.add(ProactiveRecommendationDto.a.a(r110));
            r103 = r103 + 1;
            goto L10
        L12:
            Unit r111 = Unit.INSTANCE;
            return new ProactiveDayPageResult(r100, r102, r104, CollectionsKt.build(r105));
        L8:
            r104 = false;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public final ProactiveDayPageResult[] newArray(int r100) {
            return new ProactiveDayPageResult[r100];
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
        if ((r100 instanceof ProactiveDayPageResult) == true) goto L8;
        return false;
    L8:
        ProactiveDayPageResult r101 = (ProactiveDayPageResult) r100;
        if (this.f397155a == r101.f397155a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f397156b, r101.f397156b) == true) goto L15;
        return false;
    L15:
        if (this.f397157c == r101.f397157c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f397158d, r101.f397158d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f397155a;
        int r101 = ((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f397156b.hashCode()) * 31;
        if (this.f397157c == false) goto L5;
        int r102 = 1231;
    L7:
        return ((r101 + r102) * 31) + this.f397158d.hashCode();
    L5:
        r102 = 1237;
        goto L7
    }

    public final String toString() {
        return "ProactiveDayPageResult(batchId=" + this.f397155a + ", dayKey=" + this.f397156b + ", hasNext=" + this.f397157c + ", list=" + this.f397158d + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeLong(this.f397155a);
        r100.writeString(this.f397156b);
        r100.writeInt(this.f397157c ? 1 : 0);
        r100.writeInt(this.f397158d.size());
        Iterator<T> r102 = this.f397158d.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((ProactiveRecommendationDto) r102.next()).writeToParcel(r100, r101);
        goto L4
    }

    public ProactiveDayPageResult(long r100, String r101, boolean r102, List<ProactiveRecommendationDto> r103) {
        Intrinsics.checkNotNullParameter(r101, "dayKey");
        Intrinsics.checkNotNullParameter(r103, "list");
        this.f397155a = r100;
        this.f397156b = r101;
        this.f397157c = r102;
        this.f397158d = r103;
    }
}
