package com.bytedance.iesgurd.meta;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B'\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0002\u0010\tBM\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\f\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011J\u0006\u0010 \u001a\u00020!J\t\u0010\"\u001a\u00020\u0004HÆ\u0003J\t\u0010#\u001a\u00020\u0006HÆ\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00060\fHÆ\u0003J\t\u0010%\u001a\u00020\u0006HÆ\u0003J\t\u0010&\u001a\u00020\u0006HÆ\u0003J\t\u0010'\u001a\u00020\u0006HÆ\u0003J\t\u0010(\u001a\u00020\u0004HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0010HÆ\u0003Ja\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u00062\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\f2\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÆ\u0001J\u0013\u0010+\u001a\u00020!2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00060\fJ\t\u0010.\u001a\u00020/HÖ\u0001J\t\u00100\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u000e\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0007\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0016\u0010\n\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\r\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0016\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/bytedance/iesgurd/meta/PrepareMetaPackage;", "", "()V", "id", "", "md5", "", "length", "url", "(JLjava/lang/String;JLjava/lang/String;)V", "schema", "domains", "", "uri", "decompressMd5", "ultraUpdateResource", "Lcom/bytedance/iesgurd/meta/UltraUpdateResource;", "(JLjava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLcom/bytedance/iesgurd/meta/UltraUpdateResource;)V", "getDecompressMd5", "()Ljava/lang/String;", "getDomains", "()Ljava/util/List;", "getId", "()J", "getLength", "getMd5", "getSchema", "getUltraUpdateResource", "()Lcom/bytedance/iesgurd/meta/UltraUpdateResource;", "getUri", "urlList", "", "checkValid", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "getUrlList", "hashCode", "", "toString", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
public final class PrepareMetaPackage {

    @SerializedName("decompress_md5")
    private final String decompressMd5;

    @SerializedName("domains")
    private final List<String> domains;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final long f250762id;

    @SerializedName("size")
    private final long length;

    /* JADX INFO: renamed from: md5, reason: collision with root package name */
    @SerializedName("md5")
    private final String f250763md5;

    @SerializedName("schema")
    private final String schema;

    @SerializedName("ultra_update_resource")
    private final UltraUpdateResource ultraUpdateResource;

    @SerializedName("uri")
    private final String uri;
    private List<String> urlList;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PrepareMetaPackage copy$default(PrepareMetaPackage r110, long r111, String r112, List r113, String r114, String r115, String r116, long r117, UltraUpdateResource r210, int r211, Object r212) {
        if ((r211 & 1) == 0) goto L5;
        long r100 = r110.f250762id;
    L7:
        if ((r211 & 2) == 0) goto L9;
        String r101 = r110.schema;
    L11:
        if ((r211 & 4) == 0) goto L13;
        List r102 = r110.domains;
    L15:
        if ((r211 & 8) == 0) goto L17;
        String r103 = r110.uri;
    L19:
        if ((r211 & 16) == 0) goto L21;
        String r104 = r110.f250763md5;
    L23:
        if ((r211 & 32) == 0) goto L25;
        String r105 = r110.decompressMd5;
    L27:
        if ((r211 & 64) == 0) goto L29;
        long r106 = r110.length;
    L31:
        if ((r211 & 128) == 0) goto L33;
        UltraUpdateResource r107 = r110.ultraUpdateResource;
    L35:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107);
    L33:
        r107 = r210;
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

    public final long component1() {
        return this.f250762id;
    }

    public final String component2() {
        return this.schema;
    }

    public final List<String> component3() {
        return this.domains;
    }

    public final String component4() {
        return this.uri;
    }

    public final String component5() {
        return this.f250763md5;
    }

    public final String component6() {
        return this.decompressMd5;
    }

    public final long component7() {
        return this.length;
    }

    public final UltraUpdateResource component8() {
        return this.ultraUpdateResource;
    }

    public final PrepareMetaPackage copy(long r110, String r111, List<String> r112, String r113, String r114, String r115, long r210, UltraUpdateResource r211) {
        return new PrepareMetaPackage(r110, r111, r112, r113, r114, r115, r210, r211);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PrepareMetaPackage) == false) goto L22;
        PrepareMetaPackage r101 = (PrepareMetaPackage) r100;
        if (this.f250762id == r101.f250762id) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.schema, r101.schema) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.domains, r101.domains) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.uri, r101.uri) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f250763md5, r101.f250763md5) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.decompressMd5, r101.decompressMd5) == true) goto L18;
        return false;
    L18:
        if (this.length == r101.length) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.ultraUpdateResource, r101.ultraUpdateResource) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public int hashCode() {
        long r100 = this.f250762id;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.schema;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.hashCode();
    L6:
        int r105 = (r101 + r104) * 31;
        List<String> r106 = this.domains;
        if (r106 == null) goto L9;
        int r107 = r106.hashCode();
    L10:
        int r108 = (r105 + r107) * 31;
        String r109 = this.uri;
        if (r109 == null) goto L13;
        int r110 = r109.hashCode();
    L14:
        int r111 = (r108 + r110) * 31;
        String r112 = this.f250763md5;
        if (r112 == null) goto L17;
        int r113 = r112.hashCode();
    L18:
        int r114 = (r111 + r113) * 31;
        String r115 = this.decompressMd5;
        if (r115 == null) goto L21;
        int r116 = r115.hashCode();
    L22:
        long r117 = this.length;
        int r118 = (((r114 + r116) * 31) + ((int) (r117 ^ (r117 >>> 32)))) * 31;
        UltraUpdateResource r119 = this.ultraUpdateResource;
        if (r119 == null) goto L26;
        r103 = r119.hashCode();
    L26:
        return r118 + r103;
    L21:
        r116 = 0;
        goto L22
    L17:
        r113 = 0;
        goto L18
    L13:
        r110 = 0;
        goto L14
    L9:
        r107 = 0;
        goto L10
    L5:
        r104 = 0;
        goto L6
    }

    public String toString() {
        return "PrepareMetaPackage(id=" + this.f250762id + ", schema=" + this.schema + ", domains=" + this.domains + ", uri=" + this.uri + ", md5=" + this.f250763md5 + ", decompressMd5=" + this.decompressMd5 + ", length=" + this.length + ", ultraUpdateResource=" + this.ultraUpdateResource + ")";
    }

    public PrepareMetaPackage() {
        this(0, "", CollectionsKt.emptyList(), "", "", "", 0, null);
    }

    public final boolean checkValid() {
        if (this.f250762id < 0) goto L40;
        String r100 = this.schema;
        if (r100 != null) goto L7;
    L10:
        boolean r101 = true;
    L11:
        if (r101 == true) goto L41;
        List<String> r102 = this.domains;
        if (r102 != null) goto L15;
    L18:
        boolean r103 = true;
    L19:
        if (r103 == true) goto L42;
        String r104 = this.uri;
        if (r104 != null) goto L23;
    L26:
        boolean r105 = true;
    L27:
        if (r105 == true) goto L43;
        String r106 = this.f250763md5;
        if (r106 != null) goto L31;
    L34:
        boolean r107 = true;
    L35:
        if (r107 == false) goto L37;
        return false;
    L37:
        if (this.length <= 0) goto L45;
        return true;
    L45:
        return false;
    L31:
        if (r106.length() == 0) goto L34;
        r107 = false;
        goto L35
    L43:
        return false;
    L23:
        if (r104.length() == 0) goto L26;
        r105 = false;
        goto L27
    L42:
        return false;
    L15:
        if (r102.isEmpty() == true) goto L18;
        r103 = false;
        goto L19
    L41:
        return false;
    L7:
        if (r100.length() == 0) goto L10;
        r101 = false;
        goto L11
    L40:
        return false;
    }

    public final List<String> getUrlList() {
        if (this.urlList != null) goto L11;
        this.urlList = new ArrayList();
        Iterator<T> r100 = this.domains.iterator();
    L6:
        if (r100.hasNext() == false) goto L11;
        String r101 = (String) r100.next();
        List<String> r102 = this.urlList;
        if (r102 != null) goto L10;
        Intrinsics.throwNpe();
    L10:
        r102.add(this.schema + "://" + r101 + this.uri);
    L11:
        List<String> r103 = this.urlList;
        if (r103 != null) goto L14;
        Intrinsics.throwNpe();
    L14:
        return r103;
    }

    public final String getDecompressMd5() {
        return this.decompressMd5;
    }

    public final List<String> getDomains() {
        return this.domains;
    }

    public final long getId() {
        return this.f250762id;
    }

    public final long getLength() {
        return this.length;
    }

    public final String getMd5() {
        return this.f250763md5;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final UltraUpdateResource getUltraUpdateResource() {
        return this.ultraUpdateResource;
    }

    public final String getUri() {
        return this.uri;
    }

    public PrepareMetaPackage(long r110, String r111, long r112, String r113) {
        this(r110, "", CollectionsKt.emptyList(), "", r111, "", r112, null);
        ArrayList r100 = new ArrayList();
        this.urlList = r100;
        r100.add(r113);
    }

    public PrepareMetaPackage(long r100, String r101, List<String> r102, String r103, String r104, String r105, long r106, UltraUpdateResource r110) {
        this.f250762id = r100;
        this.schema = r101;
        this.domains = r102;
        this.uri = r103;
        this.f250763md5 = r104;
        this.decompressMd5 = r105;
        this.length = r106;
        this.ultraUpdateResource = r110;
    }
}
