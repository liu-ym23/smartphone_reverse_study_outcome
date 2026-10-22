package com.ss.android.lark.chat.preview.memberlist;

import androidx.lifecycle.ViewModelProvider;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larksuite.arch.jack.JackViewModelFactory;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", AbsMethodDelegate.TAG_INVOKE, "com/larksuite/arch/jack/ExtensionsKt$viewModel$5"}, k = 3, mv = {2, 1, 0}, xi = 48)
public final class MemberListFragment$special$$inlined$viewModel$default$4 extends Lambda implements Function0<ViewModelProvider.Factory> {
    public static final MemberListFragment$special$$inlined$viewModel$default$4 INSTANCE = null;

    static {
        INSTANCE = new MemberListFragment$special$$inlined$viewModel$default$4();
    }

    public MemberListFragment$special$$inlined$viewModel$default$4() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ViewModelProvider.Factory invoke() {
        return new JackViewModelFactory();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ViewModelProvider.Factory invoke() {
        return invoke();
    }
}
