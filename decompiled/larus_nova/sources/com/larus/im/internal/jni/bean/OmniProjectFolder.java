package com.larus.im.internal.jni.bean;

import com.byted.cast.common.auth.AuthConstants;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.hihonor.honorid.core.data.UserInfo;
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
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ;2\u00060\u0001j\u0002`\u0002:\u0002:;Bw\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011Bw\b\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\r\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0010\u0010\u0016J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010(\u001a\u00020\u000bHÆ\u0003J\t\u0010)\u001a\u00020\rHÆ\u0003J\t\u0010*\u001a\u00020\rHÆ\u0003J\t\u0010+\u001a\u00020\rHÆ\u0003Jy\u0010,\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\rHÆ\u0001J\u0013\u0010-\u001a\u00020\u000b2\b\u0010.\u001a\u0004\u0018\u00010/HÖ\u0003J\t\u00100\u001a\u00020\u0013HÖ\u0001J\t\u00101\u001a\u00020\u0004HÖ\u0001J%\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u00002\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u000208H\u0001¢\u0006\u0002\b9R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0019\u0010\u0018R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001a\u0010\u0018R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001b\u0010\u0018R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001c\u0010\u0018R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001d\u0010\u0018R\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001e\u0010\u0018R\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001f\u0010\u0018R\u0016\u0010\u000e\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b \u0010\u0018R\u0016\u0010\u000f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b!\u0010\u0018¨\u0006<"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniProjectFolder;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "projectFolderId", "", "projectId", "folderDeviceId", "folderDeviceName", "folderName", "workspace", "isPrimary", "", "version", "", "createTime", UserInfo.UPDATE_TIME, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZJJJ)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZJJJLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getProjectFolderId$annotations", "()V", "getProjectId$annotations", "getFolderDeviceId$annotations", "getFolderDeviceName$annotations", "getFolderName$annotations", "getWorkspace$annotations", "isPrimary$annotations", "getVersion$annotations", "getCreateTime$annotations", "getUpdateTime$annotations", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_release", "$serializer", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OmniProjectFolder implements java.io.Serializable {
    public static final Companion Companion = null;
    public final long createTime;
    public final String folderDeviceId;
    public final String folderDeviceName;
    public final String folderName;
    public final boolean isPrimary;
    public final String projectFolderId;
    public final String projectId;
    public final long updateTime;
    public final long version;
    public final String workspace;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniProjectFolder$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OmniProjectFolder;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OmniProjectFolder> serializer() {
            return OmniProjectFolder$$serializer.INSTANCE;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OmniProjectFolder() {
        this(null, null, null, null, null, null, false, 0, 0, 0, 1023, null);
    }

    public static /* synthetic */ OmniProjectFolder copy$default(OmniProjectFolder r110, String r111, String r112, String r113, String r114, String r210, String r211, boolean r212, long r213, long r214, long r215, int r216, Object r310) {
        if ((r216 & 1) == 0) goto L5;
        String r100 = r110.projectFolderId;
    L7:
        if ((r216 & 2) == 0) goto L9;
        String r101 = r110.projectId;
    L11:
        if ((r216 & 4) == 0) goto L13;
        String r102 = r110.folderDeviceId;
    L15:
        if ((r216 & 8) == 0) goto L17;
        String r103 = r110.folderDeviceName;
    L19:
        if ((r216 & 16) == 0) goto L21;
        String r104 = r110.folderName;
    L23:
        if ((r216 & 32) == 0) goto L25;
        String r105 = r110.workspace;
    L27:
        if ((r216 & 64) == 0) goto L29;
        boolean r106 = r110.isPrimary;
    L31:
        if ((r216 & 128) == 0) goto L33;
        long r107 = r110.version;
    L35:
        if ((r216 & 256) == 0) goto L37;
        long r115 = r110.createTime;
    L39:
        if ((r216 & 512) == 0) goto L41;
        long r116 = r110.updateTime;
    L43:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r115, r116);
    L41:
        r116 = r215;
        goto L43
    L37:
        r115 = r214;
        goto L39
    L33:
        r107 = r213;
        goto L35
    L29:
        r106 = r212;
        goto L31
    L25:
        r105 = r211;
        goto L27
    L21:
        r104 = r210;
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

    @SerialName("create_time")
    public static /* synthetic */ void getCreateTime$annotations() {
    }

    @SerialName("folder_device_id")
    public static /* synthetic */ void getFolderDeviceId$annotations() {
    }

    @SerialName("folder_device_name")
    public static /* synthetic */ void getFolderDeviceName$annotations() {
    }

    @SerialName("folder_name")
    public static /* synthetic */ void getFolderName$annotations() {
    }

    @SerialName("project_folder_id")
    public static /* synthetic */ void getProjectFolderId$annotations() {
    }

    @SerialName(AuthConstants.PARAM_KEY_LICENSE_PROJECT_ID)
    public static /* synthetic */ void getProjectId$annotations() {
    }

    @SerialName("update_time")
    public static /* synthetic */ void getUpdateTime$annotations() {
    }

    @SerialName("version")
    public static /* synthetic */ void getVersion$annotations() {
    }

    @SerialName("workspace")
    public static /* synthetic */ void getWorkspace$annotations() {
    }

    @SerialName("is_primary")
    public static /* synthetic */ void isPrimary$annotations() {
    }

    public final String component1() {
        return this.projectFolderId;
    }

    public final long component10() {
        return this.updateTime;
    }

    public final String component2() {
        return this.projectId;
    }

    public final String component3() {
        return this.folderDeviceId;
    }

    public final String component4() {
        return this.folderDeviceName;
    }

    public final String component5() {
        return this.folderName;
    }

    public final String component6() {
        return this.workspace;
    }

    public final boolean component7() {
        return this.isPrimary;
    }

    public final long component8() {
        return this.version;
    }

    public final long component9() {
        return this.createTime;
    }

    public final OmniProjectFolder copy(String r110, String r111, String r112, String r113, String r210, String r211, boolean r212, long r213, long r214, long r215) {
        return new OmniProjectFolder(r110, r111, r112, r113, r210, r211, r212, r213, r214, r215);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OmniProjectFolder) == true) goto L8;
        return false;
    L8:
        OmniProjectFolder r101 = (OmniProjectFolder) r100;
        if (Intrinsics.areEqual(this.projectFolderId, r101.projectFolderId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.projectId, r101.projectId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.folderDeviceId, r101.folderDeviceId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.folderDeviceName, r101.folderDeviceName) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.folderName, r101.folderName) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.workspace, r101.workspace) == true) goto L27;
        return false;
    L27:
        if (this.isPrimary == r101.isPrimary) goto L30;
        return false;
    L30:
        if (this.version == r101.version) goto L33;
        return false;
    L33:
        if (this.createTime == r101.createTime) goto L36;
        return false;
    L36:
        if (this.updateTime == r101.updateTime) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        String r100 = this.projectFolderId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.projectId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.folderDeviceId;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.folderDeviceName;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.folderName;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.workspace;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        int r117 = (r115 + r101) * 31;
        if (this.isPrimary == false) goto L29;
        int r118 = 1231;
    L30:
        int r119 = (r117 + r118) * 31;
        long r120 = this.version;
        int r121 = (r119 + ((int) (r120 ^ (r120 >>> 32)))) * 31;
        long r122 = this.createTime;
        int r123 = (r121 + ((int) (r122 ^ (r122 >>> 32)))) * 31;
        long r124 = this.updateTime;
        return r123 + ((int) (r124 ^ (r124 >>> 32)));
    L29:
        r118 = 1237;
        goto L30
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
        return "OmniProjectFolder(projectFolderId=" + this.projectFolderId + ", projectId=" + this.projectId + ", folderDeviceId=" + this.folderDeviceId + ", folderDeviceName=" + this.folderDeviceName + ", folderName=" + this.folderName + ", workspace=" + this.workspace + ", isPrimary=" + this.isPrimary + ", version=" + this.version + ", createTime=" + this.createTime + ", updateTime=" + this.updateTime + ')';
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_release(OmniProjectFolder r100, muc.d r101, f r110) {
        boolean r102 = false;
        if (r101.shouldEncodeElementDefault(r110, 0) == false) goto L6;
    L4:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L12;
        r101.encodeNullableSerializableElement(r110, 0, v2.f520790a, r100.projectFolderId);
    L12:
        if (r101.shouldEncodeElementDefault(r110, 1) == false) goto L15;
    L13:
        boolean r104 = true;
    L18:
        if (r104 == false) goto L21;
        r101.encodeNullableSerializableElement(r110, 1, v2.f520790a, r100.projectId);
    L21:
        if (r101.shouldEncodeElementDefault(r110, 2) == false) goto L24;
    L22:
        boolean r105 = true;
    L27:
        if (r105 == false) goto L30;
        r101.encodeNullableSerializableElement(r110, 2, v2.f520790a, r100.folderDeviceId);
    L30:
        if (r101.shouldEncodeElementDefault(r110, 3) == false) goto L33;
    L31:
        boolean r106 = true;
    L36:
        if (r106 == false) goto L39;
        r101.encodeNullableSerializableElement(r110, 3, v2.f520790a, r100.folderDeviceName);
    L39:
        if (r101.shouldEncodeElementDefault(r110, 4) == false) goto L42;
    L40:
        boolean r107 = true;
    L45:
        if (r107 == false) goto L48;
        r101.encodeNullableSerializableElement(r110, 4, v2.f520790a, r100.folderName);
    L48:
        if (r101.shouldEncodeElementDefault(r110, 5) == false) goto L51;
    L49:
        boolean r108 = true;
    L54:
        if (r108 == false) goto L57;
        r101.encodeNullableSerializableElement(r110, 5, v2.f520790a, r100.workspace);
    L57:
        if (r101.shouldEncodeElementDefault(r110, 6) == false) goto L60;
    L58:
        boolean r109 = true;
    L63:
        if (r109 == false) goto L66;
        r101.encodeBooleanElement(r110, 6, r100.isPrimary);
    L66:
        if (r101.shouldEncodeElementDefault(r110, 7) == false) goto L69;
    L67:
        boolean r111 = true;
    L72:
        if (r111 == false) goto L75;
        r101.encodeLongElement(r110, 7, r100.version);
    L75:
        if (r101.shouldEncodeElementDefault(r110, 8) == false) goto L78;
    L76:
        boolean r112 = true;
    L81:
        if (r112 == false) goto L84;
        r101.encodeLongElement(r110, 8, r100.createTime);
    L84:
        if (r101.shouldEncodeElementDefault(r110, 9) == false) goto L87;
    L85:
        r102 = true;
    L89:
        if (r102 == false) goto L92;
        r101.encodeLongElement(r110, 9, r100.updateTime);
        return;
    L92:
        return;
    L87:
        if (r100.updateTime == 0) goto L89;
    L78:
        if (r100.createTime != 0) goto L76;
        r112 = false;
        goto L81
    L69:
        if (r100.version != 0) goto L67;
        r111 = false;
        goto L72
    L60:
        if (r100.isPrimary == true) goto L58;
        r109 = false;
        goto L63
    L51:
        if (r100.workspace != null) goto L49;
        r108 = false;
        goto L54
    L42:
        if (r100.folderName != null) goto L40;
        r107 = false;
        goto L45
    L33:
        if (r100.folderDeviceName != null) goto L31;
        r106 = false;
        goto L36
    L24:
        if (r100.folderDeviceId != null) goto L22;
        r105 = false;
        goto L27
    L15:
        if (r100.projectId != null) goto L13;
        r104 = false;
        goto L18
    L6:
        if (r100.projectFolderId != null) goto L4;
        r103 = false;
        goto L9
    }

    public OmniProjectFolder(String r100, String r101, String r102, String r103, String r104, String r105, boolean r106, long r107, long r110, long r111) {
        this.projectFolderId = r100;
        this.projectId = r101;
        this.folderDeviceId = r102;
        this.folderDeviceName = r103;
        this.folderName = r104;
        this.workspace = r105;
        this.isPrimary = r106;
        this.version = r107;
        this.createTime = r110;
        this.updateTime = r111;
    }

    public /* synthetic */ OmniProjectFolder(int r100, String r101, String r110, String r111, String r112, String r113, String r114, boolean r115, long r116, long r117, long r210, q2 r211) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, OmniProjectFolder$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.projectFolderId = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.projectId = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.folderDeviceId = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.folderDeviceName = null;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.folderName = null;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.workspace = null;
    L29:
        if ((r100 & 64) != 0) goto L31;
        this.isPrimary = false;
    L33:
        if ((r100 & 128) != 0) goto L35;
        this.version = 0;
    L37:
        if ((r100 & 256) != 0) goto L39;
        this.createTime = 0;
    L41:
        if ((r100 & 512) != 0) goto L43;
        this.updateTime = 0;
        return;
    L43:
        this.updateTime = r210;
        return;
    L39:
        this.createTime = r117;
        goto L41
    L35:
        this.version = r116;
        goto L37
    L31:
        this.isPrimary = r115;
        goto L33
    L27:
        this.workspace = r114;
        goto L29
    L23:
        this.folderName = r113;
        goto L25
    L19:
        this.folderDeviceName = r112;
        goto L21
    L15:
        this.folderDeviceId = r111;
        goto L17
    L11:
        this.projectId = r110;
        goto L13
    L7:
        this.projectFolderId = r101;
        goto L9
    }

    public /* synthetic */ OmniProjectFolder(String r110, String r111, String r112, String r113, String r210, String r211, boolean r212, long r213, long r214, long r215, int r216, DefaultConstructorMarker r310) {
        String r100 = null;
        if ((r216 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r216 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r216 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r216 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r216 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r216 & 32) != 0) goto L27;
        r100 = r211;
    L27:
        if ((r216 & 64) == 0) goto L29;
        boolean r106 = false;
    L30:
        long r107 = 0;
        if ((r216 & 128) == 0) goto L33;
        long r114 = 0;
    L35:
        if ((r216 & 256) == 0) goto L37;
        long r115 = 0;
    L39:
        if ((r216 & 512) != 0) goto L42;
        r107 = r215;
    L42:
        this(r101, r102, r103, r104, r105, r100, r106, r114, r115, r107);
        return;
    L37:
        r115 = r214;
        goto L39
    L33:
        r114 = r213;
        goto L35
    L29:
        r106 = r212;
        goto L30
    L21:
        r105 = r210;
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
