package com.bytedance.android.livesdk.livecommerce.intro.model.resp;

import com.bytedance.android.ec.model.response.StandardEventTrack;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R*\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R*\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000f\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R*\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010\u0005\u001a\u0004\b$\u0010\u0007R\u001c\u0010%\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R(\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b)\u0010\u0005\u001a\u0004\b*\u0010\u0007R\u001c\u0010,\u001a\u0004\u0018\u00010+8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u001c\u00101\u001a\u0004\u0018\u0001008\u0006X\u0087\u0004¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104¨\u00065"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/q0;", "", "", "", "uiFrame", "Ljava/util/Map;", "h", "()Ljava/util/Map;", "uiFrameV2", "i", "uiTemplate", "Ljava/lang/String;", "j", "()Ljava/lang/String;", "", "status", "I", "getStatus", "()I", "", "", "durations", "Ljava/util/List;", "c", "()Ljava/util/List;", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/IntroProduct;", "product", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/IntroProduct;", "e", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/IntroProduct;", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/h;", "bizExtendParam", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/h;", "a", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/h;", "auctionInfo", "getAuctionInfo", "cardType", "Ljava/lang/Integer;", "b", "()Ljava/lang/Integer;", "eventParams", "d", "Lcom/bytedance/android/ec/model/response/StandardEventTrack;", "standardEventTrack", "Lcom/bytedance/android/ec/model/response/StandardEventTrack;", "f", "()Lcom/bytedance/android/ec/model/response/StandardEventTrack;", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/j0;", "track", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/j0;", "g", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/j0;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class q0 {

    @SerializedName("auction_info")
    private final Map<String, Object> auctionInfo;

    @SerializedName("biz_extend_param")
    private final h bizExtendParam;

    @SerializedName("card_type")
    private final Integer cardType;

    @SerializedName("durations")
    private final List<Long> durations;

    @SerializedName("event_param")
    private final Map<String, String> eventParams;

    @SerializedName("product")
    private final IntroProduct product;

    @SerializedName("standard_event_track")
    private final StandardEventTrack standardEventTrack;

    @SerializedName("status")
    private final int status;

    @SerializedName("track")
    private final j0 track;

    @SerializedName("ui_frame")
    private final Map<String, Object> uiFrame;

    @SerializedName("ui_frame_v2")
    private final Map<String, Object> uiFrameV2;

    @SerializedName("ui_template")
    private final String uiTemplate;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof q0) == false) goto L30;
        q0 r4 = (q0) r3;
        if (Intrinsics.areEqual(this.uiFrame, r4.uiFrame) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.uiFrameV2, r4.uiFrameV2) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.uiTemplate, r4.uiTemplate) == true) goto L12;
        return false;
    L12:
        if (this.status == r4.status) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.durations, r4.durations) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.product, r4.product) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.bizExtendParam, r4.bizExtendParam) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.auctionInfo, r4.auctionInfo) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.cardType, r4.cardType) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.eventParams, r4.eventParams) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.standardEventTrack, r4.standardEventTrack) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.track, r4.track) == true) goto L46;
        return false;
    L46:
        return true;
    L30:
        return false;
    }

    public final int hashCode() {
        Map<String, Object> r0 = this.uiFrame;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Map<String, Object> r4 = this.uiFrameV2;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.uiTemplate;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (((r6 + r8) * 31) + this.status) * 31;
        List<Long> r10 = this.durations;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        IntroProduct r13 = this.product;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        h r16 = this.bizExtendParam;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        Map<String, Object> r19 = this.auctionInfo;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        Integer r22 = this.cardType;
        if (r22 == null) goto L33;
        int r23 = r22.hashCode();
    L34:
        int r24 = (r21 + r23) * 31;
        Map<String, String> r25 = this.eventParams;
        if (r25 == null) goto L37;
        int r26 = r25.hashCode();
    L38:
        int r27 = (r24 + r26) * 31;
        StandardEventTrack r28 = this.standardEventTrack;
        if (r28 == null) goto L41;
        int r29 = r28.hashCode();
    L42:
        int r30 = (r27 + r29) * 31;
        j0 r31 = this.track;
        if (r31 == null) goto L46;
        r1 = r31.hashCode();
    L46:
        return r30 + r1;
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

    public final String toString() {
        return "LiveAuctionProduct(uiFrame=" + this.uiFrame + ", uiFrameV2=" + this.uiFrameV2 + ", uiTemplate=" + this.uiTemplate + ", status=" + this.status + ", durations=" + this.durations + ", product=" + this.product + ", bizExtendParam=" + this.bizExtendParam + ", auctionInfo=" + this.auctionInfo + ", cardType=" + this.cardType + ", eventParams=" + this.eventParams + ", standardEventTrack=" + this.standardEventTrack + ", track=" + this.track + ")";
    }

    public q0() {
        this.uiFrame = null;
        this.uiFrameV2 = null;
        this.uiTemplate = null;
        this.status = 0;
        this.durations = null;
        this.product = null;
        this.bizExtendParam = null;
        this.auctionInfo = null;
        this.cardType = null;
        this.eventParams = null;
        this.standardEventTrack = null;
        this.track = null;
    }

    public final h a() {
        return this.bizExtendParam;
    }

    public final Integer b() {
        return this.cardType;
    }

    public final List<Long> c() {
        return this.durations;
    }

    public final Map<String, String> d() {
        return this.eventParams;
    }

    public final IntroProduct e() {
        return this.product;
    }

    public final StandardEventTrack f() {
        return this.standardEventTrack;
    }

    public final j0 g() {
        return this.track;
    }

    public final Map<String, Object> h() {
        return this.uiFrame;
    }

    public final Map<String, Object> i() {
        return this.uiFrameV2;
    }

    public final String j() {
        return this.uiTemplate;
    }
}
