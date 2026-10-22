package com.larus.bmhome.setting;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.larus.ui.arch.modulizer.di.ContainerFilter;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0085\u0001\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0017\u0010\u0017\u001a\u0013\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\u0002\b\u0019H\u0096\u0001¢\u0006\u0002\u0010\u001aJ\t\u0010\u001b\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u001c\u001a\u00020\u0005H\u0096\u0001J<\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0017\u0010\u0017\u001a\u0013\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\u0002\b\u0019H\u0096\u0001J\u0011\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\t\u0010\u001f\u001a\u00020\u0005H\u0096\u0001¨\u0006 "}, d2 = {"Lcom/larus/bmhome/setting/FragmentProvider;", "Lcom/larus/bmhome/setting/IFragmentProvider;", "<init>", "()V", "createChatFragment", "Landroidx/fragment/app/Fragment;", "chatBundle", "Landroid/os/Bundle;", "hasBottomTab", "", "enableChatWithTab", "getBottomTabHeight", "", "addBotListener", "Lcom/larus/bmhome/chat/event/OnAddBotChangedListener;", "chatListener", "Lcom/larus/bmhome/chat/event/OnChatChangedListener;", "chatTabInterceptor", "Lkotlin/Function1;", "", "overrideLayout", "overrideContainer", "Lcom/larus/ui/arch/modulizer/di/ContainerFilter;", "initContainerData", "Lcom/larus/ui/arch/component/external/api/receiver/Container;", "Lkotlin/ExtensionFunctionType;", "(Landroid/os/Bundle;ZZILcom/larus/bmhome/chat/event/OnAddBotChangedListener;Lcom/larus/bmhome/chat/event/OnChatChangedListener;Lkotlin/jvm/functions/Function1;Ljava/lang/Integer;Lcom/larus/ui/arch/modulizer/di/ContainerFilter;Lkotlin/jvm/functions/Function1;)Landroidx/fragment/app/Fragment;", "createChatImmersFragment", "createConversationFragment", "createFlowSdkChatFragment", "createOWindowChatFragment", "createTemplateFragment", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FragmentProvider implements IFragmentProvider {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final FragmentProvider f313806b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IFragmentProvider f313807a;

    static {
        f313806b = new FragmentProvider();
    }

    @Override // com.larus.bmhome.setting.IFragmentProvider
    public final Fragment a(Bundle r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "chatBundle");
        Intrinsics.checkNotNullParameter(r101, "initContainerData");
        return this.f313807a.a(r100, r101);
    }

    @Override // com.larus.bmhome.setting.IFragmentProvider
    public final Fragment b() {
        return this.f313807a.b();
    }

    @Override // com.larus.bmhome.setting.IFragmentProvider
    public final Fragment c() {
        return this.f313807a.c();
    }

    @Override // com.larus.bmhome.setting.IFragmentProvider
    public final Fragment d(Bundle r100, boolean r110, int r111, Integer r112, ContainerFilter r113, Function1 r114) {
        Intrinsics.checkNotNullParameter(r100, "chatBundle");
        Intrinsics.checkNotNullParameter(r114, "initContainerData");
        return this.f313807a.d(r100, r110, r111, r112, r113, r114);
    }

    @Override // com.larus.bmhome.setting.IFragmentProvider
    public final Fragment e(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "chatBundle");
        return this.f313807a.e(r100);
    }

    private FragmentProvider() {
        IFragmentProvider r100 = (IFragmentProvider) ServiceManager.get().getService(IFragmentProvider.class);
        if (r100 != null) goto L5;
        r100 = new FragmentProviderNoop();
    L5:
        this.f313807a = r100;
    }
}
