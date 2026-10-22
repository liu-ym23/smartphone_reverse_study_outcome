package com.larus.bmhome.chat.bean;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.video.Content;
import com.larus.bmhome.video.ItemType;
import com.larus.bmhome.view.screenmenu.widget.ItemStyle;
import com.obric.trace.ObricActionBarTrackType;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import com.tencent.qqmusic.third.api.contract.Keys;
import ic8.i0;
import ic8.j0;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0087\b\u0018\u00002\u00020\u0001B¥\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\u0018\b\u0002\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0017\u0010\u0018J$\u00100\u001a\u0002012\u0012\b\u0002\u00102\u001a\f\u0012\u0006\u0012\u0004\u0018\u000101\u0018\u0001032\b\b\u0002\u00104\u001a\u000205J\b\u00106\u001a\u0004\u0018\u000107J\b\u00108\u001a\u0004\u0018\u00010\u0003J\b\u00109\u001a\u0004\u0018\u00010\u0003J\b\u0010:\u001a\u0004\u0018\u00010\u0003J\b\u0010;\u001a\u0004\u0018\u00010\u0003J\b\u0010<\u001a\u0004\u0018\u00010\u0003J\b\u0010=\u001a\u0004\u0018\u00010\u0003J\b\u0010>\u001a\u0004\u0018\u00010\u0003J\b\u0010?\u001a\u0004\u0018\u00010\u0003J\b\u0010@\u001a\u0004\u0018\u00010\u0003J\u0006\u0010A\u001a\u000205J\u0014\u0010B\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010CJ\b\u0010D\u001a\u0004\u0018\u00010\u0003J\b\u0010E\u001a\u0004\u0018\u00010\u0003J\b\u0010F\u001a\u00020\u0003H\u0016J\u000b\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010I\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u0010J\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010 J\u0010\u0010K\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010 J\u000b\u0010L\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u0019\u0010Q\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0015HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0003HÆ\u0003J¬\u0001\u0010S\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0018\b\u0002\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010TJ\u0013\u0010U\u001a\u0002052\b\u0010V\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010W\u001a\u00020\u0006HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u001a\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\"\u0010 R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R&\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001a¨\u0006X"}, d2 = {"Lcom/larus/bmhome/chat/bean/NexPulseCandidate;", "", "gid", "", "parentId", "candidateType", "", Keys.API_PARAM_KEY_SDK_EXPIRETIME, "", "effectiveTime", "textConf", "Lcom/larus/bmhome/chat/bean/TextCandidateConf;", "cardConf", "Lcom/larus/bmhome/chat/bean/CardCandidateConf;", "popWindowConf", "Lcom/larus/bmhome/chat/bean/PopWindowCandidateConf;", "richMediaConf", "Lcom/larus/bmhome/chat/bean/RichMediaCandidateConf;", "skillConf", "Lcom/larus/bmhome/chat/bean/SkillConf;", "candidateExt", "", "categoryId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Lcom/larus/bmhome/chat/bean/TextCandidateConf;Lcom/larus/bmhome/chat/bean/CardCandidateConf;Lcom/larus/bmhome/chat/bean/PopWindowCandidateConf;Lcom/larus/bmhome/chat/bean/RichMediaCandidateConf;Lcom/larus/bmhome/chat/bean/SkillConf;Ljava/util/Map;Ljava/lang/String;)V", "getGid", "()Ljava/lang/String;", "getParentId", "getCandidateType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getExpireTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getEffectiveTime", "getTextConf", "()Lcom/larus/bmhome/chat/bean/TextCandidateConf;", "getCardConf", "()Lcom/larus/bmhome/chat/bean/CardCandidateConf;", "getPopWindowConf", "()Lcom/larus/bmhome/chat/bean/PopWindowCandidateConf;", "getRichMediaConf", "()Lcom/larus/bmhome/chat/bean/RichMediaCandidateConf;", "getSkillConf", "()Lcom/larus/bmhome/chat/bean/SkillConf;", "getCandidateExt", "()Ljava/util/Map;", "getCategoryId", "toSuggestItem", "Lcom/larus/bmhome/chat/bean/PromptContent$SuggestItem;", "childCandidates", "", "isCategoryCandidate", "", "toOnboardingSugItem", "Lcom/larus/bmhome/chat/bean/OnboardingSug;", "getLogId", "getPromptFrom", "getLotteryStatus", "getActionBarTemplateId", "getCardName", "getClickClearContext", "getTemplateSubType", "getTemplateRecExtra", "getTagCode", "isWorldCupCard", "getSelectionPos", "Lkotlin/Pair;", "getVisualSize", "getActivityId", "toString", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Lcom/larus/bmhome/chat/bean/TextCandidateConf;Lcom/larus/bmhome/chat/bean/CardCandidateConf;Lcom/larus/bmhome/chat/bean/PopWindowCandidateConf;Lcom/larus/bmhome/chat/bean/RichMediaCandidateConf;Lcom/larus/bmhome/chat/bean/SkillConf;Ljava/util/Map;Ljava/lang/String;)Lcom/larus/bmhome/chat/bean/NexPulseCandidate;", "equals", "other", "hashCode", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NexPulseCandidate {

    @SerializedName("candidate_ext")
    private final Map<String, String> candidateExt;

    @SerializedName("candidate_type")
    private final Integer candidateType;

    @SerializedName("card_conf")
    private final CardCandidateConf cardConf;

    @SerializedName("category_id")
    private final String categoryId;

    @SerializedName("effective_time")
    private final Long effectiveTime;

    @SerializedName("expire_time")
    private final Long expireTime;

    @SerializedName("gid")
    private final String gid;

    @SerializedName("parent_id")
    private final String parentId;

    @SerializedName("pop_window_conf")
    private final PopWindowCandidateConf popWindowConf;

    @SerializedName("rich_media_conf")
    private final RichMediaCandidateConf richMediaConf;

    @SerializedName("skill_conf")
    private final SkillConf skillConf;

    @SerializedName("text_conf")
    private final TextCandidateConf textConf;

    public NexPulseCandidate() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, UnixStat.PERM_MASK, null);
    }

    public static /* synthetic */ CharSequence a(JsonElement r100) {
        return toSuggestItem$lambda$5$lambda$4(r100);
    }

    public static /* synthetic */ CharSequence b(JsonElement r100) {
        return toSuggestItem$lambda$7$lambda$6(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ NexPulseCandidate copy$default(NexPulseCandidate r110, String r111, String r112, Integer r113, Long r114, Long r115, TextCandidateConf r116, CardCandidateConf r210, PopWindowCandidateConf r211, RichMediaCandidateConf r212, SkillConf r213, Map r214, String r215, int r216, Object r217) {
        if ((r216 & 1) == 0) goto L5;
        String r100 = r110.gid;
    L7:
        if ((r216 & 2) == 0) goto L9;
        String r101 = r110.parentId;
    L11:
        if ((r216 & 4) == 0) goto L13;
        Integer r102 = r110.candidateType;
    L15:
        if ((r216 & 8) == 0) goto L17;
        Long r103 = r110.expireTime;
    L19:
        if ((r216 & 16) == 0) goto L21;
        Long r104 = r110.effectiveTime;
    L23:
        if ((r216 & 32) == 0) goto L25;
        TextCandidateConf r105 = r110.textConf;
    L27:
        if ((r216 & 64) == 0) goto L29;
        CardCandidateConf r106 = r110.cardConf;
    L31:
        if ((r216 & 128) == 0) goto L33;
        PopWindowCandidateConf r107 = r110.popWindowConf;
    L35:
        if ((r216 & 256) == 0) goto L37;
        RichMediaCandidateConf r117 = r110.richMediaConf;
    L39:
        if ((r216 & 512) == 0) goto L41;
        SkillConf r118 = r110.skillConf;
    L43:
        if ((r216 & 1024) == 0) goto L45;
        Map r119 = r110.candidateExt;
    L47:
        if ((r216 & 2048) == 0) goto L49;
        String r108 = r110.categoryId;
    L51:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r117, r118, r119, r108);
    L49:
        r108 = r215;
        goto L51
    L45:
        r119 = r214;
        goto L47
    L41:
        r118 = r213;
        goto L43
    L37:
        r117 = r212;
        goto L39
    L33:
        r107 = r211;
        goto L35
    L29:
        r106 = r210;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.gid;
    }

    public final SkillConf component10() {
        return this.skillConf;
    }

    public final Map<String, String> component11() {
        return this.candidateExt;
    }

    public final String component12() {
        return this.categoryId;
    }

    public final String component2() {
        return this.parentId;
    }

    public final Integer component3() {
        return this.candidateType;
    }

    public final Long component4() {
        return this.expireTime;
    }

    public final Long component5() {
        return this.effectiveTime;
    }

    public final TextCandidateConf component6() {
        return this.textConf;
    }

    public final CardCandidateConf component7() {
        return this.cardConf;
    }

    public final PopWindowCandidateConf component8() {
        return this.popWindowConf;
    }

    public final RichMediaCandidateConf component9() {
        return this.richMediaConf;
    }

    public final NexPulseCandidate copy(String r110, String r111, Integer r112, Long r113, Long r114, TextCandidateConf r210, CardCandidateConf r211, PopWindowCandidateConf r212, RichMediaCandidateConf r213, SkillConf r214, Map<String, String> r215, String r216) {
        return new NexPulseCandidate(r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r215, r216);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof NexPulseCandidate) == true) goto L8;
        return false;
    L8:
        NexPulseCandidate r101 = (NexPulseCandidate) r100;
        if (Intrinsics.areEqual(this.gid, r101.gid) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.parentId, r101.parentId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.candidateType, r101.candidateType) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.expireTime, r101.expireTime) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.effectiveTime, r101.effectiveTime) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.textConf, r101.textConf) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.cardConf, r101.cardConf) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.popWindowConf, r101.popWindowConf) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.richMediaConf, r101.richMediaConf) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.skillConf, r101.skillConf) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.candidateExt, r101.candidateExt) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.categoryId, r101.categoryId) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public int hashCode() {
        String r100 = this.gid;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.parentId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.candidateType;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.expireTime;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Long r113 = this.effectiveTime;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        TextCandidateConf r116 = this.textConf;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        CardCandidateConf r119 = this.cardConf;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        PopWindowCandidateConf r122 = this.popWindowConf;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        RichMediaCandidateConf r125 = this.richMediaConf;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        SkillConf r128 = this.skillConf;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        Map<String, String> r131 = this.candidateExt;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.categoryId;
        if (r134 == null) goto L51;
        r101 = r134.hashCode();
    L51:
        return r133 + r101;
    L45:
        r132 = r131.hashCode();
        goto L46
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
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

    public final String getActionBarTemplateId() {
        Map<String, String> r100 = this.candidateExt;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.get(ObricActionBarTrackType.KEY_ACTION_BAR_TEMPLATE_ID);
    }

    public final String getActivityId() {
        Map<String, String> r100 = this.candidateExt;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.get("activity_id");
    }

    public final String getCardName() {
        Map<String, String> r100 = this.candidateExt;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.get("card_name");
    }

    public final String getClickClearContext() {
        Map<String, String> r100 = this.candidateExt;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.get("click_clear_context");
    }

    public final String getLogId() {
        Map<String, String> r100 = this.candidateExt;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.get("reco_request_id");
    }

    public final String getLotteryStatus() {
        Map<String, String> r100 = this.candidateExt;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.get("lottery_status");
    }

    public final String getPromptFrom() {
        Map<String, String> r100 = this.candidateExt;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.get("prompt_from");
    }

    public final Pair<Integer, Integer> getSelectionPos() {
        Map<String, String> r100 = this.candidateExt;
        if (r100 == null) goto L7;
        String r101 = r100.get("select_start_pos");
        if (r101 == null) goto L7;
        Integer r102 = StringsKt.toIntOrNull(r101);
    L8:
        Map<String, String> r103 = this.candidateExt;
        if (r103 == null) goto L13;
        String r104 = r103.get("select_end_pos");
        if (r104 == null) goto L13;
        Integer r105 = StringsKt.toIntOrNull(r104);
    L14:
        if (r102 == null) goto L20;
        if (r105 == null) goto L20;
        if (r102.intValue() > r105.intValue()) goto L20;
        return TuplesKt.to(r102, r105);
    L20:
        return null;
    L13:
        r105 = null;
    L7:
        r102 = null;
        goto L8
    }

    public final String getTagCode() {
        CardCandidateConf r100 = this.cardConf;
        if (r100 == null) goto L8;
        List<Integer> r101 = r100.getTagList();
        if (r101 != null) goto L7;
        return null;
    L7:
        return CollectionsKt.joinToString$default(r101, ",", null, null, 0, null, null, 62, null);
    L8:
        TextCandidateConf r102 = this.textConf;
        if (r102 == null) goto L15;
        List<Integer> r103 = r102.getTagList();
        if (r103 != null) goto L13;
        return null;
    L13:
        return CollectionsKt.joinToString$default(r103, ",", null, null, 0, null, null, 62, null);
    L15:
        return null;
    }

    public final String getTemplateRecExtra() {
        Map<String, String> r100 = this.candidateExt;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.get("template_rec_extra");
    }

    public final String getTemplateSubType() {
        Map<String, String> r100 = this.candidateExt;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.get("template_sub_type");
    }

    public final String getVisualSize() {
        CardCandidateConf r100 = this.cardConf;
        if (r100 == null) goto L5;
        Integer r101 = r100.getCardSize();
    L6:
        if (r101 != null) goto L9;
    L11:
        if (r101 != null) goto L14;
    L16:
        if (r101 != null) goto L19;
        return null;
    L19:
        if (r101.intValue() != 3) goto L24;
        return "full";
    L24:
        return null;
    L14:
        if (r101.intValue() != 2) goto L16;
        return ItemStyle.ITEM_STYLE_DOUBLE;
    L9:
        if (r101.intValue() != 1) goto L11;
        return "single";
    L5:
        r101 = null;
        goto L6
    }

    public final OnboardingSug toOnboardingSugItem() {
        RichMediaCandidateConf r100 = this.richMediaConf;
        if (r100 == null) goto L22;
        Content r101 = r100.getUgcItem();
        if (r101 == null) goto L24;
        String r102 = r101.getItemId();
        if (r102 == null) goto L12;
        Long r103 = StringsKt.toLongOrNull(r102);
        if (r103 == null) goto L12;
        long r104 = r103.longValue();
    L13:
        long r105 = r104;
        Integer r106 = r101.getItemType();
        int r107 = ItemType.VIDEO.getValue();
        if (r106 != null) goto L17;
    L19:
        SuggestItemType r108 = SuggestItemType.ArticleRichMediaWelcomeBack;
    L21:
        return new OnboardingSug(r105, r108.getValue(), 1, 2, r101);
    L17:
        if (r106.intValue() != r107) goto L19;
        r108 = SuggestItemType.VideoRichMediaWelcomeBack;
    L12:
        r104 = 0;
        goto L13
    L24:
        return null;
    L22:
        return null;
    }

    public String toString() {
        return "NexPulseCandidate(gid=" + this.gid + ", parentId=" + this.parentId + ", categoryId=" + this.categoryId + ", candidateType=" + this.candidateType + ", expireTime=" + this.expireTime + ", effectiveTime=" + this.effectiveTime + ", textConf=" + this.textConf + ", cardConf=" + this.cardConf + ')';
    }

    public final boolean isWorldCupCard() {
        return Intrinsics.areEqual(getCardName(), "world_cup_2026_guide");
    }

    public final Map<String, String> getCandidateExt() {
        return this.candidateExt;
    }

    public final Integer getCandidateType() {
        return this.candidateType;
    }

    public final CardCandidateConf getCardConf() {
        return this.cardConf;
    }

    public final String getCategoryId() {
        return this.categoryId;
    }

    public final Long getEffectiveTime() {
        return this.effectiveTime;
    }

    public final Long getExpireTime() {
        return this.expireTime;
    }

    public final String getGid() {
        return this.gid;
    }

    public final String getParentId() {
        return this.parentId;
    }

    public final PopWindowCandidateConf getPopWindowConf() {
        return this.popWindowConf;
    }

    public final RichMediaCandidateConf getRichMediaConf() {
        return this.richMediaConf;
    }

    public final SkillConf getSkillConf() {
        return this.skillConf;
    }

    public final TextCandidateConf getTextConf() {
        return this.textConf;
    }

    private static final CharSequence toSuggestItem$lambda$5$lambda$4(JsonElement r100) {
        JsonObject r101 = r100.getAsJsonObject();
        if (r101 == null) goto L7;
        JsonElement r102 = r101.get("text");
        if (r102 == null) goto L7;
        String r103 = r102.getAsString();
    L8:
        if (r103 != null) goto L11;
        return "";
    L11:
        return r103;
    L7:
        r103 = null;
        goto L8
    }

    private static final CharSequence toSuggestItem$lambda$7$lambda$6(JsonElement r100) {
        JsonObject r101 = r100.getAsJsonObject();
        if (r101 == null) goto L7;
        JsonElement r102 = r101.get("text");
        if (r102 == null) goto L7;
        String r103 = r102.getAsString();
    L8:
        if (r103 != null) goto L11;
        return "";
    L11:
        return r103;
    L7:
        r103 = null;
        goto L8
    }

    public final PromptContent.SuggestItem toSuggestItem(List<PromptContent.SuggestItem> r410, boolean r411) {
        Map<String, String> r100 = this.candidateExt;
        if (r100 != null) goto L5;
        r100 = MapsKt.emptyMap();
    L5:
        Map r110 = MapsKt.toMutableMap(r100);
        TextCandidateConf r101 = this.textConf;
        if (r101 == null) goto L10;
        List<Integer> r102 = r101.getTagList();
        if (r102 == null) goto L10;
        String r103 = (String) r110.put("tag_enum_mapping", CollectionsKt.joinToString$default(r102, ",", null, null, 0, null, null, 62, null));
    L10:
        String r104 = this.categoryId;
        if (r104 != null) goto L13;
    L234:
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L31
        TextCandidateConf r106 = this.textConf;     // Catch: Throwable -> L31
        if (r106 == null) goto L28;
        JsonObject r107 = r106.getDisplayRichTextConf();     // Catch: Throwable -> L31
        if (r107 == null) goto L28;
        JsonArray r108 = r107.getAsJsonArray("rich_contents");     // Catch: Throwable -> L31
        if (r108 == null) goto L28;
        String r109 = CollectionsKt.joinToString$default(r108, "", null, null, 0, null, new i0(), 30, null);     // Catch: Throwable -> L31
    L29:
        Object r111 = Result.m9449constructorimpl(r109);     // Catch: Throwable -> L31
    L34:
        if (Result.m9455isFailureimpl(r111) == false) goto L36;
        r111 = null;
    L36:
        String r112 = (String) r111;
        TextCandidateConf r113 = this.textConf;     // Catch: Throwable -> L47
        if (r113 == null) goto L44;
        JsonObject r114 = r113.getSendRichTextConf();     // Catch: Throwable -> L47
        if (r114 == null) goto L44;
        JsonArray r115 = r114.getAsJsonArray("rich_contents");     // Catch: Throwable -> L47
        if (r115 == null) goto L44;
        String r116 = CollectionsKt.joinToString$default(r115, "", null, null, 0, null, new j0(), 30, null);     // Catch: Throwable -> L47
    L45:
        Object r117 = Result.m9449constructorimpl(r116);     // Catch: Throwable -> L47
    L50:
        if (Result.m9455isFailureimpl(r117) == false) goto L52;
        r117 = null;
    L52:
        String r118 = (String) r117;
        TextCandidateConf r119 = this.textConf;     // Catch: Throwable -> L65
        if (r119 == null) goto L62;
        JsonObject r120 = r119.getDisplayRichTextConf();     // Catch: Throwable -> L65
        if (r120 == null) goto L62;
        JsonElement r121 = r120.get("is_rich_text");     // Catch: Throwable -> L65
        if (r121 == null) goto L62;
        if (r121.getAsBoolean() != true) goto L62;
        boolean r122 = true;
    L63:
        Object r123 = Result.m9449constructorimpl(Boolean.valueOf(r122));     // Catch: Throwable -> L65
    L67:
        Boolean r124 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r123) == false) goto L70;
        r123 = r124;
    L70:
        boolean r125 = ((Boolean) r123).booleanValue();
        if (r112 != null) goto L73;
    L76:
        boolean r126 = true;
    L77:
        if (r126 == false) goto L80;
        r112 = null;
    L80:
        if (r112 != null) goto L87;
        TextCandidateConf r127 = this.textConf;
        if (r127 == null) goto L84;
        r112 = r127.getDisplayText();
    L85:
        if (r112 != null) goto L87;
        r112 = "";
        goto L87
    L84:
        r112 = null;
    L87:
        String r128 = this.gid;
        TextCandidateConf r129 = this.textConf;
        if (r129 == null) goto L93;
        Long r130 = r129.getSuggestedItemType();
        if (r130 == null) goto L93;
        String r131 = r130.toString();
        if (r131 == null) goto L93;
    L94:
        String r132 = r131;
        if (r118 != null) goto L97;
    L100:
        boolean r133 = true;
    L101:
        if (r133 == false) goto L104;
        r118 = null;
    L104:
        if (r118 != null) goto L109;
        TextCandidateConf r134 = this.textConf;
        if (r134 == null) goto L108;
        r118 = r134.getSendMessageText();
        goto L109
    L108:
        String r135 = null;
    L110:
        TextCandidateConf r136 = this.textConf;
        if (r136 == null) goto L113;
        String r137 = r136.getSchema();
    L114:
        TextCandidateConf r138 = this.textConf;
        if (r138 == null) goto L117;
        String r139 = r138.getBgColorLight();
    L118:
        TextCandidateConf r140 = this.textConf;
        if (r140 == null) goto L121;
        String r141 = r140.getBgColorDark();
    L122:
        TextCandidateConf r142 = this.textConf;
        if (r142 == null) goto L125;
        String r143 = r142.getFontColorLight();
    L126:
        TextCandidateConf r144 = this.textConf;
        if (r144 == null) goto L129;
        String r145 = r144.getFontColorDark();
    L130:
        TextCandidateConf r146 = this.textConf;
        if (r146 == null) goto L133;
        String r147 = r146.getBorderColorLight();
    L134:
        TextCandidateConf r148 = this.textConf;
        if (r148 == null) goto L137;
        String r149 = r148.getBorderColorDark();
    L138:
        TextCandidateConf r150 = this.textConf;
        if (r150 == null) goto L143;
        NexPulseMedia r151 = r150.getEndIcon();
        if (r151 == null) goto L143;
        String r210 = r151.getMediaLightUri();
    L144:
        TextCandidateConf r152 = this.textConf;
        if (r152 == null) goto L149;
        NexPulseMedia r153 = r152.getEndIcon();
        if (r153 == null) goto L149;
        String r211 = r153.getMediaLightUrl();
    L150:
        PromptContent.SuggestImageItem r212 = new PromptContent.SuggestImageItem(r210, r211, null, null, 12, null);
        TextCandidateConf r154 = this.textConf;
        if (r154 == null) goto L155;
        NexPulseMedia r155 = r154.getEndIcon();
        if (r155 == null) goto L155;
        String r213 = r155.getMediaDarkUri();
    L156:
        TextCandidateConf r156 = this.textConf;
        if (r156 == null) goto L161;
        NexPulseMedia r157 = r156.getEndIcon();
        if (r157 == null) goto L161;
        String r214 = r157.getMediaDarkUrl();
    L162:
        PromptContent.SuggestImageItem r158 = new PromptContent.SuggestImageItem(r213, r214, null, null, 12, null);
        TextCandidateConf r159 = this.textConf;
        if (r159 == null) goto L167;
        NexPulseMedia r160 = r159.getFrontIcon();
        if (r160 == null) goto L167;
        String r310 = r160.getMediaLightUri();
    L168:
        TextCandidateConf r161 = this.textConf;
        if (r161 == null) goto L173;
        NexPulseMedia r162 = r161.getFrontIcon();
        if (r162 == null) goto L173;
        String r311 = r162.getMediaLightUrl();
    L174:
        PromptContent.SuggestImageItem r215 = new PromptContent.SuggestImageItem(r310, r311, null, null, 12, null);
        TextCandidateConf r163 = this.textConf;
        if (r163 == null) goto L179;
        NexPulseMedia r164 = r163.getFrontIcon();
        if (r164 == null) goto L179;
        String r216 = r164.getMediaDarkUri();
    L180:
        TextCandidateConf r165 = this.textConf;
        if (r165 == null) goto L185;
        NexPulseMedia r166 = r165.getFrontIcon();
        if (r166 == null) goto L185;
        String r217 = r166.getMediaDarkUrl();
    L186:
        PromptContent.SuggestImageItem r218 = new PromptContent.SuggestImageItem(r216, r217, null, null, 12, null);
        TextCandidateConf r167 = this.textConf;
        if (r167 == null) goto L189;
        String r219 = r167.getWcbItem();
    L190:
        TextCandidateConf r168 = this.textConf;
        if (r168 == null) goto L193;
        Boolean r220 = Boolean.valueOf(r168.isHighlightPush());
    L194:
        if (r125 == true) goto L204;
        TextCandidateConf r169 = this.textConf;
        if (r169 != null) goto L198;
    L200:
        boolean r170 = false;
    L201:
        if (r170 == true) goto L204;
        boolean r171 = false;
    L205:
        Integer r172 = this.candidateType;
        TextCandidateConf r173 = this.textConf;
        if (r173 == null) goto L208;
        Boolean r221 = r173.isContinueAsk();
    L209:
        TextCandidateConf r174 = this.textConf;
        if (r174 == null) goto L212;
        Integer r222 = r174.getIcon();
    L213:
        TextCandidateConf r175 = this.textConf;
        if (r175 == null) goto L216;
        Integer r312 = r175.getPosition();
    L217:
        TextCandidateConf r176 = this.textConf;
        if (r176 == null) goto L220;
        JsonObject r313 = r176.getDisplayRichTextConf();
    L221:
        TextCandidateConf r177 = this.textConf;
        if (r177 == null) goto L224;
        JsonObject r314 = r177.getSendRichTextConf();
    L225:
        if (r410 != null) goto L227;
    L229:
        List<PromptContent.SuggestItem> r315 = null;
    L230:
        String r178 = r112;
        String r179 = r139;
        String r180 = r141;
        String r181 = r143;
        String r182 = r145;
        String r183 = r147;
        String r184 = r149;
        Boolean r185 = r220;
        String r186 = r137;
        boolean r223 = r171;
        return new PromptContent.SuggestItem(r178, r179, r180, r181, r182, r183, r184, r185, r128, r132, r135, r186, null, null, r212, r158, r215, r218, null, r219, r110, null, r223, r172, r221, r222, r312, r313, r314, r315, Boolean.valueOf(r411), 2371584, null);
    L227:
        if ((true ^ r410.isEmpty()) == false) goto L229;
        r315 = r410;
        goto L230
    L224:
        r314 = null;
        goto L225
    L220:
        r313 = null;
        goto L221
    L216:
        r312 = null;
        goto L217
    L212:
        r222 = null;
        goto L213
    L208:
        r221 = null;
        goto L209
    L198:
        if (r169.isRichText() != true) goto L200;
        r170 = true;
    L204:
        r171 = true;
        goto L205
    L193:
        r220 = null;
        goto L194
    L189:
        r219 = null;
    L185:
        r217 = null;
    L179:
        r216 = null;
    L173:
        r311 = null;
    L167:
        r310 = null;
    L161:
        r214 = null;
    L155:
        r213 = null;
    L149:
        r211 = null;
    L143:
        r210 = null;
        goto L144
    L137:
        r149 = null;
        goto L138
    L133:
        r147 = null;
        goto L134
    L129:
        r145 = null;
        goto L130
    L125:
        r143 = null;
        goto L126
    L121:
        r141 = null;
        goto L122
    L117:
        r139 = null;
        goto L118
    L113:
        r137 = null;
    L109:
        r135 = r118;
        goto L110
    L97:
        if (r118.length() == 0) goto L100;
        r133 = false;
    L93:
        r131 = "1";
        goto L94
    L73:
        if (r112.length() == 0) goto L76;
        r126 = false;
    L62:
        r122 = false;
    L65:
        th = move-exception;
        Result.Companion r187 = Result.Companion;
        r123 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L44:
        r116 = null;
    L47:
        th = move-exception;
        Result.Companion r188 = Result.Companion;
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L28:
        r109 = null;
    L31:
        th = move-exception;
        Result.Companion r189 = Result.Companion;
        r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L34
    L13:
        if (r104.length() <= 0) goto L15;
        boolean r190 = true;
    L16:
        if (r190 == true) goto L19;
        r104 = null;
    L19:
        if (r104 == null) goto L234;
        r110.put("category_id", r104);
        goto L234
    L15:
        r190 = false;
        goto L16
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PromptContent.SuggestItem toSuggestItem$default(NexPulseCandidate r100, List r101, boolean r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = false;
    L9:
        return r100.toSuggestItem(r101, r102);
    }

    public NexPulseCandidate(String r100, String r101, Integer r102, Long r103, Long r104, TextCandidateConf r105, CardCandidateConf r106, PopWindowCandidateConf r107, RichMediaCandidateConf r108, SkillConf r110, Map<String, String> r111, String r112) {
        this.gid = r100;
        this.parentId = r101;
        this.candidateType = r102;
        this.expireTime = r103;
        this.effectiveTime = r104;
        this.textConf = r105;
        this.cardConf = r106;
        this.popWindowConf = r107;
        this.richMediaConf = r108;
        this.skillConf = r110;
        this.candidateExt = r111;
        this.categoryId = r112;
    }

    public /* synthetic */ NexPulseCandidate(String r110, String r111, Integer r112, Long r113, Long r114, TextCandidateConf r115, CardCandidateConf r210, PopWindowCandidateConf r211, RichMediaCandidateConf r212, SkillConf r213, Map r214, String r215, int r216, DefaultConstructorMarker r217) {
        String r100 = null;
        if ((r216 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r216 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r216 & 4) == 0) goto L13;
        Integer r103 = null;
    L15:
        if ((r216 & 8) == 0) goto L17;
        Long r104 = null;
    L19:
        if ((r216 & 16) == 0) goto L21;
        Long r105 = null;
    L23:
        if ((r216 & 32) == 0) goto L25;
        TextCandidateConf r106 = null;
    L27:
        if ((r216 & 64) == 0) goto L29;
        CardCandidateConf r107 = null;
    L31:
        if ((r216 & 128) == 0) goto L33;
        PopWindowCandidateConf r108 = null;
    L35:
        if ((r216 & 256) == 0) goto L37;
        RichMediaCandidateConf r116 = null;
    L39:
        if ((r216 & 512) == 0) goto L41;
        SkillConf r117 = null;
    L43:
        if ((r216 & 1024) == 0) goto L45;
        Map r118 = null;
    L47:
        if ((r216 & 2048) != 0) goto L50;
        r100 = r215;
    L50:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r116, r117, r118, r100);
        return;
    L45:
        r118 = r214;
        goto L47
    L41:
        r117 = r213;
        goto L43
    L37:
        r116 = r212;
        goto L39
    L33:
        r108 = r211;
        goto L35
    L29:
        r107 = r210;
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
}
