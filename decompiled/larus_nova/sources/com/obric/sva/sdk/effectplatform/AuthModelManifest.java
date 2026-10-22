package com.obric.sva.sdk.effectplatform;

import com.google.gson.annotations.SerializedName;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\"\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u007f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0081\u0001\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010¨\u0006+"}, d2 = {"Lcom/obric/sva/sdk/effectplatform/AuthModelManifest;", "", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "", "date", "version", "description", "authModelFile", "authModelVersion", "authModelMd5", "authKeyFile", "authKeyMd5", "authRawFileMd5", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getModel", "()Ljava/lang/String;", "getDate", "getVersion", "getDescription", "getAuthModelFile", "getAuthModelVersion", "getAuthModelMd5", "getAuthKeyFile", "getAuthKeyMd5", "getAuthRawFileMd5", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "", "other", "hashCode", "", "toString", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AuthModelManifest {

    @SerializedName("auth-key")
    private final String authKeyFile;

    @SerializedName("auth-key-md5")
    private final String authKeyMd5;

    @SerializedName("auth-file")
    private final String authModelFile;

    @SerializedName("auth-md5")
    private final String authModelMd5;

    @SerializedName("auth-model-version")
    private final String authModelVersion;

    @SerializedName("auth-rawfile-md5")
    private final String authRawFileMd5;

    @SerializedName("date")
    private final String date;

    @SerializedName("description")
    private final String description;

    @SerializedName(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL)
    private final String model;

    @SerializedName("version")
    private final String version;

    public AuthModelManifest() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    public static /* synthetic */ AuthModelManifest copy$default(AuthModelManifest r110, String r111, String r112, String r113, String r114, String r115, String r116, String r117, String r118, String r210, String r211, int r212, Object r213) {
        if ((r212 & 1) == 0) goto L5;
        String r100 = r110.model;
    L7:
        if ((r212 & 2) == 0) goto L9;
        String r101 = r110.date;
    L11:
        if ((r212 & 4) == 0) goto L13;
        String r102 = r110.version;
    L15:
        if ((r212 & 8) == 0) goto L17;
        String r103 = r110.description;
    L19:
        if ((r212 & 16) == 0) goto L21;
        String r104 = r110.authModelFile;
    L23:
        if ((r212 & 32) == 0) goto L25;
        String r105 = r110.authModelVersion;
    L27:
        if ((r212 & 64) == 0) goto L29;
        String r106 = r110.authModelMd5;
    L31:
        if ((r212 & 128) == 0) goto L33;
        String r107 = r110.authKeyFile;
    L35:
        if ((r212 & 256) == 0) goto L37;
        String r119 = r110.authKeyMd5;
    L39:
        if ((r212 & 512) == 0) goto L41;
        String r108 = r110.authRawFileMd5;
    L43:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r119, r108);
    L41:
        r108 = r211;
        goto L43
    L37:
        r119 = r210;
        goto L39
    L33:
        r107 = r118;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
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
        return this.model;
    }

    public final String component10() {
        return this.authRawFileMd5;
    }

    public final String component2() {
        return this.date;
    }

    public final String component3() {
        return this.version;
    }

    public final String component4() {
        return this.description;
    }

    public final String component5() {
        return this.authModelFile;
    }

    public final String component6() {
        return this.authModelVersion;
    }

    public final String component7() {
        return this.authModelMd5;
    }

    public final String component8() {
        return this.authKeyFile;
    }

    public final String component9() {
        return this.authKeyMd5;
    }

    public final AuthModelManifest copy(String r110, String r111, String r112, String r113, String r114, String r115, String r116, String r210, String r211, String r212) {
        return new AuthModelManifest(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AuthModelManifest) == true) goto L8;
        return false;
    L8:
        AuthModelManifest r101 = (AuthModelManifest) r100;
        if (Intrinsics.areEqual(this.model, r101.model) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.date, r101.date) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.version, r101.version) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.description, r101.description) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.authModelFile, r101.authModelFile) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.authModelVersion, r101.authModelVersion) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.authModelMd5, r101.authModelMd5) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.authKeyFile, r101.authKeyFile) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.authKeyMd5, r101.authKeyMd5) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.authRawFileMd5, r101.authRawFileMd5) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        String r100 = this.model;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.date;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.version;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.description;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.authModelFile;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.authModelVersion;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.authModelMd5;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.authKeyFile;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.authKeyMd5;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.authRawFileMd5;
        if (r128 == null) goto L43;
        r101 = r128.hashCode();
    L43:
        return r127 + r101;
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
        return "AuthModelManifest(model=" + this.model + ", date=" + this.date + ", version=" + this.version + ", description=" + this.description + ", authModelFile=" + this.authModelFile + ", authModelVersion=" + this.authModelVersion + ", authModelMd5=" + this.authModelMd5 + ", authKeyFile=" + this.authKeyFile + ", authKeyMd5=" + this.authKeyMd5 + ", authRawFileMd5=" + this.authRawFileMd5 + ')';
    }

    public final String getAuthKeyFile() {
        return this.authKeyFile;
    }

    public final String getAuthKeyMd5() {
        return this.authKeyMd5;
    }

    public final String getAuthModelFile() {
        return this.authModelFile;
    }

    public final String getAuthModelMd5() {
        return this.authModelMd5;
    }

    public final String getAuthModelVersion() {
        return this.authModelVersion;
    }

    public final String getAuthRawFileMd5() {
        return this.authRawFileMd5;
    }

    public final String getDate() {
        return this.date;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getModel() {
        return this.model;
    }

    public final String getVersion() {
        return this.version;
    }

    public AuthModelManifest(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r108, String r110) {
        this.model = r100;
        this.date = r101;
        this.version = r102;
        this.description = r103;
        this.authModelFile = r104;
        this.authModelVersion = r105;
        this.authModelMd5 = r106;
        this.authKeyFile = r107;
        this.authKeyMd5 = r108;
        this.authRawFileMd5 = r110;
    }

    public /* synthetic */ AuthModelManifest(String r110, String r111, String r112, String r113, String r114, String r115, String r116, String r117, String r210, String r211, int r212, DefaultConstructorMarker r213) {
        String r100 = null;
        if ((r212 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r212 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r212 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r212 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r212 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r212 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r212 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r212 & 128) == 0) goto L33;
        String r108 = null;
    L35:
        if ((r212 & 256) == 0) goto L37;
        String r118 = null;
    L39:
        if ((r212 & 512) != 0) goto L42;
        r100 = r211;
    L42:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r118, r100);
        return;
    L37:
        r118 = r210;
        goto L39
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
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
