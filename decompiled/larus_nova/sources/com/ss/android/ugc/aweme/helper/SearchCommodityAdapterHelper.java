package com.ss.android.ugc.aweme.helper;

import com.ss.android.ugc.aweme.discover.model.SearchAggregateCommodity;
import com.ss.android.ugc.aweme.discover.model.SearchCommodityDynamicPatch;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/aweme/helper/SearchCommodityAdapterHelper;", "", "<init>", "()V", "Companion", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SearchCommodityAdapterHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Integer> f450868a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f450869b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f450870c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/ss/android/ugc/aweme/helper/SearchCommodityAdapterHelper$Companion;", "", "()V", "BASIC_VIEW_TYPE_SEGMENT_DOUBLE", "", "BASIC_VIEW_TYPE_SEGMENT_SINGLE", "TYPE_LYNX_DOUBLE", "TYPE_LYNX_SINGLE", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    static {
        new Companion(0);
    }

    public SearchCommodityAdapterHelper() {
        this.f450868a = new LinkedHashMap();
    }

    public final int a(SearchAggregateCommodity r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "struct");
        String r102 = "";
        String r103 = null;
        if (r101 == false) goto L10;
        SearchCommodityDynamicPatch r104 = r100.getDynamicPatch();
        if (r104 == null) goto L7;
        String r105 = r104.getWaterfallLayoutSchema();
    L8:
        if (r105 != null) goto L17;
    L9:
        r105 = "";
    L17:
        if (r105.length() != 0) goto L19;
        boolean r106 = true;
    L20:
        if (r106 == false) goto L29;
        SearchCommodityDynamicPatch r107 = r100.getDynamicPatch();
        if (r107 == null) goto L24;
        r103 = r107.schema;
    L24:
        if (r103 == null) goto L27;
        r102 = r103;
    L27:
        r105 = r102;
    L29:
        if (((LinkedHashMap) this.f450868a).get(r105) != null) goto L44;
        Integer r108 = r100.getShowFormat();
        if (r108 != null) goto L34;
    L36:
        Integer r109 = r100.getShowFormat();
        if (r109 == null) goto L44;
        if (r109.intValue() != 2) goto L44;
        if (r101 == false) goto L43;
        Map<String, Integer> r110 = this.f450868a;
        int r111 = this.f450869b + 1;
        this.f450869b = r111;
        r110.put(r105, Integer.valueOf(r111 + 16777216));
        goto L44
    L43:
        Map<String, Integer> r112 = this.f450868a;
        int r113 = this.f450870c + 1;
        this.f450870c = r113;
        r112.put(r105, Integer.valueOf(r113 + 33554432));
        goto L44
    L34:
        if (r108.intValue() != 1) goto L36;
        Map<String, Integer> r114 = this.f450868a;
        int r115 = this.f450870c + 1;
        this.f450870c = r115;
        r114.put(r105, Integer.valueOf(r115 + 33554432));
    L44:
        Integer r116 = (Integer) ((LinkedHashMap) this.f450868a).get(r105);
        if (r116 != null) goto L49;
        return TTVideoEngineInterface.PLAYER_OPTION_GSKEY_AUDIOTRACK_POOL_SIZE;
    L49:
        return r116.intValue();
    L19:
        r106 = false;
        goto L20
    L7:
        r105 = null;
        goto L8
    L10:
        SearchCommodityDynamicPatch r117 = r100.getDynamicPatch();
        if (r117 == null) goto L13;
        r105 = r117.getWaterfallLayoutSchemaSingle();
    L14:
        if (r105 != null) goto L17;
    L13:
        r105 = null;
        goto L14
    }
}
