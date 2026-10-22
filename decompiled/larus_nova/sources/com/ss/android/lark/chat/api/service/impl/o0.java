package com.ss.android.lark.chat.api.service.impl;

import com.bytedance.lark.pb.im.v1.SubscribeChatEventRequest;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.ss.android.lark.biz.im.api.ImageHistoryResponse;
import com.ss.android.lark.chat.api.service.IChatService;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.name.ChatNameRenderer$doHideTranslate$1;
import com.ss.android.lark.chat.name.ChatNameRenderer$doTranslate$1;
import com.ss.android.lark.dto.group.GroupRecallEntity;
import com.ss.android.lark.integrator.im.impl.IIMApiImpl;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.entity.UserSession;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class o0 extends c0c.b implements IChatService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IChatService f411620b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.ss.android.lark.passportc.internal.v f411621c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<IChatService> f411622d;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.chat.api.service.IChatService
    public final void Ac(String r100, UIGetDataCallback r101) {
        Intrinsics.checkNotNullParameter(r100, "chatId");
        this.f411620b.Ac(r100, r101);
    }

    @Override // com.ss.android.lark.chat.api.service.IChatService
    public final void Dc(String r100, Iterable r101, Iterable r102, IGetDataCallback r103) {
        this.f411620b.Dc(r100, r101, r102, r103);
    }

    @Override // com.ss.android.lark.chat.api.service.IChatService
    public final com.ss.android.lark.chat.entity.chat.b I0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "chatId");
        return this.f411620b.I0(r100);
    }

    @Override // com.ss.android.lark.chat.api.service.IChatService
    public final void L9(String r100, String r101, IIMApiImpl.AnonymousClass1 r102) {
        Intrinsics.checkNotNullParameter(r102, "callback");
        this.f411620b.L9(r100, r101, r102);
    }

    @Override // com.ss.android.lark.chat.api.service.IChatService
    public final ccb.d M2(String r100, String r101, String r102, boolean r103) {
        return this.f411620b.M2(r100, r101, r102, r103);
    }

    @Override // com.ss.android.lark.chat.api.service.IChatService
    public final ImageHistoryResponse Ne(String r100, String r101, ImageHistoryResponse.Direction r102, int r103) {
        return this.f411620b.Ne(r100, r101, r102, r103);
    }

    @Override // com.ss.android.lark.chat.api.service.IChatService
    public final void U6(String r100, IGetDataCallback<Boolean> r101) {
        this.f411620b.U6(r100, r101);
    }

    @Override // com.ss.android.lark.chat.api.service.IChatService
    public final boolean checkLoginUserExistedInLocalChat(Chat r100) {
        return this.f411620b.checkLoginUserExistedInLocalChat(r100);
    }

    @Override // com.ss.android.lark.chat.api.service.IChatService
    public final void f2(List<GroupRecallEntity> r100, String r101, IGetDataCallback<List<GroupRecallEntity>> r102) {
        this.f411620b.f2(r100, r101, r102);
    }

    @Override // com.ss.android.lark.chat.api.service.IChatService
    public final Chat getChatById(String r100) {
        return this.f411620b.getChatById(r100);
    }

    @Override // com.ss.android.lark.chat.api.service.IChatService
    public final Chat getLocalChat(String r100) {
        return this.f411620b.getLocalChat(r100);
    }

    @Override // com.ss.android.lark.chat.api.service.IChatService
    public final Chat getP2pChatByChatterId(String r100) {
        return this.f411620b.getP2pChatByChatterId(r100);
    }

    @Override // com.ss.android.lark.chat.api.service.IChatService
    public final void getP2pChatCreatedByChatterId(String r100, IGetDataCallback<Chat> r101) {
        Intrinsics.checkNotNullParameter(r101, "callback");
        this.f411620b.getP2pChatCreatedByChatterId(r100, r101);
    }

    @Override // com.ss.android.lark.chat.api.service.IChatService
    public final void h3(String r100, String r101, boolean r102, ChatNameRenderer$doTranslate$1 r103) {
        Intrinsics.checkNotNullParameter(r100, "chatId");
        this.f411620b.h3(r100, r101, r102, r103);
    }

    @Override // com.ss.android.lark.chat.api.service.IChatService
    public final void t8(String r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "chatId");
        this.f411620b.t8(r100, r101, r102);
    }

    @Override // com.ss.android.lark.chat.api.service.IChatService
    public final void t9(String r100, String r101, UIGetDataCallback r102) {
        this.f411620b.t9(r100, r101, r102);
    }

    @Override // com.ss.android.lark.chat.api.service.IChatService
    public final void u2(List<String> r100, List<String> r101, SubscribeChatEventRequest.SubscriptionKey r102) {
        this.f411620b.u2(r100, r101, r102);
    }

    @Override // com.ss.android.lark.chat.api.service.IChatService
    public final void y3(String r100, ChatNameRenderer$doHideTranslate$1 r101) {
        Intrinsics.checkNotNullParameter(r100, "chatId");
        this.f411620b.y3(r100, r101);
    }

    @Override // com.ss.android.lark.chat.api.service.IChatService
    public final ImageHistoryResponse ze(String r100, String r101, ImageHistoryResponse.Direction r102) {
        return this.f411620b.ze(r100, r101, r102);
    }

    public o0(com.ss.android.lark.passportc.api.j r100, com.ss.android.lark.passportc.internal.v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<IChatService> r103 = new com.ss.android.lark.passportc.convention.b(e0c.k.b(r101.c(r102), IChatService.class), IChatService.class);
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "instanceHolder");
        super(r100);
        this.f411620b = r103.b();
        this.f411621c = r101;
        this.f411622d = r103;
    }

    @Override // c0c.b
    public final void qf(f0c.g r100, f0c.g r101) {
        Log.i("ChatServiceProxy", "preparing IChatService");
        com.ss.android.lark.passportc.internal.v r102 = this.f411621c;
        if (r101 == null) goto L6;
        UserSession r103 = r101.f475034b;
        if (r103 == null) goto L6;
    L7:
        IChatService r104 = (IChatService) e0c.k.b(r102.c(r103), IChatService.class);
        this.f411622d.e(r104);
        return;
    L6:
        r103 = ContainerConstsKt.a();
        goto L7
    }
}
