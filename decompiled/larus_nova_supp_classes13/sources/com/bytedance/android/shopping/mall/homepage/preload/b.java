package com.bytedance.android.shopping.mall.homepage.preload;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR0\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R0\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/preload/b;", "", "", "itemType", "Ljava/lang/Integer;", "getItemType", "()Ljava/lang/Integer;", "setItemType", "(Ljava/lang/Integer;)V", "loadNum", "getLoadNum", "setLoadNum", "", "", "urlReplace", "Ljava/util/Map;", "getUrlReplace", "()Ljava/util/Map;", "setUrlReplace", "(Ljava/util/Map;)V", "schemaReplace", "getSchemaReplace", "setSchemaReplace", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("item_type")
    private Integer itemType;

    @SerializedName("load_num")
    private Integer loadNum;

    @SerializedName("schema_replace")
    private Map<String, String> schemaReplace;

    @SerializedName("url_replace")
    private Map<String, String> urlReplace;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof b) == false) goto L14;
        b r4 = (b) r3;
        if (Intrinsics.areEqual(this.itemType, r4.itemType) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.loadNum, r4.loadNum) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.urlReplace, r4.urlReplace) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.schemaReplace, r4.schemaReplace) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        Integer r0 = this.itemType;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.loadNum;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Map<String, String> r7 = this.urlReplace;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Map<String, String> r10 = this.schemaReplace;
        if (r10 == null) goto L18;
        r1 = r10.hashCode();
    L18:
        return r9 + r1;
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "MallLynxCardPreCreateInnerConfig(itemType=" + this.itemType + ", loadNum=" + this.loadNum + ", urlReplace=" + this.urlReplace + ", schemaReplace=" + this.schemaReplace + ")";
    }

    public b() {
        this.itemType = null;
        this.loadNum = null;
        this.urlReplace = null;
        this.schemaReplace = null;
    }
}
