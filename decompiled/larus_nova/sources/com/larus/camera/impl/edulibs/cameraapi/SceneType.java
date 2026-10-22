package com.larus.camera.impl.edulibs.cameraapi;

import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\b\u0086\u0081\u0002\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0016B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0017"}, d2 = {"Lcom/larus/camera/impl/edulibs/cameraapi/SceneType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Default", "Doubao_Education_Camera_Qa", "Doubao_General_Camera_Tab_Qa", "Doubao_General_Camera_Intent_Recognition_Education_Qa", "Doubao_Education_Camera_Essay_Correction", "Doubao_Education_Camera_Mental_Calculations", "Doubao_General_Camera_Intent_Recognition_Education_Correction", "Doubao_Education_Camera_Homework_Correction", "Hippo_Photo_Qa", "Hippo_Record_Error", "Hippo_Homework_Correction", "Hippo_Essay_Correction", "Hippo_Chinese_Essay_Writing", "Doubao_Live_Tutor", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SceneType extends Enum<SceneType> {
    public static final a Companion = null;

    @SerializedName("0")
    public static final SceneType Default = null;

    @SerializedName("104")
    public static final SceneType Doubao_Education_Camera_Essay_Correction = null;

    @SerializedName(IInteractGameMonitorService.FAILURE_CODE_OTHER_GAME_MUTEX)
    public static final SceneType Doubao_Education_Camera_Homework_Correction = null;

    @SerializedName("105")
    public static final SceneType Doubao_Education_Camera_Mental_Calculations = null;

    @SerializedName("101")
    public static final SceneType Doubao_Education_Camera_Qa = null;

    @SerializedName("108")
    public static final SceneType Doubao_General_Camera_Intent_Recognition_Education_Correction = null;

    @SerializedName(IInteractGameMonitorService.FAILURE_CODE_LINK_MIC_MUTEX)
    public static final SceneType Doubao_General_Camera_Intent_Recognition_Education_Qa = null;

    @SerializedName(BDLocationException.ERROR_UID_IS_EMPTY)
    public static final SceneType Doubao_General_Camera_Tab_Qa = null;

    @SerializedName("209")
    public static final SceneType Doubao_Live_Tutor = null;

    @SerializedName("205")
    public static final SceneType Hippo_Chinese_Essay_Writing = null;

    @SerializedName("204")
    public static final SceneType Hippo_Essay_Correction = null;

    @SerializedName("203")
    public static final SceneType Hippo_Homework_Correction = null;

    @SerializedName("201")
    public static final SceneType Hippo_Photo_Qa = null;

    @SerializedName("202")
    public static final SceneType Hippo_Record_Error = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SceneType[] f321699a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f321700b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<SceneType> getEntries() {
        return f321700b;
    }

    static {
        SceneType r100 = new SceneType("Default", 0, 0);
        Default = r100;
        SceneType r101 = new SceneType("Doubao_Education_Camera_Qa", 1, 101);
        Doubao_Education_Camera_Qa = r101;
        SceneType r102 = new SceneType("Doubao_General_Camera_Tab_Qa", 2, 102);
        Doubao_General_Camera_Tab_Qa = r102;
        SceneType r103 = new SceneType("Doubao_General_Camera_Intent_Recognition_Education_Qa", 3, 103);
        Doubao_General_Camera_Intent_Recognition_Education_Qa = r103;
        SceneType r104 = new SceneType("Doubao_Education_Camera_Essay_Correction", 4, 104);
        Doubao_Education_Camera_Essay_Correction = r104;
        SceneType r105 = new SceneType("Doubao_Education_Camera_Mental_Calculations", 5, 105);
        Doubao_Education_Camera_Mental_Calculations = r105;
        SceneType r110 = new SceneType("Doubao_General_Camera_Intent_Recognition_Education_Correction", 6, 108);
        Doubao_General_Camera_Intent_Recognition_Education_Correction = r110;
        SceneType r111 = new SceneType("Doubao_Education_Camera_Homework_Correction", 7, 109);
        Doubao_Education_Camera_Homework_Correction = r111;
        SceneType r112 = new SceneType("Hippo_Photo_Qa", 8, 201);
        Hippo_Photo_Qa = r112;
        SceneType r113 = new SceneType("Hippo_Record_Error", 9, 202);
        Hippo_Record_Error = r113;
        SceneType r106 = new SceneType("Hippo_Homework_Correction", 10, 203);
        Hippo_Homework_Correction = r106;
        SceneType r107 = new SceneType("Hippo_Essay_Correction", 11, 204);
        Hippo_Essay_Correction = r107;
        SceneType r108 = new SceneType("Hippo_Chinese_Essay_Writing", 12, 205);
        Hippo_Chinese_Essay_Writing = r108;
        SceneType r109 = new SceneType("Doubao_Live_Tutor", 13, 209);
        Doubao_Live_Tutor = r109;
        SceneType[] r114 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r106, r107, r108, r109};
        f321699a = r114;
        f321700b = EnumEntriesKt.enumEntries(r114);
        Companion = new a();
    }

    public static SceneType[] values() {
        return (SceneType[]) f321699a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    @JvmStatic
    public static final SceneType findByValue(int r100) {
        Companion.getClass();
        if (r100 == 0) goto L24;
        if (r100 == 108) goto L37;
        if (r100 == 109) goto L36;
        switch(r100) {
            case 101: goto L30;
            case 102: goto L29;
            case 103: goto L28;
            case 104: goto L27;
            case 105: goto L26;
            default: goto L9;
        };
    L9:
        switch(r100) {
            case 201: goto L35;
            case 202: goto L34;
            case 203: goto L33;
            case 204: goto L32;
            case 205: goto L31;
            default: goto L10;
        };
    L10:
        return null;
    L31:
        return Hippo_Chinese_Essay_Writing;
    L32:
        return Hippo_Essay_Correction;
    L33:
        return Hippo_Homework_Correction;
    L34:
        return Hippo_Record_Error;
    L35:
        return Hippo_Photo_Qa;
    L26:
        return Doubao_Education_Camera_Mental_Calculations;
    L27:
        return Doubao_Education_Camera_Essay_Correction;
    L28:
        return Doubao_General_Camera_Intent_Recognition_Education_Qa;
    L29:
        return Doubao_General_Camera_Tab_Qa;
    L30:
        return Doubao_Education_Camera_Qa;
    L36:
        return Doubao_Education_Camera_Homework_Correction;
    L37:
        return Doubao_General_Camera_Intent_Recognition_Education_Correction;
    L24:
        return Default;
    }

    public static SceneType valueOf(String r100) {
        return (SceneType) r27.a.a(SceneType.class, r100);
    }

    public SceneType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
