package com.larus.im.internal.jni.bean;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import de9.d9;
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
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 '2\u00060\u0001j\u0002`\u0002:\u0002&'B5\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nBC\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\t\u0010\u000fJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\u0017\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\bHÆ\u0003J7\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\fHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0004HÖ\u0001J%\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0001¢\u0006\u0002\b%R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0012\u0010\u0011R$\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0013\u0010\u0011¨\u0006("}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniMessageRenderCompleteRequest;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "renderToken", "", "renderCompleteTimestamp", "", PromotionProductPrivilegesStruct.TAGS, "", "<init>", "(Ljava/lang/String;JLjava/util/Map;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;JLjava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getRenderToken$annotations", "()V", "getRenderCompleteTimestamp$annotations", "getTags$annotations", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_release", "$serializer", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OmniMessageRenderCompleteRequest implements java.io.Serializable {
    private static final Lazy<d<Object>>[] $childSerializers = null;
    public static final Companion Companion = null;
    public final long renderCompleteTimestamp;
    public final String renderToken;
    public final Map<String, String> tags;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniMessageRenderCompleteRequest$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OmniMessageRenderCompleteRequest;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OmniMessageRenderCompleteRequest> serializer() {
            return OmniMessageRenderCompleteRequest$$serializer.INSTANCE;
        }
    }

    public OmniMessageRenderCompleteRequest() {
        this(null, 0, null, 7, null);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_() {
        v2 r100 = v2.f520790a;
        return new a1(r100, r100);
    }

    public static /* synthetic */ d a() {
        return _childSerializers$_anonymous_();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OmniMessageRenderCompleteRequest copy$default(OmniMessageRenderCompleteRequest r100, String r101, long r102, Map r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.renderToken;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.renderCompleteTimestamp;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.tags;
    L12:
        return r100.copy(r101, r102, r103);
    }

    @SerialName("render_complete_timestamp")
    public static /* synthetic */ void getRenderCompleteTimestamp$annotations() {
    }

    @SerialName("render_token")
    public static /* synthetic */ void getRenderToken$annotations() {
    }

    @SerialName(PromotionProductPrivilegesStruct.TAGS)
    public static /* synthetic */ void getTags$annotations() {
    }

    public final String component1() {
        return this.renderToken;
    }

    public final long component2() {
        return this.renderCompleteTimestamp;
    }

    public final Map<String, String> component3() {
        return this.tags;
    }

    public final OmniMessageRenderCompleteRequest copy(String r100, long r101, Map<String, String> r102) {
        return new OmniMessageRenderCompleteRequest(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OmniMessageRenderCompleteRequest) == true) goto L8;
        return false;
    L8:
        OmniMessageRenderCompleteRequest r101 = (OmniMessageRenderCompleteRequest) r100;
        if (Intrinsics.areEqual(this.renderToken, r101.renderToken) == true) goto L12;
        return false;
    L12:
        if (this.renderCompleteTimestamp == r101.renderCompleteTimestamp) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.tags, r101.tags) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r100 = this.renderToken;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        long r103 = this.renderCompleteTimestamp;
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        Map<String, String> r105 = this.tags;
        if (r105 == null) goto L11;
        r101 = r105.hashCode();
    L11:
        return r104 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "OmniMessageRenderCompleteRequest(renderToken=" + this.renderToken + ", renderCompleteTimestamp=" + this.renderCompleteTimestamp + ", tags=" + this.tags + ')';
    }

    static {
        Companion = new Companion(null);
        $childSerializers = new Lazy[]{null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new d9())};
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    public OmniMessageRenderCompleteRequest(String r100, long r101, Map<String, String> r102) {
        this.renderToken = r100;
        this.renderCompleteTimestamp = r101;
        this.tags = r102;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_release(OmniMessageRenderCompleteRequest r100, muc.d r101, f r110) {
        Lazy<d<Object>>[] r102 = $childSerializers;
        boolean r103 = false;
        if (r101.shouldEncodeElementDefault(r110, 0) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeNullableSerializableElement(r110, 0, v2.f520790a, r100.renderToken);
    L12:
        if (r101.shouldEncodeElementDefault(r110, 1) == false) goto L15;
    L13:
        boolean r105 = true;
    L18:
        if (r105 == false) goto L21;
        r101.encodeLongElement(r110, 1, r100.renderCompleteTimestamp);
    L21:
        if (r101.shouldEncodeElementDefault(r110, 2) == false) goto L24;
    L22:
        r103 = true;
    L26:
        if (r103 == false) goto L29;
        r101.encodeNullableSerializableElement(r110, 2, r102[2].getValue(), r100.tags);
        return;
    L29:
        return;
    L24:
        if (r100.tags == null) goto L26;
    L15:
        if (r100.renderCompleteTimestamp != 0) goto L13;
        r105 = false;
        goto L18
    L6:
        if (r100.renderToken != null) goto L4;
        r104 = false;
        goto L9
    }

    public /* synthetic */ OmniMessageRenderCompleteRequest(int r100, String r101, long r102, Map r103, q2 r104) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, OmniMessageRenderCompleteRequest$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.renderToken = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.renderCompleteTimestamp = 0;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.tags = null;
        return;
    L15:
        this.tags = r103;
        return;
    L11:
        this.renderCompleteTimestamp = r102;
        goto L13
    L7:
        this.renderToken = r101;
        goto L9
    }

    public /* synthetic */ OmniMessageRenderCompleteRequest(String r100, long r101, Map r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
