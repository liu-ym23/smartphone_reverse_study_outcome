package com.obric.sva.sdk.effectplatform;

import com.google.gson.annotations.SerializedName;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b'\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bß\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u000e\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0000J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003Já\u0001\u0010?\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010@\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010A\u001a\u00020BHÖ\u0001J\t\u0010C\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0018R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0018R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0018R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0018R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0018R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0018R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0018R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0018R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0018R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0018¨\u0006D"}, d2 = {"Lcom/obric/sva/sdk/effectplatform/ModelManifest;", "", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "", "date", "version", "description", "kwsModelFile", "kwsModelVersion", "kwsEngineVersion", "kwsModelMd5", "kwsKeyFile", "kwsKeyMd5", "kwsRawFileMd5", "sidModelFile", "sidModelVersion", "sidEngineVersion", "sidModelMd5", "sidKeyFile", "sidKeyMd5", "sidRawFileMd5", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getModel", "()Ljava/lang/String;", "getDate", "getVersion", "getDescription", "getKwsModelFile", "getKwsModelVersion", "getKwsEngineVersion", "getKwsModelMd5", "getKwsKeyFile", "getKwsKeyMd5", "getKwsRawFileMd5", "getSidModelFile", "getSidModelVersion", "getSidEngineVersion", "getSidModelMd5", "getSidKeyFile", "getSidKeyMd5", "getSidRawFileMd5", "sameAs", "", "other", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "copy", "equals", "hashCode", "", "toString", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ModelManifest {

    @SerializedName("date")
    private final String date;

    @SerializedName("description")
    private final String description;

    @SerializedName("kws_engine_version")
    private final String kwsEngineVersion;

    @SerializedName("kws-key")
    private final String kwsKeyFile;

    @SerializedName("kws-key-md5")
    private final String kwsKeyMd5;

    @SerializedName("kws-file")
    private final String kwsModelFile;

    @SerializedName("kws-md5")
    private final String kwsModelMd5;

    @SerializedName("kws-model-version")
    private final String kwsModelVersion;

    @SerializedName("kws-rawfile-md5")
    private final String kwsRawFileMd5;

    @SerializedName(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL)
    private final String model;

    @SerializedName("voiceprint-engine-version")
    private final String sidEngineVersion;

    @SerializedName("voiceprint-key")
    private final String sidKeyFile;

    @SerializedName("voiceprint-key-md5")
    private final String sidKeyMd5;

    @SerializedName("voiceprint-file")
    private final String sidModelFile;

    @SerializedName("voiceprint-md5")
    private final String sidModelMd5;

    @SerializedName("voiceprint-model-version")
    private final String sidModelVersion;

    @SerializedName("voiceprint-rawfile-md5")
    private final String sidRawFileMd5;

    @SerializedName("version")
    private final String version;

    public ModelManifest() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 262143, null);
    }

    public static /* synthetic */ ModelManifest copy$default(ModelManifest r110, String r111, String r112, String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218, String r219, String r310, String r311, String r312, String r313, String r314, String r315, int r316, Object r317) {
        if ((r316 & 1) == 0) goto L5;
        String r100 = r110.model;
    L7:
        if ((r316 & 2) == 0) goto L9;
        String r101 = r110.date;
    L11:
        if ((r316 & 4) == 0) goto L13;
        String r102 = r110.version;
    L15:
        if ((r316 & 8) == 0) goto L17;
        String r103 = r110.description;
    L19:
        if ((r316 & 16) == 0) goto L21;
        String r104 = r110.kwsModelFile;
    L23:
        if ((r316 & 32) == 0) goto L25;
        String r105 = r110.kwsModelVersion;
    L27:
        if ((r316 & 64) == 0) goto L29;
        String r106 = r110.kwsEngineVersion;
    L31:
        if ((r316 & 128) == 0) goto L33;
        String r107 = r110.kwsModelMd5;
    L35:
        if ((r316 & 256) == 0) goto L37;
        String r113 = r110.kwsKeyFile;
    L39:
        if ((r316 & 512) == 0) goto L41;
        String r114 = r110.kwsKeyMd5;
    L43:
        if ((r316 & 1024) == 0) goto L45;
        String r115 = r110.kwsRawFileMd5;
    L47:
        if ((r316 & 2048) == 0) goto L49;
        String r116 = r110.sidModelFile;
    L51:
        if ((r316 & 4096) == 0) goto L53;
        String r117 = r110.sidModelVersion;
    L55:
        if ((r316 & 8192) == 0) goto L57;
        String r118 = r110.sidEngineVersion;
    L58:
        String r318 = r118;
        if ((r316 & 16384) == 0) goto L61;
        String r119 = r110.sidModelMd5;
    L62:
        String r319 = r119;
        if ((r316 & 32768) == 0) goto L65;
        String r120 = r110.sidKeyFile;
    L66:
        String r320 = r120;
        if ((r316 & 65536) == 0) goto L69;
        String r121 = r110.sidKeyMd5;
    L71:
        if ((r316 & 131072) == 0) goto L73;
        String r108 = r110.sidRawFileMd5;
    L75:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r318, r319, r320, r121, r108);
    L73:
        r108 = r315;
        goto L75
    L69:
        r121 = r314;
        goto L71
    L65:
        r120 = r313;
        goto L66
    L61:
        r119 = r312;
        goto L62
    L57:
        r118 = r311;
        goto L58
    L53:
        r117 = r310;
        goto L55
    L49:
        r116 = r219;
        goto L51
    L45:
        r115 = r218;
        goto L47
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

    public final String component1() {
        return this.model;
    }

    public final String component10() {
        return this.kwsKeyMd5;
    }

    public final String component11() {
        return this.kwsRawFileMd5;
    }

    public final String component12() {
        return this.sidModelFile;
    }

    public final String component13() {
        return this.sidModelVersion;
    }

    public final String component14() {
        return this.sidEngineVersion;
    }

    public final String component15() {
        return this.sidModelMd5;
    }

    public final String component16() {
        return this.sidKeyFile;
    }

    public final String component17() {
        return this.sidKeyMd5;
    }

    public final String component18() {
        return this.sidRawFileMd5;
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
        return this.kwsModelFile;
    }

    public final String component6() {
        return this.kwsModelVersion;
    }

    public final String component7() {
        return this.kwsEngineVersion;
    }

    public final String component8() {
        return this.kwsModelMd5;
    }

    public final String component9() {
        return this.kwsKeyFile;
    }

    public final ModelManifest copy(String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218, String r310, String r311, String r312, String r313, String r314, String r315, String r316, String r317, String r318) {
        return new ModelManifest(r210, r211, r212, r213, r214, r215, r216, r217, r218, r310, r311, r312, r313, r314, r315, r316, r317, r318);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ModelManifest) == true) goto L8;
        return false;
    L8:
        ModelManifest r101 = (ModelManifest) r100;
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
        if (Intrinsics.areEqual(this.kwsModelFile, r101.kwsModelFile) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.kwsModelVersion, r101.kwsModelVersion) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.kwsEngineVersion, r101.kwsEngineVersion) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.kwsModelMd5, r101.kwsModelMd5) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.kwsKeyFile, r101.kwsKeyFile) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.kwsKeyMd5, r101.kwsKeyMd5) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.kwsRawFileMd5, r101.kwsRawFileMd5) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.sidModelFile, r101.sidModelFile) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.sidModelVersion, r101.sidModelVersion) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.sidEngineVersion, r101.sidEngineVersion) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.sidModelMd5, r101.sidModelMd5) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.sidKeyFile, r101.sidKeyFile) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.sidKeyMd5, r101.sidKeyMd5) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.sidRawFileMd5, r101.sidRawFileMd5) == true) goto L62;
        return false;
    L62:
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
        String r113 = this.kwsModelFile;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.kwsModelVersion;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.kwsEngineVersion;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.kwsModelMd5;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.kwsKeyFile;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.kwsKeyMd5;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.kwsRawFileMd5;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.sidModelFile;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        String r137 = this.sidModelVersion;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        String r140 = this.sidEngineVersion;
        if (r140 != null) goto L57;
        int r141 = 0;
    L58:
        int r142 = (r139 + r141) * 31;
        String r143 = this.sidModelMd5;
        if (r143 != null) goto L61;
        int r144 = 0;
    L62:
        int r145 = (r142 + r144) * 31;
        String r146 = this.sidKeyFile;
        if (r146 != null) goto L65;
        int r147 = 0;
    L66:
        int r148 = (r145 + r147) * 31;
        String r149 = this.sidKeyMd5;
        if (r149 != null) goto L69;
        int r150 = 0;
    L70:
        int r151 = (r148 + r150) * 31;
        String r152 = this.sidRawFileMd5;
        if (r152 == null) goto L75;
        r101 = r152.hashCode();
    L75:
        return r151 + r101;
    L69:
        r150 = r149.hashCode();
        goto L70
    L65:
        r147 = r146.hashCode();
        goto L66
    L61:
        r144 = r143.hashCode();
        goto L62
    L57:
        r141 = r140.hashCode();
        goto L58
    L53:
        r138 = r137.hashCode();
        goto L54
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
        return "ModelManifest(model=" + this.model + ", date=" + this.date + ", version=" + this.version + ", description=" + this.description + ", kwsModelFile=" + this.kwsModelFile + ", kwsModelVersion=" + this.kwsModelVersion + ", kwsEngineVersion=" + this.kwsEngineVersion + ", kwsModelMd5=" + this.kwsModelMd5 + ", kwsKeyFile=" + this.kwsKeyFile + ", kwsKeyMd5=" + this.kwsKeyMd5 + ", kwsRawFileMd5=" + this.kwsRawFileMd5 + ", sidModelFile=" + this.sidModelFile + ", sidModelVersion=" + this.sidModelVersion + ", sidEngineVersion=" + this.sidEngineVersion + ", sidModelMd5=" + this.sidModelMd5 + ", sidKeyFile=" + this.sidKeyFile + ", sidKeyMd5=" + this.sidKeyMd5 + ", sidRawFileMd5=" + this.sidRawFileMd5 + ')';
    }

    public final String getDate() {
        return this.date;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getKwsEngineVersion() {
        return this.kwsEngineVersion;
    }

    public final String getKwsKeyFile() {
        return this.kwsKeyFile;
    }

    public final String getKwsKeyMd5() {
        return this.kwsKeyMd5;
    }

    public final String getKwsModelFile() {
        return this.kwsModelFile;
    }

    public final String getKwsModelMd5() {
        return this.kwsModelMd5;
    }

    public final String getKwsModelVersion() {
        return this.kwsModelVersion;
    }

    public final String getKwsRawFileMd5() {
        return this.kwsRawFileMd5;
    }

    public final String getModel() {
        return this.model;
    }

    public final String getSidEngineVersion() {
        return this.sidEngineVersion;
    }

    public final String getSidKeyFile() {
        return this.sidKeyFile;
    }

    public final String getSidKeyMd5() {
        return this.sidKeyMd5;
    }

    public final String getSidModelFile() {
        return this.sidModelFile;
    }

    public final String getSidModelMd5() {
        return this.sidModelMd5;
    }

    public final String getSidModelVersion() {
        return this.sidModelVersion;
    }

    public final String getSidRawFileMd5() {
        return this.sidRawFileMd5;
    }

    public final String getVersion() {
        return this.version;
    }

    public final boolean sameAs(ModelManifest r100) {
        Intrinsics.checkNotNullParameter(r100, "other");
        if (Intrinsics.areEqual(this.version, r100.version) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.kwsModelFile, r100.kwsModelFile) == true) goto L8;
    L37:
        return false;
    L8:
        if (Intrinsics.areEqual(this.kwsModelVersion, r100.kwsModelVersion) == false) goto L37;
        if (Intrinsics.areEqual(this.kwsEngineVersion, r100.kwsEngineVersion) == false) goto L37;
        if (Intrinsics.areEqual(this.kwsModelMd5, r100.kwsModelMd5) == false) goto L37;
        if (Intrinsics.areEqual(this.kwsKeyFile, r100.kwsKeyFile) == false) goto L37;
        if (Intrinsics.areEqual(this.kwsKeyMd5, r100.kwsKeyMd5) == false) goto L37;
        if (Intrinsics.areEqual(this.kwsRawFileMd5, r100.kwsRawFileMd5) == false) goto L37;
        if (Intrinsics.areEqual(this.sidModelFile, r100.sidModelFile) == false) goto L37;
        if (Intrinsics.areEqual(this.sidModelVersion, r100.sidModelVersion) == false) goto L37;
        if (Intrinsics.areEqual(this.sidEngineVersion, r100.sidEngineVersion) == false) goto L37;
        if (Intrinsics.areEqual(this.sidModelMd5, r100.sidModelMd5) == false) goto L37;
        if (Intrinsics.areEqual(this.sidKeyFile, r100.sidKeyFile) == false) goto L37;
        if (Intrinsics.areEqual(this.sidKeyMd5, r100.sidKeyMd5) == false) goto L37;
        if (Intrinsics.areEqual(this.sidRawFileMd5, r100.sidRawFileMd5) == false) goto L37;
        return true;
    }

    public ModelManifest(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r110, String r111, String r112, String r113, String r114, String r115, String r116, String r117, String r118, String r119, String r210) {
        this.model = r100;
        this.date = r101;
        this.version = r102;
        this.description = r103;
        this.kwsModelFile = r104;
        this.kwsModelVersion = r105;
        this.kwsEngineVersion = r106;
        this.kwsModelMd5 = r110;
        this.kwsKeyFile = r111;
        this.kwsKeyMd5 = r112;
        this.kwsRawFileMd5 = r113;
        this.sidModelFile = r114;
        this.sidModelVersion = r115;
        this.sidEngineVersion = r116;
        this.sidModelMd5 = r117;
        this.sidKeyFile = r118;
        this.sidKeyMd5 = r119;
        this.sidRawFileMd5 = r210;
    }

    public /* synthetic */ ModelManifest(String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218, String r219, String r310, String r311, String r312, String r313, String r314, String r315, String r316, String r317, int r318, DefaultConstructorMarker r319) {
        if ((r318 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r318 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r318 & 4) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r318 & 8) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r318 & 16) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r318 & 32) == 0) goto L25;
        String r105 = null;
    L27:
        if ((r318 & 64) == 0) goto L29;
        String r106 = null;
    L31:
        if ((r318 & 128) == 0) goto L33;
        String r107 = null;
    L35:
        if ((r318 & 256) == 0) goto L37;
        String r110 = null;
    L39:
        if ((r318 & 512) == 0) goto L41;
        String r111 = null;
    L43:
        if ((r318 & 1024) == 0) goto L45;
        String r112 = null;
    L47:
        if ((r318 & 2048) == 0) goto L49;
        String r113 = null;
    L51:
        if ((r318 & 4096) == 0) goto L53;
        String r114 = null;
    L55:
        if ((r318 & 8192) == 0) goto L57;
        String r115 = null;
    L59:
        if ((r318 & 16384) == 0) goto L61;
        String r108 = null;
    L63:
        if ((r318 & 32768) == 0) goto L65;
        String r116 = null;
    L67:
        if ((r318 & 65536) == 0) goto L69;
        String r117 = null;
    L71:
        if ((r318 & 131072) == 0) goto L73;
        String r109 = null;
    L74:
        this(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, r114, r115, r108, r116, r117, r109);
        return;
    L73:
        r109 = r317;
        goto L74
    L69:
        r117 = r316;
        goto L71
    L65:
        r116 = r315;
        goto L67
    L61:
        r108 = r314;
        goto L63
    L57:
        r115 = r313;
        goto L59
    L53:
        r114 = r312;
        goto L55
    L49:
        r113 = r311;
        goto L51
    L45:
        r112 = r310;
        goto L47
    L41:
        r111 = r219;
        goto L43
    L37:
        r110 = r218;
        goto L39
    L33:
        r107 = r217;
        goto L35
    L29:
        r106 = r216;
        goto L31
    L25:
        r105 = r215;
        goto L27
    L21:
        r104 = r214;
        goto L23
    L17:
        r103 = r213;
        goto L19
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
