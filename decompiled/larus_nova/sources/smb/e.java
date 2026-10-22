package smb;

import android.content.Context;
import com.larus.search.impl.LarkChatServiceProxyImpl$openLarkChat$1;
import com.ss.android.lark.biz.im.api.bundle.ChatBundle;
import com.ss.android.lark.biz.im.api.l1;
import com.ss.android.lark.flow.chat.FlowChatModule;
import com.ss.android.lark.officesdk.container.OfficeSDKUserScope;
import com.ss.android.lark.utils.statistics.PerfLog;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@OfficeSDKUserScope
public final class e implements dza.b {
    @Inject
    public e() {
    }

    @Override // dza.b
    public final void a(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "chatId");
        int r102 = FlowChatModule.f422022d;
        FlowChatModule r103 = FlowChatModule.a.a();
        ChatBundle.a r104 = new ChatBundle.a();
        r104.f409934a = r101;
        r104.b(Boolean.TRUE);
        r103.e(r100, new ChatBundle(r104), null);
    }

    @Override // dza.b
    public final void b(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "threadId");
        int r102 = FlowChatModule.f422022d;
        FlowChatModule r103 = FlowChatModule.a.a();
        l1.a r104 = new l1.a();
        r104.f410298e = r101;
        r104.f410316w = Boolean.TRUE;
        l1 r105 = new l1(r104);
        r103.getClass();
        FlowChatModule.g(r100, r105);
    }

    @Override // dza.b
    public final void c(Context r100, ChatBundle r101, LarkChatServiceProxyImpl$openLarkChat$1 r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "chatBundle");
        int r103 = FlowChatModule.f422022d;
        FlowChatModule.a.a().e(r100, r101, r102);
    }
}
