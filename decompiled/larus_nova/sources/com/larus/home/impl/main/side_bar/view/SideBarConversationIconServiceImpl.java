package com.larus.home.impl.main.side_bar.view;

import androidx.lifecycle.LifecycleOwner;
import com.larus.bmhome.chat.api.sidebar.ISideBarConversationIconService;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0018\u0010\b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0004\u0012\u00020\f0\tH\u0016¨\u0006\r"}, d2 = {"Lcom/larus/home/impl/main/side_bar/view/SideBarConversationIconServiceImpl;", "Lcom/larus/bmhome/chat/api/sidebar/ISideBarConversationIconService;", "<init>", "()V", "createSession", "Lcom/larus/bmhome/chat/api/sidebar/SideBarConversationIconSession;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "onIconsChanged", "Lkotlin/Function1;", "", "", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SideBarConversationIconServiceImpl implements ISideBarConversationIconService {
    public SideBarConversationIconServiceImpl() {
    }

    @Override // com.larus.bmhome.chat.api.sidebar.ISideBarConversationIconService
    public final SideBarConversationIconSessionImpl a(LifecycleOwner r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r101, "onIconsChanged");
        return new SideBarConversationIconSessionImpl(r100, r101);
    }
}
