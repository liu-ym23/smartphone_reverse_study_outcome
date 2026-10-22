package com.larus.im.internal.jni.bean;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import de9.g7;
import juc.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
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
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ,2\u00060\u0001j\u0002`\u0002:\u0002+,B?\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000b\u0010\fBK\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u000b\u0010\u0011J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0004HÆ\u0003JA\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\t2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u000eHÖ\u0001J\t\u0010\"\u001a\u00020\u0004HÖ\u0001J%\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0001¢\u0006\u0002\b*R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0014\u0010\u0013R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0015\u0010\u0013R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0016\u0010\u0013R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0017\u0010\u0013¨\u0006-"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniGetBotRequest;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "botId", "", "conversationId", "mode", "Lcom/larus/im/internal/jni/bean/OmniGetBotMode;", "syncLocal", "", "source", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/internal/jni/bean/OmniGetBotMode;ZLjava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lcom/larus/im/internal/jni/bean/OmniGetBotMode;ZLjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getBotId$annotations", "()V", "getConversationId$annotations", "getMode$annotations", "getSyncLocal$annotations", "getSource$annotations", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_release", "$serializer", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OmniGetBotRequest implements java.io.Serializable {
    private static final Lazy<d<Object>>[] $childSerializers = null;
    public static final Companion Companion = null;
    public final String botId;
    public final String conversationId;
    public final OmniGetBotMode mode;
    public final String source;
    public final boolean syncLocal;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniGetBotRequest$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OmniGetBotRequest;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OmniGetBotRequest> serializer() {
            return OmniGetBotRequest$$serializer.INSTANCE;
        }
    }

    public OmniGetBotRequest() {
        this(null, null, null, false, null, 31, null);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_() {
        return OmniGetBotMode.Companion.serializer();
    }

    public static /* synthetic */ d a() {
        return _childSerializers$_anonymous_();
    }

    public static /* synthetic */ OmniGetBotRequest copy$default(OmniGetBotRequest r100, String r101, String r102, OmniGetBotMode r103, boolean r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.botId;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.conversationId;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.mode;
    L11:
        OmniGetBotMode r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.syncLocal;
    L14:
        boolean r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.source;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    @SerialName("bot_id")
    public static /* synthetic */ void getBotId$annotations() {
    }

    @SerialName("conversation_id")
    public static /* synthetic */ void getConversationId$annotations() {
    }

    @SerialName("mode")
    public static /* synthetic */ void getMode$annotations() {
    }

    @SerialName("source")
    public static /* synthetic */ void getSource$annotations() {
    }

    @SerialName("sync_local")
    public static /* synthetic */ void getSyncLocal$annotations() {
    }

    public final String component1() {
        return this.botId;
    }

    public final String component2() {
        return this.conversationId;
    }

    public final OmniGetBotMode component3() {
        return this.mode;
    }

    public final boolean component4() {
        return this.syncLocal;
    }

    public final String component5() {
        return this.source;
    }

    public final OmniGetBotRequest copy(String r100, String r101, OmniGetBotMode r110, boolean r111, String r112) {
        Intrinsics.checkNotNullParameter(r110, "mode");
        return new OmniGetBotRequest(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OmniGetBotRequest) == true) goto L8;
        return false;
    L8:
        OmniGetBotRequest r101 = (OmniGetBotRequest) r100;
        if (Intrinsics.areEqual(this.botId, r101.botId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.conversationId, r101.conversationId) == true) goto L15;
        return false;
    L15:
        if (this.mode == r101.mode) goto L18;
        return false;
    L18:
        if (this.syncLocal == r101.syncLocal) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.source, r101.source) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r100 = this.botId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.conversationId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (((r103 + r105) * 31) + this.mode.hashCode()) * 31;
        if (this.syncLocal == false) goto L13;
        int r107 = 1231;
    L14:
        int r108 = (r106 + r107) * 31;
        String r109 = this.source;
        if (r109 == null) goto L19;
        r101 = r109.hashCode();
    L19:
        return r108 + r101;
    L13:
        r107 = 1237;
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "OmniGetBotRequest(botId=" + this.botId + ", conversationId=" + this.conversationId + ", mode=" + this.mode + ", syncLocal=" + this.syncLocal + ", source=" + this.source + ')';
    }

    static {
        Companion = new Companion(null);
        $childSerializers = new Lazy[]{null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new g7()), null, null};
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_release(OmniGetBotRequest r100, muc.d r101, f r102) {
        Lazy<d<Object>>[] r103 = $childSerializers;
        boolean r104 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r105 = true;
    L9:
        if (r105 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, v2.f520790a, r100.botId);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r106 = true;
    L18:
        if (r106 == false) goto L21;
        r101.encodeNullableSerializableElement(r102, 1, v2.f520790a, r100.conversationId);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r107 = true;
    L27:
        if (r107 == false) goto L30;
        r101.encodeSerializableElement(r102, 2, r103[2].getValue(), r100.mode);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        boolean r108 = true;
    L36:
        if (r108 == false) goto L39;
        r101.encodeBooleanElement(r102, 3, r100.syncLocal);
    L39:
        if (r101.shouldEncodeElementDefault(r102, 4) == false) goto L42;
    L40:
        r104 = true;
    L44:
        if (r104 == false) goto L47;
        r101.encodeNullableSerializableElement(r102, 4, v2.f520790a, r100.source);
        return;
    L47:
        return;
    L42:
        if (r100.source == null) goto L44;
    L33:
        if (r100.syncLocal == true) goto L31;
        r108 = false;
        goto L36
    L24:
        if (r100.mode != OmniGetBotMode.OmniGetBotMode_LOCAL) goto L22;
        r107 = false;
        goto L27
    L15:
        if (r100.conversationId != null) goto L13;
        r106 = false;
        goto L18
    L6:
        if (r100.botId != null) goto L4;
        r105 = false;
        goto L9
    }

    public OmniGetBotRequest(String r100, String r101, OmniGetBotMode r102, boolean r103, String r104) {
        Intrinsics.checkNotNullParameter(r102, "mode");
        this.botId = r100;
        this.conversationId = r101;
        this.mode = r102;
        this.syncLocal = r103;
        this.source = r104;
    }

    public /* synthetic */ OmniGetBotRequest(int r100, String r101, String r102, OmniGetBotMode r103, boolean r104, String r105, q2 r106) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, OmniGetBotRequest$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.botId = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.conversationId = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.mode = OmniGetBotMode.OmniGetBotMode_LOCAL;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.syncLocal = false;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.source = null;
        return;
    L23:
        this.source = r105;
        return;
    L19:
        this.syncLocal = r104;
        goto L21
    L15:
        this.mode = r103;
        goto L17
    L11:
        this.conversationId = r102;
        goto L13
    L7:
        this.botId = r101;
        goto L9
    }

    public /* synthetic */ OmniGetBotRequest(String r100, String r101, OmniGetBotMode r102, boolean r103, String r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        String r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        String r105 = null;
    L11:
        if ((r110 & 4) == 0) goto L13;
        r102 = OmniGetBotMode.OmniGetBotMode_LOCAL;
    L13:
        OmniGetBotMode r106 = r102;
        if ((r110 & 8) == 0) goto L16;
        boolean r107 = false;
    L18:
        if ((r110 & 16) == 0) goto L20;
        String r113 = null;
    L21:
        this(r112, r105, r106, r107, r113);
        return;
    L20:
        r113 = r104;
        goto L21
    L16:
        r107 = r103;
        goto L18
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
