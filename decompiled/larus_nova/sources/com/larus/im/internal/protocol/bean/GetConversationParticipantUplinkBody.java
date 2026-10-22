package com.larus.im.internal.protocol.bean;

import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
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
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 '2\u00060\u0001j\u0002`\u0002:\u0002'(B1\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nB=\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\t\u0010\u000eJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J3\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0004HÖ\u0001J%\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0002\b&R\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0011\u0010\u0010R\u0018\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0012\u0010\u0010R\u0018\u0010\b\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0013\u0010\u0010¨\u0006)"}, d2 = {"Lcom/larus/im/internal/protocol/bean/GetConversationParticipantUplinkBody;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "conversationId", "", "offset", "", VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT, "conversationType", "<init>", "(Ljava/lang/String;III)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;IIILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getConversationId$annotations", "()V", "getOffset$annotations", "getLimit$annotations", "getConversationType$annotations", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$imsdkkmp_api_release", "Companion", "$serializer", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class GetConversationParticipantUplinkBody implements java.io.Serializable {
    public static final b Companion = null;
    private static final long serialVersionUID = 1;
    public String conversationId;
    public int conversationType;
    public int limit;
    public int offset;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<GetConversationParticipantUplinkBody> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f349641a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f349642b = null;

        public a() {
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            w0 r100 = w0.f520792a;
            return new d[]{kuc.a.d(v2.f520790a), r100, r100, r100};
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f349642b;
        }

        static {
            a r100 = new a();
            f349641a = r100;
            g2 r101 = new g2("com.larus.im.internal.protocol.bean.GetConversationParticipantUplinkBody", r100, 4);
            r101.j("conversation_id", true);
            r101.j("offset", true);
            r101.j(VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT, true);
            r101.j("conversation_type", true);
            f349642b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r210) {
            Intrinsics.checkNotNullParameter(r210, "decoder");
            g2 r100 = f349642b;
            muc.c r101 = r210.beginStructure(r100);
            if (r101.decodeSequentially() == false) goto L5;
            String r102 = (String) r101.decodeNullableSerializableElement(r100, 0, v2.f520790a, null);
            int r103 = r101.decodeIntElement(r100, 1);
            String r110 = r102;
            int r111 = r101.decodeIntElement(r100, 2);
            int r112 = r103;
            int r113 = r101.decodeIntElement(r100, 3);
            int r114 = 15;
        L21:
            r101.endStructure(r100);
            return new GetConversationParticipantUplinkBody(r114, r110, r112, r111, r113, null);
        L5:
            String r115 = null;
            int r104 = 0;
            int r105 = 0;
            int r106 = 0;
            int r107 = 0;
            boolean r116 = true;
        L6:
            if (r116 == false) goto L20;
            int r117 = r101.decodeElementIndex(r100);
            if (r117 != (-1)) goto L9;
            r116 = false;
            goto L6
        L9:
            if (r117 != 0) goto L10;
            r115 = (String) r101.decodeNullableSerializableElement(r100, 0, v2.f520790a, r115);
            r107 = r107 | 1;
            goto L6
        L10:
            if (r117 != 1) goto L11;
            r105 = r101.decodeIntElement(r100, 1);
            r107 = r107 | 2;
            goto L6
        L11:
            if (r117 != 2) goto L12;
            r104 = r101.decodeIntElement(r100, 2);
            r107 = r107 | 4;
            goto L6
        L12:
            if (r117 != 3) goto L15;
            r106 = r101.decodeIntElement(r100, 3);
            r107 = r107 | 8;
            goto L6
        L15:
            throw new UnknownFieldException(r117);
        L20:
            r111 = r104;
            r112 = r105;
            r113 = r106;
            r114 = r107;
            r110 = r115;
            goto L21
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            GetConversationParticipantUplinkBody r102 = (GetConversationParticipantUplinkBody) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f349642b;
            muc.d r104 = r100.beginStructure(r103);
            GetConversationParticipantUplinkBody.write$Self$imsdkkmp_api_release(r102, r104, r103);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<GetConversationParticipantUplinkBody> serializer() {
            return a.f349641a;
        }
    }

    public GetConversationParticipantUplinkBody() {
        this(null, 0, 0, 0, 15, null);
    }

    public static /* synthetic */ GetConversationParticipantUplinkBody copy$default(GetConversationParticipantUplinkBody r100, String r101, int r102, int r103, int r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.conversationId;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.offset;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.limit;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.conversationType;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    @SerialName("conversation_id")
    public static /* synthetic */ void getConversationId$annotations() {
    }

    @SerialName("conversation_type")
    public static /* synthetic */ void getConversationType$annotations() {
    }

    @SerialName(VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT)
    public static /* synthetic */ void getLimit$annotations() {
    }

    @SerialName("offset")
    public static /* synthetic */ void getOffset$annotations() {
    }

    public final String component1() {
        return this.conversationId;
    }

    public final int component2() {
        return this.offset;
    }

    public final int component3() {
        return this.limit;
    }

    public final int component4() {
        return this.conversationType;
    }

    public final GetConversationParticipantUplinkBody copy(String r100, int r101, int r102, int r103) {
        return new GetConversationParticipantUplinkBody(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GetConversationParticipantUplinkBody) == true) goto L8;
        return false;
    L8:
        GetConversationParticipantUplinkBody r101 = (GetConversationParticipantUplinkBody) r100;
        if (Intrinsics.areEqual(this.conversationId, r101.conversationId) == true) goto L12;
        return false;
    L12:
        if (this.offset == r101.offset) goto L15;
        return false;
    L15:
        if (this.limit == r101.limit) goto L18;
        return false;
    L18:
        if (this.conversationType == r101.conversationType) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r100 = this.conversationId;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (((((r101 * 31) + this.offset) * 31) + this.limit) * 31) + this.conversationType;
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public String toString() {
        return "GetConversationParticipantUplinkBody(conversationId=" + this.conversationId + ", offset=" + this.offset + ", limit=" + this.limit + ", conversationType=" + this.conversationType + ')';
    }

    static {
        Companion = new b();
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$imsdkkmp_api_release(GetConversationParticipantUplinkBody r100, muc.d r101, f r102) {
        boolean r103 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, v2.f520790a, r100.conversationId);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r105 = true;
    L18:
        if (r105 == false) goto L21;
        r101.encodeIntElement(r102, 1, r100.offset);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r106 = true;
    L27:
        if (r106 == false) goto L30;
        r101.encodeIntElement(r102, 2, r100.limit);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        r103 = true;
    L35:
        if (r103 == false) goto L38;
        r101.encodeIntElement(r102, 3, r100.conversationType);
        return;
    L38:
        return;
    L33:
        if (r100.conversationType == 0) goto L35;
    L24:
        if (r100.limit != 0) goto L22;
        r106 = false;
        goto L27
    L15:
        if (r100.offset != 0) goto L13;
        r105 = false;
        goto L18
    L6:
        if (r100.conversationId != null) goto L4;
        r104 = false;
        goto L9
    }

    public GetConversationParticipantUplinkBody(String r100, int r101, int r102, int r103) {
        this.conversationId = r100;
        this.offset = r101;
        this.limit = r102;
        this.conversationType = r103;
    }

    public GetConversationParticipantUplinkBody(int r100, String r101, int r102, int r103, int r104, q2 r105) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f349642b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.conversationId = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.offset = 0;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.limit = 0;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.conversationType = 0;
        return;
    L19:
        this.conversationType = r104;
        return;
    L15:
        this.limit = r103;
        goto L17
    L11:
        this.offset = r102;
        goto L13
    L7:
        this.conversationId = r101;
        goto L9
    }

    public /* synthetic */ GetConversationParticipantUplinkBody(String r100, int r101, int r102, int r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = 0;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = 0;
    L14:
        this(r100, r101, r102, r103);
    }
}
