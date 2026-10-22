package com.larus.bmhome.setting;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.larus.ui.arch.modulizer.di.ContainerFilter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J;\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0017\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f¢\u0006\u0002\b\u0012H\u0016J\u0084\u0001\u0010\u0013\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u000b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0017\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f¢\u0006\u0002\b\u0012H\u0016¢\u0006\u0002\u0010\u001dJ\b\u0010\u001e\u001a\u00020\u0005H\u0016J\u0010\u0010\u001f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006 "}, d2 = {"Lcom/larus/bmhome/setting/FragmentProviderNoop;", "Lcom/larus/bmhome/setting/IFragmentProvider;", "<init>", "()V", "createChatImmersFragment", "Landroidx/fragment/app/Fragment;", "createConversationFragment", "createFlowSdkChatFragment", "chatBundle", "Landroid/os/Bundle;", "getBottomTabHeight", "", "chatListener", "Lcom/larus/bmhome/chat/event/OnChatChangedListener;", "initContainerData", "Lkotlin/Function1;", "Lcom/larus/ui/arch/component/external/api/receiver/Container;", "", "Lkotlin/ExtensionFunctionType;", "createChatFragment", "hasBottomTab", "", "enableChatWithTab", "addBotListener", "Lcom/larus/bmhome/chat/event/OnAddBotChangedListener;", "chatTabInterceptor", "overrideLayout", "overrideContainer", "Lcom/larus/ui/arch/modulizer/di/ContainerFilter;", "(Landroid/os/Bundle;ZZILcom/larus/bmhome/chat/event/OnAddBotChangedListener;Lcom/larus/bmhome/chat/event/OnChatChangedListener;Lkotlin/jvm/functions/Function1;Ljava/lang/Integer;Lcom/larus/ui/arch/modulizer/di/ContainerFilter;Lkotlin/jvm/functions/Function1;)Landroidx/fragment/app/Fragment;", "createTemplateFragment", "createOWindowChatFragment", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FragmentProviderNoop implements IFragmentProvider {
    public FragmentProviderNoop() {
    }

    @Override // com.larus.bmhome.setting.IFragmentProvider
    public final Fragment b() {
        return new Fragment();
    }

    @Override // com.larus.bmhome.setting.IFragmentProvider
    public final Fragment c() {
        return new Fragment();
    }

    @Override // com.larus.bmhome.setting.IFragmentProvider
    public final Fragment e(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "chatBundle");
        return new Fragment();
    }

    @Override // com.larus.bmhome.setting.IFragmentProvider
    public final Fragment a(Bundle r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "chatBundle");
        Intrinsics.checkNotNullParameter(r101, "initContainerData");
        return new Fragment();
    }

    @Override // com.larus.bmhome.setting.IFragmentProvider
    public final Fragment d(Bundle r100, boolean r101, int r102, Integer r103, ContainerFilter r104, Function1 r105) {
        Intrinsics.checkNotNullParameter(r100, "chatBundle");
        Intrinsics.checkNotNullParameter(r105, "initContainerData");
        return new Fragment();
    }
}
