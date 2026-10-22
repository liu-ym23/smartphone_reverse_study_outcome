package com.larus.im.internal.jni.bean;

import androidx.core.app.NotificationCompat;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
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
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 B2\u00060\u0001j\u0002`\u0002:\u0002ABB\u0087\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0010\u001a\u00020\f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\f¢\u0006\u0004\b\u0013\u0010\u0014B\u0083\u0001\b\u0010\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0010\u001a\u00020\f\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\u0006\u0010\u0012\u001a\u00020\f\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u0013\u0010\u0019J\u000b\u0010'\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010)\u001a\u00020\bHÆ\u0003J\t\u0010*\u001a\u00020\bHÆ\u0003J\t\u0010+\u001a\u00020\bHÆ\u0003J\t\u0010,\u001a\u00020\fHÆ\u0003J\t\u0010-\u001a\u00020\fHÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u00100\u001a\u00020\fHÆ\u0003J\t\u00101\u001a\u00020\fHÆ\u0003J\t\u00102\u001a\u00020\fHÆ\u0003J\u0089\u0001\u00103\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0010\u001a\u00020\f2\b\b\u0002\u0010\u0011\u001a\u00020\f2\b\b\u0002\u0010\u0012\u001a\u00020\fHÆ\u0001J\u0013\u00104\u001a\u00020\b2\b\u00105\u001a\u0004\u0018\u000106HÖ\u0003J\t\u00107\u001a\u00020\u0016HÖ\u0001J\t\u00108\u001a\u00020\u0004HÖ\u0001J%\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u00002\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?H\u0001¢\u0006\u0002\b@R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001a\u0010\u001bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001c\u0010\u001bR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001d\u0010\u001bR\u0016\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001e\u0010\u001bR\u0016\u0010\n\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001f\u0010\u001bR\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b \u0010\u001bR\u0016\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b!\u0010\u001bR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\"\u0010\u001bR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b#\u0010\u001bR\u0016\u0010\u0010\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b$\u0010\u001bR\u0016\u0010\u0011\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b%\u0010\u001bR\u0016\u0010\u0012\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b&\u0010\u001b¨\u0006C"}, d2 = {"Lcom/larus/im/internal/jni/bean/OMNIAVFrameExt;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "extra", "", "type", "Lcom/larus/im/internal/jni/bean/OMNIStreamType;", NotificationCompat.GROUP_KEY_SILENT, "", "muted", "isFirstPkg", "status", "", "queryRound", DBDefinition.TASK_ID, "replyRound", "timestamp", "downlinkProcessStartTimestampMs", "downlinkProcessEndTimestampMs", "<init>", "(Ljava/lang/String;Lcom/larus/im/internal/jni/bean/OMNIStreamType;ZZZJJLjava/lang/String;Ljava/lang/String;JJJ)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lcom/larus/im/internal/jni/bean/OMNIStreamType;ZZZJJLjava/lang/String;Ljava/lang/String;JJJLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getExtra$annotations", "()V", "getType$annotations", "getSilent$annotations", "getMuted$annotations", "isFirstPkg$annotations", "getStatus$annotations", "getQueryRound$annotations", "getTaskId$annotations", "getReplyRound$annotations", "getTimestamp$annotations", "getDownlinkProcessStartTimestampMs$annotations", "getDownlinkProcessEndTimestampMs$annotations", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_av_release", "$serializer", "Companion", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OMNIAVFrameExt implements java.io.Serializable {
    public static final Companion Companion = null;
    public final long downlinkProcessEndTimestampMs;
    public final long downlinkProcessStartTimestampMs;
    public final String extra;
    public final boolean isFirstPkg;
    public final boolean muted;
    public final long queryRound;
    public final String replyRound;
    public final boolean silent;
    public final long status;
    public final String taskId;
    public final long timestamp;
    public final OMNIStreamType type;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OMNIAVFrameExt$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OMNIAVFrameExt;", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OMNIAVFrameExt> serializer() {
            return OMNIAVFrameExt$$serializer.INSTANCE;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OMNIAVFrameExt() {
        this(null, null, false, false, false, 0, 0, null, null, 0, 0, 0, UnixStat.PERM_MASK, null);
    }

    public static /* synthetic */ OMNIAVFrameExt copy$default(OMNIAVFrameExt r110, String r111, OMNIStreamType r112, boolean r113, boolean r210, boolean r211, long r212, long r213, String r214, String r215, long r216, long r310, long r311, int r312, Object r313) {
        if ((r312 & 1) == 0) goto L5;
        String r100 = r110.extra;
    L7:
        if ((r312 & 2) == 0) goto L9;
        OMNIStreamType r101 = r110.type;
    L11:
        if ((r312 & 4) == 0) goto L13;
        boolean r102 = r110.silent;
    L15:
        if ((r312 & 8) == 0) goto L17;
        boolean r103 = r110.muted;
    L19:
        if ((r312 & 16) == 0) goto L21;
        boolean r104 = r110.isFirstPkg;
    L23:
        if ((r312 & 32) == 0) goto L25;
        long r105 = r110.status;
    L27:
        if ((r312 & 64) == 0) goto L29;
        long r106 = r110.queryRound;
    L31:
        if ((r312 & 128) == 0) goto L33;
        String r114 = r110.taskId;
    L35:
        if ((r312 & 256) == 0) goto L37;
        String r115 = r110.replyRound;
    L39:
        if ((r312 & 512) == 0) goto L41;
        long r116 = r110.timestamp;
    L42:
        long r217 = r116;
        if ((r312 & 1024) == 0) goto L45;
        long r117 = r110.downlinkProcessStartTimestampMs;
    L46:
        long r314 = r117;
        if ((r312 & 2048) == 0) goto L49;
        long r118 = r110.downlinkProcessEndTimestampMs;
    L51:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r114, r115, r217, r314, r118);
    L49:
        r118 = r311;
        goto L51
    L45:
        r117 = r310;
        goto L46
    L41:
        r116 = r216;
        goto L42
    L37:
        r115 = r215;
        goto L39
    L33:
        r114 = r214;
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

    @SerialName("downlink_process_end_timestamp_ms")
    public static /* synthetic */ void getDownlinkProcessEndTimestampMs$annotations() {
    }

    @SerialName("downlink_process_start_timestamp_ms")
    public static /* synthetic */ void getDownlinkProcessStartTimestampMs$annotations() {
    }

    @SerialName("extra")
    public static /* synthetic */ void getExtra$annotations() {
    }

    @SerialName("muted")
    public static /* synthetic */ void getMuted$annotations() {
    }

    @SerialName("query_round")
    public static /* synthetic */ void getQueryRound$annotations() {
    }

    @SerialName("reply_round")
    public static /* synthetic */ void getReplyRound$annotations() {
    }

    @SerialName(NotificationCompat.GROUP_KEY_SILENT)
    public static /* synthetic */ void getSilent$annotations() {
    }

    @SerialName("status")
    public static /* synthetic */ void getStatus$annotations() {
    }

    @SerialName("task_id")
    public static /* synthetic */ void getTaskId$annotations() {
    }

    @SerialName("timestamp")
    public static /* synthetic */ void getTimestamp$annotations() {
    }

    @SerialName("type")
    public static /* synthetic */ void getType$annotations() {
    }

    @SerialName("isFirstPkg")
    public static /* synthetic */ void isFirstPkg$annotations() {
    }

    public final String component1() {
        return this.extra;
    }

    public final long component10() {
        return this.timestamp;
    }

    public final long component11() {
        return this.downlinkProcessStartTimestampMs;
    }

    public final long component12() {
        return this.downlinkProcessEndTimestampMs;
    }

    public final OMNIStreamType component2() {
        return this.type;
    }

    public final boolean component3() {
        return this.silent;
    }

    public final boolean component4() {
        return this.muted;
    }

    public final boolean component5() {
        return this.isFirstPkg;
    }

    public final long component6() {
        return this.status;
    }

    public final long component7() {
        return this.queryRound;
    }

    public final String component8() {
        return this.taskId;
    }

    public final String component9() {
        return this.replyRound;
    }

    public final OMNIAVFrameExt copy(String r210, OMNIStreamType r211, boolean r212, boolean r213, boolean r214, long r215, long r216, String r217, String r310, long r311, long r312, long r313) {
        return new OMNIAVFrameExt(r210, r211, r212, r213, r214, r215, r216, r217, r310, r311, r312, r313);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OMNIAVFrameExt) == true) goto L8;
        return false;
    L8:
        OMNIAVFrameExt r101 = (OMNIAVFrameExt) r100;
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L15;
        return false;
    L15:
        if (this.silent == r101.silent) goto L18;
        return false;
    L18:
        if (this.muted == r101.muted) goto L21;
        return false;
    L21:
        if (this.isFirstPkg == r101.isFirstPkg) goto L24;
        return false;
    L24:
        if (this.status == r101.status) goto L27;
        return false;
    L27:
        if (this.queryRound == r101.queryRound) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.taskId, r101.taskId) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.replyRound, r101.replyRound) == true) goto L36;
        return false;
    L36:
        if (this.timestamp == r101.timestamp) goto L39;
        return false;
    L39:
        if (this.downlinkProcessStartTimestampMs == r101.downlinkProcessStartTimestampMs) goto L42;
        return false;
    L42:
        if (this.downlinkProcessEndTimestampMs == r101.downlinkProcessEndTimestampMs) goto L44;
        return false;
    L44:
        return true;
    }

    public int hashCode() {
        String r100 = this.extra;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        OMNIStreamType r104 = this.type;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        int r107 = 1231;
        if (this.silent == false) goto L13;
        int r108 = 1231;
    L14:
        int r109 = (r106 + r108) * 31;
        if (this.muted == false) goto L17;
        int r110 = 1231;
    L18:
        int r111 = (r109 + r110) * 31;
        if (this.isFirstPkg == true) goto L22;
        r107 = 1237;
    L22:
        long r112 = this.status;
        int r113 = (((r111 + r107) * 31) + ((int) (r112 ^ (r112 >>> 32)))) * 31;
        long r114 = this.queryRound;
        int r115 = (r113 + ((int) (r114 ^ (r114 >>> 32)))) * 31;
        String r116 = this.taskId;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.replyRound;
        if (r119 == null) goto L30;
        r101 = r119.hashCode();
    L30:
        int r120 = (r118 + r101) * 31;
        long r121 = this.timestamp;
        int r122 = (r120 + ((int) (r121 ^ (r121 >>> 32)))) * 31;
        long r123 = this.downlinkProcessStartTimestampMs;
        int r124 = (r122 + ((int) (r123 ^ (r123 >>> 32)))) * 31;
        long r125 = this.downlinkProcessEndTimestampMs;
        return r124 + ((int) (r125 ^ (r125 >>> 32)));
    L25:
        r117 = r116.hashCode();
        goto L26
    L17:
        r110 = 1237;
        goto L18
    L13:
        r108 = 1237;
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "OMNIAVFrameExt(extra=" + this.extra + ", type=" + this.type + ", silent=" + this.silent + ", muted=" + this.muted + ", isFirstPkg=" + this.isFirstPkg + ", status=" + this.status + ", queryRound=" + this.queryRound + ", taskId=" + this.taskId + ", replyRound=" + this.replyRound + ", timestamp=" + this.timestamp + ", downlinkProcessStartTimestampMs=" + this.downlinkProcessStartTimestampMs + ", downlinkProcessEndTimestampMs=" + this.downlinkProcessEndTimestampMs + ')';
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_av_release(OMNIAVFrameExt r100, muc.d r101, f r110) {
        boolean r102 = false;
        if (r101.shouldEncodeElementDefault(r110, 0) == false) goto L6;
    L4:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L12;
        r101.encodeNullableSerializableElement(r110, 0, v2.f520790a, r100.extra);
    L12:
        if (r101.shouldEncodeElementDefault(r110, 1) == false) goto L15;
    L13:
        boolean r104 = true;
    L18:
        if (r104 == false) goto L21;
        r101.encodeNullableSerializableElement(r110, 1, OMNIStreamType$$serializer.INSTANCE, r100.type);
    L21:
        if (r101.shouldEncodeElementDefault(r110, 2) == false) goto L24;
    L22:
        boolean r105 = true;
    L27:
        if (r105 == false) goto L30;
        r101.encodeBooleanElement(r110, 2, r100.silent);
    L30:
        if (r101.shouldEncodeElementDefault(r110, 3) == false) goto L33;
    L31:
        boolean r106 = true;
    L36:
        if (r106 == false) goto L39;
        r101.encodeBooleanElement(r110, 3, r100.muted);
    L39:
        if (r101.shouldEncodeElementDefault(r110, 4) == false) goto L42;
    L40:
        boolean r107 = true;
    L45:
        if (r107 == false) goto L48;
        r101.encodeBooleanElement(r110, 4, r100.isFirstPkg);
    L48:
        if (r101.shouldEncodeElementDefault(r110, 5) == false) goto L51;
    L49:
        boolean r108 = true;
    L54:
        if (r108 == false) goto L57;
        r101.encodeLongElement(r110, 5, r100.status);
    L57:
        if (r101.shouldEncodeElementDefault(r110, 6) == false) goto L60;
    L58:
        boolean r109 = true;
    L63:
        if (r109 == false) goto L66;
        r101.encodeLongElement(r110, 6, r100.queryRound);
    L66:
        if (r101.shouldEncodeElementDefault(r110, 7) == false) goto L69;
    L67:
        boolean r111 = true;
    L72:
        if (r111 == false) goto L75;
        r101.encodeNullableSerializableElement(r110, 7, v2.f520790a, r100.taskId);
    L75:
        if (r101.shouldEncodeElementDefault(r110, 8) == false) goto L78;
    L76:
        boolean r112 = true;
    L81:
        if (r112 == false) goto L84;
        r101.encodeNullableSerializableElement(r110, 8, v2.f520790a, r100.replyRound);
    L84:
        if (r101.shouldEncodeElementDefault(r110, 9) == false) goto L87;
    L85:
        boolean r113 = true;
    L90:
        if (r113 == false) goto L93;
        r101.encodeLongElement(r110, 9, r100.timestamp);
    L93:
        if (r101.shouldEncodeElementDefault(r110, 10) == false) goto L96;
    L94:
        boolean r114 = true;
    L99:
        if (r114 == false) goto L102;
        r101.encodeLongElement(r110, 10, r100.downlinkProcessStartTimestampMs);
    L102:
        if (r101.shouldEncodeElementDefault(r110, 11) == false) goto L105;
    L103:
        r102 = true;
    L107:
        if (r102 == false) goto L110;
        r101.encodeLongElement(r110, 11, r100.downlinkProcessEndTimestampMs);
        return;
    L110:
        return;
    L105:
        if (r100.downlinkProcessEndTimestampMs == 0) goto L107;
    L96:
        if (r100.downlinkProcessStartTimestampMs != 0) goto L94;
        r114 = false;
        goto L99
    L87:
        if (r100.timestamp != 0) goto L85;
        r113 = false;
        goto L90
    L78:
        if (r100.replyRound != null) goto L76;
        r112 = false;
        goto L81
    L69:
        if (r100.taskId != null) goto L67;
        r111 = false;
        goto L72
    L60:
        if (r100.queryRound != 0) goto L58;
        r109 = false;
        goto L63
    L51:
        if (r100.status != 0) goto L49;
        r108 = false;
        goto L54
    L42:
        if (r100.isFirstPkg == true) goto L40;
        r107 = false;
        goto L45
    L33:
        if (r100.muted == true) goto L31;
        r106 = false;
        goto L36
    L24:
        if (r100.silent == true) goto L22;
        r105 = false;
        goto L27
    L15:
        if (r100.type != null) goto L13;
        r104 = false;
        goto L18
    L6:
        if (r100.extra != null) goto L4;
        r103 = false;
        goto L9
    }

    public OMNIAVFrameExt(String r100, OMNIStreamType r101, boolean r102, boolean r103, boolean r104, long r105, long r110, String r111, String r112, long r113, long r114, long r115) {
        this.extra = r100;
        this.type = r101;
        this.silent = r102;
        this.muted = r103;
        this.isFirstPkg = r104;
        this.status = r105;
        this.queryRound = r110;
        this.taskId = r111;
        this.replyRound = r112;
        this.timestamp = r113;
        this.downlinkProcessStartTimestampMs = r114;
        this.downlinkProcessEndTimestampMs = r115;
    }

    public /* synthetic */ OMNIAVFrameExt(int r100, String r110, OMNIStreamType r111, boolean r112, boolean r113, boolean r114, long r115, long r116, String r117, String r210, long r211, long r212, long r213, q2 r214) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, OMNIAVFrameExt$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.extra = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.type = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.silent = false;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.muted = false;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.isFirstPkg = false;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.status = 0;
    L29:
        if ((r100 & 64) != 0) goto L31;
        this.queryRound = 0;
    L33:
        if ((r100 & 128) != 0) goto L35;
        this.taskId = null;
    L37:
        if ((r100 & 256) != 0) goto L39;
        this.replyRound = null;
    L41:
        if ((r100 & 512) != 0) goto L43;
        this.timestamp = 0;
    L45:
        if ((r100 & 1024) != 0) goto L47;
        this.downlinkProcessStartTimestampMs = 0;
    L49:
        if ((r100 & 2048) != 0) goto L51;
        this.downlinkProcessEndTimestampMs = 0;
        return;
    L51:
        this.downlinkProcessEndTimestampMs = r213;
        return;
    L47:
        this.downlinkProcessStartTimestampMs = r212;
        goto L49
    L43:
        this.timestamp = r211;
        goto L45
    L39:
        this.replyRound = r210;
        goto L41
    L35:
        this.taskId = r117;
        goto L37
    L31:
        this.queryRound = r116;
        goto L33
    L27:
        this.status = r115;
        goto L29
    L23:
        this.isFirstPkg = r114;
        goto L25
    L19:
        this.muted = r113;
        goto L21
    L15:
        this.silent = r112;
        goto L17
    L11:
        this.type = r111;
        goto L13
    L7:
        this.extra = r110;
        goto L9
    }

    public /* synthetic */ OMNIAVFrameExt(String r110, OMNIStreamType r210, boolean r211, boolean r212, boolean r213, long r214, long r215, String r216, String r217, long r310, long r311, long r312, int r313, DefaultConstructorMarker r314) {
        String r100 = null;
        if ((r313 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r313 & 2) == 0) goto L9;
        OMNIStreamType r102 = null;
    L10:
        boolean r103 = false;
        if ((r313 & 4) == 0) goto L13;
        boolean r104 = false;
    L15:
        if ((r313 & 8) == 0) goto L17;
        boolean r105 = false;
    L19:
        if ((r313 & 16) != 0) goto L23;
        r103 = r213;
    L23:
        if ((r313 & 32) == 0) goto L25;
        long r111 = 0;
    L27:
        if ((r313 & 64) == 0) goto L29;
        long r112 = 0;
    L31:
        if ((r313 & 128) == 0) goto L33;
        String r106 = null;
    L35:
        if ((r313 & 256) != 0) goto L39;
        r100 = r217;
    L39:
        if ((r313 & 512) == 0) goto L41;
        long r113 = 0;
    L43:
        if ((r313 & 1024) == 0) goto L45;
        long r107 = 0;
    L47:
        if ((r313 & 2048) == 0) goto L49;
        long r114 = 0;
    L50:
        this(r101, r102, r104, r105, r103, r111, r112, r106, r100, r113, r107, r114);
        return;
    L49:
        r114 = r312;
        goto L50
    L45:
        r107 = r311;
        goto L47
    L41:
        r113 = r310;
        goto L43
    L33:
        r106 = r216;
        goto L35
    L29:
        r112 = r215;
        goto L31
    L25:
        r111 = r214;
        goto L27
    L17:
        r105 = r212;
        goto L19
    L13:
        r104 = r211;
        goto L15
    L9:
        r102 = r210;
        goto L10
    L5:
        r101 = r110;
        goto L7
    }
}
