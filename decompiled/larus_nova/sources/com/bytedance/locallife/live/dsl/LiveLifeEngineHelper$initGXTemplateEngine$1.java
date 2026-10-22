package com.bytedance.locallife.live.dsl;

import com.alibaba.gaiax.api.IGXTemplateEngine;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/alibaba/gaiax/api/IGXTemplateEngine;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3}, xi = 48)
final class LiveLifeEngineHelper$initGXTemplateEngine$1 extends Lambda implements Function1<IGXTemplateEngine, Unit> {
    final /* synthetic */ a this$0;

    public LiveLifeEngineHelper$initGXTemplateEngine$1(a r100) {
        this.this$0 = r100;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(IGXTemplateEngine r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(IGXTemplateEngine r100) {
        this.this$0.f259418a = r100;
    }
}
