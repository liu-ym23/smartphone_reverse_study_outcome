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
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 $2\u00060\u0001j\u0002`\u0002:\u0002$%B)\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\tB7\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\b\u0010\rJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0004HÆ\u0003J+\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0004HÖ\u0001J%\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0001¢\u0006\u0002\b#R\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0010\u0010\u000fR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0011\u0010\u000f¨\u0006&"}, d2 = {"Lcom/larus/im/internal/protocol/bean/FetchChunkMessageUplinkBody;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "token", "", "seqSt", "", "acceptBinaryType", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;ILjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getToken$annotations", "()V", "getSeqSt$annotations", "getAcceptBinaryType$annotations", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$imsdkkmp_api_release", "Companion", "$serializer", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class FetchChunkMessageUplinkBody implements java.io.Serializable {
    public static final b Companion = null;
    private static final long serialVersionUID = 1;
    public String acceptBinaryType;
    public int seqSt;
    public String token;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<FetchChunkMessageUplinkBody> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f349631a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f349632b = null;

        public a() {
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            v2 r100 = v2.f520790a;
            return new d[]{kuc.a.d(r100), w0.f520792a, kuc.a.d(r100)};
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f349632b;
        }

        static {
            a r100 = new a();
            f349631a = r100;
            g2 r101 = new g2("com.larus.im.internal.protocol.bean.FetchChunkMessageUplinkBody", r100, 3);
            r101.j("token", true);
            r101.j("seq_st", true);
            r101.j("accept_binary_type", true);
            f349632b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f349632b;
            muc.c r101 = r110.beginStructure(r100);
            if (r101.decodeSequentially() == false) goto L5;
            v2 r102 = v2.f520790a;
            String r103 = (String) r101.decodeNullableSerializableElement(r100, 0, r102, null);
            int r104 = r101.decodeIntElement(r100, 1);
            String r111 = (String) r101.decodeNullableSerializableElement(r100, 2, r102, null);
            int r112 = r104;
            String r113 = r103;
            int r114 = 7;
        L19:
            r101.endStructure(r100);
            return new FetchChunkMessageUplinkBody(r114, r113, r112, r111, null);
        L5:
            String r105 = null;
            String r106 = null;
            int r107 = 0;
            int r108 = 0;
            boolean r109 = true;
        L6:
            if (r109 == false) goto L18;
            int r115 = r101.decodeElementIndex(r100);
            if (r115 != (-1)) goto L9;
            r109 = false;
            goto L6
        L9:
            if (r115 != 0) goto L10;
            r105 = (String) r101.decodeNullableSerializableElement(r100, 0, v2.f520790a, r105);
            r107 = r107 | 1;
            goto L6
        L10:
            if (r115 != 1) goto L11;
            r108 = r101.decodeIntElement(r100, 1);
            r107 = r107 | 2;
            goto L6
        L11:
            if (r115 != 2) goto L14;
            r106 = (String) r101.decodeNullableSerializableElement(r100, 2, v2.f520790a, r106);
            r107 = r107 | 4;
            goto L6
        L14:
            throw new UnknownFieldException(r115);
        L18:
            r114 = r107;
            r112 = r108;
            r113 = r105;
            r111 = r106;
            goto L19
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            FetchChunkMessageUplinkBody r102 = (FetchChunkMessageUplinkBody) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f349632b;
            muc.d r104 = r100.beginStructure(r103);
            FetchChunkMessageUplinkBody.write$Self$imsdkkmp_api_release(r102, r104, r103);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<FetchChunkMessageUplinkBody> serializer() {
            return a.f349631a;
        }
    }

    public FetchChunkMessageUplinkBody() {
        this(null, 0, null, 7, null);
    }

    public static /* synthetic */ FetchChunkMessageUplinkBody copy$default(FetchChunkMessageUplinkBody r100, String r101, int r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.token;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.seqSt;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.acceptBinaryType;
    L12:
        return r100.copy(r101, r102, r103);
    }

    @SerialName("accept_binary_type")
    public static /* synthetic */ void getAcceptBinaryType$annotations() {
    }

    @SerialName("seq_st")
    public static /* synthetic */ void getSeqSt$annotations() {
    }

    @SerialName("token")
    public static /* synthetic */ void getToken$annotations() {
    }

    public final String component1() {
        return this.token;
    }

    public final int component2() {
        return this.seqSt;
    }

    public final String component3() {
        return this.acceptBinaryType;
    }

    public final FetchChunkMessageUplinkBody copy(String r100, int r101, String r102) {
        return new FetchChunkMessageUplinkBody(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FetchChunkMessageUplinkBody) == true) goto L8;
        return false;
    L8:
        FetchChunkMessageUplinkBody r101 = (FetchChunkMessageUplinkBody) r100;
        if (Intrinsics.areEqual(this.token, r101.token) == true) goto L12;
        return false;
    L12:
        if (this.seqSt == r101.seqSt) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.acceptBinaryType, r101.acceptBinaryType) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r100 = this.token;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.seqSt) * 31;
        String r104 = this.acceptBinaryType;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "FetchChunkMessageUplinkBody(token=" + this.token + ", seqSt=" + this.seqSt + ", acceptBinaryType=" + this.acceptBinaryType + ')';
    }

    static {
        Companion = new b();
    }

    public FetchChunkMessageUplinkBody(String r100, int r101, String r102) {
        this.token = r100;
        this.seqSt = r101;
        this.acceptBinaryType = r102;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$imsdkkmp_api_release(FetchChunkMessageUplinkBody r100, muc.d r101, f r102) {
        boolean r103 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, v2.f520790a, r100.token);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r105 = true;
    L18:
        if (r105 == false) goto L21;
        r101.encodeIntElement(r102, 1, r100.seqSt);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        r103 = true;
    L26:
        if (r103 == false) goto L29;
        r101.encodeNullableSerializableElement(r102, 2, v2.f520790a, r100.acceptBinaryType);
        return;
    L29:
        return;
    L24:
        if (r100.acceptBinaryType == null) goto L26;
    L15:
        if (r100.seqSt != 0) goto L13;
        r105 = false;
        goto L18
    L6:
        if (r100.token != null) goto L4;
        r104 = false;
        goto L9
    }

    public FetchChunkMessageUplinkBody(int r100, String r101, int r102, String r103, q2 r104) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f349632b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.token = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.seqSt = 0;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.acceptBinaryType = null;
        return;
    L15:
        this.acceptBinaryType = r103;
        return;
    L11:
        this.seqSt = r102;
        goto L13
    L7:
        this.token = r101;
        goto L9
    }

    public /* synthetic */ FetchChunkMessageUplinkBody(String r100, int r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
