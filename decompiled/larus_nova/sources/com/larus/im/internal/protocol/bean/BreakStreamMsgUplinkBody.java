package com.larus.im.internal.protocol.bean;

import af9.m;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.im.internal.jni.bean.OmniBreakReason;
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
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.q2;
import nuc.v2;
import nuc.w0;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 +2\u00060\u0001j\u0002`\u0002:\u0002+,B?\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fBK\b\u0010\u0012\u0006\u0010\r\u001a\u00020\b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u000b\u0010\u0010J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003JA\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\bHÖ\u0001J\t\u0010\"\u001a\u00020\u0004HÖ\u0001J%\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0001¢\u0006\u0002\b*R\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0013\u0010\u0012R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0014\u0010\u0012R\u0018\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0015\u0010\u0012R\u0018\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0016\u0010\u0012¨\u0006-"}, d2 = {"Lcom/larus/im/internal/protocol/bean/BreakStreamMsgUplinkBody;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "replyMsgId", "", "messageId", "conversationId", "conversationType", "", "breakReason", "Lcom/larus/im/internal/jni/bean/OmniBreakReason;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/larus/im/internal/jni/bean/OmniBreakReason;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/larus/im/internal/jni/bean/OmniBreakReason;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getReplyMsgId$annotations", "()V", "getMessageId$annotations", "getConversationId$annotations", "getConversationType$annotations", "getBreakReason$annotations", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$imsdkkmp_api_release", "Companion", "$serializer", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class BreakStreamMsgUplinkBody implements java.io.Serializable {
    private static final Lazy<d<Object>>[] $childSerializers = null;
    public static final b Companion = null;
    private static final long serialVersionUID = 1;
    public OmniBreakReason breakReason;
    public String conversationId;
    public int conversationType;
    public String messageId;
    public String replyMsgId;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<BreakStreamMsgUplinkBody> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f349600a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f349601b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f349601b;
        }

        static {
            a r100 = new a();
            f349600a = r100;
            g2 r101 = new g2("com.larus.im.internal.protocol.bean.BreakStreamMsgUplinkBody", r100, 5);
            r101.j("reply_msg_id", true);
            r101.j(MusicAppletPage.KEY_MESSAGE_ID, true);
            r101.j("conversation_id", true);
            r101.j("conversation_type", true);
            r101.j("break_reason", true);
            f349601b = r101;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            Lazy[] r100 = BreakStreamMsgUplinkBody.access$get$childSerializers$cp();
            v2 r101 = v2.f520790a;
            return new d[]{kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r101), w0.f520792a, r100[4].getValue()};
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r210) {
            Intrinsics.checkNotNullParameter(r210, "decoder");
            g2 r100 = f349601b;
            muc.c r101 = r210.beginStructure(r100);
            Lazy[] r102 = BreakStreamMsgUplinkBody.access$get$childSerializers$cp();
            if (r101.decodeSequentially() == false) goto L5;
            v2 r103 = v2.f520790a;
            String r104 = (String) r101.decodeNullableSerializableElement(r100, 0, r103, null);
            String r105 = (String) r101.decodeNullableSerializableElement(r100, 1, r103, null);
            String r106 = (String) r101.decodeNullableSerializableElement(r100, 2, r103, null);
            int r107 = r101.decodeIntElement(r100, 3);
            OmniBreakReason r211 = (OmniBreakReason) r101.decodeSerializableElement(r100, 4, (juc.c) r102[4].getValue(), null);
            String r212 = r106;
            int r213 = r107;
            String r110 = r105;
            String r111 = r104;
            int r112 = 31;
        L25:
            r101.endStructure(r100);
            return new BreakStreamMsgUplinkBody(r112, r111, r110, r212, r213, r211, null);
        L5:
            String r113 = null;
            String r114 = null;
            String r115 = null;
            OmniBreakReason r116 = null;
            int r108 = 0;
            int r109 = 0;
            boolean r117 = true;
        L6:
            if (r117 == false) goto L24;
            int r118 = r101.decodeElementIndex(r100);
            if (r118 != (-1)) goto L9;
            r117 = false;
            goto L6
        L9:
            if (r118 == 0) goto L21;
            if (r118 == 1) goto L19;
            if (r118 == 2) goto L18;
            if (r118 == 3) goto L17;
            if (r118 != 4) goto L16;
            r116 = (OmniBreakReason) r101.decodeSerializableElement(r100, 4, (juc.c) r102[4].getValue(), r116);
            r108 = r108 | 16;
            goto L6
        L16:
            throw new UnknownFieldException(r118);
        L17:
            r108 = r108 | 8;
            r109 = r101.decodeIntElement(r100, 3);
            goto L6
        L18:
            r115 = (String) r101.decodeNullableSerializableElement(r100, 2, v2.f520790a, r115);
            r108 = r108 | 4;
            goto L6
        L19:
            r114 = (String) r101.decodeNullableSerializableElement(r100, 1, v2.f520790a, r114);
            r108 = r108 | 2;
            goto L6
        L21:
            r108 = r108 | 1;
            r113 = (String) r101.decodeNullableSerializableElement(r100, 0, v2.f520790a, r113);
            goto L6
        L24:
            r112 = r108;
            r213 = r109;
            r111 = r113;
            r110 = r114;
            r212 = r115;
            r211 = r116;
            goto L25
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            BreakStreamMsgUplinkBody r102 = (BreakStreamMsgUplinkBody) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f349601b;
            muc.d r104 = r100.beginStructure(r103);
            BreakStreamMsgUplinkBody.write$Self$imsdkkmp_api_release(r102, r104, r103);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<BreakStreamMsgUplinkBody> serializer() {
            return a.f349600a;
        }
    }

    public BreakStreamMsgUplinkBody() {
        this(null, null, null, 0, null, 31, null);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_() {
        return OmniBreakReason.Companion.serializer();
    }

    public static /* synthetic */ d a() {
        return _childSerializers$_anonymous_();
    }

    public static /* synthetic */ BreakStreamMsgUplinkBody copy$default(BreakStreamMsgUplinkBody r100, String r101, String r102, String r103, int r104, OmniBreakReason r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.replyMsgId;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.messageId;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.conversationId;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.conversationType;
    L14:
        int r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.breakReason;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    @SerialName("break_reason")
    public static /* synthetic */ void getBreakReason$annotations() {
    }

    @SerialName("conversation_id")
    public static /* synthetic */ void getConversationId$annotations() {
    }

    @SerialName("conversation_type")
    public static /* synthetic */ void getConversationType$annotations() {
    }

    @SerialName(MusicAppletPage.KEY_MESSAGE_ID)
    public static /* synthetic */ void getMessageId$annotations() {
    }

    @SerialName("reply_msg_id")
    public static /* synthetic */ void getReplyMsgId$annotations() {
    }

    public final String component1() {
        return this.replyMsgId;
    }

    public final String component2() {
        return this.messageId;
    }

    public final String component3() {
        return this.conversationId;
    }

    public final int component4() {
        return this.conversationType;
    }

    public final OmniBreakReason component5() {
        return this.breakReason;
    }

    public final BreakStreamMsgUplinkBody copy(String r100, String r101, String r110, int r111, OmniBreakReason r112) {
        Intrinsics.checkNotNullParameter(r112, "breakReason");
        return new BreakStreamMsgUplinkBody(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BreakStreamMsgUplinkBody) == true) goto L8;
        return false;
    L8:
        BreakStreamMsgUplinkBody r101 = (BreakStreamMsgUplinkBody) r100;
        if (Intrinsics.areEqual(this.replyMsgId, r101.replyMsgId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.messageId, r101.messageId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.conversationId, r101.conversationId) == true) goto L18;
        return false;
    L18:
        if (this.conversationType == r101.conversationType) goto L21;
        return false;
    L21:
        if (this.breakReason == r101.breakReason) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r100 = this.replyMsgId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.messageId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.conversationId;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return ((((r106 + r101) * 31) + this.conversationType) * 31) + this.breakReason.hashCode();
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "BreakStreamMsgUplinkBody(replyMsgId=" + this.replyMsgId + ", messageId=" + this.messageId + ", conversationId=" + this.conversationId + ", conversationType=" + this.conversationType + ", breakReason=" + this.breakReason + ')';
    }

    static {
        Companion = new b();
        $childSerializers = new Lazy[]{null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new m())};
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$imsdkkmp_api_release(BreakStreamMsgUplinkBody r100, muc.d r101, f r102) {
        Lazy<d<Object>>[] r103 = $childSerializers;
        boolean r104 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r105 = true;
    L9:
        if (r105 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, v2.f520790a, r100.replyMsgId);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r106 = true;
    L18:
        if (r106 == false) goto L21;
        r101.encodeNullableSerializableElement(r102, 1, v2.f520790a, r100.messageId);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r107 = true;
    L27:
        if (r107 == false) goto L30;
        r101.encodeNullableSerializableElement(r102, 2, v2.f520790a, r100.conversationId);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        boolean r108 = true;
    L36:
        if (r108 == false) goto L39;
        r101.encodeIntElement(r102, 3, r100.conversationType);
    L39:
        if (r101.shouldEncodeElementDefault(r102, 4) == false) goto L42;
    L40:
        r104 = true;
    L44:
        if (r104 == false) goto L47;
        r101.encodeSerializableElement(r102, 4, r103[4].getValue(), r100.breakReason);
        return;
    L47:
        return;
    L42:
        if (r100.breakReason == OmniBreakReason.OmniBreakReason_OTHER) goto L44;
    L33:
        if (r100.conversationType != 0) goto L31;
        r108 = false;
        goto L36
    L24:
        if (r100.conversationId != null) goto L22;
        r107 = false;
        goto L27
    L15:
        if (r100.messageId != null) goto L13;
        r106 = false;
        goto L18
    L6:
        if (r100.replyMsgId != null) goto L4;
        r105 = false;
        goto L9
    }

    public BreakStreamMsgUplinkBody(String r100, String r101, String r102, int r103, OmniBreakReason r104) {
        Intrinsics.checkNotNullParameter(r104, "breakReason");
        this.replyMsgId = r100;
        this.messageId = r101;
        this.conversationId = r102;
        this.conversationType = r103;
        this.breakReason = r104;
    }

    public BreakStreamMsgUplinkBody(int r100, String r101, String r102, String r103, int r104, OmniBreakReason r105, q2 r106) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f349601b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.replyMsgId = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.messageId = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.conversationId = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.conversationType = 0;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.breakReason = OmniBreakReason.OmniBreakReason_OTHER;
        return;
    L23:
        this.breakReason = r105;
        return;
    L19:
        this.conversationType = r104;
        goto L21
    L15:
        this.conversationId = r103;
        goto L17
    L11:
        this.messageId = r102;
        goto L13
    L7:
        this.replyMsgId = r101;
        goto L9
    }

    public /* synthetic */ BreakStreamMsgUplinkBody(String r100, String r101, String r102, int r103, OmniBreakReason r104, int r105, DefaultConstructorMarker r110) {
        String r106 = null;
        if ((r105 & 1) == 0) goto L5;
        String r111 = null;
    L7:
        if ((r105 & 2) == 0) goto L9;
        String r107 = null;
    L11:
        if ((r105 & 4) != 0) goto L15;
        r106 = r102;
    L15:
        if ((r105 & 8) == 0) goto L17;
        int r108 = 0;
    L19:
        if ((r105 & 16) == 0) goto L21;
        r104 = OmniBreakReason.OmniBreakReason_OTHER;
    L21:
        this(r111, r107, r106, r108, r104);
        return;
    L17:
        r108 = r103;
        goto L19
    L9:
        r107 = r101;
        goto L11
    L5:
        r111 = r100;
        goto L7
    }
}
