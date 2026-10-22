package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\"\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002BY\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u000b\u0010$\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010'\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010(\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001aJb\u0010+\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010,J\t\u0010-\u001a\u00020\fHÖ\u0001J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u000101HÖ\u0003J\t\u00102\u001a\u00020\fHÖ\u0001J\u0012\u00103\u001a\u00020\u00012\b\u00104\u001a\u0004\u0018\u000101H\u0016J\t\u00105\u001a\u00020\u0004HÖ\u0001J\u0019\u00106\u001a\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\fHÖ\u0001R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000f\"\u0004\b\u001f\u0010\u0011R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u000f\"\u0004\b!\u0010\u0011R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\"\u0010\u0015\"\u0004\b#\u0010\u0017¨\u0006;"}, d2 = {"Lcom/obric/capabilitykit/common/intent/MessagesSearchParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "query", "", "caller", "startTimestamp", "", "endTimestamp", "messageStatusType", "content", "maxCount", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getCaller", "()Ljava/lang/String;", "setCaller", "(Ljava/lang/String;)V", "getContent", "setContent", "getEndTimestamp", "()Ljava/lang/Long;", "setEndTimestamp", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getMaxCount", "()Ljava/lang/Integer;", "setMaxCount", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getMessageStatusType", "setMessageStatusType", "getQuery", "setQuery", "getStartTimestamp", "setStartTimestamp", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/obric/capabilitykit/common/intent/MessagesSearchParams;", "describeContents", "equals", "", "other", "", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MessagesSearchParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<MessagesSearchParams> CREATOR = null;
    private String caller;
    private String content;
    private Long endTimestamp;
    private Integer maxCount;
    private String messageStatusType;
    private String query;
    private Long startTimestamp;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<MessagesSearchParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final MessagesSearchParams createFromParcel(Parcel r110) {
            int r100 = r110.readInt();
            Intrinsics.checkNotNullParameter(r110, "parcel");
            String r101 = r110.readString();
            String r102 = r110.readString();
            if (r110.readInt() != 0) goto L5;
            Long r103 = null;
        L7:
            if (r110.readInt() != 0) goto L9;
            Long r104 = null;
        L10:
            String r105 = r110.readString();
            String r106 = r110.readString();
            if (r110.readInt() != 0) goto L13;
            Integer r111 = null;
        L14:
            MessagesSearchParams r107 = new MessagesSearchParams(r101, r102, r103, r104, r105, r106, r111);
            int r108 = Math.min(r100, 0);
            ClassLoader r109 = a.class.getClassLoader();
            int r112 = 1;
        L15:
            if (r112 > r108) goto L17;
            r112 = r112 + 1;
        L17:
            if (r112 > r100) goto L19;
            joa.a.d(r110, r109);
            r112 = r112 + 1;
            goto L17
        L19:
            return r107;
        L13:
            r111 = Integer.valueOf(r110.readInt());
            goto L14
        L9:
            r104 = Long.valueOf(r110.readLong());
            goto L10
        L5:
            r103 = Long.valueOf(r110.readLong());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final MessagesSearchParams[] newArray(int r100) {
            return new MessagesSearchParams[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public MessagesSearchParams() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ MessagesSearchParams copy$default(MessagesSearchParams r100, String r101, String r102, Long r103, Long r104, String r110, String r111, Integer r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.query;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.caller;
    L8:
        String r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.startTimestamp;
    L11:
        Long r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.endTimestamp;
    L14:
        Long r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.messageStatusType;
    L17:
        String r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.content;
    L20:
        String r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.maxCount;
    L23:
        String r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final String component1() {
        return this.query;
    }

    public final String component2() {
        return this.caller;
    }

    public final Long component3() {
        return this.startTimestamp;
    }

    public final Long component4() {
        return this.endTimestamp;
    }

    public final String component5() {
        return this.messageStatusType;
    }

    public final String component6() {
        return this.content;
    }

    public final Integer component7() {
        return this.maxCount;
    }

    public final MessagesSearchParams copy(String r110, String r111, Long r112, Long r113, String r114, String r115, Integer r116) {
        return new MessagesSearchParams(r110, r111, r112, r113, r114, r115, r116);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MessagesSearchParams) == true) goto L8;
        return false;
    L8:
        MessagesSearchParams r101 = (MessagesSearchParams) r100;
        if (Intrinsics.areEqual(this.query, r101.query) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.caller, r101.caller) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.startTimestamp, r101.startTimestamp) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.endTimestamp, r101.endTimestamp) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.messageStatusType, r101.messageStatusType) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.maxCount, r101.maxCount) == true) goto L29;
        return false;
    L29:
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
        String r104 = this.caller;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.startTimestamp;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.endTimestamp;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.messageStatusType;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.content;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.maxCount;
        if (r119 == null) goto L31;
        r101 = r119.hashCode();
    L31:
        return r118 + r101;
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
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
        return "MessagesSearchParams(query=" + this.query + ", caller=" + this.caller + ", startTimestamp=" + this.startTimestamp + ", endTimestamp=" + this.endTimestamp + ", messageStatusType=" + this.messageStatusType + ", content=" + this.content + ", maxCount=" + this.maxCount + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        int r102 = 0;
        r100.writeInt(0);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        r100.writeString(this.query);
        r100.writeString(this.caller);
        Long r103 = this.startTimestamp;
        if (r103 != null) goto L5;
        r100.writeInt(0);
    L6:
        Long r104 = this.endTimestamp;
        if (r104 != null) goto L9;
        r100.writeInt(0);
    L10:
        r100.writeString(this.messageStatusType);
        r100.writeString(this.content);
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

    public final String getCaller() {
        return this.caller;
    }

    public final String getContent() {
        return this.content;
    }

    public final Long getEndTimestamp() {
        return this.endTimestamp;
    }

    public final Integer getMaxCount() {
        return this.maxCount;
    }

    public final String getMessageStatusType() {
        return this.messageStatusType;
    }

    public final String getQuery() {
        return this.query;
    }

    public final Long getStartTimestamp() {
        return this.startTimestamp;
    }

    public IntentParams mergeParams(Object r110) {
        if ((r110 instanceof MessagesSearchParams) == true) goto L5;
        return this;
    L5:
        String r100 = this.query;
        if (r100 != null) goto L8;
        r100 = ((MessagesSearchParams) r110).query;
    L8:
        String r101 = r100;
        String r102 = this.caller;
        if (r102 != null) goto L11;
        r102 = ((MessagesSearchParams) r110).caller;
    L11:
        String r103 = r102;
        Long r104 = this.startTimestamp;
        if (r104 != null) goto L14;
        r104 = ((MessagesSearchParams) r110).startTimestamp;
    L14:
        Long r105 = r104;
        Long r106 = this.endTimestamp;
        if (r106 != null) goto L17;
        r106 = ((MessagesSearchParams) r110).endTimestamp;
    L17:
        Long r107 = r106;
        String r108 = this.messageStatusType;
        if (r108 != null) goto L20;
        r108 = ((MessagesSearchParams) r110).messageStatusType;
    L20:
        String r109 = r108;
        String r111 = this.content;
        if (r111 != null) goto L23;
        r111 = ((MessagesSearchParams) r110).content;
    L23:
        String r112 = r111;
        Integer r113 = this.maxCount;
        if (r113 != null) goto L26;
        Integer r114 = ((MessagesSearchParams) r110).maxCount;
    L28:
        return new MessagesSearchParams(r101, r103, r105, r107, r109, r112, r114);
    L26:
        r114 = r113;
        goto L28
    }

    public final void setCaller(String r100) {
        this.caller = r100;
    }

    public final void setContent(String r100) {
        this.content = r100;
    }

    public final void setEndTimestamp(Long r100) {
        this.endTimestamp = r100;
    }

    public final void setMaxCount(Integer r100) {
        this.maxCount = r100;
    }

    public final void setMessageStatusType(String r100) {
        this.messageStatusType = r100;
    }

    public final void setQuery(String r100) {
        this.query = r100;
    }

    public final void setStartTimestamp(Long r100) {
        this.startTimestamp = r100;
    }

    public MessagesSearchParams(String r100, String r101, Long r102, Long r103, String r104, String r105, Integer r106) {
        this.query = r100;
        this.caller = r101;
        this.startTimestamp = r102;
        this.endTimestamp = r103;
        this.messageStatusType = r104;
        this.content = r105;
        this.maxCount = r106;
    }

    public /* synthetic */ MessagesSearchParams(String r100, String r101, Long r102, Long r110, String r111, String r112, Integer r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 1) == 0) goto L5;
        String r116 = null;
    L7:
        if ((r114 & 2) == 0) goto L9;
        String r103 = null;
    L11:
        if ((r114 & 4) == 0) goto L13;
        Long r104 = null;
    L15:
        if ((r114 & 8) == 0) goto L17;
        Long r105 = null;
    L19:
        if ((r114 & 16) == 0) goto L21;
        String r106 = null;
    L23:
        if ((r114 & 32) == 0) goto L25;
        String r107 = null;
    L27:
        if ((r114 & 64) == 0) goto L29;
        Integer r117 = null;
    L30:
        this(r116, r103, r104, r105, r106, r107, r117);
        return;
    L29:
        r117 = r113;
        goto L30
    L25:
        r107 = r112;
        goto L27
    L21:
        r106 = r111;
        goto L23
    L17:
        r105 = r110;
        goto L19
    L13:
        r104 = r102;
        goto L15
    L9:
        r103 = r101;
        goto L11
    L5:
        r116 = r100;
        goto L7
    }
}
