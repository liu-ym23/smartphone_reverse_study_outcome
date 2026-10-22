package com.larus.im.bean.message.block;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
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
import kotlinx.serialization.Transient;
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
import nuc.w0;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b.\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 R2\u00060\u0001j\u0002`\u0002:\u0002QRB\u008b\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0011\u0010\u0012B\u008b\u0001\b\u0010\u0012\u0006\u0010\u0013\u001a\u00020\b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0011\u0010\u0016J\u000b\u00107\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u00109\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010 J\u0010\u0010:\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010 J\u000b\u0010;\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0017\u0010<\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\fHÆ\u0003J\u0010\u0010=\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010 J\u0010\u0010>\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010 J\u0010\u0010?\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010 J\u0010\u0010@\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010 J\u0092\u0001\u0010A\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010BJ\u0013\u0010C\u001a\u00020D2\b\u0010E\u001a\u0004\u0018\u00010FHÖ\u0003J\t\u0010G\u001a\u00020\bHÖ\u0001J\t\u0010H\u001a\u00020\u0004HÖ\u0001J%\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020\u00002\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020OH\u0001¢\u0006\u0002\bPR\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0018\u001a\u0004\b\u001c\u0010\u001dR \u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010!\u0012\u0004\b\u001e\u0010\u0018\u001a\u0004\b\u001f\u0010 R \u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010!\u0012\u0004\b\"\u0010\u0018\u001a\u0004\b#\u0010 R\u001e\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010\u0018\u001a\u0004\b%\u0010\u001aR*\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010\u0018\u001a\u0004\b'\u0010(R \u0010\r\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010!\u0012\u0004\b)\u0010\u0018\u001a\u0004\b*\u0010 R \u0010\u000e\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010!\u0012\u0004\b+\u0010\u0018\u001a\u0004\b,\u0010 R \u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010!\u0012\u0004\b-\u0010\u0018\u001a\u0004\b.\u0010 R \u0010\u0010\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010!\u0012\u0004\b/\u0010\u0018\u001a\u0004\b0\u0010 R$\u00101\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b2\u0010\u0018\u001a\u0004\b3\u00104\"\u0004\b5\u00106¨\u0006S"}, d2 = {"Lcom/larus/im/bean/message/block/QuickReplyItem;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "text", "", "icon", "Lcom/larus/im/bean/message/block/QuickReplyIcon;", "renderStyle", "", ReportConstant.COMMON_ACTION_TYPE, "schemaPayload", "extraParams", "", "reviewStatus", "shortcutKey", "alignType", "highlightType", "<init>", "(Ljava/lang/String;Lcom/larus/im/bean/message/block/QuickReplyIcon;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/Map;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lcom/larus/im/bean/message/block/QuickReplyIcon;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/Map;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getText$annotations", "()V", "getText", "()Ljava/lang/String;", "getIcon$annotations", "getIcon", "()Lcom/larus/im/bean/message/block/QuickReplyIcon;", "getRenderStyle$annotations", "getRenderStyle", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getActionType$annotations", "getActionType", "getSchemaPayload$annotations", "getSchemaPayload", "getExtraParams$annotations", "getExtraParams", "()Ljava/util/Map;", "getReviewStatus$annotations", "getReviewStatus", "getShortcutKey$annotations", "getShortcutKey", "getAlignType$annotations", "getAlignType", "getHighlightType$annotations", "getHighlightType", "trackIndex", "getTrackIndex$annotations", "getTrackIndex", "()I", "setTrackIndex", "(I)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(Ljava/lang/String;Lcom/larus/im/bean/message/block/QuickReplyIcon;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/Map;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/larus/im/bean/message/block/QuickReplyItem;", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$imsdkkmp_api_release", "$serializer", "Companion", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class QuickReplyItem implements java.io.Serializable {
    private static final Lazy<d<Object>>[] $childSerializers = null;
    public static final b Companion = null;
    private final Integer actionType;
    private final Integer alignType;
    private final Map<String, String> extraParams;
    private final Integer highlightType;
    private final QuickReplyIcon icon;
    private final Integer renderStyle;
    private final Integer reviewStatus;
    private final String schemaPayload;
    private final Integer shortcutKey;
    private final String text;
    private transient int trackIndex;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<QuickReplyItem> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f347016a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f347017b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f347017b;
        }

        static {
            a r100 = new a();
            f347016a = r100;
            g2 r101 = new g2("com.larus.im.bean.message.block.QuickReplyItem", r100, 10);
            r101.j("text", true);
            r101.j("icon", true);
            r101.j("render_style", true);
            r101.j("action_type", true);
            r101.j("schema_payload", true);
            r101.j("extra_params", true);
            r101.j("review_status", true);
            r101.j("shortcut_key", true);
            r101.j("align_type", true);
            r101.j("highlight_type", true);
            f347017b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            Lazy[] r100 = QuickReplyItem.access$get$childSerializers$cp();
            v2 r101 = v2.f520790a;
            w0 r102 = w0.f520792a;
            return new d[]{kuc.a.d(r101), kuc.a.d(QuickReplyIcon.a.f347014a), kuc.a.d(r102), kuc.a.d(r102), kuc.a.d(r101), kuc.a.d((d) r100[5].getValue()), kuc.a.d(r102), kuc.a.d(r102), kuc.a.d(r102), kuc.a.d(r102)};
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r210) {
            Intrinsics.checkNotNullParameter(r210, "decoder");
            g2 r100 = f347017b;
            c r101 = r210.beginStructure(r100);
            Lazy[] r102 = QuickReplyItem.access$get$childSerializers$cp();
            int r103 = 9;
            String r110 = null;
            if (r101.decodeSequentially() == false) goto L5;
            v2 r104 = v2.f520790a;
            String r111 = (String) r101.decodeNullableSerializableElement(r100, 0, r104, null);
            QuickReplyIcon r112 = (QuickReplyIcon) r101.decodeNullableSerializableElement(r100, 1, QuickReplyIcon.a.f347014a, null);
            w0 r113 = w0.f520792a;
            Integer r105 = (Integer) r101.decodeNullableSerializableElement(r100, 2, r113, null);
            Integer r106 = (Integer) r101.decodeNullableSerializableElement(r100, 3, r113, null);
            String r107 = (String) r101.decodeNullableSerializableElement(r100, 4, r104, null);
            Map r108 = (Map) r101.decodeNullableSerializableElement(r100, 5, (juc.c) r102[5].getValue(), null);
            Integer r109 = (Integer) r101.decodeNullableSerializableElement(r100, 6, r113, null);
            Integer r114 = (Integer) r101.decodeNullableSerializableElement(r100, 7, r113, null);
            Map r115 = r108;
            String r116 = r107;
            Integer r211 = r109;
            Integer r117 = r106;
            Integer r212 = r114;
            Integer r213 = (Integer) r101.decodeNullableSerializableElement(r100, 8, r113, null);
            Integer r214 = (Integer) r101.decodeNullableSerializableElement(r100, 9, r113, null);
            Integer r118 = r105;
            r110 = r111;
            QuickReplyIcon r119 = r112;
            int r120 = 1023;
        L28:
            r101.endStructure(r100);
            return new QuickReplyItem(r120, r110, r119, r118, r117, r116, r115, r211, r212, r213, r214, null);
        L5:
            Integer r121 = null;
            Integer r122 = null;
            Integer r123 = null;
            Integer r124 = null;
            String r125 = null;
            Map r126 = null;
            QuickReplyIcon r127 = null;
            Integer r128 = null;
            Integer r129 = null;
            int r130 = 0;
            boolean r215 = true;
        L6:
            if (r215 == false) goto L27;
            int r131 = r101.decodeElementIndex(r100);
            switch(r131) {
                case -1: goto L26;
                case 0: goto L24;
                case 1: goto L22;
                case 2: goto L20;
                case 3: goto L18;
                case 4: goto L17;
                case 5: goto L16;
                case 6: goto L14;
                case 7: goto L13;
                case 8: goto L12;
                case 9: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r131);
        L26:
            r102 = r102;
            r215 = false;
            goto L6
        L11:
            r123 = (Integer) r101.decodeNullableSerializableElement(r100, r103, w0.f520792a, r123);
            r130 = r130 | 512;
        L25:
            r102 = r102;
            r103 = 9;
            goto L6
        L12:
            r124 = (Integer) r101.decodeNullableSerializableElement(r100, 8, w0.f520792a, r124);
            r130 = r130 | 256;
            goto L25
        L13:
            r122 = (Integer) r101.decodeNullableSerializableElement(r100, 7, w0.f520792a, r122);
            r130 = r130 | 128;
            goto L25
        L14:
            r121 = (Integer) r101.decodeNullableSerializableElement(r100, 6, w0.f520792a, r121);
            r130 = r130 | 64;
            goto L25
        L16:
            r126 = (Map) r101.decodeNullableSerializableElement(r100, 5, (juc.c) r102[5].getValue(), r126);
            r130 = r130 | 32;
            goto L25
        L17:
            r125 = (String) r101.decodeNullableSerializableElement(r100, 4, v2.f520790a, r125);
            r130 = r130 | 16;
            goto L25
        L18:
            r130 = r130 | 8;
            r129 = (Integer) r101.decodeNullableSerializableElement(r100, 3, w0.f520792a, r129);
            goto L25
        L20:
            r102 = r102;
            r130 = r130 | 4;
            r128 = (Integer) r101.decodeNullableSerializableElement(r100, 2, w0.f520792a, r128);
            goto L25
        L22:
            r102 = r102;
            r127 = (QuickReplyIcon) r101.decodeNullableSerializableElement(r100, 1, QuickReplyIcon.a.f347014a, r127);
            r130 = r130 | 2;
            goto L25
        L24:
            r102 = r102;
            r130 = r130 | 1;
            r110 = (String) r101.decodeNullableSerializableElement(r100, 0, v2.f520790a, r110);
            goto L25
        L27:
            r211 = r121;
            r212 = r122;
            r214 = r123;
            r213 = r124;
            r116 = r125;
            r115 = r126;
            r118 = r128;
            r117 = r129;
            r120 = r130;
            r119 = r127;
            goto L28
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            QuickReplyItem r102 = (QuickReplyItem) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f347017b;
            muc.d r104 = r100.beginStructure(r103);
            QuickReplyItem.write$Self$imsdkkmp_api_release(r102, r104, r103);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<QuickReplyItem> serializer() {
            return a.f347016a;
        }
    }

    public QuickReplyItem() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_() {
        v2 r100 = v2.f520790a;
        return new a1(r100, r100);
    }

    public static /* synthetic */ d a() {
        return _childSerializers$_anonymous_();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ QuickReplyItem copy$default(QuickReplyItem r110, String r111, QuickReplyIcon r112, Integer r113, Integer r114, String r115, Map r116, Integer r117, Integer r118, Integer r210, Integer r211, int r212, Object r213) {
        if ((r212 & 1) == 0) goto L5;
        String r100 = r110.text;
    L7:
        if ((r212 & 2) == 0) goto L9;
        QuickReplyIcon r101 = r110.icon;
    L11:
        if ((r212 & 4) == 0) goto L13;
        Integer r102 = r110.renderStyle;
    L15:
        if ((r212 & 8) == 0) goto L17;
        Integer r103 = r110.actionType;
    L19:
        if ((r212 & 16) == 0) goto L21;
        String r104 = r110.schemaPayload;
    L23:
        if ((r212 & 32) == 0) goto L25;
        Map r105 = r110.extraParams;
    L27:
        if ((r212 & 64) == 0) goto L29;
        Integer r106 = r110.reviewStatus;
    L31:
        if ((r212 & 128) == 0) goto L33;
        Integer r107 = r110.shortcutKey;
    L35:
        if ((r212 & 256) == 0) goto L37;
        Integer r119 = r110.alignType;
    L39:
        if ((r212 & 512) == 0) goto L41;
        Integer r108 = r110.highlightType;
    L43:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r119, r108);
    L41:
        r108 = r211;
        goto L43
    L37:
        r119 = r210;
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

    @SerialName("action_type")
    public static /* synthetic */ void getActionType$annotations() {
    }

    @SerialName("align_type")
    public static /* synthetic */ void getAlignType$annotations() {
    }

    @SerialName("extra_params")
    public static /* synthetic */ void getExtraParams$annotations() {
    }

    @SerialName("highlight_type")
    public static /* synthetic */ void getHighlightType$annotations() {
    }

    @SerialName("icon")
    public static /* synthetic */ void getIcon$annotations() {
    }

    @SerialName("render_style")
    public static /* synthetic */ void getRenderStyle$annotations() {
    }

    @SerialName("review_status")
    public static /* synthetic */ void getReviewStatus$annotations() {
    }

    @SerialName("schema_payload")
    public static /* synthetic */ void getSchemaPayload$annotations() {
    }

    @SerialName("shortcut_key")
    public static /* synthetic */ void getShortcutKey$annotations() {
    }

    @SerialName("text")
    public static /* synthetic */ void getText$annotations() {
    }

    @Transient
    public static /* synthetic */ void getTrackIndex$annotations() {
    }

    public final String component1() {
        return this.text;
    }

    public final Integer component10() {
        return this.highlightType;
    }

    public final QuickReplyIcon component2() {
        return this.icon;
    }

    public final Integer component3() {
        return this.renderStyle;
    }

    public final Integer component4() {
        return this.actionType;
    }

    public final String component5() {
        return this.schemaPayload;
    }

    public final Map<String, String> component6() {
        return this.extraParams;
    }

    public final Integer component7() {
        return this.reviewStatus;
    }

    public final Integer component8() {
        return this.shortcutKey;
    }

    public final Integer component9() {
        return this.alignType;
    }

    public final QuickReplyItem copy(String r110, QuickReplyIcon r111, Integer r112, Integer r113, String r114, Map<String, String> r115, Integer r116, Integer r210, Integer r211, Integer r212) {
        return new QuickReplyItem(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof QuickReplyItem) == true) goto L8;
        return false;
    L8:
        QuickReplyItem r101 = (QuickReplyItem) r100;
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.icon, r101.icon) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.renderStyle, r101.renderStyle) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.actionType, r101.actionType) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.schemaPayload, r101.schemaPayload) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.extraParams, r101.extraParams) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.reviewStatus, r101.reviewStatus) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.shortcutKey, r101.shortcutKey) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.alignType, r101.alignType) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.highlightType, r101.highlightType) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        String r100 = this.text;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        QuickReplyIcon r104 = this.icon;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.renderStyle;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.actionType;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.schemaPayload;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Map<String, String> r116 = this.extraParams;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.reviewStatus;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Integer r122 = this.shortcutKey;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Integer r125 = this.alignType;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        Integer r128 = this.highlightType;
        if (r128 == null) goto L43;
        r101 = r128.hashCode();
    L43:
        return r127 + r101;
    L37:
        r126 = r125.hashCode();
        goto L38
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
        return "QuickReplyItem(text=" + this.text + ", icon=" + this.icon + ", renderStyle=" + this.renderStyle + ", actionType=" + this.actionType + ", schemaPayload=" + this.schemaPayload + ", extraParams=" + this.extraParams + ", reviewStatus=" + this.reviewStatus + ", shortcutKey=" + this.shortcutKey + ", alignType=" + this.alignType + ", highlightType=" + this.highlightType + ')';
    }

    static {
        Companion = new b();
        $childSerializers = new Lazy[]{null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new zc9.w0()), null, null, null, null};
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    public final Integer getActionType() {
        return this.actionType;
    }

    public final Integer getAlignType() {
        return this.alignType;
    }

    public final Map<String, String> getExtraParams() {
        return this.extraParams;
    }

    public final Integer getHighlightType() {
        return this.highlightType;
    }

    public final QuickReplyIcon getIcon() {
        return this.icon;
    }

    public final Integer getRenderStyle() {
        return this.renderStyle;
    }

    public final Integer getReviewStatus() {
        return this.reviewStatus;
    }

    public final String getSchemaPayload() {
        return this.schemaPayload;
    }

    public final Integer getShortcutKey() {
        return this.shortcutKey;
    }

    public final String getText() {
        return this.text;
    }

    public final int getTrackIndex() {
        return this.trackIndex;
    }

    public final void setTrackIndex(int r100) {
        this.trackIndex = r100;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$imsdkkmp_api_release(QuickReplyItem r100, muc.d r101, f r102) {
        Lazy<d<Object>>[] r103 = $childSerializers;
        boolean r104 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r105 = true;
    L9:
        if (r105 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, v2.f520790a, r100.text);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r106 = true;
    L18:
        if (r106 == false) goto L21;
        r101.encodeNullableSerializableElement(r102, 1, QuickReplyIcon.a.f347014a, r100.icon);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r107 = true;
    L27:
        if (r107 == false) goto L30;
        r101.encodeNullableSerializableElement(r102, 2, w0.f520792a, r100.renderStyle);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        boolean r108 = true;
    L36:
        if (r108 == false) goto L39;
        r101.encodeNullableSerializableElement(r102, 3, w0.f520792a, r100.actionType);
    L39:
        if (r101.shouldEncodeElementDefault(r102, 4) == false) goto L42;
    L40:
        boolean r109 = true;
    L45:
        if (r109 == false) goto L48;
        r101.encodeNullableSerializableElement(r102, 4, v2.f520790a, r100.schemaPayload);
    L48:
        if (r101.shouldEncodeElementDefault(r102, 5) == false) goto L51;
    L49:
        boolean r110 = true;
    L54:
        if (r110 == false) goto L57;
        r101.encodeNullableSerializableElement(r102, 5, r103[5].getValue(), r100.extraParams);
    L57:
        if (r101.shouldEncodeElementDefault(r102, 6) == false) goto L60;
    L58:
        boolean r111 = true;
    L63:
        if (r111 == false) goto L66;
        r101.encodeNullableSerializableElement(r102, 6, w0.f520792a, r100.reviewStatus);
    L66:
        if (r101.shouldEncodeElementDefault(r102, 7) == false) goto L69;
    L67:
        boolean r112 = true;
    L72:
        if (r112 == false) goto L75;
        r101.encodeNullableSerializableElement(r102, 7, w0.f520792a, r100.shortcutKey);
    L75:
        if (r101.shouldEncodeElementDefault(r102, 8) == false) goto L78;
    L76:
        boolean r113 = true;
    L81:
        if (r113 == false) goto L84;
        r101.encodeNullableSerializableElement(r102, 8, w0.f520792a, r100.alignType);
    L84:
        if (r101.shouldEncodeElementDefault(r102, 9) == false) goto L87;
    L85:
        r104 = true;
    L89:
        if (r104 == false) goto L92;
        r101.encodeNullableSerializableElement(r102, 9, w0.f520792a, r100.highlightType);
        return;
    L92:
        return;
    L87:
        if (r100.highlightType == null) goto L89;
    L78:
        if (r100.alignType != null) goto L76;
        r113 = false;
        goto L81
    L69:
        if (r100.shortcutKey != null) goto L67;
        r112 = false;
        goto L72
    L60:
        if (r100.reviewStatus != null) goto L58;
        r111 = false;
        goto L63
    L51:
        if (r100.extraParams != null) goto L49;
        r110 = false;
        goto L54
    L42:
        if (r100.schemaPayload != null) goto L40;
        r109 = false;
        goto L45
    L33:
        if (r100.actionType != null) goto L31;
        r108 = false;
        goto L36
    L24:
        if (r100.renderStyle != null) goto L22;
        r107 = false;
        goto L27
    L15:
        if (r100.icon != null) goto L13;
        r106 = false;
        goto L18
    L6:
        if (r100.text != null) goto L4;
        r105 = false;
        goto L9
    }

    public QuickReplyItem(String r100, QuickReplyIcon r101, Integer r102, Integer r103, String r104, Map<String, String> r105, Integer r106, Integer r107, Integer r108, Integer r110) {
        this.text = r100;
        this.icon = r101;
        this.renderStyle = r102;
        this.actionType = r103;
        this.schemaPayload = r104;
        this.extraParams = r105;
        this.reviewStatus = r106;
        this.shortcutKey = r107;
        this.alignType = r108;
        this.highlightType = r110;
    }

    public QuickReplyItem(int r100, String r101, QuickReplyIcon r102, Integer r103, Integer r104, String r105, Map r106, Integer r110, Integer r111, Integer r112, Integer r113, q2 r114) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f347017b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.text = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.icon = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.renderStyle = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.actionType = null;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.schemaPayload = null;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.extraParams = null;
    L29:
        if ((r100 & 64) != 0) goto L31;
        this.reviewStatus = null;
    L33:
        if ((r100 & 128) != 0) goto L35;
        this.shortcutKey = null;
    L37:
        if ((r100 & 256) != 0) goto L39;
        this.alignType = null;
    L41:
        if ((r100 & 512) != 0) goto L43;
        this.highlightType = null;
    L44:
        this.trackIndex = 0;
        return;
    L43:
        this.highlightType = r113;
        goto L44
    L39:
        this.alignType = r112;
        goto L41
    L35:
        this.shortcutKey = r111;
        goto L37
    L31:
        this.reviewStatus = r110;
        goto L33
    L27:
        this.extraParams = r106;
        goto L29
    L23:
        this.schemaPayload = r105;
        goto L25
    L19:
        this.actionType = r104;
        goto L21
    L15:
        this.renderStyle = r103;
        goto L17
    L11:
        this.icon = r102;
        goto L13
    L7:
        this.text = r101;
        goto L9
    }

    public /* synthetic */ QuickReplyItem(String r110, QuickReplyIcon r111, Integer r112, Integer r113, String r114, Map r115, Integer r116, Integer r117, Integer r210, Integer r211, int r212, DefaultConstructorMarker r213) {
        Integer r100 = null;
        if ((r212 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r212 & 2) == 0) goto L9;
        QuickReplyIcon r102 = null;
    L11:
        if ((r212 & 4) == 0) goto L13;
        Integer r103 = null;
    L15:
        if ((r212 & 8) == 0) goto L17;
        Integer r104 = null;
    L19:
        if ((r212 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r212 & 32) == 0) goto L25;
        Map r106 = null;
    L27:
        if ((r212 & 64) == 0) goto L29;
        Integer r107 = null;
    L31:
        if ((r212 & 128) == 0) goto L33;
        Integer r108 = null;
    L35:
        if ((r212 & 256) == 0) goto L37;
        Integer r118 = null;
    L39:
        if ((r212 & 512) != 0) goto L42;
        r100 = r211;
    L42:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r118, r100);
        return;
    L37:
        r118 = r210;
        goto L39
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
