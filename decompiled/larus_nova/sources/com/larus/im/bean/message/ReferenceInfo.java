package com.larus.im.bean.message;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.JsonAdapter;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
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
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 @2\u00060\u0001j\u0002`\u0002:\u0002?@B}\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000b\u0012\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u000e\u0010\u000fBa\b\u0010\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u000e\u0010\u0013J\u0010\u0010&\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010'J\u000b\u0010(\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010*\u001a\u00020\u0004HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0017\u0010,\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000bHÆ\u0003J\u0017\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000bHÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0084\u0001\u0010/\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000b2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u00100J\u0013\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u000104HÖ\u0003J\t\u00105\u001a\u00020\u0004HÖ\u0001J\t\u00106\u001a\u00020\u0006HÖ\u0001J%\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u00002\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=H\u0001¢\u0006\u0002\b>R\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u0012\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0017\u0010\u0015R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0018\u0010\u0015R\u0018\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0019\u0010\u0015R\u001a\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u001a\u0010\u0015R&\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u001b\u0010\u0015R2\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001c\u0010\u0015\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R&\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b!\u0010\u0015\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006A"}, d2 = {"Lcom/larus/im/bean/message/ReferenceInfo;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "contentType", "", "displayContent", "", "referencedMessageId", "searchIndex", "hint", "ext", "", "traceExtra", "replyId", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getContentType$annotations", "()V", "Ljava/lang/Integer;", "getDisplayContent$annotations", "getReferencedMessageId$annotations", "getSearchIndex$annotations", "getHint$annotations", "getExt$annotations", "getTraceExtra$annotations", "getTraceExtra", "()Ljava/util/Map;", "setTraceExtra", "(Ljava/util/Map;)V", "getReplyId$annotations", "getReplyId", "()Ljava/lang/String;", "setReplyId", "(Ljava/lang/String;)V", "component1", "()Ljava/lang/Integer;", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;)Lcom/larus/im/bean/message/ReferenceInfo;", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$imsdkkmp_api_release", "$serializer", "Companion", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class ReferenceInfo implements java.io.Serializable {
    private static final Lazy<d<Object>>[] $childSerializers = null;
    public static final b Companion = null;
    public final Integer contentType;
    public final String displayContent;

    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    public Map<String, String> ext;
    public String hint;
    public String referencedMessageId;
    private transient String replyId;
    public int searchIndex;
    private transient Map<String, String> traceExtra;

    /* JADX INFO: loaded from: classes4.dex */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<ReferenceInfo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f346698a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f346699b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f346699b;
        }

        static {
            a r100 = new a();
            f346698a = r100;
            g2 r101 = new g2("com.larus.im.bean.message.ReferenceInfo", r100, 6);
            r101.j("content_type", true);
            r101.j("display_content", true);
            r101.j("referenced_message_id", true);
            r101.j("search_index", true);
            r101.j("hint", true);
            r101.j("ext", true);
            f346699b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            Lazy[] r100 = ReferenceInfo.access$get$childSerializers$cp();
            w0 r101 = w0.f520792a;
            v2 r102 = v2.f520790a;
            return new d[]{kuc.a.d(r101), kuc.a.d(r102), kuc.a.d(r102), r101, kuc.a.d(r102), kuc.a.d((d) r100[5].getValue())};
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f346699b;
            muc.c r101 = r110.beginStructure(r100);
            Lazy[] r102 = ReferenceInfo.access$get$childSerializers$cp();
            int r103 = 2;
            if (r101.decodeSequentially() == false) goto L5;
            Integer r104 = (Integer) r101.decodeNullableSerializableElement(r100, 0, w0.f520792a, null);
            v2 r105 = v2.f520790a;
            String r106 = (String) r101.decodeNullableSerializableElement(r100, 1, r105, null);
            String r107 = (String) r101.decodeNullableSerializableElement(r100, 2, r105, null);
            int r108 = r101.decodeIntElement(r100, 3);
            String r109 = (String) r101.decodeNullableSerializableElement(r100, 4, r105, null);
            Map r111 = (Map) r101.decodeNullableSerializableElement(r100, 5, (juc.c) r102[5].getValue(), null);
            Integer r112 = r104;
            String r113 = r107;
            String r114 = r109;
            int r115 = r108;
            String r116 = r106;
            int r117 = 63;
        L21:
            r101.endStructure(r100);
            return new ReferenceInfo(r117, r112, r116, r113, r115, r114, r111, null);
        L5:
            Map r118 = null;
            r116 = null;
            Integer r119 = null;
            String r120 = null;
            String r121 = null;
            int r122 = 0;
            r117 = 0;
            boolean r123 = true;
        L6:
            if (r123 == false) goto L20;
            int r124 = r101.decodeElementIndex(r100);
            switch(r124) {
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
            throw new UnknownFieldException(r124);
        L19:
            r103 = 2;
            r123 = false;
            goto L6
        L11:
            r118 = (Map) r101.decodeNullableSerializableElement(r100, 5, (juc.c) r102[5].getValue(), r118);
            int r125 = r117 | 32;
        L16:
            r117 = r125;
        L18:
            r103 = 2;
            goto L6
        L12:
            r120 = (String) r101.decodeNullableSerializableElement(r100, 4, v2.f520790a, r120);
            r125 = r117 | 16;
            goto L16
        L13:
            r122 = r101.decodeIntElement(r100, 3);
            r125 = r117 | 8;
            goto L16
        L14:
            r121 = (String) r101.decodeNullableSerializableElement(r100, r103, v2.f520790a, r121);
            r125 = r117 | 4;
            goto L16
        L15:
            r116 = (String) r101.decodeNullableSerializableElement(r100, 1, v2.f520790a, r116);
            r125 = r117 | 2;
            goto L16
        L17:
            r117 = r117 | 1;
            r119 = (Integer) r101.decodeNullableSerializableElement(r100, 0, w0.f520792a, r119);
            goto L18
        L20:
            r111 = r118;
            r112 = r119;
            r113 = r121;
            r114 = r120;
            r115 = r122;
            goto L21
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            ReferenceInfo r102 = (ReferenceInfo) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f346699b;
            muc.d r104 = r100.beginStructure(r103);
            ReferenceInfo.write$Self$imsdkkmp_api_release(r102, r104, r103);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<ReferenceInfo> serializer() {
            return a.f346698a;
        }
    }

    public ReferenceInfo() {
        this(null, null, null, 0, null, null, null, null, 255, null);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_() {
        v2 r100 = v2.f520790a;
        return new a1(r100, r100);
    }

    public static /* synthetic */ d a() {
        return _childSerializers$_anonymous_();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ReferenceInfo copy$default(ReferenceInfo r100, Integer r110, String r111, String r112, int r113, String r114, Map r115, Map r116, String r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        Integer r101 = r100.contentType;
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r102 = r100.displayContent;
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r103 = r100.referencedMessageId;
    L15:
        if ((r118 & 8) == 0) goto L17;
        int r104 = r100.searchIndex;
    L19:
        if ((r118 & 16) == 0) goto L21;
        String r105 = r100.hint;
    L23:
        if ((r118 & 32) == 0) goto L25;
        Map r106 = r100.ext;
    L27:
        if ((r118 & 64) == 0) goto L29;
        Map r107 = r100.traceExtra;
    L31:
        if ((r118 & 128) == 0) goto L33;
        String r108 = r100.replyId;
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

    @SerialName("content_type")
    public static /* synthetic */ void getContentType$annotations() {
    }

    @SerialName("display_content")
    public static /* synthetic */ void getDisplayContent$annotations() {
    }

    @SerialName("ext")
    public static /* synthetic */ void getExt$annotations() {
    }

    @SerialName("hint")
    public static /* synthetic */ void getHint$annotations() {
    }

    @SerialName("referenced_message_id")
    public static /* synthetic */ void getReferencedMessageId$annotations() {
    }

    @Transient
    public static /* synthetic */ void getReplyId$annotations() {
    }

    @SerialName("search_index")
    public static /* synthetic */ void getSearchIndex$annotations() {
    }

    @Transient
    public static /* synthetic */ void getTraceExtra$annotations() {
    }

    public final Integer component1() {
        return this.contentType;
    }

    public final String component2() {
        return this.displayContent;
    }

    public final String component3() {
        return this.referencedMessageId;
    }

    public final int component4() {
        return this.searchIndex;
    }

    public final String component5() {
        return this.hint;
    }

    public final Map<String, String> component6() {
        return this.ext;
    }

    public final Map<String, String> component7() {
        return this.traceExtra;
    }

    public final String component8() {
        return this.replyId;
    }

    public final ReferenceInfo copy(Integer r110, String r111, String r112, int r113, String r114, Map<String, String> r115, Map<String, String> r116, String r117) {
        return new ReferenceInfo(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ReferenceInfo) == true) goto L8;
        return false;
    L8:
        ReferenceInfo r101 = (ReferenceInfo) r100;
        if (Intrinsics.areEqual(this.contentType, r101.contentType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.displayContent, r101.displayContent) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.referencedMessageId, r101.referencedMessageId) == true) goto L18;
        return false;
    L18:
        if (this.searchIndex == r101.searchIndex) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.hint, r101.hint) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.ext, r101.ext) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.traceExtra, r101.traceExtra) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.replyId, r101.replyId) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.contentType;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.displayContent;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.referencedMessageId;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (((r106 + r108) * 31) + this.searchIndex) * 31;
        String r110 = this.hint;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Map<String, String> r113 = this.ext;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Map<String, String> r116 = this.traceExtra;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.replyId;
        if (r119 == null) goto L31;
        r101 = r119.hashCode();
    L31:
        return r118 + r101;
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
        return "ReferenceInfo(contentType=" + this.contentType + ", displayContent=" + this.displayContent + ", referencedMessageId=" + this.referencedMessageId + ", searchIndex=" + this.searchIndex + ", hint=" + this.hint + ", ext=" + this.ext + ", traceExtra=" + this.traceExtra + ", replyId=" + this.replyId + ')';
    }

    static {
        Companion = new b();
        $childSerializers = new Lazy[]{null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new yc9.w0())};
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    public final String getReplyId() {
        return this.replyId;
    }

    public final Map<String, String> getTraceExtra() {
        return this.traceExtra;
    }

    public final void setReplyId(String r100) {
        this.replyId = r100;
    }

    public final void setTraceExtra(Map<String, String> r100) {
        this.traceExtra = r100;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$imsdkkmp_api_release(ReferenceInfo r100, muc.d r101, f r102) {
        Lazy<d<Object>>[] r103 = $childSerializers;
        boolean r104 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r105 = true;
    L9:
        if (r105 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, w0.f520792a, r100.contentType);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r106 = true;
    L18:
        if (r106 == false) goto L21;
        r101.encodeNullableSerializableElement(r102, 1, v2.f520790a, r100.displayContent);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r107 = true;
    L27:
        if (r107 == false) goto L30;
        r101.encodeNullableSerializableElement(r102, 2, v2.f520790a, r100.referencedMessageId);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        boolean r108 = true;
    L36:
        if (r108 == false) goto L39;
        r101.encodeIntElement(r102, 3, r100.searchIndex);
    L39:
        if (r101.shouldEncodeElementDefault(r102, 4) == false) goto L42;
    L40:
        boolean r109 = true;
    L45:
        if (r109 == false) goto L48;
        r101.encodeNullableSerializableElement(r102, 4, v2.f520790a, r100.hint);
    L48:
        if (r101.shouldEncodeElementDefault(r102, 5) == false) goto L51;
    L49:
        r104 = true;
    L53:
        if (r104 == false) goto L56;
        r101.encodeNullableSerializableElement(r102, 5, r103[5].getValue(), r100.ext);
        return;
    L56:
        return;
    L51:
        if (r100.ext == null) goto L53;
    L42:
        if (r100.hint != null) goto L40;
        r109 = false;
        goto L45
    L33:
        if (r100.searchIndex != 0) goto L31;
        r108 = false;
        goto L36
    L24:
        if (r100.referencedMessageId != null) goto L22;
        r107 = false;
        goto L27
    L15:
        if (r100.displayContent != null) goto L13;
        r106 = false;
        goto L18
    L6:
        if (r100.contentType != null) goto L4;
        r105 = false;
        goto L9
    }

    public ReferenceInfo(int r100, Integer r101, String r102, String r103, int r104, String r105, Map r106, q2 r110) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f346699b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.contentType = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.displayContent = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.referencedMessageId = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.searchIndex = 0;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.hint = null;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.ext = null;
    L28:
        this.traceExtra = null;
        this.replyId = null;
        return;
    L27:
        this.ext = r106;
        goto L28
    L23:
        this.hint = r105;
        goto L25
    L19:
        this.searchIndex = r104;
        goto L21
    L15:
        this.referencedMessageId = r103;
        goto L17
    L11:
        this.displayContent = r102;
        goto L13
    L7:
        this.contentType = r101;
        goto L9
    }

    public ReferenceInfo(Integer r100, String r101, String r102, int r103, String r104, Map<String, String> r105, Map<String, String> r106, String r107) {
        this.contentType = r100;
        this.displayContent = r101;
        this.referencedMessageId = r102;
        this.searchIndex = r103;
        this.hint = r104;
        this.ext = r105;
        this.traceExtra = r106;
        this.replyId = r107;
    }

    public /* synthetic */ ReferenceInfo(Integer r110, String r111, String r112, int r113, String r114, Map r115, Map r116, String r117, int r118, DefaultConstructorMarker r119) {
        String r100 = null;
        if ((r118 & 1) == 0) goto L5;
        Integer r101 = null;
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r118 & 8) == 0) goto L17;
        int r104 = 0;
    L19:
        if ((r118 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r118 & 32) == 0) goto L25;
        Map r106 = null;
    L27:
        if ((r118 & 64) == 0) goto L29;
        Map r107 = null;
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
