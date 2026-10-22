package com.bytedance.jedi.ext.adapter.decorator;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.jedi.ext.adapter.decorator.internal.HeaderHolder;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/bytedance/jedi/ext/adapter/decorator/internal/HeaderHolder;", "<anonymous parameter 0>", "Landroid/view/ViewGroup;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
final class RawAdapterDecorator$setHeaderView$1$1 extends Lambda implements Function1<ViewGroup, HeaderHolder> {
    final /* synthetic */ View $it;

    public RawAdapterDecorator$setHeaderView$1$1(View r100) {
        this.$it = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final HeaderHolder invoke2(ViewGroup r100) {
        return new HeaderHolder(this.$it);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ HeaderHolder invoke(ViewGroup r100) {
        return invoke2(r100);
    }
}
