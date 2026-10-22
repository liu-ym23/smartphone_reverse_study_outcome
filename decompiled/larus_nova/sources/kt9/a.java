package kt9;

import com.google.gson.annotations.SerializedName;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0018\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\u0018\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ@\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00052\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\"\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\"\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/larus/settings/image/ImageCacheConfig;", "", "enable", "", "domainWhiteList", "", "", "pathWhiteList", "<init>", "(Z[Ljava/lang/String;[Ljava/lang/String;)V", "getEnable", "()Z", "getDomainWhiteList", "()[Ljava/lang/String;", "[Ljava/lang/String;", "getPathWhiteList", "component1", "component2", "component3", "copy", "(Z[Ljava/lang/String;[Ljava/lang/String;)Lcom/larus/settings/image/ImageCacheConfig;", "equals", "other", "hashCode", "", "toString", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    @SerializedName("domain_white_list")
    private final String[] domainWhiteList;

    @SerializedName("image_cache_opt_enable")
    private final boolean enable;

    @SerializedName("path_white_list")
    private final String[] pathWhiteList;

    public a() {
        this(false, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.enable == r101.enable) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.domainWhiteList, r101.domainWhiteList) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.pathWhiteList, r101.pathWhiteList) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        if (this.enable == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        String[] r102 = this.domainWhiteList;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r101 + r104) * 31;
        String[] r106 = this.pathWhiteList;
        if (r106 == null) goto L15;
        r103 = Arrays.hashCode(r106);
    L15:
        return r105 + r103;
    L9:
        r104 = Arrays.hashCode(r102);
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "ImageCacheConfig(enable=" + this.enable + ", domainWhiteList=" + Arrays.toString(this.domainWhiteList) + ", pathWhiteList=" + Arrays.toString(this.pathWhiteList) + ')';
    }

    public final String[] a() {
        return this.domainWhiteList;
    }

    public final boolean b() {
        return this.enable;
    }

    public final String[] c() {
        return this.pathWhiteList;
    }

    public a(boolean r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        r100 = true;
    L5:
        String[] r102 = null;
        if ((r101 & 2) == 0) goto L8;
        String[] r103 = new String[0];
    L10:
        if ((r101 & 4) == 0) goto L12;
        r102 = new String[0];
    L12:
        this.enable = r100;
        this.domainWhiteList = r103;
        this.pathWhiteList = r102;
        return;
    L8:
        r103 = null;
        goto L10
    }
}
