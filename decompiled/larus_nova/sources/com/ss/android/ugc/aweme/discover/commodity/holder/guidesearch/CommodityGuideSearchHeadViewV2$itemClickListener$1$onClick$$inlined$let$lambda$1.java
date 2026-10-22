package com.ss.android.ugc.aweme.discover.commodity.holder.guidesearch;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.ugc.aweme.discover.model.ECGuideSearchWord;
import com.ss.android.ugc.aweme.search.common.utils.SearchIDManager;
import com.ss.android.ugc.aweme.search.model.SearchEnterParam;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\n¢\u0006\u0002\b\u0006¨\u0006\u0007"}, d2 = {"<anonymous>", "", "it", "", "", "", AbsMethodDelegate.TAG_INVOKE, "com/ss/android/ugc/aweme/discover/commodity/holder/guidesearch/CommodityGuideSearchHeadViewV2$itemClickListener$1$onClick$4$1"}, k = 3, mv = {1, 4, 3})
final class CommodityGuideSearchHeadViewV2$itemClickListener$1$onClick$$inlined$let$lambda$1 extends Lambda implements Function1<Map<String, Object>, Unit> {
    final /* synthetic */ ECGuideSearchWord $guideSearchWord$inlined;
    final /* synthetic */ SearchEnterParam $newSearchEnterParam$inlined;

    public CommodityGuideSearchHeadViewV2$itemClickListener$1$onClick$$inlined$let$lambda$1(SearchEnterParam r100, ECGuideSearchWord r101) {
        this.$newSearchEnterParam$inlined = r100;
        this.$guideSearchWord$inlined = r101;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Map<String, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        String r101 = this.$guideSearchWord$inlined.getId();
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        r100.put("recommend_word_id", r101);
        r100.put("recommend_word_session_id", SearchIDManager.a(SearchIDManager.f452276g));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Map<String, Object> r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
