package com.bytedance.ee.android.file.picker.lib.v2.ui;

import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", AbsMethodDelegate.TAG_INVOKE, "com/larksuite/arch/jack/ExtensionsKt$viewModel$4"}, k = 3, mv = {2, 1, 0}, xi = 48)
public final class ConfirmActivity$special$$inlined$viewModel$default$4 extends Lambda implements Function0<ViewModelProvider.Factory> {
    final /* synthetic */ ViewModelStoreOwner $this_viewModel;

    public ConfirmActivity$special$$inlined$viewModel$default$4(ViewModelStoreOwner r100) {
        this.$this_viewModel = r100;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ViewModelProvider.Factory invoke() {
        return ((HasDefaultViewModelProviderFactory) this.$this_viewModel).getDefaultViewModelProviderFactory();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ViewModelProvider.Factory invoke() {
        return invoke();
    }
}
