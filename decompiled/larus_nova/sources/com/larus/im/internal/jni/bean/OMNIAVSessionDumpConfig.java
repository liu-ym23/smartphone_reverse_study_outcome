package com.larus.im.internal.jni.bean;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import juc.d;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import luc.f;
import nuc.b2;
import nuc.q2;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 %2\u00060\u0001j\u0002`\u0002:\u0002$%B%\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bB3\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0004HÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\nHÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J%\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0001¢\u0006\u0002\b#R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0010\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0011\u0010\u000f¨\u0006&"}, d2 = {"Lcom/larus/im/internal/jni/bean/OMNIAVSessionDumpConfig;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "enableAvDump", "", "enableRtcDump", "enableSpeechDump", "<init>", "(ZZZ)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IZZZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getEnableAvDump$annotations", "()V", "getEnableRtcDump$annotations", "getEnableSpeechDump$annotations", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "toString", "", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_av_release", "$serializer", "Companion", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OMNIAVSessionDumpConfig implements java.io.Serializable {
    public static final Companion Companion = null;
    public final boolean enableAvDump;
    public final boolean enableRtcDump;
    public final boolean enableSpeechDump;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OMNIAVSessionDumpConfig$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OMNIAVSessionDumpConfig;", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OMNIAVSessionDumpConfig> serializer() {
            return OMNIAVSessionDumpConfig$$serializer.INSTANCE;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OMNIAVSessionDumpConfig() {
        this(false, false, false, 7, null);
    }

    public static /* synthetic */ OMNIAVSessionDumpConfig copy$default(OMNIAVSessionDumpConfig r100, boolean r101, boolean r102, boolean r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.enableAvDump;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.enableRtcDump;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.enableSpeechDump;
    L12:
        return r100.copy(r101, r102, r103);
    }

    @SerialName("enableAvDump")
    public static /* synthetic */ void getEnableAvDump$annotations() {
    }

    @SerialName("enableRtcDump")
    public static /* synthetic */ void getEnableRtcDump$annotations() {
    }

    @SerialName("enableSpeechDump")
    public static /* synthetic */ void getEnableSpeechDump$annotations() {
    }

    public final boolean component1() {
        return this.enableAvDump;
    }

    public final boolean component2() {
        return this.enableRtcDump;
    }

    public final boolean component3() {
        return this.enableSpeechDump;
    }

    public final OMNIAVSessionDumpConfig copy(boolean r100, boolean r101, boolean r102) {
        return new OMNIAVSessionDumpConfig(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OMNIAVSessionDumpConfig) == true) goto L8;
        return false;
    L8:
        OMNIAVSessionDumpConfig r101 = (OMNIAVSessionDumpConfig) r100;
        if (this.enableAvDump == r101.enableAvDump) goto L12;
        return false;
    L12:
        if (this.enableRtcDump == r101.enableRtcDump) goto L15;
        return false;
    L15:
        if (this.enableSpeechDump == r101.enableSpeechDump) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.enableAvDump == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.enableRtcDump == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.enableSpeechDump == true) goto L15;
        r100 = 1237;
    L15:
        return r104 + r100;
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "OMNIAVSessionDumpConfig(enableAvDump=" + this.enableAvDump + ", enableRtcDump=" + this.enableRtcDump + ", enableSpeechDump=" + this.enableSpeechDump + ')';
    }

    public OMNIAVSessionDumpConfig(boolean r100, boolean r101, boolean r102) {
        this.enableAvDump = r100;
        this.enableRtcDump = r101;
        this.enableSpeechDump = r102;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_av_release(OMNIAVSessionDumpConfig r100, muc.d r101, f r102) {
        boolean r103 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeBooleanElement(r102, 0, r100.enableAvDump);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r105 = true;
    L18:
        if (r105 == false) goto L21;
        r101.encodeBooleanElement(r102, 1, r100.enableRtcDump);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        r103 = true;
    L26:
        if (r103 == false) goto L29;
        r101.encodeBooleanElement(r102, 2, r100.enableSpeechDump);
        return;
    L29:
        return;
    L24:
        if (r100.enableSpeechDump == false) goto L26;
    L15:
        if (r100.enableRtcDump == true) goto L13;
        r105 = false;
        goto L18
    L6:
        if (r100.enableAvDump == true) goto L4;
        r104 = false;
        goto L9
    }

    public /* synthetic */ OMNIAVSessionDumpConfig(int r100, boolean r101, boolean r102, boolean r103, q2 r104) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, OMNIAVSessionDumpConfig$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.enableAvDump = false;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.enableRtcDump = false;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.enableSpeechDump = false;
        return;
    L15:
        this.enableSpeechDump = r103;
        return;
    L11:
        this.enableRtcDump = r102;
        goto L13
    L7:
        this.enableAvDump = r101;
        goto L9
    }

    public /* synthetic */ OMNIAVSessionDumpConfig(boolean r100, boolean r101, boolean r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = false;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = false;
    L11:
        this(r100, r101, r102);
    }
}
