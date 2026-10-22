package jd3;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class j extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Set<Long> f498348p = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f498349a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f498350b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f498351c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f498352d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f498353e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f498354f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f498355g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f498356h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f498357i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f498358j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f498359k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f498360l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f498361m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f498362n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f498363o;

    public static final class a {
    }

    static {
        f498348p = new LinkedHashSet();
    }

    public j() {
        super("comment_card_duration");
        this.f498349a = "";
        this.f498350b = "";
        this.f498351c = "";
        this.f498352d = "";
        this.f498353e = "";
        this.f498354f = "";
        this.f498355g = "";
        this.f498356h = "";
        this.f498357i = "";
        this.f498358j = "";
        this.f498359k = "0";
        this.f498360l = "";
        this.f498361m = "";
        this.f498362n = "";
        this.f498363o = "";
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r100 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam("page_name", com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_DETAIL, r100);
        appendParam("source_page", com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_DETAIL, r100);
        appendParam("enter_method", this.f498351c, r100);
        appendParam("author_id", this.f498349a, r100);
        appendParam("group_id", this.f498350b, r100);
        appendParam("follow_status", this.f498352d, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_ID, this.f498353e, r100);
        appendParam("product_id", this.f498354f, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_TYPE, this.f498355g, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_CARRIER_SOURCE, this.f498356h, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_SOURCE_METHOD, this.f498357i, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, this.f498358j, r100);
        appendParam("duration", this.f498359k, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMENT_ENTRANCE, this.f498360l, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMENT_TAG, this.f498361m, r100);
        appendParam("search_id", this.f498362n, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMENT_MODULE, this.f498363o, r100);
        Set<Long> r101 = f498348p;
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMENT_SHOW_LIST, CollectionsKt.toList(r101).toString(), r100);
        r101.clear();
    }
}
