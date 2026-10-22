package com.bytedance.android.livesdk.livecommerce.playback.model;

import com.bytedance.android.ec.model.playback.ECReplayVideo;
import com.bytedance.android.ec.model.playback.ExplainPlaybackVideoInfo;
import com.bytedance.android.ec.model.playback.ReplayCards;
import com.bytedance.android.ec.model.response.ECPromotion;
import com.bytedance.android.ec.model.response.ECPromotionCampaign;
import com.bytedance.android.ec.model.response.ECRitTag;
import com.bytedance.bdlocation.network.model.DeviceStatus$DiffDimension;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B§\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0018J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u00106\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010%J\u000b\u00107\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0011\u0010:\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003J\u0011\u0010;\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000bHÆ\u0003J\t\u0010<\u001a\u00020\u0010HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0001HÆ\u0003J´\u0001\u0010?\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0010HÆ\u0001¢\u0006\u0002\u0010@J\u0013\u0010A\u001a\u00020B2\b\u0010C\u001a\u0004\u0018\u00010DHÖ\u0003J\t\u0010E\u001a\u00020FHÖ\u0001J\t\u0010G\u001a\u00020\u0007HÖ\u0001R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010&\u001a\u0004\b$\u0010%R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b'\u0010#R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001aR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b+\u0010#R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b0\u00101¨\u0006H"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/playback/model/ExplainPlaybackFinalParams;", "Ljava/io/Serializable;", "videoInfo", "Lcom/bytedance/android/ec/model/playback/ExplainPlaybackVideoInfo;", "videoInfoV2", "Lcom/bytedance/android/ec/model/playback/ECReplayVideo;", "v3EventsAdditions", "", "ecPromotion", "Lcom/bytedance/android/ec/model/response/ECPromotion;", "commentaryTags", "", "Lcom/bytedance/android/ec/model/response/ECRitTag;", "campaignList", "Lcom/bytedance/android/ec/model/response/ECPromotionCampaign;", "serverTime", "", "roomSchema", "userInfo", "aweme", "replayCards", "Lcom/bytedance/android/ec/model/playback/ReplayCards;", "replayViewCnt", "replayViewNum", "(Lcom/bytedance/android/ec/model/playback/ExplainPlaybackVideoInfo;Lcom/bytedance/android/ec/model/playback/ECReplayVideo;Ljava/lang/String;Lcom/bytedance/android/ec/model/response/ECPromotion;Ljava/util/List;Ljava/util/List;JLjava/lang/String;Ljava/io/Serializable;Ljava/io/Serializable;Lcom/bytedance/android/ec/model/playback/ReplayCards;Ljava/lang/String;Ljava/lang/Long;)V", "getAweme", "()Ljava/io/Serializable;", "getCampaignList", "()Ljava/util/List;", "getCommentaryTags", "getEcPromotion", "()Lcom/bytedance/android/ec/model/response/ECPromotion;", "getReplayCards", "()Lcom/bytedance/android/ec/model/playback/ReplayCards;", "getReplayViewCnt", "()Ljava/lang/String;", "getReplayViewNum", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getRoomSchema", "getServerTime", "()J", "getUserInfo", "getV3EventsAdditions", "getVideoInfo", "()Lcom/bytedance/android/ec/model/playback/ExplainPlaybackVideoInfo;", "setVideoInfo", "(Lcom/bytedance/android/ec/model/playback/ExplainPlaybackVideoInfo;)V", "getVideoInfoV2", "()Lcom/bytedance/android/ec/model/playback/ECReplayVideo;", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Lcom/bytedance/android/ec/model/playback/ExplainPlaybackVideoInfo;Lcom/bytedance/android/ec/model/playback/ECReplayVideo;Ljava/lang/String;Lcom/bytedance/android/ec/model/response/ECPromotion;Ljava/util/List;Ljava/util/List;JLjava/lang/String;Ljava/io/Serializable;Ljava/io/Serializable;Lcom/bytedance/android/ec/model/playback/ReplayCards;Ljava/lang/String;Ljava/lang/Long;)Lcom/bytedance/android/livesdk/livecommerce/playback/model/ExplainPlaybackFinalParams;", "equals", "", "other", "", "hashCode", "", "toString", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ExplainPlaybackFinalParams implements Serializable {
    private final Serializable aweme;
    private final List<ECPromotionCampaign> campaignList;
    private final List<ECRitTag> commentaryTags;
    private final ECPromotion ecPromotion;
    private final ReplayCards replayCards;
    private final String replayViewCnt;
    private final Long replayViewNum;
    private final String roomSchema;
    private final long serverTime;
    private final Serializable userInfo;
    private final String v3EventsAdditions;
    private ExplainPlaybackVideoInfo videoInfo;
    private final ECReplayVideo videoInfoV2;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ExplainPlaybackFinalParams copy$default(ExplainPlaybackFinalParams r15, ExplainPlaybackVideoInfo r16, ECReplayVideo r17, String r18, ECPromotion r19, List r20, List r21, long r22, String r24, Serializable r25, Serializable r26, ReplayCards r27, String r28, Long r29, int r30, Object r31) {
        if ((r30 & 1) == 0) goto L5;
        ExplainPlaybackVideoInfo r2 = r15.videoInfo;
    L7:
        if ((r30 & 2) == 0) goto L9;
        ECReplayVideo r3 = r15.videoInfoV2;
    L11:
        if ((r30 & 4) == 0) goto L13;
        String r4 = r15.v3EventsAdditions;
    L15:
        if ((r30 & 8) == 0) goto L17;
        ECPromotion r5 = r15.ecPromotion;
    L19:
        if ((r30 & 16) == 0) goto L21;
        List r6 = r15.commentaryTags;
    L23:
        if ((r30 & 32) == 0) goto L25;
        List r7 = r15.campaignList;
    L27:
        if ((r30 & 64) == 0) goto L29;
        long r8 = r15.serverTime;
    L31:
        if ((r30 & DeviceStatus$DiffDimension.DIFF_RESTRICTED_MODE) == 0) goto L33;
        String r10 = r15.roomSchema;
    L35:
        if ((r30 & DeviceStatus$DiffDimension.DIFF_LOCATION_MODE) == 0) goto L37;
        Serializable r11 = r15.userInfo;
    L39:
        if ((r30 & DeviceStatus$DiffDimension.DIFF_IS_STRICT_RESTRICTED_MODE) == 0) goto L41;
        Serializable r12 = r15.aweme;
    L43:
        if ((r30 & DeviceStatus$DiffDimension.DIFF_BLUETOOTH_PERMISSION) == 0) goto L45;
        ReplayCards r13 = r15.replayCards;
    L47:
        if ((r30 & 2048) == 0) goto L49;
        String r14 = r15.replayViewCnt;
    L51:
        if ((r30 & 4096) == 0) goto L53;
        Long r1 = r15.replayViewNum;
    L55:
        return r15.copy(r2, r3, r4, r5, r6, r7, r8, r10, r11, r12, r13, r14, r1);
    L53:
        r1 = r29;
        goto L55
    L49:
        r14 = r28;
        goto L51
    L45:
        r13 = r27;
        goto L47
    L41:
        r12 = r26;
        goto L43
    L37:
        r11 = r25;
        goto L39
    L33:
        r10 = r24;
        goto L35
    L29:
        r8 = r22;
        goto L31
    L25:
        r7 = r21;
        goto L27
    L21:
        r6 = r20;
        goto L23
    L17:
        r5 = r19;
        goto L19
    L13:
        r4 = r18;
        goto L15
    L9:
        r3 = r17;
        goto L11
    L5:
        r2 = r16;
        goto L7
    }

    public final ExplainPlaybackVideoInfo component1() {
        return this.videoInfo;
    }

    public final Serializable component10() {
        return this.aweme;
    }

    public final ReplayCards component11() {
        return this.replayCards;
    }

    public final String component12() {
        return this.replayViewCnt;
    }

    public final Long component13() {
        return this.replayViewNum;
    }

    public final ECReplayVideo component2() {
        return this.videoInfoV2;
    }

    public final String component3() {
        return this.v3EventsAdditions;
    }

    public final ECPromotion component4() {
        return this.ecPromotion;
    }

    public final List<ECRitTag> component5() {
        return this.commentaryTags;
    }

    public final List<ECPromotionCampaign> component6() {
        return this.campaignList;
    }

    public final long component7() {
        return this.serverTime;
    }

    public final String component8() {
        return this.roomSchema;
    }

    public final Serializable component9() {
        return this.userInfo;
    }

    public final ExplainPlaybackFinalParams copy(ExplainPlaybackVideoInfo r17, ECReplayVideo r18, String r19, ECPromotion r20, List<ECRitTag> r21, List<? extends ECPromotionCampaign> r22, long r23, String r25, Serializable r26, Serializable r27, ReplayCards r28, String r29, Long r30) {
        return new ExplainPlaybackFinalParams(r17, r18, r19, r20, r21, r22, r23, r25, r26, r27, r28, r29, r30);
    }

    public boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof ExplainPlaybackFinalParams) == false) goto L32;
        ExplainPlaybackFinalParams r7 = (ExplainPlaybackFinalParams) r6;
        if (Intrinsics.areEqual(this.videoInfo, r7.videoInfo) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.videoInfoV2, r7.videoInfoV2) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.v3EventsAdditions, r7.v3EventsAdditions) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.ecPromotion, r7.ecPromotion) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.commentaryTags, r7.commentaryTags) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.campaignList, r7.campaignList) == true) goto L18;
        return false;
    L18:
        if (this.serverTime == r7.serverTime) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.roomSchema, r7.roomSchema) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.userInfo, r7.userInfo) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.aweme, r7.aweme) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.replayCards, r7.replayCards) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.replayViewCnt, r7.replayViewCnt) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.replayViewNum, r7.replayViewNum) == true) goto L49;
        return false;
    L49:
        return true;
    L32:
        return false;
    }

    public int hashCode() {
        ExplainPlaybackVideoInfo r0 = this.videoInfo;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        ECReplayVideo r4 = this.videoInfoV2;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.v3EventsAdditions;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        ECPromotion r10 = this.ecPromotion;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        List<ECRitTag> r13 = this.commentaryTags;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        List<ECPromotionCampaign> r16 = this.campaignList;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        long r19 = this.serverTime;
        int r20 = (r18 + ((int) (r19 ^ (r19 >>> 32)))) * 31;
        String r21 = this.roomSchema;
        if (r21 == null) goto L29;
        int r22 = r21.hashCode();
    L30:
        int r23 = (r20 + r22) * 31;
        Serializable r24 = this.userInfo;
        if (r24 == null) goto L33;
        int r25 = r24.hashCode();
    L34:
        int r26 = (r23 + r25) * 31;
        Serializable r27 = this.aweme;
        if (r27 == null) goto L37;
        int r28 = r27.hashCode();
    L38:
        int r29 = (r26 + r28) * 31;
        ReplayCards r30 = this.replayCards;
        if (r30 == null) goto L41;
        int r31 = r30.hashCode();
    L42:
        int r32 = (r29 + r31) * 31;
        String r33 = this.replayViewCnt;
        if (r33 == null) goto L45;
        int r34 = r33.hashCode();
    L46:
        int r35 = (r32 + r34) * 31;
        Long r36 = this.replayViewNum;
        if (r36 == null) goto L50;
        r1 = r36.hashCode();
    L50:
        return r35 + r1;
    L45:
        r34 = 0;
        goto L46
    L41:
        r31 = 0;
        goto L42
    L37:
        r28 = 0;
        goto L38
    L33:
        r25 = 0;
        goto L34
    L29:
        r22 = 0;
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
        return "ExplainPlaybackFinalParams(videoInfo=" + this.videoInfo + ", videoInfoV2=" + this.videoInfoV2 + ", v3EventsAdditions=" + this.v3EventsAdditions + ", ecPromotion=" + this.ecPromotion + ", commentaryTags=" + this.commentaryTags + ", campaignList=" + this.campaignList + ", serverTime=" + this.serverTime + ", roomSchema=" + this.roomSchema + ", userInfo=" + this.userInfo + ", aweme=" + this.aweme + ", replayCards=" + this.replayCards + ", replayViewCnt=" + this.replayViewCnt + ", replayViewNum=" + this.replayViewNum + ")";
    }

    public final Serializable getAweme() {
        return this.aweme;
    }

    public final List<ECPromotionCampaign> getCampaignList() {
        return this.campaignList;
    }

    public final List<ECRitTag> getCommentaryTags() {
        return this.commentaryTags;
    }

    public final ECPromotion getEcPromotion() {
        return this.ecPromotion;
    }

    public final ReplayCards getReplayCards() {
        return this.replayCards;
    }

    public final String getReplayViewCnt() {
        return this.replayViewCnt;
    }

    public final Long getReplayViewNum() {
        return this.replayViewNum;
    }

    public final String getRoomSchema() {
        return this.roomSchema;
    }

    public final long getServerTime() {
        return this.serverTime;
    }

    public final Serializable getUserInfo() {
        return this.userInfo;
    }

    public final String getV3EventsAdditions() {
        return this.v3EventsAdditions;
    }

    public final ExplainPlaybackVideoInfo getVideoInfo() {
        return this.videoInfo;
    }

    public final ECReplayVideo getVideoInfoV2() {
        return this.videoInfoV2;
    }

    public final void setVideoInfo(ExplainPlaybackVideoInfo r1) {
        this.videoInfo = r1;
    }

    public ExplainPlaybackFinalParams(ExplainPlaybackVideoInfo r1, ECReplayVideo r2, String r3, ECPromotion r4, List<ECRitTag> r5, List<? extends ECPromotionCampaign> r6, long r7, String r9, Serializable r10, Serializable r11, ReplayCards r12, String r13, Long r14) {
        this.videoInfo = r1;
        this.videoInfoV2 = r2;
        this.v3EventsAdditions = r3;
        this.ecPromotion = r4;
        this.commentaryTags = r5;
        this.campaignList = r6;
        this.serverTime = r7;
        this.roomSchema = r9;
        this.userInfo = r10;
        this.aweme = r11;
        this.replayCards = r12;
        this.replayViewCnt = r13;
        this.replayViewNum = r14;
    }

    public /* synthetic */ ExplainPlaybackFinalParams(ExplainPlaybackVideoInfo r19, ECReplayVideo r20, String r21, ECPromotion r22, List r23, List r24, long r25, String r27, Serializable r28, Serializable r29, ReplayCards r30, String r31, Long r32, int r33, DefaultConstructorMarker r34) {
        if ((r33 & 2) == 0) goto L5;
        ECReplayVideo r5 = null;
    L7:
        if ((r33 & 4) == 0) goto L9;
        String r6 = null;
    L11:
        if ((r33 & 8) == 0) goto L13;
        ECPromotion r7 = null;
    L15:
        if ((r33 & 16) == 0) goto L17;
        List r8 = null;
    L19:
        if ((r33 & 32) == 0) goto L21;
        List r9 = null;
    L23:
        if ((r33 & DeviceStatus$DiffDimension.DIFF_RESTRICTED_MODE) == 0) goto L25;
        String r12 = null;
    L27:
        if ((r33 & DeviceStatus$DiffDimension.DIFF_LOCATION_MODE) == 0) goto L29;
        Serializable r13 = null;
    L31:
        if ((r33 & DeviceStatus$DiffDimension.DIFF_IS_STRICT_RESTRICTED_MODE) == 0) goto L33;
        Serializable r14 = null;
    L35:
        if ((r33 & DeviceStatus$DiffDimension.DIFF_BLUETOOTH_PERMISSION) == 0) goto L37;
        ReplayCards r15 = null;
    L39:
        if ((r33 & 2048) == 0) goto L41;
        String r16 = null;
    L43:
        if ((r33 & 4096) == 0) goto L45;
        Long r17 = null;
    L46:
        this(r19, r5, r6, r7, r8, r9, r25, r12, r13, r14, r15, r16, r17);
        return;
    L45:
        r17 = r32;
        goto L46
    L41:
        r16 = r31;
        goto L43
    L37:
        r15 = r30;
        goto L39
    L33:
        r14 = r29;
        goto L35
    L29:
        r13 = r28;
        goto L31
    L25:
        r12 = r27;
        goto L27
    L21:
        r9 = r24;
        goto L23
    L17:
        r8 = r23;
        goto L19
    L13:
        r7 = r22;
        goto L15
    L9:
        r6 = r21;
        goto L11
    L5:
        r5 = r20;
        goto L7
    }
}
