package com.larus.im.internal.jni.bean;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import de9.mc;
import java.util.List;
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
import nuc.b2;
import nuc.f;
import nuc.q2;
import nuc.v2;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 62\u00060\u0001j\u0002`\u0002:\u000256Bi\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010Bm\b\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u000f\u0010\u0015J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010#\u001a\u00020\tHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010%\u001a\u00020\fHÆ\u0003J\u0011\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000eHÆ\u0003Jk\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000eHÆ\u0001J\u0013\u0010(\u001a\u00020\f2\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001a\u00020\u0012HÖ\u0001J\t\u0010,\u001a\u00020\u0004HÖ\u0001J%\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u00002\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0001¢\u0006\u0002\b4R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0018\u0010\u0017R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0019\u0010\u0017R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001a\u0010\u0017R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001b\u0010\u0017R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001c\u0010\u0017R\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001d\u0010\u0017R\u001e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001e\u0010\u0017¨\u00067"}, d2 = {"Lcom/larus/im/internal/jni/bean/RoomMeta;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "rtcAppId", "", "roomId", "rtcUserId", "token", "expireTimeMs", "", "sessionId", "useRtcTestDomain", "", "testAccessHosts", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;ZLjava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;ZLjava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getRtcAppId$annotations", "()V", "getRoomId$annotations", "getRtcUserId$annotations", "getToken$annotations", "getExpireTimeMs$annotations", "getSessionId$annotations", "getUseRtcTestDomain$annotations", "getTestAccessHosts$annotations", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_release", "$serializer", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class RoomMeta implements java.io.Serializable {
    private static final Lazy<d<Object>>[] $childSerializers = null;
    public static final Companion Companion = null;
    public final long expireTimeMs;
    public final String roomId;
    public final String rtcAppId;
    public final String rtcUserId;
    public final String sessionId;
    public final List<String> testAccessHosts;
    public final String token;
    public final boolean useRtcTestDomain;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/RoomMeta$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/RoomMeta;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<RoomMeta> serializer() {
            return RoomMeta$$serializer.INSTANCE;
        }
    }

    public RoomMeta() {
        this(null, null, null, null, 0, null, false, null, 255, null);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_() {
        return new f(v2.f520790a);
    }

    public static /* synthetic */ d a() {
        return _childSerializers$_anonymous_();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RoomMeta copy$default(RoomMeta r110, String r111, String r112, String r113, String r114, long r115, String r116, boolean r117, List r118, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        String r100 = r110.rtcAppId;
    L7:
        if ((r210 & 2) == 0) goto L9;
        String r101 = r110.roomId;
    L11:
        if ((r210 & 4) == 0) goto L13;
        String r102 = r110.rtcUserId;
    L15:
        if ((r210 & 8) == 0) goto L17;
        String r103 = r110.token;
    L19:
        if ((r210 & 16) == 0) goto L21;
        long r104 = r110.expireTimeMs;
    L23:
        if ((r210 & 32) == 0) goto L25;
        String r105 = r110.sessionId;
    L27:
        if ((r210 & 64) == 0) goto L29;
        boolean r106 = r110.useRtcTestDomain;
    L31:
        if ((r210 & 128) == 0) goto L33;
        List r107 = r110.testAccessHosts;
    L35:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107);
    L33:
        r107 = r118;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
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

    @SerialName("expire_time_ms")
    public static /* synthetic */ void getExpireTimeMs$annotations() {
    }

    @SerialName("room_id")
    public static /* synthetic */ void getRoomId$annotations() {
    }

    @SerialName("rtc_app_id")
    public static /* synthetic */ void getRtcAppId$annotations() {
    }

    @SerialName("rtc_user_id")
    public static /* synthetic */ void getRtcUserId$annotations() {
    }

    @SerialName("session_id")
    public static /* synthetic */ void getSessionId$annotations() {
    }

    @SerialName("test_access_hosts")
    public static /* synthetic */ void getTestAccessHosts$annotations() {
    }

    @SerialName("token")
    public static /* synthetic */ void getToken$annotations() {
    }

    @SerialName("use_rtc_test_domain")
    public static /* synthetic */ void getUseRtcTestDomain$annotations() {
    }

    public final String component1() {
        return this.rtcAppId;
    }

    public final String component2() {
        return this.roomId;
    }

    public final String component3() {
        return this.rtcUserId;
    }

    public final String component4() {
        return this.token;
    }

    public final long component5() {
        return this.expireTimeMs;
    }

    public final String component6() {
        return this.sessionId;
    }

    public final boolean component7() {
        return this.useRtcTestDomain;
    }

    public final List<String> component8() {
        return this.testAccessHosts;
    }

    public final RoomMeta copy(String r110, String r111, String r112, String r113, long r114, String r115, boolean r116, List<String> r210) {
        return new RoomMeta(r110, r111, r112, r113, r114, r115, r116, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof RoomMeta) == true) goto L8;
        return false;
    L8:
        RoomMeta r101 = (RoomMeta) r100;
        if (Intrinsics.areEqual(this.rtcAppId, r101.rtcAppId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.roomId, r101.roomId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.rtcUserId, r101.rtcUserId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.token, r101.token) == true) goto L21;
        return false;
    L21:
        if (this.expireTimeMs == r101.expireTimeMs) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.sessionId, r101.sessionId) == true) goto L27;
        return false;
    L27:
        if (this.useRtcTestDomain == r101.useRtcTestDomain) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.testAccessHosts, r101.testAccessHosts) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        String r100 = this.rtcAppId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.roomId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.rtcUserId;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.token;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        long r113 = this.expireTimeMs;
        int r114 = (r112 + ((int) (r113 ^ (r113 >>> 32)))) * 31;
        String r115 = this.sessionId;
        if (r115 != null) goto L21;
        int r116 = 0;
    L22:
        int r117 = (r114 + r116) * 31;
        if (this.useRtcTestDomain == false) goto L25;
        int r118 = 1231;
    L26:
        int r119 = (r117 + r118) * 31;
        List<String> r120 = this.testAccessHosts;
        if (r120 == null) goto L31;
        r101 = r120.hashCode();
    L31:
        return r119 + r101;
    L25:
        r118 = 1237;
        goto L26
    L21:
        r116 = r115.hashCode();
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
        return "RoomMeta(rtcAppId=" + this.rtcAppId + ", roomId=" + this.roomId + ", rtcUserId=" + this.rtcUserId + ", token=" + this.token + ", expireTimeMs=" + this.expireTimeMs + ", sessionId=" + this.sessionId + ", useRtcTestDomain=" + this.useRtcTestDomain + ", testAccessHosts=" + this.testAccessHosts + ')';
    }

    static {
        Companion = new Companion(null);
        $childSerializers = new Lazy[]{null, null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new mc())};
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_release(RoomMeta r100, muc.d r110, luc.f r111) {
        Lazy<d<Object>>[] r101 = $childSerializers;
        boolean r102 = false;
        if (r110.shouldEncodeElementDefault(r111, 0) == false) goto L6;
    L4:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L12;
        r110.encodeNullableSerializableElement(r111, 0, v2.f520790a, r100.rtcAppId);
    L12:
        if (r110.shouldEncodeElementDefault(r111, 1) == false) goto L15;
    L13:
        boolean r104 = true;
    L18:
        if (r104 == false) goto L21;
        r110.encodeNullableSerializableElement(r111, 1, v2.f520790a, r100.roomId);
    L21:
        if (r110.shouldEncodeElementDefault(r111, 2) == false) goto L24;
    L22:
        boolean r105 = true;
    L27:
        if (r105 == false) goto L30;
        r110.encodeNullableSerializableElement(r111, 2, v2.f520790a, r100.rtcUserId);
    L30:
        if (r110.shouldEncodeElementDefault(r111, 3) == false) goto L33;
    L31:
        boolean r106 = true;
    L36:
        if (r106 == false) goto L39;
        r110.encodeNullableSerializableElement(r111, 3, v2.f520790a, r100.token);
    L39:
        if (r110.shouldEncodeElementDefault(r111, 4) == false) goto L42;
    L40:
        boolean r107 = true;
    L45:
        if (r107 == false) goto L48;
        r110.encodeLongElement(r111, 4, r100.expireTimeMs);
    L48:
        if (r110.shouldEncodeElementDefault(r111, 5) == false) goto L51;
    L49:
        boolean r108 = true;
    L54:
        if (r108 == false) goto L57;
        r110.encodeNullableSerializableElement(r111, 5, v2.f520790a, r100.sessionId);
    L57:
        if (r110.shouldEncodeElementDefault(r111, 6) == false) goto L60;
    L58:
        boolean r109 = true;
    L63:
        if (r109 == false) goto L66;
        r110.encodeBooleanElement(r111, 6, r100.useRtcTestDomain);
    L66:
        if (r110.shouldEncodeElementDefault(r111, 7) == false) goto L69;
    L67:
        r102 = true;
    L71:
        if (r102 == false) goto L74;
        r110.encodeNullableSerializableElement(r111, 7, r101[7].getValue(), r100.testAccessHosts);
        return;
    L74:
        return;
    L69:
        if (r100.testAccessHosts == null) goto L71;
    L60:
        if (r100.useRtcTestDomain == true) goto L58;
        r109 = false;
        goto L63
    L51:
        if (r100.sessionId != null) goto L49;
        r108 = false;
        goto L54
    L42:
        if (r100.expireTimeMs != 0) goto L40;
        r107 = false;
        goto L45
    L33:
        if (r100.token != null) goto L31;
        r106 = false;
        goto L36
    L24:
        if (r100.rtcUserId != null) goto L22;
        r105 = false;
        goto L27
    L15:
        if (r100.roomId != null) goto L13;
        r104 = false;
        goto L18
    L6:
        if (r100.rtcAppId != null) goto L4;
        r103 = false;
        goto L9
    }

    public RoomMeta(String r100, String r101, String r102, String r103, long r104, String r105, boolean r106, List<String> r107) {
        this.rtcAppId = r100;
        this.roomId = r101;
        this.rtcUserId = r102;
        this.token = r103;
        this.expireTimeMs = r104;
        this.sessionId = r105;
        this.useRtcTestDomain = r106;
        this.testAccessHosts = r107;
    }

    public /* synthetic */ RoomMeta(int r100, String r101, String r102, String r103, String r104, long r105, String r110, boolean r111, List r112, q2 r113) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, RoomMeta$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.rtcAppId = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.roomId = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.rtcUserId = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.token = null;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.expireTimeMs = 0;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.sessionId = null;
    L29:
        if ((r100 & 64) != 0) goto L31;
        this.useRtcTestDomain = false;
    L33:
        if ((r100 & 128) != 0) goto L35;
        this.testAccessHosts = null;
        return;
    L35:
        this.testAccessHosts = r112;
        return;
    L31:
        this.useRtcTestDomain = r111;
        goto L33
    L27:
        this.sessionId = r110;
        goto L29
    L23:
        this.expireTimeMs = r105;
        goto L25
    L19:
        this.token = r104;
        goto L21
    L15:
        this.rtcUserId = r103;
        goto L17
    L11:
        this.roomId = r102;
        goto L13
    L7:
        this.rtcAppId = r101;
        goto L9
    }

    public /* synthetic */ RoomMeta(String r110, String r111, String r112, String r113, long r114, String r115, boolean r116, List r117, int r210, DefaultConstructorMarker r211) {
        List r100 = null;
        if ((r210 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r210 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r210 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r210 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r210 & 16) == 0) goto L21;
        long r105 = 0;
    L23:
        if ((r210 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r210 & 64) == 0) goto L29;
        boolean r107 = false;
    L31:
        if ((r210 & 128) != 0) goto L34;
        r100 = r117;
    L34:
        this(r101, r102, r103, r104, r105, r106, r107, r100);
        return;
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
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
