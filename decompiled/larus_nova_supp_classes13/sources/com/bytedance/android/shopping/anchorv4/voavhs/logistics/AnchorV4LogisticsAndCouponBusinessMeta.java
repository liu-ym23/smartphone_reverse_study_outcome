package com.bytedance.android.shopping.anchorv4.voavhs.logistics;

import com.bytedance.android.shopping.anchorv4.dto.adapter.JsonToStringAdapter;
import com.bytedance.android.shopping.extensions.k;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b0\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001BÕ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0012HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0011\u0010:\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tHÆ\u0003J\u0011\u0010;\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tHÆ\u0003J\u0011\u0010<\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tHÆ\u0003J\u0010\u0010=\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010\u001dJ\u000b\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003JÞ\u0001\u0010?\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010@J\u0013\u0010A\u001a\u00020\u00122\b\u0010B\u001a\u0004\u0018\u00010CHÖ\u0003J\b\u0010D\u001a\u0004\u0018\u00010\u0003J\b\u0010E\u001a\u0004\u0018\u00010\u0003J\b\u0010F\u001a\u0004\u0018\u00010\u0003J\t\u0010G\u001a\u00020\u000bHÖ\u0001J\t\u0010H\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u0016\u0010\u0011\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001aR\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010%R\u001e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010%R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001aR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001aR\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001aR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001aR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001a¨\u0006I"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/logistics/AnchorV4LogisticsAndCouponBusinessMeta;", "Ljava/io/Serializable;", "services", "", "specialService", "couponMeta", "openInfoMeta", "Lcom/bytedance/android/shopping/anchorv4/voavhs/logistics/OpenInfoMeta;", "logisticsJumpUrls", "", "logisticsTextType", "", "logisticsType", "deliveryStatus", "", "rawData", "logData", "hasLogistics", "", "newbieServiceUrl", "carModelLink", "hasAddCar", "guaranteeHeaderUrl", "servicePanelUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/shopping/anchorv4/voavhs/logistics/OpenInfoMeta;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCarModelLink", "()Ljava/lang/String;", "getCouponMeta", "getDeliveryStatus", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getGuaranteeHeaderUrl", "getHasAddCar", "getHasLogistics", "()Z", "getLogData", "getLogisticsJumpUrls", "()Ljava/util/List;", "getLogisticsTextType", "getLogisticsType", "getNewbieServiceUrl", "getOpenInfoMeta", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/logistics/OpenInfoMeta;", "getRawData", "getServicePanelUrl", "getServices", "getSpecialService", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/shopping/anchorv4/voavhs/logistics/OpenInfoMeta;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/android/shopping/anchorv4/voavhs/logistics/AnchorV4LogisticsAndCouponBusinessMeta;", "equals", "other", "", "getServiceTypes", "getTextTypes", "getTypes", "hashCode", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4LogisticsAndCouponBusinessMeta implements Serializable {

    @SerializedName("car_model_link")
    private final String carModelLink;

    @SerializedName("coupon_meta")
    @JsonAdapter(JsonToStringAdapter.class)
    private final String couponMeta;

    @SerializedName("delivery_status")
    private final Long deliveryStatus;

    @SerializedName("guarantee_header_url")
    private final String guaranteeHeaderUrl;

    @SerializedName("has_add_car")
    private final String hasAddCar;

    @SerializedName("has_logistics")
    private final boolean hasLogistics;

    @SerializedName("log_data")
    private final String logData;

    @SerializedName("logistics_jump_urls")
    private final List<String> logisticsJumpUrls;

    @SerializedName("logistics_text_types")
    private final List<Integer> logisticsTextType;

    @SerializedName("logistics_types")
    private final List<Integer> logisticsType;

    @SerializedName("newbie_service_url")
    private final String newbieServiceUrl;

    @SerializedName("open_info")
    private final OpenInfoMeta openInfoMeta;

    @SerializedName("raw_data")
    @JsonAdapter(JsonToStringAdapter.class)
    private final String rawData;

    @SerializedName("new_services_panel_url")
    private final String servicePanelUrl;

    @SerializedName("services")
    @JsonAdapter(JsonToStringAdapter.class)
    private final String services;

    @SerializedName("special_services")
    @JsonAdapter(JsonToStringAdapter.class)
    private final String specialService;

    public AnchorV4LogisticsAndCouponBusinessMeta() {
        this(null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, 65535, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AnchorV4LogisticsAndCouponBusinessMeta copy$default(AnchorV4LogisticsAndCouponBusinessMeta r17, String r18, String r19, String r20, OpenInfoMeta r21, List r22, List r23, List r24, Long r25, String r26, String r27, boolean r28, String r29, String r30, String r31, String r32, String r33, int r34, Object r35) {
        if ((r34 & 1) == 0) goto L5;
        String r2 = r17.services;
    L7:
        if ((r34 & 2) == 0) goto L9;
        String r3 = r17.specialService;
    L11:
        if ((r34 & 4) == 0) goto L13;
        String r4 = r17.couponMeta;
    L15:
        if ((r34 & 8) == 0) goto L17;
        OpenInfoMeta r5 = r17.openInfoMeta;
    L19:
        if ((r34 & 16) == 0) goto L21;
        List r6 = r17.logisticsJumpUrls;
    L23:
        if ((r34 & 32) == 0) goto L25;
        List r7 = r17.logisticsTextType;
    L27:
        if ((r34 & 64) == 0) goto L29;
        List r8 = r17.logisticsType;
    L31:
        if ((r34 & 128) == 0) goto L33;
        Long r9 = r17.deliveryStatus;
    L35:
        if ((r34 & 256) == 0) goto L37;
        String r10 = r17.rawData;
    L39:
        if ((r34 & 512) == 0) goto L41;
        String r11 = r17.logData;
    L43:
        if ((r34 & 1024) == 0) goto L45;
        boolean r12 = r17.hasLogistics;
    L47:
        if ((r34 & 2048) == 0) goto L49;
        String r13 = r17.newbieServiceUrl;
    L51:
        if ((r34 & 4096) == 0) goto L53;
        String r14 = r17.carModelLink;
    L55:
        if ((r34 & 8192) == 0) goto L57;
        String r15 = r17.hasAddCar;
    L58:
        String r36 = r15;
        if ((r34 & 16384) == 0) goto L61;
        String r16 = r17.guaranteeHeaderUrl;
    L63:
        if ((r34 & 32768) == 0) goto L65;
        String r1 = r17.servicePanelUrl;
    L67:
        return r17.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r36, r16, r1);
    L65:
        r1 = r33;
        goto L67
    L61:
        r16 = r32;
        goto L63
    L57:
        r15 = r31;
        goto L58
    L53:
        r14 = r30;
        goto L55
    L49:
        r13 = r29;
        goto L51
    L45:
        r12 = r28;
        goto L47
    L41:
        r11 = r27;
        goto L43
    L37:
        r10 = r26;
        goto L39
    L33:
        r9 = r25;
        goto L35
    L29:
        r8 = r24;
        goto L31
    L25:
        r7 = r23;
        goto L27
    L21:
        r6 = r22;
        goto L23
    L17:
        r5 = r21;
        goto L19
    L13:
        r4 = r20;
        goto L15
    L9:
        r3 = r19;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }

    public final String component1() {
        return this.services;
    }

    public final String component10() {
        return this.logData;
    }

    public final boolean component11() {
        return this.hasLogistics;
    }

    public final String component12() {
        return this.newbieServiceUrl;
    }

    public final String component13() {
        return this.carModelLink;
    }

    public final String component14() {
        return this.hasAddCar;
    }

    public final String component15() {
        return this.guaranteeHeaderUrl;
    }

    public final String component16() {
        return this.servicePanelUrl;
    }

    public final String component2() {
        return this.specialService;
    }

    public final String component3() {
        return this.couponMeta;
    }

    public final OpenInfoMeta component4() {
        return this.openInfoMeta;
    }

    public final List<String> component5() {
        return this.logisticsJumpUrls;
    }

    public final List<Integer> component6() {
        return this.logisticsTextType;
    }

    public final List<Integer> component7() {
        return this.logisticsType;
    }

    public final Long component8() {
        return this.deliveryStatus;
    }

    public final String component9() {
        return this.rawData;
    }

    public final AnchorV4LogisticsAndCouponBusinessMeta copy(String r19, String r20, String r21, OpenInfoMeta r22, List<String> r23, List<Integer> r24, List<Integer> r25, Long r26, String r27, String r28, boolean r29, String r30, String r31, String r32, String r33, String r34) {
        return new AnchorV4LogisticsAndCouponBusinessMeta(r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof AnchorV4LogisticsAndCouponBusinessMeta) == false) goto L38;
        AnchorV4LogisticsAndCouponBusinessMeta r4 = (AnchorV4LogisticsAndCouponBusinessMeta) r3;
        if (Intrinsics.areEqual(this.services, r4.services) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.specialService, r4.specialService) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.couponMeta, r4.couponMeta) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.openInfoMeta, r4.openInfoMeta) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.logisticsJumpUrls, r4.logisticsJumpUrls) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.logisticsTextType, r4.logisticsTextType) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.logisticsType, r4.logisticsType) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.deliveryStatus, r4.deliveryStatus) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.rawData, r4.rawData) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.logData, r4.logData) == true) goto L26;
        return false;
    L26:
        if (this.hasLogistics == r4.hasLogistics) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.newbieServiceUrl, r4.newbieServiceUrl) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.carModelLink, r4.carModelLink) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.hasAddCar, r4.hasAddCar) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.guaranteeHeaderUrl, r4.guaranteeHeaderUrl) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.servicePanelUrl, r4.servicePanelUrl) == true) goto L58;
        return false;
    L58:
        return true;
    L38:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v22, types: [int] */
    /* JADX WARN: Type inference failed for: r2v28, types: [int] */
    /* JADX WARN: Type inference failed for: r2v46 */
    /* JADX WARN: Type inference failed for: r2v56 */
    public int hashCode() {
        String r0 = this.services;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.specialService;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.couponMeta;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        OpenInfoMeta r10 = this.openInfoMeta;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        List<String> r13 = this.logisticsJumpUrls;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        List<Integer> r16 = this.logisticsTextType;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        List<Integer> r19 = this.logisticsType;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        Long r22 = this.deliveryStatus;
        if (r22 == null) goto L33;
        int r23 = r22.hashCode();
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.rawData;
        if (r25 == null) goto L37;
        int r26 = r25.hashCode();
    L38:
        int r27 = (r24 + r26) * 31;
        String r28 = this.logData;
        if (r28 == null) goto L41;
        int r29 = r28.hashCode();
    L42:
        int r30 = (r27 + r29) * 31;
        boolean r31 = this.hasLogistics;
        ?? r32 = r31;
        if (r31 == false) goto L45;
        r32 = 1;
    L45:
        int r33 = (r30 + r32) * 31;
        String r34 = this.newbieServiceUrl;
        if (r34 == null) goto L48;
        int r35 = r34.hashCode();
    L49:
        int r36 = (r33 + r35) * 31;
        String r37 = this.carModelLink;
        if (r37 == null) goto L52;
        int r38 = r37.hashCode();
    L53:
        int r39 = (r36 + r38) * 31;
        String r40 = this.hasAddCar;
        if (r40 == null) goto L56;
        int r41 = r40.hashCode();
    L57:
        int r42 = (r39 + r41) * 31;
        String r43 = this.guaranteeHeaderUrl;
        if (r43 == null) goto L60;
        int r44 = r43.hashCode();
    L61:
        int r45 = (r42 + r44) * 31;
        String r46 = this.servicePanelUrl;
        if (r46 == null) goto L65;
        r1 = r46.hashCode();
    L65:
        return r45 + r1;
    L60:
        r44 = 0;
        goto L61
    L56:
        r41 = 0;
        goto L57
    L52:
        r38 = 0;
        goto L53
    L48:
        r35 = 0;
        goto L49
    L41:
        r29 = 0;
        goto L42
    L37:
        r26 = 0;
        goto L38
    L33:
        r23 = 0;
        goto L34
    L29:
        r20 = 0;
        goto L30
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
        return "AnchorV4LogisticsAndCouponBusinessMeta(services=" + this.services + ", specialService=" + this.specialService + ", couponMeta=" + this.couponMeta + ", openInfoMeta=" + this.openInfoMeta + ", logisticsJumpUrls=" + this.logisticsJumpUrls + ", logisticsTextType=" + this.logisticsTextType + ", logisticsType=" + this.logisticsType + ", deliveryStatus=" + this.deliveryStatus + ", rawData=" + this.rawData + ", logData=" + this.logData + ", hasLogistics=" + this.hasLogistics + ", newbieServiceUrl=" + this.newbieServiceUrl + ", carModelLink=" + this.carModelLink + ", hasAddCar=" + this.hasAddCar + ", guaranteeHeaderUrl=" + this.guaranteeHeaderUrl + ", servicePanelUrl=" + this.servicePanelUrl + ")";
    }

    public final String getServiceTypes() {
        String r0 = this.services;
        if (r0 == null) goto L5;
        JSONArray r1 = k.t(r0);
    L6:
        int r2 = 0;
        if (r1 == null) goto L9;
        int r3 = r1.length();
    L10:
        if (r3 <= 0) goto L28;
        ArrayList r4 = new ArrayList();
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L24
        if (r1 == null) goto L15;
        int r6 = r1.length();     // Catch: Throwable -> L24
    L16:
        if (r2 >= r6) goto L22;
        if (r1 == null) goto L21;
        JSONObject r7 = r1.optJSONObject(r2);     // Catch: Throwable -> L24
        if (r7 == null) goto L21;
        r4.add(Integer.valueOf(r7.optInt("service_type")));     // Catch: Throwable -> L24
    L21:
        r2 = r2 + 1;     // Catch: Throwable -> L24
        goto L16
    L22:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L24
    L27:
        return CollectionsKt.joinToString$default(r4, ",", "[", "]", 0, null, null, 56, null);
    L15:
        r6 = 0;
    L24:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L27
    L28:
        return null;
    L9:
        r3 = 0;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    public final String getTextTypes() {
        List<Integer> r0 = this.logisticsTextType;
        if (r0 != null) goto L7;
        return null;
    L7:
        return CollectionsKt.joinToString$default(r0, ",", null, null, 0, null, null, 62, null);
    }

    public final String getTypes() {
        List<Integer> r0 = this.logisticsType;
        if (r0 != null) goto L7;
        return null;
    L7:
        return CollectionsKt.joinToString$default(r0, ",", null, null, 0, null, null, 62, null);
    }

    public final String getCarModelLink() {
        return this.carModelLink;
    }

    public final String getCouponMeta() {
        return this.couponMeta;
    }

    public final Long getDeliveryStatus() {
        return this.deliveryStatus;
    }

    public final String getGuaranteeHeaderUrl() {
        return this.guaranteeHeaderUrl;
    }

    public final String getHasAddCar() {
        return this.hasAddCar;
    }

    public final boolean getHasLogistics() {
        return this.hasLogistics;
    }

    public final String getLogData() {
        return this.logData;
    }

    public final List<String> getLogisticsJumpUrls() {
        return this.logisticsJumpUrls;
    }

    public final List<Integer> getLogisticsTextType() {
        return this.logisticsTextType;
    }

    public final List<Integer> getLogisticsType() {
        return this.logisticsType;
    }

    public final String getNewbieServiceUrl() {
        return this.newbieServiceUrl;
    }

    public final OpenInfoMeta getOpenInfoMeta() {
        return this.openInfoMeta;
    }

    public final String getRawData() {
        return this.rawData;
    }

    public final String getServicePanelUrl() {
        return this.servicePanelUrl;
    }

    public final String getServices() {
        return this.services;
    }

    public final String getSpecialService() {
        return this.specialService;
    }

    public AnchorV4LogisticsAndCouponBusinessMeta(String r3, String r4, String r5, OpenInfoMeta r6, List<String> r7, List<Integer> r8, List<Integer> r9, Long r10, String r11, String r12, boolean r13, String r14, String r15, String r16, String r17, String r18) {
        this.services = r3;
        this.specialService = r4;
        this.couponMeta = r5;
        this.openInfoMeta = r6;
        this.logisticsJumpUrls = r7;
        this.logisticsTextType = r8;
        this.logisticsType = r9;
        this.deliveryStatus = r10;
        this.rawData = r11;
        this.logData = r12;
        this.hasLogistics = r13;
        this.newbieServiceUrl = r14;
        this.carModelLink = r15;
        this.hasAddCar = r16;
        this.guaranteeHeaderUrl = r17;
        this.servicePanelUrl = r18;
    }

    public /* synthetic */ AnchorV4LogisticsAndCouponBusinessMeta(String r18, String r19, String r20, OpenInfoMeta r21, List r22, List r23, List r24, Long r25, String r26, String r27, boolean r28, String r29, String r30, String r31, String r32, String r33, int r34, DefaultConstructorMarker r35) {
        if ((r34 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r34 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r34 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r34 & 8) == 0) goto L17;
        OpenInfoMeta r5 = null;
    L19:
        if ((r34 & 16) == 0) goto L21;
        List r6 = null;
    L23:
        if ((r34 & 32) == 0) goto L25;
        List r7 = null;
    L27:
        if ((r34 & 64) == 0) goto L29;
        List r8 = null;
    L31:
        if ((r34 & 128) == 0) goto L33;
        Long r9 = null;
    L35:
        if ((r34 & 256) == 0) goto L37;
        String r10 = null;
    L39:
        if ((r34 & 512) == 0) goto L41;
        String r11 = null;
    L43:
        if ((r34 & 1024) == 0) goto L45;
        boolean r12 = false;
    L47:
        if ((r34 & 2048) == 0) goto L49;
        String r13 = null;
    L51:
        if ((r34 & 4096) == 0) goto L53;
        String r14 = null;
    L55:
        if ((r34 & 8192) == 0) goto L57;
        String r15 = null;
    L59:
        if ((r34 & 16384) == 0) goto L61;
        String r2 = null;
    L63:
        if ((r34 & 32768) == 0) goto L65;
        String r0 = null;
    L66:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r2, r0);
        return;
    L65:
        r0 = r33;
        goto L66
    L61:
        r2 = r32;
        goto L63
    L57:
        r15 = r31;
        goto L59
    L53:
        r14 = r30;
        goto L55
    L49:
        r13 = r29;
        goto L51
    L45:
        r12 = r28;
        goto L47
    L41:
        r11 = r27;
        goto L43
    L37:
        r10 = r26;
        goto L39
    L33:
        r9 = r25;
        goto L35
    L29:
        r8 = r24;
        goto L31
    L25:
        r7 = r23;
        goto L27
    L21:
        r6 = r22;
        goto L23
    L17:
        r5 = r21;
        goto L19
    L13:
        r4 = r20;
        goto L15
    L9:
        r3 = r19;
        goto L11
    L5:
        r1 = r18;
        goto L7
    }
}
