package com.obric.assistant.remote_card_container.cache;

import com.google.gson.annotations.SerializedName;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u001d\b\u0086\b\u0018\u00002\u00020\u0001Be\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010 \u001a\u00020\bHÆ\u0003J\t\u0010!\u001a\u00020\nHÆ\u0003J\t\u0010\"\u001a\u00020\nHÆ\u0003J\t\u0010#\u001a\u00020\rHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jg\u0010%\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010&\u001a\u00020\b2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\nHÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0016R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u000b\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012¨\u0006*"}, d2 = {"Lcom/obric/assistant/remote_card_container/cache/CardInfo;", "", "cardUri", "", "localMessageIds", "", "extraParams", "isExpired", "", "actualViewHeight", "", "defaultViewHeight", "sourceAppLastUpdateTime", "", "dataUUID", "<init>", "(Ljava/lang/String;Ljava/util/Set;Ljava/lang/String;ZIIJLjava/lang/String;)V", "getCardUri", "()Ljava/lang/String;", "getLocalMessageIds", "()Ljava/util/Set;", "getExtraParams", "()Z", "getActualViewHeight", "()I", "getDefaultViewHeight", "getSourceAppLastUpdateTime", "()J", "getDataUUID", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class j {

    @SerializedName("actualViewHeight")
    private final int actualViewHeight;

    @SerializedName("cardUri")
    private final String cardUri;

    @SerializedName("dataUUID")
    private final String dataUUID;

    @SerializedName("defaultViewHeight")
    private final int defaultViewHeight;

    @SerializedName("extraParams")
    private final String extraParams;

    @SerializedName("isExpired")
    private final boolean isExpired;

    @SerializedName("localMessageIds")
    private final Set<String> localMessageIds;

    @SerializedName("sourceAppLastUpdateTime")
    private final long sourceAppLastUpdateTime;

    public j() {
        this(null, null, null, 0, 255);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.cardUri, r101.cardUri) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.localMessageIds, r101.localMessageIds) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.extraParams, r101.extraParams) == true) goto L18;
        return false;
    L18:
        if (this.isExpired == r101.isExpired) goto L21;
        return false;
    L21:
        if (this.actualViewHeight == r101.actualViewHeight) goto L24;
        return false;
    L24:
        if (this.defaultViewHeight == r101.defaultViewHeight) goto L27;
        return false;
    L27:
        if (this.sourceAppLastUpdateTime == r101.sourceAppLastUpdateTime) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.dataUUID, r101.dataUUID) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        String r100 = this.cardUri;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Set<String> r104 = this.localMessageIds;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.extraParams;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        if (this.isExpired == false) goto L17;
        int r110 = 1231;
    L18:
        int r111 = (((((r109 + r110) * 31) + this.actualViewHeight) * 31) + this.defaultViewHeight) * 31;
        long r112 = this.sourceAppLastUpdateTime;
        int r113 = (r111 + ((int) (r112 ^ (r112 >>> 32)))) * 31;
        String r114 = this.dataUUID;
        if (r114 == null) goto L23;
        r101 = r114.hashCode();
    L23:
        return r113 + r101;
    L17:
        r110 = 1237;
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

    public final String toString() {
        return "CardInfo(cardUri=" + this.cardUri + ", localMessageIds=" + this.localMessageIds + ", extraParams=" + this.extraParams + ", isExpired=" + this.isExpired + ", actualViewHeight=" + this.actualViewHeight + ", defaultViewHeight=" + this.defaultViewHeight + ", sourceAppLastUpdateTime=" + this.sourceAppLastUpdateTime + ", dataUUID=" + this.dataUUID + ')';
    }

    public final int b() {
        return this.actualViewHeight;
    }

    public final String c() {
        return this.cardUri;
    }

    public final String d() {
        return this.dataUUID;
    }

    public final int e() {
        return this.defaultViewHeight;
    }

    public final String f() {
        return this.extraParams;
    }

    public final Set<String> g() {
        return this.localMessageIds;
    }

    public final long h() {
        return this.sourceAppLastUpdateTime;
    }

    public final boolean i() {
        return this.isExpired;
    }

    public /* synthetic */ j(String r110, Set r111, String r112, int r113, int r114) {
        String r100 = null;
        if ((r114 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r114 & 2) == 0) goto L9;
        Set r102 = SetsKt.emptySet();
    L11:
        if ((r114 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r114 & 8) == 0) goto L17;
        boolean r104 = true;
    L19:
        if ((r114 & 32) == 0) goto L21;
        int r105 = 0;
    L23:
        if ((r114 & 64) == 0) goto L25;
        long r115 = -1;
    L27:
        if ((r114 & 128) == 0) goto L29;
        r100 = "";
    L29:
        this(r101, r102, r103, r104, 0, r105, r115, r100);
        return;
    L25:
        r115 = 0;
        goto L27
    L21:
        r105 = r113;
        goto L23
    L17:
        r104 = false;
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

    public j(String r100, Set<String> r101, String r102, boolean r103, int r104, int r105, long r106, String r107) {
        this.cardUri = r100;
        this.localMessageIds = r101;
        this.extraParams = r102;
        this.isExpired = r103;
        this.actualViewHeight = r104;
        this.defaultViewHeight = r105;
        this.sourceAppLastUpdateTime = r106;
        this.dataUUID = r107;
    }

    public static j a(j r110, Set r111, String r112, boolean r113, int r114, int r115, long r116, String r117, int r118) {
        if ((r118 & 1) == 0) goto L5;
        String r100 = r110.cardUri;
    L7:
        if ((r118 & 2) == 0) goto L9;
        Set r101 = r110.localMessageIds;
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r102 = r110.extraParams;
    L15:
        if ((r118 & 8) == 0) goto L17;
        boolean r103 = r110.isExpired;
    L19:
        if ((r118 & 16) == 0) goto L21;
        int r104 = r110.actualViewHeight;
    L23:
        if ((r118 & 32) == 0) goto L25;
        int r105 = r110.defaultViewHeight;
    L27:
        if ((r118 & 64) == 0) goto L29;
        long r106 = r110.sourceAppLastUpdateTime;
    L31:
        if ((r118 & 128) == 0) goto L33;
        String r107 = r110.dataUUID;
    L34:
        r110.getClass();
        return new j(r100, r101, r102, r103, r104, r105, r106, r107);
    L33:
        r107 = r117;
        goto L34
    L29:
        r106 = r116;
        goto L31
    L25:
        r105 = r115;
        goto L27
    L21:
        r104 = r114;
        goto L23
    L17:
        r103 = r113;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = null;
        goto L7
    }
}
