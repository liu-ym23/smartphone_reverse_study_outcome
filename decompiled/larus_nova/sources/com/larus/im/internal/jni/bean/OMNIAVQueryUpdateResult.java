package com.larus.im.internal.jni.bean;

import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.ss.android.dypay.api.DyPayConstant;
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
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ,2\u00060\u0001j\u0002`\u0002:\u0002+,B=\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000b\u0010\fBG\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u000b\u0010\u0011J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0004HÆ\u0003J?\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u000eHÖ\u0001J\t\u0010\"\u001a\u00020\u0004HÖ\u0001J%\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0001¢\u0006\u0002\b*R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0014\u0010\u0013R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0015\u0010\u0013R\u0016\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0016\u0010\u0013R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0017\u0010\u0013¨\u0006-"}, d2 = {"Lcom/larus/im/internal/jni/bean/OMNIAVQueryUpdateResult;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "text", "", "isInterim", "", DyPayConstant.KEY_START_TIME, "", "endTime", "asrTaskId", "<init>", "(Ljava/lang/String;ZFFLjava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;ZFFLjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getText$annotations", "()V", "isInterim$annotations", "getStartTime$annotations", "getEndTime$annotations", "getAsrTaskId$annotations", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_av_release", "$serializer", "Companion", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OMNIAVQueryUpdateResult implements java.io.Serializable {
    public static final Companion Companion = null;
    public final String asrTaskId;
    public final float endTime;
    public final boolean isInterim;
    public final float startTime;
    public final String text;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OMNIAVQueryUpdateResult$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OMNIAVQueryUpdateResult;", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OMNIAVQueryUpdateResult> serializer() {
            return OMNIAVQueryUpdateResult$$serializer.INSTANCE;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OMNIAVQueryUpdateResult() {
        this(null, false, 0.0f, 0.0f, null, 31, null);
    }

    public static /* synthetic */ OMNIAVQueryUpdateResult copy$default(OMNIAVQueryUpdateResult r100, String r101, boolean r102, float r103, float r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.text;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.isInterim;
    L8:
        boolean r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.startTime;
    L11:
        float r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.endTime;
    L14:
        float r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.asrTaskId;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    @SerialName("asr_task_id")
    public static /* synthetic */ void getAsrTaskId$annotations() {
    }

    @SerialName("end_time")
    public static /* synthetic */ void getEndTime$annotations() {
    }

    @SerialName(ILoadStallMonitor.START_TIME)
    public static /* synthetic */ void getStartTime$annotations() {
    }

    @SerialName("text")
    public static /* synthetic */ void getText$annotations() {
    }

    @SerialName("is_interim")
    public static /* synthetic */ void isInterim$annotations() {
    }

    public final String component1() {
        return this.text;
    }

    public final boolean component2() {
        return this.isInterim;
    }

    public final float component3() {
        return this.startTime;
    }

    public final float component4() {
        return this.endTime;
    }

    public final String component5() {
        return this.asrTaskId;
    }

    public final OMNIAVQueryUpdateResult copy(String r100, boolean r101, float r110, float r111, String r112) {
        return new OMNIAVQueryUpdateResult(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OMNIAVQueryUpdateResult) == true) goto L8;
        return false;
    L8:
        OMNIAVQueryUpdateResult r101 = (OMNIAVQueryUpdateResult) r100;
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L12;
        return false;
    L12:
        if (this.isInterim == r101.isInterim) goto L15;
        return false;
    L15:
        if (Float.compare(this.startTime, r101.startTime) == 0) goto L18;
        return false;
    L18:
        if (Float.compare(this.endTime, r101.endTime) == 0) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.asrTaskId, r101.asrTaskId) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r100 = this.text;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        if (this.isInterim == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (((((r103 + r104) * 31) + Float.floatToIntBits(this.startTime)) * 31) + Float.floatToIntBits(this.endTime)) * 31;
        String r106 = this.asrTaskId;
        if (r106 == null) goto L15;
        r101 = r106.hashCode();
    L15:
        return r105 + r101;
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "OMNIAVQueryUpdateResult(text=" + this.text + ", isInterim=" + this.isInterim + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", asrTaskId=" + this.asrTaskId + ')';
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_av_release(OMNIAVQueryUpdateResult r100, muc.d r101, f r102) {
        boolean r103 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, v2.f520790a, r100.text);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r105 = true;
    L18:
        if (r105 == false) goto L21;
        r101.encodeBooleanElement(r102, 1, r100.isInterim);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r106 = true;
    L27:
        if (r106 == false) goto L30;
        r101.encodeFloatElement(r102, 2, r100.startTime);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        boolean r107 = true;
    L36:
        if (r107 == false) goto L39;
        r101.encodeFloatElement(r102, 3, r100.endTime);
    L39:
        if (r101.shouldEncodeElementDefault(r102, 4) == false) goto L42;
    L40:
        r103 = true;
    L44:
        if (r103 == false) goto L47;
        r101.encodeNullableSerializableElement(r102, 4, v2.f520790a, r100.asrTaskId);
        return;
    L47:
        return;
    L42:
        if (r100.asrTaskId == null) goto L44;
    L33:
        if (Float.compare(r100.endTime, 0.0f) != 0) goto L31;
        r107 = false;
        goto L36
    L24:
        if (Float.compare(r100.startTime, 0.0f) != 0) goto L22;
        r106 = false;
        goto L27
    L15:
        if (r100.isInterim == true) goto L13;
        r105 = false;
        goto L18
    L6:
        if (r100.text != null) goto L4;
        r104 = false;
        goto L9
    }

    public OMNIAVQueryUpdateResult(String r100, boolean r101, float r102, float r103, String r104) {
        this.text = r100;
        this.isInterim = r101;
        this.startTime = r102;
        this.endTime = r103;
        this.asrTaskId = r104;
    }

    public /* synthetic */ OMNIAVQueryUpdateResult(int r100, String r101, boolean r102, float r103, float r104, String r105, q2 r106) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, OMNIAVQueryUpdateResult$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.text = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.isInterim = false;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.startTime = 0.0f;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.endTime = 0.0f;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.asrTaskId = null;
        return;
    L23:
        this.asrTaskId = r105;
        return;
    L19:
        this.endTime = r104;
        goto L21
    L15:
        this.startTime = r103;
        goto L17
    L11:
        this.isInterim = r102;
        goto L13
    L7:
        this.text = r101;
        goto L9
    }

    public /* synthetic */ OMNIAVQueryUpdateResult(String r100, boolean r101, float r102, float r103, String r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        String r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        boolean r105 = false;
    L11:
        if ((r110 & 4) == 0) goto L13;
        float r106 = 0.0f;
    L15:
        if ((r110 & 8) == 0) goto L17;
        float r107 = 0.0f;
    L19:
        if ((r110 & 16) == 0) goto L21;
        String r113 = null;
    L22:
        this(r112, r105, r106, r107, r113);
        return;
    L21:
        r113 = r104;
        goto L22
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
