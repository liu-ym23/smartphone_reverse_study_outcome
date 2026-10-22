package com.larus.im.internal.jni.bean;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.ss.texturerender.effect.ICEffect.ICEffectKeys;
import juc.d;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import luc.f;
import nuc.b2;
import nuc.q2;
import nuc.v2;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 .2\u00060\u0001j\u0002`\u0002:\u0002-.BM\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u000b\u0010\fBU\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u000b\u0010\u0010J\t\u0010\u0018\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0006HÆ\u0003JO\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\u0004HÖ\u0001J\t\u0010$\u001a\u00020\u0006HÖ\u0001J%\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0001¢\u0006\u0002\b,R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0013\u0010\u0012R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0014\u0010\u0012R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0015\u0010\u0012R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0016\u0010\u0012R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0017\u0010\u0012¨\u0006/"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniAgentTaskParam;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "runtimeType", "", "folderName", "", "deviceName", "workspace", "localDeviceId", "localAppId", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getRuntimeType$annotations", "()V", "getFolderName$annotations", "getDeviceName$annotations", "getWorkspace$annotations", "getLocalDeviceId$annotations", "getLocalAppId$annotations", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_release", "$serializer", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OmniAgentTaskParam implements java.io.Serializable {
    public static final Companion Companion = null;
    public final String deviceName;
    public final String folderName;
    public final String localAppId;
    public final String localDeviceId;
    public final int runtimeType;
    public final String workspace;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniAgentTaskParam$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OmniAgentTaskParam;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OmniAgentTaskParam> serializer() {
            return OmniAgentTaskParam$$serializer.INSTANCE;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OmniAgentTaskParam() {
        this(0, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ OmniAgentTaskParam copy$default(OmniAgentTaskParam r100, int r101, String r102, String r103, String r104, String r105, String r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.runtimeType;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.folderName;
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.deviceName;
    L11:
        String r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.workspace;
    L14:
        String r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.localDeviceId;
    L17:
        String r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.localAppId;
    L20:
        int r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    @SerialName(ICEffectKeys.KEY_IS_IC_EFFECT_DEVICE_NAME)
    public static /* synthetic */ void getDeviceName$annotations() {
    }

    @SerialName("folder_name")
    public static /* synthetic */ void getFolderName$annotations() {
    }

    @SerialName("local_app_id")
    public static /* synthetic */ void getLocalAppId$annotations() {
    }

    @SerialName("local_device_id")
    public static /* synthetic */ void getLocalDeviceId$annotations() {
    }

    @SerialName("runtime_type")
    public static /* synthetic */ void getRuntimeType$annotations() {
    }

    @SerialName("workspace")
    public static /* synthetic */ void getWorkspace$annotations() {
    }

    public final int component1() {
        return this.runtimeType;
    }

    public final String component2() {
        return this.folderName;
    }

    public final String component3() {
        return this.deviceName;
    }

    public final String component4() {
        return this.workspace;
    }

    public final String component5() {
        return this.localDeviceId;
    }

    public final String component6() {
        return this.localAppId;
    }

    public final OmniAgentTaskParam copy(int r100, String r110, String r111, String r112, String r113, String r114) {
        return new OmniAgentTaskParam(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OmniAgentTaskParam) == true) goto L8;
        return false;
    L8:
        OmniAgentTaskParam r101 = (OmniAgentTaskParam) r100;
        if (this.runtimeType == r101.runtimeType) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.folderName, r101.folderName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.deviceName, r101.deviceName) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.workspace, r101.workspace) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.localDeviceId, r101.localDeviceId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.localAppId, r101.localAppId) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r100 = this.runtimeType * 31;
        String r101 = this.folderName;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.deviceName;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.workspace;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.localDeviceId;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.localAppId;
        if (r114 == null) goto L23;
        r102 = r114.hashCode();
    L23:
        return r113 + r102;
    L17:
        r112 = r111.hashCode();
        goto L18
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
        return "OmniAgentTaskParam(runtimeType=" + this.runtimeType + ", folderName=" + this.folderName + ", deviceName=" + this.deviceName + ", workspace=" + this.workspace + ", localDeviceId=" + this.localDeviceId + ", localAppId=" + this.localAppId + ')';
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_release(OmniAgentTaskParam r100, muc.d r101, f r102) {
        boolean r103 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeIntElement(r102, 0, r100.runtimeType);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r105 = true;
    L18:
        if (r105 == false) goto L21;
        r101.encodeNullableSerializableElement(r102, 1, v2.f520790a, r100.folderName);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r106 = true;
    L27:
        if (r106 == false) goto L30;
        r101.encodeNullableSerializableElement(r102, 2, v2.f520790a, r100.deviceName);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        boolean r107 = true;
    L36:
        if (r107 == false) goto L39;
        r101.encodeNullableSerializableElement(r102, 3, v2.f520790a, r100.workspace);
    L39:
        if (r101.shouldEncodeElementDefault(r102, 4) == false) goto L42;
    L40:
        boolean r108 = true;
    L45:
        if (r108 == false) goto L48;
        r101.encodeNullableSerializableElement(r102, 4, v2.f520790a, r100.localDeviceId);
    L48:
        if (r101.shouldEncodeElementDefault(r102, 5) == false) goto L51;
    L49:
        r103 = true;
    L53:
        if (r103 == false) goto L56;
        r101.encodeNullableSerializableElement(r102, 5, v2.f520790a, r100.localAppId);
        return;
    L56:
        return;
    L51:
        if (r100.localAppId == null) goto L53;
    L42:
        if (r100.localDeviceId != null) goto L40;
        r108 = false;
        goto L45
    L33:
        if (r100.workspace != null) goto L31;
        r107 = false;
        goto L36
    L24:
        if (r100.deviceName != null) goto L22;
        r106 = false;
        goto L27
    L15:
        if (r100.folderName != null) goto L13;
        r105 = false;
        goto L18
    L6:
        if (r100.runtimeType != 0) goto L4;
        r104 = false;
        goto L9
    }

    public OmniAgentTaskParam(int r100, String r101, String r102, String r103, String r104, String r105) {
        this.runtimeType = r100;
        this.folderName = r101;
        this.deviceName = r102;
        this.workspace = r103;
        this.localDeviceId = r104;
        this.localAppId = r105;
    }

    public /* synthetic */ OmniAgentTaskParam(int r100, int r101, String r102, String r103, String r104, String r105, String r106, q2 r110) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, OmniAgentTaskParam$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.runtimeType = 0;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.folderName = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.deviceName = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.workspace = null;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.localDeviceId = null;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.localAppId = null;
        return;
    L27:
        this.localAppId = r106;
        return;
    L23:
        this.localDeviceId = r105;
        goto L25
    L19:
        this.workspace = r104;
        goto L21
    L15:
        this.deviceName = r103;
        goto L17
    L11:
        this.folderName = r102;
        goto L13
    L7:
        this.runtimeType = r101;
        goto L9
    }

    public /* synthetic */ OmniAgentTaskParam(int r100, String r101, String r102, String r103, String r104, String r110, int r111, DefaultConstructorMarker r112) {
        if ((r111 & 1) == 0) goto L5;
        r100 = 0;
    L5:
        String r105 = null;
        if ((r111 & 2) == 0) goto L8;
        String r113 = null;
    L10:
        if ((r111 & 4) == 0) goto L12;
        String r106 = null;
    L14:
        if ((r111 & 8) == 0) goto L16;
        String r107 = null;
    L18:
        if ((r111 & 16) == 0) goto L20;
        String r108 = null;
    L22:
        if ((r111 & 32) != 0) goto L25;
        r105 = r110;
    L25:
        this(r100, r113, r106, r107, r108, r105);
        return;
    L20:
        r108 = r104;
        goto L22
    L16:
        r107 = r103;
        goto L18
    L12:
        r106 = r102;
        goto L14
    L8:
        r113 = r101;
        goto L10
    }
}
