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
import nuc.g1;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.q2;
import nuc.v2;
import nuc.w0;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 +2\u00060\u0001j\u0002`\u0002:\u0002+,B=\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000b\u0010\fBG\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u000b\u0010\u0010J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0004HÆ\u0003J?\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u0006HÖ\u0001J\t\u0010\"\u001a\u00020\u0004HÖ\u0001J%\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0001¢\u0006\u0002\b*R\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0013\u0010\u0012R\u0018\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0014\u0010\u0012R\u0018\u0010\t\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0015\u0010\u0012R\u001a\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0016\u0010\u0012¨\u0006-"}, d2 = {"Lcom/larus/im/internal/protocol/bean/DeleteUserConversationUplinkBody;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "conversationId", "", "mode", "", "clearMessageIndex", "", "conversationType", "botId", "<init>", "(Ljava/lang/String;IJILjava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;IJILjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getConversationId$annotations", "()V", "getMode$annotations", "getClearMessageIndex$annotations", "getConversationType$annotations", "getBotId$annotations", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$imsdkkmp_api_release", "Companion", "$serializer", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class DeleteUserConversationUplinkBody implements java.io.Serializable {
    public static final b Companion = null;
    private static final long serialVersionUID = 1;
    public String botId;
    public long clearMessageIndex;
    public String conversationId;
    public int conversationType;
    public int mode;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<DeleteUserConversationUplinkBody> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f349623a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f349624b = null;

        public a() {
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            v2 r100 = v2.f520790a;
            w0 r101 = w0.f520792a;
            return new d[]{kuc.a.d(r100), r101, g1.f520681a, r101, kuc.a.d(r100)};
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f349624b;
        }

        static {
            a r100 = new a();
            f349623a = r100;
            g2 r101 = new g2("com.larus.im.internal.protocol.bean.DeleteUserConversationUplinkBody", r100, 5);
            r101.j("conversation_id", true);
            r101.j("mode", true);
            r101.j("clear_message_index", true);
            r101.j("conversation_type", true);
            r101.j("bot_id", true);
            f349624b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r210) {
            Intrinsics.checkNotNullParameter(r210, "decoder");
            g2 r100 = f349624b;
            muc.c r101 = r210.beginStructure(r100);
            if (r101.decodeSequentially() == false) goto L5;
            v2 r102 = v2.f520790a;
            String r103 = (String) r101.decodeNullableSerializableElement(r100, 0, r102, null);
            int r104 = r101.decodeIntElement(r100, 1);
            long r105 = r101.decodeLongElement(r100, 2);
            int r106 = r101.decodeIntElement(r100, 3);
            String r211 = (String) r101.decodeNullableSerializableElement(r100, 4, r102, null);
            int r212 = r106;
            int r110 = r104;
            String r111 = r103;
            long r213 = r105;
            int r112 = 31;
        L25:
            r101.endStructure(r100);
            return new DeleteUserConversationUplinkBody(r112, r111, r110, r213, r212, r211, null);
        L5:
            String r113 = null;
            long r114 = 0;
            int r107 = 0;
            int r108 = 0;
            boolean r115 = true;
            String r116 = null;
            int r109 = 0;
        L6:
            if (r115 == false) goto L24;
            int r117 = r101.decodeElementIndex(r100);
            if (r117 != (-1)) goto L9;
            r115 = false;
            goto L6
        L9:
            if (r117 == 0) goto L21;
            if (r117 == 1) goto L19;
            if (r117 == 2) goto L18;
            if (r117 == 3) goto L17;
            if (r117 != 4) goto L16;
            r113 = (String) r101.decodeNullableSerializableElement(r100, 4, v2.f520790a, r113);
            int r118 = r109 | 16;
        L20:
            r109 = r118;
            goto L6
        L16:
            throw new UnknownFieldException(r117);
        L17:
            r107 = r101.decodeIntElement(r100, 3);
            r118 = r109 | 8;
            goto L20
        L18:
            r114 = r101.decodeLongElement(r100, 2);
            r118 = r109 | 4;
            goto L20
        L19:
            r108 = r101.decodeIntElement(r100, 1);
            r118 = r109 | 2;
            goto L20
        L21:
            r109 = r109 | 1;
            r116 = (String) r101.decodeNullableSerializableElement(r100, 0, v2.f520790a, r116);
            goto L6
        L24:
            r212 = r107;
            r112 = r109;
            r110 = r108;
            r111 = r116;
            r211 = r113;
            r213 = r114;
            goto L25
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            DeleteUserConversationUplinkBody r102 = (DeleteUserConversationUplinkBody) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f349624b;
            muc.d r104 = r100.beginStructure(r103);
            DeleteUserConversationUplinkBody.write$Self$imsdkkmp_api_release(r102, r104, r103);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<DeleteUserConversationUplinkBody> serializer() {
            return a.f349623a;
        }
    }

    public DeleteUserConversationUplinkBody() {
        this(null, 0, 0, 0, null, 31, null);
    }

    public static /* synthetic */ DeleteUserConversationUplinkBody copy$default(DeleteUserConversationUplinkBody r100, String r101, int r102, long r103, int r104, String r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.conversationId;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.mode;
    L8:
        int r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.clearMessageIndex;
    L11:
        long r105 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.conversationType;
    L14:
        int r106 = r104;
        if ((r111 & 16) == 0) goto L17;
        r110 = r100.botId;
    L17:
        String r107 = r101;
        return r100.copy(r107, r113, r105, r106, r110);
    }

    @SerialName("bot_id")
    public static /* synthetic */ void getBotId$annotations() {
    }

    @SerialName("clear_message_index")
    public static /* synthetic */ void getClearMessageIndex$annotations() {
    }

    @SerialName("conversation_id")
    public static /* synthetic */ void getConversationId$annotations() {
    }

    @SerialName("conversation_type")
    public static /* synthetic */ void getConversationType$annotations() {
    }

    @SerialName("mode")
    public static /* synthetic */ void getMode$annotations() {
    }

    public final String component1() {
        return this.conversationId;
    }

    public final int component2() {
        return this.mode;
    }

    public final long component3() {
        return this.clearMessageIndex;
    }

    public final int component4() {
        return this.conversationType;
    }

    public final String component5() {
        return this.botId;
    }

    public final DeleteUserConversationUplinkBody copy(String r100, int r110, long r111, int r112, String r113) {
        return new DeleteUserConversationUplinkBody(r100, r110, r111, r112, r113);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DeleteUserConversationUplinkBody) == true) goto L8;
        return false;
    L8:
        DeleteUserConversationUplinkBody r101 = (DeleteUserConversationUplinkBody) r100;
        if (Intrinsics.areEqual(this.conversationId, r101.conversationId) == true) goto L12;
        return false;
    L12:
        if (this.mode == r101.mode) goto L15;
        return false;
    L15:
        if (this.clearMessageIndex == r101.clearMessageIndex) goto L18;
        return false;
    L18:
        if (this.conversationType == r101.conversationType) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.botId, r101.botId) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r100 = this.conversationId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.mode) * 31;
        long r104 = this.clearMessageIndex;
        int r105 = (((r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31) + this.conversationType) * 31;
        String r106 = this.botId;
        if (r106 == null) goto L11;
        r101 = r106.hashCode();
    L11:
        return r105 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "DeleteUserConversationUplinkBody(conversationId=" + this.conversationId + ", mode=" + this.mode + ", clearMessageIndex=" + this.clearMessageIndex + ", conversationType=" + this.conversationType + ", botId=" + this.botId + ')';
    }

    static {
        Companion = new b();
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$imsdkkmp_api_release(DeleteUserConversationUplinkBody r100, muc.d r101, f r110) {
        boolean r102 = false;
        if (r101.shouldEncodeElementDefault(r110, 0) == false) goto L6;
    L4:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L12;
        r101.encodeNullableSerializableElement(r110, 0, v2.f520790a, r100.conversationId);
    L12:
        if (r101.shouldEncodeElementDefault(r110, 1) == false) goto L15;
    L13:
        boolean r104 = true;
    L18:
        if (r104 == false) goto L21;
        r101.encodeIntElement(r110, 1, r100.mode);
    L21:
        if (r101.shouldEncodeElementDefault(r110, 2) == false) goto L24;
    L22:
        boolean r105 = true;
    L27:
        if (r105 == false) goto L30;
        r101.encodeLongElement(r110, 2, r100.clearMessageIndex);
    L30:
        if (r101.shouldEncodeElementDefault(r110, 3) == false) goto L33;
    L31:
        boolean r106 = true;
    L36:
        if (r106 == false) goto L39;
        r101.encodeIntElement(r110, 3, r100.conversationType);
    L39:
        if (r101.shouldEncodeElementDefault(r110, 4) == false) goto L42;
    L40:
        r102 = true;
    L44:
        if (r102 == false) goto L47;
        r101.encodeNullableSerializableElement(r110, 4, v2.f520790a, r100.botId);
        return;
    L47:
        return;
    L42:
        if (r100.botId == null) goto L44;
    L33:
        if (r100.conversationType != 0) goto L31;
        r106 = false;
        goto L36
    L24:
        if (r100.clearMessageIndex != 0) goto L22;
        r105 = false;
        goto L27
    L15:
        if (r100.mode != 0) goto L13;
        r104 = false;
        goto L18
    L6:
        if (r100.conversationId != null) goto L4;
        r103 = false;
        goto L9
    }

    public DeleteUserConversationUplinkBody(String r100, int r101, long r102, int r103, String r104) {
        this.conversationId = r100;
        this.mode = r101;
        this.clearMessageIndex = r102;
        this.conversationType = r103;
        this.botId = r104;
    }

    public DeleteUserConversationUplinkBody(int r100, String r101, int r102, long r103, int r104, String r105, q2 r110) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f349624b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.conversationId = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.mode = 0;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.clearMessageIndex = 0;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.conversationType = 0;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.botId = null;
        return;
    L23:
        this.botId = r105;
        return;
    L19:
        this.conversationType = r104;
        goto L21
    L15:
        this.clearMessageIndex = r103;
        goto L17
    L11:
        this.mode = r102;
        goto L13
    L7:
        this.conversationId = r101;
        goto L9
    }

    public /* synthetic */ DeleteUserConversationUplinkBody(String r100, int r101, long r102, int r110, String r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        String r114 = null;
    L6:
        int r103 = 0;
        if ((r112 & 2) == 0) goto L9;
        int r104 = 0;
    L11:
        if ((r112 & 4) == 0) goto L13;
        r102 = 0;
    L13:
        long r105 = r102;
        if ((r112 & 8) != 0) goto L18;
        r103 = r110;
    L18:
        if ((r112 & 16) == 0) goto L20;
        String r115 = null;
    L21:
        this(r114, r104, r105, r103, r115);
        return;
    L20:
        r115 = r111;
        goto L21
    L9:
        r104 = r101;
        goto L11
    L5:
        r114 = r100;
        goto L6
    }
}
