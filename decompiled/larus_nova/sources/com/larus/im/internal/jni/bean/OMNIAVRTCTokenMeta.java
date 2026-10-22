package com.larus.im.internal.jni.bean;

import com.android.ttcjpaysdk.bindcard.base.constants.BindCardPayConfirmConstants;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
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
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 42\u00060\u0001j\u0002`\u0002:\u000234B_\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\r\u0010\u000eBc\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\r\u0010\u0012J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\"\u001a\u00020\u0007HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0004HÆ\u0003Ja\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020\u0007HÖ\u0001J\t\u0010*\u001a\u00020\u0004HÖ\u0001J%\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00002\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0001¢\u0006\u0002\b2R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0015\u0010\u0014R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0016\u0010\u0014R\u0016\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0017\u0010\u0014R\u0016\u0010\t\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0018\u0010\u0014R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0019\u0010\u0014R\u0016\u0010\u000b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001a\u0010\u0014R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001b\u0010\u0014¨\u00065"}, d2 = {"Lcom/larus/im/internal/jni/bean/OMNIAVRTCTokenMeta;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "traceId", "", "logId", "getTokenType", "", DBDefinition.RETRY_COUNT, "statusCode", "statusMessage", "subStatusCode", "subStatusMessage", "<init>", "(Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;ILjava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;IIILjava/lang/String;ILjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTraceId$annotations", "()V", "getLogId$annotations", "getGetTokenType$annotations", "getRetryCount$annotations", "getStatusCode$annotations", "getStatusMessage$annotations", "getSubStatusCode$annotations", "getSubStatusMessage$annotations", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_av_release", "$serializer", "Companion", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OMNIAVRTCTokenMeta implements java.io.Serializable {
    public static final Companion Companion = null;
    public final int getTokenType;
    public final String logId;
    public final int retryCount;
    public final int statusCode;
    public final String statusMessage;
    public final int subStatusCode;
    public final String subStatusMessage;
    public final String traceId;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OMNIAVRTCTokenMeta$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OMNIAVRTCTokenMeta;", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OMNIAVRTCTokenMeta> serializer() {
            return OMNIAVRTCTokenMeta$$serializer.INSTANCE;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OMNIAVRTCTokenMeta() {
        this(null, null, 0, 0, 0, null, 0, null, 255, null);
    }

    public static /* synthetic */ OMNIAVRTCTokenMeta copy$default(OMNIAVRTCTokenMeta r100, String r110, String r111, int r112, int r113, int r114, String r115, int r116, String r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        String r101 = r100.traceId;
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r102 = r100.logId;
    L11:
        if ((r118 & 4) == 0) goto L13;
        int r103 = r100.getTokenType;
    L15:
        if ((r118 & 8) == 0) goto L17;
        int r104 = r100.retryCount;
    L19:
        if ((r118 & 16) == 0) goto L21;
        int r105 = r100.statusCode;
    L23:
        if ((r118 & 32) == 0) goto L25;
        String r106 = r100.statusMessage;
    L27:
        if ((r118 & 64) == 0) goto L29;
        int r107 = r100.subStatusCode;
    L31:
        if ((r118 & 128) == 0) goto L33;
        String r108 = r100.subStatusMessage;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
    L33:
        r108 = r117;
        goto L35
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

    @SerialName("get_token_type")
    public static /* synthetic */ void getGetTokenType$annotations() {
    }

    @SerialName("log_id")
    public static /* synthetic */ void getLogId$annotations() {
    }

    @SerialName("retry_count")
    public static /* synthetic */ void getRetryCount$annotations() {
    }

    @SerialName("status_code")
    public static /* synthetic */ void getStatusCode$annotations() {
    }

    @SerialName("status_message")
    public static /* synthetic */ void getStatusMessage$annotations() {
    }

    @SerialName("sub_status_code")
    public static /* synthetic */ void getSubStatusCode$annotations() {
    }

    @SerialName("sub_status_message")
    public static /* synthetic */ void getSubStatusMessage$annotations() {
    }

    @SerialName(BindCardPayConfirmConstants.Key.TRACE_ID)
    public static /* synthetic */ void getTraceId$annotations() {
    }

    public final String component1() {
        return this.traceId;
    }

    public final String component2() {
        return this.logId;
    }

    public final int component3() {
        return this.getTokenType;
    }

    public final int component4() {
        return this.retryCount;
    }

    public final int component5() {
        return this.statusCode;
    }

    public final String component6() {
        return this.statusMessage;
    }

    public final int component7() {
        return this.subStatusCode;
    }

    public final String component8() {
        return this.subStatusMessage;
    }

    public final OMNIAVRTCTokenMeta copy(String r110, String r111, int r112, int r113, int r114, String r115, int r116, String r117) {
        return new OMNIAVRTCTokenMeta(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OMNIAVRTCTokenMeta) == true) goto L8;
        return false;
    L8:
        OMNIAVRTCTokenMeta r101 = (OMNIAVRTCTokenMeta) r100;
        if (Intrinsics.areEqual(this.traceId, r101.traceId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.logId, r101.logId) == true) goto L15;
        return false;
    L15:
        if (this.getTokenType == r101.getTokenType) goto L18;
        return false;
    L18:
        if (this.retryCount == r101.retryCount) goto L21;
        return false;
    L21:
        if (this.statusCode == r101.statusCode) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.statusMessage, r101.statusMessage) == true) goto L27;
        return false;
    L27:
        if (this.subStatusCode == r101.subStatusCode) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.subStatusMessage, r101.subStatusMessage) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        String r100 = this.traceId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.logId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (((((((r103 + r105) * 31) + this.getTokenType) * 31) + this.retryCount) * 31) + this.statusCode) * 31;
        String r107 = this.statusMessage;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (((r106 + r108) * 31) + this.subStatusCode) * 31;
        String r110 = this.subStatusMessage;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
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
        return "OMNIAVRTCTokenMeta(traceId=" + this.traceId + ", logId=" + this.logId + ", getTokenType=" + this.getTokenType + ", retryCount=" + this.retryCount + ", statusCode=" + this.statusCode + ", statusMessage=" + this.statusMessage + ", subStatusCode=" + this.subStatusCode + ", subStatusMessage=" + this.subStatusMessage + ')';
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_av_release(OMNIAVRTCTokenMeta r100, muc.d r101, f r102) {
        boolean r103 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, v2.f520790a, r100.traceId);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r105 = true;
    L18:
        if (r105 == false) goto L21;
        r101.encodeNullableSerializableElement(r102, 1, v2.f520790a, r100.logId);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r106 = true;
    L27:
        if (r106 == false) goto L30;
        r101.encodeIntElement(r102, 2, r100.getTokenType);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        boolean r107 = true;
    L36:
        if (r107 == false) goto L39;
        r101.encodeIntElement(r102, 3, r100.retryCount);
    L39:
        if (r101.shouldEncodeElementDefault(r102, 4) == false) goto L42;
    L40:
        boolean r108 = true;
    L45:
        if (r108 == false) goto L48;
        r101.encodeIntElement(r102, 4, r100.statusCode);
    L48:
        if (r101.shouldEncodeElementDefault(r102, 5) == false) goto L51;
    L49:
        boolean r109 = true;
    L54:
        if (r109 == false) goto L57;
        r101.encodeNullableSerializableElement(r102, 5, v2.f520790a, r100.statusMessage);
    L57:
        if (r101.shouldEncodeElementDefault(r102, 6) == false) goto L60;
    L58:
        boolean r110 = true;
    L63:
        if (r110 == false) goto L66;
        r101.encodeIntElement(r102, 6, r100.subStatusCode);
    L66:
        if (r101.shouldEncodeElementDefault(r102, 7) == false) goto L69;
    L67:
        r103 = true;
    L71:
        if (r103 == false) goto L74;
        r101.encodeNullableSerializableElement(r102, 7, v2.f520790a, r100.subStatusMessage);
        return;
    L74:
        return;
    L69:
        if (r100.subStatusMessage == null) goto L71;
    L60:
        if (r100.subStatusCode != 0) goto L58;
        r110 = false;
        goto L63
    L51:
        if (r100.statusMessage != null) goto L49;
        r109 = false;
        goto L54
    L42:
        if (r100.statusCode != 0) goto L40;
        r108 = false;
        goto L45
    L33:
        if (r100.retryCount != 0) goto L31;
        r107 = false;
        goto L36
    L24:
        if (r100.getTokenType != 0) goto L22;
        r106 = false;
        goto L27
    L15:
        if (r100.logId != null) goto L13;
        r105 = false;
        goto L18
    L6:
        if (r100.traceId != null) goto L4;
        r104 = false;
        goto L9
    }

    public OMNIAVRTCTokenMeta(String r100, String r101, int r102, int r103, int r104, String r105, int r106, String r107) {
        this.traceId = r100;
        this.logId = r101;
        this.getTokenType = r102;
        this.retryCount = r103;
        this.statusCode = r104;
        this.statusMessage = r105;
        this.subStatusCode = r106;
        this.subStatusMessage = r107;
    }

    public /* synthetic */ OMNIAVRTCTokenMeta(int r100, String r101, String r102, int r103, int r104, int r105, String r106, int r110, String r111, q2 r112) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, OMNIAVRTCTokenMeta$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.traceId = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.logId = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.getTokenType = 0;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.retryCount = 0;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.statusCode = 0;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.statusMessage = null;
    L29:
        if ((r100 & 64) != 0) goto L31;
        this.subStatusCode = 0;
    L33:
        if ((r100 & 128) != 0) goto L35;
        this.subStatusMessage = null;
        return;
    L35:
        this.subStatusMessage = r111;
        return;
    L31:
        this.subStatusCode = r110;
        goto L33
    L27:
        this.statusMessage = r106;
        goto L29
    L23:
        this.statusCode = r105;
        goto L25
    L19:
        this.retryCount = r104;
        goto L21
    L15:
        this.getTokenType = r103;
        goto L17
    L11:
        this.logId = r102;
        goto L13
    L7:
        this.traceId = r101;
        goto L9
    }

    public /* synthetic */ OMNIAVRTCTokenMeta(String r110, String r111, int r112, int r113, int r114, String r115, int r116, String r117, int r118, DefaultConstructorMarker r210) {
        String r100 = null;
        if ((r118 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r102 = null;
    L10:
        int r103 = 0;
        if ((r118 & 4) == 0) goto L13;
        int r104 = 0;
    L15:
        if ((r118 & 8) == 0) goto L17;
        int r105 = 0;
    L19:
        if ((r118 & 16) == 0) goto L21;
        int r106 = 0;
    L23:
        if ((r118 & 32) == 0) goto L25;
        String r107 = null;
    L27:
        if ((r118 & 64) != 0) goto L31;
        r103 = r116;
    L31:
        if ((r118 & 128) != 0) goto L34;
        r100 = r117;
    L34:
        this(r101, r102, r104, r105, r106, r107, r103, r100);
        return;
    L25:
        r107 = r115;
        goto L27
    L21:
        r106 = r114;
        goto L23
    L17:
        r105 = r113;
        goto L19
    L13:
        r104 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L10
    L5:
        r101 = r110;
        goto L7
    }
}
