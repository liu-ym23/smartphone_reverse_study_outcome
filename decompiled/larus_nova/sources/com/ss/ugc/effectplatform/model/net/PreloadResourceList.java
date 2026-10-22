package com.ss.ugc.effectplatform.model.net;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bm\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\n¢\u0006\u0002\u0010\u000fJ\t\u0010(\u001a\u00020\u0003HÆ\u0003J\u0011\u0010)\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\nHÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\u000f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00030\nHÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\u007f\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\nHÆ\u0001J\u0013\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00106\u001a\u000207HÖ\u0001J\t\u00108\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0011\"\u0004\b\u001b\u0010\u0013R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0011\"\u0004\b\u001d\u0010\u0013R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0011\"\u0004\b\u001f\u0010\u0013R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0011\"\u0004\b!\u0010\u0013R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0011\"\u0004\b#\u0010\u0013R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0011\"\u0004\b%\u0010\u0013R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0011\"\u0004\b'\u0010\u0013¨\u00069"}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/PreloadResourceList;", "", "key", "", "name", "version", "level", "type", "uri", "cdn_prefix_list", "", "download_type", "block_file_type", "block_list", "Lcom/ss/ugc/effectplatform/model/net/Block_list;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getBlock_file_type", "()Ljava/lang/String;", "setBlock_file_type", "(Ljava/lang/String;)V", "getBlock_list", "()Ljava/util/List;", "setBlock_list", "(Ljava/util/List;)V", "getCdn_prefix_list", "setCdn_prefix_list", "getDownload_type", "setDownload_type", "getKey", "setKey", "getLevel", "setLevel", "getName", "setName", "getType", "setType", "getUri", "setUri", "getVersion", "setVersion", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "effectplatform_release"}, k = 1, mv = {1, 1, 16})
public final class PreloadResourceList {
    private String block_file_type;
    private List<Block_list> block_list;
    private List<String> cdn_prefix_list;
    private String download_type;
    private String key;
    private String level;
    private String name;
    private String type;
    private String uri;
    private String version;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PreloadResourceList copy$default(PreloadResourceList r110, String r111, String r112, String r113, String r114, String r115, String r116, List r117, String r118, String r210, List r211, int r212, Object r213) {
        if ((r212 & 1) == 0) goto L5;
        String r100 = r110.key;
    L7:
        if ((r212 & 2) == 0) goto L9;
        String r101 = r110.name;
    L11:
        if ((r212 & 4) == 0) goto L13;
        String r102 = r110.version;
    L15:
        if ((r212 & 8) == 0) goto L17;
        String r103 = r110.level;
    L19:
        if ((r212 & 16) == 0) goto L21;
        String r104 = r110.type;
    L23:
        if ((r212 & 32) == 0) goto L25;
        String r105 = r110.uri;
    L27:
        if ((r212 & 64) == 0) goto L29;
        List r106 = r110.cdn_prefix_list;
    L31:
        if ((r212 & 128) == 0) goto L33;
        String r107 = r110.download_type;
    L35:
        if ((r212 & 256) == 0) goto L37;
        String r119 = r110.block_file_type;
    L39:
        if ((r212 & 512) == 0) goto L41;
        List r108 = r110.block_list;
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
        return this.key;
    }

    public final List<Block_list> component10() {
        return this.block_list;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.version;
    }

    public final String component4() {
        return this.level;
    }

    public final String component5() {
        return this.type;
    }

    public final String component6() {
        return this.uri;
    }

    public final List<String> component7() {
        return this.cdn_prefix_list;
    }

    public final String component8() {
        return this.download_type;
    }

    public final String component9() {
        return this.block_file_type;
    }

    public final PreloadResourceList copy(String r110, String r111, String r112, String r113, String r114, String r115, List<String> r116, String r210, String r211, List<Block_list> r212) {
        return new PreloadResourceList(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PreloadResourceList) == false) goto L26;
        PreloadResourceList r101 = (PreloadResourceList) r100;
        if (Intrinsics.areEqual(this.key, r101.key) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.version, r101.version) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.level, r101.level) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.uri, r101.uri) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.cdn_prefix_list, r101.cdn_prefix_list) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.download_type, r101.download_type) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.block_file_type, r101.block_file_type) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.block_list, r101.block_list) == true) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    public int hashCode() {
        String r100 = this.key;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.name;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.version;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.level;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.type;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.uri;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        List<String> r119 = this.cdn_prefix_list;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.download_type;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.block_file_type;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        List<Block_list> r128 = this.block_list;
        if (r128 == null) goto L42;
        r101 = r128.hashCode();
    L42:
        return r127 + r101;
    L37:
        r126 = 0;
        goto L38
    L33:
        r123 = 0;
        goto L34
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "PreloadResourceList(key=" + this.key + ", name=" + this.name + ", version=" + this.version + ", level=" + this.level + ", type=" + this.type + ", uri=" + this.uri + ", cdn_prefix_list=" + this.cdn_prefix_list + ", download_type=" + this.download_type + ", block_file_type=" + this.block_file_type + ", block_list=" + this.block_list + ")";
    }

    public final String getBlock_file_type() {
        return this.block_file_type;
    }

    public final List<Block_list> getBlock_list() {
        return this.block_list;
    }

    public final List<String> getCdn_prefix_list() {
        return this.cdn_prefix_list;
    }

    public final String getDownload_type() {
        return this.download_type;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getLevel() {
        return this.level;
    }

    public final String getName() {
        return this.name;
    }

    public final String getType() {
        return this.type;
    }

    public final String getUri() {
        return this.uri;
    }

    public final String getVersion() {
        return this.version;
    }

    public final void setBlock_file_type(String r100) {
        this.block_file_type = r100;
    }

    public final void setBlock_list(List<Block_list> r100) {
        this.block_list = r100;
    }

    public final void setCdn_prefix_list(List<String> r100) {
        this.cdn_prefix_list = r100;
    }

    public final void setDownload_type(String r100) {
        this.download_type = r100;
    }

    public final void setKey(String r100) {
        this.key = r100;
    }

    public final void setLevel(String r100) {
        this.level = r100;
    }

    public final void setName(String r100) {
        this.name = r100;
    }

    public final void setType(String r100) {
        this.type = r100;
    }

    public final void setUri(String r100) {
        this.uri = r100;
    }

    public final void setVersion(String r100) {
        this.version = r100;
    }

    public PreloadResourceList(String r100, String r101, String r102, String r103, String r104, String r105, List<String> r106, String r107, String r108, List<Block_list> r110) {
        this.key = r100;
        this.name = r101;
        this.version = r102;
        this.level = r103;
        this.type = r104;
        this.uri = r105;
        this.cdn_prefix_list = r106;
        this.download_type = r107;
        this.block_file_type = r108;
        this.block_list = r110;
    }

    public /* synthetic */ PreloadResourceList(String r110, String r111, String r112, String r113, String r114, String r210, List r211, String r212, String r213, List r214, int r215, DefaultConstructorMarker r216) {
        if ((r215 & 4) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r215 & 8) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r215 & 512) == 0) goto L13;
        List r115 = null;
    L14:
        this(r110, r111, r100, r101, r114, r210, r211, r212, r213, r115);
        return;
    L13:
        r115 = r214;
        goto L14
    L9:
        r101 = r113;
        goto L11
    L5:
        r100 = r112;
        goto L7
    }
}
