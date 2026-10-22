package com.larus.security.api;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.im.bean.message.Message;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.ServiceType;
import com.larus.platform.service.z2;
import com.privacy.azerothprivacy.AzerothPrivacy;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class AzerothUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AzerothUtils f367839a = null;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/larus/security/api/AzerothUtils$BatchTokenItem;", "", "log_Id", "", "token", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getLog_Id", "()Ljava/lang/String;", "getToken", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class BatchTokenItem {
        private final String log_Id;
        private final String token;

        public static /* synthetic */ BatchTokenItem copy$default(BatchTokenItem r100, String r101, String r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.log_Id;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.token;
        L9:
            return r100.copy(r101, r102);
        }

        public final String component1() {
            return this.log_Id;
        }

        public final String component2() {
            return this.token;
        }

        public final BatchTokenItem copy(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "log_Id");
            Intrinsics.checkNotNullParameter(r101, "token");
            return new BatchTokenItem(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof BatchTokenItem) == true) goto L8;
            return false;
        L8:
            BatchTokenItem r101 = (BatchTokenItem) r100;
            if (Intrinsics.areEqual(this.log_Id, r101.log_Id) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.token, r101.token) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.log_Id.hashCode() * 31) + this.token.hashCode();
        }

        public String toString() {
            return "BatchTokenItem(log_Id=" + this.log_Id + ", token=" + this.token + ')';
        }

        public final String getLog_Id() {
            return this.log_Id;
        }

        public final String getToken() {
            return this.token;
        }

        public BatchTokenItem(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "log_Id");
            Intrinsics.checkNotNullParameter(r101, "token");
            this.log_Id = r100;
            this.token = r101;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BW\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u001a\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0015J^\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\nHÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR \u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0017\u0010\u0015¨\u0006%"}, d2 = {"Lcom/larus/security/api/AzerothUtils$SaveTokenObject;", "", "logID", "", "token", "batchData", "", "Lcom/larus/security/api/AzerothUtils$BatchTokenItem;", "feedbackContent", "feedbackSource", "", "feedbackType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getLogID", "()Ljava/lang/String;", "getToken", "getBatchData", "()Ljava/util/List;", "getFeedbackContent", "getFeedbackSource", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getFeedbackType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/larus/security/api/AzerothUtils$SaveTokenObject;", "equals", "", "other", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SaveTokenObject {

        @SerializedName("batch_data")
        private final List<BatchTokenItem> batchData;

        @SerializedName("feedback_content")
        private final String feedbackContent;

        @SerializedName("feedback_source")
        private final Integer feedbackSource;

        @SerializedName("feedback_type")
        private final Integer feedbackType;

        @SerializedName("log_id")
        private final String logID;

        @SerializedName("token")
        private final String token;

        public SaveTokenObject() {
            this(null, null, null, null, null, null, 63, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SaveTokenObject copy$default(SaveTokenObject r100, String r101, String r102, List r103, String r104, Integer r105, Integer r110, int r111, Object r112) {
            if ((r111 & 1) == 0) goto L6;
            r101 = r100.logID;
        L6:
            if ((r111 & 2) == 0) goto L8;
            r102 = r100.token;
        L8:
            String r113 = r102;
            if ((r111 & 4) == 0) goto L11;
            r103 = r100.batchData;
        L11:
            List r106 = r103;
            if ((r111 & 8) == 0) goto L14;
            r104 = r100.feedbackContent;
        L14:
            String r107 = r104;
            if ((r111 & 16) == 0) goto L17;
            r105 = r100.feedbackSource;
        L17:
            Integer r108 = r105;
            if ((r111 & 32) == 0) goto L20;
            r110 = r100.feedbackType;
        L20:
            String r109 = r101;
            return r100.copy(r109, r113, r106, r107, r108, r110);
        }

        public final String component1() {
            return this.logID;
        }

        public final String component2() {
            return this.token;
        }

        public final List<BatchTokenItem> component3() {
            return this.batchData;
        }

        public final String component4() {
            return this.feedbackContent;
        }

        public final Integer component5() {
            return this.feedbackSource;
        }

        public final Integer component6() {
            return this.feedbackType;
        }

        public final SaveTokenObject copy(String r100, String r110, List<BatchTokenItem> r111, String r112, Integer r113, Integer r114) {
            return new SaveTokenObject(r100, r110, r111, r112, r113, r114);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof SaveTokenObject) == true) goto L8;
            return false;
        L8:
            SaveTokenObject r101 = (SaveTokenObject) r100;
            if (Intrinsics.areEqual(this.logID, r101.logID) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.token, r101.token) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.batchData, r101.batchData) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.feedbackContent, r101.feedbackContent) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.feedbackSource, r101.feedbackSource) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.feedbackType, r101.feedbackType) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public int hashCode() {
            String r100 = this.logID;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.token;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            List<BatchTokenItem> r107 = this.batchData;
            if (r107 != null) goto L13;
            int r108 = 0;
        L14:
            int r109 = (r106 + r108) * 31;
            String r110 = this.feedbackContent;
            if (r110 != null) goto L17;
            int r111 = 0;
        L18:
            int r112 = (r109 + r111) * 31;
            Integer r113 = this.feedbackSource;
            if (r113 != null) goto L21;
            int r114 = 0;
        L22:
            int r115 = (r112 + r114) * 31;
            Integer r116 = this.feedbackType;
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
            return "SaveTokenObject(logID=" + this.logID + ", token=" + this.token + ", batchData=" + this.batchData + ", feedbackContent=" + this.feedbackContent + ", feedbackSource=" + this.feedbackSource + ", feedbackType=" + this.feedbackType + ')';
        }

        public final List<BatchTokenItem> getBatchData() {
            return this.batchData;
        }

        public final String getFeedbackContent() {
            return this.feedbackContent;
        }

        public final Integer getFeedbackSource() {
            return this.feedbackSource;
        }

        public final Integer getFeedbackType() {
            return this.feedbackType;
        }

        public final String getLogID() {
            return this.logID;
        }

        public final String getToken() {
            return this.token;
        }

        public SaveTokenObject(String r100, String r101, List<BatchTokenItem> r102, String r103, Integer r104, Integer r105) {
            this.logID = r100;
            this.token = r101;
            this.batchData = r102;
            this.feedbackContent = r103;
            this.feedbackSource = r104;
            this.feedbackType = r105;
        }

        public /* synthetic */ SaveTokenObject(String r100, String r101, List r102, String r103, Integer r104, Integer r110, int r111, DefaultConstructorMarker r112) {
            String r105 = "";
            if ((r111 & 1) == 0) goto L5;
            String r113 = "";
        L7:
            if ((r111 & 2) != 0) goto L11;
            r105 = r101;
        L11:
            if ((r111 & 4) == 0) goto L13;
            List r106 = null;
        L15:
            if ((r111 & 8) == 0) goto L17;
            String r107 = null;
        L19:
            if ((r111 & 16) == 0) goto L21;
            Integer r108 = null;
        L23:
            if ((r111 & 32) == 0) goto L25;
            r110 = 0;
        L25:
            this(r113, r105, r106, r107, r108, r110);
            return;
        L21:
            r108 = r104;
            goto L23
        L17:
            r107 = r103;
            goto L19
        L13:
            r106 = r102;
            goto L15
        L5:
            r113 = r100;
            goto L7
        }
    }

    static {
        f367839a = new AzerothUtils();
    }

    public AzerothUtils() {
    }

    public static String b(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "logId");
        Intrinsics.checkNotNullParameter(r101, "sectionId");
        Intrinsics.checkNotNullParameter(r102, "messageId");
        boolean r103 = false;
        if (r100.length() != 0) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == false) goto L8;
        return null;
    L8:
        if (r101.length() != 0) goto L10;
        boolean r105 = true;
    L11:
        if (r105 == false) goto L13;
        return null;
    L13:
        if (r102.length() != 0) goto L15;
        r103 = true;
    L15:
        if (r103 == true) goto L35;
        return toa.e.a(r100, r101, r102);
    L19:
        e = move-exception;
        apa.a.c("TraceAuthToken", "generate TraceAuthToken error", e);
        return toa.e.b(r100, r101, r102);
    L23:
        e = move-exception;
        apa.a.c("TraceAuthToken", "generate downgraded TraceAuthToken error", e);
        HashMap r106 = new HashMap();
        r106.put("user_id", AzerothPrivacy.getAppInfo().f530146e);
        r106.put("sdk_version", AzerothPrivacy.getVersion());
        xoa.b r107 = xoa.a.f564690a;
        xoa.b r108 = xoa.a.f564690a;
        xoa.a.a(e, "generate downgraded TraceAuthToken error", r106);
        return "";
    L35:
        return null;
    L10:
        r105 = false;
        goto L11
    L5:
        r104 = false;
        goto L6
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:74:0x018b -> B:75:0x0196). Please report as a decompilation issue!!! */
    public final Object a(Message r210, int r310, Integer r311, String r312, Continuation<? super Unit> r313) {
        if ((r313 instanceof AzerothUtils$generateAndUploadFornaxToken$1) == false) goto L7;
        AzerothUtils$generateAndUploadFornaxToken$1 r100 = (AzerothUtils$generateAndUploadFornaxToken$1) r313;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        int r105 = 0;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        int r106 = r100.I$0;
        Iterator r107 = (Iterator) r100.L$5;
        String r108 = (String) r100.L$4;
        String r109 = (String) r100.L$3;
        String r110 = (String) r100.L$2;
        Integer r111 = (Integer) r100.L$1;
        Message r112 = (Message) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L75:
        int r113 = r106;
        Object r114 = r103;
        Iterator r115 = r107;
        String r116 = r108;
        String r117 = r110;
        Message r118 = r112;
        AzerothUtils$generateAndUploadFornaxToken$1 r119 = r100;
        String r120 = r109;
        Integer r121 = r111;
    L77:
        r105 = 0;
    L41:
        if (r115.hasNext() == false) goto L79;
        String r122 = (String) r115.next();
        Map<String, String> r123 = r118.getExt();
        if (r123 == null) goto L45;
        String r124 = r123.get(r122);
    L46:
        if (r124 != null) goto L48;
    L51:
        boolean r125 = true;
    L52:
        if (r125 == true) goto L76;
        String r126 = b(r124, r116, r120);
        if (r126 != null) goto L56;
    L59:
        boolean r127 = true;
    L60:
        if (r127 == true) goto L76;
        JSONObject r128 = new JSONObject();
        r128.put("log_id", r124);
        r128.put("token", r126);
        r128.put(MusicAppletPage.KEY_MESSAGE_ID, r118.getMessageId());
        r128.put("feedback_source", r113);
        Map<String, String> r129 = r118.getExt();
        if (r129 == null) goto L64;
        String r130 = r129.get("dora_vision_ext");
    L65:
        if (r130 == null) goto L67;
        r128.put("section_id", r118.getSectionId());
        r128.put("mode", r105);
    L67:
        if (r121 == null) goto L69;
        r121.intValue();
        r128.put("feedback_type", r121.intValue());
    L69:
        if (r117 == null) goto L71;
        r128.put("feedback_content", r117);
    L71:
        Unit r131 = Unit.INSTANCE;
        r119.L$0 = r118;
        r119.L$1 = r121;
        r119.L$2 = r117;
        r119.L$3 = r120;
        r119.L$4 = r116;
        r119.L$5 = r115;
        r119.I$0 = r113;
        r119.label = 1;
        String r132 = r120;
        String r211 = r116;
        Iterator r212 = r115;
        Object r133 = r114;
        if (HttpExtKt.k(ServiceType.BASIC_SERVICE, SaveTokenObject.class, "/alice/debug/save_token", r128, null, null, false, null, null, null, r119, 1008) != r133) goto L74;
        return r133;
    L74:
        r112 = r118;
        r106 = r113;
        r111 = r121;
        r110 = r117;
        r100 = r119;
        r103 = r133;
        r109 = r132;
        r108 = r211;
        r107 = r212;
        goto L75
    L64:
        r130 = null;
        goto L65
    L76:
        r114 = r114;
        r120 = r120;
        r116 = r116;
        r115 = r115;
        goto L77
    L56:
        if (r126.length() == 0) goto L59;
        r127 = false;
        goto L60
    L80:
        r114 = r114;
        r120 = r120;
        r116 = r116;
        r115 = r115;
        goto L77
    L48:
        if (r124.length() == 0) goto L51;
        r125 = false;
        goto L52
    L45:
        r124 = null;
    L79:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        if (z2.f365865a.L1() == true) goto L20;
        if (r310 != 1) goto L18;
    L19:
        boolean r134 = true;
    L21:
        if (r134 == true) goto L23;
        String r135 = r210.getMessageId();
        String r136 = r210.getSectionId();
        if (r135 != null) goto L27;
    L30:
        boolean r137 = true;
    L31:
        if (r137 == true) goto L79;
        if (r136 != null) goto L34;
    L37:
        boolean r138 = true;
    L38:
        if (r138 == true) goto L79;
        r120 = r135;
        r114 = r103;
        r116 = r136;
        r115 = CollectionsKt.listOf(new String[]{"inner_log_id", "asr_log_id"}).iterator();
        r117 = r312;
        r113 = r310;
        r119 = r100;
        r118 = r210;
        r121 = r311;
        goto L41
    L34:
        if (r136.length() == 0) goto L37;
        r138 = false;
        goto L38
    L27:
        if (r135.length() == 0) goto L30;
        r137 = false;
        goto L31
    L23:
        return Unit.INSTANCE;
    L18:
        if (r310 == 3) goto L19;
    L20:
        r134 = false;
    L7:
        r100 = new AzerothUtils$generateAndUploadFornaxToken$1(this, r313);
        goto L8
    }
}
