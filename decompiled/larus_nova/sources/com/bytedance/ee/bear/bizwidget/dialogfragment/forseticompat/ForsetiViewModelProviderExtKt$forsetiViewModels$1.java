package com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 176)
public final class ForsetiViewModelProviderExtKt$forsetiViewModels$1 extends Lambda implements Function0<ViewModelProvider> {
    final /* synthetic */ Function0<ViewModelProvider.Factory> $factoryProducer;
    final /* synthetic */ FragmentActivity $this_forsetiViewModels;

    /* JADX WARN: Multi-variable type inference failed */
    public ForsetiViewModelProviderExtKt$forsetiViewModels$1(Function0<? extends ViewModelProvider.Factory> r100, FragmentActivity r101) {
        this.$factoryProducer = r100;
        this.$this_forsetiViewModels = r101;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ViewModelProvider invoke() {
        Function0<ViewModelProvider.Factory> r100 = this.$factoryProducer;
        if (r100 == null) goto L5;
        ViewModelProvider.Factory r101 = r100.invoke();
    L6:
        if (r101 != null) goto L10;
        ViewModelProvider.NewInstanceFactory r102 = ForsetiViewModelProvider.f216459c;
        return ForsetiViewModelProvider.a.a(this.$this_forsetiViewModels);
    L10:
        return new ForsetiViewModelProvider(this.$this_forsetiViewModels, r101);
    L5:
        r101 = null;
        goto L6
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ViewModelProvider invoke() {
        return invoke();
    }
}
