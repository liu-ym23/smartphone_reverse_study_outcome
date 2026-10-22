package com.larus.im.internal.jni.bean;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import de9.g6;
import de9.h6;
import de9.i6;
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

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 62\u00060\u0001j\u0002`\u0002:\u000256Bw\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e\u0012\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0010\u0010\u0011B}\b\u0010\u0012\u0006\u0010\u0012\u001a\u00020\t\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e\u0012\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0010\u0010\u0015J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010!\u001a\u00020\u0007HÆ\u0003J\t\u0010\"\u001a\u00020\tHÆ\u0003J\t\u0010#\u001a\u00020\tHÆ\u0003J\t\u0010$\u001a\u00020\fHÆ\u0003J\u0017\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000eHÆ\u0003J\u0017\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000eHÆ\u0003Jy\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e2\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000eHÆ\u0001J\u0013\u0010(\u001a\u00020\u00072\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001a\u00020\tHÖ\u0001J\t\u0010,\u001a\u00020\u0004HÖ\u0001J%\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u00002\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0001¢\u0006\u0002\b4R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0018\u0010\u0017R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0019\u0010\u0017R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001a\u0010\u0017R\u0016\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001b\u0010\u0017R\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001c\u0010\u0017R$\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001d\u0010\u0017R$\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001e\u0010\u0017¨\u00067"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniCreateConversationMeta;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "botInfo", "", "name", "ifPin", "", "defaultStatus", "", "conversationScene", "leftButtonStyle", "Lcom/larus/im/internal/jni/bean/OmniInputLeftButtonStyle;", "ext", "", "bizExt", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZIILcom/larus/im/internal/jni/bean/OmniInputLeftButtonStyle;Ljava/util/Map;Ljava/util/Map;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;ZIILcom/larus/im/internal/jni/bean/OmniInputLeftButtonStyle;Ljava/util/Map;Ljava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getBotInfo$annotations", "()V", "getName$annotations", "getIfPin$annotations", "getDefaultStatus$annotations", "getConversationScene$annotations", "getLeftButtonStyle$annotations", "getExt$annotations", "getBizExt$annotations", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_release", "$serializer", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OmniCreateConversationMeta implements java.io.Serializable {
    private static final Lazy<d<Object>>[] $childSerializers = null;
    public static final Companion Companion = null;
    public final Map<String, String> bizExt;
    public final String botInfo;
    public final int conversationScene;
    public final int defaultStatus;
    public final Map<String, String> ext;
    public final boolean ifPin;
    public final OmniInputLeftButtonStyle leftButtonStyle;
    public final String name;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniCreateConversationMeta$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OmniCreateConversationMeta;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OmniCreateConversationMeta> serializer() {
            return OmniCreateConversationMeta$$serializer.INSTANCE;
        }
    }

    public OmniCreateConversationMeta() {
        this(null, null, false, 0, 0, null, null, null, 255, null);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_() {
        return OmniInputLeftButtonStyle.Companion.serializer();
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_$0() {
        v2 r100 = v2.f520790a;
        return new a1(r100, r100);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_$1() {
        v2 r100 = v2.f520790a;
        return new a1(r100, r100);
    }

    public static /* synthetic */ d a() {
        return _childSerializers$_anonymous_$1();
    }

    public static /* synthetic */ d b() {
        return _childSerializers$_anonymous_();
    }

    public static /* synthetic */ d c() {
        return _childSerializers$_anonymous_$0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OmniCreateConversationMeta copy$default(OmniCreateConversationMeta r100, String r110, String r111, boolean r112, int r113, int r114, OmniInputLeftButtonStyle r115, Map r116, Map r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        String r101 = r100.botInfo;
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r102 = r100.name;
    L11:
        if ((r118 & 4) == 0) goto L13;
        boolean r103 = r100.ifPin;
    L15:
        if ((r118 & 8) == 0) goto L17;
        int r104 = r100.defaultStatus;
    L19:
        if ((r118 & 16) == 0) goto L21;
        int r105 = r100.conversationScene;
    L23:
        if ((r118 & 32) == 0) goto L25;
        OmniInputLeftButtonStyle r106 = r100.leftButtonStyle;
    L27:
        if ((r118 & 64) == 0) goto L29;
        Map r107 = r100.ext;
    L31:
        if ((r118 & 128) == 0) goto L33;
        Map r108 = r100.bizExt;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    @SerialName("biz_ext")
    public static /* synthetic */ void getBizExt$annotations() {
    }

    @SerialName("bot_info")
    public static /* synthetic */ void getBotInfo$annotations() {
    }

    @SerialName("conversation_scene")
    public static /* synthetic */ void getConversationScene$annotations() {
    }

    @SerialName("default_status")
    public static /* synthetic */ void getDefaultStatus$annotations() {
    }

    @SerialName("ext")
    public static /* synthetic */ void getExt$annotations() {
    }

    @SerialName("if_pin")
    public static /* synthetic */ void getIfPin$annotations() {
    }

    @SerialName("left_button_style")
    public static /* synthetic */ void getLeftButtonStyle$annotations() {
    }

    @SerialName("name")
    public static /* synthetic */ void getName$annotations() {
    }

    public final String component1() {
        return this.botInfo;
    }

    public final String component2() {
        return this.name;
    }

    public final boolean component3() {
        return this.ifPin;
    }

    public final int component4() {
        return this.defaultStatus;
    }

    public final int component5() {
        return this.conversationScene;
    }

    public final OmniInputLeftButtonStyle component6() {
        return this.leftButtonStyle;
    }

    public final Map<String, String> component7() {
        return this.ext;
    }

    public final Map<String, String> component8() {
        return this.bizExt;
    }

    public final OmniCreateConversationMeta copy(String r110, String r111, boolean r112, int r113, int r114, OmniInputLeftButtonStyle r115, Map<String, String> r116, Map<String, String> r117) {
        Intrinsics.checkNotNullParameter(r115, "leftButtonStyle");
        return new OmniCreateConversationMeta(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OmniCreateConversationMeta) == true) goto L8;
        return false;
    L8:
        OmniCreateConversationMeta r101 = (OmniCreateConversationMeta) r100;
        if (Intrinsics.areEqual(this.botInfo, r101.botInfo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L15;
        return false;
    L15:
        if (this.ifPin == r101.ifPin) goto L18;
        return false;
    L18:
        if (this.defaultStatus == r101.defaultStatus) goto L21;
        return false;
    L21:
        if (this.conversationScene == r101.conversationScene) goto L24;
        return false;
    L24:
        if (this.leftButtonStyle == r101.leftButtonStyle) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.ext, r101.ext) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.bizExt, r101.bizExt) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        String r100 = this.botInfo;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.name;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        if (this.ifPin == false) goto L13;
        int r107 = 1231;
    L14:
        int r108 = (((((((r106 + r107) * 31) + this.defaultStatus) * 31) + this.conversationScene) * 31) + this.leftButtonStyle.hashCode()) * 31;
        Map<String, String> r109 = this.ext;
        if (r109 != null) goto L17;
        int r110 = 0;
    L18:
        int r111 = (r108 + r110) * 31;
        Map<String, String> r112 = this.bizExt;
        if (r112 == null) goto L23;
        r101 = r112.hashCode();
    L23:
        return r111 + r101;
    L17:
        r110 = r109.hashCode();
        goto L18
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
        return "OmniCreateConversationMeta(botInfo=" + this.botInfo + ", name=" + this.name + ", ifPin=" + this.ifPin + ", defaultStatus=" + this.defaultStatus + ", conversationScene=" + this.conversationScene + ", leftButtonStyle=" + this.leftButtonStyle + ", ext=" + this.ext + ", bizExt=" + this.bizExt + ')';
    }

    static {
        Companion = new Companion(null);
        LazyThreadSafetyMode r100 = LazyThreadSafetyMode.PUBLICATION;
        $childSerializers = new Lazy[]{null, null, null, null, null, LazyKt.lazy(r100, new g6()), LazyKt.lazy(r100, new h6()), LazyKt.lazy(r100, new i6())};
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_release(OmniCreateConversationMeta r100, muc.d r101, f r102) {
        Lazy<d<Object>>[] r103 = $childSerializers;
        boolean r104 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r105 = true;
    L9:
        if (r105 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, v2.f520790a, r100.botInfo);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r106 = true;
    L18:
        if (r106 == false) goto L21;
        r101.encodeNullableSerializableElement(r102, 1, v2.f520790a, r100.name);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r107 = true;
    L27:
        if (r107 == false) goto L30;
        r101.encodeBooleanElement(r102, 2, r100.ifPin);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        boolean r108 = true;
    L36:
        if (r108 == false) goto L39;
        r101.encodeIntElement(r102, 3, r100.defaultStatus);
    L39:
        if (r101.shouldEncodeElementDefault(r102, 4) == false) goto L42;
    L40:
        boolean r109 = true;
    L45:
        if (r109 == false) goto L48;
        r101.encodeIntElement(r102, 4, r100.conversationScene);
    L48:
        if (r101.shouldEncodeElementDefault(r102, 5) == false) goto L51;
    L49:
        boolean r110 = true;
    L54:
        if (r110 == false) goto L57;
        r101.encodeSerializableElement(r102, 5, r103[5].getValue(), r100.leftButtonStyle);
    L57:
        if (r101.shouldEncodeElementDefault(r102, 6) == false) goto L60;
    L58:
        boolean r111 = true;
    L63:
        if (r111 == false) goto L66;
        r101.encodeNullableSerializableElement(r102, 6, r103[6].getValue(), r100.ext);
    L66:
        if (r101.shouldEncodeElementDefault(r102, 7) == false) goto L69;
    L67:
        r104 = true;
    L71:
        if (r104 == false) goto L74;
        r101.encodeNullableSerializableElement(r102, 7, r103[7].getValue(), r100.bizExt);
        return;
    L74:
        return;
    L69:
        if (r100.bizExt == null) goto L71;
    L60:
        if (r100.ext != null) goto L58;
        r111 = false;
        goto L63
    L51:
        if (r100.leftButtonStyle != OmniInputLeftButtonStyle.ButtonStyle_None) goto L49;
        r110 = false;
        goto L54
    L42:
        if (r100.conversationScene != 0) goto L40;
        r109 = false;
        goto L45
    L33:
        if (r100.defaultStatus != 0) goto L31;
        r108 = false;
        goto L36
    L24:
        if (r100.ifPin == true) goto L22;
        r107 = false;
        goto L27
    L15:
        if (r100.name != null) goto L13;
        r106 = false;
        goto L18
    L6:
        if (r100.botInfo != null) goto L4;
        r105 = false;
        goto L9
    }

    public OmniCreateConversationMeta(String r100, String r101, boolean r102, int r103, int r104, OmniInputLeftButtonStyle r105, Map<String, String> r106, Map<String, String> r107) {
        Intrinsics.checkNotNullParameter(r105, "leftButtonStyle");
        this.botInfo = r100;
        this.name = r101;
        this.ifPin = r102;
        this.defaultStatus = r103;
        this.conversationScene = r104;
        this.leftButtonStyle = r105;
        this.ext = r106;
        this.bizExt = r107;
    }

    public /* synthetic */ OmniCreateConversationMeta(int r100, String r101, String r102, boolean r103, int r104, int r105, OmniInputLeftButtonStyle r106, Map r110, Map r111, q2 r112) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, OmniCreateConversationMeta$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.botInfo = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.name = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.ifPin = false;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.defaultStatus = 0;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.conversationScene = 0;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.leftButtonStyle = OmniInputLeftButtonStyle.ButtonStyle_None;
    L29:
        if ((r100 & 64) != 0) goto L31;
        this.ext = null;
    L33:
        if ((r100 & 128) != 0) goto L35;
        this.bizExt = null;
        return;
    L35:
        this.bizExt = r111;
        return;
    L31:
        this.ext = r110;
        goto L33
    L27:
        this.leftButtonStyle = r106;
        goto L29
    L23:
        this.conversationScene = r105;
        goto L25
    L19:
        this.defaultStatus = r104;
        goto L21
    L15:
        this.ifPin = r103;
        goto L17
    L11:
        this.name = r102;
        goto L13
    L7:
        this.botInfo = r101;
        goto L9
    }

    public /* synthetic */ OmniCreateConversationMeta(String r110, String r111, boolean r112, int r113, int r114, OmniInputLeftButtonStyle r115, Map r116, Map r117, int r118, DefaultConstructorMarker r119) {
        Map r100 = null;
        if ((r118 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r102 = null;
    L10:
        int r103 = 0;
        if ((r118 & 4) == 0) goto L13;
        boolean r104 = false;
    L15:
        if ((r118 & 8) == 0) goto L17;
        int r105 = 0;
    L19:
        if ((r118 & 16) != 0) goto L23;
        r103 = r114;
    L23:
        if ((r118 & 32) == 0) goto L25;
        OmniInputLeftButtonStyle r106 = OmniInputLeftButtonStyle.ButtonStyle_None;
    L27:
        if ((r118 & 64) == 0) goto L29;
        Map r107 = null;
    L31:
        if ((r118 & 128) != 0) goto L34;
        r100 = r117;
    L34:
        this(r101, r102, r104, r105, r103, r106, r107, r100);
        return;
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L17:
        r105 = r113;
        goto L19
    L13:
        r104 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L10
    L5:
        r101 = r110;
        goto L7
    }
}
