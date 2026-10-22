package com.bytedance.android.shopping.sku.inner.repo.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\b\u0018\u00002\u00020\u0001B?\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0018\b\u0002\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\f¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR'\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/shopping/sku/inner/repo/model/SkuPassThroughItem;", "Ljava/io/Serializable;", "", "", "to", "Ljava/util/List;", "getTo", "()Ljava/util/List;", "data", "Ljava/lang/String;", "getData", "()Ljava/lang/String;", "", "a", "Ljava/util/Map;", "getRawMap", "()Ljava/util/Map;", "rawMap", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/util/Map;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SkuPassThroughItem implements Serializable {
    public final transient Map<String, String> a;

    @SerializedName("data")
    private final String data;

    @SerializedName("to")
    private final List<String> to;

    public SkuPassThroughItem() {
        this(null, null, null, 7, null);
    }

    public final String getData() {
        return this.data;
    }

    public final Map<String, String> getRawMap() {
        return this.a;
    }

    public final List<String> getTo() {
        return this.to;
    }

    public SkuPassThroughItem(List<String> r1, String r2, Map<String, String> r3) {
        this.to = r1;
        this.data = r2;
        this.a = r3;
    }

    public /* synthetic */ SkuPassThroughItem(List r2, String r3, Map r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }
}
