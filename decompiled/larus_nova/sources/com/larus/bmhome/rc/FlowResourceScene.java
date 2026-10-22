package com.larus.bmhome.rc;

import com.bytedance.bdlocation.exception.BDLocationException;
import com.larus.common.apphost.AppHost;
import com.tencent.connect.common.Constants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\b\u0086\u0081\u0002\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0019B!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0018\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u001a"}, d2 = {"Lcom/larus/bmhome/rc/FlowResourceScene;", "", "title", "", "sceneIDForDoubao", "sceneIDForCici", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getSceneIDForDoubao", "getSceneIDForCici", "Unknown", "FileUpload", "ImageVLM", "ImageOCR", "ImageEDU", "VideoUpload", "O_Server", "O_Mobile_Tmp", "O_ASSISTANT_FEEDBACK", "CreationUserVideo", "CreationUserVideoV2", "SpringMainVenue", "toString", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FlowResourceScene extends Enum<FlowResourceScene> {
    public static final a Companion = null;
    public static final FlowResourceScene CreationUserVideo = null;
    public static final FlowResourceScene CreationUserVideoV2 = null;
    public static final FlowResourceScene FileUpload = null;
    public static final FlowResourceScene ImageEDU = null;
    public static final FlowResourceScene ImageOCR = null;
    public static final FlowResourceScene ImageVLM = null;
    public static final FlowResourceScene O_ASSISTANT_FEEDBACK = null;
    public static final FlowResourceScene O_Mobile_Tmp = null;
    public static final FlowResourceScene O_Server = null;
    public static final FlowResourceScene SpringMainVenue = null;
    public static final FlowResourceScene Unknown = null;
    public static final FlowResourceScene VideoUpload = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FlowResourceScene[] f313537a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f313538b = null;
    private final String sceneIDForCici;
    private final String sceneIDForDoubao;
    private final String title;

    public static final class a {
        public a() {
        }

        public static FlowResourceScene a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            if (AppHost.f326268a.isOversea() == false) goto L29;
            FlowResourceScene r101 = FlowResourceScene.FileUpload;
            if (Intrinsics.areEqual(r100, r101.getSceneIDForCici()) == true) goto L65;
            FlowResourceScene r102 = FlowResourceScene.ImageVLM;
            if (Intrinsics.areEqual(r100, r102.getSceneIDForCici()) == true) goto L66;
            FlowResourceScene r103 = FlowResourceScene.ImageOCR;
            if (Intrinsics.areEqual(r100, r103.getSceneIDForCici()) == true) goto L67;
            FlowResourceScene r104 = FlowResourceScene.ImageEDU;
            if (Intrinsics.areEqual(r100, r104.getSceneIDForCici()) == true) goto L68;
            FlowResourceScene r105 = FlowResourceScene.VideoUpload;
            if (Intrinsics.areEqual(r100, r105.getSceneIDForCici()) == true) goto L69;
            FlowResourceScene r106 = FlowResourceScene.O_ASSISTANT_FEEDBACK;
            if (Intrinsics.areEqual(r100, r106.getSceneIDForCici()) == true) goto L70;
            FlowResourceScene r107 = FlowResourceScene.CreationUserVideo;
            if (Intrinsics.areEqual(r100, r107.getSceneIDForCici()) == true) goto L71;
            FlowResourceScene r108 = FlowResourceScene.CreationUserVideoV2;
            if (Intrinsics.areEqual(r100, r108.getSceneIDForCici()) == false) goto L64;
            return r108;
        L64:
            return FlowResourceScene.Unknown;
        L71:
            return r107;
        L70:
            return r106;
        L69:
            return r105;
        L68:
            return r104;
        L67:
            return r103;
        L66:
            return r102;
        L65:
            return r101;
        L29:
            FlowResourceScene r109 = FlowResourceScene.FileUpload;
            if (Intrinsics.areEqual(r100, r109.getSceneIDForDoubao()) == true) goto L73;
            FlowResourceScene r110 = FlowResourceScene.ImageVLM;
            if (Intrinsics.areEqual(r100, r110.getSceneIDForDoubao()) == true) goto L74;
            FlowResourceScene r111 = FlowResourceScene.ImageOCR;
            if (Intrinsics.areEqual(r100, r111.getSceneIDForDoubao()) == true) goto L75;
            FlowResourceScene r112 = FlowResourceScene.ImageEDU;
            if (Intrinsics.areEqual(r100, r112.getSceneIDForDoubao()) == true) goto L76;
            FlowResourceScene r113 = FlowResourceScene.VideoUpload;
            if (Intrinsics.areEqual(r100, r113.getSceneIDForDoubao()) == true) goto L77;
            FlowResourceScene r114 = FlowResourceScene.O_Server;
            if (Intrinsics.areEqual(r100, r114.getSceneIDForDoubao()) == true) goto L78;
            FlowResourceScene r115 = FlowResourceScene.O_Mobile_Tmp;
            if (Intrinsics.areEqual(r100, r115.getSceneIDForDoubao()) == true) goto L79;
            FlowResourceScene r116 = FlowResourceScene.O_ASSISTANT_FEEDBACK;
            if (Intrinsics.areEqual(r100, r116.getSceneIDForDoubao()) == true) goto L80;
            FlowResourceScene r117 = FlowResourceScene.CreationUserVideo;
            if (Intrinsics.areEqual(r100, r117.getSceneIDForDoubao()) == true) goto L81;
            FlowResourceScene r118 = FlowResourceScene.CreationUserVideoV2;
            if (Intrinsics.areEqual(r100, r118.getSceneIDForDoubao()) == true) goto L82;
            FlowResourceScene r119 = FlowResourceScene.SpringMainVenue;
            if (Intrinsics.areEqual(r100, r119.getSceneIDForDoubao()) == false) goto L63;
            return r119;
        L63:
            return FlowResourceScene.Unknown;
        L82:
            return r118;
        L81:
            return r117;
        L80:
            return r116;
        L79:
            return r115;
        L78:
            return r114;
        L77:
            return r113;
        L76:
            return r112;
        L75:
            return r111;
        L74:
            return r110;
        L73:
            return r109;
        }

        public static String b(FlowResourceScene r100) {
            Intrinsics.checkNotNullParameter(r100, "scene");
            if (AppHost.f326268a.isOversea() == false) goto L6;
            return r100.getSceneIDForCici();
        L6:
            return r100.getSceneIDForDoubao();
        }
    }

    public static EnumEntries<FlowResourceScene> getEntries() {
        return f313538b;
    }

    static {
        FlowResourceScene r100 = new FlowResourceScene("Unknown", 0, "unknown", "0", "0");
        Unknown = r100;
        FlowResourceScene r101 = new FlowResourceScene("FileUpload", 1, "upload_file", "5", "4");
        FileUpload = r101;
        FlowResourceScene r102 = new FlowResourceScene("ImageVLM", 2, "vlm_image", "7", "5");
        ImageVLM = r102;
        FlowResourceScene r103 = new FlowResourceScene("ImageOCR", 3, "ocr_image", "8", "6");
        ImageOCR = r103;
        FlowResourceScene r104 = new FlowResourceScene("ImageEDU", 4, "edu_image", Constants.VIA_SHARE_TYPE_MINI_PROGRAM, "7");
        ImageEDU = r104;
        FlowResourceScene r105 = new FlowResourceScene("VideoUpload", 5, "video_upload", "21", "21");
        VideoUpload = r105;
        FlowResourceScene r106 = new FlowResourceScene("O_Server", 6, "o_server", "69", "69");
        O_Server = r106;
        FlowResourceScene r110 = new FlowResourceScene("O_Mobile_Tmp", 7, "o_mobile_tmp", BDLocationException.ERROR_BLUETOOTh_NOT_AVAILABLE, BDLocationException.ERROR_BLUETOOTh_NOT_AVAILABLE);
        O_Mobile_Tmp = r110;
        FlowResourceScene r107 = new FlowResourceScene("O_ASSISTANT_FEEDBACK", 8, "o_assistant_feedback", BDLocationException.ERROR_CODE_LBS_LIGHT_SUBMITV2_FAILED, BDLocationException.ERROR_CODE_LBS_LIGHT_SUBMITV2_FAILED);
        O_ASSISTANT_FEEDBACK = r107;
        FlowResourceScene r108 = new FlowResourceScene("CreationUserVideo", 9, "creation_user_video", "81", "26");
        CreationUserVideo = r108;
        FlowResourceScene r109 = new FlowResourceScene("CreationUserVideoV2", 10, "creation_user_video_v2", "133", BDLocationException.ERROR_BYTE_NO_FINE_LOCATION_PERMISSION);
        CreationUserVideoV2 = r109;
        FlowResourceScene r111 = new FlowResourceScene("SpringMainVenue", 11, "spring_main_venue", "83", "83");
        SpringMainVenue = r111;
        FlowResourceScene[] r112 = {r100, r101, r102, r103, r104, r105, r106, r110, r107, r108, r109, r111};
        f313537a = r112;
        f313538b = EnumEntriesKt.enumEntries(r112);
        Companion = new a();
    }

    public static FlowResourceScene[] values() {
        return (FlowResourceScene[]) f313537a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        r100.append(super.toString());
        r100.append('(');
        Companion.getClass();
        r100.append(a.b(this));
        r100.append(')');
        return r100.toString();
    }

    public final String getSceneIDForCici() {
        return this.sceneIDForCici;
    }

    public final String getSceneIDForDoubao() {
        return this.sceneIDForDoubao;
    }

    public final String getTitle() {
        return this.title;
    }

    public static FlowResourceScene valueOf(String r100) {
        return (FlowResourceScene) r27.a.a(FlowResourceScene.class, r100);
    }

    public FlowResourceScene(String r100, int r101, String r102, String r103, String r104) {
        super(r100, r101);
        this.title = r102;
        this.sceneIDForDoubao = r103;
        this.sceneIDForCici = r104;
    }
}
