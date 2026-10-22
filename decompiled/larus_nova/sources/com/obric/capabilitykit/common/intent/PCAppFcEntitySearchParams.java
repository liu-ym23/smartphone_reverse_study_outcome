package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B/\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0016\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\nJ8\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0018J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\n\u0010\u001f\u001a\u0004\u0018\u00010\u0004H\u0016J\t\u0010 \u001a\u00020\u001aHÖ\u0001J\u0012\u0010!\u001a\u00020\u00012\b\u0010\"\u001a\u0004\u0018\u00010\u001eH\u0016J\t\u0010#\u001a\u00020\u0004HÖ\u0001J\u0019\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u001aHÖ\u0001R$\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011¨\u0006)"}, d2 = {"Lcom/obric/capabilitykit/common/intent/PCAppFcEntitySearchParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "quResult", "", "interactionType", "domains", "", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V", "getDomains", "()[Ljava/lang/String;", "setDomains", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "getInteractionType", "()Ljava/lang/String;", "setInteractionType", "(Ljava/lang/String;)V", "getQuResult", "setQuResult", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Lcom/obric/capabilitykit/common/intent/PCAppFcEntitySearchParams;", "describeContents", "", "equals", "", "other", "", "getSubActionValue", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PCAppFcEntitySearchParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<PCAppFcEntitySearchParams> CREATOR = null;
    private String[] domains;
    private String interactionType;
    private String quResult;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<PCAppFcEntitySearchParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final PCAppFcEntitySearchParams createFromParcel(Parcel r100) {
            int r101 = r100.readInt();
            Intrinsics.checkNotNullParameter(r100, "parcel");
            PCAppFcEntitySearchParams r102 = new PCAppFcEntitySearchParams(r100.readString(), r100.readString(), r100.createStringArray());
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
        public final PCAppFcEntitySearchParams[] newArray(int r100) {
            return new PCAppFcEntitySearchParams[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public PCAppFcEntitySearchParams() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ PCAppFcEntitySearchParams copy$default(PCAppFcEntitySearchParams r100, String r101, String r102, String[] r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.quResult;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.interactionType;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.domains;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.quResult;
    }

    public final String component2() {
        return this.interactionType;
    }

    public final String[] component3() {
        return this.domains;
    }

    public final PCAppFcEntitySearchParams copy(String r100, String r101, String[] r102) {
        return new PCAppFcEntitySearchParams(r100, r101, r102);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PCAppFcEntitySearchParams) == true) goto L8;
        return false;
    L8:
        PCAppFcEntitySearchParams r101 = (PCAppFcEntitySearchParams) r100;
        if (Intrinsics.areEqual(this.quResult, r101.quResult) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.interactionType, r101.interactionType) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.domains, r101.domains) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r100 = this.quResult;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.interactionType;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String[] r107 = this.domains;
        if (r107 == null) goto L15;
        r101 = Arrays.hashCode(r107);
    L15:
        return r106 + r101;
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
        return "PCAppFcEntitySearchParams(quResult=" + this.quResult + ", interactionType=" + this.interactionType + ", domains=" + Arrays.toString(this.domains) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(0);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        r100.writeString(this.quResult);
        r100.writeString(this.interactionType);
        r100.writeStringArray(this.domains);
    }

    public String getSubActionValue() {
        String[] r100 = this.domains;
        if (r100 != null) goto L7;
        return null;
    L7:
        return ArraysKt.joinToString$default(r100, null, null, null, 0, null, null, 63, null);
    }

    public final String[] getDomains() {
        return this.domains;
    }

    public final String getInteractionType() {
        return this.interactionType;
    }

    public final String getQuResult() {
        return this.quResult;
    }

    public IntentParams mergeParams(Object r100) {
        if ((r100 instanceof PCAppFcEntitySearchParams) == true) goto L5;
        return this;
    L5:
        String r101 = this.quResult;
        if (r101 != null) goto L8;
        r101 = ((PCAppFcEntitySearchParams) r100).quResult;
    L8:
        String r102 = this.interactionType;
        if (r102 != null) goto L11;
        r102 = ((PCAppFcEntitySearchParams) r100).interactionType;
    L11:
        String[] r103 = this.domains;
        if (r103 != null) goto L15;
        r103 = ((PCAppFcEntitySearchParams) r100).domains;
    L15:
        return new PCAppFcEntitySearchParams(r101, r102, r103);
    }

    public final void setDomains(String[] r100) {
        this.domains = r100;
    }

    public final void setInteractionType(String r100) {
        this.interactionType = r100;
    }

    public final void setQuResult(String r100) {
        this.quResult = r100;
    }

    public PCAppFcEntitySearchParams(String r100, String r101, String[] r102) {
        this.quResult = r100;
        this.interactionType = r101;
        this.domains = r102;
    }

    public /* synthetic */ PCAppFcEntitySearchParams(String r100, String r101, String[] r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
