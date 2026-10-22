package com.larus.im.bean.message.block;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import java.util.List;
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
import nuc.b2;
import nuc.g2;
import nuc.i;
import nuc.i2;
import nuc.m0;
import nuc.q2;
import nuc.v2;
import nuc.w0;
import zc9.u0;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 M2\u00060\u0001j\u0002`\u0002:\u0002LMBy\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0013\u0010\u0014B{\b\u0010\u0012\u0006\u0010\u0015\u001a\u00020\u0007\u0012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0013\u0010\u0018J\u0011\u00104\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003J\u0010\u00105\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u00106\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010#J\u0010\u00107\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u000b\u00108\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u0010\u0010;\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010<\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0080\u0001\u0010=\u001a\u00020\u00002\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010>J\u0013\u0010?\u001a\u00020\t2\b\u0010@\u001a\u0004\u0018\u00010AHÖ\u0003J\t\u0010B\u001a\u00020\u0007HÖ\u0001J\t\u0010C\u001a\u00020\fHÖ\u0001J%\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020\u00002\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020JH\u0001¢\u0006\u0002\bKR$\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010 \u0012\u0004\b\u001d\u0010\u001a\u001a\u0004\b\u001e\u0010\u001fR \u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010$\u0012\u0004\b!\u0010\u001a\u001a\u0004\b\"\u0010#R \u0010\n\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010 \u0012\u0004\b%\u0010\u001a\u001a\u0004\b&\u0010\u001fR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010\u001a\u001a\u0004\b(\u0010)R\u001e\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010\u001a\u001a\u0004\b+\u0010,R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b-\u0010\u001a\u001a\u0004\b.\u0010/R \u0010\u0011\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010 \u0012\u0004\b0\u0010\u001a\u001a\u0004\b1\u0010\u001fR \u0010\u0012\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010 \u0012\u0004\b2\u0010\u001a\u001a\u0004\b3\u0010\u001f¨\u0006N"}, d2 = {"Lcom/larus/im/bean/message/block/QuickReplyBlock;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "items", "", "Lcom/larus/im/bean/message/block/QuickReplyItem;", "sortType", "", "hideOnClick", "", "status", "guideText", "", "decisionContext", "Lcom/larus/im/bean/message/block/QuickReplyDecisionContext;", "thinkingContent", "Lcom/larus/im/bean/message/block/InteractionAskContent;", "scene", "interactionType", "<init>", "(Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Lcom/larus/im/bean/message/block/QuickReplyDecisionContext;Lcom/larus/im/bean/message/block/InteractionAskContent;Ljava/lang/Integer;Ljava/lang/Integer;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Lcom/larus/im/bean/message/block/QuickReplyDecisionContext;Lcom/larus/im/bean/message/block/InteractionAskContent;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getItems$annotations", "()V", "getItems", "()Ljava/util/List;", "getSortType$annotations", "getSortType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHideOnClick$annotations", "getHideOnClick", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getStatus$annotations", "getStatus", "getGuideText$annotations", "getGuideText", "()Ljava/lang/String;", "getDecisionContext$annotations", "getDecisionContext", "()Lcom/larus/im/bean/message/block/QuickReplyDecisionContext;", "getThinkingContent$annotations", "getThinkingContent", "()Lcom/larus/im/bean/message/block/InteractionAskContent;", "getScene$annotations", "getScene", "getInteractionType$annotations", "getInteractionType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Lcom/larus/im/bean/message/block/QuickReplyDecisionContext;Lcom/larus/im/bean/message/block/InteractionAskContent;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/larus/im/bean/message/block/QuickReplyBlock;", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$imsdkkmp_api_release", "$serializer", "Companion", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class QuickReplyBlock implements java.io.Serializable {
    private static final Lazy<d<Object>>[] $childSerializers = null;
    public static final b Companion = null;
    private final QuickReplyDecisionContext decisionContext;
    private final String guideText;
    private final Boolean hideOnClick;
    private final Integer interactionType;
    private final List<QuickReplyItem> items;
    private final Integer scene;
    private final Integer sortType;
    private final Integer status;
    private final InteractionAskContent thinkingContent;

    /* JADX INFO: loaded from: classes4.dex */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<QuickReplyBlock> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f347008a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f347009b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f347009b;
        }

        static {
            a r100 = new a();
            f347008a = r100;
            g2 r101 = new g2("com.larus.im.bean.message.block.QuickReplyBlock", r100, 9);
            r101.j("items", true);
            r101.j(com.bytedance.android.ec.core.event.a.KEY_SORD_TYPE, true);
            r101.j("hide_on_click", true);
            r101.j("status", true);
            r101.j("guide_text", true);
            r101.j("decision_context", true);
            r101.j("thinking_content", true);
            r101.j("scene", true);
            r101.j(com.bytedance.android.ec.core.event.a.KEY_INTERACTION_TYPE, true);
            f347009b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            w0 r100 = w0.f520792a;
            return new d[]{kuc.a.d((d) QuickReplyBlock.access$get$childSerializers$cp()[0].getValue()), kuc.a.d(r100), kuc.a.d(i.f520705a), kuc.a.d(r100), kuc.a.d(v2.f520790a), kuc.a.d(QuickReplyDecisionContext.a.f347010a), kuc.a.d(InteractionAskContent.a.f346902a), kuc.a.d(r100), kuc.a.d(r100)};
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r210) {
            Intrinsics.checkNotNullParameter(r210, "decoder");
            g2 r100 = f347009b;
            c r101 = r210.beginStructure(r100);
            Lazy[] r102 = QuickReplyBlock.access$get$childSerializers$cp();
            int r103 = 8;
            int r104 = 5;
            int r105 = 6;
            Integer r110 = null;
            if (r101.decodeSequentially() == false) goto L5;
            List r106 = (List) r101.decodeNullableSerializableElement(r100, 0, (juc.c) r102[0].getValue(), null);
            w0 r107 = w0.f520792a;
            Integer r111 = (Integer) r101.decodeNullableSerializableElement(r100, 1, r107, null);
            Boolean r108 = (Boolean) r101.decodeNullableSerializableElement(r100, 2, i.f520705a, null);
            Integer r109 = (Integer) r101.decodeNullableSerializableElement(r100, 3, r107, null);
            String r112 = (String) r101.decodeNullableSerializableElement(r100, 4, v2.f520790a, null);
            QuickReplyDecisionContext r113 = (QuickReplyDecisionContext) r101.decodeNullableSerializableElement(r100, 5, QuickReplyDecisionContext.a.f347010a, null);
            InteractionAskContent r114 = (InteractionAskContent) r101.decodeNullableSerializableElement(r100, 6, InteractionAskContent.a.f346902a, null);
            Integer r115 = (Integer) r101.decodeNullableSerializableElement(r100, 7, r107, null);
            List r116 = r106;
            Integer r211 = (Integer) r101.decodeNullableSerializableElement(r100, 8, r107, null);
            Integer r117 = r109;
            QuickReplyDecisionContext r118 = r113;
            InteractionAskContent r119 = r114;
            Integer r212 = r115;
            Boolean r120 = r108;
            String r121 = r112;
            Integer r122 = r111;
            int r123 = 511;
        L26:
            r101.endStructure(r100);
            return new QuickReplyBlock(r123, r116, r122, r120, r117, r121, r118, r119, r212, r211, null);
        L5:
            QuickReplyDecisionContext r124 = null;
            Integer r125 = null;
            InteractionAskContent r126 = null;
            Integer r127 = null;
            Integer r128 = null;
            String r129 = null;
            List r130 = null;
            Boolean r213 = null;
            int r131 = 0;
            boolean r214 = true;
        L6:
            if (r214 == false) goto L25;
            int r132 = r101.decodeElementIndex(r100);
            switch(r132) {
                case -1: goto L24;
                case 0: goto L22;
                case 1: goto L20;
                case 2: goto L18;
                case 3: goto L17;
                case 4: goto L16;
                case 5: goto L14;
                case 6: goto L13;
                case 7: goto L12;
                case 8: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r132);
        L24:
            r103 = 8;
            r105 = 6;
            r214 = false;
            goto L6
        L11:
            r125 = (Integer) r101.decodeNullableSerializableElement(r100, r103, w0.f520792a, r125);
            r131 = r131 | 256;
        L19:
            Boolean r133 = r213;
        L23:
            r213 = r133;
            r103 = 8;
            r104 = 5;
            r105 = 6;
            goto L6
        L12:
            r127 = (Integer) r101.decodeNullableSerializableElement(r100, 7, w0.f520792a, r127);
            r131 = r131 | 128;
            goto L19
        L13:
            r126 = (InteractionAskContent) r101.decodeNullableSerializableElement(r100, r105, InteractionAskContent.a.f346902a, r126);
            r131 = r131 | 64;
            goto L19
        L14:
            r124 = (QuickReplyDecisionContext) r101.decodeNullableSerializableElement(r100, r104, QuickReplyDecisionContext.a.f347010a, r124);
            r131 = r131 | 32;
            goto L19
        L16:
            r129 = (String) r101.decodeNullableSerializableElement(r100, 4, v2.f520790a, r129);
            r131 = r131 | 16;
            goto L19
        L17:
            r128 = (Integer) r101.decodeNullableSerializableElement(r100, 3, w0.f520792a, r128);
            r131 = r131 | 8;
            goto L19
        L18:
            r213 = (Boolean) r101.decodeNullableSerializableElement(r100, 2, i.f520705a, r213);
            r131 = r131 | 4;
            goto L19
        L20:
            r133 = r213;
            r110 = (Integer) r101.decodeNullableSerializableElement(r100, 1, w0.f520792a, r110);
            r131 = r131 | 2;
            goto L23
        L22:
            r133 = r213;
            r131 = r131 | 1;
            r130 = (List) r101.decodeNullableSerializableElement(r100, 0, (juc.c) r102[0].getValue(), r130);
            goto L23
        L25:
            List r134 = r130;
            Boolean r135 = r213;
            r118 = r124;
            r211 = r125;
            r119 = r126;
            r212 = r127;
            r117 = r128;
            r121 = r129;
            r123 = r131;
            r120 = r135;
            r122 = r110;
            r116 = r134;
            goto L26
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            QuickReplyBlock r102 = (QuickReplyBlock) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f347009b;
            muc.d r104 = r100.beginStructure(r103);
            QuickReplyBlock.write$Self$imsdkkmp_api_release(r102, r104, r103);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<QuickReplyBlock> serializer() {
            return a.f347008a;
        }
    }

    public QuickReplyBlock() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_() {
        return new nuc.f(QuickReplyItem.a.f347016a);
    }

    public static /* synthetic */ d a() {
        return _childSerializers$_anonymous_();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ QuickReplyBlock copy$default(QuickReplyBlock r110, List r111, Integer r112, Boolean r113, Integer r114, String r115, QuickReplyDecisionContext r116, InteractionAskContent r117, Integer r118, Integer r119, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        List r100 = r110.items;
    L7:
        if ((r210 & 2) == 0) goto L9;
        Integer r101 = r110.sortType;
    L11:
        if ((r210 & 4) == 0) goto L13;
        Boolean r102 = r110.hideOnClick;
    L15:
        if ((r210 & 8) == 0) goto L17;
        Integer r103 = r110.status;
    L19:
        if ((r210 & 16) == 0) goto L21;
        String r104 = r110.guideText;
    L23:
        if ((r210 & 32) == 0) goto L25;
        QuickReplyDecisionContext r105 = r110.decisionContext;
    L27:
        if ((r210 & 64) == 0) goto L29;
        InteractionAskContent r106 = r110.thinkingContent;
    L31:
        if ((r210 & 128) == 0) goto L33;
        Integer r107 = r110.scene;
    L35:
        if ((r210 & 256) == 0) goto L37;
        Integer r108 = r110.interactionType;
    L39:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r108);
    L37:
        r108 = r119;
        goto L39
    L33:
        r107 = r118;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    @SerialName("decision_context")
    public static /* synthetic */ void getDecisionContext$annotations() {
    }

    @SerialName("guide_text")
    public static /* synthetic */ void getGuideText$annotations() {
    }

    @SerialName("hide_on_click")
    public static /* synthetic */ void getHideOnClick$annotations() {
    }

    @SerialName(com.bytedance.android.ec.core.event.a.KEY_INTERACTION_TYPE)
    public static /* synthetic */ void getInteractionType$annotations() {
    }

    @SerialName("items")
    public static /* synthetic */ void getItems$annotations() {
    }

    @SerialName("scene")
    public static /* synthetic */ void getScene$annotations() {
    }

    @SerialName(com.bytedance.android.ec.core.event.a.KEY_SORD_TYPE)
    public static /* synthetic */ void getSortType$annotations() {
    }

    @SerialName("status")
    public static /* synthetic */ void getStatus$annotations() {
    }

    @SerialName("thinking_content")
    public static /* synthetic */ void getThinkingContent$annotations() {
    }

    public final List<QuickReplyItem> component1() {
        return this.items;
    }

    public final Integer component2() {
        return this.sortType;
    }

    public final Boolean component3() {
        return this.hideOnClick;
    }

    public final Integer component4() {
        return this.status;
    }

    public final String component5() {
        return this.guideText;
    }

    public final QuickReplyDecisionContext component6() {
        return this.decisionContext;
    }

    public final InteractionAskContent component7() {
        return this.thinkingContent;
    }

    public final Integer component8() {
        return this.scene;
    }

    public final Integer component9() {
        return this.interactionType;
    }

    public final QuickReplyBlock copy(List<QuickReplyItem> r110, Integer r111, Boolean r112, Integer r113, String r114, QuickReplyDecisionContext r115, InteractionAskContent r116, Integer r117, Integer r210) {
        return new QuickReplyBlock(r110, r111, r112, r113, r114, r115, r116, r117, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof QuickReplyBlock) == true) goto L8;
        return false;
    L8:
        QuickReplyBlock r101 = (QuickReplyBlock) r100;
        if (Intrinsics.areEqual(this.items, r101.items) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.sortType, r101.sortType) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.hideOnClick, r101.hideOnClick) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.status, r101.status) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.guideText, r101.guideText) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.decisionContext, r101.decisionContext) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.thinkingContent, r101.thinkingContent) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.scene, r101.scene) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.interactionType, r101.interactionType) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        List<QuickReplyItem> r100 = this.items;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.sortType;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.hideOnClick;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.status;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.guideText;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        QuickReplyDecisionContext r116 = this.decisionContext;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        InteractionAskContent r119 = this.thinkingContent;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Integer r122 = this.scene;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Integer r125 = this.interactionType;
        if (r125 == null) goto L39;
        r101 = r125.hashCode();
    L39:
        return r124 + r101;
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
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
        return "QuickReplyBlock(items=" + this.items + ", sortType=" + this.sortType + ", hideOnClick=" + this.hideOnClick + ", status=" + this.status + ", guideText=" + this.guideText + ", decisionContext=" + this.decisionContext + ", thinkingContent=" + this.thinkingContent + ", scene=" + this.scene + ", interactionType=" + this.interactionType + ')';
    }

    static {
        Companion = new b();
        $childSerializers = new Lazy[]{LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new u0()), null, null, null, null, null, null, null, null};
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    public final QuickReplyDecisionContext getDecisionContext() {
        return this.decisionContext;
    }

    public final String getGuideText() {
        return this.guideText;
    }

    public final Boolean getHideOnClick() {
        return this.hideOnClick;
    }

    public final Integer getInteractionType() {
        return this.interactionType;
    }

    public final List<QuickReplyItem> getItems() {
        return this.items;
    }

    public final Integer getScene() {
        return this.scene;
    }

    public final Integer getSortType() {
        return this.sortType;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public final InteractionAskContent getThinkingContent() {
        return this.thinkingContent;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$imsdkkmp_api_release(QuickReplyBlock r100, muc.d r101, f r102) {
        Lazy<d<Object>>[] r103 = $childSerializers;
        boolean r104 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r105 = true;
    L9:
        if (r105 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, r103[0].getValue(), r100.items);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r106 = true;
    L18:
        if (r106 == false) goto L21;
        r101.encodeNullableSerializableElement(r102, 1, w0.f520792a, r100.sortType);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r107 = true;
    L27:
        if (r107 == false) goto L30;
        r101.encodeNullableSerializableElement(r102, 2, i.f520705a, r100.hideOnClick);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        boolean r108 = true;
    L36:
        if (r108 == false) goto L39;
        r101.encodeNullableSerializableElement(r102, 3, w0.f520792a, r100.status);
    L39:
        if (r101.shouldEncodeElementDefault(r102, 4) == false) goto L42;
    L40:
        boolean r109 = true;
    L45:
        if (r109 == false) goto L48;
        r101.encodeNullableSerializableElement(r102, 4, v2.f520790a, r100.guideText);
    L48:
        if (r101.shouldEncodeElementDefault(r102, 5) == false) goto L51;
    L49:
        boolean r110 = true;
    L54:
        if (r110 == false) goto L57;
        r101.encodeNullableSerializableElement(r102, 5, QuickReplyDecisionContext.a.f347010a, r100.decisionContext);
    L57:
        if (r101.shouldEncodeElementDefault(r102, 6) == false) goto L60;
    L58:
        boolean r111 = true;
    L63:
        if (r111 == false) goto L66;
        r101.encodeNullableSerializableElement(r102, 6, InteractionAskContent.a.f346902a, r100.thinkingContent);
    L66:
        if (r101.shouldEncodeElementDefault(r102, 7) == false) goto L69;
    L67:
        boolean r112 = true;
    L72:
        if (r112 == false) goto L75;
        r101.encodeNullableSerializableElement(r102, 7, w0.f520792a, r100.scene);
    L75:
        if (r101.shouldEncodeElementDefault(r102, 8) == false) goto L78;
    L76:
        r104 = true;
    L80:
        if (r104 == false) goto L83;
        r101.encodeNullableSerializableElement(r102, 8, w0.f520792a, r100.interactionType);
        return;
    L83:
        return;
    L78:
        if (r100.interactionType == null) goto L80;
    L69:
        if (r100.scene != null) goto L67;
        r112 = false;
        goto L72
    L60:
        if (r100.thinkingContent != null) goto L58;
        r111 = false;
        goto L63
    L51:
        if (r100.decisionContext != null) goto L49;
        r110 = false;
        goto L54
    L42:
        if (r100.guideText != null) goto L40;
        r109 = false;
        goto L45
    L33:
        if (r100.status != null) goto L31;
        r108 = false;
        goto L36
    L24:
        if (r100.hideOnClick != null) goto L22;
        r107 = false;
        goto L27
    L15:
        if (r100.sortType != null) goto L13;
        r106 = false;
        goto L18
    L6:
        if (r100.items != null) goto L4;
        r105 = false;
        goto L9
    }

    public QuickReplyBlock(List<QuickReplyItem> r100, Integer r101, Boolean r102, Integer r103, String r104, QuickReplyDecisionContext r105, InteractionAskContent r106, Integer r107, Integer r108) {
        this.items = r100;
        this.sortType = r101;
        this.hideOnClick = r102;
        this.status = r103;
        this.guideText = r104;
        this.decisionContext = r105;
        this.thinkingContent = r106;
        this.scene = r107;
        this.interactionType = r108;
    }

    public QuickReplyBlock(int r100, List r101, Integer r102, Boolean r103, Integer r104, String r105, QuickReplyDecisionContext r106, InteractionAskContent r107, Integer r110, Integer r111, q2 r112) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f347009b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.items = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.sortType = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.hideOnClick = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.status = null;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.guideText = null;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.decisionContext = null;
    L29:
        if ((r100 & 64) != 0) goto L31;
        this.thinkingContent = null;
    L33:
        if ((r100 & 128) != 0) goto L35;
        this.scene = null;
    L37:
        if ((r100 & 256) != 0) goto L39;
        this.interactionType = null;
        return;
    L39:
        this.interactionType = r111;
        return;
    L35:
        this.scene = r110;
        goto L37
    L31:
        this.thinkingContent = r107;
        goto L33
    L27:
        this.decisionContext = r106;
        goto L29
    L23:
        this.guideText = r105;
        goto L25
    L19:
        this.status = r104;
        goto L21
    L15:
        this.hideOnClick = r103;
        goto L17
    L11:
        this.sortType = r102;
        goto L13
    L7:
        this.items = r101;
        goto L9
    }

    public /* synthetic */ QuickReplyBlock(List r110, Integer r111, Boolean r112, Integer r113, String r114, QuickReplyDecisionContext r115, InteractionAskContent r116, Integer r117, Integer r118, int r210, DefaultConstructorMarker r211) {
        Integer r100 = null;
        if ((r210 & 1) == 0) goto L5;
        List r101 = null;
    L7:
        if ((r210 & 2) == 0) goto L9;
        Integer r102 = null;
    L11:
        if ((r210 & 4) == 0) goto L13;
        Boolean r103 = null;
    L15:
        if ((r210 & 8) == 0) goto L17;
        Integer r104 = null;
    L19:
        if ((r210 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r210 & 32) == 0) goto L25;
        QuickReplyDecisionContext r106 = null;
    L27:
        if ((r210 & 64) == 0) goto L29;
        InteractionAskContent r107 = null;
    L31:
        if ((r210 & 128) == 0) goto L33;
        Integer r108 = null;
    L35:
        if ((r210 & 256) != 0) goto L38;
        r100 = r118;
    L38:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r100);
        return;
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
}
