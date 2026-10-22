package com.ss.android.ugc.aweme.discover.commodity.holder.guidesearch;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/ss/android/ugc/aweme/discover/commodity/holder/guidesearch/GSBackGroundViewGradientContext;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class CommodityGuideSearchHeadViewV4$bindData$10 extends Lambda implements Function1<GSBackGroundViewGradientContext, GSBackGroundViewGradientContext> {
    final /* synthetic */ Ref.ObjectRef $bottomBgEndColor;
    final /* synthetic */ Ref.ObjectRef $bottomBgStartColor;

    public CommodityGuideSearchHeadViewV4$bindData$10(Ref.ObjectRef r100, Ref.ObjectRef r101) {
        this.$bottomBgStartColor = r100;
        this.$bottomBgEndColor = r101;
        super(1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final GSBackGroundViewGradientContext invoke2(GSBackGroundViewGradientContext r110) {
        Intrinsics.checkNotNullParameter(r110, "$receiver");
        return GSBackGroundViewGradientContext.a(r110, ColorProtector.parseColor((String) this.$bottomBgStartColor.element), ColorProtector.parseColor((String) this.$bottomBgEndColor.element), 0.4735f, 0.069f, 0.4708f, 0.376f, 0, 0, 192);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ GSBackGroundViewGradientContext invoke(GSBackGroundViewGradientContext r100) {
        return invoke2(r100);
    }
}
