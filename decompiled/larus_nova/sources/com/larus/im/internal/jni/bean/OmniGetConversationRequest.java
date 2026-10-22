package com.larus.im.internal.jni.bean;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import de9.k7;
import de9.l7;
import java.util.Map;
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
import nuc.a1;
import nuc.b2;
import nuc.q2;
import nuc.v2;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 -2\u00060\u0001j\u0002`\u0002:\u0002,-BM\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fBY\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u000b\u0010\u0011J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J\u0017\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\nHÆ\u0003JO\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u000eHÖ\u0001J\t\u0010#\u001a\u00020\u0004HÖ\u0001J%\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0001¢\u0006\u0002\b+R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0014\u0010\u0013R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0015\u0010\u0013R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0016\u0010\u0013R$\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0017\u0010\u0013¨\u0006."}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniGetConversationRequest;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "conversationId", "", "botId", "localConversationId", "source", "Lcom/larus/im/internal/jni/bean/OmniGetConversationSource;", "ext", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/internal/jni/bean/OmniGetConversationSource;Ljava/util/Map;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/internal/jni/bean/OmniGetConversationSource;Ljava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getConversationId$annotations", "()V", "getBotId$annotations", "getLocalConversationId$annotations", "getSource$annotations", "getExt$annotations", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_release", "$serializer", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OmniGetConversationRequest implements java.io.Serializable {
    private static final Lazy<d<Object>>[] $childSerializers = null;
    public static final Companion Companion = null;
    public final String botId;
    public final String conversationId;
    public final Map<String, String> ext;
    public final String localConversationId;
    public final OmniGetConversationSource source;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniGetConversationRequest$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OmniGetConversationRequest;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OmniGetConversationRequest> serializer() {
            return OmniGetConversationRequest$$serializer.INSTANCE;
        }
    }

    public OmniGetConversationRequest() {
        this(null, null, null, null, null, 31, null);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_() {
        return OmniGetConversationSource.Companion.serializer();
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_$0() {
        v2 r100 = v2.f520790a;
        return new a1(r100, r100);
    }

    public static /* synthetic */ d a() {
        return _childSerializers$_anonymous_$0();
    }

    public static /* synthetic */ d b() {
        return _childSerializers$_anonymous_();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OmniGetConversationRequest copy$default(OmniGetConversationRequest r100, String r101, String r102, String r103, OmniGetConversationSource r104, Map r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.conversationId;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.botId;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.localConversationId;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.source;
    L14:
        OmniGetConversationSource r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.ext;
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

    @SerialName("ext")
    public static /* synthetic */ void getExt$annotations() {
    }

    @SerialName("local_conversation_id")
    public static /* synthetic */ void getLocalConversationId$annotations() {
    }

    @SerialName("source")
    public static /* synthetic */ void getSource$annotations() {
    }

    public final String component1() {
        return this.conversationId;
    }

    public final String component2() {
        return this.botId;
    }

    public final String component3() {
        return this.localConversationId;
    }

    public final OmniGetConversationSource component4() {
        return this.source;
    }

    public final Map<String, String> component5() {
        return this.ext;
    }

    public final OmniGetConversationRequest copy(String r100, String r101, String r110, OmniGetConversationSource r111, Map<String, String> r112) {
        Intrinsics.checkNotNullParameter(r111, "source");
        return new OmniGetConversationRequest(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OmniGetConversationRequest) == true) goto L8;
        return false;
    L8:
        OmniGetConversationRequest r101 = (OmniGetConversationRequest) r100;
        if (Intrinsics.areEqual(this.conversationId, r101.conversationId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.botId, r101.botId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.localConversationId, r101.localConversationId) == true) goto L18;
        return false;
    L18:
        if (this.source == r101.source) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.ext, r101.ext) == true) goto L23;
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
        int r103 = r102 * 31;
        String r104 = this.botId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.localConversationId;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (((r106 + r108) * 31) + this.source.hashCode()) * 31;
        Map<String, String> r110 = this.ext;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "OmniGetConversationRequest(conversationId=" + this.conversationId + ", botId=" + this.botId + ", localConversationId=" + this.localConversationId + ", source=" + this.source + ", ext=" + this.ext + ')';
    }

    static {
        Companion = new Companion(null);
        LazyThreadSafetyMode r100 = LazyThreadSafetyMode.PUBLICATION;
        $childSerializers = new Lazy[]{null, null, null, LazyKt.lazy(r100, new k7()), LazyKt.lazy(r100, new l7())};
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_release(OmniGetConversationRequest r100, muc.d r101, f r102) {
        Lazy<d<Object>>[] r103 = $childSerializers;
        boolean r104 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r105 = true;
    L9:
        if (r105 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, v2.f520790a, r100.conversationId);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r106 = true;
    L18:
        if (r106 == false) goto L21;
        r101.encodeNullableSerializableElement(r102, 1, v2.f520790a, r100.botId);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r107 = true;
    L27:
        if (r107 == false) goto L30;
        r101.encodeNullableSerializableElement(r102, 2, v2.f520790a, r100.localConversationId);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        boolean r108 = true;
    L36:
        if (r108 == false) goto L39;
        r101.encodeSerializableElement(r102, 3, r103[3].getValue(), r100.source);
    L39:
        if (r101.shouldEncodeElementDefault(r102, 4) == false) goto L42;
    L40:
        r104 = true;
    L44:
        if (r104 == false) goto L47;
        r101.encodeNullableSerializableElement(r102, 4, r103[4].getValue(), r100.ext);
        return;
    L47:
        return;
    L42:
        if (r100.ext == null) goto L44;
    L33:
        if (r100.source != OmniGetConversationSource.OmniGetConversationSource_LOCAL) goto L31;
        r108 = false;
        goto L36
    L24:
        if (r100.localConversationId != null) goto L22;
        r107 = false;
        goto L27
    L15:
        if (r100.botId != null) goto L13;
        r106 = false;
        goto L18
    L6:
        if (r100.conversationId != null) goto L4;
        r105 = false;
        goto L9
    }

    public OmniGetConversationRequest(String r100, String r101, String r102, OmniGetConversationSource r103, Map<String, String> r104) {
        Intrinsics.checkNotNullParameter(r103, "source");
        this.conversationId = r100;
        this.botId = r101;
        this.localConversationId = r102;
        this.source = r103;
        this.ext = r104;
    }

    public /* synthetic */ OmniGetConversationRequest(int r100, String r101, String r102, String r103, OmniGetConversationSource r104, Map r105, q2 r106) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, OmniGetConversationRequest$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.conversationId = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.botId = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.localConversationId = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.source = OmniGetConversationSource.OmniGetConversationSource_LOCAL;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.ext = null;
        return;
    L23:
        this.ext = r105;
        return;
    L19:
        this.source = r104;
        goto L21
    L15:
        this.localConversationId = r103;
        goto L17
    L11:
        this.botId = r102;
        goto L13
    L7:
        this.conversationId = r101;
        goto L9
    }

    public /* synthetic */ OmniGetConversationRequest(String r100, String r101, String r102, OmniGetConversationSource r103, Map r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        String r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        String r105 = null;
    L11:
        if ((r110 & 4) == 0) goto L13;
        String r106 = null;
    L15:
        if ((r110 & 8) == 0) goto L17;
        r103 = OmniGetConversationSource.OmniGetConversationSource_LOCAL;
    L17:
        OmniGetConversationSource r107 = r103;
        if ((r110 & 16) == 0) goto L20;
        Map r113 = null;
    L21:
        this(r112, r105, r106, r107, r113);
        return;
    L20:
        r113 = r104;
        goto L21
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
