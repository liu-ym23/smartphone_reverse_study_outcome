package com.larus.im.bean.message.block;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
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
import muc.c;
import muc.e;
import nuc.a1;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.q2;
import nuc.v2;
import zc9.k;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 72\u00060\u0001j\u0002`\u0002:\u000267B[\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fBc\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u000b\u0010\u0011J\u000b\u0010!\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0017\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\nHÆ\u0003J]\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+HÖ\u0003J\t\u0010,\u001a\u00020\u000eHÖ\u0001J\t\u0010-\u001a\u00020\u0004HÖ\u0001J%\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u00002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0001¢\u0006\u0002\b5R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u001b\u0010\u0015R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0013\u001a\u0004\b\u001d\u0010\u0015R*\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0013\u001a\u0004\b\u001f\u0010 ¨\u00068"}, d2 = {"Lcom/larus/im/bean/message/block/ButtonBlock;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "displayText", "", "messageText", "iconUrl", "darkIconUrl", "command", "extra", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getDisplayText$annotations", "()V", "getDisplayText", "()Ljava/lang/String;", "getMessageText$annotations", "getMessageText", "getIconUrl$annotations", "getIconUrl", "getDarkIconUrl$annotations", "getDarkIconUrl", "getCommand$annotations", "getCommand", "getExtra$annotations", "getExtra", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$imsdkkmp_api_release", "$serializer", "Companion", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class ButtonBlock implements java.io.Serializable {
    private static final Lazy<d<Object>>[] $childSerializers = null;
    public static final b Companion = null;
    private final String command;
    private final String darkIconUrl;
    private final String displayText;
    private final Map<String, String> extra;
    private final String iconUrl;
    private final String messageText;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<ButtonBlock> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f346822a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f346823b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f346823b;
        }

        static {
            a r100 = new a();
            f346822a = r100;
            g2 r101 = new g2("com.larus.im.bean.message.block.ButtonBlock", r100, 6);
            r101.j("display_text", true);
            r101.j(TTDelegateActivity.MESSAGE_TEXT, true);
            r101.j("icon_url", true);
            r101.j("dark_icon_url", true);
            r101.j("command", true);
            r101.j("extra", true);
            f346823b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            Lazy[] r100 = ButtonBlock.access$get$childSerializers$cp();
            v2 r101 = v2.f520790a;
            return new d[]{kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d((d) r100[5].getValue())};
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r210) {
            Intrinsics.checkNotNullParameter(r210, "decoder");
            g2 r100 = f346823b;
            c r101 = r210.beginStructure(r100);
            Lazy[] r102 = ButtonBlock.access$get$childSerializers$cp();
            int r103 = 2;
            Map r110 = null;
            if (r101.decodeSequentially() == false) goto L5;
            v2 r104 = v2.f520790a;
            String r105 = (String) r101.decodeNullableSerializableElement(r100, 0, r104, null);
            String r106 = (String) r101.decodeNullableSerializableElement(r100, 1, r104, null);
            String r107 = (String) r101.decodeNullableSerializableElement(r100, 2, r104, null);
            String r108 = (String) r101.decodeNullableSerializableElement(r100, 3, r104, null);
            String r109 = (String) r101.decodeNullableSerializableElement(r100, 4, r104, null);
            Map r111 = (Map) r101.decodeNullableSerializableElement(r100, 5, (juc.c) r102[5].getValue(), null);
            String r112 = r109;
            String r113 = r107;
            String r114 = r108;
            String r115 = r106;
            String r116 = r105;
            int r117 = 63;
        L21:
            r101.endStructure(r100);
            return new ButtonBlock(r117, r116, r115, r113, r114, r112, r111, null);
        L5:
            r116 = null;
            String r118 = null;
            r113 = null;
            String r119 = null;
            r112 = null;
            int r120 = 0;
            boolean r121 = true;
        L6:
            if (r121 == false) goto L20;
            int r122 = r101.decodeElementIndex(r100);
            switch(r122) {
                case -1: goto L19;
                case 0: goto L17;
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r122);
        L19:
            r103 = 2;
            r121 = false;
            goto L6
        L11:
            r110 = (Map) r101.decodeNullableSerializableElement(r100, 5, (juc.c) r102[5].getValue(), r110);
            r120 = r120 | 32;
        L18:
            r103 = 2;
            goto L6
        L12:
            r112 = (String) r101.decodeNullableSerializableElement(r100, 4, v2.f520790a, r112);
            r120 = r120 | 16;
            goto L18
        L13:
            r118 = (String) r101.decodeNullableSerializableElement(r100, 3, v2.f520790a, r118);
            r120 = r120 | 8;
            goto L18
        L14:
            r113 = (String) r101.decodeNullableSerializableElement(r100, r103, v2.f520790a, r113);
            r120 = r120 | 4;
            goto L18
        L15:
            r119 = (String) r101.decodeNullableSerializableElement(r100, 1, v2.f520790a, r119);
            r120 = r120 | 2;
            goto L18
        L17:
            r120 = r120 | 1;
            r116 = (String) r101.decodeNullableSerializableElement(r100, 0, v2.f520790a, r116);
            goto L18
        L20:
            r111 = r110;
            r117 = r120;
            String r123 = r119;
            r114 = r118;
            r115 = r123;
            goto L21
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            ButtonBlock r102 = (ButtonBlock) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f346823b;
            muc.d r104 = r100.beginStructure(r103);
            ButtonBlock.write$Self$imsdkkmp_api_release(r102, r104, r103);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<ButtonBlock> serializer() {
            return a.f346822a;
        }
    }

    public ButtonBlock() {
        this(null, null, null, null, null, null, 63, null);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_() {
        v2 r100 = v2.f520790a;
        return new a1(r100, r100);
    }

    public static /* synthetic */ d a() {
        return _childSerializers$_anonymous_();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ButtonBlock copy$default(ButtonBlock r100, String r101, String r102, String r103, String r104, String r105, Map r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.displayText;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.messageText;
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.iconUrl;
    L11:
        String r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.darkIconUrl;
    L14:
        String r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.command;
    L17:
        String r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.extra;
    L20:
        String r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    @SerialName("command")
    public static /* synthetic */ void getCommand$annotations() {
    }

    @SerialName("dark_icon_url")
    public static /* synthetic */ void getDarkIconUrl$annotations() {
    }

    @SerialName("display_text")
    public static /* synthetic */ void getDisplayText$annotations() {
    }

    @SerialName("extra")
    public static /* synthetic */ void getExtra$annotations() {
    }

    @SerialName("icon_url")
    public static /* synthetic */ void getIconUrl$annotations() {
    }

    @SerialName(TTDelegateActivity.MESSAGE_TEXT)
    public static /* synthetic */ void getMessageText$annotations() {
    }

    public final String component1() {
        return this.displayText;
    }

    public final String component2() {
        return this.messageText;
    }

    public final String component3() {
        return this.iconUrl;
    }

    public final String component4() {
        return this.darkIconUrl;
    }

    public final String component5() {
        return this.command;
    }

    public final Map<String, String> component6() {
        return this.extra;
    }

    public final ButtonBlock copy(String r100, String r110, String r111, String r112, String r113, Map<String, String> r114) {
        return new ButtonBlock(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ButtonBlock) == true) goto L8;
        return false;
    L8:
        ButtonBlock r101 = (ButtonBlock) r100;
        if (Intrinsics.areEqual(this.displayText, r101.displayText) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.messageText, r101.messageText) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.iconUrl, r101.iconUrl) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.darkIconUrl, r101.darkIconUrl) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.command, r101.command) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        String r100 = this.displayText;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.messageText;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.iconUrl;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.darkIconUrl;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.command;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Map<String, String> r116 = this.extra;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
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
        return "ButtonBlock(displayText=" + this.displayText + ", messageText=" + this.messageText + ", iconUrl=" + this.iconUrl + ", darkIconUrl=" + this.darkIconUrl + ", command=" + this.command + ", extra=" + this.extra + ')';
    }

    static {
        Companion = new b();
        $childSerializers = new Lazy[]{null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new k())};
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    public final String getCommand() {
        return this.command;
    }

    public final String getDarkIconUrl() {
        return this.darkIconUrl;
    }

    public final String getDisplayText() {
        return this.displayText;
    }

    public final Map<String, String> getExtra() {
        return this.extra;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final String getMessageText() {
        return this.messageText;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$imsdkkmp_api_release(ButtonBlock r100, muc.d r101, f r102) {
        Lazy<d<Object>>[] r103 = $childSerializers;
        boolean r104 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r105 = true;
    L9:
        if (r105 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, v2.f520790a, r100.displayText);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r106 = true;
    L18:
        if (r106 == false) goto L21;
        r101.encodeNullableSerializableElement(r102, 1, v2.f520790a, r100.messageText);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r107 = true;
    L27:
        if (r107 == false) goto L30;
        r101.encodeNullableSerializableElement(r102, 2, v2.f520790a, r100.iconUrl);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        boolean r108 = true;
    L36:
        if (r108 == false) goto L39;
        r101.encodeNullableSerializableElement(r102, 3, v2.f520790a, r100.darkIconUrl);
    L39:
        if (r101.shouldEncodeElementDefault(r102, 4) == false) goto L42;
    L40:
        boolean r109 = true;
    L45:
        if (r109 == false) goto L48;
        r101.encodeNullableSerializableElement(r102, 4, v2.f520790a, r100.command);
    L48:
        if (r101.shouldEncodeElementDefault(r102, 5) == false) goto L51;
    L49:
        r104 = true;
    L53:
        if (r104 == false) goto L56;
        r101.encodeNullableSerializableElement(r102, 5, r103[5].getValue(), r100.extra);
        return;
    L56:
        return;
    L51:
        if (r100.extra == null) goto L53;
    L42:
        if (r100.command != null) goto L40;
        r109 = false;
        goto L45
    L33:
        if (r100.darkIconUrl != null) goto L31;
        r108 = false;
        goto L36
    L24:
        if (r100.iconUrl != null) goto L22;
        r107 = false;
        goto L27
    L15:
        if (r100.messageText != null) goto L13;
        r106 = false;
        goto L18
    L6:
        if (r100.displayText != null) goto L4;
        r105 = false;
        goto L9
    }

    public ButtonBlock(String r100, String r101, String r102, String r103, String r104, Map<String, String> r105) {
        this.displayText = r100;
        this.messageText = r101;
        this.iconUrl = r102;
        this.darkIconUrl = r103;
        this.command = r104;
        this.extra = r105;
    }

    public ButtonBlock(int r100, String r101, String r102, String r103, String r104, String r105, Map r106, q2 r107) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f346823b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.displayText = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.messageText = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.iconUrl = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.darkIconUrl = null;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.command = null;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.extra = null;
        return;
    L27:
        this.extra = r106;
        return;
    L23:
        this.command = r105;
        goto L25
    L19:
        this.darkIconUrl = r104;
        goto L21
    L15:
        this.iconUrl = r103;
        goto L17
    L11:
        this.messageText = r102;
        goto L13
    L7:
        this.displayText = r101;
        goto L9
    }

    public /* synthetic */ ButtonBlock(String r100, String r101, String r102, String r103, String r110, Map r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        String r114 = null;
    L7:
        if ((r112 & 2) == 0) goto L9;
        String r104 = null;
    L11:
        if ((r112 & 4) == 0) goto L13;
        String r105 = null;
    L15:
        if ((r112 & 8) == 0) goto L17;
        String r106 = null;
    L19:
        if ((r112 & 16) == 0) goto L21;
        String r107 = null;
    L23:
        if ((r112 & 32) == 0) goto L25;
        Map r115 = null;
    L26:
        this(r114, r104, r105, r106, r107, r115);
        return;
    L25:
        r115 = r111;
        goto L26
    L21:
        r107 = r110;
        goto L23
    L17:
        r106 = r103;
        goto L19
    L13:
        r105 = r102;
        goto L15
    L9:
        r104 = r101;
        goto L11
    L5:
        r114 = r100;
        goto L7
    }
}
