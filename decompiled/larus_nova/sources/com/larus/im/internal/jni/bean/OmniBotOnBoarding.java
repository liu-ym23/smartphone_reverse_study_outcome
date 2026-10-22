package com.larus.im.internal.jni.bean;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import de9.o4;
import de9.p4;
import java.util.List;
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
import nuc.b2;
import nuc.f;
import nuc.q2;
import nuc.v2;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 02\u00060\u0001j\u0002`\u0002:\u0002/0BW\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eB_\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\t\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006\u0012\u0006\u0010\f\u001a\u00020\t\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\r\u0010\u0012J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0011\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u001d\u001a\u00020\tHÆ\u0003J\u0011\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006HÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003JY\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\b\u001a\u00020\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00062\b\b\u0002\u0010\f\u001a\u00020\tHÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020\tHÖ\u0001J\t\u0010&\u001a\u00020\u0004HÖ\u0001J%\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0001¢\u0006\u0002\b.R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0015\u0010\u0014R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0016\u0010\u0014R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0017\u0010\u0014R\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0018\u0010\u0014R\u0016\u0010\f\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0019\u0010\u0014¨\u00061"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniBotOnBoarding;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "prologue", "", "suggests", "", "content", "callMode", "", "messageList", "Lcom/larus/im/internal/jni/bean/OmniMessage;", "version", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;ILjava/util/List;I)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/util/List;Ljava/lang/String;ILjava/util/List;ILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getPrologue$annotations", "()V", "getSuggests$annotations", "getContent$annotations", "getCallMode$annotations", "getMessageList$annotations", "getVersion$annotations", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_release", "$serializer", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OmniBotOnBoarding implements java.io.Serializable {
    private static final Lazy<d<Object>>[] $childSerializers = null;
    public static final Companion Companion = null;
    public final int callMode;
    public final String content;
    public final List<OmniMessage> messageList;
    public final String prologue;
    public final List<String> suggests;
    public final int version;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniBotOnBoarding$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OmniBotOnBoarding;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OmniBotOnBoarding> serializer() {
            return OmniBotOnBoarding$$serializer.INSTANCE;
        }
    }

    public OmniBotOnBoarding() {
        this(null, null, null, 0, null, 0, 63, null);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_() {
        return new f(v2.f520790a);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_$0() {
        return new f(OmniMessage$$serializer.INSTANCE);
    }

    public static /* synthetic */ d a() {
        return _childSerializers$_anonymous_();
    }

    public static /* synthetic */ d b() {
        return _childSerializers$_anonymous_$0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OmniBotOnBoarding copy$default(OmniBotOnBoarding r100, String r101, List r102, String r103, int r104, List r105, int r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.prologue;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.suggests;
    L8:
        List r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.content;
    L11:
        String r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.callMode;
    L14:
        int r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.messageList;
    L17:
        List r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.version;
    L20:
        String r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    @SerialName("call_mode")
    public static /* synthetic */ void getCallMode$annotations() {
    }

    @SerialName("content")
    public static /* synthetic */ void getContent$annotations() {
    }

    @SerialName("message_list")
    public static /* synthetic */ void getMessageList$annotations() {
    }

    @SerialName("prologue")
    public static /* synthetic */ void getPrologue$annotations() {
    }

    @SerialName("suggests")
    public static /* synthetic */ void getSuggests$annotations() {
    }

    @SerialName("version")
    public static /* synthetic */ void getVersion$annotations() {
    }

    public final String component1() {
        return this.prologue;
    }

    public final List<String> component2() {
        return this.suggests;
    }

    public final String component3() {
        return this.content;
    }

    public final int component4() {
        return this.callMode;
    }

    public final List<OmniMessage> component5() {
        return this.messageList;
    }

    public final int component6() {
        return this.version;
    }

    public final OmniBotOnBoarding copy(String r100, List<String> r110, String r111, int r112, List<OmniMessage> r113, int r114) {
        return new OmniBotOnBoarding(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OmniBotOnBoarding) == true) goto L8;
        return false;
    L8:
        OmniBotOnBoarding r101 = (OmniBotOnBoarding) r100;
        if (Intrinsics.areEqual(this.prologue, r101.prologue) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.suggests, r101.suggests) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L18;
        return false;
    L18:
        if (this.callMode == r101.callMode) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.messageList, r101.messageList) == true) goto L24;
        return false;
    L24:
        if (this.version == r101.version) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        String r100 = this.prologue;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.suggests;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.content;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (((r106 + r108) * 31) + this.callMode) * 31;
        List<OmniMessage> r110 = this.messageList;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return ((r109 + r101) * 31) + this.version;
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
        return "OmniBotOnBoarding(prologue=" + this.prologue + ", suggests=" + this.suggests + ", content=" + this.content + ", callMode=" + this.callMode + ", messageList=" + this.messageList + ", version=" + this.version + ')';
    }

    static {
        Companion = new Companion(null);
        LazyThreadSafetyMode r100 = LazyThreadSafetyMode.PUBLICATION;
        $childSerializers = new Lazy[]{null, LazyKt.lazy(r100, new o4()), null, null, LazyKt.lazy(r100, new p4()), null};
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_release(OmniBotOnBoarding r100, muc.d r101, luc.f r102) {
        Lazy<d<Object>>[] r103 = $childSerializers;
        boolean r104 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r105 = true;
    L9:
        if (r105 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, v2.f520790a, r100.prologue);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r106 = true;
    L18:
        if (r106 == false) goto L21;
        r101.encodeNullableSerializableElement(r102, 1, r103[1].getValue(), r100.suggests);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r107 = true;
    L27:
        if (r107 == false) goto L30;
        r101.encodeNullableSerializableElement(r102, 2, v2.f520790a, r100.content);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        boolean r108 = true;
    L36:
        if (r108 == false) goto L39;
        r101.encodeIntElement(r102, 3, r100.callMode);
    L39:
        if (r101.shouldEncodeElementDefault(r102, 4) == false) goto L42;
    L40:
        boolean r109 = true;
    L45:
        if (r109 == false) goto L48;
        r101.encodeNullableSerializableElement(r102, 4, r103[4].getValue(), r100.messageList);
    L48:
        if (r101.shouldEncodeElementDefault(r102, 5) == false) goto L51;
    L49:
        r104 = true;
    L53:
        if (r104 == false) goto L56;
        r101.encodeIntElement(r102, 5, r100.version);
        return;
    L56:
        return;
    L51:
        if (r100.version == 0) goto L53;
    L42:
        if (r100.messageList != null) goto L40;
        r109 = false;
        goto L45
    L33:
        if (r100.callMode != 0) goto L31;
        r108 = false;
        goto L36
    L24:
        if (r100.content != null) goto L22;
        r107 = false;
        goto L27
    L15:
        if (r100.suggests != null) goto L13;
        r106 = false;
        goto L18
    L6:
        if (r100.prologue != null) goto L4;
        r105 = false;
        goto L9
    }

    public OmniBotOnBoarding(String r100, List<String> r101, String r102, int r103, List<OmniMessage> r104, int r105) {
        this.prologue = r100;
        this.suggests = r101;
        this.content = r102;
        this.callMode = r103;
        this.messageList = r104;
        this.version = r105;
    }

    public /* synthetic */ OmniBotOnBoarding(int r100, String r101, List r102, String r103, int r104, List r105, int r106, q2 r110) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, OmniBotOnBoarding$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.prologue = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.suggests = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.content = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.callMode = 0;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.messageList = null;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.version = 0;
        return;
    L27:
        this.version = r106;
        return;
    L23:
        this.messageList = r105;
        goto L25
    L19:
        this.callMode = r104;
        goto L21
    L15:
        this.content = r103;
        goto L17
    L11:
        this.suggests = r102;
        goto L13
    L7:
        this.prologue = r101;
        goto L9
    }

    public /* synthetic */ OmniBotOnBoarding(String r100, List r101, String r102, int r103, List r104, int r110, int r111, DefaultConstructorMarker r112) {
        List r105 = null;
        if ((r111 & 1) == 0) goto L5;
        String r113 = null;
    L7:
        if ((r111 & 2) == 0) goto L9;
        List r106 = null;
    L11:
        if ((r111 & 4) == 0) goto L13;
        String r107 = null;
    L15:
        if ((r111 & 8) == 0) goto L17;
        int r108 = 0;
    L19:
        if ((r111 & 16) != 0) goto L23;
        r105 = r104;
    L23:
        if ((r111 & 32) == 0) goto L25;
        int r114 = 0;
    L26:
        this(r113, r106, r107, r108, r105, r114);
        return;
    L25:
        r114 = r110;
        goto L26
    L17:
        r108 = r103;
        goto L19
    L13:
        r107 = r102;
        goto L15
    L9:
        r106 = r101;
        goto L11
    L5:
        r113 = r100;
        goto L7
    }
}
