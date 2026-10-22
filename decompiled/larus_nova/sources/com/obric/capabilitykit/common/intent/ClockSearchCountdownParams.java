package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002BA\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010 \u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010!\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0012JJ\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010$J\t\u0010%\u001a\u00020\nHÖ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020\nHÖ\u0001J\u0012\u0010+\u001a\u00020\u00012\b\u0010,\u001a\u0004\u0018\u00010)H\u0016J\t\u0010-\u001a\u00020\u0004HÖ\u0001J\u0019\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\nHÖ\u0001R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u001c\u0010\r\"\u0004\b\u001d\u0010\u000f¨\u00063"}, d2 = {"Lcom/obric/capabilitykit/common/intent/ClockSearchCountdownParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "query", "", "startTimestamp", "", "endTimestamp", "name", "maxCount", "", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;)V", "getEndTimestamp", "()Ljava/lang/Long;", "setEndTimestamp", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getMaxCount", "()Ljava/lang/Integer;", "setMaxCount", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getQuery", "setQuery", "getStartTimestamp", "setStartTimestamp", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;)Lcom/obric/capabilitykit/common/intent/ClockSearchCountdownParams;", "describeContents", "equals", "", "other", "", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ClockSearchCountdownParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<ClockSearchCountdownParams> CREATOR = null;
    private Long endTimestamp;
    private Integer maxCount;
    private String name;
    private String query;
    private Long startTimestamp;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<ClockSearchCountdownParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ClockSearchCountdownParams createFromParcel(Parcel r110) {
            int r100 = r110.readInt();
            Intrinsics.checkNotNullParameter(r110, "parcel");
            String r101 = r110.readString();
            if (r110.readInt() != 0) goto L5;
            Long r102 = null;
        L7:
            if (r110.readInt() != 0) goto L9;
            Long r103 = null;
        L10:
            String r104 = r110.readString();
            if (r110.readInt() != 0) goto L13;
            Integer r105 = null;
        L14:
            ClockSearchCountdownParams r106 = new ClockSearchCountdownParams(r101, r102, r103, r104, r105);
            int r107 = Math.min(r100, 0);
            ClassLoader r108 = a.class.getClassLoader();
            int r109 = 1;
        L15:
            if (r109 > r107) goto L17;
            r109 = r109 + 1;
        L17:
            if (r109 > r100) goto L19;
            joa.a.d(r110, r108);
            r109 = r109 + 1;
            goto L17
        L19:
            return r106;
        L13:
            r105 = Integer.valueOf(r110.readInt());
            goto L14
        L9:
            r103 = Long.valueOf(r110.readLong());
            goto L10
        L5:
            r102 = Long.valueOf(r110.readLong());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final ClockSearchCountdownParams[] newArray(int r100) {
            return new ClockSearchCountdownParams[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public ClockSearchCountdownParams() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ ClockSearchCountdownParams copy$default(ClockSearchCountdownParams r100, String r101, Long r102, Long r103, String r104, Integer r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.query;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.startTimestamp;
    L8:
        Long r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.endTimestamp;
    L11:
        Long r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.name;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.maxCount;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.query;
    }

    public final Long component2() {
        return this.startTimestamp;
    }

    public final Long component3() {
        return this.endTimestamp;
    }

    public final String component4() {
        return this.name;
    }

    public final Integer component5() {
        return this.maxCount;
    }

    public final ClockSearchCountdownParams copy(String r100, Long r101, Long r110, String r111, Integer r112) {
        return new ClockSearchCountdownParams(r100, r101, r110, r111, r112);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ClockSearchCountdownParams) == true) goto L8;
        return false;
    L8:
        ClockSearchCountdownParams r101 = (ClockSearchCountdownParams) r100;
        if (Intrinsics.areEqual(this.query, r101.query) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.startTimestamp, r101.startTimestamp) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.endTimestamp, r101.endTimestamp) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.maxCount, r101.maxCount) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public String getSubActionValue() {
        return null;
    }

    public int hashCode() {
        String r100 = this.query;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.startTimestamp;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.endTimestamp;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.name;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.maxCount;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public boolean isParamsCompleted() {
        return true;
    }

    public String toString() {
        return "ClockSearchCountdownParams(query=" + this.query + ", startTimestamp=" + this.startTimestamp + ", endTimestamp=" + this.endTimestamp + ", name=" + this.name + ", maxCount=" + this.maxCount + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        int r102 = 0;
        r100.writeInt(0);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        r100.writeString(this.query);
        Long r103 = this.startTimestamp;
        if (r103 != null) goto L5;
        r100.writeInt(0);
    L6:
        Long r104 = this.endTimestamp;
        if (r104 != null) goto L9;
        r100.writeInt(0);
    L10:
        r100.writeString(this.name);
        Integer r105 = this.maxCount;
        if (r105 == null) goto L14;
        r100.writeInt(1);
        r102 = r105.intValue();
    L14:
        r100.writeInt(r102);
        return;
    L9:
        r100.writeInt(1);
        r100.writeLong(r104.longValue());
        goto L10
    L5:
        r100.writeInt(1);
        r100.writeLong(r103.longValue());
        goto L6
    }

    public final Long getEndTimestamp() {
        return this.endTimestamp;
    }

    public final Integer getMaxCount() {
        return this.maxCount;
    }

    public final String getName() {
        return this.name;
    }

    public final String getQuery() {
        return this.query;
    }

    public final Long getStartTimestamp() {
        return this.startTimestamp;
    }

    public IntentParams mergeParams(Object r100) {
        if ((r100 instanceof ClockSearchCountdownParams) == true) goto L5;
        return this;
    L5:
        String r101 = this.query;
        if (r101 != null) goto L8;
        r101 = ((ClockSearchCountdownParams) r100).query;
    L8:
        String r102 = r101;
        Long r103 = this.startTimestamp;
        if (r103 != null) goto L11;
        r103 = ((ClockSearchCountdownParams) r100).startTimestamp;
    L11:
        Long r104 = r103;
        Long r105 = this.endTimestamp;
        if (r105 != null) goto L14;
        r105 = ((ClockSearchCountdownParams) r100).endTimestamp;
    L14:
        Long r106 = r105;
        String r107 = this.name;
        if (r107 != null) goto L17;
        r107 = ((ClockSearchCountdownParams) r100).name;
    L17:
        String r108 = r107;
        Integer r109 = this.maxCount;
        if (r109 != null) goto L20;
        Integer r110 = ((ClockSearchCountdownParams) r100).maxCount;
    L22:
        return new ClockSearchCountdownParams(r102, r104, r106, r108, r110);
    L20:
        r110 = r109;
        goto L22
    }

    public final void setEndTimestamp(Long r100) {
        this.endTimestamp = r100;
    }

    public final void setMaxCount(Integer r100) {
        this.maxCount = r100;
    }

    public final void setName(String r100) {
        this.name = r100;
    }

    public final void setQuery(String r100) {
        this.query = r100;
    }

    public final void setStartTimestamp(Long r100) {
        this.startTimestamp = r100;
    }

    public ClockSearchCountdownParams(String r100, Long r101, Long r102, String r103, Integer r104) {
        this.query = r100;
        this.startTimestamp = r101;
        this.endTimestamp = r102;
        this.name = r103;
        this.maxCount = r104;
    }

    public /* synthetic */ ClockSearchCountdownParams(String r100, Long r101, Long r102, String r103, Integer r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        String r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        Long r105 = null;
    L11:
        if ((r110 & 4) == 0) goto L13;
        Long r106 = null;
    L15:
        if ((r110 & 8) == 0) goto L17;
        String r107 = null;
    L19:
        if ((r110 & 16) == 0) goto L21;
        Integer r113 = null;
    L22:
        this(r112, r105, r106, r107, r113);
        return;
    L21:
        r113 = r104;
        goto L22
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
