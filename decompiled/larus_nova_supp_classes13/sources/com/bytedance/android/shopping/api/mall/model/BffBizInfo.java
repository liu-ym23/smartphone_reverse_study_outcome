package com.bytedance.android.shopping.api.mall.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001Bs\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0018\b\u0002\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007HÆ\u0003J\u0011\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0019\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\fHÆ\u0003J|\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\u0018\b\u0002\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u0003HÖ\u0001J\t\u0010'\u001a\u00020\u0005HÖ\u0001R&\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u001a\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0018\u0010\u0016R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011¨\u0006("}, d2 = {"Lcom/bytedance/android/shopping/api/mall/model/BffBizInfo;", "", "offset", "", "requestId", "", "filters", "", "followTabShopFilters", "ecSceneId", "loginStatus", "bizIdentity", "", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/Map;)V", "getBizIdentity", "()Ljava/util/Map;", "getEcSceneId", "()Ljava/lang/String;", "getFilters", "()Ljava/util/List;", "getFollowTabShopFilters", "getLoginStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getOffset", "getRequestId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/Map;)Lcom/bytedance/android/shopping/api/mall/model/BffBizInfo;", "equals", "", "other", "hashCode", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BffBizInfo {

    @SerializedName("biz_identity")
    private final Map<String, Object> bizIdentity;

    @SerializedName("ecom_scene_id")
    private final String ecSceneId;

    @SerializedName("filters")
    private final List<String> filters;

    @SerializedName("follow_tab_shop_filters")
    private final List<String> followTabShopFilters;

    @SerializedName("login_status")
    private final Integer loginStatus;

    @SerializedName("recommend_back_up_offset")
    private final Integer offset;

    @SerializedName("request_id")
    private final String requestId;

    public BffBizInfo() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BffBizInfo copy$default(BffBizInfo r5, Integer r6, String r7, List r8, List r9, String r10, Integer r11, Map r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.offset;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.requestId;
    L8:
        String r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.filters;
    L11:
        List r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.followTabShopFilters;
    L14:
        List r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.ecSceneId;
    L17:
        String r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.loginStatus;
    L20:
        Integer r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.bizIdentity;
    L23:
        Integer r16 = r6;
        return r5.copy(r16, r15, r0, r1, r2, r3, r12);
    }

    public final Integer component1() {
        return this.offset;
    }

    public final String component2() {
        return this.requestId;
    }

    public final List<String> component3() {
        return this.filters;
    }

    public final List<String> component4() {
        return this.followTabShopFilters;
    }

    public final String component5() {
        return this.ecSceneId;
    }

    public final Integer component6() {
        return this.loginStatus;
    }

    public final Map<String, Object> component7() {
        return this.bizIdentity;
    }

    public final BffBizInfo copy(Integer r10, String r11, List<String> r12, List<String> r13, String r14, Integer r15, Map<String, ? extends Object> r16) {
        return new BffBizInfo(r10, r11, r12, r13, r14, r15, r16);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof BffBizInfo) == false) goto L20;
        BffBizInfo r4 = (BffBizInfo) r3;
        if (Intrinsics.areEqual(this.offset, r4.offset) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.requestId, r4.requestId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.filters, r4.filters) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.followTabShopFilters, r4.followTabShopFilters) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.ecSceneId, r4.ecSceneId) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.loginStatus, r4.loginStatus) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.bizIdentity, r4.bizIdentity) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        Integer r0 = this.offset;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.requestId;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        List<String> r7 = this.filters;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        List<String> r10 = this.followTabShopFilters;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.ecSceneId;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        Integer r16 = this.loginStatus;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        Map<String, Object> r19 = this.bizIdentity;
        if (r19 == null) goto L30;
        r1 = r19.hashCode();
    L30:
        return r18 + r1;
    L25:
        r17 = 0;
        goto L26
    L21:
        r14 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "BffBizInfo(offset=" + this.offset + ", requestId=" + this.requestId + ", filters=" + this.filters + ", followTabShopFilters=" + this.followTabShopFilters + ", ecSceneId=" + this.ecSceneId + ", loginStatus=" + this.loginStatus + ", bizIdentity=" + this.bizIdentity + ")";
    }

    public final Map<String, Object> getBizIdentity() {
        return this.bizIdentity;
    }

    public final String getEcSceneId() {
        return this.ecSceneId;
    }

    public final List<String> getFilters() {
        return this.filters;
    }

    public final List<String> getFollowTabShopFilters() {
        return this.followTabShopFilters;
    }

    public final Integer getLoginStatus() {
        return this.loginStatus;
    }

    public final Integer getOffset() {
        return this.offset;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public BffBizInfo(Integer r1, String r2, List<String> r3, List<String> r4, String r5, Integer r6, Map<String, ? extends Object> r7) {
        this.offset = r1;
        this.requestId = r2;
        this.filters = r3;
        this.followTabShopFilters = r4;
        this.ecSceneId = r5;
        this.loginStatus = r6;
        this.bizIdentity = r7;
    }

    public /* synthetic */ BffBizInfo(Integer r6, String r7, List r8, List r9, String r10, Integer r11, Map r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 1) == 0) goto L5;
        r6 = 0;
    L5:
        Map r0 = null;
        if ((r13 & 2) == 0) goto L8;
        String r15 = null;
    L10:
        if ((r13 & 4) == 0) goto L12;
        List r1 = null;
    L14:
        if ((r13 & 8) == 0) goto L16;
        List r2 = null;
    L18:
        if ((r13 & 16) == 0) goto L20;
        String r3 = null;
    L22:
        if ((r13 & 32) == 0) goto L24;
        Integer r4 = null;
    L26:
        if ((r13 & 64) != 0) goto L29;
        r0 = r12;
    L29:
        this(r6, r15, r1, r2, r3, r4, r0);
        return;
    L24:
        r4 = r11;
        goto L26
    L20:
        r3 = r10;
        goto L22
    L16:
        r2 = r9;
        goto L18
    L12:
        r1 = r8;
        goto L14
    L8:
        r15 = r7;
        goto L10
    }
}
