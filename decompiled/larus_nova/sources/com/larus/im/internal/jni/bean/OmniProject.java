package com.larus.im.internal.jni.bean;

import com.byted.cast.common.auth.AuthConstants;
import com.bytedance.android.livesdk.schema.AudienceGamePromoteDetailActionHandler;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.hihonor.honorid.core.data.UserInfo;
import com.ss.texturerender.effect.ICEffect.ICEffectKeys;
import com.tencent.open.SocialConstants;
import de9.w9;
import de9.x9;
import de9.y9;
import java.util.List;
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
import nuc.a1;
import nuc.b2;
import nuc.f;
import nuc.q2;
import nuc.v2;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 Q2\u00060\u0001j\u0002`\u0002:\u0002PQBÍ\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0004\u0012\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u001b\u0010\u001cBÃ\u0001\b\u0010\u0012\u0006\u0010\u001d\u001a\u00020\f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0013\u001a\u00020\u0011\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004\u0012\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001a\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b\u001b\u0010 J\u000b\u00102\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u00105\u001a\u00020\bHÆ\u0003J\t\u00106\u001a\u00020\nHÆ\u0003J\t\u00107\u001a\u00020\fHÆ\u0003J\u0011\u00108\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eHÆ\u0003J\t\u00109\u001a\u00020\u0011HÆ\u0003J\t\u0010:\u001a\u00020\u0011HÆ\u0003J\t\u0010;\u001a\u00020\u0011HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0017\u0010A\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001aHÆ\u0003JÏ\u0001\u0010B\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00112\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00042\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001aHÆ\u0001J\u0013\u0010C\u001a\u00020\n2\b\u0010D\u001a\u0004\u0018\u00010EHÖ\u0003J\t\u0010F\u001a\u00020\fHÖ\u0001J\t\u0010G\u001a\u00020\u0004HÖ\u0001J%\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020\u00002\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020NH\u0001¢\u0006\u0002\bOR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b!\u0010\"R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b#\u0010\"R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b$\u0010\"R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b%\u0010\"R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b&\u0010\"R\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b'\u0010\"R\u001e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b(\u0010\"R\u0016\u0010\u0010\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b)\u0010\"R\u0016\u0010\u0012\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b*\u0010\"R\u0016\u0010\u0013\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b+\u0010\"R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b,\u0010\"R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b-\u0010\"R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b.\u0010\"R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b/\u0010\"R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b0\u0010\"R$\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b1\u0010\"¨\u0006R"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniProject;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "projectId", "", "name", SocialConstants.PARAM_APP_DESC, "status", "Lcom/larus/im/internal/jni/bean/OmniProjectStatus;", "isPinned", "", "displayOrder", "", "folders", "", "Lcom/larus/im/internal/jni/bean/OmniProjectFolder;", "createTime", "", UserInfo.UPDATE_TIME, "version", "creatorId", "tenantId", "bizId", "deviceId", "deviceName", "ext", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/internal/jni/bean/OmniProjectStatus;ZILjava/util/List;JJJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/internal/jni/bean/OmniProjectStatus;ZILjava/util/List;JJJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getProjectId$annotations", "()V", "getName$annotations", "getDesc$annotations", "getStatus$annotations", "isPinned$annotations", "getDisplayOrder$annotations", "getFolders$annotations", "getCreateTime$annotations", "getUpdateTime$annotations", "getVersion$annotations", "getCreatorId$annotations", "getTenantId$annotations", "getBizId$annotations", "getDeviceId$annotations", "getDeviceName$annotations", "getExt$annotations", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "copy", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_release", "$serializer", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OmniProject implements java.io.Serializable {
    private static final Lazy<d<Object>>[] $childSerializers = null;
    public static final Companion Companion = null;
    public final String bizId;
    public final long createTime;
    public final String creatorId;
    public final String desc;
    public final String deviceId;
    public final String deviceName;
    public final int displayOrder;
    public final Map<String, String> ext;
    public final List<OmniProjectFolder> folders;
    public final boolean isPinned;
    public final String name;
    public final String projectId;
    public final OmniProjectStatus status;
    public final String tenantId;
    public final long updateTime;
    public final long version;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniProject$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OmniProject;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OmniProject> serializer() {
            return OmniProject$$serializer.INSTANCE;
        }
    }

    public OmniProject() {
        this(null, null, null, null, false, 0, null, 0, 0, 0, null, null, null, null, null, null, 65535, null);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_() {
        return OmniProjectStatus.Companion.serializer();
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_$0() {
        return new f(OmniProjectFolder$$serializer.INSTANCE);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_$1() {
        v2 r100 = v2.f520790a;
        return new a1(r100, r100);
    }

    public static /* synthetic */ d a() {
        return _childSerializers$_anonymous_$0();
    }

    public static /* synthetic */ d b() {
        return _childSerializers$_anonymous_();
    }

    public static /* synthetic */ d c() {
        return _childSerializers$_anonymous_$1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OmniProject copy$default(OmniProject r110, String r111, String r112, String r210, OmniProjectStatus r211, boolean r212, int r213, List r214, long r215, long r216, long r217, String r310, String r311, String r312, String r313, String r314, Map r315, int r316, Object r317) {
        if ((r316 & 1) == 0) goto L5;
        String r100 = r110.projectId;
    L7:
        if ((r316 & 2) == 0) goto L9;
        String r101 = r110.name;
    L11:
        if ((r316 & 4) == 0) goto L13;
        String r102 = r110.desc;
    L15:
        if ((r316 & 8) == 0) goto L17;
        OmniProjectStatus r103 = r110.status;
    L19:
        if ((r316 & 16) == 0) goto L21;
        boolean r104 = r110.isPinned;
    L23:
        if ((r316 & 32) == 0) goto L25;
        int r105 = r110.displayOrder;
    L27:
        if ((r316 & 64) == 0) goto L29;
        List r106 = r110.folders;
    L31:
        if ((r316 & 128) == 0) goto L33;
        long r107 = r110.createTime;
    L35:
        if ((r316 & 256) == 0) goto L37;
        long r113 = r110.updateTime;
    L39:
        if ((r316 & 512) == 0) goto L41;
        long r114 = r110.version;
    L43:
        if ((r316 & 1024) == 0) goto L45;
        String r115 = r110.creatorId;
    L46:
        String r318 = r115;
        if ((r316 & 2048) == 0) goto L49;
        String r116 = r110.tenantId;
    L50:
        String r319 = r116;
        if ((r316 & 4096) == 0) goto L53;
        String r117 = r110.bizId;
    L54:
        String r320 = r117;
        if ((r316 & 8192) == 0) goto L57;
        String r118 = r110.deviceId;
    L58:
        String r321 = r118;
        if ((r316 & 16384) == 0) goto L61;
        String r119 = r110.deviceName;
    L63:
        if ((r316 & 32768) == 0) goto L65;
        Map r108 = r110.ext;
    L67:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r318, r319, r320, r321, r119, r108);
    L65:
        r108 = r315;
        goto L67
    L61:
        r119 = r314;
        goto L63
    L57:
        r118 = r313;
        goto L58
    L53:
        r117 = r312;
        goto L54
    L49:
        r116 = r311;
        goto L50
    L45:
        r115 = r310;
        goto L46
    L41:
        r114 = r217;
        goto L43
    L37:
        r113 = r216;
        goto L39
    L33:
        r107 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    @SerialName(AudienceGamePromoteDetailActionHandler.PARA_BIZ_ID)
    public static /* synthetic */ void getBizId$annotations() {
    }

    @SerialName("create_time")
    public static /* synthetic */ void getCreateTime$annotations() {
    }

    @SerialName("creator_id")
    public static /* synthetic */ void getCreatorId$annotations() {
    }

    @SerialName(SocialConstants.PARAM_APP_DESC)
    public static /* synthetic */ void getDesc$annotations() {
    }

    @SerialName("device_id")
    public static /* synthetic */ void getDeviceId$annotations() {
    }

    @SerialName(ICEffectKeys.KEY_IS_IC_EFFECT_DEVICE_NAME)
    public static /* synthetic */ void getDeviceName$annotations() {
    }

    @SerialName("display_order")
    public static /* synthetic */ void getDisplayOrder$annotations() {
    }

    @SerialName("ext")
    public static /* synthetic */ void getExt$annotations() {
    }

    @SerialName("folders")
    public static /* synthetic */ void getFolders$annotations() {
    }

    @SerialName("name")
    public static /* synthetic */ void getName$annotations() {
    }

    @SerialName(AuthConstants.PARAM_KEY_LICENSE_PROJECT_ID)
    public static /* synthetic */ void getProjectId$annotations() {
    }

    @SerialName("status")
    public static /* synthetic */ void getStatus$annotations() {
    }

    @SerialName("tenant_id")
    public static /* synthetic */ void getTenantId$annotations() {
    }

    @SerialName("update_time")
    public static /* synthetic */ void getUpdateTime$annotations() {
    }

    @SerialName("version")
    public static /* synthetic */ void getVersion$annotations() {
    }

    @SerialName("is_pinned")
    public static /* synthetic */ void isPinned$annotations() {
    }

    public final String component1() {
        return this.projectId;
    }

    public final long component10() {
        return this.version;
    }

    public final String component11() {
        return this.creatorId;
    }

    public final String component12() {
        return this.tenantId;
    }

    public final String component13() {
        return this.bizId;
    }

    public final String component14() {
        return this.deviceId;
    }

    public final String component15() {
        return this.deviceName;
    }

    public final Map<String, String> component16() {
        return this.ext;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.desc;
    }

    public final OmniProjectStatus component4() {
        return this.status;
    }

    public final boolean component5() {
        return this.isPinned;
    }

    public final int component6() {
        return this.displayOrder;
    }

    public final List<OmniProjectFolder> component7() {
        return this.folders;
    }

    public final long component8() {
        return this.createTime;
    }

    public final long component9() {
        return this.updateTime;
    }

    public final OmniProject copy(String r210, String r211, String r212, OmniProjectStatus r213, boolean r214, int r215, List<OmniProjectFolder> r216, long r217, long r310, long r311, String r312, String r313, String r314, String r315, String r316, Map<String, String> r410) {
        Intrinsics.checkNotNullParameter(r213, "status");
        return new OmniProject(r210, r211, r212, r213, r214, r215, r216, r217, r310, r311, r312, r313, r314, r315, r316, r410);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OmniProject) == true) goto L8;
        return false;
    L8:
        OmniProject r101 = (OmniProject) r100;
        if (Intrinsics.areEqual(this.projectId, r101.projectId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.desc, r101.desc) == true) goto L18;
        return false;
    L18:
        if (this.status == r101.status) goto L21;
        return false;
    L21:
        if (this.isPinned == r101.isPinned) goto L24;
        return false;
    L24:
        if (this.displayOrder == r101.displayOrder) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.folders, r101.folders) == true) goto L30;
        return false;
    L30:
        if (this.createTime == r101.createTime) goto L33;
        return false;
    L33:
        if (this.updateTime == r101.updateTime) goto L36;
        return false;
    L36:
        if (this.version == r101.version) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.creatorId, r101.creatorId) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.tenantId, r101.tenantId) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.bizId, r101.bizId) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.deviceId, r101.deviceId) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.deviceName, r101.deviceName) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.ext, r101.ext) == true) goto L56;
        return false;
    L56:
        return true;
    }

    public int hashCode() {
        String r100 = this.projectId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.name;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.desc;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (((r106 + r108) * 31) + this.status.hashCode()) * 31;
        if (this.isPinned == false) goto L17;
        int r110 = 1231;
    L18:
        int r111 = (((r109 + r110) * 31) + this.displayOrder) * 31;
        List<OmniProjectFolder> r112 = this.folders;
        if (r112 != null) goto L21;
        int r113 = 0;
    L22:
        int r114 = (r111 + r113) * 31;
        long r115 = this.createTime;
        int r116 = (r114 + ((int) (r115 ^ (r115 >>> 32)))) * 31;
        long r117 = this.updateTime;
        int r118 = (r116 + ((int) (r117 ^ (r117 >>> 32)))) * 31;
        long r119 = this.version;
        int r120 = (r118 + ((int) (r119 ^ (r119 >>> 32)))) * 31;
        String r121 = this.creatorId;
        if (r121 != null) goto L25;
        int r122 = 0;
    L26:
        int r123 = (r120 + r122) * 31;
        String r124 = this.tenantId;
        if (r124 != null) goto L29;
        int r125 = 0;
    L30:
        int r126 = (r123 + r125) * 31;
        String r127 = this.bizId;
        if (r127 != null) goto L33;
        int r128 = 0;
    L34:
        int r129 = (r126 + r128) * 31;
        String r130 = this.deviceId;
        if (r130 != null) goto L37;
        int r131 = 0;
    L38:
        int r132 = (r129 + r131) * 31;
        String r133 = this.deviceName;
        if (r133 != null) goto L41;
        int r134 = 0;
    L42:
        int r135 = (r132 + r134) * 31;
        Map<String, String> r136 = this.ext;
        if (r136 == null) goto L47;
        r101 = r136.hashCode();
    L47:
        return r135 + r101;
    L41:
        r134 = r133.hashCode();
        goto L42
    L37:
        r131 = r130.hashCode();
        goto L38
    L33:
        r128 = r127.hashCode();
        goto L34
    L29:
        r125 = r124.hashCode();
        goto L30
    L25:
        r122 = r121.hashCode();
        goto L26
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
        return "OmniProject(projectId=" + this.projectId + ", name=" + this.name + ", desc=" + this.desc + ", status=" + this.status + ", isPinned=" + this.isPinned + ", displayOrder=" + this.displayOrder + ", folders=" + this.folders + ", createTime=" + this.createTime + ", updateTime=" + this.updateTime + ", version=" + this.version + ", creatorId=" + this.creatorId + ", tenantId=" + this.tenantId + ", bizId=" + this.bizId + ", deviceId=" + this.deviceId + ", deviceName=" + this.deviceName + ", ext=" + this.ext + ')';
    }

    static {
        Companion = new Companion(null);
        LazyThreadSafetyMode r100 = LazyThreadSafetyMode.PUBLICATION;
        $childSerializers = new Lazy[]{null, null, null, LazyKt.lazy(r100, new w9()), null, null, LazyKt.lazy(r100, new x9()), null, null, null, null, null, null, null, null, LazyKt.lazy(r100, new y9())};
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_release(OmniProject r100, muc.d r110, luc.f r111) {
        Lazy<d<Object>>[] r101 = $childSerializers;
        boolean r102 = false;
        if (r110.shouldEncodeElementDefault(r111, 0) == false) goto L6;
    L4:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L12;
        r110.encodeNullableSerializableElement(r111, 0, v2.f520790a, r100.projectId);
    L12:
        if (r110.shouldEncodeElementDefault(r111, 1) == false) goto L15;
    L13:
        boolean r104 = true;
    L18:
        if (r104 == false) goto L21;
        r110.encodeNullableSerializableElement(r111, 1, v2.f520790a, r100.name);
    L21:
        if (r110.shouldEncodeElementDefault(r111, 2) == false) goto L24;
    L22:
        boolean r105 = true;
    L27:
        if (r105 == false) goto L30;
        r110.encodeNullableSerializableElement(r111, 2, v2.f520790a, r100.desc);
    L30:
        if (r110.shouldEncodeElementDefault(r111, 3) == false) goto L33;
    L31:
        boolean r106 = true;
    L36:
        if (r106 == false) goto L39;
        r110.encodeSerializableElement(r111, 3, r101[3].getValue(), r100.status);
    L39:
        if (r110.shouldEncodeElementDefault(r111, 4) == false) goto L42;
    L40:
        boolean r107 = true;
    L45:
        if (r107 == false) goto L48;
        r110.encodeBooleanElement(r111, 4, r100.isPinned);
    L48:
        if (r110.shouldEncodeElementDefault(r111, 5) == false) goto L51;
    L49:
        boolean r108 = true;
    L54:
        if (r108 == false) goto L57;
        r110.encodeIntElement(r111, 5, r100.displayOrder);
    L57:
        if (r110.shouldEncodeElementDefault(r111, 6) == false) goto L60;
    L58:
        boolean r109 = true;
    L63:
        if (r109 == false) goto L66;
        r110.encodeNullableSerializableElement(r111, 6, r101[6].getValue(), r100.folders);
    L66:
        if (r110.shouldEncodeElementDefault(r111, 7) == false) goto L69;
    L67:
        boolean r112 = true;
    L72:
        if (r112 == false) goto L75;
        r110.encodeLongElement(r111, 7, r100.createTime);
    L75:
        if (r110.shouldEncodeElementDefault(r111, 8) == false) goto L78;
    L76:
        boolean r113 = true;
    L81:
        if (r113 == false) goto L84;
        r110.encodeLongElement(r111, 8, r100.updateTime);
    L84:
        if (r110.shouldEncodeElementDefault(r111, 9) == false) goto L87;
    L85:
        boolean r114 = true;
    L90:
        if (r114 == false) goto L93;
        r110.encodeLongElement(r111, 9, r100.version);
    L93:
        if (r110.shouldEncodeElementDefault(r111, 10) == false) goto L96;
    L94:
        boolean r115 = true;
    L99:
        if (r115 == false) goto L102;
        r110.encodeNullableSerializableElement(r111, 10, v2.f520790a, r100.creatorId);
    L102:
        if (r110.shouldEncodeElementDefault(r111, 11) == false) goto L105;
    L103:
        boolean r116 = true;
    L108:
        if (r116 == false) goto L111;
        r110.encodeNullableSerializableElement(r111, 11, v2.f520790a, r100.tenantId);
    L111:
        if (r110.shouldEncodeElementDefault(r111, 12) == false) goto L114;
    L112:
        boolean r117 = true;
    L117:
        if (r117 == false) goto L120;
        r110.encodeNullableSerializableElement(r111, 12, v2.f520790a, r100.bizId);
    L120:
        if (r110.shouldEncodeElementDefault(r111, 13) == false) goto L123;
    L121:
        boolean r118 = true;
    L126:
        if (r118 == false) goto L129;
        r110.encodeNullableSerializableElement(r111, 13, v2.f520790a, r100.deviceId);
    L129:
        if (r110.shouldEncodeElementDefault(r111, 14) == false) goto L132;
    L130:
        boolean r119 = true;
    L135:
        if (r119 == false) goto L138;
        r110.encodeNullableSerializableElement(r111, 14, v2.f520790a, r100.deviceName);
    L138:
        if (r110.shouldEncodeElementDefault(r111, 15) == false) goto L141;
    L139:
        r102 = true;
    L143:
        if (r102 == false) goto L146;
        r110.encodeNullableSerializableElement(r111, 15, r101[15].getValue(), r100.ext);
        return;
    L146:
        return;
    L141:
        if (r100.ext == null) goto L143;
    L132:
        if (r100.deviceName != null) goto L130;
        r119 = false;
        goto L135
    L123:
        if (r100.deviceId != null) goto L121;
        r118 = false;
        goto L126
    L114:
        if (r100.bizId != null) goto L112;
        r117 = false;
        goto L117
    L105:
        if (r100.tenantId != null) goto L103;
        r116 = false;
        goto L108
    L96:
        if (r100.creatorId != null) goto L94;
        r115 = false;
        goto L99
    L87:
        if (r100.version != 0) goto L85;
        r114 = false;
        goto L90
    L78:
        if (r100.updateTime != 0) goto L76;
        r113 = false;
        goto L81
    L69:
        if (r100.createTime != 0) goto L67;
        r112 = false;
        goto L72
    L60:
        if (r100.folders != null) goto L58;
        r109 = false;
        goto L63
    L51:
        if (r100.displayOrder != 0) goto L49;
        r108 = false;
        goto L54
    L42:
        if (r100.isPinned == true) goto L40;
        r107 = false;
        goto L45
    L33:
        if (r100.status != OmniProjectStatus.OmniProjectStatus_UNKNOWN) goto L31;
        r106 = false;
        goto L36
    L24:
        if (r100.desc != null) goto L22;
        r105 = false;
        goto L27
    L15:
        if (r100.name != null) goto L13;
        r104 = false;
        goto L18
    L6:
        if (r100.projectId != null) goto L4;
        r103 = false;
        goto L9
    }

    public OmniProject(String r100, String r101, String r102, OmniProjectStatus r103, boolean r104, int r105, List<OmniProjectFolder> r110, long r111, long r112, long r113, String r114, String r115, String r116, String r210, String r211, Map<String, String> r212) {
        Intrinsics.checkNotNullParameter(r103, "status");
        this.projectId = r100;
        this.name = r101;
        this.desc = r102;
        this.status = r103;
        this.isPinned = r104;
        this.displayOrder = r105;
        this.folders = r110;
        this.createTime = r111;
        this.updateTime = r112;
        this.version = r113;
        this.creatorId = r114;
        this.tenantId = r115;
        this.bizId = r116;
        this.deviceId = r210;
        this.deviceName = r211;
        this.ext = r212;
    }

    public /* synthetic */ OmniProject(int r100, String r110, String r111, String r112, OmniProjectStatus r113, boolean r114, int r115, List r116, long r117, long r118, long r210, String r211, String r212, String r213, String r214, String r215, Map r216, q2 r217) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, OmniProject$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.projectId = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.name = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.desc = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        OmniProjectStatus r101 = OmniProjectStatus.OmniProjectStatus_UNKNOWN;
    L20:
        this.status = r101;
        if ((r100 & 16) != 0) goto L23;
        this.isPinned = false;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.displayOrder = 0;
    L29:
        if ((r100 & 64) != 0) goto L31;
        this.folders = null;
    L32:
        long r102 = 0;
        if ((r100 & 128) != 0) goto L35;
        this.createTime = 0;
    L37:
        if ((r100 & 256) != 0) goto L39;
        this.updateTime = 0;
    L41:
        if ((r100 & 512) == 0) goto L44;
        r102 = r210;
    L44:
        this.version = r102;
        if ((r100 & 1024) != 0) goto L47;
        this.creatorId = null;
    L49:
        if ((r100 & 2048) != 0) goto L51;
        this.tenantId = null;
    L53:
        if ((r100 & 4096) != 0) goto L55;
        this.bizId = null;
    L57:
        if ((r100 & 8192) != 0) goto L59;
        this.deviceId = null;
    L61:
        if ((r100 & 16384) != 0) goto L63;
        this.deviceName = null;
    L65:
        if ((r100 & 32768) != 0) goto L67;
        this.ext = null;
        return;
    L67:
        this.ext = r216;
        return;
    L63:
        this.deviceName = r215;
        goto L65
    L59:
        this.deviceId = r214;
        goto L61
    L55:
        this.bizId = r213;
        goto L57
    L51:
        this.tenantId = r212;
        goto L53
    L47:
        this.creatorId = r211;
        goto L49
    L39:
        this.updateTime = r118;
        goto L41
    L35:
        this.createTime = r117;
        goto L37
    L31:
        this.folders = r116;
        goto L32
    L27:
        this.displayOrder = r115;
        goto L29
    L23:
        this.isPinned = r114;
        goto L25
    L19:
        r101 = r113;
        goto L20
    L15:
        this.desc = r112;
        goto L17
    L11:
        this.name = r111;
        goto L13
    L7:
        this.projectId = r110;
        goto L9
    }

    public /* synthetic */ OmniProject(String r210, String r211, String r212, OmniProjectStatus r213, boolean r214, int r215, List r216, long r217, long r310, long r311, String r312, String r313, String r314, String r315, String r316, Map r317, int r410, DefaultConstructorMarker r411) {
        if ((r410 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r410 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r410 & 4) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r410 & 8) == 0) goto L17;
        OmniProjectStatus r103 = OmniProjectStatus.OmniProjectStatus_UNKNOWN;
    L18:
        int r104 = 0;
        if ((r410 & 16) == 0) goto L21;
        boolean r105 = false;
    L23:
        if ((r410 & 32) != 0) goto L27;
        r104 = r215;
    L27:
        if ((r410 & 64) == 0) goto L29;
        List r106 = null;
    L30:
        long r110 = 0;
        if ((r410 & 128) == 0) goto L33;
        long r111 = 0;
    L35:
        if ((r410 & 256) == 0) goto L37;
        long r112 = 0;
    L39:
        if ((r410 & 512) != 0) goto L43;
        r110 = r311;
    L43:
        if ((r410 & 1024) == 0) goto L45;
        String r107 = null;
    L47:
        if ((r410 & 2048) == 0) goto L49;
        String r108 = null;
    L50:
        String r113 = r108;
        if ((r410 & 4096) == 0) goto L53;
        String r109 = null;
    L54:
        String r114 = r109;
        if ((r410 & 8192) == 0) goto L57;
        String r115 = null;
    L58:
        String r116 = r115;
        if ((r410 & 16384) == 0) goto L61;
        String r117 = null;
    L63:
        if ((r410 & 32768) == 0) goto L65;
        Map r118 = null;
    L66:
        this(r100, r101, r102, r103, r105, r104, r106, r111, r112, r110, r107, r113, r114, r116, r117, r118);
        return;
    L65:
        r118 = r317;
        goto L66
    L61:
        r117 = r316;
        goto L63
    L57:
        r115 = r315;
        goto L58
    L53:
        r109 = r314;
        goto L54
    L49:
        r108 = r313;
        goto L50
    L45:
        r107 = r312;
        goto L47
    L37:
        r112 = r310;
        goto L39
    L33:
        r111 = r217;
        goto L35
    L29:
        r106 = r216;
        goto L30
    L21:
        r105 = r214;
        goto L23
    L17:
        r103 = r213;
        goto L18
    L13:
        r102 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }
}
