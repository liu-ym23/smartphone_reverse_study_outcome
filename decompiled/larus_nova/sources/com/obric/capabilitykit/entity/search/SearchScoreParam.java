package com.obric.capabilitykit.entity.search;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.camera.video.AudioStats;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J\t\u0010\u000f\u001a\u00020\bHÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0018\u001a\u00020\bHÖ\u0001J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0012H\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001d"}, d2 = {"Lcom/obric/capabilitykit/entity/search/SearchScoreParam;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "value", "", "type", "", "(DLjava/lang/String;)V", "getType", "()Ljava/lang/String;", "getValue", "()D", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SearchScoreParam implements Parcelable {
    public static final a CREATOR = null;
    private final String type;
    private final double value;

    public static final class a implements Parcelable.Creator<SearchScoreParam> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SearchScoreParam createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new SearchScoreParam(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final SearchScoreParam[] newArray(int r100) {
            return new SearchScoreParam[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public SearchScoreParam() {
        this(AudioStats.AUDIO_AMPLITUDE_NONE, null, 3, null);
    }

    public SearchScoreParam(double r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "type");
        this.value = r100;
        this.type = r101;
    }

    public /* synthetic */ SearchScoreParam(double r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = AudioStats.AUDIO_AMPLITUDE_NONE;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = "";
    L8:
        this(r100, r101);
    }

    public SearchScoreParam(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        double r101 = r100.readDouble();
        String r102 = r100.readString();
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        this(r101, r102);
    }

    public static /* synthetic */ SearchScoreParam copy$default(SearchScoreParam r100, double r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.value;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.type;
    L9:
        return r100.copy(r101, r102);
    }

    public final double component1() {
        return this.value;
    }

    public final String component2() {
        return this.type;
    }

    public final SearchScoreParam copy(double r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "type");
        return new SearchScoreParam(r100, r101);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SearchScoreParam) == true) goto L8;
        return false;
    L8:
        SearchScoreParam r101 = (SearchScoreParam) r100;
        if (Double.compare(this.value, r101.value) == 0) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final String getType() {
        return this.type;
    }

    public final double getValue() {
        return this.value;
    }

    public int hashCode() {
        long r100 = Double.doubleToLongBits(this.value);
        return (((int) (r100 ^ (r100 >>> 32))) * 31) + this.type.hashCode();
    }

    public String toString() {
        return "SearchScoreParam(value=" + this.value + ", type=" + this.type + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeDouble(this.value);
        r100.writeString(this.type);
    }
}
