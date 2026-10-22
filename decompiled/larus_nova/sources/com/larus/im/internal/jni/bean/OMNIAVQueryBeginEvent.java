package com.larus.im.internal.jni.bean;

import com.bytedance.android.ec.core.event.a;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
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
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 /2\u00060\u0001j\u0002`\u0002:\u0002./BI\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rBQ\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\f\u0010\u0012J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u001f\u001a\u00020\u000bHÆ\u0003JK\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010!\u001a\u00020\u000b2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\u000fHÖ\u0001J\t\u0010%\u001a\u00020\u0004HÖ\u0001J%\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00002\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0001¢\u0006\u0002\b-R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0015\u0010\u0014R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0016\u0010\u0014R\u0016\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0017\u0010\u0014R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0018\u0010\u0014R\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0019\u0010\u0014¨\u00060"}, d2 = {"Lcom/larus/im/internal/jni/bean/OMNIAVQueryBeginEvent;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "questionId", "", "asrTaskId", "roundId", "", "startListenTimestampMs", "localMessageId", "continueTts", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;Z)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;JJLjava/lang/String;ZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getQuestionId$annotations", "()V", "getAsrTaskId$annotations", "getRoundId$annotations", "getStartListenTimestampMs$annotations", "getLocalMessageId$annotations", "getContinueTts$annotations", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_av_release", "$serializer", "Companion", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OMNIAVQueryBeginEvent implements java.io.Serializable {
    public static final Companion Companion = null;
    public final String asrTaskId;
    public final boolean continueTts;
    public final String localMessageId;
    public final String questionId;
    public final long roundId;
    public final long startListenTimestampMs;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OMNIAVQueryBeginEvent$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OMNIAVQueryBeginEvent;", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OMNIAVQueryBeginEvent> serializer() {
            return OMNIAVQueryBeginEvent$$serializer.INSTANCE;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OMNIAVQueryBeginEvent() {
        this(null, null, 0, 0, null, false, 63, null);
    }

    public static /* synthetic */ OMNIAVQueryBeginEvent copy$default(OMNIAVQueryBeginEvent r100, String r110, String r111, long r112, long r113, String r114, boolean r115, int r116, Object r117) {
        if ((r116 & 1) == 0) goto L5;
        String r101 = r100.questionId;
    L7:
        if ((r116 & 2) == 0) goto L9;
        String r102 = r100.asrTaskId;
    L11:
        if ((r116 & 4) == 0) goto L13;
        long r103 = r100.roundId;
    L15:
        if ((r116 & 8) == 0) goto L17;
        long r104 = r100.startListenTimestampMs;
    L19:
        if ((r116 & 16) == 0) goto L21;
        String r105 = r100.localMessageId;
    L23:
        if ((r116 & 32) == 0) goto L25;
        boolean r106 = r100.continueTts;
    L27:
        return r100.copy(r101, r102, r103, r104, r105, r106);
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

    @SerialName("asr_task_id")
    public static /* synthetic */ void getAsrTaskId$annotations() {
    }

    @SerialName("continue_tts")
    public static /* synthetic */ void getContinueTts$annotations() {
    }

    @SerialName("local_message_id")
    public static /* synthetic */ void getLocalMessageId$annotations() {
    }

    @SerialName(a.KEY_QUESTION_ID)
    public static /* synthetic */ void getQuestionId$annotations() {
    }

    @SerialName("round_id")
    public static /* synthetic */ void getRoundId$annotations() {
    }

    @SerialName("start_listen_timestamp_ms")
    public static /* synthetic */ void getStartListenTimestampMs$annotations() {
    }

    public final String component1() {
        return this.questionId;
    }

    public final String component2() {
        return this.asrTaskId;
    }

    public final long component3() {
        return this.roundId;
    }

    public final long component4() {
        return this.startListenTimestampMs;
    }

    public final String component5() {
        return this.localMessageId;
    }

    public final boolean component6() {
        return this.continueTts;
    }

    public final OMNIAVQueryBeginEvent copy(String r110, String r111, long r112, long r113, String r114, boolean r115) {
        return new OMNIAVQueryBeginEvent(r110, r111, r112, r113, r114, r115);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OMNIAVQueryBeginEvent) == true) goto L8;
        return false;
    L8:
        OMNIAVQueryBeginEvent r101 = (OMNIAVQueryBeginEvent) r100;
        if (Intrinsics.areEqual(this.questionId, r101.questionId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.asrTaskId, r101.asrTaskId) == true) goto L15;
        return false;
    L15:
        if (this.roundId == r101.roundId) goto L18;
        return false;
    L18:
        if (this.startListenTimestampMs == r101.startListenTimestampMs) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.localMessageId, r101.localMessageId) == true) goto L24;
        return false;
    L24:
        if (this.continueTts == r101.continueTts) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        String r100 = this.questionId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.asrTaskId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        long r107 = this.roundId;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        long r109 = this.startListenTimestampMs;
        int r110 = (r108 + ((int) (r109 ^ (r109 >>> 32)))) * 31;
        String r111 = this.localMessageId;
        if (r111 == null) goto L14;
        r101 = r111.hashCode();
    L14:
        int r112 = (r110 + r101) * 31;
        if (this.continueTts == false) goto L17;
        int r113 = 1231;
    L19:
        return r112 + r113;
    L17:
        r113 = 1237;
        goto L19
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "OMNIAVQueryBeginEvent(questionId=" + this.questionId + ", asrTaskId=" + this.asrTaskId + ", roundId=" + this.roundId + ", startListenTimestampMs=" + this.startListenTimestampMs + ", localMessageId=" + this.localMessageId + ", continueTts=" + this.continueTts + ')';
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_av_release(OMNIAVQueryBeginEvent r100, muc.d r101, f r110) {
        boolean r102 = false;
        if (r101.shouldEncodeElementDefault(r110, 0) == false) goto L6;
    L4:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L12;
        r101.encodeNullableSerializableElement(r110, 0, v2.f520790a, r100.questionId);
    L12:
        if (r101.shouldEncodeElementDefault(r110, 1) == false) goto L15;
    L13:
        boolean r104 = true;
    L18:
        if (r104 == false) goto L21;
        r101.encodeNullableSerializableElement(r110, 1, v2.f520790a, r100.asrTaskId);
    L21:
        if (r101.shouldEncodeElementDefault(r110, 2) == false) goto L24;
    L22:
        boolean r105 = true;
    L27:
        if (r105 == false) goto L30;
        r101.encodeLongElement(r110, 2, r100.roundId);
    L30:
        if (r101.shouldEncodeElementDefault(r110, 3) == false) goto L33;
    L31:
        boolean r106 = true;
    L36:
        if (r106 == false) goto L39;
        r101.encodeLongElement(r110, 3, r100.startListenTimestampMs);
    L39:
        if (r101.shouldEncodeElementDefault(r110, 4) == false) goto L42;
    L40:
        boolean r107 = true;
    L45:
        if (r107 == false) goto L48;
        r101.encodeNullableSerializableElement(r110, 4, v2.f520790a, r100.localMessageId);
    L48:
        if (r101.shouldEncodeElementDefault(r110, 5) == false) goto L51;
    L49:
        r102 = true;
    L53:
        if (r102 == false) goto L56;
        r101.encodeBooleanElement(r110, 5, r100.continueTts);
        return;
    L56:
        return;
    L51:
        if (r100.continueTts == false) goto L53;
    L42:
        if (r100.localMessageId != null) goto L40;
        r107 = false;
        goto L45
    L33:
        if (r100.startListenTimestampMs != 0) goto L31;
        r106 = false;
        goto L36
    L24:
        if (r100.roundId != 0) goto L22;
        r105 = false;
        goto L27
    L15:
        if (r100.asrTaskId != null) goto L13;
        r104 = false;
        goto L18
    L6:
        if (r100.questionId != null) goto L4;
        r103 = false;
        goto L9
    }

    public OMNIAVQueryBeginEvent(String r100, String r101, long r102, long r103, String r104, boolean r105) {
        this.questionId = r100;
        this.asrTaskId = r101;
        this.roundId = r102;
        this.startListenTimestampMs = r103;
        this.localMessageId = r104;
        this.continueTts = r105;
    }

    public /* synthetic */ OMNIAVQueryBeginEvent(int r100, String r101, String r102, long r103, long r110, String r111, boolean r112, q2 r113) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, OMNIAVQueryBeginEvent$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.questionId = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.asrTaskId = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.roundId = 0;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.startListenTimestampMs = 0;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.localMessageId = null;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.continueTts = false;
        return;
    L27:
        this.continueTts = r112;
        return;
    L23:
        this.localMessageId = r111;
        goto L25
    L19:
        this.startListenTimestampMs = r110;
        goto L21
    L15:
        this.roundId = r103;
        goto L17
    L11:
        this.asrTaskId = r102;
        goto L13
    L7:
        this.questionId = r101;
        goto L9
    }

    public /* synthetic */ OMNIAVQueryBeginEvent(String r100, String r110, long r111, long r112, String r113, boolean r114, int r115, DefaultConstructorMarker r116) {
        String r101 = null;
        if ((r115 & 1) == 0) goto L5;
        String r102 = null;
    L7:
        if ((r115 & 2) == 0) goto L9;
        String r103 = null;
    L10:
        long r104 = 0;
        if ((r115 & 4) == 0) goto L13;
        long r105 = 0;
    L15:
        if ((r115 & 8) != 0) goto L19;
        r104 = r112;
    L19:
        if ((r115 & 16) != 0) goto L23;
        r101 = r113;
    L23:
        if ((r115 & 32) == 0) goto L25;
        boolean r106 = false;
    L26:
        this(r102, r103, r105, r104, r101, r106);
        return;
    L25:
        r106 = r114;
        goto L26
    L13:
        r105 = r111;
        goto L15
    L9:
        r103 = r110;
        goto L10
    L5:
        r102 = r100;
        goto L7
    }
}
