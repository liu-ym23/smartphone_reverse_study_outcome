package com.larus.bmhome.rc;

import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\t\n\u0002\b+\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B¿\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0018\b\u0002\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\u0018\b\u0002\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\n¢\u0006\u0004\b\u0013\u0010\u0014J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0019\u0010-\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\nHÆ\u0003J\u0010\u0010.\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010 J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0019\u00104\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\nHÆ\u0003JÆ\u0001\u00105\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0018\b\u0002\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\u0018\b\u0002\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u00106J\u0013\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010:\u001a\u00020\bHÖ\u0001J\t\u0010;\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR&\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0016R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0016R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0016R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0016R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0016R&\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001e¨\u0006<"}, d2 = {"Lcom/larus/bmhome/rc/ResourceFingerprintMeta;", "", "originHash", "", "transformPolicyId", "policyFamily", "policyDigest", "policySchemaVersion", "", "policyDefinition", "", "fileSize", "", DBDefinition.MIME_TYPE, "fileName", "dataType", "bizDomain", "uploadScene", "preCheckMeta", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/Map;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getOriginHash", "()Ljava/lang/String;", "getTransformPolicyId", "getPolicyFamily", "getPolicyDigest", "getPolicySchemaVersion", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPolicyDefinition", "()Ljava/util/Map;", "getFileSize", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getMimeType", "getFileName", "getDataType", "getBizDomain", "getUploadScene", "getPreCheckMeta", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/Map;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Lcom/larus/bmhome/rc/ResourceFingerprintMeta;", "equals", "", "other", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ResourceFingerprintMeta {

    @SerializedName("biz_domain")
    private final String bizDomain;

    @SerializedName("data_type")
    private final String dataType;

    @SerializedName("file_name")
    private final String fileName;

    @SerializedName("file_size")
    private final Long fileSize;

    @SerializedName("mime_type")
    private final String mimeType;

    @SerializedName("origin_hash")
    private final String originHash;

    @SerializedName("policy_definition")
    private final Map<String, String> policyDefinition;

    @SerializedName("policy_digest")
    private final String policyDigest;

    @SerializedName("policy_family")
    private final String policyFamily;

    @SerializedName("policy_schema_version")
    private final Integer policySchemaVersion;

    @SerializedName("pre_check_meta")
    private final Map<String, String> preCheckMeta;

    @SerializedName("transform_policy_id")
    private final String transformPolicyId;

    @SerializedName("upload_scene")
    private final String uploadScene;

    public ResourceFingerprintMeta() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, 8191, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ResourceFingerprintMeta copy$default(ResourceFingerprintMeta r110, String r111, String r112, String r113, String r114, Integer r115, Map r210, Long r211, String r212, String r213, String r214, String r215, String r216, Map r217, int r218, Object r219) {
        if ((r218 & 1) == 0) goto L5;
        String r100 = r110.originHash;
    L7:
        if ((r218 & 2) == 0) goto L9;
        String r101 = r110.transformPolicyId;
    L11:
        if ((r218 & 4) == 0) goto L13;
        String r102 = r110.policyFamily;
    L15:
        if ((r218 & 8) == 0) goto L17;
        String r103 = r110.policyDigest;
    L19:
        if ((r218 & 16) == 0) goto L21;
        Integer r104 = r110.policySchemaVersion;
    L23:
        if ((r218 & 32) == 0) goto L25;
        Map r105 = r110.policyDefinition;
    L27:
        if ((r218 & 64) == 0) goto L29;
        Long r106 = r110.fileSize;
    L31:
        if ((r218 & 128) == 0) goto L33;
        String r107 = r110.mimeType;
    L35:
        if ((r218 & 256) == 0) goto L37;
        String r116 = r110.fileName;
    L39:
        if ((r218 & 512) == 0) goto L41;
        String r117 = r110.dataType;
    L43:
        if ((r218 & 1024) == 0) goto L45;
        String r118 = r110.bizDomain;
    L47:
        if ((r218 & 2048) == 0) goto L49;
        String r119 = r110.uploadScene;
    L51:
        if ((r218 & 4096) == 0) goto L53;
        Map r108 = r110.preCheckMeta;
    L55:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r116, r117, r118, r119, r108);
    L53:
        r108 = r217;
        goto L55
    L49:
        r119 = r216;
        goto L51
    L45:
        r118 = r215;
        goto L47
    L41:
        r117 = r214;
        goto L43
    L37:
        r116 = r213;
        goto L39
    L33:
        r107 = r212;
        goto L35
    L29:
        r106 = r211;
        goto L31
    L25:
        r105 = r210;
        goto L27
    L21:
        r104 = r115;
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

    public final String component1() {
        return this.originHash;
    }

    public final String component10() {
        return this.dataType;
    }

    public final String component11() {
        return this.bizDomain;
    }

    public final String component12() {
        return this.uploadScene;
    }

    public final Map<String, String> component13() {
        return this.preCheckMeta;
    }

    public final String component2() {
        return this.transformPolicyId;
    }

    public final String component3() {
        return this.policyFamily;
    }

    public final String component4() {
        return this.policyDigest;
    }

    public final Integer component5() {
        return this.policySchemaVersion;
    }

    public final Map<String, String> component6() {
        return this.policyDefinition;
    }

    public final Long component7() {
        return this.fileSize;
    }

    public final String component8() {
        return this.mimeType;
    }

    public final String component9() {
        return this.fileName;
    }

    public final ResourceFingerprintMeta copy(String r110, String r111, String r112, String r113, Integer r210, Map<String, String> r211, Long r212, String r213, String r214, String r215, String r216, String r217, Map<String, String> r218) {
        return new ResourceFingerprintMeta(r110, r111, r112, r113, r210, r211, r212, r213, r214, r215, r216, r217, r218);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ResourceFingerprintMeta) == true) goto L8;
        return false;
    L8:
        ResourceFingerprintMeta r101 = (ResourceFingerprintMeta) r100;
        if (Intrinsics.areEqual(this.originHash, r101.originHash) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.transformPolicyId, r101.transformPolicyId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.policyFamily, r101.policyFamily) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.policyDigest, r101.policyDigest) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.policySchemaVersion, r101.policySchemaVersion) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.policyDefinition, r101.policyDefinition) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.fileSize, r101.fileSize) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.mimeType, r101.mimeType) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.fileName, r101.fileName) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.dataType, r101.dataType) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.bizDomain, r101.bizDomain) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.uploadScene, r101.uploadScene) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.preCheckMeta, r101.preCheckMeta) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public int hashCode() {
        String r100 = this.originHash;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.transformPolicyId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.policyFamily;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.policyDigest;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.policySchemaVersion;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Map<String, String> r116 = this.policyDefinition;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Long r119 = this.fileSize;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.mimeType;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.fileName;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.dataType;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.bizDomain;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.uploadScene;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        Map<String, String> r137 = this.preCheckMeta;
        if (r137 == null) goto L55;
        r101 = r137.hashCode();
    L55:
        return r136 + r101;
    L49:
        r135 = r134.hashCode();
        goto L50
    L45:
        r132 = r131.hashCode();
        goto L46
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
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
        return "ResourceFingerprintMeta(originHash=" + this.originHash + ", transformPolicyId=" + this.transformPolicyId + ", policyFamily=" + this.policyFamily + ", policyDigest=" + this.policyDigest + ", policySchemaVersion=" + this.policySchemaVersion + ", policyDefinition=" + this.policyDefinition + ", fileSize=" + this.fileSize + ", mimeType=" + this.mimeType + ", fileName=" + this.fileName + ", dataType=" + this.dataType + ", bizDomain=" + this.bizDomain + ", uploadScene=" + this.uploadScene + ", preCheckMeta=" + this.preCheckMeta + ')';
    }

    public final String getBizDomain() {
        return this.bizDomain;
    }

    public final String getDataType() {
        return this.dataType;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final Long getFileSize() {
        return this.fileSize;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    public final String getOriginHash() {
        return this.originHash;
    }

    public final Map<String, String> getPolicyDefinition() {
        return this.policyDefinition;
    }

    public final String getPolicyDigest() {
        return this.policyDigest;
    }

    public final String getPolicyFamily() {
        return this.policyFamily;
    }

    public final Integer getPolicySchemaVersion() {
        return this.policySchemaVersion;
    }

    public final Map<String, String> getPreCheckMeta() {
        return this.preCheckMeta;
    }

    public final String getTransformPolicyId() {
        return this.transformPolicyId;
    }

    public final String getUploadScene() {
        return this.uploadScene;
    }

    public ResourceFingerprintMeta(String r100, String r101, String r102, String r103, Integer r104, Map<String, String> r105, Long r106, String r107, String r108, String r110, String r111, String r112, Map<String, String> r113) {
        this.originHash = r100;
        this.transformPolicyId = r101;
        this.policyFamily = r102;
        this.policyDigest = r103;
        this.policySchemaVersion = r104;
        this.policyDefinition = r105;
        this.fileSize = r106;
        this.mimeType = r107;
        this.fileName = r108;
        this.dataType = r110;
        this.bizDomain = r111;
        this.uploadScene = r112;
        this.preCheckMeta = r113;
    }

    public /* synthetic */ ResourceFingerprintMeta(String r110, String r111, String r112, String r113, Integer r114, Map r210, Long r211, String r212, String r213, String r214, String r215, String r216, Map r217, int r218, DefaultConstructorMarker r219) {
        Map r100 = null;
        if ((r218 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r218 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r218 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r218 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r218 & 16) == 0) goto L21;
        Integer r105 = null;
    L23:
        if ((r218 & 32) == 0) goto L25;
        Map r106 = null;
    L27:
        if ((r218 & 64) == 0) goto L29;
        Long r107 = null;
    L31:
        if ((r218 & 128) == 0) goto L33;
        String r108 = null;
    L35:
        if ((r218 & 256) == 0) goto L37;
        String r115 = null;
    L39:
        if ((r218 & 512) == 0) goto L41;
        String r116 = null;
    L43:
        if ((r218 & 1024) == 0) goto L45;
        String r117 = null;
    L47:
        if ((r218 & 2048) == 0) goto L49;
        String r118 = null;
    L51:
        if ((r218 & 4096) != 0) goto L54;
        r100 = r217;
    L54:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r115, r116, r117, r118, r100);
        return;
    L49:
        r118 = r216;
        goto L51
    L45:
        r117 = r215;
        goto L47
    L41:
        r116 = r214;
        goto L43
    L37:
        r115 = r213;
        goto L39
    L33:
        r108 = r212;
        goto L35
    L29:
        r107 = r211;
        goto L31
    L25:
        r106 = r210;
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
