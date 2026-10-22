package com.larus.bmhome.chat.api.sidebar;

import androidx.lifecycle.LifecycleOwner;
import com.larus.home.impl.main.side_bar.view.SideBarConversationIconSessionImpl;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0018\u0010\u0006\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0004\u0012\u00020\n0\u0007H&¨\u0006\u000b"}, d2 = {"Lcom/larus/bmhome/chat/api/sidebar/ISideBarConversationIconService;", "", "createSession", "Lcom/larus/bmhome/chat/api/sidebar/SideBarConversationIconSession;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "onIconsChanged", "Lkotlin/Function1;", "", "", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ISideBarConversationIconService {
    SideBarConversationIconSessionImpl a(LifecycleOwner r100, Function1 r101);
}
