package com.obric.sva.sdk.sami;

import com.mammon.audiosdk.enums.SAMICoreTokenType;
import com.mammon.audiosdk.structures.SpeechFingerprintEnrollParameter;
import com.obric.sva.sdk.controller.SvaSdkGlobal;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u000b\n\u0002\b@\b\u0086\b\u0018\u00002\u00020\u0001Bù\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0017\u001a\u00020\n\u0012\b\b\u0002\u0010\u0018\u001a\u00020\n\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001e¢\u0006\u0004\b\u001f\u0010 J\u0016\u0010>\u001a\u00020\u00032\u0006\u0010?\u001a\u00020\u00032\u0006\u0010@\u001a\u00020\u001eJ\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\t\u0010G\u001a\u00020\nHÆ\u0003J\t\u0010H\u001a\u00020\u0003HÆ\u0003J\t\u0010I\u001a\u00020\u0003HÆ\u0003J\t\u0010J\u001a\u00020\u0003HÆ\u0003J\t\u0010K\u001a\u00020\u0003HÆ\u0003J\t\u0010L\u001a\u00020\u0003HÆ\u0003J\t\u0010M\u001a\u00020\u0003HÆ\u0003J\t\u0010N\u001a\u00020\u0003HÆ\u0003J\t\u0010O\u001a\u00020\u0003HÆ\u0003J\t\u0010P\u001a\u00020\u0003HÆ\u0003J\t\u0010Q\u001a\u00020\u0003HÆ\u0003J\t\u0010R\u001a\u00020\u0003HÆ\u0003J\t\u0010S\u001a\u00020\u0003HÆ\u0003J\t\u0010T\u001a\u00020\nHÆ\u0003J\t\u0010U\u001a\u00020\nHÆ\u0003J\t\u0010V\u001a\u00020\u001aHÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u001cHÆ\u0003J\t\u0010X\u001a\u00020\u001eHÆ\u0003Jû\u0001\u0010Y\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\n2\b\b\u0002\u0010\u0018\u001a\u00020\n2\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001eHÆ\u0001J\u0013\u0010Z\u001a\u00020\u001e2\b\u0010[\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\\\u001a\u00020\nHÖ\u0001J\t\u0010]\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\"R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\"R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\"R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\"R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\"R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\"R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\"R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\"R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\"R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\"R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\"R\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\"R\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\"R\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\"R\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\"R\u0011\u0010\u0016\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\"R\u0011\u0010\u0017\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b6\u0010)R\u0011\u0010\u0018\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b7\u0010)R\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0011\u0010\u001d\u001a\u00020\u001e¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=¨\u0006^"}, d2 = {"Lcom/obric/sva/sdk/sami/WakeupParamSnapshot;", "", "sn", "", com.bytedance.android.ec.core.event.a.KEY_DID, "uid", "doubaoUid", "doubaoDid", "dbPath", "appStatus", "", "appVersion", "groupId", "engineVersion", "dumpDir", "appId", "modelMd5", "modelPath", "kwsEncKeyInfo", "sidModelMd5", "sidModelPath", "sidEncKeyInfo", "sidFilePath", "sidLevel", "sidBarginStatus", "sidVolume", "", "sidThresholds", "", "bypassAdaptiveSid", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIF[FZ)V", "getSn", "()Ljava/lang/String;", "getDid", "getUid", "getDoubaoUid", "getDoubaoDid", "getDbPath", "getAppStatus", "()I", "getAppVersion", "getGroupId", "getEngineVersion", "getDumpDir", "getAppId", "getModelMd5", "getModelPath", "getKwsEncKeyInfo", "getSidModelMd5", "getSidModelPath", "getSidEncKeyInfo", "getSidFilePath", "getSidLevel", "getSidBarginStatus", "getSidVolume", "()F", "getSidThresholds", "()[F", "getBypassAdaptiveSid", "()Z", "toJson", "businessType", "includeModelInfo", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "copy", "equals", "other", "hashCode", "toString", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WakeupParamSnapshot {
    private final String appId;
    private final int appStatus;
    private final String appVersion;
    private final boolean bypassAdaptiveSid;
    private final String dbPath;
    private final String did;
    private final String doubaoDid;
    private final String doubaoUid;
    private final String dumpDir;
    private final String engineVersion;
    private final String groupId;
    private final String kwsEncKeyInfo;
    private final String modelMd5;
    private final String modelPath;
    private final int sidBarginStatus;
    private final String sidEncKeyInfo;
    private final String sidFilePath;
    private final int sidLevel;
    private final String sidModelMd5;
    private final String sidModelPath;
    private final float[] sidThresholds;
    private final float sidVolume;

    /* JADX INFO: renamed from: sn, reason: collision with root package name */
    private final String f403941sn;
    private final String uid;

    public WakeupParamSnapshot() {
        this(null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, 0, 0, 0.0f, null, false, 16777215, null);
    }

    public static /* synthetic */ WakeupParamSnapshot copy$default(WakeupParamSnapshot r110, String r111, String r112, String r210, String r211, String r212, String r213, int r214, String r215, String r216, String r217, String r218, String r219, String r310, String r311, String r312, String r313, String r314, String r315, String r316, int r317, int r318, float r319, float[] r410, boolean r411, int r412, Object r413) {
        if ((r412 & 1) == 0) goto L5;
        String r100 = r110.f403941sn;
    L7:
        if ((r412 & 2) == 0) goto L9;
        String r101 = r110.did;
    L11:
        if ((r412 & 4) == 0) goto L13;
        String r102 = r110.uid;
    L15:
        if ((r412 & 8) == 0) goto L17;
        String r103 = r110.doubaoUid;
    L19:
        if ((r412 & 16) == 0) goto L21;
        String r104 = r110.doubaoDid;
    L23:
        if ((r412 & 32) == 0) goto L25;
        String r105 = r110.dbPath;
    L27:
        if ((r412 & 64) == 0) goto L29;
        int r106 = r110.appStatus;
    L31:
        if ((r412 & 128) == 0) goto L33;
        String r107 = r110.appVersion;
    L35:
        if ((r412 & 256) == 0) goto L37;
        String r113 = r110.groupId;
    L39:
        if ((r412 & 512) == 0) goto L41;
        String r114 = r110.engineVersion;
    L43:
        if ((r412 & 1024) == 0) goto L45;
        String r115 = r110.dumpDir;
    L47:
        if ((r412 & 2048) == 0) goto L49;
        String r116 = r110.appId;
    L51:
        if ((r412 & 4096) == 0) goto L53;
        String r117 = r110.modelMd5;
    L55:
        if ((r412 & 8192) == 0) goto L57;
        String r118 = r110.modelPath;
    L58:
        String r320 = r118;
        if ((r412 & 16384) == 0) goto L61;
        String r119 = r110.kwsEncKeyInfo;
    L62:
        String r321 = r119;
        if ((r412 & 32768) == 0) goto L65;
        String r120 = r110.sidModelMd5;
    L66:
        String r322 = r120;
        if ((r412 & 65536) == 0) goto L69;
        String r121 = r110.sidModelPath;
    L70:
        String r323 = r121;
        if ((r412 & 131072) == 0) goto L73;
        String r122 = r110.sidEncKeyInfo;
    L74:
        String r324 = r122;
        if ((r412 & 262144) == 0) goto L77;
        String r123 = r110.sidFilePath;
    L78:
        String r325 = r123;
        if ((r412 & 524288) == 0) goto L81;
        int r124 = r110.sidLevel;
    L82:
        int r326 = r124;
        if ((r412 & 1048576) == 0) goto L85;
        int r125 = r110.sidBarginStatus;
    L86:
        int r327 = r125;
        if ((r412 & 2097152) == 0) goto L89;
        float r126 = r110.sidVolume;
    L90:
        float r328 = r126;
        if ((r412 & 4194304) == 0) goto L93;
        float[] r127 = r110.sidThresholds;
    L95:
        if ((r412 & 8388608) == 0) goto L97;
        boolean r108 = r110.bypassAdaptiveSid;
    L99:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r320, r321, r322, r323, r324, r325, r326, r327, r328, r127, r108);
    L97:
        r108 = r411;
        goto L99
    L93:
        r127 = r410;
        goto L95
    L89:
        r126 = r319;
        goto L90
    L85:
        r125 = r318;
        goto L86
    L81:
        r124 = r317;
        goto L82
    L77:
        r123 = r316;
        goto L78
    L73:
        r122 = r315;
        goto L74
    L69:
        r121 = r314;
        goto L70
    L65:
        r120 = r313;
        goto L66
    L61:
        r119 = r312;
        goto L62
    L57:
        r118 = r311;
        goto L58
    L53:
        r117 = r310;
        goto L55
    L49:
        r116 = r219;
        goto L51
    L45:
        r115 = r218;
        goto L47
    L41:
        r114 = r217;
        goto L43
    L37:
        r113 = r216;
        goto L39
    L33:
        r107 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.f403941sn;
    }

    public final String component10() {
        return this.engineVersion;
    }

    public final String component11() {
        return this.dumpDir;
    }

    public final String component12() {
        return this.appId;
    }

    public final String component13() {
        return this.modelMd5;
    }

    public final String component14() {
        return this.modelPath;
    }

    public final String component15() {
        return this.kwsEncKeyInfo;
    }

    public final String component16() {
        return this.sidModelMd5;
    }

    public final String component17() {
        return this.sidModelPath;
    }

    public final String component18() {
        return this.sidEncKeyInfo;
    }

    public final String component19() {
        return this.sidFilePath;
    }

    public final String component2() {
        return this.did;
    }

    public final int component20() {
        return this.sidLevel;
    }

    public final int component21() {
        return this.sidBarginStatus;
    }

    public final float component22() {
        return this.sidVolume;
    }

    public final float[] component23() {
        return this.sidThresholds;
    }

    public final boolean component24() {
        return this.bypassAdaptiveSid;
    }

    public final String component3() {
        return this.uid;
    }

    public final String component4() {
        return this.doubaoUid;
    }

    public final String component5() {
        return this.doubaoDid;
    }

    public final String component6() {
        return this.dbPath;
    }

    public final int component7() {
        return this.appStatus;
    }

    public final String component8() {
        return this.appVersion;
    }

    public final String component9() {
        return this.groupId;
    }

    public final WakeupParamSnapshot copy(String r210, String r211, String r310, String r311, String r312, String r313, int r314, String r315, String r316, String r317, String r318, String r319, String r410, String r411, String r412, String r413, String r414, String r415, String r416, int r417, int r418, float r419, float[] r510, boolean r511) {
        Intrinsics.checkNotNullParameter(r210, "sn");
        Intrinsics.checkNotNullParameter(r211, com.bytedance.android.ec.core.event.a.KEY_DID);
        Intrinsics.checkNotNullParameter(r310, "uid");
        Intrinsics.checkNotNullParameter(r311, "doubaoUid");
        Intrinsics.checkNotNullParameter(r312, "doubaoDid");
        Intrinsics.checkNotNullParameter(r313, "dbPath");
        Intrinsics.checkNotNullParameter(r315, "appVersion");
        Intrinsics.checkNotNullParameter(r316, "groupId");
        Intrinsics.checkNotNullParameter(r317, "engineVersion");
        Intrinsics.checkNotNullParameter(r318, "dumpDir");
        Intrinsics.checkNotNullParameter(r319, "appId");
        Intrinsics.checkNotNullParameter(r410, "modelMd5");
        Intrinsics.checkNotNullParameter(r411, "modelPath");
        Intrinsics.checkNotNullParameter(r412, "kwsEncKeyInfo");
        Intrinsics.checkNotNullParameter(r413, "sidModelMd5");
        Intrinsics.checkNotNullParameter(r414, "sidModelPath");
        Intrinsics.checkNotNullParameter(r415, "sidEncKeyInfo");
        Intrinsics.checkNotNullParameter(r416, "sidFilePath");
        return new WakeupParamSnapshot(r210, r211, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r510, r511);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof WakeupParamSnapshot) == true) goto L8;
        return false;
    L8:
        WakeupParamSnapshot r101 = (WakeupParamSnapshot) r100;
        if (Intrinsics.areEqual(this.f403941sn, r101.f403941sn) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.did, r101.did) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.uid, r101.uid) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.doubaoUid, r101.doubaoUid) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.doubaoDid, r101.doubaoDid) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.dbPath, r101.dbPath) == true) goto L27;
        return false;
    L27:
        if (this.appStatus == r101.appStatus) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.appVersion, r101.appVersion) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.groupId, r101.groupId) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.engineVersion, r101.engineVersion) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.dumpDir, r101.dumpDir) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.appId, r101.appId) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.modelMd5, r101.modelMd5) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.modelPath, r101.modelPath) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.kwsEncKeyInfo, r101.kwsEncKeyInfo) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.sidModelMd5, r101.sidModelMd5) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.sidModelPath, r101.sidModelPath) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.sidEncKeyInfo, r101.sidEncKeyInfo) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.sidFilePath, r101.sidFilePath) == true) goto L66;
        return false;
    L66:
        if (this.sidLevel == r101.sidLevel) goto L69;
        return false;
    L69:
        if (this.sidBarginStatus == r101.sidBarginStatus) goto L72;
        return false;
    L72:
        if (Float.compare(this.sidVolume, r101.sidVolume) == 0) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.sidThresholds, r101.sidThresholds) == true) goto L78;
        return false;
    L78:
        if (this.bypassAdaptiveSid == r101.bypassAdaptiveSid) goto L80;
        return false;
    L80:
        return true;
    }

    public int hashCode() {
        int r100 = ((((((((((((((((((((((((((((((((((((((((((this.f403941sn.hashCode() * 31) + this.did.hashCode()) * 31) + this.uid.hashCode()) * 31) + this.doubaoUid.hashCode()) * 31) + this.doubaoDid.hashCode()) * 31) + this.dbPath.hashCode()) * 31) + this.appStatus) * 31) + this.appVersion.hashCode()) * 31) + this.groupId.hashCode()) * 31) + this.engineVersion.hashCode()) * 31) + this.dumpDir.hashCode()) * 31) + this.appId.hashCode()) * 31) + this.modelMd5.hashCode()) * 31) + this.modelPath.hashCode()) * 31) + this.kwsEncKeyInfo.hashCode()) * 31) + this.sidModelMd5.hashCode()) * 31) + this.sidModelPath.hashCode()) * 31) + this.sidEncKeyInfo.hashCode()) * 31) + this.sidFilePath.hashCode()) * 31) + this.sidLevel) * 31) + this.sidBarginStatus) * 31) + Float.floatToIntBits(this.sidVolume)) * 31;
        float[] r101 = this.sidThresholds;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.bypassAdaptiveSid == false) goto L9;
        int r104 = 1231;
    L11:
        return r103 + r104;
    L9:
        r104 = 1237;
        goto L11
    L5:
        r102 = Arrays.hashCode(r101);
        goto L6
    }

    public String toString() {
        return "WakeupParamSnapshot(sn=" + this.f403941sn + ", did=" + this.did + ", uid=" + this.uid + ", doubaoUid=" + this.doubaoUid + ", doubaoDid=" + this.doubaoDid + ", dbPath=" + this.dbPath + ", appStatus=" + this.appStatus + ", appVersion=" + this.appVersion + ", groupId=" + this.groupId + ", engineVersion=" + this.engineVersion + ", dumpDir=" + this.dumpDir + ", appId=" + this.appId + ", modelMd5=" + this.modelMd5 + ", modelPath=" + this.modelPath + ", kwsEncKeyInfo=" + this.kwsEncKeyInfo + ", sidModelMd5=" + this.sidModelMd5 + ", sidModelPath=" + this.sidModelPath + ", sidEncKeyInfo=" + this.sidEncKeyInfo + ", sidFilePath=" + this.sidFilePath + ", sidLevel=" + this.sidLevel + ", sidBarginStatus=" + this.sidBarginStatus + ", sidVolume=" + this.sidVolume + ", sidThresholds=" + Arrays.toString(this.sidThresholds) + ", bypassAdaptiveSid=" + this.bypassAdaptiveSid + ')';
    }

    public final String getAppId() {
        return this.appId;
    }

    public final int getAppStatus() {
        return this.appStatus;
    }

    public final String getAppVersion() {
        return this.appVersion;
    }

    public final boolean getBypassAdaptiveSid() {
        return this.bypassAdaptiveSid;
    }

    public final String getDbPath() {
        return this.dbPath;
    }

    public final String getDid() {
        return this.did;
    }

    public final String getDoubaoDid() {
        return this.doubaoDid;
    }

    public final String getDoubaoUid() {
        return this.doubaoUid;
    }

    public final String getDumpDir() {
        return this.dumpDir;
    }

    public final String getEngineVersion() {
        return this.engineVersion;
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public final String getKwsEncKeyInfo() {
        return this.kwsEncKeyInfo;
    }

    public final String getModelMd5() {
        return this.modelMd5;
    }

    public final String getModelPath() {
        return this.modelPath;
    }

    public final int getSidBarginStatus() {
        return this.sidBarginStatus;
    }

    public final String getSidEncKeyInfo() {
        return this.sidEncKeyInfo;
    }

    public final String getSidFilePath() {
        return this.sidFilePath;
    }

    public final int getSidLevel() {
        return this.sidLevel;
    }

    public final String getSidModelMd5() {
        return this.sidModelMd5;
    }

    public final String getSidModelPath() {
        return this.sidModelPath;
    }

    public final float[] getSidThresholds() {
        return this.sidThresholds;
    }

    public final float getSidVolume() {
        return this.sidVolume;
    }

    public final String getSn() {
        return this.f403941sn;
    }

    public final String getUid() {
        return this.uid;
    }

    public final String toJson(String r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r110, "businessType");
        boolean r100 = true;
        if (r111 == false) goto L16;
        JSONObject r101 = new JSONObject();
        r101.put("model_md5", this.modelMd5);
        r101.put("model_path", this.modelPath);
        r101.put("engine_backend", SpeechFingerprintEnrollParameter.SID_ENROLL_ENGINE_BACKEND_FLUTE);
        r101.put("kws_enc_key_info", this.kwsEncKeyInfo);
        r101.put("sid_model_md5", this.sidModelMd5);
        r101.put("sid_model_path", this.sidModelPath);
        r101.put("sid_enc_key_info", this.sidEncKeyInfo);
        if (this.sidFilePath.length() <= 0) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == false) goto L10;
        r101.put("sid_file_path", this.sidFilePath);
    L10:
        r101.put("sid_level", this.sidLevel);
        r101.put("sid_bargin_status", this.sidBarginStatus);
        r101.put("sid_volume", Float.valueOf(this.sidVolume));
        JSONObject r103 = new JSONObject();
        r103.put("usage", "");
        Unit r104 = Unit.INSTANCE;
        r101.put("extra", r103.toString());
        float[] r105 = this.sidThresholds;
        if (r105 == null) goto L17;
        JSONArray r106 = new JSONArray();
        int r107 = r105.length;
        int r108 = 0;
    L13:
        if (r108 >= r107) goto L15;
        r106.put(r105[r108]);
        r108 = r108 + 1;
        goto L13
    L15:
        Unit r109 = Unit.INSTANCE;
        r101.put("sid_threshold", r106);
    L17:
        JSONObject r112 = new JSONObject();
        r112.put("proto-version", "v2");
        r112.put("Passport-Auth", AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        r112.put("sdk-version", "2");
        r112.put("X-tt-Token", "123");
        String r113 = r112.toString();
        JSONObject r114 = new JSONObject();
        r114.put("app_key", SvaSdkGlobal.APP_KEY);
        r114.put("business_type", r110);
        if (r111 == false) goto L20;
        r114.put("doubao_uid", this.doubaoUid);
        r114.put("doubao_did", this.doubaoDid);
    L20:
        r114.put("token", "123");
        r114.put("token_type", SAMICoreTokenType.TOKEN_TO_C_D.getValue());
        r114.put("header", r113);
        r114.put("url", "https://audio.doubao.com/internal");
        JSONObject r115 = new JSONObject();
        r115.put("sn", this.f403941sn);
        r115.put(com.bytedance.android.ec.core.event.a.KEY_DID, this.did);
        if (this.uid.length() <= 0) goto L23;
        boolean r116 = true;
    L24:
        if (r116 == false) goto L27;
        r115.put("uid", this.uid);
    L27:
        if (this.dbPath.length() <= 0) goto L29;
        boolean r117 = true;
    L30:
        if (r117 == false) goto L33;
        r115.put("db_path", this.dbPath);
    L33:
        if (this.appId.length() <= 0) goto L35;
        boolean r118 = true;
    L36:
        if (r118 == false) goto L38;
        r115.put("app_id", this.appId);
    L38:
        r115.put("app_status", this.appStatus);
        if (this.appVersion.length() <= 0) goto L41;
        boolean r119 = true;
    L42:
        if (r119 == false) goto L44;
        r115.put("app_version", this.appVersion);
    L44:
        if (r111 == true) goto L46;
    L51:
        r115.put("bypass_adaptive_sid", this.bypassAdaptiveSid);
        r115.put("engine_version", this.engineVersion);
        r115.put("model_info", r101);
        r115.put("server_param", r114);
        r115.put("dump_dir", this.dumpDir);
        return r115.toString();
    L46:
        if (this.groupId.length() > 0) goto L49;
        r100 = false;
    L49:
        if (r100 == false) goto L51;
        r115.put("group_id", this.groupId);
        goto L51
    L41:
        r119 = false;
        goto L42
    L35:
        r118 = false;
        goto L36
    L29:
        r117 = false;
        goto L30
    L23:
        r116 = false;
        goto L24
    L7:
        r102 = false;
        goto L8
    L16:
        r101 = new JSONObject();
        goto L17
    }

    public WakeupParamSnapshot(String r110, String r111, String r112, String r210, String r211, String r212, int r213, String r214, String r215, String r216, String r217, String r218, String r219, String r310, String r311, String r312, String r313, String r314, String r315, int r316, int r317, float r318, float[] r319, boolean r410) {
        Intrinsics.checkNotNullParameter(r110, "sn");
        Intrinsics.checkNotNullParameter(r111, com.bytedance.android.ec.core.event.a.KEY_DID);
        Intrinsics.checkNotNullParameter(r112, "uid");
        Intrinsics.checkNotNullParameter(r210, "doubaoUid");
        Intrinsics.checkNotNullParameter(r211, "doubaoDid");
        Intrinsics.checkNotNullParameter(r212, "dbPath");
        Intrinsics.checkNotNullParameter(r214, "appVersion");
        Intrinsics.checkNotNullParameter(r215, "groupId");
        Intrinsics.checkNotNullParameter(r216, "engineVersion");
        Intrinsics.checkNotNullParameter(r217, "dumpDir");
        Intrinsics.checkNotNullParameter(r218, "appId");
        Intrinsics.checkNotNullParameter(r219, "modelMd5");
        Intrinsics.checkNotNullParameter(r310, "modelPath");
        Intrinsics.checkNotNullParameter(r311, "kwsEncKeyInfo");
        Intrinsics.checkNotNullParameter(r312, "sidModelMd5");
        Intrinsics.checkNotNullParameter(r313, "sidModelPath");
        Intrinsics.checkNotNullParameter(r314, "sidEncKeyInfo");
        Intrinsics.checkNotNullParameter(r315, "sidFilePath");
        this.f403941sn = r110;
        this.did = r111;
        this.uid = r112;
        this.doubaoUid = r210;
        this.doubaoDid = r211;
        this.dbPath = r212;
        this.appStatus = r213;
        this.appVersion = r214;
        this.groupId = r215;
        this.engineVersion = r216;
        this.dumpDir = r217;
        this.appId = r218;
        this.modelMd5 = r219;
        this.modelPath = r310;
        this.kwsEncKeyInfo = r311;
        this.sidModelMd5 = r312;
        this.sidModelPath = r313;
        this.sidEncKeyInfo = r314;
        this.sidFilePath = r315;
        this.sidLevel = r316;
        this.sidBarginStatus = r317;
        this.sidVolume = r318;
        this.sidThresholds = r319;
        this.bypassAdaptiveSid = r410;
    }

    public /* synthetic */ WakeupParamSnapshot(String r210, String r211, String r212, String r213, String r310, String r311, int r312, String r313, String r314, String r315, String r316, String r317, String r318, String r319, String r410, String r411, String r412, String r413, String r414, int r415, int r416, float r417, float[] r418, boolean r419, int r510, DefaultConstructorMarker r511) {
        if ((r510 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r510 & 2) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r510 & 4) == 0) goto L13;
        String r102 = "";
    L15:
        if ((r510 & 8) == 0) goto L17;
        String r103 = "";
    L19:
        if ((r510 & 16) == 0) goto L21;
        String r104 = "";
    L23:
        if ((r510 & 32) == 0) goto L25;
        String r105 = "";
    L27:
        if ((r510 & 64) == 0) goto L29;
        int r106 = 0;
    L31:
        if ((r510 & 128) == 0) goto L33;
        String r110 = "";
    L35:
        if ((r510 & 256) == 0) goto L37;
        String r111 = "";
    L39:
        if ((r510 & 512) == 0) goto L41;
        String r112 = "";
    L43:
        if ((r510 & 1024) == 0) goto L45;
        String r113 = "";
    L47:
        if ((r510 & 2048) == 0) goto L49;
        String r114 = "";
    L51:
        if ((r510 & 4096) == 0) goto L53;
        String r115 = "";
    L55:
        if ((r510 & 8192) == 0) goto L57;
        String r107 = "";
    L59:
        if ((r510 & 16384) == 0) goto L61;
        String r108 = "";
    L63:
        if ((r510 & 32768) == 0) goto L65;
        String r116 = "";
    L67:
        if ((r510 & 65536) == 0) goto L69;
        String r117 = "";
    L71:
        if ((r510 & 131072) == 0) goto L73;
        String r118 = "";
    L75:
        if ((r510 & 262144) == 0) goto L77;
        String r119 = "";
    L79:
        if ((r510 & 524288) == 0) goto L81;
        int r214 = 2;
    L83:
        if ((r510 & 1048576) == 0) goto L85;
        int r215 = 0;
    L87:
        if ((r510 & 2097152) == 0) goto L89;
        float r216 = 0.0f;
    L91:
        if ((r510 & 4194304) == 0) goto L93;
        float[] r217 = null;
    L95:
        if ((r510 & 8388608) == 0) goto L97;
        boolean r109 = true;
    L98:
        this(r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r115, r107, r108, r116, r117, r118, r119, r214, r215, r216, r217, r109);
        return;
    L97:
        r109 = r419;
        goto L98
    L93:
        r217 = r418;
        goto L95
    L89:
        r216 = r417;
        goto L91
    L85:
        r215 = r416;
        goto L87
    L81:
        r214 = r415;
        goto L83
    L77:
        r119 = r414;
        goto L79
    L73:
        r118 = r413;
        goto L75
    L69:
        r117 = r412;
        goto L71
    L65:
        r116 = r411;
        goto L67
    L61:
        r108 = r410;
        goto L63
    L57:
        r107 = r319;
        goto L59
    L53:
        r115 = r318;
        goto L55
    L49:
        r114 = r317;
        goto L51
    L45:
        r113 = r316;
        goto L47
    L41:
        r112 = r315;
        goto L43
    L37:
        r111 = r314;
        goto L39
    L33:
        r110 = r313;
        goto L35
    L29:
        r106 = r312;
        goto L31
    L25:
        r105 = r311;
        goto L27
    L21:
        r104 = r310;
        goto L23
    L17:
        r103 = r213;
        goto L19
    L13:
        r102 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }
}
