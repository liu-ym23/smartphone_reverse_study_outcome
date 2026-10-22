package com.larus.im.internal.jni.bean;

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
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 +2\u00060\u0001j\u0002`\u0002:\u0002*+B=\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fBG\b\u0010\u0012\u0006\u0010\r\u001a\u00020\n\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u000b\u0010\u0010J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003J?\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\nHÖ\u0001J\t\u0010!\u001a\u00020\u0004HÖ\u0001J%\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0001¢\u0006\u0002\b)R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0013\u0010\u0012R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0014\u0010\u0012R\u0016\u0010\b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0015\u0010\u0012R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0016\u0010\u0012¨\u0006,"}, d2 = {"Lcom/larus/im/internal/jni/bean/OMNIAVRuntimeWakeupParams;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "wakeWord", "", "isConfFetched", "", "vuiId", "enableOneShot", "vuiQueryMode", "", "<init>", "(Ljava/lang/String;ZLjava/lang/String;ZI)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;ZLjava/lang/String;ZILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getWakeWord$annotations", "()V", "isConfFetched$annotations", "getVuiId$annotations", "getEnableOneShot$annotations", "getVuiQueryMode$annotations", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_av_release", "$serializer", "Companion", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OMNIAVRuntimeWakeupParams implements java.io.Serializable {
    public static final Companion Companion = null;
    public final boolean enableOneShot;
    public final boolean isConfFetched;
    public final String vuiId;
    public final int vuiQueryMode;
    public final String wakeWord;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OMNIAVRuntimeWakeupParams$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OMNIAVRuntimeWakeupParams;", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OMNIAVRuntimeWakeupParams> serializer() {
            return OMNIAVRuntimeWakeupParams$$serializer.INSTANCE;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OMNIAVRuntimeWakeupParams() {
        this(null, false, null, false, 0, 31, null);
    }

    public static /* synthetic */ OMNIAVRuntimeWakeupParams copy$default(OMNIAVRuntimeWakeupParams r100, String r101, boolean r102, String r103, boolean r104, int r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.wakeWord;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.isConfFetched;
    L8:
        boolean r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.vuiId;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.enableOneShot;
    L14:
        boolean r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.vuiQueryMode;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    @SerialName("enableOneShot")
    public static /* synthetic */ void getEnableOneShot$annotations() {
    }

    @SerialName("vuiId")
    public static /* synthetic */ void getVuiId$annotations() {
    }

    @SerialName("vuiQueryMode")
    public static /* synthetic */ void getVuiQueryMode$annotations() {
    }

    @SerialName("wakeWord")
    public static /* synthetic */ void getWakeWord$annotations() {
    }

    @SerialName("isConfFetched")
    public static /* synthetic */ void isConfFetched$annotations() {
    }

    public final String component1() {
        return this.wakeWord;
    }

    public final boolean component2() {
        return this.isConfFetched;
    }

    public final String component3() {
        return this.vuiId;
    }

    public final boolean component4() {
        return this.enableOneShot;
    }

    public final int component5() {
        return this.vuiQueryMode;
    }

    public final OMNIAVRuntimeWakeupParams copy(String r100, boolean r101, String r110, boolean r111, int r112) {
        return new OMNIAVRuntimeWakeupParams(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OMNIAVRuntimeWakeupParams) == true) goto L8;
        return false;
    L8:
        OMNIAVRuntimeWakeupParams r101 = (OMNIAVRuntimeWakeupParams) r100;
        if (Intrinsics.areEqual(this.wakeWord, r101.wakeWord) == true) goto L12;
        return false;
    L12:
        if (this.isConfFetched == r101.isConfFetched) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.vuiId, r101.vuiId) == true) goto L18;
        return false;
    L18:
        if (this.enableOneShot == r101.enableOneShot) goto L21;
        return false;
    L21:
        if (this.vuiQueryMode == r101.vuiQueryMode) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r100 = this.wakeWord;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        int r104 = 1231;
        if (this.isConfFetched == false) goto L9;
        int r105 = 1231;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.vuiId;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        int r108 = (r106 + r101) * 31;
        if (this.enableOneShot == true) goto L19;
        r104 = 1237;
    L19:
        return ((r108 + r104) * 31) + this.vuiQueryMode;
    L9:
        r105 = 1237;
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "OMNIAVRuntimeWakeupParams(wakeWord=" + this.wakeWord + ", isConfFetched=" + this.isConfFetched + ", vuiId=" + this.vuiId + ", enableOneShot=" + this.enableOneShot + ", vuiQueryMode=" + this.vuiQueryMode + ')';
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_av_release(OMNIAVRuntimeWakeupParams r100, muc.d r101, f r102) {
        boolean r103 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, v2.f520790a, r100.wakeWord);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r105 = true;
    L18:
        if (r105 == false) goto L21;
        r101.encodeBooleanElement(r102, 1, r100.isConfFetched);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r106 = true;
    L27:
        if (r106 == false) goto L30;
        r101.encodeNullableSerializableElement(r102, 2, v2.f520790a, r100.vuiId);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        boolean r107 = true;
    L36:
        if (r107 == false) goto L39;
        r101.encodeBooleanElement(r102, 3, r100.enableOneShot);
    L39:
        if (r101.shouldEncodeElementDefault(r102, 4) == false) goto L42;
    L40:
        r103 = true;
    L44:
        if (r103 == false) goto L47;
        r101.encodeIntElement(r102, 4, r100.vuiQueryMode);
        return;
    L47:
        return;
    L42:
        if (r100.vuiQueryMode == 0) goto L44;
    L33:
        if (r100.enableOneShot == true) goto L31;
        r107 = false;
        goto L36
    L24:
        if (r100.vuiId != null) goto L22;
        r106 = false;
        goto L27
    L15:
        if (r100.isConfFetched == true) goto L13;
        r105 = false;
        goto L18
    L6:
        if (r100.wakeWord != null) goto L4;
        r104 = false;
        goto L9
    }

    public OMNIAVRuntimeWakeupParams(String r100, boolean r101, String r102, boolean r103, int r104) {
        this.wakeWord = r100;
        this.isConfFetched = r101;
        this.vuiId = r102;
        this.enableOneShot = r103;
        this.vuiQueryMode = r104;
    }

    public /* synthetic */ OMNIAVRuntimeWakeupParams(int r100, String r101, boolean r102, String r103, boolean r104, int r105, q2 r106) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, OMNIAVRuntimeWakeupParams$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.wakeWord = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.isConfFetched = false;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.vuiId = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.enableOneShot = false;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.vuiQueryMode = 0;
        return;
    L23:
        this.vuiQueryMode = r105;
        return;
    L19:
        this.enableOneShot = r104;
        goto L21
    L15:
        this.vuiId = r103;
        goto L17
    L11:
        this.isConfFetched = r102;
        goto L13
    L7:
        this.wakeWord = r101;
        goto L9
    }

    public /* synthetic */ OMNIAVRuntimeWakeupParams(String r100, boolean r101, String r102, boolean r103, int r104, int r110, DefaultConstructorMarker r111) {
        String r105 = null;
        if ((r110 & 1) == 0) goto L5;
        String r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        boolean r106 = false;
    L11:
        if ((r110 & 4) != 0) goto L15;
        r105 = r102;
    L15:
        if ((r110 & 8) == 0) goto L17;
        boolean r107 = false;
    L19:
        if ((r110 & 16) == 0) goto L21;
        int r113 = 0;
    L22:
        this(r112, r106, r105, r107, r113);
        return;
    L21:
        r113 = r104;
        goto L22
    L17:
        r107 = r103;
        goto L19
    L9:
        r106 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
