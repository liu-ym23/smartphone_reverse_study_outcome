package com.larus.platform.spi;

import android.content.Context;
import android.os.Bundle;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import gr9.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import wc9.e;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cJ\u0010\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H&J\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H¦@¢\u0006\u0002\u0010\u0006J0\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0003H¦@¢\u0006\u0002\u0010\u000eJh\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u0016H&¨\u0006\u001d"}, d2 = {"Lcom/larus/platform/spi/IAIChatConversationService;", "", "getSubConversationList", "", "Lcom/larus/platform/model/search/SubConversationSimplifyModel;", "fetchSubConversationList", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createLocalBotSubConv", "Lcom/larus/im/bean/conversation/Conversation;", "botId", "", "conv", "msgList", "Lcom/larus/im/bean/message/Message;", "(Ljava/lang/String;Lcom/larus/im/bean/conversation/Conversation;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "gotoSubConversation", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "enterMethod", "previousPage", "needTryLocalFirst", "", "extraParams", "Landroid/os/Bundle;", "autoSendParams", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility$OnSendParams;", "openKeyboardInNonLocalConv", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IAIChatConversationService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f365892a = null;

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0096A¢\u0006\u0002\u0010\fJ\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\nH\u0096A¢\u0006\u0002\u0010\u000fJ\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\nH\u0096\u0001J[\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u0018H\u0096\u0001¨\u0006\u001e"}, d2 = {"Lcom/larus/platform/spi/IAIChatConversationService$Companion;", "Lcom/larus/platform/spi/IAIChatConversationService;", "<init>", "()V", "createLocalBotSubConv", "Lcom/larus/im/bean/conversation/Conversation;", "botId", "", "conv", "msgList", "", "Lcom/larus/im/bean/message/Message;", "(Ljava/lang/String;Lcom/larus/im/bean/conversation/Conversation;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchSubConversationList", "Lcom/larus/platform/model/search/SubConversationSimplifyModel;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSubConversationList", "gotoSubConversation", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "enterMethod", "previousPage", "needTryLocalFirst", "", "extraParams", "Landroid/os/Bundle;", "autoSendParams", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility$OnSendParams;", "openKeyboardInNonLocalConv", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements IAIChatConversationService {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ Companion f365893c = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IAIChatConversationService f365894b;

        static {
            f365893c = new Companion();
        }

        @Override // com.larus.platform.spi.IAIChatConversationService
        public final Object a(String r100, e r101, List r102, ContinuationImpl r103) {
            return this.f365894b.a(r100, r101, r102, r103);
        }

        @Override // com.larus.platform.spi.IAIChatConversationService
        public final void b(Context r110, String r111, e r112, String r113, String r114, boolean r115, Bundle r116, ICoreInputAbility.OnSendParams r117, boolean r210) {
            Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r111, "botId");
            this.f365894b.b(r110, r111, r112, r113, r114, r115, r116, r117, r210);
        }

        @Override // com.larus.platform.spi.IAIChatConversationService
        public final Object c(Continuation<? super List<b>> r100) {
            return this.f365894b.c(r100);
        }

        @Override // com.larus.platform.spi.IAIChatConversationService
        public final List<b> d() {
            return this.f365894b.d();
        }

        private Companion() {
            IAIChatConversationService r100 = (IAIChatConversationService) ServiceManager.get().getService(IAIChatConversationService.class);
            if (r100 != null) goto L5;
            r100 = IAIChatConversationServiceEmpty.f365895b;
        L5:
            this.f365894b = r100;
        }
    }

    public static final class a {
        public static /* synthetic */ void a(Companion r110, Context r111, String r112, e r113, String r114, String r115, Bundle r116, int r210) {
            if ((r210 & 4) == 0) goto L5;
            e r100 = null;
        L7:
            if ((r210 & 8) == 0) goto L9;
            String r101 = "";
        L11:
            if ((r210 & 16) == 0) goto L13;
            String r102 = "";
        L15:
            if ((r210 & 32) == 0) goto L17;
            boolean r103 = false;
        L19:
            if ((r210 & 64) == 0) goto L21;
            Bundle r117 = null;
        L23:
            if ((r210 & 256) == 0) goto L25;
            boolean r118 = true;
        L26:
            r110.b(r111, r112, r100, r101, r102, r103, r117, null, r118);
            return;
        L25:
            r118 = false;
            goto L26
        L21:
            r117 = r116;
            goto L23
        L17:
            r103 = true;
            goto L19
        L13:
            r102 = r115;
            goto L15
        L9:
            r101 = r114;
            goto L11
        L5:
            r100 = r113;
            goto L7
        }
    }

    static {
        f365892a = Companion.f365893c;
    }

    Object a(String r100, e r101, List r102, ContinuationImpl r103);

    void b(Context r100, String r101, e r102, String r103, String r104, boolean r105, Bundle r106, ICoreInputAbility.OnSendParams r107, boolean r108);

    Object c(Continuation<? super List<b>> r100);

    List<b> d();
}
