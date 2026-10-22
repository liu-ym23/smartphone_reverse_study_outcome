package com.suite.lark.platform.component.widget_biz_dinghelper.helper.view;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
public final class CardListViewWrapper$cardListFrame$2$1$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Ref.ObjectRef<a> $interactFeature;

    public CardListViewWrapper$cardListFrame$2$1$2(Ref.ObjectRef<a> r100) {
        this.$interactFeature = r100;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        a r100 = this.$interactFeature.element;
        if (r100 == null) goto L5;
        r100.getClass();
        r100.getClass();
    L5:
        this.$interactFeature.element = null;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
