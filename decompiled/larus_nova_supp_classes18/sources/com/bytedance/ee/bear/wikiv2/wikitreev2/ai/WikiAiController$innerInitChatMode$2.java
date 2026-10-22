package com.bytedance.ee.bear.wikiv2.wikitreev2.ai;

import android.content.Context;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.util.ui.m;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/bytedance/ee/bear/wikiv2/wikitreev2/ai/WikiAiController$innerInitChatMode$2", "Lcom/larksuite/framework/callback/IGetDataCallback;", "Lcom/ss/android/lark/myai/export/model/ChatModeInitResult;", "onSuccess", "", WikiFolderPushPlugin.DATA, "onError", "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WikiAiController$innerInitChatMode$2 implements IGetDataCallback<osb.c> {
    final /* synthetic */ WikiAiController.b $callback;
    final /* synthetic */ Context $context;
    final /* synthetic */ b $params;
    final /* synthetic */ WikiAiController this$0;

    public static final class a implements Runnable {
        public final /* synthetic */ Context a;

        public a(Context r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L12;
            return;
        L12:
            throw th;
        L3:
            if (j.a.a.getNetworkState().a() == false) goto L5;
            int r0 = 2131887323;
        L6:
            Toast.showFailureText(this.a, r0);     // Catch: Throwable -> L8
            return;
        L5:
            r0 = 2131887130;
            goto L6
        }
    }

    public void onError(ErrorResult r3) {
        Intrinsics.checkNotNullParameter(r3, "err");
        tt5.a.h("WikiAiController", "innerInitChatMode onError:" + r3);
        this.this$0.e.set(false);
        m.a(new a(this.$context));
    }

    public void onSuccess(osb.c r2) {
        tt5.a.h("WikiAiController", "innerInitChatMode onSuccess: chatId=null, chatModeId=null");
        this.$params.getClass();
        this.this$0.e.set(false);
    }

    public /* bridge */ /* synthetic */ void onError(Object r1) {
        onError((ErrorResult) r1);
    }

    public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
        onSuccess((osb.c) r1);
    }

    public WikiAiController$innerInitChatMode$2(b r1, WikiAiController.b r2, WikiAiController r3, Context r4) {
        this.$params = r1;
        this.$callback = r2;
        this.this$0 = r3;
        this.$context = r4;
    }
}
