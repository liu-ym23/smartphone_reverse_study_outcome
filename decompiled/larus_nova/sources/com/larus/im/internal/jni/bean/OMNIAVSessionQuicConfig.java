package com.larus.im.internal.jni.bean;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.heytap.mcssdk.constant.b;
import juc.d;
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
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 J2\u00060\u0001j\u0002`\u0002:\u0002IJB\u00ad\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\b\b\u0002\u0010\u0013\u001a\u00020\r\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0010¢\u0006\u0004\b\u0015\u0010\u0016B£\u0001\b\u0010\u0012\u0006\u0010\u0017\u001a\u00020\r\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\r\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\u0006\u0010\u0013\u001a\u00020\r\u0012\u0006\u0010\u0014\u001a\u00020\u0010\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u0015\u0010\u001aJ\u000b\u0010+\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u00103\u001a\u00020\rHÆ\u0003J\t\u00104\u001a\u00020\rHÆ\u0003J\t\u00105\u001a\u00020\u0010HÆ\u0003J\t\u00106\u001a\u00020\rHÆ\u0003J\t\u00107\u001a\u00020\rHÆ\u0003J\t\u00108\u001a\u00020\rHÆ\u0003J\t\u00109\u001a\u00020\u0010HÆ\u0003J¯\u0001\u0010:\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\u0010HÆ\u0001J\u0013\u0010;\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u00010>HÖ\u0003J\t\u0010?\u001a\u00020\rHÖ\u0001J\t\u0010@\u001a\u00020\u0004HÖ\u0001J%\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\u00002\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020GH\u0001¢\u0006\u0002\bHR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001b\u0010\u001cR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001d\u0010\u001cR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001e\u0010\u001cR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001f\u0010\u001cR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b \u0010\u001cR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b!\u0010\u001cR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\"\u0010\u001cR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b#\u0010\u001cR\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b$\u0010\u001cR\u0016\u0010\u000e\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b%\u0010\u001cR\u0016\u0010\u000f\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b&\u0010\u001cR\u0016\u0010\u0011\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b'\u0010\u001cR\u0016\u0010\u0012\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b(\u0010\u001cR\u0016\u0010\u0013\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b)\u0010\u001cR\u0016\u0010\u0014\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b*\u0010\u001c¨\u0006K"}, d2 = {"Lcom/larus/im/internal/jni/bean/OMNIAVSessionQuicConfig;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "url", "", "urlWithQueries", "appId", "appVersion", b.f276376z, "header", "namespace", "ppeLane", "connectRetryCount", "", "connectRetryDurationMs", "connectRetryDurationFactor", "", "connectTimeoutMs", "reconnectingMaxCount", "reconnectingDurationMs", "reconnectingDurationFactor", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIFIIIF)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIFIIIFLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getUrl$annotations", "()V", "getUrlWithQueries$annotations", "getAppId$annotations", "getAppVersion$annotations", "getAppKey$annotations", "getHeader$annotations", "getNamespace$annotations", "getPpeLane$annotations", "getConnectRetryCount$annotations", "getConnectRetryDurationMs$annotations", "getConnectRetryDurationFactor$annotations", "getConnectTimeoutMs$annotations", "getReconnectingMaxCount$annotations", "getReconnectingDurationMs$annotations", "getReconnectingDurationFactor$annotations", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_av_release", "$serializer", "Companion", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OMNIAVSessionQuicConfig implements java.io.Serializable {
    public static final Companion Companion = null;
    public final String appId;
    public final String appKey;
    public final String appVersion;
    public final int connectRetryCount;
    public final float connectRetryDurationFactor;
    public final int connectRetryDurationMs;
    public final int connectTimeoutMs;
    public final String header;
    public final String namespace;
    public final String ppeLane;
    public final float reconnectingDurationFactor;
    public final int reconnectingDurationMs;
    public final int reconnectingMaxCount;
    public final String url;
    public final String urlWithQueries;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OMNIAVSessionQuicConfig$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OMNIAVSessionQuicConfig;", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OMNIAVSessionQuicConfig> serializer() {
            return OMNIAVSessionQuicConfig$$serializer.INSTANCE;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OMNIAVSessionQuicConfig() {
        this(null, null, null, null, null, null, null, null, 0, 0, 0.0f, 0, 0, 0, 0.0f, 32767, null);
    }

    public static /* synthetic */ OMNIAVSessionQuicConfig copy$default(OMNIAVSessionQuicConfig r110, String r111, String r112, String r113, String r210, String r211, String r212, String r213, String r214, int r215, int r216, float r217, int r218, int r219, int r310, float r311, int r312, Object r313) {
        if ((r312 & 1) == 0) goto L5;
        String r100 = r110.url;
    L7:
        if ((r312 & 2) == 0) goto L9;
        String r101 = r110.urlWithQueries;
    L11:
        if ((r312 & 4) == 0) goto L13;
        String r102 = r110.appId;
    L15:
        if ((r312 & 8) == 0) goto L17;
        String r103 = r110.appVersion;
    L19:
        if ((r312 & 16) == 0) goto L21;
        String r104 = r110.appKey;
    L23:
        if ((r312 & 32) == 0) goto L25;
        String r105 = r110.header;
    L27:
        if ((r312 & 64) == 0) goto L29;
        String r106 = r110.namespace;
    L31:
        if ((r312 & 128) == 0) goto L33;
        String r107 = r110.ppeLane;
    L35:
        if ((r312 & 256) == 0) goto L37;
        int r114 = r110.connectRetryCount;
    L39:
        if ((r312 & 512) == 0) goto L41;
        int r115 = r110.connectRetryDurationMs;
    L43:
        if ((r312 & 1024) == 0) goto L45;
        float r116 = r110.connectRetryDurationFactor;
    L47:
        if ((r312 & 2048) == 0) goto L49;
        int r117 = r110.connectTimeoutMs;
    L51:
        if ((r312 & 4096) == 0) goto L53;
        int r118 = r110.reconnectingMaxCount;
    L55:
        if ((r312 & 8192) == 0) goto L57;
        int r119 = r110.reconnectingDurationMs;
    L59:
        if ((r312 & 16384) == 0) goto L61;
        float r108 = r110.reconnectingDurationFactor;
    L63:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r114, r115, r116, r117, r118, r119, r108);
    L61:
        r108 = r311;
        goto L63
    L57:
        r119 = r310;
        goto L59
    L53:
        r118 = r219;
        goto L55
    L49:
        r117 = r218;
        goto L51
    L45:
        r116 = r217;
        goto L47
    L41:
        r115 = r216;
        goto L43
    L37:
        r114 = r215;
        goto L39
    L33:
        r107 = r214;
        goto L35
    L29:
        r106 = r213;
        goto L31
    L25:
        r105 = r212;
        goto L27
    L21:
        r104 = r211;
        goto L23
    L17:
        r103 = r210;
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

    @SerialName("app_key")
    public static /* synthetic */ void getAppKey$annotations() {
    }

    @SerialName("app_version")
    public static /* synthetic */ void getAppVersion$annotations() {
    }

    @SerialName("connect_retry_count")
    public static /* synthetic */ void getConnectRetryCount$annotations() {
    }

    @SerialName("connect_retry_duration_factor")
    public static /* synthetic */ void getConnectRetryDurationFactor$annotations() {
    }

    @SerialName("connect_retry_duration_ms")
    public static /* synthetic */ void getConnectRetryDurationMs$annotations() {
    }

    @SerialName("connect_timeout_ms")
    public static /* synthetic */ void getConnectTimeoutMs$annotations() {
    }

    @SerialName("header")
    public static /* synthetic */ void getHeader$annotations() {
    }

    @SerialName("namespace_")
    public static /* synthetic */ void getNamespace$annotations() {
    }

    @SerialName("ppe_lane")
    public static /* synthetic */ void getPpeLane$annotations() {
    }

    @SerialName("reconnecting_duration_factor")
    public static /* synthetic */ void getReconnectingDurationFactor$annotations() {
    }

    @SerialName("reconnecting_duration_ms")
    public static /* synthetic */ void getReconnectingDurationMs$annotations() {
    }

    @SerialName("reconnecting_max_count")
    public static /* synthetic */ void getReconnectingMaxCount$annotations() {
    }

    @SerialName("url")
    public static /* synthetic */ void getUrl$annotations() {
    }

    @SerialName("url_with_queries")
    public static /* synthetic */ void getUrlWithQueries$annotations() {
    }

    public final String component1() {
        return this.url;
    }

    public final int component10() {
        return this.connectRetryDurationMs;
    }

    public final float component11() {
        return this.connectRetryDurationFactor;
    }

    public final int component12() {
        return this.connectTimeoutMs;
    }

    public final int component13() {
        return this.reconnectingMaxCount;
    }

    public final int component14() {
        return this.reconnectingDurationMs;
    }

    public final float component15() {
        return this.reconnectingDurationFactor;
    }

    public final String component2() {
        return this.urlWithQueries;
    }

    public final String component3() {
        return this.appId;
    }

    public final String component4() {
        return this.appVersion;
    }

    public final String component5() {
        return this.appKey;
    }

    public final String component6() {
        return this.header;
    }

    public final String component7() {
        return this.namespace;
    }

    public final String component8() {
        return this.ppeLane;
    }

    public final int component9() {
        return this.connectRetryCount;
    }

    public final OMNIAVSessionQuicConfig copy(String r110, String r111, String r210, String r211, String r212, String r213, String r214, String r215, int r216, int r217, float r218, int r219, int r310, int r311, float r312) {
        return new OMNIAVSessionQuicConfig(r110, r111, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OMNIAVSessionQuicConfig) == true) goto L8;
        return false;
    L8:
        OMNIAVSessionQuicConfig r101 = (OMNIAVSessionQuicConfig) r100;
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.urlWithQueries, r101.urlWithQueries) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.appId, r101.appId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.appVersion, r101.appVersion) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.appKey, r101.appKey) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.header, r101.header) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.namespace, r101.namespace) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.ppeLane, r101.ppeLane) == true) goto L33;
        return false;
    L33:
        if (this.connectRetryCount == r101.connectRetryCount) goto L36;
        return false;
    L36:
        if (this.connectRetryDurationMs == r101.connectRetryDurationMs) goto L39;
        return false;
    L39:
        if (Float.compare(this.connectRetryDurationFactor, r101.connectRetryDurationFactor) == 0) goto L42;
        return false;
    L42:
        if (this.connectTimeoutMs == r101.connectTimeoutMs) goto L45;
        return false;
    L45:
        if (this.reconnectingMaxCount == r101.reconnectingMaxCount) goto L48;
        return false;
    L48:
        if (this.reconnectingDurationMs == r101.reconnectingDurationMs) goto L51;
        return false;
    L51:
        if (Float.compare(this.reconnectingDurationFactor, r101.reconnectingDurationFactor) == 0) goto L53;
        return false;
    L53:
        return true;
    }

    public int hashCode() {
        String r100 = this.url;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.urlWithQueries;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.appId;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.appVersion;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.appKey;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.header;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.namespace;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.ppeLane;
        if (r122 == null) goto L35;
        r101 = r122.hashCode();
    L35:
        return ((((((((((((((r121 + r101) * 31) + this.connectRetryCount) * 31) + this.connectRetryDurationMs) * 31) + Float.floatToIntBits(this.connectRetryDurationFactor)) * 31) + this.connectTimeoutMs) * 31) + this.reconnectingMaxCount) * 31) + this.reconnectingDurationMs) * 31) + Float.floatToIntBits(this.reconnectingDurationFactor);
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

    public String toString() {
        return "OMNIAVSessionQuicConfig(url=" + this.url + ", urlWithQueries=" + this.urlWithQueries + ", appId=" + this.appId + ", appVersion=" + this.appVersion + ", appKey=" + this.appKey + ", header=" + this.header + ", namespace=" + this.namespace + ", ppeLane=" + this.ppeLane + ", connectRetryCount=" + this.connectRetryCount + ", connectRetryDurationMs=" + this.connectRetryDurationMs + ", connectRetryDurationFactor=" + this.connectRetryDurationFactor + ", connectTimeoutMs=" + this.connectTimeoutMs + ", reconnectingMaxCount=" + this.reconnectingMaxCount + ", reconnectingDurationMs=" + this.reconnectingDurationMs + ", reconnectingDurationFactor=" + this.reconnectingDurationFactor + ')';
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_av_release(OMNIAVSessionQuicConfig r100, muc.d r101, f r102) {
        boolean r103 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, v2.f520790a, r100.url);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r105 = true;
    L18:
        if (r105 == false) goto L21;
        r101.encodeNullableSerializableElement(r102, 1, v2.f520790a, r100.urlWithQueries);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r106 = true;
    L27:
        if (r106 == false) goto L30;
        r101.encodeNullableSerializableElement(r102, 2, v2.f520790a, r100.appId);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        boolean r107 = true;
    L36:
        if (r107 == false) goto L39;
        r101.encodeNullableSerializableElement(r102, 3, v2.f520790a, r100.appVersion);
    L39:
        if (r101.shouldEncodeElementDefault(r102, 4) == false) goto L42;
    L40:
        boolean r108 = true;
    L45:
        if (r108 == false) goto L48;
        r101.encodeNullableSerializableElement(r102, 4, v2.f520790a, r100.appKey);
    L48:
        if (r101.shouldEncodeElementDefault(r102, 5) == false) goto L51;
    L49:
        boolean r109 = true;
    L54:
        if (r109 == false) goto L57;
        r101.encodeNullableSerializableElement(r102, 5, v2.f520790a, r100.header);
    L57:
        if (r101.shouldEncodeElementDefault(r102, 6) == false) goto L60;
    L58:
        boolean r110 = true;
    L63:
        if (r110 == false) goto L66;
        r101.encodeNullableSerializableElement(r102, 6, v2.f520790a, r100.namespace);
    L66:
        if (r101.shouldEncodeElementDefault(r102, 7) == false) goto L69;
    L67:
        boolean r111 = true;
    L72:
        if (r111 == false) goto L75;
        r101.encodeNullableSerializableElement(r102, 7, v2.f520790a, r100.ppeLane);
    L75:
        if (r101.shouldEncodeElementDefault(r102, 8) == false) goto L78;
    L76:
        boolean r112 = true;
    L81:
        if (r112 == false) goto L84;
        r101.encodeIntElement(r102, 8, r100.connectRetryCount);
    L84:
        if (r101.shouldEncodeElementDefault(r102, 9) == false) goto L87;
    L85:
        boolean r113 = true;
    L90:
        if (r113 == false) goto L93;
        r101.encodeIntElement(r102, 9, r100.connectRetryDurationMs);
    L93:
        if (r101.shouldEncodeElementDefault(r102, 10) == false) goto L96;
    L94:
        boolean r114 = true;
    L99:
        if (r114 == false) goto L102;
        r101.encodeFloatElement(r102, 10, r100.connectRetryDurationFactor);
    L102:
        if (r101.shouldEncodeElementDefault(r102, 11) == false) goto L105;
    L103:
        boolean r115 = true;
    L108:
        if (r115 == false) goto L111;
        r101.encodeIntElement(r102, 11, r100.connectTimeoutMs);
    L111:
        if (r101.shouldEncodeElementDefault(r102, 12) == false) goto L114;
    L112:
        boolean r116 = true;
    L117:
        if (r116 == false) goto L120;
        r101.encodeIntElement(r102, 12, r100.reconnectingMaxCount);
    L120:
        if (r101.shouldEncodeElementDefault(r102, 13) == false) goto L123;
    L121:
        boolean r117 = true;
    L126:
        if (r117 == false) goto L129;
        r101.encodeIntElement(r102, 13, r100.reconnectingDurationMs);
    L129:
        if (r101.shouldEncodeElementDefault(r102, 14) == false) goto L132;
    L130:
        r103 = true;
    L134:
        if (r103 == false) goto L137;
        r101.encodeFloatElement(r102, 14, r100.reconnectingDurationFactor);
        return;
    L137:
        return;
    L132:
        if (Float.compare(r100.reconnectingDurationFactor, 0.0f) == 0) goto L134;
    L123:
        if (r100.reconnectingDurationMs != 0) goto L121;
        r117 = false;
        goto L126
    L114:
        if (r100.reconnectingMaxCount != 0) goto L112;
        r116 = false;
        goto L117
    L105:
        if (r100.connectTimeoutMs != 0) goto L103;
        r115 = false;
        goto L108
    L96:
        if (Float.compare(r100.connectRetryDurationFactor, 0.0f) != 0) goto L94;
        r114 = false;
        goto L99
    L87:
        if (r100.connectRetryDurationMs != 0) goto L85;
        r113 = false;
        goto L90
    L78:
        if (r100.connectRetryCount != 0) goto L76;
        r112 = false;
        goto L81
    L69:
        if (r100.ppeLane != null) goto L67;
        r111 = false;
        goto L72
    L60:
        if (r100.namespace != null) goto L58;
        r110 = false;
        goto L63
    L51:
        if (r100.header != null) goto L49;
        r109 = false;
        goto L54
    L42:
        if (r100.appKey != null) goto L40;
        r108 = false;
        goto L45
    L33:
        if (r100.appVersion != null) goto L31;
        r107 = false;
        goto L36
    L24:
        if (r100.appId != null) goto L22;
        r106 = false;
        goto L27
    L15:
        if (r100.urlWithQueries != null) goto L13;
        r105 = false;
        goto L18
    L6:
        if (r100.url != null) goto L4;
        r104 = false;
        goto L9
    }

    public OMNIAVSessionQuicConfig(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, int r108, int r110, float r111, int r112, int r113, int r114, float r115) {
        this.url = r100;
        this.urlWithQueries = r101;
        this.appId = r102;
        this.appVersion = r103;
        this.appKey = r104;
        this.header = r105;
        this.namespace = r106;
        this.ppeLane = r107;
        this.connectRetryCount = r108;
        this.connectRetryDurationMs = r110;
        this.connectRetryDurationFactor = r111;
        this.connectTimeoutMs = r112;
        this.reconnectingMaxCount = r113;
        this.reconnectingDurationMs = r114;
        this.reconnectingDurationFactor = r115;
    }

    public /* synthetic */ OMNIAVSessionQuicConfig(int r100, String r101, String r102, String r103, String r110, String r111, String r112, String r113, String r114, int r115, int r116, float r117, int r118, int r119, int r210, float r211, q2 r212) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, OMNIAVSessionQuicConfig$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.url = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.urlWithQueries = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.appId = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.appVersion = null;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.appKey = null;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.header = null;
    L29:
        if ((r100 & 64) != 0) goto L31;
        this.namespace = null;
    L33:
        if ((r100 & 128) != 0) goto L35;
        this.ppeLane = null;
    L37:
        if ((r100 & 256) != 0) goto L39;
        this.connectRetryCount = 0;
    L41:
        if ((r100 & 512) != 0) goto L43;
        this.connectRetryDurationMs = 0;
    L45:
        if ((r100 & 1024) != 0) goto L47;
        this.connectRetryDurationFactor = 0.0f;
    L49:
        if ((r100 & 2048) != 0) goto L51;
        this.connectTimeoutMs = 0;
    L53:
        if ((r100 & 4096) != 0) goto L55;
        this.reconnectingMaxCount = 0;
    L57:
        if ((r100 & 8192) != 0) goto L59;
        this.reconnectingDurationMs = 0;
    L61:
        if ((r100 & 16384) != 0) goto L63;
        this.reconnectingDurationFactor = 0.0f;
        return;
    L63:
        this.reconnectingDurationFactor = r211;
        return;
    L59:
        this.reconnectingDurationMs = r210;
        goto L61
    L55:
        this.reconnectingMaxCount = r119;
        goto L57
    L51:
        this.connectTimeoutMs = r118;
        goto L53
    L47:
        this.connectRetryDurationFactor = r117;
        goto L49
    L43:
        this.connectRetryDurationMs = r116;
        goto L45
    L39:
        this.connectRetryCount = r115;
        goto L41
    L35:
        this.ppeLane = r114;
        goto L37
    L31:
        this.namespace = r113;
        goto L33
    L27:
        this.header = r112;
        goto L29
    L23:
        this.appKey = r111;
        goto L25
    L19:
        this.appVersion = r110;
        goto L21
    L15:
        this.appId = r103;
        goto L17
    L11:
        this.urlWithQueries = r102;
        goto L13
    L7:
        this.url = r101;
        goto L9
    }

    public /* synthetic */ OMNIAVSessionQuicConfig(String r110, String r111, String r112, String r210, String r211, String r212, String r213, String r214, int r215, int r216, float r217, int r218, int r219, int r310, float r311, int r312, DefaultConstructorMarker r313) {
        String r100 = null;
        if ((r312 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r312 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r312 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r312 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r312 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r312 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r312 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r312 & 128) != 0) goto L35;
        r100 = r214;
    L35:
        if ((r312 & 256) == 0) goto L37;
        int r108 = 0;
    L39:
        if ((r312 & 512) == 0) goto L41;
        int r113 = 0;
    L42:
        float r114 = 0.0f;
        if ((r312 & 1024) == 0) goto L45;
        float r115 = 0.0f;
    L47:
        if ((r312 & 2048) == 0) goto L49;
        int r116 = 0;
    L51:
        if ((r312 & 4096) == 0) goto L53;
        int r117 = 0;
    L55:
        if ((r312 & 8192) == 0) goto L57;
        int r118 = 0;
    L59:
        if ((r312 & 16384) != 0) goto L62;
        r114 = r311;
    L62:
        this(r101, r102, r103, r104, r105, r106, r107, r100, r108, r113, r115, r116, r117, r118, r114);
        return;
    L57:
        r118 = r310;
        goto L59
    L53:
        r117 = r219;
        goto L55
    L49:
        r116 = r218;
        goto L51
    L45:
        r115 = r217;
        goto L47
    L41:
        r113 = r216;
        goto L42
    L37:
        r108 = r215;
        goto L39
    L29:
        r107 = r213;
        goto L31
    L25:
        r106 = r212;
        goto L27
    L21:
        r105 = r211;
        goto L23
    L17:
        r104 = r210;
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
