package com.larus.im.internal.jni.bean;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import de9.h7;
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
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 -2\u00060\u0001j\u0002`\u0002:\u0002,-B;\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rBG\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\f\u0010\u0012J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J\t\u0010\u001c\u001a\u00020\nHÆ\u0003J\t\u0010\u001d\u001a\u00020\nHÆ\u0003J=\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001f\u001a\u00020\u00062\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u000fHÖ\u0001J\t\u0010#\u001a\u00020\u0004HÖ\u0001J%\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0001¢\u0006\u0002\b+R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0015\u0010\u0014R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0016\u0010\u0014R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0017\u0010\u0014R\u0016\u0010\u000b\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0018\u0010\u0014¨\u0006."}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniGetConversationListAnchor;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "conversationId", "", "pinned", "", "conversationType", "Lcom/larus/im/internal/jni/bean/OmniBotConversationType;", "version", "", "pinTime", "<init>", "(Ljava/lang/String;ZLcom/larus/im/internal/jni/bean/OmniBotConversationType;JJ)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;ZLcom/larus/im/internal/jni/bean/OmniBotConversationType;JJLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getConversationId$annotations", "()V", "getPinned$annotations", "getConversationType$annotations", "getVersion$annotations", "getPinTime$annotations", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_release", "$serializer", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OmniGetConversationListAnchor implements java.io.Serializable {
    private static final Lazy<d<Object>>[] $childSerializers = null;
    public static final Companion Companion = null;
    public final String conversationId;
    public final OmniBotConversationType conversationType;
    public final long pinTime;
    public final boolean pinned;
    public final long version;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniGetConversationListAnchor$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OmniGetConversationListAnchor;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OmniGetConversationListAnchor> serializer() {
            return OmniGetConversationListAnchor$$serializer.INSTANCE;
        }
    }

    public OmniGetConversationListAnchor() {
        this(null, false, null, 0, 0, 31, null);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_() {
        return OmniBotConversationType.Companion.serializer();
    }

    public static /* synthetic */ d a() {
        return _childSerializers$_anonymous_();
    }

    public static /* synthetic */ OmniGetConversationListAnchor copy$default(OmniGetConversationListAnchor r100, String r101, boolean r102, OmniBotConversationType r103, long r104, long r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.conversationId;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.pinned;
    L8:
        boolean r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.conversationType;
    L11:
        OmniBotConversationType r105 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.version;
    L14:
        long r106 = r104;
        if ((r111 & 16) == 0) goto L17;
        r110 = r100.pinTime;
    L17:
        String r107 = r101;
        return r100.copy(r107, r113, r105, r106, r110);
    }

    @SerialName("conversation_id")
    public static /* synthetic */ void getConversationId$annotations() {
    }

    @SerialName("conversation_type")
    public static /* synthetic */ void getConversationType$annotations() {
    }

    @SerialName("pin_time")
    public static /* synthetic */ void getPinTime$annotations() {
    }

    @SerialName("pinned")
    public static /* synthetic */ void getPinned$annotations() {
    }

    @SerialName("version")
    public static /* synthetic */ void getVersion$annotations() {
    }

    public final String component1() {
        return this.conversationId;
    }

    public final boolean component2() {
        return this.pinned;
    }

    public final OmniBotConversationType component3() {
        return this.conversationType;
    }

    public final long component4() {
        return this.version;
    }

    public final long component5() {
        return this.pinTime;
    }

    public final OmniGetConversationListAnchor copy(String r110, boolean r111, OmniBotConversationType r112, long r113, long r114) {
        Intrinsics.checkNotNullParameter(r112, "conversationType");
        return new OmniGetConversationListAnchor(r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OmniGetConversationListAnchor) == true) goto L8;
        return false;
    L8:
        OmniGetConversationListAnchor r101 = (OmniGetConversationListAnchor) r100;
        if (Intrinsics.areEqual(this.conversationId, r101.conversationId) == true) goto L12;
        return false;
    L12:
        if (this.pinned == r101.pinned) goto L15;
        return false;
    L15:
        if (this.conversationType == r101.conversationType) goto L18;
        return false;
    L18:
        if (this.version == r101.version) goto L21;
        return false;
    L21:
        if (this.pinTime == r101.pinTime) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r100 = this.conversationId;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = r101 * 31;
        if (this.pinned == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (((r102 + r103) * 31) + this.conversationType.hashCode()) * 31;
        long r105 = this.version;
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        long r107 = this.pinTime;
        return r106 + ((int) (r107 ^ (r107 >>> 32)));
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "OmniGetConversationListAnchor(conversationId=" + this.conversationId + ", pinned=" + this.pinned + ", conversationType=" + this.conversationType + ", version=" + this.version + ", pinTime=" + this.pinTime + ')';
    }

    static {
        Companion = new Companion(null);
        $childSerializers = new Lazy[]{null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new h7()), null, null};
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_release(OmniGetConversationListAnchor r100, muc.d r101, f r110) {
        Lazy<d<Object>>[] r102 = $childSerializers;
        boolean r103 = false;
        if (r101.shouldEncodeElementDefault(r110, 0) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeNullableSerializableElement(r110, 0, v2.f520790a, r100.conversationId);
    L12:
        if (r101.shouldEncodeElementDefault(r110, 1) == false) goto L15;
    L13:
        boolean r105 = true;
    L18:
        if (r105 == false) goto L21;
        r101.encodeBooleanElement(r110, 1, r100.pinned);
    L21:
        if (r101.shouldEncodeElementDefault(r110, 2) == false) goto L24;
    L22:
        boolean r106 = true;
    L27:
        if (r106 == false) goto L30;
        r101.encodeSerializableElement(r110, 2, r102[2].getValue(), r100.conversationType);
    L30:
        if (r101.shouldEncodeElementDefault(r110, 3) == false) goto L33;
    L31:
        boolean r107 = true;
    L36:
        if (r107 == false) goto L39;
        r101.encodeLongElement(r110, 3, r100.version);
    L39:
        if (r101.shouldEncodeElementDefault(r110, 4) == false) goto L42;
    L40:
        r103 = true;
    L44:
        if (r103 == false) goto L47;
        r101.encodeLongElement(r110, 4, r100.pinTime);
        return;
    L47:
        return;
    L42:
        if (r100.pinTime == 0) goto L44;
    L33:
        if (r100.version != 0) goto L31;
        r107 = false;
        goto L36
    L24:
        if (r100.conversationType != OmniBotConversationType.BOT_TYPE_UNKNOWN) goto L22;
        r106 = false;
        goto L27
    L15:
        if (r100.pinned == true) goto L13;
        r105 = false;
        goto L18
    L6:
        if (r100.conversationId != null) goto L4;
        r104 = false;
        goto L9
    }

    public OmniGetConversationListAnchor(String r100, boolean r101, OmniBotConversationType r102, long r103, long r104) {
        Intrinsics.checkNotNullParameter(r102, "conversationType");
        this.conversationId = r100;
        this.pinned = r101;
        this.conversationType = r102;
        this.version = r103;
        this.pinTime = r104;
    }

    public /* synthetic */ OmniGetConversationListAnchor(int r100, String r101, boolean r102, OmniBotConversationType r103, long r104, long r105, q2 r110) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, OmniGetConversationListAnchor$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.conversationId = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.pinned = false;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.conversationType = OmniBotConversationType.BOT_TYPE_UNKNOWN;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.version = 0;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.pinTime = 0;
        return;
    L23:
        this.pinTime = r105;
        return;
    L19:
        this.version = r104;
        goto L21
    L15:
        this.conversationType = r103;
        goto L17
    L11:
        this.pinned = r102;
        goto L13
    L7:
        this.conversationId = r101;
        goto L9
    }

    public /* synthetic */ OmniGetConversationListAnchor(String r100, boolean r101, OmniBotConversationType r102, long r103, long r110, int r111, DefaultConstructorMarker r112) {
        if ((r111 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r111 & 2) == 0) goto L8;
        boolean r113 = false;
    L10:
        if ((r111 & 4) == 0) goto L12;
        r102 = OmniBotConversationType.BOT_TYPE_UNKNOWN;
    L12:
        OmniBotConversationType r104 = r102;
        long r105 = 0;
        if ((r111 & 8) == 0) goto L15;
        long r106 = 0;
    L17:
        if ((r111 & 16) != 0) goto L20;
        r105 = r110;
    L20:
        this(r100, r113, r104, r106, r105);
        return;
    L15:
        r106 = r103;
        goto L17
    L8:
        r113 = r101;
        goto L10
    }
}
