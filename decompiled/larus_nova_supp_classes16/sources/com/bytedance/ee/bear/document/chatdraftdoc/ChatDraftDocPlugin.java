package com.bytedance.ee.bear.document.chatdraftdoc;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPluginV2;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.lark.dependency.t;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.biz.im.api.j1;
import com.ss.android.lark.chat.entity.message.MessageParams;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u00182\u00020\u00012\u00020\u0002:\u0002\u0018\u0019B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\n2\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e0\fH\u0016J\u0012\u0010\u000f\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0012\u001a\u00020\nH\u0002J\u0012\u0010\u0013\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\rH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ee/bear/document/chatdraftdoc/ChatDraftDocPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPluginV2;", "Lcom/bytedance/ee/bear/facade/common/BackPressHandler;", "<init>", "()V", "chatDraftDocViewModel", "Lcom/bytedance/ee/bear/document/chatdraftdoc/ChatDraftDocViewModel;", "deleteChatDraftDocNetExecutor", "Lcom/bytedance/ee/bear/document/chatdraftdoc/DeleteChatDraftDocNetExecutor;", "getBridgeHandlers", "", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "onAttachToHost", "host", "Lcom/bytedance/ee/bear/browser/plugin/PluginHost;", "publishDraft", "onDetachFromHost", "onBackPressed", "", "deleteChatDocRelatedAndPublish", "chatId", "Companion", "PublishDraftHandler", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatDraftDocPlugin extends DocumentPluginV2 implements sa5.d {
    public static final a Companion = null;
    private static final String TAG = "ChatDraftDocPlugin";
    private final ChatDraftDocViewModel chatDraftDocViewModel;
    private l deleteChatDraftDocNetExecutor;

    public static final class a {
        public a() {
        }
    }

    public final class b implements tb5.i<String> {
        public final /* synthetic */ ChatDraftDocPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(ChatDraftDocPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r1, tb5.m r2) {
            String r3 = (String) r1;
            tt5.a.h(ChatDraftDocPlugin.TAG, "publish draft");
            ChatDraftDocPlugin.access$getChatDraftDocViewModel$p(this.a).updateActive(true);
        }
    }

    public static final class c implements k05.b {
        public final /* synthetic */ ChatDraftDocPlugin a;

        public c(ChatDraftDocPlugin r1) {
            this.a = r1;
        }

        @Override // k05.b
        public final void a(int r3) {
            tt5.a.h(ChatDraftDocPlugin.TAG, "deleteChatDocRelated callback code : " + r3);
            l r0 = ChatDraftDocPlugin.access$getDeleteChatDraftDocNetExecutor$p(this.a);
            if (r0 == null) goto L5;
            r0.a.clear();
        L5:
            if (r3 != 0) goto L7;
            ChatDraftDocPlugin.access$publishDraft(this.a);
            ChatDraftDocPlugin.access$getActivity(this.a).finish();
            return;
        L7:
            Toast.showFailureText(ChatDraftDocPlugin.access$getActivity(this.a), 2131888924);
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ ChatDraftDocPlugin a;

        public d(ChatDraftDocPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            Boolean r4 = (Boolean) r3;
            DocViewModel r0 = ChatDraftDocPlugin.access$getDocViewModel(this.a);
            if (r0 == null) goto L5;
            String r1 = r0.getChatId();
        L6:
            if (r1 != null) goto L8;
        L11:
            boolean r2 = true;
        L12:
            if (r2 == false) goto L15;
            tt5.a.h(ChatDraftDocPlugin.TAG, "deleteChatDocRelated err, chatId isNullOrEmpty");
            return;
        L15:
            if (Intrinsics.areEqual(r4, Boolean.TRUE) == true) goto L17;
            return;
        L17:
            if (com.bytedance.ee.util.ui.b.a(ChatDraftDocPlugin.access$getActivity(this.a)) == false) goto L22;
            ChatDraftDocPlugin.access$deleteChatDocRelatedAndPublish(this.a, r1);
            return;
        L22:
            return;
        L8:
            if (r1.length() == 0) goto L11;
            r2 = false;
            goto L12
        L5:
            r1 = null;
            goto L6
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.browser.plugin.BasePluginV2, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public ChatDraftDocPlugin() {
        this.chatDraftDocViewModel = new ChatDraftDocViewModel();
    }

    private final void publishDraft() {
        DocViewModel r0 = getDocViewModel();
        if (r0 != null) goto L5;
        return;
    L5:
        String r1 = r0.getChatId();
        if (r1 != null) goto L8;
        return;
    L8:
        j1.a r2 = new j1.a();
        r2.A = com.ss.android.lark.widget.richtext.c.c(r0.getUrl());
        ((MessageParams.a) r2).c = r1;
        j1 r3 = r2.b();
        IGetDataCallback<String> r4 = new ChatDraftDocPlugin$publishDraft$noteCallback$1(this);
        Toast.showLoading(getActivity(), getActivity().getText(2131888931));
        ((t) org.koin.java.a.c(t.class, null, null, 6)).sendMessage(r3, r4);
    }

    @Override // sa5.d
    public boolean onBackPressed() {
        if (getDocViewModel() == null) goto L17;
        DocViewModel r0 = getDocViewModel();
        if (r0 == null) goto L7;
        String r1 = r0.getChatId();
    L8:
        if (r1 != null) goto L10;
    L13:
        boolean r2 = true;
    L14:
        if (r2 == true) goto L16;
        UDToast.show(getActivity(), 2131888922, 2131256306);
        goto L17
    L16:
        tt5.a.d(TAG, "onBackPressed chatId isEmpty");
        goto L17
    L10:
        if (r1.length() == 0) goto L13;
        r2 = false;
        goto L14
    L7:
        r1 = null;
    L17:
        return false;
    }

    public static final /* synthetic */ FragmentActivity access$getActivity(ChatDraftDocPlugin r0) {
        return r0.getActivity();
    }

    public static final /* synthetic */ ChatDraftDocViewModel access$getChatDraftDocViewModel$p(ChatDraftDocPlugin r0) {
        return r0.chatDraftDocViewModel;
    }

    public static final /* synthetic */ l access$getDeleteChatDraftDocNetExecutor$p(ChatDraftDocPlugin r0) {
        return r0.deleteChatDraftDocNetExecutor;
    }

    public static final /* synthetic */ DocViewModel access$getDocViewModel(ChatDraftDocPlugin r0) {
        return r0.getDocViewModel();
    }

    public static final /* synthetic */ void access$publishDraft(ChatDraftDocPlugin r0) {
        r0.publishDraft();
    }

    private final void deleteChatDocRelatedAndPublish(String r4) {
        PluginHost r0 = getHost();
        if (r0 == null) goto L7;
        vo5.a r1 = r0.getUserComponent();
        if (r1 == null) goto L7;
        NetService r2 = (NetService) r1.a(NetService.class);
    L8:
        if (r2 == null) goto L13;
        l r3 = this.deleteChatDraftDocNetExecutor;
        if (r3 == null) goto L14;
        r3.a(r2, r4, new c(this));
        return;
    L14:
        return;
    L13:
        return;
    L7:
        r2 = null;
        goto L8
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, yv4.a
    public void getBridgeHandlers(Map<String, tb5.i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        super.getBridgeHandlers(r3);
        r3.put("biz.navigation.publishDraft", new b(this));
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToHost(PluginHost r3) {
        super.onAttachToHost(r3);
        this.deleteChatDraftDocNetExecutor = new l();
        this.chatDraftDocViewModel.getActive().observe(getLifecycleOwner(), new d(this));
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onDetachFromHost(PluginHost r1) {
        super.onDetachFromHost(r1);
        l r2 = this.deleteChatDraftDocNetExecutor;
        if (r2 == null) goto L5;
        r2.a.clear();
    L5:
        this.deleteChatDraftDocNetExecutor = null;
    }

    public static final /* synthetic */ void access$deleteChatDocRelatedAndPublish(ChatDraftDocPlugin r0, String r1) {
        r0.deleteChatDocRelatedAndPublish(r1);
    }
}
