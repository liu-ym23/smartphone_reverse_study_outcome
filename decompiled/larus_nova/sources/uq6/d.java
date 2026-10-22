package uq6;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u001c\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR$\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR$\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR$\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\b¨\u0006\u001e"}, d2 = {"Luq6/d;", "", "", "pageParseStartTs", "Ljava/lang/Long;", "d", "()Ljava/lang/Long;", "setPageParseStartTs", "(Ljava/lang/Long;)V", "pageParseBuildTreeTs", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "f", "pageParseBuildTreeCost", "getPageParseBuildTreeCost", "e", "pageParseMergeTreeTs", "c", ce.f26395j, "pageMergeTreeCost", "getPageMergeTreeCost", "setPageMergeTreeCost", "pageParseCreateModelCost", "getPageParseCreateModelCost", "h", "pageParseCreateModelTs", "b", RXScreenCaptureService.KEY_INDEX, "pageParseCost", "getPageParseCost", ce.f26391f, "dito-performance-saas_release"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName("page_parse_merge_tree_cost")
    private Long pageMergeTreeCost;

    @SerializedName("page_parse_build_tree_cost")
    private Long pageParseBuildTreeCost;

    @SerializedName("page_parse_build_tree_ts")
    private Long pageParseBuildTreeTs;

    @SerializedName("page_parse_cost")
    private Long pageParseCost;

    @SerializedName("page_parse_create_model_cost")
    private Long pageParseCreateModelCost;

    @SerializedName("page_parse_create_model_ts")
    private Long pageParseCreateModelTs;

    @SerializedName("page_parse_merge_tree_ts")
    private Long pageParseMergeTreeTs;

    @SerializedName("page_parse_start_ts")
    private Long pageParseStartTs;

    public d() {
        this(0);
    }

    public final Long a() {
        return this.pageParseBuildTreeTs;
    }

    public final Long b() {
        return this.pageParseCreateModelTs;
    }

    public final Long c() {
        return this.pageParseMergeTreeTs;
    }

    public final Long d() {
        return this.pageParseStartTs;
    }

    public /* synthetic */ d(int r100) {
        this(Long.valueOf(System.currentTimeMillis()));
    }

    public final void e(Long r100) {
        this.pageParseBuildTreeCost = r100;
    }

    public final void f(Long r100) {
        this.pageParseBuildTreeTs = r100;
    }

    public final void g(Long r100) {
        this.pageParseCost = r100;
    }

    public final void h(Long r100) {
        this.pageParseCreateModelCost = r100;
    }

    public final void i(Long r100) {
        this.pageParseCreateModelTs = r100;
    }

    public final void j(Long r100) {
        this.pageParseMergeTreeTs = r100;
    }

    public d(Long r100) {
        this.pageParseStartTs = r100;
    }
}
