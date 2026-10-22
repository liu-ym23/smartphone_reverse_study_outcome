package com.larus.im.internal.jni.bean;

import com.byted.cast.common.auth.AuthConstants;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import de9.e1;
import juc.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import luc.f;
import nuc.b2;
import nuc.q2;
import nuc.v2;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 D2\u00060\u0001j\u0002`\u0002:\u0002CDB\u0095\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u0012\b\b\u0002\u0010\r\u001a\u00020\t\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014B\u0091\u0001\b\u0010\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u0013\u0010\u0019J\u000b\u0010(\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010,\u001a\u00020\tHÆ\u0003J\t\u0010-\u001a\u00020\tHÆ\u0003J\t\u0010.\u001a\u00020\tHÆ\u0003J\t\u0010/\u001a\u00020\tHÆ\u0003J\t\u00100\u001a\u00020\tHÆ\u0003J\t\u00101\u001a\u00020\tHÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u00104\u001a\u00020\u0012HÆ\u0003J\u0097\u0001\u00105\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\t2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u0012HÆ\u0001J\u0013\u00106\u001a\u00020\t2\b\u00107\u001a\u0004\u0018\u000108HÖ\u0003J\t\u00109\u001a\u00020\u0016HÖ\u0001J\t\u0010:\u001a\u00020\u0004HÖ\u0001J%\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u00002\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020AH\u0001¢\u0006\u0002\bBR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001a\u0010\u001bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001c\u0010\u001bR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001d\u0010\u001bR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001e\u0010\u001bR\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001f\u0010\u001bR\u0016\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b \u0010\u001bR\u0016\u0010\u000b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b!\u0010\u001bR\u0016\u0010\f\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\"\u0010\u001bR\u0016\u0010\r\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b#\u0010\u001bR\u0016\u0010\u000e\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b$\u0010\u001bR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b%\u0010\u001bR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b&\u0010\u001bR\u0016\u0010\u0011\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b'\u0010\u001b¨\u0006E"}, d2 = {"Lcom/larus/im/internal/jni/bean/OMNIAVRTCEngineInitConfig;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "appId", "", "businessId", "userId", "token", "skipBtConnPermission", "", "useRtcTestDomain", "supportFakeConnect", "enableRtcSpeechAec", "rtcDumpEnable", "isOversea", "engineParameters", "engineBusinessId", "sessionProfile", "Lcom/larus/im/internal/jni/bean/OMNIAVSessionProfile;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZZZZLjava/lang/String;Ljava/lang/String;Lcom/larus/im/internal/jni/bean/OMNIAVSessionProfile;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZZZZLjava/lang/String;Ljava/lang/String;Lcom/larus/im/internal/jni/bean/OMNIAVSessionProfile;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getAppId$annotations", "()V", "getBusinessId$annotations", "getUserId$annotations", "getToken$annotations", "getSkipBtConnPermission$annotations", "getUseRtcTestDomain$annotations", "getSupportFakeConnect$annotations", "getEnableRtcSpeechAec$annotations", "getRtcDumpEnable$annotations", "isOversea$annotations", "getEngineParameters$annotations", "getEngineBusinessId$annotations", "getSessionProfile$annotations", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_av_release", "$serializer", "Companion", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OMNIAVRTCEngineInitConfig implements java.io.Serializable {
    private static final Lazy<d<Object>>[] $childSerializers = null;
    public static final Companion Companion = null;
    public final String appId;
    public final String businessId;
    public final boolean enableRtcSpeechAec;
    public final String engineBusinessId;
    public final String engineParameters;
    public final boolean isOversea;
    public final boolean rtcDumpEnable;
    public final OMNIAVSessionProfile sessionProfile;
    public final boolean skipBtConnPermission;
    public final boolean supportFakeConnect;
    public final String token;
    public final boolean useRtcTestDomain;
    public final String userId;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OMNIAVRTCEngineInitConfig$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OMNIAVRTCEngineInitConfig;", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OMNIAVRTCEngineInitConfig> serializer() {
            return OMNIAVRTCEngineInitConfig$$serializer.INSTANCE;
        }
    }

    public OMNIAVRTCEngineInitConfig() {
        this(null, null, null, null, false, false, false, false, false, false, null, null, null, 8191, null);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_() {
        return OMNIAVSessionProfile.Companion.serializer();
    }

    public static /* synthetic */ d a() {
        return _childSerializers$_anonymous_();
    }

    public static /* synthetic */ OMNIAVRTCEngineInitConfig copy$default(OMNIAVRTCEngineInitConfig r110, String r111, String r112, String r113, String r114, boolean r115, boolean r210, boolean r211, boolean r212, boolean r213, boolean r214, String r215, String r216, OMNIAVSessionProfile r217, int r218, Object r219) {
        if ((r218 & 1) == 0) goto L5;
        String r100 = r110.appId;
    L7:
        if ((r218 & 2) == 0) goto L9;
        String r101 = r110.businessId;
    L11:
        if ((r218 & 4) == 0) goto L13;
        String r102 = r110.userId;
    L15:
        if ((r218 & 8) == 0) goto L17;
        String r103 = r110.token;
    L19:
        if ((r218 & 16) == 0) goto L21;
        boolean r104 = r110.skipBtConnPermission;
    L23:
        if ((r218 & 32) == 0) goto L25;
        boolean r105 = r110.useRtcTestDomain;
    L27:
        if ((r218 & 64) == 0) goto L29;
        boolean r106 = r110.supportFakeConnect;
    L31:
        if ((r218 & 128) == 0) goto L33;
        boolean r107 = r110.enableRtcSpeechAec;
    L35:
        if ((r218 & 256) == 0) goto L37;
        boolean r116 = r110.rtcDumpEnable;
    L39:
        if ((r218 & 512) == 0) goto L41;
        boolean r117 = r110.isOversea;
    L43:
        if ((r218 & 1024) == 0) goto L45;
        String r118 = r110.engineParameters;
    L47:
        if ((r218 & 2048) == 0) goto L49;
        String r119 = r110.engineBusinessId;
    L51:
        if ((r218 & 4096) == 0) goto L53;
        OMNIAVSessionProfile r108 = r110.sessionProfile;
    L55:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r116, r117, r118, r119, r108);
    L53:
        r108 = r217;
        goto L55
    L49:
        r119 = r216;
        goto L51
    L45:
        r118 = r215;
        goto L47
    L41:
        r117 = r214;
        goto L43
    L37:
        r116 = r213;
        goto L39
    L33:
        r107 = r212;
        goto L35
    L29:
        r106 = r211;
        goto L31
    L25:
        r105 = r210;
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

    @SerialName("app_id")
    public static /* synthetic */ void getAppId$annotations() {
    }

    @SerialName(AuthConstants.PARAM_KEY_LICENSE_BUSINESS_ID)
    public static /* synthetic */ void getBusinessId$annotations() {
    }

    @SerialName("enable_rtc_speech_aec")
    public static /* synthetic */ void getEnableRtcSpeechAec$annotations() {
    }

    @SerialName("engine_business_id")
    public static /* synthetic */ void getEngineBusinessId$annotations() {
    }

    @SerialName("engine_parameters")
    public static /* synthetic */ void getEngineParameters$annotations() {
    }

    @SerialName("rtc_dump_enable")
    public static /* synthetic */ void getRtcDumpEnable$annotations() {
    }

    @SerialName("session_profile")
    public static /* synthetic */ void getSessionProfile$annotations() {
    }

    @SerialName("skip_bt_conn_permission")
    public static /* synthetic */ void getSkipBtConnPermission$annotations() {
    }

    @SerialName("support_fake_connect")
    public static /* synthetic */ void getSupportFakeConnect$annotations() {
    }

    @SerialName("token")
    public static /* synthetic */ void getToken$annotations() {
    }

    @SerialName("use_rtc_test_domain")
    public static /* synthetic */ void getUseRtcTestDomain$annotations() {
    }

    @SerialName("user_id")
    public static /* synthetic */ void getUserId$annotations() {
    }

    @SerialName("is_oversea")
    public static /* synthetic */ void isOversea$annotations() {
    }

    public final String component1() {
        return this.appId;
    }

    public final boolean component10() {
        return this.isOversea;
    }

    public final String component11() {
        return this.engineParameters;
    }

    public final String component12() {
        return this.engineBusinessId;
    }

    public final OMNIAVSessionProfile component13() {
        return this.sessionProfile;
    }

    public final String component2() {
        return this.businessId;
    }

    public final String component3() {
        return this.userId;
    }

    public final String component4() {
        return this.token;
    }

    public final boolean component5() {
        return this.skipBtConnPermission;
    }

    public final boolean component6() {
        return this.useRtcTestDomain;
    }

    public final boolean component7() {
        return this.supportFakeConnect;
    }

    public final boolean component8() {
        return this.enableRtcSpeechAec;
    }

    public final boolean component9() {
        return this.rtcDumpEnable;
    }

    public final OMNIAVRTCEngineInitConfig copy(String r110, String r111, String r112, String r113, boolean r210, boolean r211, boolean r212, boolean r213, boolean r214, boolean r215, String r216, String r217, OMNIAVSessionProfile r218) {
        Intrinsics.checkNotNullParameter(r218, "sessionProfile");
        return new OMNIAVRTCEngineInitConfig(r110, r111, r112, r113, r210, r211, r212, r213, r214, r215, r216, r217, r218);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OMNIAVRTCEngineInitConfig) == true) goto L8;
        return false;
    L8:
        OMNIAVRTCEngineInitConfig r101 = (OMNIAVRTCEngineInitConfig) r100;
        if (Intrinsics.areEqual(this.appId, r101.appId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.businessId, r101.businessId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.userId, r101.userId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.token, r101.token) == true) goto L21;
        return false;
    L21:
        if (this.skipBtConnPermission == r101.skipBtConnPermission) goto L24;
        return false;
    L24:
        if (this.useRtcTestDomain == r101.useRtcTestDomain) goto L27;
        return false;
    L27:
        if (this.supportFakeConnect == r101.supportFakeConnect) goto L30;
        return false;
    L30:
        if (this.enableRtcSpeechAec == r101.enableRtcSpeechAec) goto L33;
        return false;
    L33:
        if (this.rtcDumpEnable == r101.rtcDumpEnable) goto L36;
        return false;
    L36:
        if (this.isOversea == r101.isOversea) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.engineParameters, r101.engineParameters) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.engineBusinessId, r101.engineBusinessId) == true) goto L45;
        return false;
    L45:
        if (this.sessionProfile == r101.sessionProfile) goto L47;
        return false;
    L47:
        return true;
    }

    public int hashCode() {
        String r100 = this.appId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.businessId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.userId;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.token;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        int r113 = 1231;
        if (this.skipBtConnPermission == false) goto L21;
        int r114 = 1231;
    L22:
        int r115 = (r112 + r114) * 31;
        if (this.useRtcTestDomain == false) goto L25;
        int r116 = 1231;
    L26:
        int r117 = (r115 + r116) * 31;
        if (this.supportFakeConnect == false) goto L29;
        int r118 = 1231;
    L30:
        int r119 = (r117 + r118) * 31;
        if (this.enableRtcSpeechAec == false) goto L33;
        int r120 = 1231;
    L34:
        int r121 = (r119 + r120) * 31;
        if (this.rtcDumpEnable == false) goto L37;
        int r122 = 1231;
    L38:
        int r123 = (r121 + r122) * 31;
        if (this.isOversea == true) goto L42;
        r113 = 1237;
    L42:
        int r124 = (r123 + r113) * 31;
        String r125 = this.engineParameters;
        if (r125 != null) goto L45;
        int r126 = 0;
    L46:
        int r127 = (r124 + r126) * 31;
        String r128 = this.engineBusinessId;
        if (r128 == null) goto L51;
        r101 = r128.hashCode();
    L51:
        return ((r127 + r101) * 31) + this.sessionProfile.hashCode();
    L45:
        r126 = r125.hashCode();
        goto L46
    L37:
        r122 = 1237;
        goto L38
    L33:
        r120 = 1237;
        goto L34
    L29:
        r118 = 1237;
        goto L30
    L25:
        r116 = 1237;
        goto L26
    L21:
        r114 = 1237;
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
        return "OMNIAVRTCEngineInitConfig(appId=" + this.appId + ", businessId=" + this.businessId + ", userId=" + this.userId + ", token=" + this.token + ", skipBtConnPermission=" + this.skipBtConnPermission + ", useRtcTestDomain=" + this.useRtcTestDomain + ", supportFakeConnect=" + this.supportFakeConnect + ", enableRtcSpeechAec=" + this.enableRtcSpeechAec + ", rtcDumpEnable=" + this.rtcDumpEnable + ", isOversea=" + this.isOversea + ", engineParameters=" + this.engineParameters + ", engineBusinessId=" + this.engineBusinessId + ", sessionProfile=" + this.sessionProfile + ')';
    }

    static {
        Companion = new Companion(null);
        $childSerializers = new Lazy[]{null, null, null, null, null, null, null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new e1())};
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_av_release(OMNIAVRTCEngineInitConfig r100, muc.d r101, f r102) {
        Lazy<d<Object>>[] r103 = $childSerializers;
        boolean r104 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r105 = true;
    L9:
        if (r105 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, v2.f520790a, r100.appId);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r106 = true;
    L18:
        if (r106 == false) goto L21;
        r101.encodeNullableSerializableElement(r102, 1, v2.f520790a, r100.businessId);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r107 = true;
    L27:
        if (r107 == false) goto L30;
        r101.encodeNullableSerializableElement(r102, 2, v2.f520790a, r100.userId);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        boolean r108 = true;
    L36:
        if (r108 == false) goto L39;
        r101.encodeNullableSerializableElement(r102, 3, v2.f520790a, r100.token);
    L39:
        if (r101.shouldEncodeElementDefault(r102, 4) == false) goto L42;
    L40:
        boolean r109 = true;
    L45:
        if (r109 == false) goto L48;
        r101.encodeBooleanElement(r102, 4, r100.skipBtConnPermission);
    L48:
        if (r101.shouldEncodeElementDefault(r102, 5) == false) goto L51;
    L49:
        boolean r110 = true;
    L54:
        if (r110 == false) goto L57;
        r101.encodeBooleanElement(r102, 5, r100.useRtcTestDomain);
    L57:
        if (r101.shouldEncodeElementDefault(r102, 6) == false) goto L60;
    L58:
        boolean r111 = true;
    L63:
        if (r111 == false) goto L66;
        r101.encodeBooleanElement(r102, 6, r100.supportFakeConnect);
    L66:
        if (r101.shouldEncodeElementDefault(r102, 7) == false) goto L69;
    L67:
        boolean r112 = true;
    L72:
        if (r112 == false) goto L75;
        r101.encodeBooleanElement(r102, 7, r100.enableRtcSpeechAec);
    L75:
        if (r101.shouldEncodeElementDefault(r102, 8) == false) goto L78;
    L76:
        boolean r113 = true;
    L81:
        if (r113 == false) goto L84;
        r101.encodeBooleanElement(r102, 8, r100.rtcDumpEnable);
    L84:
        if (r101.shouldEncodeElementDefault(r102, 9) == false) goto L87;
    L85:
        boolean r114 = true;
    L90:
        if (r114 == false) goto L93;
        r101.encodeBooleanElement(r102, 9, r100.isOversea);
    L93:
        if (r101.shouldEncodeElementDefault(r102, 10) == false) goto L96;
    L94:
        boolean r115 = true;
    L99:
        if (r115 == false) goto L102;
        r101.encodeNullableSerializableElement(r102, 10, v2.f520790a, r100.engineParameters);
    L102:
        if (r101.shouldEncodeElementDefault(r102, 11) == false) goto L105;
    L103:
        boolean r116 = true;
    L108:
        if (r116 == false) goto L111;
        r101.encodeNullableSerializableElement(r102, 11, v2.f520790a, r100.engineBusinessId);
    L111:
        if (r101.shouldEncodeElementDefault(r102, 12) == false) goto L114;
    L112:
        r104 = true;
    L116:
        if (r104 == false) goto L119;
        r101.encodeSerializableElement(r102, 12, r103[12].getValue(), r100.sessionProfile);
        return;
    L119:
        return;
    L114:
        if (r100.sessionProfile == OMNIAVSessionProfile.FULL_AV) goto L116;
    L105:
        if (r100.engineBusinessId != null) goto L103;
        r116 = false;
        goto L108
    L96:
        if (r100.engineParameters != null) goto L94;
        r115 = false;
        goto L99
    L87:
        if (r100.isOversea == true) goto L85;
        r114 = false;
        goto L90
    L78:
        if (r100.rtcDumpEnable == true) goto L76;
        r113 = false;
        goto L81
    L69:
        if (r100.enableRtcSpeechAec == true) goto L67;
        r112 = false;
        goto L72
    L60:
        if (r100.supportFakeConnect == true) goto L58;
        r111 = false;
        goto L63
    L51:
        if (r100.useRtcTestDomain == true) goto L49;
        r110 = false;
        goto L54
    L42:
        if (r100.skipBtConnPermission == true) goto L40;
        r109 = false;
        goto L45
    L33:
        if (r100.token != null) goto L31;
        r108 = false;
        goto L36
    L24:
        if (r100.userId != null) goto L22;
        r107 = false;
        goto L27
    L15:
        if (r100.businessId != null) goto L13;
        r106 = false;
        goto L18
    L6:
        if (r100.appId != null) goto L4;
        r105 = false;
        goto L9
    }

    public OMNIAVRTCEngineInitConfig(String r100, String r101, String r102, String r103, boolean r104, boolean r105, boolean r106, boolean r107, boolean r110, boolean r111, String r112, String r113, OMNIAVSessionProfile r114) {
        Intrinsics.checkNotNullParameter(r114, "sessionProfile");
        this.appId = r100;
        this.businessId = r101;
        this.userId = r102;
        this.token = r103;
        this.skipBtConnPermission = r104;
        this.useRtcTestDomain = r105;
        this.supportFakeConnect = r106;
        this.enableRtcSpeechAec = r107;
        this.rtcDumpEnable = r110;
        this.isOversea = r111;
        this.engineParameters = r112;
        this.engineBusinessId = r113;
        this.sessionProfile = r114;
    }

    public /* synthetic */ OMNIAVRTCEngineInitConfig(int r100, String r101, String r102, String r103, String r110, boolean r111, boolean r112, boolean r113, boolean r114, boolean r115, boolean r116, String r117, String r118, OMNIAVSessionProfile r119, q2 r210) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, OMNIAVRTCEngineInitConfig$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.appId = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.businessId = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.userId = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.token = null;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.skipBtConnPermission = false;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.useRtcTestDomain = false;
    L29:
        if ((r100 & 64) != 0) goto L31;
        this.supportFakeConnect = false;
    L33:
        if ((r100 & 128) != 0) goto L35;
        this.enableRtcSpeechAec = false;
    L37:
        if ((r100 & 256) != 0) goto L39;
        this.rtcDumpEnable = false;
    L41:
        if ((r100 & 512) != 0) goto L43;
        this.isOversea = false;
    L45:
        if ((r100 & 1024) != 0) goto L47;
        this.engineParameters = null;
    L49:
        if ((r100 & 2048) != 0) goto L51;
        this.engineBusinessId = null;
    L53:
        if ((r100 & 4096) != 0) goto L55;
        OMNIAVSessionProfile r104 = OMNIAVSessionProfile.FULL_AV;
    L56:
        this.sessionProfile = r104;
        return;
    L55:
        r104 = r119;
        goto L56
    L51:
        this.engineBusinessId = r118;
        goto L53
    L47:
        this.engineParameters = r117;
        goto L49
    L43:
        this.isOversea = r116;
        goto L45
    L39:
        this.rtcDumpEnable = r115;
        goto L41
    L35:
        this.enableRtcSpeechAec = r114;
        goto L37
    L31:
        this.supportFakeConnect = r113;
        goto L33
    L27:
        this.useRtcTestDomain = r112;
        goto L29
    L23:
        this.skipBtConnPermission = r111;
        goto L25
    L19:
        this.token = r110;
        goto L21
    L15:
        this.userId = r103;
        goto L17
    L11:
        this.businessId = r102;
        goto L13
    L7:
        this.appId = r101;
        goto L9
    }

    public /* synthetic */ OMNIAVRTCEngineInitConfig(String r110, String r111, String r112, String r113, boolean r114, boolean r210, boolean r211, boolean r212, boolean r213, boolean r214, String r215, String r216, OMNIAVSessionProfile r217, int r218, DefaultConstructorMarker r219) {
        String r100 = null;
        if ((r218 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r218 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r218 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r218 & 8) == 0) goto L17;
        String r104 = null;
    L18:
        boolean r105 = false;
        if ((r218 & 16) == 0) goto L21;
        boolean r106 = false;
    L23:
        if ((r218 & 32) == 0) goto L25;
        boolean r107 = false;
    L27:
        if ((r218 & 64) == 0) goto L29;
        boolean r108 = false;
    L31:
        if ((r218 & 128) == 0) goto L33;
        boolean r115 = false;
    L35:
        if ((r218 & 256) == 0) goto L37;
        boolean r116 = false;
    L39:
        if ((r218 & 512) != 0) goto L43;
        r105 = r214;
    L43:
        if ((r218 & 1024) == 0) goto L45;
        String r117 = null;
    L47:
        if ((r218 & 2048) != 0) goto L51;
        r100 = r216;
    L51:
        if ((r218 & 4096) == 0) goto L53;
        OMNIAVSessionProfile r109 = OMNIAVSessionProfile.FULL_AV;
    L54:
        this(r101, r102, r103, r104, r106, r107, r108, r115, r116, r105, r117, r100, r109);
        return;
    L53:
        r109 = r217;
        goto L54
    L45:
        r117 = r215;
        goto L47
    L37:
        r116 = r213;
        goto L39
    L33:
        r115 = r212;
        goto L35
    L29:
        r108 = r211;
        goto L31
    L25:
        r107 = r210;
        goto L27
    L21:
        r106 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L18
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
