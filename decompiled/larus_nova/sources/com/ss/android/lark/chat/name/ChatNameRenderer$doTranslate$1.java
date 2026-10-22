package com.ss.android.lark.chat.name;

import android.content.Context;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.log.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"com/ss/android/lark/chat/name/ChatNameRenderer$doTranslate$1", "Lcom/larksuite/framework/callback/IGetDataCallback;", "", "onSuccess", "", "data", "(Ljava/lang/Boolean;)V", LynxVideoManagerLite.EVENT_ON_ERROR, "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatNameRenderer$doTranslate$1 implements IGetDataCallback<Boolean> {
    final /* synthetic */ Chat $chat;
    final /* synthetic */ Context $context;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f415938a;

        public a(Context r100) {
            this.f415938a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            UDToast.show(this.f415938a, R.string.Lark_IM_ActionFailedPleaseTryAgainLater_ErrorMessage);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.larksuite.framework.callback.IGetDataCallback
    public void onError(ErrorResult r100) {
        Intrinsics.checkNotNullParameter(r100, "err");
        Log.i("ChatNameRenderer", "[chat_name_translate] translate fail " + this.$chat.getId());
        UICallbackExecutor.post(new a(this.$context));
    }

    public void onSuccess(Boolean r100) {
        Log.i("ChatNameRenderer", "[chat_name_translate] translate success " + this.$chat.getId());
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onError(ErrorResult r100) {
        onError(r100);
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onSuccess(Object r100) {
        onSuccess((Boolean) r100);
    }

    public ChatNameRenderer$doTranslate$1(Chat r100, Context r101) {
        this.$chat = r100;
        this.$context = r101;
    }
}
