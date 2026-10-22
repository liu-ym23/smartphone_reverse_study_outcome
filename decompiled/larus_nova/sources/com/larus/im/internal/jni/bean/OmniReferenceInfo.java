package com.larus.im.internal.jni.bean;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import de9.fa;
import de9.ga;
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
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 -2\u00060\u0001j\u0002`\u0002:\u0002,-BM\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fBY\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u000b\u0010\u0011J\t\u0010\u0018\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0017\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\nHÆ\u0003JO\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u000eHÖ\u0001J\t\u0010#\u001a\u00020\u0006HÖ\u0001J%\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0001¢\u0006\u0002\b+R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0014\u0010\u0013R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0015\u0010\u0013R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0016\u0010\u0013R$\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0017\u0010\u0013¨\u0006."}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniReferenceInfo;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "contentType", "Lcom/larus/im/internal/jni/bean/OmniMessageContentType;", "referencedMessageId", "", "displayContent", "hint", "ext", "", "<init>", "(Lcom/larus/im/internal/jni/bean/OmniMessageContentType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/larus/im/internal/jni/bean/OmniMessageContentType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getContentType$annotations", "()V", "getReferencedMessageId$annotations", "getDisplayContent$annotations", "getHint$annotations", "getExt$annotations", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_release", "$serializer", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OmniReferenceInfo implements java.io.Serializable {
    private static final Lazy<d<Object>>[] $childSerializers = null;
    public static final Companion Companion = null;
    public final OmniMessageContentType contentType;
    public final String displayContent;
    public final Map<String, String> ext;
    public final String hint;
    public final String referencedMessageId;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniReferenceInfo$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OmniReferenceInfo;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OmniReferenceInfo> serializer() {
            return OmniReferenceInfo$$serializer.INSTANCE;
        }
    }

    public OmniReferenceInfo() {
        this(null, null, null, null, null, 31, null);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_() {
        return OmniMessageContentType.Companion.serializer();
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_$0() {
        v2 r100 = v2.f520790a;
        return new a1(r100, r100);
    }

    public static /* synthetic */ d a() {
        return _childSerializers$_anonymous_();
    }

    public static /* synthetic */ d b() {
        return _childSerializers$_anonymous_$0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OmniReferenceInfo copy$default(OmniReferenceInfo r100, OmniMessageContentType r101, String r102, String r103, String r104, Map r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.contentType;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.referencedMessageId;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.displayContent;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.hint;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.ext;
    L17:
        OmniMessageContentType r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
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

    public final OmniMessageContentType component1() {
        return this.contentType;
    }

    public final String component2() {
        return this.referencedMessageId;
    }

    public final String component3() {
        return this.displayContent;
    }

    public final String component4() {
        return this.hint;
    }

    public final Map<String, String> component5() {
        return this.ext;
    }

    public final OmniReferenceInfo copy(OmniMessageContentType r100, String r101, String r110, String r111, Map<String, String> r112) {
        Intrinsics.checkNotNullParameter(r100, "contentType");
        return new OmniReferenceInfo(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OmniReferenceInfo) == true) goto L8;
        return false;
    L8:
        OmniReferenceInfo r101 = (OmniReferenceInfo) r100;
        if (this.contentType == r101.contentType) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.referencedMessageId, r101.referencedMessageId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.displayContent, r101.displayContent) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.hint, r101.hint) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.ext, r101.ext) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r100 = this.contentType.hashCode() * 31;
        String r101 = this.referencedMessageId;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.displayContent;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.hint;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        Map<String, String> r111 = this.ext;
        if (r111 == null) goto L19;
        r102 = r111.hashCode();
    L19:
        return r110 + r102;
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "OmniReferenceInfo(contentType=" + this.contentType + ", referencedMessageId=" + this.referencedMessageId + ", displayContent=" + this.displayContent + ", hint=" + this.hint + ", ext=" + this.ext + ')';
    }

    static {
        Companion = new Companion(null);
        LazyThreadSafetyMode r100 = LazyThreadSafetyMode.PUBLICATION;
        $childSerializers = new Lazy[]{LazyKt.lazy(r100, new fa()), null, null, null, LazyKt.lazy(r100, new ga())};
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_release(OmniReferenceInfo r100, muc.d r101, f r102) {
        Lazy<d<Object>>[] r103 = $childSerializers;
        boolean r104 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r105 = true;
    L9:
        if (r105 == false) goto L12;
        r101.encodeSerializableElement(r102, 0, r103[0].getValue(), r100.contentType);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r106 = true;
    L18:
        if (r106 == false) goto L21;
        r101.encodeNullableSerializableElement(r102, 1, v2.f520790a, r100.referencedMessageId);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r107 = true;
    L27:
        if (r107 == false) goto L30;
        r101.encodeNullableSerializableElement(r102, 2, v2.f520790a, r100.displayContent);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        boolean r108 = true;
    L36:
        if (r108 == false) goto L39;
        r101.encodeNullableSerializableElement(r102, 3, v2.f520790a, r100.hint);
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
        if (r100.hint != null) goto L31;
        r108 = false;
        goto L36
    L24:
        if (r100.displayContent != null) goto L22;
        r107 = false;
        goto L27
    L15:
        if (r100.referencedMessageId != null) goto L13;
        r106 = false;
        goto L18
    L6:
        if (r100.contentType != OmniMessageContentType.UNSPECIFIED) goto L4;
        r105 = false;
        goto L9
    }

    public OmniReferenceInfo(OmniMessageContentType r100, String r101, String r102, String r103, Map<String, String> r104) {
        Intrinsics.checkNotNullParameter(r100, "contentType");
        this.contentType = r100;
        this.referencedMessageId = r101;
        this.displayContent = r102;
        this.hint = r103;
        this.ext = r104;
    }

    public /* synthetic */ OmniReferenceInfo(int r100, OmniMessageContentType r101, String r102, String r103, String r104, Map r105, q2 r106) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, OmniReferenceInfo$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        r101 = OmniMessageContentType.UNSPECIFIED;
    L7:
        this.contentType = r101;
        if ((r100 & 2) != 0) goto L10;
        this.referencedMessageId = null;
    L12:
        if ((r100 & 4) != 0) goto L14;
        this.displayContent = null;
    L16:
        if ((r100 & 8) != 0) goto L18;
        this.hint = null;
    L20:
        if ((r100 & 16) != 0) goto L22;
        this.ext = null;
        return;
    L22:
        this.ext = r105;
        return;
    L18:
        this.hint = r104;
        goto L20
    L14:
        this.displayContent = r103;
        goto L16
    L10:
        this.referencedMessageId = r102;
        goto L12
    }

    public /* synthetic */ OmniReferenceInfo(OmniMessageContentType r100, String r101, String r102, String r103, Map r104, int r105, DefaultConstructorMarker r110) {
        if ((r105 & 1) == 0) goto L5;
        r100 = OmniMessageContentType.UNSPECIFIED;
    L5:
        Map r106 = null;
        if ((r105 & 2) == 0) goto L8;
        String r111 = null;
    L10:
        if ((r105 & 4) == 0) goto L12;
        String r107 = null;
    L14:
        if ((r105 & 8) == 0) goto L16;
        String r108 = null;
    L18:
        if ((r105 & 16) != 0) goto L21;
        r106 = r104;
    L21:
        this(r100, r111, r107, r108, r106);
        return;
    L16:
        r108 = r103;
        goto L18
    L12:
        r107 = r102;
        goto L14
    L8:
        r111 = r101;
        goto L10
    }
}
