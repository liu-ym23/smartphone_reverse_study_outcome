package com.ss.android.lark.integrator.im.module.export;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.ss.android.lark.auditsdk.security.SecurityService;
import com.ss.android.lark.biz.im.api.bundle.ChatBundle;
import com.ss.android.lark.biz.im.api.bundle.v2.base.input.ChatBundleInput;
import com.ss.android.lark.chat.api.IChatParser;
import com.ss.android.lark.chat.api.service.impl.ChatService;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.create.groupchat.impl.service.interceptor.StrangerInterceptor$getP2pChatCreatedByChatterId$2$1;
import com.ss.android.lark.utils.statistics.PerfLog;
import hab.b;
import hab.c;
import hab.d;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class FlowGroupCreateExport implements b, hab.a, c, d {

    public static final class a {
    }

    static {
    }

    @Inject
    public FlowGroupCreateExport() {
    }

    @Override // hab.b
    public final void a() {
        Intrinsics.checkNotNullParameter("new_group", "way");
    }

    @Override // hab.b
    public final IChatParser getChatParser() {
        return (IChatParser) ChatCoreModule.f414743b.getValue();
    }

    @Override // hab.b
    public final void b(String r100, StrangerInterceptor$getP2pChatCreatedByChatterId$2$1 r101) {
        Intrinsics.checkNotNullParameter(r100, "chatterId");
        Intrinsics.checkNotNullParameter(r101, "callback");
        ChatService.c.f411535a.getP2pChatCreatedByChatterId(r100, r101);
    }

    @Override // hab.a
    public final boolean d(int r100, String r101) {
        return SecurityService.f409594a.getValue().a(r100, r101);
    }

    @Override // hab.b
    public final void openChat(Context r100, ChatBundle r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "chatBundle");
        int r102 = dgb.a.f468547d;
        com.ss.android.lark.chatwindow.launcher.c r103 = dgb.a.C5667a.a().f468549b;
        if (r103 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("chatLauncherV2");
        r103 = null;
    L6:
        int r104 = ChatBundleInput.f409974j;
        r103.U7(r100, null, ChatBundleInput.Companion.a(r101), new AnonymousClass2());
    }

    @Override // hab.b
    public final void c(Fragment r100, Context r101, ChatBundle r102) {
        Intrinsics.checkNotNullParameter(r100, "sourceFragment");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "chatBundle");
        int r103 = dgb.a.f468547d;
        com.ss.android.lark.chatwindow.launcher.c r104 = dgb.a.C5667a.a().f468549b;
        if (r104 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("chatLauncherV2");
        r104 = null;
    L6:
        int r105 = ChatBundleInput.f409974j;
        r104.U7(r101, r100, ChatBundleInput.Companion.a(r102), new AnonymousClass1());
    }
}
