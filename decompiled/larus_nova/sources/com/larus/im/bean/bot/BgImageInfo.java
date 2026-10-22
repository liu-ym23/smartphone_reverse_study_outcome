package com.larus.im.bean.bot;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import java.util.List;
import juc.d;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 Q2\u00060\u0001j\u0002`\u0002:\u0002PQB\u0093\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0012\u0010\u0013B\u0091\u0001\b\u0010\u0012\u0006\u0010\u0014\u001a\u00020\u0010\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0010\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0012\u0010\u0017J\u0006\u00104\u001a\u000205J\u000b\u00106\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u00108\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010 J\u0013\u00109\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\tHÆ\u0003J\u0010\u0010:\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010 J\u000b\u0010;\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010?\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u00101J\u000b\u0010@\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u009a\u0001\u0010A\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u0010BJ\u0013\u0010C\u001a\u00020\u00072\b\u0010D\u001a\u0004\u0018\u00010EHÖ\u0003J\t\u0010F\u001a\u00020\u0010HÖ\u0001J\t\u0010G\u001a\u00020\u0004HÖ\u0001J%\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020\u00002\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020NH\u0001¢\u0006\u0002\bOR\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0019\u001a\u0004\b\u001d\u0010\u001bR \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010!\u0012\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010 R&\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u0019\u001a\u0004\b#\u0010$R \u0010\n\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010!\u0012\u0004\b%\u0010\u0019\u001a\u0004\b&\u0010 R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010\u0019\u001a\u0004\b(\u0010\u001bR\u001e\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b)\u0010\u0019\u001a\u0004\b*\u0010\u001bR\u001e\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b+\u0010\u0019\u001a\u0004\b,\u0010\u001bR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b-\u0010\u0019\u001a\u0004\b.\u0010\u001bR \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u00102\u0012\u0004\b/\u0010\u0019\u001a\u0004\b0\u00101R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b3\u0010\u0019¨\u0006R"}, d2 = {"Lcom/larus/im/bean/bot/BgImageInfo;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "bgImgPrompt", "", "bgImgPromptEn", "aiGenBgImg", "", "bgImgDrawStyleStarlingKey", "", "bgImgOpen", "referenceBgImgUri", "referenceBgImgUrl", "referenceBgImgStyle", "referenceBgImgPrompt", "bgCategoryType", "", "bgImagePromptForEnrich", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getBgImgPrompt$annotations", "()V", "getBgImgPrompt", "()Ljava/lang/String;", "getBgImgPromptEn$annotations", "getBgImgPromptEn", "getAiGenBgImg$annotations", "getAiGenBgImg", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getBgImgDrawStyleStarlingKey$annotations", "getBgImgDrawStyleStarlingKey", "()Ljava/util/List;", "getBgImgOpen$annotations", "getBgImgOpen", "getReferenceBgImgUri$annotations", "getReferenceBgImgUri", "getReferenceBgImgUrl$annotations", "getReferenceBgImgUrl", "getReferenceBgImgStyle$annotations", "getReferenceBgImgStyle", "getReferenceBgImgPrompt$annotations", "getReferenceBgImgPrompt", "getBgCategoryType$annotations", "getBgCategoryType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBgImagePromptForEnrich$annotations", "toBgImageEditInfo", "Lcom/larus/im/bean/bot/BgImageEditInfo;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/larus/im/bean/bot/BgImageInfo;", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$imsdkkmp_api_release", "$serializer", "Companion", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class BgImageInfo implements java.io.Serializable {
    public static final b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy<d<Object>>[] f346422a = null;
    private final Boolean aiGenBgImg;
    private final Integer bgCategoryType;
    public final String bgImagePromptForEnrich;
    private final List<String> bgImgDrawStyleStarlingKey;
    private final Boolean bgImgOpen;
    private final String bgImgPrompt;
    private final String bgImgPromptEn;
    private final String referenceBgImgPrompt;
    private final String referenceBgImgStyle;
    private final String referenceBgImgUri;
    private final String referenceBgImgUrl;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<BgImageInfo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f346423a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f346424b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f346424b;
        }

        static {
            a r100 = new a();
            f346423a = r100;
            g2 r101 = new g2("com.larus.im.bean.bot.BgImageInfo", r100, 11);
            r101.j("bg_img_prompt", true);
            r101.j("bg_img_prompt_en", true);
            r101.j("ai_gen_bg_img", true);
            r101.j("bg_img_draw_style_starling_key", true);
            r101.j("bg_img_open", true);
            r101.j("reference_bg_img_uri", true);
            r101.j("reference_bg_img_url", true);
            r101.j("reference_bg_img_style", true);
            r101.j("reference_bg_img_prompt", true);
            r101.j("bot_category_type", true);
            r101.j("bg_image_prompt_for_enrich", true);
            f346424b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            Lazy[] r100 = BgImageInfo.access$get$childSerializers$cp();
            v2 r101 = v2.f520790a;
            i r102 = i.f520705a;
            return new d[]{kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r102), kuc.a.d((d) r100[3].getValue()), kuc.a.d(r102), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(w0.f520792a), kuc.a.d(r101)};
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r210) {
            Intrinsics.checkNotNullParameter(r210, "decoder");
            g2 r100 = f346424b;
            c r101 = r210.beginStructure(r100);
            Lazy[] r102 = BgImageInfo.access$get$childSerializers$cp();
            int r103 = 9;
            int r110 = 8;
            Boolean r111 = null;
            if (r101.decodeSequentially() == false) goto L5;
            v2 r104 = v2.f520790a;
            String r112 = (String) r101.decodeNullableSerializableElement(r100, 0, r104, null);
            String r113 = (String) r101.decodeNullableSerializableElement(r100, 1, r104, null);
            i r105 = i.f520705a;
            Boolean r114 = (Boolean) r101.decodeNullableSerializableElement(r100, 2, r105, null);
            List r106 = (List) r101.decodeNullableSerializableElement(r100, 3, (juc.c) r102[3].getValue(), null);
            Boolean r107 = (Boolean) r101.decodeNullableSerializableElement(r100, 4, r105, null);
            String r108 = (String) r101.decodeNullableSerializableElement(r100, 5, r104, null);
            String r109 = (String) r101.decodeNullableSerializableElement(r100, 6, r104, null);
            String r115 = (String) r101.decodeNullableSerializableElement(r100, 7, r104, null);
            String r116 = (String) r101.decodeNullableSerializableElement(r100, 8, r104, null);
            Integer r117 = (Integer) r101.decodeNullableSerializableElement(r100, 9, w0.f520792a, null);
            String r211 = (String) r101.decodeNullableSerializableElement(r100, 10, r104, null);
            r111 = r107;
            String r118 = r108;
            String r119 = r109;
            String r120 = r115;
            String r121 = r116;
            Integer r212 = r117;
            String r122 = r112;
            String r123 = r113;
            List r124 = r106;
            Boolean r125 = r114;
            int r126 = 2047;
        L30:
            r101.endStructure(r100);
            return new BgImageInfo(r126, r122, r123, r125, r124, r111, r118, r119, r120, r121, r212, r211, null);
        L5:
            int r127 = 10;
            String r128 = null;
            String r129 = null;
            Integer r130 = null;
            String r131 = null;
            String r132 = null;
            r125 = null;
            String r133 = null;
            String r134 = null;
            String r213 = null;
            List r214 = null;
            int r135 = 0;
            boolean r215 = true;
        L6:
            if (r215 == false) goto L29;
            int r136 = r101.decodeElementIndex(r100);
            switch(r136) {
                case -1: goto L28;
                case 0: goto L26;
                case 1: goto L24;
                case 2: goto L22;
                case 3: goto L21;
                case 4: goto L20;
                case 5: goto L17;
                case 6: goto L15;
                case 7: goto L14;
                case 8: goto L13;
                case 9: goto L12;
                case 10: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r136);
        L28:
            r102 = r102;
            r103 = 9;
            r110 = 8;
            r215 = false;
            goto L6
        L11:
            r129 = (String) r101.decodeNullableSerializableElement(r100, r127, v2.f520790a, r129);
            r135 = r135 | 1024;
        L18:
            List r137 = r214;
        L23:
            String r138 = r134;
        L27:
            r102 = r102;
            r134 = r138;
            r214 = r137;
            r127 = 10;
            r103 = 9;
            r110 = 8;
            goto L6
        L12:
            r130 = (Integer) r101.decodeNullableSerializableElement(r100, r103, w0.f520792a, r130);
            r135 = r135 | 512;
            goto L18
        L13:
            r128 = (String) r101.decodeNullableSerializableElement(r100, r110, v2.f520790a, r128);
            r135 = r135 | 256;
            goto L18
        L14:
            r131 = (String) r101.decodeNullableSerializableElement(r100, 7, v2.f520790a, r131);
            r135 = r135 | 128;
            goto L18
        L15:
            r132 = (String) r101.decodeNullableSerializableElement(r100, 6, v2.f520790a, r132);
            r135 = r135 | 64;
            goto L18
        L17:
            r133 = (String) r101.decodeNullableSerializableElement(r100, 5, v2.f520790a, r133);
            r135 = r135 | 32;
            goto L18
        L20:
            r111 = (Boolean) r101.decodeNullableSerializableElement(r100, 4, i.f520705a, r111);
            r135 = r135 | 16;
            goto L18
        L21:
            r135 = r135 | 8;
            r137 = (List) r101.decodeNullableSerializableElement(r100, 3, (juc.c) r102[3].getValue(), r214);
            goto L23
        L22:
            r137 = r214;
            r125 = (Boolean) r101.decodeNullableSerializableElement(r100, 2, i.f520705a, r125);
            r135 = r135 | 4;
            goto L23
        L24:
            r137 = r214;
            r138 = (String) r101.decodeNullableSerializableElement(r100, 1, v2.f520790a, r134);
            r135 = r135 | 2;
            goto L27
        L26:
            r137 = r214;
            r135 = r135 | 1;
            r213 = (String) r101.decodeNullableSerializableElement(r100, 0, v2.f520790a, r213);
            r138 = r134;
            goto L27
        L29:
            String r139 = r134;
            r121 = r128;
            r211 = r129;
            r212 = r130;
            r120 = r131;
            r119 = r132;
            r122 = r213;
            r118 = r133;
            r126 = r135;
            r123 = r139;
            r124 = r214;
            goto L30
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            BgImageInfo r102 = (BgImageInfo) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f346424b;
            muc.d r104 = r100.beginStructure(r103);
            BgImageInfo.write$Self$imsdkkmp_api_release(r102, r104, r103);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<BgImageInfo> serializer() {
            return a.f346423a;
        }
    }

    public BgImageInfo() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BgImageInfo copy$default(BgImageInfo r110, String r111, String r112, Boolean r113, List r114, Boolean r115, String r116, String r117, String r210, String r211, Integer r212, String r213, int r214, Object r215) {
        if ((r214 & 1) == 0) goto L5;
        String r100 = r110.bgImgPrompt;
    L7:
        if ((r214 & 2) == 0) goto L9;
        String r101 = r110.bgImgPromptEn;
    L11:
        if ((r214 & 4) == 0) goto L13;
        Boolean r102 = r110.aiGenBgImg;
    L15:
        if ((r214 & 8) == 0) goto L17;
        List r103 = r110.bgImgDrawStyleStarlingKey;
    L19:
        if ((r214 & 16) == 0) goto L21;
        Boolean r104 = r110.bgImgOpen;
    L23:
        if ((r214 & 32) == 0) goto L25;
        String r105 = r110.referenceBgImgUri;
    L27:
        if ((r214 & 64) == 0) goto L29;
        String r106 = r110.referenceBgImgUrl;
    L31:
        if ((r214 & 128) == 0) goto L33;
        String r107 = r110.referenceBgImgStyle;
    L35:
        if ((r214 & 256) == 0) goto L37;
        String r118 = r110.referenceBgImgPrompt;
    L39:
        if ((r214 & 512) == 0) goto L41;
        Integer r119 = r110.bgCategoryType;
    L43:
        if ((r214 & 1024) == 0) goto L45;
        String r108 = r110.bgImagePromptForEnrich;
    L47:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r118, r119, r108);
    L45:
        r108 = r213;
        goto L47
    L41:
        r119 = r212;
        goto L43
    L37:
        r118 = r211;
        goto L39
    L33:
        r107 = r210;
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

    @SerialName("ai_gen_bg_img")
    public static /* synthetic */ void getAiGenBgImg$annotations() {
    }

    @SerialName("bot_category_type")
    public static /* synthetic */ void getBgCategoryType$annotations() {
    }

    @SerialName("bg_image_prompt_for_enrich")
    public static /* synthetic */ void getBgImagePromptForEnrich$annotations() {
    }

    @SerialName("bg_img_draw_style_starling_key")
    public static /* synthetic */ void getBgImgDrawStyleStarlingKey$annotations() {
    }

    @SerialName("bg_img_open")
    public static /* synthetic */ void getBgImgOpen$annotations() {
    }

    @SerialName("bg_img_prompt")
    public static /* synthetic */ void getBgImgPrompt$annotations() {
    }

    @SerialName("bg_img_prompt_en")
    public static /* synthetic */ void getBgImgPromptEn$annotations() {
    }

    @SerialName("reference_bg_img_prompt")
    public static /* synthetic */ void getReferenceBgImgPrompt$annotations() {
    }

    @SerialName("reference_bg_img_style")
    public static /* synthetic */ void getReferenceBgImgStyle$annotations() {
    }

    @SerialName("reference_bg_img_uri")
    public static /* synthetic */ void getReferenceBgImgUri$annotations() {
    }

    @SerialName("reference_bg_img_url")
    public static /* synthetic */ void getReferenceBgImgUrl$annotations() {
    }

    public final String component1() {
        return this.bgImgPrompt;
    }

    public final Integer component10() {
        return this.bgCategoryType;
    }

    public final String component11() {
        return this.bgImagePromptForEnrich;
    }

    public final String component2() {
        return this.bgImgPromptEn;
    }

    public final Boolean component3() {
        return this.aiGenBgImg;
    }

    public final List<String> component4() {
        return this.bgImgDrawStyleStarlingKey;
    }

    public final Boolean component5() {
        return this.bgImgOpen;
    }

    public final String component6() {
        return this.referenceBgImgUri;
    }

    public final String component7() {
        return this.referenceBgImgUrl;
    }

    public final String component8() {
        return this.referenceBgImgStyle;
    }

    public final String component9() {
        return this.referenceBgImgPrompt;
    }

    public final BgImageInfo copy(String r110, String r111, Boolean r112, List<String> r113, Boolean r114, String r115, String r210, String r211, String r212, Integer r213, String r214) {
        return new BgImageInfo(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BgImageInfo) == true) goto L8;
        return false;
    L8:
        BgImageInfo r101 = (BgImageInfo) r100;
        if (Intrinsics.areEqual(this.bgImgPrompt, r101.bgImgPrompt) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.bgImgPromptEn, r101.bgImgPromptEn) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.aiGenBgImg, r101.aiGenBgImg) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.bgImgDrawStyleStarlingKey, r101.bgImgDrawStyleStarlingKey) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.bgImgOpen, r101.bgImgOpen) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.referenceBgImgUri, r101.referenceBgImgUri) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.referenceBgImgUrl, r101.referenceBgImgUrl) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.referenceBgImgStyle, r101.referenceBgImgStyle) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.referenceBgImgPrompt, r101.referenceBgImgPrompt) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.bgCategoryType, r101.bgCategoryType) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.bgImagePromptForEnrich, r101.bgImagePromptForEnrich) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public int hashCode() {
        String r100 = this.bgImgPrompt;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.bgImgPromptEn;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.aiGenBgImg;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        List<String> r110 = this.bgImgDrawStyleStarlingKey;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Boolean r113 = this.bgImgOpen;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.referenceBgImgUri;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.referenceBgImgUrl;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.referenceBgImgStyle;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.referenceBgImgPrompt;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        Integer r128 = this.bgCategoryType;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.bgImagePromptForEnrich;
        if (r131 == null) goto L47;
        r101 = r131.hashCode();
    L47:
        return r130 + r101;
    L41:
        r129 = r128.hashCode();
        goto L42
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
        return "BgImageInfo(bgImgPrompt=" + this.bgImgPrompt + ", bgImgPromptEn=" + this.bgImgPromptEn + ", aiGenBgImg=" + this.aiGenBgImg + ", bgImgDrawStyleStarlingKey=" + this.bgImgDrawStyleStarlingKey + ", bgImgOpen=" + this.bgImgOpen + ", referenceBgImgUri=" + this.referenceBgImgUri + ", referenceBgImgUrl=" + this.referenceBgImgUrl + ", referenceBgImgStyle=" + this.referenceBgImgStyle + ", referenceBgImgPrompt=" + this.referenceBgImgPrompt + ", bgCategoryType=" + this.bgCategoryType + ", bgImagePromptForEnrich=" + this.bgImagePromptForEnrich + ')';
    }

    static {
        Companion = new b();
        f346422a = new Lazy[]{null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new uc9.c()), null, null, null, null, null, null, null};
    }

    public final uc9.b toBgImageEditInfo() {
        String r100 = this.bgImgPrompt;
        String r101 = this.bgImgPromptEn;
        Boolean r102 = this.aiGenBgImg;
        List<String> r103 = this.bgImgDrawStyleStarlingKey;
        if (r103 == null) goto L5;
        List r104 = CollectionsKt.toList(r103);
    L7:
        return new uc9.b(r100, r101, r102, r104, this.bgImgOpen, this.referenceBgImgUri, this.referenceBgImgUrl, this.referenceBgImgStyle, this.referenceBgImgPrompt, this.bgCategoryType, this.bgImagePromptForEnrich);
    L5:
        r104 = null;
        goto L7
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return f346422a;
    }

    public final Boolean getAiGenBgImg() {
        return this.aiGenBgImg;
    }

    public final Integer getBgCategoryType() {
        return this.bgCategoryType;
    }

    public final List<String> getBgImgDrawStyleStarlingKey() {
        return this.bgImgDrawStyleStarlingKey;
    }

    public final Boolean getBgImgOpen() {
        return this.bgImgOpen;
    }

    public final String getBgImgPrompt() {
        return this.bgImgPrompt;
    }

    public final String getBgImgPromptEn() {
        return this.bgImgPromptEn;
    }

    public final String getReferenceBgImgPrompt() {
        return this.referenceBgImgPrompt;
    }

    public final String getReferenceBgImgStyle() {
        return this.referenceBgImgStyle;
    }

    public final String getReferenceBgImgUri() {
        return this.referenceBgImgUri;
    }

    public final String getReferenceBgImgUrl() {
        return this.referenceBgImgUrl;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$imsdkkmp_api_release(BgImageInfo r100, muc.d r101, f r102) {
        Lazy<d<Object>>[] r103 = f346422a;
        boolean r104 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r105 = true;
    L9:
        if (r105 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, v2.f520790a, r100.bgImgPrompt);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r106 = true;
    L18:
        if (r106 == false) goto L21;
        r101.encodeNullableSerializableElement(r102, 1, v2.f520790a, r100.bgImgPromptEn);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r107 = true;
    L27:
        if (r107 == false) goto L30;
        r101.encodeNullableSerializableElement(r102, 2, i.f520705a, r100.aiGenBgImg);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        boolean r108 = true;
    L36:
        if (r108 == false) goto L39;
        r101.encodeNullableSerializableElement(r102, 3, r103[3].getValue(), r100.bgImgDrawStyleStarlingKey);
    L39:
        if (r101.shouldEncodeElementDefault(r102, 4) == false) goto L42;
    L40:
        boolean r109 = true;
    L45:
        if (r109 == false) goto L48;
        r101.encodeNullableSerializableElement(r102, 4, i.f520705a, r100.bgImgOpen);
    L48:
        if (r101.shouldEncodeElementDefault(r102, 5) == false) goto L51;
    L49:
        boolean r110 = true;
    L54:
        if (r110 == false) goto L57;
        r101.encodeNullableSerializableElement(r102, 5, v2.f520790a, r100.referenceBgImgUri);
    L57:
        if (r101.shouldEncodeElementDefault(r102, 6) == false) goto L60;
    L58:
        boolean r111 = true;
    L63:
        if (r111 == false) goto L66;
        r101.encodeNullableSerializableElement(r102, 6, v2.f520790a, r100.referenceBgImgUrl);
    L66:
        if (r101.shouldEncodeElementDefault(r102, 7) == false) goto L69;
    L67:
        boolean r112 = true;
    L72:
        if (r112 == false) goto L75;
        r101.encodeNullableSerializableElement(r102, 7, v2.f520790a, r100.referenceBgImgStyle);
    L75:
        if (r101.shouldEncodeElementDefault(r102, 8) == false) goto L78;
    L76:
        boolean r113 = true;
    L81:
        if (r113 == false) goto L84;
        r101.encodeNullableSerializableElement(r102, 8, v2.f520790a, r100.referenceBgImgPrompt);
    L84:
        if (r101.shouldEncodeElementDefault(r102, 9) == false) goto L87;
    L85:
        boolean r114 = true;
    L90:
        if (r114 == false) goto L93;
        r101.encodeNullableSerializableElement(r102, 9, w0.f520792a, r100.bgCategoryType);
    L93:
        if (r101.shouldEncodeElementDefault(r102, 10) == false) goto L96;
    L94:
        r104 = true;
    L98:
        if (r104 == false) goto L101;
        r101.encodeNullableSerializableElement(r102, 10, v2.f520790a, r100.bgImagePromptForEnrich);
        return;
    L101:
        return;
    L96:
        if (r100.bgImagePromptForEnrich == null) goto L98;
    L87:
        if (r100.bgCategoryType != null) goto L85;
        r114 = false;
        goto L90
    L78:
        if (r100.referenceBgImgPrompt != null) goto L76;
        r113 = false;
        goto L81
    L69:
        if (r100.referenceBgImgStyle != null) goto L67;
        r112 = false;
        goto L72
    L60:
        if (r100.referenceBgImgUrl != null) goto L58;
        r111 = false;
        goto L63
    L51:
        if (r100.referenceBgImgUri != null) goto L49;
        r110 = false;
        goto L54
    L42:
        if (r100.bgImgOpen != null) goto L40;
        r109 = false;
        goto L45
    L33:
        if (r100.bgImgDrawStyleStarlingKey != null) goto L31;
        r108 = false;
        goto L36
    L24:
        if (r100.aiGenBgImg != null) goto L22;
        r107 = false;
        goto L27
    L15:
        if (r100.bgImgPromptEn != null) goto L13;
        r106 = false;
        goto L18
    L6:
        if (r100.bgImgPrompt != null) goto L4;
        r105 = false;
        goto L9
    }

    public BgImageInfo(String r100, String r101, Boolean r102, List<String> r103, Boolean r104, String r105, String r106, String r107, String r108, Integer r110, String r111) {
        this.bgImgPrompt = r100;
        this.bgImgPromptEn = r101;
        this.aiGenBgImg = r102;
        this.bgImgDrawStyleStarlingKey = r103;
        this.bgImgOpen = r104;
        this.referenceBgImgUri = r105;
        this.referenceBgImgUrl = r106;
        this.referenceBgImgStyle = r107;
        this.referenceBgImgPrompt = r108;
        this.bgCategoryType = r110;
        this.bgImagePromptForEnrich = r111;
    }

    public BgImageInfo(int r100, String r101, String r102, Boolean r103, List r104, Boolean r105, String r106, String r107, String r110, String r111, Integer r112, String r113, q2 r114) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f346424b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.bgImgPrompt = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.bgImgPromptEn = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.aiGenBgImg = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.bgImgDrawStyleStarlingKey = null;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.bgImgOpen = null;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.referenceBgImgUri = null;
    L29:
        if ((r100 & 64) != 0) goto L31;
        this.referenceBgImgUrl = null;
    L33:
        if ((r100 & 128) != 0) goto L35;
        this.referenceBgImgStyle = null;
    L37:
        if ((r100 & 256) != 0) goto L39;
        this.referenceBgImgPrompt = null;
    L41:
        if ((r100 & 512) != 0) goto L43;
        this.bgCategoryType = null;
    L45:
        if ((r100 & 1024) != 0) goto L47;
        this.bgImagePromptForEnrich = null;
        return;
    L47:
        this.bgImagePromptForEnrich = r113;
        return;
    L43:
        this.bgCategoryType = r112;
        goto L45
    L39:
        this.referenceBgImgPrompt = r111;
        goto L41
    L35:
        this.referenceBgImgStyle = r110;
        goto L37
    L31:
        this.referenceBgImgUrl = r107;
        goto L33
    L27:
        this.referenceBgImgUri = r106;
        goto L29
    L23:
        this.bgImgOpen = r105;
        goto L25
    L19:
        this.bgImgDrawStyleStarlingKey = r104;
        goto L21
    L15:
        this.aiGenBgImg = r103;
        goto L17
    L11:
        this.bgImgPromptEn = r102;
        goto L13
    L7:
        this.bgImgPrompt = r101;
        goto L9
    }

    public /* synthetic */ BgImageInfo(String r110, String r111, Boolean r112, List r113, Boolean r114, String r115, String r116, String r210, String r211, Integer r212, String r213, int r214, DefaultConstructorMarker r215) {
        String r100 = null;
        if ((r214 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r214 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r214 & 4) == 0) goto L13;
        Boolean r103 = null;
    L15:
        if ((r214 & 8) == 0) goto L17;
        List r104 = null;
    L19:
        if ((r214 & 16) == 0) goto L21;
        Boolean r105 = null;
    L23:
        if ((r214 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r214 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r214 & 128) == 0) goto L33;
        String r108 = null;
    L35:
        if ((r214 & 256) == 0) goto L37;
        String r117 = null;
    L39:
        if ((r214 & 512) == 0) goto L41;
        Integer r118 = null;
    L43:
        if ((r214 & 1024) != 0) goto L46;
        r100 = r213;
    L46:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r117, r118, r100);
        return;
    L41:
        r118 = r212;
        goto L43
    L37:
        r117 = r211;
        goto L39
    L33:
        r108 = r210;
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
