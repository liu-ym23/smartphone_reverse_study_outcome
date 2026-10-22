package com.ss.android.ugc.aweme.discover.commodity.holder.guidesearch;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.ss.android.ugc.aweme.search.utils.DimensUtilKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/ss/android/ugc/aweme/discover/commodity/holder/guidesearch/GSBackGroundViewOutLineContext;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class CommodityGuideSearchHeadViewV4$bindData$8 extends Lambda implements Function1<GSBackGroundViewOutLineContext, GSBackGroundViewOutLineContext> {
    final /* synthetic */ String $borderColor;
    final /* synthetic */ CommodityGuideSearchHeadViewV4 this$0;

    public CommodityGuideSearchHeadViewV4$bindData$8(CommodityGuideSearchHeadViewV4 r100, String r101) {
        this.this$0 = r100;
        this.$borderColor = r101;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final GSBackGroundViewOutLineContext invoke2(GSBackGroundViewOutLineContext r100) {
        Intrinsics.checkNotNullParameter(r100, "$receiver");
        float r101 = this.this$0.f450167k;
        float r102 = DimensUtilKt.a(1);
        int r103 = ColorProtector.parseColor(this.$borderColor);
        r100.getClass();
        return new GSBackGroundViewOutLineContext(r103, r102, r101);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ GSBackGroundViewOutLineContext invoke(GSBackGroundViewOutLineContext r100) {
        return invoke2(r100);
    }
}
