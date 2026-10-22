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
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 )2\u00060\u0001j\u0002`\u0002:\u0002()B1\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nB=\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\t\u0010\u000fJ\t\u0010\u0015\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0004HÆ\u0003J3\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\fHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0006HÖ\u0001J%\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0001¢\u0006\u0002\b'R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0012\u0010\u0011R\u0016\u0010\u0007\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0013\u0010\u0011R\u0016\u0010\b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0014\u0010\u0011¨\u0006*"}, d2 = {"Lcom/larus/im/internal/jni/bean/OMNIAVCommandEvent;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "cmd", "", "extra", "", "cliMs", "servMs", "<init>", "(JLjava/lang/String;JJ)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJLjava/lang/String;JJLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCmd$annotations", "()V", "getExtra$annotations", "getCliMs$annotations", "getServMs$annotations", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_av_release", "$serializer", "Companion", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OMNIAVCommandEvent implements java.io.Serializable {
    public static final Companion Companion = null;
    public final long cliMs;
    public final long cmd;
    public final String extra;
    public final long servMs;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OMNIAVCommandEvent$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OMNIAVCommandEvent;", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OMNIAVCommandEvent> serializer() {
            return OMNIAVCommandEvent$$serializer.INSTANCE;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OMNIAVCommandEvent() {
        this(0, null, 0, 0, 15, null);
    }

    public static /* synthetic */ OMNIAVCommandEvent copy$default(OMNIAVCommandEvent r100, long r101, String r110, long r111, long r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L5;
        long r102 = r100.cmd;
    L7:
        if ((r113 & 2) == 0) goto L9;
        String r103 = r100.extra;
    L11:
        if ((r113 & 4) == 0) goto L13;
        long r104 = r100.cliMs;
    L15:
        if ((r113 & 8) == 0) goto L17;
        long r105 = r100.servMs;
    L19:
        return r100.copy(r102, r103, r104, r105);
    L17:
        r105 = r112;
        goto L19
    L13:
        r104 = r111;
        goto L15
    L9:
        r103 = r110;
        goto L11
    L5:
        r102 = r101;
        goto L7
    }

    @SerialName("cli_ms")
    public static /* synthetic */ void getCliMs$annotations() {
    }

    @SerialName("cmd")
    public static /* synthetic */ void getCmd$annotations() {
    }

    @SerialName("extra")
    public static /* synthetic */ void getExtra$annotations() {
    }

    @SerialName("serv_ms")
    public static /* synthetic */ void getServMs$annotations() {
    }

    public final long component1() {
        return this.cmd;
    }

    public final String component2() {
        return this.extra;
    }

    public final long component3() {
        return this.cliMs;
    }

    public final long component4() {
        return this.servMs;
    }

    public final OMNIAVCommandEvent copy(long r110, String r111, long r112, long r113) {
        return new OMNIAVCommandEvent(r110, r111, r112, r113);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OMNIAVCommandEvent) == true) goto L8;
        return false;
    L8:
        OMNIAVCommandEvent r101 = (OMNIAVCommandEvent) r100;
        if (this.cmd == r101.cmd) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L15;
        return false;
    L15:
        if (this.cliMs == r101.cliMs) goto L18;
        return false;
    L18:
        if (this.servMs == r101.servMs) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        long r100 = this.cmd;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.extra;
        if (r102 != null) goto L5;
        int r103 = 0;
    L6:
        long r104 = this.cliMs;
        int r105 = (((r101 + r103) * 31) + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        long r106 = this.servMs;
        return r105 + ((int) (r106 ^ (r106 >>> 32)));
    L5:
        r103 = r102.hashCode();
        goto L6
    }

    public String toString() {
        return "OMNIAVCommandEvent(cmd=" + this.cmd + ", extra=" + this.extra + ", cliMs=" + this.cliMs + ", servMs=" + this.servMs + ')';
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_av_release(OMNIAVCommandEvent r100, muc.d r101, f r110) {
        boolean r102 = false;
        if (r101.shouldEncodeElementDefault(r110, 0) == false) goto L6;
    L4:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L12;
        r101.encodeLongElement(r110, 0, r100.cmd);
    L12:
        if (r101.shouldEncodeElementDefault(r110, 1) == false) goto L15;
    L13:
        boolean r104 = true;
    L18:
        if (r104 == false) goto L21;
        r101.encodeNullableSerializableElement(r110, 1, v2.f520790a, r100.extra);
    L21:
        if (r101.shouldEncodeElementDefault(r110, 2) == false) goto L24;
    L22:
        boolean r105 = true;
    L27:
        if (r105 == false) goto L30;
        r101.encodeLongElement(r110, 2, r100.cliMs);
    L30:
        if (r101.shouldEncodeElementDefault(r110, 3) == false) goto L33;
    L31:
        r102 = true;
    L35:
        if (r102 == false) goto L38;
        r101.encodeLongElement(r110, 3, r100.servMs);
        return;
    L38:
        return;
    L33:
        if (r100.servMs == 0) goto L35;
    L24:
        if (r100.cliMs != 0) goto L22;
        r105 = false;
        goto L27
    L15:
        if (r100.extra != null) goto L13;
        r104 = false;
        goto L18
    L6:
        if (r100.cmd != 0) goto L4;
        r103 = false;
        goto L9
    }

    public OMNIAVCommandEvent(long r100, String r101, long r102, long r103) {
        this.cmd = r100;
        this.extra = r101;
        this.cliMs = r102;
        this.servMs = r103;
    }

    public /* synthetic */ OMNIAVCommandEvent(int r100, long r101, String r102, long r103, long r110, q2 r111) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, OMNIAVCommandEvent$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.cmd = 0;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.extra = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.cliMs = 0;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.servMs = 0;
        return;
    L19:
        this.servMs = r110;
        return;
    L15:
        this.cliMs = r103;
        goto L17
    L11:
        this.extra = r102;
        goto L13
    L7:
        this.cmd = r101;
        goto L9
    }

    public /* synthetic */ OMNIAVCommandEvent(long r100, String r101, long r110, long r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        long r102 = 0;
    L7:
        if ((r112 & 2) == 0) goto L9;
        r101 = null;
    L9:
        String r114 = r101;
        if ((r112 & 4) == 0) goto L12;
        long r103 = 0;
    L14:
        if ((r112 & 8) == 0) goto L16;
        long r115 = 0;
    L17:
        this(r102, r114, r103, r115);
        return;
    L16:
        r115 = r111;
        goto L17
    L12:
        r103 = r110;
        goto L14
    L5:
        r102 = r100;
        goto L7
    }
}
