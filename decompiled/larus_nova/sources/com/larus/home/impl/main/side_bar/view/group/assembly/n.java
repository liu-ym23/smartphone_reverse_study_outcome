package com.larus.home.impl.main.side_bar.view.group.assembly;

import ac9.c0;
import com.larus.home.impl.main.side_bar.data.SideBarConfigModel;
import com.larus.home.impl.main.side_bar.view.SideBarContentFragment;
import com.larus.home.impl.main.side_bar.view.group.datasource.GroupSortPolicy;
import com.larus.home.impl.main.side_bar.view.group.policy.ConversationArchiveFilter;
import com.larus.home.impl.main.side_bar.view.group.policy.ConversationGroupPolicy;
import com.larus.home.impl.main.side_bar.view.group.render.o0;
import com.larus.home.impl.main.side_bar.view.project.SideBarProjectActionHandler;

/* JADX INFO: loaded from: classes29.dex */
public interface n {
    com.larus.home.impl.main.side_bar.view.group.datasource.lark.u a();

    void b(ConversationGroupPolicy r100);

    SideBarProjectActionHandler c();

    c0 d();

    void e(boolean r100);

    SideBarContentFragment f();

    SideBarContentFragment g();

    SideBarContentFragment getFragment();

    SideBarConfigModel h();

    o0 i();

    GroupController j();

    void k(GroupSortPolicy r100);

    void l(ConversationArchiveFilter r100);
}
