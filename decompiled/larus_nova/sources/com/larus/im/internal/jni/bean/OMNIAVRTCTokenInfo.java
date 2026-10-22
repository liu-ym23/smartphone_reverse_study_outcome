package com.larus.im.internal.jni.bean;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.tencent.qqmusic.third.api.contract.Keys;
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
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 82\u00060\u0001j\u0002`\u0002:\u000278Bk\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000f\u0010\u0010Bm\b\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u000f\u0010\u0015J\u000b\u0010 \u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010#\u001a\u00020\bHÆ\u0003J\t\u0010$\u001a\u00020\bHÆ\u0003J\t\u0010%\u001a\u00020\bHÆ\u0003J\t\u0010&\u001a\u00020\fHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0004HÆ\u0003Jm\u0010)\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010*\u001a\u00020\f2\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\t\u0010-\u001a\u00020\u0012HÖ\u0001J\t\u0010.\u001a\u00020\u0004HÖ\u0001J%\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u00002\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0001¢\u0006\u0002\b6R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0018\u0010\u0017R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0019\u0010\u0017R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001a\u0010\u0017R\u0016\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001b\u0010\u0017R\u0016\u0010\n\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001c\u0010\u0017R\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001d\u0010\u0017R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001e\u0010\u0017R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001f\u0010\u0017¨\u00069"}, d2 = {"Lcom/larus/im/internal/jni/bean/OMNIAVRTCTokenInfo;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "appId", "", "roomId", "token", "expireDuration", "", Keys.API_PARAM_KEY_SDK_EXPIRETIME, "acquireTime", "isClientPreload", "", "logId", "userId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJJZLjava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;JJJZLjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getAppId$annotations", "()V", "getRoomId$annotations", "getToken$annotations", "getExpireDuration$annotations", "getExpireTime$annotations", "getAcquireTime$annotations", "isClientPreload$annotations", "getLogId$annotations", "getUserId$annotations", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_av_release", "$serializer", "Companion", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OMNIAVRTCTokenInfo implements java.io.Serializable {
    public static final Companion Companion = null;
    public final long acquireTime;
    public final String appId;
    public final long expireDuration;
    public final long expireTime;
    public final boolean isClientPreload;
    public final String logId;
    public final String roomId;
    public final String token;
    public final String userId;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OMNIAVRTCTokenInfo$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OMNIAVRTCTokenInfo;", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OMNIAVRTCTokenInfo> serializer() {
            return OMNIAVRTCTokenInfo$$serializer.INSTANCE;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OMNIAVRTCTokenInfo() {
        this(null, null, null, 0, 0, 0, false, null, null, 511, null);
    }

    public static /* synthetic */ OMNIAVRTCTokenInfo copy$default(OMNIAVRTCTokenInfo r110, String r111, String r112, String r113, long r114, long r115, long r210, boolean r211, String r212, String r213, int r214, Object r215) {
        if ((r214 & 1) == 0) goto L5;
        String r100 = r110.appId;
    L7:
        if ((r214 & 2) == 0) goto L9;
        String r101 = r110.roomId;
    L11:
        if ((r214 & 4) == 0) goto L13;
        String r102 = r110.token;
    L15:
        if ((r214 & 8) == 0) goto L17;
        long r103 = r110.expireDuration;
    L19:
        if ((r214 & 16) == 0) goto L21;
        long r104 = r110.expireTime;
    L23:
        if ((r214 & 32) == 0) goto L25;
        long r105 = r110.acquireTime;
    L27:
        if ((r214 & 64) == 0) goto L29;
        boolean r116 = r110.isClientPreload;
    L31:
        if ((r214 & 128) == 0) goto L33;
        String r117 = r110.logId;
    L35:
        if ((r214 & 256) == 0) goto L37;
        String r106 = r110.userId;
    L39:
        return r110.copy(r100, r101, r102, r103, r104, r105, r116, r117, r106);
    L37:
        r106 = r213;
        goto L39
    L33:
        r117 = r212;
        goto L35
    L29:
        r116 = r211;
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

    @SerialName("acquire_time")
    public static /* synthetic */ void getAcquireTime$annotations() {
    }

    @SerialName("app_id")
    public static /* synthetic */ void getAppId$annotations() {
    }

    @SerialName("expire_duration")
    public static /* synthetic */ void getExpireDuration$annotations() {
    }

    @SerialName("expire_time")
    public static /* synthetic */ void getExpireTime$annotations() {
    }

    @SerialName("log_id")
    public static /* synthetic */ void getLogId$annotations() {
    }

    @SerialName("room_id")
    public static /* synthetic */ void getRoomId$annotations() {
    }

    @SerialName("token")
    public static /* synthetic */ void getToken$annotations() {
    }

    @SerialName("user_id")
    public static /* synthetic */ void getUserId$annotations() {
    }

    @SerialName("is_client_preload")
    public static /* synthetic */ void isClientPreload$annotations() {
    }

    public final String component1() {
        return this.appId;
    }

    public final String component2() {
        return this.roomId;
    }

    public final String component3() {
        return this.token;
    }

    public final long component4() {
        return this.expireDuration;
    }

    public final long component5() {
        return this.expireTime;
    }

    public final long component6() {
        return this.acquireTime;
    }

    public final boolean component7() {
        return this.isClientPreload;
    }

    public final String component8() {
        return this.logId;
    }

    public final String component9() {
        return this.userId;
    }

    public final OMNIAVRTCTokenInfo copy(String r110, String r111, String r112, long r113, long r210, long r211, boolean r212, String r213, String r214) {
        return new OMNIAVRTCTokenInfo(r110, r111, r112, r113, r210, r211, r212, r213, r214);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OMNIAVRTCTokenInfo) == true) goto L8;
        return false;
    L8:
        OMNIAVRTCTokenInfo r101 = (OMNIAVRTCTokenInfo) r100;
        if (Intrinsics.areEqual(this.appId, r101.appId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.roomId, r101.roomId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.token, r101.token) == true) goto L18;
        return false;
    L18:
        if (this.expireDuration == r101.expireDuration) goto L21;
        return false;
    L21:
        if (this.expireTime == r101.expireTime) goto L24;
        return false;
    L24:
        if (this.acquireTime == r101.acquireTime) goto L27;
        return false;
    L27:
        if (this.isClientPreload == r101.isClientPreload) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.logId, r101.logId) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.userId, r101.userId) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        String r100 = this.appId;
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
        String r107 = this.token;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        long r110 = this.expireDuration;
        int r111 = (r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31;
        long r112 = this.expireTime;
        int r113 = (r111 + ((int) (r112 ^ (r112 >>> 32)))) * 31;
        long r114 = this.acquireTime;
        int r115 = (r113 + ((int) (r114 ^ (r114 >>> 32)))) * 31;
        if (this.isClientPreload == false) goto L17;
        int r116 = 1231;
    L18:
        int r117 = (r115 + r116) * 31;
        String r118 = this.logId;
        if (r118 != null) goto L21;
        int r119 = 0;
    L22:
        int r120 = (r117 + r119) * 31;
        String r121 = this.userId;
        if (r121 == null) goto L27;
        r101 = r121.hashCode();
    L27:
        return r120 + r101;
    L21:
        r119 = r118.hashCode();
        goto L22
    L17:
        r116 = 1237;
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
        return "OMNIAVRTCTokenInfo(appId=" + this.appId + ", roomId=" + this.roomId + ", token=" + this.token + ", expireDuration=" + this.expireDuration + ", expireTime=" + this.expireTime + ", acquireTime=" + this.acquireTime + ", isClientPreload=" + this.isClientPreload + ", logId=" + this.logId + ", userId=" + this.userId + ')';
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_av_release(OMNIAVRTCTokenInfo r100, muc.d r101, f r110) {
        boolean r102 = false;
        if (r101.shouldEncodeElementDefault(r110, 0) == false) goto L6;
    L4:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L12;
        r101.encodeNullableSerializableElement(r110, 0, v2.f520790a, r100.appId);
    L12:
        if (r101.shouldEncodeElementDefault(r110, 1) == false) goto L15;
    L13:
        boolean r104 = true;
    L18:
        if (r104 == false) goto L21;
        r101.encodeNullableSerializableElement(r110, 1, v2.f520790a, r100.roomId);
    L21:
        if (r101.shouldEncodeElementDefault(r110, 2) == false) goto L24;
    L22:
        boolean r105 = true;
    L27:
        if (r105 == false) goto L30;
        r101.encodeNullableSerializableElement(r110, 2, v2.f520790a, r100.token);
    L30:
        if (r101.shouldEncodeElementDefault(r110, 3) == false) goto L33;
    L31:
        boolean r106 = true;
    L36:
        if (r106 == false) goto L39;
        r101.encodeLongElement(r110, 3, r100.expireDuration);
    L39:
        if (r101.shouldEncodeElementDefault(r110, 4) == false) goto L42;
    L40:
        boolean r107 = true;
    L45:
        if (r107 == false) goto L48;
        r101.encodeLongElement(r110, 4, r100.expireTime);
    L48:
        if (r101.shouldEncodeElementDefault(r110, 5) == false) goto L51;
    L49:
        boolean r108 = true;
    L54:
        if (r108 == false) goto L57;
        r101.encodeLongElement(r110, 5, r100.acquireTime);
    L57:
        if (r101.shouldEncodeElementDefault(r110, 6) == false) goto L60;
    L58:
        boolean r109 = true;
    L63:
        if (r109 == false) goto L66;
        r101.encodeBooleanElement(r110, 6, r100.isClientPreload);
    L66:
        if (r101.shouldEncodeElementDefault(r110, 7) == false) goto L69;
    L67:
        boolean r111 = true;
    L72:
        if (r111 == false) goto L75;
        r101.encodeNullableSerializableElement(r110, 7, v2.f520790a, r100.logId);
    L75:
        if (r101.shouldEncodeElementDefault(r110, 8) == false) goto L78;
    L76:
        r102 = true;
    L80:
        if (r102 == false) goto L83;
        r101.encodeNullableSerializableElement(r110, 8, v2.f520790a, r100.userId);
        return;
    L83:
        return;
    L78:
        if (r100.userId == null) goto L80;
    L69:
        if (r100.logId != null) goto L67;
        r111 = false;
        goto L72
    L60:
        if (r100.isClientPreload == true) goto L58;
        r109 = false;
        goto L63
    L51:
        if (r100.acquireTime != 0) goto L49;
        r108 = false;
        goto L54
    L42:
        if (r100.expireTime != 0) goto L40;
        r107 = false;
        goto L45
    L33:
        if (r100.expireDuration != 0) goto L31;
        r106 = false;
        goto L36
    L24:
        if (r100.token != null) goto L22;
        r105 = false;
        goto L27
    L15:
        if (r100.roomId != null) goto L13;
        r104 = false;
        goto L18
    L6:
        if (r100.appId != null) goto L4;
        r103 = false;
        goto L9
    }

    public OMNIAVRTCTokenInfo(String r100, String r101, String r102, long r103, long r104, long r105, boolean r110, String r111, String r112) {
        this.appId = r100;
        this.roomId = r101;
        this.token = r102;
        this.expireDuration = r103;
        this.expireTime = r104;
        this.acquireTime = r105;
        this.isClientPreload = r110;
        this.logId = r111;
        this.userId = r112;
    }

    public /* synthetic */ OMNIAVRTCTokenInfo(int r110, String r111, String r112, String r113, long r114, long r115, long r116, boolean r210, String r211, String r212, q2 r213) {
        if ((r110 & 0) == 0) goto L5;
        b2.b(r110, 0, OMNIAVRTCTokenInfo$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r110 & 1) != 0) goto L7;
        this.appId = null;
    L9:
        if ((r110 & 2) != 0) goto L11;
        this.roomId = null;
    L13:
        if ((r110 & 4) != 0) goto L15;
        this.token = null;
    L16:
        long r100 = 0;
        if ((r110 & 8) != 0) goto L19;
        this.expireDuration = 0;
    L21:
        if ((r110 & 16) != 0) goto L23;
        this.expireTime = 0;
    L25:
        if ((r110 & 32) == 0) goto L28;
        r100 = r116;
    L28:
        this.acquireTime = r100;
        if ((r110 & 64) != 0) goto L31;
        this.isClientPreload = false;
    L33:
        if ((r110 & 128) != 0) goto L35;
        this.logId = null;
    L37:
        if ((r110 & 256) != 0) goto L39;
        this.userId = null;
        return;
    L39:
        this.userId = r212;
        return;
    L35:
        this.logId = r211;
        goto L37
    L31:
        this.isClientPreload = r210;
        goto L33
    L23:
        this.expireTime = r115;
        goto L25
    L19:
        this.expireDuration = r114;
        goto L21
    L15:
        this.token = r113;
        goto L16
    L11:
        this.roomId = r112;
        goto L13
    L7:
        this.appId = r111;
        goto L9
    }

    public /* synthetic */ OMNIAVRTCTokenInfo(String r110, String r111, String r112, long r113, long r114, long r210, boolean r211, String r212, String r213, int r214, DefaultConstructorMarker r215) {
        String r100 = null;
        if ((r214 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r214 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r214 & 4) == 0) goto L13;
        String r103 = null;
    L14:
        long r104 = 0;
        if ((r214 & 8) == 0) goto L17;
        long r105 = 0;
    L19:
        if ((r214 & 16) == 0) goto L21;
        long r115 = 0;
    L23:
        if ((r214 & 32) != 0) goto L27;
        r104 = r210;
    L27:
        if ((r214 & 64) == 0) goto L29;
        boolean r106 = false;
    L31:
        if ((r214 & 128) == 0) goto L33;
        String r116 = null;
    L35:
        if ((r214 & 256) != 0) goto L38;
        r100 = r213;
    L38:
        this(r101, r102, r103, r105, r115, r104, r106, r116, r100);
        return;
    L33:
        r116 = r212;
        goto L35
    L29:
        r106 = r211;
        goto L31
    L21:
        r115 = r114;
        goto L23
    L17:
        r105 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L14
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
