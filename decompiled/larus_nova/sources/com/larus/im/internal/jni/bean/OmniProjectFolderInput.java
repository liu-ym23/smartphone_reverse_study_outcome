package com.larus.im.internal.jni.bean;

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
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 +2\u00060\u0001j\u0002`\u0002:\u0002*+BC\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\t\u0010\nBM\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\t\u0010\u000fJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0004HÆ\u0003JE\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\fHÖ\u0001J\t\u0010!\u001a\u00020\u0004HÖ\u0001J%\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0001¢\u0006\u0002\b)R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0012\u0010\u0011R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0013\u0010\u0011R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0014\u0010\u0011R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0015\u0010\u0011¨\u0006,"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniProjectFolderInput;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "projectFolderId", "", "folderDeviceId", "folderDeviceName", "folderName", "workspace", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getProjectFolderId$annotations", "()V", "getFolderDeviceId$annotations", "getFolderDeviceName$annotations", "getFolderName$annotations", "getWorkspace$annotations", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_release", "$serializer", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OmniProjectFolderInput implements java.io.Serializable {
    public static final Companion Companion = null;
    public final String folderDeviceId;
    public final String folderDeviceName;
    public final String folderName;
    public final String projectFolderId;
    public final String workspace;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniProjectFolderInput$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OmniProjectFolderInput;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OmniProjectFolderInput> serializer() {
            return OmniProjectFolderInput$$serializer.INSTANCE;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OmniProjectFolderInput() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ OmniProjectFolderInput copy$default(OmniProjectFolderInput r100, String r101, String r102, String r103, String r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.projectFolderId;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.folderDeviceId;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.folderDeviceName;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.folderName;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.workspace;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
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

    @SerialName("workspace")
    public static /* synthetic */ void getWorkspace$annotations() {
    }

    public final String component1() {
        return this.projectFolderId;
    }

    public final String component2() {
        return this.folderDeviceId;
    }

    public final String component3() {
        return this.folderDeviceName;
    }

    public final String component4() {
        return this.folderName;
    }

    public final String component5() {
        return this.workspace;
    }

    public final OmniProjectFolderInput copy(String r100, String r101, String r110, String r111, String r112) {
        return new OmniProjectFolderInput(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OmniProjectFolderInput) == true) goto L8;
        return false;
    L8:
        OmniProjectFolderInput r101 = (OmniProjectFolderInput) r100;
        if (Intrinsics.areEqual(this.projectFolderId, r101.projectFolderId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.folderDeviceId, r101.folderDeviceId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.folderDeviceName, r101.folderDeviceName) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.folderName, r101.folderName) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.workspace, r101.workspace) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r100 = this.projectFolderId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.folderDeviceId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.folderDeviceName;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.folderName;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.workspace;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
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
        return "OmniProjectFolderInput(projectFolderId=" + this.projectFolderId + ", folderDeviceId=" + this.folderDeviceId + ", folderDeviceName=" + this.folderDeviceName + ", folderName=" + this.folderName + ", workspace=" + this.workspace + ')';
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_release(OmniProjectFolderInput r100, muc.d r101, f r102) {
        boolean r103 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, v2.f520790a, r100.projectFolderId);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r105 = true;
    L18:
        if (r105 == false) goto L21;
        r101.encodeNullableSerializableElement(r102, 1, v2.f520790a, r100.folderDeviceId);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r106 = true;
    L27:
        if (r106 == false) goto L30;
        r101.encodeNullableSerializableElement(r102, 2, v2.f520790a, r100.folderDeviceName);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        boolean r107 = true;
    L36:
        if (r107 == false) goto L39;
        r101.encodeNullableSerializableElement(r102, 3, v2.f520790a, r100.folderName);
    L39:
        if (r101.shouldEncodeElementDefault(r102, 4) == false) goto L42;
    L40:
        r103 = true;
    L44:
        if (r103 == false) goto L47;
        r101.encodeNullableSerializableElement(r102, 4, v2.f520790a, r100.workspace);
        return;
    L47:
        return;
    L42:
        if (r100.workspace == null) goto L44;
    L33:
        if (r100.folderName != null) goto L31;
        r107 = false;
        goto L36
    L24:
        if (r100.folderDeviceName != null) goto L22;
        r106 = false;
        goto L27
    L15:
        if (r100.folderDeviceId != null) goto L13;
        r105 = false;
        goto L18
    L6:
        if (r100.projectFolderId != null) goto L4;
        r104 = false;
        goto L9
    }

    public OmniProjectFolderInput(String r100, String r101, String r102, String r103, String r104) {
        this.projectFolderId = r100;
        this.folderDeviceId = r101;
        this.folderDeviceName = r102;
        this.folderName = r103;
        this.workspace = r104;
    }

    public /* synthetic */ OmniProjectFolderInput(int r100, String r101, String r102, String r103, String r104, String r105, q2 r106) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, OmniProjectFolderInput$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.projectFolderId = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.folderDeviceId = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.folderDeviceName = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.folderName = null;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.workspace = null;
        return;
    L23:
        this.workspace = r105;
        return;
    L19:
        this.folderName = r104;
        goto L21
    L15:
        this.folderDeviceName = r103;
        goto L17
    L11:
        this.folderDeviceId = r102;
        goto L13
    L7:
        this.projectFolderId = r101;
        goto L9
    }

    public /* synthetic */ OmniProjectFolderInput(String r100, String r101, String r102, String r103, String r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        String r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        String r105 = null;
    L11:
        if ((r110 & 4) == 0) goto L13;
        String r106 = null;
    L15:
        if ((r110 & 8) == 0) goto L17;
        String r107 = null;
    L19:
        if ((r110 & 16) == 0) goto L21;
        String r113 = null;
    L22:
        this(r112, r105, r106, r107, r113);
        return;
    L21:
        r113 = r104;
        goto L22
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
