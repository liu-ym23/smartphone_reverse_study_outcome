package com.obric.capabilitykit.entity.search;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.obric.capabilitykit.common.UtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\u0006\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 >2\u00020\u0001:\u0001>B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0002\u0010\nJ\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\t\u0010/\u001a\u00020\u0007HÆ\u0003J\t\u00100\u001a\u00020\u0007HÆ\u0003J\t\u00101\u001a\u00020\u0005HÆ\u0003J;\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001J\b\u00103\u001a\u00020\u0005H\u0016J\u0013\u00104\u001a\u00020\u00072\b\u00105\u001a\u0004\u0018\u000106HÖ\u0003J\t\u00107\u001a\u00020\u0005HÖ\u0001J\t\u00108\u001a\u00020\u0003HÖ\u0001J\u0018\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u0005H\u0016R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000f\"\u0004\b\u0019\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0014\"\u0004\b$\u0010\u0016R\u001a\u0010%\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u000f\"\u0004\b'\u0010\u0011R\u001c\u0010(\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u000f\"\u0004\b*\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\f¨\u0006?"}, d2 = {"Lcom/obric/capabilitykit/entity/search/InAppSearchRequest;", "Landroid/os/Parcelable;", "query", "", "maxEntityCount", "", "useSemantic", "", "enableSemanticRanking", "maxSemanticResultCount", "(Ljava/lang/String;IZZI)V", "getEnableSemanticRanking", "()Z", "filterConditions", "getFilterConditions", "()Ljava/lang/String;", "setFilterConditions", "(Ljava/lang/String;)V", "firstPageLimit", "getFirstPageLimit", "()I", "setFirstPageLimit", "(I)V", "interactionType", "getInteractionType", "setInteractionType", "getMaxEntityCount", "getMaxSemanticResultCount", "minImageSemanticsDistance", "", "getMinImageSemanticsDistance", "()D", "setMinImageSemanticsDistance", "(D)V", "otherPagesLimit", "getOtherPagesLimit", "setOtherPagesLimit", "packageName", "getPackageName", "setPackageName", "presetQUResult", "getPresetQUResult", "setPresetQUResult", "getQuery", "getUseSemantic", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class InAppSearchRequest implements Parcelable {
    public static final CREATOR CREATOR = null;
    private static final String VERSION = "1";
    private final boolean enableSemanticRanking;
    private String filterConditions;
    private int firstPageLimit;
    private String interactionType;
    private final int maxEntityCount;
    private final int maxSemanticResultCount;
    private double minImageSemanticsDistance;
    private int otherPagesLimit;
    private String packageName;
    private String presetQUResult;
    private final String query;
    private final boolean useSemantic;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001d\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¢\u0006\u0002\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/capabilitykit/entity/search/InAppSearchRequest$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/search/InAppSearchRequest;", "()V", "VERSION", "", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/obric/capabilitykit/entity/search/InAppSearchRequest;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<InAppSearchRequest> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InAppSearchRequest createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return (InAppSearchRequest) GsonProtectorUtils.fromJson(UtilsKt.a(), r100.readString(), InAppSearchRequest.class);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ InAppSearchRequest createFromParcel(Parcel r100) {
            return createFromParcel(r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InAppSearchRequest[] newArray(int r100) {
            return new InAppSearchRequest[r100];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ InAppSearchRequest[] newArray(int r100) {
            return newArray(r100);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public InAppSearchRequest(String r100, int r101, boolean r102, boolean r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, "query");
        this.query = r100;
        this.maxEntityCount = r101;
        this.useSemantic = r102;
        this.enableSemanticRanking = r103;
        this.maxSemanticResultCount = r104;
        this.packageName = "";
        this.minImageSemanticsDistance = 0.39d;
        this.firstPageLimit = -1;
        this.interactionType = "";
        this.filterConditions = "";
    }

    public /* synthetic */ InAppSearchRequest(String r100, int r101, boolean r110, boolean r111, int r112, int r113, DefaultConstructorMarker r114) {
        if ((r113 & 2) == 0) goto L5;
        int r102 = 0;
    L7:
        if ((r113 & 4) == 0) goto L9;
        boolean r103 = true;
    L11:
        if ((r113 & 8) == 0) goto L13;
        boolean r104 = true;
    L15:
        if ((r113 & 16) == 0) goto L17;
        int r105 = 0;
    L18:
        this(r100, r102, r103, r104, r105);
        return;
    L17:
        r105 = r112;
        goto L18
    L13:
        r104 = r111;
        goto L15
    L9:
        r103 = r110;
        goto L11
    L5:
        r102 = r101;
        goto L7
    }

    public static /* synthetic */ InAppSearchRequest copy$default(InAppSearchRequest r100, String r101, int r102, boolean r103, boolean r104, int r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.query;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.maxEntityCount;
    L8:
        int r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.useSemantic;
    L11:
        boolean r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.enableSemanticRanking;
    L14:
        boolean r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.maxSemanticResultCount;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.query;
    }

    public final int component2() {
        return this.maxEntityCount;
    }

    public final boolean component3() {
        return this.useSemantic;
    }

    public final boolean component4() {
        return this.enableSemanticRanking;
    }

    public final int component5() {
        return this.maxSemanticResultCount;
    }

    public final InAppSearchRequest copy(String r100, int r101, boolean r110, boolean r111, int r112) {
        Intrinsics.checkNotNullParameter(r100, "query");
        return new InAppSearchRequest(r100, r101, r110, r111, r112);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof InAppSearchRequest) == true) goto L8;
        return false;
    L8:
        InAppSearchRequest r101 = (InAppSearchRequest) r100;
        if (Intrinsics.areEqual(this.query, r101.query) == true) goto L12;
        return false;
    L12:
        if (this.maxEntityCount == r101.maxEntityCount) goto L15;
        return false;
    L15:
        if (this.useSemantic == r101.useSemantic) goto L18;
        return false;
    L18:
        if (this.enableSemanticRanking == r101.enableSemanticRanking) goto L21;
        return false;
    L21:
        if (this.maxSemanticResultCount == r101.maxSemanticResultCount) goto L23;
        return false;
    L23:
        return true;
    }

    public final boolean getEnableSemanticRanking() {
        return this.enableSemanticRanking;
    }

    public final String getFilterConditions() {
        return this.filterConditions;
    }

    public final int getFirstPageLimit() {
        return this.firstPageLimit;
    }

    public final String getInteractionType() {
        return this.interactionType;
    }

    public final int getMaxEntityCount() {
        return this.maxEntityCount;
    }

    public final int getMaxSemanticResultCount() {
        return this.maxSemanticResultCount;
    }

    public final double getMinImageSemanticsDistance() {
        return this.minImageSemanticsDistance;
    }

    public final int getOtherPagesLimit() {
        return this.otherPagesLimit;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getPresetQUResult() {
        return this.presetQUResult;
    }

    public final String getQuery() {
        return this.query;
    }

    public final boolean getUseSemantic() {
        return this.useSemantic;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int r100 = ((this.query.hashCode() * 31) + this.maxEntityCount) * 31;
        boolean r101 = this.useSemantic;
        ?? r102 = 1;
        ?? r103 = r101;
        if (r101 == false) goto L5;
        r103 = 1;
    L5:
        int r104 = (r100 + r103) * 31;
        boolean r105 = this.enableSemanticRanking;
        if (r105 == true) goto L10;
        r102 = r105;
    L10:
        return ((r104 + r102) * 31) + this.maxSemanticResultCount;
    }

    public final void setFilterConditions(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.filterConditions = r100;
    }

    public final void setFirstPageLimit(int r100) {
        this.firstPageLimit = r100;
    }

    public final void setInteractionType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.interactionType = r100;
    }

    public final void setMinImageSemanticsDistance(double r100) {
        this.minImageSemanticsDistance = r100;
    }

    public final void setOtherPagesLimit(int r100) {
        this.otherPagesLimit = r100;
    }

    public final void setPackageName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.packageName = r100;
    }

    public final void setPresetQUResult(String r100) {
        this.presetQUResult = r100;
    }

    public String toString() {
        return "InAppSearchRequest(query=" + this.query + ", maxEntityCount=" + this.maxEntityCount + ", useSemantic=" + this.useSemantic + ", enableSemanticRanking=" + this.enableSemanticRanking + ", maxSemanticResultCount=" + this.maxSemanticResultCount + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeString(GsonProtectorUtils.toJson(UtilsKt.a(), this));
    }
}
