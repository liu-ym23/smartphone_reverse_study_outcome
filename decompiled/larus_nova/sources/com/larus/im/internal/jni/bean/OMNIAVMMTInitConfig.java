package com.larus.im.internal.jni.bean;

import com.bytedance.android.livesdk.schema.AudienceGamePromoteDetailActionHandler;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
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
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 .2\u00060\u0001j\u0002`\u0002:\u0002-.BM\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000b\u0010\fBU\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u000b\u0010\u0011J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u001c\u001a\u00020\bHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0004HÆ\u0003JO\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010 \u001a\u00020\b2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\u000eHÖ\u0001J\t\u0010$\u001a\u00020\u0004HÖ\u0001J%\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0001¢\u0006\u0002\b,R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0014\u0010\u0013R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0015\u0010\u0013R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0016\u0010\u0013R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0017\u0010\u0013R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0018\u0010\u0013¨\u0006/"}, d2 = {"Lcom/larus/im/internal/jni/bean/OMNIAVMMTInitConfig;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "mmtAppId", "", "bizId", "streamApp", "enableTestEnv", "", "ppeLane", "bmmtConfig", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getMmtAppId$annotations", "()V", "getBizId$annotations", "getStreamApp$annotations", "getEnableTestEnv$annotations", "getPpeLane$annotations", "getBmmtConfig$annotations", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_av_release", "$serializer", "Companion", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OMNIAVMMTInitConfig implements java.io.Serializable {
    public static final Companion Companion = null;
    public final String bizId;
    public final String bmmtConfig;
    public final boolean enableTestEnv;
    public final String mmtAppId;
    public final String ppeLane;
    public final String streamApp;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OMNIAVMMTInitConfig$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OMNIAVMMTInitConfig;", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OMNIAVMMTInitConfig> serializer() {
            return OMNIAVMMTInitConfig$$serializer.INSTANCE;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OMNIAVMMTInitConfig() {
        this(null, null, null, false, null, null, 63, null);
    }

    public static /* synthetic */ OMNIAVMMTInitConfig copy$default(OMNIAVMMTInitConfig r100, String r101, String r102, String r103, boolean r104, String r105, String r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.mmtAppId;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.bizId;
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.streamApp;
    L11:
        String r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.enableTestEnv;
    L14:
        boolean r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.ppeLane;
    L17:
        String r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.bmmtConfig;
    L20:
        String r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    @SerialName(AudienceGamePromoteDetailActionHandler.PARA_BIZ_ID)
    public static /* synthetic */ void getBizId$annotations() {
    }

    @SerialName("bmmt_config")
    public static /* synthetic */ void getBmmtConfig$annotations() {
    }

    @SerialName("enable_test_env")
    public static /* synthetic */ void getEnableTestEnv$annotations() {
    }

    @SerialName("mmt_app_id")
    public static /* synthetic */ void getMmtAppId$annotations() {
    }

    @SerialName("ppe_lane")
    public static /* synthetic */ void getPpeLane$annotations() {
    }

    @SerialName("stream_app")
    public static /* synthetic */ void getStreamApp$annotations() {
    }

    public final String component1() {
        return this.mmtAppId;
    }

    public final String component2() {
        return this.bizId;
    }

    public final String component3() {
        return this.streamApp;
    }

    public final boolean component4() {
        return this.enableTestEnv;
    }

    public final String component5() {
        return this.ppeLane;
    }

    public final String component6() {
        return this.bmmtConfig;
    }

    public final OMNIAVMMTInitConfig copy(String r100, String r110, String r111, boolean r112, String r113, String r114) {
        return new OMNIAVMMTInitConfig(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OMNIAVMMTInitConfig) == true) goto L8;
        return false;
    L8:
        OMNIAVMMTInitConfig r101 = (OMNIAVMMTInitConfig) r100;
        if (Intrinsics.areEqual(this.mmtAppId, r101.mmtAppId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.bizId, r101.bizId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.streamApp, r101.streamApp) == true) goto L18;
        return false;
    L18:
        if (this.enableTestEnv == r101.enableTestEnv) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.ppeLane, r101.ppeLane) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.bmmtConfig, r101.bmmtConfig) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        String r100 = this.mmtAppId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.bizId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.streamApp;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        if (this.enableTestEnv == false) goto L17;
        int r110 = 1231;
    L18:
        int r111 = (r109 + r110) * 31;
        String r112 = this.ppeLane;
        if (r112 != null) goto L21;
        int r113 = 0;
    L22:
        int r114 = (r111 + r113) * 31;
        String r115 = this.bmmtConfig;
        if (r115 == null) goto L27;
        r101 = r115.hashCode();
    L27:
        return r114 + r101;
    L21:
        r113 = r112.hashCode();
        goto L22
    L17:
        r110 = 1237;
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
        return "OMNIAVMMTInitConfig(mmtAppId=" + this.mmtAppId + ", bizId=" + this.bizId + ", streamApp=" + this.streamApp + ", enableTestEnv=" + this.enableTestEnv + ", ppeLane=" + this.ppeLane + ", bmmtConfig=" + this.bmmtConfig + ')';
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_av_release(OMNIAVMMTInitConfig r100, muc.d r101, f r102) {
        boolean r103 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, v2.f520790a, r100.mmtAppId);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r105 = true;
    L18:
        if (r105 == false) goto L21;
        r101.encodeNullableSerializableElement(r102, 1, v2.f520790a, r100.bizId);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r106 = true;
    L27:
        if (r106 == false) goto L30;
        r101.encodeNullableSerializableElement(r102, 2, v2.f520790a, r100.streamApp);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        boolean r107 = true;
    L36:
        if (r107 == false) goto L39;
        r101.encodeBooleanElement(r102, 3, r100.enableTestEnv);
    L39:
        if (r101.shouldEncodeElementDefault(r102, 4) == false) goto L42;
    L40:
        boolean r108 = true;
    L45:
        if (r108 == false) goto L48;
        r101.encodeNullableSerializableElement(r102, 4, v2.f520790a, r100.ppeLane);
    L48:
        if (r101.shouldEncodeElementDefault(r102, 5) == false) goto L51;
    L49:
        r103 = true;
    L53:
        if (r103 == false) goto L56;
        r101.encodeNullableSerializableElement(r102, 5, v2.f520790a, r100.bmmtConfig);
        return;
    L56:
        return;
    L51:
        if (r100.bmmtConfig == null) goto L53;
    L42:
        if (r100.ppeLane != null) goto L40;
        r108 = false;
        goto L45
    L33:
        if (r100.enableTestEnv == true) goto L31;
        r107 = false;
        goto L36
    L24:
        if (r100.streamApp != null) goto L22;
        r106 = false;
        goto L27
    L15:
        if (r100.bizId != null) goto L13;
        r105 = false;
        goto L18
    L6:
        if (r100.mmtAppId != null) goto L4;
        r104 = false;
        goto L9
    }

    public OMNIAVMMTInitConfig(String r100, String r101, String r102, boolean r103, String r104, String r105) {
        this.mmtAppId = r100;
        this.bizId = r101;
        this.streamApp = r102;
        this.enableTestEnv = r103;
        this.ppeLane = r104;
        this.bmmtConfig = r105;
    }

    public /* synthetic */ OMNIAVMMTInitConfig(int r100, String r101, String r102, String r103, boolean r104, String r105, String r106, q2 r110) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, OMNIAVMMTInitConfig$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.mmtAppId = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.bizId = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.streamApp = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.enableTestEnv = false;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.ppeLane = null;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.bmmtConfig = null;
        return;
    L27:
        this.bmmtConfig = r106;
        return;
    L23:
        this.ppeLane = r105;
        goto L25
    L19:
        this.enableTestEnv = r104;
        goto L21
    L15:
        this.streamApp = r103;
        goto L17
    L11:
        this.bizId = r102;
        goto L13
    L7:
        this.mmtAppId = r101;
        goto L9
    }

    public /* synthetic */ OMNIAVMMTInitConfig(String r100, String r101, String r102, boolean r103, String r110, String r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        String r114 = null;
    L7:
        if ((r112 & 2) == 0) goto L9;
        String r104 = null;
    L11:
        if ((r112 & 4) == 0) goto L13;
        String r105 = null;
    L15:
        if ((r112 & 8) == 0) goto L17;
        boolean r106 = false;
    L19:
        if ((r112 & 16) == 0) goto L21;
        String r107 = null;
    L23:
        if ((r112 & 32) == 0) goto L25;
        String r115 = null;
    L26:
        this(r114, r104, r105, r106, r107, r115);
        return;
    L25:
        r115 = r111;
        goto L26
    L21:
        r107 = r110;
        goto L23
    L17:
        r106 = r103;
        goto L19
    L13:
        r105 = r102;
        goto L15
    L9:
        r104 = r101;
        goto L11
    L5:
        r114 = r100;
        goto L7
    }
}
