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
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 (2\u00020\u0001:\u0001(B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fB\u0011\b\u0016\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000b\u0010\u000fJ\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001bH\u0016J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\b0\u0005HÆ\u0003J\t\u0010 \u001a\u00020\nHÆ\u0003J=\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\"\u001a\u00020\n2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020\u001bHÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006)"}, d2 = {"Lcom/obric/memorydata/sdk/proactive/ProactiveAllPageSnapshot;", "Landroid/os/Parcelable;", "batchId", "", "dayHeaders", "", "Lcom/obric/memorydata/sdk/proactive/ProactiveDayHeaderDto;", "todayFirstPage", "Lcom/obric/memorydata/sdk/proactive/ProactiveRecommendationDto;", "todayHasNext", "", "<init>", "(JLjava/util/List;Ljava/util/List;Z)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getBatchId", "()J", "getDayHeaders", "()Ljava/util/List;", "getTodayFirstPage", "getTodayHasNext", "()Z", "writeToParcel", "", "dest", "flags", "", "describeContents", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "toString", "", "CREATOR", "cocreationreview_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ProactiveAllPageSnapshot implements Parcelable {
    public static final a CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f397148a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<ProactiveDayHeaderDto> f397149b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<ProactiveRecommendationDto> f397150c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f397151d;

    public static final class a implements Parcelable.Creator<ProactiveAllPageSnapshot> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ProactiveAllPageSnapshot createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            Intrinsics.checkNotNullParameter(r110, "parcel");
            long r100 = r110.readLong();
            List r101 = CollectionsKt.createListBuilder();
            int r102 = r110.readInt();
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L5;
            ProactiveDayHeaderDto.CREATOR.getClass();
            r101.add(ProactiveDayHeaderDto.a.a(r110));
            r103 = r103 + 1;
            goto L3
        L5:
            Unit r104 = Unit.INSTANCE;
            List r105 = CollectionsKt.build(r101);
            List r106 = CollectionsKt.createListBuilder();
            int r107 = r110.readInt();
            int r108 = 0;
        L6:
            if (r108 >= r107) goto L8;
            ProactiveRecommendationDto.CREATOR.getClass();
            r106.add(ProactiveRecommendationDto.a.a(r110));
            r108 = r108 + 1;
            goto L6
        L8:
            Unit r109 = Unit.INSTANCE;
            List r111 = CollectionsKt.build(r106);
            if (r110.readInt() == 0) goto L11;
            boolean r112 = true;
        L13:
            return new ProactiveAllPageSnapshot(r100, r105, r111, r112);
        L11:
            r112 = false;
            goto L13
        }

        @Override // android.os.Parcelable.Creator
        public final ProactiveAllPageSnapshot[] newArray(int r100) {
            return new ProactiveAllPageSnapshot[r100];
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
        if ((r100 instanceof ProactiveAllPageSnapshot) == true) goto L8;
        return false;
    L8:
        ProactiveAllPageSnapshot r101 = (ProactiveAllPageSnapshot) r100;
        if (this.f397148a == r101.f397148a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f397149b, r101.f397149b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f397150c, r101.f397150c) == true) goto L18;
        return false;
    L18:
        if (this.f397151d == r101.f397151d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f397148a;
        int r101 = ((((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f397149b.hashCode()) * 31) + this.f397150c.hashCode()) * 31;
        if (this.f397151d == false) goto L5;
        int r102 = 1231;
    L7:
        return r101 + r102;
    L5:
        r102 = 1237;
        goto L7
    }

    public final String toString() {
        return "ProactiveAllPageSnapshot(batchId=" + this.f397148a + ", dayHeaders=" + this.f397149b + ", todayFirstPage=" + this.f397150c + ", todayHasNext=" + this.f397151d + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeLong(this.f397148a);
        r100.writeInt(this.f397149b.size());
        Iterator<T> r102 = this.f397149b.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((ProactiveDayHeaderDto) r102.next()).writeToParcel(r100, r101);
        goto L4
    L6:
        r100.writeInt(this.f397150c.size());
        Iterator<T> r103 = this.f397150c.iterator();
    L8:
        if (r103.hasNext() == false) goto L10;
        ((ProactiveRecommendationDto) r103.next()).writeToParcel(r100, r101);
        goto L8
    L10:
        r100.writeInt(this.f397151d ? 1 : 0);
    }

    public ProactiveAllPageSnapshot(long r100, List<ProactiveDayHeaderDto> r101, List<ProactiveRecommendationDto> r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r101, "dayHeaders");
        Intrinsics.checkNotNullParameter(r102, "todayFirstPage");
        this.f397148a = r100;
        this.f397149b = r101;
        this.f397150c = r102;
        this.f397151d = r103;
    }
}
