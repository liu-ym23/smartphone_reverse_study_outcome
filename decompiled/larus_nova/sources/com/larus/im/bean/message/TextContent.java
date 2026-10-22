package com.larus.im.bean.message;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.JsonAdapter;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import com.tencent.open.SocialConstants;
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
import kotlin.jvm.internal.Reflection;
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
import yc9.g1;
import yc9.h1;
import yc9.i1;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 K2\u00060\u0001j\u0002`\u0002:\u0002KLBs\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0012\u0010\u0013Bw\b\u0010\u0012\u0006\u0010\u0014\u001a\u00020\t\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0012\u0010\u0017J\u000b\u00103\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0011\u00104\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\u0010\u00105\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0011\u00106\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0011HÆ\u0003Jz\u0010;\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÆ\u0001¢\u0006\u0002\u0010<J\u0013\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010@HÖ\u0003J\t\u0010A\u001a\u00020\tHÖ\u0001J\t\u0010B\u001a\u00020\u0004HÖ\u0001J%\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020\u00002\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020IH\u0001¢\u0006\u0002\bJR\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0018\u0010\u0019R \u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u001a\u0010\u0019R(\u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010 \u0012\u0004\b\u001b\u0010\u0019\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR,\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b!\u0010\u0019\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R&\u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b&\u0010\u0019\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b+\u0010\u0019\u001a\u0004\b,\u0010-R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b.\u0010\u0019\u001a\u0004\b/\u0010-R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b0\u0010\u0019\u001a\u0004\b1\u00102¨\u0006M"}, d2 = {"Lcom/larus/im/bean/message/TextContent;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "text", "", "textTags", "", "Lcom/larus/im/bean/message/TextTagInfo;", "imCmd", "", "reference", "Lcom/larus/im/bean/message/Reference;", "multiReference", "Lcom/larus/im/bean/message/MultiReference;", "title", SocialConstants.PARAM_APP_DESC, "images", "Lkotlinx/serialization/json/JsonArray;", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/util/List;Lcom/larus/im/bean/message/MultiReference;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/json/JsonArray;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/util/List;Lcom/larus/im/bean/message/MultiReference;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/json/JsonArray;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getText$annotations", "()V", "getTextTags$annotations", "getImCmd$annotations", "getImCmd", "()Ljava/lang/Integer;", "setImCmd", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getReference$annotations", "getReference", "()Ljava/util/List;", "setReference", "(Ljava/util/List;)V", "getMultiReference$annotations", "getMultiReference", "()Lcom/larus/im/bean/message/MultiReference;", "setMultiReference", "(Lcom/larus/im/bean/message/MultiReference;)V", "getTitle$annotations", "getTitle", "()Ljava/lang/String;", "getDesc$annotations", "getDesc", "getImages$annotations", "getImages", "()Lkotlinx/serialization/json/JsonArray;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/util/List;Lcom/larus/im/bean/message/MultiReference;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/json/JsonArray;)Lcom/larus/im/bean/message/TextContent;", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$imsdkkmp_api_release", "Companion", "$serializer", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class TextContent implements java.io.Serializable {
    private static final Lazy<d<Object>>[] $childSerializers = null;
    public static final b Companion = null;
    private static final long serialVersionUID = 1;
    private final String desc;
    private Integer imCmd;
    private final ouc.b images;
    private MultiReference multiReference;

    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private List<Reference> reference;
    public String text;

    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    public List<TextTagInfo> textTags;
    private final String title;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<TextContent> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f346728a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f346729b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f346729b;
        }

        static {
            a r100 = new a();
            f346728a = r100;
            g2 r101 = new g2("com.larus.im.bean.message.TextContent", r100, 8);
            r101.j("text", true);
            r101.j("text_tags", true);
            r101.j("im_cmd", true);
            r101.j("search_references", true);
            r101.j("multi_reference", true);
            r101.j("title", true);
            r101.j("description", true);
            r101.j("images", true);
            f346729b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            Lazy[] r100 = TextContent.access$get$childSerializers$cp();
            v2 r101 = v2.f520790a;
            return new d[]{kuc.a.d(r101), kuc.a.d((d) r100[1].getValue()), kuc.a.d(w0.f520792a), kuc.a.d((d) r100[3].getValue()), kuc.a.d(MultiReference.a.f346686a), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d((d) r100[7].getValue())};
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r210) {
            Intrinsics.checkNotNullParameter(r210, "decoder");
            g2 r100 = f346729b;
            muc.c r101 = r210.beginStructure(r100);
            Lazy[] r102 = TextContent.access$get$childSerializers$cp();
            int r103 = 5;
            int r104 = 6;
            List r110 = null;
            if (r101.decodeSequentially() == false) goto L5;
            v2 r105 = v2.f520790a;
            String r106 = (String) r101.decodeNullableSerializableElement(r100, 0, r105, null);
            List r111 = (List) r101.decodeNullableSerializableElement(r100, 1, (juc.c) r102[1].getValue(), null);
            Integer r107 = (Integer) r101.decodeNullableSerializableElement(r100, 2, w0.f520792a, null);
            List r108 = (List) r101.decodeNullableSerializableElement(r100, 3, (juc.c) r102[3].getValue(), null);
            MultiReference r109 = (MultiReference) r101.decodeNullableSerializableElement(r100, 4, MultiReference.a.f346686a, null);
            String r112 = (String) r101.decodeNullableSerializableElement(r100, 5, r105, null);
            String r113 = (String) r101.decodeNullableSerializableElement(r100, 6, r105, null);
            int r114 = 255;
            ouc.b r115 = (ouc.b) r101.decodeNullableSerializableElement(r100, 7, (juc.c) r102[7].getValue(), null);
            String r116 = r113;
            String r117 = r112;
            MultiReference r118 = r109;
            List r119 = r111;
            List r120 = r108;
            Integer r121 = r107;
            String r122 = r106;
        L24:
            r101.endStructure(r100);
            return new TextContent(r114, r122, r119, r121, r120, r118, r117, r116, r115, null);
        L5:
            List r123 = null;
            ouc.b r124 = null;
            String r125 = null;
            MultiReference r126 = null;
            String r127 = null;
            String r128 = null;
            Integer r129 = null;
            int r130 = 0;
            boolean r131 = true;
        L6:
            if (r131 == false) goto L23;
            int r132 = r101.decodeElementIndex(r100);
            switch(r132) {
                case -1: goto L22;
                case 0: goto L20;
                case 1: goto L18;
                case 2: goto L16;
                case 3: goto L15;
                case 4: goto L14;
                case 5: goto L13;
                case 6: goto L12;
                case 7: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r132);
        L22:
            r103 = 5;
            r131 = false;
            goto L6
        L11:
            r124 = (ouc.b) r101.decodeNullableSerializableElement(r100, 7, (juc.c) r102[7].getValue(), r124);
            r130 = r130 | 128;
        L17:
            Integer r133 = r129;
        L21:
            r129 = r133;
            r103 = 5;
            r104 = 6;
            goto L6
        L12:
            r128 = (String) r101.decodeNullableSerializableElement(r100, r104, v2.f520790a, r128);
            r130 = r130 | 64;
            goto L17
        L13:
            r125 = (String) r101.decodeNullableSerializableElement(r100, r103, v2.f520790a, r125);
            r130 = r130 | 32;
            goto L17
        L14:
            r126 = (MultiReference) r101.decodeNullableSerializableElement(r100, 4, MultiReference.a.f346686a, r126);
            r130 = r130 | 16;
            goto L17
        L15:
            r123 = (List) r101.decodeNullableSerializableElement(r100, 3, (juc.c) r102[3].getValue(), r123);
            r130 = r130 | 8;
            goto L17
        L16:
            r129 = (Integer) r101.decodeNullableSerializableElement(r100, 2, w0.f520792a, r129);
            r130 = r130 | 4;
            goto L17
        L18:
            r133 = r129;
            r110 = (List) r101.decodeNullableSerializableElement(r100, 1, (juc.c) r102[1].getValue(), r110);
            r130 = r130 | 2;
            goto L21
        L20:
            r133 = r129;
            r130 = r130 | 1;
            r127 = (String) r101.decodeNullableSerializableElement(r100, 0, v2.f520790a, r127);
            goto L21
        L23:
            r114 = r130;
            r119 = r110;
            r118 = r126;
            r116 = r128;
            r117 = r125;
            r120 = r123;
            r122 = r127;
            r115 = r124;
            r121 = r129;
            goto L24
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            TextContent r102 = (TextContent) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f346729b;
            muc.d r104 = r100.beginStructure(r103);
            TextContent.write$Self$imsdkkmp_api_release(r102, r104, r103);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<TextContent> serializer() {
            return a.f346728a;
        }
    }

    public TextContent() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_() {
        return new nuc.f(TextTagInfo.a.f346730a);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_$0() {
        return new nuc.f(Reference.a.f346696a);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_$1() {
        return new juc.b(Reflection.getOrCreateKotlinClass(ouc.b.class), kuc.a.d(ouc.d.f526808a), new d[0]);
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
    public static /* synthetic */ TextContent copy$default(TextContent r100, String r110, List r111, Integer r112, List r113, MultiReference r114, String r115, String r116, ouc.b r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        String r101 = r100.text;
    L7:
        if ((r118 & 2) == 0) goto L9;
        List r102 = r100.textTags;
    L11:
        if ((r118 & 4) == 0) goto L13;
        Integer r103 = r100.imCmd;
    L15:
        if ((r118 & 8) == 0) goto L17;
        List r104 = r100.reference;
    L19:
        if ((r118 & 16) == 0) goto L21;
        MultiReference r105 = r100.multiReference;
    L23:
        if ((r118 & 32) == 0) goto L25;
        String r106 = r100.title;
    L27:
        if ((r118 & 64) == 0) goto L29;
        String r107 = r100.desc;
    L31:
        if ((r118 & 128) == 0) goto L33;
        ouc.b r108 = r100.images;
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

    @SerialName("description")
    public static /* synthetic */ void getDesc$annotations() {
    }

    @SerialName("im_cmd")
    public static /* synthetic */ void getImCmd$annotations() {
    }

    @SerialName("images")
    public static /* synthetic */ void getImages$annotations() {
    }

    @SerialName("multi_reference")
    public static /* synthetic */ void getMultiReference$annotations() {
    }

    @SerialName("search_references")
    public static /* synthetic */ void getReference$annotations() {
    }

    @SerialName("text")
    public static /* synthetic */ void getText$annotations() {
    }

    @SerialName("text_tags")
    public static /* synthetic */ void getTextTags$annotations() {
    }

    @SerialName("title")
    public static /* synthetic */ void getTitle$annotations() {
    }

    public final String component1() {
        return this.text;
    }

    public final List<TextTagInfo> component2() {
        return this.textTags;
    }

    public final Integer component3() {
        return this.imCmd;
    }

    public final List<Reference> component4() {
        return this.reference;
    }

    public final MultiReference component5() {
        return this.multiReference;
    }

    public final String component6() {
        return this.title;
    }

    public final String component7() {
        return this.desc;
    }

    public final ouc.b component8() {
        return this.images;
    }

    public final TextContent copy(String r110, List<TextTagInfo> r111, Integer r112, List<Reference> r113, MultiReference r114, String r115, String r116, ouc.b r117) {
        return new TextContent(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TextContent) == true) goto L8;
        return false;
    L8:
        TextContent r101 = (TextContent) r100;
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.textTags, r101.textTags) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.imCmd, r101.imCmd) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.reference, r101.reference) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.multiReference, r101.multiReference) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.desc, r101.desc) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.images, r101.images) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        String r100 = this.text;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<TextTagInfo> r104 = this.textTags;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.imCmd;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        List<Reference> r110 = this.reference;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        MultiReference r113 = this.multiReference;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.title;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.desc;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        ouc.b r122 = this.images;
        if (r122 == null) goto L35;
        r101 = r122.hashCode();
    L35:
        return r121 + r101;
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
        return "TextContent(text=" + this.text + ", textTags=" + this.textTags + ", imCmd=" + this.imCmd + ", reference=" + this.reference + ", multiReference=" + this.multiReference + ", title=" + this.title + ", desc=" + this.desc + ", images=" + this.images + ')';
    }

    static {
        Companion = new b();
        LazyThreadSafetyMode r100 = LazyThreadSafetyMode.PUBLICATION;
        $childSerializers = new Lazy[]{null, LazyKt.lazy(r100, new g1()), null, LazyKt.lazy(r100, new h1()), null, null, null, LazyKt.lazy(r100, new i1())};
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final Integer getImCmd() {
        return this.imCmd;
    }

    public final ouc.b getImages() {
        return this.images;
    }

    public final MultiReference getMultiReference() {
        return this.multiReference;
    }

    public final List<Reference> getReference() {
        return this.reference;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setImCmd(Integer r100) {
        this.imCmd = r100;
    }

    public final void setMultiReference(MultiReference r100) {
        this.multiReference = r100;
    }

    public final void setReference(List<Reference> r100) {
        this.reference = r100;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$imsdkkmp_api_release(TextContent r100, muc.d r101, f r102) {
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
        r101.encodeNullableSerializableElement(r102, 1, r103[1].getValue(), r100.textTags);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L23;
    L22:
        boolean r107 = true;
    L30:
        if (r107 == false) goto L33;
        r101.encodeNullableSerializableElement(r102, 2, w0.f520792a, r100.imCmd);
    L33:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L36;
    L34:
        boolean r108 = true;
    L39:
        if (r108 == false) goto L42;
        r101.encodeNullableSerializableElement(r102, 3, r103[3].getValue(), r100.reference);
    L42:
        if (r101.shouldEncodeElementDefault(r102, 4) == false) goto L45;
    L43:
        boolean r109 = true;
    L48:
        if (r109 == false) goto L51;
        r101.encodeNullableSerializableElement(r102, 4, MultiReference.a.f346686a, r100.multiReference);
    L51:
        if (r101.shouldEncodeElementDefault(r102, 5) == false) goto L54;
    L52:
        boolean r110 = true;
    L57:
        if (r110 == false) goto L60;
        r101.encodeNullableSerializableElement(r102, 5, v2.f520790a, r100.title);
    L60:
        if (r101.shouldEncodeElementDefault(r102, 6) == false) goto L63;
    L61:
        boolean r111 = true;
    L66:
        if (r111 == false) goto L69;
        r101.encodeNullableSerializableElement(r102, 6, v2.f520790a, r100.desc);
    L69:
        if (r101.shouldEncodeElementDefault(r102, 7) == false) goto L72;
    L70:
        r104 = true;
    L74:
        if (r104 == false) goto L77;
        r101.encodeNullableSerializableElement(r102, 7, r103[7].getValue(), r100.images);
        return;
    L77:
        return;
    L72:
        if (r100.images == null) goto L74;
    L63:
        if (r100.desc != null) goto L61;
        r111 = false;
        goto L66
    L54:
        if (r100.title != null) goto L52;
        r110 = false;
        goto L57
    L45:
        if (r100.multiReference != null) goto L43;
        r109 = false;
        goto L48
    L36:
        if (r100.reference != null) goto L34;
        r108 = false;
        goto L39
    L23:
        Integer r112 = r100.imCmd;
        if (r112 == null) goto L22;
        if (r112.intValue() != (-1)) goto L22;
        r107 = false;
        goto L30
    L15:
        if (r100.textTags != null) goto L13;
        r106 = false;
        goto L18
    L6:
        if (r100.text != null) goto L4;
        r105 = false;
        goto L9
    }

    public TextContent(String r100, List<TextTagInfo> r101, Integer r102, List<Reference> r103, MultiReference r104, String r105, String r106, ouc.b r107) {
        this.text = r100;
        this.textTags = r101;
        this.imCmd = r102;
        this.reference = r103;
        this.multiReference = r104;
        this.title = r105;
        this.desc = r106;
        this.images = r107;
    }

    public TextContent(int r100, String r101, List r102, Integer r103, List r104, MultiReference r105, String r106, String r107, ouc.b r110, q2 r111) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f346729b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.text = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.textTags = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.imCmd = -1;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.reference = null;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.multiReference = null;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.title = null;
    L29:
        if ((r100 & 64) != 0) goto L31;
        this.desc = null;
    L33:
        if ((r100 & 128) != 0) goto L35;
        this.images = null;
        return;
    L35:
        this.images = r110;
        return;
    L31:
        this.desc = r107;
        goto L33
    L27:
        this.title = r106;
        goto L29
    L23:
        this.multiReference = r105;
        goto L25
    L19:
        this.reference = r104;
        goto L21
    L15:
        this.imCmd = r103;
        goto L17
    L11:
        this.textTags = r102;
        goto L13
    L7:
        this.text = r101;
        goto L9
    }

    public /* synthetic */ TextContent(String r110, List r111, Integer r112, List r113, MultiReference r114, String r115, String r116, ouc.b r117, int r118, DefaultConstructorMarker r119) {
        ouc.b r100 = null;
        if ((r118 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r118 & 2) == 0) goto L9;
        List r102 = null;
    L11:
        if ((r118 & 4) == 0) goto L13;
        Integer r103 = -1;
    L15:
        if ((r118 & 8) == 0) goto L17;
        List r104 = null;
    L19:
        if ((r118 & 16) == 0) goto L21;
        MultiReference r105 = null;
    L23:
        if ((r118 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r118 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r118 & 128) != 0) goto L34;
        r100 = r117;
    L34:
        this(r101, r102, r103, r104, r105, r106, r107, r100);
        return;
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
