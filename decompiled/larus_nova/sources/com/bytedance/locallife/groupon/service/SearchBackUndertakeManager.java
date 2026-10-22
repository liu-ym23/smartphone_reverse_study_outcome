package com.bytedance.locallife.groupon.service;

import com.bytedance.common.wschannel.WsConstants;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\bÇ\u0002\u0018\u00002\u00020\u0001:\u0004\u0015\u0016\u0017\u0018B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004J\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\tJ\u001c\u0010\u0012\u001a\u00020\u00102\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\tH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/locallife/groupon/service/SearchBackUndertakeManager;", "", "()V", WsConstants.KEY_PAYLOAD, "", "searchParams", "", "consumePayload", "consumePayloadModel", "Lcom/bytedance/locallife/groupon/service/SearchBackUndertakeManager$UndertakePayload;", "consumeSearchParams", "fromJsonString", "json", "hasParams", "", "setPayload", "", "p", "setSearchParams", "params", "toJsonString", "FeedOriginGidInfo", "InsertItemInfo", "InsertItemTag", "UndertakePayload", "locallife-groupon-common_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class SearchBackUndertakeManager {
    public static final SearchBackUndertakeManager INSTANCE = null;
    private static String payload;
    private static Map<String, String> searchParams;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J,\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/locallife/groupon/service/SearchBackUndertakeManager$FeedOriginGidInfo;", "", "PromotionType", "", "InsertItemInfo", "", "Lcom/bytedance/locallife/groupon/service/SearchBackUndertakeManager$InsertItemInfo;", "(Ljava/lang/Integer;Ljava/util/List;)V", "getInsertItemInfo", "()Ljava/util/List;", "getPromotionType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/util/List;)Lcom/bytedance/locallife/groupon/service/SearchBackUndertakeManager$FeedOriginGidInfo;", "equals", "", "other", "hashCode", "toString", "", "locallife-groupon-common_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    public static final class FeedOriginGidInfo {
        private final List<InsertItemInfo> InsertItemInfo;
        private final Integer PromotionType;

        /* JADX WARN: Multi-variable type inference failed */
        public FeedOriginGidInfo() {
            Object[] r100 = 0 == true ? 1 : 0;
            this(null, r100, 3, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ FeedOriginGidInfo copy$default(FeedOriginGidInfo r100, Integer r101, List r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.PromotionType;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.InsertItemInfo;
        L9:
            return r100.copy(r101, r102);
        }

        public final Integer component1() {
            return this.PromotionType;
        }

        public final List<InsertItemInfo> component2() {
            return this.InsertItemInfo;
        }

        public final FeedOriginGidInfo copy(Integer r100, List<InsertItemInfo> r101) {
            return new FeedOriginGidInfo(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof FeedOriginGidInfo) == true) goto L8;
            return false;
        L8:
            FeedOriginGidInfo r101 = (FeedOriginGidInfo) r100;
            if (Intrinsics.areEqual(this.PromotionType, r101.PromotionType) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.InsertItemInfo, r101.InsertItemInfo) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            Integer r100 = this.PromotionType;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            List<InsertItemInfo> r104 = this.InsertItemInfo;
            if (r104 == null) goto L11;
            r101 = r104.hashCode();
        L11:
            return r103 + r101;
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public String toString() {
            JSONObject r100 = new JSONObject();
            Integer r101 = this.PromotionType;
            if (r101 == null) goto L5;
            r100.put("PromotionType", r101.intValue());
        L5:
            List<InsertItemInfo> r102 = this.InsertItemInfo;
            if (r102 == null) goto L34;
            JSONArray r103 = new JSONArray();
            Iterator<T> r104 = r102.iterator();
        L9:
            if (r104.hasNext() == false) goto L32;
            InsertItemInfo r105 = (InsertItemInfo) r104.next();
            JSONObject r106 = new JSONObject();
            Long r107 = r105.getInsertAwemeId();
            if (r107 == null) goto L13;
            r106.put("InsertAwemeId", r107.longValue());
        L13:
            Integer r108 = r105.getInsertAwemeType();
            if (r108 == null) goto L16;
            r106.put("InsertAwemeType", r108.intValue());
        L16:
            InsertItemTag r109 = r105.getInsertAwemeTag();
            if (r109 == null) goto L22;
            JSONObject r110 = new JSONObject();
            String r111 = r109.getText();
            if (r111 == null) goto L21;
            r110.put("Text", r111);
        L21:
            Unit r112 = Unit.INSTANCE;
            r106.put("InsertAwemeTag", r110);
        L22:
            Boolean r113 = r105.getIsHighlight();
            if (r113 == null) goto L25;
            r106.put("IsHighlight", r113.booleanValue());
        L25:
            Boolean r114 = r105.getUseNewHighlight();
            if (r114 == null) goto L28;
            r106.put("UseNewHighlight", r114.booleanValue());
        L28:
            String r115 = r105.getInsertLifeMallTrackParams();
            if (r115 == null) goto L31;
            r106.put("InsertLifeMallTrackParams", r115);
        L31:
            r103.put(r106);
            goto L9
        L32:
            Unit r116 = Unit.INSTANCE;
            r100.put("InsertItemInfo", r103);
        L34:
            return r100.toString();
        }

        public final List<InsertItemInfo> getInsertItemInfo() {
            return this.InsertItemInfo;
        }

        public final Integer getPromotionType() {
            return this.PromotionType;
        }

        public FeedOriginGidInfo(Integer r100, List<InsertItemInfo> r101) {
            this.PromotionType = r100;
            this.InsertItemInfo = r101;
        }

        public /* synthetic */ FeedOriginGidInfo(Integer r100, List r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 1) == 0) goto L6;
            r100 = null;
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = null;
        L8:
            this(r100, r101);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001c\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010 \u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0019J\u000b\u0010!\u001a\u0004\u0018\u00010\fHÆ\u0003JV\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020\t2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u0005HÖ\u0001J\t\u0010'\u001a\u00020\fHÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001b\u0010\u0019¨\u0006("}, d2 = {"Lcom/bytedance/locallife/groupon/service/SearchBackUndertakeManager$InsertItemInfo;", "", "InsertAwemeId", "", "InsertAwemeType", "", "InsertAwemeTag", "Lcom/bytedance/locallife/groupon/service/SearchBackUndertakeManager$InsertItemTag;", "IsHighlight", "", "UseNewHighlight", "InsertLifeMallTrackParams", "", "(Ljava/lang/Long;Ljava/lang/Integer;Lcom/bytedance/locallife/groupon/service/SearchBackUndertakeManager$InsertItemTag;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;)V", "getInsertAwemeId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getInsertAwemeTag", "()Lcom/bytedance/locallife/groupon/service/SearchBackUndertakeManager$InsertItemTag;", "getInsertAwemeType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getInsertLifeMallTrackParams", "()Ljava/lang/String;", "getIsHighlight", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getUseNewHighlight", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Long;Ljava/lang/Integer;Lcom/bytedance/locallife/groupon/service/SearchBackUndertakeManager$InsertItemTag;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/bytedance/locallife/groupon/service/SearchBackUndertakeManager$InsertItemInfo;", "equals", "other", "hashCode", "toString", "locallife-groupon-common_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    public static final class InsertItemInfo {
        private final Long InsertAwemeId;
        private final InsertItemTag InsertAwemeTag;
        private final Integer InsertAwemeType;
        private final String InsertLifeMallTrackParams;
        private final Boolean IsHighlight;
        private final Boolean UseNewHighlight;

        public InsertItemInfo() {
            this(null, null, null, null, null, null, 63, null);
        }

        public static /* synthetic */ InsertItemInfo copy$default(InsertItemInfo r100, Long r101, Integer r102, InsertItemTag r103, Boolean r104, Boolean r105, String r110, int r111, Object r112) {
            if ((r111 & 1) == 0) goto L6;
            r101 = r100.InsertAwemeId;
        L6:
            if ((r111 & 2) == 0) goto L8;
            r102 = r100.InsertAwemeType;
        L8:
            Integer r113 = r102;
            if ((r111 & 4) == 0) goto L11;
            r103 = r100.InsertAwemeTag;
        L11:
            InsertItemTag r106 = r103;
            if ((r111 & 8) == 0) goto L14;
            r104 = r100.IsHighlight;
        L14:
            Boolean r107 = r104;
            if ((r111 & 16) == 0) goto L17;
            r105 = r100.UseNewHighlight;
        L17:
            Boolean r108 = r105;
            if ((r111 & 32) == 0) goto L20;
            r110 = r100.InsertLifeMallTrackParams;
        L20:
            Long r109 = r101;
            return r100.copy(r109, r113, r106, r107, r108, r110);
        }

        public final Long component1() {
            return this.InsertAwemeId;
        }

        public final Integer component2() {
            return this.InsertAwemeType;
        }

        public final InsertItemTag component3() {
            return this.InsertAwemeTag;
        }

        public final Boolean component4() {
            return this.IsHighlight;
        }

        public final Boolean component5() {
            return this.UseNewHighlight;
        }

        public final String component6() {
            return this.InsertLifeMallTrackParams;
        }

        public final InsertItemInfo copy(Long r100, Integer r110, InsertItemTag r111, Boolean r112, Boolean r113, String r114) {
            return new InsertItemInfo(r100, r110, r111, r112, r113, r114);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof InsertItemInfo) == true) goto L8;
            return false;
        L8:
            InsertItemInfo r101 = (InsertItemInfo) r100;
            if (Intrinsics.areEqual(this.InsertAwemeId, r101.InsertAwemeId) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.InsertAwemeType, r101.InsertAwemeType) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.InsertAwemeTag, r101.InsertAwemeTag) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.IsHighlight, r101.IsHighlight) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.UseNewHighlight, r101.UseNewHighlight) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.InsertLifeMallTrackParams, r101.InsertLifeMallTrackParams) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public int hashCode() {
            Long r100 = this.InsertAwemeId;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            Integer r104 = this.InsertAwemeType;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            InsertItemTag r107 = this.InsertAwemeTag;
            if (r107 != null) goto L13;
            int r108 = 0;
        L14:
            int r109 = (r106 + r108) * 31;
            Boolean r110 = this.IsHighlight;
            if (r110 != null) goto L17;
            int r111 = 0;
        L18:
            int r112 = (r109 + r111) * 31;
            Boolean r113 = this.UseNewHighlight;
            if (r113 != null) goto L21;
            int r114 = 0;
        L22:
            int r115 = (r112 + r114) * 31;
            String r116 = this.InsertLifeMallTrackParams;
            if (r116 == null) goto L27;
            r101 = r116.hashCode();
        L27:
            return r115 + r101;
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

        public String toString() {
            return "InsertItemInfo(InsertAwemeId=" + this.InsertAwemeId + ", InsertAwemeType=" + this.InsertAwemeType + ", InsertAwemeTag=" + this.InsertAwemeTag + ", IsHighlight=" + this.IsHighlight + ", UseNewHighlight=" + this.UseNewHighlight + ", InsertLifeMallTrackParams=" + this.InsertLifeMallTrackParams + ')';
        }

        public final Long getInsertAwemeId() {
            return this.InsertAwemeId;
        }

        public final InsertItemTag getInsertAwemeTag() {
            return this.InsertAwemeTag;
        }

        public final Integer getInsertAwemeType() {
            return this.InsertAwemeType;
        }

        public final String getInsertLifeMallTrackParams() {
            return this.InsertLifeMallTrackParams;
        }

        public final Boolean getIsHighlight() {
            return this.IsHighlight;
        }

        public final Boolean getUseNewHighlight() {
            return this.UseNewHighlight;
        }

        public InsertItemInfo(Long r100, Integer r101, InsertItemTag r102, Boolean r103, Boolean r104, String r105) {
            this.InsertAwemeId = r100;
            this.InsertAwemeType = r101;
            this.InsertAwemeTag = r102;
            this.IsHighlight = r103;
            this.UseNewHighlight = r104;
            this.InsertLifeMallTrackParams = r105;
        }

        public /* synthetic */ InsertItemInfo(Long r100, Integer r101, InsertItemTag r102, Boolean r103, Boolean r110, String r111, int r112, DefaultConstructorMarker r113) {
            if ((r112 & 1) == 0) goto L5;
            Long r114 = null;
        L7:
            if ((r112 & 2) == 0) goto L9;
            Integer r104 = null;
        L11:
            if ((r112 & 4) == 0) goto L13;
            InsertItemTag r105 = null;
        L15:
            if ((r112 & 8) == 0) goto L17;
            Boolean r106 = null;
        L19:
            if ((r112 & 16) == 0) goto L21;
            Boolean r107 = null;
        L23:
            if ((r112 & 32) == 0) goto L25;
            String r115 = null;
        L26:
            this(r114, r104, r105, r106, r107, r115);
            return;
        L25:
            r115 = r111;
            goto L26
        L21:
            r107 = r110;
            goto L23
        L17:
            r106 = r103;
            goto L19
        L13:
            r105 = r102;
            goto L15
        L9:
            r104 = r101;
            goto L11
        L5:
            r114 = r100;
            goto L7
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/bytedance/locallife/groupon/service/SearchBackUndertakeManager$InsertItemTag;", "", "Text", "", "(Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "locallife-groupon-common_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    public static final class InsertItemTag {
        private final String Text;

        /* JADX WARN: Multi-variable type inference failed */
        public InsertItemTag() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ InsertItemTag copy$default(InsertItemTag r100, String r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.Text;
        L6:
            return r100.copy(r101);
        }

        public final String component1() {
            return this.Text;
        }

        public final InsertItemTag copy(String r100) {
            return new InsertItemTag(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof InsertItemTag) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.Text, ((InsertItemTag) r100).Text) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            String r100 = this.Text;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public String toString() {
            return "InsertItemTag(Text=" + this.Text + ')';
        }

        public final String getText() {
            return this.Text;
        }

        public InsertItemTag(String r100) {
            this.Text = r100;
        }

        public /* synthetic */ InsertItemTag(String r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = null;
        L5:
            this(r100);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007\u0012\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007¢\u0006\u0002\u0010\nJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0017\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007HÆ\u0003J\u0017\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007HÆ\u0003JV\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00072\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\bHÖ\u0001R\u001f\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001f\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/bytedance/locallife/groupon/service/SearchBackUndertakeManager$UndertakePayload;", "", "first_pull_scene", "", "feed_origin_gid_info", "Lcom/bytedance/locallife/groupon/service/SearchBackUndertakeManager$FeedOriginGidInfo;", "dolphin", "", "", "extra_params", "(Ljava/lang/Integer;Lcom/bytedance/locallife/groupon/service/SearchBackUndertakeManager$FeedOriginGidInfo;Ljava/util/Map;Ljava/util/Map;)V", "getDolphin", "()Ljava/util/Map;", "getExtra_params", "getFeed_origin_gid_info", "()Lcom/bytedance/locallife/groupon/service/SearchBackUndertakeManager$FeedOriginGidInfo;", "getFirst_pull_scene", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Lcom/bytedance/locallife/groupon/service/SearchBackUndertakeManager$FeedOriginGidInfo;Ljava/util/Map;Ljava/util/Map;)Lcom/bytedance/locallife/groupon/service/SearchBackUndertakeManager$UndertakePayload;", "equals", "", "other", "hashCode", "toString", "locallife-groupon-common_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    public static final class UndertakePayload {
        private final Map<String, Object> dolphin;
        private final Map<String, Object> extra_params;
        private final FeedOriginGidInfo feed_origin_gid_info;
        private final Integer first_pull_scene;

        public UndertakePayload() {
            this(null, null, null, null, 15, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ UndertakePayload copy$default(UndertakePayload r100, Integer r101, FeedOriginGidInfo r102, Map r103, Map r104, int r105, Object r106) {
            if ((r105 & 1) == 0) goto L6;
            r101 = r100.first_pull_scene;
        L6:
            if ((r105 & 2) == 0) goto L9;
            r102 = r100.feed_origin_gid_info;
        L9:
            if ((r105 & 4) == 0) goto L12;
            r103 = r100.dolphin;
        L12:
            if ((r105 & 8) == 0) goto L15;
            r104 = r100.extra_params;
        L15:
            return r100.copy(r101, r102, r103, r104);
        }

        public final Integer component1() {
            return this.first_pull_scene;
        }

        public final FeedOriginGidInfo component2() {
            return this.feed_origin_gid_info;
        }

        public final Map<String, Object> component3() {
            return this.dolphin;
        }

        public final Map<String, Object> component4() {
            return this.extra_params;
        }

        public final UndertakePayload copy(Integer r100, FeedOriginGidInfo r101, Map<String, ? extends Object> r102, Map<String, ? extends Object> r103) {
            return new UndertakePayload(r100, r101, r102, r103);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof UndertakePayload) == true) goto L8;
            return false;
        L8:
            UndertakePayload r101 = (UndertakePayload) r100;
            if (Intrinsics.areEqual(this.first_pull_scene, r101.first_pull_scene) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.feed_origin_gid_info, r101.feed_origin_gid_info) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.dolphin, r101.dolphin) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.extra_params, r101.extra_params) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            Integer r100 = this.first_pull_scene;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            FeedOriginGidInfo r104 = this.feed_origin_gid_info;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            Map<String, Object> r107 = this.dolphin;
            if (r107 != null) goto L13;
            int r108 = 0;
        L14:
            int r109 = (r106 + r108) * 31;
            Map<String, Object> r110 = this.extra_params;
            if (r110 == null) goto L19;
            r101 = r110.hashCode();
        L19:
            return r109 + r101;
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

        public String toString() {
            return "UndertakePayload(first_pull_scene=" + this.first_pull_scene + ", feed_origin_gid_info=" + this.feed_origin_gid_info + ", dolphin=" + this.dolphin + ", extra_params=" + this.extra_params + ')';
        }

        public final Map<String, Object> getDolphin() {
            return this.dolphin;
        }

        public final Map<String, Object> getExtra_params() {
            return this.extra_params;
        }

        public final FeedOriginGidInfo getFeed_origin_gid_info() {
            return this.feed_origin_gid_info;
        }

        public final Integer getFirst_pull_scene() {
            return this.first_pull_scene;
        }

        public UndertakePayload(Integer r100, FeedOriginGidInfo r101, Map<String, ? extends Object> r102, Map<String, ? extends Object> r103) {
            this.first_pull_scene = r100;
            this.feed_origin_gid_info = r101;
            this.dolphin = r102;
            this.extra_params = r103;
        }

        public /* synthetic */ UndertakePayload(Integer r100, FeedOriginGidInfo r101, Map r102, Map r103, int r104, DefaultConstructorMarker r105) {
            if ((r104 & 1) == 0) goto L6;
            r100 = null;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r101 = null;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r102 = null;
        L12:
            if ((r104 & 8) == 0) goto L14;
            r103 = null;
        L14:
            this(r100, r101, r102, r103);
        }
    }

    static {
        INSTANCE = new SearchBackUndertakeManager();
    }

    private SearchBackUndertakeManager() {
    }

    public final String consumePayload() {
        String r100 = payload;
        payload = null;
        return r100;
    }

    public final Map<String, String> consumeSearchParams() {
        Map<String, String> r100 = searchParams;
        searchParams = null;
        return r100;
    }

    public final boolean hasParams() {
        String r100 = payload;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L10:
        return !r101;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L10
    }

    public final UndertakePayload consumePayloadModel() {
        String r100 = consumePayload();
        Object r101 = null;
        if (r100 != null) goto L15;
        return null;
    L15:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        Object r103 = Result.m9449constructorimpl(fromJsonString(r100));     // Catch: Throwable -> L7
    L10:
        if (Result.m9455isFailureimpl(r103) == true) goto L14;
        r101 = r103;
    L14:
        return (UndertakePayload) r101;
    L7:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    private final UndertakePayload fromJsonString(String r110) {
        JSONObject r100 = new JSONObject(r110);
        int r101 = 0;
        int r102 = r100.optInt("first_pull_scene", 0);
        LinkedHashMap r103 = null;
        if (r102 == 0) goto L5;
    L7:
        Integer r104 = Integer.valueOf(r102);
    L8:
        JSONObject r105 = r100.optJSONObject("feed_origin_gid_info");
        if (r105 == null) goto L49;
        JSONArray r106 = r105.optJSONArray("InsertItemInfo");
        if (r106 == null) goto L43;
        List r107 = CollectionsKt.createListBuilder();
        int r108 = r106.length();
    L13:
        if (r101 >= r108) goto L42;
        JSONObject r109 = r106.optJSONObject(r101);
        if (r109 == null) goto L41;
        JSONObject r111 = r109.optJSONObject("InsertAwemeTag");
        if (r111 == null) goto L19;
        InsertItemTag r112 = new InsertItemTag(r111.optString("Text", null));
    L21:
        if (r109.has("InsertAwemeId") == false) goto L23;
        Long r113 = Long.valueOf(r109.optLong("InsertAwemeId"));
    L25:
        if (r109.has("InsertAwemeType") == false) goto L27;
        Integer r114 = Integer.valueOf(r109.optInt("InsertAwemeType"));
    L29:
        if (r109.has("IsHighlight") == false) goto L31;
        Boolean r115 = Boolean.valueOf(r109.optBoolean("IsHighlight"));
    L33:
        if (r109.has("UseNewHighlight") == false) goto L35;
        Boolean r116 = Boolean.valueOf(r109.optBoolean("UseNewHighlight"));
    L37:
        if (r109.has("InsertLifeMallTrackParams") == false) goto L39;
        String r117 = r109.optString("InsertLifeMallTrackParams");
    L40:
        r107.add(new InsertItemInfo(r113, r114, r112, r115, r116, r117));
        goto L41
    L39:
        r117 = null;
        goto L40
    L35:
        r116 = null;
        goto L37
    L31:
        r115 = null;
        goto L33
    L27:
        r114 = null;
        goto L29
    L23:
        r113 = null;
        goto L25
    L19:
        r112 = null;
    L41:
        r101 = r101 + 1;
        goto L13
    L42:
        List r118 = CollectionsKt.build(r107);
    L45:
        if (r105.has("PromotionType") == false) goto L47;
        Integer r119 = Integer.valueOf(r105.optInt("PromotionType"));
    L48:
        FeedOriginGidInfo r120 = new FeedOriginGidInfo(r119, r118);
    L50:
        JSONObject r121 = r100.optJSONObject("dolphin");
        if (r121 == null) goto L56;
        Sequence r122 = SequencesKt.asSequence(r121.keys());
        LinkedHashMap r123 = new LinkedHashMap();
        Iterator r124 = r122.iterator();
    L54:
        if (r124.hasNext() == false) goto L57;
        Object r125 = r124.next();
        r123.put(r125, r121.opt((String) r125));
    L57:
        JSONObject r126 = r100.optJSONObject("extra_params");
        if (r126 == null) goto L64;
        Sequence r127 = SequencesKt.asSequence(r126.keys());
        r103 = new LinkedHashMap();
        Iterator r128 = r127.iterator();
    L61:
        if (r128.hasNext() == false) goto L64;
        Object r129 = r128.next();
        r103.put(r129, r126.opt((String) r129));
    L64:
        return new UndertakePayload(r104, r120, r123, r103);
    L56:
        r123 = null;
        goto L57
    L47:
        r119 = null;
        goto L48
    L43:
        r118 = null;
        goto L45
    L49:
        r120 = null;
        goto L50
    L5:
        if (r100.has("first_pull_scene") == true) goto L7;
        r104 = null;
        goto L8
    }

    private final String toJsonString(UndertakePayload r110) {
        JSONObject r100 = new JSONObject();
        Integer r101 = r110.getFirst_pull_scene();
        if (r101 == null) goto L5;
        r100.put("first_pull_scene", r101.intValue());
    L5:
        FeedOriginGidInfo r102 = r110.getFeed_origin_gid_info();
        if (r102 == null) goto L39;
        JSONObject r103 = new JSONObject();
        Integer r104 = r102.getPromotionType();
        if (r104 == null) goto L10;
        r103.put("PromotionType", r104.intValue());
    L10:
        List<InsertItemInfo> r105 = r102.getInsertItemInfo();
        if (r105 == null) goto L38;
        JSONArray r106 = new JSONArray();
        Iterator<T> r107 = r105.iterator();
    L14:
        if (r107.hasNext() == false) goto L37;
        InsertItemInfo r108 = (InsertItemInfo) r107.next();
        JSONObject r109 = new JSONObject();
        Long r111 = r108.getInsertAwemeId();
        if (r111 == null) goto L18;
        r109.put("InsertAwemeId", r111.longValue());
    L18:
        Integer r112 = r108.getInsertAwemeType();
        if (r112 == null) goto L21;
        r109.put("InsertAwemeType", r112.intValue());
    L21:
        InsertItemTag r113 = r108.getInsertAwemeTag();
        if (r113 == null) goto L27;
        JSONObject r114 = new JSONObject();
        String r115 = r113.getText();
        if (r115 == null) goto L26;
        r114.put("Text", r115);
    L26:
        Unit r116 = Unit.INSTANCE;
        r109.put("InsertAwemeTag", r114);
    L27:
        Boolean r117 = r108.getIsHighlight();
        if (r117 == null) goto L30;
        r109.put("IsHighlight", r117.booleanValue());
    L30:
        Boolean r118 = r108.getUseNewHighlight();
        if (r118 == null) goto L33;
        r109.put("UseNewHighlight", r118.booleanValue());
    L33:
        String r119 = r108.getInsertLifeMallTrackParams();
        if (r119 == null) goto L36;
        r109.put("InsertLifeMallTrackParams", r119);
    L36:
        r106.put(r109);
        goto L14
    L37:
        Unit r120 = Unit.INSTANCE;
        r103.put("InsertItemInfo", r106);
    L38:
        r100.put("feed_origin_gid_info", r103);
    L39:
        Map<String, Object> r121 = r110.getDolphin();
        if (r121 == null) goto L46;
        JSONObject r122 = new JSONObject();
        Iterator<Map.Entry<String, Object>> r123 = r121.entrySet().iterator();
    L43:
        if (r123.hasNext() == false) goto L45;
        Map.Entry<String, Object> r124 = r123.next();
        r122.put(r124.getKey(), r124.getValue());
        goto L43
    L45:
        r100.put("dolphin", r122);
    L46:
        Map<String, Object> r125 = r110.getExtra_params();
        if (r125 == null) goto L54;
        JSONObject r126 = new JSONObject();
        Iterator<Map.Entry<String, Object>> r127 = r125.entrySet().iterator();
    L50:
        if (r127.hasNext() == false) goto L52;
        Map.Entry<String, Object> r128 = r127.next();
        r126.put(r128.getKey(), r128.getValue());
        goto L50
    L52:
        r100.put("extra_params", r126);
    L54:
        return r100.toString();
    }

    public final void setPayload(UndertakePayload r100) {
        if (r100 != null) goto L5;
        payload = null;
        searchParams = null;
        return;
    L5:
        payload = toJsonString(r100);
    }

    public final void setSearchParams(Map<String, String> r100) {
        searchParams = r100;
    }
}
