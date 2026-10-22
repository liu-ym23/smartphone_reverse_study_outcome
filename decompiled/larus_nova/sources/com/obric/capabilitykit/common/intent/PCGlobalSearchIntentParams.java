package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b$\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002BA\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u000bJ\u000b\u0010#\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u0010%\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010&\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0004HÆ\u0003JJ\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u0010)J\t\u0010*\u001a\u00020\bHÖ\u0001J\u0013\u0010+\u001a\u00020\u00062\b\u0010,\u001a\u0004\u0018\u00010-HÖ\u0003J\t\u0010.\u001a\u00020\bHÖ\u0001J\u0012\u0010/\u001a\u00020\u00012\b\u00100\u001a\u0004\u0018\u00010-H\u0016J\t\u00101\u001a\u00020\u0004HÖ\u0001J\u0019\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\bHÖ\u0001R&\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R(\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u0017\u0012\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R&\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0018\u0010\r\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011R(\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010 \u0012\u0004\b\u001b\u0010\r\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u000f\"\u0004\b\"\u0010\u0011¨\u00067"}, d2 = {"Lcom/obric/capabilitykit/common/intent/PCGlobalSearchIntentParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "quResult", "", "needDeepSearch", "", "limitCount", "", "interactionType", "meta", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getInteractionType$annotations", "()V", "getInteractionType", "()Ljava/lang/String;", "setInteractionType", "(Ljava/lang/String;)V", "getLimitCount$annotations", "getLimitCount", "()Ljava/lang/Integer;", "setLimitCount", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getMeta$annotations", "getMeta", "setMeta", "getNeedDeepSearch$annotations", "getNeedDeepSearch", "()Ljava/lang/Boolean;", "setNeedDeepSearch", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getQuResult", "setQuResult", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/obric/capabilitykit/common/intent/PCGlobalSearchIntentParams;", "describeContents", "equals", "other", "", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PCGlobalSearchIntentParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<PCGlobalSearchIntentParams> CREATOR = null;
    String interactionType;
    Integer limitCount;
    String meta;
    Boolean needDeepSearch;
    private String quResult;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<PCGlobalSearchIntentParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final PCGlobalSearchIntentParams createFromParcel(Parcel r110) {
            int r100 = r110.readInt();
            Intrinsics.checkNotNullParameter(r110, "parcel");
            PCGlobalSearchIntentParams r101 = new PCGlobalSearchIntentParams(r110.readString(), null, null, null, null, 30, null);
            int r102 = Math.min(r100, 4);
            ClassLoader r103 = a.class.getClassLoader();
            int r104 = 1;
        L3:
            if (r104 > r102) goto L23;
            if (r104 != 1) goto L9;
            Object r105 = joa.a.c(r110, r103);
            if (r105 == null) goto L22;
            r101.needDeepSearch = (Boolean) r105;
        L22:
            r104 = r104 + 1;
            goto L3
        L9:
            if (r104 != 2) goto L14;
            Object r106 = joa.a.c(r110, r103);
            if (r106 == null) goto L22;
            r101.limitCount = (Integer) r106;
            goto L22
        L14:
            if (r104 != 3) goto L18;
            Object r107 = joa.a.c(r110, r103);
            if (r107 == null) goto L22;
            r101.interactionType = (String) r107;
            goto L22
        L18:
            if (r104 != 4) goto L22;
            Object r108 = joa.a.c(r110, r103);
            if (r108 == null) goto L22;
            r101.meta = (String) r108;
        L23:
            if (r104 > r100) goto L25;
            joa.a.d(r110, r103);
            r104 = r104 + 1;
            goto L23
        L25:
            return r101;
        }

        @Override // android.os.Parcelable.Creator
        public final PCGlobalSearchIntentParams[] newArray(int r100) {
            return new PCGlobalSearchIntentParams[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public PCGlobalSearchIntentParams() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ PCGlobalSearchIntentParams copy$default(PCGlobalSearchIntentParams r100, String r101, Boolean r102, Integer r103, String r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.quResult;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.needDeepSearch;
    L8:
        Boolean r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.limitCount;
    L11:
        Integer r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.interactionType;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.meta;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public static /* synthetic */ void getInteractionType$annotations() {
    }

    public static /* synthetic */ void getLimitCount$annotations() {
    }

    public static /* synthetic */ void getMeta$annotations() {
    }

    public static /* synthetic */ void getNeedDeepSearch$annotations() {
    }

    public final String component1() {
        return this.quResult;
    }

    public final Boolean component2() {
        return this.needDeepSearch;
    }

    public final Integer component3() {
        return this.limitCount;
    }

    public final String component4() {
        return this.interactionType;
    }

    public final String component5() {
        return this.meta;
    }

    public final PCGlobalSearchIntentParams copy(String r100, Boolean r101, Integer r110, String r111, String r112) {
        return new PCGlobalSearchIntentParams(r100, r101, r110, r111, r112);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PCGlobalSearchIntentParams) == true) goto L8;
        return false;
    L8:
        PCGlobalSearchIntentParams r101 = (PCGlobalSearchIntentParams) r100;
        if (Intrinsics.areEqual(this.quResult, r101.quResult) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.needDeepSearch, r101.needDeepSearch) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.limitCount, r101.limitCount) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.interactionType, r101.interactionType) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.meta, r101.meta) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public String getSubActionValue() {
        return null;
    }

    public int hashCode() {
        String r100 = this.quResult;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.needDeepSearch;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.limitCount;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.interactionType;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.meta;
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
        return "PCGlobalSearchIntentParams(quResult=" + this.quResult + ", needDeepSearch=" + this.needDeepSearch + ", limitCount=" + this.limitCount + ", interactionType=" + this.interactionType + ", meta=" + this.meta + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(4);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        r100.writeString(this.quResult);
        r100.writeValue(this.needDeepSearch);
        r100.writeValue(this.limitCount);
        r100.writeValue(this.interactionType);
        r100.writeValue(this.meta);
    }

    public final String getInteractionType() {
        return this.interactionType;
    }

    public final Integer getLimitCount() {
        return this.limitCount;
    }

    public final String getMeta() {
        return this.meta;
    }

    public final Boolean getNeedDeepSearch() {
        return this.needDeepSearch;
    }

    public final String getQuResult() {
        return this.quResult;
    }

    public IntentParams mergeParams(Object r100) {
        if ((r100 instanceof PCGlobalSearchIntentParams) == true) goto L5;
        return this;
    L5:
        String r101 = this.quResult;
        if (r101 != null) goto L8;
        r101 = ((PCGlobalSearchIntentParams) r100).quResult;
    L8:
        String r102 = r101;
        Boolean r103 = this.needDeepSearch;
        if (r103 != null) goto L11;
        r103 = ((PCGlobalSearchIntentParams) r100).needDeepSearch;
    L11:
        Boolean r104 = r103;
        Integer r105 = this.limitCount;
        if (r105 != null) goto L14;
        r105 = ((PCGlobalSearchIntentParams) r100).limitCount;
    L14:
        Integer r106 = r105;
        String r107 = this.interactionType;
        if (r107 != null) goto L17;
        r107 = ((PCGlobalSearchIntentParams) r100).interactionType;
    L17:
        String r108 = r107;
        String r109 = this.meta;
        if (r109 != null) goto L20;
        String r110 = ((PCGlobalSearchIntentParams) r100).meta;
    L22:
        return new PCGlobalSearchIntentParams(r102, r104, r106, r108, r110);
    L20:
        r110 = r109;
        goto L22
    }

    public final void setInteractionType(String r100) {
        this.interactionType = r100;
    }

    public final void setLimitCount(Integer r100) {
        this.limitCount = r100;
    }

    public final void setMeta(String r100) {
        this.meta = r100;
    }

    public final void setNeedDeepSearch(Boolean r100) {
        this.needDeepSearch = r100;
    }

    public final void setQuResult(String r100) {
        this.quResult = r100;
    }

    public PCGlobalSearchIntentParams(String r100, Boolean r101, Integer r102, String r103, String r104) {
        this.quResult = r100;
        this.needDeepSearch = r101;
        this.limitCount = r102;
        this.interactionType = r103;
        this.meta = r104;
    }

    public /* synthetic */ PCGlobalSearchIntentParams(String r100, Boolean r101, Integer r102, String r103, String r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        String r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        Boolean r105 = null;
    L11:
        if ((r110 & 4) == 0) goto L13;
        Integer r106 = null;
    L15:
        if ((r110 & 8) == 0) goto L17;
        String r107 = null;
    L19:
        if ((r110 & 16) == 0) goto L21;
        String r113 = null;
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
