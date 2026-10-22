package com.ss.android.ugc.aweme.search.common.tab;

import com.ss.android.ugc.aweme.ec.search.common.UrlModel;
import com.ss.android.ugc.aweme.framework.tab.TabFeedModel;
import com.ss.android.ugc.aweme.search.common.base.log.Logger;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/tab/ECCommodityTabSource;", "Lcom/ss/android/ugc/aweme/search/common/tab/ECTabSource;", "<init>", "()V", "Companion", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECCommodityTabSource extends ECTabSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f452184a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f452185b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f452186c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f452187d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f452188e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Companion f452189f = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/tab/ECCommodityTabSource$Companion;", "", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    static {
        f452189f = new Companion(0);
        f452188e = "ECCommodityTabSource_hcx";
    }

    @Override // com.ss.android.ugc.aweme.search.common.tab.ECTabSource
    public final List<TabFeedModel> a() {
        ArrayList r100 = new ArrayList();
        if (f452187d == false) goto L5;
        TabFeedModel r101 = new TabFeedModel("ecom_ai_search", "搜", 130);
        UrlModel r102 = new UrlModel();
        r102.setUrlList(CollectionsKt.mutableListOf(new String[]{"https://p3-ecom-search.byteimg.com/tos-cn-i-nwfy1fis1k/513eef89cc3d20e8ca364ec1ffe621e2.jpg~tplv-nwfy1fis1k-image.image"}));
        r102.setWidth(14);
        r102.setHeight(12);
        Unit r103 = Unit.INSTANCE;
        r101.prefixIcon = r102;
        r100.add(r101);
    L5:
        r100.addAll(CollectionsKt.mutableListOf(new TabFeedModel[]{new TabFeedModel("goods", "全部", 8), new TabFeedModel("ecom_live", "直播", 17), new TabFeedModel("shop", "店铺", 13)}));
        if (f452184a == false) goto L9;
        r100.add(new TabFeedModel("ecom_content", "种草", 21));
    L9:
        if (f452185b == false) goto L12;
        r100.add(new TabFeedModel("ecom_instant", "小时达", 23));
    L12:
        if (f452186c == false) goto L14;
        r100.add(new TabFeedModel("spu_ranking_list", "榜单", 110));
    L14:
        Logger.a(f452188e, "ECCommodityTabSource getDefaultTabs = " + r100);
        return r100;
    }

    @Override // com.ss.android.ugc.aweme.search.common.tab.ECTabSource
    public final List<TabFeedModel> b() {
        return a();
    }

    public ECCommodityTabSource() {
    }
}
