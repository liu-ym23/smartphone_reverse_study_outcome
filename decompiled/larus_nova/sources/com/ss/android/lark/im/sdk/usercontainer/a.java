package com.ss.android.lark.im.sdk.usercontainer;

import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.im.sdk.service.ImSdkChatService;
import com.ss.android.lark.integrator.im.impl.ChatApiImpl$selectMessagesFromChat$1;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import e0c.k;
import f0c.g;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a extends c0c.b implements ImSdkChatService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ImSdkChatService f426196b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f426197c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<ImSdkChatService> f426198d;

    /* JADX INFO: renamed from: com.ss.android.lark.im.sdk.usercontainer.a$a, reason: collision with other inner class name */
    public static final class C5040a {
    }

    static {
    }

    @Override // com.ss.android.lark.im.sdk.service.ImSdkChatService
    public final Chat B2(String r100) {
        Intrinsics.checkNotNullParameter(r100, "chatId");
        return this.f426196b.B2(r100);
    }

    @Override // com.ss.android.lark.im.sdk.service.ImSdkChatService
    public final void C2(List<String> r100, IGetDataCallback<Map<String, Chat>> r101) {
        Intrinsics.checkNotNullParameter(r100, "chatterIds");
        Intrinsics.checkNotNullParameter(r101, "callback");
        this.f426196b.C2(r100, r101);
    }

    @Override // com.ss.android.lark.im.sdk.service.ImSdkChatService
    public final com.ss.android.lark.chat.entity.chat.b I0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "chatId");
        return this.f426196b.I0(r100);
    }

    @Override // com.ss.android.lark.im.sdk.service.ImSdkChatService
    public final Chat P6(String r100, ImSdkChatService.Source r101) {
        Intrinsics.checkNotNullParameter(r100, "chatId");
        Intrinsics.checkNotNullParameter(r101, "source");
        return this.f426196b.P6(r100, r101);
    }

    @Override // com.ss.android.lark.im.sdk.service.ImSdkChatService
    public final void X5(String r100, ImSdkChatService.a r101, IGetDataCallback<Chat> r102) {
        Intrinsics.checkNotNullParameter(r100, "chatterId");
        Intrinsics.checkNotNullParameter(r102, "callback");
        this.f426196b.X5(r100, r101, r102);
    }

    @Override // com.ss.android.lark.im.sdk.service.ImSdkChatService
    public final void Y6(List<String> r100, String r101, IGetDataCallback<Map<String, Boolean>> r102) {
        Intrinsics.checkNotNullParameter(r100, "chatterIds");
        Intrinsics.checkNotNullParameter(r101, "chatId");
        Intrinsics.checkNotNullParameter(r102, "callback");
        this.f426196b.Y6(r100, r101, r102);
    }

    @Override // com.ss.android.lark.im.sdk.service.ImSdkChatService
    public final Chat getLocalChat(String r100) {
        Intrinsics.checkNotNullParameter(r100, "chatId");
        return this.f426196b.getLocalChat(r100);
    }

    @Override // com.ss.android.lark.im.sdk.service.ImSdkChatService
    public final String getOtherP2PChatterId(Chat r100) {
        Intrinsics.checkNotNullParameter(r100, "chat");
        return this.f426196b.getOtherP2PChatterId(r100);
    }

    @Override // com.ss.android.lark.im.sdk.service.ImSdkChatService
    public final com.ss.android.lark.chat.entity.chat.a nd(String r100) {
        return this.f426196b.nd(r100);
    }

    @Override // com.ss.android.lark.im.sdk.service.ImSdkChatService
    public final void uc(List r100, ChatApiImpl$selectMessagesFromChat$1 r101) {
        Intrinsics.checkNotNullParameter(r100, "chatIds");
        Intrinsics.checkNotNullParameter(r101, "callback");
        this.f426196b.uc(r100, r101);
    }

    @Override // com.ss.android.lark.im.sdk.service.ImSdkChatService
    public final Chat we(String r100) {
        Intrinsics.checkNotNullParameter(r100, "chatId");
        return this.f426196b.we(r100);
    }

    @Override // com.ss.android.lark.im.sdk.service.ImSdkChatService
    public final Chat xc(String r100) {
        Intrinsics.checkNotNullParameter(r100, "chatterId");
        return this.f426196b.xc(r100);
    }

    public a(j r100, v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<ImSdkChatService> r103 = new com.ss.android.lark.passportc.convention.b(k.b(r101.c(r102), ImSdkChatService.class), ImSdkChatService.class);
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "instanceHolder");
        super(r100);
        this.f426196b = r103.b();
        this.f426197c = r101;
        this.f426198d = r103;
    }

    @Override // c0c.b
    public final void qf(g r100, g r101) {
        Log.i("ImSdkChatServiceProxy", "preparing ImSdkChatService");
        v r102 = this.f426197c;
        if (r101 == null) goto L6;
        UserSession r103 = r101.f475034b;
        if (r103 == null) goto L6;
    L7:
        ImSdkChatService r104 = (ImSdkChatService) k.b(r102.c(r103), ImSdkChatService.class);
        this.f426198d.e(r104);
        return;
    L6:
        r103 = ContainerConstsKt.a();
        goto L7
    }
}
