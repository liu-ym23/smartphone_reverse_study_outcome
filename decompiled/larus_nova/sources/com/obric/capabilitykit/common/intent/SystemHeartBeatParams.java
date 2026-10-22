package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B5\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\tJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0004HÆ\u0003J>\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u0010\u001cJ\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\u001eHÖ\u0001J\b\u0010$\u001a\u00020 H\u0016J\u0012\u0010%\u001a\u00020\u00012\b\u0010&\u001a\u0004\u0018\u00010\"H\u0016J\t\u0010'\u001a\u00020\u0004HÖ\u0001J\u0019\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u001eHÖ\u0001R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\u0015\u0010\u000b\"\u0004\b\u0016\u0010\r¨\u0006-"}, d2 = {"Lcom/obric/capabilitykit/common/intent/SystemHeartBeatParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "questionId", "", "expiryTimestamp", "", "timeUntilNextHeartbeat", "ext", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;)V", "getExpiryTimestamp", "()Ljava/lang/Long;", "setExpiryTimestamp", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getExt", "()Ljava/lang/String;", "setExt", "(Ljava/lang/String;)V", "getQuestionId", "setQuestionId", "getTimeUntilNextHeartbeat", "setTimeUntilNextHeartbeat", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;)Lcom/obric/capabilitykit/common/intent/SystemHeartBeatParams;", "describeContents", "", "equals", "", "other", "", "hashCode", "isParamsCompleted", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SystemHeartBeatParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<SystemHeartBeatParams> CREATOR = null;
    private Long expiryTimestamp;
    private String ext;
    private String questionId;
    private Long timeUntilNextHeartbeat;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<SystemHeartBeatParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SystemHeartBeatParams createFromParcel(Parcel r100) {
            int r101 = r100.readInt();
            Intrinsics.checkNotNullParameter(r100, "parcel");
            String r102 = r100.readString();
            Long r103 = null;
            if (r100.readInt() != 0) goto L5;
            Long r104 = null;
        L7:
            if (r100.readInt() == 0) goto L10;
            r103 = Long.valueOf(r100.readLong());
        L10:
            SystemHeartBeatParams r105 = new SystemHeartBeatParams(r102, r104, r103, r100.readString());
            int r106 = Math.min(r101, 0);
            ClassLoader r107 = a.class.getClassLoader();
            int r108 = 1;
        L11:
            if (r108 > r106) goto L13;
            r108 = r108 + 1;
        L13:
            if (r108 > r101) goto L15;
            joa.a.d(r100, r107);
            r108 = r108 + 1;
            goto L13
        L15:
            return r105;
        L5:
            r104 = Long.valueOf(r100.readLong());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final SystemHeartBeatParams[] newArray(int r100) {
            return new SystemHeartBeatParams[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public SystemHeartBeatParams() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ SystemHeartBeatParams copy$default(SystemHeartBeatParams r100, String r101, Long r102, Long r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.questionId;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.expiryTimestamp;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.timeUntilNextHeartbeat;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.ext;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.questionId;
    }

    public final Long component2() {
        return this.expiryTimestamp;
    }

    public final Long component3() {
        return this.timeUntilNextHeartbeat;
    }

    public final String component4() {
        return this.ext;
    }

    public final SystemHeartBeatParams copy(String r100, Long r101, Long r102, String r103) {
        return new SystemHeartBeatParams(r100, r101, r102, r103);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SystemHeartBeatParams) == true) goto L8;
        return false;
    L8:
        SystemHeartBeatParams r101 = (SystemHeartBeatParams) r100;
        if (Intrinsics.areEqual(this.questionId, r101.questionId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.expiryTimestamp, r101.expiryTimestamp) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.timeUntilNextHeartbeat, r101.timeUntilNextHeartbeat) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.ext, r101.ext) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public String getSubActionValue() {
        return null;
    }

    public int hashCode() {
        String r100 = this.questionId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.expiryTimestamp;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.timeUntilNextHeartbeat;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.ext;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
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

    public String toString() {
        return "SystemHeartBeatParams(questionId=" + this.questionId + ", expiryTimestamp=" + this.expiryTimestamp + ", timeUntilNextHeartbeat=" + this.timeUntilNextHeartbeat + ", ext=" + this.ext + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(0);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        r100.writeString(this.questionId);
        Long r102 = this.expiryTimestamp;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        Long r103 = this.timeUntilNextHeartbeat;
        if (r103 != null) goto L9;
        r100.writeInt(0);
    L10:
        r100.writeString(this.ext);
        return;
    L9:
        r100.writeInt(1);
        r100.writeLong(r103.longValue());
        goto L10
    L5:
        r100.writeInt(1);
        r100.writeLong(r102.longValue());
        goto L6
    }

    public boolean isParamsCompleted() {
        if (this.expiryTimestamp != null) goto L5;
    L7:
        return false;
    L5:
        if (this.timeUntilNextHeartbeat == null) goto L7;
        return true;
    }

    public final Long getExpiryTimestamp() {
        return this.expiryTimestamp;
    }

    public final String getExt() {
        return this.ext;
    }

    public final String getQuestionId() {
        return this.questionId;
    }

    public final Long getTimeUntilNextHeartbeat() {
        return this.timeUntilNextHeartbeat;
    }

    public IntentParams mergeParams(Object r100) {
        if ((r100 instanceof SystemHeartBeatParams) == true) goto L5;
        return this;
    L5:
        String r101 = this.questionId;
        if (r101 != null) goto L8;
        r101 = ((SystemHeartBeatParams) r100).questionId;
    L8:
        Long r102 = this.expiryTimestamp;
        if (r102 != null) goto L11;
        r102 = ((SystemHeartBeatParams) r100).expiryTimestamp;
    L11:
        Long r103 = this.timeUntilNextHeartbeat;
        if (r103 != null) goto L14;
        r103 = ((SystemHeartBeatParams) r100).timeUntilNextHeartbeat;
    L14:
        String r104 = this.ext;
        if (r104 != null) goto L18;
        r104 = ((SystemHeartBeatParams) r100).ext;
    L18:
        return new SystemHeartBeatParams(r101, r102, r103, r104);
    }

    public final void setExpiryTimestamp(Long r100) {
        this.expiryTimestamp = r100;
    }

    public final void setExt(String r100) {
        this.ext = r100;
    }

    public final void setQuestionId(String r100) {
        this.questionId = r100;
    }

    public final void setTimeUntilNextHeartbeat(Long r100) {
        this.timeUntilNextHeartbeat = r100;
    }

    public SystemHeartBeatParams(String r100, Long r101, Long r102, String r103) {
        this.questionId = r100;
        this.expiryTimestamp = r101;
        this.timeUntilNextHeartbeat = r102;
        this.ext = r103;
    }

    public /* synthetic */ SystemHeartBeatParams(String r100, Long r101, Long r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
