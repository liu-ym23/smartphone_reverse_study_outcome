package ox8;

import com.google.gson.annotations.SerializedName;
import com.larus.camera.impl.edulibs.cameraapi.idl.RpcErrorCode;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b/\b\u0086\b\u0018\u00002\u00020\u0001BÕ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u001a\b\u0002\u0010\b\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t\u0018\u00010\t\u0012\u001a\b\u0002\u0010\u000b\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\t\u0018\u00010\t\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u00104\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u001b\u00105\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t\u0018\u00010\tHÆ\u0003J\u001b\u00106\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\t\u0018\u00010\tHÆ\u0003J\u0011\u00107\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tHÆ\u0003J\u0010\u00108\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010;\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010)J\u000b\u0010<\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010?\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0002\u00100JÜ\u0001\u0010@\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u001a\b\u0002\u0010\b\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t\u0018\u00010\t2\u001a\b\u0002\u0010\u000b\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\t\u0018\u00010\t2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÆ\u0001¢\u0006\u0002\u0010AJ\u0013\u0010B\u001a\u00020\u00172\b\u0010C\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010D\u001a\u00020\u0007HÖ\u0001J\t\u0010E\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR(\u0010\b\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R(\u0010\u000b\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\t\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u001e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\"R\u001a\u0010\r\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b%\u0010\u001fR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001bR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001bR\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010*\u001a\u0004\b(\u0010)R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001bR\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001bR\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\n\n\u0002\u00101\u001a\u0004\b/\u00100¨\u0006F"}, d2 = {"Lcom/larus/camera/impl/edulibs/cameraapi/idl/QuestionDetectionResponse;", "", "traceId", "", "rpcCode", "Lcom/larus/camera/impl/edulibs/cameraapi/idl/RpcErrorCode;", "elapsedTime", "", "questionBoxes", "", "Lcom/larus/camera/impl/edulibs/cameraapi/idl/QuestionPoly;", "questionImages", "centralBoxIndexList", "imageOrientation", "handWrittenRemovalBase64", "imageDewarpBase64", "detectionId", "", "statusInfo", "Lcom/larus/camera/impl/edulibs/cameraapi/idl/StatusInfo;", "requestId", "eduExtraParam", "homeworkCorrectionEnabled", "", "<init>", "(Ljava/lang/String;Lcom/larus/camera/impl/edulibs/cameraapi/idl/RpcErrorCode;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lcom/larus/camera/impl/edulibs/cameraapi/idl/StatusInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getTraceId", "()Ljava/lang/String;", "getRpcCode", "()Lcom/larus/camera/impl/edulibs/cameraapi/idl/RpcErrorCode;", "getElapsedTime", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getQuestionBoxes", "()Ljava/util/List;", "getQuestionImages", "getCentralBoxIndexList", "getImageOrientation", "getHandWrittenRemovalBase64", "getImageDewarpBase64", "getDetectionId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getStatusInfo", "()Lcom/larus/camera/impl/edulibs/cameraapi/idl/StatusInfo;", "getRequestId", "getEduExtraParam", "getHomeworkCorrectionEnabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "(Ljava/lang/String;Lcom/larus/camera/impl/edulibs/cameraapi/idl/RpcErrorCode;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lcom/larus/camera/impl/edulibs/cameraapi/idl/StatusInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/larus/camera/impl/edulibs/cameraapi/idl/QuestionDetectionResponse;", "equals", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Boolean f527094a;

    @SerializedName("CentralBoxIndexList")
    private final List<Integer> centralBoxIndexList;

    @SerializedName("detection_id")
    private final Long detectionId;

    @SerializedName("edu_extra_param")
    private final String eduExtraParam;

    @SerializedName("ElapsedTime")
    private final Integer elapsedTime;

    @SerializedName("HandWrittenRemovalBase64")
    private final String handWrittenRemovalBase64;

    @SerializedName("ImageDewarpBase64")
    private final String imageDewarpBase64;

    @SerializedName("image_orientation")
    private final Integer imageOrientation;

    @SerializedName("QuestionBoxes")
    private final List<List<g>> questionBoxes;

    @SerializedName("QuestionImages")
    private final List<List<String>> questionImages;

    @SerializedName("request_id")
    private final String requestId;

    @SerializedName("RpcCode")
    private final RpcErrorCode rpcCode;

    @SerializedName("status_info")
    private final i statusInfo;

    @SerializedName("TraceId")
    private final String traceId;

    public e() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.traceId, r101.traceId) == true) goto L12;
        return false;
    L12:
        if (this.rpcCode == r101.rpcCode) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.elapsedTime, r101.elapsedTime) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.questionBoxes, r101.questionBoxes) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.questionImages, r101.questionImages) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.centralBoxIndexList, r101.centralBoxIndexList) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.imageOrientation, r101.imageOrientation) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.handWrittenRemovalBase64, r101.handWrittenRemovalBase64) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.imageDewarpBase64, r101.imageDewarpBase64) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.detectionId, r101.detectionId) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.statusInfo, r101.statusInfo) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.requestId, r101.requestId) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.eduExtraParam, r101.eduExtraParam) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f527094a, r101.f527094a) == true) goto L50;
        return false;
    L50:
        return true;
    }

    public final int hashCode() {
        String r100 = this.traceId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        RpcErrorCode r104 = this.rpcCode;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.elapsedTime;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        List<List<g>> r110 = this.questionBoxes;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        List<List<String>> r113 = this.questionImages;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        List<Integer> r116 = this.centralBoxIndexList;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.imageOrientation;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.handWrittenRemovalBase64;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.imageDewarpBase64;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        Long r128 = this.detectionId;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        i r131 = this.statusInfo;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.requestId;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        String r137 = this.eduExtraParam;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        Boolean r140 = this.f527094a;
        if (r140 == null) goto L59;
        r101 = r140.hashCode();
    L59:
        return r139 + r101;
    L53:
        r138 = r137.hashCode();
        goto L54
    L49:
        r135 = r134.hashCode();
        goto L50
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

    public final String toString() {
        return "QuestionDetectionResponse(traceId=" + this.traceId + ", rpcCode=" + this.rpcCode + ", elapsedTime=" + this.elapsedTime + ", questionBoxes=" + this.questionBoxes + ", questionImages=" + this.questionImages + ", centralBoxIndexList=" + this.centralBoxIndexList + ", imageOrientation=" + this.imageOrientation + ", handWrittenRemovalBase64=" + this.handWrittenRemovalBase64 + ", imageDewarpBase64=" + this.imageDewarpBase64 + ", detectionId=" + this.detectionId + ", statusInfo=" + this.statusInfo + ", requestId=" + this.requestId + ", eduExtraParam=" + this.eduExtraParam + ", homeworkCorrectionEnabled=" + this.f527094a + ')';
    }

    public final List<Integer> b() {
        return this.centralBoxIndexList;
    }

    public final Long c() {
        return this.detectionId;
    }

    public final String d() {
        return this.eduExtraParam;
    }

    public final String e() {
        return this.imageDewarpBase64;
    }

    public final Integer f() {
        return this.imageOrientation;
    }

    public final List<List<g>> g() {
        return this.questionBoxes;
    }

    public final List<List<String>> h() {
        return this.questionImages;
    }

    public final String i() {
        return this.requestId;
    }

    public final String j() {
        return this.traceId;
    }

    public static e a(e r110, Integer r210, String r211, String r212, Boolean r213, int r214) {
        i r100 = null;
        if ((r214 & 1) == 0) goto L5;
        String r101 = r110.traceId;
    L7:
        if ((r214 & 2) == 0) goto L9;
        RpcErrorCode r102 = r110.rpcCode;
    L11:
        if ((r214 & 4) == 0) goto L13;
        Integer r103 = r110.elapsedTime;
    L15:
        if ((r214 & 8) == 0) goto L17;
        List<List<g>> r104 = r110.questionBoxes;
    L19:
        if ((r214 & 16) == 0) goto L21;
        List<List<String>> r105 = r110.questionImages;
    L23:
        if ((r214 & 32) == 0) goto L25;
        List<Integer> r111 = r110.centralBoxIndexList;
    L27:
        if ((r214 & 64) == 0) goto L29;
        Integer r112 = r110.imageOrientation;
    L31:
        if ((r214 & 128) == 0) goto L33;
        String r113 = r110.handWrittenRemovalBase64;
    L35:
        if ((r214 & 256) == 0) goto L37;
        String r114 = r110.imageDewarpBase64;
    L39:
        if ((r214 & 512) == 0) goto L41;
        Long r115 = r110.detectionId;
    L43:
        if ((r214 & 1024) == 0) goto L45;
        r100 = r110.statusInfo;
    L45:
        i r116 = r100;
        if ((r214 & 2048) == 0) goto L48;
        String r117 = r110.requestId;
    L50:
        if ((r214 & 4096) == 0) goto L52;
        String r118 = r110.eduExtraParam;
    L54:
        if ((r214 & 8192) == 0) goto L56;
        Boolean r119 = r110.f527094a;
    L58:
        return new e(r101, r102, r103, r104, r105, r111, r112, r113, r114, r115, r116, r117, r118, r119);
    L56:
        r119 = r213;
        goto L58
    L52:
        r118 = r212;
        goto L54
    L48:
        r117 = r211;
        goto L50
    L41:
        r115 = null;
        goto L43
    L37:
        r114 = null;
        goto L39
    L33:
        r113 = null;
        goto L35
    L29:
        r112 = r210;
        goto L31
    L25:
        r111 = null;
        goto L27
    L21:
        r105 = null;
        goto L23
    L17:
        r104 = null;
        goto L19
    L13:
        r103 = null;
        goto L15
    L9:
        r102 = null;
        goto L11
    L5:
        r101 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(String r100, RpcErrorCode r101, Integer r102, List<? extends List<g>> r103, List<? extends List<String>> r104, List<Integer> r105, Integer r106, String r107, String r108, Long r110, i r111, String r112, String r113, Boolean r114) {
        this.traceId = r100;
        this.rpcCode = r101;
        this.elapsedTime = r102;
        this.questionBoxes = r103;
        this.questionImages = r104;
        this.centralBoxIndexList = r105;
        this.imageOrientation = r106;
        this.handWrittenRemovalBase64 = r107;
        this.imageDewarpBase64 = r108;
        this.detectionId = r110;
        this.statusInfo = r111;
        this.requestId = r112;
        this.eduExtraParam = r113;
        this.f527094a = r114;
    }

    public /* synthetic */ e(String r110, RpcErrorCode r111, Integer r112, List r113, List r210, List r211, Integer r212, String r213, String r214, Long r215, i r216, String r217, String r218, Boolean r219, int r310) {
        Boolean r100 = null;
        if ((r310 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r310 & 2) == 0) goto L9;
        RpcErrorCode r102 = null;
    L11:
        if ((r310 & 4) == 0) goto L13;
        Integer r103 = null;
    L15:
        if ((r310 & 8) == 0) goto L17;
        List r104 = null;
    L19:
        if ((r310 & 16) == 0) goto L21;
        List r105 = null;
    L23:
        if ((r310 & 32) == 0) goto L25;
        List r106 = null;
    L27:
        if ((r310 & 64) == 0) goto L29;
        Integer r107 = null;
    L31:
        if ((r310 & 128) == 0) goto L33;
        String r108 = null;
    L35:
        if ((r310 & 256) == 0) goto L37;
        String r114 = null;
    L39:
        if ((r310 & 512) == 0) goto L41;
        Long r115 = null;
    L43:
        if ((r310 & 1024) == 0) goto L45;
        i r116 = null;
    L47:
        if ((r310 & 2048) == 0) goto L49;
        String r117 = null;
    L51:
        if ((r310 & 4096) == 0) goto L53;
        String r118 = null;
    L55:
        if ((r310 & 8192) != 0) goto L58;
        r100 = r219;
    L58:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r114, r115, r116, r117, r118, r100);
        return;
    L53:
        r118 = r218;
        goto L55
    L49:
        r117 = r217;
        goto L51
    L45:
        r116 = r216;
        goto L47
    L41:
        r115 = r215;
        goto L43
    L37:
        r114 = r214;
        goto L39
    L33:
        r108 = r213;
        goto L35
    L29:
        r107 = r212;
        goto L31
    L25:
        r106 = r211;
        goto L27
    L21:
        r105 = r210;
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
