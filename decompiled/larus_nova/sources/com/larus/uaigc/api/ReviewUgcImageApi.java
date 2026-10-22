package com.larus.uaigc.api;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import com.google.gson.annotations.SerializedName;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.network.bean.BizResponse;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u0000 \u00112\u00020\u0001:\u0006\f\r\u000e\u000f\u0010\u0011J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\nH§@¢\u0006\u0002\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/larus/uaigc/api/ReviewUgcImageApi;", "", "reviewUgcImage", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/uaigc/api/ReviewUgcImageApi$ReviewUgcImageData;", "request", "Lcom/larus/uaigc/api/ReviewUgcImageApi$ReviewUgcImageRequest;", "(Lcom/larus/uaigc/api/ReviewUgcImageApi$ReviewUgcImageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reviewImageByPreHandlerV2", "Lcom/larus/uaigc/api/ReviewUgcImageApi$PreHandlerV2ReviewImageResponse;", "Lcom/larus/uaigc/api/ReviewUgcImageApi$PreHandlerV2ReviewImageRequest;", "(Lcom/larus/uaigc/api/ReviewUgcImageApi$PreHandlerV2ReviewImageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "PreHandlerV2ReviewImageRequest", "PreHandlerV2ReviewImageResponse", "ReviewUgcImageRequest", "ReviewUgcImageData", "CheckResultEnum", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ReviewUgcImageApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f370263a = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/uaigc/api/ReviewUgcImageApi$CheckResultEnum;", "", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface CheckResultEnum {
        public static final a Companion = null;
        public static final int NOT_RECOMMEND = 5;
        public static final int OTHER = 100;
        public static final int PASS = 1;
        public static final int PENDING = 2;
        public static final int SELF_VISIBLE = 7;
        public static final int UN_PASS = 3;
        public static final int UN_PASS_BUT_IGNORED = 6;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f370264a = null;

            static {
                f370264a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.f370264a;
        }
    }

    public static final class Companion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f370265a = null;

        static {
            f370265a = new Companion();
        }

        public Companion() {
        }

        public static Object a(Function2 r100, Continuation r101) {
            return BuildersKt.withContext(Dispatchers.getIO(), new ReviewUgcImageApi$Companion$safeCall$2(r100, null), r101);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\nR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/larus/uaigc/api/ReviewUgcImageApi$PreHandlerV2ReviewImageRequest;", "", "uplinkEntity", "Lcom/larus/im/bean/message/UplinkFileEntity;", "conversationId", "", "botId", "sectionId", "localMsgId", "<init>", "(Lcom/larus/im/bean/message/UplinkFileEntity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getUplinkEntity", "()Lcom/larus/im/bean/message/UplinkFileEntity;", "getConversationId", "()Ljava/lang/String;", "getBotId", "getSectionId", "getLocalMsgId", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a {

        @SerializedName("bot_id")
        private final String botId;

        @SerializedName("conversation_id")
        private final String conversationId;

        @SerializedName("local_message_id")
        private final String localMsgId;

        @SerializedName("section_id")
        private final String sectionId;

        @SerializedName("uplink_entity")
        private final UplinkFileEntity uplinkEntity;

        public a() {
            this(null, null, null, null, null);
        }

        public a(UplinkFileEntity r100, String r101, String r102, String r103, String r104) {
            this.uplinkEntity = r100;
            this.conversationId = r101;
            this.botId = r102;
            this.sectionId = r103;
            this.localMsgId = r104;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/larus/uaigc/api/ReviewUgcImageApi$PreHandlerV2ReviewImageResponse;", "", "code", "", "msg", "", "<init>", "(JLjava/lang/String;)V", "getCode", "()J", "getMsg", "()Ljava/lang/String;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b {

        @SerializedName("code")
        private final long code;

        @SerializedName("msg")
        private final String msg;

        public b() {
            this.code = 0;
            this.msg = "";
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/larus/uaigc/api/ReviewUgcImageApi$ReviewUgcImageData;", "", "checkResult", "", "faceDetected", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/Boolean;)V", "getCheckResult", "()Ljava/lang/Integer;", "setCheckResult", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getFaceDetected", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class c {

        @SerializedName(LocationMonitorConst.CHECK_RESULT)
        private Integer checkResult;

        @SerializedName("face_detected")
        private final Boolean faceDetected;

        public c() {
            this.checkResult = null;
            this.faceDetected = null;
        }

        public final Integer a() {
            return this.checkResult;
        }

        public final Boolean b() {
            return this.faceDetected;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/larus/uaigc/api/ReviewUgcImageApi$ReviewUgcImageRequest;", "", "imageUri", "", "needReview", "", "needDetectFace", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getImageUri", "()Ljava/lang/String;", "setImageUri", "(Ljava/lang/String;)V", "getNeedReview", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getNeedDetectFace", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class d {

        @SerializedName("image_uri")
        private String imageUri;

        @SerializedName("need_detect_face")
        private final Boolean needDetectFace;

        @SerializedName("need_review")
        private final Boolean needReview;

        /* JADX WARN: Multi-variable type inference failed */
        public d() {
            Object[] r100 = 0 == true ? 1 : 0;
            this(null, r100, 7);
        }

        public /* synthetic */ d(String r100, Boolean r101, int r102) {
            if ((r102 & 1) == 0) goto L6;
            r100 = null;
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = null;
        L8:
            this(r100, r101, null);
        }

        public d(String r100, Boolean r101, Boolean r102) {
            this.imageUri = r100;
            this.needReview = r101;
            this.needDetectFace = r102;
        }
    }

    static {
        f370263a = Companion.f370265a;
    }

    @POST("alice/message/pre_handle_v2")
    Object reviewImageByPreHandlerV2(@Body a r100, Continuation<? super BizResponse<b>> r101);

    @POST("/creativity/image/pre_handle")
    Object reviewUgcImage(@Body d r100, Continuation<? super BizResponse<c>> r101);
}
