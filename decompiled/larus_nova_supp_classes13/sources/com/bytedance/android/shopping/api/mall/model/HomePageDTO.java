package com.bytedance.android.shopping.api.mall.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b6\b\u0087\b\u0018\u0000 D2\u00020\u0001:\u0001EB\u0081\u0001\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\n\u0012\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\r\u0012\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\bB\u0010CJ\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0007\u001a\u00020\u0006HÆ\u0003J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0017\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\rHÆ\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fHÆ\u0003J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0012\u0010\tJ\u008a\u0001\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00042\b\b\u0002\u0010\u0015\u001a\u00020\u00062\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\n2\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\r2\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u001e\u001a\u00020\nHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0006HÖ\u0001J\u0013\u0010!\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003R$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010\u0014\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010'\u001a\u0004\b(\u0010)R\u001a\u0010\u0015\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010*\u001a\u0004\b+\u0010,R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010-\u001a\u0004\b.\u0010\tR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010/\u001a\u0004\b0\u00101R$\u0010\u0018\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010/\u001a\u0004\b2\u00101\"\u0004\b3\u00104R0\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R*\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R$\u0010\u001b\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010-\u001a\u0004\b?\u0010\t\"\u0004\b@\u0010A¨\u0006F"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/model/HomePageDTO;", "", "Lcom/bytedance/android/shopping/api/mall/model/HomePageBffDTO;", "component1", "", "component2", "", "component3", "component4", "()Ljava/lang/Integer;", "", "component5", "component6", "", "component7", "", "Lcom/bytedance/android/shopping/api/mall/model/ChunkedSectionData;", "component8", "component9", "bff", "hasMore", "cursor", "statusCode", "statusMessage", "chunkedSection", "serverTiming", "chunkDataList", "dataReuseStatus", "copy", "(Lcom/bytedance/android/shopping/api/mall/model/HomePageBffDTO;ZILjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/List;Ljava/lang/Integer;)Lcom/bytedance/android/shopping/api/mall/model/HomePageDTO;", "toString", "hashCode", "other", "equals", "Lcom/bytedance/android/shopping/api/mall/model/HomePageBffDTO;", "getBff", "()Lcom/bytedance/android/shopping/api/mall/model/HomePageBffDTO;", "setBff", "(Lcom/bytedance/android/shopping/api/mall/model/HomePageBffDTO;)V", "Z", "getHasMore", "()Z", "I", "getCursor", "()I", "Ljava/lang/Integer;", "getStatusCode", "Ljava/lang/String;", "getStatusMessage", "()Ljava/lang/String;", "getChunkedSection", "setChunkedSection", "(Ljava/lang/String;)V", "Ljava/util/Map;", "getServerTiming", "()Ljava/util/Map;", "setServerTiming", "(Ljava/util/Map;)V", "Ljava/util/List;", "getChunkDataList", "()Ljava/util/List;", "setChunkDataList", "(Ljava/util/List;)V", "getDataReuseStatus", "setDataReuseStatus", "(Ljava/lang/Integer;)V", "<init>", "(Lcom/bytedance/android/shopping/api/mall/model/HomePageBffDTO;ZILjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/List;Ljava/lang/Integer;)V", "Companion", "a", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HomePageDTO {
    public static final a Companion = null;
    public static final int DATA_REUSE_AI_PREFETCH_EXPIRED = 1;
    public static final int DATA_REUSE_UNEXPOSED = 2;

    @SerializedName("bff_data")
    private HomePageBffDTO bff;

    @SerializedName("chunked_data_list")
    private List<ChunkedSectionData> chunkDataList;

    @SerializedName("chunked_section")
    private String chunkedSection;

    @SerializedName("cursor")
    private final int cursor;

    @SerializedName("data_reuse_status")
    private Integer dataReuseStatus;

    @SerializedName("has_more")
    private final boolean hasMore;

    @SerializedName("server_time")
    private Map<String, ? extends Object> serverTiming;

    @SerializedName("status_code")
    private final Integer statusCode;

    @SerializedName("status_message")
    private final String statusMessage;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public HomePageDTO() {
        this(null, false, 0, null, null, null, null, null, null, 511, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HomePageDTO copy$default(HomePageDTO r10, HomePageBffDTO r11, boolean r12, int r13, Integer r14, String r15, String r16, Map r17, List r18, Integer r19, int r20, Object r21) {
        if ((r20 & 1) == 0) goto L5;
        HomePageBffDTO r2 = r10.bff;
    L7:
        if ((r20 & 2) == 0) goto L9;
        boolean r3 = r10.hasMore;
    L11:
        if ((r20 & 4) == 0) goto L13;
        int r4 = r10.cursor;
    L15:
        if ((r20 & 8) == 0) goto L17;
        Integer r5 = r10.statusCode;
    L19:
        if ((r20 & 16) == 0) goto L21;
        String r6 = r10.statusMessage;
    L23:
        if ((r20 & 32) == 0) goto L25;
        String r7 = r10.chunkedSection;
    L27:
        if ((r20 & 64) == 0) goto L29;
        Map r8 = r10.serverTiming;
    L31:
        if ((r20 & 128) == 0) goto L33;
        List r9 = r10.chunkDataList;
    L35:
        if ((r20 & 256) == 0) goto L37;
        Integer r1 = r10.dataReuseStatus;
    L39:
        return r10.copy(r2, r3, r4, r5, r6, r7, r8, r9, r1);
    L37:
        r1 = r19;
        goto L39
    L33:
        r9 = r18;
        goto L35
    L29:
        r8 = r17;
        goto L31
    L25:
        r7 = r16;
        goto L27
    L21:
        r6 = r15;
        goto L23
    L17:
        r5 = r14;
        goto L19
    L13:
        r4 = r13;
        goto L15
    L9:
        r3 = r12;
        goto L11
    L5:
        r2 = r11;
        goto L7
    }

    public final HomePageBffDTO component1() {
        return this.bff;
    }

    public final boolean component2() {
        return this.hasMore;
    }

    public final int component3() {
        return this.cursor;
    }

    public final Integer component4() {
        return this.statusCode;
    }

    public final String component5() {
        return this.statusMessage;
    }

    public final String component6() {
        return this.chunkedSection;
    }

    public final Map<String, Object> component7() {
        return this.serverTiming;
    }

    public final List<ChunkedSectionData> component8() {
        return this.chunkDataList;
    }

    public final Integer component9() {
        return this.dataReuseStatus;
    }

    public final HomePageDTO copy(HomePageBffDTO r12, boolean r13, int r14, Integer r15, String r16, String r17, Map<String, ? extends Object> r18, List<ChunkedSectionData> r19, Integer r20) {
        return new HomePageDTO(r12, r13, r14, r15, r16, r17, r18, r19, r20);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof HomePageDTO) == false) goto L24;
        HomePageDTO r4 = (HomePageDTO) r3;
        if (Intrinsics.areEqual(this.bff, r4.bff) == true) goto L8;
        return false;
    L8:
        if (this.hasMore == r4.hasMore) goto L10;
        return false;
    L10:
        if (this.cursor == r4.cursor) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.statusCode, r4.statusCode) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.statusMessage, r4.statusMessage) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.chunkedSection, r4.chunkedSection) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.serverTiming, r4.serverTiming) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.chunkDataList, r4.chunkDataList) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.dataReuseStatus, r4.dataReuseStatus) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25 */
    public int hashCode() {
        HomePageBffDTO r0 = this.bff;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        boolean r4 = this.hasMore;
        ?? r5 = r4;
        if (r4 == false) goto L9;
        r5 = 1;
    L9:
        int r6 = (((r3 + r5) * 31) + this.cursor) * 31;
        Integer r7 = this.statusCode;
        if (r7 == null) goto L12;
        int r8 = r7.hashCode();
    L13:
        int r9 = (r6 + r8) * 31;
        String r10 = this.statusMessage;
        if (r10 == null) goto L16;
        int r11 = r10.hashCode();
    L17:
        int r12 = (r9 + r11) * 31;
        String r13 = this.chunkedSection;
        if (r13 == null) goto L20;
        int r14 = r13.hashCode();
    L21:
        int r15 = (r12 + r14) * 31;
        Map<String, ? extends Object> r16 = this.serverTiming;
        if (r16 == null) goto L24;
        int r17 = r16.hashCode();
    L25:
        int r18 = (r15 + r17) * 31;
        List<ChunkedSectionData> r19 = this.chunkDataList;
        if (r19 == null) goto L28;
        int r20 = r19.hashCode();
    L29:
        int r21 = (r18 + r20) * 31;
        Integer r22 = this.dataReuseStatus;
        if (r22 == null) goto L33;
        r1 = r22.hashCode();
    L33:
        return r21 + r1;
    L28:
        r20 = 0;
        goto L29
    L24:
        r17 = 0;
        goto L25
    L20:
        r14 = 0;
        goto L21
    L16:
        r11 = 0;
        goto L17
    L12:
        r8 = 0;
        goto L13
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "HomePageDTO(bff=" + this.bff + ", hasMore=" + this.hasMore + ", cursor=" + this.cursor + ", statusCode=" + this.statusCode + ", statusMessage=" + this.statusMessage + ", chunkedSection=" + this.chunkedSection + ", serverTiming=" + this.serverTiming + ", chunkDataList=" + this.chunkDataList + ", dataReuseStatus=" + this.dataReuseStatus + ")";
    }

    public final HomePageBffDTO getBff() {
        return this.bff;
    }

    public final List<ChunkedSectionData> getChunkDataList() {
        return this.chunkDataList;
    }

    public final String getChunkedSection() {
        return this.chunkedSection;
    }

    public final int getCursor() {
        return this.cursor;
    }

    public final Integer getDataReuseStatus() {
        return this.dataReuseStatus;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final Map<String, Object> getServerTiming() {
        return this.serverTiming;
    }

    public final Integer getStatusCode() {
        return this.statusCode;
    }

    public final String getStatusMessage() {
        return this.statusMessage;
    }

    public final void setBff(HomePageBffDTO r1) {
        this.bff = r1;
    }

    public final void setChunkDataList(List<ChunkedSectionData> r1) {
        this.chunkDataList = r1;
    }

    public final void setChunkedSection(String r1) {
        this.chunkedSection = r1;
    }

    public final void setDataReuseStatus(Integer r1) {
        this.dataReuseStatus = r1;
    }

    public final void setServerTiming(Map<String, ? extends Object> r1) {
        this.serverTiming = r1;
    }

    public HomePageDTO(HomePageBffDTO r1, boolean r2, int r3, Integer r4, String r5, String r6, Map<String, ? extends Object> r7, List<ChunkedSectionData> r8, Integer r9) {
        this.bff = r1;
        this.hasMore = r2;
        this.cursor = r3;
        this.statusCode = r4;
        this.statusMessage = r5;
        this.chunkedSection = r6;
        this.serverTiming = r7;
        this.chunkDataList = r8;
        this.dataReuseStatus = r9;
    }

    public /* synthetic */ HomePageDTO(HomePageBffDTO r12, boolean r13, int r14, Integer r15, String r16, String r17, Map r18, List r19, Integer r20, int r21, DefaultConstructorMarker r22) {
        List r2 = null;
        if ((r21 & 1) == 0) goto L5;
        HomePageBffDTO r1 = null;
    L7:
        if ((r21 & 2) == 0) goto L9;
        boolean r3 = true;
    L11:
        if ((r21 & 4) == 0) goto L13;
        int r4 = 0;
    L15:
        if ((r21 & 8) == 0) goto L17;
        Integer r6 = 0;
    L19:
        if ((r21 & 16) == 0) goto L21;
        String r7 = null;
    L23:
        if ((r21 & 32) == 0) goto L25;
        String r8 = null;
    L27:
        if ((r21 & 64) == 0) goto L29;
        Map r9 = null;
    L31:
        if ((r21 & 128) != 0) goto L35;
        r2 = r19;
    L35:
        if ((r21 & 256) == 0) goto L37;
        Integer r0 = 0;
    L38:
        this(r1, r3, r4, r6, r7, r8, r9, r2, r0);
        return;
    L37:
        r0 = r20;
        goto L38
    L29:
        r9 = r18;
        goto L31
    L25:
        r8 = r17;
        goto L27
    L21:
        r7 = r16;
        goto L23
    L17:
        r6 = r15;
        goto L19
    L13:
        r4 = r14;
        goto L15
    L9:
        r3 = r13;
        goto L11
    L5:
        r1 = r12;
        goto L7
    }
}
