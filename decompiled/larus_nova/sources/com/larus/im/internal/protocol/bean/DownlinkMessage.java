package com.larus.im.internal.protocol.bean;

import af9.d0;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.JsonAdapter;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.Map;
import juc.d;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import luc.f;
import muc.e;
import nuc.a1;
import nuc.b2;
import nuc.g1;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.q2;
import nuc.v2;
import nuc.w0;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 62\u00060\u0001j\u0002`\u0002:\u000267Bm\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000f¢\u0006\u0004\b\u0010\u0010\u0011Bq\b\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000f\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0010\u0010\u0015J\t\u0010\u001f\u001a\u00020\u0004HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010#\u001a\u00020\u000bHÆ\u0003J\t\u0010$\u001a\u00020\u0004HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0017\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000fHÆ\u0003Jo\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000fHÆ\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+HÖ\u0003J\t\u0010,\u001a\u00020\u0004HÖ\u0001J\t\u0010-\u001a\u00020\u0006HÖ\u0001J%\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u00002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0001¢\u0006\u0002\b5R\u0018\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0018\u0010\u0017R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0019\u0010\u0017R\u001a\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u001a\u0010\u0017R\u0018\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u001b\u0010\u0017R\u0018\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u001c\u0010\u0017R\u001a\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u001d\u0010\u0017R&\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u001e\u0010\u0017¨\u00068"}, d2 = {"Lcom/larus/im/internal/protocol/bean/DownlinkMessage;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "cmd", "", "sequenceId", "", "downlinkBody", "Lcom/larus/im/internal/protocol/bean/DownlinkBody;", "version", "cmdIndex", "", "statusCode", "statusDesc", "ext", "", "<init>", "(ILjava/lang/String;Lcom/larus/im/internal/protocol/bean/DownlinkBody;Ljava/lang/String;JILjava/lang/String;Ljava/util/Map;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/lang/String;Lcom/larus/im/internal/protocol/bean/DownlinkBody;Ljava/lang/String;JILjava/lang/String;Ljava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCmd$annotations", "()V", "getSequenceId$annotations", "getDownlinkBody$annotations", "getVersion$annotations", "getCmdIndex$annotations", "getStatusCode$annotations", "getStatusDesc$annotations", "getExt$annotations", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$imsdkkmp_api_release", "Companion", "$serializer", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class DownlinkMessage implements java.io.Serializable {
    private static final Lazy<d<Object>>[] $childSerializers = null;
    public static final b Companion = null;
    private static final long serialVersionUID = 1;
    public int cmd;
    public long cmdIndex;
    public DownlinkBody downlinkBody;

    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    public Map<String, String> ext;
    public String sequenceId;
    public int statusCode;
    public String statusDesc;
    public String version;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<DownlinkMessage> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f349627a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f349628b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f349628b;
        }

        static {
            a r100 = new a();
            f349627a = r100;
            g2 r101 = new g2("com.larus.im.internal.protocol.bean.DownlinkMessage", r100, 8);
            r101.j("cmd", true);
            r101.j("sequence_id", true);
            r101.j("downlink_body", true);
            r101.j("version", true);
            r101.j("cmd_index", true);
            r101.j("status_code", true);
            r101.j("status_desc", true);
            r101.j("ext", true);
            f349628b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            Lazy[] r100 = DownlinkMessage.access$get$childSerializers$cp();
            w0 r101 = w0.f520792a;
            v2 r102 = v2.f520790a;
            return new d[]{r101, kuc.a.d(r102), kuc.a.d(DownlinkBody.a.f349625a), kuc.a.d(r102), g1.f520681a, r101, kuc.a.d(r102), kuc.a.d((d) r100[7].getValue())};
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r210) {
            Intrinsics.checkNotNullParameter(r210, "decoder");
            g2 r100 = f349628b;
            muc.c r101 = r210.beginStructure(r100);
            Lazy[] r102 = DownlinkMessage.access$get$childSerializers$cp();
            int r103 = 4;
            if (r101.decodeSequentially() == false) goto L5;
            int r104 = r101.decodeIntElement(r100, 0);
            v2 r105 = v2.f520790a;
            String r106 = (String) r101.decodeNullableSerializableElement(r100, 1, r105, null);
            DownlinkBody r107 = (DownlinkBody) r101.decodeNullableSerializableElement(r100, 2, DownlinkBody.a.f349625a, null);
            String r108 = (String) r101.decodeNullableSerializableElement(r100, 3, r105, null);
            long r110 = r101.decodeLongElement(r100, 4);
            int r109 = r101.decodeIntElement(r100, 5);
            String r111 = (String) r101.decodeNullableSerializableElement(r100, 6, r105, null);
            Map r112 = (Map) r101.decodeNullableSerializableElement(r100, 7, (juc.c) r102[7].getValue(), null);
            String r113 = r108;
            String r114 = r111;
            DownlinkBody r115 = r107;
            String r116 = r106;
            long r117 = r110;
            int r118 = 255;
            int r119 = r104;
            int r120 = r109;
        L26:
            r101.endStructure(r100);
            return new DownlinkMessage(r118, r119, r116, r115, r113, r117, r120, r114, r112, null);
        L5:
            Map r121 = null;
            String r122 = null;
            String r123 = null;
            String r124 = null;
            long r125 = 0;
            int r126 = 0;
            int r127 = 0;
            boolean r211 = true;
            DownlinkBody r128 = null;
            int r129 = 0;
        L6:
            if (r211 == false) goto L25;
            int r130 = r101.decodeElementIndex(r100);
            switch(r130) {
                case -1: goto L24;
                case 0: goto L22;
                case 1: goto L20;
                case 2: goto L18;
                case 3: goto L16;
                case 4: goto L15;
                case 5: goto L14;
                case 6: goto L12;
                case 7: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r130);
        L24:
            r211 = false;
            goto L6
        L11:
            r121 = (Map) r101.decodeNullableSerializableElement(r100, 7, (juc.c) r102[7].getValue(), r121);
            int r131 = r127 | 128;
        L21:
            r127 = r131;
        L23:
            r103 = 4;
            goto L6
        L12:
            r123 = (String) r101.decodeNullableSerializableElement(r100, 6, v2.f520790a, r123);
            r131 = r127 | 64;
            goto L21
        L14:
            r129 = r101.decodeIntElement(r100, 5);
            r131 = r127 | 32;
            goto L21
        L15:
            r125 = r101.decodeLongElement(r100, r103);
            r131 = r127 | 16;
            goto L21
        L16:
            r122 = (String) r101.decodeNullableSerializableElement(r100, 3, v2.f520790a, r122);
            r131 = r127 | 8;
            goto L21
        L18:
            r128 = (DownlinkBody) r101.decodeNullableSerializableElement(r100, 2, DownlinkBody.a.f349625a, r128);
            r131 = r127 | 4;
            goto L21
        L20:
            r124 = (String) r101.decodeNullableSerializableElement(r100, 1, v2.f520790a, r124);
            r131 = r127 | 2;
            goto L21
        L22:
            r126 = r101.decodeIntElement(r100, 0);
            r127 = r127 | 1;
            goto L23
        L25:
            r112 = r121;
            r113 = r122;
            r118 = r127;
            r115 = r128;
            r119 = r126;
            r120 = r129;
            r117 = r125;
            String r212 = r124;
            r114 = r123;
            r116 = r212;
            goto L26
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            DownlinkMessage r102 = (DownlinkMessage) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f349628b;
            muc.d r104 = r100.beginStructure(r103);
            DownlinkMessage.write$Self$imsdkkmp_api_release(r102, r104, r103);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<DownlinkMessage> serializer() {
            return a.f349627a;
        }
    }

    public DownlinkMessage() {
        this(0, null, null, null, 0, 0, null, null, 255, null);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_() {
        v2 r100 = v2.f520790a;
        return new a1(r100, r100);
    }

    public static /* synthetic */ d a() {
        return _childSerializers$_anonymous_();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DownlinkMessage copy$default(DownlinkMessage r110, int r111, String r112, DownlinkBody r113, String r114, long r115, int r116, String r117, Map r118, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        int r100 = r110.cmd;
    L7:
        if ((r210 & 2) == 0) goto L9;
        String r101 = r110.sequenceId;
    L11:
        if ((r210 & 4) == 0) goto L13;
        DownlinkBody r102 = r110.downlinkBody;
    L15:
        if ((r210 & 8) == 0) goto L17;
        String r103 = r110.version;
    L19:
        if ((r210 & 16) == 0) goto L21;
        long r104 = r110.cmdIndex;
    L23:
        if ((r210 & 32) == 0) goto L25;
        int r105 = r110.statusCode;
    L27:
        if ((r210 & 64) == 0) goto L29;
        String r106 = r110.statusDesc;
    L31:
        if ((r210 & 128) == 0) goto L33;
        Map r107 = r110.ext;
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

    @SerialName("cmd")
    public static /* synthetic */ void getCmd$annotations() {
    }

    @SerialName("cmd_index")
    public static /* synthetic */ void getCmdIndex$annotations() {
    }

    @SerialName("downlink_body")
    public static /* synthetic */ void getDownlinkBody$annotations() {
    }

    @SerialName("ext")
    public static /* synthetic */ void getExt$annotations() {
    }

    @SerialName("sequence_id")
    public static /* synthetic */ void getSequenceId$annotations() {
    }

    @SerialName("status_code")
    public static /* synthetic */ void getStatusCode$annotations() {
    }

    @SerialName("status_desc")
    public static /* synthetic */ void getStatusDesc$annotations() {
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

    public final DownlinkBody component3() {
        return this.downlinkBody;
    }

    public final String component4() {
        return this.version;
    }

    public final long component5() {
        return this.cmdIndex;
    }

    public final int component6() {
        return this.statusCode;
    }

    public final String component7() {
        return this.statusDesc;
    }

    public final Map<String, String> component8() {
        return this.ext;
    }

    public final DownlinkMessage copy(int r110, String r111, DownlinkBody r112, String r113, long r114, int r115, String r116, Map<String, String> r210) {
        return new DownlinkMessage(r110, r111, r112, r113, r114, r115, r116, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DownlinkMessage) == true) goto L8;
        return false;
    L8:
        DownlinkMessage r101 = (DownlinkMessage) r100;
        if (this.cmd == r101.cmd) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.sequenceId, r101.sequenceId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.downlinkBody, r101.downlinkBody) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.version, r101.version) == true) goto L21;
        return false;
    L21:
        if (this.cmdIndex == r101.cmdIndex) goto L24;
        return false;
    L24:
        if (this.statusCode == r101.statusCode) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.statusDesc, r101.statusDesc) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.ext, r101.ext) == true) goto L32;
        return false;
    L32:
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
        DownlinkBody r105 = this.downlinkBody;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.version;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        long r110 = this.cmdIndex;
        int r111 = (((((r107 + r109) * 31) + ((int) (r110 ^ (r110 >>> 32)))) * 31) + this.statusCode) * 31;
        String r112 = this.statusDesc;
        if (r112 != null) goto L17;
        int r113 = 0;
    L18:
        int r114 = (r111 + r113) * 31;
        Map<String, String> r115 = this.ext;
        if (r115 == null) goto L23;
        r102 = r115.hashCode();
    L23:
        return r114 + r102;
    L17:
        r113 = r112.hashCode();
        goto L18
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
        return "DownlinkMessage(cmd=" + this.cmd + ", sequenceId=" + this.sequenceId + ", downlinkBody=" + this.downlinkBody + ", version=" + this.version + ", cmdIndex=" + this.cmdIndex + ", statusCode=" + this.statusCode + ", statusDesc=" + this.statusDesc + ", ext=" + this.ext + ')';
    }

    static {
        Companion = new b();
        $childSerializers = new Lazy[]{null, null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new d0())};
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$imsdkkmp_api_release(DownlinkMessage r100, muc.d r110, f r111) {
        Lazy<d<Object>>[] r101 = $childSerializers;
        boolean r102 = false;
        if (r110.shouldEncodeElementDefault(r111, 0) == false) goto L6;
    L4:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L12;
        r110.encodeIntElement(r111, 0, r100.cmd);
    L12:
        if (r110.shouldEncodeElementDefault(r111, 1) == false) goto L15;
    L13:
        boolean r104 = true;
    L18:
        if (r104 == false) goto L21;
        r110.encodeNullableSerializableElement(r111, 1, v2.f520790a, r100.sequenceId);
    L21:
        if (r110.shouldEncodeElementDefault(r111, 2) == false) goto L24;
    L22:
        boolean r105 = true;
    L27:
        if (r105 == false) goto L30;
        r110.encodeNullableSerializableElement(r111, 2, DownlinkBody.a.f349625a, r100.downlinkBody);
    L30:
        if (r110.shouldEncodeElementDefault(r111, 3) == false) goto L33;
    L31:
        boolean r106 = true;
    L36:
        if (r106 == false) goto L39;
        r110.encodeNullableSerializableElement(r111, 3, v2.f520790a, r100.version);
    L39:
        if (r110.shouldEncodeElementDefault(r111, 4) == false) goto L42;
    L40:
        boolean r107 = true;
    L45:
        if (r107 == false) goto L48;
        r110.encodeLongElement(r111, 4, r100.cmdIndex);
    L48:
        if (r110.shouldEncodeElementDefault(r111, 5) == false) goto L51;
    L49:
        boolean r108 = true;
    L54:
        if (r108 == false) goto L57;
        r110.encodeIntElement(r111, 5, r100.statusCode);
    L57:
        if (r110.shouldEncodeElementDefault(r111, 6) == false) goto L60;
    L58:
        boolean r109 = true;
    L63:
        if (r109 == false) goto L66;
        r110.encodeNullableSerializableElement(r111, 6, v2.f520790a, r100.statusDesc);
    L66:
        if (r110.shouldEncodeElementDefault(r111, 7) == false) goto L69;
    L67:
        r102 = true;
    L71:
        if (r102 == false) goto L74;
        r110.encodeNullableSerializableElement(r111, 7, r101[7].getValue(), r100.ext);
        return;
    L74:
        return;
    L69:
        if (r100.ext == null) goto L71;
    L60:
        if (r100.statusDesc != null) goto L58;
        r109 = false;
        goto L63
    L51:
        if (r100.statusCode != 0) goto L49;
        r108 = false;
        goto L54
    L42:
        if (r100.cmdIndex != (-1)) goto L40;
        r107 = false;
        goto L45
    L33:
        if (r100.version != null) goto L31;
        r106 = false;
        goto L36
    L24:
        if (r100.downlinkBody != null) goto L22;
        r105 = false;
        goto L27
    L15:
        if (r100.sequenceId != null) goto L13;
        r104 = false;
        goto L18
    L6:
        if (r100.cmd != 0) goto L4;
        r103 = false;
        goto L9
    }

    public DownlinkMessage(int r100, String r101, DownlinkBody r102, String r103, long r104, int r105, String r106, Map<String, String> r107) {
        this.cmd = r100;
        this.sequenceId = r101;
        this.downlinkBody = r102;
        this.version = r103;
        this.cmdIndex = r104;
        this.statusCode = r105;
        this.statusDesc = r106;
        this.ext = r107;
    }

    public DownlinkMessage(int r100, int r101, String r102, DownlinkBody r103, String r104, long r105, int r110, String r111, Map r112, q2 r113) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f349628b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.cmd = 0;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.sequenceId = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.downlinkBody = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.version = null;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.cmdIndex = -1;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.statusCode = 0;
    L29:
        if ((r100 & 64) != 0) goto L31;
        this.statusDesc = null;
    L33:
        if ((r100 & 128) != 0) goto L35;
        this.ext = null;
        return;
    L35:
        this.ext = r112;
        return;
    L31:
        this.statusDesc = r111;
        goto L33
    L27:
        this.statusCode = r110;
        goto L29
    L23:
        this.cmdIndex = r105;
        goto L25
    L19:
        this.version = r104;
        goto L21
    L15:
        this.downlinkBody = r103;
        goto L17
    L11:
        this.sequenceId = r102;
        goto L13
    L7:
        this.cmd = r101;
        goto L9
    }

    public /* synthetic */ DownlinkMessage(int r110, String r111, DownlinkBody r112, String r113, long r114, int r115, String r116, Map r117, int r210, DefaultConstructorMarker r211) {
        int r100 = 0;
        if ((r210 & 1) == 0) goto L5;
        int r101 = 0;
    L6:
        Map r102 = null;
        if ((r210 & 2) == 0) goto L9;
        String r103 = null;
    L11:
        if ((r210 & 4) == 0) goto L13;
        DownlinkBody r104 = null;
    L15:
        if ((r210 & 8) == 0) goto L17;
        String r105 = null;
    L19:
        if ((r210 & 16) == 0) goto L21;
        long r106 = -1;
    L23:
        if ((r210 & 32) != 0) goto L27;
        r100 = r115;
    L27:
        if ((r210 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r210 & 128) != 0) goto L34;
        r102 = r117;
    L34:
        this(r101, r103, r104, r105, r106, r100, r107, r102);
        return;
    L29:
        r107 = r116;
        goto L31
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
        r103 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L6
    }
}
