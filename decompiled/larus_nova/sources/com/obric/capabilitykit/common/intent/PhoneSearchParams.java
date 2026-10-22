package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b(\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002Bq\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ\u000b\u0010*\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u0010.\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u0010/\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u00102\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010 Jz\u00103\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u00104J\t\u00105\u001a\u00020\u000eHÖ\u0001J\u0013\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u000109HÖ\u0003J\t\u0010:\u001a\u00020\u000eHÖ\u0001J\u0012\u0010;\u001a\u00020\u00012\b\u0010<\u001a\u0004\u0018\u000109H\u0016J\t\u0010=\u001a\u00020\u0004HÖ\u0001J\u0019\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\u000eHÖ\u0001R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\u001e\u0010\t\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0011\"\u0004\b%\u0010\u0013R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b&\u0010\u001b\"\u0004\b'\u0010\u001dR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0011\"\u0004\b)\u0010\u0013¨\u0006C"}, d2 = {"Lcom/obric/capabilitykit/common/intent/PhoneSearchParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "query", "", "contactName", "telephone", "startTimestamp", "", "endTimestamp", "callType", "callConnectionType", "content", "maxCount", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getCallConnectionType", "()Ljava/lang/String;", "setCallConnectionType", "(Ljava/lang/String;)V", "getCallType", "setCallType", "getContactName", "setContactName", "getContent", "setContent", "getEndTimestamp", "()Ljava/lang/Long;", "setEndTimestamp", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getMaxCount", "()Ljava/lang/Integer;", "setMaxCount", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getQuery", "setQuery", "getStartTimestamp", "setStartTimestamp", "getTelephone", "setTelephone", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/obric/capabilitykit/common/intent/PhoneSearchParams;", "describeContents", "equals", "", "other", "", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PhoneSearchParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<PhoneSearchParams> CREATOR = null;
    private String callConnectionType;
    private String callType;
    private String contactName;
    private String content;
    private Long endTimestamp;
    private Integer maxCount;
    private String query;
    private Long startTimestamp;
    private String telephone;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<PhoneSearchParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final PhoneSearchParams createFromParcel(Parcel r110) {
            int r100 = r110.readInt();
            Intrinsics.checkNotNullParameter(r110, "parcel");
            String r101 = r110.readString();
            String r102 = r110.readString();
            String r103 = r110.readString();
            if (r110.readInt() != 0) goto L5;
            Long r104 = null;
        L7:
            if (r110.readInt() != 0) goto L9;
            Long r105 = null;
        L10:
            String r106 = r110.readString();
            String r111 = r110.readString();
            String r112 = r110.readString();
            if (r110.readInt() != 0) goto L13;
            Integer r113 = null;
        L14:
            PhoneSearchParams r107 = new PhoneSearchParams(r101, r102, r103, r104, r105, r106, r111, r112, r113);
            int r108 = Math.min(r100, 0);
            ClassLoader r109 = a.class.getClassLoader();
            int r114 = 1;
        L15:
            if (r114 > r108) goto L17;
            r114 = r114 + 1;
        L17:
            if (r114 > r100) goto L19;
            joa.a.d(r110, r109);
            r114 = r114 + 1;
            goto L17
        L19:
            return r107;
        L13:
            r113 = Integer.valueOf(r110.readInt());
            goto L14
        L9:
            r105 = Long.valueOf(r110.readLong());
            goto L10
        L5:
            r104 = Long.valueOf(r110.readLong());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final PhoneSearchParams[] newArray(int r100) {
            return new PhoneSearchParams[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public PhoneSearchParams() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    public static /* synthetic */ PhoneSearchParams copy$default(PhoneSearchParams r110, String r111, String r112, String r113, Long r114, Long r115, String r116, String r117, String r118, Integer r119, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        String r100 = r110.query;
    L7:
        if ((r210 & 2) == 0) goto L9;
        String r101 = r110.contactName;
    L11:
        if ((r210 & 4) == 0) goto L13;
        String r102 = r110.telephone;
    L15:
        if ((r210 & 8) == 0) goto L17;
        Long r103 = r110.startTimestamp;
    L19:
        if ((r210 & 16) == 0) goto L21;
        Long r104 = r110.endTimestamp;
    L23:
        if ((r210 & 32) == 0) goto L25;
        String r105 = r110.callType;
    L27:
        if ((r210 & 64) == 0) goto L29;
        String r106 = r110.callConnectionType;
    L31:
        if ((r210 & 128) == 0) goto L33;
        String r107 = r110.content;
    L35:
        if ((r210 & 256) == 0) goto L37;
        Integer r108 = r110.maxCount;
    L39:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r108);
    L37:
        r108 = r119;
        goto L39
    L33:
        r107 = r118;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.query;
    }

    public final String component2() {
        return this.contactName;
    }

    public final String component3() {
        return this.telephone;
    }

    public final Long component4() {
        return this.startTimestamp;
    }

    public final Long component5() {
        return this.endTimestamp;
    }

    public final String component6() {
        return this.callType;
    }

    public final String component7() {
        return this.callConnectionType;
    }

    public final String component8() {
        return this.content;
    }

    public final Integer component9() {
        return this.maxCount;
    }

    public final PhoneSearchParams copy(String r110, String r111, String r112, Long r113, Long r114, String r115, String r116, String r117, Integer r210) {
        return new PhoneSearchParams(r110, r111, r112, r113, r114, r115, r116, r117, r210);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PhoneSearchParams) == true) goto L8;
        return false;
    L8:
        PhoneSearchParams r101 = (PhoneSearchParams) r100;
        if (Intrinsics.areEqual(this.query, r101.query) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.contactName, r101.contactName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.telephone, r101.telephone) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.startTimestamp, r101.startTimestamp) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.endTimestamp, r101.endTimestamp) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.callType, r101.callType) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.callConnectionType, r101.callConnectionType) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.maxCount, r101.maxCount) == true) goto L35;
        return false;
    L35:
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
        String r104 = this.contactName;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.telephone;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.startTimestamp;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Long r113 = this.endTimestamp;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.callType;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.callConnectionType;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.content;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Integer r125 = this.maxCount;
        if (r125 == null) goto L39;
        r101 = r125.hashCode();
    L39:
        return r124 + r101;
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
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
        return "PhoneSearchParams(query=" + this.query + ", contactName=" + this.contactName + ", telephone=" + this.telephone + ", startTimestamp=" + this.startTimestamp + ", endTimestamp=" + this.endTimestamp + ", callType=" + this.callType + ", callConnectionType=" + this.callConnectionType + ", content=" + this.content + ", maxCount=" + this.maxCount + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        int r102 = 0;
        r100.writeInt(0);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        r100.writeString(this.query);
        r100.writeString(this.contactName);
        r100.writeString(this.telephone);
        Long r103 = this.startTimestamp;
        if (r103 != null) goto L5;
        r100.writeInt(0);
    L6:
        Long r104 = this.endTimestamp;
        if (r104 != null) goto L9;
        r100.writeInt(0);
    L10:
        r100.writeString(this.callType);
        r100.writeString(this.callConnectionType);
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

    public final String getCallConnectionType() {
        return this.callConnectionType;
    }

    public final String getCallType() {
        return this.callType;
    }

    public final String getContactName() {
        return this.contactName;
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

    public final String getQuery() {
        return this.query;
    }

    public final Long getStartTimestamp() {
        return this.startTimestamp;
    }

    public final String getTelephone() {
        return this.telephone;
    }

    public IntentParams mergeParams(Object r110) {
        if ((r110 instanceof PhoneSearchParams) == true) goto L5;
        return this;
    L5:
        String r100 = this.query;
        if (r100 != null) goto L8;
        r100 = ((PhoneSearchParams) r110).query;
    L8:
        String r101 = r100;
        String r102 = this.contactName;
        if (r102 != null) goto L11;
        r102 = ((PhoneSearchParams) r110).contactName;
    L11:
        String r103 = r102;
        String r104 = this.telephone;
        if (r104 != null) goto L14;
        r104 = ((PhoneSearchParams) r110).telephone;
    L14:
        String r105 = r104;
        Long r106 = this.startTimestamp;
        if (r106 != null) goto L17;
        r106 = ((PhoneSearchParams) r110).startTimestamp;
    L17:
        Long r107 = r106;
        Long r108 = this.endTimestamp;
        if (r108 != null) goto L20;
        r108 = ((PhoneSearchParams) r110).endTimestamp;
    L20:
        Long r109 = r108;
        String r111 = this.callType;
        if (r111 != null) goto L23;
        r111 = ((PhoneSearchParams) r110).callType;
    L23:
        String r112 = r111;
        String r113 = this.callConnectionType;
        if (r113 != null) goto L26;
        r113 = ((PhoneSearchParams) r110).callConnectionType;
    L26:
        String r114 = r113;
        String r115 = this.content;
        if (r115 != null) goto L29;
        r115 = ((PhoneSearchParams) r110).content;
    L29:
        String r116 = r115;
        Integer r117 = this.maxCount;
        if (r117 != null) goto L32;
        Integer r118 = ((PhoneSearchParams) r110).maxCount;
    L34:
        return new PhoneSearchParams(r101, r103, r105, r107, r109, r112, r114, r116, r118);
    L32:
        r118 = r117;
        goto L34
    }

    public final void setCallConnectionType(String r100) {
        this.callConnectionType = r100;
    }

    public final void setCallType(String r100) {
        this.callType = r100;
    }

    public final void setContactName(String r100) {
        this.contactName = r100;
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

    public final void setQuery(String r100) {
        this.query = r100;
    }

    public final void setStartTimestamp(Long r100) {
        this.startTimestamp = r100;
    }

    public final void setTelephone(String r100) {
        this.telephone = r100;
    }

    public PhoneSearchParams(String r100, String r101, String r102, Long r103, Long r104, String r105, String r106, String r107, Integer r108) {
        this.query = r100;
        this.contactName = r101;
        this.telephone = r102;
        this.startTimestamp = r103;
        this.endTimestamp = r104;
        this.callType = r105;
        this.callConnectionType = r106;
        this.content = r107;
        this.maxCount = r108;
    }

    public /* synthetic */ PhoneSearchParams(String r110, String r111, String r112, Long r113, Long r114, String r115, String r116, String r117, Integer r118, int r210, DefaultConstructorMarker r211) {
        Integer r100 = null;
        if ((r210 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r210 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r210 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r210 & 8) == 0) goto L17;
        Long r104 = null;
    L19:
        if ((r210 & 16) == 0) goto L21;
        Long r105 = null;
    L23:
        if ((r210 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r210 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r210 & 128) == 0) goto L33;
        String r108 = null;
    L35:
        if ((r210 & 256) != 0) goto L38;
        r100 = r118;
    L38:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r100);
        return;
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
