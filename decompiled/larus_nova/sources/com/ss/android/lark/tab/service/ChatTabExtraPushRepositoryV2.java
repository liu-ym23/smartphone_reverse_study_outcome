package com.ss.android.lark.tab.service;

import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.bytedance.lark.pb.im.v1.PushChatPinCountResponse;
import com.ss.android.lark.chat.service.impl.y0;
import com.ss.android.lark.passportc.dwarf.UserScope;
import io.reactivex.disposables.Disposable;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@UserScope
public final class ChatTabExtraPushRepositoryV2 implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f441121a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.lark.rustclient.api.l f441122b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Disposable f441123c;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.tab.service.j
    public final void b() {
        Disposable r100 = this.f441123c;
        if (r100 == null) goto L6;
        r100.dispose();
        return;
    }

    @Inject
    public ChatTabExtraPushRepositoryV2(String r100, com.bytedance.lark.rustclient.api.l r101) {
        Intrinsics.checkNotNullParameter(r100, "currentUserId");
        Intrinsics.checkNotNullParameter(r101, "userClient");
        this.f441121a = r100;
        this.f441122b = r101;
    }

    @Override // com.ss.android.lark.tab.service.j
    public final void a(final Function1<? super PushChatPinCountResponse, Unit> r100, final Function1<? super Throwable, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "onReceive");
        Intrinsics.checkNotNullParameter(r101, LynxVideoManagerLite.EVENT_ON_ERROR);
        this.f441123c = y0.a("ChatTabExtraPushRepositoryV2", this.f441121a, new ChatTabExtraPushRepositoryV2$subscribeChatPinCountPush$1(this, r100, r101));
    }
}
