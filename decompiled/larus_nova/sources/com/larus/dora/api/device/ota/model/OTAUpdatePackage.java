package com.larus.dora.api.device.ota.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b*\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001By\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u0012\b\u0002\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010.\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\t\u00101\u001a\u00020\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0013\u00104\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\fHÆ\u0003J\u0010\u00105\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010+J\u0080\u0001\u00106\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\u0012\b\u0002\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u00107J\u0013\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010;HÖ\u0003J\t\u0010<\u001a\u00020\u0003HÖ\u0001J\t\u0010=\u001a\u00020\u0005HÖ\u0001R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R \u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019R\"\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R\u001e\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R \u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0017\"\u0004\b#\u0010\u0019R \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0017\"\u0004\b%\u0010\u0019R(\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010,\u001a\u0004\b*\u0010+¨\u0006>"}, d2 = {"Lcom/larus/dora/api/device/ota/model/OTAUpdatePackage;", "Ljava/io/Serializable;", "id", "", "md5", "", "name", "size", "type", "url", "version", "bakUrls", "", "buildTime", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ILjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Long;)V", "getId", "()Ljava/lang/Integer;", "setId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getMd5", "()Ljava/lang/String;", "setMd5", "(Ljava/lang/String;)V", "getName", "setName", "getSize", "setSize", "getType", "()I", "setType", "(I)V", "getUrl", "setUrl", "getVersion", "setVersion", "getBakUrls", "()Ljava/util/List;", "setBakUrls", "(Ljava/util/List;)V", "getBuildTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ILjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Long;)Lcom/larus/dora/api/device/ota/model/OTAUpdatePackage;", "equals", "", "other", "", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OTAUpdatePackage implements Serializable {

    @SerializedName("bak_urls")
    private List<String> bakUrls;

    @SerializedName("buildtime")
    private final Long buildTime;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private Integer f331737id;

    /* JADX INFO: renamed from: md5, reason: collision with root package name */
    @SerializedName("md5")
    private String f331738md5;

    @SerializedName("name")
    private String name;

    @SerializedName("size")
    private Integer size;

    @SerializedName("type")
    private int type;

    @SerializedName("url")
    private String url;

    @SerializedName("version")
    private String version;

    public OTAUpdatePackage() {
        this(null, null, null, null, 0, null, null, null, null, 511, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OTAUpdatePackage copy$default(OTAUpdatePackage r110, Integer r111, String r112, String r113, Integer r114, int r115, String r116, String r117, List r118, Long r119, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        Integer r100 = r110.f331737id;
    L7:
        if ((r210 & 2) == 0) goto L9;
        String r101 = r110.f331738md5;
    L11:
        if ((r210 & 4) == 0) goto L13;
        String r102 = r110.name;
    L15:
        if ((r210 & 8) == 0) goto L17;
        Integer r103 = r110.size;
    L19:
        if ((r210 & 16) == 0) goto L21;
        int r104 = r110.type;
    L23:
        if ((r210 & 32) == 0) goto L25;
        String r105 = r110.url;
    L27:
        if ((r210 & 64) == 0) goto L29;
        String r106 = r110.version;
    L31:
        if ((r210 & 128) == 0) goto L33;
        List r107 = r110.bakUrls;
    L35:
        if ((r210 & 256) == 0) goto L37;
        Long r108 = r110.buildTime;
    L39:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r108);
    L37:
        r108 = r119;
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

    public final Integer component1() {
        return this.f331737id;
    }

    public final String component2() {
        return this.f331738md5;
    }

    public final String component3() {
        return this.name;
    }

    public final Integer component4() {
        return this.size;
    }

    public final int component5() {
        return this.type;
    }

    public final String component6() {
        return this.url;
    }

    public final String component7() {
        return this.version;
    }

    public final List<String> component8() {
        return this.bakUrls;
    }

    public final Long component9() {
        return this.buildTime;
    }

    public final OTAUpdatePackage copy(Integer r110, String r111, String r112, Integer r113, int r114, String r115, String r116, List<String> r117, Long r210) {
        return new OTAUpdatePackage(r110, r111, r112, r113, r114, r115, r116, r117, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OTAUpdatePackage) == true) goto L8;
        return false;
    L8:
        OTAUpdatePackage r101 = (OTAUpdatePackage) r100;
        if (Intrinsics.areEqual(this.f331737id, r101.f331737id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f331738md5, r101.f331738md5) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.size, r101.size) == true) goto L21;
        return false;
    L21:
        if (this.type == r101.type) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.version, r101.version) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.bakUrls, r101.bakUrls) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.buildTime, r101.buildTime) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.f331737id;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f331738md5;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.name;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.size;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (((r109 + r111) * 31) + this.type) * 31;
        String r113 = this.url;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.version;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        List<String> r119 = this.bakUrls;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Long r122 = this.buildTime;
        if (r122 == null) goto L35;
        r101 = r122.hashCode();
    L35:
        return r121 + r101;
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
        return "OTAUpdatePackage(id=" + this.f331737id + ", md5=" + this.f331738md5 + ", name=" + this.name + ", size=" + this.size + ", type=" + this.type + ", url=" + this.url + ", version=" + this.version + ", bakUrls=" + this.bakUrls + ", buildTime=" + this.buildTime + ')';
    }

    public final List<String> getBakUrls() {
        return this.bakUrls;
    }

    public final Long getBuildTime() {
        return this.buildTime;
    }

    public final Integer getId() {
        return this.f331737id;
    }

    public final String getMd5() {
        return this.f331738md5;
    }

    public final String getName() {
        return this.name;
    }

    public final Integer getSize() {
        return this.size;
    }

    public final int getType() {
        return this.type;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getVersion() {
        return this.version;
    }

    public final void setBakUrls(List<String> r100) {
        this.bakUrls = r100;
    }

    public final void setId(Integer r100) {
        this.f331737id = r100;
    }

    public final void setMd5(String r100) {
        this.f331738md5 = r100;
    }

    public final void setName(String r100) {
        this.name = r100;
    }

    public final void setSize(Integer r100) {
        this.size = r100;
    }

    public final void setType(int r100) {
        this.type = r100;
    }

    public final void setUrl(String r100) {
        this.url = r100;
    }

    public final void setVersion(String r100) {
        this.version = r100;
    }

    public OTAUpdatePackage(Integer r100, String r101, String r102, Integer r103, int r104, String r105, String r106, List<String> r107, Long r108) {
        this.f331737id = r100;
        this.f331738md5 = r101;
        this.name = r102;
        this.size = r103;
        this.type = r104;
        this.url = r105;
        this.version = r106;
        this.bakUrls = r107;
        this.buildTime = r108;
    }

    public /* synthetic */ OTAUpdatePackage(Integer r110, String r111, String r112, Integer r113, int r114, String r115, String r116, List r117, Long r118, int r210, DefaultConstructorMarker r211) {
        Long r100 = null;
        if ((r210 & 1) == 0) goto L5;
        Integer r101 = null;
    L7:
        if ((r210 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r210 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r210 & 8) == 0) goto L17;
        Integer r104 = null;
    L19:
        if ((r210 & 16) == 0) goto L21;
        int r105 = 0;
    L23:
        if ((r210 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r210 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r210 & 128) == 0) goto L33;
        List r108 = null;
    L35:
        if ((r210 & 256) != 0) goto L38;
        r100 = r118;
    L38:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r100);
        return;
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
