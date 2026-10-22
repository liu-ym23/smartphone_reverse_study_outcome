package com.bytedance.jedi.ext.adapter.decorator.internal;

import android.view.ViewGroup;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lkotlin/Function1;", "Landroid/view/ViewGroup;", "Lcom/bytedance/jedi/ext/adapter/decorator/internal/DefaultAutoLoadingView;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
final class LoadingDelegate$defaultLoading$2 extends Lambda implements Function0<Function1<? super ViewGroup, ? extends DefaultAutoLoadingView>> {
    final /* synthetic */ d this$0;

    public LoadingDelegate$defaultLoading$2(d r100) {
        this.this$0 = r100;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Function1<? super ViewGroup, ? extends DefaultAutoLoadingView> invoke2() {
        return new AnonymousClass1(this);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Function1<? super ViewGroup, ? extends DefaultAutoLoadingView> invoke() {
        return invoke2();
    }
}
