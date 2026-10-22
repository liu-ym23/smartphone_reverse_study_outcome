package com.bytedance.ee.bear.wikiv2.wikitreev2.ai;

import android.content.Context;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.util.ui.m;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.myai.export.d;
import com.ss.android.lark.myai.export.model.ChatContext;
import com.ss.android.lark.myai.export.model.ChatModeState;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/bytedance/ee/bear/wikiv2/wikitreev2/ai/WikiAiController$doOpenMyAi$1$onDataReceive$1", "Lcom/larksuite/framework/callback/IGetDataCallback;", "Lcom/ss/android/lark/myai/export/model/ChatModeState;", "onSuccess", "", WikiFolderPushPlugin.DATA, "onError", "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WikiAiController$doOpenMyAi$1$onDataReceive$1 implements IGetDataCallback<ChatModeState> {
    final /* synthetic */ String $chatId;
    final /* synthetic */ b $chatInitParam;
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
        tt5.a.k("WikiAiController", "getChatModeState onError: " + r3);
        m.a(new a(this.$context));
    }

    public void onSuccess(ChatModeState r6) {
        tt5.a.h("WikiAiController", "getChatModeState onSuccess: data= " + r6);
        if (r6 != ChatModeState.OPEN) goto L9;
        WikiAiController r7 = this.this$0;
        Function1<? super Result<com.ss.android.lark.myai.export.b>, ? extends d> r0 = r7.c;
        if (r0 == null) goto L7;
        Result.Companion r1 = Result.Companion;
        String r2 = this.$chatId;
        this.$chatInitParam.getClass();
        com.ss.android.lark.myai.export.b.a r3 = new com.ss.android.lark.myai.export.b.a(r2, 0);
        final b r4 = this.$params;
        Function0<ChatContext> r5 = new WikiAiController$doOpenMyAi$1$onDataReceive$1$onSuccess$1(r4);
        Intrinsics.checkNotNullParameter(r5, "provider");
        r3.d = r5;
        d r8 = (d) r0.invoke(Result.box-impl(Result.constructor-impl(new com.ss.android.lark.myai.export.b(r3))));
    L8:
        r7.b = r8;
        return;
    L7:
        r8 = null;
        goto L8
    L9:
        tt5.a.k("WikiAiController", "getChatModeState invalid!");
        this.$chatInitParam.getClass();
    }

    public /* bridge */ /* synthetic */ void onError(Object r1) {
        onError((ErrorResult) r1);
    }

    public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
        onSuccess((ChatModeState) r1);
    }

    public WikiAiController$doOpenMyAi$1$onDataReceive$1(WikiAiController r1, String r2, b r3, b r4, Context r5) {
        this.this$0 = r1;
        this.$chatId = r2;
        this.$chatInitParam = r3;
        this.$params = r4;
        this.$context = r5;
    }
}
