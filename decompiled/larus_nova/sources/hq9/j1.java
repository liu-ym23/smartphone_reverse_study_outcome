package hq9;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006\u0012\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006HÆ\u0003J\u0013\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006HÆ\u0003JE\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00062\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0007HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR \u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR \u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/larus/platform/model/FoldableConfig;", "", "enableFoldableIdentify", "", "foldableIdentifyUseKevaCache", "foldableModelBlackList", "", "", "foldableModelWhiteList", "<init>", "(ZZLjava/util/List;Ljava/util/List;)V", "getEnableFoldableIdentify", "()Z", "getFoldableIdentifyUseKevaCache", "getFoldableModelBlackList", "()Ljava/util/List;", "getFoldableModelWhiteList", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class j1 {

    @SerializedName("enable_foldable_identify")
    private final boolean enableFoldableIdentify;

    @SerializedName("foldable_identify_use_keva_cache")
    private final boolean foldableIdentifyUseKevaCache;

    @SerializedName("foldable_model_black_list")
    private final List<String> foldableModelBlackList;

    @SerializedName("foldable_model_white_list")
    private final List<String> foldableModelWhiteList;

    public j1() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j1) == true) goto L8;
        return false;
    L8:
        j1 r101 = (j1) r100;
        if (this.enableFoldableIdentify == r101.enableFoldableIdentify) goto L12;
        return false;
    L12:
        if (this.foldableIdentifyUseKevaCache == r101.foldableIdentifyUseKevaCache) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.foldableModelBlackList, r101.foldableModelBlackList) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.foldableModelWhiteList, r101.foldableModelWhiteList) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.enableFoldableIdentify == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.foldableIdentifyUseKevaCache == true) goto L10;
        r100 = 1237;
    L10:
        int r103 = (r102 + r100) * 31;
        List<String> r104 = this.foldableModelBlackList;
        int r105 = 0;
        if (r104 != null) goto L13;
        int r106 = 0;
    L14:
        int r107 = (r103 + r106) * 31;
        List<String> r108 = this.foldableModelWhiteList;
        if (r108 == null) goto L19;
        r105 = r108.hashCode();
    L19:
        return r107 + r105;
    L13:
        r106 = r104.hashCode();
        goto L14
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "FoldableConfig(enableFoldableIdentify=" + this.enableFoldableIdentify + ", foldableIdentifyUseKevaCache=" + this.foldableIdentifyUseKevaCache + ", foldableModelBlackList=" + this.foldableModelBlackList + ", foldableModelWhiteList=" + this.foldableModelWhiteList + ')';
    }

    public final boolean a() {
        return this.enableFoldableIdentify;
    }

    public final boolean b() {
        return this.foldableIdentifyUseKevaCache;
    }

    public final List<String> c() {
        return this.foldableModelBlackList;
    }

    public final List<String> d() {
        return this.foldableModelWhiteList;
    }

    public j1(Object r100) {
        List<String> r101 = CollectionsKt.emptyList();
        List<String> r102 = CollectionsKt.emptyList();
        this.enableFoldableIdentify = false;
        this.foldableIdentifyUseKevaCache = true;
        this.foldableModelBlackList = r101;
        this.foldableModelWhiteList = r102;
    }
}
