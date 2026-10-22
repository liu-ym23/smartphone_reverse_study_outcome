package com.larus.im.internal.protocol.bean;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import juc.d;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import luc.f;
import muc.e;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.q2;
import nuc.v2;
import nuc.w0;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 .2\u00060\u0001j\u0002`\u0002:\u0002./BA\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u000b\u0010\fBK\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u000b\u0010\u0010J\t\u0010\u0018\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0006HÆ\u0003JH\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\u0004HÖ\u0001J\t\u0010%\u001a\u00020\u0006HÖ\u0001J%\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00002\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0001¢\u0006\u0002\b-R\u0018\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0013\u0010\u0012R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0014\u0010\u0012R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\n\n\u0002\u0010\u0016\u0012\u0004\b\u0015\u0010\u0012R\u001a\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0017\u0010\u0012¨\u00060"}, d2 = {"Lcom/larus/im/internal/protocol/bean/UplinkMessage;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "cmd", "", "sequenceId", "", "uplinkBody", "Lcom/larus/im/internal/protocol/bean/UplinkBody;", "channel", "version", "<init>", "(ILjava/lang/String;Lcom/larus/im/internal/protocol/bean/UplinkBody;Ljava/lang/Integer;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/lang/String;Lcom/larus/im/internal/protocol/bean/UplinkBody;Ljava/lang/Integer;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCmd$annotations", "()V", "getSequenceId$annotations", "getUplinkBody$annotations", "getChannel$annotations", "Ljava/lang/Integer;", "getVersion$annotations", "component1", "component2", "component3", "component4", "()Ljava/lang/Integer;", "component5", "copy", "(ILjava/lang/String;Lcom/larus/im/internal/protocol/bean/UplinkBody;Ljava/lang/Integer;Ljava/lang/String;)Lcom/larus/im/internal/protocol/bean/UplinkMessage;", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$imsdkkmp_api_release", "Companion", "$serializer", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class UplinkMessage implements java.io.Serializable {
    public static final b Companion = null;
    private static final long serialVersionUID = 1;
    public Integer channel;
    public int cmd;
    public String sequenceId;
    public UplinkBody uplinkBody;
    public String version;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<UplinkMessage> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f349730a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f349731b = null;

        public a() {
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            w0 r100 = w0.f520792a;
            v2 r101 = v2.f520790a;
            return new d[]{r100, kuc.a.d(r101), kuc.a.d(UplinkBody.a.f349728a), kuc.a.d(r100), kuc.a.d(r101)};
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f349731b;
        }

        static {
            a r100 = new a();
            f349730a = r100;
            g2 r101 = new g2("com.larus.im.internal.protocol.bean.UplinkMessage", r100, 5);
            r101.j("cmd", true);
            r101.j("sequence_id", true);
            r101.j("uplink_body", true);
            r101.j("channel", true);
            r101.j("version", true);
            f349731b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r210) {
            Intrinsics.checkNotNullParameter(r210, "decoder");
            g2 r100 = f349731b;
            muc.c r101 = r210.beginStructure(r100);
            if (r101.decodeSequentially() == false) goto L5;
            int r102 = r101.decodeIntElement(r100, 0);
            v2 r103 = v2.f520790a;
            String r104 = (String) r101.decodeNullableSerializableElement(r100, 1, r103, null);
            UplinkBody r105 = (UplinkBody) r101.decodeNullableSerializableElement(r100, 2, UplinkBody.a.f349728a, null);
            Integer r106 = (Integer) r101.decodeNullableSerializableElement(r100, 3, w0.f520792a, null);
            int r110 = r102;
            UplinkBody r111 = r105;
            String r211 = (String) r101.decodeNullableSerializableElement(r100, 4, r103, null);
            String r112 = r104;
            Integer r113 = r106;
            int r114 = 31;
        L23:
            r101.endStructure(r100);
            return new UplinkMessage(r114, r110, r112, r111, r113, r211, null);
        L5:
            String r107 = null;
            UplinkBody r115 = null;
            Integer r116 = null;
            String r117 = null;
            int r108 = 0;
            int r109 = 0;
            boolean r118 = true;
        L6:
            if (r118 == false) goto L22;
            int r119 = r101.decodeElementIndex(r100);
            if (r119 != (-1)) goto L9;
            r118 = false;
            goto L6
        L9:
            if (r119 != 0) goto L10;
            r108 = r101.decodeIntElement(r100, 0);
            r109 = r109 | 1;
            goto L6
        L10:
            if (r119 != 1) goto L11;
            r107 = (String) r101.decodeNullableSerializableElement(r100, 1, v2.f520790a, r107);
            r109 = r109 | 2;
            goto L6
        L11:
            if (r119 != 2) goto L12;
            r115 = (UplinkBody) r101.decodeNullableSerializableElement(r100, 2, UplinkBody.a.f349728a, r115);
            r109 = r109 | 4;
            goto L6
        L12:
            if (r119 != 3) goto L13;
            r116 = (Integer) r101.decodeNullableSerializableElement(r100, 3, w0.f520792a, r116);
            r109 = r109 | 8;
            goto L6
        L13:
            if (r119 != 4) goto L16;
            r117 = (String) r101.decodeNullableSerializableElement(r100, 4, v2.f520790a, r117);
            r109 = r109 | 16;
            goto L6
        L16:
            throw new UnknownFieldException(r119);
        L22:
            r110 = r108;
            r114 = r109;
            r112 = r107;
            r111 = r115;
            r113 = r116;
            r211 = r117;
            goto L23
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            UplinkMessage r102 = (UplinkMessage) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f349731b;
            muc.d r104 = r100.beginStructure(r103);
            UplinkMessage.write$Self$imsdkkmp_api_release(r102, r104, r103);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<UplinkMessage> serializer() {
            return a.f349730a;
        }
    }

    public UplinkMessage() {
        this(0, null, null, null, null, 31, null);
    }

    public static /* synthetic */ UplinkMessage copy$default(UplinkMessage r100, int r101, String r102, UplinkBody r103, Integer r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.cmd;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.sequenceId;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.uplinkBody;
    L11:
        UplinkBody r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.channel;
    L14:
        Integer r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.version;
    L17:
        int r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    @SerialName("channel")
    public static /* synthetic */ void getChannel$annotations() {
    }

    @SerialName("cmd")
    public static /* synthetic */ void getCmd$annotations() {
    }

    @SerialName("sequence_id")
    public static /* synthetic */ void getSequenceId$annotations() {
    }

    @SerialName("uplink_body")
    public static /* synthetic */ void getUplinkBody$annotations() {
    }

    @SerialName("version")
    public static /* synthetic */ void getVersion$annotations() {
    }

    public final int component1() {
        return this.cmd;
    }

    public final String component2() {
        return this.sequenceId;
    }

    public final UplinkBody component3() {
        return this.uplinkBody;
    }

    public final Integer component4() {
        return this.channel;
    }

    public final String component5() {
        return this.version;
    }

    public final UplinkMessage copy(int r100, String r101, UplinkBody r110, Integer r111, String r112) {
        return new UplinkMessage(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof UplinkMessage) == true) goto L8;
        return false;
    L8:
        UplinkMessage r101 = (UplinkMessage) r100;
        if (this.cmd == r101.cmd) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.sequenceId, r101.sequenceId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.uplinkBody, r101.uplinkBody) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.channel, r101.channel) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.version, r101.version) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r100 = this.cmd * 31;
        String r101 = this.sequenceId;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        UplinkBody r105 = this.uplinkBody;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Integer r108 = this.channel;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.version;
        if (r111 == null) goto L19;
        r102 = r111.hashCode();
    L19:
        return r110 + r102;
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "UplinkMessage(cmd=" + this.cmd + ", sequenceId=" + this.sequenceId + ", uplinkBody=" + this.uplinkBody + ", channel=" + this.channel + ", version=" + this.version + ')';
    }

    static {
        Companion = new b();
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$imsdkkmp_api_release(UplinkMessage r100, muc.d r101, f r102) {
        boolean r103 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeIntElement(r102, 0, r100.cmd);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r105 = true;
    L18:
        if (r105 == false) goto L21;
        r101.encodeNullableSerializableElement(r102, 1, v2.f520790a, r100.sequenceId);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r106 = true;
    L27:
        if (r106 == false) goto L30;
        r101.encodeNullableSerializableElement(r102, 2, UplinkBody.a.f349728a, r100.uplinkBody);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        boolean r107 = true;
    L36:
        if (r107 == false) goto L39;
        r101.encodeNullableSerializableElement(r102, 3, w0.f520792a, r100.channel);
    L39:
        if (r101.shouldEncodeElementDefault(r102, 4) == false) goto L42;
    L40:
        r103 = true;
    L44:
        if (r103 == false) goto L47;
        r101.encodeNullableSerializableElement(r102, 4, v2.f520790a, r100.version);
        return;
    L47:
        return;
    L42:
        if (r100.version == null) goto L44;
    L33:
        if (r100.channel != null) goto L31;
        r107 = false;
        goto L36
    L24:
        if (r100.uplinkBody != null) goto L22;
        r106 = false;
        goto L27
    L15:
        if (r100.sequenceId != null) goto L13;
        r105 = false;
        goto L18
    L6:
        if (r100.cmd != 0) goto L4;
        r104 = false;
        goto L9
    }

    public UplinkMessage(int r100, String r101, UplinkBody r102, Integer r103, String r104) {
        this.cmd = r100;
        this.sequenceId = r101;
        this.uplinkBody = r102;
        this.channel = r103;
        this.version = r104;
    }

    public UplinkMessage(int r100, int r101, String r102, UplinkBody r103, Integer r104, String r105, q2 r106) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f349731b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.cmd = 0;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.sequenceId = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.uplinkBody = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.channel = null;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.version = null;
        return;
    L23:
        this.version = r105;
        return;
    L19:
        this.channel = r104;
        goto L21
    L15:
        this.uplinkBody = r103;
        goto L17
    L11:
        this.sequenceId = r102;
        goto L13
    L7:
        this.cmd = r101;
        goto L9
    }

    public /* synthetic */ UplinkMessage(int r100, String r101, UplinkBody r102, Integer r103, String r104, int r105, DefaultConstructorMarker r110) {
        if ((r105 & 1) == 0) goto L5;
        r100 = 0;
    L5:
        String r106 = null;
        if ((r105 & 2) == 0) goto L8;
        String r111 = null;
    L10:
        if ((r105 & 4) == 0) goto L12;
        UplinkBody r107 = null;
    L14:
        if ((r105 & 8) == 0) goto L16;
        Integer r108 = null;
    L18:
        if ((r105 & 16) != 0) goto L21;
        r106 = r104;
    L21:
        this(r100, r111, r107, r108, r106);
        return;
    L16:
        r108 = r103;
        goto L18
    L12:
        r107 = r102;
        goto L14
    L8:
        r111 = r101;
        goto L10
    }
}
