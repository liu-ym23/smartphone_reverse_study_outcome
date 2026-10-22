package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B5\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0004HÆ\u0003J9\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u001bHÖ\u0001J\b\u0010!\u001a\u00020\u001dH\u0016J\u0012\u0010\"\u001a\u00020\u00012\b\u0010#\u001a\u0004\u0018\u00010\u001fH\u0016J\t\u0010$\u001a\u00020\u0004HÖ\u0001J\u0019\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u001bHÖ\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR&\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\f¨\u0006*"}, d2 = {"Lcom/obric/capabilitykit/common/intent/PCCommonGlobalSearchParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "originQuery", "", "searchParams", "interactionType", "memoryScene", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getInteractionType", "()Ljava/lang/String;", "setInteractionType", "(Ljava/lang/String;)V", "getMemoryScene$annotations", "()V", "getMemoryScene", "setMemoryScene", "getOriginQuery", "setOriginQuery", "getSearchParams", "setSearchParams", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "isParamsCompleted", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PCCommonGlobalSearchParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<PCCommonGlobalSearchParams> CREATOR = null;
    private String interactionType;
    String memoryScene;
    private String originQuery;
    private String searchParams;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<PCCommonGlobalSearchParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final PCCommonGlobalSearchParams createFromParcel(Parcel r110) {
            int r100 = r110.readInt();
            Intrinsics.checkNotNullParameter(r110, "parcel");
            PCCommonGlobalSearchParams r101 = new PCCommonGlobalSearchParams(r110.readString(), r110.readString(), r110.readString(), null, 8, null);
            int r102 = Math.min(r100, 1);
            ClassLoader r103 = a.class.getClassLoader();
            int r104 = 1;
        L3:
            if (r104 > r102) goto L9;
            if (r104 != 1) goto L8;
            Object r105 = joa.a.c(r110, r103);
            if (r105 == null) goto L8;
            r101.memoryScene = (String) r105;
        L8:
            r104 = r104 + 1;
        L9:
            if (r104 > r100) goto L11;
            joa.a.d(r110, r103);
            r104 = r104 + 1;
            goto L9
        L11:
            return r101;
        }

        @Override // android.os.Parcelable.Creator
        public final PCCommonGlobalSearchParams[] newArray(int r100) {
            return new PCCommonGlobalSearchParams[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public PCCommonGlobalSearchParams() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ PCCommonGlobalSearchParams copy$default(PCCommonGlobalSearchParams r100, String r101, String r102, String r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.originQuery;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.searchParams;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.interactionType;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.memoryScene;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public static /* synthetic */ void getMemoryScene$annotations() {
    }

    public final String component1() {
        return this.originQuery;
    }

    public final String component2() {
        return this.searchParams;
    }

    public final String component3() {
        return this.interactionType;
    }

    public final String component4() {
        return this.memoryScene;
    }

    public final PCCommonGlobalSearchParams copy(String r100, String r101, String r102, String r103) {
        return new PCCommonGlobalSearchParams(r100, r101, r102, r103);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PCCommonGlobalSearchParams) == true) goto L8;
        return false;
    L8:
        PCCommonGlobalSearchParams r101 = (PCCommonGlobalSearchParams) r100;
        if (Intrinsics.areEqual(this.originQuery, r101.originQuery) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.searchParams, r101.searchParams) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.interactionType, r101.interactionType) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.memoryScene, r101.memoryScene) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public String getSubActionValue() {
        return null;
    }

    public int hashCode() {
        String r100 = this.originQuery;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.searchParams;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.interactionType;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.memoryScene;
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
        return "PCCommonGlobalSearchParams(originQuery=" + this.originQuery + ", searchParams=" + this.searchParams + ", interactionType=" + this.interactionType + ", memoryScene=" + this.memoryScene + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(1);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        r100.writeString(this.originQuery);
        r100.writeString(this.searchParams);
        r100.writeString(this.interactionType);
        r100.writeValue(this.memoryScene);
    }

    public boolean isParamsCompleted() {
        if (this.originQuery != null) goto L5;
    L7:
        return false;
    L5:
        if (this.searchParams == null) goto L7;
        return true;
    }

    public final String getInteractionType() {
        return this.interactionType;
    }

    public final String getMemoryScene() {
        return this.memoryScene;
    }

    public final String getOriginQuery() {
        return this.originQuery;
    }

    public final String getSearchParams() {
        return this.searchParams;
    }

    public IntentParams mergeParams(Object r100) {
        if ((r100 instanceof PCCommonGlobalSearchParams) == true) goto L5;
        return this;
    L5:
        String r101 = this.originQuery;
        if (r101 != null) goto L8;
        r101 = ((PCCommonGlobalSearchParams) r100).originQuery;
    L8:
        String r102 = this.searchParams;
        if (r102 != null) goto L11;
        r102 = ((PCCommonGlobalSearchParams) r100).searchParams;
    L11:
        String r103 = this.interactionType;
        if (r103 != null) goto L14;
        r103 = ((PCCommonGlobalSearchParams) r100).interactionType;
    L14:
        String r104 = this.memoryScene;
        if (r104 != null) goto L18;
        r104 = ((PCCommonGlobalSearchParams) r100).memoryScene;
    L18:
        return new PCCommonGlobalSearchParams(r101, r102, r103, r104);
    }

    public final void setInteractionType(String r100) {
        this.interactionType = r100;
    }

    public final void setMemoryScene(String r100) {
        this.memoryScene = r100;
    }

    public final void setOriginQuery(String r100) {
        this.originQuery = r100;
    }

    public final void setSearchParams(String r100) {
        this.searchParams = r100;
    }

    public PCCommonGlobalSearchParams(String r100, String r101, String r102, String r103) {
        this.originQuery = r100;
        this.searchParams = r101;
        this.interactionType = r102;
        this.memoryScene = r103;
    }

    public /* synthetic */ PCCommonGlobalSearchParams(String r100, String r101, String r102, String r103, int r104, DefaultConstructorMarker r105) {
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
