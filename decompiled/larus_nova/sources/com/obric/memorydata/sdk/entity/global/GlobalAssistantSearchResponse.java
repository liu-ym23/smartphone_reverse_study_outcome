package com.obric.memorydata.sdk.entity.global;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import pka.b;
import rka.c;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u0000 K2\u00020\u0001:\u0001KB_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0011\u0010\u0012B\u0011\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0014¢\u0006\u0004\b\u0011\u0010\u0015J\u0018\u00104\u001a\u0002052\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u00106\u001a\u00020\u0003H\u0016J\b\u00107\u001a\u00020\u0003H\u0016J\u0016\u00108\u001a\u0002052\u0006\u00109\u001a\u00020\u00052\u0006\u0010:\u001a\u00020;J\u0010\u00102\u001a\u0004\u0018\u00010;2\u0006\u00109\u001a\u00020\u0005J\u000e\u0010<\u001a\u0002052\u0006\u00109\u001a\u00020\u0005J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u0005HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0005HÆ\u0003Je\u0010E\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010F\u001a\u00020G2\b\u0010H\u001a\u0004\u0018\u00010;HÖ\u0003J\t\u0010I\u001a\u00020\u0003HÖ\u0001J\t\u0010J\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u001b\"\u0004\b3\u0010\u001d¨\u0006L"}, d2 = {"Lcom/obric/memorydata/sdk/entity/global/GlobalAssistantSearchResponse;", "Landroid/os/Parcelable;", "code", "", "message", "", "entityResult", "Lcom/obric/memorydata/sdk/entity/global/GlobalAssistantSearchEntityResult;", "kgResult", "Lcom/obric/memorydata/sdk/entity/global/GlobalAssistantSearchKgResult;", "domainResult", "Lcom/obric/memorydata/sdk/entity/global/GlobalAssistantSearchDomainResult;", "memoryResult", "Lcom/obric/memorydata/sdk/entity/global/GlobalAssistantSearchMemoryResult;", "proactiveRecommendationResult", "Lcom/obric/memorydata/sdk/entity/global/ProactiveRecommendationSearchResult;", "extra", "<init>", "(ILjava/lang/String;Lcom/obric/memorydata/sdk/entity/global/GlobalAssistantSearchEntityResult;Lcom/obric/memorydata/sdk/entity/global/GlobalAssistantSearchKgResult;Lcom/obric/memorydata/sdk/entity/global/GlobalAssistantSearchDomainResult;Lcom/obric/memorydata/sdk/entity/global/GlobalAssistantSearchMemoryResult;Lcom/obric/memorydata/sdk/entity/global/ProactiveRecommendationSearchResult;Ljava/lang/String;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getCode", "()I", "setCode", "(I)V", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "getEntityResult", "()Lcom/obric/memorydata/sdk/entity/global/GlobalAssistantSearchEntityResult;", "setEntityResult", "(Lcom/obric/memorydata/sdk/entity/global/GlobalAssistantSearchEntityResult;)V", "getKgResult", "()Lcom/obric/memorydata/sdk/entity/global/GlobalAssistantSearchKgResult;", "setKgResult", "(Lcom/obric/memorydata/sdk/entity/global/GlobalAssistantSearchKgResult;)V", "getDomainResult", "()Lcom/obric/memorydata/sdk/entity/global/GlobalAssistantSearchDomainResult;", "setDomainResult", "(Lcom/obric/memorydata/sdk/entity/global/GlobalAssistantSearchDomainResult;)V", "getMemoryResult", "()Lcom/obric/memorydata/sdk/entity/global/GlobalAssistantSearchMemoryResult;", "setMemoryResult", "(Lcom/obric/memorydata/sdk/entity/global/GlobalAssistantSearchMemoryResult;)V", "getProactiveRecommendationResult", "()Lcom/obric/memorydata/sdk/entity/global/ProactiveRecommendationSearchResult;", "setProactiveRecommendationResult", "(Lcom/obric/memorydata/sdk/entity/global/ProactiveRecommendationSearchResult;)V", "getExtra", "setExtra", "writeToParcel", "", "flags", "describeContents", "addExtra", "key", "value", "", "removeExtra", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "CREATOR", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class GlobalAssistantSearchResponse implements Parcelable {
    public static final a CREATOR = null;
    private int code;
    private GlobalAssistantSearchDomainResult domainResult;
    private GlobalAssistantSearchEntityResult entityResult;
    private String extra;
    private GlobalAssistantSearchKgResult kgResult;
    private GlobalAssistantSearchMemoryResult memoryResult;
    private String message;
    private ProactiveRecommendationSearchResult proactiveRecommendationResult;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<GlobalAssistantSearchResponse> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final GlobalAssistantSearchResponse createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new GlobalAssistantSearchResponse(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final GlobalAssistantSearchResponse[] newArray(int r100) {
            return new GlobalAssistantSearchResponse[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public static /* synthetic */ Unit a(GlobalAssistantSearchResponse r100, String r101) {
        return removeExtra$lambda$2(r100, r101);
    }

    public static /* synthetic */ Object b(GlobalAssistantSearchResponse r100, String r101) {
        return getExtra$lambda$1(r100, r101);
    }

    public static /* synthetic */ JSONObject c(GlobalAssistantSearchResponse r100) {
        return addExtra$lambda$0(r100);
    }

    public static /* synthetic */ GlobalAssistantSearchResponse copy$default(GlobalAssistantSearchResponse r100, int r110, String r111, GlobalAssistantSearchEntityResult r112, GlobalAssistantSearchKgResult r113, GlobalAssistantSearchDomainResult r114, GlobalAssistantSearchMemoryResult r115, ProactiveRecommendationSearchResult r116, String r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        int r101 = r100.code;
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r102 = r100.message;
    L11:
        if ((r118 & 4) == 0) goto L13;
        GlobalAssistantSearchEntityResult r103 = r100.entityResult;
    L15:
        if ((r118 & 8) == 0) goto L17;
        GlobalAssistantSearchKgResult r104 = r100.kgResult;
    L19:
        if ((r118 & 16) == 0) goto L21;
        GlobalAssistantSearchDomainResult r105 = r100.domainResult;
    L23:
        if ((r118 & 32) == 0) goto L25;
        GlobalAssistantSearchMemoryResult r106 = r100.memoryResult;
    L27:
        if ((r118 & 64) == 0) goto L29;
        ProactiveRecommendationSearchResult r107 = r100.proactiveRecommendationResult;
    L31:
        if ((r118 & 128) == 0) goto L33;
        String r108 = r100.extra;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
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

    public final int component1() {
        return this.code;
    }

    public final String component2() {
        return this.message;
    }

    public final GlobalAssistantSearchEntityResult component3() {
        return this.entityResult;
    }

    public final GlobalAssistantSearchKgResult component4() {
        return this.kgResult;
    }

    public final GlobalAssistantSearchDomainResult component5() {
        return this.domainResult;
    }

    public final GlobalAssistantSearchMemoryResult component6() {
        return this.memoryResult;
    }

    public final ProactiveRecommendationSearchResult component7() {
        return this.proactiveRecommendationResult;
    }

    public final String component8() {
        return this.extra;
    }

    public final GlobalAssistantSearchResponse copy(int r110, String r111, GlobalAssistantSearchEntityResult r112, GlobalAssistantSearchKgResult r113, GlobalAssistantSearchDomainResult r114, GlobalAssistantSearchMemoryResult r115, ProactiveRecommendationSearchResult r116, String r117) {
        Intrinsics.checkNotNullParameter(r111, "message");
        return new GlobalAssistantSearchResponse(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GlobalAssistantSearchResponse) == true) goto L8;
        return false;
    L8:
        GlobalAssistantSearchResponse r101 = (GlobalAssistantSearchResponse) r100;
        if (this.code == r101.code) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.message, r101.message) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.entityResult, r101.entityResult) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.kgResult, r101.kgResult) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.domainResult, r101.domainResult) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.memoryResult, r101.memoryResult) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.proactiveRecommendationResult, r101.proactiveRecommendationResult) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.code * 31) + this.message.hashCode()) * 31;
        GlobalAssistantSearchEntityResult r101 = this.entityResult;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        GlobalAssistantSearchKgResult r105 = this.kgResult;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        GlobalAssistantSearchDomainResult r108 = this.domainResult;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        GlobalAssistantSearchMemoryResult r111 = this.memoryResult;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        ProactiveRecommendationSearchResult r114 = this.proactiveRecommendationResult;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        String r117 = this.extra;
        if (r117 == null) goto L27;
        r102 = r117.hashCode();
    L27:
        return r116 + r102;
    L21:
        r115 = r114.hashCode();
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "GlobalAssistantSearchResponse(code=" + this.code + ", message=" + this.message + ", entityResult=" + this.entityResult + ", kgResult=" + this.kgResult + ", domainResult=" + this.domainResult + ", memoryResult=" + this.memoryResult + ", proactiveRecommendationResult=" + this.proactiveRecommendationResult + ", extra=" + this.extra + ')';
    }

    public final int getCode() {
        return this.code;
    }

    public final GlobalAssistantSearchDomainResult getDomainResult() {
        return this.domainResult;
    }

    public final GlobalAssistantSearchEntityResult getEntityResult() {
        return this.entityResult;
    }

    public final String getExtra() {
        return this.extra;
    }

    public final GlobalAssistantSearchKgResult getKgResult() {
        return this.kgResult;
    }

    public final GlobalAssistantSearchMemoryResult getMemoryResult() {
        return this.memoryResult;
    }

    public final String getMessage() {
        return this.message;
    }

    public final ProactiveRecommendationSearchResult getProactiveRecommendationResult() {
        return this.proactiveRecommendationResult;
    }

    public GlobalAssistantSearchResponse(Parcel r110) {
        Intrinsics.checkNotNullParameter(r110, "parcel");
        int r100 = r110.readInt();
        String r101 = r110.readString();
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        this(r100, r101, (GlobalAssistantSearchEntityResult) r110.readParcelable(GlobalAssistantSearchEntityResult.class.getClassLoader()), (GlobalAssistantSearchKgResult) r110.readParcelable(GlobalAssistantSearchKgResult.class.getClassLoader()), (GlobalAssistantSearchDomainResult) r110.readParcelable(GlobalAssistantSearchDomainResult.class.getClassLoader()), (GlobalAssistantSearchMemoryResult) r110.readParcelable(GlobalAssistantSearchMemoryResult.class.getClassLoader()), (ProactiveRecommendationSearchResult) r110.readParcelable(ProactiveRecommendationSearchResult.class.getClassLoader()), r110.readString());
    }

    private static final JSONObject addExtra$lambda$0(GlobalAssistantSearchResponse r100) {
        return new JSONObject(r100.extra);
    }

    public final Object getExtra(final String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        String r101 = this.extra;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L12;
        return null;
    L12:
        return b.a(new rka.b(this, r100));
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    public final void removeExtra(final String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        String r101 = this.extra;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L12;
        b.a(new rka.a(this, r100));
        return;
    L12:
        return;
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    public final void setCode(int r100) {
        this.code = r100;
    }

    public final void setDomainResult(GlobalAssistantSearchDomainResult r100) {
        this.domainResult = r100;
    }

    public final void setEntityResult(GlobalAssistantSearchEntityResult r100) {
        this.entityResult = r100;
    }

    public final void setExtra(String r100) {
        this.extra = r100;
    }

    public final void setKgResult(GlobalAssistantSearchKgResult r100) {
        this.kgResult = r100;
    }

    public final void setMemoryResult(GlobalAssistantSearchMemoryResult r100) {
        this.memoryResult = r100;
    }

    public final void setMessage(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.message = r100;
    }

    public final void setProactiveRecommendationResult(ProactiveRecommendationSearchResult r100) {
        this.proactiveRecommendationResult = r100;
    }

    private static final Object getExtra$lambda$1(GlobalAssistantSearchResponse r100, String r101) {
        return new JSONObject(r100.extra).opt(r101);
    }

    private static final Unit removeExtra$lambda$2(GlobalAssistantSearchResponse r100, String r101) {
        JSONObject r102 = new JSONObject(r100.extra);
        r102.remove(r101);
        r100.extra = r102.toString();
        return Unit.INSTANCE;
    }

    public final void addExtra(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        String r102 = this.extra;
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L11;
        JSONObject r104 = new JSONObject();
    L14:
        r104.put(r100, r101);
        this.extra = r104.toString();
        return;
    L11:
        r104 = (JSONObject) b.a(new c(this));
        if (r104 != null) goto L14;
        r104 = new JSONObject();
        goto L14
    L5:
        if (r102.length() == 0) goto L8;
        r103 = false;
        goto L9
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeInt(this.code);
        r100.writeString(this.message);
        r100.writeParcelable(this.entityResult, r101);
        r100.writeParcelable(this.kgResult, r101);
        r100.writeParcelable(this.domainResult, r101);
        r100.writeParcelable(this.memoryResult, r101);
        r100.writeParcelable(this.proactiveRecommendationResult, r101);
        r100.writeString(this.extra);
    }

    public GlobalAssistantSearchResponse(int r100, String r101, GlobalAssistantSearchEntityResult r102, GlobalAssistantSearchKgResult r103, GlobalAssistantSearchDomainResult r104, GlobalAssistantSearchMemoryResult r105, ProactiveRecommendationSearchResult r106, String r107) {
        Intrinsics.checkNotNullParameter(r101, "message");
        this.code = r100;
        this.message = r101;
        this.entityResult = r102;
        this.kgResult = r103;
        this.domainResult = r104;
        this.memoryResult = r105;
        this.proactiveRecommendationResult = r106;
        this.extra = r107;
    }

    public /* synthetic */ GlobalAssistantSearchResponse(int r110, String r111, GlobalAssistantSearchEntityResult r112, GlobalAssistantSearchKgResult r113, GlobalAssistantSearchDomainResult r114, GlobalAssistantSearchMemoryResult r115, ProactiveRecommendationSearchResult r116, String r210, int r211, DefaultConstructorMarker r212) {
        if ((r211 & 4) == 0) goto L5;
        GlobalAssistantSearchEntityResult r100 = null;
    L7:
        if ((r211 & 8) == 0) goto L9;
        GlobalAssistantSearchKgResult r101 = null;
    L11:
        if ((r211 & 16) == 0) goto L13;
        GlobalAssistantSearchDomainResult r102 = null;
    L15:
        if ((r211 & 32) == 0) goto L17;
        GlobalAssistantSearchMemoryResult r103 = null;
    L19:
        if ((r211 & 64) == 0) goto L21;
        ProactiveRecommendationSearchResult r117 = null;
    L23:
        if ((r211 & 128) == 0) goto L25;
        String r118 = null;
    L26:
        this(r110, r111, r100, r101, r102, r103, r117, r118);
        return;
    L25:
        r118 = r210;
        goto L26
    L21:
        r117 = r116;
        goto L23
    L17:
        r103 = r115;
        goto L19
    L13:
        r102 = r114;
        goto L15
    L9:
        r101 = r113;
        goto L11
    L5:
        r100 = r112;
        goto L7
    }
}
