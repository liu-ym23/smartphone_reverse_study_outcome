package sq9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/larus/platform/model/creation/CommunityRecommendRequestConfig;", "", "pageSize", "", "preloadThreshold", "<init>", "(II)V", "getPageSize", "()I", "getPreloadThreshold", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f543085a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f543086b = null;

    @SerializedName("page_size")
    private final int pageSize;

    @SerializedName("preload_threshold")
    private final int preloadThreshold;

    /* JADX INFO: renamed from: sq9.a$a, reason: collision with other inner class name */
    public static final class C7643a {
    }

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.pageSize == r101.pageSize) goto L12;
        return false;
    L12:
        if (this.preloadThreshold == r101.preloadThreshold) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.pageSize * 31) + this.preloadThreshold;
    }

    public final String toString() {
        return "CommunityRecommendRequestConfig(pageSize=" + this.pageSize + ", preloadThreshold=" + this.preloadThreshold + ')';
    }

    static {
        f543085a = new a(12, 6);
        f543086b = new a(0);
    }

    public final int a() {
        return this.pageSize;
    }

    public final int b() {
        return this.preloadThreshold;
    }

    public /* synthetic */ a(int r100) {
        this(20, 10);
    }

    public a(int r100, int r101) {
        this.pageSize = r100;
        this.preloadThreshold = r101;
    }
}
