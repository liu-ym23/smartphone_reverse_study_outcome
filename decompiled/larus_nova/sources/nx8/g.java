package nx8;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b,\b\u0086\b\u0018\u00002\u00020\u0001B£\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0012\b\u0002\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0014\u0010\u0015J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010-\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0013\u0010.\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000bHÆ\u0003J\u0010\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0013\u00100\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000bHÆ\u0003J\u0010\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000b\u00103\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0005HÆ\u0003Jª\u0001\u00105\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0012\b\u0002\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u00106J\u0013\u00107\u001a\u00020\f2\b\u00108\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00109\u001a\u00020\u0003HÖ\u0001J\t\u0010:\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR \u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001a\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b#\u0010\u001cR \u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\"R\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b%\u0010\u001cR\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b&\u0010\u001cR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0019R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0019¨\u0006;"}, d2 = {"Lcom/larus/camera/impl/edulibs/cameraapi/EduImageMessageExt;", "", "os", "", com.heytap.mcssdk.constant.b.C, "", "picSource", "detectionType", "detectionId", "", "userChangeBoxes", "", "", "essayScene", "searchContent", "Lcom/larus/camera/impl/edulibs/cameraapi/EduImageSearchContent;", "selectIndex", "detectionSceneType", "requestId", "eduExtraParam", "<init>", "(ILjava/lang/String;ILjava/lang/Integer;Ljava/lang/Long;Ljava/util/List;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getOs", "()I", "getSdkVersion", "()Ljava/lang/String;", "getPicSource", "getDetectionType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDetectionId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getUserChangeBoxes", "()Ljava/util/List;", "getEssayScene", "getSearchContent", "getSelectIndex", "getDetectionSceneType", "getRequestId", "getEduExtraParam", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "(ILjava/lang/String;ILjava/lang/Integer;Ljava/lang/Long;Ljava/util/List;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/larus/camera/impl/edulibs/cameraapi/EduImageMessageExt;", "equals", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient String f521077a;

    @SerializedName("detection_id")
    private final Long detectionId;

    @SerializedName("detection_scene_type")
    private final Integer detectionSceneType;

    @SerializedName(EventConstant.Key.DETECTION_TYPE)
    private final Integer detectionType;

    @SerializedName("essay_scene")
    private final Integer essayScene;

    /* JADX INFO: renamed from: os, reason: collision with root package name */
    @SerializedName("os")
    private final int f521078os;

    @SerializedName("picture_source")
    private final int picSource;

    @SerializedName("request_id")
    private final String requestId;

    @SerializedName("edu_camera_sdk_version")
    private final String sdkVersion;

    @SerializedName("search_content")
    private final List<j> searchContent;

    @SerializedName("search_index")
    private final Integer selectIndex;

    @SerializedName("user_change_boxes")
    private final List<Boolean> userChangeBoxes;

    public g() {
        this(null, null, null, null, null, null, null, null, null, null, UnixStat.PERM_MASK);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (this.f521078os == r101.f521078os) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.sdkVersion, r101.sdkVersion) == true) goto L15;
        return false;
    L15:
        if (this.picSource == r101.picSource) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.detectionType, r101.detectionType) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.detectionId, r101.detectionId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.userChangeBoxes, r101.userChangeBoxes) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.essayScene, r101.essayScene) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.searchContent, r101.searchContent) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.selectIndex, r101.selectIndex) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.detectionSceneType, r101.detectionSceneType) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.requestId, r101.requestId) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f521077a, r101.f521077a) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f521078os * 31;
        String r101 = this.sdkVersion;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((r100 + r103) * 31) + this.picSource) * 31;
        Integer r105 = this.detectionType;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Long r108 = this.detectionId;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        List<Boolean> r111 = this.userChangeBoxes;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        Integer r114 = this.essayScene;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        List<j> r117 = this.searchContent;
        if (r117 != null) goto L25;
        int r118 = 0;
    L26:
        int r119 = (r116 + r118) * 31;
        Integer r120 = this.selectIndex;
        if (r120 != null) goto L29;
        int r121 = 0;
    L30:
        int r122 = (r119 + r121) * 31;
        Integer r123 = this.detectionSceneType;
        if (r123 != null) goto L33;
        int r124 = 0;
    L34:
        int r125 = (r122 + r124) * 31;
        String r126 = this.requestId;
        if (r126 != null) goto L37;
        int r127 = 0;
    L38:
        int r128 = (r125 + r127) * 31;
        String r129 = this.f521077a;
        if (r129 == null) goto L43;
        r102 = r129.hashCode();
    L43:
        return r128 + r102;
    L37:
        r127 = r126.hashCode();
        goto L38
    L33:
        r124 = r123.hashCode();
        goto L34
    L29:
        r121 = r120.hashCode();
        goto L30
    L25:
        r118 = r117.hashCode();
        goto L26
    L21:
        r115 = r114.hashCode();
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "EduImageMessageExt(os=" + this.f521078os + ", sdkVersion=" + this.sdkVersion + ", picSource=" + this.picSource + ", detectionType=" + this.detectionType + ", detectionId=" + this.detectionId + ", userChangeBoxes=" + this.userChangeBoxes + ", essayScene=" + this.essayScene + ", searchContent=" + this.searchContent + ", selectIndex=" + this.selectIndex + ", detectionSceneType=" + this.detectionSceneType + ", requestId=" + this.requestId + ", eduExtraParam=" + this.f521077a + ')';
    }

    public g(String r100, Integer r101, Long r102, List r103, Integer r104, List r110, Integer r111, Integer r112, String r113, String r114, int r115) {
        int r105 = 0;
        if ((r115 & 1) == 0) goto L5;
        int r106 = 2;
    L7:
        if ((r115 & 2) == 0) goto L10;
        r100 = "";
    L10:
        if ((r115 & 4) == 0) goto L13;
        r105 = 1;
    L13:
        if ((r115 & 8) == 0) goto L16;
        r101 = null;
    L16:
        if ((r115 & 16) == 0) goto L19;
        r102 = null;
    L19:
        if ((r115 & 32) == 0) goto L22;
        r103 = null;
    L22:
        if ((r115 & 64) == 0) goto L25;
        r104 = null;
    L25:
        if ((r115 & 128) == 0) goto L28;
        r110 = null;
    L28:
        if ((r115 & 256) == 0) goto L31;
        r111 = null;
    L31:
        if ((r115 & 512) == 0) goto L34;
        r112 = null;
    L34:
        if ((r115 & 1024) == 0) goto L37;
        r113 = null;
    L37:
        if ((r115 & 2048) == 0) goto L39;
        r114 = null;
    L39:
        this.f521078os = r106;
        this.sdkVersion = r100;
        this.picSource = r105;
        this.detectionType = r101;
        this.detectionId = r102;
        this.userChangeBoxes = r103;
        this.essayScene = r104;
        this.searchContent = r110;
        this.selectIndex = r111;
        this.detectionSceneType = r112;
        this.requestId = r113;
        this.f521077a = r114;
        return;
    L5:
        r106 = 0;
        goto L7
    }
}
