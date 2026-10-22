package com.obric.assistant.remote_card_container;

import android.app.Application;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import androidx.core.content.pm.PackageInfoCompat;
import com.android.ttcjpaysdk.bindcard.base.ui.fragment.CJPayBindCardKeepDialogFragment;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.delegate.y0;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.IRemoteCard;
import com.obric.assistant.chat.IObricChatService;
import com.obric.assistant.chat.impl.MessageObserverImpl;
import com.obric.assistant.remote_card_container.cache.CardCacheManager;
import com.obric.assistant.remote_card_container.cardhost.CardHostIPCApi;
import com.obric.assistant.remote_card_container.manager.RemoteCardManager;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\bH\u0002J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\f\u0010\u001b\u001a\u00020\u001c*\u00020\u001aH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e²\u0006\f\u0010\u001f\u001a\u0004\u0018\u00010 X\u008a\u0084\u0002"}, d2 = {"Lcom/obric/assistant/remote_card_container/RemoteCardImpl;", "Lcom/obric/assistant/IRemoteCard;", "<init>", "()V", "ioScope", "Lkotlinx/coroutines/CoroutineScope;", "mainScope", "init", "", "notifyCardChanged", "params", "Landroid/os/Bundle;", "onAppUpdated", "intent", "Landroid/content/Intent;", "onAppUninstall", "onAppChanged", "showDialog", CJPayBindCardKeepDialogFragment.DIALOG_BEAN_KEY, "Lcom/obric/aiagent/assistant_card/provider_core/bean/DialogBean;", "showMenu", "menuBean", "Lcom/obric/aiagent/assistant_card/provider_core/bean/MenuBean;", "observeMessageList", "saveRemoteCardInfo", "message", "Lcom/larus/im/bean/message/Message;", "isRemoteCardMessage", "", "Companion", "card_mainlandRelease", "chatListAbility", "Lcom/larus/bmhome/chat/component/list/IChatListComponentAbility;"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RemoteCardImpl implements IRemoteCard {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f391216c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f391217a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CoroutineScope f391218b;

    /* JADX INFO: loaded from: classes4.dex */
    public static final class a {
    }

    /* JADX INFO: renamed from: com.obric.assistant.remote_card_container.RemoteCardImpl$init$1, reason: invalid class name */
    public static final class AnonymousClass1 implements sfa.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RemoteCardImpl f391219a;

        /* JADX INFO: renamed from: com.obric.assistant.remote_card_container.RemoteCardImpl$init$1$a */
        /* JADX INFO: loaded from: classes33.dex */
        public static final class a implements IIMCallback<Message> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ kotlinx.coroutines.i<Message> f391220a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f391221b;

            @Override // com.larus.im.callback.IIMCallback
            public final boolean mustInMain() {
                return !y0.a();
            }

            @Override // com.larus.im.callback.IIMCallback
            public final void onFailure(IIMError r100) {
                Intrinsics.checkNotNullParameter(r100, "error");
                Intrinsics.checkNotNullParameter(r100, "error");
                FLogger.f375446a.i("RemoteCardImpl", "getMessageById failed: messageId = " + this.f391221b + ", code = " + r100.getCode() + ", tips = " + r100.getTips());
                this.f391220a.resumeWith(Result.m9449constructorimpl(null));
            }

            @Override // com.larus.im.callback.IIMCallback
            public final void onSuccess(Message r100) {
                Message r101 = r100;
                Intrinsics.checkNotNullParameter(r101, "result");
                this.f391220a.resumeWith(Result.m9449constructorimpl(r101));
            }

            public a(kotlinx.coroutines.j r100, String r101) {
                this.f391220a = r100;
                this.f391221b = r101;
            }
        }

        public AnonymousClass1(RemoteCardImpl r100) {
            this.f391219a = r100;
        }

        @Override // sfa.a
        public final void a(o9a.b r100) {
            Intrinsics.checkNotNullParameter(r100, "menuBean");
            RemoteCardImpl r101 = this.f391219a;
            BuildersKt.launch$default(r101.f391218b, null, null, new RemoteCardImpl$init$1$showMenu$1(r101, r100, null), 3, null);
        }

        @Override // sfa.a
        public final void c(CharSequence r100) {
            Intrinsics.checkNotNullParameter(r100, "content");
            BuildersKt.launch$default(this.f391219a.f391218b, null, null, new RemoteCardImpl$init$1$copyContent$1(r100, null), 3, null);
        }

        @Override // sfa.a
        public final void d(o9a.a r100) {
            Intrinsics.checkNotNullParameter(r100, CJPayBindCardKeepDialogFragment.DIALOG_BEAN_KEY);
            RemoteCardImpl r101 = this.f391219a;
            BuildersKt.launch$default(r101.f391218b, null, null, new RemoteCardImpl$init$1$showDialog$1(r101, r100, null), 3, null);
        }

        @Override // sfa.a
        public final Object b(String r100, Continuation<? super Boolean> r101) {
            if ((r101 instanceof RemoteCardImpl$init$1$isMessageValid$1) == false) goto L7;
            RemoteCardImpl$init$1$isMessageValid$1 r102 = (RemoteCardImpl$init$1$isMessageValid$1) r101;
            int r103 = r102.label;
            if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
            r102.label = r103 - Integer.MIN_VALUE;
        L8:
            Object r104 = r102.result;
            Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r106 = r102.label;
            boolean r107 = false;
            if (r106 == 0) goto L14;
            if (r106 != 1) goto L13;
            String r108 = (String) r102.L$0;
            ResultKt.throwOnFailure(r104);
        L29:
            Message r109 = (Message) r104;
            if (r109 == null) goto L32;
            MessageStatus r110 = r109.getMessageStatus();
        L34:
            if (r110 != MessageStatus.MessageStatus_AVAILABLE) goto L37;
            r107 = true;
        L37:
            return Boxing.boxBoolean(r107);
        L32:
            r110 = null;
            goto L34
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r104);
            if (r100 != null) goto L17;
        L20:
            boolean r111 = true;
        L21:
            if (r111 == true) goto L23;
            r102.L$0 = r100;
            r102.label = 1;
            kotlinx.coroutines.j r112 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r102), 1);
            r112.C();
            com.larus.im.d.e().m(r100, new a(r112, r100));
            r104 = r112.B();
            if (r104 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L27;
            DebugProbesKt.probeCoroutineSuspended(r102);
        L27:
            if (r104 != r105) goto L29;
            return r105;
        L23:
            return Boxing.boxBoolean(false);
        L17:
            if (r100.length() == 0) goto L20;
            r111 = false;
        L7:
            r102 = new RemoteCardImpl$init$1$isMessageValid$1(this, r101);
            goto L8
        }
    }

    static {
    }

    @Override // com.obric.assistant.IRemoteCard
    public final void init() {
        p9a.b.a("RemoteCardImpl", "init");
        RemoteCardManager.f391282d = new AnonymousClass1(this);
        ConcurrentHashMap<String, com.obric.aiagent.assistant_card.provider_core.a> r100 = com.obric.aiagent.assistant_card.provider_core.c.f384640a;
        Application r101 = AppHost.f326268a.getApplication();
        com.obric.assistant.remote_card_container.manager.f r102 = new com.obric.assistant.remote_card_container.manager.f();
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "logger");
        com.obric.aiagent.assistant_card.provider_core.c.f384643d = r101.getApplicationContext();
        Intrinsics.checkNotNullParameter(r102, "logger");
        p9a.b.f528329a = r102;
        p9a.b.a("CardProviderManager", "init: packageName = " + r101.getPackageName() + ", logger = " + r102);
        PackageInfo r103 = r101.getPackageManager().getPackageInfo(r101.getPackageName(), 0);
        String r104 = r103.versionName;
        PackageInfoCompat.getLongVersionCode(r103);
        IObricChatService.f386556a.getClass();
        IObricChatService r105 = IObricChatService.a.a();
        if (r105 == null) goto L5;
        r105.l();
        MessageObserverImpl r106 = MessageObserverImpl.f386914a;
    L6:
        if (r106 != null) goto L8;
        FLogger.f375446a.w("RemoteCardImpl", "observeMessageList: messageObserver is null");
    L9:
        CardCacheManager r107 = CardCacheManager.f391235a;
        CardCacheManager.a();
        return;
    L8:
        r106.f(new RemoteCardImpl$observeMessageList$1(this));
        goto L9
    L5:
        r106 = null;
        goto L6
    }

    public RemoteCardImpl() {
        this.f391217a = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        this.f391218b = CoroutineScopeKt.MainScope();
    }

    @Override // com.obric.assistant.IRemoteCard
    public final void a(Intent r100) {
        Intrinsics.checkNotNullParameter(r100, "intent");
        int r101 = rfa.a.f537647a;
        Intrinsics.checkNotNullParameter(r100, "intent");
        String r102 = rfa.a.a(r100);
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == true) goto L13;
        p9a.e r104 = p9a.b.f528329a;
        p9a.b.a("AppChangeHandler", "onAppChanged: " + r102);
        CardCacheManager r105 = CardCacheManager.f391235a;
        Intrinsics.checkNotNullParameter(r102, "pkgName");
        CardCacheManager.b(new com.obric.assistant.remote_card_container.cache.e(r102));
        return;
    L13:
        return;
    L5:
        if (r102.length() == 0) goto L8;
        r103 = false;
        goto L9
    }

    @Override // com.obric.assistant.IRemoteCard
    public final void b(Intent r100) {
        Intrinsics.checkNotNullParameter(r100, "intent");
        int r101 = rfa.a.f537647a;
        Intrinsics.checkNotNullParameter(r100, "intent");
        String r102 = rfa.a.a(r100);
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == true) goto L13;
        p9a.e r104 = p9a.b.f528329a;
        p9a.b.a("AppChangeHandler", "onAppUpdated: " + r102);
        CardCacheManager r105 = CardCacheManager.f391235a;
        Intrinsics.checkNotNullParameter(r102, "pkgName");
        CardCacheManager.b(new com.obric.assistant.remote_card_container.cache.e(r102));
        return;
    L13:
        return;
    L5:
        if (r102.length() == 0) goto L8;
        r103 = false;
        goto L9
    }

    @Override // com.obric.assistant.IRemoteCard
    public final void c(Intent r100) {
        Intrinsics.checkNotNullParameter(r100, "intent");
        int r101 = rfa.a.f537647a;
        Intrinsics.checkNotNullParameter(r100, "intent");
        String r102 = rfa.a.a(r100);
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == true) goto L13;
        p9a.e r104 = p9a.b.f528329a;
        p9a.b.a("AppChangeHandler", "onAppUninstall: " + r102);
        CardCacheManager r105 = CardCacheManager.f391235a;
        Intrinsics.checkNotNullParameter(r102, "pkgName");
        CardCacheManager.b(new com.obric.assistant.remote_card_container.cache.e(r102));
        return;
    L13:
        return;
    L5:
        if (r102.length() == 0) goto L8;
        r103 = false;
        goto L9
    }

    @Override // com.obric.assistant.IRemoteCard
    public final void notifyCardChanged(Bundle r100) {
        CardHostIPCApi.INSTANCE.notifyCardChanged(r100);
    }
}
