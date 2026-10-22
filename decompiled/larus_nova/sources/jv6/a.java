package jv6;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Ljv6/a;", "", "", "needPrefetch", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "", "", "resources", "Ljava/util/List;", "getResources", "()Ljava/util/List;", "locallife-live-api_release"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("need_prefetch")
    private final int needPrefetch;

    @SerializedName("list")
    private final List<String> resources;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.needPrefetch == r101.needPrefetch) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.resources, r101.resources) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.needPrefetch * 31;
        List<String> r101 = this.resources;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "AtmosphereResourceCacheConfig(needPrefetch=" + this.needPrefetch + ", resources=" + this.resources + ')';
    }

    public a() {
        List<String> r100 = CollectionsKt.emptyList();
        this.needPrefetch = 1;
        this.resources = r100;
    }

    public final int a() {
        return this.needPrefetch;
    }

    public final List<String> getResources() {
        return this.resources;
    }
}
