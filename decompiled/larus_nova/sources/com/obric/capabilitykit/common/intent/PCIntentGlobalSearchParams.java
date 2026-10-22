package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0006J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0004HÆ\u0003J!\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0011HÖ\u0001J\b\u0010\u0017\u001a\u00020\u0013H\u0016J\u0012\u0010\u0018\u001a\u00020\u00012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0015H\u0016J\t\u0010\u001a\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0011HÖ\u0001R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006 "}, d2 = {"Lcom/obric/capabilitykit/common/intent/PCIntentGlobalSearchParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "searchParams", "", "interactionType", "(Ljava/lang/String;Ljava/lang/String;)V", "getInteractionType", "()Ljava/lang/String;", "setInteractionType", "(Ljava/lang/String;)V", "getSearchParams", "setSearchParams", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "isParamsCompleted", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PCIntentGlobalSearchParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<PCIntentGlobalSearchParams> CREATOR = null;
    private String interactionType;
    private String searchParams;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<PCIntentGlobalSearchParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final PCIntentGlobalSearchParams createFromParcel(Parcel r100) {
            int r101 = r100.readInt();
            Intrinsics.checkNotNullParameter(r100, "parcel");
            PCIntentGlobalSearchParams r102 = new PCIntentGlobalSearchParams(r100.readString(), r100.readString());
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
        public final PCIntentGlobalSearchParams[] newArray(int r100) {
            return new PCIntentGlobalSearchParams[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PCIntentGlobalSearchParams() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ PCIntentGlobalSearchParams copy$default(PCIntentGlobalSearchParams r100, String r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.searchParams;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.interactionType;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.searchParams;
    }

    public final String component2() {
        return this.interactionType;
    }

    public final PCIntentGlobalSearchParams copy(String r100, String r101) {
        return new PCIntentGlobalSearchParams(r100, r101);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PCIntentGlobalSearchParams) == true) goto L8;
        return false;
    L8:
        PCIntentGlobalSearchParams r101 = (PCIntentGlobalSearchParams) r100;
        if (Intrinsics.areEqual(this.searchParams, r101.searchParams) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.interactionType, r101.interactionType) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public String getSubActionValue() {
        return null;
    }

    public int hashCode() {
        String r100 = this.searchParams;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.interactionType;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "PCIntentGlobalSearchParams(searchParams=" + this.searchParams + ", interactionType=" + this.interactionType + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(0);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        r100.writeString(this.searchParams);
        r100.writeString(this.interactionType);
    }

    public boolean isParamsCompleted() {
        if (this.searchParams == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final String getInteractionType() {
        return this.interactionType;
    }

    public final String getSearchParams() {
        return this.searchParams;
    }

    public IntentParams mergeParams(Object r100) {
        if ((r100 instanceof PCIntentGlobalSearchParams) == true) goto L5;
        return this;
    L5:
        String r101 = this.searchParams;
        if (r101 != null) goto L8;
        r101 = ((PCIntentGlobalSearchParams) r100).searchParams;
    L8:
        String r102 = this.interactionType;
        if (r102 != null) goto L12;
        r102 = ((PCIntentGlobalSearchParams) r100).interactionType;
    L12:
        return new PCIntentGlobalSearchParams(r101, r102);
    }

    public final void setInteractionType(String r100) {
        this.interactionType = r100;
    }

    public final void setSearchParams(String r100) {
        this.searchParams = r100;
    }

    public PCIntentGlobalSearchParams(String r100, String r101) {
        this.searchParams = r100;
        this.interactionType = r101;
    }

    public /* synthetic */ PCIntentGlobalSearchParams(String r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
