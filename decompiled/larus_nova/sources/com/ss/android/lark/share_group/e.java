package com.ss.android.lark.share_group;

import com.larksuite.framework.mvp.IModel;
import com.ss.android.lark.chat.api.service.impl.ChatService;
import com.ss.android.lark.dto.group.GroupRecallEntity;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public final class e implements IModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f440526a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ChatService f440527b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f440528a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<GroupRecallEntity> f440529b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f440530c;

        public a(String r100, List<GroupRecallEntity> r101, boolean r102) {
            this.f440528a = r100;
            this.f440529b = r101;
            this.f440530c = r102;
        }
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void create() {
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
    }

    public e(a r100) {
        this.f440527b = ChatService.c.f411535a;
        this.f440526a = r100;
    }
}
