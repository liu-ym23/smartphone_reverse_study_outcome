package com.bytedance.locallife.live.experiment;

import com.bytedance.locallife.live.util.LiveLifeSaaSUtil;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes21.dex */
public final class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f259507a = null;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/locallife/live/experiment/n0$a;", "", "", "firstPageSize", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "setFirstPageSize", "(I)V", "pageSize", "c", "setPageSize", "prefetchDistance", "d", "setPrefetchDistance", "firstRenderCount", "b", "setFirstRenderCount", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("first_page_size")
        private int firstPageSize;

        @SerializedName("first_render_count")
        private int firstRenderCount;

        @SerializedName("page_size")
        private int pageSize;

        @SerializedName("prefetch_distance")
        private int prefetchDistance;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.firstPageSize == r101.firstPageSize) goto L12;
            return false;
        L12:
            if (this.pageSize == r101.pageSize) goto L15;
            return false;
        L15:
            if (this.prefetchDistance == r101.prefetchDistance) goto L18;
            return false;
        L18:
            if (this.firstRenderCount == r101.firstRenderCount) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.firstPageSize * 31) + this.pageSize) * 31) + this.prefetchDistance) * 31) + this.firstRenderCount;
        }

        public final String toString() {
            return "PageSizeConfig(firstPageSize=" + this.firstPageSize + ", pageSize=" + this.pageSize + ", prefetchDistance=" + this.prefetchDistance + ", firstRenderCount=" + this.firstRenderCount + ')';
        }

        public a() {
            this(20, 20, 10, 8);
        }

        public final int a() {
            return this.firstPageSize;
        }

        public final int b() {
            return this.firstRenderCount;
        }

        public final int c() {
            return this.pageSize;
        }

        public final int d() {
            return this.prefetchDistance;
        }

        public a(int r100, int r101, int r102, int r103) {
            this.firstPageSize = r100;
            this.pageSize = r101;
            this.prefetchDistance = r102;
            this.firstRenderCount = r103;
        }
    }

    static {
        f259507a = new a(14, 18, 9, 8);
    }

    @JvmStatic
    public static final a a() {
        a r100 = f259507a;
        if (LiveLifeSaaSUtil.y().containsKey("locallife_shelf_paging_config") == false) goto L12;
        Object r101 = LiveLifeSaaSUtil.y().get("locallife_shelf_paging_config");     // Catch: Throwable -> L18
        if (r101 != null) goto L9;
        Object r102 = null;
    L13:
        a r103 = (a) r102;     // Catch: Throwable -> L18
        if (r103 != null) goto L17;
        return r100;
    L17:
        return r103;
    L9:
        if ((r101 instanceof a) == true) goto L11;
        r102 = LiveLifeSaaSUtil.a("locallife_shelf_paging_config", a.class, r100);     // Catch: Throwable -> L18
        goto L13
    L11:
        r102 = (a) r101;     // Catch: Throwable -> L18
        goto L13
    L12:
        r102 = LiveLifeSaaSUtil.a("locallife_shelf_paging_config", a.class, r100);     // Catch: Throwable -> L18
    L22:
        return r100;
    }
}
