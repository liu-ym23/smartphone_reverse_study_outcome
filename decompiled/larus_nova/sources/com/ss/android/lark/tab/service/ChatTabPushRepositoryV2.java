package com.ss.android.lark.tab.service;

import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.bytedance.lark.pb.im.v1.PushChatTabs;
import com.ss.android.lark.chat.service.impl.y0;
import com.ss.android.lark.passportc.dwarf.UserScope;
import io.reactivex.disposables.Disposable;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@UserScope
public final class ChatTabPushRepositoryV2 implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f441135a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.lark.rustclient.api.l f441136b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Disposable f441137c;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.tab.service.n
    public final void a() {
        Disposable r100 = this.f441137c;
        if (r100 == null) goto L6;
        r100.dispose();
        return;
    }

    @Inject
    public ChatTabPushRepositoryV2(String r100, com.bytedance.lark.rustclient.api.l r101) {
        Intrinsics.checkNotNullParameter(r100, "currentUserId");
        Intrinsics.checkNotNullParameter(r101, "userClient");
        this.f441135a = r100;
        this.f441136b = r101;
    }

    @Override // com.ss.android.lark.tab.service.n
    public final void b(final Function1<? super PushChatTabs, Unit> r100, final Function1<? super Throwable, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "onReceive");
        Intrinsics.checkNotNullParameter(r101, LynxVideoManagerLite.EVENT_ON_ERROR);
        this.f441137c = y0.a("ChatTabPushRepositoryV2", this.f441135a, new ChatTabPushRepositoryV2$subscribeChatTabsPush$1(this, r100, r101));
    }
}
