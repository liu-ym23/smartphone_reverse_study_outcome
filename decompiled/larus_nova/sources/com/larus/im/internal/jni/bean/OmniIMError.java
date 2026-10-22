package com.larus.im.internal.jni.bean;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import de9.w7;
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

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 &2\u00060\u0001j\u0002`\u0002:\u0002%&B5\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nBC\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\t\u0010\u000eJ\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0017\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\bHÆ\u0003J7\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0004HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001J%\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0001¢\u0006\u0002\b$R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0011\u0010\u0010R$\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0012\u0010\u0010¨\u0006'"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniIMError;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "code", "", "tips", "", "ext", "", "<init>", "(ILjava/lang/String;Ljava/util/Map;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/lang/String;Ljava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCode$annotations", "()V", "getTips$annotations", "getExt$annotations", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_release", "$serializer", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OmniIMError implements java.io.Serializable {
    private static final Lazy<d<Object>>[] $childSerializers = null;
    public static final Companion Companion = null;
    public final int code;
    public final Map<String, String> ext;
    public final String tips;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniIMError$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OmniIMError;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OmniIMError> serializer() {
            return OmniIMError$$serializer.INSTANCE;
        }
    }

    public OmniIMError() {
        this(0, null, null, 7, null);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_() {
        v2 r100 = v2.f520790a;
        return new a1(r100, r100);
    }

    public static /* synthetic */ d a() {
        return _childSerializers$_anonymous_();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OmniIMError copy$default(OmniIMError r100, int r101, String r102, Map r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.code;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.tips;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.ext;
    L12:
        return r100.copy(r101, r102, r103);
    }

    @SerialName("code")
    public static /* synthetic */ void getCode$annotations() {
    }

    @SerialName("ext")
    public static /* synthetic */ void getExt$annotations() {
    }

    @SerialName("tips")
    public static /* synthetic */ void getTips$annotations() {
    }

    public final int component1() {
        return this.code;
    }

    public final String component2() {
        return this.tips;
    }

    public final Map<String, String> component3() {
        return this.ext;
    }

    public final OmniIMError copy(int r100, String r101, Map<String, String> r102) {
        return new OmniIMError(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OmniIMError) == true) goto L8;
        return false;
    L8:
        OmniIMError r101 = (OmniIMError) r100;
        if (this.code == r101.code) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.tips, r101.tips) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.ext, r101.ext) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = this.code * 31;
        String r101 = this.tips;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Map<String, String> r105 = this.ext;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "OmniIMError(code=" + this.code + ", tips=" + this.tips + ", ext=" + this.ext + ')';
    }

    static {
        Companion = new Companion(null);
        $childSerializers = new Lazy[]{null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new w7())};
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    public OmniIMError(int r100, String r101, Map<String, String> r102) {
        this.code = r100;
        this.tips = r101;
        this.ext = r102;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_release(OmniIMError r100, muc.d r101, f r102) {
        Lazy<d<Object>>[] r103 = $childSerializers;
        boolean r104 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r105 = true;
    L9:
        if (r105 == false) goto L12;
        r101.encodeIntElement(r102, 0, r100.code);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r106 = true;
    L18:
        if (r106 == false) goto L21;
        r101.encodeNullableSerializableElement(r102, 1, v2.f520790a, r100.tips);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        r104 = true;
    L26:
        if (r104 == false) goto L29;
        r101.encodeNullableSerializableElement(r102, 2, r103[2].getValue(), r100.ext);
        return;
    L29:
        return;
    L24:
        if (r100.ext == null) goto L26;
    L15:
        if (r100.tips != null) goto L13;
        r106 = false;
        goto L18
    L6:
        if (r100.code != 0) goto L4;
        r105 = false;
        goto L9
    }

    public /* synthetic */ OmniIMError(int r100, int r101, String r102, Map r103, q2 r104) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, OmniIMError$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.code = 0;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.tips = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.ext = null;
        return;
    L15:
        this.ext = r103;
        return;
    L11:
        this.tips = r102;
        goto L13
    L7:
        this.code = r101;
        goto L9
    }

    public /* synthetic */ OmniIMError(int r100, String r101, Map r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
