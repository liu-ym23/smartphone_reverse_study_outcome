package com.bytedance.iesgurd.meta;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u001e\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0003J\t\u0010\u001b\u001a\u00020\u0018HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/bytedance/iesgurd/meta/UltraUpdateResource;", "", "schema", "", "domains", "", "resourcePrefix", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getDomains", "()Ljava/util/List;", "getResourcePrefix", "()Ljava/lang/String;", "setResourcePrefix", "(Ljava/lang/String;)V", "getSchema", "component1", "component2", "component3", "copy", "equals", "", "other", "getUrl", "index", "", "channel", "bundle", "hashCode", "toString", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
public final class UltraUpdateResource {

    @SerializedName("domains")
    private final List<String> domains;

    @SerializedName("resource_prefix")
    private String resourcePrefix;

    @SerializedName("schema")
    private final String schema;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UltraUpdateResource copy$default(UltraUpdateResource r100, String r101, List r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.schema;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.domains;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.resourcePrefix;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.schema;
    }

    public final List<String> component2() {
        return this.domains;
    }

    public final String component3() {
        return this.resourcePrefix;
    }

    public final UltraUpdateResource copy(String r100, List<String> r101, String r102) {
        return new UltraUpdateResource(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof UltraUpdateResource) == false) goto L12;
        UltraUpdateResource r101 = (UltraUpdateResource) r100;
        if (Intrinsics.areEqual(this.schema, r101.schema) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.domains, r101.domains) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.resourcePrefix, r101.resourcePrefix) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        String r100 = this.schema;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.domains;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.resourcePrefix;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "UltraUpdateResource(schema=" + this.schema + ", domains=" + this.domains + ", resourcePrefix=" + this.resourcePrefix + ")";
    }

    public final List<String> getDomains() {
        return this.domains;
    }

    public final String getResourcePrefix() {
        return this.resourcePrefix;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final void setResourcePrefix(String r100) {
        this.resourcePrefix = r100;
    }

    public UltraUpdateResource(String r100, List<String> r101, String r102) {
        this.schema = r100;
        this.domains = r101;
        this.resourcePrefix = r102;
    }

    public final String getUrl(int r100, String r101, String r102) {
        String r103 = (String) ListProtector.get(this.domains, r100);
        if (StringsKt.endsWith$default(r103, HTTP.URL_DEFAULT, false, 2, null) == true) goto L8;
        if (StringsKt.startsWith$default(this.resourcePrefix, HTTP.URL_DEFAULT, false, 2, null) == true) goto L8;
        r103 = r103 + HTTP.URL_DEFAULT;
    L8:
        if (StringsKt.endsWith$default(this.resourcePrefix, HTTP.URL_DEFAULT, false, 2, null) == true) goto L11;
        this.resourcePrefix = this.resourcePrefix + HTTP.URL_DEFAULT;
    L11:
        return this.schema + "://" + r103 + this.resourcePrefix + r101 + '/' + r102;
    }
}
