package com.bytedance.ee.bear.wikiv2.wikitreev2.ai;

import android.content.Context;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.util.ui.m;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/bytedance/ee/bear/wikiv2/wikitreev2/ai/WikiAiController$innerInitChatMode$2", "Lcom/larksuite/framework/callback/IGetDataCallback;", "Lcom/ss/android/lark/myai/export/model/ChatModeInitResult;", "onSuccess", "", "data", LynxVideoManagerLite.EVENT_ON_ERROR, "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WikiAiController$innerInitChatMode$2 implements IGetDataCallback<osb.c> {
    final /* synthetic */ WikiAiController.b $callback;
    final /* synthetic */ Context $context;
    final /* synthetic */ b $params;
    final /* synthetic */ WikiAiController this$0;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f241361a;

        public a(Context r100) {
            this.f241361a = r100;
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
            if (j.a.f217090a.getNetworkState().a() == false) goto L5;
            int r100 = R.string.CreationMobile_Error_Comment_NetworkError;
        L6:
            Toast.showFailureText(this.f241361a, r100);     // Catch: Throwable -> L8
            return;
        L5:
            r100 = R.string.CreationMobile_Common_NoInternet;
            goto L6
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.larksuite.framework.callback.IGetDataCallback
    public void onError(ErrorResult r100) {
        Intrinsics.checkNotNullParameter(r100, "err");
        tt5.a.h("WikiAiController", "innerInitChatMode onError:" + r100);
        this.this$0.f241358e.set(false);
        m.a(new a(this.$context));
    }

    public void onSuccess(osb.c r100) {
        tt5.a.h("WikiAiController", "innerInitChatMode onSuccess: chatId=null, chatModeId=null");
        this.$params.getClass();
        this.this$0.f241358e.set(false);
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onError(ErrorResult r100) {
        onError(r100);
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onSuccess(Object r100) {
        onSuccess((osb.c) r100);
    }

    public WikiAiController$innerInitChatMode$2(b r100, WikiAiController.b r101, WikiAiController r102, Context r103) {
        this.$params = r100;
        this.$callback = r101;
        this.this$0 = r102;
        this.$context = r103;
    }
}
