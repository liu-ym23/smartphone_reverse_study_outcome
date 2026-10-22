package com.larus.im.internal.jni.bean;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import de9.a3;
import java.util.List;
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
import nuc.b2;
import nuc.f;
import nuc.q2;
import nuc.v2;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 )2\u00060\u0001j\u0002`\u0002:\u0002()B9\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fBE\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\n\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u000b\u0010\u0010J\t\u0010\u0016\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0011\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\nHÆ\u0003J;\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001f\u001a\u00020\bHÖ\u0001J%\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0001¢\u0006\u0002\b'R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0013\u0010\u0012R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0014\u0010\u0012R\u001e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0015\u0010\u0012¨\u0006*"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniAIJobRuntimeConfig;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "hasRuntimeType", "", "runtimeType", "", "deviceId", "", "projects", "", "<init>", "(ZILjava/lang/String;Ljava/util/List;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IZILjava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getHasRuntimeType$annotations", "()V", "getRuntimeType$annotations", "getDeviceId$annotations", "getProjects$annotations", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_release", "$serializer", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OmniAIJobRuntimeConfig implements java.io.Serializable {
    private static final Lazy<d<Object>>[] $childSerializers = null;
    public static final Companion Companion = null;
    public final String deviceId;
    public final boolean hasRuntimeType;
    public final List<String> projects;
    public final int runtimeType;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniAIJobRuntimeConfig$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OmniAIJobRuntimeConfig;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OmniAIJobRuntimeConfig> serializer() {
            return OmniAIJobRuntimeConfig$$serializer.INSTANCE;
        }
    }

    public OmniAIJobRuntimeConfig() {
        this(false, 0, null, null, 15, null);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_() {
        return new f(v2.f520790a);
    }

    public static /* synthetic */ d a() {
        return _childSerializers$_anonymous_();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OmniAIJobRuntimeConfig copy$default(OmniAIJobRuntimeConfig r100, boolean r101, int r102, String r103, List r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.hasRuntimeType;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.runtimeType;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.deviceId;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.projects;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    @SerialName("device_id")
    public static /* synthetic */ void getDeviceId$annotations() {
    }

    @SerialName("has_runtime_type")
    public static /* synthetic */ void getHasRuntimeType$annotations() {
    }

    @SerialName("projects")
    public static /* synthetic */ void getProjects$annotations() {
    }

    @SerialName("runtime_type")
    public static /* synthetic */ void getRuntimeType$annotations() {
    }

    public final boolean component1() {
        return this.hasRuntimeType;
    }

    public final int component2() {
        return this.runtimeType;
    }

    public final String component3() {
        return this.deviceId;
    }

    public final List<String> component4() {
        return this.projects;
    }

    public final OmniAIJobRuntimeConfig copy(boolean r100, int r101, String r102, List<String> r103) {
        return new OmniAIJobRuntimeConfig(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OmniAIJobRuntimeConfig) == true) goto L8;
        return false;
    L8:
        OmniAIJobRuntimeConfig r101 = (OmniAIJobRuntimeConfig) r100;
        if (this.hasRuntimeType == r101.hasRuntimeType) goto L12;
        return false;
    L12:
        if (this.runtimeType == r101.runtimeType) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.deviceId, r101.deviceId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.projects, r101.projects) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        if (this.hasRuntimeType == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = ((r100 * 31) + this.runtimeType) * 31;
        String r102 = this.deviceId;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r101 + r104) * 31;
        List<String> r106 = this.projects;
        if (r106 == null) goto L15;
        r103 = r106.hashCode();
    L15:
        return r105 + r103;
    L9:
        r104 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public String toString() {
        return "OmniAIJobRuntimeConfig(hasRuntimeType=" + this.hasRuntimeType + ", runtimeType=" + this.runtimeType + ", deviceId=" + this.deviceId + ", projects=" + this.projects + ')';
    }

    static {
        Companion = new Companion(null);
        $childSerializers = new Lazy[]{null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new a3())};
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_release(OmniAIJobRuntimeConfig r100, muc.d r101, luc.f r102) {
        Lazy<d<Object>>[] r103 = $childSerializers;
        boolean r104 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r105 = true;
    L9:
        if (r105 == false) goto L12;
        r101.encodeBooleanElement(r102, 0, r100.hasRuntimeType);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r106 = true;
    L18:
        if (r106 == false) goto L21;
        r101.encodeIntElement(r102, 1, r100.runtimeType);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r107 = true;
    L27:
        if (r107 == false) goto L30;
        r101.encodeNullableSerializableElement(r102, 2, v2.f520790a, r100.deviceId);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        r104 = true;
    L35:
        if (r104 == false) goto L38;
        r101.encodeNullableSerializableElement(r102, 3, r103[3].getValue(), r100.projects);
        return;
    L38:
        return;
    L33:
        if (r100.projects == null) goto L35;
    L24:
        if (r100.deviceId != null) goto L22;
        r107 = false;
        goto L27
    L15:
        if (r100.runtimeType != 0) goto L13;
        r106 = false;
        goto L18
    L6:
        if (r100.hasRuntimeType == true) goto L4;
        r105 = false;
        goto L9
    }

    public OmniAIJobRuntimeConfig(boolean r100, int r101, String r102, List<String> r103) {
        this.hasRuntimeType = r100;
        this.runtimeType = r101;
        this.deviceId = r102;
        this.projects = r103;
    }

    public /* synthetic */ OmniAIJobRuntimeConfig(int r100, boolean r101, int r102, String r103, List r104, q2 r105) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, OmniAIJobRuntimeConfig$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.hasRuntimeType = false;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.runtimeType = 0;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.deviceId = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.projects = null;
        return;
    L19:
        this.projects = r104;
        return;
    L15:
        this.deviceId = r103;
        goto L17
    L11:
        this.runtimeType = r102;
        goto L13
    L7:
        this.hasRuntimeType = r101;
        goto L9
    }

    public /* synthetic */ OmniAIJobRuntimeConfig(boolean r100, int r101, String r102, List r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
