package com.ss.android.lark.integrator.im.feed_shared.dependency;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.larksuite.framework.utils.KeyboardUtils;
import com.ss.android.lark.biz.im.api.bundle.ChatBundle;
import com.ss.android.lark.biz.im.api.bundle.SourceType;
import com.ss.android.lark.biz.im.api.l1;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.flow.chat.FlowChatModule;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class d implements peb.b.d {
    public d() {
    }

    @Override // peb.b.d
    public final void a(Context r100, String r101, int r102, boolean r103) {
        int r104 = FlowChatModule.f422022d;
        FlowChatModule r105 = FlowChatModule.a.a();
        l1.a r106 = new l1.a();
        r106.f410298e = r101;
        r106.f410304k = r102;
        r106.f410303j = "feed";
        r106.B = r103;
        l1 r107 = new l1(r106);
        r105.getClass();
        FlowChatModule.g(r100, r107);
    }

    @Override // peb.b.d
    public final void b(Context r100, String r101, int r102, boolean r103) {
        Log.i("ChatDependency", "enter openThreadPage");
        int r104 = FlowChatModule.f422022d;
        FlowChatModule r105 = FlowChatModule.a.a();
        l1.a r106 = new l1.a();
        r106.f410298e = r101;
        r106.f410304k = r102;
        r106.f410303j = "feed";
        r106.B = r103;
        l1 r107 = new l1(r106);
        r105.getClass();
        FlowChatModule.g(r100, r107);
    }

    @Override // peb.b.d
    public final void c(Context r100, Fragment r101, String r102, int r103, boolean r104) {
        l1.a r105 = new l1.a();
        r105.f410298e = r102;
        r105.f410304k = r103;
        r105.f410303j = "feed";
        r105.B = r104;
        l1 r106 = new l1(r105);
        int r107 = FlowChatModule.f422022d;
        FlowChatModule.a.a().getClass();
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r106, "bundle");
        KeyboardUtils.hideKeyboard(r100);
        whb.d.b(r100, r101, r106);
    }

    @Override // peb.b.d
    public final void d(Context r100, String r101, Chat.ChatMode r102, boolean r103, String r104, int r105, boolean r106) {
        ChatBundle.a r107 = new ChatBundle.a();
        r107.f409934a = r101;
        r107.a(r102);
        r107.f409946m = r103;
        r107.f409941h = SourceType.fromValue("feed");
        r107.f409937d = r104;
        r107.f409940g = null;
        r107.f409958y = r105;
        r107.G = r106;
        ChatBundle r108 = new ChatBundle(r107);
        int r109 = FlowChatModule.f422022d;
        FlowChatModule.a.a().e(r100, r108, new ChatDependency$1(this));
    }
}
