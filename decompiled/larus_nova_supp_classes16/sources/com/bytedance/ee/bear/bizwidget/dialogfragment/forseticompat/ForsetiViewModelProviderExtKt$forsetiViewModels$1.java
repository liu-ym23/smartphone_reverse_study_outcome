package com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = 176)
public final class ForsetiViewModelProviderExtKt$forsetiViewModels$1 extends Lambda implements Function0<ViewModelProvider> {
    final /* synthetic */ Function0<ViewModelProvider.Factory> $factoryProducer;
    final /* synthetic */ FragmentActivity $this_forsetiViewModels;

    public ForsetiViewModelProviderExtKt$forsetiViewModels$1(Function0<? extends ViewModelProvider.Factory> r1, FragmentActivity r2) {
        this.$factoryProducer = r1;
        this.$this_forsetiViewModels = r2;
        super(0);
    }

    public final ViewModelProvider invoke() {
        Function0<ViewModelProvider.Factory> r0 = this.$factoryProducer;
        if (r0 == null) goto L5;
        ViewModelProvider.Factory r1 = (ViewModelProvider.Factory) r0.invoke();
    L6:
        if (r1 != null) goto L10;
        ViewModelProvider.NewInstanceFactory r2 = ForsetiViewModelProvider.c;
        return ForsetiViewModelProvider.a.a(this.$this_forsetiViewModels);
    L10:
        return new ForsetiViewModelProvider(this.$this_forsetiViewModels, r1);
    L5:
        r1 = null;
        goto L6
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m91invoke() {
        return invoke();
    }
}
