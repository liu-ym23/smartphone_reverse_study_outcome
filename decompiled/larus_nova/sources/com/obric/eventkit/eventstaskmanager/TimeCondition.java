package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J)\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\t\u0010\u0014\u001a\u00020\u0007HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0007HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\n¨\u0006 "}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/TimeCondition;", "Lcom/obric/eventkit/eventstaskmanager/Condition;", "Landroid/os/Parcelable;", "start", "", "end", VideoThumbInfo.KEY_INTERVAL, "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getEnd", "()Ljava/lang/String;", "getInterval", "()I", "setInterval", "(I)V", "getStart", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TimeCondition implements Condition, Parcelable {
    public static final Parcelable.Creator<TimeCondition> CREATOR = null;
    private final String end;
    private int interval;
    private final String start;

    public static final class a implements Parcelable.Creator<TimeCondition> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final TimeCondition createFromParcel(Parcel r100) {
            int r101 = r100.readInt();
            Intrinsics.checkNotNullParameter(r100, "parcel");
            TimeCondition r102 = new TimeCondition(r100.readString(), r100.readString(), r100.readInt());
            int r103 = Math.min(r101, 0);
            ClassLoader r104 = a.class.getClassLoader();
            int r105 = 1;
        L3:
            if (r105 > r103) goto L5;
            r105 = r105 + 1;
        L5:
            if (r105 > r101) goto L7;
            joa.a.d(r100, r104);
            r105 = r105 + 1;
            goto L5
        L7:
            return r102;
        }

        @Override // android.os.Parcelable.Creator
        public final TimeCondition[] newArray(int r100) {
            return new TimeCondition[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public TimeCondition(String r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "start");
        this.start = r100;
        this.end = r101;
        this.interval = r102;
    }

    public /* synthetic */ TimeCondition(String r100, String r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        this(r100, r101, r102);
    }

    public static /* synthetic */ TimeCondition copy$default(TimeCondition r100, String r101, String r102, int r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.start;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.end;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.interval;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.start;
    }

    public final String component2() {
        return this.end;
    }

    public final int component3() {
        return this.interval;
    }

    public final TimeCondition copy(String r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "start");
        return new TimeCondition(r100, r101, r102);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TimeCondition) == true) goto L8;
        return false;
    L8:
        TimeCondition r101 = (TimeCondition) r100;
        if (Intrinsics.areEqual(this.start, r101.start) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.end, r101.end) == true) goto L15;
        return false;
    L15:
        if (this.interval == r101.interval) goto L17;
        return false;
    L17:
        return true;
    }

    public final String getEnd() {
        return this.end;
    }

    public final int getInterval() {
        return this.interval;
    }

    public final String getStart() {
        return this.start;
    }

    public int hashCode() {
        int r100 = this.start.hashCode() * 31;
        String r101 = this.end;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((r100 + r102) * 31) + this.interval;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final void setInterval(int r100) {
        this.interval = r100;
    }

    public String toString() {
        return "TimeCondition(start=" + this.start + ", end=" + this.end + ", interval=" + this.interval + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(0);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        r100.writeString(this.start);
        r100.writeString(this.end);
        r100.writeInt(this.interval);
    }
}
