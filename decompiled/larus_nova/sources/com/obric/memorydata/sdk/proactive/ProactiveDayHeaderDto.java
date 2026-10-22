package com.obric.memorydata.sdk.proactive;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\b\u0010\fJ\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0007H\u0016J\b\u0010\u0017\u001a\u00020\u0007H\u0016J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J'\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u0007HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006#"}, d2 = {"Lcom/obric/memorydata/sdk/proactive/ProactiveDayHeaderDto;", "Landroid/os/Parcelable;", "dayKey", "", "dayStartMillis", "", "count", "", "<init>", "(Ljava/lang/String;JI)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getDayKey", "()Ljava/lang/String;", "getDayStartMillis", "()J", "getCount", "()I", "writeToParcel", "", "dest", "flags", "describeContents", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "CREATOR", "cocreationreview_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ProactiveDayHeaderDto implements Parcelable {
    public static final a CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f397152a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f397153b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f397154c;

    public static final class a implements Parcelable.Creator<ProactiveDayHeaderDto> {
        public a() {
        }

        public static ProactiveDayHeaderDto a(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            Intrinsics.checkNotNullParameter(r100, "parcel");
            String r101 = r100.readString();
            if (r101 != null) goto L6;
            r101 = "";
        L6:
            return new ProactiveDayHeaderDto(r101, r100.readLong(), r100.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ ProactiveDayHeaderDto createFromParcel(Parcel r100) {
            return a(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final ProactiveDayHeaderDto[] newArray(int r100) {
            return new ProactiveDayHeaderDto[r100];
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
        if ((r100 instanceof ProactiveDayHeaderDto) == true) goto L8;
        return false;
    L8:
        ProactiveDayHeaderDto r101 = (ProactiveDayHeaderDto) r100;
        if (Intrinsics.areEqual(this.f397152a, r101.f397152a) == true) goto L12;
        return false;
    L12:
        if (this.f397153b == r101.f397153b) goto L15;
        return false;
    L15:
        if (this.f397154c == r101.f397154c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f397152a.hashCode() * 31;
        long r101 = this.f397153b;
        return ((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f397154c;
    }

    public final String toString() {
        return "ProactiveDayHeaderDto(dayKey=" + this.f397152a + ", dayStartMillis=" + this.f397153b + ", count=" + this.f397154c + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f397152a);
        r100.writeLong(this.f397153b);
        r100.writeInt(this.f397154c);
    }

    public ProactiveDayHeaderDto(String r100, long r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "dayKey");
        this.f397152a = r100;
        this.f397153b = r101;
        this.f397154c = r102;
    }
}
